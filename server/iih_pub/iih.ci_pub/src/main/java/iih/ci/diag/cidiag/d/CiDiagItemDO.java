package iih.ci.diag.cidiag.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.diag.cidiag.d.desc.CiDiagItemDODesc;
import java.math.BigDecimal;

/**
 * 临床诊断明细 DO数据 
 * 
 */
public class CiDiagItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DIITM= "Id_diitm";
	public static final String ID_DI= "Id_di";
	public static final String SORTNO= "Sortno";
	public static final String ID_DIDEF= "Id_didef";
	public static final String ID_DIDEF_CODE= "Id_didef_code";
	public static final String ID_DIDEF_NAME= "Id_didef_name";
	public static final String ID_DIDEF_SYN= "Id_didef_syn";
	public static final String ID_DIDEF_SYN_CODE= "Id_didef_syn_code";
	public static final String ID_DIDEF_SYN_NAME= "Id_didef_syn_name";
	public static final String DES= "Des";
	public static final String FG_MAJDI= "Fg_majdi";
	public static final String FG_SUSPDI= "Fg_suspdi";
	public static final String FG_INFEDI= "Fg_infedi";
	public static final String ID_PARENT= "Id_parent";
	public static final String INNERCODE= "Innercode";
	public static final String FG_FLUPCI= "Fg_flupci";
	public static final String FG_SYM= "Fg_sym";
	public static final String SUPPLEMENT= "Supplement";
	public static final String ID_DISYS= "Id_disys";
	public static final String SD_DISYS= "Sd_disys";
	public static final String ID_DISYS_NAME= "Id_disys_name";
	public static final String DI_STANDARD= "Di_standard";
	public static final String DI_STANDARD_CODE= "Di_standard_code";
	public static final String DI_STANDARD_NAME= "Di_standard_name";
	public static final String FG_SELF= "Fg_self";
	public static final String FG_UR= "Fg_ur";
	public static final String FG_CHRONIC= "Fg_chronic";
	public static final String FG_SPECIAL= "Fg_special";
	public static final String EU_HPBEYOND= "Eu_hpbeyond";
	public static final String ID_INFECTIONTP= "Id_infectiontp";
	public static final String SD_INFECTIONTP= "Sd_infectiontp";
	public static final String DIDEF_CODE= "Didef_code";
	public static final String DIDEF_NAME= "Didef_name";
	public static final String DIDEF_SYN_NAME= "Didef_syn_name";
	public static final String DIDEF_SYN_CODE= "Didef_syn_code";
	public static final String DISYS_CODE= "Disys_code";
	public static final String DISYS_NAME= "Disys_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}	
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}	
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}	
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	public String getId_didef_code() {
		return ((String) getAttrVal("Id_didef_code"));
	}	
	public void setId_didef_code(String Id_didef_code) {
		setAttrVal("Id_didef_code", Id_didef_code);
	}
	public String getId_didef_name() {
		return ((String) getAttrVal("Id_didef_name"));
	}	
	public void setId_didef_name(String Id_didef_name) {
		setAttrVal("Id_didef_name", Id_didef_name);
	}
	public String getId_didef_syn() {
		return ((String) getAttrVal("Id_didef_syn"));
	}	
	public void setId_didef_syn(String Id_didef_syn) {
		setAttrVal("Id_didef_syn", Id_didef_syn);
	}
	public String getId_didef_syn_code() {
		return ((String) getAttrVal("Id_didef_syn_code"));
	}	
	public void setId_didef_syn_code(String Id_didef_syn_code) {
		setAttrVal("Id_didef_syn_code", Id_didef_syn_code);
	}
	public String getId_didef_syn_name() {
		return ((String) getAttrVal("Id_didef_syn_name"));
	}	
	public void setId_didef_syn_name(String Id_didef_syn_name) {
		setAttrVal("Id_didef_syn_name", Id_didef_syn_name);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_majdi() {
		return ((FBoolean) getAttrVal("Fg_majdi"));
	}	
	public void setFg_majdi(FBoolean Fg_majdi) {
		setAttrVal("Fg_majdi", Fg_majdi);
	}
	public FBoolean getFg_suspdi() {
		return ((FBoolean) getAttrVal("Fg_suspdi"));
	}	
	public void setFg_suspdi(FBoolean Fg_suspdi) {
		setAttrVal("Fg_suspdi", Fg_suspdi);
	}
	public FBoolean getFg_infedi() {
		return ((FBoolean) getAttrVal("Fg_infedi"));
	}	
	public void setFg_infedi(FBoolean Fg_infedi) {
		setAttrVal("Fg_infedi", Fg_infedi);
	}
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	public FBoolean getFg_flupci() {
		return ((FBoolean) getAttrVal("Fg_flupci"));
	}	
	public void setFg_flupci(FBoolean Fg_flupci) {
		setAttrVal("Fg_flupci", Fg_flupci);
	}
	public FBoolean getFg_sym() {
		return ((FBoolean) getAttrVal("Fg_sym"));
	}	
	public void setFg_sym(FBoolean Fg_sym) {
		setAttrVal("Fg_sym", Fg_sym);
	}
	public String getSupplement() {
		return ((String) getAttrVal("Supplement"));
	}	
	public void setSupplement(String Supplement) {
		setAttrVal("Supplement", Supplement);
	}
	public String getId_disys() {
		return ((String) getAttrVal("Id_disys"));
	}	
	public void setId_disys(String Id_disys) {
		setAttrVal("Id_disys", Id_disys);
	}
	public String getSd_disys() {
		return ((String) getAttrVal("Sd_disys"));
	}	
	public void setSd_disys(String Sd_disys) {
		setAttrVal("Sd_disys", Sd_disys);
	}
	public String getId_disys_name() {
		return ((String) getAttrVal("Id_disys_name"));
	}	
	public void setId_disys_name(String Id_disys_name) {
		setAttrVal("Id_disys_name", Id_disys_name);
	}
	public String getDi_standard() {
		return ((String) getAttrVal("Di_standard"));
	}	
	public void setDi_standard(String Di_standard) {
		setAttrVal("Di_standard", Di_standard);
	}
	public String getDi_standard_code() {
		return ((String) getAttrVal("Di_standard_code"));
	}	
	public void setDi_standard_code(String Di_standard_code) {
		setAttrVal("Di_standard_code", Di_standard_code);
	}
	public String getDi_standard_name() {
		return ((String) getAttrVal("Di_standard_name"));
	}	
	public void setDi_standard_name(String Di_standard_name) {
		setAttrVal("Di_standard_name", Di_standard_name);
	}
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}	
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	public FBoolean getFg_ur() {
		return ((FBoolean) getAttrVal("Fg_ur"));
	}	
	public void setFg_ur(FBoolean Fg_ur) {
		setAttrVal("Fg_ur", Fg_ur);
	}
	public FBoolean getFg_chronic() {
		return ((FBoolean) getAttrVal("Fg_chronic"));
	}	
	public void setFg_chronic(FBoolean Fg_chronic) {
		setAttrVal("Fg_chronic", Fg_chronic);
	}
	public FBoolean getFg_special() {
		return ((FBoolean) getAttrVal("Fg_special"));
	}	
	public void setFg_special(FBoolean Fg_special) {
		setAttrVal("Fg_special", Fg_special);
	}
	public String getEu_hpbeyond() {
		return ((String) getAttrVal("Eu_hpbeyond"));
	}	
	public void setEu_hpbeyond(String Eu_hpbeyond) {
		setAttrVal("Eu_hpbeyond", Eu_hpbeyond);
	}
	public String getId_infectiontp() {
		return ((String) getAttrVal("Id_infectiontp"));
	}	
	public void setId_infectiontp(String Id_infectiontp) {
		setAttrVal("Id_infectiontp", Id_infectiontp);
	}
	public String getSd_infectiontp() {
		return ((String) getAttrVal("Sd_infectiontp"));
	}	
	public void setSd_infectiontp(String Sd_infectiontp) {
		setAttrVal("Sd_infectiontp", Sd_infectiontp);
	}
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}	
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}	
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	public String getDidef_syn_name() {
		return ((String) getAttrVal("Didef_syn_name"));
	}	
	public void setDidef_syn_name(String Didef_syn_name) {
		setAttrVal("Didef_syn_name", Didef_syn_name);
	}
	public String getDidef_syn_code() {
		return ((String) getAttrVal("Didef_syn_code"));
	}	
	public void setDidef_syn_code(String Didef_syn_code) {
		setAttrVal("Didef_syn_code", Didef_syn_code);
	}
	public String getDisys_code() {
		return ((String) getAttrVal("Disys_code"));
	}	
	public void setDisys_code(String Disys_code) {
		setAttrVal("Disys_code", Disys_code);
	}
	public String getDisys_name() {
		return ((String) getAttrVal("Disys_name"));
	}	
	public void setDisys_name(String Disys_name) {
		setAttrVal("Disys_name", Disys_name);
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
		return "Id_diitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_di_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiDiagItemDODesc.class);
	}
	
}