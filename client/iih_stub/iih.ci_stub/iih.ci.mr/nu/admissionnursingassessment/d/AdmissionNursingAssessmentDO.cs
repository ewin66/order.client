
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.admissionnursingassessment.d
{
    /// <summary>
    /// AdmissionNursingAssessmentDO 的摘要说明。
    /// </summary>
    public class AdmissionNursingAssessmentDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_ANA";
		public const string TABLE_ALIAS_NAME = "a0";

        public AdmissionNursingAssessmentDO() {
        }
		public string Id_ana {
            get { return getAttrVal<string>("Id_ana",null); }
            set { setAttrVal<string>("Id_ana", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
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
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_diagnosis {
            get { return getAttrVal<string>("Name_diagnosis",null); }
            set { setAttrVal<string>("Name_diagnosis", value); }
        }
		public string Glqt {
            get { return getAttrVal<string>("Glqt",null); }
            set { setAttrVal<string>("Glqt", value); }
        }
		public string Sd_referalsrc {
            get { return getAttrVal<string>("Sd_referalsrc",null); }
            set { setAttrVal<string>("Sd_referalsrc", value); }
        }
		public string Id_referalsrc {
            get { return getAttrVal<string>("Id_referalsrc",null); }
            set { setAttrVal<string>("Id_referalsrc", value); }
        }
		public string Other_referalsrc {
            get { return getAttrVal<string>("Other_referalsrc",null); }
            set { setAttrVal<string>("Other_referalsrc", value); }
        }
		public string Id_ryxdfs {
            get { return getAttrVal<string>("Id_ryxdfs",null); }
            set { setAttrVal<string>("Id_ryxdfs", value); }
        }
		public string Sd_yrxdfs {
            get { return getAttrVal<string>("Sd_yrxdfs",null); }
            set { setAttrVal<string>("Sd_yrxdfs", value); }
        }
		public string Ryxdfs_other {
            get { return getAttrVal<string>("Ryxdfs_other",null); }
            set { setAttrVal<string>("Ryxdfs_other", value); }
        }
		public string Id_jy {
            get { return getAttrVal<string>("Id_jy",null); }
            set { setAttrVal<string>("Id_jy", value); }
        }
		public string Sd_jy {
            get { return getAttrVal<string>("Sd_jy",null); }
            set { setAttrVal<string>("Sd_jy", value); }
        }
		public int? Eu_zj {
            get { return getAttrVal<int?>("Eu_zj",null); }
            set { setAttrVal<int?>("Eu_zj", value); }
        }
		public int? Eu_pb {
            get { return getAttrVal<int?>("Eu_pb",null); }
            set { setAttrVal<int?>("Eu_pb", value); }
        }
		public int? Eu_gms {
            get { return getAttrVal<int?>("Eu_gms",null); }
            set { setAttrVal<int?>("Eu_gms", value); }
        }
		public int? Eu_shxy {
            get { return getAttrVal<int?>("Eu_shxy",null); }
            set { setAttrVal<int?>("Eu_shxy", value); }
        }
		public int? Eu_shyj {
            get { return getAttrVal<int?>("Eu_shyj",null); }
            set { setAttrVal<int?>("Eu_shyj", value); }
        }
		public int? Eu_jws {
            get { return getAttrVal<int?>("Eu_jws",null); }
            set { setAttrVal<int?>("Eu_jws", value); }
        }
		public int? Eu_qx {
            get { return getAttrVal<int?>("Eu_qx",null); }
            set { setAttrVal<int?>("Eu_qx", value); }
        }
		public string Id_qxxx {
            get { return getAttrVal<string>("Id_qxxx",null); }
            set { setAttrVal<string>("Id_qxxx", value); }
        }
		public string Sd_qxxx {
            get { return getAttrVal<string>("Sd_qxxx",null); }
            set { setAttrVal<string>("Sd_qxxx", value); }
        }
		public string Other_qxxx {
            get { return getAttrVal<string>("Other_qxxx",null); }
            set { setAttrVal<string>("Other_qxxx", value); }
        }
		public int? Eu_yssp {
            get { return getAttrVal<int?>("Eu_yssp",null); }
            set { setAttrVal<int?>("Eu_yssp", value); }
        }
		public string Id_ysspycxx {
            get { return getAttrVal<string>("Id_ysspycxx",null); }
            set { setAttrVal<string>("Id_ysspycxx", value); }
        }
		public string Sd_ysspycxx {
            get { return getAttrVal<string>("Sd_ysspycxx",null); }
            set { setAttrVal<string>("Sd_ysspycxx", value); }
        }
		public string Other_ysspycxx {
            get { return getAttrVal<string>("Other_ysspycxx",null); }
            set { setAttrVal<string>("Other_ysspycxx", value); }
        }
		public int? Eu_stzksl {
            get { return getAttrVal<int?>("Eu_stzksl",null); }
            set { setAttrVal<int?>("Eu_stzksl", value); }
        }
		public string Id_stzkslxx {
            get { return getAttrVal<string>("Id_stzkslxx",null); }
            set { setAttrVal<string>("Id_stzkslxx", value); }
        }
		public string Sd_stzkslxx {
            get { return getAttrVal<string>("Sd_stzkslxx",null); }
            set { setAttrVal<string>("Sd_stzkslxx", value); }
        }
		public string Other_stzkslxx {
            get { return getAttrVal<string>("Other_stzkslxx",null); }
            set { setAttrVal<string>("Other_stzkslxx", value); }
        }
		public int? Eu_stzktl {
            get { return getAttrVal<int?>("Eu_stzktl",null); }
            set { setAttrVal<int?>("Eu_stzktl", value); }
        }
		public string Id_stzktlxx {
            get { return getAttrVal<string>("Id_stzktlxx",null); }
            set { setAttrVal<string>("Id_stzktlxx", value); }
        }
		public string Sd_stzktlxx {
            get { return getAttrVal<string>("Sd_stzktlxx",null); }
            set { setAttrVal<string>("Sd_stzktlxx", value); }
        }
		public string Other_stzktlxx {
            get { return getAttrVal<string>("Other_stzktlxx",null); }
            set { setAttrVal<string>("Other_stzktlxx", value); }
        }
		public int? Eu_stzkyy {
            get { return getAttrVal<int?>("Eu_stzkyy",null); }
            set { setAttrVal<int?>("Eu_stzkyy", value); }
        }
		public string Id_stzkyyxx {
            get { return getAttrVal<string>("Id_stzkyyxx",null); }
            set { setAttrVal<string>("Id_stzkyyxx", value); }
        }
		public string Sd_stzkyyxx {
            get { return getAttrVal<string>("Sd_stzkyyxx",null); }
            set { setAttrVal<string>("Sd_stzkyyxx", value); }
        }
		public string Other_stzkyyxx {
            get { return getAttrVal<string>("Other_stzkyyxx",null); }
            set { setAttrVal<string>("Other_stzkyyxx", value); }
        }
		public int? Eu_stzkmr {
            get { return getAttrVal<int?>("Eu_stzkmr",null); }
            set { setAttrVal<int?>("Eu_stzkmr", value); }
        }
		public string Id_stzkmrxx {
            get { return getAttrVal<string>("Id_stzkmrxx",null); }
            set { setAttrVal<string>("Id_stzkmrxx", value); }
        }
		public string Sd_stzkmrxx {
            get { return getAttrVal<string>("Sd_stzkmrxx",null); }
            set { setAttrVal<string>("Sd_stzkmrxx", value); }
        }
		public string Other_stzkmrxx {
            get { return getAttrVal<string>("Other_stzkmrxx",null); }
            set { setAttrVal<string>("Other_stzkmrxx", value); }
        }
		public int? Eu_stzkjs {
            get { return getAttrVal<int?>("Eu_stzkjs",null); }
            set { setAttrVal<int?>("Eu_stzkjs", value); }
        }
		public string Id_stzkjsxx {
            get { return getAttrVal<string>("Id_stzkjsxx",null); }
            set { setAttrVal<string>("Id_stzkjsxx", value); }
        }
		public string Sd_stzkjsxx {
            get { return getAttrVal<string>("Sd_stzkjsxx",null); }
            set { setAttrVal<string>("Sd_stzkjsxx", value); }
        }
		public string Other_stzkjsxx {
            get { return getAttrVal<string>("Other_stzkjsxx",null); }
            set { setAttrVal<string>("Other_stzkjsxx", value); }
        }
		public int? Eu_stzkpn {
            get { return getAttrVal<int?>("Eu_stzkpn",null); }
            set { setAttrVal<int?>("Eu_stzkpn", value); }
        }
		public string Id_stzkpnxx {
            get { return getAttrVal<string>("Id_stzkpnxx",null); }
            set { setAttrVal<string>("Id_stzkpnxx", value); }
        }
		public string Sd_stzkpnxx {
            get { return getAttrVal<string>("Sd_stzkpnxx",null); }
            set { setAttrVal<string>("Sd_stzkpnxx", value); }
        }
		public string Other_stzkpnxx {
            get { return getAttrVal<string>("Other_stzkpnxx",null); }
            set { setAttrVal<string>("Other_stzkpnxx", value); }
        }
		public int? Eu_stzkpb {
            get { return getAttrVal<int?>("Eu_stzkpb",null); }
            set { setAttrVal<int?>("Eu_stzkpb", value); }
        }
		public string Id_stzkpbxx {
            get { return getAttrVal<string>("Id_stzkpbxx",null); }
            set { setAttrVal<string>("Id_stzkpbxx", value); }
        }
		public string Sd_stzkpbxx {
            get { return getAttrVal<string>("Sd_stzkpbxx",null); }
            set { setAttrVal<string>("Sd_stzkpbxx", value); }
        }
		public string Other_stzkpbxx {
            get { return getAttrVal<string>("Other_stzkpbxx",null); }
            set { setAttrVal<string>("Other_stzkpbxx", value); }
        }
		public string Id_stzkhd {
            get { return getAttrVal<string>("Id_stzkhd",null); }
            set { setAttrVal<string>("Id_stzkhd", value); }
        }
		public string Sd_stzkhd {
            get { return getAttrVal<string>("Sd_stzkhd",null); }
            set { setAttrVal<string>("Sd_stzkhd", value); }
        }
		public string Oher_stzkhd {
            get { return getAttrVal<string>("Oher_stzkhd",null); }
            set { setAttrVal<string>("Oher_stzkhd", value); }
        }
		public int? Eu_stzksm {
            get { return getAttrVal<int?>("Eu_stzksm",null); }
            set { setAttrVal<int?>("Eu_stzksm", value); }
        }
		public string Id_stzksmxx {
            get { return getAttrVal<string>("Id_stzksmxx",null); }
            set { setAttrVal<string>("Id_stzksmxx", value); }
        }
		public string Sd_stzksmxx {
            get { return getAttrVal<string>("Sd_stzksmxx",null); }
            set { setAttrVal<string>("Sd_stzksmxx", value); }
        }
		public string Other_stzksmxx {
            get { return getAttrVal<string>("Other_stzksmxx",null); }
            set { setAttrVal<string>("Other_stzksmxx", value); }
        }
		public int? Eu_stzkzlnl {
            get { return getAttrVal<int?>("Eu_stzkzlnl",null); }
            set { setAttrVal<int?>("Eu_stzkzlnl", value); }
        }
		public string Id_stzkzlnlxx {
            get { return getAttrVal<string>("Id_stzkzlnlxx",null); }
            set { setAttrVal<string>("Id_stzkzlnlxx", value); }
        }
		public string Sd_stzkzlnlxx {
            get { return getAttrVal<string>("Sd_stzkzlnlxx",null); }
            set { setAttrVal<string>("Sd_stzkzlnlxx", value); }
        }
		public string Other_stzkzlnlxx {
            get { return getAttrVal<string>("Other_stzkzlnlxx",null); }
            set { setAttrVal<string>("Other_stzkzlnlxx", value); }
        }
		public int? Eu_stzkpf {
            get { return getAttrVal<int?>("Eu_stzkpf",null); }
            set { setAttrVal<int?>("Eu_stzkpf", value); }
        }
		public string Id_pfyclx {
            get { return getAttrVal<string>("Id_pfyclx",null); }
            set { setAttrVal<string>("Id_pfyclx", value); }
        }
		public string Sd_pfyclx {
            get { return getAttrVal<string>("Sd_pfyclx",null); }
            set { setAttrVal<string>("Sd_pfyclx", value); }
        }
		public string Other_pfyclx {
            get { return getAttrVal<string>("Other_pfyclx",null); }
            set { setAttrVal<string>("Other_pfyclx", value); }
        }
		public int? Pressuresore {
            get { return getAttrVal<int?>("Pressuresore",null); }
            set { setAttrVal<int?>("Pressuresore", value); }
        }
		public int? Eu_gl {
            get { return getAttrVal<int?>("Eu_gl",null); }
            set { setAttrVal<int?>("Eu_gl", value); }
        }
		public string Id_glylg {
            get { return getAttrVal<string>("Id_glylg",null); }
            set { setAttrVal<string>("Id_glylg", value); }
        }
		public string Sd_glylg {
            get { return getAttrVal<string>("Sd_glylg",null); }
            set { setAttrVal<string>("Sd_glylg", value); }
        }
		public string Other_glylg {
            get { return getAttrVal<string>("Other_glylg",null); }
            set { setAttrVal<string>("Other_glylg", value); }
        }
		public string Id_glwzjm {
            get { return getAttrVal<string>("Id_glwzjm",null); }
            set { setAttrVal<string>("Id_glwzjm", value); }
        }
		public string Sd_glwzjm {
            get { return getAttrVal<string>("Sd_glwzjm",null); }
            set { setAttrVal<string>("Sd_glwzjm", value); }
        }
		public string Id_glsjm {
            get { return getAttrVal<string>("Id_glsjm",null); }
            set { setAttrVal<string>("Id_glsjm", value); }
        }
		public string Sd_glsjm {
            get { return getAttrVal<string>("Sd_glsjm",null); }
            set { setAttrVal<string>("Sd_glsjm", value); }
        }
		public string Other_glsjm {
            get { return getAttrVal<string>("Other_glsjm",null); }
            set { setAttrVal<string>("Other_glsjm", value); }
        }
		public string Id_glrgqd {
            get { return getAttrVal<string>("Id_glrgqd",null); }
            set { setAttrVal<string>("Id_glrgqd", value); }
        }
		public string Sd_glrgqd {
            get { return getAttrVal<string>("Sd_glrgqd",null); }
            set { setAttrVal<string>("Sd_glrgqd", value); }
        }
		public int? Eu_ddfxpg {
            get { return getAttrVal<int?>("Eu_ddfxpg",null); }
            set { setAttrVal<int?>("Eu_ddfxpg", value); }
        }
		public string Score_falll {
            get { return getAttrVal<string>("Score_falll",null); }
            set { setAttrVal<string>("Score_falll", value); }
        }
		public string Inforsources {
            get { return getAttrVal<string>("Inforsources",null); }
            set { setAttrVal<string>("Inforsources", value); }
        }
		public string Signature {
            get { return getAttrVal<string>("Signature",null); }
            set { setAttrVal<string>("Signature", value); }
        }
		public DateTime? Dt_assess {
            get { return getAttrVal<FDateTime>("Dt_assess",null); }
            set { setAttrVal<FDateTime>("Dt_assess", value); }
        }
		public string Zkpg {
            get { return getAttrVal<string>("Zkpg",null); }
            set { setAttrVal<string>("Zkpg", value); }
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
		public string Name_sex {
            get { return getAttrVal<string>("Name_sex",null); }
            set { setAttrVal<string>("Name_sex", value); }
        }
		public string Name_referalsrc {
            get { return getAttrVal<string>("Name_referalsrc",null); }
            set { setAttrVal<string>("Name_referalsrc", value); }
        }
		public string Name_ryxdfs {
            get { return getAttrVal<string>("Name_ryxdfs",null); }
            set { setAttrVal<string>("Name_ryxdfs", value); }
        }
		public string Name_jy {
            get { return getAttrVal<string>("Name_jy",null); }
            set { setAttrVal<string>("Name_jy", value); }
        }
		public string Name_qxxx {
            get { return getAttrVal<string>("Name_qxxx",null); }
            set { setAttrVal<string>("Name_qxxx", value); }
        }
		public string Name_ysspycxx {
            get { return getAttrVal<string>("Name_ysspycxx",null); }
            set { setAttrVal<string>("Name_ysspycxx", value); }
        }
		public string Name_stzkslxx {
            get { return getAttrVal<string>("Name_stzkslxx",null); }
            set { setAttrVal<string>("Name_stzkslxx", value); }
        }
		public string Name_stzktlxx {
            get { return getAttrVal<string>("Name_stzktlxx",null); }
            set { setAttrVal<string>("Name_stzktlxx", value); }
        }
		public string Name_stzkyyxx {
            get { return getAttrVal<string>("Name_stzkyyxx",null); }
            set { setAttrVal<string>("Name_stzkyyxx", value); }
        }
		public string Name_stzkmrxx {
            get { return getAttrVal<string>("Name_stzkmrxx",null); }
            set { setAttrVal<string>("Name_stzkmrxx", value); }
        }
		public string Name_stzkjsxx {
            get { return getAttrVal<string>("Name_stzkjsxx",null); }
            set { setAttrVal<string>("Name_stzkjsxx", value); }
        }
		public string Name_stzkpnxx {
            get { return getAttrVal<string>("Name_stzkpnxx",null); }
            set { setAttrVal<string>("Name_stzkpnxx", value); }
        }
		public string Name_stzkpbxx {
            get { return getAttrVal<string>("Name_stzkpbxx",null); }
            set { setAttrVal<string>("Name_stzkpbxx", value); }
        }
		public string Name_stzkhd {
            get { return getAttrVal<string>("Name_stzkhd",null); }
            set { setAttrVal<string>("Name_stzkhd", value); }
        }
		public string Name_stzksmxx {
            get { return getAttrVal<string>("Name_stzksmxx",null); }
            set { setAttrVal<string>("Name_stzksmxx", value); }
        }
		public string Name_stzkzlnlxx {
            get { return getAttrVal<string>("Name_stzkzlnlxx",null); }
            set { setAttrVal<string>("Name_stzkzlnlxx", value); }
        }
		public string Name_pfyclx {
            get { return getAttrVal<string>("Name_pfyclx",null); }
            set { setAttrVal<string>("Name_pfyclx", value); }
        }
		public string Name_glylg {
            get { return getAttrVal<string>("Name_glylg",null); }
            set { setAttrVal<string>("Name_glylg", value); }
        }
		public string Name_glwzjm {
            get { return getAttrVal<string>("Name_glwzjm",null); }
            set { setAttrVal<string>("Name_glwzjm", value); }
        }
		public string Name_glsjm {
            get { return getAttrVal<string>("Name_glsjm",null); }
            set { setAttrVal<string>("Name_glsjm", value); }
        }
		public string Name_glrgqd {
            get { return getAttrVal<string>("Name_glrgqd",null); }
            set { setAttrVal<string>("Name_glrgqd", value); }
        }
		public string Name_signature {
            get { return getAttrVal<string>("Name_signature",null); }
            set { setAttrVal<string>("Name_signature", value); }
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
            return "CI_MR_NU_ANA";
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
            return "Id_ana";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.admissionnursingassessment.d.AdmissionNursingAssessmentDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ana", "Id_grp", "Id_org", "Id_ent", "Name_pat", "Id_sex", "Sd_sex", "Age", "Name_bed", "Code_amr_ip", "Name_diagnosis", "Glqt", "Sd_referalsrc", "Id_referalsrc", "Other_referalsrc", "Id_ryxdfs", "Sd_yrxdfs", "Ryxdfs_other", "Id_jy", "Sd_jy", "Eu_zj", "Eu_pb", "Eu_gms", "Eu_shxy", "Eu_shyj", "Eu_jws", "Eu_qx", "Id_qxxx", "Sd_qxxx", "Other_qxxx", "Eu_yssp", "Id_ysspycxx", "Sd_ysspycxx", "Other_ysspycxx", "Eu_stzksl", "Id_stzkslxx", "Sd_stzkslxx", "Other_stzkslxx", "Eu_stzktl", "Id_stzktlxx", "Sd_stzktlxx", "Other_stzktlxx", "Eu_stzkyy", "Id_stzkyyxx", "Sd_stzkyyxx", "Other_stzkyyxx", "Eu_stzkmr", "Id_stzkmrxx", "Sd_stzkmrxx", "Other_stzkmrxx", "Eu_stzkjs", "Id_stzkjsxx", "Sd_stzkjsxx", "Other_stzkjsxx", "Eu_stzkpn", "Id_stzkpnxx", "Sd_stzkpnxx", "Other_stzkpnxx", "Eu_stzkpb", "Id_stzkpbxx", "Sd_stzkpbxx", "Other_stzkpbxx", "Id_stzkhd", "Sd_stzkhd", "Oher_stzkhd", "Eu_stzksm", "Id_stzksmxx", "Sd_stzksmxx", "Other_stzksmxx", "Eu_stzkzlnl", "Id_stzkzlnlxx", "Sd_stzkzlnlxx", "Other_stzkzlnlxx", "Eu_stzkpf", "Id_pfyclx", "Sd_pfyclx", "Other_pfyclx", "Pressuresore", "Eu_gl", "Id_glylg", "Sd_glylg", "Other_glylg", "Id_glwzjm", "Sd_glwzjm", "Id_glsjm", "Sd_glsjm", "Other_glsjm", "Id_glrgqd", "Sd_glrgqd", "Eu_ddfxpg", "Score_falll", "Inforsources", "Signature", "Dt_assess", "Zkpg", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_sex", "Name_referalsrc", "Name_ryxdfs", "Name_jy", "Name_qxxx", "Name_ysspycxx", "Name_stzkslxx", "Name_stzktlxx", "Name_stzkyyxx", "Name_stzkmrxx", "Name_stzkjsxx", "Name_stzkpnxx", "Name_stzkpbxx", "Name_stzkhd", "Name_stzksmxx", "Name_stzkzlnlxx", "Name_pfyclx", "Name_glylg", "Name_glwzjm", "Name_glsjm", "Name_glrgqd", "Name_signature"};
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
