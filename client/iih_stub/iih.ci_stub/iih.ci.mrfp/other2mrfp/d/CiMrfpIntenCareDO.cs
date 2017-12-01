
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.other2mrfp.d
{
    /// <summary>
    /// CiMrfpIntenCareDO 的摘要说明。
    /// </summary>
    public class CiMrfpIntenCareDO : BaseDO {

        public CiMrfpIntenCareDO() {
        }
		public string Id_mrfp_intencare {
            get { return getAttrVal<string>("Id_mrfp_intencare",null); }
            set { setAttrVal<string>("Id_mrfp_intencare", value); }
        }
		public string Id_cimrfpother {
            get { return getAttrVal<string>("Id_cimrfpother",null); }
            set { setAttrVal<string>("Id_cimrfpother", value); }
        }
		public string Name_intencare {
            get { return getAttrVal<string>("Name_intencare",null); }
            set { setAttrVal<string>("Name_intencare", value); }
        }
		public DateTime? Time_in_intencare {
            get { return getAttrVal<FDateTime>("Time_in_intencare",null); }
            set { setAttrVal<FDateTime>("Time_in_intencare", value); }
        }
		public DateTime? Time_out_intencare {
            get { return getAttrVal<FDateTime>("Time_out_intencare",null); }
            set { setAttrVal<FDateTime>("Time_out_intencare", value); }
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
            return "ci_mrfp_intencare";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfp_intencare";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfp_intencare", "Id_cimrfpother", "Name_intencare", "Time_in_intencare", "Time_out_intencare"};
        }
        
    }
}
