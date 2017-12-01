using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.dto.rfmnotice.d
{
    /// <summary>
    /// QaNoticeDTO 的摘要说明。
    /// </summary>
    public class QaNoticeDTO : BaseDTO {

        public QaNoticeDTO() {
 
        }

        /// <summary>
        /// 主键标识
        /// </summary>
		public string Id_noticedto {
            get { return getAttrVal<string>("Id_noticedto",null); }
            set { setAttrVal<string>("Id_noticedto", value); }
        }

        /// <summary>
        /// 通知书id
        /// </summary>
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
        }

        /// <summary>
        /// 通知书状态id
        /// </summary>
		public string Id_status {
            get { return getAttrVal<string>("Id_status",null); }
            set { setAttrVal<string>("Id_status", value); }
        }

        /// <summary>
        /// 通知书状态编码
        /// </summary>
		public string Sd_status {
            get { return getAttrVal<string>("Sd_status",null); }
            set { setAttrVal<string>("Sd_status", value); }
        }

        /// <summary>
        /// 通知书状态
        /// </summary>
		public string Status_name {
            get { return getAttrVal<string>("Status_name",null); }
            set { setAttrVal<string>("Status_name", value); }
        }

        /// <summary>
        /// 发送时间
        /// </summary>
		public DateTime? Dt_send {
            get { return getAttrVal<FDateTime>("Dt_send",null); }
            set { setAttrVal<FDateTime>("Dt_send", value); }
        }

        /// <summary>
        /// 质控医生id
        /// </summary>
		public string Id_exec_doctor {
            get { return getAttrVal<string>("Id_exec_doctor",null); }
            set { setAttrVal<string>("Id_exec_doctor", value); }
        }

        /// <summary>
        /// 质控医生
        /// </summary>
		public string Exec_doctor_name {
            get { return getAttrVal<string>("Exec_doctor_name",null); }
            set { setAttrVal<string>("Exec_doctor_name", value); }
        }

        /// <summary>
        /// 质控科室id
        /// </summary>
		public string Id_exec_dept {
            get { return getAttrVal<string>("Id_exec_dept",null); }
            set { setAttrVal<string>("Id_exec_dept", value); }
        }

        /// <summary>
        /// 质控科室
        /// </summary>
		public string Exec_dept_name {
            get { return getAttrVal<string>("Exec_dept_name",null); }
            set { setAttrVal<string>("Exec_dept_name", value); }
        }

        /// <summary>
        /// 整改医生id
        /// </summary>
		public string Id_rfm_doctor {
            get { return getAttrVal<string>("Id_rfm_doctor",null); }
            set { setAttrVal<string>("Id_rfm_doctor", value); }
        }

        /// <summary>
        /// 整改医生
        /// </summary>
		public string Rfm_doctor_name {
            get { return getAttrVal<string>("Rfm_doctor_name",null); }
            set { setAttrVal<string>("Rfm_doctor_name", value); }
        }

        /// <summary>
        /// 整改科室id
        /// </summary>
		public string Id_rfm_dept {
            get { return getAttrVal<string>("Id_rfm_dept",null); }
            set { setAttrVal<string>("Id_rfm_dept", value); }
        }

        /// <summary>
        /// 整改科室
        /// </summary>
		public string Rfm_dept_name {
            get { return getAttrVal<string>("Rfm_dept_name",null); }
            set { setAttrVal<string>("Rfm_dept_name", value); }
        }

        /// <summary>
        /// 患者就诊主键
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 缺陷次数
        /// </summary>
		public string Deduct_times {
            get { return getAttrVal<string>("Deduct_times",null); }
            set { setAttrVal<string>("Deduct_times", value); }
        }

        /// <summary>
        /// 整改期限
        /// </summary>
		public int? Rfm_deadline {
            get { return getAttrVal<int?>("Rfm_deadline",null); }
            set { setAttrVal<int?>("Rfm_deadline", value); }
        }

        /// <summary>
        /// 截止时间
        /// </summary>
		public DateTime? Dt_deadline {
            get { return getAttrVal<FDateTime>("Dt_deadline",null); }
            set { setAttrVal<FDateTime>("Dt_deadline", value); }
        }

        /// <summary>
        /// 整改说明
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 整改完成时间
        /// </summary>
		public DateTime? Rfm_time {
            get { return getAttrVal<FDateTime>("Rfm_time",null); }
            set { setAttrVal<FDateTime>("Rfm_time", value); }
        }

        /// <summary>
        /// 超时申请状态
        /// </summary>
		public string Id_dead_apply_status {
            get { return getAttrVal<string>("Id_dead_apply_status",null); }
            set { setAttrVal<string>("Id_dead_apply_status", value); }
        }

        /// <summary>
        /// 超时申请状态编码
        /// </summary>
		public string Sd_dead_apply_status {
            get { return getAttrVal<string>("Sd_dead_apply_status",null); }
            set { setAttrVal<string>("Sd_dead_apply_status", value); }
        }

        /// <summary>
        /// 超时申请原因
        /// </summary>
		public string Dead_apply_reason {
            get { return getAttrVal<string>("Dead_apply_reason",null); }
            set { setAttrVal<string>("Dead_apply_reason", value); }
        }

        /// <summary>
        /// 超时申请时间
        /// </summary>
		public DateTime? Dt_dead_apply {
            get { return getAttrVal<FDateTime>("Dt_dead_apply",null); }
            set { setAttrVal<FDateTime>("Dt_dead_apply", value); }
        }

        /// <summary>
        /// 超时申请驳回原因
        /// </summary>
		public string Dead_callback_reason {
            get { return getAttrVal<string>("Dead_callback_reason",null); }
            set { setAttrVal<string>("Dead_callback_reason", value); }
        }

        /// <summary>
        /// 超时审批时间
        /// </summary>
		public DateTime? Dt_dead_agree {
            get { return getAttrVal<FDateTime>("Dt_dead_agree",null); }
            set { setAttrVal<FDateTime>("Dt_dead_agree", value); }
        }

        /// <summary>
        /// 超时申请状态名称
        /// </summary>
		public string Dead_apply_status_name {
            get { return getAttrVal<string>("Dead_apply_status_name",null); }
            set { setAttrVal<string>("Dead_apply_status_name", value); }
        }

        /// <summary>
        /// 质控类型id
        /// </summary>
		public string Id_qa_ty {
            get { return getAttrVal<string>("Id_qa_ty",null); }
            set { setAttrVal<string>("Id_qa_ty", value); }
        }

        /// <summary>
        /// 质控类型
        /// </summary>
		public string Qa_ty_name {
            get { return getAttrVal<string>("Qa_ty_name",null); }
            set { setAttrVal<string>("Qa_ty_name", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_noticedto", "Id_revision", "Id_status", "Sd_status", "Status_name", "Dt_send", "Id_exec_doctor", "Exec_doctor_name", "Id_exec_dept", "Exec_dept_name", "Id_rfm_doctor", "Rfm_doctor_name", "Id_rfm_dept", "Rfm_dept_name", "Id_ent", "Name_pat", "Deduct_times", "Rfm_deadline", "Dt_deadline", "Des", "Rfm_time", "Id_dead_apply_status", "Sd_dead_apply_status", "Dead_apply_reason", "Dt_dead_apply", "Dead_callback_reason", "Dt_dead_agree", "Dead_apply_status_name", "Id_qa_ty", "Qa_ty_name"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO";
        }
    }
}
