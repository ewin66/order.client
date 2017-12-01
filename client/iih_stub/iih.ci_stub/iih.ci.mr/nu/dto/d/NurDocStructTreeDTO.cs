using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.dto.d
{
    /// <summary>
    /// NurDocStructTreeDTO 的摘要说明。
    /// </summary>
    public class NurDocStructTreeDTO : BaseDTO {

        public NurDocStructTreeDTO() {
 
        }

        /// <summary>
        /// 主键ID
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 显示名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 父级主键
        /// </summary>
		public string Id_par {
            get { return getAttrVal<string>("Id_par",null); }
            set { setAttrVal<string>("Id_par", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Name", "Id_par"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.dto.d.NurDocStructTreeDTO";
        }
    }
}
