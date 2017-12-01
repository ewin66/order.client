using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.dto.d
{
    /// <summary>
    /// StructTreeDTO 的摘要说明。
    /// </summary>
    public class StructTreeDTO : BaseDTO {

        public StructTreeDTO() {
 
        }

        /// <summary>
        /// 主键ID
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 是否是数据组
        /// </summary>
		public bool? Fg_dg {
            get { return getAttrVal<FBoolean>("Fg_dg",null); }
            set { setAttrVal<FBoolean>("Fg_dg", value); }
        }

        /// <summary>
        /// 树显示名称
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
            return new string[]{ "Id", "Fg_dg", "Name", "Id_par"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.dto.d.StructTreeDTO";
        }
    }
}
