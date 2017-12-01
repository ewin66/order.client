package iih.ci.mr.nu.admissionnursingassessment.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.admissionnursingassessment.d.desc.AdmissionNursingAssessmentDODesc;
import java.math.BigDecimal;

/**
 * 入院护理评估单 DO数据 
 * 
 */
public class AdmissionNursingAssessmentDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ANA= "Id_ana";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String AGE= "Age";
	public static final String NAME_BED= "Name_bed";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	public static final String GLQT= "Glqt";
	public static final String SD_REFERALSRC= "Sd_referalsrc";
	public static final String ID_REFERALSRC= "Id_referalsrc";
	public static final String OTHER_REFERALSRC= "Other_referalsrc";
	public static final String ID_RYXDFS= "Id_ryxdfs";
	public static final String SD_YRXDFS= "Sd_yrxdfs";
	public static final String RYXDFS_OTHER= "Ryxdfs_other";
	public static final String ID_JY= "Id_jy";
	public static final String SD_JY= "Sd_jy";
	public static final String EU_ZJ= "Eu_zj";
	public static final String EU_PB= "Eu_pb";
	public static final String EU_GMS= "Eu_gms";
	public static final String EU_SHXY= "Eu_shxy";
	public static final String EU_SHYJ= "Eu_shyj";
	public static final String EU_JWS= "Eu_jws";
	public static final String EU_QX= "Eu_qx";
	public static final String ID_QXXX= "Id_qxxx";
	public static final String SD_QXXX= "Sd_qxxx";
	public static final String OTHER_QXXX= "Other_qxxx";
	public static final String EU_YSSP= "Eu_yssp";
	public static final String ID_YSSPYCXX= "Id_ysspycxx";
	public static final String SD_YSSPYCXX= "Sd_ysspycxx";
	public static final String OTHER_YSSPYCXX= "Other_ysspycxx";
	public static final String EU_STZKSL= "Eu_stzksl";
	public static final String ID_STZKSLXX= "Id_stzkslxx";
	public static final String SD_STZKSLXX= "Sd_stzkslxx";
	public static final String OTHER_STZKSLXX= "Other_stzkslxx";
	public static final String EU_STZKTL= "Eu_stzktl";
	public static final String ID_STZKTLXX= "Id_stzktlxx";
	public static final String SD_STZKTLXX= "Sd_stzktlxx";
	public static final String OTHER_STZKTLXX= "Other_stzktlxx";
	public static final String EU_STZKYY= "Eu_stzkyy";
	public static final String ID_STZKYYXX= "Id_stzkyyxx";
	public static final String SD_STZKYYXX= "Sd_stzkyyxx";
	public static final String OTHER_STZKYYXX= "Other_stzkyyxx";
	public static final String EU_STZKMR= "Eu_stzkmr";
	public static final String ID_STZKMRXX= "Id_stzkmrxx";
	public static final String SD_STZKMRXX= "Sd_stzkmrxx";
	public static final String OTHER_STZKMRXX= "Other_stzkmrxx";
	public static final String EU_STZKJS= "Eu_stzkjs";
	public static final String ID_STZKJSXX= "Id_stzkjsxx";
	public static final String SD_STZKJSXX= "Sd_stzkjsxx";
	public static final String OTHER_STZKJSXX= "Other_stzkjsxx";
	public static final String EU_STZKPN= "Eu_stzkpn";
	public static final String ID_STZKPNXX= "Id_stzkpnxx";
	public static final String SD_STZKPNXX= "Sd_stzkpnxx";
	public static final String OTHER_STZKPNXX= "Other_stzkpnxx";
	public static final String EU_STZKPB= "Eu_stzkpb";
	public static final String ID_STZKPBXX= "Id_stzkpbxx";
	public static final String SD_STZKPBXX= "Sd_stzkpbxx";
	public static final String OTHER_STZKPBXX= "Other_stzkpbxx";
	public static final String ID_STZKHD= "Id_stzkhd";
	public static final String SD_STZKHD= "Sd_stzkhd";
	public static final String OHER_STZKHD= "Oher_stzkhd";
	public static final String EU_STZKSM= "Eu_stzksm";
	public static final String ID_STZKSMXX= "Id_stzksmxx";
	public static final String SD_STZKSMXX= "Sd_stzksmxx";
	public static final String OTHER_STZKSMXX= "Other_stzksmxx";
	public static final String EU_STZKZLNL= "Eu_stzkzlnl";
	public static final String ID_STZKZLNLXX= "Id_stzkzlnlxx";
	public static final String SD_STZKZLNLXX= "Sd_stzkzlnlxx";
	public static final String OTHER_STZKZLNLXX= "Other_stzkzlnlxx";
	public static final String EU_STZKPF= "Eu_stzkpf";
	public static final String ID_PFYCLX= "Id_pfyclx";
	public static final String SD_PFYCLX= "Sd_pfyclx";
	public static final String OTHER_PFYCLX= "Other_pfyclx";
	public static final String PRESSURESORE= "Pressuresore";
	public static final String EU_GL= "Eu_gl";
	public static final String ID_GLYLG= "Id_glylg";
	public static final String SD_GLYLG= "Sd_glylg";
	public static final String OTHER_GLYLG= "Other_glylg";
	public static final String ID_GLWZJM= "Id_glwzjm";
	public static final String SD_GLWZJM= "Sd_glwzjm";
	public static final String ID_GLSJM= "Id_glsjm";
	public static final String SD_GLSJM= "Sd_glsjm";
	public static final String OTHER_GLSJM= "Other_glsjm";
	public static final String ID_GLRGQD= "Id_glrgqd";
	public static final String SD_GLRGQD= "Sd_glrgqd";
	public static final String EU_DDFXPG= "Eu_ddfxpg";
	public static final String SCORE_FALLL= "Score_falll";
	public static final String INFORSOURCES= "Inforsources";
	public static final String SIGNATURE= "Signature";
	public static final String DT_ASSESS= "Dt_assess";
	public static final String ZKPG= "Zkpg";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_REFERALSRC= "Name_referalsrc";
	public static final String NAME_RYXDFS= "Name_ryxdfs";
	public static final String NAME_JY= "Name_jy";
	public static final String NAME_QXXX= "Name_qxxx";
	public static final String NAME_YSSPYCXX= "Name_ysspycxx";
	public static final String NAME_STZKSLXX= "Name_stzkslxx";
	public static final String NAME_STZKTLXX= "Name_stzktlxx";
	public static final String NAME_STZKYYXX= "Name_stzkyyxx";
	public static final String NAME_STZKMRXX= "Name_stzkmrxx";
	public static final String NAME_STZKJSXX= "Name_stzkjsxx";
	public static final String NAME_STZKPNXX= "Name_stzkpnxx";
	public static final String NAME_STZKPBXX= "Name_stzkpbxx";
	public static final String NAME_STZKHD= "Name_stzkhd";
	public static final String NAME_STZKSMXX= "Name_stzksmxx";
	public static final String NAME_STZKZLNLXX= "Name_stzkzlnlxx";
	public static final String NAME_PFYCLX= "Name_pfyclx";
	public static final String NAME_GLYLG= "Name_glylg";
	public static final String NAME_GLWZJM= "Name_glwzjm";
	public static final String NAME_GLSJM= "Name_glsjm";
	public static final String NAME_GLRGQD= "Name_glrgqd";
	public static final String NAME_SIGNATURE= "Name_signature";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ana() {
		return ((String) getAttrVal("Id_ana"));
	}	
	public void setId_ana(String Id_ana) {
		setAttrVal("Id_ana", Id_ana);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	public String getGlqt() {
		return ((String) getAttrVal("Glqt"));
	}	
	public void setGlqt(String Glqt) {
		setAttrVal("Glqt", Glqt);
	}
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}	
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}	
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	public String getOther_referalsrc() {
		return ((String) getAttrVal("Other_referalsrc"));
	}	
	public void setOther_referalsrc(String Other_referalsrc) {
		setAttrVal("Other_referalsrc", Other_referalsrc);
	}
	public String getId_ryxdfs() {
		return ((String) getAttrVal("Id_ryxdfs"));
	}	
	public void setId_ryxdfs(String Id_ryxdfs) {
		setAttrVal("Id_ryxdfs", Id_ryxdfs);
	}
	public String getSd_yrxdfs() {
		return ((String) getAttrVal("Sd_yrxdfs"));
	}	
	public void setSd_yrxdfs(String Sd_yrxdfs) {
		setAttrVal("Sd_yrxdfs", Sd_yrxdfs);
	}
	public String getRyxdfs_other() {
		return ((String) getAttrVal("Ryxdfs_other"));
	}	
	public void setRyxdfs_other(String Ryxdfs_other) {
		setAttrVal("Ryxdfs_other", Ryxdfs_other);
	}
	public String getId_jy() {
		return ((String) getAttrVal("Id_jy"));
	}	
	public void setId_jy(String Id_jy) {
		setAttrVal("Id_jy", Id_jy);
	}
	public String getSd_jy() {
		return ((String) getAttrVal("Sd_jy"));
	}	
	public void setSd_jy(String Sd_jy) {
		setAttrVal("Sd_jy", Sd_jy);
	}
	public Integer getEu_zj() {
		return ((Integer) getAttrVal("Eu_zj"));
	}	
	public void setEu_zj(Integer Eu_zj) {
		setAttrVal("Eu_zj", Eu_zj);
	}
	public Integer getEu_pb() {
		return ((Integer) getAttrVal("Eu_pb"));
	}	
	public void setEu_pb(Integer Eu_pb) {
		setAttrVal("Eu_pb", Eu_pb);
	}
	public Integer getEu_gms() {
		return ((Integer) getAttrVal("Eu_gms"));
	}	
	public void setEu_gms(Integer Eu_gms) {
		setAttrVal("Eu_gms", Eu_gms);
	}
	public Integer getEu_shxy() {
		return ((Integer) getAttrVal("Eu_shxy"));
	}	
	public void setEu_shxy(Integer Eu_shxy) {
		setAttrVal("Eu_shxy", Eu_shxy);
	}
	public Integer getEu_shyj() {
		return ((Integer) getAttrVal("Eu_shyj"));
	}	
	public void setEu_shyj(Integer Eu_shyj) {
		setAttrVal("Eu_shyj", Eu_shyj);
	}
	public Integer getEu_jws() {
		return ((Integer) getAttrVal("Eu_jws"));
	}	
	public void setEu_jws(Integer Eu_jws) {
		setAttrVal("Eu_jws", Eu_jws);
	}
	public Integer getEu_qx() {
		return ((Integer) getAttrVal("Eu_qx"));
	}	
	public void setEu_qx(Integer Eu_qx) {
		setAttrVal("Eu_qx", Eu_qx);
	}
	public String getId_qxxx() {
		return ((String) getAttrVal("Id_qxxx"));
	}	
	public void setId_qxxx(String Id_qxxx) {
		setAttrVal("Id_qxxx", Id_qxxx);
	}
	public String getSd_qxxx() {
		return ((String) getAttrVal("Sd_qxxx"));
	}	
	public void setSd_qxxx(String Sd_qxxx) {
		setAttrVal("Sd_qxxx", Sd_qxxx);
	}
	public String getOther_qxxx() {
		return ((String) getAttrVal("Other_qxxx"));
	}	
	public void setOther_qxxx(String Other_qxxx) {
		setAttrVal("Other_qxxx", Other_qxxx);
	}
	public Integer getEu_yssp() {
		return ((Integer) getAttrVal("Eu_yssp"));
	}	
	public void setEu_yssp(Integer Eu_yssp) {
		setAttrVal("Eu_yssp", Eu_yssp);
	}
	public String getId_ysspycxx() {
		return ((String) getAttrVal("Id_ysspycxx"));
	}	
	public void setId_ysspycxx(String Id_ysspycxx) {
		setAttrVal("Id_ysspycxx", Id_ysspycxx);
	}
	public String getSd_ysspycxx() {
		return ((String) getAttrVal("Sd_ysspycxx"));
	}	
	public void setSd_ysspycxx(String Sd_ysspycxx) {
		setAttrVal("Sd_ysspycxx", Sd_ysspycxx);
	}
	public String getOther_ysspycxx() {
		return ((String) getAttrVal("Other_ysspycxx"));
	}	
	public void setOther_ysspycxx(String Other_ysspycxx) {
		setAttrVal("Other_ysspycxx", Other_ysspycxx);
	}
	public Integer getEu_stzksl() {
		return ((Integer) getAttrVal("Eu_stzksl"));
	}	
	public void setEu_stzksl(Integer Eu_stzksl) {
		setAttrVal("Eu_stzksl", Eu_stzksl);
	}
	public String getId_stzkslxx() {
		return ((String) getAttrVal("Id_stzkslxx"));
	}	
	public void setId_stzkslxx(String Id_stzkslxx) {
		setAttrVal("Id_stzkslxx", Id_stzkslxx);
	}
	public String getSd_stzkslxx() {
		return ((String) getAttrVal("Sd_stzkslxx"));
	}	
	public void setSd_stzkslxx(String Sd_stzkslxx) {
		setAttrVal("Sd_stzkslxx", Sd_stzkslxx);
	}
	public String getOther_stzkslxx() {
		return ((String) getAttrVal("Other_stzkslxx"));
	}	
	public void setOther_stzkslxx(String Other_stzkslxx) {
		setAttrVal("Other_stzkslxx", Other_stzkslxx);
	}
	public Integer getEu_stzktl() {
		return ((Integer) getAttrVal("Eu_stzktl"));
	}	
	public void setEu_stzktl(Integer Eu_stzktl) {
		setAttrVal("Eu_stzktl", Eu_stzktl);
	}
	public String getId_stzktlxx() {
		return ((String) getAttrVal("Id_stzktlxx"));
	}	
	public void setId_stzktlxx(String Id_stzktlxx) {
		setAttrVal("Id_stzktlxx", Id_stzktlxx);
	}
	public String getSd_stzktlxx() {
		return ((String) getAttrVal("Sd_stzktlxx"));
	}	
	public void setSd_stzktlxx(String Sd_stzktlxx) {
		setAttrVal("Sd_stzktlxx", Sd_stzktlxx);
	}
	public String getOther_stzktlxx() {
		return ((String) getAttrVal("Other_stzktlxx"));
	}	
	public void setOther_stzktlxx(String Other_stzktlxx) {
		setAttrVal("Other_stzktlxx", Other_stzktlxx);
	}
	public Integer getEu_stzkyy() {
		return ((Integer) getAttrVal("Eu_stzkyy"));
	}	
	public void setEu_stzkyy(Integer Eu_stzkyy) {
		setAttrVal("Eu_stzkyy", Eu_stzkyy);
	}
	public String getId_stzkyyxx() {
		return ((String) getAttrVal("Id_stzkyyxx"));
	}	
	public void setId_stzkyyxx(String Id_stzkyyxx) {
		setAttrVal("Id_stzkyyxx", Id_stzkyyxx);
	}
	public String getSd_stzkyyxx() {
		return ((String) getAttrVal("Sd_stzkyyxx"));
	}	
	public void setSd_stzkyyxx(String Sd_stzkyyxx) {
		setAttrVal("Sd_stzkyyxx", Sd_stzkyyxx);
	}
	public String getOther_stzkyyxx() {
		return ((String) getAttrVal("Other_stzkyyxx"));
	}	
	public void setOther_stzkyyxx(String Other_stzkyyxx) {
		setAttrVal("Other_stzkyyxx", Other_stzkyyxx);
	}
	public Integer getEu_stzkmr() {
		return ((Integer) getAttrVal("Eu_stzkmr"));
	}	
	public void setEu_stzkmr(Integer Eu_stzkmr) {
		setAttrVal("Eu_stzkmr", Eu_stzkmr);
	}
	public String getId_stzkmrxx() {
		return ((String) getAttrVal("Id_stzkmrxx"));
	}	
	public void setId_stzkmrxx(String Id_stzkmrxx) {
		setAttrVal("Id_stzkmrxx", Id_stzkmrxx);
	}
	public String getSd_stzkmrxx() {
		return ((String) getAttrVal("Sd_stzkmrxx"));
	}	
	public void setSd_stzkmrxx(String Sd_stzkmrxx) {
		setAttrVal("Sd_stzkmrxx", Sd_stzkmrxx);
	}
	public String getOther_stzkmrxx() {
		return ((String) getAttrVal("Other_stzkmrxx"));
	}	
	public void setOther_stzkmrxx(String Other_stzkmrxx) {
		setAttrVal("Other_stzkmrxx", Other_stzkmrxx);
	}
	public Integer getEu_stzkjs() {
		return ((Integer) getAttrVal("Eu_stzkjs"));
	}	
	public void setEu_stzkjs(Integer Eu_stzkjs) {
		setAttrVal("Eu_stzkjs", Eu_stzkjs);
	}
	public String getId_stzkjsxx() {
		return ((String) getAttrVal("Id_stzkjsxx"));
	}	
	public void setId_stzkjsxx(String Id_stzkjsxx) {
		setAttrVal("Id_stzkjsxx", Id_stzkjsxx);
	}
	public String getSd_stzkjsxx() {
		return ((String) getAttrVal("Sd_stzkjsxx"));
	}	
	public void setSd_stzkjsxx(String Sd_stzkjsxx) {
		setAttrVal("Sd_stzkjsxx", Sd_stzkjsxx);
	}
	public String getOther_stzkjsxx() {
		return ((String) getAttrVal("Other_stzkjsxx"));
	}	
	public void setOther_stzkjsxx(String Other_stzkjsxx) {
		setAttrVal("Other_stzkjsxx", Other_stzkjsxx);
	}
	public Integer getEu_stzkpn() {
		return ((Integer) getAttrVal("Eu_stzkpn"));
	}	
	public void setEu_stzkpn(Integer Eu_stzkpn) {
		setAttrVal("Eu_stzkpn", Eu_stzkpn);
	}
	public String getId_stzkpnxx() {
		return ((String) getAttrVal("Id_stzkpnxx"));
	}	
	public void setId_stzkpnxx(String Id_stzkpnxx) {
		setAttrVal("Id_stzkpnxx", Id_stzkpnxx);
	}
	public String getSd_stzkpnxx() {
		return ((String) getAttrVal("Sd_stzkpnxx"));
	}	
	public void setSd_stzkpnxx(String Sd_stzkpnxx) {
		setAttrVal("Sd_stzkpnxx", Sd_stzkpnxx);
	}
	public String getOther_stzkpnxx() {
		return ((String) getAttrVal("Other_stzkpnxx"));
	}	
	public void setOther_stzkpnxx(String Other_stzkpnxx) {
		setAttrVal("Other_stzkpnxx", Other_stzkpnxx);
	}
	public Integer getEu_stzkpb() {
		return ((Integer) getAttrVal("Eu_stzkpb"));
	}	
	public void setEu_stzkpb(Integer Eu_stzkpb) {
		setAttrVal("Eu_stzkpb", Eu_stzkpb);
	}
	public String getId_stzkpbxx() {
		return ((String) getAttrVal("Id_stzkpbxx"));
	}	
	public void setId_stzkpbxx(String Id_stzkpbxx) {
		setAttrVal("Id_stzkpbxx", Id_stzkpbxx);
	}
	public String getSd_stzkpbxx() {
		return ((String) getAttrVal("Sd_stzkpbxx"));
	}	
	public void setSd_stzkpbxx(String Sd_stzkpbxx) {
		setAttrVal("Sd_stzkpbxx", Sd_stzkpbxx);
	}
	public String getOther_stzkpbxx() {
		return ((String) getAttrVal("Other_stzkpbxx"));
	}	
	public void setOther_stzkpbxx(String Other_stzkpbxx) {
		setAttrVal("Other_stzkpbxx", Other_stzkpbxx);
	}
	public String getId_stzkhd() {
		return ((String) getAttrVal("Id_stzkhd"));
	}	
	public void setId_stzkhd(String Id_stzkhd) {
		setAttrVal("Id_stzkhd", Id_stzkhd);
	}
	public String getSd_stzkhd() {
		return ((String) getAttrVal("Sd_stzkhd"));
	}	
	public void setSd_stzkhd(String Sd_stzkhd) {
		setAttrVal("Sd_stzkhd", Sd_stzkhd);
	}
	public String getOher_stzkhd() {
		return ((String) getAttrVal("Oher_stzkhd"));
	}	
	public void setOher_stzkhd(String Oher_stzkhd) {
		setAttrVal("Oher_stzkhd", Oher_stzkhd);
	}
	public Integer getEu_stzksm() {
		return ((Integer) getAttrVal("Eu_stzksm"));
	}	
	public void setEu_stzksm(Integer Eu_stzksm) {
		setAttrVal("Eu_stzksm", Eu_stzksm);
	}
	public String getId_stzksmxx() {
		return ((String) getAttrVal("Id_stzksmxx"));
	}	
	public void setId_stzksmxx(String Id_stzksmxx) {
		setAttrVal("Id_stzksmxx", Id_stzksmxx);
	}
	public String getSd_stzksmxx() {
		return ((String) getAttrVal("Sd_stzksmxx"));
	}	
	public void setSd_stzksmxx(String Sd_stzksmxx) {
		setAttrVal("Sd_stzksmxx", Sd_stzksmxx);
	}
	public String getOther_stzksmxx() {
		return ((String) getAttrVal("Other_stzksmxx"));
	}	
	public void setOther_stzksmxx(String Other_stzksmxx) {
		setAttrVal("Other_stzksmxx", Other_stzksmxx);
	}
	public Integer getEu_stzkzlnl() {
		return ((Integer) getAttrVal("Eu_stzkzlnl"));
	}	
	public void setEu_stzkzlnl(Integer Eu_stzkzlnl) {
		setAttrVal("Eu_stzkzlnl", Eu_stzkzlnl);
	}
	public String getId_stzkzlnlxx() {
		return ((String) getAttrVal("Id_stzkzlnlxx"));
	}	
	public void setId_stzkzlnlxx(String Id_stzkzlnlxx) {
		setAttrVal("Id_stzkzlnlxx", Id_stzkzlnlxx);
	}
	public String getSd_stzkzlnlxx() {
		return ((String) getAttrVal("Sd_stzkzlnlxx"));
	}	
	public void setSd_stzkzlnlxx(String Sd_stzkzlnlxx) {
		setAttrVal("Sd_stzkzlnlxx", Sd_stzkzlnlxx);
	}
	public String getOther_stzkzlnlxx() {
		return ((String) getAttrVal("Other_stzkzlnlxx"));
	}	
	public void setOther_stzkzlnlxx(String Other_stzkzlnlxx) {
		setAttrVal("Other_stzkzlnlxx", Other_stzkzlnlxx);
	}
	public Integer getEu_stzkpf() {
		return ((Integer) getAttrVal("Eu_stzkpf"));
	}	
	public void setEu_stzkpf(Integer Eu_stzkpf) {
		setAttrVal("Eu_stzkpf", Eu_stzkpf);
	}
	public String getId_pfyclx() {
		return ((String) getAttrVal("Id_pfyclx"));
	}	
	public void setId_pfyclx(String Id_pfyclx) {
		setAttrVal("Id_pfyclx", Id_pfyclx);
	}
	public String getSd_pfyclx() {
		return ((String) getAttrVal("Sd_pfyclx"));
	}	
	public void setSd_pfyclx(String Sd_pfyclx) {
		setAttrVal("Sd_pfyclx", Sd_pfyclx);
	}
	public String getOther_pfyclx() {
		return ((String) getAttrVal("Other_pfyclx"));
	}	
	public void setOther_pfyclx(String Other_pfyclx) {
		setAttrVal("Other_pfyclx", Other_pfyclx);
	}
	public Integer getPressuresore() {
		return ((Integer) getAttrVal("Pressuresore"));
	}	
	public void setPressuresore(Integer Pressuresore) {
		setAttrVal("Pressuresore", Pressuresore);
	}
	public Integer getEu_gl() {
		return ((Integer) getAttrVal("Eu_gl"));
	}	
	public void setEu_gl(Integer Eu_gl) {
		setAttrVal("Eu_gl", Eu_gl);
	}
	public String getId_glylg() {
		return ((String) getAttrVal("Id_glylg"));
	}	
	public void setId_glylg(String Id_glylg) {
		setAttrVal("Id_glylg", Id_glylg);
	}
	public String getSd_glylg() {
		return ((String) getAttrVal("Sd_glylg"));
	}	
	public void setSd_glylg(String Sd_glylg) {
		setAttrVal("Sd_glylg", Sd_glylg);
	}
	public String getOther_glylg() {
		return ((String) getAttrVal("Other_glylg"));
	}	
	public void setOther_glylg(String Other_glylg) {
		setAttrVal("Other_glylg", Other_glylg);
	}
	public String getId_glwzjm() {
		return ((String) getAttrVal("Id_glwzjm"));
	}	
	public void setId_glwzjm(String Id_glwzjm) {
		setAttrVal("Id_glwzjm", Id_glwzjm);
	}
	public String getSd_glwzjm() {
		return ((String) getAttrVal("Sd_glwzjm"));
	}	
	public void setSd_glwzjm(String Sd_glwzjm) {
		setAttrVal("Sd_glwzjm", Sd_glwzjm);
	}
	public String getId_glsjm() {
		return ((String) getAttrVal("Id_glsjm"));
	}	
	public void setId_glsjm(String Id_glsjm) {
		setAttrVal("Id_glsjm", Id_glsjm);
	}
	public String getSd_glsjm() {
		return ((String) getAttrVal("Sd_glsjm"));
	}	
	public void setSd_glsjm(String Sd_glsjm) {
		setAttrVal("Sd_glsjm", Sd_glsjm);
	}
	public String getOther_glsjm() {
		return ((String) getAttrVal("Other_glsjm"));
	}	
	public void setOther_glsjm(String Other_glsjm) {
		setAttrVal("Other_glsjm", Other_glsjm);
	}
	public String getId_glrgqd() {
		return ((String) getAttrVal("Id_glrgqd"));
	}	
	public void setId_glrgqd(String Id_glrgqd) {
		setAttrVal("Id_glrgqd", Id_glrgqd);
	}
	public String getSd_glrgqd() {
		return ((String) getAttrVal("Sd_glrgqd"));
	}	
	public void setSd_glrgqd(String Sd_glrgqd) {
		setAttrVal("Sd_glrgqd", Sd_glrgqd);
	}
	public Integer getEu_ddfxpg() {
		return ((Integer) getAttrVal("Eu_ddfxpg"));
	}	
	public void setEu_ddfxpg(Integer Eu_ddfxpg) {
		setAttrVal("Eu_ddfxpg", Eu_ddfxpg);
	}
	public String getScore_falll() {
		return ((String) getAttrVal("Score_falll"));
	}	
	public void setScore_falll(String Score_falll) {
		setAttrVal("Score_falll", Score_falll);
	}
	public String getInforsources() {
		return ((String) getAttrVal("Inforsources"));
	}	
	public void setInforsources(String Inforsources) {
		setAttrVal("Inforsources", Inforsources);
	}
	public String getSignature() {
		return ((String) getAttrVal("Signature"));
	}	
	public void setSignature(String Signature) {
		setAttrVal("Signature", Signature);
	}
	public FDateTime getDt_assess() {
		return ((FDateTime) getAttrVal("Dt_assess"));
	}	
	public void setDt_assess(FDateTime Dt_assess) {
		setAttrVal("Dt_assess", Dt_assess);
	}
	public String getZkpg() {
		return ((String) getAttrVal("Zkpg"));
	}	
	public void setZkpg(String Zkpg) {
		setAttrVal("Zkpg", Zkpg);
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
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}	
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	public String getName_ryxdfs() {
		return ((String) getAttrVal("Name_ryxdfs"));
	}	
	public void setName_ryxdfs(String Name_ryxdfs) {
		setAttrVal("Name_ryxdfs", Name_ryxdfs);
	}
	public String getName_jy() {
		return ((String) getAttrVal("Name_jy"));
	}	
	public void setName_jy(String Name_jy) {
		setAttrVal("Name_jy", Name_jy);
	}
	public String getName_qxxx() {
		return ((String) getAttrVal("Name_qxxx"));
	}	
	public void setName_qxxx(String Name_qxxx) {
		setAttrVal("Name_qxxx", Name_qxxx);
	}
	public String getName_ysspycxx() {
		return ((String) getAttrVal("Name_ysspycxx"));
	}	
	public void setName_ysspycxx(String Name_ysspycxx) {
		setAttrVal("Name_ysspycxx", Name_ysspycxx);
	}
	public String getName_stzkslxx() {
		return ((String) getAttrVal("Name_stzkslxx"));
	}	
	public void setName_stzkslxx(String Name_stzkslxx) {
		setAttrVal("Name_stzkslxx", Name_stzkslxx);
	}
	public String getName_stzktlxx() {
		return ((String) getAttrVal("Name_stzktlxx"));
	}	
	public void setName_stzktlxx(String Name_stzktlxx) {
		setAttrVal("Name_stzktlxx", Name_stzktlxx);
	}
	public String getName_stzkyyxx() {
		return ((String) getAttrVal("Name_stzkyyxx"));
	}	
	public void setName_stzkyyxx(String Name_stzkyyxx) {
		setAttrVal("Name_stzkyyxx", Name_stzkyyxx);
	}
	public String getName_stzkmrxx() {
		return ((String) getAttrVal("Name_stzkmrxx"));
	}	
	public void setName_stzkmrxx(String Name_stzkmrxx) {
		setAttrVal("Name_stzkmrxx", Name_stzkmrxx);
	}
	public String getName_stzkjsxx() {
		return ((String) getAttrVal("Name_stzkjsxx"));
	}	
	public void setName_stzkjsxx(String Name_stzkjsxx) {
		setAttrVal("Name_stzkjsxx", Name_stzkjsxx);
	}
	public String getName_stzkpnxx() {
		return ((String) getAttrVal("Name_stzkpnxx"));
	}	
	public void setName_stzkpnxx(String Name_stzkpnxx) {
		setAttrVal("Name_stzkpnxx", Name_stzkpnxx);
	}
	public String getName_stzkpbxx() {
		return ((String) getAttrVal("Name_stzkpbxx"));
	}	
	public void setName_stzkpbxx(String Name_stzkpbxx) {
		setAttrVal("Name_stzkpbxx", Name_stzkpbxx);
	}
	public String getName_stzkhd() {
		return ((String) getAttrVal("Name_stzkhd"));
	}	
	public void setName_stzkhd(String Name_stzkhd) {
		setAttrVal("Name_stzkhd", Name_stzkhd);
	}
	public String getName_stzksmxx() {
		return ((String) getAttrVal("Name_stzksmxx"));
	}	
	public void setName_stzksmxx(String Name_stzksmxx) {
		setAttrVal("Name_stzksmxx", Name_stzksmxx);
	}
	public String getName_stzkzlnlxx() {
		return ((String) getAttrVal("Name_stzkzlnlxx"));
	}	
	public void setName_stzkzlnlxx(String Name_stzkzlnlxx) {
		setAttrVal("Name_stzkzlnlxx", Name_stzkzlnlxx);
	}
	public String getName_pfyclx() {
		return ((String) getAttrVal("Name_pfyclx"));
	}	
	public void setName_pfyclx(String Name_pfyclx) {
		setAttrVal("Name_pfyclx", Name_pfyclx);
	}
	public String getName_glylg() {
		return ((String) getAttrVal("Name_glylg"));
	}	
	public void setName_glylg(String Name_glylg) {
		setAttrVal("Name_glylg", Name_glylg);
	}
	public String getName_glwzjm() {
		return ((String) getAttrVal("Name_glwzjm"));
	}	
	public void setName_glwzjm(String Name_glwzjm) {
		setAttrVal("Name_glwzjm", Name_glwzjm);
	}
	public String getName_glsjm() {
		return ((String) getAttrVal("Name_glsjm"));
	}	
	public void setName_glsjm(String Name_glsjm) {
		setAttrVal("Name_glsjm", Name_glsjm);
	}
	public String getName_glrgqd() {
		return ((String) getAttrVal("Name_glrgqd"));
	}	
	public void setName_glrgqd(String Name_glrgqd) {
		setAttrVal("Name_glrgqd", Name_glrgqd);
	}
	public String getName_signature() {
		return ((String) getAttrVal("Name_signature"));
	}	
	public void setName_signature(String Name_signature) {
		setAttrVal("Name_signature", Name_signature);
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
		return "Id_ana";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_NU_ANA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AdmissionNursingAssessmentDODesc.class);
	}
	
}