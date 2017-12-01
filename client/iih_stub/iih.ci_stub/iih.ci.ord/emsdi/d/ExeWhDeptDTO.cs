using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.emsdi.d
{
    /// <summary>
    /// ExeWhDeptDTO 的摘要说明。
    /// </summary>
    public class ExeWhDeptDTO : BaseDTO {

        public ExeWhDeptDTO() {
 
        }

        /// <summary>
        /// 执行科室组织
        /// </summary>
		public string Id_org_mp {
            get { return getAttrVal<string>("Id_org_mp",null); }
            set { setAttrVal<string>("Id_org_mp", value); }
        }

        /// <summary>
        /// 执行科室组织编码
        /// </summary>
		public string Code_org_mp {
            get { return getAttrVal<string>("Code_org_mp",null); }
            set { setAttrVal<string>("Code_org_mp", value); }
        }

        /// <summary>
        /// 执行科室组织名称
        /// </summary>
		public string Name_org_mp {
            get { return getAttrVal<string>("Name_org_mp",null); }
            set { setAttrVal<string>("Name_org_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室编码
        /// </summary>
		public string Code_dep_mp {
            get { return getAttrVal<string>("Code_dep_mp",null); }
            set { setAttrVal<string>("Code_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 库房组织
        /// </summary>
		public string Id_org_wh {
            get { return getAttrVal<string>("Id_org_wh",null); }
            set { setAttrVal<string>("Id_org_wh", value); }
        }

        /// <summary>
        /// 库房组织编码
        /// </summary>
		public string Code_org_wh {
            get { return getAttrVal<string>("Code_org_wh",null); }
            set { setAttrVal<string>("Code_org_wh", value); }
        }

        /// <summary>
        /// 库房组织名称
        /// </summary>
		public string Name_org_wh {
            get { return getAttrVal<string>("Name_org_wh",null); }
            set { setAttrVal<string>("Name_org_wh", value); }
        }

        /// <summary>
        /// 库房
        /// </summary>
		public string Id_dep_wh {
            get { return getAttrVal<string>("Id_dep_wh",null); }
            set { setAttrVal<string>("Id_dep_wh", value); }
        }

        /// <summary>
        /// 库房编码
        /// </summary>
		public string Code_dep_wh {
            get { return getAttrVal<string>("Code_dep_wh",null); }
            set { setAttrVal<string>("Code_dep_wh", value); }
        }

        /// <summary>
        /// 库房名称
        /// </summary>
		public string Name_dep_wh {
            get { return getAttrVal<string>("Name_dep_wh",null); }
            set { setAttrVal<string>("Name_dep_wh", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_org_mp", "Code_org_mp", "Name_org_mp", "Id_dep_mp", "Code_dep_mp", "Name_dep_mp", "Id_org_wh", "Code_org_wh", "Name_org_wh", "Id_dep_wh", "Code_dep_wh", "Name_dep_wh"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.emsdi.d.ExeWhDeptDTO";
        }
    }
}
