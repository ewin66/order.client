package iih.ci.ord.s.ems.biz.op.ems.apbt.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
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
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsApBtCreateBP extends EmsBaseCreateBP {
	
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsBtItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		if (null == emsModel)
		{
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
			emsModel.setDt_bt(tm); // 输血日期 SINGLE											
			emsModel.setDt_create(tm); // 开立时间 SINGLE
			emsModel.setNo_applyform( CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()) );
			
			emsModel.setId_emp_create(ems.getEnContext().getPsnInfo().getId_psndoc()); // 申请医生id REF
			emsModel.setName_emp_create(ems.getEnContext().getPsnInfo().getName()); // 申请医生 SINGLE
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

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO()	);
        
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(), "", "");
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}
		emsModel.setId_mp_dep(wf.getFirstid_mp_dept());
		emsModel.setName_mp_dep(wf.getFirstname_mp_dept());
		
		// 动态指标
		if (null != ems.getEmsMgrInfo()){
		OrdApSugViewItemDO[] szOrdApSugViewItemDO = this.ordApSugViewItemListFrom(ems.getEnContext(), ems.getEmsMgrInfo().getId_ems());
		if (null != szOrdApSugViewItemDO){
			FArrayList indicatorList = new FArrayList();
			for (OrdApSugViewItemDO item : szOrdApSugViewItemDO){
				indicatorList.add(item);
			}
			if (indicatorList.size() > 0){
				emsModel.setBtLabItemEx(indicatorList);
			}
		}
		}

		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());

		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		// 返回值处理
		 rst.setDocument(this.handleReturnDocument(emsModel));
		//rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.BT.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	public EmsBtItemDO emsModelFrom(MedSrvDO med) throws BizException {
		EmsBtItemDO ems = new EmsBtItemDO();
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		ems.setComponents_name(med.getName());
		ems.setFg_bl(med.getFg_bl());
		ems.setFg_or(med.getFg_or());
		ems.setFg_mm(med.getFg_mm());
		// ems.setId_or //医嘱id
		// ems.setId_orsrv //医嘱服务id
		// 若打开该医疗单的服务是服务套时，输血成分参照是服务套中临床标志为true的明细
		if (CiOrdUtils.isTrue(med.getFg_set())) {
	
			MedSrvSetItemDO[] setItems = ServiceFinder.find(IMedSrvSetItemDORService.class)
					.find(String.format("a8.id_srv='%s'", med.getId_srv()), "", FBoolean.FALSE);
			if (setItems != null && setItems.length > 0) {
				ems.setId_srv(setItems[0].getId_srv_itm()); // 服务id
				ems.setName_srv(setItems[0].getSet_name()); // 输血成分(服务名称)
				ems.setQuan_med(setItems[0].getQuan_medu()); // 输血数量(医学单位数值)
				ems.setId_unit_med(setItems[0].getId_medu()); // 输血数量单位(医学单位)
				ems.setName_unit_med(setItems[0].getMedu_name()); // 医学单位名称
			}
		} else {
			ems.setId_srv(med.getId_srv()); // 服务id
			ems.setName_srv(med.getName()); // 输血成分(服务名称)
			ems.setQuan_med(med.getQuan_med()); // 输血数量(医学单位数值) SINGLE FDouble
			ems.setId_unit_med(med.getId_unit_med()); // 输血数量单位(医学单位) REF 计量单位
			ems.setName_unit_med(med.getMed_name()); // 医学单位名称 SINGLE String 50
		}
		// ems.setId_di //临床诊断id REF 医疗服务_疾病诊断定义 20 疾病诊断
		// ems.setName_di //临床诊断
		ems.setNo_applyform(CiOrdUtils.getApplyNo(med.getSd_srvtp())); // 输血单号
		// ems.setParturition_cnt //产数量 SINGLE Integer 10
		// ems.setFg_bt // 输血史标志 SINGLE FBoolean 1
		// ems.setSd_pps // 输血目的编码 SINGLE String 20
		// ems.setId_pps // 输血目的id REF 检验目的_自定义档案 20 检验目的_自定义档案
		// ems.setName_pps // 输血目的 SINGLE String 50
		// ems.setFg_db // 献血史标志 SINGLE FBoolean 1
		// ems.setNo_db // 献血证号 SINGLE String 50
		// ems.setId_mode // 预定输血方式id REF 20
		// ems.setName_mode // 预定输血方式 SINGLE String 50
		// ems.setSd_demandsu // 输血需求状态sd SINGLE String 50
		// ems.setSd_mode //预定输血方式sd SINGLE String 50
		// ems.setPregnat_num //孕几胎 SINGLE Integer 10
		// ems.setId_labitmexplain //输血前检查说明id SINGLE String 50
		// ems.setName_labitmexplain //输血前检查说明 SINGLE String 50
		// ems.setSd_labitmexplain //输血前检测项目说明 REF String 50
		ems.setDt_bt(tm); // 输血日期 SINGLE											
		ems.setDt_create(tm); // 开立时间 SINGLE
																// FDateTime 19
		// ems.setId_bttp // 血液品种id REF 血液品种_自定义档案 20 血液品种_自定义档案
		// ems.setName_bttp // 血液品种 SINGLE String 50
		// ems.setSd_bttp // 血液品种sd SINGLE String 50
		// ems.setId_demandsu // 输血需求状态id REF 20
		// ems.setName_demandsu // 输血需求状态
		
		ems.setUse_days(1);
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(med.getId_freq(), ems.getUse_days());
		ems.setTimes_cur(totalTimes);
		
		ems.setDt_begin_ui(tm);		// SINGLE
		ems.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),tm.getUFTime()));																// String															// 50
		
	
		return ems;
	}

	/**
	 * 动态指标
	 * 
	 * @param ctx
	 * @param id_srvof
	 * @return
	 * @throws BizException
	 */
	protected OrdApSugViewItemDO[] ordApSugViewItemListFrom(CiEnContextDTO ctx, String id_srvof) throws BizException {
		// 获取医疗单维护 -- 医疗单注册服务
		IEmsregistryRService emsMgrService = ServiceFinder.find(IEmsregistryRService.class);
		if (null == emsMgrService)
			return null;

		EmsregistryAggDO emsRegAggDo = emsMgrService.findById(id_srvof);

		if (null == emsRegAggDo) {
			return null;
		}

		if (emsRegAggDo.getParentDO() == null)
			return null;

		FBoolean fg_dyncitm_en = emsRegAggDo.getParentDO().getFg_dyncitm_crossentp();
		Integer eu_dyncitmunit = emsRegAggDo.getParentDO().getEu_dyncitmunit();// 指标周期类型
		Integer dyncitmunitct = emsRegAggDo.getParentDO().getCnt_dyncitmunit();

		EmsDynamicParamDTO paramDto = new EmsDynamicParamDTO();
		paramDto.setId_ems(id_srvof);
		paramDto.setFg_dyncitm_en(fg_dyncitm_en.booleanValue());
		paramDto.setEu_dyncitmunit(eu_dyncitmunit);
		paramDto.setId_ent(ctx.getId_en());
		paramDto.setId_pat(ctx.getId_pat());
		paramDto.setDyncitmunitct(dyncitmunitct);

		IBdSrvQryService qryService = ServiceFinder.find(IBdSrvQryService.class);
		if (null == qryService) {
			return null;
		}
		EmsDynamicIndexDTO[] dtos = qryService.getEmsDynamicIndexInfos(paramDto);
		// Datatype为编辑类型，0：输入框，其他为：下拉框
		List<OrdApSugViewItemDO> rstList = new ArrayList<OrdApSugViewItemDO>();
		for (EmsDynamicIndexDTO dto : dtos) {
			OrdApSugViewItemDO item = new OrdApSugViewItemDO();
			{
				item.setVal_rstrptla(dto.getIndexval() == null ? "" : dto.getIndexval());
				item.setVal_restrptlab(dto.getEnumvalues() == null ? "" : "|" + dto.getEnumvalues().replace(',', '|'));
				item.setSd_restrptlabtp(dto.getDatatype());
				item.setName_srv(dto.getShowname());
				item.setName_unit(dto.getUnitname());
				item.setId_unit(dto.getId_unit());
				item.setId_srv(dto.getId_srv());
			}
			;
			rstList.add(item);
		}

		return rstList.toArray(new OrdApSugViewItemDO[rstList.size()]);
	}
}
