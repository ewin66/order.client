package iih.ci.ord.s.ems.biz.op.emsv1.cons.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvConsDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedSrvConsDORService;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.ciordems.d.EmsItemInCons;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsPriceUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
/**
 * 会诊医疗单创建业务实现
 * @author wangqingzhu
 *
 */
public class EmsConsCreateBP extends EmsBaseCreateBP {

public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		EmsCrtDTO ems = emsarray[0];
		EmsRstDTO rst = new EmsRstDTO();
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		// 合成主UI模型对象
		EmsConsItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		if(null == emsModel){
			emsModel = emsModelFrom(aggDO.getParentDO());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(),emsModel);
		}
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm);		// SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),tm.getUFTime()));	
			
			emsModel.setDt_plan ( CiOrdAppUtils.getServerDateTime());   	//计划会诊时间	SINGLE	FDateTime 
			emsModel.setDt_creat ( CiOrdAppUtils.getServerDateTime());	    //申请时间	SINGLE	FDateTime 
			emsModel.setNo_applyform ( CiOrdUtils.getApplyNo(aggDO.getParentDO().getSd_srvtp()));
		}
		emsModel.setTel ( ems.getEnContext().getDept().getTel());        	//联系电话	SINGLE	String	2 
		emsModel.setId_dep_cons ( ems.getEnContext().getDept().getId_dep());    // 申请科室id	REF	部门	20	 	  
		emsModel.setName_dep_cons ( ems.getEnContext().getDept().getName());	//申请科室	SINGLE	String	5 
		emsModel.setId_emp_cons ( ems.getEnContext().getUser().getId_user());	    //申请人id	REF	用户	20	 	  
		emsModel.setName_emp_cons ( ems.getEnContext().getUser().getName());	//申请人	SINGLE	String         
        if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ems.getEnContext().getCode_entp())) 
        {
            // 住院 会诊地点是患者床旁 就诊科室+就诊病区+床号
        	emsModel.setName_place (ems.getEnContext().getEnt4BannerDTO().getName_dep_phy() + ems.getEnContext().getEnt4BannerDTO().getName_dep_nur() +
        			ems.getEnContext().getEnt4BannerDTO().getName_bed());    //申请地点名称	SINGLE	String	5 
        }
        else if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ems.getEnContext().getEnt4BannerDTO().getCode_entp()) || 
        		IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(ems.getEnContext().getEnt4BannerDTO().getCode_entp()))
        {   
            // 门诊、急诊 会诊地点是就诊科室所在地址，如果地址为空使用就诊科室
        	
            DeptDO dept = ServiceFinder.find(IDeptRService.class).findById(ems.getEnContext().getEnt4BannerDTO().getId_dep_phy());
            emsModel.setName_place ( CiOrdUtils.isEmpty(dept.getId_plc()) ? dept.getName() : dept.getId_plc());
        }           
        else
        {
            // 其他就诊类型
        }
     // 价格
        emsModel.setPrice(OrderEmsPriceUtils.calculatePrice(aggDO.getParentDO(),ems.getEnContext().getEnt4BannerDTO().getId_pripat()));
        emsModel.setStatus(DOStatus.NEW);
     // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO()	);
        // 返回值处理
        rst.setDocument(handleReturnDocument(emsModel));
//        rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.CONS.toString());
		
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 构造会诊模型主数据
	 * @param ctx
	 * @param med
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	protected EmsConsItemDO emsModelFrom(MedSrvDO med) throws BizException{
		EmsConsItemDO ems = new EmsConsItemDO();
		//ems.setId_emsconsitem(不对照)	//主键	SINGLE	String	50	  
	    //ems.setId_or(不对照)	        //医嘱id	SINGLE	String	50	
	    ems.setNo_applyform ( CiOrdUtils.getApplyNo(med.getSd_srvtp()));
	    ems.setId_srv ( med.getId_srv());
	    ems.setName_srv ( med.getName());
	    ems.setFg_urgent ( FBoolean.FALSE);	    //加急标识	SINGLE	FBoolean  
	    ems.setDt_plan ( CiOrdAppUtils.getServerDateTime());   	//计划会诊时间	SINGLE	FDateTime 
	    ems.setDt_creat ( CiOrdAppUtils.getServerDateTime());	    //申请时间	SINGLE	FDateTime 
	    //ems.setId_place	    //申请地点id	REF	地点	20
	    
	    EmsItemInCons item = new EmsItemInCons();
	    MedSrvConsDO srvcons = getMedSrvConsDO(med.getId_srv());
	    if (srvcons != null)
	    {
	        item.setId_constp( srvcons.getId_constp());
	        item.setName_constp( srvcons.getName_constp());
	        item.setSd_constp( srvcons.getSd_constp());
	        ems.setId_constp( srvcons.getId_constp());
	        ems.setSd_constp( srvcons.getSd_constp());
	        ems.setName_constp( srvcons.getName_constp());
	        ems.setFg_deps( srvcons.getFg_deps());
	        ems.setFg_inorg( srvcons.getFg_inorg());
	        ems.setPrice( (med.getPri() == null ? FDouble.ZERO_DBL : med.getPri()));
	    }
	    
	    //ems.setDes_emr	        //  病理摘要	SINGLE	备注	300	  
	    //ems.setDes_psp	        //会诊目的	SINGLE	备注	300	  
	    FArrayList consAssList = new FArrayList();
	    {
	        consAssList.add(item);
	        ems.setConsAssList(consAssList);
	    }
	    
	    FArrayList consItemList = new FArrayList();
	    {
	        consItemList.add(item);
	        ems.setConsAssList(consItemList);
	    }
	    
	    
	    // 受邀科室
	    ems.setId_dep_emp(null);
	    ems.setName_dep_emp(null);
	    
	    return ems;
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
