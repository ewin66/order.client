
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApOutDO 的摘要说明。
    /// </summary>
    public class OrdApOutDO : BaseDO {

        public OrdApOutDO() {
            this.Fg_death = false;
            this.Fg_autopsy = false;
        }
		public string Id_orout {
            get { return getAttrVal<string>("Id_orout",null); }
            set { setAttrVal<string>("Id_orout", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_outtp {
            get { return getAttrVal<string>("Id_outtp",null); }
            set { setAttrVal<string>("Id_outtp", value); }
        }
		public string Sd_outtp {
            get { return getAttrVal<string>("Sd_outtp",null); }
            set { setAttrVal<string>("Sd_outtp", value); }
        }
		public DateTime? Dt_timeout {
            get { return getAttrVal<FDateTime>("Dt_timeout",null); }
            set { setAttrVal<FDateTime>("Dt_timeout", value); }
        }
		public string Id_dep_out {
            get { return getAttrVal<string>("Id_dep_out",null); }
            set { setAttrVal<string>("Id_dep_out", value); }
        }
		public string Id_dep_nur_out {
            get { return getAttrVal<string>("Id_dep_nur_out",null); }
            set { setAttrVal<string>("Id_dep_nur_out", value); }
        }
		public string Id_bed_out {
            get { return getAttrVal<string>("Id_bed_out",null); }
            set { setAttrVal<string>("Id_bed_out", value); }
        }
		public bool? Fg_death {
            get { return getAttrVal<FBoolean>("Fg_death",false); }
            set { setAttrVal<FBoolean>("Fg_death", value); }
        }
		public bool? Fg_autopsy {
            get { return getAttrVal<FBoolean>("Fg_autopsy",false); }
            set { setAttrVal<FBoolean>("Fg_autopsy", value); }
        }
		public string Des_outtp {
            get { return getAttrVal<string>("Des_outtp",null); }
            set { setAttrVal<string>("Des_outtp", value); }
        }
		public bool? Fg_again31 {
            get { return getAttrVal<FBoolean>("Fg_again31",null); }
            set { setAttrVal<FBoolean>("Fg_again31", value); }
        }
		public string Des_again31 {
            get { return getAttrVal<string>("Des_again31",null); }
            set { setAttrVal<string>("Des_again31", value); }
        }
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
        }
		public string Def6 {
            get { return getAttrVal<string>("Def6",null); }
            set { setAttrVal<string>("Def6", value); }
        }
		public string Def7 {
            get { return getAttrVal<string>("Def7",null); }
            set { setAttrVal<string>("Def7", value); }
        }
		public string Def8 {
            get { return getAttrVal<string>("Def8",null); }
            set { setAttrVal<string>("Def8", value); }
        }
		public string Def9 {
            get { return getAttrVal<string>("Def9",null); }
            set { setAttrVal<string>("Def9", value); }
        }
		public string Def10 {
            get { return getAttrVal<string>("Def10",null); }
            set { setAttrVal<string>("Def10", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Name_outtp {
            get { return getAttrVal<string>("Name_outtp",null); }
            set { setAttrVal<string>("Name_outtp", value); }
        }
		public string Name_dep_out {
            get { return getAttrVal<string>("Name_dep_out",null); }
            set { setAttrVal<string>("Name_dep_out", value); }
        }
		public string Name_dep_nur_out {
            get { return getAttrVal<string>("Name_dep_nur_out",null); }
            set { setAttrVal<string>("Name_dep_nur_out", value); }
        }
		public string Name_bed_out {
            get { return getAttrVal<string>("Name_bed_out",null); }
            set { setAttrVal<string>("Name_bed_out", value); }
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
            return "ci_ap_out";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orout";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApOutDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orout", "Id_or", "Id_outtp", "Sd_outtp", "Dt_timeout", "Id_dep_out", "Id_dep_nur_out", "Id_bed_out", "Fg_death", "Fg_autopsy", "Des_outtp", "Fg_again31", "Des_again31", "Def1", "Def2", "Def3", "Def4", "Def5", "Def6", "Def7", "Def8", "Def9", "Def10", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_outtp", "Name_dep_out", "Name_dep_nur_out", "Name_bed_out"};
        }
        
    }
}
