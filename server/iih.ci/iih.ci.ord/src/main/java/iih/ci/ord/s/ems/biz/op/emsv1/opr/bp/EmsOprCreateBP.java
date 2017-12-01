package iih.ci.ord.s.ems.biz.op.emsv1.opr.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvOpDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvOpDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单创建逻辑
 * @author wangqingzhu
 *
 */
public class EmsOprCreateBP extends EmsBaseCreateBP {
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		EmsRstDTO rst = new EmsRstDTO();
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 获取主服务信息
		MedsrvAggDO aggDO = getMedSrvInfo(ems.getId_srv());
		if (aggDO == null){
			throw new BizException("查询主服务信息失败！",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsOpitemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());;
		if(null == emsModel){
			emsModel = emsModelFrom(aggDO.getParentDO());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(),emsModel);
		}
		// 可变部分赋值
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm);		// SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),tm.getUFTime()));	

			emsModel.setDt_plan( tm );          //计划手术时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
			emsModel.setDt_creat( tm);//开立日期	SINGLE	FDateTime	19	
			emsModel.setNo_applyform( CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()) );
		}
		//诊断信息
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

		// 获取价格
		emsModel.setPrice(OrderEmsPriceUtils.calculatePrice(aggDO.getParentDO(),ems.getEnContext().getEnt4BannerDTO().getId_pripat()));

		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(), "","");
		if (null == wf){
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
		emsModel.setName_mp_dep(wf.getFirstname_mp_dept());
		emsModel.setStatus(DOStatus.NEW);

		// 动态指标
		if (null != ems.getEmsMgrInfo()){
			OrdApSugViewItemDO[] szOrdApSugViewItemDO = this.ordApSugViewItemListFrom(ems.getEnContext(), ems.getEmsMgrInfo().getId_ems());
			if (null != szOrdApSugViewItemDO){
				FArrayList indicatorList = new FArrayList();
				for (OrdApSugViewItemDO item : szOrdApSugViewItemDO){
					indicatorList.add(item);
				}
				if (indicatorList.size() > 0){
					emsModel.setOpCheckIndicatorList(indicatorList);
				}
			}
		}

		//
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO()	);
		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.OPER.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}



	/**
	 * 创建主模型对象
	 * @param medSrv
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	protected EmsOpitemDO emsModelFrom(MedSrvDO medSrv)throws BizException{
		EmsOpitemDO ems = new EmsOpitemDO();
		FDateTime tm = CiOrdAppUtils.getServerDateTime();


		MedSrvOpDO op = getMedSrvOp(medSrv.getId_srv());
		if (null == op){
			throw new BizException (String.format("没有查到【%s】服务的属性信息", medSrv.getName()));
		}

		ems.setId_incitp( op.getId_incitp() );
		ems.setSd_incitp( op.getSd_incitp() );
		ems.setId_unit_med( medSrv.getId_unit_med() );
		ems.setName_unit_med( medSrv.getMed_name() );
		ems.setQuan_med( medSrv.getQuan_med() );
		//ems.setId_emsopitem	        //手术申请单主键	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_or(   	            //医嘱id	SINGLE	String	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setId_srv( medSrv.getId_srv() );	            //服务id	REF	医疗服务	20	医疗服务	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setName_srv( medSrv.getName() );	            //手术名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setNo_applyform( CiOrdUtils.getApplyNo(medSrv.getSd_srvtp()) );	        //申请单号	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setCode_srv( op.getCode_di() );	            //手术编码	SINGLE	String	50	
		//ems.setFg_er_sug	        //急诊手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setFg_xq_sug	        //限期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setFg_zq_sug	        //择期手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setDt_plan( tm );          //计划手术时间	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setDt_creat( tm);//开立日期	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_di	            //诊断id	REF	医疗服务_疾病诊断定义	20	疾病诊断	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_di	            //诊断	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_mp_dep	        //执行科室id	REF	部门	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_mp_dep	        //执行科室	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setSd_lvlsug( op.getSd_opclass() );	        //手术分级编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setName_lvlsug( op.getName_opclass() );	        //手术分级	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setId_lvlsug( op.getId_opclass() ); //手术分级id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSd_anestp	        //麻醉方式编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_anestp	        //麻醉方式	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_anestp	        //麻醉方式id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setFg_allergy	        //药物过敏史	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		ems.setFg_new_sug( op.getFg_new_sug() ); //是否开展新手术	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setFg_patho	            //手术中冰冻处理	SINGLE	FBoolean	1	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setQuan_bt_plan	        //预期输血量	SINGLE	FDouble	16	 	 				 	 	 	 	  		 	 			 	 	 	
		//ems.setTime_sup_plan	    //预期手术时长	SINGLE	Integer	10	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_emp_operator	    //主刀医师id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_emp_operator	//主刀医师	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_emp_help1	        //一助id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_emp_help1	    //一助	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSd_sugbodycod	    //体位编码	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_sugbodycod	    //体位	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_sugbodycod	    //体位id	REF	体位编码_自定义档案	20	体位编码_自定义档案	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSpecialreq	        //特殊器械	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSpecialinstrument	//特殊仪器	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSpecialdes	        //特殊准备	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setAnnouncements	    //注意事项	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSd_su	            //手术申请状态	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_role	            //角色id	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_role	        //角色	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setId_emp_op	        //人员id	REF	人员基本信息	20	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setName_emp_op	        //人员名称	SINGLE	String	50	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSv	                //版本号	SINGLE	FDateTime	19	 	 				 	 	 	 	 	 				 	 			 	 	 	
		//ems.setSortno	            //排序号
		// String															// 50


		return ems;
	}

	/**
	 * 获取主服务对象
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	protected MedsrvAggDO getMedSrvInfo(String id_srv) throws BizException{
		return ServiceFinder.find(IMedsrvRService.class).findById(id_srv);
	}


	private MedSrvOpDO getMedSrvOp(String id_srv) throws BizException
	{
		
		IMedSrvOpDORService service = ServiceFinder.find(IMedSrvOpDORService.class);
		
		MedSrvOpDO[] ops = service.find(String.format("a3.id_srv='%s'", id_srv), "", FBoolean.FALSE);
		if (!CiOrdUtils.isEmpty(ops)){
			return ops[0];
		}
		
		return null;
	}


	protected OrdApSugViewItemDO[] ordApSugViewItemListFrom(CiEnContextDTO ctx, String id_srvof) throws BizException
	{
		// 获取医疗单维护 -- 医疗单注册服务
		IEmsregistryRService emsMgrService = ServiceFinder.find(IEmsregistryRService.class);
		if (null == emsMgrService)
			return null;


		EmsregistryAggDO emsRegAggDo = emsMgrService.findById(id_srvof);

		if (null == emsRegAggDo){
			return null;
		}

		if (emsRegAggDo.getParentDO() == null) 
			return null;

		FBoolean fg_dyncitm_en = emsRegAggDo.getParentDO().getFg_dyncitm_crossentp();
		Integer eu_dyncitmunit = emsRegAggDo.getParentDO().getEu_dyncitmunit();//指标周期类型
		Integer dyncitmunitct = emsRegAggDo.getParentDO().getCnt_dyncitmunit();

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems( id_srvof);
		paramDto.setFg_dyncitm_en( fg_dyncitm_en.booleanValue());
		paramDto.setEu_dyncitmunit( eu_dyncitmunit);
		paramDto.setId_ent( ctx.getId_en());
		paramDto.setId_pat ( ctx.getId_pat());
		paramDto.setDyncitmunitct ( dyncitmunitct);

		IBdSrvQryService qryService = ServiceFinder.find(IBdSrvQryService.class);
		if (null == qryService){
			return null;
		}
		EmsDynamicIndexDTO[] dtos = qryService.getEmsDynamicIndexInfos(paramDto);
		//Datatype为编辑类型，0：输入框，其他为：下拉框
		List<OrdApSugViewItemDO> rstList = new ArrayList<OrdApSugViewItemDO>();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApSugViewItemDO item = new OrdApSugViewItemDO();
			{
				item.setVal_rstrptla ( dto.getIndexval() == null ? "" : dto.getIndexval());
				item.setVal_restrptlab ( dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
				item.setSd_restrptlabtp ( dto.getDatatype());
				item.setName_srv ( dto.getShowname());
				item.setName_unit ( dto.getUnitname());
				item.setId_unit ( dto.getId_unit());
				item.setId_srv ( dto.getId_srv());
			};
			rstList.add(item);
		}

		return rstList.toArray(new OrdApSugViewItemDO[rstList.size()]);
	}

}
