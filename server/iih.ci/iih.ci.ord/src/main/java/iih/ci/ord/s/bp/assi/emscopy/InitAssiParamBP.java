package iih.ci.ord.s.bp.assi.emscopy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialAggDO;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.ds.IMeterialService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 初始化参数
 * 
 * @author HUMS
 *
 */
public class InitAssiParamBP {

	// 医疗服务服务
	private IMedsrvMDORService imedsrvMDORService;
	// 套定义服务
	private IMedSrvSetItemDORService srvSetItemRSercie;
	// 检查属性
	private IMedSrvRisDORService imedSrvRisDORService = null;

	// 诊断服务接口
	private ICidiagQryService icidiagQryService;
	// 物品查询接口
	private IMeterialService imeterialService;

	public InitAssiParamBP() {

		imedsrvMDORService = (IMedsrvMDORService) ServiceFinder.find(IMedsrvMDORService.class);
		srvSetItemRSercie = (IMedSrvSetItemDORService) ServiceFinder.find(IMedSrvSetItemDORService.class);
		imedSrvRisDORService = (IMedSrvRisDORService) ServiceFinder.find(IMedSrvRisDORService.class);

		icidiagQryService = (ICidiagQryService) ServiceFinder.find(ICidiagQryService.class);
		imeterialService = (IMeterialService) ServiceFinder.find(IMeterialService.class);

	}

	public AssiParamDTO initAssiParam(CiEnContextDTO envinfo, CiOrTmplDTO[] ciOrtmplAggs) throws BizException {

		AssiParamDTO paramDTO = new AssiParamDTO();

		// 初始化上下文就诊环境
		this.initCiEnContext(envinfo, paramDTO);

		// 初始化服务相关的map集合
		this.initAssiMapParam(paramDTO, ciOrtmplAggs);
		return paramDTO;
	}

	/**
	 * 初始化上下文环境中的保外诊断属性
	 * 
	 * @param envinfo 当前上下文就诊环境
	 * @param paramDTO
	 * @throws BizException
	 */
	private void initCiEnContext(CiEnContextDTO envinfo, AssiParamDTO paramDTO) throws BizException {

		// 如果是医保就诊，判断是否存在保外诊断
		if (envinfo.getFg_hpfundpay() == FBoolean.TRUE) {
			// 查询保外诊断
			CiDiagItemDO[] ciDiagItems = icidiagQryService.getHpjudgetpCiDiagItems(envinfo.getId_en());
			CiEnContextUtil.SetHpCiDiagItem(envinfo, ciDiagItems);
		}

		paramDTO.setEnvinfo(envinfo);
	}

