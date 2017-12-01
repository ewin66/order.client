package iih.ci.ord.s.bp.iemsg;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.iemsg.d.IEOpRisIllHisDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrItmDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiRisOpOrQry;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * BS002：生成集成平台检查申请服务数据信息操作BP 已记账
 * （门诊）
 */
public class GetIEOpMsgInfo4RisBP {
	/**
	 * 生成集成平台检查申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		// 获得sql串及其对应的结果集map
		String sql = getSQlStr(id_ors);
		//Map<String, Object> map = CiOrdUtils.getRsMap(sql);
		
		// 组装检查数据
		List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql);
		List<IEOpRisOrEnDTO> risenlist=new ArrayList<>();
		for (Map<String, Object> map2 : maps) {
			IEOpRisOrEnDTO ierisdto = new IEOpRisOrEnDTO();
			setRisEnDto8Map(ierisdto, map2);
			risenlist.add(ierisdto);
			ierisdto.setAge(AgeCalcUtil.getAge(ierisdto.getBirthday()));
		}

		if(risenlist.size()>0)
		return risenlist.toArray(new IEOpRisOrEnDTO[0]);//new IEOpLisOrEnDTO[] { ielisdto };
		else{
			return new IEOpRisOrEnDTO[]{};
		}
	}
	
	/**
	 * 获得 SQL串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_ors) {
		CiRisOpOrQry qry = new CiRisOpOrQry(id_ors);
		return qry.getQrySQLStr();
	}
	
	/**
	 * IE检查申请就诊信息DTO   IEOpRisOrEnDTO
	 * @param ieoprisdto
	 * @param map
	 */
	private void setRisEnDto8Map(IEOpRisOrEnDTO ieoprisdto, Map<String, Object> map) {

		IEOpRisOrDTO ierisdto=new IEOpRisOrDTO();
		IEOpRisIllHisDTO ierisillhisdto=new IEOpRisIllHisDTO();
		setRisOrDto8Map(ierisdto, map);
		setRisOrIllHisDto8Map(ierisillhisdto, map);
		FArrayList2 faIerisors=new FArrayList2();
		FArrayList2 faIerishis=new FArrayList2();
		faIerisors.add(ierisdto);
		faIerishis.add(ierisillhisdto);
		ieoprisdto.setOrg_code(CiOrdUtils.nullHandle(map.get("org_code")));
		ieoprisdto.setOrg_name(CiOrdUtils.nullHandle(map.get("org_name")));
		ieoprisdto.setId_ierisoren(CiOrdUtils.nullHandle(map.get("id_ierisoren")));
		ieoprisdto.setIerisors(faIerisors);
		ieoprisdto.setIerishises(faIerishis);
		ieoprisdto.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
		ieoprisdto.setP_bar_code(CiOrdUtils.nullHandle(map.get("p_bar_code")));
		ieoprisdto.setWard_code(CiOrdUtils.nullHandle(map.get("ward_code")));
		ieoprisdto.setWard_code_name(CiOrdUtils.nullHandle(map.get("ward_code_name")));
		ieoprisdto.setBed_no(CiOrdUtils.nullHandle(map.get("bed_no")));
		ieoprisdto.setSocial_no(CiOrdUtils.nullHandle(map.get("social_no")));
		ieoprisdto.setAddition_no(CiOrdUtils.nullHandle(map.get("addition_no")));
		ieoprisdto.setName(CiOrdUtils.nullHandle(map.get("name")));
		ieoprisdto.setHome_tel(CiOrdUtils.nullHandle(map.get("home_tel")));
		ieoprisdto.setSexid(CiOrdUtils.nullHandle(map.get("sexid")));
		ieoprisdto.setBirthday(map.get("birthday")==null?null:new FDate(map.get("birthday").toString()));
		ieoprisdto.setAge(CiOrdUtils.nullHandle(map.get("age")));
		ieoprisdto.setHome_street(CiOrdUtils.nullHandle(map.get("home_street")));
		ieoprisdto.setMarry_code(CiOrdUtils.nullHandle(map.get("marry_code")));
		ieoprisdto.setNation_code(CiOrdUtils.nullHandle(map.get("nation_code")));
		ieoprisdto.setOccupation_type(CiOrdUtils.nullHandle(map.get("occupation_type")));
		ieoprisdto.setOccupation_type_name(CiOrdUtils.nullHandle(map.get("occupation_type_name")));
		ieoprisdto.setWork_unit(CiOrdUtils.nullHandle(map.get("work_unit")));
		ieoprisdto.setCountry_code(CiOrdUtils.nullHandle(map.get("country_code")));
		ieoprisdto.setCountry_code_name(CiOrdUtils.nullHandle(map.get("country_code_name")));
		ieoprisdto.setRelation_tel(CiOrdUtils.nullHandle(map.get("relation_tel")));
		ieoprisdto.setRelation_tel_name(CiOrdUtils.nullHandle(map.get("relation_tel_name")));
		ieoprisdto.setApply_hospital(CiOrdUtils.nullHandle(map.get("apply_hospital")));
		ieoprisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
		ieoprisdto.setApply_doctor(CiOrdUtils.nullHandle(map.get("apply_doctor")));
		ieoprisdto.setApply_doctor_name(CiOrdUtils.nullHandle(map.get("apply_doctor_name")));
		ieoprisdto.setApply_unit(CiOrdUtils.nullHandle(map.get("apply_unit")));
		ieoprisdto.setApply_unit_name(CiOrdUtils.nullHandle(map.get("apply_unit_name")));
		ieoprisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
		ieoprisdto.setConfirm_opera(CiOrdUtils.nullHandle(map.get("confirm_opera")));
		ieoprisdto.setConfirm_opera_name(CiOrdUtils.nullHandle(map.get("confirm_opera_name")));
		ieoprisdto.setResponse_type(CiOrdUtils.nullHandle(map.get("response_type")));
		ieoprisdto.setTimes(map.get("times")+"");
		ieoprisdto.setDiag_type_code(CiOrdUtils.nullHandle(map.get("diag_type_code")));
		ieoprisdto.setDiag_type_name(CiOrdUtils.nullHandle(map.get("diag_type_name")));
		ieoprisdto.setDiag_input_date(map.get("diag_input_date")==null?null:new FDateTime(map.get("diag_input_date").toString()));
		ieoprisdto.setDiag_code(CiOrdUtils.nullHandle(map.get("diag_code")));
		ieoprisdto.setDiag_str(CiOrdUtils.nullHandle(map.get("diag_str")));
		ieoprisdto.setDomain_id("01");
		
		ieoprisdto.setCode_dep_ns(CiOrdUtils.nullHandle(map.get("code_dep_ns")));
		ieoprisdto.setName_dep_ns(CiOrdUtils.nullHandle(map.get("name_dep_ns")));
	}
	
