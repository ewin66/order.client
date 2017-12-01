package iih.ci.ord.s.bp.iemsg;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiLisOpOrQry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台检验申请服务数据信息操作BP
 * （门诊）
 * 
 * 
 * @author li_cheng
 * 
 */
public class GetIEOpMsgInfo4LisBP2 {
	/**
	 * 生成集成平台检验申请服务数据信息
	 * （门诊）
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpLisOrEnDTO[] exec(String id_ors,String domainid) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得sql串及其对应的结果集map
		String sql=getSQlStr(id_ors);
		List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql);
		List<IEOpLisOrEnDTO> lisenlist=new ArrayList<>();
		for (Map<String, Object> map2 : maps) {
			IEOpLisOrEnDTO ielisdto = new IEOpLisOrEnDTO();
			setLisEnDto8Map(ielisdto, map2);
			ielisdto.setDomain_id(domainid);
			lisenlist.add(ielisdto);
		}
		// 组装检验数据
		if(lisenlist.size()>0)
		return lisenlist.toArray(new IEOpLisOrEnDTO[0]);//new IEOpLisOrEnDTO[] { ielisdto };
		else{
			return new IEOpLisOrEnDTO[]{};
		}
	}
	
	/**
	 * 获得 SQL串 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_ors){
		CiLisOpOrQry qry=new CiLisOpOrQry(id_ors);
		return qry.getQrySQLStr();
	} 
	
	
	/**
	 * IE检验申请就诊信息DTO   IELisOrEnDTO
	 * @param ielisdto
	 * @param map
	 * @throws BizException 
	 */
		private void setLisEnDto8Map(IEOpLisOrEnDTO ieoplisdto, Map<String, Object> map) throws BizException {
          
		
			IEOpLisOrDTO ielisdto=new IEOpLisOrDTO();
			setLisOrDto8Map(ielisdto, map);
			FArrayList2 fa2=new FArrayList2();
			fa2.add(ielisdto);
	//		ieoplisdto.setDomain_id("01");
			ieoplisdto.setId_ielisoren(CiOrdUtils.nullHandle(map.get("id_ielisoren")));
			ieoplisdto.setId_ielisors(fa2);
			ieoplisdto.setPatient_id(CiOrdUtils.nullHandle(map.get("patient_id")));
			ieoplisdto.setP_bar_code(CiOrdUtils.nullHandle(map.get("p_bar_code")));
			ieoplisdto.setWard_code(CiOrdUtils.nullHandle(map.get("ward_code")));
			ieoplisdto.setWard_code_name(CiOrdUtils.nullHandle(map.get("ward_code_name")));
			ieoplisdto.setBed_no(CiOrdUtils.nullHandle(map.get("bed_no")));
			ieoplisdto.setSocial_no(CiOrdUtils.nullHandle(map.get("social_no")));
			ieoplisdto.setName(CiOrdUtils.nullHandle(map.get("name")));
			ieoplisdto.setHome_tel(CiOrdUtils.nullHandle(map.get("home_tel")));
			ieoplisdto.setCellphone(CiOrdUtils.nullHandle(map.get("cellphone")));
			ieoplisdto.setSex(CiOrdUtils.nullHandle(map.get("sex")));
			if(map.get("birthday")!=null){
			String ss=map.get("birthday").toString();
			FDate fd=new FDate(ss);
//			String bdstr=IemsgEventUtils.ModifyDateFormat(fd);
			ieoplisdto.setBirthday(fd);
			String ager=AgeCalcUtil.getAge(fd);
			ieoplisdto.setAge(ager);    //该方法暂时有问题
			}
			ieoplisdto.setHome_street(CiOrdUtils.nullHandle(map.get("home_street")));
			ieoplisdto.setPost_code(CiOrdUtils.nullHandle(map.get("post_code")));
			ieoplisdto.setWork_place_code(CiOrdUtils.nullHandle(map.get("work_place_code")));
			ieoplisdto.setWork_place(CiOrdUtils.nullHandle(map.get("work_place")));
			ieoplisdto.setHospital_code(CiOrdUtils.nullHandle(map.get("hospital_code")));
			ieoplisdto.setHospital_name(CiOrdUtils.nullHandle(map.get("hospital_name")));
			ieoplisdto.setEnter_date(map.get("enter_date")==null?null:new FDateTime(map.get("enter_date").toString()));
			ieoplisdto.setApply_doctor(CiOrdUtils.nullHandle(map.get("apply_doctor")));
			ieoplisdto.setApply_doctor_name(CiOrdUtils.nullHandle(map.get("apply_doctor_name")));
			ieoplisdto.setApply_unit(CiOrdUtils.nullHandle(map.get("apply_unit")));
			ieoplisdto.setApply_unit_name(CiOrdUtils.nullHandle(map.get("apply_unit_name")));
			ieoplisdto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
			ieoplisdto.setConfirm_opera(CiOrdUtils.nullHandle(map.get("confirm_opera")));
			ieoplisdto.setConfirm_opera_name(CiOrdUtils.nullHandle(map.get("confirm_opera_name")));
			ieoplisdto.setInput_begindate(map.get("input_begindate")==null?null:new FDateTime(map.get("input_begindate").toString()));
			ieoplisdto.setInput_enddate(map.get("input_enddate")==null?null:new FDateTime(map.get("input_enddate").toString()));
			ieoplisdto.setInput_opera(CiOrdUtils.nullHandle(map.get("input_opera")));
			ieoplisdto.setInput_opera_name(CiOrdUtils.nullHandle(map.get("input_opera_name")));
			ieoplisdto.setTimes(map.get("times")+"");
			ieoplisdto.setVisit_type(CiOrdUtils.nullHandle(map.get("visit_type")));
			ieoplisdto.setVisit_type_name(CiOrdUtils.nullHandle(map.get("visit_type_name")));
			ieoplisdto.setYq_code(CiOrdUtils.nullHandle(map.get("yq_code")));
			ieoplisdto.setYz_code_name(CiOrdUtils.nullHandle(map.get("yz_code_name")));
			ieoplisdto.setDiag_type(CiOrdUtils.nullHandle(map.get("diag_type")));
			ieoplisdto.setDiag_code(CiOrdUtils.nullHandle(map.get("diag_code")));
			ieoplisdto.setDiag_str(CiOrdUtils.nullHandle(map.get("diag_str")));
			ieoplisdto.setPatient_deptcode(CiOrdUtils.nullHandle(map.get("patient_deptcode")));
			ieoplisdto.setPatient_deptname(CiOrdUtils.nullHandle(map.get("patient_deptname")));
			
		}
	/**
	 * IE检验申请信息DTO   IELisOrDTO
	 * @param ielisordto
	 * @param map
	 * @throws BizException 
	 */
		private void setLisOrDto8Map(IEOpLisOrDTO ielisordto, Map<String, Object> map) throws BizException {

		
			
			IEOpLisOrItmDTO ielisitemdto=new IEOpLisOrItmDTO();
			setLisOrItemDto8Map(ielisitemdto, map);
			FArrayList2 fa2=new FArrayList2();
			fa2.add(ielisitemdto);
			 ielisordto.setId_ielisor(CiOrdUtils.nullHandle( map.get("id_ielisor")));
			 ielisordto.setId_ielisoren(CiOrdUtils.nullHandle( map.get("id_ielisoren")));
			ielisordto.setId_ielisoritms(fa2);
			ielisordto.setJy_applyserial1(CiOrdUtils.nullHandle( map.get("jy_applyserial1")));
			ielisordto.setOrder_type(CiOrdUtils.nullHandle( map.get("order_type")));
			ielisordto.setOrder_type_name(CiOrdUtils.nullHandle( map.get("order_type_name")));
			ielisordto.setApply_date(map.get("apply_date")==null?null:new FDateTime(map.get("apply_date").toString()));
			ielisordto.setIs_private(CiOrdUtils.nullHandle( map.get("is_private")));
			ielisordto.setDiag_type(CiOrdUtils.nullHandle( map.get("diag_type")));
			ielisordto.setDiag_name(CiOrdUtils.nullHandle( map.get("diag_name")));
			ielisordto.setDiag_str(CiOrdUtils.nullHandle( map.get("diag_str")));
		}

