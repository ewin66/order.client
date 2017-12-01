package iih.ci.ord.s.bp.ordsrvchangedval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.prisrvcomp.d.PriSrvCompDO;
import iih.bd.pp.prisrvcomp.i.IPrisrvcompRService;
import iih.bd.pp.prisrvsetfix.d.PriSrvSetFixDO;
import iih.bd.pp.prisrvsetfix.i.IPrisrvsetfixRService;
import iih.bd.pp.prisrvsetmu.d.PriSrvSetMuDO;
import iih.bd.pp.prisrvsetmu.i.IPrisrvsetmuRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.s.bp.ordsrvchangedval.qry.GetMedSrvDOsQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 判断服务是否可开立
 * 
 * @author YANG
 *
 */
public class OrdChangedSrvValidateBP {

	private static String STR_SRV_ENTP_VAL = "服务【%s】就诊类型不符，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_ACTIVE_VAL = "服务【%s】停用，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_OR_VAL = "服务【%s】不是医嘱服务，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_MM_ACTIVE_VAL = "服务【%s】关联物品【%s】停开，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_MM_VAL = "服务【%s】关联物品变更，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_SET_VAL = "【%s】套内明细【%s】停用，请联系医保办维护处理，电话：69006098！";
	private static String STR_SRV_BL_VAL = "【%s】费用项停用，不可开立，请联系医保办维护处理，电话：69006098！";

	private FMap mapMeSrvDOs_Checked = new FMap();
	private FMap2 mapResult = new FMap2();

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param medSrvDOs 待判断服务对象集合
	 * @param code_entp 就诊类型
	 * @return
	 * @throws BizException
	 */
	public Map<String, String> exec(List<MedSrvDO> medSrvDOs, String code_entp) throws BizException {
		Map<String, String> srvStatusMap = new HashMap<String, String>();
		if (medSrvDOs == null || medSrvDOs.size() == 0) {
			return srvStatusMap;
		}

		FMap2 fmap = this.exec(code_entp, medSrvDOs.toArray(new MedSrvDO[medSrvDOs.size()]));

		for (String key : fmap.keySet()) {
			srvStatusMap.put(key, fmap.get(key).toString());
		}

		return srvStatusMap;
	}

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp 就诊类型
	 * @param medSrvDOs 待判断服务对象数组
	 * @return
	 * @throws BizException
	 */
	public FMap2 exec(String code_entp, MedSrvDO[] medSrvDOs) throws BizException {
		if (null == medSrvDOs || 0 >= medSrvDOs.length)
			return null;

		ArrayList<OrdSrvChangedInfoDTO> srvInfoDTOs = new ArrayList<OrdSrvChangedInfoDTO>();
		for (MedSrvDO medSrvDO : medSrvDOs) {
			OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
			dto.setId_srv(medSrvDO.getId_srv());
			srvInfoDTOs.add(dto);
		}
		return this.exec(srvInfoDTOs.toArray(new OrdSrvChangedInfoDTO[srvInfoDTOs.size()]), code_entp);
	}

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp 就诊类型
	 * @param ordSrvChangedInfoDTOs 服务是否可用判断参数
	 * @return Map<String,String> 非物品时 key：id_srv ; value：不可用提示信息，物品时 key：id_srv,id_mm ; value：不可用提示信息
	 * @throws BizException
	 */
	public Map<String, String> exec(String code_entp, List<OrdSrvChangedInfoDTO> ordSrvInfos) throws BizException {

		Map<String, String> srvStatusMap = new HashMap<String, String>();
		if (ordSrvInfos == null || ordSrvInfos.size() == 0) {
			return srvStatusMap;
		}

		FMap2 fmap = this.exec(ordSrvInfos.toArray(new OrdSrvChangedInfoDTO[ordSrvInfos.size()]), code_entp);

		for (String key : fmap.keySet()) {
			srvStatusMap.put(key, fmap.get(key).toString());
		}

		return srvStatusMap;
	}

