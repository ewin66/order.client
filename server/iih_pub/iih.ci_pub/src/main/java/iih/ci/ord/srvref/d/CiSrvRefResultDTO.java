package iih.ci.ord.srvref.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 临床医嘱服务参照查询结果DTO DTO数据 
 * 
 */
public class CiSrvRefResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务主键
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务主键
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getSrvname() {
		return ((String) getAttrVal("Srvname"));
	}
	/**
	 * 服务名称
	 * @param Srvname
	 */
	public void setSrvname(String Srvname) {
		setAttrVal("Srvname", Srvname);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getSrvcode() {
		return ((String) getAttrVal("Srvcode"));
	}
	/**
	 * 服务编码
	 * @param Srvcode
	 */
	public void setSrvcode(String Srvcode) {
		setAttrVal("Srvcode", Srvcode);
	}
	/**
	 * 服务分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}
	/**
	 * 服务分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
	}
	/**
	 * 服务分类名称
	 * @return String
	 */
	public String getSrvcaname() {
		return ((String) getAttrVal("Srvcaname"));
	}
	/**
	 * 服务分类名称
	 * @param Srvcaname
	 */
	public void setSrvcaname(String Srvcaname) {
		setAttrVal("Srvcaname", Srvcaname);
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
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 服务类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 简称
	 * @return String
	 */
	public String getShortname() {
		return ((String) getAttrVal("Shortname"));
	}
	/**
	 * 简称
	 * @param Shortname
	 */
	public void setShortname(String Shortname) {
		setAttrVal("Shortname", Shortname);
	}
	/**
	 * 套标识
	 * @return FBoolean
	 */
	public FBoolean getFg_set() {
		return ((FBoolean) getAttrVal("Fg_set"));
	}
	/**
	 * 套标识
	 * @param Fg_set
	 */
	public void setFg_set(FBoolean Fg_set) {
		setAttrVal("Fg_set", Fg_set);
	}
	/**
	 * 服务备注信息
	 * @return String
	 */
	public String getSrvdes() {
		return ((String) getAttrVal("Srvdes"));
	}
	/**
	 * 服务备注信息
	 * @param Srvdes
	 */
	public void setSrvdes(String Srvdes) {
		setAttrVal("Srvdes", Srvdes);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getHpname() {
		return ((String) getAttrVal("Hpname"));
	}
	/**
	 * 医保计划名称
	 * @param Hpname
	 */
	public void setHpname(String Hpname) {
		setAttrVal("Hpname", Hpname);
	}
	/**
	 * 医保计划目录类型
	 * @return String
	 */
	public String getId_hpsrvtp() {
		return ((String) getAttrVal("Id_hpsrvtp"));
	}
	/**
	 * 医保计划目录类型
	 * @param Id_hpsrvtp
	 */
	public void setId_hpsrvtp(String Id_hpsrvtp) {
		setAttrVal("Id_hpsrvtp", Id_hpsrvtp);
	}
	/**
	 * 医保计划目录类型编码
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 医保计划目录类型编码
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 医保计划目录类型名称
	 * @return String
	 */
	public String getName_hpsrvtp() {
		return ((String) getAttrVal("Name_hpsrvtp"));
	}
	/**
	 * 医保计划目录类型名称
	 * @param Name_hpsrvtp
	 */
	public void setName_hpsrvtp(String Name_hpsrvtp) {
		setAttrVal("Name_hpsrvtp", Name_hpsrvtp);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getLimitreimbursecond() {
		return ((String) getAttrVal("Limitreimbursecond"));
	}
	/**
	 * 限制报销条件
	 * @param Limitreimbursecond
	 */
	public void setLimitreimbursecond(String Limitreimbursecond) {
		setAttrVal("Limitreimbursecond", Limitreimbursecond);
	}
	/**
	 * 报销比例
	 * @return FDouble
	 */
	public FDouble getReimburserate() {
		return ((FDouble) getAttrVal("Reimburserate"));
	}
	/**
	 * 报销比例
	 * @param Reimburserate
	 */
	public void setReimburserate(FDouble Reimburserate) {
		setAttrVal("Reimburserate", Reimburserate);
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
	 * 物品名称
	 * @return String
	 */
	public String getMmname() {
		return ((String) getAttrVal("Mmname"));
	}
	/**
	 * 物品名称
	 * @param Mmname
	 */
	public void setMmname(String Mmname) {
		setAttrVal("Mmname", Mmname);
	}
	/**
	 * 物品规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 物品规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 物品售价
	 * @return FDouble
	 */
	public FDouble getSalesprice() {
		return ((FDouble) getAttrVal("Salesprice"));
	}
	/**
	 * 物品售价
	 * @param Salesprice
	 */
	public void setSalesprice(FDouble Salesprice) {
		setAttrVal("Salesprice", Salesprice);
	}
	/**
	 * 售价单位
	 * @return String
	 */
	public String getSalesunitname() {
		return ((String) getAttrVal("Salesunitname"));
	}
	/**
	 * 售价单位
	 * @param Salesunitname
	 */
	public void setSalesunitname(String Salesunitname) {
		setAttrVal("Salesunitname", Salesunitname);
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
	 * 价值分类名称
	 * @return String
	 */
	public String getName_val() {
		return ((String) getAttrVal("Name_val"));
	}
	/**
	 * 价值分类名称
	 * @param Name_val
	 */
	public void setName_val(String Name_val) {
		setAttrVal("Name_val", Name_val);
	}
	/**
	 * 生产厂家
	 * @return String
	 */
	public String getName_sup() {
		return ((String) getAttrVal("Name_sup"));
	}
	/**
	 * 生产厂家
	 * @param Name_sup
	 */
	public void setName_sup(String Name_sup) {
		setAttrVal("Name_sup", Name_sup);
	}
	/**
	 * 进口分类
	 * @return String
	 */
	public String getImporttp() {
		return ((String) getAttrVal("Importtp"));
	}
	/**
	 * 进口分类
	 * @param Importtp
	 */
	public void setImporttp(String Importtp) {
		setAttrVal("Importtp", Importtp);
	}
	/**
	 * 药品产地
	 * @return String
	 */
	public String getMadeplace() {
		return ((String) getAttrVal("Madeplace"));
	}
	/**
	 * 药品产地
	 * @param Madeplace
	 */
	public void setMadeplace(String Madeplace) {
		setAttrVal("Madeplace", Madeplace);
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
	 * 药品剂型名称
	 * @return String
	 */
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}
	/**
	 * 药品剂型名称
	 * @param Name_dosage
	 */
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
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
	 * 药理分类名称
	 * @return String
	 */
	public String getName_pharm() {
		return ((String) getAttrVal("Name_pharm"));
	}
	/**
	 * 药理分类名称
	 * @param Name_pharm
	 */
	public void setName_pharm(String Name_pharm) {
		setAttrVal("Name_pharm", Name_pharm);
	}
	/**
	 * 毒麻标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pois() {
		return ((FBoolean) getAttrVal("Fg_pois"));
	}
	/**
	 * 毒麻标识
	 * @param Fg_pois
	 */
	public void setFg_pois(FBoolean Fg_pois) {
		setAttrVal("Fg_pois", Fg_pois);
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
	 * 毒麻分类名称
	 * @return String
	 */
	public String getName_pois() {
		return ((String) getAttrVal("Name_pois"));
	}
	/**
	 * 毒麻分类名称
	 * @param Name_pois
	 */
	public void setName_pois(String Name_pois) {
		setAttrVal("Name_pois", Name_pois);
	}
	/**
	 * 抗菌药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_anti() {
		return ((FBoolean) getAttrVal("Fg_anti"));
	}
	/**
	 * 抗菌药标识
	 * @param Fg_anti
	 */
	public void setFg_anti(FBoolean Fg_anti) {
		setAttrVal("Fg_anti", Fg_anti);
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
	 * 抗菌药分类名称
	 * @return String
	 */
	public String getName_anti() {
		return ((String) getAttrVal("Name_anti"));
	}
	/**
	 * 抗菌药分类名称
	 * @param Name_anti
	 */
	public void setName_anti(String Name_anti) {
		setAttrVal("Name_anti", Name_anti);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getId_opclass() {
		return ((String) getAttrVal("Id_opclass"));
	}
	/**
	 * 手术级别
	 * @param Id_opclass
	 */
	public void setId_opclass(String Id_opclass) {
		setAttrVal("Id_opclass", Id_opclass);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_opclass() {
		return ((String) getAttrVal("Sd_opclass"));
	}
	/**
	 * 手术级别编码
	 * @param Sd_opclass
	 */
	public void setSd_opclass(String Sd_opclass) {
		setAttrVal("Sd_opclass", Sd_opclass);
	}
	/**
	 * 手术级别名称
	 * @return String
	 */
	public String getName_opclass() {
		return ((String) getAttrVal("Name_opclass"));
	}
	/**
	 * 手术级别名称
	 * @param Name_opclass
	 */
	public void setName_opclass(String Name_opclass) {
		setAttrVal("Name_opclass", Name_opclass);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}
	/**
	 * 切口等级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}
	/**
	 * 切口等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 切口等级名称
	 * @return String
	 */
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}
	/**
	 * 切口等级名称
	 * @param Name_incitp
	 */
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	/**
	 * 新开展手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_new_sug() {
		return ((FBoolean) getAttrVal("Fg_new_sug"));
	}
	/**
	 * 新开展手术标识
	 * @param Fg_new_sug
	 */
	public void setFg_new_sug(FBoolean Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 标本类型
	 * @return String
	 */
	public String getId_samptp() {
		return ((String) getAttrVal("Id_samptp"));
	}
	/**
	 * 标本类型
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
	 * 标本类型名称
	 * @return String
	 */
	public String getName_samptp() {
		return ((String) getAttrVal("Name_samptp"));
	}
	/**
	 * 标本类型名称
	 * @param Name_samptp
	 */
	public void setName_samptp(String Name_samptp) {
		setAttrVal("Name_samptp", Name_samptp);
	}
	/**
	 * 检查部位
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}
	/**
	 * 检查部位
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 检查部位编码
	 * @return String
	 */
	public String getSd_body() {
		return ((String) getAttrVal("Sd_body"));
	}
	/**
	 * 检查部位编码
	 * @param Sd_body
	 */
	public void setSd_body(String Sd_body) {
		setAttrVal("Sd_body", Sd_body);
	}
	/**
	 * 检查部位名称
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}
	/**
	 * 检查部位名称
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 检查体位
	 * @return String
	 */
	public String getId_pos() {
		return ((String) getAttrVal("Id_pos"));
	}
	/**
	 * 检查体位
	 * @param Id_pos
	 */
	public void setId_pos(String Id_pos) {
		setAttrVal("Id_pos", Id_pos);
	}
	/**
	 * 检查体位编码
	 * @return String
	 */
	public String getSd_pos() {
		return ((String) getAttrVal("Sd_pos"));
	}
	/**
	 * 检查体位编码
	 * @param Sd_pos
	 */
	public void setSd_pos(String Sd_pos) {
		setAttrVal("Sd_pos", Sd_pos);
	}
	/**
	 * 检查体位名称
	 * @return String
	 */
	public String getName_pos() {
		return ((String) getAttrVal("Name_pos"));
	}
	/**
	 * 检查体位名称
	 * @param Name_pos
	 */
	public void setName_pos(String Name_pos) {
		setAttrVal("Name_pos", Name_pos);
	}
	/**
	 * 描述信息
	 * @return String
	 */
	public String getSrvrefdes() {
		return ((String) getAttrVal("Srvrefdes"));
	}
	/**
	 * 描述信息
	 * @param Srvrefdes
	 */
	public void setSrvrefdes(String Srvrefdes) {
		setAttrVal("Srvrefdes", Srvrefdes);
	}
}