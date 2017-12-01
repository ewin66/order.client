using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatsigns.d
{
    /// <summary>
    /// PatDTO 的摘要说明。
    /// </summary>
    public class PatDTO : BaseDTO {

        public PatDTO() {
 
        }

        /// <summary>
        /// 就诊ID
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        ///  患者ID
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 住院类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 住院号
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 床位号
        /// </summary>
		public string Bebcode {
            get { return getAttrVal<string>("Bebcode",null); }
            set { setAttrVal<string>("Bebcode", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Sex {
            get { return getAttrVal<string>("Sex",null); }
            set { setAttrVal<string>("Sex", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 是否选中
        /// </summary>
		public bool? Checked {
            get { return getAttrVal<FBoolean>("Checked",null); }
            set { setAttrVal<FBoolean>("Checked", value); }
        }

        /// <summary>
        /// 任务标识
        /// </summary>
		public bool? Fg_task {
            get { return getAttrVal<FBoolean>("Fg_task",null); }
            set { setAttrVal<FBoolean>("Fg_task", value); }
        }

        /// <summary>
        /// 应录总数
        /// </summary>
		public int? Task_all {
            get { return getAttrVal<int?>("Task_all",null); }
            set { setAttrVal<int?>("Task_all", value); }
        }

        /// <summary>
        /// 已录次数
        /// </summary>
		public int? Task_ed {
            get { return getAttrVal<int?>("Task_ed",null); }
            set { setAttrVal<int?>("Task_ed", value); }
        }

        /// <summary>
        /// 未录次数
        /// </summary>
		public int? Task_ing {
            get { return getAttrVal<int?>("Task_ing",null); }
            set { setAttrVal<int?>("Task_ing", value); }
        }

        /// <summary>
        /// 说明
        /// </summary>
		public string Instraction {
            get { return getAttrVal<string>("Instraction",null); }
            set { setAttrVal<string>("Instraction", value); }
        }

        /// <summary>
        /// 入院日期
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDate>("Dt_entry",null); }
            set { setAttrVal<FDate>("Dt_entry", value); }
        }

        /// <summary>
        /// 出院日期
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDate>("Dt_end",null); }
            set { setAttrVal<FDate>("Dt_end", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ent", "Id_pat", "Code_entp", "Code", "Bebcode", "Name", "Sex", "Age", "Dt_birth", "Checked", "Fg_task", "Task_all", "Task_ed", "Task_ing", "Instraction", "Dt_entry", "Dt_end"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatsigns.d.PatDTO";
        }
    }
}
