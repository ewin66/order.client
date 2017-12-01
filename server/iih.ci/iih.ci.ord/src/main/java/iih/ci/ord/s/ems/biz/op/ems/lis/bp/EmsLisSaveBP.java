package iih.ci.ord.s.ems.biz.op.ems.lis.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvLisDO;
import iih.bd.srv.medsrv.i.IMedSrvLisDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.i.ICiorapplisRService;
import iih.ci.ord.ciordems.d.EmsObsItemDO;
import iih.ci.ord.ciordems.d.EmsObsLap;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.ci.ord.s.ems.biz.itf.IEmsValidate;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParamList;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsSetSaveBP;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultLisCreateOrderInfo;
import iih.ci.ord.s.ems.biz.op.ems.lis.EmsLisValidate;
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
public class EmsLisSaveBP extends EmsSetSaveBP {

	public EmsLisSaveBP() {

		// 设置有效性检查
		setEmsValidate(new EmsLisValidate());
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultLisCreateOrderInfo());
	}
	
	public EmsLisSaveBP(IEmsValidate emsValidate) {

		// 设置有效性检查
		setEmsValidate(emsValidate);
		// 设置医嘱默认生成逻辑
		setDefaultCreateOrderInfo(new DefaultLisCreateOrderInfo());
	}
	
	
	@Override
	protected int GetSrvObjStatus(Object objDO) {
		return ((EmsObsItemDO)objDO).getStatus();
	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException {
		// 定义创建默认医嘱参数列表
		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		StringObjectMap som = new StringObjectMap();
		StringObjectMap srvKey2UiModelCache = new StringObjectMap();
		for (Object uiModel : listUiModel){
			EmsObsItemDO doInfo = (EmsObsItemDO)uiModel;
			som.put(doInfo.getId_srv(), uiModel);
			srvKey2UiModelCache.put(doInfo.getId_srv(), doInfo);
		}
		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		assert !CiOrdUtils.isEmpty(szMedSrvInfo) : "获取检验医疗单基础服务数据失败";
		for (MedSrvDO srvInfo : szMedSrvInfo){
			BdSrvMmInfoList bdSrvMmInfoList = new BdSrvMmInfoList();
			bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,srvKey2UiModelCache.get(srvInfo.getId_srv())));
			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvMmInfoList,som.get(srvInfo.getId_srv())));
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

				Object objAppSheetInfo = opInfo.getOrderAppSheetList().getFirstObject();

				if (objAppSheetInfo instanceof OrdApLabDO) { // 检验申请单保存
					OrdApLabDO[] szOrdApLabDO = CiOrdAppUtils.getOrapplisService().save(
							opInfo.getOrderAppSheetList().toArray(new OrdApLabDO[opInfo.getOrderAppSheetList().size()]));
					
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
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		OrderPackageInfo[] orderPakageInfos=super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		for(OrderPackageInfo opInfo:orderPakageInfos){
			String sd_samptp="";
			if(opInfo.isNew()){
				MedSrvLisDO[] srvlisdos= ServiceFinder.find(IMedSrvLisDORService.class).findByAttrValString("Id_srv",	opInfo.getBdSrvList().get(0).getId_srv());
				if(!CiOrdUtils.isEmpty(srvlisdos)){
					sd_samptp=srvlisdos[0].getSd_samptp();
				}
				
			}else{
				OrdApLabDO[] labdo=ServiceFinder.find(ICiorapplisRService.class).findByAttrValString("Id_or",opInfo.getOrderInfo().getId_or());
				if(!CiOrdUtils.isEmpty(labdo)){
					sd_samptp=labdo[0].getSd_samptp();
				}
			}
			
			OrdApLabDO labdo=(OrdApLabDO)opInfo.getOrderAppSheetList().get(0);
			if(!CiOrdUtils.isEmpty(sd_samptp) && !CiOrdUtils.isEmpty(labdo) && !sd_samptp.equals(labdo.getSd_samptp())){
				OrderSrvMmList delsrvmmList=new OrderSrvMmList();
				for(OrderSrvMmInfo srvmmInfo:opInfo.getOrderSrvMmList()){
					
					if(srvmmInfo.getOrderSrvInfo().getEu_sourcemd()==OrSrvSourceFromEnum.SPECIMENRELFEE
							||srvmmInfo.getOrderSrvInfo().getEu_sourcemd()==OrSrvSourceFromEnum.SPECIMENVESSELRELFEE){
						if(srvmmInfo.getOrderSrvInfo().getStatus()==DOStatus.NEW){
							//								opInfo.getOrderSrvMmList().remove(srvmmInfo);
							delsrvmmList.add(srvmmInfo);
						}else{
							srvmmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
						}

					}
					
				}
				if(delsrvmmList.size()>0){
					for(OrderSrvMmInfo srvmmInfo:delsrvmmList){
						opInfo.getOrderSrvMmList().remove(srvmmInfo);
					}
				}
				opInfo.getOrderSrvMmList().append(((DefaultLisCreateOrderInfo)this.getDefaultCreateOrderInfo()).specimenTpRelSrvHandle(opInfo,labdo.getSd_samptp(),labdo.getSd_contp(),ctx).asArray());
			}
		}
		return szOrderPakageInfo;
	}

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {

		EmsObsItemDO ems = (EmsObsItemDO)uiModel;
		// 医嘱内容
		orderInfo.setContent_or(CiOrContentUtils.create(orderInfo.getSd_srvtp(), ems.getName_srv(), orderInfo.getRoute_name(), FBoolean.FALSE).toString());
		// 开立时间
		orderInfo.setDt_entry(ems.getDt_plan());
		// 
		FDateTime[] dtSE = OrderUtils.getDtBeginEnd(ctx.getCode_entp(),ems.getDt_plan(),ems.getDt_plan(),ems.getUse_days());
		// 生效时间
		orderInfo.setDt_effe(dtSE[0]);
		// 过期时间
		orderInfo.setDt_end(dtSE[1]);
		// 医嘱描述
		orderInfo.setDes_or(ems.getDes_sympsign());
		// 处理医嘱停止时间等相关信息
		if (FBoolean.TRUE.equals(orderInfo.getFg_long())
				&& orderInfo.getDt_end() != null
				&& CiOrdUtils.MAX_SYS_DATETIME.after(orderInfo.getDt_end())) {
			orderInfo.setFg_stop(FBoolean.TRUE);
			orderInfo.setId_emp_stop(ctx.getId_emp_or());
			orderInfo.setId_dep_stop(ctx.getId_dep_or());
			orderInfo.setDt_stop(orderInfo.getDt_entry());
		}
		// 处理在院执行信息
		orderInfo.setFg_mp_in(FBoolean.TRUE);

		orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
		if(ems.getTimes_mp_in() != null){
			orderInfo.setTimes_mp_in(ems.getTimes_mp_in());
		}else{
			orderInfo.setTimes_mp_in(ems.getTimes_cur());
			ems.setTimes_mp_in(ems.getTimes_cur());
		}

		// 待删除字段信息
		orderInfo.setFuncclassstr(ems.getFuncclassstr());
		orderInfo.setId_srvof(ems.getId_srvof());
		// 申请单号
		orderInfo.setApplyno(ems.getApplyno());
		// 最近执行时间
		orderInfo.setDt_last_bl(OrderUtils.getLastDt(orderInfo.getId_freq(), orderInfo.getDt_effe(), 0,orderInfo.getFg_long()));
		// 总价
		orderInfo.setAmount(ems.getPrice());	
		// 执行闭环
		orderInfo.setId_orpltp(OrderUtils.getOrCLoopTpId(orderInfo));// 执行闭环
		// 执行科室
		orderInfo.setId_dep_mp(ems.getId_mp_dep());
		// 最后执行时间
		orderInfo.setDt_last_mp(dtSE[0]);
		// 状态
		orderInfo.setStatus(ems.getStatus());
		orderInfo.setNote_or(ems.getDes_sympsign());
		orderInfo.setApplyno(ems.getApplyno());

/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 频次
		orderInfo.setId_freq(ems.getId_freq());
		orderInfo.setFreq_name(ems.getName_freq());
		orderInfo.setFreqct(ems.getFreqct());
		orderInfo.setSd_frequnitct(ems.getSd_frequnitct());
		//剂量
		orderInfo.setQuan_medu(ems.getQuan_med());
		orderInfo.setId_unit_med(ems.getId_unit_med());
		orderInfo.setName_unit_med(ems.getName_unit_med());
		// 使用天数
		orderInfo.setDays_or(ems.getUse_days());
		// 计算总次数
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(orderInfo.getId_freq(), ems.getUse_days());
		orderInfo.setTimes_cur(totalTimes);
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
	}



	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO ordSrvInfo, Object uiModel) throws BizException {
		EmsObsItemDO srvdto = (EmsObsItemDO)uiModel;
		if(srvdto==null)return;
		if(ordSrvInfo.getStatus()==DOStatus.DELETED) return;
		//		ordSrvInfo.setSortno(0);
		ordSrvInfo.setDt_create(srvdto.getDt_begin_ui());
		//
		//				ordSrvInfo.setDt_last_cg(getLastDt(ordSrvInfo.getId_freq(),ordo.getDt_effe(),ems.getTimes_firday_mp(),ordo.getFg_long()));
		ordSrvInfo.setDt_last_bl(OrderUtils.getLastDt(ordSrvInfo.getId_freq(),srvdto.getDt_begin_ui(),null,FBoolean.FALSE));//???
		if(CiOrdUtils.isEmpty(srvdto.getPrice())){
			//映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), ordSrvInfo.getId_srv(),srvdto.getPrice().toString(),ordSrvInfo);
		}else{
			ordSrvInfo.setPri(srvdto.getPrice());
			ordSrvInfo.setPri_std(srvdto.getPri_std());//???
			ordSrvInfo.setPri_ratio(srvdto.getPri_ratio());//???
			ordSrvInfo.setId_pripat(srvdto.getId_pripat());//???
		}
		//		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd());
		//		ordSrvInfo.setEu_sourcemd(srvdto.getEu_sourcemd()); //添加医疗单来源//???
		//		ordSrvInfo.setId_srv_src(srvdto.getId_srv_src());
		ordSrvInfo.setId_dep_mp(srvdto.getId_mp_dep()); 
		ordSrvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(ordSrvInfo.getId_dep_mp()));
		//		ordSrvInfo.setPriby(srvdto.getPri);//2016-09-01  新增
		ordSrvInfo.setStatus(srvdto.getStatus());
	}

	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList, Object[] extInfoList, Object uiModel)
			throws BizException {
		EmsObsItemDO srvdto=(EmsObsItemDO)uiModel;
		for(Object obj:appSheetList){
			OrdApLabDO ordlis=(OrdApLabDO)obj;
			//ordlis.setId_or(srvdto.getId_or());
			ordlis.setId_di(srvdto.getId_di());//临床诊断	
			ordlis.setId_diitm(srvdto.getId_diitm());//临床诊断子项
			ordlis.setStr_id_diitm(srvdto.getStr_id_diitm());//临床诊断明细
			ordlis.setStr_code_di(srvdto.getStr_code_di());//诊断编码拼接
			ordlis.setStr_name_di(srvdto.getStr_name_di());//诊断名称拼接
			ordlis.setNo_applyform(srvdto.getNo_applyobs());//申请单号	
			ordlis.setId_srvca(srvdto.getId_srvca());//检验分类	
			ordlis.setSd_pps(srvdto.getSd_pps());//检验目的编码
			ordlis.setDt_plan(srvdto.getDt_plan());//计划检验日期
			ordlis.setId_pps(srvdto.getId_pps());//检验目的	
			ordlis.setDes_pps(srvdto.getDes_pps());//检验目的描述	
			ordlis.setDes_sympsign(srvdto.getDes_sympsign());//病情描述	
			ordlis.setClinicalzztz(srvdto.getClinicalzztz());//临床症状及体征
			ordlis.setPastillness(srvdto.getPastillness());//既往病史 
			ordlis.setAuximtexam(srvdto.getAuximtexam());//其它检查所见 
			ordlis.setAnnouncements(srvdto.getAnnouncements());//注意事项 
			ordlis.setFg_urgent(srvdto.getFg_urgent());//加急标识	 
			ordlis.setSd_samptp(srvdto.getSd_samptp());//标本类型	
			ordlis.setName_samptp(srvdto.getName_samptp());//标本类型	
			ordlis.setId_samptp(srvdto.getId_samptp());//标本类型编码	 
			ordlis.setSd_colltp(srvdto.getSd_colltp());//采集方法	 
			ordlis.setId_colltp(srvdto.getId_colltp());//采集方法编码	 
			ordlis.setDes_labsamp(srvdto.getDes_labsamp());//标本说明	 	
			ordlis.setId_unit_quan(srvdto.getId_unit_sampcoltime());//需求数量单位	 	 	 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	a0b14
			ordlis.setName_diag(srvdto.getName_diag());//诊断名称		 				 	 	 	 	 	 				 	 			 	 	 		 	 	 	 	 
			ordlis.setId_sampcoltime(srvdto.getId_sampcoltime());//标本采集时间	REF	标本
			ordlis.setId_sampcollecttimetp(srvdto.getId_sampcollecttimetp());//标本采集时间类型	
			ordlis.setSd_sampcollecttimetp(srvdto.getSd_sampcollecttimetp());//标本采集时间类型编码
			ordlis.setLen_sampcoltime(srvdto.getLen_sampcoltime());//标本采集时长	SINGLE	
			ordlis.setId_unit_sampcoltime(srvdto.getId_unit_sampcoltime());//标本采集时间时长单位
			ordlis.setStatus(srvdto.getStatus());
			if (!CiOrdUtils.isEmpty(srvdto.getEmsOrObsListEx()) )
			{
				EmsObsLap emsObsLap = (EmsObsLap)srvdto.getEmsOrObsListEx().get(0);
				ordlis.setAnnouncements ( emsObsLap.getAnnouncements());
				ordlis.setQuan ( emsObsLap.getQuan());
				ordlis.setId_unit_quan ( emsObsLap.getId_quan());
				ordlis.setSd_contp ( emsObsLap.getSd_contp());
				ordlis.setId_contp ( emsObsLap.getId_contp());
				ordlis.setSd_colltp ( emsObsLap.getSd_colltp());
				ordlis.setId_colltp ( emsObsLap.getId_colltp());
				ordlis.setId_labgroup ( emsObsLap.getId_labgroup());
				ordlis.setSd_labgroup ( emsObsLap.getSd_labgroup());
			}
		}
	}
	@Override
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		EmsObsItemDO srvdto = (EmsObsItemDO) uiModel;
		if (srvInfo.getStatus() == DOStatus.DELETED)
			return;
		srvInfo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());
		srvInfo.setId_srv_src(orderInfo.getId_srv());
		srvInfo.setId_dep_mp(srvdto.getId_mp_dep());
		srvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_dep_mp()));
		srvInfo.setDt_last_bl(OrderUtils.getLastDt(srvInfo.getId_freq(), srvdto.getDt_plan(), null, FBoolean.FALSE));
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 频次
		srvInfo.setId_freq(srvdto.getId_freq());
		srvInfo.setFreq_name(srvdto.getName_freq());
		srvInfo.setFreqct(srvdto.getFreqct());
		srvInfo.setSd_frequnitct(srvdto.getSd_frequnitct());
		// 剂量
		srvInfo.setQuan_medu(srvdto.getQuan_med());
		// 总量
		srvInfo.setQuan_total_medu(srvdto.getQuan_cur());
		// 单位
		srvInfo.setId_medu(srvdto.getId_unit_med());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		//		srvInfo.setStatus(srvdto.getStatus());
	}
}
