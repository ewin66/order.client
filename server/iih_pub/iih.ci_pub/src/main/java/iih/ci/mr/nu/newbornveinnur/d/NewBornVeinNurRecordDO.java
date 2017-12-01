package iih.ci.mr.nu.newbornveinnur.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.newbornveinnur.d.desc.NewBornVeinNurRecordDODesc;
import java.math.BigDecimal;

/**
 * 新生儿脐静脉护理记录 DO数据 
 * 
 */
public class NewBornVeinNurRecordDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NBVNREC= "Id_nbvnrec";
	public static final String ID_NBVN= "Id_nbvn";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String REDSWOLLEN= "Redswollen";
	public static final String BLEEDING= "Bleeding";
	public static final String ID_SMOOTH_PIPE= "Id_smooth_pipe";
	public static final String SD_SMOOTH_PIPE= "Sd_smooth_pipe";
	public static final String CATHETER_INSERTION= "Catheter_insertion";
	public static final String CATHETER_EXPOSED= "Catheter_exposed";
	public static final String REPLACE_DRESSING= "Replace_dressing";
	public static final String REPLACE_INFUSION_CONECTOR= "Replace_infusion_conector";
	public static final String OTHER= "Other";
	public static final String ID_SIGN= "Id_sign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SMOOTH_PIPE= "Name_smooth_pipe";
	public static final String NAME_SIGN= "Name_sign";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nbvnrec() {
		return ((String) getAttrVal("Id_nbvnrec"));
	}	
	public void setId_nbvnrec(String Id_nbvnrec) {
		setAttrVal("Id_nbvnrec", Id_nbvnrec);
	}
	public String getId_nbvn() {
		return ((String) getAttrVal("Id_nbvn"));
	}	
	public void setId_nbvn(String Id_nbvn) {
		setAttrVal("Id_nbvn", Id_nbvn);
	}
	public FDate getD_rec() {
		return ((FDate) getAttrVal("D_rec"));
	}	
	public void setD_rec(FDate D_rec) {
		setAttrVal("D_rec", D_rec);
	}
	public FTime getT_rec() {
		return ((FTime) getAttrVal("T_rec"));
	}	
	public void setT_rec(FTime T_rec) {
		setAttrVal("T_rec", T_rec);
	}
	public Integer getRedswollen() {
		return ((Integer) getAttrVal("Redswollen"));
	}	
	public void setRedswollen(Integer Redswollen) {
		setAttrVal("Redswollen", Redswollen);
	}
	public Integer getBleeding() {
		return ((Integer) getAttrVal("Bleeding"));
	}	
	public void setBleeding(Integer Bleeding) {
		setAttrVal("Bleeding", Bleeding);
	}
	public String getId_smooth_pipe() {
		return ((String) getAttrVal("Id_smooth_pipe"));
	}	
	public void setId_smooth_pipe(String Id_smooth_pipe) {
		setAttrVal("Id_smooth_pipe", Id_smooth_pipe);
	}
	public String getSd_smooth_pipe() {
		return ((String) getAttrVal("Sd_smooth_pipe"));
	}	
	public void setSd_smooth_pipe(String Sd_smooth_pipe) {
		setAttrVal("Sd_smooth_pipe", Sd_smooth_pipe);
	}
	public Integer getCatheter_insertion() {
		return ((Integer) getAttrVal("Catheter_insertion"));
	}	
	public void setCatheter_insertion(Integer Catheter_insertion) {
		setAttrVal("Catheter_insertion", Catheter_insertion);
	}
	public Integer getCatheter_exposed() {
		return ((Integer) getAttrVal("Catheter_exposed"));
	}	
	public void setCatheter_exposed(Integer Catheter_exposed) {
		setAttrVal("Catheter_exposed", Catheter_exposed);
	}
	public Integer getReplace_dressing() {
		return ((Integer) getAttrVal("Replace_dressing"));
	}	
	public void setReplace_dressing(Integer Replace_dressing) {
		setAttrVal("Replace_dressing", Replace_dressing);
	}
	public Integer getReplace_infusion_conector() {
		return ((Integer) getAttrVal("Replace_infusion_conector"));
	}	
	public void setReplace_infusion_conector(Integer Replace_infusion_conector) {
		setAttrVal("Replace_infusion_conector", Replace_infusion_conector);
	}
	public String getOther() {
		return ((String) getAttrVal("Other"));
	}	
	public void setOther(String Other) {
		setAttrVal("Other", Other);
	}
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getName_smooth_pipe() {
		return ((String) getAttrVal("Name_smooth_pipe"));
	}	
	public void setName_smooth_pipe(String Name_smooth_pipe) {
		setAttrVal("Name_smooth_pipe", Name_smooth_pipe);
	}
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
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
		return "Id_nbvnrec";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mr_nu_nbvn_rec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NewBornVeinNurRecordDODesc.class);
	}
	
}