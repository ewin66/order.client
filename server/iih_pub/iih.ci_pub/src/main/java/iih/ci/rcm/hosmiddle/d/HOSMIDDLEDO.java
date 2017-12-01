package iih.ci.rcm.hosmiddle.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.hosmiddle.d.desc.HOSMIDDLEDODesc;
import java.math.BigDecimal;

/**
 * 院感上报中间表 DO数据 
 * 
 */
public class HOSMIDDLEDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MIDDLE= "Id_middle";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	public static final String ID_SUBCARD= "Id_subcard";
	public static final String TITLE= "Title";
	public static final String STATE= "State";
	public static final String STYLE= "Style";
	public static final String SERAILNO= "Serailno";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_middle() {
		return ((String) getAttrVal("Id_middle"));
	}	
	public void setId_middle(String Id_middle) {
		setAttrVal("Id_middle", Id_middle);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	public String getId_subcard() {
		return ((String) getAttrVal("Id_subcard"));
	}	
	public void setId_subcard(String Id_subcard) {
		setAttrVal("Id_subcard", Id_subcard);
	}
	public String getTitle() {
		return ((String) getAttrVal("Title"));
	}	
	public void setTitle(String Title) {
		setAttrVal("Title", Title);
	}
	public FBoolean getState() {
		return ((FBoolean) getAttrVal("State"));
	}	
	public void setState(FBoolean State) {
		setAttrVal("State", State);
	}
	public String getStyle() {
		return ((String) getAttrVal("Style"));
	}	
	public void setStyle(String Style) {
		setAttrVal("Style", Style);
	}
	public String getSerailno() {
		return ((String) getAttrVal("Serailno"));
	}	
	public void setSerailno(String Serailno) {
		setAttrVal("Serailno", Serailno);
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
		return "Id_middle";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_HOS_MIDDLE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HOSMIDDLEDODesc.class);
	}
	
}