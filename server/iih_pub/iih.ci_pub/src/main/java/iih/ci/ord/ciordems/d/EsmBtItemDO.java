package iih.ci.ord.ciordems.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 输血医疗单项目 DTO数据 
 * 
 */
public class EsmBtItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输血医疗单主键
	 * @return String
	 */
	public String getId_emsbt() {
		return ((String) getAttrVal("Id_emsbt"));
	}
	/**
	 * 输血医疗单主键
	 * @param Id_emsbt
	 */
	public void setId_emsbt(String Id_emsbt) {
		setAttrVal("Id_emsbt", Id_emsbt);
	}
	/**
	 * 服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 *  输血成分(服务名称)
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 *  输血成分(服务名称)
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务id
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务id
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 输血数量(医学单位数值)
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 输血数量(医学单位数值)
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
	}
	/**
	 * 输血数量单位(医学单位)
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 输血数量单位(医学单位)
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医学单位名称
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医学单位名称
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 临床诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 临床诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 临床诊断
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 输血单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 输血单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 产数量
	 * @return Integer
	 */
	public Integer getParturition_cnt() {
		return ((Integer) getAttrVal("Parturition_cnt"));
	}
	/**
	 * 产数量
	 * @param Parturition_cnt
	 */
	public void setParturition_cnt(Integer Parturition_cnt) {
		setAttrVal("Parturition_cnt", Parturition_cnt);
	}
	/**
	 * 输血史标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bt() {
		return ((FBoolean) getAttrVal("Fg_bt"));
	}
	/**
	 * 输血史标志
	 * @param Fg_bt
	 */
	public void setFg_bt(FBoolean Fg_bt) {
		setAttrVal("Fg_bt", Fg_bt);
	}
	/**
	 * 输血目的编码
	 * @return String
	 */
	public String getSd_pps() {
		return ((String) getAttrVal("Sd_pps"));
	}
	/**
	 * 输血目的编码
	 * @param Sd_pps
	 */
	public void setSd_pps(String Sd_pps) {
		setAttrVal("Sd_pps", Sd_pps);
	}
	/**
	 * 输血目的id
	 * @return String
	 */
	public String getId_pps() {
		return ((String) getAttrVal("Id_pps"));
	}
	/**
	 * 输血目的id
	 * @param Id_pps
	 */
	public void setId_pps(String Id_pps) {
		setAttrVal("Id_pps", Id_pps);
	}
	/**
	 * 输血目的
	 * @return String
	 */
	public String getName_pps() {
		return ((String) getAttrVal("Name_pps"));
	}
	/**
	 * 输血目的
	 * @param Name_pps
	 */
	public void setName_pps(String Name_pps) {
		setAttrVal("Name_pps", Name_pps);
	}
	/**
	 * 献血史标志
	 * @return FBoolean
	 */
	public FBoolean getFg_db() {
		return ((FBoolean) getAttrVal("Fg_db"));
	}
	/**
	 * 献血史标志
	 * @param Fg_db
	 */
	public void setFg_db(FBoolean Fg_db) {
		setAttrVal("Fg_db", Fg_db);
	}
	/**
	 * 献血证号
	 * @return String
	 */
	public String getNo_db() {
		return ((String) getAttrVal("No_db"));
	}
	/**
	 * 献血证号
	 * @param No_db
	 */
	public void setNo_db(String No_db) {
		setAttrVal("No_db", No_db);
	}
	/**
	 * 预定输血方式id
	 * @return String
	 */
	public String getId_mode() {
		return ((String) getAttrVal("Id_mode"));
	}
	/**
	 * 预定输血方式id
	 * @param Id_mode
	 */
	public void setId_mode(String Id_mode) {
		setAttrVal("Id_mode", Id_mode);
	}
	/**
	 * 预定输血方式
	 * @return String
	 */
	public String getName_mode() {
		return ((String) getAttrVal("Name_mode"));
	}
	/**
	 * 预定输血方式
	 * @param Name_mode
	 */
	public void setName_mode(String Name_mode) {
		setAttrVal("Name_mode", Name_mode);
	}
	/**
	 * 输血需求状态sd
	 * @return String
	 */
	public String getSd_demandsu() {
		return ((String) getAttrVal("Sd_demandsu"));
	}
	/**
	 * 输血需求状态sd
	 * @param Sd_demandsu
	 */
	public void setSd_demandsu(String Sd_demandsu) {
		setAttrVal("Sd_demandsu", Sd_demandsu);
	}
	/**
	 * 预定输血方式sd
	 * @return String
	 */
	public String getSd_mode() {
		return ((String) getAttrVal("Sd_mode"));
	}
	/**
	 * 预定输血方式sd
	 * @param Sd_mode
	 */
	public void setSd_mode(String Sd_mode) {
		setAttrVal("Sd_mode", Sd_mode);
	}
	/**
	 * 孕几胎
	 * @return Integer
	 */
	public Integer getPregnat_num() {
		return ((Integer) getAttrVal("Pregnat_num"));
	}
	/**
	 * 孕几胎
	 * @param Pregnat_num
	 */
	public void setPregnat_num(Integer Pregnat_num) {
		setAttrVal("Pregnat_num", Pregnat_num);
	}
	/**
	 * 输血前检查说明id
	 * @return String
	 */
	public String getId_labitmexplain() {
		return ((String) getAttrVal("Id_labitmexplain"));
	}
	/**
	 * 输血前检查说明id
	 * @param Id_labitmexplain
	 */
	public void setId_labitmexplain(String Id_labitmexplain) {
		setAttrVal("Id_labitmexplain", Id_labitmexplain);
	}
	/**
	 * 输血前检查说明
	 * @return String
	 */
	public String getName_labitmexplain() {
		return ((String) getAttrVal("Name_labitmexplain"));
	}
	/**
	 * 输血前检查说明
	 * @param Name_labitmexplain
	 */
	public void setName_labitmexplain(String Name_labitmexplain) {
		setAttrVal("Name_labitmexplain", Name_labitmexplain);
	}
	/**
	 * 输血前检测项目说明
	 * @return String
	 */
	public String getSd_labitmexplain() {
		return ((String) getAttrVal("Sd_labitmexplain"));
	}
	/**
	 * 输血前检测项目说明
	 * @param Sd_labitmexplain
	 */
	public void setSd_labitmexplain(String Sd_labitmexplain) {
		setAttrVal("Sd_labitmexplain", Sd_labitmexplain);
	}
	/**
	 * 输血日期
	 * @return FDateTime
	 */
	public FDateTime getDt_bt() {
		return ((FDateTime) getAttrVal("Dt_bt"));
	}
	/**
	 * 输血日期
	 * @param Dt_bt
	 */
	public void setDt_bt(FDateTime Dt_bt) {
		setAttrVal("Dt_bt", Dt_bt);
	}
	/**
	 * 申请医生id
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}
	/**
	 * 申请医生id
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
	}
	/**
	 * 申请医生
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 申请医生
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 开立时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 血液品种id
	 * @return String
	 */
	public String getId_bttp() {
		return ((String) getAttrVal("Id_bttp"));
	}
	/**
	 * 血液品种id
	 * @param Id_bttp
	 */
	public void setId_bttp(String Id_bttp) {
		setAttrVal("Id_bttp", Id_bttp);
	}
	/**
	 * 血液品种
	 * @return String
	 */
	public String getName_bttp() {
		return ((String) getAttrVal("Name_bttp"));
	}
	/**
	 * 血液品种
	 * @param Name_bttp
	 */
	public void setName_bttp(String Name_bttp) {
		setAttrVal("Name_bttp", Name_bttp);
	}
	/**
	 * 血液品种sd
	 * @return String
	 */
	public String getSd_bttp() {
		return ((String) getAttrVal("Sd_bttp"));
	}
	/**
	 * 血液品种sd
	 * @param Sd_bttp
	 */
	public void setSd_bttp(String Sd_bttp) {
		setAttrVal("Sd_bttp", Sd_bttp);
	}
	/**
	 * 输血需求状态id
	 * @return String
	 */
	public String getId_demandsu() {
		return ((String) getAttrVal("Id_demandsu"));
	}
	/**
	 * 输血需求状态id
	 * @param Id_demandsu
	 */
	public void setId_demandsu(String Id_demandsu) {
		setAttrVal("Id_demandsu", Id_demandsu);
	}
	/**
	 * 输血需求状态
	 * @return String
	 */
	public String getName_demandsu() {
		return ((String) getAttrVal("Name_demandsu"));
	}
	/**
	 * 输血需求状态
	 * @param Name_demandsu
	 */
	public void setName_demandsu(String Name_demandsu) {
		setAttrVal("Name_demandsu", Name_demandsu);
	}
	
	public FArrayList getBtLabItem(){
		
		return ((FArrayList) getAttrVal("OrdApSugViewItemDO"));
	}
	public void setBtLabItem(FArrayList OrdApSugViewItemDO){
		setAttrVal("OrdApSugViewItemDO", OrdApSugViewItemDO);
	}
}