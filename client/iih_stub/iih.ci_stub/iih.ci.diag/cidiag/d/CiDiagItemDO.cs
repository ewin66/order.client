
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.diag.cidiag.d
{
    /// <summary>
    /// CiDiagItemDO 的摘要说明。
    /// </summary>
    public class CiDiagItemDO : BaseDO {

		public const string TABLE_NAME = "ci_di_itm";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiDiagItemDO() {
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }
		public string Id_didef {
            get { return getAttrVal<string>("Id_didef",null); }
            set { setAttrVal<string>("Id_didef", value); }
        }
		public string Id_didef_code {
            get { return getAttrVal<string>("Id_didef_code",null); }
            set { setAttrVal<string>("Id_didef_code", value); }
        }
		public string Id_didef_name {
            get { return getAttrVal<string>("Id_didef_name",null); }
            set { setAttrVal<string>("Id_didef_name", value); }
        }
		public string Id_didef_syn {
            get { return getAttrVal<string>("Id_didef_syn",null); }
            set { setAttrVal<string>("Id_didef_syn", value); }
        }
		public string Id_didef_syn_code {
            get { return getAttrVal<string>("Id_didef_syn_code",null); }
            set { setAttrVal<string>("Id_didef_syn_code", value); }
        }
		public string Id_didef_syn_name {
            get { return getAttrVal<string>("Id_didef_syn_name",null); }
            set { setAttrVal<string>("Id_didef_syn_name", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public bool? Fg_majdi {
            get { return getAttrVal<FBoolean>("Fg_majdi",null); }
            set { setAttrVal<FBoolean>("Fg_majdi", value); }
        }
		public bool? Fg_suspdi {
            get { return getAttrVal<FBoolean>("Fg_suspdi",null); }
            set { setAttrVal<FBoolean>("Fg_suspdi", value); }
        }
		public bool? Fg_infedi {
            get { return getAttrVal<FBoolean>("Fg_infedi",null); }
            set { setAttrVal<FBoolean>("Fg_infedi", value); }
        }
		public string Id_parent {
            get { return getAttrVal<string>("Id_parent",null); }
            set { setAttrVal<string>("Id_parent", value); }
        }
		public string Innercode {
            get { return getAttrVal<string>("Innercode",null); }
            set { setAttrVal<string>("Innercode", value); }
        }
		public bool? Fg_flupci {
            get { return getAttrVal<FBoolean>("Fg_flupci",null); }
            set { setAttrVal<FBoolean>("Fg_flupci", value); }
        }
		public bool? Fg_sym {
            get { return getAttrVal<FBoolean>("Fg_sym",null); }
            set { setAttrVal<FBoolean>("Fg_sym", value); }
        }
		public string Supplement {
            get { return getAttrVal<string>("Supplement",null); }
            set { setAttrVal<string>("Supplement", value); }
        }
		public string Id_disys {
            get { return getAttrVal<string>("Id_disys",null); }
            set { setAttrVal<string>("Id_disys", value); }
        }
		public string Sd_disys {
            get { return getAttrVal<string>("Sd_disys",null); }
            set { setAttrVal<string>("Sd_disys", value); }
        }
		public string Id_disys_name {
            get { return getAttrVal<string>("Id_disys_name",null); }
            set { setAttrVal<string>("Id_disys_name", value); }
        }
		public string Di_standard {
            get { return getAttrVal<string>("Di_standard",null); }
            set { setAttrVal<string>("Di_standard", value); }
        }
		public string Di_standard_code {
            get { return getAttrVal<string>("Di_standard_code",null); }
            set { setAttrVal<string>("Di_standard_code", value); }
        }
		public string Di_standard_name {
            get { return getAttrVal<string>("Di_standard_name",null); }
            set { setAttrVal<string>("Di_standard_name", value); }
        }
		public bool? Fg_self {
            get { return getAttrVal<FBoolean>("Fg_self",null); }
            set { setAttrVal<FBoolean>("Fg_self", value); }
        }
		public bool? Fg_ur {
            get { return getAttrVal<FBoolean>("Fg_ur",null); }
            set { setAttrVal<FBoolean>("Fg_ur", value); }
        }
		public bool? Fg_chronic {
            get { return getAttrVal<FBoolean>("Fg_chronic",null); }
            set { setAttrVal<FBoolean>("Fg_chronic", value); }
        }
		public bool? Fg_special {
            get { return getAttrVal<FBoolean>("Fg_special",null); }
            set { setAttrVal<FBoolean>("Fg_special", value); }
        }
		public string Eu_hpbeyond {
            get { return getAttrVal<string>("Eu_hpbeyond",null); }
            set { setAttrVal<string>("Eu_hpbeyond", value); }
        }
		public string Id_infectiontp {
            get { return getAttrVal<string>("Id_infectiontp",null); }
            set { setAttrVal<string>("Id_infectiontp", value); }
        }
		public string Sd_infectiontp {
            get { return getAttrVal<string>("Sd_infectiontp",null); }
            set { setAttrVal<string>("Sd_infectiontp", value); }
        }
		public string Didef_code {
            get { return getAttrVal<string>("Didef_code",null); }
            set { setAttrVal<string>("Didef_code", value); }
        }
		public string Didef_name {
            get { return getAttrVal<string>("Didef_name",null); }
            set { setAttrVal<string>("Didef_name", value); }
        }
		public string Didef_syn_name {
            get { return getAttrVal<string>("Didef_syn_name",null); }
            set { setAttrVal<string>("Didef_syn_name", value); }
        }
		public string Didef_syn_code {
            get { return getAttrVal<string>("Didef_syn_code",null); }
            set { setAttrVal<string>("Didef_syn_code", value); }
        }
		public string Disys_code {
            get { return getAttrVal<string>("Disys_code",null); }
            set { setAttrVal<string>("Disys_code", value); }
        }
		public string Disys_name {
            get { return getAttrVal<string>("Disys_name",null); }
            set { setAttrVal<string>("Disys_name", value); }
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
            return "ci_di_itm";
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
            return "Id_diitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.diag.cidiag.d.CiDiagItemDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_diitm", "Id_di", "Sortno", "Id_didef", "Id_didef_code", "Id_didef_name", "Id_didef_syn", "Id_didef_syn_code", "Id_didef_syn_name", "Des", "Fg_majdi", "Fg_suspdi", "Fg_infedi", "Id_parent", "Innercode", "Fg_flupci", "Fg_sym", "Supplement", "Id_disys", "Sd_disys", "Id_disys_name", "Di_standard", "Di_standard_code", "Di_standard_name", "Fg_self", "Fg_ur", "Fg_chronic", "Fg_special", "Eu_hpbeyond", "Id_infectiontp", "Sd_infectiontp", "Didef_code", "Didef_name", "Didef_syn_name", "Didef_syn_code", "Disys_code", "Disys_name"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id","Id_diitm");
				base.name_path_map.Add("pid","Id_parent");
            }
		}
    }
}
