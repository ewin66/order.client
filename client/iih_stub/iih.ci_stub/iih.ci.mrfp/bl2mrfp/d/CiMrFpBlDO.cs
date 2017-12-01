
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.bl2mrfp.d
{
    /// <summary>
    /// CiMrFpBlDO 的摘要说明。
    /// </summary>
    public class CiMrFpBlDO : BaseDO {

        public CiMrFpBlDO() {
        }
		public string Id_mrfpbl {
            get { return getAttrVal<string>("Id_mrfpbl",null); }
            set { setAttrVal<string>("Id_mrfpbl", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_mrfp {
            get { return getAttrVal<string>("Id_mrfp",null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Id_srv_bl {
            get { return getAttrVal<string>("Id_srv_bl",null); }
            set { setAttrVal<string>("Id_srv_bl", value); }
        }
		public string Name_srv_bl {
            get { return getAttrVal<string>("Name_srv_bl",null); }
            set { setAttrVal<string>("Name_srv_bl", value); }
        }
		public double? Amount {
            get { return getAttrVal<FDouble>("Amount",null); }
            set { setAttrVal<FDouble>("Amount", value); }
        }
		public double? Cms_gmsfee {
            get { return getAttrVal<FDouble>("Cms_gmsfee",null); }
            set { setAttrVal<FDouble>("Cms_gmsfee", value); }
        }
		public double? Cms_gtofee {
            get { return getAttrVal<FDouble>("Cms_gtofee",null); }
            set { setAttrVal<FDouble>("Cms_gtofee", value); }
        }
		public double? Cms_nurfee {
            get { return getAttrVal<FDouble>("Cms_nurfee",null); }
            set { setAttrVal<FDouble>("Cms_nurfee", value); }
        }
		public double? Cms_otherfee {
            get { return getAttrVal<FDouble>("Cms_otherfee",null); }
            set { setAttrVal<FDouble>("Cms_otherfee", value); }
        }
		public double? Cms_spamount {
            get { return getAttrVal<FDouble>("Cms_spamount",null); }
            set { setAttrVal<FDouble>("Cms_spamount", value); }
        }
		public double? Di_pdifee {
            get { return getAttrVal<FDouble>("Di_pdifee",null); }
            set { setAttrVal<FDouble>("Di_pdifee", value); }
        }
		public double? Di_ldifee {
            get { return getAttrVal<FDouble>("Di_ldifee",null); }
            set { setAttrVal<FDouble>("Di_ldifee", value); }
        }
		public double? Di_idifee {
            get { return getAttrVal<FDouble>("Di_idifee",null); }
            set { setAttrVal<FDouble>("Di_idifee", value); }
        }
		public double? Di_cdifee {
            get { return getAttrVal<FDouble>("Di_cdifee",null); }
            set { setAttrVal<FDouble>("Di_cdifee", value); }
        }
		public double? Tc_nstpfee {
            get { return getAttrVal<FDouble>("Tc_nstpfee",null); }
            set { setAttrVal<FDouble>("Tc_nstpfee", value); }
        }
		public double? Tc_cptfee {
            get { return getAttrVal<FDouble>("Tc_cptfee",null); }
            set { setAttrVal<FDouble>("Tc_cptfee", value); }
        }
		public double? Tc_stfee {
            get { return getAttrVal<FDouble>("Tc_stfee",null); }
            set { setAttrVal<FDouble>("Tc_stfee", value); }
        }
		public double? Tc_anfee {
            get { return getAttrVal<FDouble>("Tc_anfee",null); }
            set { setAttrVal<FDouble>("Tc_anfee", value); }
        }
		public double? Tc_opfee {
            get { return getAttrVal<FDouble>("Tc_opfee",null); }
            set { setAttrVal<FDouble>("Tc_opfee", value); }
        }
		public double? Rc_rcfee {
            get { return getAttrVal<FDouble>("Rc_rcfee",null); }
            set { setAttrVal<FDouble>("Rc_rcfee", value); }
        }
		public double? Tcm_cmtfee {
            get { return getAttrVal<FDouble>("Tcm_cmtfee",null); }
            set { setAttrVal<FDouble>("Tcm_cmtfee", value); }
        }
		public double? Wm_wmfee {
            get { return getAttrVal<FDouble>("Wm_wmfee",null); }
            set { setAttrVal<FDouble>("Wm_wmfee", value); }
        }
		public double? Wm_agfee {
            get { return getAttrVal<FDouble>("Wm_agfee",null); }
            set { setAttrVal<FDouble>("Wm_agfee", value); }
        }
		public double? Tcmt_cpmfee {
            get { return getAttrVal<FDouble>("Tcmt_cpmfee",null); }
            set { setAttrVal<FDouble>("Tcmt_cpmfee", value); }
        }
		public double? Tcmt_chmfee {
            get { return getAttrVal<FDouble>("Tcmt_chmfee",null); }
            set { setAttrVal<FDouble>("Tcmt_chmfee", value); }
        }
		public double? Babp_bfee {
            get { return getAttrVal<FDouble>("Babp_bfee",null); }
            set { setAttrVal<FDouble>("Babp_bfee", value); }
        }
		public double? Babp_apfee {
            get { return getAttrVal<FDouble>("Babp_apfee",null); }
            set { setAttrVal<FDouble>("Babp_apfee", value); }
        }
		public double? Babp_gpfee {
            get { return getAttrVal<FDouble>("Babp_gpfee",null); }
            set { setAttrVal<FDouble>("Babp_gpfee", value); }
        }
		public double? Babp_bcffee {
            get { return getAttrVal<FDouble>("Babp_bcffee",null); }
            set { setAttrVal<FDouble>("Babp_bcffee", value); }
        }
		public double? Babp_cflfee {
            get { return getAttrVal<FDouble>("Babp_cflfee",null); }
            set { setAttrVal<FDouble>("Babp_cflfee", value); }
        }
		public double? Sc_dmmfifee {
            get { return getAttrVal<FDouble>("Sc_dmmfifee",null); }
            set { setAttrVal<FDouble>("Sc_dmmfifee", value); }
        }
		public double? Sc_dmmftfee {
            get { return getAttrVal<FDouble>("Sc_dmmftfee",null); }
            set { setAttrVal<FDouble>("Sc_dmmftfee", value); }
        }
		public double? Sc_dmmfsfee {
            get { return getAttrVal<FDouble>("Sc_dmmfsfee",null); }
            set { setAttrVal<FDouble>("Sc_dmmfsfee", value); }
        }
		public double? Oc_ocfee {
            get { return getAttrVal<FDouble>("Oc_ocfee",null); }
            set { setAttrVal<FDouble>("Oc_ocfee", value); }
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
            return "CI_MR_FP_BL";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_mrfpbl";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_mrfpbl", "Id_ent", "Id_pat", "Id_mrfp", "Sortno", "Id_srv_bl", "Name_srv_bl", "Amount", "Cms_gmsfee", "Cms_gtofee", "Cms_nurfee", "Cms_otherfee", "Cms_spamount", "Di_pdifee", "Di_ldifee", "Di_idifee", "Di_cdifee", "Tc_nstpfee", "Tc_cptfee", "Tc_stfee", "Tc_anfee", "Tc_opfee", "Rc_rcfee", "Tcm_cmtfee", "Wm_wmfee", "Wm_agfee", "Tcmt_cpmfee", "Tcmt_chmfee", "Babp_bfee", "Babp_apfee", "Babp_gpfee", "Babp_bcffee", "Babp_cflfee", "Sc_dmmfifee", "Sc_dmmftfee", "Sc_dmmfsfee", "Oc_ocfee"};
        }
        
    }
}
