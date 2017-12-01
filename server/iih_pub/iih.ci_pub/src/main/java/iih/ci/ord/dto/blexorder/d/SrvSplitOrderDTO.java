package iih.ci.ord.dto.blexorder.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 执行与记费服务拆解医嘱信息DTO DTO数据 
 * 
 */
public class SrvSplitOrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 婴儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bb() {
		return ((FBoolean) getAttrVal("Fg_bb"));
	}	
	/**
	 * 婴儿标识
	 * @param Fg_bb
	 */
	public void setFg_bb(FBoolean Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 婴儿序号
	 * @return Integer
	 */
	public Integer getNo_bb() {
		return ((Integer) getAttrVal("No_bb"));
	}	
	/**
	 * 婴儿序号
	 * @param No_bb
	 */
	public void setNo_bb(Integer No_bb) {
		setAttrVal("No_bb", No_bb);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱备注
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 医嘱备注
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getId_orsrvtp() {
		return ((String) getAttrVal("Id_orsrvtp"));
	}	
	/**
	 * 医嘱类型
	 * @param Id_orsrvtp
	 */
	public void setId_orsrvtp(String Id_orsrvtp) {
		setAttrVal("Id_orsrvtp", Id_orsrvtp);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getSd_orsrvtp() {
		return ((String) getAttrVal("Sd_orsrvtp"));
	}	
	/**
	 * 医嘱类型编码
	 * @param Sd_orsrvtp
	 */
	public void setSd_orsrvtp(String Sd_orsrvtp) {
		setAttrVal("Sd_orsrvtp", Sd_orsrvtp);
	}
	/**
	 * 医嘱状态
	 * @return String
	 */
	public String getId_su_or() {
		return ((String) getAttrVal("Id_su_or"));
	}	
	/**
	 * 医嘱状态
	 * @param Id_su_or
	 */
	public void setId_su_or(String Id_su_or) {
		setAttrVal("Id_su_or", Id_su_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}	
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 结束日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 失效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_invalid() {
		return ((FDateTime) getAttrVal("Dt_invalid"));
	}	
	/**
	 * 失效日期
	 * @param Dt_invalid
	 */
	public void setDt_invalid(FDateTime Dt_invalid) {
		setAttrVal("Dt_invalid", Dt_invalid);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}	
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 代煎标识
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}	
	/**
	 * 代煎标识
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
	}
	/**
	 * 医嘱付数
	 * @return Integer
	 */
	public Integer getQuan_or() {
		return ((Integer) getAttrVal("Quan_or"));
	}	
	/**
	 * 医嘱付数
	 * @param Quan_or
	 */
	public void setQuan_or(Integer Quan_or) {
		setAttrVal("Quan_or", Quan_or);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}	
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
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
	 * 床边执行标识
	 * @return FBoolean
	 */
	public FBoolean getFg_mp_bed() {
		return ((FBoolean) getAttrVal("Fg_mp_bed"));
	}	
	/**
	 * 床边执行标识
	 * @param Fg_mp_bed
	 */
	public void setFg_mp_bed(FBoolean Fg_mp_bed) {
		setAttrVal("Fg_mp_bed", Fg_mp_bed);
	}
	/**
	 * 停止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_stop() {
		return ((FDateTime) getAttrVal("Dt_stop"));
	}	
	/**
	 * 停止日期
	 * @param Dt_stop
	 */
	public void setDt_stop(FDateTime Dt_stop) {
		setAttrVal("Dt_stop", Dt_stop);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_pati() {
		return ((String) getAttrVal("Name_pati"));
	}	
	/**
	 * 姓名
	 * @param Name_pati
	 */
	public void setName_pati(String Name_pati) {
		setAttrVal("Name_pati", Name_pati);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getGender() {
		return ((String) getAttrVal("Gender"));
	}	
	/**
	 * 性别
	 * @param Gender
	 */
	public void setGender(String Gender) {
		setAttrVal("Gender", Gender);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getNo_bed() {
		return ((String) getAttrVal("No_bed"));
	}	
	/**
	 * 床号
	 * @param No_bed
	 */
	public void setNo_bed(String No_bed) {
		setAttrVal("No_bed", No_bed);
	}
	/**
	 * 附属信息
	 * @return FMap
	 */
	public FMap getOrattachinfos() {
		return ((FMap) getAttrVal("Orattachinfos"));
	}	
	/**
	 * 附属信息
	 * @param Orattachinfos
	 */
	public void setOrattachinfos(FMap Orattachinfos) {
		setAttrVal("Orattachinfos", Orattachinfos);
	}
	/**
	 * 医嘱服务项目
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}	
	/**
	 * 医嘱服务项目
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务项目
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 服务项目
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 服务编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 服务编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 服务名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}	
	/**
	 * 服务名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 服务项目分类
	 * @return String
	 */
	public String getId_srvca() {
		return ((String) getAttrVal("Id_srvca"));
	}	
	/**
	 * 服务项目分类
	 * @param Id_srvca
	 */
	public void setId_srvca(String Id_srvca) {
		setAttrVal("Id_srvca", Id_srvca);
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
	 * 医学单位
	 * @return String
	 */
	public String getId_medu() {
		return ((String) getAttrVal("Id_medu"));
	}	
	/**
	 * 医学单位
	 * @param Id_medu
	 */
	public void setId_medu(String Id_medu) {
		setAttrVal("Id_medu", Id_medu);
	}
	/**
	 * 数值_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_medu() {
		return ((FDouble) getAttrVal("Quan_medu"));
	}	
	/**
	 * 数值_医学单位
	 * @param Quan_medu
	 */
	public void setQuan_medu(FDouble Quan_medu) {
		setAttrVal("Quan_medu", Quan_medu);
	}
	/**
	 * 出院带药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_pres_outp() {
		return ((FBoolean) getAttrVal("Fg_pres_outp"));
	}	
	/**
	 * 出院带药标识
	 * @param Fg_pres_outp
	 */
	public void setFg_pres_outp(FBoolean Fg_pres_outp) {
		setAttrVal("Fg_pres_outp", Fg_pres_outp);
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
	 * 收费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}	
	/**
	 * 收费标识
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
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
	 * 不规则剂量标识
	 * @return FBoolean
	 */
	public FBoolean getFg_dose_anoma() {
		return ((FBoolean) getAttrVal("Fg_dose_anoma"));
	}	
	/**
	 * 不规则剂量标识
	 * @param Fg_dose_anoma
	 */
	public void setFg_dose_anoma(FBoolean Fg_dose_anoma) {
		setAttrVal("Fg_dose_anoma", Fg_dose_anoma);
	}
	/**
	 * 最近生成日期（医嘱项目）
	 * @return FDateTime
	 */
	public FDateTime getDt_last_bl() {
		return ((FDateTime) getAttrVal("Dt_last_bl"));
	}	
	/**
	 * 最近生成日期（医嘱项目）
	 * @param Dt_last_bl
	 */
	public void setDt_last_bl(FDateTime Dt_last_bl) {
		setAttrVal("Dt_last_bl", Dt_last_bl);
	}
	/**
	 * 最近执行日期
	 * @return FDateTime
	 */
	public FDateTime getDt_last_mp() {
		return ((FDateTime) getAttrVal("Dt_last_mp"));
	}	
	/**
	 * 最近执行日期
	 * @param Dt_last_mp
	 */
	public void setDt_last_mp(FDateTime Dt_last_mp) {
		setAttrVal("Dt_last_mp", Dt_last_mp);
	}
	/**
	 * 执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	/**
	 * 执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 医嘱服务执行状态
	 * @return String
	 */
	public String getOrsrv_su_mp() {
		return ((String) getAttrVal("Orsrv_su_mp"));
	}	
	/**
	 * 医嘱服务执行状态
	 * @param Orsrv_su_mp
	 */
	public void setOrsrv_su_mp(String Orsrv_su_mp) {
		setAttrVal("Orsrv_su_mp", Orsrv_su_mp);
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
	 * 包装单位_基本
	 * @return String
	 */
	public String getId_pkgu_base() {
		return ((String) getAttrVal("Id_pkgu_base"));
	}	
	/**
	 * 包装单位_基本
	 * @param Id_pkgu_base
	 */
	public void setId_pkgu_base(String Id_pkgu_base) {
		setAttrVal("Id_pkgu_base", Id_pkgu_base);
	}
	/**
	 * 包装单位_当前
	 * @return String
	 */
	public String getId_pkgu_cur() {
		return ((String) getAttrVal("Id_pkgu_cur"));
	}	
	/**
	 * 包装单位_当前
	 * @param Id_pkgu_cur
	 */
	public void setId_pkgu_cur(String Id_pkgu_cur) {
		setAttrVal("Id_pkgu_cur", Id_pkgu_cur);
	}
	/**
	 * 换算系数
	 * @return FDouble
	 */
	public FDouble getFactor() {
		return ((FDouble) getAttrVal("Factor"));
	}	
	/**
	 * 换算系数
	 * @param Factor
	 */
	public void setFactor(FDouble Factor) {
		setAttrVal("Factor", Factor);
	}
	/**
	 * 系数_医疗基本
	 * @return FDouble
	 */
	public FDouble getFactor_mb() {
		return ((FDouble) getAttrVal("Factor_mb"));
	}	
	/**
	 * 系数_医疗基本
	 * @param Factor_mb
	 */
	public void setFactor_mb(FDouble Factor_mb) {
		setAttrVal("Factor_mb", Factor_mb);
	}
	/**
	 * 单次数量值_分子
	 * @return Integer
	 */
	public Integer getQuan_num_base() {
		return ((Integer) getAttrVal("Quan_num_base"));
	}	
	/**
	 * 单次数量值_分子
	 * @param Quan_num_base
	 */
	public void setQuan_num_base(Integer Quan_num_base) {
		setAttrVal("Quan_num_base", Quan_num_base);
	}
	/**
	 * 单次数量值_分母
	 * @return Integer
	 */
	public Integer getQuan_den_base() {
		return ((Integer) getAttrVal("Quan_den_base"));
	}	
	/**
	 * 单次数量值_分母
	 * @param Quan_den_base
	 */
	public void setQuan_den_base(Integer Quan_den_base) {
		setAttrVal("Quan_den_base", Quan_den_base);
	}
	/**
	 * 总量_当前包装
	 * @return FDouble
	 */
	public FDouble getQuan_cur() {
		return ((FDouble) getAttrVal("Quan_cur"));
	}	
	/**
	 * 总量_当前包装
	 * @param Quan_cur
	 */
	public void setQuan_cur(FDouble Quan_cur) {
		setAttrVal("Quan_cur", Quan_cur);
	}
	/**
	 * 床边剩余量_医学单位
	 * @return FDouble
	 */
	public FDouble getQuan_bed_medu() {
		return ((FDouble) getAttrVal("Quan_bed_medu"));
	}	
	/**
	 * 床边剩余量_医学单位
	 * @param Quan_bed_medu
	 */
	public void setQuan_bed_medu(FDouble Quan_bed_medu) {
		setAttrVal("Quan_bed_medu", Quan_bed_medu);
	}
	/**
	 * 参考价格_当前包装
	 * @return FDouble
	 */
	public FDouble getPrice_pgku_cur() {
		return ((FDouble) getAttrVal("Price_pgku_cur"));
	}	
	/**
	 * 参考价格_当前包装
	 * @param Price_pgku_cur
	 */
	public void setPrice_pgku_cur(FDouble Price_pgku_cur) {
		setAttrVal("Price_pgku_cur", Price_pgku_cur);
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
	 * 物品包装单位取整模式
	 * @return String
	 */
	public String getPkuroundmode() {
		return ((String) getAttrVal("Pkuroundmode"));
	}	
	/**
	 * 物品包装单位取整模式
	 * @param Pkuroundmode
	 */
	public void setPkuroundmode(String Pkuroundmode) {
		setAttrVal("Pkuroundmode", Pkuroundmode);
	}
	/**
	 * 开立日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 开立日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 开立机构
	 * @return String
	 */
	public String getId_org_create() {
		return ((String) getAttrVal("Id_org_create"));
	}	
	/**
	 * 开立机构
	 * @param Id_org_create
	 */
	public void setId_org_create(String Id_org_create) {
		setAttrVal("Id_org_create", Id_org_create);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_create() {
		return ((String) getAttrVal("Id_dep_create"));
	}	
	/**
	 * 开立科室
	 * @param Id_dep_create
	 */
	public void setId_dep_create(String Id_dep_create) {
		setAttrVal("Id_dep_create", Id_dep_create);
	}
	/**
	 * 护理病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_create() {
		return ((String) getAttrVal("Id_emp_create"));
	}	
	/**
	 * 开立医生
	 * @param Id_emp_create
	 */
	public void setId_emp_create(String Id_emp_create) {
		setAttrVal("Id_emp_create", Id_emp_create);
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
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}	
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法要求
	 * @return String
	 */
	public String getId_routedes() {
		return ((String) getAttrVal("Id_routedes"));
	}	
	/**
	 * 用法要求
	 * @param Id_routedes
	 */
	public void setId_routedes(String Id_routedes) {
		setAttrVal("Id_routedes", Id_routedes);
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
	 * 煎法要求
	 * @return String
	 */
	public String getId_boildes() {
		return ((String) getAttrVal("Id_boildes"));
	}	
	/**
	 * 煎法要求
	 * @param Id_boildes
	 */
	public void setId_boildes(String Id_boildes) {
		setAttrVal("Id_boildes", Id_boildes);
	}
	/**
	 * 频次
	 * @return String
	 */
	public String getId_freq() {
		return ((String) getAttrVal("Id_freq"));
	}	
	/**
	 * 频次
	 * @param Id_freq
	 */
	public void setId_freq(String Id_freq) {
		setAttrVal("Id_freq", Id_freq);
	}
	/**
	 * 频次周期类型
	 * @return String
	 */
	public String getId_frequnit() {
		return ((String) getAttrVal("Id_frequnit"));
	}	
	/**
	 * 频次周期类型
	 * @param Id_frequnit
	 */
	public void setId_frequnit(String Id_frequnit) {
		setAttrVal("Id_frequnit", Id_frequnit);
	}
	/**
	 * 频次周期类型编码
	 * @return String
	 */
	public String getSd_frequnit() {
		return ((String) getAttrVal("Sd_frequnit"));
	}	
	/**
	 * 频次周期类型编码
	 * @param Sd_frequnit
	 */
	public void setSd_frequnit(String Sd_frequnit) {
		setAttrVal("Sd_frequnit", Sd_frequnit);
	}
	/**
	 * 频次周期总数
	 * @return Integer
	 */
	public Integer getFrequnitcnt() {
		return ((Integer) getAttrVal("Frequnitcnt"));
	}	
	/**
	 * 频次周期总数
	 * @param Frequnitcnt
	 */
	public void setFrequnitcnt(Integer Frequnitcnt) {
		setAttrVal("Frequnitcnt", Frequnitcnt);
	}
	/**
	 * 频次周期下次数
	 * @return Integer
	 */
	public Integer getFreqcnt() {
		return ((Integer) getAttrVal("Freqcnt"));
	}	
	/**
	 * 频次周期下次数
	 * @param Freqcnt
	 */
	public void setFreqcnt(Integer Freqcnt) {
		setAttrVal("Freqcnt", Freqcnt);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}	
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 持续时间秒数
	 * @return Integer
	 */
	public Integer getDurationsec() {
		return ((Integer) getAttrVal("Durationsec"));
	}	
	/**
	 * 持续时间秒数
	 * @param Durationsec
	 */
	public void setDurationsec(Integer Durationsec) {
		setAttrVal("Durationsec", Durationsec);
	}
	/**
	 * 请领数量
	 * @return FDouble
	 */
	public FDouble getQuan_mp_ap() {
		return ((FDouble) getAttrVal("Quan_mp_ap"));
	}	
	/**
	 * 请领数量
	 * @param Quan_mp_ap
	 */
	public void setQuan_mp_ap(FDouble Quan_mp_ap) {
		setAttrVal("Quan_mp_ap", Quan_mp_ap);
	}
	/**
	 * 请领数量单位
	 * @return String
	 */
	public String getId_pkgu_ap() {
		return ((String) getAttrVal("Id_pkgu_ap"));
	}	
	/**
	 * 请领数量单位
	 * @param Id_pkgu_ap
	 */
	public void setId_pkgu_ap(String Id_pkgu_ap) {
		setAttrVal("Id_pkgu_ap", Id_pkgu_ap);
	}
	/**
	 * 请领后床边余量
	 * @return FDouble
	 */
	public FDouble getQuan_bed_ap_medu() {
		return ((FDouble) getAttrVal("Quan_bed_ap_medu"));
	}	
	/**
	 * 请领后床边余量
	 * @param Quan_bed_ap_medu
	 */
	public void setQuan_bed_ap_medu(FDouble Quan_bed_ap_medu) {
		setAttrVal("Quan_bed_ap_medu", Quan_bed_ap_medu);
	}
}