/**
 * 
 */
package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.d.desc.MeterialDODesc;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.desc.MedSrvDODesc;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * @ClassName: getClassMedSrvDOSBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年5月24日 下午4:00:29
 * @Package iih.ci.ord.s.bp Copyright: Copyright (c) 2011 Company: 北大医疗信息技术有限责任公司
 */
public class getClassMedSrvDOSBP {

	// bd_srv 查询服务
	private IMedsrvMDORService medsrvRService;
	// bd_mm 查询服务
	private IMeterialMDORService meterialRService;

	public getClassMedSrvDOSBP() {

		meterialRService = CiOrdAppUtils.getMaterialQryService();
		medsrvRService = CiOrdAppUtils.getMedsrvMDORService();
	}

	public MedSrvDO[] exe(String condition, String orderColumn, FBoolean isLazy,FMap2 medSrvMap) throws BizException {
		condition += " and fg_or = 'Y' and fg_active = 'Y' and ds=0";
		//MedSrvDO[] medsrvs = medsrvRService.find(condition, "a0.pycode", isLazy);
		
		String sql = "select id_srv ,name,Pycode,Fg_mm,Fg_set,sd_srvtp from bd_srv " + MedSrvDODesc.TABLE_ALIAS_NAME +" where " + condition +" order by a0.pycode";

		List<MedSrvDO> queryResult = (List<MedSrvDO>) new DAFacade().execQuery(sql, new BeanListHandler(MedSrvDO.class));
		
		return sortPinyincode(queryResult.toArray(new MedSrvDO[queryResult.size()]),medSrvMap);
	}

	/**
	 * 获取医疗服务
	 * 
	 * @param code_entp 就诊类型
	 * @param condition 查询医疗服务过滤条件
	 * @param orderColumn 排序字段
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public FMap2 exec(String code_entp, String condition, String orderColumn) throws BizException {

		if (CiOrdUtils.isEmpty(condition) || CiOrdUtils.isEmpty(code_entp))
			return null;

		FMap2 medSrvMap = new FMap2();
		FArrayList2 medSrvList = new FArrayList2();

		// 物品对应的服务id
		List<String> idSrvList = new ArrayList<String>();

		StringBuffer sqlBuffer = new StringBuffer();
		// 根据id_srv 查询物品表中的id_srv，id_mm字段
		String sql = "select " + MeterialDO.ID_SRV + ", " + MeterialDO.ID_MM + " from " + MeterialDODesc.TABLE_NAME
				+ " where id_srv in ( %s )";

		List<OrdSrvChangedInfoDTO> srvStatusInfoList = new ArrayList<OrdSrvChangedInfoDTO>();

		MedSrvDO[] medSrvs = this.exe(condition, orderColumn, FBoolean.FALSE,medSrvMap);
//		if (medSrvs == null || medSrvs.length == 0) {
//			medSrvMap.put("medSrvs", medSrvs);
//			medSrvMap.put("srvStatusMap", new FMap2());
//		}

		for (MedSrvDO medSrv : medSrvs) {

			medSrvList.add(medSrv);
			if (CiOrdUtils.isEmpty(medSrv.getId_srv())) {
				continue;
			}

			if (medSrv.getFg_mm() == FBoolean.TRUE && !CiOrdUtils.isEmpty(medSrv.getId_srv())) {
				idSrvList.add(medSrv.getId_srv());
				continue;
			}

			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(medSrv.getId_srv());
			srvStatusInfoList.add(dto);
		}

		if (idSrvList.size() > 0) {

			StringBuffer idMmBuffer = new StringBuffer();

			for (int i = 0; i < idSrvList.size(); i++) {

				idMmBuffer.append(",'" + idSrvList.get(i) + "'");
				if ((i > 0 && i % 100 == 0) || i == idSrvList.size() - 1) {

					sql = String.format(sql, idMmBuffer.substring(1));
					sqlBuffer.append(" union " + sql);
					idMmBuffer.setLength(0);

				}
			}

			//sql = String.format(sql, idMmBuffer.substring(1));

			List<Map<String, String>> queryResult = (List<Map<String, String>>) new DAFacade()
					.execQuery(sqlBuffer.substring(6), new MapListHandler());

			for (Map<String, String> map : queryResult) {

				OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
				dto.setId_srv(map.get(MeterialDO.ID_SRV.toLowerCase()));
				dto.setId_mm(map.get(MeterialDO.ID_MM.toLowerCase()));
				srvStatusInfoList.add(dto);
			}
		}

		OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
		// 获取不可用服务集合，key：id_srv; value：不可用提示信息
		long  startTime = System.currentTimeMillis();
		/*FMap2 srvStatusMap = bp.exec(srvStatusInfoList.toArray(new OrdSrvChangedInfoDTO[srvStatusInfoList.size()]),
				code_entp);*/
		CiOrdUtils.LogerOutInfo(" 类  getClassMedSrvDOSBP  方法  验证方法耗时  exec 耗时"+(System.currentTimeMillis()- startTime));
		medSrvMap.put("srvStatusMap",  new FMap2());
		//medSrvMap.put("medSrvList", medSrvList);

