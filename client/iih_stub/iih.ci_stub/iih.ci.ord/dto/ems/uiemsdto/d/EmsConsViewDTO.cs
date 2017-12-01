using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsConsViewDTO 的摘要说明。
    /// </summary>
    public class EmsConsViewDTO : BaseDTO {

        public EmsConsViewDTO() {
 
        }

        /// <summary>
        /// 受邀科室ID
        /// </summary>
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }

        /// <summary>
        /// 受邀科室
        /// </summary>
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }

        /// <summary>
        /// 受邀人ID
        /// </summary>
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }

        /// <summary>
        /// 受邀人
        /// </summary>
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }

        /// <summary>
        /// 受邀人职称ID
        /// </summary>
		public string Id_emp_title {
            get { return getAttrVal<string>("Id_emp_title",null); }
            set { setAttrVal<string>("Id_emp_title", value); }
        }

        /// <summary>
        /// 受邀人职称
        /// </summary>
		public string Sd_emp_title {
            get { return getAttrVal<string>("Sd_emp_title",null); }
            set { setAttrVal<string>("Sd_emp_title", value); }
        }

        /// <summary>
        /// 会诊受邀对象ID
        /// </summary>
		public string Id_invitecons {
            get { return getAttrVal<string>("Id_invitecons",null); }
            set { setAttrVal<string>("Id_invitecons", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_dep", "Name_dep", "Id_emp", "Name_emp", "Id_emp_title", "Sd_emp_title", "Id_invitecons"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsConsViewDTO";
        }
    }
}
