
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.cimrvt.d
{
    /// <summary>
    /// CiMrVtItmDO 的摘要说明。
    /// </summary>
    public class CiMrVtItmDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_vt_itm";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiMrVtItmDO() {
        }
		public string Id_mrvtitm {
            get { return getAttrVal<string>("Id_mrvtitm",null); }
            set { setAttrVal<string>("Id_mrvtitm", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_mrvt {
            get { return getAttrVal<string>("Id_mrvt",null); }
            set { setAttrVal<string>("Id_mrvt", value); }
        }
		public string Id_mrtplvtitm {
            get { return getAttrVal<string>("Id_mrtplvtitm",null); }
            set { setAttrVal<string>("Id_mrtplvtitm", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public bool? Fg_temsheet {
            get { return getAttrVal<FBoolean>("Fg_temsheet",null); }
            set { setAttrVal<FBoolean>("Fg_temsheet", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Valcount {
            get { return getAttrVal<string>("Valcount",null); }
            set { setAttrVal<string>("Valcount", value); }
        }
		public string Value {
            get { return getAttrVal<string>("Value",null); }
            set { setAttrVal<string>("Value", value); }
        }
		public bool? Fg_pos {
            get { return getAttrVal<FBoolean>("Fg_pos",null); }
            set { setAttrVal<FBoolean>("Fg_pos", value); }
        }
		public string Id_vt_pos {
            get { return getAttrVal<string>("Id_vt_pos",null); }
            set { setAttrVal<string>("Id_vt_pos", value); }
        }
		public string Sd_vt_pos {
            get { return getAttrVal<string>("Sd_vt_pos",null); }
            set { setAttrVal<string>("Sd_vt_pos", value); }
        }
		public bool? Fg_aux {
            get { return getAttrVal<FBoolean>("Fg_aux",null); }
            set { setAttrVal<FBoolean>("Fg_aux", value); }
        }
		public string Id_vt_aux {
            get { return getAttrVal<string>("Id_vt_aux",null); }
            set { setAttrVal<string>("Id_vt_aux", value); }
        }
		public string Sd_vt_aux {
            get { return getAttrVal<string>("Sd_vt_aux",null); }
            set { setAttrVal<string>("Sd_vt_aux", value); }
        }
		public string Value1 {
            get { return getAttrVal<string>("Value1",null); }
            set { setAttrVal<string>("Value1", value); }
        }
		public string Value2 {
            get { return getAttrVal<string>("Value2",null); }
            set { setAttrVal<string>("Value2", value); }
        }
		public string Value3 {
            get { return getAttrVal<string>("Value3",null); }
            set { setAttrVal<string>("Value3", value); }
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
            return "ci_mr_vt_itm";
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
            return "Id_mrvtitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrvt.d.CiMrVtItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrvtitm", "Id_org", "Id_grp", "Id_mrvt", "Id_mrtplvtitm", "Sortno", "Fg_temsheet", "Id_srv", "Name", "Valcount", "Value", "Fg_pos", "Id_vt_pos", "Sd_vt_pos", "Fg_aux", "Id_vt_aux", "Sd_vt_aux", "Value1", "Value2", "Value3"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("id_org","Id_org");
				base.name_path_map.Add("id_group","Id_grp");
            }
		}
    }
}
