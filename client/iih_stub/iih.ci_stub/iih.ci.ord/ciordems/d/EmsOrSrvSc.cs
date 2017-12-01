using System;
using iih.bd.srv.medsrv.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// BD_SRV表和该服务对应的医保的信息的合集，是一个DTO
    /// </summary>
    public class EmsOrSrvSc : BaseDTO {

        public EmsOrSrvSc() {
 
        }

        /// <summary>
        /// 服务主键
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 服务类型名称
        /// </summary>
		public string Name_srvca {
            get { return getAttrVal<string>("Name_srvca",null); }
            set { setAttrVal<string>("Name_srvca", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 助记码
        /// </summary>
		public string Mnecode {
            get { return getAttrVal<string>("Mnecode",null); }
            set { setAttrVal<string>("Mnecode", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Healthca {
            get { return getAttrVal<string>("Healthca",null); }
            set { setAttrVal<string>("Healthca", value); }
        }

        /// <summary>
        /// 描述
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 描述
        /// </summary>
        public MedSrvDO MedSrvDO
        {
            get { return getAttrVal<MedSrvDO>("MedSrvDO", null); }
            set { setAttrVal<MedSrvDO>("MedSrvDO", value); }
        }
        /// <summary>
        /// 价格描述
        /// </summary>
        public string Des_pri
        {
            get { return getAttrVal<string>("Des_pri", null); }
            set { setAttrVal<string>("Des_pri", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_srv", "Id_srvca", "Name_srvca", "Name_srv", "Code_srv", "Mnecode", "Healthca", "Des", "Des_pri" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsOrSrvSc";
        }
    }
}
