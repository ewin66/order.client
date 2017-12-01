package iih.ci.mr.per.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.per.d.desc.PerListDODesc;
import java.math.BigDecimal;

/**
 * 实体 DO数据 
 * 
 */
public class PerListDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LIST= "Id_list";
	public static final String ID_PER= "Id_per";
	public static final String ID_ENT= "Id_ent";
	public static final String FILEFT= "Fileft";
	public static final String FIBOTTOM= "Fibottom";
	public static final String FICENTER= "Ficenter";
	public static final String JHYKTOPLEFT= "Jhyktopleft";
	public static final String JHYKTOPCENTER= "Jhyktopcenter";
	public static final String JHYKTOPRIGHT= "Jhyktopright";
	public static final String JHYKTOPBOTTOMLEFT= "Jhyktopbottomleft";
	public static final String JHYKTOPBOTTOMCENTER= "Jhyktopbottomcenter";
	public static final String JHYKTOPBOTTOMRIGHT= "Jhyktopbottomright";
	public static final String YNTOPVALUE= "Yntopvalue";
	public static final String YNBOTTOMVALUE= "Ynbottomvalue";
	public static final String DDVALUE= "Ddvalue";
	public static final String DDPOSITION= "Ddposition";
	public static final String PLITOPLEFT= "Plitopleft";
	public static final String PLITOPCENTER= "Plitopcenter";
	public static final String PLITOPRIGHT= "Plitopright";
	public static final String PLITBOTTOMLEFT= "Plitbottomleft";
	public static final String PLITBOTTOMCENTER= "Plitbottomcenter";
	public static final String PLITBOTTOMRIGHT= "Plitbottomright";
	public static final String CEJTOPLEFT= "Cejtopleft";
	public static final String CEJTOPCENTER= "Cejtopcenter";
	public static final String CEJTOPRIGHT= "Cejtopright";
	public static final String CEJBOTTOMLEFT= "Cejbottomleft";
	public static final String CEJBOTTOMCENTER= "Cejbottomcenter";
	public static final String CEJBOTTOMRIGHT= "Cejbottomright";
	public static final String BITOPVALUE= "Bitopvalue";
	public static final String BIBOTTOMVALUE= "Bibottomvalue";
	public static final String PDTOPLEFT= "Pdtopleft";
	public static final String PDTOPCENTER= "Pdtopcenter";
	public static final String PDTOPRIGHT= "Pdtopright";
	public static final String PDBOTTOMLEFT= "Pdbottomleft";
	public static final String PDBOTTOMCENTER= "Pdbottomcenter";
	public static final String PDBOTTOMRIGHT= "Pdbottomright";
	public static final String ID_PAT= "Id_pat";
	public static final String BLEEDTOPLEFT= "Bleedtopleft";
	public static final String BLEEDTOPCENTER= "Bleedtopcenter";
	public static final String BLEEDTOPRIGHT= "Bleedtopright";
	public static final String BLEEDBOTTOMLEFT= "Bleedbottomleft";
	public static final String BLEEDBOTTOMCENTER= "Bleedbottomcenter";
	public static final String BLEEDBOTTOMRIGHT= "Bleedbottomright";
	public static final String TEECHSTATUS= "Teechstatus";
	public static final String TEECHINDEX= "Teechindex";
	public static final String DT_OP= "Dt_op";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_list() {
		return ((String) getAttrVal("Id_list"));
	}	
	public void setId_list(String Id_list) {
		setAttrVal("Id_list", Id_list);
	}
	public String getId_per() {
		return ((String) getAttrVal("Id_per"));
	}	
	public void setId_per(String Id_per) {
		setAttrVal("Id_per", Id_per);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getFileft() {
		return ((String) getAttrVal("Fileft"));
	}	
	public void setFileft(String Fileft) {
		setAttrVal("Fileft", Fileft);
	}
	public String getFibottom() {
		return ((String) getAttrVal("Fibottom"));
	}	
	public void setFibottom(String Fibottom) {
		setAttrVal("Fibottom", Fibottom);
	}
	public String getFicenter() {
		return ((String) getAttrVal("Ficenter"));
	}	
	public void setFicenter(String Ficenter) {
		setAttrVal("Ficenter", Ficenter);
	}
	public String getJhyktopleft() {
		return ((String) getAttrVal("Jhyktopleft"));
	}	
	public void setJhyktopleft(String Jhyktopleft) {
		setAttrVal("Jhyktopleft", Jhyktopleft);
	}
	public String getJhyktopcenter() {
		return ((String) getAttrVal("Jhyktopcenter"));
	}	
	public void setJhyktopcenter(String Jhyktopcenter) {
		setAttrVal("Jhyktopcenter", Jhyktopcenter);
	}
	public String getJhyktopright() {
		return ((String) getAttrVal("Jhyktopright"));
	}	
	public void setJhyktopright(String Jhyktopright) {
		setAttrVal("Jhyktopright", Jhyktopright);
	}
	public String getJhyktopbottomleft() {
		return ((String) getAttrVal("Jhyktopbottomleft"));
	}	
	public void setJhyktopbottomleft(String Jhyktopbottomleft) {
		setAttrVal("Jhyktopbottomleft", Jhyktopbottomleft);
	}
	public String getJhyktopbottomcenter() {
		return ((String) getAttrVal("Jhyktopbottomcenter"));
	}	
	public void setJhyktopbottomcenter(String Jhyktopbottomcenter) {
		setAttrVal("Jhyktopbottomcenter", Jhyktopbottomcenter);
	}
	public String getJhyktopbottomright() {
		return ((String) getAttrVal("Jhyktopbottomright"));
	}	
	public void setJhyktopbottomright(String Jhyktopbottomright) {
		setAttrVal("Jhyktopbottomright", Jhyktopbottomright);
	}
	public String getYntopvalue() {
		return ((String) getAttrVal("Yntopvalue"));
	}	
	public void setYntopvalue(String Yntopvalue) {
		setAttrVal("Yntopvalue", Yntopvalue);
	}
	public String getYnbottomvalue() {
		return ((String) getAttrVal("Ynbottomvalue"));
	}	
	public void setYnbottomvalue(String Ynbottomvalue) {
		setAttrVal("Ynbottomvalue", Ynbottomvalue);
	}
	public String getDdvalue() {
		return ((String) getAttrVal("Ddvalue"));
	}	
	public void setDdvalue(String Ddvalue) {
		setAttrVal("Ddvalue", Ddvalue);
	}
	public String getDdposition() {
		return ((String) getAttrVal("Ddposition"));
	}	
	public void setDdposition(String Ddposition) {
		setAttrVal("Ddposition", Ddposition);
	}
	public String getPlitopleft() {
		return ((String) getAttrVal("Plitopleft"));
	}	
	public void setPlitopleft(String Plitopleft) {
		setAttrVal("Plitopleft", Plitopleft);
	}
	public String getPlitopcenter() {
		return ((String) getAttrVal("Plitopcenter"));
	}	
	public void setPlitopcenter(String Plitopcenter) {
		setAttrVal("Plitopcenter", Plitopcenter);
	}
	public String getPlitopright() {
		return ((String) getAttrVal("Plitopright"));
	}	
	public void setPlitopright(String Plitopright) {
		setAttrVal("Plitopright", Plitopright);
	}
	public String getPlitbottomleft() {
		return ((String) getAttrVal("Plitbottomleft"));
	}	
	public void setPlitbottomleft(String Plitbottomleft) {
		setAttrVal("Plitbottomleft", Plitbottomleft);
	}
	public String getPlitbottomcenter() {
		return ((String) getAttrVal("Plitbottomcenter"));
	}	
	public void setPlitbottomcenter(String Plitbottomcenter) {
		setAttrVal("Plitbottomcenter", Plitbottomcenter);
	}
	public String getPlitbottomright() {
		return ((String) getAttrVal("Plitbottomright"));
	}	
	public void setPlitbottomright(String Plitbottomright) {
		setAttrVal("Plitbottomright", Plitbottomright);
	}
	public String getCejtopleft() {
		return ((String) getAttrVal("Cejtopleft"));
	}	
	public void setCejtopleft(String Cejtopleft) {
		setAttrVal("Cejtopleft", Cejtopleft);
	}
	public String getCejtopcenter() {
		return ((String) getAttrVal("Cejtopcenter"));
	}	
	public void setCejtopcenter(String Cejtopcenter) {
		setAttrVal("Cejtopcenter", Cejtopcenter);
	}
	public String getCejtopright() {
		return ((String) getAttrVal("Cejtopright"));
	}	
	public void setCejtopright(String Cejtopright) {
		setAttrVal("Cejtopright", Cejtopright);
	}
	public String getCejbottomleft() {
		return ((String) getAttrVal("Cejbottomleft"));
	}	
	public void setCejbottomleft(String Cejbottomleft) {
		setAttrVal("Cejbottomleft", Cejbottomleft);
	}
	public String getCejbottomcenter() {
		return ((String) getAttrVal("Cejbottomcenter"));
	}	
	public void setCejbottomcenter(String Cejbottomcenter) {
		setAttrVal("Cejbottomcenter", Cejbottomcenter);
	}
	public String getCejbottomright() {
		return ((String) getAttrVal("Cejbottomright"));
	}	
	public void setCejbottomright(String Cejbottomright) {
		setAttrVal("Cejbottomright", Cejbottomright);
	}
	public String getBitopvalue() {
		return ((String) getAttrVal("Bitopvalue"));
	}	
	public void setBitopvalue(String Bitopvalue) {
		setAttrVal("Bitopvalue", Bitopvalue);
	}
	public String getBibottomvalue() {
		return ((String) getAttrVal("Bibottomvalue"));
	}	
	public void setBibottomvalue(String Bibottomvalue) {
		setAttrVal("Bibottomvalue", Bibottomvalue);
	}
	public String getPdtopleft() {
		return ((String) getAttrVal("Pdtopleft"));
	}	
	public void setPdtopleft(String Pdtopleft) {
		setAttrVal("Pdtopleft", Pdtopleft);
	}
	public String getPdtopcenter() {
		return ((String) getAttrVal("Pdtopcenter"));
	}	
	public void setPdtopcenter(String Pdtopcenter) {
		setAttrVal("Pdtopcenter", Pdtopcenter);
	}
	public String getPdtopright() {
		return ((String) getAttrVal("Pdtopright"));
	}	
	public void setPdtopright(String Pdtopright) {
		setAttrVal("Pdtopright", Pdtopright);
	}
	public String getPdbottomleft() {
		return ((String) getAttrVal("Pdbottomleft"));
	}	
	public void setPdbottomleft(String Pdbottomleft) {
		setAttrVal("Pdbottomleft", Pdbottomleft);
	}
	public String getPdbottomcenter() {
		return ((String) getAttrVal("Pdbottomcenter"));
	}	
	public void setPdbottomcenter(String Pdbottomcenter) {
		setAttrVal("Pdbottomcenter", Pdbottomcenter);
	}
	public String getPdbottomright() {
		return ((String) getAttrVal("Pdbottomright"));
	}	
	public void setPdbottomright(String Pdbottomright) {
		setAttrVal("Pdbottomright", Pdbottomright);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getBleedtopleft() {
		return ((String) getAttrVal("Bleedtopleft"));
	}	
	public void setBleedtopleft(String Bleedtopleft) {
		setAttrVal("Bleedtopleft", Bleedtopleft);
	}
	public String getBleedtopcenter() {
		return ((String) getAttrVal("Bleedtopcenter"));
	}	
	public void setBleedtopcenter(String Bleedtopcenter) {
		setAttrVal("Bleedtopcenter", Bleedtopcenter);
	}
	public String getBleedtopright() {
		return ((String) getAttrVal("Bleedtopright"));
	}	
	public void setBleedtopright(String Bleedtopright) {
		setAttrVal("Bleedtopright", Bleedtopright);
	}
	public String getBleedbottomleft() {
		return ((String) getAttrVal("Bleedbottomleft"));
	}	
	public void setBleedbottomleft(String Bleedbottomleft) {
		setAttrVal("Bleedbottomleft", Bleedbottomleft);
	}
	public String getBleedbottomcenter() {
		return ((String) getAttrVal("Bleedbottomcenter"));
	}	
	public void setBleedbottomcenter(String Bleedbottomcenter) {
		setAttrVal("Bleedbottomcenter", Bleedbottomcenter);
	}
	public String getBleedbottomright() {
		return ((String) getAttrVal("Bleedbottomright"));
	}	
	public void setBleedbottomright(String Bleedbottomright) {
		setAttrVal("Bleedbottomright", Bleedbottomright);
	}
	public String getTeechstatus() {
		return ((String) getAttrVal("Teechstatus"));
	}	
	public void setTeechstatus(String Teechstatus) {
		setAttrVal("Teechstatus", Teechstatus);
	}
	public String getTeechindex() {
		return ((String) getAttrVal("Teechindex"));
	}	
	public void setTeechindex(String Teechindex) {
		setAttrVal("Teechindex", Teechindex);
	}
	public FDateTime getDt_op() {
		return ((FDateTime) getAttrVal("Dt_op"));
	}	
	public void setDt_op(FDateTime Dt_op) {
		setAttrVal("Dt_op", Dt_op);
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
		return "Id_list";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_PER_QC_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PerListDODesc.class);
	}
	
}