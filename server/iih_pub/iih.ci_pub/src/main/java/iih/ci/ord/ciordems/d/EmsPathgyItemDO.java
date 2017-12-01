package iih.ci.ord.ciordems.d;

import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/**
 * 病理申请医疗单 DTO数据 
 * 
 */
public class EmsPathgyItemDO extends OrCommonFieldsDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 诊断子项id
	 * @return String
	 */
	public String getId_diitm() {
		return ((String) getAttrVal("Id_diitm"));
	}
	/**
	 * 诊断子项id
	 * @param Id_diitm
	 */
	public void setId_diitm(String Id_diitm) {
		setAttrVal("Id_diitm", Id_diitm);
	}
	/**
	 * 诊断编码拼接
	 * @return String
	 */
	public String getStr_code_di() {
		return ((String) getAttrVal("Str_code_di"));
	}
	/**
	 * 诊断编码拼接
	 * @param Str_code_di
	 */
	public void setStr_code_di(String Str_code_di) {
		setAttrVal("Str_code_di", Str_code_di);
	}
	/**
	 * 诊断idi拼接字符串
	 * @return String
	 */
	public String getStr_id_diitm() {
		return ((String) getAttrVal("Str_id_diitm"));
	}
	/**
	 * 诊断idi拼接字符串
	 * @param Str_id_diitm
	 */
	public void setStr_id_diitm(String Str_id_diitm) {
		setAttrVal("Str_id_diitm", Str_id_diitm);
	}
	/**
	 * 诊断名字拼接字符串
	 * @return String
	 */
	public String getStr_name_di() {
		return ((String) getAttrVal("Str_name_di"));
	}
	/**
	 * 诊断名字拼接字符串
	 * @param Str_name_di
	 */
	public void setStr_name_di(String Str_name_di) {
		setAttrVal("Str_name_di", Str_name_di);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}
	/**
	 * 诊断
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 诊断id
	 * @return String
	 */
	public String getId_di() {
		return ((String) getAttrVal("Id_di"));
	}
	/**
	 * 诊断id
	 * @param Id_di
	 */
	public void setId_di(String Id_di) {
		setAttrVal("Id_di", Id_di);
	}
	/**
	 * 主键
	 * @return String
	 */
	public String getId_ordpathgyitem() {
		return ((String) getAttrVal("Id_ordpathgyitem"));
	}
	/**
	 * 主键
	 * @param Id_ordpathgyitem
	 */
	public void setId_ordpathgyitem(String Id_ordpathgyitem) {
		setAttrVal("Id_ordpathgyitem", Id_ordpathgyitem);
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
	 * 病理项目
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 病理项目
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 标本类型id
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型id
	 * @param Id_samptp
	 */
	public void setId_samptp(String Id_samptp) {
		setAttrVal("Id_samptp", Id_samptp);
	}
	/**
	 * 标本类型编码
	 * @return String
	 */
	public String getSd_samptp() {
		return ((String) getAttrVal("Sd_samptp"));
	}
	/**
	 * 标本类型编码
	 * @param Sd_samptp
	 */
	public void setSd_samptp(String Sd_samptp) {
		setAttrVal("Sd_samptp", Sd_samptp);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 检查要求
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}
	/**
	 * 检查要求
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 病情描述
	 * @return String
	 */
	public String getDes_sympsign() {
		return ((String) getAttrVal("Des_sympsign"));
	}
	/**
	 * 病情描述
	 * @param Des_sympsign
	 */
	public void setDes_sympsign(String Des_sympsign) {
		setAttrVal("Des_sympsign", Des_sympsign);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}
	/**
	 * 申请时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 申请医师
	 * @return String
	 */
	public String getName_emp_create() {
		return ((String) getAttrVal("Name_emp_create"));
	}
	/**
	 * 申请医师
	 * @param Name_emp_create
	 */
	public void setName_emp_create(String Name_emp_create) {
		setAttrVal("Name_emp_create", Name_emp_create);
	}
	/**
	 * 采集所见
	 * @return String
	 */
	public String getCollectdes() {
		return ((String) getAttrVal("Collectdes"));
	}
	/**
	 * 采集所见
	 * @param Collectdes
	 */
	public void setCollectdes(String Collectdes) {
		setAttrVal("Collectdes", Collectdes);
	}
	/**
	 * 采集者id
	 * @return String
	 */
	public String getId_emp_coll() {
		return ((String) getAttrVal("Id_emp_coll"));
	}
	/**
	 * 采集者id
	 * @param Id_emp_coll
	 */
	public void setId_emp_coll(String Id_emp_coll) {
		setAttrVal("Id_emp_coll", Id_emp_coll);
	}
	/**
	 * 采集者
	 * @return String
	 */
	public String getName_emp_coll() {
		return ((String) getAttrVal("Name_emp_coll"));
	}
	/**
	 * 采集者
	 * @param Name_emp_coll
	 */
	public void setName_emp_coll(String Name_emp_coll) {
		setAttrVal("Name_emp_coll", Name_emp_coll);
	}
	/**
	 * 采集时间
	 * @return FDateTime
	 */
	public FDateTime getDt_coll() {
		return ((FDateTime) getAttrVal("Dt_coll"));
	}
	/**
	 * 采集时间
	 * @param Dt_coll
	 */
	public void setDt_coll(FDateTime Dt_coll) {
		setAttrVal("Dt_coll", Dt_coll);
	}
	/**
	 * 外院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_outer() {
		return ((FBoolean) getAttrVal("Fg_outer"));
	}
	/**
	 * 外院标志
	 * @param Fg_outer
	 */
	public void setFg_outer(FBoolean Fg_outer) {
		setAttrVal("Fg_outer", Fg_outer);
	}
	/**
	 * 既往病理医院
	 * @return String
	 */
	public String getOrg_pathgy_old() {
		return ((String) getAttrVal("Org_pathgy_old"));
	}
	/**
	 * 既往病理医院
	 * @param Org_pathgy_old
	 */
	public void setOrg_pathgy_old(String Org_pathgy_old) {
		setAttrVal("Org_pathgy_old", Org_pathgy_old);
	}
	/**
	 * 既往病理日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pathgy_old() {
		return ((FDateTime) getAttrVal("Dt_pathgy_old"));
	}
	/**
	 * 既往病理日期
	 * @param Dt_pathgy_old
	 */
	public void setDt_pathgy_old(FDateTime Dt_pathgy_old) {
		setAttrVal("Dt_pathgy_old", Dt_pathgy_old);
	}
	/**
	 * 既往病理号
	 * @return String
	 */
	public String getNo_pathgy_old() {
		return ((String) getAttrVal("No_pathgy_old"));
	}
	/**
	 * 既往病理号
	 * @param No_pathgy_old
	 */
	public void setNo_pathgy_old(String No_pathgy_old) {
		setAttrVal("No_pathgy_old", No_pathgy_old);
	}
	/**
	 * 既往病理诊断id
	 * @return String
	 */
	public String getId_di_pathgy_old() {
		return ((String) getAttrVal("Id_di_pathgy_old"));
	}
	/**
	 * 既往病理诊断id
	 * @param Id_di_pathgy_old
	 */
	public void setId_di_pathgy_old(String Id_di_pathgy_old) {
		setAttrVal("Id_di_pathgy_old", Id_di_pathgy_old);
	}
	/**
	 * 既往病理诊断
	 * @return String
	 */
	public String getName_di_pathgy_old() {
		return ((String) getAttrVal("Name_di_pathgy_old"));
	}
	/**
	 * 既往病理诊断
	 * @param Name_di_pathgy_old
	 */
	public void setName_di_pathgy_old(String Name_di_pathgy_old) {
		setAttrVal("Name_di_pathgy_old", Name_di_pathgy_old);
	}
	/**
	 * 标本采集科室id
	 * @return String
	 */
	public String getId_dep_coll() {
		return ((String) getAttrVal("Id_dep_coll"));
	}
	/**
	 * 标本采集科室id
	 * @param Id_dep_coll
	 */
	public void setId_dep_coll(String Id_dep_coll) {
		setAttrVal("Id_dep_coll", Id_dep_coll);
	}
	/**
	 * 标本采集科室
	 * @return String
	 */
	public String getName_dep_coll() {
		return ((String) getAttrVal("Name_dep_coll"));
	}
	/**
	 * 标本采集科室
	 * @param Name_dep_coll
	 */
	public void setName_dep_coll(String Name_dep_coll) {
		setAttrVal("Name_dep_coll", Name_dep_coll);
	}
	/**
	 * 病理号
	 * @return String
	 */
	public String getNo_pathgy() {
		return ((String) getAttrVal("No_pathgy"));
	}
	/**
	 * 病理号
	 * @param No_pathgy
	 */
	public void setNo_pathgy(String No_pathgy) {
		setAttrVal("No_pathgy", No_pathgy);
	}
	/**
	 * 报告发布时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rptpathgy() {
		return ((FDateTime) getAttrVal("Dt_rptpathgy"));
	}
	/**
	 * 报告发布时间
	 * @param Dt_rptpathgy
	 */
	public void setDt_rptpathgy(FDateTime Dt_rptpathgy) {
		setAttrVal("Dt_rptpathgy", Dt_rptpathgy);
	}
	/**
	 * 版本号
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本号
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 标本数量
	 * @return Integer
	 */
	public Integer getQuan() {
		return ((Integer) getAttrVal("Quan"));
	}
	/**
	 * 标本数量
	 * @param Quan
	 */
	public void setQuan(Integer Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 采集方法
	 * @return String
	 */
	public String getSd_colltp() {
		return ((String) getAttrVal("Sd_colltp"));
	}
	/**
	 * 采集方法
	 * @param Sd_colltp
	 */
	public void setSd_colltp(String Sd_colltp) {
		setAttrVal("Sd_colltp", Sd_colltp);
	}
	/**
	 * 采集方法id
	 * @return String
	 */
	public String getId_colltp() {
		return ((String) getAttrVal("Id_colltp"));
	}
	/**
	 * 采集方法id
	 * @param Id_colltp
	 */
	public void setId_colltp(String Id_colltp) {
		setAttrVal("Id_colltp", Id_colltp);
	}
	/**
	 * 采集方法名称
	 * @return String
	 */
	public String getName_colltp() {
		return ((String) getAttrVal("Name_colltp"));
	}
	/**
	 * 采集方法名称
	 * @param Name_colltp
	 */
	public void setName_colltp(String Name_colltp) {
		setAttrVal("Name_colltp", Name_colltp);
	}
	/**
	 * 标本说明
	 * @return String
	 */
	public String getDes_labsamp() {
		return ((String) getAttrVal("Des_labsamp"));
	}
	/**
	 * 标本说明
	 * @param Des_labsamp
	 */
	public void setDes_labsamp(String Des_labsamp) {
		setAttrVal("Des_labsamp", Des_labsamp);
	}
	/**
	 * 参考价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 参考价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 费用同步编码
	 * @return FBoolean
	 */
	public FBoolean getFg_syncfee() {
		return ((FBoolean) getAttrVal("Fg_syncfee"));
	}
	/**
	 * 费用同步编码
	 * @param Fg_syncfee
	 */
	public void setFg_syncfee(FBoolean Fg_syncfee) {
		setAttrVal("Fg_syncfee", Fg_syncfee);
	}
	/**
	 * 服务分类内部编码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内部编码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 执行科室id
	 * @return String
	 */
	public String getId_mp_dep() {
		return ((String) getAttrVal("Id_mp_dep"));
	}
	/**
	 * 执行科室id
	 * @param Id_mp_dep
	 */
	public void setId_mp_dep(String Id_mp_dep) {
		setAttrVal("Id_mp_dep", Id_mp_dep);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_mp_dep() {
		return ((String) getAttrVal("Name_mp_dep"));
	}
	/**
	 * 执行科室名称
	 * @param Name_mp_dep
	 */
	public void setName_mp_dep(String Name_mp_dep) {
		setAttrVal("Name_mp_dep", Name_mp_dep);
	}
	
	
	/**
	 * 客户拓展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 客户拓展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 客户拓展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 客户拓展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户拓展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户拓展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户拓展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户拓展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户拓展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户拓展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 客户拓展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 客户拓展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 客户拓展字段7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}
	/**
	 * 客户拓展字段7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 客户拓展字段8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}
	/**
	 * 客户拓展字段8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 客户拓展字段9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}
	/**
	 * 客户拓展字段9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 客户拓展字段10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}
	/**
	 * 客户拓展字段10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 客户拓展字段11
	 * @return String
	 */
	public String getDef11() {
		return ((String) getAttrVal("Def11"));
	}
	/**
	 * 客户拓展字段11
	 * @param Def11
	 */
	public void setDef11(String Def11) {
		setAttrVal("Def11", Def11);
	}
	/**
	 * 客户拓展字段12
	 * @return String
	 */
	public String getDef12() {
		return ((String) getAttrVal("Def12"));
	}
	/**
	 * 客户拓展字段12
	 * @param Def12
	 */
	public void setDef12(String Def12) {
		setAttrVal("Def12", Def12);
	}
	/**
	 * 客户拓展字段13
	 * @return String
	 */
	public String getDef13() {
		return ((String) getAttrVal("Def13"));
	}
	/**
	 * 客户拓展字段13
	 * @param Def13
	 */
	public void setDef13(String Def13) {
		setAttrVal("Def13", Def13);
	}
	/**
	 * 客户拓展字段14
	 * @return String
	 */
	public String getDef14() {
		return ((String) getAttrVal("Def14"));
	}
	/**
	 * 客户拓展字段14
	 * @param Def14
	 */
	public void setDef14(String Def14) {
		setAttrVal("Def14", Def14);
	}
	/**
	 * 客户拓展字段15
	 * @return String
	 */
	public String getDef15() {
		return ((String) getAttrVal("Def15"));
	}
	/**
	 * 客户拓展字段15
	 * @param Def15
	 */
	public void setDef15(String Def15) {
		setAttrVal("Def15", Def15);
	}
	/**
	 * 客户拓展字段16
	 * @return String
	 */
	public String getDef16() {
		return ((String) getAttrVal("Def16"));
	}
	/**
	 * 客户拓展字段16
	 * @param Def16
	 */
	public void setDef16(String Def16) {
		setAttrVal("Def16", Def16);
	}
	/**
	 * 客户拓展字段17
	 * @return String
	 */
	public String getDef17() {
		return ((String) getAttrVal("Def17"));
	}
	/**
	 * 客户拓展字段17
	 * @param Def17
	 */
	public void setDef17(String Def17) {
		setAttrVal("Def17", Def17);
	}
	/**
	 * 客户拓展字段18
	 * @return String
	 */
	public String getDef18() {
		return ((String) getAttrVal("Def18"));
	}
	/**
	 * 客户拓展字段18
	 * @param Def18
	 */
	public void setDef18(String Def18) {
		setAttrVal("Def18", Def18);
	}
	/**
	 * 客户拓展字段19
	 * @return String
	 */
	public String getDef19() {
		return ((String) getAttrVal("Def19"));
	}
	/**
	 * 客户拓展字段19
	 * @param Def19
	 */
	public void setDef19(String Def19) {
		setAttrVal("Def19", Def19);
	}
	/**
	 * 客户拓展字段20
	 * @return String
	 */
	public String getDef20() {
		return ((String) getAttrVal("Def20"));
	}
	/**
	 * 客户拓展字段20
	 * @param Def20
	 */
	public void setDef20(String Def20) {
		setAttrVal("Def20", Def20);
	}
	/**
	 * 客户拓展字段21
	 * @return String
	 */
	public String getDef21() {
		return ((String) getAttrVal("Def21"));
	}
	/**
	 * 客户拓展字段21
	 * @param Def21
	 */
	public void setDef21(String Def21) {
		setAttrVal("Def21", Def21);
	}
	/**
	 * 客户拓展字段22
	 * @return String
	 */
	public String getDef22() {
		return ((String) getAttrVal("Def22"));
	}
	/**
	 * 客户拓展字段22
	 * @param Def22
	 */
	public void setDef22(String Def22) {
		setAttrVal("Def22", Def22);
	}
	/**
	 * 客户拓展字段23
	 * @return String
	 */
	public String getDef23() {
		return ((String) getAttrVal("Def23"));
	}
	/**
	 * 客户拓展字段23
	 * @param Def23
	 */
	public void setDef23(String Def23) {
		setAttrVal("Def23", Def23);
	}
	/**
	 * 客户拓展字段24
	 * @return String
	 */
	public String getDef24() {
		return ((String) getAttrVal("Def24"));
	}
	/**
	 * 客户拓展字段24
	 * @param Def24
	 */
	public void setDef24(String Def24) {
		setAttrVal("Def24", Def24);
	}
	/**
	 * 客户拓展字段25
	 * @return String
	 */
	public String getDef25() {
		return ((String) getAttrVal("Def25"));
	}
	/**
	 * 客户拓展字段25
	 * @param Def25
	 */
	public void setDef25(String Def25) {
		setAttrVal("Def25", Def25);
	}
	/**
	 * 客户拓展字段26
	 * @return String
	 */
	public String getDef26() {
		return ((String) getAttrVal("Def26"));
	}
	/**
	 * 客户拓展字段26
	 * @param Def26
	 */
	public void setDef26(String Def26) {
		setAttrVal("Def26", Def26);
	}
	/**
	 * 客户拓展字段27
	 * @return String
	 */
	public String getDef27() {
		return ((String) getAttrVal("Def27"));
	}
	/**
	 * 客户拓展字段27
	 * @param Def27
	 */
	public void setDef27(String Def27) {
		setAttrVal("Def27", Def27);
	}
	/**
	 * 客户拓展字段28
	 * @return String
	 */
	public String getDef28() {
		return ((String) getAttrVal("Def28"));
	}
	/**
	 * 客户拓展字段28
	 * @param Def28
	 */
	public void setDef28(String Def28) {
		setAttrVal("Def28", Def28);
	}
	/**
	 * 客户拓展字段29
	 * @return String
	 */
	public String getDef29() {
		return ((String) getAttrVal("Def29"));
	}
	/**
	 * 客户拓展字段29
	 * @param Def29
	 */
	public void setDef29(String Def29) {
		setAttrVal("Def29", Def29);
	}
	/**
	 * 客户拓展字段304
	 * @return String
	 */
	public String getDef30() {
		return ((String) getAttrVal("Def30"));
	}
	/**
	 * 客户拓展字段304
	 * @param Def30
	 */
	public void setDef30(String Def30) {
		setAttrVal("Def30", Def30);
	}
	/**
	 * 客户拓展字段31
	 * @return String
	 */
	public String getDef31() {
		return ((String) getAttrVal("Def31"));
	}
	/**
	 * 客户拓展字段31
	 * @param Def31
	 */
	public void setDef31(String Def31) {
		setAttrVal("Def31", Def31);
	}
	/**
	 * 客户拓展字段32
	 * @return String
	 */
	public String getDef32() {
		return ((String) getAttrVal("Def32"));
	}
	/**
	 * 客户拓展字段32
	 * @param Def32
	 */
	public void setDef32(String Def32) {
		setAttrVal("Def32", Def32);
	}
	/**
	 * 客户拓展字段33
	 * @return String
	 */
	public String getDef33() {
		return ((String) getAttrVal("Def33"));
	}
	/**
	 * 客户拓展字段33
	 * @param Def33
	 */
	public void setDef33(String Def33) {
		setAttrVal("Def33", Def33);
	}
	/**
	 * 客户拓展字段34
	 * @return String
	 */
	public String getDef34() {
		return ((String) getAttrVal("Def34"));
	}
	/**
	 * 客户拓展字段34
	 * @param Def34
	 */
	public void setDef34(String Def34) {
		setAttrVal("Def34", Def34);
	}
	/**
	 * 客户拓展字段35
	 * @return String
	 */
	public String getDef35() {
		return ((String) getAttrVal("Def35"));
	}
	/**
	 * 客户拓展字段35
	 * @param Def35
	 */
	public void setDef35(String Def35) {
		setAttrVal("Def35", Def35);
	}
	/**
	 * 客户拓展字段36
	 * @return String
	 */
	public String getDef36() {
		return ((String) getAttrVal("Def36"));
	}
	/**
	 * 客户拓展字段36
	 * @param Def36
	 */
	public void setDef36(String Def36) {
		setAttrVal("Def36", Def36);
	}
	/**
	 * 客户拓展字段37
	 * @return String
	 */
	public String getDef37() {
		return ((String) getAttrVal("Def37"));
	}
	/**
	 * 客户拓展字段37
	 * @param Def37
	 */
	public void setDef37(String Def37) {
		setAttrVal("Def37", Def37);
	}
	/**
	 * 客户拓展字段38
	 * @return String
	 */
	public String getDef38() {
		return ((String) getAttrVal("Def38"));
	}
	/**
	 * 客户拓展字段38
	 * @param Def38
	 */
	public void setDef38(String Def38) {
		setAttrVal("Def38", Def38);
	}
	/**
	 * 客户拓展字段39
	 * @return String
	 */
	public String getDef39() {
		return ((String) getAttrVal("Def39"));
	}
	/**
	 * 客户拓展字段39
	 * @param Def39
	 */
	public void setDef39(String Def39) {
		setAttrVal("Def39", Def39);
	}
	/**
	 * 客户拓展字段40
	 * @return String
	 */
	public String getDef40() {
		return ((String) getAttrVal("Def40"));
	}
	/**
	 * 客户拓展字段40
	 * @param Def40
	 */
	public void setDef40(String Def40) {
		setAttrVal("Def40", Def40);
	}
	/**
	 * 客户拓展字段41
	 * @return String
	 */
	public String getDef41() {
		return ((String) getAttrVal("Def41"));
	}
	/**
	 * 客户拓展字段41
	 * @param Def41
	 */
	public void setDef41(String Def41) {
		setAttrVal("Def41", Def41);
	}
	/**
	 * 客户拓展字段42
	 * @return String
	 */
	public String getDef42() {
		return ((String) getAttrVal("Def42"));
	}
	/**
	 * 客户拓展字段42
	 * @param Def42
	 */
	public void setDef42(String Def42) {
		setAttrVal("Def42", Def42);
	}
	/**
	 * 客户拓展字段43
	 * @return String
	 */
	public String getDef43() {
		return ((String) getAttrVal("Def43"));
	}
	/**
	 * 客户拓展字段43
	 * @param Def43
	 */
	public void setDef43(String Def43) {
		setAttrVal("Def43", Def43);
	}
	/**
	 * 客户拓展字段44
	 * @return String
	 */
	public String getDef44() {
		return ((String) getAttrVal("Def44"));
	}
	/**
	 * 客户拓展字段44
	 * @param Def44
	 */
	public void setDef44(String Def44) {
		setAttrVal("Def44", Def44);
	}
	/**
	 * 客户拓展字段45
	 * @return String
	 */
	public String getDef45() {
		return ((String) getAttrVal("Def45"));
	}
	/**
	 * 客户拓展字段45
	 * @param Def45
	 */
	public void setDef45(String Def45) {
		setAttrVal("Def45", Def45);
	}
	/**
	 * 客户拓展字段46
	 * @return String
	 */
	public String getDef46() {
		return ((String) getAttrVal("Def46"));
	}
	/**
	 * 客户拓展字段46
	 * @param Def46
	 */
	public void setDef46(String Def46) {
		setAttrVal("Def46", Def46);
	}
	/**
	 * 客户拓展字段47
	 * @return String
	 */
	public String getDef47() {
		return ((String) getAttrVal("Def47"));
	}
	/**
	 * 客户拓展字段47
	 * @param Def47
	 */
	public void setDef47(String Def47) {
		setAttrVal("Def47", Def47);
	}
	/**
	 * 客户拓展字段48
	 * @return String
	 */
	public String getDef48() {
		return ((String) getAttrVal("Def48"));
	}
	/**
	 * 客户拓展字段48
	 * @param Def48
	 */
	public void setDef48(String Def48) {
		setAttrVal("Def48", Def48);
	}
	/**
	 * 客户拓展字段49
	 * @return String
	 */
	public String getDef49() {
		return ((String) getAttrVal("Def49"));
	}
	/**
	 * 客户拓展字段49
	 * @param Def49
	 */
	public void setDef49(String Def49) {
		setAttrVal("Def49", Def49);
	}
	/**
	 * 客户拓展字段50
	 * @return String
	 */
	public String getDef50() {
		return ((String) getAttrVal("Def50"));
	}
	/**
	 * 客户拓展字段50
	 * @param Def50
	 */
	public void setDef50(String Def50) {
		setAttrVal("Def50", Def50);
	}
	
	/**
	 * EmsItemInpathgyList
	 * @return FArrayList
	 */
	public FArrayList getEmsItemInpathgyList() {
		return ((FArrayList) getAttrVal("EmsItemInpathgyList"));
	}
	/**
	 * 客户拓展字段50
	 * @param Def50
	 */
	public void setEmsItemInpathgyList(FArrayList EmsItemInpathgyList) {
		setAttrVal("EmsItemInpathgyList", EmsItemInpathgyList);
	}
	
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 记费模式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 记费模式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}	
}