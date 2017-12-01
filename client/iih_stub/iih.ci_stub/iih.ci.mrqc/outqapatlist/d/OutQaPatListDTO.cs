using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.outqapatlist.d
{
    /// <summary>
    /// OutQaPatListDTO 的摘要说明。
    /// </summary>
    public class OutQaPatListDTO : BaseDTO {

        public OutQaPatListDTO() {
 
        }

        /// <summary>
        /// 就诊id
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Code_ent {
            get { return getAttrVal<string>("Code_ent",null); }
            set { setAttrVal<string>("Code_ent", value); }
        }

        /// <summary>
        /// 门诊病案编号
        /// </summary>
		public string Code_amr_oep {
            get { return getAttrVal<string>("Code_amr_oep",null); }
            set { setAttrVal<string>("Code_amr_oep", value); }
        }

        /// <summary>
        /// 门诊次数
        /// </summary>
		public int? Times_op {
            get { return getAttrVal<int?>("Times_op",null); }
            set { setAttrVal<int?>("Times_op", value); }
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
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }

        /// <summary>
        /// 性别编码
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }

        /// <summary>
        /// 患者电话
        /// </summary>
		public string Telno_pat {
            get { return getAttrVal<string>("Telno_pat",null); }
            set { setAttrVal<string>("Telno_pat", value); }
        }

        /// <summary>
        /// 婚姻状况编码
        /// </summary>
		public string Sd_mari_pat {
            get { return getAttrVal<string>("Sd_mari_pat",null); }
            set { setAttrVal<string>("Sd_mari_pat", value); }
        }

        /// <summary>
        /// 婚姻状况
        /// </summary>
		public string Name_mari_pat {
            get { return getAttrVal<string>("Name_mari_pat",null); }
            set { setAttrVal<string>("Name_mari_pat", value); }
        }

        /// <summary>
        /// 科室id
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 当前医生id
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 当前医生
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
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
        /// 就诊登记日期
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
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
        /// 诊断id
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 补充描述
        /// </summary>
		public string Supplement_di {
            get { return getAttrVal<string>("Supplement_di",null); }
            set { setAttrVal<string>("Supplement_di", value); }
        }

        /// <summary>
        /// 病案主键
        /// </summary>
		public string Id_enhr {
            get { return getAttrVal<string>("Id_enhr",null); }
            set { setAttrVal<string>("Id_enhr", value); }
        }

        /// <summary>
        /// 抽查时间
        /// </summary>
		public DateTime? Dt_check {
            get { return getAttrVal<FDateTime>("Dt_check",null); }
            set { setAttrVal<FDateTime>("Dt_check", value); }
        }

        /// <summary>
        /// 质量抽查评分
        /// </summary>
		public string Score_emp_check {
            get { return getAttrVal<string>("Score_emp_check",null); }
            set { setAttrVal<string>("Score_emp_check", value); }
        }

        /// <summary>
        /// 科室质控医生id
        /// </summary>
		public string Id_emp_check {
            get { return getAttrVal<string>("Id_emp_check",null); }
            set { setAttrVal<string>("Id_emp_check", value); }
        }

        /// <summary>
        /// 科室质控医生
        /// </summary>
		public string Name_emp_check {
            get { return getAttrVal<string>("Name_emp_check",null); }
            set { setAttrVal<string>("Name_emp_check", value); }
        }

        /// <summary>
        /// 患者年龄
        /// </summary>
		public string Age_pat {
            get { return getAttrVal<string>("Age_pat",null); }
            set { setAttrVal<string>("Age_pat", value); }
        }

        /// <summary>
        /// 抽查记录主键
        /// </summary>
		public string Id_spot_check {
            get { return getAttrVal<string>("Id_spot_check",null); }
            set { setAttrVal<string>("Id_spot_check", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Code_ent", "Code_amr_oep", "Times_op", "Id_pat", "Code_pat", "Name_pat", "Dt_birth_pat", "Sd_sex", "Name_sex", "Telno_pat", "Sd_mari_pat", "Name_mari_pat", "Id_dep_phy", "Name_dep_phy", "Id_emp_phy", "Name_emp_phy", "Id_hp", "Name_hp", "No_hp", "Dt_entry", "Id_patca", "Name_patca", "Id_pripat", "Name_pripat", "Id_patcret", "Name_patcret", "Id_di", "Name_di", "Supplement_di", "Id_enhr", "Dt_check", "Score_emp_check", "Id_emp_check", "Name_emp_check", "Age_pat", "Id_spot_check"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.outqapatlist.d.OutQaPatListDTO";
        }
    }
}
