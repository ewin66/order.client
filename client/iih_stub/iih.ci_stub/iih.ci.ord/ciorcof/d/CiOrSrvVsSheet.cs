
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorcof.d
{
    /// <summary>
    /// CiOrSrvVsSheet 的摘要说明。
    /// </summary>
    public class CiOrSrvVsSheet : BaseDO {

        public CiOrSrvVsSheet() {
        }
		public string Id_srvvssheet {
            get { return getAttrVal<string>("Id_srvvssheet",null); }
            set { setAttrVal<string>("Id_srvvssheet", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Id_sheet {
            get { return getAttrVal<string>("Id_sheet",null); }
            set { setAttrVal<string>("Id_sheet", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "ci_srv_vs_sheet";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_srvvssheet";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorcof.d.CiOrSrvVsSheet";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_srvvssheet", "Sd_srvtp", "Id_srvtp", "Id_sheet"};
        }
        
    }
}
