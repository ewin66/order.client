
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// OrdApBtDO 的摘要说明。
    /// </summary>
    public class OrdApBtDO : BaseDO {

        public OrdApBtDO() {
            this.Fg_prn = false;
            this.Cnt_prn = 0;
        }
		public string Id_apbt {
            get { return getAttrVal<string>("Id_apbt",null); }
            set { setAttrVal<string>("Id_apbt", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Str_id_diitm {
            get { return getAttrVal<string>("Str_id_diitm",null); }
            set { setAttrVal<string>("Str_id_diitm", value); }
        }
		public string Str_code_di {
            get { return getAttrVal<string>("Str_code_di",null); }
            set { setAttrVal<string>("Str_code_di", value); }
        }
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }
		public int? Pregnant_num {
            get { return getAttrVal<int?>("Pregnant_num",null); }
            set { setAttrVal<int?>("Pregnant_num", value); }
        }
		public int? Parturition_cnt {
            get { return getAttrVal<int?>("Parturition_cnt",null); }
            set { setAttrVal<int?>("Parturition_cnt", value); }
        }
		public string Id_his_bt {
            get { return getAttrVal<string>("Id_his_bt",null); }
            set { setAttrVal<string>("Id_his_bt", value); }
        }
		public string Sd_his_bt {
            get { return getAttrVal<string>("Sd_his_bt",null); }
            set { setAttrVal<string>("Sd_his_bt", value); }
        }
		public string Id_pps_bt {
            get { return getAttrVal<string>("Id_pps_bt",null); }
            set { setAttrVal<string>("Id_pps_bt", value); }
        }
		public string Sd_pps_bt {
            get { return getAttrVal<string>("Sd_pps_bt",null); }
            set { setAttrVal<string>("Sd_pps_bt", value); }
        }
		public string Des_pps_bt {
            get { return getAttrVal<string>("Des_pps_bt",null); }
            set { setAttrVal<string>("Des_pps_bt", value); }
        }
		public bool? Fg_db {
            get { return getAttrVal<FBoolean>("Fg_db",null); }
            set { setAttrVal<FBoolean>("Fg_db", value); }
        }
		public string No_db {
            get { return getAttrVal<string>("No_db",null); }
            set { setAttrVal<string>("No_db", value); }
        }
		public string Id_labitmexplain {
            get { return getAttrVal<string>("Id_labitmexplain",null); }
            set { setAttrVal<string>("Id_labitmexplain", value); }
        }
		public string Sd_labitmexplain {
            get { return getAttrVal<string>("Sd_labitmexplain",null); }
            set { setAttrVal<string>("Sd_labitmexplain", value); }
        }
		public string Id_demandsu_bt {
            get { return getAttrVal<string>("Id_demandsu_bt",null); }
            set { setAttrVal<string>("Id_demandsu_bt", value); }
        }
		public string Sd_demandsu_bt {
            get { return getAttrVal<string>("Sd_demandsu_bt",null); }
            set { setAttrVal<string>("Sd_demandsu_bt", value); }
        }
		public string Id_mode_bt {
            get { return getAttrVal<string>("Id_mode_bt",null); }
            set { setAttrVal<string>("Id_mode_bt", value); }
        }
		public string Sd_mode_bt {
            get { return getAttrVal<string>("Sd_mode_bt",null); }
            set { setAttrVal<string>("Sd_mode_bt", value); }
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
		public FDouble Num_margin_bu {
            get { return getAttrVal<FDouble>("Num_margin_bu",null); }
            set { setAttrVal<FDouble>("Num_margin_bu", value); }
        }
		public string Dt_bt_pl {
            get { return getAttrVal<string>("Dt_bt_pl",null); }
            set { setAttrVal<string>("Dt_bt_pl", value); }
        }
		public string Sd_su_bt {
            get { return getAttrVal<string>("Sd_su_bt",null); }
            set { setAttrVal<string>("Sd_su_bt", value); }
        }
		public string Id_su_bt {
            get { return getAttrVal<string>("Id_su_bt",null); }
            set { setAttrVal<string>("Id_su_bt", value); }
        }
		public string Fg_rpt {
            get { return getAttrVal<string>("Fg_rpt",null); }
            set { setAttrVal<string>("Fg_rpt", value); }
        }
		public string Name_diag {
            get { return getAttrVal<string>("Name_diag",null); }
            set { setAttrVal<string>("Name_diag", value); }
        }
		public bool? Fg_prn {
            get { return getAttrVal<FBoolean>("Fg_prn",false); }
            set { setAttrVal<FBoolean>("Fg_prn", value); }
        }
		public int? Cnt_prn {
            get { return getAttrVal<int?>("Cnt_prn",0); }
            set { setAttrVal<int?>("Cnt_prn", value); }
        }
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
		public string Id_didef_dis {
            get { return getAttrVal<string>("Id_didef_dis",null); }
            set { setAttrVal<string>("Id_didef_dis", value); }
        }
		public string Name_his_bt {
            get { return getAttrVal<string>("Name_his_bt",null); }
            set { setAttrVal<string>("Name_his_bt", value); }
        }
		public string Name_pps_bt {
            get { return getAttrVal<string>("Name_pps_bt",null); }
            set { setAttrVal<string>("Name_pps_bt", value); }
        }
		public string Name_labitmexplain {
            get { return getAttrVal<string>("Name_labitmexplain",null); }
            set { setAttrVal<string>("Name_labitmexplain", value); }
        }
		public string Name_demandsu_bt {
            get { return getAttrVal<string>("Name_demandsu_bt",null); }
            set { setAttrVal<string>("Name_demandsu_bt", value); }
        }
		public string Name_mode_bt {
            get { return getAttrVal<string>("Name_mode_bt",null); }
            set { setAttrVal<string>("Name_mode_bt", value); }
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
            return "ci_ap_bt";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_apbt";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.OrdApBtDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_apbt", "Id_or", "Id_di", "Str_id_diitm", "Str_code_di", "Str_name_di", "No_applyform", "Pregnant_num", "Parturition_cnt", "Id_his_bt", "Sd_his_bt", "Id_pps_bt", "Sd_pps_bt", "Des_pps_bt", "Fg_db", "No_db", "Id_labitmexplain", "Sd_labitmexplain", "Id_demandsu_bt", "Sd_demandsu_bt", "Id_mode_bt", "Sd_mode_bt", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Num_margin_bu", "Dt_bt_pl", "Sd_su_bt", "Id_su_bt", "Fg_rpt", "Name_diag", "Fg_prn", "Cnt_prn", "Id_diitm", "Id_didef_dis", "Name_his_bt", "Name_pps_bt", "Name_labitmexplain", "Name_demandsu_bt", "Name_mode_bt"};
        }
        
    }
}
