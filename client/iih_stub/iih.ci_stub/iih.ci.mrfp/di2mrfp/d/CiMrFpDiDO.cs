
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.di2mrfp.d
{
    /// <summary>
    /// CiMrfpDiDO 的摘要说明。
    /// </summary>
    public class CiMrfpDiDO : BaseDO {

        public CiMrfpDiDO() {
        }
		public string Id_mrfpdi {
            get { return getAttrVal<string>("Id_mrfpdi",null); }
            set { setAttrVal<string>("Id_mrfpdi", value); }
        }
		public string Id_mrfp {
            get { return getAttrVal<string>("Id_mrfp",null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
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
            return "ci_mr_fp_di";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfpdi";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.di2mrfp.d.CiMrfpDiDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfpdi", "Id_mrfp", "Id_ent", "Id_pat"};
        }
        
    }
}