	/**
	 * 获取不可用医疗服务及提示信息
	 * 
	 * @param code_entp 就诊类型
	 * @param ordSrvChangedInfoDTOs 传入对象集合 （id_srv,id_mm）
	 * @return FMap2，不可开立的服务集合（Key:"Id_srv,Id_mm",Value:服务不可开立原因提示）
	 * @throws BizException
	 */
	public FMap2 exec(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTOs, String code_entp) throws BizException {
		if (null == ordSrvChangedInfoDTOs || 0 >= ordSrvChangedInfoDTOs.length)
			return null;
		
		ArrayList<String> id_srvs = new ArrayList<String>();// 需要校验的服务ID集合
		FMap mapSrvMM = new FMap();// 需要校验的 服务-物品 （保存在模板中）
		for (OrdSrvChangedInfoDTO ordSrvChangedInfoDTO : ordSrvChangedInfoDTOs) {
			if (null != ordSrvChangedInfoDTO && !StringUtils.isNullOrEmpty(ordSrvChangedInfoDTO.getId_srv())) {
				// 去除重复服务
				if (!id_srvs.contains(ordSrvChangedInfoDTO.getId_srv()))
					id_srvs.add(ordSrvChangedInfoDTO.getId_srv());
				// (id_srv:id_mm1,id_mm2,id_mm3...)
				if (!StringUtils.isNullOrEmpty(ordSrvChangedInfoDTO.getId_mm())) {
					if (mapSrvMM.containsKey(ordSrvChangedInfoDTO.getId_srv())) {
						if (!mapSrvMM.get(ordSrvChangedInfoDTO.getId_srv()).toString()
								.contains(ordSrvChangedInfoDTO.getId_mm()))
							mapSrvMM.put(ordSrvChangedInfoDTO.getId_srv(),
									mapSrvMM.get(ordSrvChangedInfoDTO.getId_srv()).toString() + ","
											+ ordSrvChangedInfoDTO.getId_mm());
					} else
						mapSrvMM.put(ordSrvChangedInfoDTO.getId_srv(), ordSrvChangedInfoDTO.getId_mm());
				}

			}
		}
		// 获取校验数据集合(id_srv:MedSrvDO)
		MedSrvDO[] meSrvDOs = getMedSrvDOs(id_srvs.toArray(new String[id_srvs.size()]));
		if (null != meSrvDOs && 0 < meSrvDOs.length) {
			for (MedSrvDO meSrvDO : meSrvDOs) {
				mapMeSrvDOs_Checked.put(meSrvDO.getId_srv(), meSrvDO);
			}
		}

		judgeSrvActive();
		judgeSrvMMActive(mapSrvMM, code_entp);
		judgeSrvSetActive();
		judgeSrvEntp(code_entp);
		judgeSrvBL();
		
		return mapResult;
	}

