
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.antennurbaby.d
{
    /// <summary>
    /// AntNurBabyDO 的摘要说明。
    /// </summary>
    public class AntNurBabyDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ANTNURBABY";
		public const string TABLE_ALIAS_NAME = "a0";

        public AntNurBabyDO() {
        }
		public string Id_ass {
            get { return getAttrVal<string>("Id_ass",null); }
            set { setAttrVal<string>("Id_ass", value); }
        }
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
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
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }
		public string Id_childbirth_type {
            get { return getAttrVal<string>("Id_childbirth_type",null); }
            set { setAttrVal<string>("Id_childbirth_type", value); }
        }
		public string Sd_childbirth_type {
            get { return getAttrVal<string>("Sd_childbirth_type",null); }
            set { setAttrVal<string>("Sd_childbirth_type", value); }
        }
		public string Name_pastmedic {
            get { return getAttrVal<string>("Name_pastmedic",null); }
            set { setAttrVal<string>("Name_pastmedic", value); }
        }
		public string Pfycms {
            get { return getAttrVal<string>("Pfycms",null); }
            set { setAttrVal<string>("Pfycms", value); }
        }
		public string Fsycms {
            get { return getAttrVal<string>("Fsycms",null); }
            set { setAttrVal<string>("Fsycms", value); }
        }
		public string Id_sign {
            get { return getAttrVal<string>("Id_sign",null); }
            set { setAttrVal<string>("Id_sign", value); }
        }
		public int? Cstc {
            get { return getAttrVal<int?>("Cstc",null); }
            set { setAttrVal<int?>("Cstc", value); }
        }
		public int? Aspf1fz {
            get { return getAttrVal<int?>("Aspf1fz",null); }
            set { setAttrVal<int?>("Aspf1fz", value); }
        }
		public int? Aspf5fz {
            get { return getAttrVal<int?>("Aspf5fz",null); }
            set { setAttrVal<int?>("Aspf5fz", value); }
        }
		public DateTime? Csrq {
            get { return getAttrVal<FDateTime>("Csrq",null); }
            set { setAttrVal<FDateTime>("Csrq", value); }
        }
		public int? Eu_xb {
            get { return getAttrVal<int?>("Eu_xb",null); }
            set { setAttrVal<int?>("Eu_xb", value); }
        }
		public int? Eu_pfqk {
            get { return getAttrVal<int?>("Eu_pfqk",null); }
            set { setAttrVal<int?>("Eu_pfqk", value); }
        }
		public int? Eu_fs {
            get { return getAttrVal<int?>("Eu_fs",null); }
            set { setAttrVal<int?>("Eu_fs", value); }
        }
		public string Id_mothernipple {
            get { return getAttrVal<string>("Id_mothernipple",null); }
            set { setAttrVal<string>("Id_mothernipple", value); }
        }
		public string Sd_mothernipple {
            get { return getAttrVal<string>("Sd_mothernipple",null); }
            set { setAttrVal<string>("Sd_mothernipple", value); }
        }
		public string Nipple_other {
            get { return getAttrVal<string>("Nipple_other",null); }
            set { setAttrVal<string>("Nipple_other", value); }
        }
		public string Poorsucking_des {
            get { return getAttrVal<string>("Poorsucking_des",null); }
            set { setAttrVal<string>("Poorsucking_des", value); }
        }
		public int? Eu_yersxsqk {
            get { return getAttrVal<int?>("Eu_yersxsqk",null); }
            set { setAttrVal<int?>("Eu_yersxsqk", value); }
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
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
		public string Name_grp {
            get { return getAttrVal<string>("Name_grp",null); }
            set { setAttrVal<string>("Name_grp", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }
		public string Name_childbirth_type {
            get { return getAttrVal<string>("Name_childbirth_type",null); }
            set { setAttrVal<string>("Name_childbirth_type", value); }
        }
		public string Name_sign {
            get { return getAttrVal<string>("Name_sign",null); }
            set { setAttrVal<string>("Name_sign", value); }
        }
		public string Name_mothernipple {
            get { return getAttrVal<string>("Name_mothernipple",null); }
            set { setAttrVal<string>("Name_mothernipple", value); }
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
            return "CI_Mr_NU_ANTNURBABY";
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
            return "Id_ass";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ass", "Id_dep_phy", "Id_ent", "Id_pat", "Code_entp", "Id_grp", "Id_org", "Id_dep_nur", "Name_bed", "Id_childbirth_type", "Sd_childbirth_type", "Name_pastmedic", "Pfycms", "Fsycms", "Id_sign", "Cstc", "Aspf1fz", "Aspf5fz", "Csrq", "Eu_xb", "Eu_pfqk", "Eu_fs", "Id_mothernipple", "Sd_mothernipple", "Nipple_other", "Poorsucking_des", "Eu_yersxsqk", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_dep_phy", "Name_pat", "Code_amr_ip", "Name_grp", "Name_org", "Name_dep_nur", "Name_childbirth_type", "Name_sign", "Name_mothernipple"};
        }
        
    }
}
