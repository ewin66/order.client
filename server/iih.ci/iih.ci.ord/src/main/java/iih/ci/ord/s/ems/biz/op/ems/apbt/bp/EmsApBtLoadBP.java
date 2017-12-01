package iih.ci.ord.s.ems.biz.op.ems.apbt.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.srv.dto.d.EmsDynamicParamDTO;
import iih.bd.srv.ems.d.EmsDynamicIndexDTO;
import iih.bd.srv.ems.d.EmsregistryAggDO;
import iih.bd.srv.ems.i.IEmsregistryRService;
import iih.bd.srv.i.IBdSrvQryService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdApBtViewItemDO;
import iih.ci.ord.cior.d.OrdApSugViewItemDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.DiagOutlineInfo;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseLoadBP;
import iih.ci.ord.s.ems.biz.utils.DiagInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单加载逻辑
 * @author wangqingzhu
 *
 */
public class EmsApBtLoadBP extends EmsBaseLoadBP {

	public EmsRstDTO[] load(EmsLoadDTO[] args) throws BizException {
		// TODO Auto-generated method stub
		EmsLoadDTO arg = args[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		
		// 获取医疗单 DTO对象结构
		CiEmsDTO ciEmsInfo = ciEmsInfoFrom(arg.getId_or());
		if (null == ciEmsInfo){
			throw new BizException ("获取医疗单信息失败", CiOrdemsErrorCodeEnum.ERRORCODE_ORDER_ISNULL);
		}
		
		
        MedSrvDO med = ServiceFinder.find(IMedsrvRService.class).findById(ciEmsInfo.getId_srv()).getParentDO();
        
        EmsBtItemDO ems = emsBtItemDOFrom(arg.getEnContext(),ciEmsInfo);
        // 医疗单对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, ciEmsInfo);
        // 主服务对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, med);
        
        // 用血模型对象
        OrderEmsExtInfoUtils.SetCustomInfo(rst, this.ciOrdubInfoFrom(arg.getId_or(), med));
        
        // 医疗单模型文档
        rst.setDocument(this.handleReturnDocument(ems));
//        rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(ems.serializeJson()));
        // 医疗单类型
        rst.setEmsDriver(EmsType.BT.toString());
        rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

	/**
	 * 构建备血申请单模型
	 * @param ctx
	 * @param ciEmsInfo
	 * @return
	 * @throws BizException
	 */
	private EmsBtItemDO emsBtItemDOFrom(CiEnContextDTO ctx, CiEmsDTO ciEmsInfo) throws BizException {

		CiEmsSrvDTO mainSrvInfo = null;
		if (CiOrdUtils.isTrue(ciEmsInfo.getFg_set())){
			mainSrvInfo = new CiEmsSrvDTO();
			mainSrvInfo.setStatus(DOStatus.UPDATED);
			mainSrvInfo.setId_srv(ciEmsInfo.getId_srv());
			mainSrvInfo.setName_srv(ciEmsInfo.getName());
			mainSrvInfo.setSd_srvtp(ciEmsInfo.getSd_srvtp());
			mainSrvInfo.setInnercode_srvca(ciEmsInfo.getInnercode_srvca());
			mainSrvInfo.setId_emp_srv(ciEmsInfo.getId_emp_phy());
			mainSrvInfo.setDt_create_srv(ciEmsInfo.getDt_begin());
			mainSrvInfo.setQuan_med(ciEmsInfo.getQuan_medu());
			mainSrvInfo.setId_unit_med(ciEmsInfo.getId_unit_med());
			mainSrvInfo.setName_unit_med(ciEmsInfo.getName_unit_med());
		}
		else{
        for ( Object item : ciEmsInfo.getEmssrvs()) {
        	CiEmsSrvDTO srv = (CiEmsSrvDTO) item;
           if (srv.getId_srv().equals(ciEmsInfo.getId_srv())){
        	   mainSrvInfo = srv;
        	   break;
           }
        }
		}
		
       
  
       return emsBtItemDOFrom(ctx, ciEmsInfo, mainSrvInfo);
        
    }
	
	/**
	 * 构建备血模型数据
	 * @param ctx
	 * @param dto
	 * @param srv
	 * @return
	 * @throws BizException
	 */
	public EmsBtItemDO emsBtItemDOFrom(CiEnContextDTO ctx, CiEmsDTO dto, CiEmsSrvDTO srv) throws BizException {
		EmsBtItemDO ems = new EmsBtItemDO();
		
        ems.setDt_bt ( dto.getDt_begin());
        ems.setDt_create(dto.getDt_begin());
        // 获取申请单信息
        Object objInfo = dto.getOrapplysheet().get((EmsType.BT).toString()) ;
        if (null == objInfo){
        	throw new BizException("该医嘱存在异常，申请单信息丢失",-1001);
        }
        CiorappbtAggDO agg = (CiorappbtAggDO)objInfo;

        OrdApBtDO bt = agg.getParentDO();
        

        // 列表中服务名称
        ems.setComponents_name ( dto.getName());
        //ems.seti
        ems.setId_emsbt ( bt.getId_apbt());
        ems.setNo_applyform ( bt.getNo_applyform());
        ems.setPregnat_num ( bt.getPregnant_num());
        ems.setParturition_cnt ( bt.getParturition_cnt());

        ems.setFg_db ( bt.getFg_db());
        ems.setNo_db ( bt.getNo_db());


        //诊断信息
        ems.setId_di ( bt.getId_di());
        ems.setName_diag ( bt.getName_diag());
        ems.setId_diitm ( bt.getId_diitm());//主诊断id
        
       
        DiagOutlineInfo diagOutlineInfo = DiagInfoUtils.GetDiagOutLineInfo(ctx.getId_en());
        if (diagOutlineInfo != null)
        {
            ems.setStr_code_di (diagOutlineInfo.getStr_code_di());//诊断编码拼接
            ems.setStr_name_di ( diagOutlineInfo.getStr_name_di());//诊断名称拼接
            ems.setStr_id_diitm ( diagOutlineInfo.getStr_id_diitm());//诊断子项目id拼接
        }
        
        // 执行科室
        ems.setId_mp_dep(srv.getId_dep());
        ems.setName_mp_dep(srv.getName_dep());

        ems.setId_his_bt ( bt.getId_his_bt());
        ems.setName_his_bt ( bt.getName_his_bt());
        ems.setSd_his_bt ( bt.getSd_his_bt());

        // 
        ems.setId_pps ( bt.getId_pps_bt());
        ems.setName_pps ( bt.getName_pps_bt());
        ems.setSd_pps ( bt.getSd_pps_bt());

        ems.setId_labitmexplain ( bt.getId_labitmexplain());
        ems.setName_labitmexplain ( bt.getName_labitmexplain());
        ems.setSd_labitmexplain ( bt.getSd_labitmexplain());

        ems.setId_demandsu ( bt.getId_demandsu_bt());
        ems.setName_demandsu ( bt.getName_demandsu_bt());
        ems.setSd_demandsu ( bt.getSd_demandsu_bt());

        ems.setId_mode ( bt.getId_mode_bt());
        ems.setName_mode ( bt.getName_mode_bt());
        ems.setSd_mode ( bt.getSd_mode_bt());
        ems.setName_emp_create ( dto.getName_emp_phy());


        ems.setId_srv ( srv.getId_srv());
        ems.setName_srv ( srv.getName_srv());
        ems.setSd_srvtp(srv.getSd_srvtp());
        ems.setInnercode_srvca(srv.getInnercode_srvca());
        

        ems.setId_emp_create ( srv.getId_emp_srv());
        ems.setDt_create ( srv.getDt_create_srv());

        ems.setQuan_med ( srv.getQuan_med());
        ems.setId_unit_med ( srv.getId_unit_med());
        ems.setName_unit_med ( srv.getName_unit_med());
        // medUnitName = ( srv.getName_unit_med());
        ems.setStatus ( DOStatus.UPDATED);
        // 动态指标数据
        OrdApSugViewItemDO[] szOrdApSugViewItemDO = ordApSugViewItemListFrom(ctx,dto.getId_srvof());
        Map<String,OrdApBtViewItemDO> tmpValueMap = EditIndicatorDateSource( agg);
        
        FArrayList ordApBtViewItemList = new FArrayList();
        for (OrdApSugViewItemDO item : szOrdApSugViewItemDO){
      	if (tmpValueMap.containsKey(item.getId_srv())){
        		item.setVal_rstrptla(tmpValueMap.get(item.getId_srv()).getVal_rstrptla());
        	}
        	ordApBtViewItemList.add(item);
        }
        ems.setBtLabItemEx(ordApBtViewItemList);
        ems.setFg_selfpay((dto.getEu_hpindicjudge()==HpIndicJudgeEnum.SELFPAY?FBoolean.TRUE:FBoolean.FALSE));
        return ems;
    }

	/**
	 * 获取备血申请单中的动态指标数据
	 * @param agg
	 * @return
	 */
	private Map<String,OrdApBtViewItemDO> EditIndicatorDateSource(  CiorappbtAggDO agg) {

        if (agg == null)
            return null;
        
        Map<String,OrdApBtViewItemDO> tmpRstMap = new HashMap<String,OrdApBtViewItemDO>();

        OrdApBtViewItemDO[] szOrdApBtViewItem = agg.getOrdApBtViewItemDO();
        for (OrdApBtViewItemDO item : szOrdApBtViewItem){
				tmpRstMap.put(item.getId_srv(), item);
		}

        return tmpRstMap;
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
	
	/**
	 * 构建用血医嘱模型数据
	 * @param id_or
	 * @param med
	 * @return
	 * @throws BizException
	 */
	CiordubDTO ciOrdubInfoFrom(String id_or, MedSrvDO med) throws BizException
    {
		CiordubDTO apbu = new CiordubDTO();
        CiorderAggDO ciagg = ServiceFinder.find(ICiorderRService.class).findById(id_or);
        CiOrderDO ciOrder = ciagg.getParentDO();
        CiorappbtAggDO[] szApbtAggInfo = ServiceFinder.find(ICiorappbtRService.class).find("id_or='" + id_or + "'", null, FBoolean.FALSE);
        OrdApBtDO btdo = szApbtAggInfo[0].getParentDO();
        
        apbu.setId_or_rel ( ciOrder.getId_or());
        apbu.setApplyform ( btdo.getNo_applyform());
        apbu.setOrsrvname ( ciagg.getOrdSrvDO()[0].getName());
        apbu.setId_srv ( ciOrder.getId_srv());
        apbu.setQuan_medu ( ciagg.getOrdSrvDO()[0].getQuan_medu());
        apbu.setId_unit ( ciagg.getOrdSrvDO()[0].getId_medu());
        apbu.setDt_bt_pl ( new FDate(btdo.getDt_bt_pl()));
        apbu.setNum_margin_bu ( btdo.getNum_margin_bu());
        apbu.setId_emp_sign ( ciOrder.getId_emp_sign());
        apbu.setName_emp_sign ( ciOrder.getEmp_sign_name());
        apbu.setId_route ( med.getId_route());
        apbu.setName_route ( med.getRoute_name());
        apbu.setQuan_medu_ub ( apbu.getQuan_medu());
        apbu.setName_unit ( ciagg.getOrdSrvDO()[0].getMedu_name());
        apbu.setId_unit ( med.getId_unit_med()); // 
        return apbu;
    }
	
}
