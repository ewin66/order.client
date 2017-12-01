
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ordprn.d
{
    /// <summary>
    /// OrdPrintDO 的摘要说明。
    /// </summary>
    public class OrdPrintDO : BaseDO {

        public OrdPrintDO() {
        }
		public string Id_orprn {
            get { return getAttrVal<string>("Id_orprn",null); }
            set { setAttrVal<string>("Id_orprn", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }
		public string Content_or_prn {
            get { return getAttrVal<string>("Content_or_prn",null); }
            set { setAttrVal<string>("Content_or_prn", value); }
        }
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }
		public string Dt_effe_m {
            get { return getAttrVal<string>("Dt_effe_m",null); }
            set { setAttrVal<string>("Dt_effe_m", value); }
        }
		public string Dt_effe_d {
            get { return getAttrVal<string>("Dt_effe_d",null); }
            set { setAttrVal<string>("Dt_effe_d", value); }
        }
		public string Dt_effe_t {
            get { return getAttrVal<string>("Dt_effe_t",null); }
            set { setAttrVal<string>("Dt_effe_t", value); }
        }
		public string Id_emp_sign {
            get { return getAttrVal<string>("Id_emp_sign",null); }
            set { setAttrVal<string>("Id_emp_sign", value); }
        }
		public string Id_dep_sign {
            get { return getAttrVal<string>("Id_dep_sign",null); }
            set { setAttrVal<string>("Id_dep_sign", value); }
        }
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }
		public string Id_emp_chk {
            get { return getAttrVal<string>("Id_emp_chk",null); }
            set { setAttrVal<string>("Id_emp_chk", value); }
        }
		public string Id_dep_chk {
            get { return getAttrVal<string>("Id_dep_chk",null); }
            set { setAttrVal<string>("Id_dep_chk", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public string Dt_end_m {
            get { return getAttrVal<string>("Dt_end_m",null); }
            set { setAttrVal<string>("Dt_end_m", value); }
        }
		public string Dt_end_d {
            get { return getAttrVal<string>("Dt_end_d",null); }
            set { setAttrVal<string>("Dt_end_d", value); }
        }
		public string Dt_end_t {
            get { return getAttrVal<string>("Dt_end_t",null); }
            set { setAttrVal<string>("Dt_end_t", value); }
        }
		public string Id_emp_stop {
            get { return getAttrVal<string>("Id_emp_stop",null); }
            set { setAttrVal<string>("Id_emp_stop", value); }
        }
		public string Id_dep_stop {
            get { return getAttrVal<string>("Id_dep_stop",null); }
            set { setAttrVal<string>("Id_dep_stop", value); }
        }
		public bool? Fg_stop_prn {
            get { return getAttrVal<FBoolean>("Fg_stop_prn",null); }
            set { setAttrVal<FBoolean>("Fg_stop_prn", value); }
        }
		public bool? Fg_chk_stop {
            get { return getAttrVal<FBoolean>("Fg_chk_stop",null); }
            set { setAttrVal<FBoolean>("Fg_chk_stop", value); }
        }
		public string Id_emp_chk_stop {
            get { return getAttrVal<string>("Id_emp_chk_stop",null); }
            set { setAttrVal<string>("Id_emp_chk_stop", value); }
        }
		public string Id_dep_chk_stop {
            get { return getAttrVal<string>("Id_dep_chk_stop",null); }
            set { setAttrVal<string>("Id_dep_chk_stop", value); }
        }
		public bool? Fg_canc_prn {
            get { return getAttrVal<FBoolean>("Fg_canc_prn",null); }
            set { setAttrVal<FBoolean>("Fg_canc_prn", value); }
        }
		public bool? Fg_chk_canc {
            get { return getAttrVal<FBoolean>("Fg_chk_canc",null); }
            set { setAttrVal<FBoolean>("Fg_chk_canc", value); }
        }
		public DateTime? Dt_mp {
            get { return getAttrVal<FDateTime>("Dt_mp",null); }
            set { setAttrVal<FDateTime>("Dt_mp", value); }
        }
		public bool? Fg_reformed {
            get { return getAttrVal<FBoolean>("Fg_reformed",null); }
            set { setAttrVal<FBoolean>("Fg_reformed", value); }
        }
		public DateTime? Dt_reform {
            get { return getAttrVal<FDateTime>("Dt_reform",null); }
            set { setAttrVal<FDateTime>("Dt_reform", value); }
        }
		public bool? Fg_reformrow {
            get { return getAttrVal<FBoolean>("Fg_reformrow",null); }
            set { setAttrVal<FBoolean>("Fg_reformrow", value); }
        }
		public DateTime? Dt_prn {
            get { return getAttrVal<FDateTime>("Dt_prn",null); }
            set { setAttrVal<FDateTime>("Dt_prn", value); }
        }
		public int? Page_num {
            get { return getAttrVal<int?>("Page_num",null); }
            set { setAttrVal<int?>("Page_num", value); }
        }
		public int? Row_num {
            get { return getAttrVal<int?>("Row_num",null); }
            set { setAttrVal<int?>("Row_num", value); }
        }
		public int? Row_cnt {
            get { return getAttrVal<int?>("Row_cnt",null); }
            set { setAttrVal<int?>("Row_cnt", value); }
        }
		public string Id_dep_prn {
            get { return getAttrVal<string>("Id_dep_prn",null); }
            set { setAttrVal<string>("Id_dep_prn", value); }
        }
		public string Id_emp_prn {
            get { return getAttrVal<string>("Id_emp_prn",null); }
            set { setAttrVal<string>("Id_emp_prn", value); }
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
		public string Code_pat {
            get { return getAttrVal<string>("Code_pat",null); }
            set { setAttrVal<string>("Code_pat", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_pat_en {
            get { return getAttrVal<string>("Name_pat_en",null); }
            set { setAttrVal<string>("Name_pat_en", value); }
        }
		public string Code_pat_en {
            get { return getAttrVal<string>("Code_pat_en",null); }
            set { setAttrVal<string>("Code_pat_en", value); }
        }
		public string Code_dep_phy {
            get { return getAttrVal<string>("Code_dep_phy",null); }
            set { setAttrVal<string>("Code_dep_phy", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Code_dep_nur {
            get { return getAttrVal<string>("Code_dep_nur",null); }
            set { setAttrVal<string>("Code_dep_nur", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Code_emp_sign {
            get { return getAttrVal<string>("Code_emp_sign",null); }
            set { setAttrVal<string>("Code_emp_sign", value); }
        }
		public string Name_emp_sign {
            get { return getAttrVal<string>("Name_emp_sign",null); }
            set { setAttrVal<string>("Name_emp_sign", value); }
        }
		public string Code_dep_sign {
            get { return getAttrVal<string>("Code_dep_sign",null); }
            set { setAttrVal<string>("Code_dep_sign", value); }
        }
		public string Name_dep_sign {
            get { return getAttrVal<string>("Name_dep_sign",null); }
            set { setAttrVal<string>("Name_dep_sign", value); }
        }
		public string Code_emp_chk {
            get { return getAttrVal<string>("Code_emp_chk",null); }
            set { setAttrVal<string>("Code_emp_chk", value); }
        }
		public string Name_emp_chk {
            get { return getAttrVal<string>("Name_emp_chk",null); }
            set { setAttrVal<string>("Name_emp_chk", value); }
        }
		public string Code_dep_chk {
            get { return getAttrVal<string>("Code_dep_chk",null); }
            set { setAttrVal<string>("Code_dep_chk", value); }
        }
		public string Name_dep_chk {
            get { return getAttrVal<string>("Name_dep_chk",null); }
            set { setAttrVal<string>("Name_dep_chk", value); }
        }
		public string Code_emp_stop {
            get { return getAttrVal<string>("Code_emp_stop",null); }
            set { setAttrVal<string>("Code_emp_stop", value); }
        }
		public string Name_emp_stop {
            get { return getAttrVal<string>("Name_emp_stop",null); }
            set { setAttrVal<string>("Name_emp_stop", value); }
        }
		public string Code_dep_stop {
            get { return getAttrVal<string>("Code_dep_stop",null); }
            set { setAttrVal<string>("Code_dep_stop", value); }
        }
		public string Name_dep_stop {
            get { return getAttrVal<string>("Name_dep_stop",null); }
            set { setAttrVal<string>("Name_dep_stop", value); }
        }
		public string Code_emp_chk_stop {
            get { return getAttrVal<string>("Code_emp_chk_stop",null); }
            set { setAttrVal<string>("Code_emp_chk_stop", value); }
        }
		public string Name_emp_chk_stop {
            get { return getAttrVal<string>("Name_emp_chk_stop",null); }
            set { setAttrVal<string>("Name_emp_chk_stop", value); }
        }
		public string Code_dep_chk_stop {
            get { return getAttrVal<string>("Code_dep_chk_stop",null); }
            set { setAttrVal<string>("Code_dep_chk_stop", value); }
        }
		public string Name_dep_chk_stop {
            get { return getAttrVal<string>("Name_dep_chk_stop",null); }
            set { setAttrVal<string>("Name_dep_chk_stop", value); }
        }
		public string Code_dep_prn {
            get { return getAttrVal<string>("Code_dep_prn",null); }
            set { setAttrVal<string>("Code_dep_prn", value); }
        }
		public string Name_dep_prn {
            get { return getAttrVal<string>("Name_dep_prn",null); }
            set { setAttrVal<string>("Name_dep_prn", value); }
        }
		public string Code_emp_prn {
            get { return getAttrVal<string>("Code_emp_prn",null); }
            set { setAttrVal<string>("Code_emp_prn", value); }
        }
		public string Name_emp_prn {
            get { return getAttrVal<string>("Name_emp_prn",null); }
            set { setAttrVal<string>("Name_emp_prn", value); }
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
            return "ci_or_prn";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orprn";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordprn.d.OrdPrintDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orprn", "Id_grp", "Id_org", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Code_amr_ip", "Id_dep_phy", "Id_dep_nur", "Id_or", "Id_srvtp", "Sd_srvtp", "Fg_long", "Content_or_prn", "Dt_effe", "Dt_effe_m", "Dt_effe_d", "Dt_effe_t", "Id_emp_sign", "Id_dep_sign", "Fg_chk", "Id_emp_chk", "Id_dep_chk", "Dt_end", "Dt_end_m", "Dt_end_d", "Dt_end_t", "Id_emp_stop", "Id_dep_stop", "Fg_stop_prn", "Fg_chk_stop", "Id_emp_chk_stop", "Id_dep_chk_stop", "Fg_canc_prn", "Fg_chk_canc", "Dt_mp", "Fg_reformed", "Dt_reform", "Fg_reformrow", "Dt_prn", "Page_num", "Row_num", "Row_cnt", "Id_dep_prn", "Id_emp_prn", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Code_pat", "Name_pat", "Name_pat_en", "Code_pat_en", "Code_dep_phy", "Name_dep_phy", "Code_dep_nur", "Name_dep_nur", "Code_emp_sign", "Name_emp_sign", "Code_dep_sign", "Name_dep_sign", "Code_emp_chk", "Name_emp_chk", "Code_dep_chk", "Name_dep_chk", "Code_emp_stop", "Name_emp_stop", "Code_dep_stop", "Name_dep_stop", "Code_emp_chk_stop", "Name_emp_chk_stop", "Code_dep_chk_stop", "Name_dep_chk_stop", "Code_dep_prn", "Name_dep_prn", "Code_emp_prn", "Name_emp_prn"};
        }
        
    }
}
