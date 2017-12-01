using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatinfodto.d
{
    /// <summary>
    /// CiMrPatInfoDTO 的摘要说明。
    /// </summary>
    public class CiMrPatInfoDTO : BaseDTO {

        public CiMrPatInfoDTO() {
 
        }

        /// <summary>
        /// 就诊ID
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊类型id
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型名称
        /// </summary>
		public string Name_entp {
            get { return getAttrVal<string>("Name_entp",null); }
            set { setAttrVal<string>("Name_entp", value); }
        }

        /// <summary>
        /// 门诊次数
        /// </summary>
		public string Times_op {
            get { return getAttrVal<string>("Times_op",null); }
            set { setAttrVal<string>("Times_op", value); }
        }

        /// <summary>
        /// 住院次数
        /// </summary>
		public string Times_ip {
            get { return getAttrVal<string>("Times_ip",null); }
            set { setAttrVal<string>("Times_ip", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Code_ent {
            get { return getAttrVal<string>("Code_ent",null); }
            set { setAttrVal<string>("Code_ent", value); }
        }

        /// <summary>
        /// 住院号
        /// </summary>
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 患者编码
        /// </summary>
		public string Code_pat {
            get { return getAttrVal<string>("Code_pat",null); }
            set { setAttrVal<string>("Code_pat", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 性别id
        /// </summary>
		public string Id_sex_pat {
            get { return getAttrVal<string>("Id_sex_pat",null); }
            set { setAttrVal<string>("Id_sex_pat", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Name_sex_pat {
            get { return getAttrVal<string>("Name_sex_pat",null); }
            set { setAttrVal<string>("Name_sex_pat", value); }
        }

        /// <summary>
        /// 证件类型id
        /// </summary>
		public string Id_idtp {
            get { return getAttrVal<string>("Id_idtp",null); }
            set { setAttrVal<string>("Id_idtp", value); }
        }

        /// <summary>
        /// 证件类型
        /// </summary>
		public string Name_idtp {
            get { return getAttrVal<string>("Name_idtp",null); }
            set { setAttrVal<string>("Name_idtp", value); }
        }

        /// <summary>
        /// 证件号码
        /// </summary>
		public string Id_code {
            get { return getAttrVal<string>("Id_code",null); }
            set { setAttrVal<string>("Id_code", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 婚姻状况id
        /// </summary>
		public string Id_mari_pat {
            get { return getAttrVal<string>("Id_mari_pat",null); }
            set { setAttrVal<string>("Id_mari_pat", value); }
        }

        /// <summary>
        /// 婚姻状况
        /// </summary>
		public string Name_mari_pat {
            get { return getAttrVal<string>("Name_mari_pat",null); }
            set { setAttrVal<string>("Name_mari_pat", value); }
        }

        /// <summary>
        /// 民族id
        /// </summary>
		public string Id_nation {
            get { return getAttrVal<string>("Id_nation",null); }
            set { setAttrVal<string>("Id_nation", value); }
        }

        /// <summary>
        /// 民族
        /// </summary>
		public string Name_nation {
            get { return getAttrVal<string>("Name_nation",null); }
            set { setAttrVal<string>("Name_nation", value); }
        }

        /// <summary>
        /// 国家id
        /// </summary>
		public string Id_country {
            get { return getAttrVal<string>("Id_country",null); }
            set { setAttrVal<string>("Id_country", value); }
        }

        /// <summary>
        /// 国家
        /// </summary>
		public string Name_country {
            get { return getAttrVal<string>("Name_country",null); }
            set { setAttrVal<string>("Name_country", value); }
        }

        /// <summary>
        /// 职业id
        /// </summary>
		public string Id_occu {
            get { return getAttrVal<string>("Id_occu",null); }
            set { setAttrVal<string>("Id_occu", value); }
        }

        /// <summary>
        /// 职业
        /// </summary>
		public string Name_occu {
            get { return getAttrVal<string>("Name_occu",null); }
            set { setAttrVal<string>("Name_occu", value); }
        }

        /// <summary>
        /// 患者分类id
        /// </summary>
		public string Id_patca {
            get { return getAttrVal<string>("Id_patca",null); }
            set { setAttrVal<string>("Id_patca", value); }
        }

        /// <summary>
        /// 患者分类
        /// </summary>
		public string Name_patca {
            get { return getAttrVal<string>("Name_patca",null); }
            set { setAttrVal<string>("Name_patca", value); }
        }

        /// <summary>
        /// 患者价格分类id
        /// </summary>
		public string Id_pripat {
            get { return getAttrVal<string>("Id_pripat",null); }
            set { setAttrVal<string>("Id_pripat", value); }
        }

        /// <summary>
        /// 患者价格分类
        /// </summary>
		public string Name_pripat {
            get { return getAttrVal<string>("Name_pripat",null); }
            set { setAttrVal<string>("Name_pripat", value); }
        }

        /// <summary>
        /// 患者信用分类id
        /// </summary>
		public string Id_patcret {
            get { return getAttrVal<string>("Id_patcret",null); }
            set { setAttrVal<string>("Id_patcret", value); }
        }

        /// <summary>
        /// 患者信用分类
        /// </summary>
		public string Name_patcret {
            get { return getAttrVal<string>("Name_patcret",null); }
            set { setAttrVal<string>("Name_patcret", value); }
        }

        /// <summary>
        /// 主医保计划id
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 主医保计划
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 主医保卡号
        /// </summary>
		public string No_hp {
            get { return getAttrVal<string>("No_hp",null); }
            set { setAttrVal<string>("No_hp", value); }
        }

        /// <summary>
        /// 联系电话
        /// </summary>
		public string Tel_num {
            get { return getAttrVal<string>("Tel_num",null); }
            set { setAttrVal<string>("Tel_num", value); }
        }

        /// <summary>
        /// 出生地址
        /// </summary>
		public string Addr_born {
            get { return getAttrVal<string>("Addr_born",null); }
            set { setAttrVal<string>("Addr_born", value); }
        }

        /// <summary>
        /// 籍贯
        /// </summary>
		public string Addr_originc {
            get { return getAttrVal<string>("Addr_originc",null); }
            set { setAttrVal<string>("Addr_originc", value); }
        }

        /// <summary>
        /// 工作单位
        /// </summary>
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }

        /// <summary>
        /// 工作地址
        /// </summary>
		public string Addr_work {
            get { return getAttrVal<string>("Addr_work",null); }
            set { setAttrVal<string>("Addr_work", value); }
        }

        /// <summary>
        /// 工作地址电话
        /// </summary>
		public string Del_addr_work {
            get { return getAttrVal<string>("Del_addr_work",null); }
            set { setAttrVal<string>("Del_addr_work", value); }
        }

        /// <summary>
        /// 工作地邮编
        /// </summary>
		public string Zip_addr_work {
            get { return getAttrVal<string>("Zip_addr_work",null); }
            set { setAttrVal<string>("Zip_addr_work", value); }
        }

        /// <summary>
        /// 联系人
        /// </summary>
		public string Name_cont {
            get { return getAttrVal<string>("Name_cont",null); }
            set { setAttrVal<string>("Name_cont", value); }
        }

        /// <summary>
        /// 联系人类型id
        /// </summary>
		public string Id_conttp {
            get { return getAttrVal<string>("Id_conttp",null); }
            set { setAttrVal<string>("Id_conttp", value); }
        }

        /// <summary>
        /// 联系人类型
        /// </summary>
		public string Name_conttp {
            get { return getAttrVal<string>("Name_conttp",null); }
            set { setAttrVal<string>("Name_conttp", value); }
        }

        /// <summary>
        /// 联系人地址
        /// </summary>
		public string Addr_cont {
            get { return getAttrVal<string>("Addr_cont",null); }
            set { setAttrVal<string>("Addr_cont", value); }
        }

        /// <summary>
        /// 联系人电话
        /// </summary>
		public string Tel_cont {
            get { return getAttrVal<string>("Tel_cont",null); }
            set { setAttrVal<string>("Tel_cont", value); }
        }

        /// <summary>
        /// 入院时间
        /// </summary>
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDate>("Dt_acpt",null); }
            set { setAttrVal<FDate>("Dt_acpt", value); }
        }

        /// <summary>
        /// 入院科室id
        /// </summary>
		public string Id_dep_phyadm {
            get { return getAttrVal<string>("Id_dep_phyadm",null); }
            set { setAttrVal<string>("Id_dep_phyadm", value); }
        }

        /// <summary>
        /// 入院科室
        /// </summary>
		public string Name_dep_phyadm {
            get { return getAttrVal<string>("Name_dep_phyadm",null); }
            set { setAttrVal<string>("Name_dep_phyadm", value); }
        }

        /// <summary>
        /// 入院病区id
        /// </summary>
		public string Id_dep_nuradm {
            get { return getAttrVal<string>("Id_dep_nuradm",null); }
            set { setAttrVal<string>("Id_dep_nuradm", value); }
        }

        /// <summary>
        /// 入院病区
        /// </summary>
		public string Name_dep_nuradm {
            get { return getAttrVal<string>("Name_dep_nuradm",null); }
            set { setAttrVal<string>("Name_dep_nuradm", value); }
        }

        /// <summary>
        /// 住院诊断
        /// </summary>
		public string Id_didef_dis {
            get { return getAttrVal<string>("Id_didef_dis",null); }
            set { setAttrVal<string>("Id_didef_dis", value); }
        }

        /// <summary>
        /// 住院诊断名称
        /// </summary>
		public string Name_didef_dis {
            get { return getAttrVal<string>("Name_didef_dis",null); }
            set { setAttrVal<string>("Name_didef_dis", value); }
        }

        /// <summary>
        /// 当前科室id
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 当前科室
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 当前病区id
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 当前病区
        /// </summary>
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }

        /// <summary>
        /// 主管医生id
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 主管医生
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 责任护士id
        /// </summary>
		public string Id_emp_nur {
            get { return getAttrVal<string>("Id_emp_nur",null); }
            set { setAttrVal<string>("Id_emp_nur", value); }
        }

        /// <summary>
        /// 责任护士
        /// </summary>
		public string Name_emp_nur {
            get { return getAttrVal<string>("Name_emp_nur",null); }
            set { setAttrVal<string>("Name_emp_nur", value); }
        }

        /// <summary>
        /// 床位id
        /// </summary>
		public string Id_bed {
            get { return getAttrVal<string>("Id_bed",null); }
            set { setAttrVal<string>("Id_bed", value); }
        }

        /// <summary>
        /// 床位
        /// </summary>
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }

        /// <summary>
        /// 护理等级id
        /// </summary>
		public string Id_level_nur {
            get { return getAttrVal<string>("Id_level_nur",null); }
            set { setAttrVal<string>("Id_level_nur", value); }
        }

        /// <summary>
        /// 护理等级
        /// </summary>
		public string Name_level_nurname65 {
            get { return getAttrVal<string>("Name_level_nurname65",null); }
            set { setAttrVal<string>("Name_level_nurname65", value); }
        }

        /// <summary>
        /// 病情等级id
        /// </summary>
		public string Id_level_dise {
            get { return getAttrVal<string>("Id_level_dise",null); }
            set { setAttrVal<string>("Id_level_dise", value); }
        }

        /// <summary>
        /// 病情等级
        /// </summary>
		public string Name_level_dise {
            get { return getAttrVal<string>("Name_level_dise",null); }
            set { setAttrVal<string>("Name_level_dise", value); }
        }

        /// <summary>
        /// 新生儿标志
        /// </summary>
		public string Fg_newborn {
            get { return getAttrVal<string>("Fg_newborn",null); }
            set { setAttrVal<string>("Fg_newborn", value); }
        }

        /// <summary>
        /// 住院天数
        /// </summary>
		public string Inhosdays {
            get { return getAttrVal<string>("Inhosdays",null); }
            set { setAttrVal<string>("Inhosdays", value); }
        }

        /// <summary>
        /// 出院病区id
        /// </summary>
		public string Id_dep_nurdisc {
            get { return getAttrVal<string>("Id_dep_nurdisc",null); }
            set { setAttrVal<string>("Id_dep_nurdisc", value); }
        }

        /// <summary>
        /// 出院病区
        /// </summary>
		public string Name_dep_nurdisc {
            get { return getAttrVal<string>("Name_dep_nurdisc",null); }
            set { setAttrVal<string>("Name_dep_nurdisc", value); }
        }

        /// <summary>
        /// 出院科室id
        /// </summary>
		public string Id_dep_phydisc {
            get { return getAttrVal<string>("Id_dep_phydisc",null); }
            set { setAttrVal<string>("Id_dep_phydisc", value); }
        }

        /// <summary>
        /// 出院科室
        /// </summary>
		public string Name_dep_phydisc {
            get { return getAttrVal<string>("Name_dep_phydisc",null); }
            set { setAttrVal<string>("Name_dep_phydisc", value); }
        }

        /// <summary>
        /// 出院时间
        /// </summary>
		public DateTime? Dt_outhos {
            get { return getAttrVal<FDateTime>("Dt_outhos",null); }
            set { setAttrVal<FDateTime>("Dt_outhos", value); }
        }

        /// <summary>
        /// 在院标志
        /// </summary>
		public string Fg_ip {
            get { return getAttrVal<string>("Fg_ip",null); }
            set { setAttrVal<string>("Fg_ip", value); }
        }

        /// <summary>
        /// 死亡时间
        /// </summary>
		public DateTime? Dt_death {
            get { return getAttrVal<FDateTime>("Dt_death",null); }
            set { setAttrVal<FDateTime>("Dt_death", value); }
        }

        /// <summary>
        /// 域id
        /// </summary>
		public string Id_pre {
            get { return getAttrVal<string>("Id_pre",null); }
            set { setAttrVal<string>("Id_pre", value); }
        }

        /// <summary>
        /// 医疗机构编码
        /// </summary>
		public string Code_org {
            get { return getAttrVal<string>("Code_org",null); }
            set { setAttrVal<string>("Code_org", value); }
        }

        /// <summary>
        /// 医疗机构名称
        /// </summary>
		public string Org {
            get { return getAttrVal<string>("Org",null); }
            set { setAttrVal<string>("Org", value); }
        }

        /// <summary>
        /// 卡片编号
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 报卡类别
        /// </summary>
		public string Eu_bklb {
            get { return getAttrVal<string>("Eu_bklb",null); }
            set { setAttrVal<string>("Eu_bklb", value); }
        }

        /// <summary>
        /// 报卡类别编码
        /// </summary>
		public string Eu_bklb_code {
            get { return getAttrVal<string>("Eu_bklb_code",null); }
            set { setAttrVal<string>("Eu_bklb_code", value); }
        }

        /// <summary>
        /// 报卡类别名称
        /// </summary>
		public string Eu_bklb_name {
            get { return getAttrVal<string>("Eu_bklb_name",null); }
            set { setAttrVal<string>("Eu_bklb_name", value); }
        }

        /// <summary>
        /// 传染卡状态
        /// </summary>
		public string Id_con_cardsu {
            get { return getAttrVal<string>("Id_con_cardsu",null); }
            set { setAttrVal<string>("Id_con_cardsu", value); }
        }

        /// <summary>
        /// 传染卡状态编码
        /// </summary>
		public string Sd_con_cardsu {
            get { return getAttrVal<string>("Sd_con_cardsu",null); }
            set { setAttrVal<string>("Sd_con_cardsu", value); }
        }

        /// <summary>
        /// 传染卡状态名称
        /// </summary>
		public string Name_con_cardsu {
            get { return getAttrVal<string>("Name_con_cardsu",null); }
            set { setAttrVal<string>("Name_con_cardsu", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 订正病名
        /// </summary>
		public string Revised_name {
            get { return getAttrVal<string>("Revised_name",null); }
            set { setAttrVal<string>("Revised_name", value); }
        }

        /// <summary>
        /// 退卡原因
        /// </summary>
		public string Retreat_reason {
            get { return getAttrVal<string>("Retreat_reason",null); }
            set { setAttrVal<string>("Retreat_reason", value); }
        }

        /// <summary>
        /// 报告单位
        /// </summary>
		public string Report_unit {
            get { return getAttrVal<string>("Report_unit",null); }
            set { setAttrVal<string>("Report_unit", value); }
        }

        /// <summary>
        /// 报告单位编码
        /// </summary>
		public string Report_unit_code {
            get { return getAttrVal<string>("Report_unit_code",null); }
            set { setAttrVal<string>("Report_unit_code", value); }
        }

        /// <summary>
        /// 报告单位名称
        /// </summary>
		public string Report_unit_name {
            get { return getAttrVal<string>("Report_unit_name",null); }
            set { setAttrVal<string>("Report_unit_name", value); }
        }

        /// <summary>
        /// 填卡医生
        /// </summary>
		public string Doctor_card {
            get { return getAttrVal<string>("Doctor_card",null); }
            set { setAttrVal<string>("Doctor_card", value); }
        }

        /// <summary>
        /// 甲类传染病
        /// </summary>
		public string Eu_jlcrb {
            get { return getAttrVal<string>("Eu_jlcrb",null); }
            set { setAttrVal<string>("Eu_jlcrb", value); }
        }

        /// <summary>
        /// 甲类传染病编码
        /// </summary>
		public string Eu_jlcrb_code {
            get { return getAttrVal<string>("Eu_jlcrb_code",null); }
            set { setAttrVal<string>("Eu_jlcrb_code", value); }
        }

        /// <summary>
        /// 甲类传染病名称
        /// </summary>
		public string Eu_jlcrb_name {
            get { return getAttrVal<string>("Eu_jlcrb_name",null); }
            set { setAttrVal<string>("Eu_jlcrb_name", value); }
        }

        /// <summary>
        /// 乙类传染病
        /// </summary>
		public string Eu_ylcrb {
            get { return getAttrVal<string>("Eu_ylcrb",null); }
            set { setAttrVal<string>("Eu_ylcrb", value); }
        }

        /// <summary>
        /// 乙类传染病编码
        /// </summary>
		public string Eu_ylcrb_code {
            get { return getAttrVal<string>("Eu_ylcrb_code",null); }
            set { setAttrVal<string>("Eu_ylcrb_code", value); }
        }

        /// <summary>
        /// 乙类传染病名称
        /// </summary>
		public string Eu_ylcrb_name {
            get { return getAttrVal<string>("Eu_ylcrb_name",null); }
            set { setAttrVal<string>("Eu_ylcrb_name", value); }
        }

        /// <summary>
        /// 丙类传染病
        /// </summary>
		public string Eu_blcrb {
            get { return getAttrVal<string>("Eu_blcrb",null); }
            set { setAttrVal<string>("Eu_blcrb", value); }
        }

        /// <summary>
        /// 丙类传染病编码
        /// </summary>
		public string Eu_blcrb_code {
            get { return getAttrVal<string>("Eu_blcrb_code",null); }
            set { setAttrVal<string>("Eu_blcrb_code", value); }
        }

        /// <summary>
        /// 病类传染病名称
        /// </summary>
		public string Eu_blcrb_name {
            get { return getAttrVal<string>("Eu_blcrb_name",null); }
            set { setAttrVal<string>("Eu_blcrb_name", value); }
        }

        /// <summary>
        /// 其他传染病
        /// </summary>
		public string Id_other_diseases {
            get { return getAttrVal<string>("Id_other_diseases",null); }
            set { setAttrVal<string>("Id_other_diseases", value); }
        }

        /// <summary>
        /// 其他传染病编码
        /// </summary>
		public string Sd_other_diseases {
            get { return getAttrVal<string>("Sd_other_diseases",null); }
            set { setAttrVal<string>("Sd_other_diseases", value); }
        }

        /// <summary>
        /// 其他传染病名称
        /// </summary>
		public string Name_other_diseases {
            get { return getAttrVal<string>("Name_other_diseases",null); }
            set { setAttrVal<string>("Name_other_diseases", value); }
        }

        /// <summary>
        /// 有无相同症状
        /// </summary>
		public bool? Is_alike {
            get { return getAttrVal<FBoolean>("Is_alike",null); }
            set { setAttrVal<FBoolean>("Is_alike", value); }
        }

        /// <summary>
        /// 病例分类
        /// </summary>
		public string Eu_blfl {
            get { return getAttrVal<string>("Eu_blfl",null); }
            set { setAttrVal<string>("Eu_blfl", value); }
        }

        /// <summary>
        /// 病例分类编码
        /// </summary>
		public string Eu_blfl_code {
            get { return getAttrVal<string>("Eu_blfl_code",null); }
            set { setAttrVal<string>("Eu_blfl_code", value); }
        }

        /// <summary>
        /// 病例分类名称
        /// </summary>
		public string Eu_blfl_name {
            get { return getAttrVal<string>("Eu_blfl_name",null); }
            set { setAttrVal<string>("Eu_blfl_name", value); }
        }

        /// <summary>
        /// 病人属于
        /// </summary>
		public string Eu_brsy {
            get { return getAttrVal<string>("Eu_brsy",null); }
            set { setAttrVal<string>("Eu_brsy", value); }
        }

        /// <summary>
        /// 病人属于编码
        /// </summary>
		public string Eu_brsy_code {
            get { return getAttrVal<string>("Eu_brsy_code",null); }
            set { setAttrVal<string>("Eu_brsy_code", value); }
        }

        /// <summary>
        /// 病人属于名称
        /// </summary>
		public string Eu_brsy_name {
            get { return getAttrVal<string>("Eu_brsy_name",null); }
            set { setAttrVal<string>("Eu_brsy_name", value); }
        }

        /// <summary>
        /// 人群分类
        /// </summary>
		public string Eu_rqfl {
            get { return getAttrVal<string>("Eu_rqfl",null); }
            set { setAttrVal<string>("Eu_rqfl", value); }
        }

        /// <summary>
        /// 人群分类编码
        /// </summary>
		public string Eu_rqfl_code {
            get { return getAttrVal<string>("Eu_rqfl_code",null); }
            set { setAttrVal<string>("Eu_rqfl_code", value); }
        }

        /// <summary>
        /// 人群分类名称
        /// </summary>
		public string Eu_rqfl_name {
            get { return getAttrVal<string>("Eu_rqfl_name",null); }
            set { setAttrVal<string>("Eu_rqfl_name", value); }
        }

        /// <summary>
        /// 患者家长姓名
        /// </summary>
		public string Hzjzxm {
            get { return getAttrVal<string>("Hzjzxm",null); }
            set { setAttrVal<string>("Hzjzxm", value); }
        }

        /// <summary>
        /// 发病日期
        /// </summary>
		public DateTime? Fbrq {
            get { return getAttrVal<FDate>("Fbrq",null); }
            set { setAttrVal<FDate>("Fbrq", value); }
        }

        /// <summary>
        /// 诊断日期
        /// </summary>
		public DateTime? Zdrq {
            get { return getAttrVal<FDateTime>("Zdrq",null); }
            set { setAttrVal<FDateTime>("Zdrq", value); }
        }

        /// <summary>
        /// 死亡日期
        /// </summary>
		public DateTime? Swrq {
            get { return getAttrVal<FDate>("Swrq",null); }
            set { setAttrVal<FDate>("Swrq", value); }
        }

        /// <summary>
        /// 年龄单位
        /// </summary>
		public string Eu_nldw {
            get { return getAttrVal<string>("Eu_nldw",null); }
            set { setAttrVal<string>("Eu_nldw", value); }
        }

        /// <summary>
        /// 年龄单位编码
        /// </summary>
		public string Eu_nldw_code {
            get { return getAttrVal<string>("Eu_nldw_code",null); }
            set { setAttrVal<string>("Eu_nldw_code", value); }
        }

        /// <summary>
        /// 年龄单位名称
        /// </summary>
		public string Eu_nldw_name {
            get { return getAttrVal<string>("Eu_nldw_name",null); }
            set { setAttrVal<string>("Eu_nldw_name", value); }
        }

        /// <summary>
        /// 报卡医生
        /// </summary>
		public string Id_emp_entry {
            get { return getAttrVal<string>("Id_emp_entry",null); }
            set { setAttrVal<string>("Id_emp_entry", value); }
        }

        /// <summary>
        /// 报卡医生编码
        /// </summary>
		public string Sd_emp_entry {
            get { return getAttrVal<string>("Sd_emp_entry",null); }
            set { setAttrVal<string>("Sd_emp_entry", value); }
        }

        /// <summary>
        /// 报卡医生名称
        /// </summary>
		public string Name_emp_entry {
            get { return getAttrVal<string>("Name_emp_entry",null); }
            set { setAttrVal<string>("Name_emp_entry", value); }
        }

        /// <summary>
        /// 实足年龄
        /// </summary>
		public int? Exact_age {
            get { return getAttrVal<int?>("Exact_age",null); }
            set { setAttrVal<int?>("Exact_age", value); }
        }

        /// <summary>
        /// 患者联系电话
        /// </summary>
		public string Mob {
            get { return getAttrVal<string>("Mob",null); }
            set { setAttrVal<string>("Mob", value); }
        }

        /// <summary>
        /// 现住址
        /// </summary>
		public string Id_province {
            get { return getAttrVal<string>("Id_province",null); }
            set { setAttrVal<string>("Id_province", value); }
        }

        /// <summary>
        /// 现住址编码
        /// </summary>
		public string Sd_province {
            get { return getAttrVal<string>("Sd_province",null); }
            set { setAttrVal<string>("Sd_province", value); }
        }

        /// <summary>
        /// 现住址名称
        /// </summary>
		public string Name_province {
            get { return getAttrVal<string>("Name_province",null); }
            set { setAttrVal<string>("Name_province", value); }
        }

        /// <summary>
        /// 乡（镇、街道）
        /// </summary>
		public string Street {
            get { return getAttrVal<string>("Street",null); }
            set { setAttrVal<string>("Street", value); }
        }

        /// <summary>
        /// 村
        /// </summary>
		public string Village {
            get { return getAttrVal<string>("Village",null); }
            set { setAttrVal<string>("Village", value); }
        }

        /// <summary>
        /// （门牌号）
        /// </summary>
		public string Housenum {
            get { return getAttrVal<string>("Housenum",null); }
            set { setAttrVal<string>("Housenum", value); }
        }

        /// <summary>
        /// 户籍地址
        /// </summary>
		public string Residence_addr {
            get { return getAttrVal<string>("Residence_addr",null); }
            set { setAttrVal<string>("Residence_addr", value); }
        }

        /// <summary>
        /// 户籍地址编码
        /// </summary>
		public string Residence_code {
            get { return getAttrVal<string>("Residence_code",null); }
            set { setAttrVal<string>("Residence_code", value); }
        }

        /// <summary>
        /// 户籍地址名称
        /// </summary>
		public string Residence {
            get { return getAttrVal<string>("Residence",null); }
            set { setAttrVal<string>("Residence", value); }
        }

        /// <summary>
        /// 填卡日期
        /// </summary>
		public DateTime? Dt_contagion {
            get { return getAttrVal<FDate>("Dt_contagion",null); }
            set { setAttrVal<FDate>("Dt_contagion", value); }
        }

        /// <summary>
        /// 联系电话1
        /// </summary>
		public string Tel {
            get { return getAttrVal<string>("Tel",null); }
            set { setAttrVal<string>("Tel", value); }
        }

        /// <summary>
        /// 病情分类编码
        /// </summary>
		public string Code_eu_bqfl {
            get { return getAttrVal<string>("Code_eu_bqfl",null); }
            set { setAttrVal<string>("Code_eu_bqfl", value); }
        }

        /// <summary>
        /// 病情分类名称
        /// </summary>
		public string Name_eu_bqfl {
            get { return getAttrVal<string>("Name_eu_bqfl",null); }
            set { setAttrVal<string>("Name_eu_bqfl", value); }
        }

        /// <summary>
        /// 传染病分类编码
        /// </summary>
		public string Code_congation_type {
            get { return getAttrVal<string>("Code_congation_type",null); }
            set { setAttrVal<string>("Code_congation_type", value); }
        }

        /// <summary>
        /// 传染病分类名称
        /// </summary>
		public string Name_congation_type {
            get { return getAttrVal<string>("Name_congation_type",null); }
            set { setAttrVal<string>("Name_congation_type", value); }
        }

        /// <summary>
        /// 传染病编码
        /// </summary>
		public string Code_congationnew {
            get { return getAttrVal<string>("Code_congationnew",null); }
            set { setAttrVal<string>("Code_congationnew", value); }
        }

        /// <summary>
        /// 传染病名称
        /// </summary>
		public string Name_congationnew {
            get { return getAttrVal<string>("Name_congationnew",null); }
            set { setAttrVal<string>("Name_congationnew", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Remarks {
            get { return getAttrVal<string>("Remarks",null); }
            set { setAttrVal<string>("Remarks", value); }
        }

        /// <summary>
        /// 是否传染病
        /// </summary>
		public string Fg_crb {
            get { return getAttrVal<string>("Fg_crb",null); }
            set { setAttrVal<string>("Fg_crb", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Id_entp", "Name_entp", "Times_op", "Times_ip", "Code_ent", "Code_amr_ip", "Id_pat", "Code_pat", "Name_pat", "Id_sex_pat", "Name_sex_pat", "Id_idtp", "Name_idtp", "Id_code", "Dt_birth", "Id_mari_pat", "Name_mari_pat", "Id_nation", "Name_nation", "Id_country", "Name_country", "Id_occu", "Name_occu", "Id_patca", "Name_patca", "Id_pripat", "Name_pripat", "Id_patcret", "Name_patcret", "Id_hp", "Name_hp", "No_hp", "Tel_num", "Addr_born", "Addr_originc", "Workunit", "Addr_work", "Del_addr_work", "Zip_addr_work", "Name_cont", "Id_conttp", "Name_conttp", "Addr_cont", "Tel_cont", "Dt_acpt", "Id_dep_phyadm", "Name_dep_phyadm", "Id_dep_nuradm", "Name_dep_nuradm", "Id_didef_dis", "Name_didef_dis", "Id_dep_phy", "Name_dep_phy", "Id_dep_nur", "Name_dep_nur", "Id_emp_phy", "Name_emp_phy", "Id_emp_nur", "Name_emp_nur", "Id_bed", "Name_bed", "Id_level_nur", "Name_level_nurname65", "Id_level_dise", "Name_level_dise", "Fg_newborn", "Inhosdays", "Id_dep_nurdisc", "Name_dep_nurdisc", "Id_dep_phydisc", "Name_dep_phydisc", "Dt_outhos", "Fg_ip", "Dt_death", "Id_pre", "Code_org", "Org", "Code", "Eu_bklb", "Eu_bklb_code", "Eu_bklb_name", "Id_con_cardsu", "Sd_con_cardsu", "Name_con_cardsu", "Name", "Revised_name", "Retreat_reason", "Report_unit", "Report_unit_code", "Report_unit_name", "Doctor_card", "Eu_jlcrb", "Eu_jlcrb_code", "Eu_jlcrb_name", "Eu_ylcrb", "Eu_ylcrb_code", "Eu_ylcrb_name", "Eu_blcrb", "Eu_blcrb_code", "Eu_blcrb_name", "Id_other_diseases", "Sd_other_diseases", "Name_other_diseases", "Is_alike", "Eu_blfl", "Eu_blfl_code", "Eu_blfl_name", "Eu_brsy", "Eu_brsy_code", "Eu_brsy_name", "Eu_rqfl", "Eu_rqfl_code", "Eu_rqfl_name", "Hzjzxm", "Fbrq", "Zdrq", "Swrq", "Eu_nldw", "Eu_nldw_code", "Eu_nldw_name", "Id_emp_entry", "Sd_emp_entry", "Name_emp_entry", "Exact_age", "Mob", "Id_province", "Sd_province", "Name_province", "Street", "Village", "Housenum", "Residence_addr", "Residence_code", "Residence", "Dt_contagion", "Tel", "Code_eu_bqfl", "Name_eu_bqfl", "Code_congation_type", "Name_congation_type", "Code_congationnew", "Name_congationnew", "Remarks", "Fg_crb"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatinfodto.d.CiMrPatInfoDTO";
        }
    }
}
