package iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.opr.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
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
import iih.ci.ord.s.ems.biz.meta.OrderSrvList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.opr.bp.EmsOprSaveBP;
import iih.ci.ord.s.ems.biz.op.tmpl.meta.OrderTmplDetailList;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.define.StringObjectMap;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单保存逻辑
 * @author wangqingzhu
 *
 */
public class TmplOprSaveBP extends EmsOprSaveBP {

	public TmplOprSaveBP(IEmsValidate iv) {
		super(iv);
		
	}

	//	@Override
	//	protected OrderPackageInfo[] handleCreateOrderInfo(CiEnContextDTO ctx,List<Object> listUiModel) throws BizException {
	//		OrderPackageInfo[] OrderPakageInfos= super.handleCreateOrderInfo(ctx, listUiModel);
	//		for(OrderPackageInfo pInfo : OrderPakageInfos){
	//			EmsOpitemDO ems = (EmsOpitemDO)pInfo.getUiModel();
	//			if(!CiOrdUtils.isEmpty(ems.getId_opex_srvs())){
	//			// 查询附加术服务信息
	//			MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(ems.getId_opex_srvs().split(","), FBoolean.FALSE);
	//			
	//				OrderSrvList osil = assumbleExtOprInfo(ctx,szMedSrvInfo,pInfo.getOrderInfo());
	//				if (CiOrdUtils.isEmpty(pInfo.getOrderSrvMmList())){
	//					pInfo.setOrderSrvMmList(new OrderSrvMmList(osil.asArray()));
	//				}
	//				else{
	//					pInfo.getOrderSrvMmList().append(osil.asArray());
	//				}
	//			}
	//			
	//		}
	//		return OrderPakageInfos;
	//	}

