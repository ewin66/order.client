package iih.ci.ord.s.ems.biz.op.ems.cons.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.base.define.StringObjectMap;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiordInviteConsDO;
import iih.ci.ord.cior.d.OrdApConsDO;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsItemInCons;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 会诊医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsConsLoadBP extends EmsBaseLoadBP {
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsRstDTO rst = new EmsRstDTO();
		EmsLoadDTO arg = args[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());
		
		EmsConsItemDO ems = modelFrom(arg.getEnContext(),ciEmsInfo,medSrvAggInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());
        
     // 获取执行科室
 		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(arg.getEnContext(), medSrvAggInfo.getParentDO(), "", "");
 		if (null == wf) {
 			// 封装错误信息
 			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
 		}
 		
 		// 保存执行科室过滤条件
 		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
 		// 保存物资流向
 		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
 		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
 		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());

        // 医疗单模型文档
 		 rst.setDocument(this.handleReturnDocument(ems));
 		//rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
        // 医疗单类型
        rst.setEmsDriver(EmsType.COMMONDRUG.toString());
        rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	public EmsConsItemDO modelFrom(CiEnContextDTO ctx, CiEmsDTO dto,MedsrvAggDO medSrvAggInfo) throws BizException {
       
		EmsConsItemDO ems = new EmsConsItemDO();
          
            CiEmsSrvDTO srvCommon = this.mainSrvInfoFrom(ctx,dto); 
            //EditCommonSrv(srvCommon, headDo);
            
            if (dto.getOrapplysheet() != null) {
            	CiorappconsultAggDO ciOrAppConsultAggInfo =(CiorappconsultAggDO)dto.getOrapplysheet().get(EmsType.CONS.toString());
                
            	ConstructApConsInfo(ems, ciOrAppConsultAggInfo, dto, srvCommon);
                constructConsEmpInfo(ems, ciOrAppConsultAggInfo);
            }
        
            return ems;
    }
	
	/**
	 * 构建会诊申请单信息
	 * @param ems
	 * @param ciOrAppConsultAggInfo
	 * @param dto
	 * @param mainSrvInfo
	 * @throws BizException 
	 */
	private void ConstructApConsInfo(EmsConsItemDO ems, CiorappconsultAggDO ciOrAppConsultAggInfo, 
			CiEmsDTO dto, CiEmsSrvDTO mainSrvInfo) throws BizException {

        OrdApConsDO ordApConsInfo = ciOrAppConsultAggInfo.getParentDO();

        ems.setId_emsconsitem ( ordApConsInfo.getId_apcons());	//主键	SINGLE	String	50	  
        //emsSetId_or = cons.Id_or;      //医嘱id	SINGLE	String	50
        ems.setId_srv ( mainSrvInfo.getId_srv());
        ems.setName_srv ( mainSrvInfo.getName_srv());
        //emsSetId_orsrv ( dto.Id_orsrv;
        ems.setFg_urgent ( ordApConsInfo.getFg_urgent());    //加急标识	SINGLE	FBoolean  
        ems.setDt_plan ( ordApConsInfo.getDt_plan());     	//计划会诊时间	SINGLE	FDateTime 
        ems.setTel ( ordApConsInfo.getTel());      	//联系电话	SINGLE	String	2 
        //emsSetId_place ( cons.Id_place;   //申请地点id	REF	地点	20	 	  
        ems.setName_place ( ordApConsInfo.getPlace());    //申请地点名称	SINGLE	String	5 
        ems.setDes_emr ( ordApConsInfo.getDes_emr());        //  病理摘要	SINGLE	备注	300	  
        ems.setDes_psp ( ordApConsInfo.getDes_psp());        //会诊目的	SINGLE	备注	300	  
        ems.setId_dep_cons ( dto.getId_dep_phy());	    // 申请科室id	REF	部门	20	 	  
        ems.setName_dep_cons ( dto.getName_dep_phy());	//申请科室	SINGLE	String	5 
        ems.setDt_creat ( dto.getDt_begin());	    //申请时间	SINGLE	FDateTime 
        ems.setId_emp_cons ( dto.getId_emp_phy());	    //申请人id	REF	用户	20	 	  
        ems.setName_emp_cons ( dto.getName_emp_phy()); //申请人	SINGLE	String
        ems.setId_constp ( ordApConsInfo.getId_constp());
        ems.setSd_constp ( ordApConsInfo.getSd_constp());
        ems.setName_constp ( ordApConsInfo.getName_constp());
        StringObjectMap tmpSrvFilterMap = new StringObjectMap();
        FDouble price = FDouble.ZERO_DBL;
        for (Object objSrv : dto.getEmssrvs())
        {
        	CiEmsSrvDTO srvInfo = (CiEmsSrvDTO)objSrv;
            if (!tmpSrvFilterMap.containsKey(srvInfo.getId_srv()) && CiOrdUtils.isTrue(srvInfo.getFg_bl()))
            {
                tmpSrvFilterMap.put(srvInfo.getId_srv(), srvInfo);
                if (srvInfo.getPrice() != null) {
                	price = price.add(srvInfo.getPrice());    
                }
            }
        }
        ems.setPrice ( price);// 会诊价格
        ems.setDt_begin_ui ( dto.getDt_begin()); //开始日期	SINGLE	FDateTim 	 	
        ems.setDt_end_ui ( dto.getDt_end()); //结束日期	SINGLE	FDateTim 
        ems.setUse_days ( dto.getDays_or()); //医嘱天数	SINGLE	Integer
        ems.setTimes_cur ( dto.getTimes_cur());//医嘱次数
        ems.setTimes_mp_in ( dto.getTimes_mp_in());//在院执行次数
        
        ems.setId_orsrv ( mainSrvInfo.getId_orsrv());
        
        MedSrvConsDO srvcons = getMedSrvConsDO(mainSrvInfo.getId_srv());
        if (srvcons != null){
        	ems.setFg_deps( srvcons.getFg_deps());
            ems.setFg_inorg( srvcons.getFg_inorg());
        }
        ems.setFg_selfpay((dto.getEu_hpindicjudge()==HpIndicJudgeEnum.SELFPAY?FBoolean.TRUE:FBoolean.FALSE));
    }
	
	/**
	 * 构建会诊人员信息
	 * @param ems
	 * @param agg
	 */
	private void constructConsEmpInfo(EmsConsItemDO ems, CiorappconsultAggDO agg) {
        OrdApConsDO cons = agg.getParentDO();
        if (agg.getCiordInviteConsDO() == null)
            return;
        
        FArrayList listEmsItemInCons = new FArrayList();
        for (CiordInviteConsDO item : agg.getCiordInviteConsDO()) {
        	EmsItemInCons emsItemInCons = new EmsItemInCons();
        	
        	emsItemInCons.setId_emsitemincons ( item.getId_invitecons());//主键		主键	SINGLE
                //Sortno	        =item.//    排序号	SINGLE	Integer	10
        	emsItemInCons.setId_org ( item.getId_org());//    受邀机构id	REF	组织	20
        	emsItemInCons.setName_org ( item.getName_org());//受邀机构	SINGLE	String
        	emsItemInCons.setId_dep_emp ( item.getId_dep());//    受邀科室id	REF	部门	20
        	emsItemInCons.setName_dep_emp ( item.getName_dep());//受邀科室	SINGLE	String
        	emsItemInCons.setSd_emp_title ( item.getSd_emp_title());//受邀职称编码	SINGLE	St
        	emsItemInCons.setId_emp_title ( item.getId_emp_title());//受邀职称id	REF	人员聘任职
        	emsItemInCons.setName_emp_title ( item.getName_emp_title());//    受邀职称	SINGLE	String
        	emsItemInCons.setId_emp_doctor ( item.getId_emp());//受邀人id	REF	用户	20
        	emsItemInCons.setName_emp_doctor ( item.getName_emp());//    受邀人	SINGLE	String	50
        	emsItemInCons.setDt_response ( item.getDt_response());//    应答时间	SINGLE	FDateT
        	emsItemInCons.setFg_response ( item.getFg_response());//应答标志	SINGLE	FBoole
        	emsItemInCons.setId_emp_response ( item.getId_emp_response());//    应答人id	REF	用户	20
        	emsItemInCons.setName_emp_response ( item.getName_emp_respon());//应答人	SINGLE	String	50
                ////Id_srv	        =item.//    会诊项目id	REF	医疗服务	
                //Name_srv	        =item.//会诊项目	SINGLE	String
        	emsItemInCons.setSd_constp ( cons.getSd_constp());//会诊类型编码	SINGLE	St
        	emsItemInCons.setId_constp ( cons.getId_constp());//会诊类型id	REF	会诊类型_自
        	emsItemInCons.setName_constp ( cons.getName_constp());//    会诊类型	SINGLE	String
        	emsItemInCons.setSv (item.getSv()); // ????? 后加 

        	listEmsItemInCons.add(emsItemInCons);
        }
        ems.setConsAssList(listEmsItemInCons);

    }
	
	
	/**
	 * 获取会诊服务DO
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public MedSrvConsDO getMedSrvConsDO(String id_srv) throws BizException
    {
        MedSrvConsDO[] conslist = ServiceFinder.find(IMedSrvConsDORService.class).find(" id_srv='"+id_srv+"'", null, FBoolean.FALSE);
        if (conslist==null || conslist.length == 0)
            return null;
        return conslist[0];
    }
	
}
