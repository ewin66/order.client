using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.cimrrecallresultdto.d
{
    /// <summary>
    /// CiMrRecallResultDTO 的摘要说明。
    /// </summary>
    public class CiMrRecallResultDTO : BaseDTO
    {

        public CiMrRecallResultDTO()
        {

        }

        /// <summary>
        /// 就诊id
        /// </summary>
        public string Id_ent
        {
            get { return getAttrVal<string>("Id_ent", null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 召回申请id
        /// </summary>
        public string Id_recall
        {
            get { return getAttrVal<string>("Id_recall", null); }
            set { setAttrVal<string>("Id_recall", value); }
        }

        /// <summary>
        ///  审批状态
        /// </summary>
        public string Name_state
        {
            get { return getAttrVal<string>("Name_state", null); }
            set { setAttrVal<string>("Name_state", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
        public string Pat_name
        {
            get { return getAttrVal<string>("Pat_name", null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
        public string Pat_sex
        {
            get { return getAttrVal<string>("Pat_sex", null); }
            set { setAttrVal<string>("Pat_sex", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
        public string Pat_age
        {
            get { return getAttrVal<string>("Pat_age", null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 驳回原因
        /// </summary>
        public string Reason_reject
        {
            get { return getAttrVal<string>("Reason_reject", null); }
            set { setAttrVal<string>("Reason_reject", value); }
        }

        /// <summary>
        /// 就诊时间
        /// </summary>
        public DateTime? Dt_ent
        {
            get { return getAttrVal<FDateTime>("Dt_ent", null); }
            set { setAttrVal<FDateTime>("Dt_ent", value); }
        }

        /// <summary>
        /// 申请时间
        /// </summary>
        public DateTime? Dt_apply
        {
            get { return getAttrVal<FDateTime>("Dt_apply", null); }
            set { setAttrVal<FDateTime>("Dt_apply", value); }
        }

        /// <summary>
        /// 审批人
        /// </summary>
        public string Name_psn_approve
        {
            get { return getAttrVal<string>("Name_psn_approve", null); }
            set { setAttrVal<string>("Name_psn_approve", value); }
        }

        /// <summary>
        /// 审批时间
        /// </summary>
        public DateTime? Dt_approve
        {
            get { return getAttrVal<FDateTime>("Dt_approve", null); }
            set { setAttrVal<FDateTime>("Dt_approve", value); }
        }

        /// <summary>
        /// 召回截止时间
        /// </summary>
        public DateTime? Dt_end
        {
            get { return getAttrVal<FDate>("Dt_end", null); }
            set { setAttrVal<FDate>("Dt_end", value); }
        }

        /// <summary>
        /// 申请原因
        /// </summary>
        public string Apply_reason
        {
            get { return getAttrVal<string>("Apply_reason", null); }
            set { setAttrVal<string>("Apply_reason", value); }
        }

        /// <summary>
        /// 申请人
        /// </summary>
        public string Name_psn_apply
        {
            get { return getAttrVal<string>("Name_psn_apply", null); }
            set { setAttrVal<string>("Name_psn_apply", value); }
        }

        /// <summary>
        /// 申请科室
        /// </summary>
        public string Name_dep_apply
        {
            get { return getAttrVal<string>("Name_dep_apply", null); }
            set { setAttrVal<string>("Name_dep_apply", value); }
        }

        /// <summary>
        /// 条码号
        /// </summary>
        public string Barcode_chis
        {
            get { return getAttrVal<string>("Barcode_chis", null); }
            set { setAttrVal<string>("Barcode_chis", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
        public string Code_entp
        {
            get { return getAttrVal<string>("Code_entp", null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 是否超时
        /// </summary>
        public string Fg_timeout
        {
            get { return getAttrVal<string>("Fg_timeout", null); }
            set { setAttrVal<string>("Fg_timeout", value); }
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
        public string Ent_code
        {
            get { return getAttrVal<string>("Ent_code", null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_ent", "Id_recall", "Name_state", "Pat_name", "Pat_sex", "Pat_age", "Reason_reject", "Dt_ent", "Dt_apply", "Name_psn_approve", "Dt_approve", "Dt_end", "Apply_reason", "Name_psn_apply", "Name_dep_apply", "Barcode_chis", "Code_entp", "Fg_timeout", "Ent_code" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.cimrrecallresultdto.d.CiMrRecallResultDTO";
        }
    }
}
