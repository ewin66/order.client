package iih.ci.ord.s.ems.biz.op.ems.ris.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSetCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 检查医疗单创建逻辑
 * @author wangqingzhu
 *
 */
public class EmsRisCreateBP extends EmsSetCreateBP {

	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsObsItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()),
				ems.getId_srv());;
		if(null == emsModel) {
			emsModel = emsModelFrom(aggDO.getParentDO());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(), emsModel);
		}
		emsModel.setStatus(DOStatus.NEW);
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm); // SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));
			// 计划检查时间
			emsModel.setDt_plan(tm);
			// 检查申请单号
			emsModel.setNo_applyobs(CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()));
		}

		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ems.getEnContext().getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsModel.setName_diag(diagOutlineInfo.getName_diag());// 主诊断名称
			emsModel.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
			emsModel.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
			emsModel.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
			
			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 临床病症及体征内容拼接,住院部门界面没有显示，所以不给赋值只在门诊中赋值，移回到门诊中2017-2-27
		emsModel.setClinicalzztz(clinicalzztzFrom(ems.getEnContext().getId_en()));

		// 获取价格 费用域不抛出异常，所以做一下异常处理
		MedSrvPriceDO medSrvPriceDO = null;
		try {
			medSrvPriceDO = OrderEmsPriceUtils.CalculatePrice(aggDO.getParentDO(),
					ems.getEnContext().getEnt4BannerDTO().getId_pripat(), emsModel.getEmsOrObsListEx());
		} catch (Exception e) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.append("获取服务价格失败：" + e.getMessage());
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}

		emsModel.setPrice(medSrvPriceDO.getPrice_ratio());
		emsModel.setPri_ratio(medSrvPriceDO.getRatio());
		emsModel.setPri_std(medSrvPriceDO.getPrice_std());
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(), "", "");
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.append("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
		emsModel.setName_mp_dep(wf.getFirstname_mp_dept());

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO());
		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.RIS.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}


	/**
	 * 构建医疗单模型
	 * @param med
	 * @return
	 * @throws BizException
	 */
	private EmsObsItemDO emsModelFrom(MedSrvDO med) throws BizException {
		EmsObsItemDO ems = new EmsObsItemDO();
		// 医嘱服务id
		ems.setId_orsrv("");
		// 医嘱医疗单
		ems.setId_or("");
		// 服务id
		ems.setId_srv(med.getId_srv());
		// 服务名称
		ems.setName_srv(med.getName());
		// 服务类型
		ems.setId_srvtp(med.getId_srvtp());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 是否多剂量
//		ems.setIsmuldose(FBoolean.TRUE);
		ems.setIsmuldose(med.getIsmuldose());
		// 是否多次执行
//		ems.setIsmulexec(FBoolean.TRUE);
		ems.setIsmulexec(med.getIsmulexec());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 计价模式
		ems.setId_primd(med.getId_primd());
		// 服务类型名称 -- 没有名称
		// headDo.Emsapobs.Name_srvtp ( med.Name);
		// 检查类型id
		ems.setId_obstp(med.getId_srv());
		// 检查类型名称
		ems.setName_obstp(med.getName());
		// 检查申请单号
		ems.setNo_applyobs(CiOrdUtils.getApplyNo(med.getSd_srvtp()));
		// 计划检查时间
		ems.setDt_plan(CiOrdAppUtils.getServerDateTime());
		// 剂量（单位）
		ems.setQuan_med(med.getQuan_med());
		ems.setId_unit_med(med.getId_unit_med());
		ems.setName_unit_med(med.getMed_name());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		//频次
		ems.setId_freq(med.getId_freq());
		ems.setName_freq(med.getFreq_name());
		ems.setFreqct(med.getFreqct());
		ems.setSd_frequnitct(med.getSd_frequnitct());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 使用天数
		ems.setUse_days(1);
		// 总次数
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(med.getId_freq(), ems.getUse_days());
		ems.setTimes_cur(totalTimes);
		// 开始结束时间
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		ems.setDt_begin_ui(tm);
		ems.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1), tm.getUFTime()));
		// 总量（单位）
		CalQuantumBP calQuantumBP = new CalQuantumBP();
		ems.setQuan_cur(calQuantumBP.getQuantum(med.getQuan_med(), ems.getTimes_cur()));
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		ems.setId_unit_sale(med.getId_unit_med());
		ems.setName_unit_sale(med.getMed_name());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111

		// 检查目的编码
		UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).find("id_udidoclist ='0001ZZ20000000000075'",
				"", FBoolean.FALSE);
		if (szUdidocDO != null && szUdidocDO.length > 0) {
			ems.setId_pps(szUdidocDO[0].getId_udidoc());
			ems.setSd_pps(szUdidocDO[0].getCode());
			// 检查目的描述
			ems.setDes_pps(szUdidocDO[0].getName());
		} else { // todo 暂时对应 需要修改
			ems.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);
			ems.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);
			// 检查目的描述
			ems.setDes_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);
		}

		// 服务套标识
		ems.setFg_set(med.getFg_set());
		MedsrvAggDO[] szMedSrvAggInfo = null;
		MedSrvSetItemDO[] szMedSrvSetItem = null;
		Map<String, MedSrvSetItemDO> tmpSetItemCacheMap = new HashMap<String, MedSrvSetItemDO>();
		if (CiOrdUtils.isTrue(med.getFg_set())) {
			// 服务套
			szMedSrvSetItem = GetItemInSet(med.getId_srv(), true);
			if (null == szMedSrvSetItem || szMedSrvSetItem.length == 0) {
				return ems;
			}
			MedSrvSetItemDO mainItem = null;
			List<String> listSrvId = new ArrayList<String>();

			for (MedSrvSetItemDO item : szMedSrvSetItem) {
				if (mainItem == null && ICiDictCodeConst.SD_SRVSETITEM_ROLE_MAIN.equals(item.getSd_srvsetrole())) {
					mainItem = item;
				}
				listSrvId.add(item.getId_srv_itm());
				tmpSetItemCacheMap.put(item.getId_srv_itm(), item);
			}
			// 获取套内项目的基础服务定义信息
			szMedSrvAggInfo = ServiceFinder.find(IMedsrvRService.class)
					.findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
		} else {
			szMedSrvAggInfo = new MedsrvAggDO[] { ServiceFinder.find(IMedsrvRService.class).findById(med.getId_srv()) };
		}
		if (szMedSrvAggInfo == null) {
			return ems;
		}

		int iNumber = 1;
		FArrayList setItemList = new FArrayList();
		for (MedsrvAggDO agg : szMedSrvAggInfo) {
			MedSrvRisDO[] szMedSrvRisDO = agg.getMedSrvRisDO();
			if (szMedSrvRisDO == null)
				continue;
			for (MedSrvRisDO ris : szMedSrvRisDO) {
				EmsObsLap obs = new EmsObsLap();
				if (szMedSrvSetItem != null && szMedSrvSetItem.length > 0) {
					if (tmpSetItemCacheMap.containsKey(ris.getId_srv())) {
						MedSrvSetItemDO item = tmpSetItemCacheMap.get(ris.getId_srv());
						obs.setFg_edit(item.getFg_edit());
						obs.setFg_or(item.getFg_clinical());
						obs.setQuan_medu(item.getQuan_medu());
						// 临床项目可选标志 = false, 选中标志 = true, 否则，全部 = false
						obs.setFg_chk(CiOrdUtils.isTrue(item.getFg_clinical())&&!CiOrdUtils.isTrue(item.getFg_edit())?FBoolean.TRUE:FBoolean.FALSE);
					}
				} else {
					obs.setFg_or(agg.getParentDO().getFg_or());
					obs.setFg_edit(FBoolean.FALSE);
					obs.setQuan_medu(agg.getParentDO().getQuan_med());
					obs.setFg_chk(FBoolean.TRUE);
				}
				// 新建时候默认全部选中
				
				obs.setId_srv(ris.getId_srv());
				obs.setCode_srv(agg.getParentDO().getCode());
				obs.setName_srv(agg.getParentDO().getName());
				obs.setId_srvtp(agg.getParentDO().getId_srvtp());
				obs.setSd_srvtp(agg.getParentDO().getSd_srvtp());
				obs.setId_srvca(agg.getParentDO().getId_srvca());
				
				obs.setId_primd(agg.getParentDO().getId_primd());
				obs.setFg_bl(agg.getParentDO().getFg_bl());
				obs.setDes_sympsign(ems.getDes_sympsign());
				obs.setFg_urgent(ems.getFg_urgent());
				
				// 部位可修改标识
				obs.setFg_body_update(ris.getFg_body_update());
				obs.setId_body(ris.getId_body());
				obs.setSd_body(ris.getSd_body());
				obs.setName_body(ris.getName_body());
				obs.setFg_pos(ris.getFg_pos());
				obs.setId_pos(ris.getId_pos());
				obs.setSd_pos(ris.getSd_pos());
				obs.setName_pos(ris.getName_pos());
				obs.setId_obstp(ris.getId_obstp());
				obs.setName_obstp(ris.getObstp_name());
				obs.setId_medu(agg.getParentDO().getId_unit_med());
				obs.setId_freq(agg.getParentDO().getId_freq());
				obs.setAnnouncements(ris.getNote());
				obs.setId_su_obs(ICiDictCodeConst.ID_CI_OBS_SQ);
				obs.setSd_su_obs(ICiDictCodeConst.SD_CI_OBS_SQ);
				obs.setEu_blmd(med.getEu_blmd());

				obs.setSortno(iNumber + "");
				iNumber++;
				setItemList.append(obs);
			}
		}

		ems.setEmsOrObsListEx(setItemList);

		return ems;
	}
	
	/**
	 * 获取套内项目集合
	 * @param id_srv
	 * @param is_clinical
	 * @return
	 * @throws BizException
	 */
	protected MedSrvSetItemDO[] GetItemInSet(String id_srv, boolean is_clinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class).find(
				String.format("a8.fg_clinical='%s' and a8.id_srv='%s' and a8.fg_active='Y'", is_clinical ? "Y" : "N", id_srv), "", FBoolean.FALSE);
	}
	
	/**
	 * 临床体征拼接字符串
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String clinicalzztzFrom(String id_ent) throws BizException {
		// 临床症状和体征
		StringBuffer clinialBuffer = null;

		IMrdocrefvalueRService mrdocservice = ServiceFinder.find(IMrdocrefvalueRService.class);
		String sql = String.format("id_ent='%s' and code_element in ('%s','%s','%s')", id_ent,
				ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE,
				ICiDictCodeConst.CODE_ELEMENT_TEST);

		MrDocRefValueDO[] szMrDocRefValueDO = mrdocservice.find(sql, "", FBoolean.FALSE);
		if (szMrDocRefValueDO != null && szMrDocRefValueDO.length > 0) {
			clinialBuffer = new StringBuffer();
			MrDocRefValueDO itemMainSuit = null, itemNowDise = null, itemTest = null;
			for (MrDocRefValueDO o : szMrDocRefValueDO) {
				// 主诉
				if (itemMainSuit == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_MAINSUIT)) {
					itemMainSuit = o;
				}
				// 现病史
				if (itemNowDise == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE)) {
					itemNowDise = o;
				}
				// 体格检查
				if (itemTest == null && o.getCode_element().equals(ICiDictCodeConst.CODE_ELEMENT_TEST)) {
					itemTest = o;
				}
			}
			if (itemMainSuit != null && !CiOrdUtils.isEmpty(itemMainSuit.getContent())) {
				clinialBuffer.append("以" + itemMainSuit.getContent() + "之主诉就诊。").append(System.lineSeparator());
			}

			if (itemNowDise != null && !CiOrdUtils.isEmpty(itemNowDise.getContent())) {
				clinialBuffer.append(itemNowDise.getContent()).append(System.lineSeparator());
			}

			if (itemTest != null && !CiOrdUtils.isEmpty(itemTest.getContent())) {
				clinialBuffer.append(itemTest.getContent());
			}
			return clinialBuffer.toString();
		}
		return null;
	}
}