	/**
	 * 获取本地拷贝的全部MedSrv并组合成map结构
	 * 
	 * @throws BizException
	 */
	private void initAssiMapParam(AssiParamDTO paramDTO, CiOrTmplDTO[] ciOrtmplAggs) throws BizException {

		// 医疗服务map集合 key id_srv
		Map<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();

		// 服务套id与套内项目集合Map结构（key服务套的id_srv ，value 套内项目集合）
		Map<String, List<MedSrvSetItemDO>> srvSetItemsMap = new HashMap<String, List<MedSrvSetItemDO>>();

		// 检查属性map集合 key值为id_srv
		Map<String, MedSrvRisDO> srvRisMap = new HashMap<String, MedSrvRisDO>();

		// 关联全部的物品集合
		Map<String, MeterialDO> meterialMap = new HashMap<String, MeterialDO>();

		// 模板、模板项目中对应的医疗服务id
		List<String> idSrvList = new ArrayList<String>();
		// 服务套对应的医疗服务集合
		List<String> srvSetIdList = null;
		// 套内项目对应的医疗服务id集合
		List<String> idSrvItmList = null;
		// 物品id集合，获取传入的模板srv中包含id_mm的物品， idmmList与idmmSrvList 获取的物品为交集结果
		List<String> idmmList = null;
		// 物品关联物品的idSrv集合，用于获取传入的物品标识单没有传入物品id的，idmmList与idmmSrvList 获取的物品为交集结果
		List<String> idmmSrvList = null;

		for (CiOrTmplDTO ciOrTmpl : ciOrtmplAggs) {

			// 医嘱模板对应的服务集合
			idSrvList.add(ciOrTmpl.getId_srv());

			// 获取所有服务套的id
			if (ciOrTmpl.getFg_set() == FBoolean.TRUE) {
				if (srvSetIdList == null) {
					srvSetIdList = new ArrayList<String>();
				}
				srvSetIdList.add(ciOrTmpl.getId_srv());
			}

			// 获取模板中的服务项目对应的医疗服务id集合
			FArrayList ciOrTmplSrvList = ciOrTmpl.getOrtmplsrvs();
			for (Object obj : ciOrTmplSrvList) {
				CiOrTmplSrvDTO ciOrTmplSrv = (CiOrTmplSrvDTO) obj;
				idSrvList.add(ciOrTmplSrv.getId_srv());

				// 获取关联的物品id集合，组套中不包含物品，只能根据服务查询
				if (StringUtils.isNotBlank(ciOrTmplSrv.getId_mm())) {
					if (idmmList == null) {
						idmmList = new ArrayList<String>();
					}
					idmmList.add(ciOrTmplSrv.getId_mm());
				}
			}
		}

		// 获取医嘱模板，医嘱模板项目对应的MedSrv
		initMedSrvMap(idSrvList, medSrvMap);

		// 获取服务套对应的套内项目集合
		MedSrvSetItemDO[] medSrvSetItems = getMedSrvSetItems(srvSetIdList);
		if (medSrvSetItems != null && medSrvSetItems.length > 0) {
			idSrvItmList = new ArrayList<String>();
			for (MedSrvSetItemDO medSrvSetItem : medSrvSetItems) {

				// 获取套内项目对应的服务id，需要再查下套内项目对应的服务
				idSrvItmList.add(medSrvSetItem.getId_srv_itm());

				// 构造套内项目Map集合
				List<MedSrvSetItemDO> medSrvSetItmList = null;
				if (srvSetItemsMap.containsKey(medSrvSetItem.getId_srv())) {
					medSrvSetItmList = srvSetItemsMap.get(medSrvSetItem.getId_srv());
				} else {
					medSrvSetItmList = new ArrayList<MedSrvSetItemDO>();
					srvSetItemsMap.put(medSrvSetItem.getId_srv(), medSrvSetItmList);
				}
				medSrvSetItmList.add(medSrvSetItem);

			}
		}

		// 查询套内项目并保存到医疗服务map结构中
		initMedSrvMap(idSrvItmList, medSrvMap);

		// 获取所有检查的医疗服务id
		List<String> idSrvRiseList = null;

		for (MedSrvDO medSrv : medSrvMap.values()) {
			if (medSrv.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {
				if (idSrvRiseList == null) {
					idSrvRiseList = new ArrayList<String>();
				}
				idSrvRiseList.add(medSrv.getId_srv());

			} else if (medSrv.getFg_mm() == FBoolean.TRUE) {
				if (idmmSrvList == null) {
					idmmSrvList = new ArrayList<String>();
				}
				idmmSrvList.add(medSrv.getId_srv());
			}
		}

		// 初始化检查的map结构
		initSrvRisMap(idSrvRiseList, srvRisMap);
		// 根据物品id初始化物品map
		initMeterialMapByIds(idmmList, meterialMap);
		// 根据物品服务初始化物品map
		initMeterialMap(idmmSrvList, meterialMap);

		paramDTO.setMedSrvMap(medSrvMap);
		paramDTO.setSrvSetItemsMap(srvSetItemsMap);
		paramDTO.setSrvRisMap(srvRisMap);
		paramDTO.setMeterialMap(meterialMap);
	}

	/**
	 * 根据id_srv集合获取医疗服务并保存到医疗服务map结构中
	 * 
	 * @param idSrvList 待查询医疗服务id
	 * @param medSrvMap
	 * @throws BizException
	 */
	private void initMedSrvMap(List<String> idSrvList, Map<String, MedSrvDO> medSrvMap) throws BizException {

		if (idSrvList == null || idSrvList.size() == 0) {
			return;
		}

		MedSrvDO[] mdeSrvs = imedsrvMDORService.findByIds(idSrvList.toArray(new String[0]), FBoolean.FALSE);
		for (MedSrvDO medSrv : mdeSrvs) {
			if (!medSrvMap.containsKey(medSrv.getId_srv())) {
				medSrvMap.put(medSrv.getId_srv(), medSrv);
			}
		}
	}

	/**
	 * 获取套内项目Map集合
	 * 
	 * @param srvSetIdList
	 * @return
	 * @throws BizException
	 */
	private MedSrvSetItemDO[] getMedSrvSetItems(List<String> srvSetIdList) throws BizException {

		MedSrvSetItemDO[] medSrvSetItems = null;
		StringBuffer idSrvBuffer = new StringBuffer();

		if (srvSetIdList == null || srvSetIdList.size() == 0) {
			return null;
		}

		for (String idSrv : srvSetIdList) {
			idSrvBuffer.append(",'" + idSrv + "'");
		}

		if (idSrvBuffer.length() > 0) {
			// 查询套内项目
			String whereStr = "id_srv in (" + idSrvBuffer.substring(1) + ")";
			medSrvSetItems = srvSetItemRSercie.find(whereStr, null, FBoolean.FALSE);

		}
		return medSrvSetItems;
	}

	/**
	 * 初始化检验属性Map集合
	 * 
	 * @param idsrvList 检验属性的idSrv集合
	 * @param srvRisMap 构造查询出来的检验对象map结构， key值为医疗服务id
	 * @throws BizException
	 */
	private void initSrvRisMap(List<String> idsrvList, Map<String, MedSrvRisDO> srvRisMap) throws BizException {

		StringBuffer idSrvBuffer = null;
		if (idsrvList == null || idsrvList.size() > 0) {
			return;
		}
		
		idSrvBuffer = new StringBuffer();
		for (String idSrv : idsrvList) {
			idSrvBuffer.append(",'" + idSrv + "'");
		}

		// 查询检查属性
		String whereStrRis = "id_srv in (" + idSrvBuffer.substring(1) + ")";
		MedSrvRisDO[] medSrvRises = imedSrvRisDORService.find(whereStrRis, null, FBoolean.FALSE);
		for (MedSrvRisDO medSrvRis : medSrvRises) {
			srvRisMap.put(medSrvRis.getId_srv(), medSrvRis);
		}
	}

	/**
	 * 初始化物品Map集合
	 * 
	 * @param idSrvList 物品对应的id_srv集合
	 * @param meterialMap 物品map集合，id为物品对应服务id
	 * @throws BizException
	 */
	private void initMeterialMap(List<String> idSrvList, Map<String, MeterialDO> meterialMap) throws BizException {

		if (idSrvList == null) {
			return;
		}

		// 排除掉已经查询过的物品，只查询当前物品集合meterialMap中不存在的物品服务
		for (MeterialDO meterial : meterialMap.values()) {
			if (idSrvList.contains(meterial.getId_srv())) {
				idSrvList.remove(meterial.getId_srv());
			}
		}

		// 可能所有的物品是根据id_mm查询出来的
		if (idSrvList.size() == 0) {
			return;
		}

		StringBuffer idSrvBuffer = new StringBuffer();
		for (String idSrv : idSrvList) {
			idSrvBuffer.append(",'" + idSrv + "'");
		}
		String whereStr = MeterialDODesc.TABLE_ALIAS_NAME + "." + MeterialDO.ID_SRV + " in (" + idSrvBuffer.substring(1)
				+ ")";
		MeterialAggDO[] meterialAggs = CiOrdAppUtils.getIMeterialRService().find(whereStr, MeterialDO.ID_SRV,
				FBoolean.TRUE);

		if (meterialAggs != null && meterialAggs.length > 0) {
			for (MeterialAggDO meterialAgg : meterialAggs) {

				MeterialDO meterial = meterialAgg.getParentDO();
				// 一个服务可能关联多个物品，一个服务id只去一个物品
				if (meterialMap.containsKey(meterial.getId_srv())) {
					continue;
				}

				meterialMap.put(meterial.getId_srv(), meterial);
			}
		}
	}

	/**
	 * 初始化物品Map集合
	 * 
	 * @param idmmList 物品id集合
	 * @param meterialMap 物品map集合，id为物品对应服务id
	 * @throws BizException
	 */
	private void initMeterialMapByIds(List<String> idmmList, Map<String, MeterialDO> meterialMap) throws BizException {

		if (idmmList == null || idmmList.size() == 0) {
			return;
		}

		for (String idmm : idmmList) {
			MeterialDO meterial = imeterialService.findMaterialByID(idmm);
			meterialMap.put(meterial.getId_srv(), meterial);
		}
	}
}
