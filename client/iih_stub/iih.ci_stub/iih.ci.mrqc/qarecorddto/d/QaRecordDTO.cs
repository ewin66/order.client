using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.qapatlist.d
{
    /// <summary>
    /// QaRecordDTO 的摘要说明。
    /// </summary>
    public class QaRecordDTO : BaseDTO {

        public QaRecordDTO() {
 
        }

        /// <summary>
        /// dto主键
        /// </summary>
		public string Id_recorddto {
            get { return getAttrVal<string>("Id_recorddto",null); }
            set { setAttrVal<string>("Id_recorddto", value); }
        }

        /// <summary>
        /// 质控日期
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 住院号
        /// </summary>
		public string Code_hospital {
            get { return getAttrVal<string>("Code_hospital",null); }
            set { setAttrVal<string>("Code_hospital", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 主诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 通知书主键
        /// </summary>
		public string Id_revision {
            get { return getAttrVal<string>("Id_revision",null); }
            set { setAttrVal<string>("Id_revision", value); }
        }

        /// <summary>
        /// 通知书状态
        /// </summary>
		public string Id_status {
            get { return getAttrVal<string>("Id_status",null); }
            set { setAttrVal<string>("Id_status", value); }
        }

        /// <summary>
        /// 通知书状态名称
        /// </summary>
		public string Status_name {
            get { return getAttrVal<string>("Status_name",null); }
            set { setAttrVal<string>("Status_name", value); }
        }

        /// <summary>
        /// 质控医生id
        /// </summary>
		public string Id_exec_user {
            get { return getAttrVal<string>("Id_exec_user",null); }
            set { setAttrVal<string>("Id_exec_user", value); }
        }

        /// <summary>
        /// 质控医生
        /// </summary>
		public string Exec_user_name {
            get { return getAttrVal<string>("Exec_user_name",null); }
            set { setAttrVal<string>("Exec_user_name", value); }
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
        /// 缺陷次数
        /// </summary>
		public string Deduct_times {
            get { return getAttrVal<string>("Deduct_times",null); }
            set { setAttrVal<string>("Deduct_times", value); }
        }

        /// <summary>
        /// 整改说明
        /// </summary>
		public string Res {
            get { return getAttrVal<string>("Res",null); }
            set { setAttrVal<string>("Res", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_recorddto", "Dt_plan", "Code_hospital", "Name_pat", "Name_di", "Id_revision", "Id_status", "Status_name", "Id_exec_user", "Exec_user_name", "Id_exec_dept", "Exec_dept_name", "Deduct_times", "Res"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.qapatlist.d.QaRecordDTO";
        }
    }
}
