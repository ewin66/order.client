using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagion.dto.d
{
    /// <summary>
    /// Contagiondto 的摘要说明。
    /// </summary>
    public class Contagiondto : BaseDTO {

        public Contagiondto() {
 
        }

        /// <summary>
        /// id_contagion
        /// </summary>
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }

        /// <summary>
        /// title
        /// </summary>
		public string Title {
            get { return getAttrVal<string>("Title",null); }
            set { setAttrVal<string>("Title", value); }
        }

        /// <summary>
        /// id_form
        /// </summary>
		public string Id_form {
            get { return getAttrVal<string>("Id_form",null); }
            set { setAttrVal<string>("Id_form", value); }
        }

        /// <summary>
        /// id_ent
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// p_id_contagion
        /// </summary>
		public string P_id_contagion {
            get { return getAttrVal<string>("P_id_contagion",null); }
            set { setAttrVal<string>("P_id_contagion", value); }
        }

        /// <summary>
        /// 状态
        /// </summary>
		public string Id_state {
            get { return getAttrVal<string>("Id_state",null); }
            set { setAttrVal<string>("Id_state", value); }
        }

        /// <summary>
        /// 驳回原因
        /// </summary>
		public string Reject_reason {
            get { return getAttrVal<string>("Reject_reason",null); }
            set { setAttrVal<string>("Reject_reason", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagion", "Title", "Id_form", "Id_ent", "P_id_contagion", "Id_state", "Reject_reason"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagion.dto.d.Contagiondto";
        }
    }
}
