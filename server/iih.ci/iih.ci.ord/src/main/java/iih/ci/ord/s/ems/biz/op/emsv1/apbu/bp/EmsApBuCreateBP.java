package iih.ci.ord.s.ems.biz.op.emsv1.apbu.bp;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

public class EmsApBuCreateBP extends EmsBaseCreateBP{
	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException {
		// TODO Auto-generated method stub
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null) {
			throw new BizException("查询主服务信息失败！",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		if(CiOrdUtils.isEmpty(ems.getExtension())){
			throw new BizException ("用血模板为空，开用血医疗单失败",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_APBU_TMPL_NULL);
		}
		
		// 合成主UI模型对象
		CiordubDTO emsModel = emsModelFrom(ems.getExtension().get("CustomInfo").toString(),aggDO.getParentDO());
		
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
		
		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO()	);
        
		// 保存执行科室过滤条件
		OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());
		
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		
		// 返回处理
		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.BTUSE.toString());
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}
	
	private OrdSrvDO mainOrdSrvDOFrom(CiorderAggDO ciagg){
		CiOrderDO ordInfo = ciagg.getParentDO();
		for (OrdSrvDO srvInf : ciagg.getOrdSrvDO()){
			if (srvInf.getId_srv().equals(ordInfo.getId_srv())){
				return srvInf;
			}
		}
		return null;
	}

	CiordubDTO emsModelFrom(String id_or, MedSrvDO med) throws BizException
    {
		FDateTime tm = CiOrdAppUtils.getServerDateTime();
		CiordubDTO apbu = new CiordubDTO();
        CiorderAggDO ciagg = ServiceFinder.find(ICiorderRService.class).findById(id_or);
        CiOrderDO ciOrder = ciagg.getParentDO();
        CiorappbtAggDO[] szApbtAggInfo = ServiceFinder.find(ICiorappbtRService.class).find("id_or='" + id_or + "'", null, FBoolean.FALSE);
        OrdApBtDO btdo = szApbtAggInfo[0].getParentDO();
        OrdSrvDO mainSrvInfo = mainOrdSrvDOFrom(ciagg);
        if (null != mainSrvInfo){
        apbu.setId_or_rel ( ciOrder.getId_or());
        apbu.setApplyform ( btdo.getNo_applyform());
        apbu.setOrsrvname ( mainSrvInfo.getName());
        apbu.setId_srv ( mainSrvInfo.getId_srv());
        apbu.setQuan_medu ( mainSrvInfo.getQuan_medu());
        
        apbu.setDt_bt_pl ( new FDate(btdo.getDt_bt_pl()));
        apbu.setNum_margin_bu ( btdo.getNum_margin_bu());
        apbu.setId_emp_sign ( ciOrder.getId_emp_sign());
        apbu.setName_emp_sign ( ciOrder.getEmp_sign_name());
        apbu.setId_route ( med.getId_route());
        apbu.setName_route ( med.getRoute_name());
        apbu.setQuan_medu_ub ( apbu.getQuan_medu());
        apbu.setName_unit ( mainSrvInfo.getMedu_name());
        apbu.setId_unit ( mainSrvInfo.getId_medu());
        apbu.setDt_bu_pl_ub(tm);
        apbu.setUse_days(1);
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer totalTimes = totalTimesBP.getTotalTimes(med.getId_freq(), apbu.getUse_days());
		apbu.setTimes_cur(totalTimes);
		
		apbu.setDt_begin_ui(tm);
		apbu.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),tm.getUFTime()));	
        }
        return apbu;
    }
	
}
