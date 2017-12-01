using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// OrSuModRtnInfoDTO 的摘要说明。
    /// </summary>
    public class OrSuModRtnInfoDTO : BaseDTO {

        public OrSuModRtnInfoDTO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 业务时间
        /// </summary>
		public DateTime? Dt_biz {
            get { return getAttrVal<FDateTime>("Dt_biz",null); }
            set { setAttrVal<FDateTime>("Dt_biz", value); }
        }

        /// <summary>
        /// 科室
        /// </summary>
		public string Id_dept {
            get { return getAttrVal<string>("Id_dept",null); }
            set { setAttrVal<string>("Id_dept", value); }
        }

        /// <summary>
        /// 科室编码
        /// </summary>
		public string Code_dept {
            get { return getAttrVal<string>("Code_dept",null); }
            set { setAttrVal<string>("Code_dept", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Name_dept {
            get { return getAttrVal<string>("Name_dept",null); }
            set { setAttrVal<string>("Name_dept", value); }
        }

        /// <summary>
        /// 人员
        /// </summary>
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }

        /// <summary>
        /// 人员编码
        /// </summary>
		public string Code_emp {
            get { return getAttrVal<string>("Code_emp",null); }
            set { setAttrVal<string>("Code_emp", value); }
        }

        /// <summary>
        /// 人员名称
        /// </summary>
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Dt_biz", "Id_dept", "Code_dept", "Name_dept", "Id_emp", "Code_emp", "Name_emp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.OrSuModRtnInfoDTO";
        }
    }
}
