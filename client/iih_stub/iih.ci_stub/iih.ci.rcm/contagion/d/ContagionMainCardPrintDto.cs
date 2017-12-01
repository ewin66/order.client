using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.d
{
    /// <summary>
    /// ContagionMainCardPrintDto 的摘要说明。
    /// </summary>
    public class ContagionMainCardPrintDto : BaseDTO {

        public ContagionMainCardPrintDto() {
 
        }

        /// <summary>
        /// 传染病报告卡id
        /// </summary>
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }

        /// <summary>
        /// 业务接口
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 父id
        /// </summary>
		public string P_id_contagion {
            get { return getAttrVal<string>("P_id_contagion",null); }
            set { setAttrVal<string>("P_id_contagion", value); }
        }

        /// <summary>
        /// 表单id
        /// </summary>
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
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
        /// 有效证件号
        /// </summary>
		public string Id_code {
            get { return getAttrVal<string>("Id_code",null); }
            set { setAttrVal<string>("Id_code", value); }
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
            get { return getAttrVal<FDate>("Zdrq",null); }
            set { setAttrVal<FDate>("Zdrq", value); }
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
        /// 工作单位(学校)
        /// </summary>
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }

        /// <summary>
        /// 联系电话
        /// </summary>
		public string Mob {
            get { return getAttrVal<string>("Mob",null); }
            set { setAttrVal<string>("Mob", value); }
        }

        /// <summary>
        /// 现住址（详填）
        /// </summary>
		public string Addr_now {
            get { return getAttrVal<string>("Addr_now",null); }
            set { setAttrVal<string>("Addr_now", value); }
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
        /// 性别
        /// </summary>
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }

        /// <summary>
        /// 性别编码
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 性别名称
        /// </summary>
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
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
        /// 集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 集团编码
        /// </summary>
		public string Sd_grp {
            get { return getAttrVal<string>("Sd_grp",null); }
            set { setAttrVal<string>("Sd_grp", value); }
        }

        /// <summary>
        /// 集团名称
        /// </summary>
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }

        /// <summary>
        /// 组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 组织编码
        /// </summary>
		public string Sd_org {
            get { return getAttrVal<string>("Sd_org",null); }
            set { setAttrVal<string>("Sd_org", value); }
        }

        /// <summary>
        /// 组织名称
        /// </summary>
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Remarks {
            get { return getAttrVal<string>("Remarks",null); }
            set { setAttrVal<string>("Remarks", value); }
        }

        /// <summary>
        /// 报卡类别4打印
        /// </summary>
		public string Cardtype {
            get { return getAttrVal<string>("Cardtype",null); }
            set { setAttrVal<string>("Cardtype", value); }
        }

        /// <summary>
        /// 年龄单位4打印
        /// </summary>
		public string Agetype {
            get { return getAttrVal<string>("Agetype",null); }
            set { setAttrVal<string>("Agetype", value); }
        }

        /// <summary>
        /// 病人属于4打印
        /// </summary>
		public string Patrelation {
            get { return getAttrVal<string>("Patrelation",null); }
            set { setAttrVal<string>("Patrelation", value); }
        }

        /// <summary>
        /// 人群分类4打印
        /// </summary>
		public string Pattype {
            get { return getAttrVal<string>("Pattype",null); }
            set { setAttrVal<string>("Pattype", value); }
        }

        /// <summary>
        /// 病例分类1
        /// </summary>
		public string Discaseone {
            get { return getAttrVal<string>("Discaseone",null); }
            set { setAttrVal<string>("Discaseone", value); }
        }

        /// <summary>
        /// 病例分类2
        /// </summary>
		public string Discasetwo {
            get { return getAttrVal<string>("Discasetwo",null); }
            set { setAttrVal<string>("Discasetwo", value); }
        }

        /// <summary>
        /// 甲类传染病4打印
        /// </summary>
		public string Jlcrb {
            get { return getAttrVal<string>("Jlcrb",null); }
            set { setAttrVal<string>("Jlcrb", value); }
        }

        /// <summary>
        /// 乙类传染病4打印
        /// </summary>
		public string Ylcrb {
            get { return getAttrVal<string>("Ylcrb",null); }
            set { setAttrVal<string>("Ylcrb", value); }
        }

        /// <summary>
        /// 丙类传染病4打印
        /// </summary>
		public string Blcrb {
            get { return getAttrVal<string>("Blcrb",null); }
            set { setAttrVal<string>("Blcrb", value); }
        }

        /// <summary>
        /// 其它传染病4打印
        /// </summary>
		public string Qtcrb {
            get { return getAttrVal<string>("Qtcrb",null); }
            set { setAttrVal<string>("Qtcrb", value); }
        }

        /// <summary>
        /// 相同症状
        /// </summary>
		public string Ishassame {
            get { return getAttrVal<string>("Ishassame",null); }
            set { setAttrVal<string>("Ishassame", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagion", "Id_mr", "Id_ent", "P_id_contagion", "Id_form", "Code", "Eu_bklb", "Eu_bklb_code", "Eu_bklb_name", "Id_con_cardsu", "Sd_con_cardsu", "Name_con_cardsu", "Name", "Id_code", "Revised_name", "Retreat_reason", "Report_unit", "Report_unit_code", "Report_unit_name", "Doctor_card", "Eu_jlcrb", "Eu_jlcrb_code", "Eu_jlcrb_name", "Eu_ylcrb", "Eu_ylcrb_code", "Eu_ylcrb_name", "Eu_blcrb", "Eu_blcrb_code", "Eu_blcrb_name", "Id_other_diseases", "Sd_other_diseases", "Name_other_diseases", "Is_alike", "Eu_blfl", "Eu_blfl_code", "Eu_blfl_name", "Eu_brsy", "Eu_brsy_code", "Eu_brsy_name", "Eu_rqfl", "Eu_rqfl_code", "Eu_rqfl_name", "Hzjzxm", "Fbrq", "Zdrq", "Swrq", "Eu_nldw", "Eu_nldw_code", "Eu_nldw_name", "Id_emp_entry", "Sd_emp_entry", "Name_emp_entry", "Exact_age", "Workunit", "Mob", "Addr_now", "Id_province", "Sd_province", "Name_province", "Street", "Village", "Housenum", "Id_sex", "Sd_sex", "Name_sex", "Dt_birth", "Dt_contagion", "Tel", "Id_grp", "Sd_grp", "Name_grp", "Id_org", "Sd_org", "Name_org", "Remarks", "Cardtype", "Agetype", "Patrelation", "Pattype", "Discaseone", "Discasetwo", "Jlcrb", "Ylcrb", "Blcrb", "Qtcrb", "Ishassame"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.d.ContagionMainCardPrintDto";
        }
    }
}
