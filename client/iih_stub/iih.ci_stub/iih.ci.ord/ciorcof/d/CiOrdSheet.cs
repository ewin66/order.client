
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciorcof.d
{
    /// <summary>
    /// CiOrdSheet 的摘要说明。
    /// </summary>
    public class CiOrdSheet : BaseDO {

        public CiOrdSheet() {
        }
		public string Id_sheet {
            get { return getAttrVal<string>("Id_sheet",null); }
            set { setAttrVal<string>("Id_sheet", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Pycode {
            get { return getAttrVal<string>("Pycode",null); }
            set { setAttrVal<string>("Pycode", value); }
        }
		public string Wbcode {
            get { return getAttrVal<string>("Wbcode",null); }
            set { setAttrVal<string>("Wbcode", value); }
        }
		public string Dll_model {
            get { return getAttrVal<string>("Dll_model",null); }
            set { setAttrVal<string>("Dll_model", value); }
        }
		public string Dll_assembly {
            get { return getAttrVal<string>("Dll_assembly",null); }
            set { setAttrVal<string>("Dll_assembly", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "ci_or_sheet";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_sheet";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciorcof.d.CiOrdSheet";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_sheet", "Code", "Name", "Pycode", "Wbcode", "Dll_model", "Dll_assembly", "Sortno", "Des", "Sv"};
        }
        
    }
}
