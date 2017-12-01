package iih.ci.ord.s.ems.biz.op.emsv1.ris.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvRisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrdocrefvalue.i.IMrdocrefvalueRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewDTO;
import iih.ci.ord.dto.ems.uiemsdto.d.EmsRisViewItemDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvSetItemList;
import iih.ci.ord.s.ems.biz.meta.BdSrvSetItemMap;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSetCreateBP;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils.IBdSrvPriCalParamFrom;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
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
		MedSrvDO medSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findById(ems.getId_srv());
		if (CiOrdUtils.isEmpty(medSrvInfo)) {
			throw new BizException("查询主服务信息失败！", CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsRisViewDTO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		if(null == emsModel) {
			emsModel = emsModelFrom(ems.getEnContext(),medSrvInfo);
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(), emsModel);
		}
		
		// 计划检查时间
		emsModel.setDt_plan(CiOrdAppUtils.getServerDateTime());
		
		// 检查申请单号
		emsModel.setNo_applyform(CiOrdUtils.getApplyNo(medSrvInfo.getSd_srvtp()));
	
		// 临床病症及体征内容拼接,住院部门界面没有显示，所以不给赋值只在门诊中赋值，移回到门诊中2017-2-27
		emsModel.setClinicalzztz(clinicalzztzFrom(ems.getEnContext()));
		
		// 诊断id
		DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ems.getEnContext().getId_en());
		if (diagOutlineInfo != null) {
			emsModel.setId_di(diagOutlineInfo.getId_di());// 主诊断的主项目id
//			emsModel.setId_diitm(diagOutlineInfo.getId_diitm());// 主诊断id
			emsModel.setName_di(diagOutlineInfo.getName_diag());// 主诊断名称
//			emsModel.setStr_code_di(diagOutlineInfo.getStr_code_di());// 诊断编码拼接
//			emsModel.setStr_name_di(diagOutlineInfo.getStr_name_di());// 诊断名称拼接
//			emsModel.setStr_id_diitm(diagOutlineInfo.getStr_id_diitm());// 诊断子项目id拼接
			
			OrderEmsExtInfoUtils.SetDiInfo(rst, diagOutlineInfo.toFMap());
		}

		// 获取价格 费用域不抛出异常，所以做一下异常处理
		MedSrvPriceDO medSrvPriceDO = OrderEmsPriceUtils.CalculatePrice(
				medSrvInfo,
				ems.getEnContext().getEnt4BannerDTO().getId_pripat(), 
				emsModel.getEmsrisviewitems(),
				new IBdSrvPriCalParamFrom(){
					public FArrayList getBdSrvPriCalParamList(FArrayList emsOrObsList){
						FArrayList bdSrvPriCalParamList = new FArrayList();
						for (Object obLap : emsOrObsList) {
							EmsRisViewItemDTO lap = (EmsRisViewItemDTO) obLap;
							if (CiOrdUtils.isTrue(lap.getFg_check())) {
								
								BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
								param.setId_srv(lap.getId_srv());
								param.setId_primd(lap.getId_primd());
								param.setNum(1);
								bdSrvPriCalParamList.add(param);
							}
						}
						return bdSrvPriCalParamList;
				}
		});
		
		if (CiOrdUtils.isEmpty(medSrvPriceDO)){
			emsModel.setPrice(medSrvPriceDO.getPrice_ratio());
			emsModel.setPrice_ratio(medSrvPriceDO.getRatio());
			emsModel.setPrice_std(medSrvPriceDO.getPrice_std());
		}
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), medSrvInfo, "", "");
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_dep_mp(wf.getFirstid_mp_dept());
		emsModel.setName_dep_mp(wf.getFirstname_mp_dept());
		emsModel.setFilter_dep_mp(wf.getId_mp_depts());

		rst.setDocument(this.handleReturnDocument(emsModel));
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
	private EmsRisViewDTO emsModelFrom(CiEnContextDTO ctx, MedSrvDO med) throws BizException {
		EmsRisViewDTO ems = new EmsRisViewDTO();
		
		// 医嘱服务id
//		ems.setId_orsrv("");
		// 医嘱医疗单
//		ems.setId_or("");
		// 服务id
		ems.setId_srv(med.getId_srv());
		// 服务名称
		ems.setName_srv(med.getName());
		// 服务类型
		ems.setSd_srvtp(med.getSd_srvtp());
		// 计价模式
//		ems.setId_primd(med.getId_primd());
		
		// 检查申请单号
		ems.setNo_applyform(CiOrdUtils.getApplyNo(med.getSd_srvtp()));

		// 计划检查时间
		ems.setDt_plan(CiOrdAppUtils.getServerDateTime());
		// 服务套
		ems.setFg_set(med.getFg_set());

		// 检查目的编码
		String key_pps = String.format("%s-%s", UdidocDO.ID_UDIDOCLIST,"@@@@ZZ20000000000075");
		UdidocDO udidocDO = this.getCache(L1SessionKeyWith(ctx), key_pps);
		if (CiOrdUtils.isEmpty(udidocDO)){
			UdidocDO[] szUdidocDO = ServiceFinder.find(IUdidocRService.class).findByAttrValString(UdidocDO.ID_UDIDOCLIST, "@@@@ZZ20000000000075");//.find("id_udidoclist ='@@@@ZZ20000000000075'",
			assert !CiOrdUtils.isEmpty(szUdidocDO) : "在数据库查询检查目的失败";
			udidocDO = !CiOrdUtils.isEmpty(szUdidocDO)? szUdidocDO[0]:null;
			if (!CiOrdUtils.isEmpty(udidocDO)){
				this.putCache(L1SessionKeyWith(ctx), key_pps, udidocDO);
			}
		}	
		if (CiOrdUtils.isEmpty(udidocDO)) {
			ems.setSd_pps(udidocDO.getCode());
			ems.setId_pps(udidocDO.getId_udidoc());
			// 检查目的描述
			ems.setDes_pps(udidocDO.getName());
		} else { 
			ems.setSd_pps(ICiDictCodeConst.Sd_CI_OBS_OBJECTIVE);
			ems.setId_pps(ICiDictCodeConst.Id_CI_OBS_OBJECTIVE);
			// 检查目的描述
			ems.setDes_pps(ICiDictCodeConst.NAME_OBS_OBJECTIVE);
		}

		FArrayList listEmsRisItemInfo = new FArrayList();
		if (CiOrdUtils.isTrue(med.getFg_set())) {
			// 服务套
			MedSrvSetItemDO[] szMedSrvSetItem = BdSrvInfoUtils.QueryMedSrvSetItemBy(med.getId_srv(), true);
			assert !CiOrdUtils.isEmpty(szMedSrvSetItem):String.format("服务套【%s】没有维护套内项目", med.getName());
			if (CiOrdUtils.isEmpty(szMedSrvSetItem)){
				throw new BizException (String.format("服务套【%s】套内项目为空，请在基础数据节点进行维护", med.getName()));
			}

			BdSrvSetItemList bdSrvSetItemList = new BdSrvSetItemList(szMedSrvSetItem);
			BdSrvSetItemMap bdSrvSetItemCache = bdSrvSetItemList.asMap();
			// 获取套内项目的基础服务定义信息
			MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(bdSrvSetItemList.asIdSrvArray(), FBoolean.FALSE);
			for (MedSrvDO bdSrvInfo : szMedSrvInfo){
				
				listEmsRisItemInfo.add(emsRisViewItemInfoFrom(ctx,bdSrvInfo,bdSrvSetItemCache.get(bdSrvInfo.getId_srv())));
			}
		} 
		else {
			listEmsRisItemInfo.add(emsRisViewItemInfoFrom(ctx,med));
		}

		ems.setEmsrisviewitems(listEmsRisItemInfo);

		return ems;
	}
	
	/**
	 * 非套项目时候，明细对象中的信息
	 * @param ctx
	 * @param bdSrvInfo
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewItemDTO emsRisViewItemInfoFrom(CiEnContextDTO ctx, MedSrvDO bdSrvInfo) throws BizException{
		MedSrvRisDO[] szMedSrvRisDO = ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValString(MedSrvRisDO.ID_SRV, bdSrvInfo.getId_srv());
		EmsRisViewItemDTO emsRisViewItemInfo = new EmsRisViewItemDTO();
		emsRisViewItemInfo.setStatus(DOStatus.NEW);
		emsRisViewItemInfo.setFg_edit(FBoolean.FALSE);
		emsRisViewItemInfo.setFg_check(FBoolean.TRUE);
		emsRisViewItemInfo.setId_srv(bdSrvInfo.getId_srv());
		emsRisViewItemInfo.setName_srv(bdSrvInfo.getName());
		emsRisViewItemInfo.setId_primd(bdSrvInfo.getId_primd());
		emsRisViewItemInfo.setId_body(szMedSrvRisDO[0].getId_body());
		emsRisViewItemInfo.setName_body(szMedSrvRisDO[0].getName_body());
		emsRisViewItemInfo.setSd_body(szMedSrvRisDO[0].getSd_body());
		emsRisViewItemInfo.setId_pos(szMedSrvRisDO[0].getId_pos());
		emsRisViewItemInfo.setName_pos(szMedSrvRisDO[0].getName_pos());
		emsRisViewItemInfo.setSd_pos(szMedSrvRisDO[0].getSd_pos());
		
		return emsRisViewItemInfo;
	}
	
	/**
	 * 服务套时候，构建明细项目中的信息
	 * @param ctx
	 * @param bdSrvInfo
	 * @param medSrvSetItemDO
	 * @return
	 * @throws BizException
	 */
	protected EmsRisViewItemDTO emsRisViewItemInfoFrom(CiEnContextDTO ctx, MedSrvDO bdSrvInfo, MedSrvSetItemDO medSrvSetItemDO) throws BizException{
		MedSrvRisDO[] szMedSrvRisDO = ServiceFinder.find(IMedSrvRisDORService.class).findByAttrValString(MedSrvRisDO.ID_SRV, bdSrvInfo.getId_srv());
		EmsRisViewItemDTO emsRisViewItemInfo = new EmsRisViewItemDTO();
		emsRisViewItemInfo.setStatus(DOStatus.NEW);
		
		emsRisViewItemInfo.setFg_edit(medSrvSetItemDO.getFg_edit());
		// 非单选模式的时候，该标志的状态与可编辑标志相关；否则，都不默认勾选（换句话说，只有必选的才会默认勾选）
		emsRisViewItemInfo.setFg_check(new FBoolean(!CiOrdUtils.isTrue(bdSrvInfo.getFg_setradio())?!CiOrdUtils.isTrue(emsRisViewItemInfo.getFg_edit()):false));
		emsRisViewItemInfo.setId_srv(bdSrvInfo.getId_srv());
		emsRisViewItemInfo.setName_srv(bdSrvInfo.getName());
		emsRisViewItemInfo.setId_primd(bdSrvInfo.getId_primd());
		emsRisViewItemInfo.setId_body(szMedSrvRisDO[0].getId_body());
		emsRisViewItemInfo.setName_body(szMedSrvRisDO[0].getName_body());
		emsRisViewItemInfo.setSd_body(szMedSrvRisDO[0].getSd_body());
		emsRisViewItemInfo.setId_pos(szMedSrvRisDO[0].getId_pos());
		emsRisViewItemInfo.setName_pos(szMedSrvRisDO[0].getName_pos());
		emsRisViewItemInfo.setSd_pos(szMedSrvRisDO[0].getSd_pos()); 
		emsRisViewItemInfo.setStatus(DOStatus.NEW);
		
		return emsRisViewItemInfo;
	}
	
	/**
	 * 临床体征拼接字符串
	 * @param id_ent
	 * @return
	 * @throws BizException
	 */
	public String clinicalzztzFrom(CiEnContextDTO ctx) throws BizException {
		// 临床症状和体征
		StringBuffer clinialBuffer = new StringBuffer();

		String key_clinicalzztz = String.format("%s-%s", MrDocRefValueDO.class.getName(),ctx.getId_en());
		MrDocRefValueDO[] szMrDocRefValueDO = getCache(L1SessionKeyWith(ctx), key_clinicalzztz);
		if (CiOrdUtils.isEmpty(szMrDocRefValueDO)){
			IMrdocrefvalueRService mrdocservice = ServiceFinder.find(IMrdocrefvalueRService.class);
			String sql = String.format("id_ent='%s' and code_element in ('%s','%s','%s')", 
					ctx.getId_en(),
					ICiDictCodeConst.CODE_ELEMENT_MAINSUIT, ICiDictCodeConst.CODE_ELEMENT_NOWDISEASE,
					ICiDictCodeConst.CODE_ELEMENT_TEST);
	
			szMrDocRefValueDO = mrdocservice.find(sql, "", FBoolean.FALSE);
			if (!CiOrdUtils.isEmpty(szMrDocRefValueDO)){
				putCache(L1SessionKeyWith(ctx), key_clinicalzztz, szMrDocRefValueDO);
			}
		}
		if (!CiOrdUtils.isEmpty(szMrDocRefValueDO)) {
			
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
