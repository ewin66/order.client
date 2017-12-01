
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.opersafechecktab.d
{
    /// <summary>
    /// OperSafeCheckTableDO 的摘要说明。
    /// </summary>
    public class OperSafeCheckTableDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_opersafe";
		public const string TABLE_ALIAS_NAME = "a0";

        public OperSafeCheckTableDO() {
        }
		public string Id_opersafe {
            get { return getAttrVal<string>("Id_opersafe",null); }
            set { setAttrVal<string>("Id_opersafe", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Id_anesthesia {
            get { return getAttrVal<string>("Id_anesthesia",null); }
            set { setAttrVal<string>("Id_anesthesia", value); }
        }
		public string Sd_anesthesia {
            get { return getAttrVal<string>("Sd_anesthesia",null); }
            set { setAttrVal<string>("Sd_anesthesia", value); }
        }
		public string Oper_method {
            get { return getAttrVal<string>("Oper_method",null); }
            set { setAttrVal<string>("Oper_method", value); }
        }
		public string Id_emp_oper {
            get { return getAttrVal<string>("Id_emp_oper",null); }
            set { setAttrVal<string>("Id_emp_oper", value); }
        }
		public DateTime? Dt_oper {
            get { return getAttrVal<FDate>("Dt_oper",null); }
            set { setAttrVal<FDate>("Dt_oper", value); }
        }
		public string Id_group {
            get { return getAttrVal<string>("Id_group",null); }
            set { setAttrVal<string>("Id_group", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public int? Eu_patinfobeforeana {
            get { return getAttrVal<int?>("Eu_patinfobeforeana",null); }
            set { setAttrVal<int?>("Eu_patinfobeforeana", value); }
        }
		public int? Eu_opermodebeforeana {
            get { return getAttrVal<int?>("Eu_opermodebeforeana",null); }
            set { setAttrVal<int?>("Eu_opermodebeforeana", value); }
        }
		public int? Eu_ssbwybsq {
            get { return getAttrVal<int?>("Eu_ssbwybsq",null); }
            set { setAttrVal<int?>("Eu_ssbwybsq", value); }
        }
		public int? Eu_sszqty {
            get { return getAttrVal<int?>("Eu_sszqty",null); }
            set { setAttrVal<int?>("Eu_sszqty", value); }
        }
		public int? Eu_mzzqty {
            get { return getAttrVal<int?>("Eu_mzzqty",null); }
            set { setAttrVal<int?>("Eu_mzzqty", value); }
        }
		public int? Eu_mzfsqr {
            get { return getAttrVal<int?>("Eu_mzfsqr",null); }
            set { setAttrVal<int?>("Eu_mzfsqr", value); }
        }
		public int? Eu_mzsbaqjc {
            get { return getAttrVal<int?>("Eu_mzsbaqjc",null); }
            set { setAttrVal<int?>("Eu_mzsbaqjc", value); }
        }
		public int? Eu_pfsfwz {
            get { return getAttrVal<int?>("Eu_pfsfwz",null); }
            set { setAttrVal<int?>("Eu_pfsfwz", value); }
        }
		public int? Eu_sqpfzbzq {
            get { return getAttrVal<int?>("Eu_sqpfzbzq",null); }
            set { setAttrVal<int?>("Eu_sqpfzbzq", value); }
        }
		public int? Eu_jmtdjlwc {
            get { return getAttrVal<int?>("Eu_jmtdjlwc",null); }
            set { setAttrVal<int?>("Eu_jmtdjlwc", value); }
        }
		public int? Eu_hzsfygms {
            get { return getAttrVal<int?>("Eu_hzsfygms",null); }
            set { setAttrVal<int?>("Eu_hzsfygms", value); }
        }
		public int? Eu_kjywpsjg {
            get { return getAttrVal<int?>("Eu_kjywpsjg",null); }
            set { setAttrVal<int?>("Eu_kjywpsjg", value); }
        }
		public int? Eu_sqbx {
            get { return getAttrVal<int?>("Eu_sqbx",null); }
            set { setAttrVal<int?>("Eu_sqbx", value); }
        }
		public string Id_item_pre {
            get { return getAttrVal<string>("Id_item_pre",null); }
            set { setAttrVal<string>("Id_item_pre", value); }
        }
		public string Sd_item_pre {
            get { return getAttrVal<string>("Sd_item_pre",null); }
            set { setAttrVal<string>("Sd_item_pre", value); }
        }
		public string Bf_ana_other {
            get { return getAttrVal<string>("Bf_ana_other",null); }
            set { setAttrVal<string>("Bf_ana_other", value); }
        }
		public int? Eu_xmxbnl {
            get { return getAttrVal<int?>("Eu_xmxbnl",null); }
            set { setAttrVal<int?>("Eu_xmxbnl", value); }
        }
		public int? Eu_sqssfsqr {
            get { return getAttrVal<int?>("Eu_sqssfsqr",null); }
            set { setAttrVal<int?>("Eu_sqssfsqr", value); }
        }
		public int? Eu_sqssbwyb {
            get { return getAttrVal<int?>("Eu_sqssbwyb",null); }
            set { setAttrVal<int?>("Eu_sqssbwyb", value); }
        }
		public string Id_ssyscs {
            get { return getAttrVal<string>("Id_ssyscs",null); }
            set { setAttrVal<string>("Id_ssyscs", value); }
        }
		public string Sd_ssyscs {
            get { return getAttrVal<string>("Sd_ssyscs",null); }
            set { setAttrVal<string>("Sd_ssyscs", value); }
        }
		public string Id_mzyscs {
            get { return getAttrVal<string>("Id_mzyscs",null); }
            set { setAttrVal<string>("Id_mzyscs", value); }
        }
		public string Sd_mzyscs {
            get { return getAttrVal<string>("Sd_mzyscs",null); }
            set { setAttrVal<string>("Sd_mzyscs", value); }
        }
		public string Id_sshscs {
            get { return getAttrVal<string>("Id_sshscs",null); }
            set { setAttrVal<string>("Id_sshscs", value); }
        }
		public string Sd_sshscs {
            get { return getAttrVal<string>("Sd_sshscs",null); }
            set { setAttrVal<string>("Sd_sshscs", value); }
        }
		public int? Eu_sfxyxgyx {
            get { return getAttrVal<int?>("Eu_sfxyxgyx",null); }
            set { setAttrVal<int?>("Eu_sfxyxgyx", value); }
        }
		public string Bf_oper_other {
            get { return getAttrVal<string>("Bf_oper_other",null); }
            set { setAttrVal<string>("Bf_oper_other", value); }
        }
		public int? Eu_shhzxmdxbd {
            get { return getAttrVal<int?>("Eu_shhzxmdxbd",null); }
            set { setAttrVal<int?>("Eu_shhzxmdxbd", value); }
        }
		public int? Eu_sjssfsqr {
            get { return getAttrVal<int?>("Eu_sjssfsqr",null); }
            set { setAttrVal<int?>("Eu_sjssfsqr", value); }
        }
		public int? Eu_ssyydsxd {
            get { return getAttrVal<int?>("Eu_ssyydsxd",null); }
            set { setAttrVal<int?>("Eu_ssyydsxd", value); }
        }
		public int? Eu_ssywqdzq {
            get { return getAttrVal<int?>("Eu_ssywqdzq",null); }
            set { setAttrVal<int?>("Eu_ssywqdzq", value); }
        }
		public int? Eu_ssbbqr {
            get { return getAttrVal<int?>("Eu_ssbbqr",null); }
            set { setAttrVal<int?>("Eu_ssbbqr", value); }
        }
		public int? Eu_shpfsfwz {
            get { return getAttrVal<int?>("Eu_shpfsfwz",null); }
            set { setAttrVal<int?>("Eu_shpfsfwz", value); }
        }
		public string Id_gcgl {
            get { return getAttrVal<string>("Id_gcgl",null); }
            set { setAttrVal<string>("Id_gcgl", value); }
        }
		public string Sd_gcgl {
            get { return getAttrVal<string>("Sd_gcgl",null); }
            set { setAttrVal<string>("Sd_gcgl", value); }
        }
		public string Id_hzqx {
            get { return getAttrVal<string>("Id_hzqx",null); }
            set { setAttrVal<string>("Id_hzqx", value); }
        }
		public string Sd_hzqx {
            get { return getAttrVal<string>("Sd_hzqx",null); }
            set { setAttrVal<string>("Sd_hzqx", value); }
        }
		public string Pipe_other {
            get { return getAttrVal<string>("Pipe_other",null); }
            set { setAttrVal<string>("Pipe_other", value); }
        }
		public string Pat_lev_other {
            get { return getAttrVal<string>("Pat_lev_other",null); }
            set { setAttrVal<string>("Pat_lev_other", value); }
        }
		public string Id_sign_doc {
            get { return getAttrVal<string>("Id_sign_doc",null); }
            set { setAttrVal<string>("Id_sign_doc", value); }
        }
		public string Id_sign_anaer {
            get { return getAttrVal<string>("Id_sign_anaer",null); }
            set { setAttrVal<string>("Id_sign_anaer", value); }
        }
		public string Id_sign_nur {
            get { return getAttrVal<string>("Id_sign_nur",null); }
            set { setAttrVal<string>("Id_sign_nur", value); }
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
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_anesthesia {
            get { return getAttrVal<string>("Name_anesthesia",null); }
            set { setAttrVal<string>("Name_anesthesia", value); }
        }
		public string Name_emp_oper {
            get { return getAttrVal<string>("Name_emp_oper",null); }
            set { setAttrVal<string>("Name_emp_oper", value); }
        }
		public string Name_item_pre {
            get { return getAttrVal<string>("Name_item_pre",null); }
            set { setAttrVal<string>("Name_item_pre", value); }
        }
		public string Name_ssyscs {
            get { return getAttrVal<string>("Name_ssyscs",null); }
            set { setAttrVal<string>("Name_ssyscs", value); }
        }
		public string Name_mzyscs {
            get { return getAttrVal<string>("Name_mzyscs",null); }
            set { setAttrVal<string>("Name_mzyscs", value); }
        }
		public string Name_sshscs {
            get { return getAttrVal<string>("Name_sshscs",null); }
            set { setAttrVal<string>("Name_sshscs", value); }
        }
		public string Name_gcgl {
            get { return getAttrVal<string>("Name_gcgl",null); }
            set { setAttrVal<string>("Name_gcgl", value); }
        }
		public string Name_hzqx {
            get { return getAttrVal<string>("Name_hzqx",null); }
            set { setAttrVal<string>("Name_hzqx", value); }
        }
		public string Name_sign_doc {
            get { return getAttrVal<string>("Name_sign_doc",null); }
            set { setAttrVal<string>("Name_sign_doc", value); }
        }
		public string Name_sign_anaer {
            get { return getAttrVal<string>("Name_sign_anaer",null); }
            set { setAttrVal<string>("Name_sign_anaer", value); }
        }
		public string Name_sign_nur {
            get { return getAttrVal<string>("Name_sign_nur",null); }
            set { setAttrVal<string>("Name_sign_nur", value); }
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
            return "ci_mr_nu_opersafe";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_opersafe";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.opersafechecktab.d.OperSafeCheckTableDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_opersafe", "Id_ent", "Id_pat", "Code_entp", "Id_dep_phy", "Name_dep_phy", "Id_sex", "Sd_sex", "Age", "Code_amr_ip", "Id_anesthesia", "Sd_anesthesia", "Oper_method", "Id_emp_oper", "Dt_oper", "Id_group", "Id_org", "Eu_patinfobeforeana", "Eu_opermodebeforeana", "Eu_ssbwybsq", "Eu_sszqty", "Eu_mzzqty", "Eu_mzfsqr", "Eu_mzsbaqjc", "Eu_pfsfwz", "Eu_sqpfzbzq", "Eu_jmtdjlwc", "Eu_hzsfygms", "Eu_kjywpsjg", "Eu_sqbx", "Id_item_pre", "Sd_item_pre", "Bf_ana_other", "Eu_xmxbnl", "Eu_sqssfsqr", "Eu_sqssbwyb", "Id_ssyscs", "Sd_ssyscs", "Id_mzyscs", "Sd_mzyscs", "Id_sshscs", "Sd_sshscs", "Eu_sfxyxgyx", "Bf_oper_other", "Eu_shhzxmdxbd", "Eu_sjssfsqr", "Eu_ssyydsxd", "Eu_ssywqdzq", "Eu_ssbbqr", "Eu_shpfsfwz", "Id_gcgl", "Sd_gcgl", "Id_hzqx", "Sd_hzqx", "Pipe_other", "Pat_lev_other", "Id_sign_doc", "Id_sign_anaer", "Id_sign_nur", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_pat", "Name_sex", "Name_anesthesia", "Name_emp_oper", "Name_item_pre", "Name_ssyscs", "Name_mzyscs", "Name_sshscs", "Name_gcgl", "Name_hzqx", "Name_sign_doc", "Name_sign_anaer", "Name_sign_nur"};
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
				base.name_path_map.Add("id_group","Id_group");
            }
		}
    }
}
