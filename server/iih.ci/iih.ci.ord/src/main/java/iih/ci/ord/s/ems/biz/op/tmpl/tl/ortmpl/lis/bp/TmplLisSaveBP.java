package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.lis.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.lis.bp.EmsLisSaveBP;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplDetailList;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
/**
 * 检验医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class TmplLisSaveBP extends EmsLisSaveBP {

	public TmplLisSaveBP(IEmsValidate iv) {
		super(iv);
		
	}
	
	@Override
	protected int GetSrvObjStatus(Object objDO) {
		return DOStatus.NEW;
	}

	/**
	 * 根据模板列表信息组织默认医嘱创建参数集合
	 * @param listUiModel 模板数据集合
	 * @return 默认医嘱创建参数集合
	 * @throws BizException
	 */
	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		for (Object uiModel : listUiModel){
			OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
			// 基础服务信息列表
			BdSrvMmInfoList bdSrvInfoList = new BdSrvMmInfoList();
			for (OrTplNItmDO tmplInfo : detailList){
				
				BdSrvMmInfo bsmi = new BdSrvMmInfo(tmplInfo);
				if (bsmi.createSrvMmInfo(
						tmplInfo.getId_srv(), 
						this.getEnContextInfo().getId_org(), 
						this.getEnContextInfo().getId_dep_or())){
					bdSrvInfoList.add(bsmi);
				}
		}
			
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvInfoList,detailList));
		}
		
		return listDefaultCreateParam.asArray();
	}

	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index){
			EmsObsItemDO itemDO = (EmsObsItemDO)listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}
	

	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		// 组装映射表
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		EmsObsItemDO doInfo = (EmsObsItemDO)uiModel;
		
		o.put(doInfo.getId_orsrv(), doInfo);
		
		return o;
	}

	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);
				
				if (objAppSheetInfo instanceof OrdApLabDO) { // 检验申请单保存
					OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisService().save(
							opInfo.getOrderAppSheetList().toArray(new OrdApLabDO[opInfo.getOrderAppSheetList().size()]));
					int i = 0;
				}
			}
		}

		return szInnerOrderSaveInfo;
	}
	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		// 检验申请单保存
		OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisQryService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szOrdApLabDO)){
			return szOrdApLabDO;
		}
		return null;
	}

	
	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * @param objInfo
	 * @return
	 */
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo){
		SrvKey2UiModelMap o= new SrvKey2UiModelMap();
		// 转换医疗单UI模型
		EmsObsItemDO ems = (EmsObsItemDO)objInfo;
		for(Object obsLapInfo:ems.getEmsOrObsListEx()){
			EmsObsLap itemdo=(EmsObsLap)obsLapInfo;
			// 过滤逻辑删除的套内临床项目
			if(itemdo.getStatus()!=DOStatus.DELETED){
				o.put(itemdo.getId_srv(), obsLapInfo);
			}
		}
		return o;
	}


	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		OrderTmplDetailList ems = (OrderTmplDetailList)uiModel;
		OrTplNItmDO drugItem = ems.get(0);
		// 医嘱内容
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), ems.asSrvNameArray()[0], orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		// 使用天数
		orderInfo.setDays_or(drugItem.getDays_or());
		// 开立时间
		orderInfo.setDt_entry(tm);
		// 
		//FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),tm,tm,drugItem.getDays_or());
		// 生效时间
		orderInfo.setDt_effe(tm);
		// 过期时间
		orderInfo.setDt_end(tm);
		// 医嘱描述
		orderInfo.setDes_or(drugItem.getDes_or());
		// 处理医嘱停止时间等相关信息
		if (FBoolean.TRUE.equals(orderInfo.getFg_long())
				&& orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}
		// 计算总次数
				GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
				Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), drugItem.getDays_or());
				orderInfo.setTimes_cur(totalTimes);
		// 处理在院执行信息
		if(FBoolean.TRUE.equals(orderInfo.getFg_mp_in())){
			orderInfo.setTimes_mp_in(totalTimes);
		}
		// 待删除字段信息
		//orderInfo.setFuncclassstr(ems.getFuncclassstr());
		orderInfo.setId_srvof(ems.getId_ems());
		// 申请单号
		orderInfo.setApplyno(CiOrdUtils.getApplyNo(drugItem.getSd_srvtp()));
		// 最近执行时间
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,orderInfo.getFg_long()));
		
		
		// 执行闭环
		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环
		// 执行科室
		orderInfo.setId_dep_mp(drugItem.getId_dep_mp());
		// 最后执行时间
		orderInfo.setDt_last_mp(tm);
		// 状态
		orderInfo.setStatus(DOStatus.NEW);

	}
	
	

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
	}
	
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
		OrTplNItmDO srvdto=detailList.get(0);
		for(Object obj:appSheetList){
			OrdApLabDO ordlis=(OrdApLabDO)obj;
			//ordlis.setId_or(srvdto.getId_or());
//			ordlis.setId_di(srvdto.getId_di());//临床诊断	
//			ordlis.setId_diitm(srvdto.getId_diitm());//临床诊断子项
//			ordlis.setStr_id_diitm(srvdto.getStr_id_diitm());//临床诊断明细
//			ordlis.setStr_code_di(srvdto.getStr_code_di());//诊断编码拼接
//			ordlis.setStr_name_di(srvdto.getStr_name_di());//诊断名称拼接
//			ordlis.setNo_applyform(srvdto.getNo_applyobs());//申请单号	
//			ordlis.setId_srvca(srvdto.getId_srvca());//检验分类	
//			ordlis.setSd_pps(srvdto.getSd_pps());//检验目的编码
//			ordlis.setDt_plan(srvdto.getDt_plan());//计划检验日期
//			ordlis.setId_pps(srvdto.getId_pps());//检验目的	
//			ordlis.setDes_pps(srvdto.getDes_pps());//检验目的描述	
//			ordlis.setDes_sympsign(srvdto.getDes_sympsign());//病情描述	
//			ordlis.setClinicalzztz(srvdto.getClinicalzztz());//临床症状及体征
//			ordlis.setPastillness(srvdto.getPastillness());//既往病史 
//			ordlis.setAuximtexam(srvdto.getAuximtexam());//其它检查所见 
//			ordlis.setAnnouncements(srvdto.getAnnouncements());//注意事项 
//			ordlis.setFg_urgent(srvdto.getFg_urgent());//加急标识	 
//			ordlis.setSd_samptp(srvdto.getSd_samptp());//标本类型	
//			ordlis.setName_samptp(srvdto.getName_samptp());//标本类型	
//			ordlis.setId_samptp(srvdto.getId_samptp());//标本类型编码	 
//			ordlis.setSd_colltp(srvdto.getSd_colltp());//采集方法	 
//			ordlis.setId_colltp(srvdto.getId_colltp());//采集方法编码	 
//			ordlis.setDes_labsamp(srvdto.getDes_labsamp());//标本说明	 	
//			ordlis.setId_unit_quan(srvdto.getId_unit_sampcoltime());//需求数量单位	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a0b14
//			ordlis.setName_diag(srvdto.getName_diag());//诊断名称		 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
//			ordlis.setId_sampcoltime(srvdto.getId_sampcoltime());//标本采集时间	REF	标本
//			ordlis.setId_sampcollecttimetp(srvdto.getId_sampcollecttimetp());//标本采集时间类型	
//			ordlis.setSd_sampcollecttimetp(srvdto.getSd_sampcollecttimetp());//标本采集时间类型编码
//			ordlis.setLen_sampcoltime(srvdto.getLen_sampcoltime());//标本采集时长	SINGLE	
//			ordlis.setId_unit_sampcoltime(srvdto.getId_unit_sampcoltime());//标本采集时间时长单位
//			ordlis.setStatus(srvdto.getStatus());
		}
	}


}
