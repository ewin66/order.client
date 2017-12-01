using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.consdto.d
{
    /// <summary>
    /// OrdConsDTO 的摘要说明。
    /// </summary>
    public class OrdConsDTO : BaseDTO {

        public OrdConsDTO() {
 
        }

        /// <summary>
        /// 加急
        /// </summary>
		public string Urgent {
            get { return getAttrVal<string>("Urgent",null); }
            set { setAttrVal<string>("Urgent", value); }
        }

        /// <summary>
        /// 计划会诊时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 会诊申请状态
        /// </summary>
		public string Name_su_cons {
            get { return getAttrVal<string>("Name_su_cons",null); }
            set { setAttrVal<string>("Name_su_cons", value); }
        }

        /// <summary>
        /// 会诊医生
        /// </summary>
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }

        /// <summary>
        /// 申请科室
        /// </summary>
		public string Name_dep_or {
            get { return getAttrVal<string>("Name_dep_or",null); }
            set { setAttrVal<string>("Name_dep_or", value); }
        }

        /// <summary>
        /// 审批通过标志
        /// </summary>
		public bool? Fg_audit {
            get { return getAttrVal<FBoolean>("Fg_audit",null); }
            set { setAttrVal<FBoolean>("Fg_audit", value); }
        }

        /// <summary>
        /// 审批意见
        /// </summary>
		public string Des_review {
            get { return getAttrVal<string>("Des_review",null); }
            set { setAttrVal<string>("Des_review", value); }
        }

        /// <summary>
        /// 会诊医生姓名
        /// </summary>
		public string Emp_name {
            get { return getAttrVal<string>("Emp_name",null); }
            set { setAttrVal<string>("Emp_name", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 患者床号
        /// </summary>
		public string Pat_bedno {
            get { return getAttrVal<string>("Pat_bedno",null); }
            set { setAttrVal<string>("Pat_bedno", value); }
        }

        /// <summary>
        /// 申请类型
        /// </summary>
		public string Name_constp {
            get { return getAttrVal<string>("Name_constp",null); }
            set { setAttrVal<string>("Name_constp", value); }
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_apcons {
            get { return getAttrVal<string>("Id_apcons",null); }
            set { setAttrVal<string>("Id_apcons", value); }
        }

        /// <summary>
        /// 审批状态
        /// </summary>
		public string Name_reviewtp {
            get { return getAttrVal<string>("Name_reviewtp",null); }
            set { setAttrVal<string>("Name_reviewtp", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 是否院内会诊
        /// </summary>
		public bool? Fg_inorg {
            get { return getAttrVal<FBoolean>("Fg_inorg",null); }
            set { setAttrVal<FBoolean>("Fg_inorg", value); }
        }

        /// <summary>
        /// 会诊申请状态编码
        /// </summary>
		public string Sd_su_cons {
            get { return getAttrVal<string>("Sd_su_cons",null); }
            set { setAttrVal<string>("Sd_su_cons", value); }
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
		public string Code_en {
            get { return getAttrVal<string>("Code_en",null); }
            set { setAttrVal<string>("Code_en", value); }
        }

        /// <summary>
        /// 受邀医生是否职称限制
        /// </summary>
		public bool? Fg_emptitlelimit {
            get { return getAttrVal<FBoolean>("Fg_emptitlelimit",null); }
            set { setAttrVal<FBoolean>("Fg_emptitlelimit", value); }
        }

        /// <summary>
        /// 受邀医生最低职称
        /// </summary>
		public string Id_emptitle {
            get { return getAttrVal<string>("Id_emptitle",null); }
            set { setAttrVal<string>("Id_emptitle", value); }
        }

        /// <summary>
        /// 受邀医生最低职称编码
        /// </summary>
		public string Sd_emptitle {
            get { return getAttrVal<string>("Sd_emptitle",null); }
            set { setAttrVal<string>("Sd_emptitle", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Urgent", "Dt_plan", "Name_su_cons", "Id_emp", "Name_dep_or", "Fg_audit", "Des_review", "Emp_name", "Name_pat", "Pat_bedno", "Name_constp", "Id_apcons", "Name_reviewtp", "Id_en", "Fg_urgent", "Fg_inorg", "Sd_su_cons", "Code_en", "Fg_emptitlelimit", "Id_emptitle", "Sd_emptitle"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.consdto.d.OrdConsDTO";
        }
    }
}
