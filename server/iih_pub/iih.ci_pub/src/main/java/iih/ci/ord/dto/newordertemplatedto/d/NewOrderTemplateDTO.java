package iih.ci.ord.dto.newordertemplatedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class NewOrderTemplateDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 显示名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 频次
	 * @return FMap2
	 */
	public FMap getFreqdefdo() {
		return ((FMap) getAttrVal("Freqdefdo"));
	}
	/**
	 * 频次
	 * @param Freqdefdo
	 */
	public void setFreqdefdo(FMap Freqdefdo) {
		setAttrVal("Freqdefdo", Freqdefdo);
	}
	/**
	 * 剂量单位
	 * @return FMap2
	 */
	public FMap getMeasdocdo() {
		return ((FMap) getAttrVal("Measdocdo"));
	}
	/**
	 * 剂量单位
	 * @param Measdocdo
	 */
	public void setMeasdocdo(FMap Measdocdo) {
		setAttrVal("Measdocdo", Measdocdo);
	}
	/**
	 * 模板项目
	 * @return FMap
	 */
	public FMap getItem() {
		return ((FMap) getAttrVal("Item"));
	}
	/**
	 * 模板项目
	 * @param Item
	 */
	public void setItem(FMap Item) {
		setAttrVal("Item", Item);
	}
	/**
	 * 模板明细集合
	 * @return FArrayList
	 */
	public FArrayList getItemlist() {
		return ((FArrayList) getAttrVal("Itemlist"));
	}
	/**
	 * 模板明细集合
	 * @param Itemlist
	 */
	public void setItemlist(FArrayList Itemlist) {
		setAttrVal("Itemlist", Itemlist);
	}
	/**
	 * 页面标志（Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品),  4 :其它）
	 * @return String
	 */
	public String getUi_flag() {
		return ((String) getAttrVal("Ui_flag"));
	}
	/**
	 * 页面标志（Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品),  4 :其它）
	 * @param Ui_flag
	 */
	public void setUi_flag(String Ui_flag) {
		setAttrVal("Ui_flag", Ui_flag);
	}
	/**
	 * 备用
	 * @return String
	 */
	public String getStr() {
		return ((String) getAttrVal("Str"));
	}
	/**
	 * 备用
	 * @param Str
	 */
	public void setStr(String Str) {
		setAttrVal("Str", Str);
	}
	/**
	 * 备用2
	 * @return String
	 */
	public String getStr2() {
		return ((String) getAttrVal("Str2"));
	}
	/**
	 * 备用2
	 * @param Str2
	 */
	public void setStr2(String Str2) {
		setAttrVal("Str2", Str2);
	}
	/**
	 * 备用3
	 * @return String
	 */
	public String getStr3() {
		return ((String) getAttrVal("Str3"));
	}
	/**
	 * 备用3
	 * @param Str3
	 */
	public void setStr3(String Str3) {
		setAttrVal("Str3", Str3);
	}
	/**
	 * 模板类型
	 * @return FBoolean
	 */
	public FBoolean getTemplatetype() {
		return ((FBoolean) getAttrVal("Templatetype"));
	}
	/**
	 * 模板类型
	 * @param Templatetype
	 */
	public void setTemplatetype(FBoolean Templatetype) {
		setAttrVal("Templatetype", Templatetype);
	}
	/**
	 * 草药用法id
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 草药用法id
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 草药用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 草药用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
	}
	/**
	 * 草药频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}
	/**
	 * 草药频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次名称
	 * @return String
	 */
	public String getName_freq() {
		return ((String) getAttrVal("Name_freq"));
	}
	/**
	 * 频次名称
	 * @param Name_freq
	 */
	public void setName_freq(String Name_freq) {
		setAttrVal("Name_freq", Name_freq);
	}
	/**
	 * 煎法
	 * @return String
	 */
	public String getId_boil() {
		return ((String) getAttrVal("Id_boil"));
	}
	/**
	 * 煎法
	 * @param Id_boil
	 */
	public void setId_boil(String Id_boil) {
		setAttrVal("Id_boil", Id_boil);
	}
	/**
	 * 煎法名称
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法名称
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 煎法集合
	 * @return FMap2
	 */
	public FMap getBoildo() {
		return ((FMap) getAttrVal("Boildo"));
	}
	/**
	 * 煎法集合
	 * @param Boildo
	 */
	public void setBoildo(FMap Boildo) {
		setAttrVal("Boildo", Boildo);
	}
	/**
	 * 用法集合
	 * @return FMap
	 */
	public FMap getRoutedo() {
		return ((FMap) getAttrVal("Routedo"));
	}
	/**
	 * 用法集合
	 * @param Routedo
	 */
	public void setRoutedo(FMap Routedo) {
		setAttrVal("Routedo", Routedo);
	}
	/**
	 * 价格
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 价格
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getOrtplnitm_mp_name() {
		return ((String) getAttrVal("Ortplnitm_mp_name"));
	}
	/**
	 * 执行科室名称
	 * @param Ortplnitm_mp_name
	 */
	public void setOrtplnitm_mp_name(String Ortplnitm_mp_name) {
		setAttrVal("Ortplnitm_mp_name", Ortplnitm_mp_name);
	}
	/**
	 * 模板服务被启用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 模板服务被启用标识
	 * @param Fg_active
	 */	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 停用的描述信息
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}	
	/**
	 * 停用的描述信息
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
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
	 * 物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 物品id
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * 用法要求id
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}
	/**
	 * 用法要求id
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
	 * 使用天数
	 * @return String
	 */
	public Integer getDays_or() {
		return ((Integer) getAttrVal("Days_or"));
	}
	/**
	 * 使用天数
	 * @param Days_or
	 */
	public void setDays_or(Integer Days_or) {
		setAttrVal("Days_or", Days_or);
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
	 * 是否被选中
	 * @return FBoolean
	 */
	public FBoolean getFg_checked() {
		return ((FBoolean) getAttrVal("Fg_checked"));
	}
	/**
	 * 是否被选中
	 * @param Fg_checked
	 */
	public void setFg_checked(FBoolean Fg_checked) {
		setAttrVal("Fg_checked", Fg_checked);
	}
	/**
	 * 医保目录
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保目录
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 *草药剂数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 草药剂数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 剂量
	 * @return
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
	 * 剂量单位
	 * @return
	 */
	public String getOrtplnitm_unit_name() {
		return ((String) getAttrVal("Ortplnitm_unit_name"));
	}
	/**
	 * 剂量单位
	 * @param Ortplnitm_unit_name
	 */
	public void setOrtplnitm_unit_name(String Ortplnitm_unit_name) {
		setAttrVal("Ortplnitm_unit_name", Ortplnitm_unit_name);
	}
	public FBoolean getIsmulexec() {
		return ((FBoolean) getAttrVal("Ismulexec"));
	}	
	public void setIsmulexec(FBoolean Ismulexec) {
		setAttrVal("Ismulexec", Ismulexec);
	}
	public FBoolean getIsmuldose() {
		return ((FBoolean) getAttrVal("Ismuldose"));
	}	
	public void setIsmuldose(FBoolean Ismuldose) {
		setAttrVal("Ismuldose", Ismuldose);
	}
}