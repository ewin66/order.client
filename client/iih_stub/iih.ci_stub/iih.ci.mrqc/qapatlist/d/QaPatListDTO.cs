using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qapatlist.d
{
    /// <summary>
    /// QaPatListDTO 的摘要说明。
    /// </summary>
    public class QaPatListDTO : BaseDTO {

        public QaPatListDTO() {
 
        }

        /// <summary>
        /// 环节质控标记
        /// </summary>
		public bool? Fg_process_qa {
            get { return getAttrVal<FBoolean>("Fg_process_qa",null); }
            set { setAttrVal<FBoolean>("Fg_process_qa", value); }
        }

        /// <summary>
        /// 病案号
        /// </summary>
		public string Hospital_code {
            get { return getAttrVal<string>("Hospital_code",null); }
            set { setAttrVal<string>("Hospital_code", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string Bed_code {
            get { return getAttrVal<string>("Bed_code",null); }
            set { setAttrVal<string>("Bed_code", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 性别id
        /// </summary>
		public string Id_sex {
            get { return getAttrVal<string>("Id_sex",null); }
            set { setAttrVal<string>("Id_sex", value); }
        }

        /// <summary>
        /// 性别编码
        /// </summary>
		public string Sd_sex {
            get { return getAttrVal<string>("Sd_sex",null); }
            set { setAttrVal<string>("Sd_sex", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Sex_name {
            get { return getAttrVal<string>("Sex_name",null); }
            set { setAttrVal<string>("Sex_name", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Pat_age {
            get { return getAttrVal<string>("Pat_age",null); }
            set { setAttrVal<string>("Pat_age", value); }
        }

        /// <summary>
        /// 就诊科室编码
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 入院时间
        /// </summary>
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDateTime>("Dt_acpt",null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }

        /// <summary>
        /// 主诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 主管医师编码
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 病危/病重
        /// </summary>
		public string Id_level_dise {
            get { return getAttrVal<string>("Id_level_dise",null); }
            set { setAttrVal<string>("Id_level_dise", value); }
        }

        /// <summary>
        /// 缺陷数
        /// </summary>
		public string Flt_num {
            get { return getAttrVal<string>("Flt_num",null); }
            set { setAttrVal<string>("Flt_num", value); }
        }

        /// <summary>
        /// 质控次数
        /// </summary>
		public string Qa_num {
            get { return getAttrVal<string>("Qa_num",null); }
            set { setAttrVal<string>("Qa_num", value); }
        }

        /// <summary>
        /// 质控医师编码
        /// </summary>
		public string Id_emp_qa {
            get { return getAttrVal<string>("Id_emp_qa",null); }
            set { setAttrVal<string>("Id_emp_qa", value); }
        }

        /// <summary>
        /// 出院时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 主键标识
        /// </summary>
		public string Id_qapatlist {
            get { return getAttrVal<string>("Id_qapatlist",null); }
            set { setAttrVal<string>("Id_qapatlist", value); }
        }

        /// <summary>
        /// 患者编码
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
		public string Dep_phy_name {
            get { return getAttrVal<string>("Dep_phy_name",null); }
            set { setAttrVal<string>("Dep_phy_name", value); }
        }

        /// <summary>
        /// 主管医师
        /// </summary>
		public string Emp_phy_name {
            get { return getAttrVal<string>("Emp_phy_name",null); }
            set { setAttrVal<string>("Emp_phy_name", value); }
        }

        /// <summary>
        /// 质控医师
        /// </summary>
		public string Emp_qa_name {
            get { return getAttrVal<string>("Emp_qa_name",null); }
            set { setAttrVal<string>("Emp_qa_name", value); }
        }

        /// <summary>
        /// 终末质控标志
        /// </summary>
		public bool? Fg_terminal_qa {
            get { return getAttrVal<FBoolean>("Fg_terminal_qa",null); }
            set { setAttrVal<FBoolean>("Fg_terminal_qa", value); }
        }

        /// <summary>
        /// 科室质控标志
        /// </summary>
		public bool? Fg_dept_qa {
            get { return getAttrVal<FBoolean>("Fg_dept_qa",null); }
            set { setAttrVal<FBoolean>("Fg_dept_qa", value); }
        }

        /// <summary>
        /// 医生部分病案状态
        /// </summary>
		public string Id_qa_doctor_part_sta {
            get { return getAttrVal<string>("Id_qa_doctor_part_sta",null); }
            set { setAttrVal<string>("Id_qa_doctor_part_sta", value); }
        }

        /// <summary>
        /// 医生部分病案状态编码
        /// </summary>
		public string Sd_qa_doctor_part_sta {
            get { return getAttrVal<string>("Sd_qa_doctor_part_sta",null); }
            set { setAttrVal<string>("Sd_qa_doctor_part_sta", value); }
        }

        /// <summary>
        /// 病案主键
        /// </summary>
		public string Id_amr {
            get { return getAttrVal<string>("Id_amr",null); }
            set { setAttrVal<string>("Id_amr", value); }
        }

        /// <summary>
        /// 缺陷主键标识
        /// </summary>
		public string Id_qaflt {
            get { return getAttrVal<string>("Id_qaflt",null); }
            set { setAttrVal<string>("Id_qaflt", value); }
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
        /// 缺陷状态id
        /// </summary>
		public string Id_flt_sta {
            get { return getAttrVal<string>("Id_flt_sta",null); }
            set { setAttrVal<string>("Id_flt_sta", value); }
        }

        /// <summary>
        /// 缺陷状态编码
        /// </summary>
		public string Sd_flt_sta {
            get { return getAttrVal<string>("Sd_flt_sta",null); }
            set { setAttrVal<string>("Sd_flt_sta", value); }
        }

        /// <summary>
        /// 缺陷状态
        /// </summary>
		public string Flt_sta_name {
            get { return getAttrVal<string>("Flt_sta_name",null); }
            set { setAttrVal<string>("Flt_sta_name", value); }
        }

        /// <summary>
        /// 病历文书id
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
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
		public string Deduct_scr_times {
            get { return getAttrVal<string>("Deduct_scr_times",null); }
            set { setAttrVal<string>("Deduct_scr_times", value); }
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
        /// 提出人
        /// </summary>
		public string Sbmt_user_name {
            get { return getAttrVal<string>("Sbmt_user_name",null); }
            set { setAttrVal<string>("Sbmt_user_name", value); }
        }

        /// <summary>
        /// 整改说明
        /// </summary>
		public string Rfm_req {
            get { return getAttrVal<string>("Rfm_req",null); }
            set { setAttrVal<string>("Rfm_req", value); }
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
        /// 整改期限
        /// </summary>
		public int? Rfm_deadline {
            get { return getAttrVal<int?>("Rfm_deadline",null); }
            set { setAttrVal<int?>("Rfm_deadline", value); }
        }

        /// <summary>
        /// 整改人id
        /// </summary>
		public string Id_treat_doctor {
            get { return getAttrVal<string>("Id_treat_doctor",null); }
            set { setAttrVal<string>("Id_treat_doctor", value); }
        }

        /// <summary>
        /// 整改人
        /// </summary>
		public string Treat_doctor_name {
            get { return getAttrVal<string>("Treat_doctor_name",null); }
            set { setAttrVal<string>("Treat_doctor_name", value); }
        }

        /// <summary>
        /// 整改科室id
        /// </summary>
		public string Id_dep_pat {
            get { return getAttrVal<string>("Id_dep_pat",null); }
            set { setAttrVal<string>("Id_dep_pat", value); }
        }

        /// <summary>
        /// 整改科室
        /// </summary>
		public string Dep_pat {
            get { return getAttrVal<string>("Dep_pat",null); }
            set { setAttrVal<string>("Dep_pat", value); }
        }

        /// <summary>
        /// 科室质控打回原因
        /// </summary>
		public string Reason_deptqc_back {
            get { return getAttrVal<string>("Reason_deptqc_back",null); }
            set { setAttrVal<string>("Reason_deptqc_back", value); }
        }

        /// <summary>
        /// 终末质控打回原因
        /// </summary>
		public string Reason_terminaltqc_back {
            get { return getAttrVal<string>("Reason_terminaltqc_back",null); }
            set { setAttrVal<string>("Reason_terminaltqc_back", value); }
        }

        /// <summary>
        /// 患者缺陷数
        /// </summary>
		public int? Flt_times {
            get { return getAttrVal<int?>("Flt_times",null); }
            set { setAttrVal<int?>("Flt_times", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth_pat {
            get { return getAttrVal<FDate>("Dt_birth_pat",null); }
            set { setAttrVal<FDate>("Dt_birth_pat", value); }
        }

        /// <summary>
        /// 出院科室id
        /// </summary>
		public string Id_dep_phydisc {
            get { return getAttrVal<string>("Id_dep_phydisc",null); }
            set { setAttrVal<string>("Id_dep_phydisc", value); }
        }

        /// <summary>
        /// 出院科室
        /// </summary>
		public string Dep_phydisc {
            get { return getAttrVal<string>("Dep_phydisc",null); }
            set { setAttrVal<string>("Dep_phydisc", value); }
        }

        /// <summary>
        /// 病案打回原因
        /// </summary>
		public string Reason_amr_back {
            get { return getAttrVal<string>("Reason_amr_back",null); }
            set { setAttrVal<string>("Reason_amr_back", value); }
        }

        /// <summary>
        /// 病案打回标志
        /// </summary>
		public bool? Fg_amr_callback {
            get { return getAttrVal<FBoolean>("Fg_amr_callback",null); }
            set { setAttrVal<FBoolean>("Fg_amr_callback", value); }
        }

        /// <summary>
        /// 签收人id
        /// </summary>
		public string Id_user_signoff {
            get { return getAttrVal<string>("Id_user_signoff",null); }
            set { setAttrVal<string>("Id_user_signoff", value); }
        }

        /// <summary>
        /// 签收科室id
        /// </summary>
		public string Id_dep_signoff {
            get { return getAttrVal<string>("Id_dep_signoff",null); }
            set { setAttrVal<string>("Id_dep_signoff", value); }
        }

        /// <summary>
        /// 签收时间
        /// </summary>
		public DateTime? Dt_signoff {
            get { return getAttrVal<FDateTime>("Dt_signoff",null); }
            set { setAttrVal<FDateTime>("Dt_signoff", value); }
        }

        /// <summary>
        /// 编目人id
        /// </summary>
		public string Id_user_catalogue {
            get { return getAttrVal<string>("Id_user_catalogue",null); }
            set { setAttrVal<string>("Id_user_catalogue", value); }
        }

        /// <summary>
        /// 编目科室id
        /// </summary>
		public string Id_dep_catalogue {
            get { return getAttrVal<string>("Id_dep_catalogue",null); }
            set { setAttrVal<string>("Id_dep_catalogue", value); }
        }

        /// <summary>
        /// 编目时间
        /// </summary>
		public DateTime? Dt_catalogue {
            get { return getAttrVal<FDateTime>("Dt_catalogue",null); }
            set { setAttrVal<FDateTime>("Dt_catalogue", value); }
        }

        /// <summary>
        /// 归档人id
        /// </summary>
		public string Id_user_pigeonhole {
            get { return getAttrVal<string>("Id_user_pigeonhole",null); }
            set { setAttrVal<string>("Id_user_pigeonhole", value); }
        }

        /// <summary>
        /// 归档科室id
        /// </summary>
		public string Id_dep_pigeonhole {
            get { return getAttrVal<string>("Id_dep_pigeonhole",null); }
            set { setAttrVal<string>("Id_dep_pigeonhole", value); }
        }

        /// <summary>
        /// 归档时间
        /// </summary>
		public DateTime? Dt_pigeonhole {
            get { return getAttrVal<FDateTime>("Dt_pigeonhole",null); }
            set { setAttrVal<FDateTime>("Dt_pigeonhole", value); }
        }

        /// <summary>
        /// 签收人
        /// </summary>
		public string User_signoff {
            get { return getAttrVal<string>("User_signoff",null); }
            set { setAttrVal<string>("User_signoff", value); }
        }

        /// <summary>
        /// 签收科室
        /// </summary>
		public string Dep_signoff {
            get { return getAttrVal<string>("Dep_signoff",null); }
            set { setAttrVal<string>("Dep_signoff", value); }
        }

        /// <summary>
        /// 编目人
        /// </summary>
		public string User_catalogue {
            get { return getAttrVal<string>("User_catalogue",null); }
            set { setAttrVal<string>("User_catalogue", value); }
        }

        /// <summary>
        /// 编目科室
        /// </summary>
		public string Dep_catalogue {
            get { return getAttrVal<string>("Dep_catalogue",null); }
            set { setAttrVal<string>("Dep_catalogue", value); }
        }

        /// <summary>
        /// 归档人
        /// </summary>
		public string User_pigeonhole {
            get { return getAttrVal<string>("User_pigeonhole",null); }
            set { setAttrVal<string>("User_pigeonhole", value); }
        }

        /// <summary>
        /// 归档科室
        /// </summary>
		public string Dep_pigeonhole {
            get { return getAttrVal<string>("Dep_pigeonhole",null); }
            set { setAttrVal<string>("Dep_pigeonhole", value); }
        }

        /// <summary>
        /// 住院病案编号
        /// </summary>
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }

        /// <summary>
        /// 就诊编码
        /// </summary>
		public string Ent_code {
            get { return getAttrVal<string>("Ent_code",null); }
            set { setAttrVal<string>("Ent_code", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Fg_process_qa", "Hospital_code", "Bed_code", "Pat_name", "Id_sex", "Sd_sex", "Sex_name", "Pat_age", "Id_dep_phy", "Dt_acpt", "Name_di", "Id_emp_phy", "Id_level_dise", "Flt_num", "Qa_num", "Id_emp_qa", "Dt_end", "Id_ent", "Code_entp", "Id_qapatlist", "Id_pat", "Dep_phy_name", "Emp_phy_name", "Emp_qa_name", "Fg_terminal_qa", "Fg_dept_qa", "Id_qa_doctor_part_sta", "Sd_qa_doctor_part_sta", "Id_amr", "Id_qaflt", "Id_qa_flt", "Id_revision", "Id_flt_sta", "Sd_flt_sta", "Flt_sta_name", "Id_mr", "Id_mr_name", "Res", "Deduct_des", "Deduct_scr_times", "Dt_sbmt", "Id_sbmt_user", "Sbmt_user_name", "Rfm_req", "Id_emp_submit", "Emp_submit_name", "Id_submit_dept", "Submit_dept_name", "Rfm_deadline", "Id_treat_doctor", "Treat_doctor_name", "Id_dep_pat", "Dep_pat", "Reason_deptqc_back", "Reason_terminaltqc_back", "Flt_times", "Dt_birth_pat", "Id_dep_phydisc", "Dep_phydisc", "Reason_amr_back", "Fg_amr_callback", "Id_user_signoff", "Id_dep_signoff", "Dt_signoff", "Id_user_catalogue", "Id_dep_catalogue", "Dt_catalogue", "Id_user_pigeonhole", "Id_dep_pigeonhole", "Dt_pigeonhole", "User_signoff", "Dep_signoff", "User_catalogue", "Dep_catalogue", "User_pigeonhole", "Dep_pigeonhole", "Code_amr_ip", "Ent_code"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qapatlist.d.QaPatListDTO";
        }
    }
}
