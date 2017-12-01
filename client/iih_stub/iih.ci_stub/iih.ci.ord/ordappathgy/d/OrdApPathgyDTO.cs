using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ordappathgy.d
{
    /// <summary>
    /// OrdApPathgyDTO 的摘要说明。
    /// </summary>
    public class OrdApPathgyDTO : BaseDTO {

        public OrdApPathgyDTO() {
 
        }

        /// <summary>
        /// 病理申请单主键标识
        /// </summary>
		public string Id_appathgy {
            get { return getAttrVal<string>("Id_appathgy",null); }
            set { setAttrVal<string>("Id_appathgy", value); }
        }

        /// <summary>
        /// 医嘱主键
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 服务项目分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 生效时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 报告状态
        /// </summary>
		public string Fg_rpt {
            get { return getAttrVal<string>("Fg_rpt",null); }
            set { setAttrVal<string>("Fg_rpt", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_appathgy", "Id_or", "Name", "Id_srvca", "Dt_effe", "Fg_rpt"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordappathgy.d.OrdApPathgyDTO";
        }
    }
}
