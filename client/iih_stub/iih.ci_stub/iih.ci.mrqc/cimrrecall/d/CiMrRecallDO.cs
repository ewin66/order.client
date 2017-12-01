
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mrqc.cimrrecall.d
{
    /// <summary>
    /// CiMrRecallDO 的摘要说明。
    /// </summary>
    public class CiMrRecallDO : BaseDO
    {

        public const string TABLE_NAME = "CI_MR_RECALL";
        public const string TABLE_ALIAS_NAME = "a0";

        public CiMrRecallDO()
        {
        }
        public string Id_ci_mr_recall
        {
            get { return getAttrVal<string>("Id_ci_mr_recall", null); }
            set { setAttrVal<string>("Id_ci_mr_recall", value); }
        }
        public string Id_grp
        {
            get { return getAttrVal<string>("Id_grp", null); }
            set { setAttrVal<string>("Id_grp", value); }
        }
        public string Id_org
        {
            get { return getAttrVal<string>("Id_org", null); }
            set { setAttrVal<string>("Id_org", value); }
        }
        public string Id_ent
        {
            get { return getAttrVal<string>("Id_ent", null); }
            set { setAttrVal<string>("Id_ent", value); }
        }
        public string Id_dep_apply
        {
            get { return getAttrVal<string>("Id_dep_apply", null); }
            set { setAttrVal<string>("Id_dep_apply", value); }
        }
        public string Id_psn_apply
        {
            get { return getAttrVal<string>("Id_psn_apply", null); }
            set { setAttrVal<string>("Id_psn_apply", value); }
        }
        public DateTime? Dt_apply
        {
            get { return getAttrVal<FDateTime>("Dt_apply", null); }
            set { setAttrVal<FDateTime>("Dt_apply", value); }
        }
        public DateTime? Dt_end
        {
            get { return getAttrVal<FDate>("Dt_end", null); }
            set { setAttrVal<FDate>("Dt_end", value); }
        }
        public string Apply_reson
        {
            get { return getAttrVal<string>("Apply_reson", null); }
            set { setAttrVal<string>("Apply_reson", value); }
        }
        public string Id_state
        {
            get { return getAttrVal<string>("Id_state", null); }
            set { setAttrVal<string>("Id_state", value); }
        }
        public string Sd_state
        {
            get { return getAttrVal<string>("Sd_state", null); }
            set { setAttrVal<string>("Sd_state", value); }
        }
        public string Reject_reson
        {
            get { return getAttrVal<string>("Reject_reson", null); }
            set { setAttrVal<string>("Reject_reson", value); }
        }
        public string Id_dep_reject
        {
            get { return getAttrVal<string>("Id_dep_reject", null); }
            set { setAttrVal<string>("Id_dep_reject", value); }
        }
        public string Id_psn_reject
        {
            get { return getAttrVal<string>("Id_psn_reject", null); }
            set { setAttrVal<string>("Id_psn_reject", value); }
        }
        public DateTime? Dt_reject
        {
            get { return getAttrVal<FDateTime>("Dt_reject", null); }
            set { setAttrVal<FDateTime>("Dt_reject", value); }
        }
        public string Id_dep_audit
        {
            get { return getAttrVal<string>("Id_dep_audit", null); }
            set { setAttrVal<string>("Id_dep_audit", value); }
        }
        public string Id_psn_audit
        {
            get { return getAttrVal<string>("Id_psn_audit", null); }
            set { setAttrVal<string>("Id_psn_audit", value); }
        }
        public DateTime? Dt_audit
        {
            get { return getAttrVal<FDateTime>("Dt_audit", null); }
            set { setAttrVal<FDateTime>("Dt_audit", value); }
        }
        public string Createdby
        {
            get { return getAttrVal<string>("Createdby", null); }
            set { setAttrVal<string>("Createdby", value); }
        }
        public DateTime? Createdtime
        {
            get { return getAttrVal<FDateTime>("Createdtime", null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
        public string Modifiedby
        {
            get { return getAttrVal<string>("Modifiedby", null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
        public DateTime? Modifiedtime
        {
            get { return getAttrVal<FDateTime>("Modifiedtime", null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
        public string Timeout_reason
        {
            get { return getAttrVal<string>("Timeout_reason", null); }
            set { setAttrVal<string>("Timeout_reason", value); }
        }
        public bool? Fg_timeout
        {
            get { return getAttrVal<FBoolean>("Fg_timeout", null); }
            set { setAttrVal<FBoolean>("Fg_timeout", value); }
        }
        public string Code_dep_apply
        {
            get { return getAttrVal<string>("Code_dep_apply", null); }
            set { setAttrVal<string>("Code_dep_apply", value); }
        }
        public string Name_dep_apply
        {
            get { return getAttrVal<string>("Name_dep_apply", null); }
            set { setAttrVal<string>("Name_dep_apply", value); }
        }
        public string Code_psn_apply
        {
            get { return getAttrVal<string>("Code_psn_apply", null); }
            set { setAttrVal<string>("Code_psn_apply", value); }
        }
        public string Name_psn_apply
        {
            get { return getAttrVal<string>("Name_psn_apply", null); }
            set { setAttrVal<string>("Name_psn_apply", value); }
        }
        public string Code_sate
        {
            get { return getAttrVal<string>("Code_sate", null); }
            set { setAttrVal<string>("Code_sate", value); }
        }
        public string Name_sate
        {
            get { return getAttrVal<string>("Name_sate", null); }
            set { setAttrVal<string>("Name_sate", value); }
        }
        public string Code_dep_reject
        {
            get { return getAttrVal<string>("Code_dep_reject", null); }
            set { setAttrVal<string>("Code_dep_reject", value); }
        }
        public string Name_dep_reject
        {
            get { return getAttrVal<string>("Name_dep_reject", null); }
            set { setAttrVal<string>("Name_dep_reject", value); }
        }
        public string Code_psn_reject
        {
            get { return getAttrVal<string>("Code_psn_reject", null); }
            set { setAttrVal<string>("Code_psn_reject", value); }
        }
        public string Name_psn_reject
        {
            get { return getAttrVal<string>("Name_psn_reject", null); }
            set { setAttrVal<string>("Name_psn_reject", value); }
        }
        public string Code_dep_audit
        {
            get { return getAttrVal<string>("Code_dep_audit", null); }
            set { setAttrVal<string>("Code_dep_audit", value); }
        }
        public string Name_dep_audit
        {
            get { return getAttrVal<string>("Name_dep_audit", null); }
            set { setAttrVal<string>("Name_dep_audit", value); }
        }
        public string Code_psn_audit
        {
            get { return getAttrVal<string>("Code_psn_audit", null); }
            set { setAttrVal<string>("Code_psn_audit", value); }
        }
        public string Name_psn_audit
        {
            get { return getAttrVal<string>("Name_psn_audit", null); }
            set { setAttrVal<string>("Name_psn_audit", value); }
        }
        public int Ds
        {
            get { return getAttrVal<int>("Ds", 0); }
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv
        {
            get { return getAttrVal<FDateTime>("Sv", null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "CI_MR_RECALL";
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
            return "Id_ci_mr_recall";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.cimrrecall.d.CiMrRecallDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Ds", "Sv", "Id_ci_mr_recall", "Id_grp", "Id_org", "Id_ent", "Id_dep_apply", "Id_psn_apply", "Dt_apply", "Dt_end", "Apply_reson", "Id_state", "Sd_state", "Reject_reson", "Id_dep_reject", "Id_psn_reject", "Dt_reject", "Id_dep_audit", "Id_psn_audit", "Dt_audit", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Timeout_reason", "Fg_timeout", "Code_dep_apply", "Name_dep_apply", "Code_psn_apply", "Name_psn_apply", "Code_sate", "Name_sate", "Code_dep_reject", "Name_dep_reject", "Code_psn_reject", "Name_psn_reject", "Code_dep_audit", "Name_dep_audit", "Code_psn_audit", "Name_psn_audit" };
        }

        /// <summary>
        /// 设置IBDataInfo接口映射数据
        /// </summary>
        /// <returns></returns>
        protected override void setBdDataInfoNameMap()
        {
            if (base.name_path_map == null)
            {
                base.name_path_map = new Dictionary<string, string>();
                base.name_path_map.Add("id_org", "Id_grp");
                base.name_path_map.Add("id_group", "Id_org");
            }
        }
    }
}
