using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.srvreact.d
{
    /// <summary>
    /// OrOpenSrvReactDTO 的摘要说明。
    /// </summary>
    public class OrOpenSrvReactDTO : BaseDTO {

        public OrOpenSrvReactDTO() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 生效时间
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 结束时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 医嘱执行状态
        /// </summary>
		public string Sd_su_mp {
            get { return getAttrVal<string>("Sd_su_mp",null); }
            set { setAttrVal<string>("Sd_su_mp", value); }
        }

        /// <summary>
        /// 对应医嘱项目
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 项目名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Content_or", "Dt_effe", "Dt_end", "Sd_su_mp", "Id_srv", "Name_srv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.srvreact.d.OrOpenSrvReactDTO";
        }
    }
}