		return medSrvMap;
	}

	/**
	 * 获取物品id_srv与id_mm集合
	 * 
	 * @param idSrvMmList
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<OrdSrvChangedInfoDTO> getMeterialIdList(List<String> idSrvList) throws BizException {

		// 根据id_srv 查询物品表中的id_srv，id_mm字段
		String sql = "select " + MeterialDO.ID_SRV + ", " + MeterialDO.ID_MM + " from " + MeterialDODesc.TABLE_NAME
				+ " where id_srv in ( %s )";

		List<Map<String, String>> queryResult = null;
		List<OrdSrvChangedInfoDTO> srvStatusInfoList = new ArrayList<OrdSrvChangedInfoDTO>();

		if (idSrvList == null || idSrvList.size() > 0) {
			return srvStatusInfoList;
		}

		StringBuffer idMmBuffer = new StringBuffer();
		for (String idSrv : idSrvList) {
			idMmBuffer.append(",'" + idSrv + "'");
		}

		sql = String.format(sql, idMmBuffer.substring(1));

		queryResult = (List<Map<String, String>>) new DAFacade().execQuery(sql, new MapListHandler());

		for (Map<String, String> map : queryResult) {

			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(map.get(MeterialDO.ID_SRV.toLowerCase()));
			srvStatusInfoList.add(dto);
		}

		return srvStatusInfoList;
	}

	/**
	 * 按拼音码排序
	 * 
	 * @param medsrvs
	 * @throws BizException
	 */
	private MedSrvDO[] sortPinyincode(MedSrvDO[] medsrvs,FMap2 medSrvMap) throws BizException {
		Map<String, String> map = new HashMap();
		List<MedSrvDO> list = new ArrayList();
		FArrayList2 medSrvList = new FArrayList2();
		if (medsrvs != null) {
			for (MedSrvDO item : medsrvs) {
				if (item.getPycode() != null && item.getPycode().length() > 1) {
					String code = item.getPycode().substring(0, 1);
					if (!map.containsKey(code.toUpperCase())) {
						MedSrvDO medsrv = new MedSrvDO();
						medsrv.setName(code.toUpperCase());
						list.add(medsrv);
					}
					list.add(item);
				}
				
				if(item.getPycode() != null && item.getPycode().length() > 1){
					String code = item.getPycode().substring(0, 1);
					 char chr = code.charAt(0); 
						if(chr >='A' && chr <='Z' ){
							code = code.toUpperCase();
						}else{
							code = "OTHER";
						}
					if(medSrvMap.containsKey(code)){
						medSrvList = (FArrayList2)medSrvMap.get(code);
						medSrvList.add(item);
					}else{
						medSrvList = new FArrayList2();
						medSrvList.add(item);
						medSrvMap.put(code, medSrvList);
					}
				}
			}
		}
		return list.toArray(new MedSrvDO[list.size()]);
	}

	/**
	 * 字符串 大小字母转换
	 * 
	 * @param str
	 * @return
	 */
	private String exChange(String str) {
		StringBuffer sb = new StringBuffer();
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isUpperCase(c)) {
					sb.append(Character.toLowerCase(c));
				} else if (Character.isLowerCase(c)) {
					sb.append(Character.toUpperCase(c));
				}
			}
		}

		return sb.toString();
	}
}