	private void setRisOrDto8Map(IEOpRisOrDTO ierisdto, Map<String, Object> map) {
	
		IEOpRisOrItmDTO ierisitemdto=new IEOpRisOrItmDTO();
		setRisOrItemDto8Map(ierisitemdto, map);
		FArrayList fa=new FArrayList();
		fa.add(ierisitemdto);
		ierisdto.setId_ierisor(CiOrdUtils.nullHandle( map.get("id_ierisor")));
		ierisdto.setId_ierisoren(CiOrdUtils.nullHandle( map.get("id_ierisoren")));
		ierisdto.setId_ierisoritms(fa);
		ierisdto.setApply_serial(CiOrdUtils.nullHandle( map.get("apply_serial")));
		ierisdto.setExam_type(CiOrdUtils.nullHandle( map.get("exam_type")));
		ierisdto.setExam_type_name(CiOrdUtils.nullHandle( map.get("exam_type_name")));
		ierisdto.setExam_content(CiOrdUtils.nullHandle( map.get("exam_content")));
		ierisdto.setExam_request_date(map.get("exam_request_date")==null?null:new FDateTime(map.get("exam_request_date").toString()));
		ierisdto.setSamp_bar_code(CiOrdUtils.nullHandle( map.get("samp_bar_code")));
		ierisdto.setSamp_type(CiOrdUtils.nullHandle( map.get("samp_type")));
		ierisdto.setSamp_content(CiOrdUtils.nullHandle( map.get("samp_content")));
		ierisdto.setExam_exec_date(map.get("exam_exec_date")==null?null:new FDateTime(map.get("exam_exec_date").toString()));
		ierisdto.setExec_unit(CiOrdUtils.nullHandle( map.get("exec_unit")));
		ierisdto.setSqd_deptcode(CiOrdUtils.nullHandle( map.get("sqd_deptcode")));
		ierisdto.setNote(CiOrdUtils.nullHandle( map.get("note")));
		ierisdto.setIemsgca_code(CiOrdUtils.nullHandle(map.get("iemsgca_code"))); // 集成平台用服务分类编码
		ierisdto.setIemsgca_name(CiOrdUtils.nullHandle(map.get("iemsgca_name"))); // 集成平台用服务分类名称
		ierisdto.setIemsgca_typename(CiOrdUtils.nullHandle(map.get("iemsgca_typename"))); // 集成平台用服务分类类型名称
		ierisitemdto.setOrder_pri(getRisPrice(CiOrdUtils.nullHandle(map.get("id_ierisor"))));//医嘱费用
		
	}
	/**
	 * 获取检查价格
	 * @param id_or
	 * @return
	 */
	private String getRisPrice(String id_or){
		DAFacade dafacade = new DAFacade();
		StringBuffer sql = new StringBuffer();
		FDouble price_total = FDouble.ZERO_DBL;
		try {
			sql.append(" select * from ci_or_srv where id_or='"+id_or+"' and fg_bl='Y' and eu_sourcemd in("+OrSrvSourceFromEnum.PHYSIAN+","+OrSrvSourceFromEnum.AGENTFROMPRIMD+","+OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD+") ");
			List<OrdSrvDO> list = (List<OrdSrvDO>)dafacade.execQuery(
					sql.toString(), new BeanListHandler(OrdSrvDO.class));
			for (OrdSrvDO ordSrvDO : list) {
				if(ordSrvDO.getFg_mm() == FBoolean.FALSE){
					price_total = price_total.add(ordSrvDO.getQuan_total_medu().multiply(ordSrvDO.getPri()));
				}else{
					sql.delete(0, sql.length());
					sql.append(" select * from ci_or_srv_mm where id_orsrv='"+ordSrvDO.getId_orsrv()+"' ");
					List<OrdSrvMmDO> ordSrvMmList = (List<OrdSrvMmDO>)dafacade.execQuery(
							sql.toString(), new BeanListHandler(OrdSrvMmDO.class));
					for (OrdSrvMmDO ordSrvMmDO : ordSrvMmList) {
						price_total = price_total.add(ordSrvMmDO.getQuan_cur().multiply(ordSrvMmDO.getPrice_pgku_cur()));
					}
				}
			}
		} catch (BizException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
		}
		return price_total.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
	}
	private void setRisOrIllHisDto8Map(IEOpRisIllHisDTO ierisillhisdto, Map<String, Object> map) {
		
		ierisillhisdto.setId_ierisillhis(CiOrdUtils.nullHandle( map.get("")));
		ierisillhisdto.setId_ierisoren(CiOrdUtils.nullHandle( map.get("id_ierisoren")));
		ierisillhisdto.setAnamnesis_code(CiOrdUtils.nullHandle( map.get("")));
		ierisillhisdto.setAnamnesis_disease_code(CiOrdUtils.nullHandle( map.get("diag_code")));
		ierisillhisdto.setAnamnesis_content(CiOrdUtils.nullHandle( map.get("diag_name")));
	}
	
