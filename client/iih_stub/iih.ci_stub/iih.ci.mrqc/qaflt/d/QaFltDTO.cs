using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qaflt.d
{
    /// <summary>
    /// QaFltDTO 的摘要说明。
    /// </summary>
    public class QaFltDTO : BaseDTO {

        public QaFltDTO() {
 
        }

        /// <summary>
        /// 缺陷状态id
        /// </summary>
		public string Id_flt_sta {
            get { return getAttrVal<string>("Id_flt_sta",null); }
            set { setAttrVal<string>("Id_flt_sta", value); }
        }

        /// <summary>
        /// 病历文书
        /// </summary>
		public string Id_mr_name {
            get { return getAttrVal<string>("Id_mr_name",null); }
            set { setAttrVal<string>("Id_mr_name", value); }
        }

        /// <summary>
        /// 缺陷描述
        /// </summary>
		public string Res {
            get { return getAttrVal<string>("Res",null); }
            set { setAttrVal<string>("Res", value); }
        }

        /// <summary>
        /// 扣分标准
        /// </summary>
		public string Deduct_des {
            get { return getAttrVal<string>("Deduct_des",null); }
            set { setAttrVal<string>("Deduct_des", value); }
        }

        /// <summary>
        /// 缺陷扣分次数
        /// </summary>
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
        }

        /// <summary>
        /// 提出日期
        /// </summary>
		public DateTime? Dt_sbmt {
            get { return getAttrVal<FDateTime>("Dt_sbmt",null); }
            set { setAttrVal<FDateTime>("Dt_sbmt", value); }
        }

        /// <summary>
        /// 提出人id
        /// </summary>
		public string Id_sbmt_user {
            get { return getAttrVal<string>("Id_sbmt_user",null); }
            set { setAttrVal<string>("Id_sbmt_user", value); }
        }

        /// <summary>
        /// 整改说明
        /// </summary>
		public string Rfm_req {
            get { return getAttrVal<string>("Rfm_req",null); }
            set { setAttrVal<string>("Rfm_req", value); }
        }

        /// <summary>
        /// 整改人id
        /// </summary>
		public string Id_treat_doctor {
            get { return getAttrVal<string>("Id_treat_doctor",null); }
            set { setAttrVal<string>("Id_treat_doctor", value); }
        }

        /// <summary>
        /// 整改科室id
        /// </summary>
		public string Id_dep_pat {
            get { return getAttrVal<string>("Id_dep_pat",null); }
            set { setAttrVal<string>("Id_dep_pat", value); }
        }

        /// <summary>
        /// 整改期限
        /// </summary>
		public int? Rfm_deadline {
            get { return getAttrVal<int?>("Rfm_deadline",null); }
            set { setAttrVal<int?>("Rfm_deadline", value); }
        }

        /// <summary>
        /// 主键标识
        /// </summary>
		public string Id_qaflt {
            get { return getAttrVal<string>("Id_qaflt",null); }
            set { setAttrVal<string>("Id_qaflt", value); }
        }

        /// <summary>
        /// 缺陷状态编码
        /// </summary>
		public string Sd_flt_sta {
            get { return getAttrVal<string>("Sd_flt_sta",null); }
            set { setAttrVal<string>("Sd_flt_sta", value); }
        }

        /// <summary>
        /// 提出人
        /// </summary>
		public string Sbmt_user_name {
            get { return getAttrVal<string>("Sbmt_user_name",null); }
            set { setAttrVal<string>("Sbmt_user_name", value); }
        }

        /// <summary>
        /// 整改人
        /// </summary>
		public string Treat_doctor_name {
            get { return getAttrVal<string>("Treat_doctor_name",null); }
            set { setAttrVal<string>("Treat_doctor_name", value); }
        }

        /// <summary>
        /// 整改科室
        /// </summary>
		public string Dep_pat {
            get { return getAttrVal<string>("Dep_pat",null); }
            set { setAttrVal<string>("Dep_pat", value); }
        }

        /// <summary>
        /// 缺陷状态
        /// </summary>
		public string Flt_sta_name {
            get { return getAttrVal<string>("Flt_sta_name",null); }
            set { setAttrVal<string>("Flt_sta_name", value); }
        }

        /// <summary>
        /// 缺陷id
        /// </summary>
		public string Id_qa_flt {
            get { return getAttrVal<string>("Id_qa_flt",null); }
            set { setAttrVal<string>("Id_qa_flt", value); }
        }

        /// <summary>
        /// 通知书id
        /// </summary>
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
        }

        /// <summary>
        /// 病历文书id
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 接收人id
        /// </summary>
		public string Id_emp_submit {
            get { return getAttrVal<string>("Id_emp_submit",null); }
            set { setAttrVal<string>("Id_emp_submit", value); }
        }

        /// <summary>
        /// 接收人
        /// </summary>
		public string Emp_submit_name {
            get { return getAttrVal<string>("Emp_submit_name",null); }
            set { setAttrVal<string>("Emp_submit_name", value); }
        }

        /// <summary>
        /// 接受科室id
        /// </summary>
		public string Id_submit_dept {
            get { return getAttrVal<string>("Id_submit_dept",null); }
            set { setAttrVal<string>("Id_submit_dept", value); }
        }

        /// <summary>
        /// 接受科室
        /// </summary>
		public string Submit_dept_name {
            get { return getAttrVal<string>("Submit_dept_name",null); }
            set { setAttrVal<string>("Submit_dept_name", value); }
        }

        /// <summary>
        /// 质控扣分类型
        /// </summary>
		public string Id_qa_drp_scr_tp {
            get { return getAttrVal<string>("Id_qa_drp_scr_tp",null); }
            set { setAttrVal<string>("Id_qa_drp_scr_tp", value); }
        }

        /// <summary>
        /// 单次扣分值
        /// </summary>
		public double? Once_drp_scr {
            get { return getAttrVal<FDouble>("Once_drp_scr",null); }
            set { setAttrVal<FDouble>("Once_drp_scr", value); }
        }

        /// <summary>
        /// 最大扣分值
        /// </summary>
		public double? Max_drp_scr {
            get { return getAttrVal<FDouble>("Max_drp_scr",null); }
            set { setAttrVal<FDouble>("Max_drp_scr", value); }
        }

        /// <summary>
        /// 质控项主键
        /// </summary>
		public string Id_qa_itm {
            get { return getAttrVal<string>("Id_qa_itm",null); }
            set { setAttrVal<string>("Id_qa_itm", value); }
        }

        /// <summary>
        /// 一级分类最大分值(一级分类表)
        /// </summary>
		public double? Score_fstmax {
            get { return getAttrVal<FDouble>("Score_fstmax",null); }
            set { setAttrVal<FDouble>("Score_fstmax", value); }
        }

        /// <summary>
        /// 一级分类名称(一级分类表)
        /// </summary>
		public string Fst_name {
            get { return getAttrVal<string>("Fst_name",null); }
            set { setAttrVal<string>("Fst_name", value); }
        }

        /// <summary>
        /// 一级分类id
        /// </summary>
		public string Id_fst {
            get { return getAttrVal<string>("Id_fst",null); }
            set { setAttrVal<string>("Id_fst", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_flt_sta", "Id_mr_name", "Res", "Deduct_des", "Deduct_scr_times", "Dt_sbmt", "Id_sbmt_user", "Rfm_req", "Id_treat_doctor", "Id_dep_pat", "Rfm_deadline", "Id_qaflt", "Sd_flt_sta", "Sbmt_user_name", "Treat_doctor_name", "Dep_pat", "Flt_sta_name", "Id_qa_flt", "Id_revision", "Id_mr", "Id_emp_submit", "Emp_submit_name", "Id_submit_dept", "Submit_dept_name", "Id_qa_drp_scr_tp", "Once_drp_scr", "Max_drp_scr", "Id_qa_itm", "Score_fstmax", "Fst_name", "Id_fst"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qaflt.d.QaFltDTO";
        }
    }
}
