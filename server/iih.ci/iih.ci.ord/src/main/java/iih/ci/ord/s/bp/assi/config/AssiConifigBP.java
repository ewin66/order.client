package iih.ci.ord.s.bp.assi.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCalcuate;
import xap.mw.core.data.BizException;

public class AssiConifigBP {

	private static Map<String, List<AssiDynamicConfigDTO>> configMap = null;

	/**
	 * 获取当前服务对应的动态处理类
	 * 
	 * @param <T>
	 * 
	 * @param extPoint 执行点
	 * @param envinfo 当前上下文就诊环境， 取其中的 code_entp 就诊类型,orSrouceFrom 数据来源
	 * @param sd_srvtp 服务类型
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public static <T> AbstractAssiCalcuate<T> getDynamicC(ExtensionPointEu extPoint, CiEnContextDTO envinfo,
			String sd_srvtp) throws BizException {

		AbstractAssiCalcuate<T> instance = null;

		// 就诊类型
		String code_entp = envinfo.getCode_entp();
		// 数据来源，先不考虑该值，后续可以扩展
		String orSrouceFrom = envinfo.getEu_orsrcmdtp();

		//if (configMap == null) {
		configMap = AssiConifigBP.getConfigResult();
		//}

		// 获取指定就诊类型下的全部类型
		List<AssiDynamicConfigDTO> configList = configMap.get(code_entp);

		// 获取配置最匹配的实现类
		AssiDynamicConfigDTO dynamicConfig = getMatchConfig(configList, sd_srvtp, orSrouceFrom);

		if (dynamicConfig != null) {

			String fullClassPath = dynamicConfig.getFullClassPath();
			try {
				instance = (AbstractAssiCalcuate<T>) Class.forName(fullClassPath).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				throw new BizException("创建类对象[" + fullClassPath + "]实例失败");
			}
		}

		return instance;
	}

	/**
	 * 获取匹配的配置结果<br>
	 * 根据服务类型判断不在拒绝集合，并且在允许集合的唯一一个配置对象
	 * 
	 * @param matchConfigList 匹配的集合对象
	 * @param sd_srvtp 服务分类
	 * @param orSrouceFrom 医嘱来源
	 * @return
	 * @throws BizException 
	 */
	private static AssiDynamicConfigDTO getMatchConfig(List<AssiDynamicConfigDTO> matchConfigList, String sd_srvtp,
			String orSrouceFrom) throws BizException {

		// 允许的集合，继续下次循环使用
		List<AssiDynamicConfigDTO> allowedConifgList = null;

		// 允许、拒绝的服务类型字符串，用于获取同时满足在匹配集合中，但不在排除集合中的一个配置对象
		String allowedSdSrvtp = null;
		String refusedSdSrvtp = null;

		if (matchConfigList == null || matchConfigList.size() == 0) {
			return null;
		}

		allowedConifgList = new ArrayList<AssiDynamicConfigDTO>();
		for (AssiDynamicConfigDTO dynamicConfig : matchConfigList) {

			allowedSdSrvtp = dynamicConfig.getAllowed_sd_srvtp();
			refusedSdSrvtp = dynamicConfig.getExclude_sd_srvtp();

			// 如果在当前AssiDynamicConfigDTO对象的排除集合中，继续查找下一个匹配结果
			if (isRefused(sd_srvtp, refusedSdSrvtp)) {
				continue;
			}

			// 将满足要求的配置加入到允许集合中，在此进行判断，直到找到最匹配的一个结果为止
			if (isAllowed(sd_srvtp, allowedSdSrvtp)) {
				if (sd_srvtp.equals(dynamicConfig.getSd_srvtp())) {
					return dynamicConfig;
				}
				allowedConifgList.add(dynamicConfig);
			}
		}

		if (allowedConifgList.size() == 1) {
			return allowedConifgList.get(0);
		} else {
			if(StringUtils.isBlank(sd_srvtp) || sd_srvtp.length() == 2){
				throw new BizException("未找到医嘱复制相关配置，请核对！");
			}
			sd_srvtp = sd_srvtp.substring(0, sd_srvtp.length() - 2);
			return getMatchConfig(allowedConifgList, sd_srvtp, orSrouceFrom);
		}
	}

