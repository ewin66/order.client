package iih.ci.ord.s.ems.biz.op.ems.treat.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.ci.ord.s.ems.define.StringList;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.material.i.IMaterialStockService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 治疗医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsTreatLoadBP extends EmsBaseLoadBP {

	@Override
	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		EmsRstDTO[] rsts = super.load(args);
		EmsLoadDTO arg = args[0];
		EmsRstDTO rst = rsts[0];
		
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		MedsrvAggDO medSrvAggInfo = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv());
		
		EmsDrugItemDO ems = modelFrom(arg.getEnContext(),ciEmsInfo,medSrvAggInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, medSrvAggInfo.getParentDO());
        
        // 获取执行科室
 		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(arg.getEnContext(), medSrvAggInfo.getParentDO(), "", "");
 		if (null == wf) {
 			// 封装错误信息
 			FArrayList errorlist=new FArrayList();
			errorlist.append("获取执行科室失败");
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
        rst.setEmsDriver(EmsType.COMMON.toString());
        return rsts;
	}

	/**
	 * 构建药品医疗单模型信息
	 * @param dtoO
	 * @param medSrvAggInfo
	 * @return
	 * @throws BizException
	 */
	public EmsDrugItemDO modelFrom(CiEnContextDTO ctx, CiEmsDTO dto,MedsrvAggDO medSrvAggInfo) throws BizException {
		EmsDrugItemDO emsDrugItemInfo = new EmsDrugItemDO();
		emsDrugItemInfo.setDt_begin_ui ( dto.getDt_begin());
		emsDrugItemInfo.setDt_end_ui ( dto.getDt_end());
		emsDrugItemInfo.setUse_days(dto.getDays_or());
		emsDrugItemInfo.setTimes_cur ( dto.getTimes_cur());
		emsDrugItemInfo.setTimes_mp_in ( dto.getTimes_mp_in());

     
		constructDrugInfo(emsDrugItemInfo,dto);
        
        MedSrvDO medSrvInfo = medSrvAggInfo.getParentDO();

        
        CiEmsSrvDTO mainSrvInfo = this.mainSrvInfoFrom(ctx,dto);
        if (mainSrvInfo != null)
        {
            emsDrugItemInfo.setQuan_med( mainSrvInfo.getQuan_med());
            emsDrugItemInfo.setId_unit_med ( mainSrvInfo.getId_unit_med());
            emsDrugItemInfo.setName_unit_med ( mainSrvInfo.getName_unit_med());
        }
        else {
            emsDrugItemInfo.setQuan_med ( medSrvInfo.getQuan_med());
            emsDrugItemInfo.setId_unit_med ( medSrvInfo.getId_unit_med());
            emsDrugItemInfo.setName_unit_med ( medSrvInfo.getMed_name());
        }
        emsDrugItemInfo.setId_or(dto.getId_or());
        emsDrugItemInfo.setId_dep ( dto.getId_dep_mp());
        emsDrugItemInfo.setName_dep ( dto.getName_dep_mp());
        //emsDrugItemInfo.setId_freq ( dto.getId_freq());
        emsDrugItemInfo.setId_route ( dto.getId_route());
        emsDrugItemInfo.setId_routedes ( dto.getId_routedes());
        emsDrugItemInfo.setId_srv ( dto.getId_srv());
        emsDrugItemInfo.setSd_srvtp ( dto.getSd_srvtp());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
		// 是否多剂量
//		emsDrugItemInfo.setIsmuldose(FBoolean.TRUE);
        emsDrugItemInfo.setIsmuldose(medSrvInfo.getIsmuldose());
		// 是否多次执行
//		emsDrugItemInfo.setIsmulexec(FBoolean.TRUE);
        emsDrugItemInfo.setIsmulexec(medSrvInfo.getIsmulexec());
/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
        //
        FArrayList drugItemList = new FArrayList();
        drugItemList.append(drugItemFrom(mainSrvInfo,emsDrugItemInfo,dto, medSrvAggInfo));
        emsDrugItemInfo.setEmsOrDrugListEx(drugItemList);
        emsDrugItemInfo.setStatus(DOStatus.UPDATED);
        return emsDrugItemInfo;
    }
	
	/**
	 * 构建药品主信息  -- 同 药品
	 * @param emsDrugItemInfo
	 * @param dto
	 */
    private void constructDrugInfo(EmsDrugItemDO emsDrugItemInfo, CiEmsDTO dto) {
        emsDrugItemInfo.setDt_begin_ui ( dto.getDt_begin()); //开始日期	SINGLE	FDateTim 	 	
        emsDrugItemInfo.setDt_end_ui ( dto.getDt_end()); //结束日期	SINGLE	FDateTim 
        emsDrugItemInfo.setUse_days ( dto.getDays_or()); //医嘱天数	SINGLE	Integer
        emsDrugItemInfo.setTimes_cur ( dto.getTimes_cur());//医嘱次数
        emsDrugItemInfo.setTimes_mp_in ( dto.getTimes_mp_in());//在院执行次数 	

        emsDrugItemInfo.setId_srv ( dto.getId_srv());
        emsDrugItemInfo.setName_srv ( dto.getName());
        emsDrugItemInfo.setSd_srvtp ( dto.getSd_srvtp());
        emsDrugItemInfo.setId_srvtp ( dto.getId_srvtp());
        emsDrugItemInfo.setNote_or ( dto.getNote());
        emsDrugItemInfo.setFg_long ( dto.getFg_long());
        //长临标识	 	 				 	 	 	 	 	 				 	 			 	 	 			 	 	 	 	 	 				 	 			 	 	 	
        emsDrugItemInfo.setId_freq ( dto.getId_freq()); //医嘱频次	REF	医嘱频次定义	 	 	
        emsDrugItemInfo.setName_freq ( dto.getName_freq()); //医嘱频次名称	SINGLE	String	
        emsDrugItemInfo.setFreqct ( dto.getFreqct());//zwq 2016-09-06
        emsDrugItemInfo.setSd_frequnitct ( dto.getSd_frequnitct());//zwq 2016-09-06
        emsDrugItemInfo.setId_route ( dto.getId_route()); //用法	REF	医疗服务_医疗用法	 	 	
        emsDrugItemInfo.setName_route ( dto.getName_route()); //用法名称	SINGLE	String	 	
        emsDrugItemInfo.setId_routedes ( dto.getId_routedes()); //用法要求	REF	医疗用法要求	 	 	 	
        emsDrugItemInfo.setName_routedes ( dto.getName_routedes()); //用法要求描述	SINGLE	String	 	
        emsDrugItemInfo.setId_boil ( dto.getId_boil()); // 煎法	REF	医疗服务中药煎法	 	 	 	 	
        emsDrugItemInfo.setName_boil ( dto.getName_boil()); //煎法名称	SINGLE	String	 	
        emsDrugItemInfo.setId_boildes ( dto.getId_boildes()); //煎法要求	REF	中药煎法要求	 	 	 	
        emsDrugItemInfo.setName_boildes ( dto.getName_boildes()); //煎法要求名称	SINGLE	String	 	
        emsDrugItemInfo.setFg_boil ( dto.getFg_boil());          //代煎标识	SINGLE	FBoolean 
        emsDrugItemInfo.setOrders ( dto.getOrders()); //医嘱付数	SINGLE	Integer	 	
        emsDrugItemInfo.setOrders_boil ( dto.getOrders_boil()); //代煎付数	SINGLE	Integer	 	
        //dto.getContent(	        //医嘱内容	SINGLE	备注	4000 	
        emsDrugItemInfo.setNote_or ( dto.getNote()); //备注	SINGLE	备注	1000	 
        //emsDrugItemInfo.setid_edto.getId_emp_phy());	    //开立医生	REF	人员基本信息	 	
        //dto.getName_emp_phy	//开立医生姓名	SINGLE	String	 	
        //dto.getId_dep_phy ());	    //开立科室	REF	部门	20	 	 
        //////dto.getName_dep_phy	//开立科室名称	SINGLE	String	 	
        //dto.getId_wg_or ());	    //医疗组	REF	业务组	20	业务 
        
        if (emsDrugItemInfo.getDt_end_ui() != null && emsDrugItemInfo.getDt_end_ui().getYear() > 2098) // 时间控件仅支持到 2099年
            emsDrugItemInfo.setDt_end_ui ( null);
        emsDrugItemInfo.setDt_fail ( dto.getDt_invalid()); //医嘱过期时间	SINGLE	FDateTim 	 	
        //dto.getFg_bb	        //婴儿标识	SINGLE	FBoolean 	 	
        //dto.getNo_bb	        //婴儿序号	SINGLE	Integer	 	
        emsDrugItemInfo.setFg_pmor ( dto.getFg_pmor()); //备用医嘱标识	SINGLE	FBoolean 	 	
        emsDrugItemInfo.setBak_des ( dto.getDes_pmor()); //备用医嘱使用条件描述	SINGLE	 	 	
        //dto.getFg_active_pm= //备用医嘱启用标识	SINGLE	FBoo 	 	 	
        //dto.getId_reltp	    //关联医嘱类型编码	SINGLE	Stri 	 	
        //dto.getSd_reltp	    //关联医嘱类型	SINGLE	String	 	
        //dto.getId_or_rel	    //关联医嘱	SINGLE	String	 	
        //dto.getFg_ctlcp	    //临床路径控制标识	SINGLE	FBoo 	 	 	
        //dto.getFg_mr	        //医疗记录联动标识	SINGLE	FBoo 	 	 	
        // emsDrugItemInfo.setFg_skintest = dto.getFg_skintest; //需皮试标识	SINGLE	FBoolean 	 	
        //dto.getId_skintest_skip_reaso	//不皮试原因	SINGLE	 	 	 	
        //dto.getSd_skintest_skip_reaso	//不皮试原因编码	SING 	 	 	 	
        emsDrugItemInfo.setFg_mp_in ( dto.getFg_mp_in()); //在院执行标识	SINGLE
         	
        //dto.getTimes_mp_in	            //在院执行次数	SINGLE	 	 	 	
        //dto.getFg_mp_bed=emsHeadDO.Emsdrugs	            //床边执行标识	SINGLE	
        //int t;
        //int.TryParse(emsDrugItemInfo.setFirst_freq, out t);
        //emsDrugItemInfo.setFirst_freq = dto.getTimes_firday_mp.ToString(); //首日执行次数	SINGLE	 	 	 	
        dto.setFg_or_doc ( FBoolean.TRUE);	            //医生医嘱标识	SINGLE	 	 	 
        emsDrugItemInfo.setQuan_firday_mp ( dto.getTimes_firday_mp());
        
        emsDrugItemInfo.setId_dep ( dto.getId_dep_mp());//zwq 2016-08-04
        emsDrugItemInfo.setName_dep ( dto.getName_dep_mp());//zwq 2016-08-04
        emsDrugItemInfo.setFg_urgent(dto.getFg_urgent());
        
        

    }


    /**
     * 构建药品项目信息
     * @param mainSrvInfo
     * @param emsDrugItemInfo
     * @param dto
     * @param medSrvAggInfo
     * @return
     * @throws BizException
     */
    private EmsOrDrug drugItemFrom(CiEmsSrvDTO mainSrvInfo,EmsDrugItemDO emsDrugItemInfo,CiEmsDTO dto,MedsrvAggDO medSrvAggInfo) throws BizException{
    	 EmsOrDrug ems = new EmsOrDrug();
         ems.setId_srv ( dto.getId_srv());
         ems.setName_srv ( dto.getName());
         ems.setUse_days ( dto.getDays_or() == null ? 1 : dto.getDays_or());
         
         if ( !CiOrdUtils.isTrue(dto.getFg_set()))
         {
             ems.setFg_bl ( mainSrvInfo.getFg_bl());
             ems.setId_orsrv ( mainSrvInfo.getId_orsrv());
             ems.setId_unit_med ( mainSrvInfo.getId_unit_med()); 
             ems.setName_unit_med ( mainSrvInfo.getName_unit_med());
             ems.setId_pri ( mainSrvInfo.getId_primd());
             ems.setId_freq ( emsDrugItemInfo.getId_freq());
             ems.setName_freq ( emsDrugItemInfo.getName_freq());
             ems.setSd_frequnitct ( emsDrugItemInfo.getSd_frequnitct());
             ems.setFreqct ( emsDrugItemInfo.getFreqct());
             ems.setFg_treat ( mainSrvInfo.getFg_indic());
             ems.setQuan_med ( mainSrvInfo.getQuan_med());
             ems.setQuan_cur ( mainSrvInfo.getQuan_total_medu() ); 
             ems.setPrice ( mainSrvInfo.getPrice()); 
         }
         else {
             ems.setId_unit_med ( emsDrugItemInfo.getId_unit_med());
             ems.setName_unit_med ( emsDrugItemInfo.getName_unit_med());
             ems.setUse_days(emsDrugItemInfo.getUse_days());
             ems.setId_pri ( medSrvAggInfo.getParentDO().getId_primd());
             ems.setId_freq (  emsDrugItemInfo.getId_freq());
             ems.setName_freq ( emsDrugItemInfo.getName_freq());
             ems.setSd_frequnitct (  emsDrugItemInfo.getSd_frequnitct());
             ems.setFreqct (  emsDrugItemInfo.getFreqct());
             ems.setQuan_med ( emsDrugItemInfo.getQuan_med());
             if(mainSrvInfo!=null){
            	 //ems.setQuan_cur ( mainSrvInfo.getQuan_total_medu() ) ; // ???????
            	 CalQuantumBP quantumBP = new CalQuantumBP();
     			 ems.setQuan_cur(quantumBP.getUnMMQuantum(ems.getId_freq(), ems.getUse_days(), ems.getQuan_med()));
             }else{
            	 ems.setQuan_cur(emsDrugItemInfo.getQuan_med());
             }
             ems.setFg_bl ( emsDrugItemInfo.getFg_bl());
             ems.setPrice ( getPrice(medSrvAggInfo));
         }
         ems.setQuan_medu_virtual(ems.getQuan_med());
         ems.setName_unit_medu_virtual(ems.getName_unit_med());
         ems.setId_unit_sale(ems.getId_unit_med());
         ems.setName_unit_sale(ems.getName_unit_med());
         ems.setId_mp_dep ( dto.getId_dep_mp());
         ems.setName_mp_dep ( dto.getName_dep_mp());
         ems.setId_srvtp ( dto.getId_srvtp());
         ems.setSd_srvtp ( dto.getSd_srvtp());
         ems.setNote_or ( dto.getNote());
         ems.setFg_urgent ( dto.getFg_urgent());
         ems.setFg_selfpay((dto.getEu_hpindicjudge()==HpIndicJudgeEnum.SELFPAY?FBoolean.TRUE:FBoolean.FALSE));
         if(mainSrvInfo!=null){
	         ems.setEu_sourcemd(mainSrvInfo.getEu_sourcemd());
	         ems.setEu_blmd(mainSrvInfo.getEu_blmd());
	         ems.setFg_hpindicjudged(mainSrvInfo.getFg_hpindicjudged());
         }
         if (null != ems.getPrice() && ems.getQuan_cur() != null)
        	 ems.setTotalprice ( ems.getPrice().multiply(ems.getQuan_cur()) );
         
         return ems;
    }
    
    
    
    /**
     * 获取套内临床项目列表
     * @param mainAggInfo
     * @param code_entp
     * @param Eu_sourcemd
     * @return
     * @throws BizException
     */
    protected List<CiEmsSrvDTO> getSetClinicalSrvDO(MedsrvAggDO mainAggInfo,String code_entp, int Eu_sourcemd) throws BizException
    {
        List<CiEmsSrvDTO> emslist = new ArrayList<CiEmsSrvDTO>();
        
            MedSrvDO aggParent = mainAggInfo.getParentDO();
            MedSrvSetItemDO[] medSrvSetItems = mainAggInfo.getMedSrvSetItemDO();
            List<MedSrvSetItemDO> listMedSrvSetItem = new ArrayList<MedSrvSetItemDO>();
            StringList listSrvId = new StringList();
            for(int i=0;i<medSrvSetItems.length;i++){
                if (CiOrdUtils.isTrue(medSrvSetItems[i].getFg_clinical())  && 
                		medSrvSetItems[i].getDs() == 0 && 
                		CiOrdUtils.isTrue(medSrvSetItems[i].getFg_active() )) {
                	listMedSrvSetItem.add(medSrvSetItems[i]);
                	listSrvId.add(medSrvSetItems[i].getId_srv_itm());
                }
            }
            MedsrvAggDO[] szMedsrvAggDO = ServiceFinder.find(IMedsrvRService.class).findByIds(listSrvId.toArray(new String[listSrvId.size()]), FBoolean.FALSE);
		if (!CiOrdUtils.isEmpty(szMedsrvAggDO)) {
			for (MedsrvAggDO agg : szMedsrvAggDO) {
				MedSrvDO medsrv = agg.getParentDO();
				CiEmsSrvDTO stvdto = new CiEmsSrvDTO();
				stvdto.setId_srv_set(aggParent.getId_srv());
				stvdto.setFg_set(medsrv.getFg_set());
				stvdto.setId_srv(medsrv.getId_srv());
				stvdto.setId_freq(medsrv.getId_freq());
				stvdto.setId_srvca(medsrv.getId_srvca());
				stvdto.setSd_srvtp(medsrv.getSd_srvtp());
				stvdto.setEu_blmd(medsrv.getEu_blmd());
				stvdto.setFg_mm(medsrv.getFg_mm());
				stvdto.setCode_srv(medsrv.getCode());
				stvdto.setFg_bl(medsrv.getFg_bl());
				stvdto.setId_srvtp(medsrv.getId_srvtp());
				stvdto.setQuan_med(medsrv.getQuan_med());
				stvdto.setId_unit_med(medsrv.getId_unit_med());
				stvdto.setId_route(medsrv.getId_route());
				stvdto.setEu_sourcemd(Eu_sourcemd);
				stvdto.setDes_srv(medsrv.getDes());
				stvdto.setFg_or(FBoolean.TRUE);
				stvdto.setId_primd(medsrv.getId_primd());
				stvdto.setName_srv(medsrv.getName());
				if (CiOrdUtils.isTrue(stvdto.getFg_mm())) {
					MeterialDO[] mms = ServiceFinder.find(IMeterialMDORService.class).find(
							String.format("id_srv='%s' and fg_active='Y' and ds=0 ", stvdto.getId_srv()), "",
							FBoolean.FALSE);
					if (mms != null && mms.length > 0) {
						stvdto.setId_mm(mms[0].getId_mm());
						IMaterialBaseInfoService meterialBaseService = ServiceFinder
								.find(IMaterialBaseInfoService.class);
						MaterialUnitDTO[] materUnit = meterialBaseService
								.getMMunitByEntp(new String[] { mms[0].getId_mm() }, code_entp);
						if (materUnit != null && materUnit.length > 0) {
							stvdto.setId_unit_sale(materUnit[0].getId_measdoc());
						} else {
							stvdto.setId_unit_sale(mms[0].getId_unit_pkgsp());
						}
						stvdto.setName_mm(mms[0].getName());
						stvdto.setId_unit_base(mms[0].getId_unit_pkgbase());

						stvdto.setCode_mm(mms[0].getCode());
						stvdto.setFactor_mb(mms[0].getFactor_mb());
						stvdto.setFactor_cb(mms[0].getFactor_sb());
						stvdto.setId_val(mms[0].getId_val());
						stvdto.setSd_val(mms[0].getSd_val());
						stvdto.setId_mmtp(mms[0].getId_mmtp());
						stvdto.setSd_mmtp(mms[0].getSd_mmtp());
						if (code_entp == IEnDictCodeConst.SD_ENTP_INPATIENT) {
							stvdto.setSd_roundmd(mms[0].getId_mupkgutp());
						} else if (code_entp == IEnDictCodeConst.SD_ENTP_OUTPATIENT) {
							stvdto.setSd_roundmd(mms[0].getSd_opmutp());
						}
						stvdto.setFg_skintest(FBoolean.FALSE);
					}
				}
				emslist.add(stvdto);
			}
		}
            
        
        return emslist;
    }

    /**
     * 获取治疗服务套的总单价
     * @param agg
     * @return
     * @throws BizException
     */
    private FDouble getPrice(MedsrvAggDO agg) throws BizException
    {
        FDouble price = FDouble.ZERO_DBL;
        if (agg == null) return price;
        if (CiOrdUtils.isTrue(agg.getParentDO().getFg_set()))
        {
            List<CiEmsSrvDTO> srvlist = getSetClinicalSrvDO(agg, "00", 0);
            
            for (CiEmsSrvDTO emsdto : srvlist)
            {
                if (CiOrdUtils.isTrue(emsdto.getFg_mm()) ) {
                    price= price.add( getMaterialPrice(emsdto.getId_mm(), emsdto.getId_unit_sale()));    
                }
            }
            // 包含服务本身价格
            price = price.add (calculatePrice(agg.getParentDO()));
        }
        return price;
    }
    
    /**
     * 获取物品价格
     * @param id_mm
     * @param id_unit_sale
     * @return
     * @throws BizException
     */
    protected FDouble getMaterialPrice(String id_mm, String id_unit_sale) throws BizException
    {
        GetStockReqDTO reqDto = new GetStockReqDTO();
        reqDto.setId_mm ( id_mm);
        reqDto.setReq_unit_id ( id_unit_sale);
        GetStockReqDTO[] reqDtoArr = new GetStockReqDTO[1];
        reqDtoArr[0] = reqDto;
        IMaterialStockService service = ServiceFinder.find(IMaterialStockService.class);
        MaterialStockDTO[] materials =  service.getMaterialStocks(reqDtoArr);
        if (materials != null && materials.length > 0)
        {
            return materials[0].getPrice_act();
        }
        else {
            return FDouble.ZERO_DBL;
        }
     }

    /**
     * 医嘱服务计算价格（非物品计价）
     * @param medsrv
     * @return
     * @throws BizException
     */
     protected FDouble calculatePrice(MedSrvDO medsrv) throws BizException
      {
          BdSrvPriCalParamDTO priParam = new BdSrvPriCalParamDTO();
     
          priParam.setId_srv( medsrv.getId_srv() );
          priParam.setId_primd ( medsrv.getId_primd());
          priParam.setNum(  0 );
          // 远程调用
          FDouble price = ServiceFinder.find(ICiOrdQryService.class).ciOrBdSrvPriceCal(priParam);
          
          return price != null?price:FDouble.ZERO_DBL;
      }

}
