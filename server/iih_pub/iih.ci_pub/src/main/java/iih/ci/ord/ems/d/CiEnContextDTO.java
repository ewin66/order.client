package iih.ci.ord.ems.d;

import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.securityfw.switchdept.d.PsnInfo;

/**
 * 临床就诊上下文信息DTO DTO数据 
 * 
 */
public class CiEnContextDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 医疗单应用场景
	 * @return Integer
	 */
	public Integer getEmsappmode() {
		return ((Integer) getAttrVal("Emsappmode"));
	}
	/**
	 * 医疗单应用场景
	 * @param Emsappmode
	 */
	public void setEmsappmode(Integer Emsappmode) {
		setAttrVal("Emsappmode", Emsappmode);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	 * 主医保数据
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保数据
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 默认的医保计划（患者医保计划为空或是高端商保的情况）
	 * @param Id_hp_default
	 */
	public void setId_hp_default(String Id_hp_default) {
		setAttrVal("Id_hp_default", Id_hp_default);
	}
	/**
	 * 默认的医保计划（患者医保计划为空或是高端商保的情况）
	 * @return String
	 */
	public String getId_hp_default() {
		return ((String) getAttrVal("Id_hp_default"));
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_en() {
		return ((String) getAttrVal("Id_dep_en"));
	}
	/**
	 * 当前就诊科室
	 * @param Id_dep_en
	 */
	public void setId_dep_en(String Id_dep_en) {
		setAttrVal("Id_dep_en", Id_dep_en);
	}
	/**
	 * 当前就诊病区
	 * @return String
	 */
	public String getId_dep_ns() {
		return ((String) getAttrVal("Id_dep_ns"));
	}
	/**
	 * 当前就诊病区
	 * @param Id_dep_ns
	 */
	public void setId_dep_ns(String Id_dep_ns) {
		setAttrVal("Id_dep_ns", Id_dep_ns);
	}
	/**
	 * 开立科室
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医疗组
	 * @return String
	 */
	public String getId_wg_or() {
		return ((String) getAttrVal("Id_wg_or"));
	}
	/**
	 * 开立医疗组
	 * @param Id_wg_or
	 */
	public void setId_wg_or(String Id_wg_or) {
		setAttrVal("Id_wg_or", Id_wg_or);
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
	 * 患者入径标识
	 * @return FBoolean
	 */
	public FBoolean getFg_cp() {
		return ((FBoolean) getAttrVal("Fg_cp"));
	}
	/**
	 * 患者入径标识
	 * @param Fg_cp
	 */
	public void setFg_cp(FBoolean Fg_cp) {
		setAttrVal("Fg_cp", Fg_cp);
	}
	/**
	 * 本次就诊是否为医保就诊
	 * @return FBoolean
	 */
	public FBoolean getFg_hpfundpay() {
		return ((FBoolean) getAttrVal("Fg_hpfundpay"));
	}
	/**
	 * 本次就诊是否为医保就诊
	 * @param Fg_hpfundpay
	 */
	public void setFg_hpfundpay(FBoolean Fg_hpfundpay) {
		setAttrVal("Fg_hpfundpay", Fg_hpfundpay);
	}
	/**
	 * 医保患者黑白名单
	 * @return String
	 */
	public String getEu_inhpbbr() {
		return ((String) getAttrVal("Eu_inhpbbr"));
	}
	/**
	 * 医保患者黑白名单
	 * @param Eu_inhpbbr
	 */
	public void setEu_inhpbbr(String Eu_inhpbbr) {
		setAttrVal("Eu_inhpbbr", Eu_inhpbbr);
	}
	/**
	 * 保外诊断
	 * @return String
	 */
	public String getEu_hpbeyond() {
		return ((String) getAttrVal("Eu_hpbeyond"));
	}
	/**
	 * 保外诊断
	 * @param Eu_hpbeyond
	 */
	public void setEu_hpbeyond(String Eu_hpbeyond) {
		setAttrVal("Eu_hpbeyond", Eu_hpbeyond);
	}
	/**
	 * 基本医保判断结果数据信息
	 * @return String
	 */
	public String getBhpjudgerst() {
		return ((String) getAttrVal("Bhpjudgerst"));
	}
	/**
	 * 基本医保判断结果数据信息
	 * @param Bhpjudgerst
	 */
	public void setBhpjudgerst(String Bhpjudgerst) {
		setAttrVal("Bhpjudgerst", Bhpjudgerst);
	}
	/**
	 * 基本医保判断结果数据信息描述
	 * @return String
	 */
	public String getDes_bhpjudgerst() {
		return ((String) getAttrVal("Des_bhpjudgerst"));
	}
	/**
	 * 基本医保判断结果数据信息描述
	 * @param Des_bhpjudgerst
	 */
	public void setDes_bhpjudgerst(String Des_bhpjudgerst) {
		setAttrVal("Des_bhpjudgerst", Des_bhpjudgerst);
	}
	/**
	 * 医嘱来源
	 * @return String
	 */
	public String getEu_orsrcmdtp() {
		return ((String) getAttrVal("Eu_orsrcmdtp"));
	}
	/**
	 * 医嘱来源
	 * @param Eu_orsrcmdtp
	 */
	public void setEu_orsrcmdtp(String Eu_orsrcmdtp) {
		setAttrVal("Eu_orsrcmdtp", Eu_orsrcmdtp);
	}
	/**
	 * banner就诊信息
	 * @return String
	 */
	public Ent4BannerDTO getEnt4BannerDTO() {
		return ((Ent4BannerDTO) getAttrVal("Ent4BannerDTO"));
	}
	/**
	 * banner就诊信息
	 * @param Ent4bannerdto
	 */
	public void setEnt4BannerDTO(Ent4BannerDTO ent4BannerDTO) {
		setAttrVal("Ent4BannerDTO", ent4BannerDTO);
	}
	/**
	 * 集团
	 * @return String
	 */
	public GroupDO getGroup() {
		return ((GroupDO) getAttrVal("Group"));
	}
	/**
	 * 集团
	 * @param Group
	 */
	public void setGroup(GroupDO Group) {
		setAttrVal("Group", Group);
	}
	/**
	 * 组织
	 * @return String
	 */
	public OrgDO getOrg() {
		return ((OrgDO) getAttrVal("Org"));
	}
	/**
	 * 组织
	 * @param Org
	 */
	public void setOrg(OrgDO Org) {
		setAttrVal("Org", Org);
	}
	/**
	 * 科室
	 * @return String
	 */
	public DeptDO getDept() {
		return ((DeptDO) getAttrVal("Dept"));
	}
	/**
	 * 科室
	 * @param Dept
	 */
	public void setDept(DeptDO Dept) {
		setAttrVal("Dept", Dept);
	}
	/**
	 * 人员
	 * @return String
	 */
	public PsnInfo getPsnInfo() {
		return ((PsnInfo) getAttrVal("PsnInfo"));
	}
	/**
	 * 人员
	 * @param Psninfo
	 */
	public void setPsnInfo(PsnInfo PsnInfo) {
		setAttrVal("PsnInfo", PsnInfo);
	}
	/**
	 * 用户
	 * @return String
	 */
	public UserDO getUser() {
		return ((UserDO) getAttrVal("User"));
	}
	/**
	 * 用户
	 * @param User
	 */
	public void setUser(UserDO User) {
		setAttrVal("User", User);
	}
	
	/**
	 * 医嘱助手 类型  medsrv:医疗服务  templ: 医嘱模板 ,technology: 医技常规
	 * @return String
	 */
	public String getAssistant_type() {
		return ((String) getAttrVal("Assistant_type"));
	}
	/**
	 * 医嘱来源
	 * @param Eu_orsrcmdtp
	 */
	public void setAssistant_type(String Assistant_type) {
		setAttrVal("Assistant_type", Assistant_type);
	}
}