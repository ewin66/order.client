package iih.ci.mrfp.other2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.other2mrfp.d.desc.CiMrfpIntenCareDODesc;
import java.math.BigDecimal;

/**
 * 重症监护 DO数据 
 * 
 */
public class CiMrfpIntenCareDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRFP_INTENCARE= "Id_mrfp_intencare";
	public static final String ID_CIMRFPOTHER= "Id_cimrfpother";
	public static final String NAME_INTENCARE= "Name_intencare";
	public static final String TIME_IN_INTENCARE= "Time_in_intencare";
	public static final String TIME_OUT_INTENCARE= "Time_out_intencare";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrfp_intencare() {
		return ((String) getAttrVal("Id_mrfp_intencare"));
	}	
	public void setId_mrfp_intencare(String Id_mrfp_intencare) {
		setAttrVal("Id_mrfp_intencare", Id_mrfp_intencare);
	}
	public String getId_cimrfpother() {
		return ((String) getAttrVal("Id_cimrfpother"));
	}	
	public void setId_cimrfpother(String Id_cimrfpother) {
		setAttrVal("Id_cimrfpother", Id_cimrfpother);
	}
	public String getName_intencare() {
		return ((String) getAttrVal("Name_intencare"));
	}	
	public void setName_intencare(String Name_intencare) {
		setAttrVal("Name_intencare", Name_intencare);
	}
	public FDateTime getTime_in_intencare() {
		return ((FDateTime) getAttrVal("Time_in_intencare"));
	}	
	public void setTime_in_intencare(FDateTime Time_in_intencare) {
		setAttrVal("Time_in_intencare", Time_in_intencare);
	}
	public FDateTime getTime_out_intencare() {
		return ((FDateTime) getAttrVal("Time_out_intencare"));
	}	
	public void setTime_out_intencare(FDateTime Time_out_intencare) {
		setAttrVal("Time_out_intencare", Time_out_intencare);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_mrfp_intencare";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrfp_intencare";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrfpIntenCareDODesc.class);
	}
	
}