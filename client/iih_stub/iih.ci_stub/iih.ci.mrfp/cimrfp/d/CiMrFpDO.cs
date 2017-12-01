
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.cimrfp.d
{
    /// <summary>
    /// 住院病历首页 DO数据 
    /// </summary>
    public class CiMrFpDO : BaseDO {

        public CiMrFpDO() {
        }
		public string Id_mrfp {
            get { return getAttrVal<string>("Id_mrfp",null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }
		public string Sd_mrfptp {
            get { return getAttrVal<string>("Sd_mrfptp",null); }
            set { setAttrVal<string>("Sd_mrfptp", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
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
            return "CI_MR_FP";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.cimrfp.d.CiMrFpDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfp", "Sd_mrfptp", "Id_pat", "Id_org", "Id_ent"};
        }
        
    }
}
