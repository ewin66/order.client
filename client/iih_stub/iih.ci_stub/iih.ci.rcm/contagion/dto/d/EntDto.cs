using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.dto.d
{
    /// <summary>
    /// EntDto 的摘要说明。
    /// </summary>
    public class EntDto : BaseDTO {

        public EntDto() {
 
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 病案号
        /// </summary>
		public string Hospital_code {
            get { return getAttrVal<string>("Hospital_code",null); }
            set { setAttrVal<string>("Hospital_code", value); }
        }

        /// <summary>
        /// 患者ID
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 病案主键
        /// </summary>
		public string Id_amr {
            get { return getAttrVal<string>("Id_amr",null); }
            set { setAttrVal<string>("Id_amr", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Bed_code {
            get { return getAttrVal<string>("Bed_code",null); }
            set { setAttrVal<string>("Bed_code", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 性别ID
        /// </summary>
		public string Id_sex_pat {
            get { return getAttrVal<string>("Id_sex_pat",null); }
            set { setAttrVal<string>("Id_sex_pat", value); }
        }

        /// <summary>
        /// 性别code
        /// </summary>
		public string Sd_sex_pat {
            get { return getAttrVal<string>("Sd_sex_pat",null); }
            set { setAttrVal<string>("Sd_sex_pat", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 就诊科室名称
        /// </summary>
		public string Dep_phy_name {
            get { return getAttrVal<string>("Dep_phy_name",null); }
            set { setAttrVal<string>("Dep_phy_name", value); }
        }

        /// <summary>
        /// 入院时间
        /// </summary>
		public string Dt_acpt {
            get { return getAttrVal<string>("Dt_acpt",null); }
            set { setAttrVal<string>("Dt_acpt", value); }
        }

        /// <summary>
        /// 出院时间
        /// </summary>
		public string Dt_end {
            get { return getAttrVal<string>("Dt_end",null); }
            set { setAttrVal<string>("Dt_end", value); }
        }

        /// <summary>
        /// 确诊时间
        /// </summary>
		public string Dt_diag {
            get { return getAttrVal<string>("Dt_diag",null); }
            set { setAttrVal<string>("Dt_diag", value); }
        }

        /// <summary>
        /// 主管医生
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public string Id_didef_dis {
            get { return getAttrVal<string>("Id_didef_dis",null); }
            set { setAttrVal<string>("Id_didef_dis", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name_didef_dis {
            get { return getAttrVal<string>("Name_didef_dis",null); }
            set { setAttrVal<string>("Name_didef_dis", value); }
        }

        /// <summary>
        /// 是否有上报卡
        /// </summary>
		public bool? Iscard {
            get { return getAttrVal<FBoolean>("Iscard",null); }
            set { setAttrVal<FBoolean>("Iscard", value); }
        }

        /// <summary>
        /// 传染病发病日期
        /// </summary>
		public string Fbrq {
            get { return getAttrVal<string>("Fbrq",null); }
            set { setAttrVal<string>("Fbrq", value); }
        }

        /// <summary>
        /// 填报日期
        /// </summary>
		public string Dt_contagion {
            get { return getAttrVal<string>("Dt_contagion",null); }
            set { setAttrVal<string>("Dt_contagion", value); }
        }

        /// <summary>
        /// 状态
        /// </summary>
		public string Id_con_cardsu {
            get { return getAttrVal<string>("Id_con_cardsu",null); }
            set { setAttrVal<string>("Id_con_cardsu", value); }
        }

        /// <summary>
        /// 状态编码
        /// </summary>
		public string Sd_con_cardsn {
            get { return getAttrVal<string>("Sd_con_cardsn",null); }
            set { setAttrVal<string>("Sd_con_cardsn", value); }
        }

        /// <summary>
        /// 状态名称
        /// </summary>
		public string Name_con_cardsn {
            get { return getAttrVal<string>("Name_con_cardsn",null); }
            set { setAttrVal<string>("Name_con_cardsn", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Pat_birth {
            get { return getAttrVal<FDate>("Pat_birth",null); }
            set { setAttrVal<FDate>("Pat_birth", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Id_entp", "Hospital_code", "Id_pat", "Id_amr", "Bed_code", "Name_pat", "Id_sex_pat", "Sd_sex_pat", "Name_sex", "Pat_age", "Id_dep_phy", "Dep_phy_name", "Dt_acpt", "Dt_end", "Dt_diag", "Name_emp_phy", "Id_didef_dis", "Name_didef_dis", "Iscard", "Fbrq", "Dt_contagion", "Id_con_cardsu", "Sd_con_cardsn", "Name_con_cardsn", "Pat_birth"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.dto.d.EntDto";
        }
    }
}