	/**
	 * 服务就诊类型判断
	 * 
	 * @param code_entp 就诊类型
	 */
	private void judgeSrvEntp(String code_entp) {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		try {
			ArrayList<String> methodnames = getMethodNames(code_entp, "getFg_use");
			Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
			for (String id_srv : new ArrayList<>(id_srvs)) {
				MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
				Class<?> clazz = meSrvDO.getClass();
				boolean bEnable = false;
				if (methodnames.size() > 0) {
					for (String methodname : methodnames) {
						// 当前就诊类型可使用
						java.lang.reflect.Method method = clazz.getDeclaredMethod(methodname);
						if (((FBoolean) method.invoke(meSrvDO)).booleanValue()) {
							bEnable = true;
							break;
						}
					}
				}
				if (!bEnable) {
					mapResult.put(id_srv, String.format(STR_SRV_ENTP_VAL, meSrvDO.getName()));
					mapMeSrvDOs_Checked.remove(id_srv);
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 服务停用判断\服务临床标识判断
	 */
	private void judgeSrvActive() {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
		for (String id_srv : new ArrayList<>(id_srvs)) {
			MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
			if (null == meSrvDO.getFg_active() || !meSrvDO.getFg_active().booleanValue()) {
				mapResult.put(id_srv, String.format(STR_SRV_ACTIVE_VAL, meSrvDO.getName()));
				mapMeSrvDOs_Checked.remove(id_srv);
			}
			if (null == meSrvDO.getFg_or() || !meSrvDO.getFg_or().booleanValue()) {
					mapResult.put(id_srv, String.format(STR_SRV_OR_VAL, meSrvDO.getName()));
					mapMeSrvDOs_Checked.remove(id_srv);
				 
			}
		}
	}

	/**
	 * 服务物品停用判断（针对的是保存在模板里的服务默认物品）
	 * 
	 * @param mapSrvMM 服务物品关联集合(id_srv:id_mm1,id_mm2,id_mm3...)
	 * @param code_entp 就诊类型
	 */
	private void judgeSrvMMActive(FMap mapSrvMM, String code_entp) {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size() || 0 >= mapSrvMM.size())
			return;

		try {
			ArrayList<String> methodnames = getMethodNames(code_entp, "getSd_mmbind");
			Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
			
			String strIdsrvs = "";
			for (String id_srv : new ArrayList<>(id_srvs)) {
				strIdsrvs += ",'" + id_srv + "'";
			}
			MeterialDO[] allMeterialDOs = this.getMeterialDOs(strIdsrvs.substring(1));
			Map<String, List<MeterialDO>> mapMeterialDOs = new HashMap<String, List<MeterialDO>>();
			if (allMeterialDOs != null && allMeterialDOs.length > 0) {
				for (MeterialDO item : allMeterialDOs) {
					if (mapMeterialDOs.containsKey(item.getId_srv())) {
						mapMeterialDOs.get(item.getId_srv()).add(item);
					} else {
						List<MeterialDO> lst = new ArrayList<MeterialDO>();
						lst.add(item);
						mapMeterialDOs.put(item.getId_srv(), lst);
					}
				}
			}
			
			outer: for (String id_srv : new ArrayList<>(id_srvs)) {
				MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
				if (null != meSrvDO.getFg_or() && meSrvDO.getFg_or().booleanValue() && null != meSrvDO.getFg_mm()
						&& meSrvDO.getFg_mm().booleanValue() && mapSrvMM.containsKey(id_srv)) {
					Class<?> clazz = meSrvDO.getClass();
					if (methodnames.size() > 0) {
						for (String methodname : methodnames) {
							// 服务执行绑定物品，不校验物品
							java.lang.reflect.Method method = clazz.getDeclaredMethod(methodname);
							if (((String) method.invoke(meSrvDO)).equals("1")) {
								continue outer;
							}
						}
					}

					MeterialDO[] meterialDOs = mapMeterialDOs.get(id_srv).toArray(new MeterialDO[]{});
					ArrayList<String> id_mms = new ArrayList<String>();
					for (MeterialDO meterialDO : meterialDOs) {
						if (mapSrvMM.get(id_srv).toString().contains(meterialDO.getId_mm())) {
							// 物品停用
							if (null == meterialDO.getFg_active() || !meterialDO.getFg_active().booleanValue()) {
								// 物品校验时对模板保存的校验，不是对服务基础数据的校验
								mapResult.put(id_srv + "," + meterialDO.getId_mm(),
										String.format(STR_SRV_MM_ACTIVE_VAL, meSrvDO.getName(), meterialDO.getName()));
								// mapMeSrvDOs_Checked.remove(id_srv);
							}
						}
						id_mms.add(meterialDO.getId_mm());
					}
					// 关联物品关系变更
					String[] idsrvmms = mapSrvMM.get(id_srv).toString().split(",");
					for (String id_mm : idsrvmms) {
						if (!id_mms.contains(id_mm)) {
							mapResult.put(id_srv + "," + id_mm, String.format(STR_SRV_MM_VAL, meSrvDO.getName()));
							// mapMeSrvDOs_Checked.remove(id_srv);
						}
					}
				}
			}
		} catch (Exception e) {
		}
	}

	/**
	 * 服务套停用判断
	 * 
	 * @throws BizException
	 */
	private void judgeSrvSetActive() throws BizException {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
		
		String strIdsrvs = "";
		for (String id_srv : new ArrayList<>(id_srvs)) {
			strIdsrvs += ",'" + id_srv + "'";
		}
		MedSrvSetItemDO[] allMedSrvSetItemDOs = this.getMedSrvSetItemDOs(strIdsrvs.substring(1));
		Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs = new HashMap<String, List<MedSrvSetItemDO>>();
		if (allMedSrvSetItemDOs != null && allMedSrvSetItemDOs.length > 0) {
			for (MedSrvSetItemDO item : allMedSrvSetItemDOs) {
				if (mapMedSrvSetItemDOs.containsKey(item.getId_srv())) {
					mapMedSrvSetItemDOs.get(item.getId_srv()).add(item);
				} else {
					List<MedSrvSetItemDO> lst = new ArrayList<MedSrvSetItemDO>();
					lst.add(item);
					mapMedSrvSetItemDOs.put(item.getId_srv(), lst);
				}
			}
		}
		
		outer: for (String id_srv : new ArrayList<>(id_srvs)) {
			MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
			if (null != meSrvDO.getFg_or() && meSrvDO.getFg_or().booleanValue() && null != meSrvDO.getFg_set()
					&& meSrvDO.getFg_set().booleanValue()) {
				MedSrvSetItemDO[] medSrvSetItemDOs = mapMedSrvSetItemDOs.get(id_srv).toArray(new MedSrvSetItemDO[]{});
				ArrayList<String> id_srv_itms = new ArrayList<String>();
				for (MedSrvSetItemDO medSrvSetItemDO : medSrvSetItemDOs) {
					//mapResult.containsKey(key)
					if (null != medSrvSetItemDO.getFg_clinical() && medSrvSetItemDO.getFg_clinical().booleanValue())
						id_srv_itms.add(medSrvSetItemDO.getId_srv_itm());
					   if(mapResult != null && mapResult.containsKey(medSrvSetItemDO.getId_srv_itm())  ){
						   mapResult.remove(medSrvSetItemDO.getId_srv_itm());
					   }
				}

				if (0 < id_srv_itms.size()) {
					// 获取校验数据集合
					MedSrvDO[] itmMeSrvDOs = getMedSrvDOs(id_srv_itms.toArray(new String[id_srv_itms.size()]));
					if (null != itmMeSrvDOs && 0 < itmMeSrvDOs.length) {
						for (MedSrvDO itmMeSrvDO : itmMeSrvDOs) {
							if (null == itmMeSrvDO.getFg_active() || !itmMeSrvDO.getFg_active().booleanValue()) {
								mapResult.put(id_srv,
										String.format(STR_SRV_SET_VAL, meSrvDO.getName(), itmMeSrvDO.getName()));
								mapMeSrvDOs_Checked.remove(id_srv);
								continue outer;
							}
						}
					}
				}
			}
		}
	}

	/**
	 * 服务费用停用判断
	 * 
	 * @throws BizException
	 */
	private void judgeSrvBL() throws BizException {
		if (null == mapMeSrvDOs_Checked || 0 >= mapMeSrvDOs_Checked.size())
			return;

		Set<String> id_srvs = mapMeSrvDOs_Checked.keySet();
		String strIdsrvs = "";
		for (String id_srv : new ArrayList<>(id_srvs)) {
			strIdsrvs += ",'" + id_srv + "'";
		}
		MedSrvSetItemDO[] allMedSrvSetItemDOs = this.getMedSrvSetItemDOs(strIdsrvs.substring(1));
		Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs = new HashMap<String, List<MedSrvSetItemDO>>();
		if (allMedSrvSetItemDOs != null && allMedSrvSetItemDOs.length > 0) {
			for (MedSrvSetItemDO item : allMedSrvSetItemDOs) {
				if (mapMedSrvSetItemDOs.containsKey(item.getId_srv())) {
					mapMedSrvSetItemDOs.get(item.getId_srv()).add(item);
				} else {
					List<MedSrvSetItemDO> lst = new ArrayList<MedSrvSetItemDO>();
					lst.add(item);
					mapMedSrvSetItemDOs.put(item.getId_srv(), lst);
				}
			}
		}
		
		PriSrvSetMuDO[] allPriSrvSetMuDOs = getPriSrvSetMuDOs(strIdsrvs.substring(1));
		Map<String, List<PriSrvSetMuDO>> mapPriSrvSetMuDOs = new HashMap<String, List<PriSrvSetMuDO>>();
		if (allPriSrvSetMuDOs != null && allPriSrvSetMuDOs.length > 0) {
			for (PriSrvSetMuDO item : allPriSrvSetMuDOs) {
				if (mapPriSrvSetMuDOs.containsKey(item.getId_srvset())) {
					mapPriSrvSetMuDOs.get(item.getId_srvset()).add(item);
				} else {
					List<PriSrvSetMuDO> lst = new ArrayList<PriSrvSetMuDO>();
					lst.add(item);
					mapPriSrvSetMuDOs.put(item.getId_srvset(), lst);
				}
			}
		}
		
		PriSrvSetFixDO[] allpPiSrvSetFixDOs = getPriSrvSetFixDOs(strIdsrvs.substring(1));
		Map<String, List<PriSrvSetFixDO>> mapPriSrvSetFixDOs = new HashMap<String, List<PriSrvSetFixDO>>();
		if (allpPiSrvSetFixDOs != null && allpPiSrvSetFixDOs.length > 0) {
			for (PriSrvSetFixDO item : allpPiSrvSetFixDOs) {
				if (mapPriSrvSetFixDOs.containsKey(item.getId_srvset())) {
					mapPriSrvSetFixDOs.get(item.getId_srvset()).add(item);
				} else {
					List<PriSrvSetFixDO> lst = new ArrayList<PriSrvSetFixDO>();
					lst.add(item);
					mapPriSrvSetFixDOs.put(item.getId_srvset(), lst);
				}
			}
		}
		
		PriSrvCompDO[] allPriSrvCompDOs = getPriSrvCompDOs(strIdsrvs.substring(1));
		Map<String, List<PriSrvCompDO>> mapPriSrvCompDOs = new HashMap<String, List<PriSrvCompDO>>();
		if (allPriSrvCompDOs != null && allPriSrvCompDOs.length > 0) {
			for (PriSrvCompDO item : allPriSrvCompDOs) {
				if (mapPriSrvCompDOs.containsKey(item.getId_srv())) {
					mapPriSrvCompDOs.get(item.getId_srv()).add(item);
				} else {
					List<PriSrvCompDO> lst = new ArrayList<PriSrvCompDO>();
					lst.add(item);
					mapPriSrvCompDOs.put(item.getId_srv(), lst);
				}
			}
		}
		
		for (String id_srv : new ArrayList<>(id_srvs)) {
			MedSrvDO meSrvDO = (MedSrvDO) mapMeSrvDOs_Checked.get(id_srv);
			if (null == meSrvDO.getFg_set() || !meSrvDO.getFg_set().booleanValue()) {
				judgeSrvBL_Srv(meSrvDO, id_srv, mapPriSrvCompDOs.get(id_srv)==null?null:mapPriSrvCompDOs.get(id_srv).toArray(new PriSrvCompDO[]{}));
			} else {
				judgeSrvBL_Srvset(meSrvDO, id_srv, mapMedSrvSetItemDOs.get(id_srv)==null?null:mapMedSrvSetItemDOs.get(id_srv).toArray(new MedSrvSetItemDO[]{}), 
						mapPriSrvSetMuDOs.get(id_srv)==null?null:mapPriSrvSetMuDOs.get(id_srv).toArray(new PriSrvSetMuDO[]{}), mapPriSrvSetFixDOs.get(id_srv)==null?null:mapPriSrvSetFixDOs.get(id_srv).toArray(new PriSrvSetFixDO[]{}));
			}
		}
	}

	/**
	 * 非套服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srv(MedSrvDO meSrvDO, String id_srv, PriSrvCompDO[] priSrvCompDOs) throws BizException {
		boolean b = true;
		if (meSrvDO.getSd_primd() == null) {
			return b;
		}
		switch (meSrvDO.getSd_primd()) {
		case IBdPrimdCodeConst.CODE_PRI_SRV:
			b = judgeSrvBL_Srv_This(meSrvDO, id_srv);
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRV_COMP:
			b = judgeSrvBL_Srv_Comp(priSrvCompDOs, id_srv, meSrvDO.getName());
			break;
		case IBdPrimdCodeConst.CODE_PRI_FREE:
			break;
		case IBdPrimdCodeConst.CODE_PRI_PLUGIN:
			break;
		case IBdPrimdCodeConst.CODE_PRI_RES:
			break;
		}
		return b;
	}

	/**
	 * 本服务定价服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @return
	 */
	private boolean judgeSrvBL_Srv_This(MedSrvDO meSrvDO, String id_srv) {
		if (meSrvDO.getDs().equals(1)) {
			mapResult.put(id_srv, String.format(STR_SRV_BL_VAL, meSrvDO.getName()));
			mapMeSrvDOs_Checked.remove(id_srv);
			return false;
		}
		return true;
	}

	/**
	 * 组合计价服务费用校验
	 * 
	 * @param id_srv_itm
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srv_Comp(PriSrvCompDO[] priSrvCompDOs, String id_srv, String name) throws BizException {
		ArrayList<String> id_srv_bls = new ArrayList<String>();
		if (null != priSrvCompDOs && 0 < priSrvCompDOs.length) {
			for (PriSrvCompDO priSrvCompDO : priSrvCompDOs)
				id_srv_bls.add(priSrvCompDO.getId_srv_bl());
		}
		
		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_bls);
	}

	/**
	 * 套服务费用校验
	 * 
	 * @param meSrvDO
	 * @param id_srv
	 * @throws BizException
	 */
	private void judgeSrvBL_Srvset(MedSrvDO meSrvDO, String id_srv, MedSrvSetItemDO[] medSrvSetItemDOs, PriSrvSetMuDO[] priSrvSetMuDOs, PriSrvSetFixDO[] priSrvSetFixDOs) throws BizException {
		boolean isAmount = false;
		switch (meSrvDO.getSd_primd()) {
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_AMOUNT:// 成员合计
			isAmount = true;
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_MU:// 个数加收
			if (!judgeSrvBL_Srvset_Mu(id_srv, meSrvDO.getName(), priSrvSetMuDOs))
				return;
			break;
		case IBdPrimdCodeConst.CODE_PRI_SRVSET_FIX:// 个数定价
			if (!judgeSrvBL_Srvset_Fix(id_srv, meSrvDO.getName(), priSrvSetFixDOs))
				return;
			break;
		}

		ArrayList<String> id_srv_itms = new ArrayList<String>();
		for (MedSrvSetItemDO medSrvSetItemDO : medSrvSetItemDOs) {
			if (isAmount)
				id_srv_itms.add(medSrvSetItemDO.getId_srv_itm());
			else {
				// 非临床项目明细
				if (null == medSrvSetItemDO.getFg_clinical() || !medSrvSetItemDO.getFg_clinical().booleanValue())
					id_srv_itms.add(medSrvSetItemDO.getId_srv_itm());
			}
		}
		if (0 < id_srv_itms.size()) {
			
			String strIdsrvs = "";
			for (String id_srv_itm : id_srv_itms) {
				strIdsrvs += ",'" + id_srv_itm + "'";
			}
			PriSrvCompDO[] allPriSrvCompDOs = getPriSrvCompDOs(strIdsrvs.substring(1));
			Map<String, List<PriSrvCompDO>> mapPriSrvCompDOs = new HashMap<String, List<PriSrvCompDO>>();
			if (allPriSrvCompDOs != null && allPriSrvCompDOs.length > 0) {
				for (PriSrvCompDO item : allPriSrvCompDOs) {
					if (mapPriSrvCompDOs.containsKey(item.getId_srv())) {
						mapPriSrvCompDOs.get(item.getId_srv()).add(item);
					} else {
						List<PriSrvCompDO> lst = new ArrayList<PriSrvCompDO>();
						lst.add(item);
						mapPriSrvCompDOs.put(item.getId_srv(), lst);
					}
				}
			}
			
			// 获取校验数据集合
			MedSrvDO[] itmMeSrvDOs = getMedSrvDOs(id_srv_itms.toArray(new String[id_srv_itms.size()]));
			if (null != itmMeSrvDOs && 0 < itmMeSrvDOs.length) {
				for (MedSrvDO itmMeSrvDO : itmMeSrvDOs) {
					if (!judgeSrvBL_Srv(itmMeSrvDO, id_srv, 
							mapPriSrvCompDOs.get(id_srv)==null?null:mapPriSrvCompDOs.get(itmMeSrvDO.getId_srv()).toArray(new PriSrvCompDO[]{})))
						return;
				}
			}
		}
	}

	/**
	 * 套服务个数加收计价费用校验
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_Mu(String id_srv, String name, PriSrvSetMuDO[] priSrvSetMuDOs) throws BizException {
		ArrayList<String> id_srv_mus = new ArrayList<String>();
		if (null != priSrvSetMuDOs && 0 < priSrvSetMuDOs.length) {
			for (PriSrvSetMuDO priSrvSetMuDO : priSrvSetMuDOs) {
				id_srv_mus.add(priSrvSetMuDO.getId_srvadd());
			}
		}
		
		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_mus);
	}

	/**
	 * 套服务个数定价费用校验
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_Fix(String id_srv, String name, PriSrvSetFixDO[] priSrvSetFixDOs) throws BizException {
		ArrayList<String> id_srv_fixs = new ArrayList<String>();
		if (null != priSrvSetFixDOs && 0 < priSrvSetFixDOs.length) {
			for (PriSrvSetFixDO priSrvSetFixDO : priSrvSetFixDOs) {
				id_srv_fixs.add(priSrvSetFixDO.getId_srvadd());
			}
		}
		
		return judgeSrvBL_Srvset_item(id_srv, name, id_srv_fixs);
	}

	/**
	 * 费用项目停用校验
	 * @param id_srv
	 * @param name
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	private boolean judgeSrvBL_Srvset_item(String id_srv, String name, ArrayList<String> id_srvs) throws BizException {
		if (0 < id_srvs.size()) {
			MedSrvDO[] blMeSrvDOs = getMedSrvDOs(id_srvs.toArray(new String[id_srvs.size()]));
			if (null != blMeSrvDOs && 0 < blMeSrvDOs.length) {
				for (MedSrvDO blMeSrvDO : blMeSrvDOs) {
					if (blMeSrvDO.getDs().equals(1)) {
						mapResult.put(id_srv, String.format(STR_SRV_BL_VAL, name));
						mapMeSrvDOs_Checked.remove(id_srv);
						return false;
					}
					id_srvs.remove(blMeSrvDO.getId_srv());
				}
			}
		}
		if (0 < id_srvs.size()) {
			mapResult.put(id_srv, String.format(STR_SRV_BL_VAL, name));
			mapMeSrvDOs_Checked.remove(id_srv);
			return false;
		}

		return true;
	}

	/**
	 * 医疗服务
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getMedSrvDOs(String[] ids) throws BizException {
		MedSrvDO[] rtn = null;
		if (ids != null && ids.length > 0) {			
			GetMedSrvDOsQry qry = new GetMedSrvDOsQry(ids);
			rtn = (MedSrvDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvDO.class);
		}

		return rtn;
	}

	/**
	 * 物品
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private MeterialDO[] getMeterialDOs(String id_srvs) throws BizException {
		IMeterialMDORService meterialMDORService = (IMeterialMDORService) ServiceFinder
				.find(IMeterialMDORService.class);
		MeterialDO[] meterialDOs = meterialMDORService.find(" id_srv in (" + id_srvs + ")", "", FBoolean.FALSE);
		return meterialDOs;
	}

	/**
	 * 服务套内项目
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private MedSrvSetItemDO[] getMedSrvSetItemDOs(String id_srvs) throws BizException {
		IMedSrvSetItemDORService medSrvSetItemDORService = (IMedSrvSetItemDORService) ServiceFinder
				.find(IMedSrvSetItemDORService.class);
		MedSrvSetItemDO[] medSrvSetItemDOs = medSrvSetItemDORService.find(" id_srv in (" + id_srvs + ")", "",
				FBoolean.FALSE);
		return medSrvSetItemDOs;
	}

	/**
	 * 组合计价策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvCompDO[] getPriSrvCompDOs(String id_srvs) throws BizException {
		IPrisrvcompRService prisrvcompRService = (IPrisrvcompRService) ServiceFinder.find(IPrisrvcompRService.class);
		PriSrvCompDO[] priSrvCompDOs = prisrvcompRService.find(" id_srv in (" + id_srvs + ")", "", FBoolean.FALSE);
		return priSrvCompDOs;
	}

	/**
	 * 服务套个数加收策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvSetMuDO[] getPriSrvSetMuDOs(String id_srvs) throws BizException {
		IPrisrvsetmuRService prisrvsetmuRService = (IPrisrvsetmuRService) ServiceFinder
				.find(IPrisrvsetmuRService.class);
		PriSrvSetMuDO[] priSrvSetMuDOs = prisrvsetmuRService.find(" id_srvset in (" + id_srvs + ")", "", FBoolean.FALSE);
		return priSrvSetMuDOs;
	}

	/**
	 * 服务套个数定价策略
	 * 
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private PriSrvSetFixDO[] getPriSrvSetFixDOs(String id_srvs) throws BizException {
		IPrisrvsetfixRService prisrvsetfixRService = (IPrisrvsetfixRService) ServiceFinder
				.find(IPrisrvsetfixRService.class);
		PriSrvSetFixDO[] priSrvSetFixDOs = prisrvsetfixRService.find(" id_srvset in (" + id_srvs + ")", "", FBoolean.FALSE);
		return priSrvSetFixDOs;
	}

	/**
	 * 获取就诊类型相关字段
	 * 
	 * @param code_entp 就诊类型
	 * @param strName
	 * @return
	 */
	private ArrayList<String> getMethodNames(String code_entp, String strName) {
		ArrayList<String> fieldnames = new ArrayList<String>();
		switch (code_entp) {
		case IEnDictCodeConst.SD_ENTP_OUTPATIENT:
			fieldnames.add(strName + "_op");
			break;
		case IEnDictCodeConst.SD_ENTP_EMERGENCY:
			fieldnames.add(strName + "_er");
			break;
		case IEnDictCodeConst.SD_ENTP_INPATIENT:
			fieldnames.add(strName + "_ip");
			break;
		case IEnDictCodeConst.SD_ENTP_HOME:
			fieldnames.add(strName + "_fm");
			break;
		case IEnDictCodeConst.SD_ENTP_PHYSICALEXAM:
			fieldnames.add(strName + "_pe");
			break;

		}

		return fieldnames;
	}
}