	/**
	 * 判断sd_srvtp 是否在排除的服务类型中，
	 * 
	 * @param sd_srvtp 服务类型
	 * @param refusedSdSrvtp 排除服务类型字符串，逗号分隔
	 * @return true： 在集合中，false：不在排除集合中
	 */
	private static boolean isRefused(String sd_srvtp, String refusedSdSrvtp) {

		if (StringUtils.isNotBlank(refusedSdSrvtp)) {
			String[] refusedArr = refusedSdSrvtp.split(",");
			for (String refused : refusedArr) {
				if (sd_srvtp.indexOf(refused) >= 0) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断sd_srvtp 是否在允许的服务类型中
	 * 
	 * @param sd_srvtp 待判断的服务类型
	 * @param refusedSdSrvtp 允许的服务类型字符串
	 * @return true： 在允许的集合中，false：不在允许的集合中
	 */
	private static boolean isAllowed(String sd_srvtp, String allowedSdSrvtp) {

		// 如果允许的集合为空，则为匹配
		if (StringUtils.isBlank(allowedSdSrvtp)) {
			return true;
		}

		// 如果在允许的集合中，返回true
		String[] allowedArr = allowedSdSrvtp.split(",");
		for (String allowed : allowedArr) {
			if (sd_srvtp.indexOf(allowed) >= 0) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 获取根据就诊类型分类的扩展执行类
	 * 
	 * @return
	 */
	private static Map<String, List<AssiDynamicConfigDTO>> getConfigResult() {

		Map<String, List<AssiDynamicConfigDTO>> configMap = new HashMap<String, List<AssiDynamicConfigDTO>>();

		// 门诊配置结果
		List<AssiDynamicConfigDTO> listOp = new ArrayList<AssiDynamicConfigDTO>();

		// 门诊执行CiEms拷贝基类（未匹配到具体类的使用这个对象进行属性拷贝）
		AssiDynamicConfigDTO configBase = new AssiDynamicConfigDTO();
		configBase.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		configBase.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		configBase.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		configBase.setAllowed_sd_srvtp("");
		configBase.setExclude_sd_srvtp("");
		configBase.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.base.OpBaseCopyCalCiEmsProperty");
		listOp.add(configBase);

		// CiEms扩展 草药
		AssiDynamicConfigDTO config = new AssiDynamicConfigDTO();
		config.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		config.setAllowed_sd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
		config.setExclude_sd_srvtp("");
		config.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyHerbsPropertyImpl");

		listOp.add(config);

		// CiEms扩展 皮试
		AssiDynamicConfigDTO config0506 = new AssiDynamicConfigDTO();
		config0506.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config0506.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_OP);
		config0506.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST);
		config0506.setAllowed_sd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST);
		config0506.setExclude_sd_srvtp("");
		config0506.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyTreatSkinTestPropertyImpl");

		listOp.add(config0506);
		configMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, listOp);

		// 住院配置结果
		List<AssiDynamicConfigDTO> listIp = new ArrayList<AssiDynamicConfigDTO>();

		// 门诊执行CiEms拷贝基类（未匹配到具体类的使用这个对象进行属性拷贝）
		AssiDynamicConfigDTO configBaseIP = new AssiDynamicConfigDTO();
		configBaseIP.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		configBaseIP.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		configBaseIP.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_DRUG);
		configBaseIP.setAllowed_sd_srvtp("");
		configBaseIP.setExclude_sd_srvtp("");
		configBaseIP.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.base.IpBaseCopyCalCiEmsProperty");
		listIp.add(configBaseIP);

		// CiEms扩展 草药
		AssiDynamicConfigDTO configIp = new AssiDynamicConfigDTO();
		configIp.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		configIp.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		configIp.setAllowed_sd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG);
		configIp.setExclude_sd_srvtp("");
		configIp.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyHerbsPropertyImpl");

		listIp.add(configIp);

		// CiEms扩展 皮试
		AssiDynamicConfigDTO config0506Ip = new AssiDynamicConfigDTO();
		config0506Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config0506Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config0506Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST);
		config0506Ip.setAllowed_sd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST);
		config0506Ip.setExclude_sd_srvtp("");
		config0506Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyTreatSkinTestPropertyImpl");
		listIp.add(config0506Ip);

		// 检查
		AssiDynamicConfigDTO config02Ip = new AssiDynamicConfigDTO();
		config02Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config02Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config02Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_RIS);
		config02Ip.setAllowed_sd_srvtp("");
		config02Ip.setExclude_sd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI);
		config02Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyRisPropertyImpl");
		listIp.add(config02Ip);

		// 检验
		AssiDynamicConfigDTO config03Ip = new AssiDynamicConfigDTO();
		config03Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config03Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config03Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_LIS);
		config03Ip.setAllowed_sd_srvtp("");
		config03Ip.setExclude_sd_srvtp("");
		config03Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyLisPropertyImpl");
		listIp.add(config03Ip);
		
		// 治疗
		AssiDynamicConfigDTO config05Ip = new AssiDynamicConfigDTO();
		config05Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config05Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config05Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_TREAT);
		config05Ip.setAllowed_sd_srvtp("");
		config05Ip.setExclude_sd_srvtp("");
		config05Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.op.OpCopyTreatPropertyImpl");
		listIp.add(config05Ip);
		
		// 嘱托
		AssiDynamicConfigDTO config08Ip = new AssiDynamicConfigDTO();
		config08Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config08Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config08Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST);
		config08Ip.setAllowed_sd_srvtp("");
		config08Ip.setExclude_sd_srvtp("");
		config08Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.base.OpBaseCopyCalCiEmsProperty");
		listIp.add(config08Ip);
		

		// 备血 Apbt
		AssiDynamicConfigDTO config1401Ip = new AssiDynamicConfigDTO();
		config1401Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config1401Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config1401Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE);
		config1401Ip.setAllowed_sd_srvtp("");
		config1401Ip.setExclude_sd_srvtp("");
		config1401Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.ip.IpCopyApbtPropertyImpl");
		listIp.add(config1401Ip);

		// 用血 Apbu
		AssiDynamicConfigDTO config1402Ip = new AssiDynamicConfigDTO();
		config1402Ip.setExtensionPoint(ExtensionPointEu.EndCiEms);// 执行的操作切入点。
		config1402Ip.setCode_entp(IBdFcDictCodeConst.SD_CODE_ENTP_IP);
		config1402Ip.setSd_srvtp(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_USE);
		config1402Ip.setAllowed_sd_srvtp("");
		config1402Ip.setExclude_sd_srvtp("");
		config1402Ip.setFullClassPath("iih.ci.ord.s.bp.assi.impl.cimes.ip.IpCopyApbuPropertyImpl");
		listIp.add(config1402Ip);

		configMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_OP, listOp);
		configMap.put(IBdFcDictCodeConst.SD_CODE_ENTP_IP, listIp);

		return configMap;
	}
}
