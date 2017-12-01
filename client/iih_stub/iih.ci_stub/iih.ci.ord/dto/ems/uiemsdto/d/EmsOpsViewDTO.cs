using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsOpsViewDTO 的摘要说明。
    /// </summary>
    public class EmsOpsViewDTO : BaseDTO {

        public EmsOpsViewDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务ID
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 处置项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 单价
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 执行科室ID
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室过滤条件
        /// </summary>
		public string Filter_dep_mp {
            get { return getAttrVal<string>("Filter_dep_mp",null); }
            set { setAttrVal<string>("Filter_dep_mp", value); }
        }

        /// <summary>
        /// 计划手术时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 手术时限
        /// </summary>
		public string Optime_limit {
            get { return getAttrVal<string>("Optime_limit",null); }
            set { setAttrVal<string>("Optime_limit", value); }
        }

        /// <summary>
        /// 诊断ID
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 诊断过滤条件
        /// </summary>
		public string Filter_di {
            get { return getAttrVal<string>("Filter_di",null); }
            set { setAttrVal<string>("Filter_di", value); }
        }

        /// <summary>
        /// 麻醉方式
        /// </summary>
		public string Name_anestp {
            get { return getAttrVal<string>("Name_anestp",null); }
            set { setAttrVal<string>("Name_anestp", value); }
        }

        /// <summary>
        /// 麻醉方式ID
        /// </summary>
		public string Id_anestp {
            get { return getAttrVal<string>("Id_anestp",null); }
            set { setAttrVal<string>("Id_anestp", value); }
        }

        /// <summary>
        /// 麻醉方式SD
        /// </summary>
		public string Sd_anestp {
            get { return getAttrVal<string>("Sd_anestp",null); }
            set { setAttrVal<string>("Sd_anestp", value); }
        }

        /// <summary>
        /// 注意事项
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 附加术ID
        /// </summary>
		public string Id_opex_srvs {
            get { return getAttrVal<string>("Id_opex_srvs",null); }
            set { setAttrVal<string>("Id_opex_srvs", value); }
        }

        /// <summary>
        /// 附加术编码
        /// </summary>
		public string Code_opex_srvs {
            get { return getAttrVal<string>("Code_opex_srvs",null); }
            set { setAttrVal<string>("Code_opex_srvs", value); }
        }

        /// <summary>
        /// 附加术
        /// </summary>
		public string Name_opex_srvs {
            get { return getAttrVal<string>("Name_opex_srvs",null); }
            set { setAttrVal<string>("Name_opex_srvs", value); }
        }

        /// <summary>
        /// 主刀医生ID
        /// </summary>
		public string Id_emp_operator {
            get { return getAttrVal<string>("Id_emp_operator",null); }
            set { setAttrVal<string>("Id_emp_operator", value); }
        }

        /// <summary>
        /// 主刀医生
        /// </summary>
		public string Name_emp_operator {
            get { return getAttrVal<string>("Name_emp_operator",null); }
            set { setAttrVal<string>("Name_emp_operator", value); }
        }

        /// <summary>
        /// 第一助手ID
        /// </summary>
		public string Id_emp_help1 {
            get { return getAttrVal<string>("Id_emp_help1",null); }
            set { setAttrVal<string>("Id_emp_help1", value); }
        }

        /// <summary>
        /// 第一助手
        /// </summary>
		public string Name_emp_help1 {
            get { return getAttrVal<string>("Name_emp_help1",null); }
            set { setAttrVal<string>("Name_emp_help1", value); }
        }

        /// <summary>
        /// 手术级别
        /// </summary>
		public string Name_lvlsug {
            get { return getAttrVal<string>("Name_lvlsug",null); }
            set { setAttrVal<string>("Name_lvlsug", value); }
        }

        /// <summary>
        /// 手术级别SD
        /// </summary>
		public string Sd_lvlsug {
            get { return getAttrVal<string>("Sd_lvlsug",null); }
            set { setAttrVal<string>("Sd_lvlsug", value); }
        }

        /// <summary>
        /// 手术级别ID
        /// </summary>
		public string Id_lvlsug {
            get { return getAttrVal<string>("Id_lvlsug",null); }
            set { setAttrVal<string>("Id_lvlsug", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Fg_urgent", "Price", "Sd_srvtp", "Id_dep_mp", "Name_dep_mp", "Filter_dep_mp", "Dt_plan", "Optime_limit", "Id_di", "Name_di", "Filter_di", "Name_anestp", "Id_anestp", "Sd_anestp", "Announcements", "Id_opex_srvs", "Code_opex_srvs", "Name_opex_srvs", "Id_emp_operator", "Name_emp_operator", "Id_emp_help1", "Name_emp_help1", "Name_lvlsug", "Sd_lvlsug", "Id_lvlsug", "Sv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsOpsViewDTO";
        }
    }
}
