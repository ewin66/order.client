using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// ImplVtDTO 的摘要说明。
    /// </summary>
    public class ImplVtDTO : BaseDTO {

        public ImplVtDTO() {
 
        }

        /// <summary>
        ///  主键
        /// </summary>
		public string Id_implvt {
            get { return getAttrVal<string>("Id_implvt",null); }
            set { setAttrVal<string>("Id_implvt", value); }
        }

        /// <summary>
        /// 所属集团id
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属集团名称
        /// </summary>
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }

        /// <summary>
        /// 所属组织id
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 所属组织名称
        /// </summary>
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }

        /// <summary>
        /// 服务分类id
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 服务分类内编码
        /// </summary>
		public string Srvca_innercode {
            get { return getAttrVal<string>("Srvca_innercode",null); }
            set { setAttrVal<string>("Srvca_innercode", value); }
        }

        /// <summary>
        /// 服务分类名称
        /// </summary>
		public string Name_srvca {
            get { return getAttrVal<string>("Name_srvca",null); }
            set { setAttrVal<string>("Name_srvca", value); }
        }

        /// <summary>
        /// 需要执行的sql
        /// </summary>
		public string Exec_sql {
            get { return getAttrVal<string>("Exec_sql",null); }
            set { setAttrVal<string>("Exec_sql", value); }
        }

        /// <summary>
        /// base64编码的sql语句
        /// </summary>
		public string Exec_sql_base64 {
            get { return getAttrVal<string>("Exec_sql_base64",null); }
            set { setAttrVal<string>("Exec_sql_base64", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_implvt", "Id_grp", "Name_grp", "Id_org", "Name_org", "Id_srvca", "Srvca_innercode", "Name_srvca", "Exec_sql", "Exec_sql_base64"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.ImplVtDTO";
        }
    }
}
