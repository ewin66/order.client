/**
 * 
 */
package iih.ci.ord.s.bp.iemsg;

import java.text.SimpleDateFormat;

import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.ord.iemsg.d.IEOpPvDiagDTO;
import iih.ci.ord.iemsg.d.IEOpPvDiagEnDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.OpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * @ClassName: GetIEOpMsgInfoDiagBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年9月28日 上午10:37:11
 * @Package iih.ci.ord.s.bp.iemsg
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
/**
 *  * 生成集成平台签署数据信息
 * （门诊）
 */
public class GetIEOpMsgInfoDiagBP {
	/**
	 * 生成集成平台签署数据信息
	 * （门诊）
	 * @param id_ent   就诊id
	 * @return
	 * @throws BizException
	 */
	public IEOpPvDiagEnDTO[] exec(CidiagAggDO aggDO,String id_ent) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(aggDO))return null;
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
	 private void MappingPvDiagEnDTO(IEOpPvDiagEnDTO pvDaigEnt,String id_ent)throws BizException{
		 IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		 IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
		 IOrgRService orgService = ServiceFinder.find(IOrgRService.class);
		 IOverviewRService pipatService =  ServiceFinder.find(IOverviewRService.class);
		 
		  if( qryService != null){
			  OpBasicDTO OpBasicDTO =  qryService.getOpBasicInfo(id_ent);
			  OverviewAggDO piPatDO= pipatService.findById(OpBasicDTO.getId_pat());
			  if(OpBasicDTO != null){
				  //pvDaigEnt.setId_ieoppvdiagen(ipBasicDTO.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
				  //pvDaigEnt.setIeoppvmaindiags(ipBasicDTO.getIeoppvmaindiags());// ie门诊就诊诊断集合
				  pvDaigEnt.setPatientid(piPatDO.getParentDO().getCode());// 患者ID
				  pvDaigEnt.setP_bar_code(OpBasicDTO.getId_ent());// 就诊号
				  pvDaigEnt.setBqcode(OpBasicDTO.getTimes_op()+"");// 就诊次数
				  pvDaigEnt.setBqname(OpBasicDTO.getName_pat());// 患者姓名 
				  DeptBDO  dept = deptService.findById(OpBasicDTO.getId_dep_phy());
				  pvDaigEnt.setBedno(dept.getCode());// 科室编码
				  pvDaigEnt.setName(dept.getName());// 科室名称
				  //pvDaigEnt.setDeptcode(ipBasicDTO.getId_dep_nur());// 病区编码
				  //pvDaigEnt.setDeptname(ipBasicDTO.getName_dep_nur());// 病区名称
				  //pvDaigEnt.setTimes(ipBasicDTO.getId_bed());// 床位号
				  OrgDO org = orgService.findById(CiOrdAppUtils.getEnvContext().getOrgId());
				  //pvDaigEnt.setHospital_code(CiOrdAppUtils.getEnvContext().getOrgId());// 医疗机构编码
				  pvDaigEnt.setHospital_code(org.getOrgcode());// 医疗机构编码
				  //pvDaigEnt.setHospital_name(piPatDO.getParentDO().getGrpname());// 医疗机构名称
				  pvDaigEnt.setHospital_name(org.getName());// 医疗机构名称
				  pvDaigEnt.setDomain_id("01");// 域id
			  }
		  } 
	 }
	 
    /**
     * 映射诊断信息
     * @param pvDaigEnt
     * @param id_ent
     */
	private void MappingDiag(CidiagAggDO aggDO,IEOpPvDiagEnDTO pvDaigEnt)throws BizException{
		IEOpPvDiagDTO majdipvDiag   = new IEOpPvDiagDTO();
		if(aggDO != null && aggDO.getCiDiagItemDO().length>0){
			FArrayList2 list = new FArrayList2();
			//需要优化  todo
			 IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
			 IPsndocRService psnService = ServiceFinder.find(IPsndocRService.class);
			 PsndocAggDO psnagg =psnService.findById(aggDO.getParentDO().getId_emp_sign());
			 DeptBDO  dept = deptService.findById(aggDO.getParentDO().getId_dep_sign());
			
			 aggDO.getParentDO().setEmpcode(psnagg.getParentDO().getCode());
			 aggDO.getParentDO().setEmpname(psnagg.getParentDO().getName());
			for(CiDiagItemDO item : aggDO.getCiDiagItemDO()){
				 IEOpPvDiagDTO pvDiag   = new IEOpPvDiagDTO();	
				 setPvDiag(pvDiag,item, aggDO,dept);
				 list.append(pvDiag);
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
	private void setPvDiag(IEOpPvDiagDTO pvDiag,CiDiagItemDO item,CidiagAggDO aggDO, DeptBDO  dept)throws BizException{
		//pvDiag.setId_ieoppvmaindiag(item.getId_ieoppvmaindiag());// ie门诊就诊诊断主键标识
		//pvDiag.setId_ieoppvdiagen(item.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
		pvDiag.setDiagno(item.getSortno());// 诊断号
		pvDiag.setDiagcode(aggDO.getParentDO().getCode_ditp());// 诊断类别编码
		pvDiag.setDiagname(aggDO.getParentDO().getName_ditp());// 诊断类别名称
		//  <!-- 是否待查 @code: N代表是, U代表否 -->  集成平台
		if(item.getFg_flupci() == FBoolean.TRUE){ // 待查诊断标志 Fg_flupci存在为空情况
			pvDiag.setUnconfirm("N");// 是否待查
		}else{
			pvDiag.setUnconfirm("U");// 是否待查
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		pvDiag.setDiagtime(sdf.format(aggDO.getParentDO().getDt_di()));// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(dept.getCode());// 诊断科室编码
		pvDiag.setDeptname(dept.getName());// 诊断科室编码
		pvDiag.setEmrtpcode("");//EMR系统诊断类别编码
		pvDiag.setEmrtpname("");//EMR系统诊断类别名称
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
