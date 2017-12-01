package iih.ci.ord.s.bp.iemsg;

import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;

import java.util.Map;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

public class CiIEMsgInfoHelper {
	/**
	 * 创建集成平台药品医嘱确认数据信息
	 * @param confirminfo
	 * @return
	 */
	public static IEPharmOrEnDTO map2IEPharmOrEnDTO(Map<String,Object> confirminfo){
		IEPharmOrEnDTO rtn=new IEPharmOrEnDTO();
		rtn.setId_iepharmoren((String)confirminfo.get("id_iepharmoren"));
		rtn.setPatientid((String)confirminfo.get("patientid"));
		rtn.setPatientseqnum((String)confirminfo.get("patientseqnum"));
		rtn.setAdmiss_times(confirminfo.get("admiss_times")+"");
		rtn.setDeptcode((String)confirminfo.get("deptcode"));
		rtn.setDeptname((String)confirminfo.get("deptname"));
		rtn.setWardcode((String)confirminfo.get("wardcode"));
		rtn.setWardname((String)confirminfo.get("wardname"));
		rtn.setBedcode((String)confirminfo.get("bedcode"));
		rtn.setName((String)confirminfo.get("name"));
		rtn.setSexid((String)confirminfo.get("sexid"));
		rtn.setBirthdaydate(new FDate(confirminfo.get("birthdaydate")+""));
		rtn.setAge((String)confirminfo.get("age"));
		rtn.setConfirm_date(new FDateTime(confirminfo.get("confirm_date")+""));
		rtn.setConfirm_nurse_code((String)confirminfo.get("confirm_nurse_code"));
		rtn.setConfirm_nurse_name((String)confirminfo.get("confirm_nurse_name"));
		rtn.setOrgname((String)confirminfo.get("orgcode"));
		rtn.setOrgname((String)confirminfo.get("orgname"));
		return rtn;
	}

}
