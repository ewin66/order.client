
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ciet.cievent.d
{
    /// <summary>
    /// CiEventDO 的摘要说明。
    /// </summary>
    public class CiEventDO : BaseDO {

        public CiEventDO() {
        }
		public string Id_et {
            get { return getAttrVal<string>("Id_et",null); }
            set { setAttrVal<string>("Id_et", value); }
        }
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }
		public DateTime? Dt_et {
            get { return getAttrVal<FDateTime>("Dt_et",null); }
            set { setAttrVal<FDateTime>("Dt_et", value); }
        }
		public string Id_ettp {
            get { return getAttrVal<string>("Id_ettp",null); }
            set { setAttrVal<string>("Id_ettp", value); }
        }
		public string Sd_ettp {
            get { return getAttrVal<string>("Sd_ettp",null); }
            set { setAttrVal<string>("Sd_ettp", value); }
        }
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }
		public string Id_des_status {
            get { return getAttrVal<string>("Id_des_status",null); }
            set { setAttrVal<string>("Id_des_status", value); }
        }
		public string Sd_des_status {
            get { return getAttrVal<string>("Sd_des_status",null); }
            set { setAttrVal<string>("Sd_des_status", value); }
        }
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
		public string Id_dep_et {
            get { return getAttrVal<string>("Id_dep_et",null); }
            set { setAttrVal<string>("Id_dep_et", value); }
        }
		public string Id_emp_et {
            get { return getAttrVal<string>("Id_emp_et",null); }
            set { setAttrVal<string>("Id_emp_et", value); }
        }
		public string Id_mrtp {
            get { return getAttrVal<string>("Id_mrtp",null); }
            set { setAttrVal<string>("Id_mrtp", value); }
        }
		public bool? Iscompleted {
            get { return getAttrVal<FBoolean>("Iscompleted",null); }
            set { setAttrVal<FBoolean>("Iscompleted", value); }
        }
		public string Id_user {
            get { return getAttrVal<string>("Id_user",null); }
            set { setAttrVal<string>("Id_user", value); }
        }
		public DateTime? Dt_begin {
            get { return getAttrVal<FDateTime>("Dt_begin",null); }
            set { setAttrVal<FDateTime>("Dt_begin", value); }
        }
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }
		public DateTime? Dt_complete {
            get { return getAttrVal<FDateTime>("Dt_complete",null); }
            set { setAttrVal<FDateTime>("Dt_complete", value); }
        }
		public string Time_has {
            get { return getAttrVal<string>("Time_has",null); }
            set { setAttrVal<string>("Time_has", value); }
        }
		public string Reason_cancel {
            get { return getAttrVal<string>("Reason_cancel",null); }
            set { setAttrVal<string>("Reason_cancel", value); }
        }
		public bool? Israte {
            get { return getAttrVal<FBoolean>("Israte",null); }
            set { setAttrVal<FBoolean>("Israte", value); }
        }
		public string Rate {
            get { return getAttrVal<string>("Rate",null); }
            set { setAttrVal<string>("Rate", value); }
        }
		public bool? Is_associated {
            get { return getAttrVal<FBoolean>("Is_associated",null); }
            set { setAttrVal<FBoolean>("Is_associated", value); }
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
		public string Eventsta_code {
            get { return getAttrVal<string>("Eventsta_code",null); }
            set { setAttrVal<string>("Eventsta_code", value); }
        }
		public string Eventsta_name {
            get { return getAttrVal<string>("Eventsta_name",null); }
            set { setAttrVal<string>("Eventsta_name", value); }
        }
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }
		public string Mrtp_code {
            get { return getAttrVal<string>("Mrtp_code",null); }
            set { setAttrVal<string>("Mrtp_code", value); }
        }
		public string Mrtp_name {
            get { return getAttrVal<string>("Mrtp_name",null); }
            set { setAttrVal<string>("Mrtp_name", value); }
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
            return "ci_et";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_et";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ciet.cievent.d.CiEventDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_et", "Id_grp", "Id_org", "Id_or", "Id_di", "Id_mr", "Dt_et", "Id_ettp", "Sd_ettp", "Code", "Name", "Des", "Id_des_status", "Sd_des_status", "Id_pat", "Id_entp", "Code_entp", "Id_ent", "Id_dep_et", "Id_emp_et", "Id_mrtp", "Iscompleted", "Id_user", "Dt_begin", "Dt_end", "Dt_complete", "Time_has", "Reason_cancel", "Israte", "Rate", "Is_associated", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Eventsta_code", "Eventsta_name", "Pat_name", "Mrtp_code", "Mrtp_name"};
        }
        
		/// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
		protected override void setBdDataInfoNameMap() {
			if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
				base.name_path_map.Add("createdby","Createdby");
				base.name_path_map.Add("createdtime","Createdtime");
				base.name_path_map.Add("modifiedby","Modifiedby");
				base.name_path_map.Add("modifiedtime","Modifiedtime");
            }
		}
    }
}
