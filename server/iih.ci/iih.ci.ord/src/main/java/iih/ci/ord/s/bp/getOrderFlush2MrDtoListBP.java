package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.ordermr.d.OrderMrDto;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.qry.getOrderFlush2MrDtoListQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 病历读取医嘱的信息
 * @author li_zheng
 *
 */
public class getOrderFlush2MrDtoListBP {

	/**
	 * 医嘱信息 orderMrdto
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public OrderMrDto[] exec(String id_ent, String type) throws BizException {
		getOrderFlush2MrDtoListQry qry = new getOrderFlush2MrDtoListQry(id_ent, type);
		OrderMrDto[] rtn = (OrderMrDto[]) AppFwUtil.getDORstWithDao(qry, OrderMrDto.class);
		return rtn;

	}

	/**
	 * 医嘱信息 orderMrdto
	 * 
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec1(String id_ent, String code_entp, String[] idors, String id_psndoc) throws BizException {
		//根据前台传入的医嘱id 设置医嘱同步到病历状态
		String whereStr = " ds = '0' and fg_sign = 'Y' and fg_canc='N' and id_emp_sign='" + id_psndoc + "' and id_or in (";
		//获取ci_agg的服务

		FMap2 xml_map = new FMap2();
		if (idors != null && idors.length > 0) {
			String whereIdStr = "";
			for (String idor : idors) {
				whereIdStr += ",'" + idor + "'";
			}
			whereStr += whereIdStr.substring(1) + ")";
			// 获得患者医嘱信息
			CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().find(whereStr, "", FBoolean.FALSE);
			if (ciors == null || ciors.length == 0)
				return null;
			//处理医嘱状态
			for (CiOrderDO cior : ciors) {
				cior.setFg_flush2mr(FBoolean.TRUE);
			}
			new DAFacade().updateDOArray(ciors, new String[] { CiOrderDO.FG_FLUSH2MR });
		}
		xml_map = getOrderFlushList(id_ent, code_entp, id_psndoc, false);
		return xml_map;
	}
	
	/**
	 * 手动刷新处置到病历
	 * 医嘱信息 orderMrdto
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec2(String[] idors)throws BizException{
		if (idors == null || idors.length <1) return DataHandleNull();
		//根据前台传入的医嘱id 设置医嘱同步到病历状态
		String whereStr = " ds = '0' and fg_sign = 'Y' and fg_canc='N' and id_or in ("; 
		FMap2 xml_map = new FMap2();
		if(idors!=null && idors.length!=0){
			String whereIdStr = "";
			for (String idor : idors) {
				whereIdStr += ",'" + idor + "'";
			}
			whereStr += whereIdStr.substring(1) + ")";
			// 获得患者医嘱信息
			CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().find(whereStr, "", FBoolean.FALSE);
			if (ciors == null || ciors.length == 0)
				return null;
			//处理医嘱状态
			for(CiOrderDO cior: ciors){
				cior.setFg_flush2mr(FBoolean.TRUE);
			}
			new DAFacade().updateDOArray(ciors, new String[] { CiOrderDO.FG_FLUSH2MR });
			
			xml_map = DataHandle(ciors);
		}
		return xml_map;
		
	}

	/**
	 * 返回所有已签署的需要刷入病历的医嘱集合
	 * 
	 * @param id_ent
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public FMap2 getOrderFlushList(String id_ent, String code_entp, String id_psndoc, boolean isAll)
			throws BizException {
		//获取需要刷新到病历的处置
		String whereFlushStr = "";
		if (isAll) {
			whereFlushStr = " ds = '0' and (eu_feereversetp != '1' or eu_feereversetp is null) and fg_sign = 'Y' and fg_canc='N' and fg_flush2mr = 'Y' and id_en ='"
					+ id_ent + "' and code_entp ='" + code_entp + "'";
		} else {
			whereFlushStr = " ds = '0' and (eu_feereversetp != '1' or eu_feereversetp is null) and fg_sign = 'Y' and fg_canc='N' and fg_flush2mr = 'Y' and id_en ='"
					+ id_ent + "' and code_entp ='" + code_entp + "' and id_emp_sign='" + id_psndoc + "'";
		}

		CiOrderDO[] ciors = CiOrdAppUtils.getOrQryService().find(whereFlushStr, "", FBoolean.FALSE);
		if (ciors == null || ciors.length == 0)
			return DataHandleNull();
		//数据处理
		return DataHandle(ciors);
	}

	/***
	 * //用以处理医嘱中的物品类医嘱
	 * 
	 * @author yzh
	 * @since 2017-05-08 20:23:41
	 * @param aggs
	 * @return
	 * @throws BizException
	 */
	private FMap2 DataHandle(CiOrderDO[] ciOrderDOs) throws BizException {
		//西药
		List<List<HashMap<String, String>>> lstWest = new ArrayList<List<HashMap<String, String>>>();
		//中成药
		List<List<HashMap<String, String>>> lstCn = new ArrayList<List<HashMap<String, String>>>();
		//草药
		List<List<HashMap<String, String>>> lstHerb = new ArrayList<List<HashMap<String, String>>>();
		//检查02
		List<HashMap<String, String>> lstRis = new ArrayList<HashMap<String, String>>();
		//检验03
		List<HashMap<String, String>> lstLis = new ArrayList<HashMap<String, String>>();
		//血液制品 14
		List<HashMap<String, String>> lstBlood = new ArrayList<HashMap<String, String>>();
		//其他为治疗 
		List<HashMap<String, String>> lstTreat = new ArrayList<HashMap<String, String>>();

		boolean isNullSql = true;
		//拼装逻辑
		String strIdors = "";
		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			if (ciOrderDO != null) {
				strIdors += ",'" + ciOrderDO.getId_or() + "'";
			}
		}

		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(" id_or in (" + strIdors.substring(1) + ")", "",
				FBoolean.FALSE);
		Map<String, List<OrdSrvDO>> mapOrdSrvDOs = new HashMap<String, List<OrdSrvDO>>();
		String strIdorsrvs = "";
		if (ordSrvDOs != null && ordSrvDOs.length > 0) {
			isNullSql = false;
			for (OrdSrvDO ordSrvDO : ordSrvDOs) {
				strIdorsrvs += ",'" + ordSrvDO.getId_orsrv() + "'";
				if (mapOrdSrvDOs.containsKey(ordSrvDO.getId_or())) {
					mapOrdSrvDOs.get(ordSrvDO.getId_or()).add(ordSrvDO);
				} else {
					List<OrdSrvDO> lstOrdSrvDOs = new ArrayList<OrdSrvDO>();
					lstOrdSrvDOs.add(ordSrvDO);
					mapOrdSrvDOs.put(ordSrvDO.getId_or(), lstOrdSrvDOs);
				}
			}
		}

