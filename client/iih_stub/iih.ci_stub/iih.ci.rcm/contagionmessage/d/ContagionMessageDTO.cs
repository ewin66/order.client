using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.contagionmessage.d
{
    /// <summary>
    /// ContagionMessageDTO 的摘要说明。
    /// </summary>
    public class ContagionMessageDTO : BaseDTO {

        public ContagionMessageDTO() {
 
        }

        /// <summary>
        /// 传染病主键
        /// </summary>
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }

        /// <summary>
        /// 保存时间
        /// </summary>
		public string Save_time {
            get { return getAttrVal<string>("Save_time",null); }
            set { setAttrVal<string>("Save_time", value); }
        }

        /// <summary>
        /// 填报科室
        /// </summary>
		public string Report_dep {
            get { return getAttrVal<string>("Report_dep",null); }
            set { setAttrVal<string>("Report_dep", value); }
        }

        /// <summary>
        /// 填报医生
        /// </summary>
		public string Report_doc {
            get { return getAttrVal<string>("Report_doc",null); }
            set { setAttrVal<string>("Report_doc", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pat {
            get { return getAttrVal<string>("Name_pat",null); }
            set { setAttrVal<string>("Name_pat", value); }
        }

        /// <summary>
        /// 疾病名称
        /// </summary>
		public string Name_disease {
            get { return getAttrVal<string>("Name_disease",null); }
            set { setAttrVal<string>("Name_disease", value); }
        }

        /// <summary>
        /// 自定义1
        /// </summary>
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }

        /// <summary>
        /// 自定义2
        /// </summary>
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }

        /// <summary>
        /// 自定义3
        /// </summary>
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagion", "Save_time", "Report_dep", "Report_doc", "Name_pat", "Name_disease", "Def1", "Def2", "Def3"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.contagionmessage.d.ContagionMessageDTO";
        }
    }
}
