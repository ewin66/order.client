
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.app.d
{
    /// <summary>
    /// CiAppPathgySheetSampDO 的摘要说明。
    /// </summary>
    public class CiAppPathgySheetSampDO : BaseDO {

		public const string TABLE_NAME = "ci_app_pathgy_samp";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiAppPathgySheetSampDO() {
        }
		public string Id_ciapppathgysheetsamp {
            get { return getAttrVal<string>("Id_ciapppathgysheetsamp",null); }
            set { setAttrVal<string>("Id_ciapppathgysheetsamp", value); }
        }
		public string Id_ciapppathgysheet {
            get { return getAttrVal<string>("Id_ciapppathgysheet",null); }
            set { setAttrVal<string>("Id_ciapppathgysheet", value); }
        }
		public string Name_labsamp {
            get { return getAttrVal<string>("Name_labsamp",null); }
            set { setAttrVal<string>("Name_labsamp", value); }
        }
		public string Body_coll {
            get { return getAttrVal<string>("Body_coll",null); }
            set { setAttrVal<string>("Body_coll", value); }
        }
		public int? Quan_coll {
            get { return getAttrVal<int?>("Quan_coll",null); }
            set { setAttrVal<int?>("Quan_coll", value); }
        }
		public string Fixative {
            get { return getAttrVal<string>("Fixative",null); }
            set { setAttrVal<string>("Fixative", value); }
        }
		public string Id_su_labsamp {
            get { return getAttrVal<string>("Id_su_labsamp",null); }
            set { setAttrVal<string>("Id_su_labsamp", value); }
        }
		public string Sd_su_labsamp {
            get { return getAttrVal<string>("Sd_su_labsamp",null); }
            set { setAttrVal<string>("Sd_su_labsamp", value); }
        }
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Name_su_labsamp {
            get { return getAttrVal<string>("Name_su_labsamp",null); }
            set { setAttrVal<string>("Name_su_labsamp", value); }
        }
		public string Name_dep_sign {
            get { return getAttrVal<string>("Name_dep_sign",null); }
            set { setAttrVal<string>("Name_dep_sign", value); }
        }
		public string Code_dep_sign {
            get { return getAttrVal<string>("Code_dep_sign",null); }
            set { setAttrVal<string>("Code_dep_sign", value); }
        }
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }
		public string Code_emp_sign {
            get { return getAttrVal<string>("Code_emp_sign",null); }
            set { setAttrVal<string>("Code_emp_sign", value); }
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
            return "ci_app_pathgy_samp";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_ciapppathgysheetsamp";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.app.d.CiAppPathgySheetSampDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ciapppathgysheetsamp", "Id_ciapppathgysheet", "Name_labsamp", "Body_coll", "Quan_coll", "Fixative", "Id_su_labsamp", "Sd_su_labsamp", "Id_dep_sign", "Id_emp_sign", "Dt_sign", "Sortno", "Name_su_labsamp", "Name_dep_sign", "Code_dep_sign", "Name_emp_sign", "Code_emp_sign"};
        }
        
    }
}
