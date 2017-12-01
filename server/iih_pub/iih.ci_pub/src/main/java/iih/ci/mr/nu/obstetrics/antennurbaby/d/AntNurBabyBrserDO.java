package iih.ci.mr.nu.obstetrics.antennurbaby.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.desc.AntNurBabyBrserDODesc;
import java.math.BigDecimal;

/**
 * 产科婴儿观察单 DO数据 
 * 
 */
public class AntNurBabyBrserDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_BRSER= "Id_brser";
	public static final String ID_ASS= "Id_ass";
	public static final String ID_SKINCOLOR= "Id_skincolor";
	public static final String SD_SKINCOLOR= "Sd_skincolor";
	public static final String ID_UMBILICAL= "Id_umbilical";
	public static final String SD_UMBILICAL= "Sd_umbilical";
	public static final String TSQKJCZ= "Tsqkjcz";
	public static final String ID_SIGNREC= "Id_signrec";
	public static final String JNSRLML= "Jnsrlml";
	public static final String DBC8H= "Dbc8h";
	public static final String XBC8H= "Xbc8h";
	public static final String TW= "Tw";
	public static final String D_REC= "D_rec";
	public static final String T_REC= "T_rec";
	public static final String ID_FEEDING= "Id_feeding";
	public static final String SD_FEEDING= "Sd_feeding";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SKINCOLOR= "Name_skincolor";
	public static final String NAME_UMBILICAL= "Name_umbilical";
	public static final String NAME_SIGNREC= "Name_signrec";
	public static final String NAME_FEEDING= "Name_feeding";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_brser() {
		return ((String) getAttrVal("Id_brser"));
	}	
	public void setId_brser(String Id_brser) {
		setAttrVal("Id_brser", Id_brser);
	}
	public String getId_ass() {
		return ((String) getAttrVal("Id_ass"));
	}	
	public void setId_ass(String Id_ass) {
		setAttrVal("Id_ass", Id_ass);
	}
	public String getId_skincolor() {
		return ((String) getAttrVal("Id_skincolor"));
	}	
	public void setId_skincolor(String Id_skincolor) {
		setAttrVal("Id_skincolor", Id_skincolor);
	}
	public String getSd_skincolor() {
		return ((String) getAttrVal("Sd_skincolor"));
	}	
	public void setSd_skincolor(String Sd_skincolor) {
		setAttrVal("Sd_skincolor", Sd_skincolor);
	}
	public String getId_umbilical() {
		return ((String) getAttrVal("Id_umbilical"));
	}	
	public void setId_umbilical(String Id_umbilical) {
		setAttrVal("Id_umbilical", Id_umbilical);
	}
	public String getSd_umbilical() {
		return ((String) getAttrVal("Sd_umbilical"));
	}	
	public void setSd_umbilical(String Sd_umbilical) {
		setAttrVal("Sd_umbilical", Sd_umbilical);
	}
	public String getTsqkjcz() {
		return ((String) getAttrVal("Tsqkjcz"));
	}	
	public void setTsqkjcz(String Tsqkjcz) {
		setAttrVal("Tsqkjcz", Tsqkjcz);
	}
	public String getId_signrec() {
		return ((String) getAttrVal("Id_signrec"));
	}	
	public void setId_signrec(String Id_signrec) {
		setAttrVal("Id_signrec", Id_signrec);
	}
	public Integer getJnsrlml() {
		return ((Integer) getAttrVal("Jnsrlml"));
	}	
	public void setJnsrlml(Integer Jnsrlml) {
		setAttrVal("Jnsrlml", Jnsrlml);
	}
	public Integer getDbc8h() {
		return ((Integer) getAttrVal("Dbc8h"));
	}	
	public void setDbc8h(Integer Dbc8h) {
		setAttrVal("Dbc8h", Dbc8h);
	}
	public Integer getXbc8h() {
		return ((Integer) getAttrVal("Xbc8h"));
	}	
	public void setXbc8h(Integer Xbc8h) {
		setAttrVal("Xbc8h", Xbc8h);
	}
	public FDouble getTw() {
		return ((FDouble) getAttrVal("Tw"));
	}	
	public void setTw(FDouble Tw) {
		setAttrVal("Tw", Tw);
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
	public String getId_feeding() {
		return ((String) getAttrVal("Id_feeding"));
	}	
	public void setId_feeding(String Id_feeding) {
		setAttrVal("Id_feeding", Id_feeding);
	}
	public String getSd_feeding() {
		return ((String) getAttrVal("Sd_feeding"));
	}	
	public void setSd_feeding(String Sd_feeding) {
		setAttrVal("Sd_feeding", Sd_feeding);
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
	public String getName_skincolor() {
		return ((String) getAttrVal("Name_skincolor"));
	}	
	public void setName_skincolor(String Name_skincolor) {
		setAttrVal("Name_skincolor", Name_skincolor);
	}
	public String getName_umbilical() {
		return ((String) getAttrVal("Name_umbilical"));
	}	
	public void setName_umbilical(String Name_umbilical) {
		setAttrVal("Name_umbilical", Name_umbilical);
	}
	public String getName_signrec() {
		return ((String) getAttrVal("Name_signrec"));
	}	
	public void setName_signrec(String Name_signrec) {
		setAttrVal("Name_signrec", Name_signrec);
	}
	public String getName_feeding() {
		return ((String) getAttrVal("Name_feeding"));
	}	
	public void setName_feeding(String Name_feeding) {
		setAttrVal("Name_feeding", Name_feeding);
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
		return "Id_brser";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_Mr_NU_ANTNURBaBrser";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntNurBabyBrserDODesc.class);
	}
	
}