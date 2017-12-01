
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cior.d
{
    /// <summary>
    /// CiordInviteConsDO 的摘要说明。
    /// </summary>
    public class CiordInviteConsDO : BaseDO {

		public const string TABLE_NAME = "ci_invite_cons";
		public const string TABLE_ALIAS_NAME = "a1";

        public CiordInviteConsDO() {
        }
		public string Id_invitecons {
            get { return getAttrVal<string>("Id_invitecons",null); }
            set { setAttrVal<string>("Id_invitecons", value); }
        }
		public string Id_apcons {
            get { return getAttrVal<string>("Id_apcons",null); }
            set { setAttrVal<string>("Id_apcons", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_dep {
            get { return getAttrVal<string>("Id_dep",null); }
            set { setAttrVal<string>("Id_dep", value); }
        }
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }
		public string Sd_emp_title {
            get { return getAttrVal<string>("Sd_emp_title",null); }
            set { setAttrVal<string>("Sd_emp_title", value); }
        }
		public string Id_emp_title {
            get { return getAttrVal<string>("Id_emp_title",null); }
            set { setAttrVal<string>("Id_emp_title", value); }
        }
		public bool? Fg_response {
            get { return getAttrVal<FBoolean>("Fg_response",null); }
            set { setAttrVal<FBoolean>("Fg_response", value); }
        }
		public DateTime? Dt_response {
            get { return getAttrVal<FDateTime>("Dt_response",null); }
            set { setAttrVal<FDateTime>("Dt_response", value); }
        }
		public string Id_emp_response {
            get { return getAttrVal<string>("Id_emp_response",null); }
            set { setAttrVal<string>("Id_emp_response", value); }
        }
		public bool? Fg_join_cons {
            get { return getAttrVal<FBoolean>("Fg_join_cons",null); }
            set { setAttrVal<FBoolean>("Fg_join_cons", value); }
        }
		public string Judgcons {
            get { return getAttrVal<string>("Judgcons",null); }
            set { setAttrVal<string>("Judgcons", value); }
        }
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }
		public string Name_emp {
            get { return getAttrVal<string>("Name_emp",null); }
            set { setAttrVal<string>("Name_emp", value); }
        }
		public string Name_emp_title {
            get { return getAttrVal<string>("Name_emp_title",null); }
            set { setAttrVal<string>("Name_emp_title", value); }
        }
		public string Name_emp_respon {
            get { return getAttrVal<string>("Name_emp_respon",null); }
            set { setAttrVal<string>("Name_emp_respon", value); }
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
            return "ci_invite_cons";
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
            return "Id_invitecons";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cior.d.CiordInviteConsDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_invitecons", "Id_apcons", "Id_org", "Id_dep", "Id_emp", "Sd_emp_title", "Id_emp_title", "Fg_response", "Dt_response", "Id_emp_response", "Fg_join_cons", "Judgcons", "Name_org", "Name_dep", "Name_emp", "Name_emp_title", "Name_emp_respon"};
        }
        
    }
}
