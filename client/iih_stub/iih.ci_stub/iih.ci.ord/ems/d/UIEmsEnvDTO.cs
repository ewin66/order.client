using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ems.d
{
    /// <summary>
    /// UIEmsEnvDTO 的摘要说明。
    /// </summary>
    public class UIEmsEnvDTO : BaseDTO {

        public UIEmsEnvDTO() {
 
        }

        /// <summary>
        /// 所属集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 医疗单应用场景
        /// </summary>
		public int? Emsappmode {
            get { return getAttrVal<int?>("Emsappmode",null); }
            set { setAttrVal<int?>("Emsappmode", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 医保信息
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 就诊类型id
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_grp", "Id_org", "Id_dep_or", "Id_emp_or", "Emsappmode", "Id_pat", "Id_en", "Code_entp", "Id_hp", "Id_entp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ems.d.UIEmsEnvDTO";
        }
    }
}
