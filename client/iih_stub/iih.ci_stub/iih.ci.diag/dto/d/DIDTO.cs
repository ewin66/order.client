using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.diag.dto.d
{
    /// <summary>
    /// DIDTO 的摘要说明。
    /// </summary>
    public class DIDTO : BaseDTO {

        public DIDTO() {
 
        }

        /// <summary>
        /// 诊断ID
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 基础数据诊断id
        /// </summary>
		public string Id_didef {
            get { return getAttrVal<string>("Id_didef",null); }
            set { setAttrVal<string>("Id_didef", value); }
        }

        /// <summary>
        /// 诊断编码
        /// </summary>
		public string Didef_code {
            get { return getAttrVal<string>("Didef_code",null); }
            set { setAttrVal<string>("Didef_code", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Didef_name {
            get { return getAttrVal<string>("Didef_name",null); }
            set { setAttrVal<string>("Didef_name", value); }
        }

        /// <summary>
        /// 诊断类型
        /// </summary>
		public string Id_ditp {
            get { return getAttrVal<string>("Id_ditp",null); }
            set { setAttrVal<string>("Id_ditp", value); }
        }

        /// <summary>
        /// 诊断类型编码
        /// </summary>
		public string Sd_ditp {
            get { return getAttrVal<string>("Sd_ditp",null); }
            set { setAttrVal<string>("Sd_ditp", value); }
        }

        /// <summary>
        /// 诊断类型名称
        /// </summary>
		public string Id_ditp_name {
            get { return getAttrVal<string>("Id_ditp_name",null); }
            set { setAttrVal<string>("Id_ditp_name", value); }
        }

        /// <summary>
        /// 证候诊断
        /// </summary>
		public string Id_didef_syn {
            get { return getAttrVal<string>("Id_didef_syn",null); }
            set { setAttrVal<string>("Id_didef_syn", value); }
        }

        /// <summary>
        /// 证候诊断编码
        /// </summary>
		public string Id_didef_syn_code {
            get { return getAttrVal<string>("Id_didef_syn_code",null); }
            set { setAttrVal<string>("Id_didef_syn_code", value); }
        }

        /// <summary>
        /// 证候诊断名称
        /// </summary>
		public string Id_didef_syn_name {
            get { return getAttrVal<string>("Id_didef_syn_name",null); }
            set { setAttrVal<string>("Id_didef_syn_name", value); }
        }

        /// <summary>
        /// 疑似
        /// </summary>
		public bool? Fg_suspdi {
            get { return getAttrVal<FBoolean>("Fg_suspdi",null); }
            set { setAttrVal<FBoolean>("Fg_suspdi", value); }
        }

        /// <summary>
        /// 补充说明
        /// </summary>
		public string Supplement {
            get { return getAttrVal<string>("Supplement",null); }
            set { setAttrVal<string>("Supplement", value); }
        }

        /// <summary>
        /// 诊断医生
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 医生姓名
        /// </summary>
		public string Id_emp_create_name {
            get { return getAttrVal<string>("Id_emp_create_name",null); }
            set { setAttrVal<string>("Id_emp_create_name", value); }
        }

        /// <summary>
        /// 诊断时间
        /// </summary>
		public DateTime? Dt_di {
            get { return getAttrVal<FDateTime>("Dt_di",null); }
            set { setAttrVal<FDateTime>("Dt_di", value); }
        }

        /// <summary>
        /// 西医标志
        /// </summary>
		public bool? Fg_med {
            get { return getAttrVal<FBoolean>("Fg_med",null); }
            set { setAttrVal<FBoolean>("Fg_med", value); }
        }

        /// <summary>
        /// 传染病标志
        /// </summary>
		public bool? Fg_infedi {
            get { return getAttrVal<FBoolean>("Fg_infedi",null); }
            set { setAttrVal<FBoolean>("Fg_infedi", value); }
        }

        /// <summary>
        /// 上级
        /// </summary>
		public string Id_par {
            get { return getAttrVal<string>("Id_par",null); }
            set { setAttrVal<string>("Id_par", value); }
        }

        /// <summary>
        /// 主要诊断
        /// </summary>
		public bool? Fg_majdi {
            get { return getAttrVal<FBoolean>("Fg_majdi",null); }
            set { setAttrVal<FBoolean>("Fg_majdi", value); }
        }

        /// <summary>
        /// 诊断科室
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 诊断体系编码
        /// </summary>
		public string Id_disys {
            get { return getAttrVal<string>("Id_disys",null); }
            set { setAttrVal<string>("Id_disys", value); }
        }

        /// <summary>
        /// 诊断体系名称
        /// </summary>
		public string Id_disys_name {
            get { return getAttrVal<string>("Id_disys_name",null); }
            set { setAttrVal<string>("Id_disys_name", value); }
        }

        /// <summary>
        /// 诊断体系sd
        /// </summary>
		public string Sd_disys {
            get { return getAttrVal<string>("Sd_disys",null); }
            set { setAttrVal<string>("Sd_disys", value); }
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 诊断描述
        /// </summary>
		public string Des_di {
            get { return getAttrVal<string>("Des_di",null); }
            set { setAttrVal<string>("Des_di", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 签署人
        /// </summary>
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }

        /// <summary>
        /// 签署科室
        /// </summary>
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }

        /// <summary>
        /// 签署时间
        /// </summary>
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }

        /// <summary>
        /// 签署人名称
        /// </summary>
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }

        /// <summary>
        /// 诊断标准名称
        /// </summary>
		public string Di_standard_name {
            get { return getAttrVal<string>("Di_standard_name",null); }
            set { setAttrVal<string>("Di_standard_name", value); }
        }

        /// <summary>
        /// 诊断标准
        /// </summary>
		public string Di_standard {
            get { return getAttrVal<string>("Di_standard",null); }
            set { setAttrVal<string>("Di_standard", value); }
        }

        /// <summary>
        /// 标准编码
        /// </summary>
		public string Di_standard_code {
            get { return getAttrVal<string>("Di_standard_code",null); }
            set { setAttrVal<string>("Di_standard_code", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Id_dep_create_name {
            get { return getAttrVal<string>("Id_dep_create_name",null); }
            set { setAttrVal<string>("Id_dep_create_name", value); }
        }

        /// <summary>
        /// 签署标识
        /// </summary>
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }

        /// <summary>
        /// 开立时间
        /// </summary>
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }

        /// <summary>
        /// 子表主键
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 疾病诊断id
        /// </summary>
		public string Di_disease {
            get { return getAttrVal<string>("Di_disease",null); }
            set { setAttrVal<string>("Di_disease", value); }
        }

        /// <summary>
        /// 疾病诊断名称
        /// </summary>
		public string Id_disease_name {
            get { return getAttrVal<string>("Id_disease_name",null); }
            set { setAttrVal<string>("Id_disease_name", value); }
        }

        /// <summary>
        /// 疾病诊断编码
        /// </summary>
		public string Id_disease_code {
            get { return getAttrVal<string>("Id_disease_code",null); }
            set { setAttrVal<string>("Id_disease_code", value); }
        }

        /// <summary>
        /// 自定义诊断标识
        /// </summary>
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }

        /// <summary>
        /// 内部编码
        /// </summary>
		public string Innercode {
            get { return getAttrVal<string>("Innercode",null); }
            set { setAttrVal<string>("Innercode", value); }
        }

        /// <summary>
        /// 上报标识
        /// </summary>
		public bool? Fg_ur {
            get { return getAttrVal<FBoolean>("Fg_ur",null); }
            set { setAttrVal<FBoolean>("Fg_ur", value); }
        }

        /// <summary>
        /// 慢性病标志
        /// </summary>
		public bool? Fg_chronic {
            get { return getAttrVal<FBoolean>("Fg_chronic",null); }
            set { setAttrVal<FBoolean>("Fg_chronic", value); }
        }

        /// <summary>
        /// 特种病标志
        /// </summary>
		public bool? Fg_special {
            get { return getAttrVal<FBoolean>("Fg_special",null); }
            set { setAttrVal<FBoolean>("Fg_special", value); }
        }

        /// <summary>
        /// 传染病种类
        /// </summary>
		public string Id_infectiontp {
            get { return getAttrVal<string>("Id_infectiontp",null); }
            set { setAttrVal<string>("Id_infectiontp", value); }
        }

        /// <summary>
        /// 传染病种类编码
        /// </summary>
		public string Sd_infectiontp {
            get { return getAttrVal<string>("Sd_infectiontp",null); }
            set { setAttrVal<string>("Sd_infectiontp", value); }
        }

        /// <summary>
        /// 保外诊断标识
        /// </summary>
		public string Eu_hpbeyond {
            get { return getAttrVal<string>("Eu_hpbeyond",null); }
            set { setAttrVal<string>("Eu_hpbeyond", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_di", "Id_didef", "Didef_code", "Didef_name", "Id_ditp", "Sd_ditp", "Id_ditp_name", "Id_didef_syn", "Id_didef_syn_code", "Id_didef_syn_name", "Fg_suspdi", "Supplement", "Id_emp_create", "Id_emp_create_name", "Dt_di", "Fg_med", "Fg_infedi", "Id_par", "Fg_majdi", "Id_dep", "Id_disys", "Id_disys_name", "Sd_disys", "Id_en", "Id_pat", "Id_entp", "Code_entp", "Des_di", "Sortno", "Id_emp_sign", "Id_dep_sign", "Dt_sign", "Name_emp_sign", "Di_standard_name", "Di_standard", "Di_standard_code", "Id_dep_create", "Id_dep_create_name", "Fg_sign", "Dt_create", "Id_diitm", "Di_disease", "Id_disease_name", "Id_disease_code", "Fg_self", "Innercode", "Fg_ur", "Fg_chronic", "Fg_special", "Id_infectiontp", "Sd_infectiontp", "Eu_hpbeyond"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.dto.d.DIDTO";
        }
    }
}
