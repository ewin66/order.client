
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// CiOrdBtTestDO 的摘要说明。
    /// </summary>
    public class CiOrdBtTestDO : BaseDO {

        public CiOrdBtTestDO() {
        }
		public string Id_rptbttest {
            get { return getAttrVal<string>("Id_rptbttest",null); }
            set { setAttrVal<string>("Id_rptbttest", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public string Id_apbt {
            get { return getAttrVal<string>("Id_apbt",null); }
            set { setAttrVal<string>("Id_apbt", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_srv_bt {
            get { return getAttrVal<string>("Id_srv_bt",null); }
            set { setAttrVal<string>("Id_srv_bt", value); }
        }
		public string Id_abo_pat {
            get { return getAttrVal<string>("Id_abo_pat",null); }
            set { setAttrVal<string>("Id_abo_pat", value); }
        }
		public string Sd_abo_pat {
            get { return getAttrVal<string>("Sd_abo_pat",null); }
            set { setAttrVal<string>("Sd_abo_pat", value); }
        }
		public string Id_rh_pat {
            get { return getAttrVal<string>("Id_rh_pat",null); }
            set { setAttrVal<string>("Id_rh_pat", value); }
        }
		public string Sd_rh_pat {
            get { return getAttrVal<string>("Sd_rh_pat",null); }
            set { setAttrVal<string>("Sd_rh_pat", value); }
        }
		public string Id_emp_recheck {
            get { return getAttrVal<string>("Id_emp_recheck",null); }
            set { setAttrVal<string>("Id_emp_recheck", value); }
        }
		public DateTime? Dt_recheck {
            get { return getAttrVal<FDateTime>("Dt_recheck",null); }
            set { setAttrVal<FDateTime>("Dt_recheck", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public int? Num_bt {
            get { return getAttrVal<int?>("Num_bt",null); }
            set { setAttrVal<int?>("Num_bt", value); }
        }
		public string Id_unit_bt {
            get { return getAttrVal<string>("Id_unit_bt",null); }
            set { setAttrVal<string>("Id_unit_bt", value); }
        }
		public int? Num_st {
            get { return getAttrVal<int?>("Num_st",null); }
            set { setAttrVal<int?>("Num_st", value); }
        }
		public string Id_unit_st {
            get { return getAttrVal<string>("Id_unit_st",null); }
            set { setAttrVal<string>("Id_unit_st", value); }
        }
		public string Id_su_bttest {
            get { return getAttrVal<string>("Id_su_bttest",null); }
            set { setAttrVal<string>("Id_su_bttest", value); }
        }
		public string Sd_su_bttest {
            get { return getAttrVal<string>("Sd_su_bttest",null); }
            set { setAttrVal<string>("Sd_su_bttest", value); }
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
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }
		public string Applyformno {
            get { return getAttrVal<string>("Applyformno",null); }
            set { setAttrVal<string>("Applyformno", value); }
        }
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_bt {
            get { return getAttrVal<string>("Name_bt",null); }
            set { setAttrVal<string>("Name_bt", value); }
        }
		public string Abo_name {
            get { return getAttrVal<string>("Abo_name",null); }
            set { setAttrVal<string>("Abo_name", value); }
        }
		public string Rh_name {
            get { return getAttrVal<string>("Rh_name",null); }
            set { setAttrVal<string>("Rh_name", value); }
        }
		public string Recheck_name {
            get { return getAttrVal<string>("Recheck_name",null); }
            set { setAttrVal<string>("Recheck_name", value); }
        }
		public string Bt_unit_name {
            get { return getAttrVal<string>("Bt_unit_name",null); }
            set { setAttrVal<string>("Bt_unit_name", value); }
        }
		public string St_unit_name {
            get { return getAttrVal<string>("St_unit_name",null); }
            set { setAttrVal<string>("St_unit_name", value); }
        }
		public string Su_bttest_name {
            get { return getAttrVal<string>("Su_bttest_name",null); }
            set { setAttrVal<string>("Su_bttest_name", value); }
        }
		public string Medu_name {
            get { return getAttrVal<string>("Medu_name",null); }
            set { setAttrVal<string>("Medu_name", value); }
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
            return "CI_RPT_BTTEST";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptbttest";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.CiOrdBtTestDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptbttest", "No_applyform", "Id_apbt", "Id_or", "Id_pat", "Id_ent", "Id_srv_bt", "Id_abo_pat", "Sd_abo_pat", "Id_rh_pat", "Sd_rh_pat", "Id_emp_recheck", "Dt_recheck", "Des", "Num_bt", "Id_unit_bt", "Num_st", "Id_unit_st", "Id_su_bttest", "Sd_su_bttest", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Quan_medu", "Id_medu", "Applyformno", "Ent_code", "Name_pat", "Name_bt", "Abo_name", "Rh_name", "Recheck_name", "Bt_unit_name", "St_unit_name", "Su_bttest_name", "Medu_name"};
        }
        
    }
}
