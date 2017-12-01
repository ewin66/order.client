package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IEBtOrEnDTO;
import iih.ci.ord.iemsg.d.IERisOrDTO;
import iih.ci.ord.iemsg.d.IERisOrEnDTO;
import iih.ci.ord.iemsg.d.IERisOrItmDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiRisOrQry;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * 生成集成平台检查申请服务数据信息操作BP
 */
public class GetIEMsgInfo4RisBP {
	/**
	 * 生成集成平台检查申请服务数据信息
	 * @param id_ors  医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IERisOrEnDTO[] exec(String id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		// 获得sql串及其对应的结果集map
		String sql = getSQlStr(id_ors);
		Map<String, Object> map = CiOrdUtils.getRsMap(sql);
		
		// 组装检查数据
		IERisOrEnDTO ierisendto = new IERisOrEnDTO();
		setRisEnDto8Map(ierisendto, map);
		return new IERisOrEnDTO[] { ierisendto };
	}
	
	/**
	 * 获得 SQL串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String id_ors) {
		CiRisOrQry qry = new CiRisOrQry(id_ors);
		return qry.getQrySQLStr();
	}
	
	/**
	 * IE检查申请就诊信息DTO   IERisOrEnDTO
	 * @param ierisendto
	 * @param map
	 */
	private void setRisEnDto8Map(IERisOrEnDTO ierisendto, Map<String, Object> map) {

		IERisOrDTO ierisdto=new IERisOrDTO();
		setRisOrDto8Map(ierisdto, map);
		FArrayList2 faIerisors=new FArrayList2();
		faIerisors.add(ierisdto);
		ierisendto.setId_ierisoren((String)map.get("id_ierisoren"));
		ierisendto.setId_ierisors(faIerisors);
		ierisendto.setPatientid((String)map.get("patientid"));
		ierisendto.setName((String)map.get("name"));
		ierisendto.setPatient_type((String)map.get("patient_type"));
		ierisendto.setIdcard((String)map.get("idcard"));
		ierisendto.setTelephone((String)map.get("telephone"));
		ierisendto.setHomeaddress((String)map.get("homeaddress"));
		ierisendto.setMarrycode((String)map.get("marrycode"));
		ierisendto.setFolkcode((String)map.get("folkcode"));
		ierisendto.setProcode((String)map.get("procode"));
		ierisendto.setProname((String)map.get("proname"));
		ierisendto.setWorkunitname((String)map.get("workunitname"));
		ierisendto.setCountrycode((String)map.get("countrycode"));
		ierisendto.setCountryname((String)map.get("countryname"));
		ierisendto.setR_tel((String)map.get("r_tel"));
		ierisendto.setR_name((String)map.get("r_name"));
		ierisendto.setYbcode((String)map.get("ybcode"));
		ierisendto.setSexid((String)map.get("sexid"));
		ierisendto.setBirthdaydate(map.get("birthdaydate")==null?null:new FDate(map.get("birthdaydate").toString()));
		ierisendto.setAge(AgeCalcUtil.getAge(ierisendto.getBirthdaydate()));
		ierisendto.setPatientseqnum((String)map.get("patientseqnum"));
		ierisendto.setAdmiss_times(map.get("admiss_times")==null?null:map.get("admiss_times").toString());
		ierisendto.setDeptcode((String)map.get("deptcode"));
		ierisendto.setDeptname((String)map.get("deptname"));
		ierisendto.setWardcode((String)map.get("wardcode"));
		ierisendto.setWardname((String)map.get("wardname"));
		ierisendto.setBedcode((String)map.get("bedcode"));
		ierisendto.setHos_code((String)map.get("hos_code"));
		ierisendto.setHos_name((String)map.get("hos_name"));
		ierisendto.setConfirm_date(map.get("confirm_date")==null?null:new FDateTime(map.get("confirm_date").toString()));
		ierisendto.setConfirm_nurse_code((String)map.get("confirm_nurse_code"));
		ierisendto.setConfirm_nurse_name((String)map.get("confirm_nurse_name"));
		ierisendto.setDiag_type_code((String)map.get("diag_type_code"));
		ierisendto.setDiag_type_name((String)map.get("diag_type_name"));
		ierisendto.setDiag_date(map.get("diag_date")==null?null:new FDateTime(map.get("diag_date").toString()));
		ierisendto.setDiag_code((String)map.get("diag_code"));
		ierisendto.setDiag_name((String)map.get("diag_name"));
		ierisendto.setDomain_id("02");

	}
	
