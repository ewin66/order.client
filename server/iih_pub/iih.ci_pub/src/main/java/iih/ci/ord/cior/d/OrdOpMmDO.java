package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdOpMmDODesc;
import java.math.BigDecimal;

/**
 * 手术卫材 DO数据 
 * 
 */
public class OrdOpMmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APOPMM= "Id_apopmm";
	public static final String ID_APOP= "Id_apop";
	public static final String ID_MM= "Id_mm";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String SPEC= "Spec";
	public static final String ID_SUP= "Id_sup";
	public static final String PRICE= "Price";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String ID_UNIT_PKGSP= "Id_unit_pkgsp";
	public static final String NAME_MM= "Name_mm";
	public static final String NAME_MMTP= "Name_mmtp";
	public static final String NAME_SUG= "Name_sug";
	public static final String NAME_UNIT_PKGSP= "Name_unit_pkgsp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apopmm() {
		return ((String) getAttrVal("Id_apopmm"));
	}	
	public void setId_apopmm(String Id_apopmm) {
		setAttrVal("Id_apopmm", Id_apopmm);
	}
	public String getId_apop() {
		return ((String) getAttrVal("Id_apop"));
	}	
	public void setId_apop(String Id_apop) {
		setAttrVal("Id_apop", Id_apop);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}	
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	public Integer getQuan_cur() {
		return ((Integer) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(Integer Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public String getId_unit_pkgsp() {
		return ((String) getAttrVal("Id_unit_pkgsp"));
	}	
	public void setId_unit_pkgsp(String Id_unit_pkgsp) {
		setAttrVal("Id_unit_pkgsp", Id_unit_pkgsp);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}	
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}	
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	public String getName_unit_pkgsp() {
		return ((String) getAttrVal("Name_unit_pkgsp"));
	}	
	public void setName_unit_pkgsp(String Name_unit_pkgsp) {
		setAttrVal("Name_unit_pkgsp", Name_unit_pkgsp);
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
		return "Id_apopmm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_sug_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdOpMmDODesc.class);
	}
	
}