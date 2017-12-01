package iih.ci.ord.s.ems.biz.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.external.ICidiagExtQryService;
import iih.ci.ord.iemsg.d.IEOpPvDiagDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.ip.event.BusiType;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;



public class DiagFireEventUtils {
	

	/**
	 * BS301： 诊断信息服务 IE 集成平台</br>
	 * 门诊诊断签署(住院的通过集成平台配置实现)
	 * 
	 * @param ret
	 * @throws BizException
	 */
	public static void IEDiagFireEvent(CidiagAggDO ret) throws BizException {
		if (ret != null && "00".equals(ret.getParentDO().getCode_entp())) {
			IEOpPvDiagEnDTO[] OpPvDiagDTO = IEOpPvDiagEnDTO(ret, ret.getParentDO().getId_en());
			// 触发事件
			for (IEOpPvDiagEnDTO d : OpPvDiagDTO) {
				DomainBusinessUserObj buo = new DomainBusinessUserObj(d, BusiType.MZ, d.getBedno(), "");
				MsgObj msg = new MsgObj();
				msg.setInteractionCode("new");
				buo.setMsgObj(msg);
				BusinessEvent event = new BusinessEvent(ICiIEEventConst.EVENT_IE_CIDIAG_OP_SIGN,
						IEventType.TYPE_UPDATE_AFTER, buo);
				EventDispatcher.fireEvent(event);

			}
		}
	}
	private static  IEOpPvDiagEnDTO[] IEOpPvDiagEnDTO(CidiagAggDO aggDO,String id_ent) throws BizException{
		//有效性校验

		IEOpPvDiagEnDTO pvDaigEnt = new IEOpPvDiagEnDTO();
		//映射患者就诊信息
		MappingPvDiagEnDTO(pvDaigEnt,id_ent);
		//映射诊断信息
		MappingDiag( aggDO, pvDaigEnt);
		return new IEOpPvDiagEnDTO[]{pvDaigEnt} ;
	}
	/**
	 * 映射患者就诊信息
	 * @param pvDaigEnt
	 * @param id_ent
	 * @throws BizException
	 */
	private static void MappingPvDiagEnDTO(IEOpPvDiagEnDTO pvDaigEnt,String id_ent)throws BizException{
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		IDeptRService deptService = ServiceFinder.find(IDeptRService.class);
		IOverviewRService pipatService =  ServiceFinder.find(IOverviewRService.class);
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		if( qryService != null){
			OpBasicDTO OpBasicDTO =  qryService.getOpBasicInfo(id_ent);
			OverviewAggDO piPatDO= pipatService.findById(OpBasicDTO.getId_pat());
			if(OpBasicDTO != null){
				//pvDaigEnt.setId_ieoppvdiagen(ipBasicDTO.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
				//pvDaigEnt.setIeoppvmaindiags(ipBasicDTO.getIeoppvmaindiags());// ie门诊就诊诊断集合
				pvDaigEnt.setPatientid(piPatDO.getParentDO().getCode());// 患者ID
				//pvDaigEnt.setP_bar_code(OpBasicDTO.getCode_ent());// 就诊号
				pvDaigEnt.setP_bar_code(piPatDO.getParentDO().getBarcode_chis());// 就诊号
				pvDaigEnt.setBqcode(OpBasicDTO.getTimes_op()+"");// 就诊次数
				pvDaigEnt.setBqname(OpBasicDTO.getName_pat());// 患者姓名 
				DeptDO  dept = deptService.findById(OpBasicDTO.getId_dep_phy());
				pvDaigEnt.setBedno(dept.getCode());// 科室编码
				pvDaigEnt.setName(dept.getName());// 科室名称
				//pvDaigEnt.setDeptcode(ipBasicDTO.getId_dep_nur());// 病区编码
				//pvDaigEnt.setDeptname(ipBasicDTO.getName_dep_nur());// 病区名称
				//pvDaigEnt.setTimes(ipBasicDTO.getId_bed());// 床位号
				OrgDO org = orgRService.findById(dept.getId_org());
				pvDaigEnt.setHospital_code(org.getOrgcode());// 医疗机构编码
				pvDaigEnt.setHospital_name(piPatDO.getParentDO().getGrpname());// 医疗机构名称
				pvDaigEnt.setDomain_id("01");// 域id
			}
		} 
	}
	/**
	 * 映射诊断信息
	 * @param pvDaigEnt
	 * @param id_ent
	 */
	private static void MappingDiag(CidiagAggDO aggDO,IEOpPvDiagEnDTO pvDaigEnt)throws BizException{
		if(aggDO != null){
			FArrayList2 list = new FArrayList2();
			//需要优化  todo
			IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
			IPsndocRService psnService = ServiceFinder.find(IPsndocRService.class);
			DAFacade dafacade = new DAFacade();
			String bedSql = "select name_bed from en_ent_ip where id_ent= '"+aggDO.getParentDO().getId_en()+"'";
			String bed_no ="";
			List<String> bedList = (List<String>)dafacade.execQuery(bedSql.toString(), new ColumnListHandler());
			if(bedList!=null && bedList.size()>0)
			{
				bed_no = bedList.get(0).toString();
			}
			PsndocAggDO psnagg =psnService.findById(aggDO.getParentDO().getId_emp_sign());
			DeptBDO  dept = deptService.findById(aggDO.getParentDO().getId_dep_sign());
			pvDaigEnt.setDeptcode(dept.getCode());
			pvDaigEnt.setDeptname(dept.getName());
			pvDaigEnt.setBedno(bed_no); 
			aggDO.getParentDO().setEmpcode(psnagg.getParentDO().getCode());
			aggDO.getParentDO().setEmpname(psnagg.getParentDO().getName());
			if(aggDO.getCiDiagItemDO() != null && aggDO.getCiDiagItemDO().length>0){
				for(CiDiagItemDO item : aggDO.getCiDiagItemDO()){
					IEOpPvDiagDTO pvDiag = new IEOpPvDiagDTO();	
					setPvDiag(pvDiag,item, aggDO, dept);
					list.append(pvDiag);
				}
			}
			pvDaigEnt.setIeoppvmaindiags(list);
		}
	}
	/**
	 * 
	 * @param pvDiag
	 * @param item
	 * @param aggDO
	 * @throws BizException
	 */
	private static void setPvDiag(IEOpPvDiagDTO pvDiag,CiDiagItemDO item,CidiagAggDO aggDO, DeptBDO  dept)throws BizException{
		//pvDiag.setId_ieoppvmaindiag(item.getId_ieoppvmaindiag());// ie门诊就诊诊断主键标识
		//pvDiag.setId_ieoppvdiagen(item.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
		ICidiagExtQryService iCidiagExtQryService = ServiceFinder.find(ICidiagExtQryService.class);
		FMap2 result = iCidiagExtQryService.ConvertDiagType(aggDO.getParentDO().getCode_ditp(), aggDO.getParentDO().getCode_entp());

		pvDiag.setDiagno(item.getSortno());// 诊断号
		//pvDiag.setDiagcode(aggDO.getParentDO().getCode_ditp());// 诊断类别编码
		//pvDiag.setDiagname(aggDO.getParentDO().getName_ditp());// 诊断类别名称
		pvDiag.setDiagcode((String)result.get("code"));// 诊断类别编码
		pvDiag.setDiagname((String)result.get("name"));// 诊断类别名称
		//  <!-- 是否待查 @code: N代表是, U代表否 -->  集成平台
		if(FBoolean.TRUE.equals(item.getFg_flupci())){ // 待查诊断标志 Fg_flupci存在为空情况
			pvDiag.setUnconfirm("N");// 是否待查
		}else{
			pvDiag.setUnconfirm("U");// 是否待查
		}
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(aggDO.getParentDO().getDt_di().getMillis());
		pvDiag.setDiagtime(sdf.format(date));// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(dept.getCode());// 诊断科室编码
		pvDiag.setDeptname(dept.getName());// 诊断科室编码
		pvDiag.setEmrtpcode(pvDiag.getDiagcode());//EMR系统诊断类别编码
		pvDiag.setEmrtpname(pvDiag.getDiagname());//EMR系统诊断类别名称
		if(item.getFg_infedi()== FBoolean.TRUE){
			pvDiag.setInflectable("true");// 是否传染
		}else{
			pvDiag.setInflectable("false");// 是否传染
		}

		if(item.getFg_majdi()==FBoolean.TRUE){
			pvDiag.setMain_flag("true");// 是否主诊断
		}else{
			pvDiag.setMain_flag("false");// 是否主诊断
		}

	}
}
