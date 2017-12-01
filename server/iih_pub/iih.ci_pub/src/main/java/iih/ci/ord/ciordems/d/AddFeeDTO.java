package iih.ci.ord.ciordems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 补费 DTO数据 
 * 
 */
public class AddFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单项目主键标识
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医疗单项目主键标识
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 医疗单
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医疗单
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 所属服务套
	 * @return String
	 */
	public String getId_srv_set() {
		return ((String) getAttrVal("Id_srv_set"));
	}
	/**
	 * 所属服务套
	 * @param Id_srv_set
	 */
	public void setId_srv_set(String Id_srv_set) {
		setAttrVal("Id_srv_set", Id_srv_set);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
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
	 * 医疗服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}
	/**
	 * 医疗服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 医疗服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 医疗服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 服务项目基本分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务项目基本分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 医疗单位
	 * @return String
	 */
	public String getId_unit_med() {
		return ((String) getAttrVal("Id_unit_med"));
	}
	/**
	 * 医疗单位
	 * @param Id_unit_med
	 */
	public void setId_unit_med(String Id_unit_med) {
		setAttrVal("Id_unit_med", Id_unit_med);
	}
	/**
	 * 医疗单位编码
	 * @return String
	 */
	public String getName_unit_med() {
		return ((String) getAttrVal("Name_unit_med"));
	}
	/**
	 * 医疗单位编码
	 * @param Name_unit_med
	 */
	public void setName_unit_med(String Name_unit_med) {
		setAttrVal("Name_unit_med", Name_unit_med);
	}
	/**
	 * 剂量
	 * @return FDouble
	 */
	public FDouble getQuan_med() {
		return ((FDouble) getAttrVal("Quan_med"));
	}
	/**
	 * 剂量
	 * @param Quan_med
	 */
	public void setQuan_med(FDouble Quan_med) {
		setAttrVal("Quan_med", Quan_med);
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
	 * 医嘱频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 医嘱频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 医嘱频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 医嘱频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 用法标识
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法标识
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 用法要求标识
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求标识
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getName_routedes() {
		return ((String) getAttrVal("Name_routedes"));
	}
	/**
	 * 用法要求
	 * @param Name_routedes
	 */
	public void setName_routedes(String Name_routedes) {
		setAttrVal("Name_routedes", Name_routedes);
	}
	/**
	 * 煎法标识
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法标识
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法要求标识
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}
	/**
	 * 煎法要求标识
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 煎法要求
	 * @return String
	 */
	public String getName_boildes() {
		return ((String) getAttrVal("Name_boildes"));
	}
	/**
	 * 煎法要求
	 * @param Name_boildes
	 */
	public void setName_boildes(String Name_boildes) {
		setAttrVal("Name_boildes", Name_boildes);
	}
	/**
	 * 变动用药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}
	/**
	 * 变动用药标识
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes_srv() {
		return ((String) getAttrVal("Des_srv"));
	}
	/**
	 * 备注
	 * @param Des_srv
	 */
	public void setDes_srv(String Des_srv) {
		setAttrVal("Des_srv", Des_srv);
	}
	/**
	 * 物品标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mm() {
		return ((FBoolean) getAttrVal("Fg_mm"));
	}
	/**
	 * 物品标识
	 * @param Fg_mm
	 */
	public void setFg_mm(FBoolean Fg_mm) {
		setAttrVal("Fg_mm", Fg_mm);
	}
	/**
	 * 服务套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 服务套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 医嘱标识
	 * @return FBoolean
	 */
	public FBoolean getFg_or() {
		return ((FBoolean) getAttrVal("Fg_or"));
	}
	/**
	 * 医嘱标识
	 * @param Fg_or
	 */
	public void setFg_or(FBoolean Fg_or) {
		setAttrVal("Fg_or", Fg_or);
	}
	/**
	 * 费用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 费用标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 自备药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_self() {
		return ((FBoolean) getAttrVal("Fg_self"));
	}
	/**
	 * 自备药标识
	 * @param Fg_self
	 */
	public void setFg_self(FBoolean Fg_self) {
		setAttrVal("Fg_self", Fg_self);
	}
	/**
	 * 出院带药标识（废弃不用了）
	 * @return FBoolean
	 */
	public FBoolean getFg_outp() {
		return ((FBoolean) getAttrVal("Fg_outp"));
	}
	/**
	 * 出院带药标识（废弃不用了）
	 * @param Fg_outp
	 */
	public void setFg_outp(FBoolean Fg_outp) {
		setAttrVal("Fg_outp", Fg_outp);
	}
	/**
	 * 预防用药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_propc() {
		return ((FBoolean) getAttrVal("Fg_propc"));
	}
	/**
	 * 预防用药标识
	 * @param Fg_propc
	 */
	public void setFg_propc(FBoolean Fg_propc) {
		setAttrVal("Fg_propc", Fg_propc);
	}
	/**
	 * 治疗用药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_treat() {
		return ((FBoolean) getAttrVal("Fg_treat"));
	}
	/**
	 * 治疗用药标识
	 * @param Fg_treat
	 */
	public void setFg_treat(FBoolean Fg_treat) {
		setAttrVal("Fg_treat", Fg_treat);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_srv() {
		return ((String) getAttrVal("Id_org_srv"));
	}
	/**
	 * 开立机构
	 * @param Id_org_srv
	 */
	public void setId_org_srv(String Id_org_srv) {
		setAttrVal("Id_org_srv", Id_org_srv);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_srv() {
		return ((String) getAttrVal("Id_dep_srv"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_srv
	 */
	public void setId_dep_srv(String Id_dep_srv) {
		setAttrVal("Id_dep_srv", Id_dep_srv);
	}
	/**
	 * 开立病区
	 * @return String
	 */
	public String getId_ward_srv() {
		return ((String) getAttrVal("Id_ward_srv"));
	}
	/**
	 * 开立病区
	 * @param Id_ward_srv
	 */
	public void setId_ward_srv(String Id_ward_srv) {
		setAttrVal("Id_ward_srv", Id_ward_srv);
	}
	/**
	 * 开立人员
	 * @return String
	 */
	public String getId_emp_srv() {
		return ((String) getAttrVal("Id_emp_srv"));
	}
	/**
	 * 开立人员
	 * @param Id_emp_srv
	 */
	public void setId_emp_srv(String Id_emp_srv) {
		setAttrVal("Id_emp_srv", Id_emp_srv);
	}
	/**
	 * 开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create_srv() {
		return ((FDateTime) getAttrVal("Dt_create_srv"));
	}
	/**
	 * 开立时间
	 * @param Dt_create_srv
	 */
	public void setDt_create_srv(FDateTime Dt_create_srv) {
		setAttrVal("Dt_create_srv", Dt_create_srv);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 最近生成日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}
	/**
	 * 最近生成日期
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 划价方式
	 * @return Integer
	 */
	public Integer getEu_blmd() {
		return ((Integer) getAttrVal("Eu_blmd"));
	}
	/**
	 * 划价方式
	 * @param Eu_blmd
	 */
	public void setEu_blmd(Integer Eu_blmd) {
		setAttrVal("Eu_blmd", Eu_blmd);
	}
	/**
	 * 服务项目物品
	 * @return String
	 */
	public String getId_orsrvmm() {
		return ((String) getAttrVal("Id_orsrvmm"));
	}
	/**
	 * 服务项目物品
	 * @param Id_orsrvmm
	 */
	public void setId_orsrvmm(String Id_orsrvmm) {
		setAttrVal("Id_orsrvmm", Id_orsrvmm);
	}
	/**
	 * 物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 物品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}
	/**
	 * 物品编码
	 * @param Code_mm
	 */
	public void setCode_mm(String Code_mm) {
		setAttrVal("Code_mm", Code_mm);
	}
	/**
	 * 物品名称
	 * @return String
	 */
	public String getName_mm() {
		return ((String) getAttrVal("Name_mm"));
	}
	/**
	 * 物品名称
	 * @param Name_mm
	 */
	public void setName_mm(String Name_mm) {
		setAttrVal("Name_mm", Name_mm);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec_mm() {
		return ((String) getAttrVal("Spec_mm"));
	}
	/**
	 * 规格
	 * @param Spec_mm
	 */
	public void setSpec_mm(String Spec_mm) {
		setAttrVal("Spec_mm", Spec_mm);
	}
	/**
	 * 零售单位
	 * @return String
	 */
	public String getId_unit_sale() {
		return ((String) getAttrVal("Id_unit_sale"));
	}
	/**
	 * 零售单位
	 * @param Id_unit_sale
	 */
	public void setId_unit_sale(String Id_unit_sale) {
		setAttrVal("Id_unit_sale", Id_unit_sale);
	}
	/**
	 * 零售单位名称
	 * @return String
	 */
	public String getName_unit_sale() {
		return ((String) getAttrVal("Name_unit_sale"));
	}
	/**
	 * 零售单位名称
	 * @param Name_unit_sale
	 */
	public void setName_unit_sale(String Name_unit_sale) {
		setAttrVal("Name_unit_sale", Name_unit_sale);
	}
	/**
	 * 基本单位
	 * @return String
	 */
	public String getId_unit_base() {
		return ((String) getAttrVal("Id_unit_base"));
	}
	/**
	 * 基本单位
	 * @param Id_unit_base
	 */
	public void setId_unit_base(String Id_unit_base) {
		setAttrVal("Id_unit_base", Id_unit_base);
	}
	/**
	 * 基本单位名称
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}
	/**
	 * 基本单位名称
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}
	/**
	 * 单次数量_分子
	 * @return Integer
	 */
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}
	/**
	 * 单次数量_分子
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次数量_分母
	 * @return Integer
	 */
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}
	/**
	 * 单次数量_分母
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 参考价当前
	 * @return FDouble
	 */
	public FDouble getPrice_cur() {
		return ((FDouble) getAttrVal("Price_cur"));
	}
	/**
	 * 参考价当前
	 * @param Price_cur
	 */
	public void setPrice_cur(FDouble Price_cur) {
		setAttrVal("Price_cur", Price_cur);
	}
	/**
	 * 总量_当前
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}
	/**
	 * 总量_当前
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 总量_基本
	 * @return FDouble
	 */
	public FDouble getQuan_base() {
		return ((FDouble) getAttrVal("Quan_base"));
	}
	/**
	 * 总量_基本
	 * @param Quan_base
	 */
	public void setQuan_base(FDouble Quan_base) {
		setAttrVal("Quan_base", Quan_base);
	}
	/**
	 * 床边量_医学
	 * @return FDouble
	 */
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}
	/**
	 * 床边量_医学
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 当前基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}
	/**
	 * 当前基本换算系数
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
	}
	/**
	 * 医疗基本换算系数
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}
	/**
	 * 医疗基本换算系数
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 药品剂型
	 * @return String
	 */
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}
	/**
	 * 药品剂型
	 * @param Id_dosage
	 */
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	/**
	 * 药品剂型编码
	 * @return String
	 */
	public String getSd_dosage() {
		return ((String) getAttrVal("Sd_dosage"));
	}
	/**
	 * 药品剂型编码
	 * @param Sd_dosage
	 */
	public void setSd_dosage(String Sd_dosage) {
		setAttrVal("Sd_dosage", Sd_dosage);
	}
	/**
	 * 药理分类
	 * @return String
	 */
	public String getId_pharm() {
		return ((String) getAttrVal("Id_pharm"));
	}
	/**
	 * 药理分类
	 * @param Id_pharm
	 */
	public void setId_pharm(String Id_pharm) {
		setAttrVal("Id_pharm", Id_pharm);
	}
	/**
	 * 药理分类编码
	 * @return String
	 */
	public String getSd_pharm() {
		return ((String) getAttrVal("Sd_pharm"));
	}
	/**
	 * 药理分类编码
	 * @param Sd_pharm
	 */
	public void setSd_pharm(String Sd_pharm) {
		setAttrVal("Sd_pharm", Sd_pharm);
	}
	/**
	 * 毒麻分类
	 * @return String
	 */
	public String getId_pois() {
		return ((String) getAttrVal("Id_pois"));
	}
	/**
	 * 毒麻分类
	 * @param Id_pois
	 */
	public void setId_pois(String Id_pois) {
		setAttrVal("Id_pois", Id_pois);
	}
	/**
	 * 毒麻分类编码
	 * @return String
	 */
	public String getSd_pois() {
		return ((String) getAttrVal("Sd_pois"));
	}
	/**
	 * 毒麻分类编码
	 * @param Sd_pois
	 */
	public void setSd_pois(String Sd_pois) {
		setAttrVal("Sd_pois", Sd_pois);
	}
	/**
	 * 抗菌药分类
	 * @return String
	 */
	public String getId_anti() {
		return ((String) getAttrVal("Id_anti"));
	}
	/**
	 * 抗菌药分类
	 * @param Id_anti
	 */
	public void setId_anti(String Id_anti) {
		setAttrVal("Id_anti", Id_anti);
	}
	/**
	 * 抗菌药分类编码
	 * @return String
	 */
	public String getSd_anti() {
		return ((String) getAttrVal("Sd_anti"));
	}
	/**
	 * 抗菌药分类编码
	 * @param Sd_anti
	 */
	public void setSd_anti(String Sd_anti) {
		setAttrVal("Sd_anti", Sd_anti);
	}
	/**
	 * 物品类型
	 * @return String
	 */
	public String getId_mmtp() {
		return ((String) getAttrVal("Id_mmtp"));
	}
	/**
	 * 物品类型
	 * @param Id_mmtp
	 */
	public void setId_mmtp(String Id_mmtp) {
		setAttrVal("Id_mmtp", Id_mmtp);
	}
	/**
	 * 物品类型编码
	 * @return String
	 */
	public String getSd_mmtp() {
		return ((String) getAttrVal("Sd_mmtp"));
	}
	/**
	 * 物品类型编码
	 * @param Sd_mmtp
	 */
	public void setSd_mmtp(String Sd_mmtp) {
		setAttrVal("Sd_mmtp", Sd_mmtp);
	}
	/**
	 * 价值分类
	 * @return String
	 */
	public String getId_val() {
		return ((String) getAttrVal("Id_val"));
	}
	/**
	 * 价值分类
	 * @param Id_val
	 */
	public void setId_val(String Id_val) {
		setAttrVal("Id_val", Id_val);
	}
	/**
	 * 价值分类编码
	 * @return String
	 */
	public String getSd_val() {
		return ((String) getAttrVal("Sd_val"));
	}
	/**
	 * 价值分类编码
	 * @param Sd_val
	 */
	public void setSd_val(String Sd_val) {
		setAttrVal("Sd_val", Sd_val);
	}
	/**
	 * 适应症
	 * @return String
	 */
	public String getIndica() {
		return ((String) getAttrVal("Indica"));
	}
	/**
	 * 适应症
	 * @param Indica
	 */
	public void setIndica(String Indica) {
		setAttrVal("Indica", Indica);
	}
	/**
	 * 禁忌症
	 * @return String
	 */
	public String getConstr() {
		return ((String) getAttrVal("Constr"));
	}
	/**
	 * 禁忌症
	 * @param Constr
	 */
	public void setConstr(String Constr) {
		setAttrVal("Constr", Constr);
	}
	/**
	 * 不良反应
	 * @return String
	 */
	public String getReact() {
		return ((String) getAttrVal("React"));
	}
	/**
	 * 不良反应
	 * @param React
	 */
	public void setReact(String React) {
		setAttrVal("React", React);
	}
	/**
	 * 主要作用
	 * @return String
	 */
	public String getGuide() {
		return ((String) getAttrVal("Guide"));
	}
	/**
	 * 主要作用
	 * @param Guide
	 */
	public void setGuide(String Guide) {
		setAttrVal("Guide", Guide);
	}
	/**
	 * OTC标识
	 * @return FBoolean
	 */
	public FBoolean getFg_otc() {
		return ((FBoolean) getAttrVal("Fg_otc"));
	}
	/**
	 * OTC标识
	 * @param Fg_otc
	 */
	public void setFg_otc(FBoolean Fg_otc) {
		setAttrVal("Fg_otc", Fg_otc);
	}
	/**
	 * 变动用药安排
	 * @return FArrayList
	 */
	public FArrayList getEmsfreqdose() {
		return ((FArrayList) getAttrVal("Emsfreqdose"));
	}
	/**
	 * 变动用药安排
	 * @param Emsfreqdose
	 */
	public void setEmsfreqdose(FArrayList Emsfreqdose) {
		setAttrVal("Emsfreqdose", Emsfreqdose);
	}
	/**
	 * 部位
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}
	/**
	 * 部位
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}
	/**
	 * 部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 部位名称
	 * @return String
	 */
	public String getBody_name() {
		return ((String) getAttrVal("Body_name"));
	}
	/**
	 * 部位名称
	 * @param Body_name
	 */
	public void setBody_name(String Body_name) {
		setAttrVal("Body_name", Body_name);
	}
	/**
	 * 体位
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}
	/**
	 * 体位
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 体位编码
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}
	/**
	 * 体位编码
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 体位名称
	 * @return String
	 */
	public String getPos_name() {
		return ((String) getAttrVal("Pos_name"));
	}
	/**
	 * 体位名称
	 * @param Pos_name
	 */
	public void setPos_name(String Pos_name) {
		setAttrVal("Pos_name", Pos_name);
	}
	/**
	 * 医保适应症标识
	 * @return FBoolean
	 */
	public FBoolean getFg_indic() {
		return ((FBoolean) getAttrVal("Fg_indic"));
	}
	/**
	 * 医保适应症标识
	 * @param Fg_indic
	 */
	public void setFg_indic(FBoolean Fg_indic) {
		setAttrVal("Fg_indic", Fg_indic);
	}
	/**
	 * 医疗单项目数据来源方式
	 * @return Integer
	 */
	public Integer getEu_sourcemd() {
		return ((Integer) getAttrVal("Eu_sourcemd"));
	}
	/**
	 * 医疗单项目数据来源方式
	 * @param Eu_sourcemd
	 */
	public void setEu_sourcemd(Integer Eu_sourcemd) {
		setAttrVal("Eu_sourcemd", Eu_sourcemd);
	}
	/**
	 * 服务版本号
	 * @return FDateTime
	 */
	public FDateTime getSrv_sv() {
		return ((FDateTime) getAttrVal("Srv_sv"));
	}
	/**
	 * 服务版本号
	 * @param Srv_sv
	 */
	public void setSrv_sv(FDateTime Srv_sv) {
		setAttrVal("Srv_sv", Srv_sv);
	}
	/**
	 * 物品版本号
	 * @return FDateTime
	 */
	public FDateTime getMm_sv() {
		return ((FDateTime) getAttrVal("Mm_sv"));
	}
	/**
	 * 物品版本号
	 * @param Mm_sv
	 */
	public void setMm_sv(FDateTime Mm_sv) {
		setAttrVal("Mm_sv", Mm_sv);
	}
	/**
	 * 需皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}
	/**
	 * 需皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
	}
	/**
	 * 不皮试原因
	 * @return String
	 */
	public String getId_skintest_skip_reason() {
		return ((String) getAttrVal("Id_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因
	 * @param Id_skintest_skip_reason
	 */
	public void setId_skintest_skip_reason(String Id_skintest_skip_reason) {
		setAttrVal("Id_skintest_skip_reason", Id_skintest_skip_reason);
	}
	/**
	 * 不皮试原因编码
	 * @return String
	 */
	public String getSd_skintest_skip_reason() {
		return ((String) getAttrVal("Sd_skintest_skip_reason"));
	}
	/**
	 * 不皮试原因编码
	 * @param Sd_skintest_skip_reason
	 */
	public void setSd_skintest_skip_reason(String Sd_skintest_skip_reason) {
		setAttrVal("Sd_skintest_skip_reason", Sd_skintest_skip_reason);
	}
	/**
	 * 关联类型
	 * @return String
	 */
	public String getId_reltp() {
		return ((String) getAttrVal("Id_reltp"));
	}
	/**
	 * 关联类型
	 * @param Id_reltp
	 */
	public void setId_reltp(String Id_reltp) {
		setAttrVal("Id_reltp", Id_reltp);
	}
	/**
	 * 关联类型编码
	 * @return String
	 */
	public String getSd_reltp() {
		return ((String) getAttrVal("Sd_reltp"));
	}
	/**
	 * 关联类型编码
	 * @param Sd_reltp
	 */
	public void setSd_reltp(String Sd_reltp) {
		setAttrVal("Sd_reltp", Sd_reltp);
	}
	/**
	 * 关联医嘱
	 * @return String
	 */
	public String getId_or_rel() {
		return ((String) getAttrVal("Id_or_rel"));
	}
	/**
	 * 关联医嘱
	 * @param Id_or_rel
	 */
	public void setId_or_rel(String Id_or_rel) {
		setAttrVal("Id_or_rel", Id_or_rel);
	}
	/**
	 * 皮试是否有结果
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest_rst() {
		return ((FBoolean) getAttrVal("Fg_skintest_rst"));
	}
	/**
	 * 皮试是否有结果
	 * @param Fg_skintest_rst
	 */
	public void setFg_skintest_rst(FBoolean Fg_skintest_rst) {
		setAttrVal("Fg_skintest_rst", Fg_skintest_rst);
	}
	/**
	 * 自定义服务标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfsrv() {
		return ((FBoolean) getAttrVal("Fg_selfsrv"));
	}
	/**
	 * 自定义服务标识
	 * @param Fg_selfsrv
	 */
	public void setFg_selfsrv(FBoolean Fg_selfsrv) {
		setAttrVal("Fg_selfsrv", Fg_selfsrv);
	}
	/**
	 * 所属来源服务
	 * @return String
	 */
	public String getId_srv_src() {
		return ((String) getAttrVal("Id_srv_src"));
	}
	/**
	 * 所属来源服务
	 * @param Id_srv_src
	 */
	public void setId_srv_src(String Id_srv_src) {
		setAttrVal("Id_srv_src", Id_srv_src);
	}
	/**
	 * 服务总量
	 * @return FDouble
	 */
	public FDouble getQuan_total_medu() {
		return ((FDouble) getAttrVal("Quan_total_medu"));
	}
	/**
	 * 服务总量
	 * @param Quan_total_medu
	 */
	public void setQuan_total_medu(FDouble Quan_total_medu) {
		setAttrVal("Quan_total_medu", Quan_total_medu);
	}
	/**
	 * 定价模式
	 * @return String
	 */
	public String getId_primd() {
		return ((String) getAttrVal("Id_primd"));
	}
	/**
	 * 定价模式
	 * @param Id_primd
	 */
	public void setId_primd(String Id_primd) {
		setAttrVal("Id_primd", Id_primd);
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
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 仓库
	 * @return String
	 */
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}
	/**
	 * 仓库
	 * @param Id_dep_wh
	 */
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	/**
	 * 毒麻药品服务代办人信息
	 * @return FArrayList
	 */
	public FArrayList getEmsagentinfo() {
		return ((FArrayList) getAttrVal("Emsagentinfo"));
	}
	/**
	 * 毒麻药品服务代办人信息
	 * @param Emsagentinfo
	 */
	public void setEmsagentinfo(FArrayList Emsagentinfo) {
		setAttrVal("Emsagentinfo", Emsagentinfo);
	}
	/**
	 * 服务分类内码
	 * @return String
	 */
	public String getInnercode_srvca() {
		return ((String) getAttrVal("Innercode_srvca"));
	}
	/**
	 * 服务分类内码
	 * @param Innercode_srvca
	 */
	public void setInnercode_srvca(String Innercode_srvca) {
		setAttrVal("Innercode_srvca", Innercode_srvca);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getSd_frequnitct() {
		return ((String) getAttrVal("Sd_frequnitct"));
	}
	/**
	 * 频次周期类型
	 * @param Sd_frequnitct
	 */
	public void setSd_frequnitct(String Sd_frequnitct) {
		setAttrVal("Sd_frequnitct", Sd_frequnitct);
	}
	/**
	 * 频次周期数
	 * @return Integer
	 */
	public Integer getFrequnitct() {
		return ((Integer) getAttrVal("Frequnitct"));
	}
	/**
	 * 频次周期数
	 * @param Frequnitct
	 */
	public void setFrequnitct(Integer Frequnitct) {
		setAttrVal("Frequnitct", Frequnitct);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqct() {
		return ((Integer) getAttrVal("Freqct"));
	}
	/**
	 * 频次周期下次数
	 * @param Freqct
	 */
	public void setFreqct(Integer Freqct) {
		setAttrVal("Freqct", Freqct);
	}
	/**
	 * 医保目录名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保目录名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getLimit() {
		return ((String) getAttrVal("Limit"));
	}
	/**
	 * 限制报销条件
	 * @param Limit
	 */
	public void setLimit(String Limit) {
		setAttrVal("Limit", Limit);
	}
	/**
	 * 总金额
	 * @return FDouble
	 */
	public FDouble getAmt_total() {
		return ((FDouble) getAttrVal("Amt_total"));
	}
	/**
	 * 总金额
	 * @param Amt_total
	 */
	public void setAmt_total(FDouble Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 库房名称
	 * @return String
	 */
	public String getName_dep_wh() {
		return ((String) getAttrVal("Name_dep_wh"));
	}
	/**
	 * 库房名称
	 * @param Name_dep_wh
	 */
	public void setName_dep_wh(String Name_dep_wh) {
		setAttrVal("Name_dep_wh", Name_dep_wh);
	}
	/**
	 * 计费单位
	 * @return String
	 */
	public String getId_unit_cg() {
		return ((String) getAttrVal("Id_unit_cg"));
	}
	/**
	 * 计费单位
	 * @param Id_unit_cg
	 */
	public void setId_unit_cg(String Id_unit_cg) {
		setAttrVal("Id_unit_cg", Id_unit_cg);
	}
	/**
	 * 计费单位名称
	 * @return String
	 */
	public String getName_unit_cg() {
		return ((String) getAttrVal("Name_unit_cg"));
	}
	/**
	 * 计费单位名称
	 * @param Name_unit_cg
	 */
	public void setName_unit_cg(String Name_unit_cg) {
		setAttrVal("Name_unit_cg", Name_unit_cg);
	}
	/**
	 * 计费基数
	 * @return FDouble
	 */
	public FDouble getQuan_cgbase() {
		return ((FDouble) getAttrVal("Quan_cgbase"));
	}
	/**
	 * 计费基数
	 * @param Quan_cgbase
	 */
	public void setQuan_cgbase(FDouble Quan_cgbase) {
		setAttrVal("Quan_cgbase", Quan_cgbase);
	}
	/**
	 * 系数_费医
	 * @return FDouble
	 */
	public FDouble getFactor_cm() {
		return ((FDouble) getAttrVal("Factor_cm"));
	}
	/**
	 * 系数_费医
	 * @param Factor_cm
	 */
	public void setFactor_cm(FDouble Factor_cm) {
		setAttrVal("Factor_cm", Factor_cm);
	}
	/**
	 * 计费取整模式
	 * @return String
	 */
	public String getSd_roundmd_cg() {
		return ((String) getAttrVal("Sd_roundmd_cg"));
	}
	/**
	 * 计费取整模式
	 * @param Sd_roundmd_cg
	 */
	public void setSd_roundmd_cg(String Sd_roundmd_cg) {
		setAttrVal("Sd_roundmd_cg", Sd_roundmd_cg);
	}
	/**
	 * 物品类型名称
	 * @return String
	 */
	public String getName_mmtp() {
		return ((String) getAttrVal("Name_mmtp"));
	}
	/**
	 * 物品类型名称
	 * @param Name_mmtp
	 */
	public void setName_mmtp(String Name_mmtp) {
		setAttrVal("Name_mmtp", Name_mmtp);
	}
	/**
	 * 厂家
	 * @return String
	 */
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}
	/**
	 * 厂家
	 * @param Id_sup
	 */
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	/**
	 * 厂家名称
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 厂家名称
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 取整方式
	 * @return String
	 */
	public String getSd_roundmd() {
		return ((String) getAttrVal("Sd_roundmd"));
	}
	/**
	 * 取整方式
	 * @param Sd_roundmd
	 */
	public void setSd_roundmd(String Sd_roundmd) {
		setAttrVal("Sd_roundmd", Sd_roundmd);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt_cur() {
		return ((FDouble) getAttrVal("Amt_cur"));
	}
	/**
	 * 金额
	 * @param Amt_cur
	 */
	public void setAmt_cur(FDouble Amt_cur) {
		setAttrVal("Amt_cur", Amt_cur);
	}
	/**
	 * 可用库存
	 * @return FDouble
	 */
	public FDouble getQuan_stock() {
		return ((FDouble) getAttrVal("Quan_stock"));
	}
	/**
	 * 可用库存
	 * @param Quan_stock
	 */
	public void setQuan_stock(FDouble Quan_stock) {
		setAttrVal("Quan_stock", Quan_stock);
	}
	/**
	 * 对应皮试服务
	 * @return String
	 */
	public String getId_srvskin() {
		return ((String) getAttrVal("Id_srvskin"));
	}
	/**
	 * 对应皮试服务
	 * @param Id_srvskin
	 */
	public void setId_srvskin(String Id_srvskin) {
		setAttrVal("Id_srvskin", Id_srvskin);
	}
	/**
	 * 关联信息Map键值串
	 * @return String
	 */
	public String getMapkeys() {
		return ((String) getAttrVal("Mapkeys"));
	}
	/**
	 * 关联信息Map键值串
	 * @param Mapkeys
	 */
	public void setMapkeys(String Mapkeys) {
		setAttrVal("Mapkeys", Mapkeys);
	}
	/**
	 * 服务与物品关联信息MAP
	 * @return FMap
	 */
	public FMap getMapinfo() {
		return ((FMap) getAttrVal("Mapinfo"));
	}
	/**
	 * 服务与物品关联信息MAP
	 * @param Mapinfo
	 */
	public void setMapinfo(FMap Mapinfo) {
		setAttrVal("Mapinfo", Mapinfo);
	}
	/**
	 * 计价依据
	 * @return String
	 */
	public String getPriby() {
		return ((String) getAttrVal("Priby"));
	}
	/**
	 * 计价依据
	 * @param Priby
	 */
	public void setPriby(String Priby) {
		setAttrVal("Priby", Priby);
	}
	/**
	 * 基数药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_base() {
		return ((FBoolean) getAttrVal("Fg_base"));
	}
	/**
	 * 基数药标识
	 * @param Fg_base
	 */
	public void setFg_base(FBoolean Fg_base) {
		setAttrVal("Fg_base", Fg_base);
	}
	/**
	 * 计费状态
	 * @return String
	 */
	public String getId_su_bl() {
		return ((String) getAttrVal("Id_su_bl"));
	}
	/**
	 * 计费状态
	 * @param Id_su_bl
	 */
	public void setId_su_bl(String Id_su_bl) {
		setAttrVal("Id_su_bl", Id_su_bl);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getId_su_mp() {
		return ((String) getAttrVal("Id_su_mp"));
	}
	/**
	 * 执行状态
	 * @param Id_su_mp
	 */
	public void setId_su_mp(String Id_su_mp) {
		setAttrVal("Id_su_mp", Id_su_mp);
	}
}