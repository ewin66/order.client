package iih.ci.ord.ordsrvmm.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import java.math.BigDecimal;

/**
 * 医嘱服务项目物品 DO数据 
 * 
 */
public class OrdSrvMmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_ORSRVMM= "Id_orsrvmm";
	public static final String ID_ORSRV= "Id_orsrv";
	public static final String ID_MM= "Id_mm";
	public static final String CODE_MM= "Code_mm";
	public static final String NAME_MM= "Name_mm";
	public static final String ID_PGKU_CUR= "Id_pgku_cur";
	public static final String PRICE_PGKU_CUR= "Price_pgku_cur";
	public static final String QUAN_CUR= "Quan_cur";
	public static final String ID_PGKU_BASE= "Id_pgku_base";
	public static final String QUAN_NUM_BASE= "Quan_num_base";
	public static final String QUAN_DEN_BASE= "Quan_den_base";
	public static final String QUAN_BED_MEDU= "Quan_bed_medu";
	public static final String FACTOR= "Factor";
	public static final String FACTOR_MB= "Factor_mb";
	public static final String ID_DOSAGE= "Id_dosage";
	public static final String SD_DOSAGE= "Sd_dosage";
	public static final String ID_PHARM= "Id_pharm";
	public static final String SD_PHARM= "Sd_pharm";
	public static final String ID_VAL= "Id_val";
	public static final String SD_VAL= "Sd_val";
	public static final String ID_POIS= "Id_pois";
	public static final String SD_POIS= "Sd_pois";
	public static final String ID_ANTI= "Id_anti";
	public static final String SD_ANTI= "Sd_anti";
	public static final String ID_MMTP= "Id_mmtp";
	public static final String SD_MMTP= "Sd_mmtp";
	public static final String ID_ANTIPSY= "Id_antipsy";
	public static final String SD_ANTIPSY= "Sd_antipsy";
	public static final String FG_OTC= "Fg_otc";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String QUAN_BED_TRANSIT= "Quan_bed_transit";
	public static final String DAYS_AVAILABLE= "Days_available";
	public static final String ID_MUPKGUTP= "Id_mupkgutp";
	public static final String SD_MUPKGUTP= "Sd_mupkgutp";
	public static final String ID_SRV= "Id_srv";
	public static final String SPEC= "Spec";
	public static final String INDICA= "Indica";
	public static final String CONSTR= "Constr";
	public static final String REACT= "React";
	public static final String NAME_PGKU_CUR= "Name_pgku_cur";
	public static final String NAME_PGKU_BASE= "Name_pgku_base";
	public static final String DS_CODE= "Ds_code";
	public static final String DS_NAME= "Ds_name";
	public static final String PA_CODE= "Pa_code";
	public static final String PA_NAME= "Pa_name";
	public static final String VAL_CODE= "Val_code";
	public static final String VAL_NAME= "Val_name";
	public static final String POIS_CODE= "Pois_code";
	public static final String POIS_NAME= "Pois_name";
	public static final String ANTI_CODE= "Anti_code";
	public static final String ANTI_NAME= "Anti_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}	
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}	
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	public FDouble getPrice_pgku_cur() {
		return ((FDouble) getAttrVal("Price_pgku_cur"));
	}	
	public void setPrice_pgku_cur(FDouble Price_pgku_cur) {
		setAttrVal("Price_pgku_cur", Price_pgku_cur);
	}
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	public String getId_pgku_base() {
		return ((String) getAttrVal("Id_pgku_base"));
	}	
	public void setId_pgku_base(String Id_pgku_base) {
		setAttrVal("Id_pgku_base", Id_pgku_base);
	}
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}	
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}	
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}	
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}	
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	public String getId_pharm() {
		return ((String) getAttrVal("Id_pharm"));
	}	
	public void setId_pharm(String Id_pharm) {
		setAttrVal("Id_pharm", Id_pharm);
	}
	public String getSd_pharm() {
		return ((String) getAttrVal("Sd_pharm"));
	}	
	public void setSd_pharm(String Sd_pharm) {
		setAttrVal("Sd_pharm", Sd_pharm);
	}
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}	
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}	
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}	
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}	
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	public String getId_anti() {
		return ((String) getAttrVal("Id_anti"));
	}	
	public void setId_anti(String Id_anti) {
		setAttrVal("Id_anti", Id_anti);
	}
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}	
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
	}
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}	
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}	
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	public String getId_antipsy() {
		return ((String) getAttrVal("Id_antipsy"));
	}	
	public void setId_antipsy(String Id_antipsy) {
		setAttrVal("Id_antipsy", Id_antipsy);
	}
	public String getSd_antipsy() {
		return ((String) getAttrVal("Sd_antipsy"));
	}	
	public void setSd_antipsy(String Sd_antipsy) {
		setAttrVal("Sd_antipsy", Sd_antipsy);
	}
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}	
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
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
	public FDouble getQuan_bed_transit() {
		return ((FDouble) getAttrVal("Quan_bed_transit"));
	}	
	public void setQuan_bed_transit(FDouble Quan_bed_transit) {
		setAttrVal("Quan_bed_transit", Quan_bed_transit);
	}
	public Integer getDays_available() {
		return ((Integer) getAttrVal("Days_available"));
	}	
	public void setDays_available(Integer Days_available) {
		setAttrVal("Days_available", Days_available);
	}
	public String getId_mupkgutp() {
		return ((String) getAttrVal("Id_mupkgutp"));
	}	
	public void setId_mupkgutp(String Id_mupkgutp) {
		setAttrVal("Id_mupkgutp", Id_mupkgutp);
	}
	public String getSd_mupkgutp() {
		return ((String) getAttrVal("Sd_mupkgutp"));
	}	
	public void setSd_mupkgutp(String Sd_mupkgutp) {
		setAttrVal("Sd_mupkgutp", Sd_mupkgutp);
	}
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}	
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	public String getIndica() {
		return ((String) getAttrVal("Indica"));
	}	
	public void setIndica(String Indica) {
		setAttrVal("Indica", Indica);
	}
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}	
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}
	public String getReact() {
		return ((String) getAttrVal("React"));
	}	
	public void setReact(String React) {
		setAttrVal("React", React);
	}
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}	
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	public String getName_pgku_base() {
		return ((String) getAttrVal("Name_pgku_base"));
	}	
	public void setName_pgku_base(String Name_pgku_base) {
		setAttrVal("Name_pgku_base", Name_pgku_base);
	}
	public String getDs_code() {
		return ((String) getAttrVal("Ds_code"));
	}	
	public void setDs_code(String Ds_code) {
		setAttrVal("Ds_code", Ds_code);
	}
	public String getDs_name() {
		return ((String) getAttrVal("Ds_name"));
	}	
	public void setDs_name(String Ds_name) {
		setAttrVal("Ds_name", Ds_name);
	}
	public String getPa_code() {
		return ((String) getAttrVal("Pa_code"));
	}	
	public void setPa_code(String Pa_code) {
		setAttrVal("Pa_code", Pa_code);
	}
	public String getPa_name() {
		return ((String) getAttrVal("Pa_name"));
	}	
	public void setPa_name(String Pa_name) {
		setAttrVal("Pa_name", Pa_name);
	}
	public String getVal_code() {
		return ((String) getAttrVal("Val_code"));
	}	
	public void setVal_code(String Val_code) {
		setAttrVal("Val_code", Val_code);
	}
	public String getVal_name() {
		return ((String) getAttrVal("Val_name"));
	}	
	public void setVal_name(String Val_name) {
		setAttrVal("Val_name", Val_name);
	}
	public String getPois_code() {
		return ((String) getAttrVal("Pois_code"));
	}	
	public void setPois_code(String Pois_code) {
		setAttrVal("Pois_code", Pois_code);
	}
	public String getPois_name() {
		return ((String) getAttrVal("Pois_name"));
	}	
	public void setPois_name(String Pois_name) {
		setAttrVal("Pois_name", Pois_name);
	}
	public String getAnti_code() {
		return ((String) getAttrVal("Anti_code"));
	}	
	public void setAnti_code(String Anti_code) {
		setAttrVal("Anti_code", Anti_code);
	}
	public String getAnti_name() {
		return ((String) getAttrVal("Anti_name"));
	}	
	public void setAnti_name(String Anti_name) {
		setAttrVal("Anti_name", Anti_name);
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
		return "Id_orsrvmm";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_or_srv_mm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdSrvMmDODesc.class);
	}
	
}