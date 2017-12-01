
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// CiOrdBtTestItmDO 的摘要说明。
    /// </summary>
    public class CiOrdBtTestItmDO : BaseDO {

        public CiOrdBtTestItmDO() {
        }
		public string Id_rptbttestitm {
            get { return getAttrVal<string>("Id_rptbttestitm",null); }
            set { setAttrVal<string>("Id_rptbttestitm", value); }
        }
		public string Id_rptbttest {
            get { return getAttrVal<string>("Id_rptbttest",null); }
            set { setAttrVal<string>("Id_rptbttest", value); }
        }
		public string Id_tb {
            get { return getAttrVal<string>("Id_tb",null); }
            set { setAttrVal<string>("Id_tb", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_srv_bt {
            get { return getAttrVal<string>("Id_srv_bt",null); }
            set { setAttrVal<string>("Id_srv_bt", value); }
        }
		public string Barcode_bb {
            get { return getAttrVal<string>("Barcode_bb",null); }
            set { setAttrVal<string>("Barcode_bb", value); }
        }
		public int? Num_bb {
            get { return getAttrVal<int?>("Num_bb",null); }
            set { setAttrVal<int?>("Num_bb", value); }
        }
		public string Id_unit_bb {
            get { return getAttrVal<string>("Id_unit_bb",null); }
            set { setAttrVal<string>("Id_unit_bb", value); }
        }
		public string Id_abo_bt {
            get { return getAttrVal<string>("Id_abo_bt",null); }
            set { setAttrVal<string>("Id_abo_bt", value); }
        }
		public string Sd_abo_bt {
            get { return getAttrVal<string>("Sd_abo_bt",null); }
            set { setAttrVal<string>("Sd_abo_bt", value); }
        }
		public string Id_rh_bt {
            get { return getAttrVal<string>("Id_rh_bt",null); }
            set { setAttrVal<string>("Id_rh_bt", value); }
        }
		public string Sd_rh_bt {
            get { return getAttrVal<string>("Sd_rh_bt",null); }
            set { setAttrVal<string>("Sd_rh_bt", value); }
        }
		public string Id_testitmmeth {
            get { return getAttrVal<string>("Id_testitmmeth",null); }
            set { setAttrVal<string>("Id_testitmmeth", value); }
        }
		public string Sd_testitmmeth {
            get { return getAttrVal<string>("Sd_testitmmeth",null); }
            set { setAttrVal<string>("Sd_testitmmeth", value); }
        }
		public string Id_testitmres_m {
            get { return getAttrVal<string>("Id_testitmres_m",null); }
            set { setAttrVal<string>("Id_testitmres_m", value); }
        }
		public string Sd_testitmres_m {
            get { return getAttrVal<string>("Sd_testitmres_m",null); }
            set { setAttrVal<string>("Sd_testitmres_m", value); }
        }
		public string Id_testitmres_s {
            get { return getAttrVal<string>("Id_testitmres_s",null); }
            set { setAttrVal<string>("Id_testitmres_s", value); }
        }
		public string Sd_testitmres_s {
            get { return getAttrVal<string>("Sd_testitmres_s",null); }
            set { setAttrVal<string>("Sd_testitmres_s", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public string Id_emp_testitm {
            get { return getAttrVal<string>("Id_emp_testitm",null); }
            set { setAttrVal<string>("Id_emp_testitm", value); }
        }
		public string Id_emp_retestitm {
            get { return getAttrVal<string>("Id_emp_retestitm",null); }
            set { setAttrVal<string>("Id_emp_retestitm", value); }
        }
		public DateTime? Dt_restitm {
            get { return getAttrVal<FDateTime>("Dt_restitm",null); }
            set { setAttrVal<FDateTime>("Dt_restitm", value); }
        }
		public bool? Fg_st {
            get { return getAttrVal<FBoolean>("Fg_st",null); }
            set { setAttrVal<FBoolean>("Fg_st", value); }
        }
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
		public string Id_unit_pkgsp {
            get { return getAttrVal<string>("Id_unit_pkgsp",null); }
            set { setAttrVal<string>("Id_unit_pkgsp", value); }
        }
		public string Code_bt {
            get { return getAttrVal<string>("Code_bt",null); }
            set { setAttrVal<string>("Code_bt", value); }
        }
		public string Name_bt {
            get { return getAttrVal<string>("Name_bt",null); }
            set { setAttrVal<string>("Name_bt", value); }
        }
		public DateTime? Dt_st {
            get { return getAttrVal<FDateTime>("Dt_st",null); }
            set { setAttrVal<FDateTime>("Dt_st", value); }
        }
		public string Id_emp_st {
            get { return getAttrVal<string>("Id_emp_st",null); }
            set { setAttrVal<string>("Id_emp_st", value); }
        }
		public string Name_bt_srv {
            get { return getAttrVal<string>("Name_bt_srv",null); }
            set { setAttrVal<string>("Name_bt_srv", value); }
        }
		public string Code_bt_srv {
            get { return getAttrVal<string>("Code_bt_srv",null); }
            set { setAttrVal<string>("Code_bt_srv", value); }
        }
		public string Unit_bb_name {
            get { return getAttrVal<string>("Unit_bb_name",null); }
            set { setAttrVal<string>("Unit_bb_name", value); }
        }
		public string Abo_name {
            get { return getAttrVal<string>("Abo_name",null); }
            set { setAttrVal<string>("Abo_name", value); }
        }
		public string Rh_name {
            get { return getAttrVal<string>("Rh_name",null); }
            set { setAttrVal<string>("Rh_name", value); }
        }
		public string Bt_method_name {
            get { return getAttrVal<string>("Bt_method_name",null); }
            set { setAttrVal<string>("Bt_method_name", value); }
        }
		public string Bt_rsm_name {
            get { return getAttrVal<string>("Bt_rsm_name",null); }
            set { setAttrVal<string>("Bt_rsm_name", value); }
        }
		public string Bt_rss_name {
            get { return getAttrVal<string>("Bt_rss_name",null); }
            set { setAttrVal<string>("Bt_rss_name", value); }
        }
		public string Test_name {
            get { return getAttrVal<string>("Test_name",null); }
            set { setAttrVal<string>("Test_name", value); }
        }
		public string Retest_name {
            get { return getAttrVal<string>("Retest_name",null); }
            set { setAttrVal<string>("Retest_name", value); }
        }
		public string Mm_name {
            get { return getAttrVal<string>("Mm_name",null); }
            set { setAttrVal<string>("Mm_name", value); }
        }
		public string Pkgsp_unit_name {
            get { return getAttrVal<string>("Pkgsp_unit_name",null); }
            set { setAttrVal<string>("Pkgsp_unit_name", value); }
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
            return "CI_RPT_BTTESTITM";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptbttestitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.CiOrdBtTestItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptbttestitm", "Id_rptbttest", "Id_tb", "Sortno", "Id_srv_bt", "Barcode_bb", "Num_bb", "Id_unit_bb", "Id_abo_bt", "Sd_abo_bt", "Id_rh_bt", "Sd_rh_bt", "Id_testitmmeth", "Sd_testitmmeth", "Id_testitmres_m", "Sd_testitmres_m", "Id_testitmres_s", "Sd_testitmres_s", "Des", "Id_emp_testitm", "Id_emp_retestitm", "Dt_restitm", "Fg_st", "Id_mm", "Id_unit_pkgsp", "Code_bt", "Name_bt", "Dt_st", "Id_emp_st", "Name_bt_srv", "Code_bt_srv", "Unit_bb_name", "Abo_name", "Rh_name", "Bt_method_name", "Bt_rsm_name", "Bt_rss_name", "Test_name", "Retest_name", "Mm_name", "Pkgsp_unit_name"};
        }
        
    }
}
