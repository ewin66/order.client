package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cior.d.desc.OrdApRptOpItemDODesc;
import java.math.BigDecimal;

/**
 * 手术项目 DO数据 
 * 
 */
public class OrdApRptOpItemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_RPTSUGITM= "Id_rptsugitm";
	public static final String ID_RPTSUG= "Id_rptsug";
	public static final String ID_SRVSUG= "Id_srvsug";
	public static final String NAME_SRV_SUG= "Name_srv_sug";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rptsugitm() {
		return ((String) getAttrVal("Id_rptsugitm"));
	}	
	public void setId_rptsugitm(String Id_rptsugitm) {
		setAttrVal("Id_rptsugitm", Id_rptsugitm);
	}
	public String getId_rptsug() {
		return ((String) getAttrVal("Id_rptsug"));
	}	
	public void setId_rptsug(String Id_rptsug) {
		setAttrVal("Id_rptsug", Id_rptsug);
	}
	public String getId_srvsug() {
		return ((String) getAttrVal("Id_srvsug"));
	}	
	public void setId_srvsug(String Id_srvsug) {
		setAttrVal("Id_srvsug", Id_srvsug);
	}
	public String getName_srv_sug() {
		return ((String) getAttrVal("Name_srv_sug"));
	}	
	public void setName_srv_sug(String Name_srv_sug) {
		setAttrVal("Name_srv_sug", Name_srv_sug);
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
		return "Id_rptsugitm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rpt_sug_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApRptOpItemDODesc.class);
	}
	
}