	private void setRisOrDto8Map(IERisOrDTO ierisdto, Map<String, Object> map) {
	
		IERisOrItmDTO ierisitemdto=new IERisOrItmDTO();
		setRisOrItemDto8Map(ierisitemdto, map);
		FArrayList2 fa=new FArrayList2();
		fa.add(ierisitemdto);
		ierisdto.setId_ierisor((String) map.get("id_ierisor"));
		ierisdto.setId_ierisoren((String) map.get("id_ierisoren"));
		ierisdto.setId_ierisoritms(fa);
		ierisdto.setSqd_jccode((String) map.get("sqd_jccode"));
		ierisdto.setSqd_ordertypecode((String) map.get("sqd_ordertypecode"));
		ierisdto.setSqd_ordertypename((String) map.get("sqd_ordertypename"));
		ierisdto.setSqd_sqddetail((String) map.get("sdsqd_sqddetail"));
		ierisdto.setSqd_sqddate(map.get("sqd_sqddate")==null?null:new FDateTime(map.get("sqd_sqddate").toString()));
		ierisdto.setSqd_bbh((String) map.get("sqd_bbh"));
		ierisdto.setSqd_bbhtype((String) map.get("sqd_bbhtype"));
		ierisdto.setSqd_bbyq((String) map.get("sqd_bbyq"));
		ierisdto.setSqd_zxsj(map.get("sqd_zxsj")==null?null:new FDateTime(map.get("sqd_zxsj").toString()));
		ierisdto.setSqd_deptname((String) map.get("sqd_deptname"));
		ierisdto.setSqd_deptcode((String) map.get("sqd_deptcode"));
		ierisdto.setSqd_sqzysx((String) map.get("sqd_sqzysx"));
		ierisdto.setIemsgca_code(CiOrdUtils.nullHandle((map.get("iemsgca_code"))));
		ierisdto.setIemsgca_name(CiOrdUtils.nullHandle((map.get("iemsgca_name"))));
		ierisdto.setIemsgca_typename(CiOrdUtils.nullHandle((map.get("iemsgca_typename"))));
		
	}
	
	private void setRisOrItemDto8Map(IERisOrItmDTO ierisitemdto, Map<String, Object> map){
		if(ierisitemdto==null||map==null)return;
		
		ierisitemdto.setId_ierisoritm((String) map.get("id_ierisoritm"));
		ierisitemdto.setId_ierisor((String) map.get("id_ierisor"));
		ierisitemdto.setYz_ordercode((String) map.get("yz_ordercode"));
		ierisitemdto.setYz_jccode((String) map.get("yz_jccode"));
		ierisitemdto.setYz_jcname((String) map.get("yz_jcname"));
		ierisitemdto.setJgbz((String) map.get("jgbz"));
		ierisitemdto.setYz_start_time(map.get("yz_start_time")==null?null:new FDateTime(map.get("yz_start_time").toString()));
		ierisitemdto.setYz_stop_time(map.get("yz_stop_time")==null?null:new FDateTime(map.get("yz_stop_time").toString()));
		ierisitemdto.setXy_zcy_fre_code((String) map.get("xy_zcy_fre_code"));
		ierisitemdto.setXy_zcy_fre_name((String) map.get("xy_zcy_fre_name"));
		ierisitemdto.setYz_jcffcode((String) map.get("yz_jcffcode"));
		ierisitemdto.setYz_jcffname((String) map.get("yz_jcffname"));
		ierisitemdto.setYz_jcbwcode((String) map.get("yz_jcbwcode"));
		ierisitemdto.setYz_jcbwname((String) map.get("yz_jcbwname"));
		ierisitemdto.setIs_ps((String) map.get("is_ps"));
		ierisitemdto.setIs_psresult((String) map.get("is_psresult"));
		ierisitemdto.setIs_jjresult((String) map.get("is_jjresult"));
		ierisitemdto.setIs_yg((String) map.get("is_yg"));
		ierisitemdto.setIs_ygresult((String) map.get("is_ygresult"));
		
		//TODO 根据就诊id 获取vip状态， 代码重构时再做调整
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