		// 获取所有医嘱项目物品信息
		IOrdsrvmmRService iOrdersrvmmRS = ServiceFinder.find(IOrdsrvmmRService.class);
		OrdSrvMmDO[] srdSrvMmDOs = iOrdersrvmmRS.find(
				isNullSql ? " Id_orsrv in ('')" : " Id_orsrv in (" + strIdorsrvs.substring(1) + " )", "",
				FBoolean.FALSE);
		Map<String, OrdSrvMmDO> mapOrdSrvMmDOs = new HashMap<String, OrdSrvMmDO>();
		//物品属性表bd_mm
		List<String> idmms = new ArrayList<String>();
		if (srdSrvMmDOs != null) {
			for (OrdSrvMmDO ordSrvMmDO : srdSrvMmDOs) {
				if (!idmms.contains(ordSrvMmDO.getId_mm())) {
					idmms.add(ordSrvMmDO.getId_mm());
				}
				mapOrdSrvMmDOs.put(ordSrvMmDO.getId_orsrv(), ordSrvMmDO);
			}
		}

		IMeterialMDORService iMMRS = ServiceFinder.find(IMeterialMDORService.class);
		MeterialDO[] meterialDOs = iMMRS.findByIds(idmms.toArray(new String[idmms.size()]), FBoolean.FALSE);
		Map<String, MeterialDO> mapMeterialDOs = new HashMap<String, MeterialDO>();
		if (meterialDOs != null) {
			for (MeterialDO meterialDO : meterialDOs) {
				mapMeterialDOs.put(meterialDO.getId_mm(), meterialDO);
			}
		}

