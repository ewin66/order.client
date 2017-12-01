using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hospentdto.d
{
    /// <summary>
    /// HospEntDTO 的摘要说明。
    /// </summary>
    public class HospEntDTO : BaseDTO {

        public HospEntDTO() {
 
        }

        /// <summary>
        /// 病案号
        /// </summary>
		public string Hospital_code {
            get { return getAttrVal<string>("Hospital_code",null); }
            set { setAttrVal<string>("Hospital_code", value); }
        }

        /// <summary>
        /// 科室病区床位
        /// </summary>
		public string Dept_ward_bed {
            get { return getAttrVal<string>("Dept_ward_bed",null); }
            set { setAttrVal<string>("Dept_ward_bed", value); }
        }

        /// <summary>
        /// 病人信息
        /// </summary>
		public string Pat_info {
            get { return getAttrVal<string>("Pat_info",null); }
            set { setAttrVal<string>("Pat_info", value); }
        }

        /// <summary>
        /// 感染日期
        /// </summary>
		public string Infect_date {
            get { return getAttrVal<string>("Infect_date",null); }
            set { setAttrVal<string>("Infect_date", value); }
        }

        /// <summary>
        /// 院感诊断
        /// </summary>
		public string Di_hosp_name {
            get { return getAttrVal<string>("Di_hosp_name",null); }
            set { setAttrVal<string>("Di_hosp_name", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 患者号
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 填报日期
        /// </summary>
		public string Dt_report {
            get { return getAttrVal<string>("Dt_report",null); }
            set { setAttrVal<string>("Dt_report", value); }
        }

        /// <summary>
        /// 状态
        /// </summary>
		public string Stages_name {
            get { return getAttrVal<string>("Stages_name",null); }
            set { setAttrVal<string>("Stages_name", value); }
        }

        /// <summary>
        /// 删除原因
        /// </summary>
		public string Delete_reason {
            get { return getAttrVal<string>("Delete_reason",null); }
            set { setAttrVal<string>("Delete_reason", value); }
        }

        /// <summary>
        /// 删除人
        /// </summary>
		public string Delete_person {
            get { return getAttrVal<string>("Delete_person",null); }
            set { setAttrVal<string>("Delete_person", value); }
        }

        /// <summary>
        /// 删除时间
        /// </summary>
		public string Delete_time {
            get { return getAttrVal<string>("Delete_time",null); }
            set { setAttrVal<string>("Delete_time", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Hospital_code", "Dept_ward_bed", "Pat_info", "Infect_date", "Di_hosp_name", "Id_ent", "Id_entp", "Id_pat", "Dt_report", "Stages_name", "Delete_reason", "Delete_person", "Delete_time"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hospentdto.d.HospEntDTO";
        }
    }
}