	@Override
	protected DefaultCreateParam[] defaultCreateParamFrom(List<Object> listUiModel) throws BizException{

		DefaultCreateParamList listDefaultCreateParam = new DefaultCreateParamList();
		//		StringObjectMap som = new StringObjectMap();
		//		StringObjectMap srvKey2UiModelCache = new StringObjectMap();
			
		for (Object uiModel : listUiModel){
			OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
			// 基础服务和物品信息列表
			BdSrvMmInfoList bdSrvInfoList = new BdSrvMmInfoList();
			for (OrTplNItmDO tmplInfo : detailList){

				BdSrvMmInfo bsmi = new BdSrvMmInfo(tmplInfo);
				if (bsmi.createSrvMmInfo(
						tmplInfo.getId_srv(), 
						this.getEnContextInfo().getId_org(), 
						this.getEnContextInfo().getId_dep_or())){
					bdSrvInfoList.add(bsmi);
					//					som.put(tmplInfo.getId_srv(), uiModel);
				}
				}

			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvInfoList,detailList));
			}
			


		//		for (Object uiModel : listUiModel){
		//			EmsOpitemDO doInfo = (EmsOpitemDO)uiModel;
		//			som.put(doInfo.getId_srv(), uiModel);
		//			srvKey2UiModelCache.put(doInfo.getId_srv(), doInfo);
		//		}
		//		MedSrvDO[] szMedSrvInfo = ServiceFinder.find(IMedsrvMDORService.class).findByIds(som.asKeyArray(),FBoolean.FALSE);
		//		assert !CiOrdUtils.isEmpty(szMedSrvInfo) : "获取手术医疗单基础服务数据失败";
		//		for (MedSrvDO srvInfo : szMedSrvInfo){
		//			BdSrvMmInfoList bdSrvMmInfoList = new BdSrvMmInfoList();
		//			bdSrvMmInfoList.add(new BdSrvMmInfo(srvInfo,srvKey2UiModelCache.get(srvInfo.getId_srv())));
		//			listDefaultCreateParam.add(new DefaultCreateParam(bdSrvMmInfoList,som.get(srvInfo.getId_srv())));
		//		}
		return listDefaultCreateParam.asArray();
	}



	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		OrderSavedRstInfo[] szInnerOrderSaveInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);

		for (OrderPackageInfo opInfo : szOrderPackageInfo) {

			// 保存申请单
			if (!CiOrdUtils.isEmpty(opInfo.getOrderAppSheetList()) ) {
				String id_or = opInfo.getOrderInfo().getId_or();
				Object objAppSheetInfo = opInfo.getOrderAppSheetList().get(0);

				if (objAppSheetInfo instanceof CiorappsurgeryAggDO) { // 手术申请单保存
					CiOrdAppUtils.getOrappsurgerytService().save(
							opInfo.getOrderAppSheetList().toArray(new CiorappsurgeryAggDO[opInfo.getOrderAppSheetList().size()]));
				}
			}

		}
		return szInnerOrderSaveInfo;
	}

	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		OrderKey2UiModelMap oiumm = new OrderKey2UiModelMap();
		for (int index = 0; index < listUiModel.size(); ++index) {
			EmsOpitemDO itemDO = (EmsOpitemDO) listUiModel.get(index);
			oiumm.put(itemDO.getId_or(), itemDO);
		}
		return oiumm;
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		SrvKey2UiModelMap o = new SrvKey2UiModelMap();
		EmsOpitemDO doInfo = (EmsOpitemDO)uiModel;

		o.put(doInfo.getId_orsrv(), doInfo);
		return o;
	}


	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	@Override
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		// 
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {

			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo.getOrderInfo(), pInfo.getUiModel());
			OrderSrvMmList dellist=new OrderSrvMmList();
			// 合并服务UI模型数据
			for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
				if(srvMmInfo.getOrderSrvInfo().getSortno()>0){
					if(pInfo.getOrderInfo().getStatus()==DOStatus.NEW){
						dellist.add(srvMmInfo);
					}else{
						srvMmInfo.getOrderSrvInfo().setStatus(DOStatus.DELETED);
					}
					continue;
				}

				// 合并服务信息
				mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
				// 处理其他信息
				afterMergeOrderSrvInfo(ctx,pInfo.getOrderInfo(),srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());

				if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())){
					mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(),srvMmInfo.getUiModel());
				}
			}
			//			EmsOpitemDO ems = (EmsOpitemDO)pInfo.getUiModel();
			//			if(dellist.size()>0){
			//				for (OrderSrvMmInfo srvMmInfo : dellist) {
			//					pInfo.getOrderSrvMmList().remove(srvMmInfo);
			//				}
			//			}
			//			if(!StringUtil.isEmpty(ems.getId_opex_srvs())){
			//				// 创建附加术服务信息
			//				getExOprSrvInfo(ctx,ems.getId_opex_srvs(),pInfo);
			//			}
			//合并申请单信息
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())){
				mergeOrderAppInfo(ctx,pInfo.getOrderAppSheetList().asArray(),pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
		}
		return szOrderPakageInfo;
	}

	/**
	 * 合并医嘱
	 * @param srvInfo
	 * @param ctx
	 * @return
	 * @throws BizException 
	 */
	protected void mergeOrderInfo(CiEnContextDTO ctx,CiOrderDO orderInfo, Object uiModel) throws BizException{
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
		orderInfo.setFg_mp_in(FBoolean.TRUE);
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
//		orderInfo.setId_dep_mp(DeptInfoUtils.GetOrWfDeptInfo(ctx,));
		// 最后执行时间
		orderInfo.setDt_last_mp(tm);
		// 状态
		orderInfo.setStatus(DOStatus.NEW);
	}

	/**
	 * 获取申清单信息
	 * @param szId_or 医嘱ID集合
	 * @return
	 * @throws BizException
	 */
	protected Object[] qryOrderAppSheetList(String[] szId_or) throws BizException{
		// 手术申请单保存
		CiorappsurgeryAggDO[] szCiorappsurgeryAggDO = CiOrdAppUtils.getOrappsurgeryQrytService().findByAttrValStrings("Id_or", szId_or);
		if (!CiOrdUtils.isEmpty(szCiorappsurgeryAggDO)){
			return szCiorappsurgeryAggDO;
		}
		return null;
	}

	/**
	 * 附加术生成服务信息
	 * @param medsrvs
	 * @param orderInfo
	 * @param ctx
	 * @throws BizException
	 */
	private OrderSrvList assumbleExtOprInfo(CiEnContextDTO ctx, MedSrvDO[] medsrvs, CiOrderDO orderInfo) throws BizException{

		OrderSrvList ordsrvlist = new OrderSrvList();
		int i=1;
		for(MedSrvDO medsrv:medsrvs){                                                                                                                  
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_or(orderInfo.getId_or());
			srvdo.setId_org(ctx.getId_org());
			srvdo.setId_grp(ctx.getId_grp());
			srvdo.setId_pat(ctx.getId_pat());
			srvdo.setId_entp(ctx.getId_entp());
			srvdo.setCode_entp(ctx.getCode_entp());
			srvdo.setId_en(ctx.getId_en());
			srvdo.setSortno(0);
			srvdo.setId_srvtp(medsrv.getId_srvtp());
			srvdo.setSd_srvtp(medsrv.getSd_srvtp());
			srvdo.setId_srv(medsrv.getId_srv());
			srvdo.setName(medsrv.getName());
			srvdo.setFg_dose_anoma(null);
			srvdo.setQuan_medu(medsrv.getQuan_med());
			srvdo.setId_medu(medsrv.getId_unit_med());
			srvdo.setId_route(medsrv.getId_route());
			srvdo.setId_routedes(medsrv.getId_routedes());
			srvdo.setId_boil(medsrv.getId_boil());
			srvdo.setId_boildes(medsrv.getId_boildes());
			srvdo.setId_freq(medsrv.getId_freq()); 
			srvdo.setId_org_srv(ctx.getId_org());
			srvdo.setId_dep_srv(ctx.getId_dep_or());
			srvdo.setId_wg_or(ctx.getId_wg_or());
			srvdo.setId_emp_srv(ctx.getId_emp_or());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());

			srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(orderInfo.getId_dep_mp()));
			srvdo.setId_dep_mp(orderInfo.getId_dep_mp());
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			srvdo.setQuan_total_medu(medsrv.getQuan_med());// 计算服务总量
			srvdo.setFg_or(medsrv.getFg_or());
			srvdo.setEu_blmd(medsrv.getEu_blmd());
			srvdo.setFg_mm(CiOrdUtils.nullHandle(medsrv.getFg_mm()));
			//if (CiOrdUtils.isEmpty(medsrv.getPri())) {
			// 映射折扣价，如果折扣价为空，则后台再查询折扣价
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(ctx.getCode_entp(), medsrv.getId_srv(),
					medsrv.getId_primd(), srvdo);
			//			} else {
			srvdo.setPri(medsrv.getPri());
			srvdo.setPri_std(medsrv.getPri());// 标准价
			// srvdo.setPri_ratio(medsrv.getPri_ratio());//价格系数??
			//				srvdo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());// 患者价格分类
			//			}
			srvdo.setFg_set(CiOrdUtils.nullHandle(medsrv.getFg_set()));
			// srvdo.setFg_indic((medsrv.getFg_hpindicjudged()));//之前关闭，现在打开了（zhangwq）//???字段类型不符合
			// srvdo.setFg_propc(CiOrdUtils.nullHandle(medsrv.getFg_propc()));
			// srvdo.setFg_self(CiOrdUtils.nullHandle(srvInfo.getFg_self()));
			// srvdo.setFg_pres_outp(CiOrdUtils.nullHandle(null));//--
			srvdo.setNote_srv(medsrv.getDes());
			srvdo.setId_srvca(medsrv.getId_srvca());
			srvdo.setFg_bl(CiOrdUtils.nullHandle(medsrv.getFg_bl()));
			srvdo.setCode_srv(medsrv.getCode());
			//			srvdo.setEu_sourcemd(Integer.parseInt(ctx.getEu_orsrcmdtp()));
			srvdo.setId_primd(medsrv.getId_primd());

			// srvdo.setId_reltp(srvInfo.getId_reltp());//2016-03-25 新增 关联类型
			// srvdo.setFg_hpindicjudged(srvInfo.getFg_hpindicjudged());//0不需要判断，1待判断，2已判断;
			// srvdo.setFg_extdispense(srvInfo.getFg_extdispense());//外配药标识
			if (CiOrdUtils.isTrue(srvdo.getFg_skintest())) {
				srvdo.setSd_reltp(IBdSrvDictCodeConst.SD_RELORDTYPE_SKIN);
			} else {
				// srvdo.setSd_reltp(srvInfo.getSd_reltp());//2016-03-25 新增 关联类型编码
			}
			// srvdo.setId_or_rel(srvInfo.getId_or_rel());//2016-03-25 新增 对应关联医嘱id
			srvdo.setFg_selfsrv(medsrv.getFg_ctm());
			// srvdo.setId_srv_src(srvInfo.getId_srv_src());
			srvdo.setQuan_total_medu(medsrv.getQuan_med());
			 srvdo.setFg_selfpay(FBoolean.TRUE);//2016-07-08新增自费标识
			srvdo.setId_hp(ctx.getId_hp());// 2016-07-12新增医保相关信息
			// srvdo.setId_hpsrvtp(ctx.getId_hpsrvtp());
			// srvdo.setSd_hpsrvtp(ctx.getSd_hpsrvtp());
			// srvdo.setDes_hplimit(ctx.getLimit());

			// srvdo.setId_dep_mp(srvInfo.getId_mp_dep());
			// srvdo.setId_dep_wh(mmdo.getId_dep_wh());
			// srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			// srvdo.setFg_base(srvInfo.getFg_base());//???
			srvdo.setInnercode_srvca(medsrv.getSrvca_innercode());
			srvdo.setFg_feertnable(FBoolean.TRUE); // 可退费标识
			srvdo.setStatus(DOStatus.NEW);
			srvdo.setSortno(i);
			srvdo.setDt_last_bl(OrderUtils.getLastDt(srvdo.getId_freq(),orderInfo.getDt_effe(),null,FBoolean.FALSE));//???
			ordsrvlist.add(srvdo);
			i++;
		}
		return ordsrvlist;

	}

	/**
	 * 合并服务
	 * @param ctx
	 * @param srvInfo
	 * @param uiModel
	 * @throws BizException 
	 */
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx,OrdSrvDO srvInfo, Object uiModel) throws BizException {
		OrTplNItmDO drugInfo = (OrTplNItmDO) uiModel;
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		String idSrv = drugInfo.getId_srv();
		if (srvInfo.getId_srv() != null && srvInfo.getId_srv().equals(idSrv)) {
			//			if (drugInfo.getStatus() == DOStatus.DELETED) {
			//				srvInfo.setStatus(DOStatus.DELETED);
			//			} else {
			srvInfo.setId_srv(drugInfo.getId_srv());
			//srvInfo.setName_srv(drugInfo.getName_srv());
			//srvInfo.setInnercode_srvca(drugInfo.getInnercode_srvca());
			// srvInfo.setCode_srv(drugInfo.getCode_srv());
			srvInfo.setSd_srvtp(drugInfo.getSd_srvtp());
			//srvInfo.setId_srvca(drugInfo.getId_srvca());
			srvInfo.setId_medu(drugInfo.getId_unit_med());
			srvInfo.setQuan_medu(drugInfo.getQuan_med());
			//srvInfo.setId_dep_mp(drugInfo.getId_mp_dep());
			//srvInfo.setId_dep_wh(drugInfo.getId_dep_wh());
			srvInfo.setPri(drugInfo.getPrice());
			srvInfo.setPri_std(drugInfo.getPrice());
			srvInfo.setId_pripat(ctx.getEnt4BannerDTO().getId_pripat());
			//srvInfo.setQuan_total_medu(drugInfo.getQuan_cur());
			srvInfo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvInfo.getId_dep_mp()));
			srvInfo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvInfo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvInfo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvInfo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			//srvInfo.setId_hpsrvtp(drugInfo.getId_hpsrvtp());
			//srvInfo.setSd_hpsrvtp(drugInfo.getSd_hpsrvtp());
			//srvInfo.setEu_sourcemd(drugInfo.getEu_sourcemd());
			srvInfo.setPri(drugInfo.getPrice());
			srvInfo.setDt_last_bl(tm);
			//srvInfo.setFg_selfpay(drugInfo.getFg_selfpay());
			// srvInfo.setPri_std(drugInfo.g.getPri_std());
			// srvInfo.setPri_ratio(drugInfo.getPri_ratio());
			// srvInfo.setId_pripat(drugInfo.getId_pripat());

			//srvInfo.setStatus(drugInfo.getStatus());
			//			}
		}
	}

	/**
	 * 合并申请单
	 */
	@Override
	protected void mergeOrderAppInfo(CiEnContextDTO ctx, Object[] appSheetList,Object[] extInfoList,Object uiModel)throws BizException{
		OrderTmplDetailList detailList = (OrderTmplDetailList)uiModel;
		OrTplNItmDO srvdto=detailList.get(0);
		for(Object obj:appSheetList){
			CiorappsurgeryAggDO aggdo=(CiorappsurgeryAggDO)obj;
			ordOpInfoFrom(srvdto,aggdo.getParentDO());
			//			List<OrdApSugViewItemDO> invitecons=new ArrayList<OrdApSugViewItemDO>();
			//动态指标处理
			//			if(srvdto.getOpCheckIndicatorList()==null)return ;
			//			for(Object itemdo:srvdto.getOpCheckIndicatorList()){
			//				OrdApSugViewItemDO consitem=(OrdApSugViewItemDO)itemdo;
			//				invitecons.add(consitem);
			//			}
			//			if(invitecons.size()>0){
			//				aggdo.setOrdApSugViewItemDO(invitecons.toArray(new OrdApSugViewItemDO[invitecons.size()]));
			//			}
		}
	}


	/**
	 * 手术申请单映射
	 * @param ordop
	 * @return
	 * @throws BizException 
	 */
	private void ordOpInfoFrom(OrTplNItmDO ordop,OrdApOpDO opInfo) throws BizException{
		//		opInfo.setId_apop();
		//		opInfo.setId_or(ordop.getId_or());
		//		opInfo.setId_di(ordop.getId_di());	
		//		opInfo.setStr_id_diitm(ordop.getStr_id_diitm());
		//		opInfo.setStr_code_di(ordop.getStr_code_di());
		//		opInfo.setStr_name_di(ordop.getStr_name_di());
		opInfo.setNo_applyform(CiOrdUtils.getApplyNo(ordop.getSd_srvtp()));
		opInfo.setDt_plan(CiOrdAppUtils.getServerDateTime());
		//		opInfo.setSugplantime(ordop.get);//???
		//		opInfo.setId_lvlsug(ordop.getId_lvlsug());
		//		opInfo.setSd_lvlsug(ordop.getSd_lvlsug());
		//		opInfo.setId_anestp(ordop.getId_anestp());
		//		opInfo.setSd_anestp(ordop.getSd_anestp());
		//		opInfo.setId_incitp(ordop.getId_incitp());
		//		opInfo.setSd_incitp(ordop.getSd_incitp());
		//		opInfo.setFg_allergy(ordop.getFg_allergy());
		//		opInfo.setFg_patho(ordop.getFg_patho());
		//		opInfo.setId_su_op(ordop.getId_su());
		//		opInfo.setSd_su_op(ordop.getSd_su());
		//		opInfo.setAnnouncements(ordop.getAnnouncements());
		opInfo.setId_srv(ordop.getId_srv());
		//		opInfo.setId_srv_code(ordop.getCode_srv());
		//		opInfo.setQuan_bt_paln(ordop.getQuan_bt_plan());
		//		opInfo.setId_emp_operate(ordop.getId_emp_operator());	
		//		opInfo.setId_emp_helper(ordop.getId_emp_help1());
		//		opInfo.setId_sugbody(ordop.getId_sugbodycod());
		//		opInfo.setSd_sugbody(ordop.getSd_sugbodycod());
		//		opInfo.setSpecialreq(ordop.getSpecialreq());
		//		opInfo.setSpecialinstrument(ordop.getSpecialinstrument());	
		//		opInfo.setSpecialdes(ordop.getSpecialdes());
		//		opInfo.setFg_er_sug(ordop.getFg_er_sug());
		//		opInfo.setFg_xq_sug(ordop.getFg_xq_sug());
		//		opInfo.setFg_zq_sug(ordop.getFg_zq_sug());
		//		opInfo.setFg_new_sug(ordop.getFg_new_sug());
		//		opInfo.setApopemp(ordop.geta);	
		//		opInfo.setApopmm();
		//		opInfo.setApopobsindex();
		//		opInfo.setName_diag(ordop.getName_diag());
		//		opInfo.setId_diitm(ordop.getId_diitm());
		//		opInfo.setFg_prn();
		//		opInfo.setCnt_prn();
		//		opInfo.setId_didef_relstd(ordop.getid_d);//???	
	}

	@Override
	protected int GetSrvObjStatus(Object objDO) {
		return DOStatus.NEW;
	}
}