		for (CiOrderDO ciOrderDO : ciOrderDOs) {
			if (ciOrderDO == null)
				continue;
			//医嘱类型编码
			String sd_srvtp = ciOrderDO.getSd_srvtp();
			if (sd_srvtp != null) {
				//如果是01开头为西药类 需要拆分看其中是否有中成药和草药
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					//创建用以保存西药草药和中成药数据的集合
					List<HashMap<String, String>> lstWestMap = new ArrayList<HashMap<String, String>>();
					List<HashMap<String, String>> lstCnMap = new ArrayList<HashMap<String, String>>();
					List<HashMap<String, String>> lstHerbMap = new ArrayList<HashMap<String, String>>();
					//药品类进行拆分判断 获取医嘱服务
					OrdSrvDO[] ciOrdSrvDOs = mapOrdSrvDOs.get(ciOrderDO.getId_or()).toArray(new OrdSrvDO[0]);
					//拼装where条件
					if (ciOrdSrvDOs.length > 0) {
						for (OrdSrvDO ordSrvDO : ciOrdSrvDOs) {
							if (ordSrvDO != null) {
								// 判断服务中是否是物品,非物品不做处理
								if (ordSrvDO.getFg_mm() == FBoolean.TRUE) {
									OrdSrvMmDO ordSrvMmDO = mapOrdSrvMmDOs.get(ordSrvDO.getId_orsrv());
									if (ordSrvMmDO != null) {
										// 获取物品类型编码
										String sdmmtp = ordSrvMmDO.getSd_mmtp();
										if (sdmmtp != null) {
											// 拆分
											if (sdmmtp.equals("103")) {// 草药
												HashMap<String, String> h_map = ConvertObj2Map(ciOrderDO, ordSrvDO,
														ordSrvMmDO, mapMeterialDOs.get(ordSrvMmDO.getId_mm()));
												lstHerbMap.add(h_map);
											} else {// 西药
												HashMap<String, String> wm_map = ConvertObj2Map(ciOrderDO, ordSrvDO,
														ordSrvMmDO, mapMeterialDOs.get(ordSrvMmDO.getId_mm()));
												lstWestMap.add(wm_map);
											}
										}
									}
								}
							}
						}
					}

					if (lstWestMap != null && lstWestMap.size() > 0) {
						lstWest.add(lstWestMap);
					}
					if (lstCnMap != null && lstCnMap.size() > 0) {
						lstCn.add(lstCnMap);
					}
					if (lstHerbMap != null && lstHerbMap.size() > 0) {
						lstHerb.add(lstHerbMap);
					}
				} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)) {//检查医嘱
					HashMap<String, String> inspect_map = ConvertObj2Map(ciOrderDO, null, null, null);
					lstRis.add(inspect_map);
				} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)) {//检验医嘱
					HashMap<String, String> test_map = ConvertObj2Map(ciOrderDO, null, null, null);
					lstLis.add(test_map);
				} else if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)) {//血液制品医嘱
					HashMap<String, String> blood_map = ConvertObj2Map(ciOrderDO, null, null, null);
					lstBlood.add(blood_map);
				} else {//其他均为治疗05
					HashMap<String, String> treat_map = ConvertObj2Map(ciOrderDO, null, null, null);
					lstTreat.add(treat_map);
				}
			}
		}

		String xml_west = ConvertDO2Xml(lstWest, true);
		String xml_cn = ConvertDO2Xml(lstCn, true);
		String xml_herb = ConvertDO2Xml(lstHerb, true);
		String xml_ris = ConvertDO2Xml(lstRis, false);
		String xml_lis = ConvertDO2Xml(lstLis, false);
		String xml_blood = ConvertDO2Xml(lstBlood, false);
		String xml_treat = ConvertDO2Xml(lstTreat, false);

		FMap2 result = new FMap2();
		result.put(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, xml_west);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG_CHINA, xml_cn);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, xml_herb);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_RIS, xml_ris);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_LIS, xml_lis);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD, xml_blood);
		result.put(IBdSrvDictCodeConst.SD_SRVTP_TREAT, xml_treat);
		return result;
	}
	
	/***
	 * //用以处理为空的情况
	 * 
	 * @author yzh
	 * @since 2017-05-26 17:01:15
	 * @param aggs
	 * @return
	 * @throws BizException
	 */
	private FMap2 DataHandleNull() throws BizException {
		FMap2 result = new FMap2();
		result.put(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG_CHINA, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_RIS, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_LIS, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD, "");
		result.put(IBdSrvDictCodeConst.SD_SRVTP_TREAT, "");
		return result;
	}
	
	/***
	 * @see 封装xml字符串
	 * @author yzh
	 * @param list
	 * @param fg_mm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String ConvertDO2Xml(List list, boolean fg_mm) {
		if (list == null || list.size() <= 0) {
			return "";
		} else {
			//创建doc
			Document document = DocumentHelper.createDocument();
			//创建根节点
			Element rootElement = document.addElement("table");
			//创建col节点
			Element colElement = rootElement.addElement("column");

			//判断传入的是否是物品类型 以此来判断如何进行取值
			if (fg_mm) {
				for (int i = 0; i < list.size(); i++) {
					List<HashMap<String, String>> item_list = (List<HashMap<String, String>>) list.get(i);
					Element groupElement = rootElement.addElement("group");
					for (int j = 0; j < item_list.size(); j++) {
						HashMap<String, String> map = item_list.get(j);

						Element rowElement = groupElement.addElement("row");
						Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
						if (i == 0 && j == 0) {
							while (iterator.hasNext()) {
								Map.Entry<String, String> entry = iterator.next();
								Element colNode = colElement.addElement("node");
								colNode.setText(entry.getKey());
								Element rowNode = rowElement.addElement("node");
								rowNode.setText(entry.getValue());
							}
						} else {
							while (iterator.hasNext()) {
								Map.Entry<String, String> entry = iterator.next();
								Element rowNode = rowElement.addElement("node");
								rowNode.setText(entry.getValue());
							}
						}
					}
				}
			} else {
				for (int i = 0; i < list.size(); i++) {
					HashMap<String, String> map = (HashMap<String, String>) list.get(i);
					Element groupElement = rootElement.addElement("group");
					Element rowElement = groupElement.addElement("row");
					Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
					if (i == 0) {
						while (iterator.hasNext()) {
							Map.Entry<String, String> entry = iterator.next();
							Element colNode = colElement.addElement("node");
							colNode.setText(entry.getKey());
							Element rowNode = rowElement.addElement("node");
							rowNode.setText(entry.getValue());
						}
					} else {
						while (iterator.hasNext()) {
							Map.Entry<String, String> entry = iterator.next();
							Element rowNode = rowElement.addElement("node");
							rowNode.setText(entry.getValue());
						}
					}

				}
			}
			return document.asXML();
		}
	}
	
	/***
	 * @see 封装空 xml字符串
	 * @author yzh
	 * @param list
	 * @param fg_mm
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private String ConvertNullXml() {
		HashMap<String, String> map = ConvertObj2Map(null, null, null, null);
		//创建doc
		Document document = DocumentHelper.createDocument();
		//创建根节点
		Element rootElement = document.addElement("table");
		//创建col节点
		Element colElement = rootElement.addElement("column");
		Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
		Element groupElement = rootElement.addElement("group");
		Element rowElement = groupElement.addElement("row");
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			Element colNode = colElement.addElement("node");
			colNode.setText(entry.getKey());
			Element rowNode = rowElement.addElement("node");
			rowNode.setText(entry.getValue().toString());
		}
		return document.asXML();
	}
	
	/***
	 * @see 用以将对象封装进入map
	 * @author yzh
	 * @param codo
	 * @param osdo
	 * @param osmmdo
	 * @param mdo
	 * @return
	 */
	@SuppressWarnings("unused")
	private HashMap<String, String> ConvertObj2Map(CiOrderDO codo, OrdSrvDO osdo, OrdSrvMmDO osmmdo, MeterialDO mdo) {
		HashMap<String, String> map = new HashMap<String, String>();
		String spec = "";
		String printname = "";
		boolean codo_flag = false;
		boolean osdo_flag = false;
		boolean osmmdo_flag = false;
		if (codo == null) {
			codo = new CiOrderDO();
			codo_flag = true;
		}
		if (osdo == null) {
			osdo = new OrdSrvDO();
			osdo_flag = true;
		}
		if (osmmdo == null) {
			osmmdo = new OrdSrvMmDO();
			osmmdo_flag = true;
		}
		//获取DO中的字段 和 val 循环放入map中
		String[] codo_names = codo.getAttrNames();
		if (codo_flag) {
			for (int i = 0; i < codo_names.length; i++) {
				map.put(codo_names[i], "");
			}
		} else {
			for (int i = 0; i < codo_names.length; i++) {
				Object val = codo.getAttrVal(codo_names[i]);
				if (val == null) {
					map.put(codo_names[i], "");
				} else {
					//判断是FBoolean类型 进行转换
					if (val instanceof FBoolean) {
						if (val == FBoolean.TRUE) {
							map.put(codo_names[i], "true");
						} else {
							map.put(codo_names[i], "false");
						}
					} else {
						map.put(codo_names[i], val + "");
					}
				}
			}
		}

		String[] osdo_names = osdo.getAttrNames();
		if (osdo_flag) {
			for (int i = 0; i < osdo_names.length; i++) {
				map.put(osdo_names[i], "");
			}
		} else {
			for (int i = 0; i < osdo_names.length; i++) {
				Object val = osdo.getAttrVal(osdo_names[i]);
				if (val == null) {
					map.put(osdo_names[i], "");
				} else {
					if (val instanceof FBoolean) {
						if (val == FBoolean.TRUE) {
							map.put(osdo_names[i], "true");
						} else {
							map.put(osdo_names[i], "false");
						}
					} else {
						map.put(osdo_names[i], val + "");
					}
				}
			}
		}

		String[] osmmdo_names = osmmdo.getAttrNames();
		if (osdo_flag) {
			for (int i = 0; i < osmmdo_names.length; i++) {
				map.put(osmmdo_names[i], "");
			}
		} else {
			for (int i = 0; i < osmmdo_names.length; i++) {
				Object val = osmmdo.getAttrVal(osmmdo_names[i]);
				if (val == null) {
					map.put(osmmdo_names[i], "");
				} else {
					if (val instanceof FBoolean) {
						if (val == FBoolean.TRUE) {
							map.put(osmmdo_names[i], "true");
						} else {
							map.put(osmmdo_names[i], "false");
						}
					} else {
						map.put(osmmdo_names[i], val + "");
					}
				}
			}
		}

		if (mdo != null) {
			spec = mdo.getSpec();
			printname = mdo.getPrintname();
		}
		map.put("SPEC", spec);
		map.put("PRINTNAME", printname);
		return map;
	}
}
