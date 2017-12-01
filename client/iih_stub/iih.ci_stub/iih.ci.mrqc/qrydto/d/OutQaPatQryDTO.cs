using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qrydto.d
{
    /// <summary>
    /// OutQaPatQryDTO 的摘要说明。
    /// </summary>
    public class OutQaPatQryDTO : BaseDTO {

        public OutQaPatQryDTO() {
 
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 当前主管医生
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 当前就诊科室
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 就诊登记日期时间
        /// </summary>
		public DateTime? Dt_entry_start {
            get { return getAttrVal<FDateTime>("Dt_entry_start",null); }
            set { setAttrVal<FDateTime>("Dt_entry_start", value); }
        }

        /// <summary>
        /// 就诊结束时间
        /// </summary>
		public DateTime? Dt_entry_end {
            get { return getAttrVal<FDateTime>("Dt_entry_end",null); }
            set { setAttrVal<FDateTime>("Dt_entry_end", value); }
        }

        /// <summary>
        /// 去无门诊病历
        /// </summary>
		public bool? Fg_mr {
            get { return getAttrVal<FBoolean>("Fg_mr",null); }
            set { setAttrVal<FBoolean>("Fg_mr", value); }
        }

        /// <summary>
        /// 去抽查
        /// </summary>
		public bool? Fg_random {
            get { return getAttrVal<FBoolean>("Fg_random",null); }
            set { setAttrVal<FBoolean>("Fg_random", value); }
        }

        /// <summary>
        /// 抽查份数
        /// </summary>
		public int? Times_random {
            get { return getAttrVal<int?>("Times_random",null); }
            set { setAttrVal<int?>("Times_random", value); }
        }

        /// <summary>
        /// 科室编码
        /// </summary>
		public string Sd_dep_phy {
            get { return getAttrVal<string>("Sd_dep_phy",null); }
            set { setAttrVal<string>("Sd_dep_phy", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 医生编码
        /// </summary>
		public string Sd_emp_phy {
            get { return getAttrVal<string>("Sd_emp_phy",null); }
            set { setAttrVal<string>("Sd_emp_phy", value); }
        }

        /// <summary>
        /// 医生名称
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Code", "Name_pat", "Id_emp_phy", "Id_dep_phy", "Dt_entry_start", "Dt_entry_end", "Fg_mr", "Fg_random", "Times_random", "Sd_dep_phy", "Name_dep_phy", "Sd_emp_phy", "Name_emp_phy"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qrydto.d.OutQaPatQryDTO";
        }
    }
}
