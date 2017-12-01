package iih.ci.ord.s.ems.biz.op.emsv1.opr.bp;

import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApOpDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.d.OrdOpEmpDO;
import iih.ci.ord.cior.d.OrdOpMmDO;
import iih.ci.ord.ciordems.d.EmsItemInOp;
import iih.ci.ord.ciordems.d.EmsOpitemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 手术医疗单的加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsOprLoadBP extends EmsBaseLoadBP {

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败",CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());
		
		EmsOpitemDO ems = emsOpitemInfoFrom(arg.getEnContext(),ciEmsInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO()	);
        
     // 获取执行科室
 		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(arg.getEnContext(), medSrvAggInfo.getParentDO(), "", "");
 		if (null == wf) {
 			// 封装错误信息
 			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
 			return rsts;
 		}
 		
 		// 保存执行科室过滤条件
 		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
 		// 保存物资流向
 		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
 		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
 		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

        // 医疗单模型文档
 		rst.setDocument(handleReturnDocument(ems));
// 		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
        // 医疗单类型
        rst.setEmsDriver(EmsType.OPER.toString());
        return rsts;
	}

	/**
	 * 构建手术医疗单主模型信息
	 * @param ctx
	 * @param dto
	 * @return
	 * @throws BizException
	 */
	public EmsOpitemDO emsOpitemInfoFrom(CiEnContextDTO ctx, CiEmsDTO dto) throws BizException {
        // 
		EmsOpitemDO ems  = new EmsOpitemDO();
        
		// 获取医疗单服务项目中的主服务
        CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx,dto);
        if (mainSrvInfo == null) {
            throw new BizException("解析手术医疗单时候，没有获取到主服务项目",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
        }
       
        CiorappsurgeryAggDO orAppSurgeryAggInfo = (CiorappsurgeryAggDO) dto.getOrapplysheet().get((EmsType.OPER).toString());
        if (orAppSurgeryAggInfo == null) {
            throw new BizException("解析手术医疗单时候，没有获取到申请单信息",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APPSHEET_NULL);
        }
        ems.setId_or(dto.getId_or());
        ems.setId_mp_dep ( mainSrvInfo.getId_dep());
        ems.setName_mp_dep ( mainSrvInfo.getName_dep());
        ems.setId_srv ( dto.getId_srv());
        ems.setName_srv ( dto.getName());
        ems.setId_orsrv ( mainSrvInfo.getId_orsrv());

        
        constructMainModelInfo(ctx, ems, dto, mainSrvInfo,orAppSurgeryAggInfo);
        constructApopEmpInfo(ems, orAppSurgeryAggInfo);
        ConstructApopMmInfo(ems, orAppSurgeryAggInfo);
        constructApopAppendInfo(ems, dto);
        constructIndicatorInfo(ems, orAppSurgeryAggInfo);
        ems.setStatus(DOStatus.UPDATED);
        return ems;
    }
	
	/**
	 * 构建主手术医疗单模型信息
	 * @param ctx
	 * @param ems
	 * @param dto
	 * @param srvCommon
	 * @param orAppSurgeryAggInfo
	 * @throws BizException
	 */
	private void constructMainModelInfo(CiEnContextDTO ctx,EmsOpitemDO ems, CiEmsDTO dto, 
CiEmsSrvDTO srvCommon,CiorappsurgeryAggDO orAppSurgeryAggInfo) throws BizException {
        
        OrdApOpDO op = orAppSurgeryAggInfo.getParentDO();
        
        ems.setId_apop ( op.getId_apop());
        //麻醉方法
        ems.setId_anestp ( op.getId_anestp());
        ems.setSd_anestp ( op.getSd_anestp());
        ems.setName_anestp ( op.getName_anestp());
        ems.setId_di ( op.getId_di());
        ems.setName_diag ( op.getName_didef_dis());
        //诊断信息
        ems.setId_di ( op.getId_di());//主诊断的主项目id
        ems.setId_diitm ( op.getId_diitm());//主诊断id
        ems.setName_diag ( op.getName_diag());//主诊断名称
        DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
        if (diagOutlineInfo != null)
        {
            ems.setStr_code_di ( diagOutlineInfo.getStr_code_di());//诊断编码拼接
            ems.setStr_name_di ( diagOutlineInfo.getStr_name_di());//诊断名称拼接
            ems.setStr_id_diitm ( diagOutlineInfo.getStr_id_diitm());//诊断子项目id拼接
        }
        //Id_diitm = null,
        ems.setId_emp_help1 ( op.getId_emp_helper());
        ems.setName_emp_help1 ( op.getName_helper());
        ems.setId_emp_operator ( op.getId_emp_operate());
        ems.setName_emp_operator ( op.getName_operate());
        //切口愈合等级
        ems.setId_incitp ( op.getId_incitp());
        ems.setSd_incitp ( op.getSd_incitp());
        //手术级别
        ems.setId_lvlsug ( op.getId_lvlsug());
        ems.setSd_lvlsug ( op.getSd_lvlsug());
        ems.setName_lvlsug ( op.getName_lvlsug());
        //emsHeadDO.Id_or ( op.getId_or());
      
        ems.setCode_srv ( op.getId_srv_code());
        //体位
        ems.setId_sugbodycod ( op.getId_sugbody());
        ems.setSd_sugbodycod ( op.getSd_sugbody());
        ems.setName_sugbodycod ( op.getName_sugbody());
        //手术申请状态
        //Id_su_op ( null,
        //Sd_su_op ( null,
        ems.setFg_allergy ( op.getFg_allergy());
        ems.setFg_new_sug ( op.getFg_new_sug());
        ems.setFg_patho ( op.getFg_patho());
        ems.setFg_er_sug ( op.getFg_er_sug());
        ems.setFg_xq_sug ( op.getFg_xq_sug());
        ems.setFg_zq_sug ( op.getFg_zq_sug());
        ems.setDt_plan ( op.getDt_plan());
        ems.setDt_creat ( dto.getDt_begin());
        ems.setNo_applyform ( op.getNo_applyform());
        ems.setQuan_bt_plan ( op.getQuan_bt_paln());
        ems.setTime_sup_plan ( op.getSugplantime());
        ems.setSpecialdes ( op.getSpecialdes());
        ems.setSpecialinstrument ( op.getSpecialinstrument());
        ems.setSpecialreq ( op.getSpecialreq());
        ems.setAnnouncements ( op.getAnnouncements());
        ems.setStatus ( DOStatus.UNCHANGED);
        ems.setPrice ( srvCommon.getPrice());
        ems.setDes ( srvCommon.getDes_srv());
        // 剂量和频次信息
        ems.setId_unit_med ( srvCommon.getId_unit_med());
        ems.setName_unit_med ( srvCommon.getName_unit_med());
        ems.setQuan_med ( srvCommon.getQuan_med());
        ems.setId_freq ( srvCommon.getId_freq());
        ems.setName_freq ( srvCommon.getName_freq());
        ems.setFreqct ( srvCommon.getFreqct());
       
    }
	
	/**
	 * 构建手术人员信息
	 * @param ems
	 * @param orAppSurgeryAggInfo
	 */
	private void constructApopEmpInfo(EmsOpitemDO ems, CiorappsurgeryAggDO orAppSurgeryAggInfo) {

		OrdOpEmpDO[] szOrdOpEmpInfo = orAppSurgeryAggInfo.getOrdOpEmpDO();
		if (szOrdOpEmpInfo == null)
			return;

		FArrayList listOpEmpItem = new FArrayList();
		for (OrdOpEmpDO emp : szOrdOpEmpInfo) {
			EmsItemInOp empItemInfo = new EmsItemInOp();
			
			empItemInfo.setId_oropitem(emp.getId_apopemp());
			empItemInfo.setId_emp_op(emp.getId_emp());
			empItemInfo.setName_emp_op(emp.getName_emp());
			empItemInfo.setId_role(emp.getId_role());
			empItemInfo.setSd_role(emp.getSd_role());
			empItemInfo.setName_role(emp.getName_role());
			empItemInfo.setStatus(DOStatus.UNCHANGED);
			
			listOpEmpItem.add(empItemInfo);

		}
		ems.setOpPersonList(listOpEmpItem);
	}
	
	/**
	 * 构建手术物品信息
	 * @param ems
	 * @param orAppSurgeryAggInfo
	 */
	private void ConstructApopMmInfo(EmsOpitemDO ems,  CiorappsurgeryAggDO orAppSurgeryAggInfo) {
        
		OrdOpMmDO[] szOrdOpMmInfo = orAppSurgeryAggInfo.getOrdOpMmDO();
        if (szOrdOpMmInfo == null)
            return;

        FArrayList listMmItem = new FArrayList(); 
        for (OrdOpMmDO mm : szOrdOpMmInfo) {
            EmsItemInOp mmItem = new EmsItemInOp ();
           
        	mmItem.setId_oropitem ( mm.getId_apopmm());
        	mmItem.setId_mm ( mm.getId_mm());
        	mmItem.setName_mm ( mm.getName_mm());
        	mmItem.setId_mmtp ( mm.getId_mmtp());
        	mmItem.setSd_mmtp ( mm.getSd_mmtp());
        	mmItem.setName_mmtp ( mm.getName_mmtp());
        	mmItem.setSpec ( mm.getSpec());
        	mmItem.setId_sup ( mm.getId_sup());
        	mmItem.setName_sup ( mm.getName_sug());
        	mmItem.setPrice ( mm.getPrice());
        	mmItem.setQuan_cur ( mm.getQuan_cur());
        	mmItem.setId_unit_pkgsp ( mm.getId_unit_pkgsp());
        	mmItem.setName_unit_pkgsp ( mm.getName_unit_pkgsp());
        	mmItem.setStatus ( DOStatus.UNCHANGED);
            
            listMmItem.add(mmItem);
            ems.setOpDrugList(listMmItem);
        }
    }
	
	/**
	 * 构建附加手术信息
	 * @param ems
	 * @param dto
	 */
	 private void constructApopAppendInfo(EmsOpitemDO ems, CiEmsDTO dto) {
         
         // 分拣附加手术项目：项目列表中，排除主医嘱项目，排除非临床项目 -- wangqzh
		 FArrayList listAppendItem = new FArrayList();
		 for (Object objInfo : dto.getEmssrvs()){
			 CiEmsSrvDTO srvInfo = (CiEmsSrvDTO)objInfo;
			 
			 if (!srvInfo.getId_srv().equals(dto.getId_srv()) && CiOrdUtils.isTrue(srvInfo.getFg_or())){
				 EmsItemInOp itemInfo = new EmsItemInOp();
				 itemInfo.setName_srv ( srvInfo.getName_srv());
				 itemInfo.setId_srv ( srvInfo.getId_srv());
				 itemInfo.setCode_srv ( srvInfo.getCode_srv());
				 itemInfo.setDes_op ( srvInfo.getDes_srv());
				 itemInfo.setId_orsrv ( srvInfo.getId_orsrv());
				 itemInfo.setStatus ( DOStatus.UNCHANGED);
				 listAppendItem.add(itemInfo);
			 }
		 }
		 ems.setOpAppendList(listAppendItem);
         
     }
	
	/**
	 * 构建动态指标信息
	 * @param ems
	 * @param agg
	 */
	 private void constructIndicatorInfo(EmsOpitemDO ems, CiorappsurgeryAggDO agg) {
         
		 OrdApSugViewItemDO[] szOrdApSugViewItemInfo = agg.getOrdApSugViewItemDO();
        
         FArrayList listOpLabItem = new FArrayList();
         for (OrdApSugViewItemDO apSugItemInfo : szOrdApSugViewItemInfo) {
        	 OrdApSugViewItemDO apViewItemInfo = new OrdApSugViewItemDO();
        	 apViewItemInfo.setVal_rstrptla ( apSugItemInfo.getVal_rstrptla() == null ? "" : apSugItemInfo.getVal_rstrptla());
        	 apViewItemInfo.setVal_restrptlab ( apSugItemInfo.getVal_restrptlab() == null ? "" : apSugItemInfo.getVal_restrptlab().replace(',', '|'));
        	 apViewItemInfo.setSd_restrptlabtp ( apSugItemInfo.getSd_restrptlabtp());
        	 apViewItemInfo.setName_srv( apSugItemInfo.getName_srv() == null ? "" : apSugItemInfo.getName_srv());
        	 apViewItemInfo.setName_unit ( apSugItemInfo.getName_unit() == null ? "" : apSugItemInfo.getName_unit());
        	 apViewItemInfo.setId_unit ( apSugItemInfo.getId_unit());
        	 apViewItemInfo.setId_srv ( apSugItemInfo.getId_srv());
        	 apViewItemInfo.setId_apopobsindex ( apSugItemInfo.getId_apopobsindex());
        	 apViewItemInfo.setId_apop ( apSugItemInfo.getId_apop());
        	 apViewItemInfo.setSv ( apSugItemInfo.getSv());
        	 apViewItemInfo.setId_restrptlabtp ( apSugItemInfo.getId_restrptlabtp());
        	 apViewItemInfo.setDs ( apSugItemInfo.getDs());
        	 apViewItemInfo.setStatus ( DOStatus.UNCHANGED);
        	 apViewItemInfo.setId_apopobsindex(apSugItemInfo.getId_apopobsindex());
        	 listOpLabItem.add(apViewItemInfo);

         }
         ems.setOpCheckIndicatorList(listOpLabItem);

     }
	
}
