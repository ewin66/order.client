using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsItemInCons 的摘要说明。
    /// </summary>
    public class EmsItemInCons : BaseDTO {

        public EmsItemInCons() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_emsitemincons {
            get { return getAttrVal<string>("Id_emsitemincons",null); }
            set { setAttrVal<string>("Id_emsitemincons", value); }
        }

        /// <summary>
        /// 排序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 受邀机构id
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 受邀机构
        /// </summary>
		public string Name_org {
            get { return getAttrVal<string>("Name_org",null); }
            set { setAttrVal<string>("Name_org", value); }
        }

        /// <summary>
        /// 受邀科室id
        /// </summary>
		public string Id_dep_emp {
            get { return getAttrVal<string>("Id_dep_emp",null); }
            set { setAttrVal<string>("Id_dep_emp", value); }
        }

        /// <summary>
        /// 受邀科室
        /// </summary>
		public string Name_dep_emp {
            get { return getAttrVal<string>("Name_dep_emp",null); }
            set { setAttrVal<string>("Name_dep_emp", value); }
        }

        /// <summary>
        /// 受邀职称编码
        /// </summary>
		public string Sd_emp_title {
            get { return getAttrVal<string>("Sd_emp_title",null); }
            set { setAttrVal<string>("Sd_emp_title", value); }
        }

        /// <summary>
        /// 受邀职称id
        /// </summary>
		public string Id_emp_title {
            get { return getAttrVal<string>("Id_emp_title",null); }
            set { setAttrVal<string>("Id_emp_title", value); }
        }

        /// <summary>
        /// 受邀职称
        /// </summary>
		public string Name_emp_title {
            get { return getAttrVal<string>("Name_emp_title",null); }
            set { setAttrVal<string>("Name_emp_title", value); }
        }

        /// <summary>
        /// 受邀人id
        /// </summary>
		public string Id_emp_doctor {
            get { return getAttrVal<string>("Id_emp_doctor",null); }
            set { setAttrVal<string>("Id_emp_doctor", value); }
        }

        /// <summary>
        /// 受邀人
        /// </summary>
		public string Name_emp_doctor {
            get { return getAttrVal<string>("Name_emp_doctor",null); }
            set { setAttrVal<string>("Name_emp_doctor", value); }
        }

        /// <summary>
        /// 应答时间
        /// </summary>
		public DateTime? Dt_response {
            get { return getAttrVal<FDateTime>("Dt_response",null); }
            set { setAttrVal<FDateTime>("Dt_response", value); }
        }

        /// <summary>
        /// 应答标志
        /// </summary>
		public bool? Fg_response {
            get { return getAttrVal<FBoolean>("Fg_response",null); }
            set { setAttrVal<FBoolean>("Fg_response", value); }
        }

        /// <summary>
        /// 应答人id
        /// </summary>
		public string Id_emp_response {
            get { return getAttrVal<string>("Id_emp_response",null); }
            set { setAttrVal<string>("Id_emp_response", value); }
        }

        /// <summary>
        /// 应答人
        /// </summary>
		public string Name_emp_response {
            get { return getAttrVal<string>("Name_emp_response",null); }
            set { setAttrVal<string>("Name_emp_response", value); }
        }

        /// <summary>
        /// 会诊项目id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 会诊项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 会诊类型编码
        /// </summary>
		public string Sd_constp {
            get { return getAttrVal<string>("Sd_constp",null); }
            set { setAttrVal<string>("Sd_constp", value); }
        }

        /// <summary>
        /// 会诊类型id
        /// </summary>
		public string Id_constp {
            get { return getAttrVal<string>("Id_constp",null); }
            set { setAttrVal<string>("Id_constp", value); }
        }

        /// <summary>
        /// 会诊类型
        /// </summary>
		public string Name_constp {
            get { return getAttrVal<string>("Name_constp",null); }
            set { setAttrVal<string>("Name_constp", value); }
        }


        /// <summary>
        /// 版本号
        /// </summary>
        public DateTime? Sv
        {
            get { return getAttrVal<DateTime?>("Sv", null); }
            set { setAttrVal<DateTime?>("Sv", value); }
        }

        /// <summary>
        /// 医保
        /// </summary>
        public string Id_haeth
        {
            get { return getAttrVal<string>("Id_hp", null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
        public string Name_heath
        {
            get { return getAttrVal<string>("Name_hp", null); }
            set { setAttrVal<string>("Name_hp", value); }
        }
        /// <summary>
        /// 服务医保类型
        /// </summary>
        public string Id_hpsrvtp
        {
            get { return getAttrVal<string>("Id_hpsrvtp", null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 服务医保类型编码
        /// </summary>
        public string Sd_hpsrvtp
        {
            get { return getAttrVal<string>("Sd_hpsrvtp", null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 医疗单来源
        /// 内部类型：[OrSrvAgentInfoDO]
        /// </summary>
        public int? Eu_sourcemd
        {
            get { return getAttrVal<int?>("Eu_sourcemd", null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 所属服务来源
        /// </summary>
        public string Id_srv_src
        {
            get { return getAttrVal<string>("Id_srv_src", null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }
        /// <summary>
        /// 计价状态
        /// </summary>
        public string Priby
        {
            get { return getAttrVal<string>("Priby", null); }
            set { setAttrVal<string>("Priby", value); }
        }


        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_emsitemincons", "Sortno", "Id_org", "Name_org", "Id_dep_emp", "Name_dep_emp", "Sd_emp_title", "Id_emp_title", "Name_emp_title", "Id_emp_doctor", "Name_emp_doctor", "Dt_response", "Fg_response", "Id_emp_response", "Name_emp_response", "Id_srv", "Name_srv", "Sd_constp", "Id_constp", "Name_constp", "Sv", "Id_hp", "Name_hp", "Id_hpsrvtp", "Sd_hpsrvtp" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsItemInCons";
        }
    }
}