	/**
	 * IE检验申请对应项目信息DTO IELisOrItmDTO
	 * 
	 * @param ielisitemdto
	 * @param map
	 * @throws BizException
	 */
	private void setLisOrItemDto8Map(IEOpLisOrItmDTO ielisitemdto, Map<String, Object> map) throws BizException {

		ielisitemdto.setId_ielisoritm(CiOrdUtils.nullHandle( map.get("id_ielisoritm")));
		ielisitemdto.setId_ielisor(CiOrdUtils.nullHandle( map.get("id_ielisor")));
		// ielisitemdto.setYz_no((CiOrdUtils.nullHandle( map.get("yz_no")).substring(0, 9)));
		ielisitemdto.setYz_no(CiOrdUtils.nullHandle( map.get("jy_applyserial1")));
		// ielisitemdto.setYz_no(CiOrdUtils.nullHandle( map.get("yz_no")));
		ielisitemdto.setJy_applyserial(CiOrdUtils.nullHandle( map.get("jy_applyserial")));//jy_applySerial   jy_applySerial
		ielisitemdto.setJyname(CiOrdUtils.nullHandle( map.get("jyname")));
		ielisitemdto.setPriority(CiOrdUtils.nullHandle( map.get("priority")));
		ielisitemdto.setYz_start_date(map.get("yz_start_date") == null ? null : new FDateTime(map.get("yz_start_date").toString()));
		ielisitemdto.setYz_stop_date(map.get("yz_stop_date") == null ? null : new FDateTime(map.get("yz_stop_date").toString()));
		ielisitemdto.setYz_frequency(CiOrdUtils.nullHandle( map.get("yz_frequency")));
		ielisitemdto.setYz_frequency_name(CiOrdUtils.nullHandle( map.get("yz_frequency_name")));
		ielisitemdto.setDescp_code(CiOrdUtils.nullHandle( map.get("descp_code")));
		ielisitemdto.setDescription(CiOrdUtils.nullHandle( map.get("description")));
		ielisitemdto.setCollect_ragion(CiOrdUtils.nullHandle( map.get("collect_ragion")));
		ielisitemdto.setSample_id(CiOrdUtils.nullHandle( map.get("sample_id")));
		ielisitemdto.setSample_class(CiOrdUtils.nullHandle( map.get("sample_class")));
		ielisitemdto.setSample_code_name(CiOrdUtils.nullHandle( map.get("sample_code_name")));
		ielisitemdto.setCollect_time(map.get("collect_time") == null ? null : new FDateTime(map.get("collect_time").toString()));
		ielisitemdto.setContainer_code(CiOrdUtils.nullHandle( map.get("container_code")));
		ielisitemdto.setContainer_code_name(CiOrdUtils.nullHandle( map.get("container_code_name")));
		ielisitemdto.setCollecter_code(CiOrdUtils.nullHandle( map.get("collecter_code")));
		ielisitemdto.setCollecter_code_name(CiOrdUtils.nullHandle( map.get("collecter_code_name")));
		ielisitemdto.setCollecter_place(CiOrdUtils.nullHandle( map.get("collecter_place")));
		ielisitemdto.setExec_code(CiOrdUtils.nullHandle( map.get("exec_code")));
		ielisitemdto.setExec_code_name(CiOrdUtils.nullHandle( map.get("exec_code_name")));
//		GetOrSrvPriceBP priBp = new GetOrSrvPriceBP();
//		String id_or = CiOrdUtils.nullHandle( map.get("id_ielisor"));
//		PriStdSrvDTO[] pris = priBp.exec(new String[] { id_or });
//		if(pris!=null&&pris.length>0)
//		ielisitemdto.setTest_price(pris[0].getPrice() + "");//
		ielisitemdto.setSupply_price(CiOrdUtils.nullHandle( map.get("supply_price")));
		ielisitemdto.setCommenttp(CiOrdUtils.nullHandle( map.get("commenttp")));
		ielisitemdto.setSample_request(CiOrdUtils.nullHandle( map.get("sample_request")));
		ielisitemdto.setIsstest(CiOrdUtils.nullHandle( map.get("isstest")));
		ielisitemdto.setStest(CiOrdUtils.nullHandle( map.get("stest")));
		ielisitemdto.setIs_em(CiOrdUtils.nullHandle( map.get("is_em")));
		ielisitemdto.setIs_em_r(CiOrdUtils.nullHandle( map.get("is_em_r")));
		ielisitemdto.setIsyg(CiOrdUtils.nullHandle( map.get("isyg")));
		ielisitemdto.setYg(CiOrdUtils.nullHandle( map.get("yg")));
	}
}
