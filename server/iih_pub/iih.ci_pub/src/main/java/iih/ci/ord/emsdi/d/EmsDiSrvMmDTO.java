package iih.ci.ord.emsdi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗单di项目物品DTO DTO数据 
 * 
 */
public class EmsDiSrvMmDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗单di服务物品主键
	 * @return String
	 */
	public String getId_emsdisrvmm() {
		return ((String) getAttrVal("Id_emsdisrvmm"));
	}	
	/**
	 * 医疗单di服务物品主键
	 * @param Id_emsdisrvmm
	 */
	public void setId_emsdisrvmm(String Id_emsdisrvmm) {
		setAttrVal("Id_emsdisrvmm", Id_emsdisrvmm);
	}
	/**
	 * 医疗单di主键
	 * @return String
	 */
	public String getId_emsdi() {
		return ((String) getAttrVal("Id_emsdi"));
	}	
	/**
	 * 医疗单di主键
	 * @param Id_emsdi
	 */
	public void setId_emsdi(String Id_emsdi) {
		setAttrVal("Id_emsdi", Id_emsdi);
	}
	/**
	 * 医疗单di服务主键
	 * @return String
	 */
	public String getId_emsdisrv() {
		return ((String) getAttrVal("Id_emsdisrv"));
	}	
	/**
	 * 医疗单di服务主键
	 * @param Id_emsdisrv
	 */
	public void setId_emsdisrv(String Id_emsdisrv) {
		setAttrVal("Id_emsdisrv", Id_emsdisrv);
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
	 * 药品编码
	 * @return String
	 */
	public String getCode_mm() {
		return ((String) getAttrVal("Code_mm"));
	}	
	/**
	 * 药品编码
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
	 * 名称_基本单位
	 * @return String
	 */
	public String getName_unit_base() {
		return ((String) getAttrVal("Name_unit_base"));
	}	
	/**
	 * 名称_基本单位
	 * @param Name_unit_base
	 */
	public void setName_unit_base(String Name_unit_base) {
		setAttrVal("Name_unit_base", Name_unit_base);
	}
	/**
	 * 系数_医学基本
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 系数_医学基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 单次数量分子
	 * @return FDouble
	 */
	public FDouble getQuan_num_base() {
		return ((FDouble) getAttrVal("Quan_num_base"));
	}	
	/**
	 * 单次数量分子
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(FDouble Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次数量分母
	 * @return String
	 */
	public String getQuan_den_base() {
		return ((String) getAttrVal("Quan_den_base"));
	}	
	/**
	 * 单次数量分母
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(String Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 总量单位
	 * @return String
	 */
	public String getId_pgku_cur() {
		return ((String) getAttrVal("Id_pgku_cur"));
	}	
	/**
	 * 总量单位
	 * @param Id_pgku_cur
	 */
	public void setId_pgku_cur(String Id_pgku_cur) {
		setAttrVal("Id_pgku_cur", Id_pgku_cur);
	}
	/**
	 * 名称_总量单位
	 * @return String
	 */
	public String getName_pgku_cur() {
		return ((String) getAttrVal("Name_pgku_cur"));
	}	
	/**
	 * 名称_总量单位
	 * @param Name_pgku_cur
	 */
	public void setName_pgku_cur(String Name_pgku_cur) {
		setAttrVal("Name_pgku_cur", Name_pgku_cur);
	}
	/**
	 * 系数_当前基本
	 * @return FDouble
	 */
	public FDouble getFactor_cb() {
		return ((FDouble) getAttrVal("Factor_cb"));
	}	
	/**
	 * 系数_当前基本
	 * @param Factor_cb
	 */
	public void setFactor_cb(FDouble Factor_cb) {
		setAttrVal("Factor_cb", Factor_cb);
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
	 * 总量
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	/**
	 * 总量
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
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
	 * 皮试标识
	 * @return FBoolean
	 */
	public FBoolean getFg_skintest() {
		return ((FBoolean) getAttrVal("Fg_skintest"));
	}	
	/**
	 * 皮试标识
	 * @param Fg_skintest
	 */
	public void setFg_skintest(FBoolean Fg_skintest) {
		setAttrVal("Fg_skintest", Fg_skintest);
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
	 * 服务物品关联信息MAP
	 * @return FMap
	 */
	public FMap getMapinfo() {
		return ((FMap) getAttrVal("Mapinfo"));
	}	
	/**
	 * 服务物品关联信息MAP
	 * @param Mapinfo
	 */
	public void setMapinfo(FMap Mapinfo) {
		setAttrVal("Mapinfo", Mapinfo);
	}
}