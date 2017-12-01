using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.coninfodto.d
{
    /// <summary>
    /// ConInfoDTO 的摘要说明。
    /// </summary>
    public class ConInfoDTO : BaseDTO {

        public ConInfoDTO() {
 
        }

        /// <summary>
        /// 报卡名称
        /// </summary>
		public string Card_name {
            get { return getAttrVal<string>("Card_name",null); }
            set { setAttrVal<string>("Card_name", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Pat_name {
            get { return getAttrVal<string>("Pat_name",null); }
            set { setAttrVal<string>("Pat_name", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Pat_xex {
            get { return getAttrVal<string>("Pat_xex",null); }
            set { setAttrVal<string>("Pat_xex", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public string Diagnose {
            get { return getAttrVal<string>("Diagnose",null); }
            set { setAttrVal<string>("Diagnose", value); }
        }

        /// <summary>
        /// 报卡医生
        /// </summary>
		public string Report_doctor {
            get { return getAttrVal<string>("Report_doctor",null); }
            set { setAttrVal<string>("Report_doctor", value); }
        }

        /// <summary>
        /// 报卡日期
        /// </summary>
		public DateTime? Report_date {
            get { return getAttrVal<FDate>("Report_date",null); }
            set { setAttrVal<FDate>("Report_date", value); }
        }

        /// <summary>
        /// 删除原因
        /// </summary>
		public string Delete_reason {
            get { return getAttrVal<string>("Delete_reason",null); }
            set { setAttrVal<string>("Delete_reason", value); }
        }

        /// <summary>
        /// 删除人员
        /// </summary>
		public string Delete_person {
            get { return getAttrVal<string>("Delete_person",null); }
            set { setAttrVal<string>("Delete_person", value); }
        }

        /// <summary>
        /// 操作时间
        /// </summary>
		public DateTime? Opreta_time {
            get { return getAttrVal<FDateTime>("Opreta_time",null); }
            set { setAttrVal<FDateTime>("Opreta_time", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 传染病id
        /// </summary>
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }

        /// <summary>
        /// 预留字段1
        /// </summary>
		public string Spare_field1 {
            get { return getAttrVal<string>("Spare_field1",null); }
            set { setAttrVal<string>("Spare_field1", value); }
        }

        /// <summary>
        /// 预留字段2
        /// </summary>
		public string Spare_field2 {
            get { return getAttrVal<string>("Spare_field2",null); }
            set { setAttrVal<string>("Spare_field2", value); }
        }

        /// <summary>
        /// 预留字段3
        /// </summary>
		public string Spare_field3 {
            get { return getAttrVal<string>("Spare_field3",null); }
            set { setAttrVal<string>("Spare_field3", value); }
        }

        /// <summary>
        /// 预留字段4
        /// </summary>
		public string Spare_field4 {
            get { return getAttrVal<string>("Spare_field4",null); }
            set { setAttrVal<string>("Spare_field4", value); }
        }

        /// <summary>
        /// 预留字段5
        /// </summary>
		public string Spare_field5 {
            get { return getAttrVal<string>("Spare_field5",null); }
            set { setAttrVal<string>("Spare_field5", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Card_name", "Pat_name", "Pat_xex", "Diagnose", "Report_doctor", "Report_date", "Delete_reason", "Delete_person", "Opreta_time", "Id_ent", "Id_contagion", "Spare_field1", "Spare_field2", "Spare_field3", "Spare_field4", "Spare_field5"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.coninfodto.d.ConInfoDTO";
        }
    }
}
