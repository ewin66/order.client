
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorder.d
{
    /// <summary>
    /// OrdApMtDO 的摘要说明。
    /// </summary>
    public class OrdApMtDO : BaseDO {

        public OrdApMtDO() {
        }
		public string Id_ormt {
            get { return getAttrVal<string>("Id_ormt",null); }
            set { setAttrVal<string>("Id_ormt", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_ordi {
            get { return getAttrVal<string>("Id_ordi",null); }
            set { setAttrVal<string>("Id_ordi", value); }
        }
		public string Id_ordiitm {
            get { return getAttrVal<string>("Id_ordiitm",null); }
            set { setAttrVal<string>("Id_ordiitm", value); }
        }
		public string Str_id_di {
            get { return getAttrVal<string>("Str_id_di",null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
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
            return "ci_ap_mt";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ormt";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorder.d.OrdApMtDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ormt", "Id_or", "Id_ordi", "Id_ordiitm", "Str_id_di", "Str_name_di", "No_applyform"};
        }
        
    }
}
