/**
 * 
 */
package iih.ci.ord.s.bp.iemsg;

import iih.bd.res.deptb.d.DeptBDO;
import iih.bd.res.deptb.i.IDeptbRService;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.i.external.ICidiagExtQryService;
import iih.ci.ord.iemsg.d.IEPvDiagEnDTO;
import iih.ci.ord.iemsg.d.IEPvMainDiagDTO;
import iih.ci.ord.iemsg.d.IEPvSecodDiagDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.IpBasicDTO;
import iih.en.pv.i.IEnOutQryService;
import iih.pi.overview.overview.d.OverviewAggDO;
import iih.pi.overview.overview.i.IOverviewRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsndocAggDO;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;

/**
 * @ClassName: GetIEMsgInfoDiagBP
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年9月28日 上午10:39:14
 * @Package iih.ci.ord.s.bp.iemsg
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */

/**
 * BS301：住院诊断签署事件</br>
 * 生成集成平台签署数据信息
 * 
 */
public class GetIEMsgInfoDiagBP {
	/**
	 * 生成集成平台签署数据信息 （住院）
	 * 
	 * @param CidiagAggDO aggDO
	 * @param id_ent 就诊号
	 * @return
	 * @throws BizException
	 */
	public IEPvDiagEnDTO[] exec(CidiagAggDO aggDO, String id_ent) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_ent))
			return null;
		//有效性校验
		if (CiOrdUtils.isEmpty(aggDO))
			return null;
		IEPvDiagEnDTO pvDaigEnt = new IEPvDiagEnDTO();
		//映射患者就诊信息
		MappingPvDiagEnDTO(pvDaigEnt, id_ent);
		//映射诊断信息
		MappingDiag(aggDO, pvDaigEnt);
		return new IEPvDiagEnDTO[] { pvDaigEnt };

	}

	/**
	 * 映射患者就诊信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 * @throws BizException
	 */
	private void MappingPvDiagEnDTO(IEPvDiagEnDTO pvDaigEnt, String id_ent) throws BizException {
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
		IOverviewRService pipatService = ServiceFinder.find(IOverviewRService.class);
		IOrgRService orgRService = ServiceFinder.find(IOrgRService.class);
		if (qryService != null) {
			IpBasicDTO ipBasicDTO = qryService.getIpBasicInfo(id_ent);
			OverviewAggDO piPatDO = pipatService.findById(ipBasicDTO.getId_pat());
			DeptBDO dept = deptService.findById(ipBasicDTO.getId_dep_phy());
			OrgDO org = orgRService.findById(dept.getId_org());
			if (ipBasicDTO != null) {
				//pvDaigEnt.setId_ieoppvdiagen(ipBasicDTO.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
				//pvDaigEnt.setIeoppvmaindiags(ipBasicDTO.getIeoppvmaindiags());// ie门诊就诊诊断集合
				pvDaigEnt.setPatientid(piPatDO.getParentDO().getCode());// 患者code
				//pvDaigEnt.setP_bar_code(ipBasicDTO.getId_ent());// 就诊号
				pvDaigEnt.setP_bar_code(piPatDO.getParentDO().getBarcode_chis());//就诊号
				pvDaigEnt.setBqcode(ipBasicDTO.getTimes_ip() + "");// 就诊次数
				pvDaigEnt.setBqname(ipBasicDTO.getName_pat());// 患者姓名 
				pvDaigEnt.setBedno(dept.getCode());// 科室编码
				pvDaigEnt.setName(dept.getName());// 科室名称
				pvDaigEnt.setDeptcode(ipBasicDTO.getId_dep_nur());// 病区编码
				pvDaigEnt.setDeptname(ipBasicDTO.getName_dep_nur());// 病区名称
				pvDaigEnt.setTimes(ipBasicDTO.getId_bed());// 床位号
				//pvDaigEnt.setHospital_code(piPatDO.getParentDO().getGrpcode());// 医疗机构编码
				//pvDaigEnt.setHospital_name(piPatDO.getParentDO().getGrpname());// 医疗机构名称
				//pvDaigEnt.setDomain_id("BS301");// 域id
				pvDaigEnt.setDomain_id("02");// 域id
			}
		}
	}

	/**
	 * 映射诊断信息
	 * 
	 * @param pvDaigEnt
	 * @param id_ent
	 */
	private void MappingDiag(CidiagAggDO aggDO, IEPvDiagEnDTO pvDaigEnt) throws BizException {
		IEPvMainDiagDTO majdipvDiag = new IEPvMainDiagDTO();
		FArrayList2 mainList = new FArrayList2();
		if (aggDO != null && aggDO.getCiDiagItemDO().length > 0) {
			FArrayList2 list = new FArrayList2();
			//需要优化  todo
			IDeptbRService deptService = ServiceFinder.find(IDeptbRService.class);
			IPsndocRService psnService = ServiceFinder.find(IPsndocRService.class);
			PsndocAggDO psnagg = psnService.findById(aggDO.getParentDO().getId_emp_sign());
			DeptBDO dept = deptService.findById(aggDO.getParentDO().getId_dep_sign());
			aggDO.getParentDO().setName_dep_sign(dept.getName());
			aggDO.getParentDO().setId_dep_sign(dept.getCode());//借用id 字段
			aggDO.getParentDO().setEmpcode(psnagg.getParentDO().getCode());
			aggDO.getParentDO().setEmpname(psnagg.getParentDO().getName());

			for (CiDiagItemDO item : aggDO.getCiDiagItemDO()) {
				if (item.getFg_majdi() == FBoolean.TRUE) {
					setEPvMainDiagDTO(majdipvDiag, item, aggDO);
					mainList.append(majdipvDiag);
				} else {
					IEPvSecodDiagDTO pvDiag = new IEPvSecodDiagDTO();
					setPvDiag(pvDiag, item, aggDO);
					list.append(pvDiag);
				}
			}
			majdipvDiag.setIepvseconddiags(list);
			pvDaigEnt.setIepvmaindiags(mainList);
		}
	}

	/**
	 * 
	 * @param pvDiag
	 * @param item
	 * @param aggDO
	 * @throws BizException
	 */
	private void setEPvMainDiagDTO(IEPvMainDiagDTO pvDiag, CiDiagItemDO item, CidiagAggDO aggDO) throws BizException {
		//pvDiag.setId_ieoppvmaindiag(item.getId_ieoppvmaindiag());// ie门诊就诊诊断主键标识
		//pvDiag.setId_ieoppvdiagen(item.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
		ICidiagExtQryService iCidiagExtQryService = ServiceFinder.find(ICidiagExtQryService.class);
		FMap2 result = iCidiagExtQryService.ConvertDiagType(aggDO.getParentDO().getCode_ditp(), aggDO.getParentDO().getCode_entp());
		pvDiag.setDiagno(item.getSortno());// 诊断号
		//pvDiag.setDiagcode(aggDO.getParentDO().getCode_ditp());// 诊断类别编码
		//pvDiag.setDiagname(aggDO.getParentDO().getName_ditp());// 诊断类别名称
		pvDiag.setDiagcode(result.get("code")==null?"":(String)result.get("code"));// 诊断类别编码
		pvDiag.setDiagname(result.get("name")==null?"":(String)result.get("name"));// 诊断类别名称
		//  <!-- 是否待查 @code: N代表是, U代表否 -->  集成平台
		if (item.getFg_flupci() == FBoolean.TRUE) { // 待查诊断标志 Fg_flupci存在为空情况
			pvDiag.setUnconfirm("N");// 是否待查
		} else {
			pvDiag.setUnconfirm("U");// 是否待查
		}
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		pvDiag.setDiagtime(aggDO.getParentDO().getDt_di() + "");// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(aggDO.getParentDO().getId_dep_sign());// 诊断科室编码
		pvDiag.setDeptname(aggDO.getParentDO().getName_dep_sign());// 诊断科室名称
		if (item.getFg_infedi() == FBoolean.TRUE) {
			pvDiag.setInflectable("true");// 是否传染
		} else {
			pvDiag.setInflectable("false");// 是否传染
		}
		//pvDiag.setMain_flag(item.getFg_majdi()+"");// 是否主诊断
	}

	/**
	 * 
	 * @param pvDiag
	 * @param item
	 * @param aggDO
	 * @throws BizException
	 */
	private void setPvDiag(IEPvSecodDiagDTO pvDiag, CiDiagItemDO item, CidiagAggDO aggDO) throws BizException {
		//pvDiag.setId_ieoppvmaindiag(item.getId_ieoppvmaindiag());// ie门诊就诊诊断主键标识
		//pvDiag.setId_ieoppvdiagen(item.getId_ieoppvdiagen());// IE门诊诊断就诊信息主键标识
		pvDiag.setDiagno(item.getSortno());// 诊断号
		pvDiag.setDiagcode(item.getId_didef_code());// 诊断类别编码
		pvDiag.setDiagname(item.getId_didef_name());// 诊断类别名称
		if (item.getFg_flupci() != null && item.getFg_flupci().booleanValue()) {
			pvDiag.setUnconfirm("N");// 是否待查
		} else {
			pvDiag.setUnconfirm("U");// 是否待查
		}
		pvDiag.setDiseasecode(item.getId_didef_code());// 疾病编码
		pvDiag.setDiseasename(item.getId_didef_name());// 疾病名称
		pvDiag.setDiagtime(aggDO.getParentDO().getDt_di() + "");// 诊断时间
		pvDiag.setDoctorcode(aggDO.getParentDO().getEmpcode());// 诊断医生编码
		pvDiag.setDoctorname(aggDO.getParentDO().getEmpname());// 诊断医生名称
		pvDiag.setDeptcode(aggDO.getParentDO().getId_dep_sign());// 诊断科室编码
		pvDiag.setDeptname(aggDO.getParentDO().getName_dep_sign());// 诊断科室名称
		if (item.getFg_infedi() == FBoolean.TRUE) {
			pvDiag.setInflectable("true");// 是否传染
		} else {
			pvDiag.setInflectable("false");// 是否传染
		}
		//pvDiag.setMain_flag(item.getFg_majdi()+"");// 是否主诊断
	}
}