	private void setRisOrItemDto8Map(IEOpRisOrItmDTO ierisitemdto, Map<String, Object> map){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		if(ierisitemdto==null||map==null)return;
		ierisitemdto.setId_ierisoritm(CiOrdUtils.nullHandle(map.get("id_ierisoritm")));
		ierisitemdto.setId_ierisor(CiOrdUtils.nullHandle( map.get("id_ierisor")));
		ierisitemdto.setExam_serial(CiOrdUtils.nullHandle( map.get("exam_serial")));
		ierisitemdto.setExam_sub_type(CiOrdUtils.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_type_name(CiOrdUtils.nullHandle( map.get("exam_sub_type_name")));
//		ierisitemdto.setExam_sub_fftype(CiOrdUtils.nullHandle( map.get("exam_sub_fftype")));
//		ierisitemdto.setExam_sub_fftype_name(CiOrdUtils.nullHandle( map.get("exam_sub_fftype_name")));
		ierisitemdto.setExam_sub_fftype(CiOrdUtils.nullHandle( map.get("exam_sub_type")));
		ierisitemdto.setExam_sub_fftype_name(CiOrdUtils.nullHandle( map.get("exam_sub_type_name")));
		ierisitemdto.setExam_region(CiOrdUtils.nullHandle( map.get("exam_region")));
		ierisitemdto.setExam_region_name(CiOrdUtils.nullHandle( map.get("exam_region_name")));
		ierisitemdto.setYz_frequency(CiOrdUtils.nullHandle( map.get("yz_frequency")));
		//医嘱开始时间取dt_effe by yzh 2017-08-01 19:00:33
		ierisitemdto.setDt_effe(CiOrdUtils.nullHandle(map.get("dt_effe")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_effe").toString()).getMillis()))));
		ierisitemdto.setDt_end(CiOrdUtils.nullHandle(map.get("dt_end")==null?null:sdf.format(new Date(new FDateTime(map.get("dt_end").toString()).getMillis())) ));
		// 设置vip标识
		String id_en = (String) map.get("id_ierisoren");
		IEnOutQryService enOutQryService = (IEnOutQryService)ServiceFinder.find(IEnOutQryService.class.getName());
		try {
			String vip  = enOutQryService.getGcVipTp(id_en);
			ierisitemdto.setEu_vip(vip);
		} catch (BizException e) {
			e.printStackTrace();
		}
	}
	
}
