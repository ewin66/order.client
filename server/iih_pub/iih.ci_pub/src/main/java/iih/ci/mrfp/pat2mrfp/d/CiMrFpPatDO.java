package iih.ci.mrfp.pat2mrfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mrfp.pat2mrfp.d.desc.CiMrFpPatDODesc;
import java.math.BigDecimal;

/**
 * 病案首页患者信息 DO数据 
 * 
 */
public class CiMrFpPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_CIMRFPPAT= "Id_cimrfppat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_SEX= "Id_sex";
	public static final String SD_SEX= "Sd_sex";
	public static final String DT_BIRTH_PAT= "Dt_birth_pat";
	public static final String AGE= "Age";
	public static final String ID_EMP_PHY= "Id_emp_phy";
	public static final String NAME_EMP_PHY= "Name_emp_phy";
	public static final String ID_EMP_NUR= "Id_emp_nur";
	public static final String NAME_EMP_NUR= "Name_emp_nur";
	public static final String ID_ZR_DOC= "Id_zr_doc";
	public static final String NAME_ZR_DOC= "Name_zr_doc";
	public static final String ID_ZZ_DOC= "Id_zz_doc";
	public static final String NAME_ZZ_DOC= "Name_zz_doc";
	public static final String ID_ZY_DOC= "Id_zy_doc";
	public static final String NAME_ZY_DOC= "Name_zy_doc";
	public static final String ADDR_BORN= "Addr_born";
	public static final String ADDR_ORIGIN= "Addr_origin";
	public static final String ADDR_NOW= "Addr_now";
	public static final String TEL_ADDR_NOW= "Tel_addr_now";
	public static final String ZIP_ADDR_NOW= "Zip_addr_now";
	public static final String ADDR_CENCUS= "Addr_cencus";
	public static final String ZIP_ADDR_CENCUS= "Zip_addr_cencus";
	public static final String WORKUNIT= "Workunit";
	public static final String ADDR_WORK= "Addr_work";
	public static final String DEL_ADDR_WORK= "Del_addr_work";
	public static final String ZIP_ADDR_WORK= "Zip_addr_work";
	public static final String NAME_CONT= "Name_cont";
	public static final String ID_CONTTP= "Id_conttp";
	public static final String SD_CONTTP= "Sd_conttp";
	public static final String ADDR_CONT= "Addr_cont";
	public static final String TEL_CONT= "Tel_cont";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_PAY_METHOD= "Id_pay_method";
	public static final String SD_PAY_METHOD= "Sd_pay_method";
	public static final String N_TIMES_INHOSPITAL= "N_times_inhospital";
	public static final String ID_COUNTRY= "Id_country";
	public static final String SD_COUNTRY= "Sd_country";
	public static final String ID_NATION= "Id_nation";
	public static final String SD_NATION= "Sd_nation";
	public static final String ID_MARRY= "Id_marry";
	public static final String SD_MARRY= "Sd_marry";
	public static final String ID_IDTP= "Id_idtp";
	public static final String SD_IDTP= "Sd_idtp";
	public static final String ID_CODE= "Id_code";
	public static final String ID_OCCU= "Id_occu";
	public static final String SD_OCCU= "Sd_occu";
	public static final String AGE_MONTH= "Age_month";
	public static final String BIRTH_WEIGHT= "Birth_weight";
	public static final String ADDMISSION_WEIGHT= "Addmission_weight";
	public static final String ID_REFERALSRC= "Id_referalsrc";
	public static final String SD_REFERALSRC= "Sd_referalsrc";
	public static final String DT_ACPT= "Dt_acpt";
	public static final String ID_DEP_PHYADM= "Id_dep_phyadm";
	public static final String SD_DEP_PHYADM= "Sd_dep_phyadm";
	public static final String ID_DEP_TRANS= "Id_dep_trans";
	public static final String SD_DEP_TRANS= "Sd_dep_trans";
	public static final String DT_END= "Dt_end";
	public static final String ID_DEP_PHYDISC= "Id_dep_phydisc";
	public static final String SD_DEP_PHYDISC= "Sd_dep_phydisc";
	public static final String HOSDAYS= "Hosdays";
	public static final String IN_ID_BED= "In_id_bed";
	public static final String OUT_ID_BED= "Out_id_bed";
	public static final String NAME_SEX= "Name_sex";
	public static final String NAME_COUNTRY= "Name_country";
	public static final String NAME_NATION= "Name_nation";
	public static final String NAME_OCCU= "Name_occu";
	public static final String NAME_MARRY= "Name_marry";
	public static final String NAME_CONTTP= "Name_conttp";
	public static final String NAME_REFERALSRC= "Name_referalsrc";
	public static final String NAME_DEP_PHYADM= "Name_dep_phyadm";
	public static final String NAME_DEP_TRANS= "Name_dep_trans";
	public static final String NAME_DEP_PHYDISC= "Name_dep_phydisc";
	public static final String NAME_PAY_METHOD= "Name_pay_method";
	public static final String ID_OUTP_EMER_DI= "Id_outp_emer_di";
	public static final String NAME_OUTP_EMER_DI= "Name_outp_emer_di";
	public static final String SD_OUTP_EMER_DI= "Sd_outp_emer_di";
	public static final String SEX_CODE= "Sex_code";
	public static final String SEX_NAME= "Sex_name";
	public static final String CONTTP_CODE= "Conttp_code";
	public static final String CONTTP_NAME= "Conttp_name";
	public static final String PAY_METHOD_CODE= "Pay_method_code";
	public static final String PAY_METHOD_NAME= "Pay_method_name";
	public static final String COUNTRY_CODE= "Country_code";
	public static final String COUNTRY_NAME= "Country_name";
	public static final String NATION_CODE= "Nation_code";
	public static final String NATION_NAME= "Nation_name";
	public static final String MARRY_CODE= "Marry_code";
	public static final String MARRY_NAME= "Marry_name";
	public static final String IDTP_CODE= "Idtp_code";
	public static final String IDTP_NAME= "Idtp_name";
	public static final String OCCU_CODE= "Occu_code";
	public static final String OCCU_NAME= "Occu_name";
	public static final String REFERALSRC_CODE= "Referalsrc_code";
	public static final String REFERALSRC_NAME= "Referalsrc_name";
	public static final String DEP_PHYADM_CODE= "Dep_phyadm_code";
	public static final String DEP_PHYADM_NAME= "Dep_phyadm_name";
	public static final String DEP_TRANS_CODE= "Dep_trans_code";
	public static final String DEP_TRANS_NAME= "Dep_trans_name";
	public static final String DEP_PHYDISC_CODE= "Dep_phydisc_code";
	public static final String DEP_PHYDISC_NAME= "Dep_phydisc_name";
	public static final String CODE_OUTP_DI= "Code_outp_di";
	public static final String NAME_OUTP_DI= "Name_outp_di";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_cimrfppat() {
		return ((String) getAttrVal("Id_cimrfppat"));
	}	
	public void setId_cimrfppat(String Id_cimrfppat) {
		setAttrVal("Id_cimrfppat", Id_cimrfppat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}	
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}	
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}	
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	public String getId_zr_doc() {
		return ((String) getAttrVal("Id_zr_doc"));
	}	
	public void setId_zr_doc(String Id_zr_doc) {
		setAttrVal("Id_zr_doc", Id_zr_doc);
	}
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}	
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	public String getId_zz_doc() {
		return ((String) getAttrVal("Id_zz_doc"));
	}	
	public void setId_zz_doc(String Id_zz_doc) {
		setAttrVal("Id_zz_doc", Id_zz_doc);
	}
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}	
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	public String getId_zy_doc() {
		return ((String) getAttrVal("Id_zy_doc"));
	}	
	public void setId_zy_doc(String Id_zy_doc) {
		setAttrVal("Id_zy_doc", Id_zy_doc);
	}
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}	
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
	}
	public String getAddr_born() {
		return ((String) getAttrVal("Addr_born"));
	}	
	public void setAddr_born(String Addr_born) {
		setAttrVal("Addr_born", Addr_born);
	}
	public String getAddr_origin() {
		return ((String) getAttrVal("Addr_origin"));
	}	
	public void setAddr_origin(String Addr_origin) {
		setAttrVal("Addr_origin", Addr_origin);
	}
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}	
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	public String getTel_addr_now() {
		return ((String) getAttrVal("Tel_addr_now"));
	}	
	public void setTel_addr_now(String Tel_addr_now) {
		setAttrVal("Tel_addr_now", Tel_addr_now);
	}
	public String getZip_addr_now() {
		return ((String) getAttrVal("Zip_addr_now"));
	}	
	public void setZip_addr_now(String Zip_addr_now) {
		setAttrVal("Zip_addr_now", Zip_addr_now);
	}
	public String getAddr_cencus() {
		return ((String) getAttrVal("Addr_cencus"));
	}	
	public void setAddr_cencus(String Addr_cencus) {
		setAttrVal("Addr_cencus", Addr_cencus);
	}
	public String getZip_addr_cencus() {
		return ((String) getAttrVal("Zip_addr_cencus"));
	}	
	public void setZip_addr_cencus(String Zip_addr_cencus) {
		setAttrVal("Zip_addr_cencus", Zip_addr_cencus);
	}
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}	
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	public String getDel_addr_work() {
		return ((String) getAttrVal("Del_addr_work"));
	}	
	public void setDel_addr_work(String Del_addr_work) {
		setAttrVal("Del_addr_work", Del_addr_work);
	}
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}	
	public void setZip_addr_work(String Zip_addr_work) {
		setAttrVal("Zip_addr_work", Zip_addr_work);
	}
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}	
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}	
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}	
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	public String getAddr_cont() {
		return ((String) getAttrVal("Addr_cont"));
	}	
	public void setAddr_cont(String Addr_cont) {
		setAttrVal("Addr_cont", Addr_cont);
	}
	public String getTel_cont() {
		return ((String) getAttrVal("Tel_cont"));
	}	
	public void setTel_cont(String Tel_cont) {
		setAttrVal("Tel_cont", Tel_cont);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_pay_method() {
		return ((String) getAttrVal("Id_pay_method"));
	}	
	public void setId_pay_method(String Id_pay_method) {
		setAttrVal("Id_pay_method", Id_pay_method);
	}
	public String getSd_pay_method() {
		return ((String) getAttrVal("Sd_pay_method"));
	}	
	public void setSd_pay_method(String Sd_pay_method) {
		setAttrVal("Sd_pay_method", Sd_pay_method);
	}
	public Integer getN_times_inhospital() {
		return ((Integer) getAttrVal("N_times_inhospital"));
	}	
	public void setN_times_inhospital(Integer N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}	
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}	
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}	
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}	
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	public String getAge_month() {
		return ((String) getAttrVal("Age_month"));
	}	
	public void setAge_month(String Age_month) {
		setAttrVal("Age_month", Age_month);
	}
	public Integer getBirth_weight() {
		return ((Integer) getAttrVal("Birth_weight"));
	}	
	public void setBirth_weight(Integer Birth_weight) {
		setAttrVal("Birth_weight", Birth_weight);
	}
	public Integer getAddmission_weight() {
		return ((Integer) getAttrVal("Addmission_weight"));
	}	
	public void setAddmission_weight(Integer Addmission_weight) {
		setAttrVal("Addmission_weight", Addmission_weight);
	}
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}	
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}	
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}	
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	public String getSd_dep_phyadm() {
		return ((String) getAttrVal("Sd_dep_phyadm"));
	}	
	public void setSd_dep_phyadm(String Sd_dep_phyadm) {
		setAttrVal("Sd_dep_phyadm", Sd_dep_phyadm);
	}
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}	
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
	}
	public String getSd_dep_trans() {
		return ((String) getAttrVal("Sd_dep_trans"));
	}	
	public void setSd_dep_trans(String Sd_dep_trans) {
		setAttrVal("Sd_dep_trans", Sd_dep_trans);
	}
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}	
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	public String getSd_dep_phydisc() {
		return ((String) getAttrVal("Sd_dep_phydisc"));
	}	
	public void setSd_dep_phydisc(String Sd_dep_phydisc) {
		setAttrVal("Sd_dep_phydisc", Sd_dep_phydisc);
	}
	public Integer getHosdays() {
		return ((Integer) getAttrVal("Hosdays"));
	}	
	public void setHosdays(Integer Hosdays) {
		setAttrVal("Hosdays", Hosdays);
	}
	public String getIn_id_bed() {
		return ((String) getAttrVal("In_id_bed"));
	}	
	public void setIn_id_bed(String In_id_bed) {
		setAttrVal("In_id_bed", In_id_bed);
	}
	public String getOut_id_bed() {
		return ((String) getAttrVal("Out_id_bed"));
	}	
	public void setOut_id_bed(String Out_id_bed) {
		setAttrVal("Out_id_bed", Out_id_bed);
	}
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}	
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}	
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}	
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}	
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}	
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	public String getName_dep_trans() {
		return ((String) getAttrVal("Name_dep_trans"));
	}	
	public void setName_dep_trans(String Name_dep_trans) {
		setAttrVal("Name_dep_trans", Name_dep_trans);
	}
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}	
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	public String getName_pay_method() {
		return ((String) getAttrVal("Name_pay_method"));
	}	
	public void setName_pay_method(String Name_pay_method) {
		setAttrVal("Name_pay_method", Name_pay_method);
	}
	public String getId_outp_emer_di() {
		return ((String) getAttrVal("Id_outp_emer_di"));
	}	
	public void setId_outp_emer_di(String Id_outp_emer_di) {
		setAttrVal("Id_outp_emer_di", Id_outp_emer_di);
	}
	public String getName_outp_emer_di() {
		return ((String) getAttrVal("Name_outp_emer_di"));
	}	
	public void setName_outp_emer_di(String Name_outp_emer_di) {
		setAttrVal("Name_outp_emer_di", Name_outp_emer_di);
	}
	public String getSd_outp_emer_di() {
		return ((String) getAttrVal("Sd_outp_emer_di"));
	}	
	public void setSd_outp_emer_di(String Sd_outp_emer_di) {
		setAttrVal("Sd_outp_emer_di", Sd_outp_emer_di);
	}
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	public String getConttp_code() {
		return ((String) getAttrVal("Conttp_code"));
	}	
	public void setConttp_code(String Conttp_code) {
		setAttrVal("Conttp_code", Conttp_code);
	}
	public String getConttp_name() {
		return ((String) getAttrVal("Conttp_name"));
	}	
	public void setConttp_name(String Conttp_name) {
		setAttrVal("Conttp_name", Conttp_name);
	}
	public String getPay_method_code() {
		return ((String) getAttrVal("Pay_method_code"));
	}	
	public void setPay_method_code(String Pay_method_code) {
		setAttrVal("Pay_method_code", Pay_method_code);
	}
	public String getPay_method_name() {
		return ((String) getAttrVal("Pay_method_name"));
	}	
	public void setPay_method_name(String Pay_method_name) {
		setAttrVal("Pay_method_name", Pay_method_name);
	}
	public String getCountry_code() {
		return ((String) getAttrVal("Country_code"));
	}	
	public void setCountry_code(String Country_code) {
		setAttrVal("Country_code", Country_code);
	}
	public String getCountry_name() {
		return ((String) getAttrVal("Country_name"));
	}	
	public void setCountry_name(String Country_name) {
		setAttrVal("Country_name", Country_name);
	}
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}	
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	public String getIdtp_code() {
		return ((String) getAttrVal("Idtp_code"));
	}	
	public void setIdtp_code(String Idtp_code) {
		setAttrVal("Idtp_code", Idtp_code);
	}
	public String getIdtp_name() {
		return ((String) getAttrVal("Idtp_name"));
	}	
	public void setIdtp_name(String Idtp_name) {
		setAttrVal("Idtp_name", Idtp_name);
	}
	public String getOccu_code() {
		return ((String) getAttrVal("Occu_code"));
	}	
	public void setOccu_code(String Occu_code) {
		setAttrVal("Occu_code", Occu_code);
	}
	public String getOccu_name() {
		return ((String) getAttrVal("Occu_name"));
	}	
	public void setOccu_name(String Occu_name) {
		setAttrVal("Occu_name", Occu_name);
	}
	public String getReferalsrc_code() {
		return ((String) getAttrVal("Referalsrc_code"));
	}	
	public void setReferalsrc_code(String Referalsrc_code) {
		setAttrVal("Referalsrc_code", Referalsrc_code);
	}
	public String getReferalsrc_name() {
		return ((String) getAttrVal("Referalsrc_name"));
	}	
	public void setReferalsrc_name(String Referalsrc_name) {
		setAttrVal("Referalsrc_name", Referalsrc_name);
	}
	public String getDep_phyadm_code() {
		return ((String) getAttrVal("Dep_phyadm_code"));
	}	
	public void setDep_phyadm_code(String Dep_phyadm_code) {
		setAttrVal("Dep_phyadm_code", Dep_phyadm_code);
	}
	public String getDep_phyadm_name() {
		return ((String) getAttrVal("Dep_phyadm_name"));
	}	
	public void setDep_phyadm_name(String Dep_phyadm_name) {
		setAttrVal("Dep_phyadm_name", Dep_phyadm_name);
	}
	public String getDep_trans_code() {
		return ((String) getAttrVal("Dep_trans_code"));
	}	
	public void setDep_trans_code(String Dep_trans_code) {
		setAttrVal("Dep_trans_code", Dep_trans_code);
	}
	public String getDep_trans_name() {
		return ((String) getAttrVal("Dep_trans_name"));
	}	
	public void setDep_trans_name(String Dep_trans_name) {
		setAttrVal("Dep_trans_name", Dep_trans_name);
	}
	public String getDep_phydisc_code() {
		return ((String) getAttrVal("Dep_phydisc_code"));
	}	
	public void setDep_phydisc_code(String Dep_phydisc_code) {
		setAttrVal("Dep_phydisc_code", Dep_phydisc_code);
	}
	public String getDep_phydisc_name() {
		return ((String) getAttrVal("Dep_phydisc_name"));
	}	
	public void setDep_phydisc_name(String Dep_phydisc_name) {
		setAttrVal("Dep_phydisc_name", Dep_phydisc_name);
	}
	public String getCode_outp_di() {
		return ((String) getAttrVal("Code_outp_di"));
	}	
	public void setCode_outp_di(String Code_outp_di) {
		setAttrVal("Code_outp_di", Code_outp_di);
	}
	public String getName_outp_di() {
		return ((String) getAttrVal("Name_outp_di"));
	}	
	public void setName_outp_di(String Name_outp_di) {
		setAttrVal("Name_outp_di", Name_outp_di);
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
		return "Id_cimrfppat";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_FP_PAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrFpPatDODesc.class);
	}
	
}