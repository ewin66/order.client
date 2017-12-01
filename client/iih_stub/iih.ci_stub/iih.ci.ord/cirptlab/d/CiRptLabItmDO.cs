
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.cirptlab.d
{
    /// <summary>
    /// CiRptLabItmDO 的摘要说明。
    /// </summary>
    public class CiRptLabItmDO : BaseDO {

        public CiRptLabItmDO() {
        }
		public string Id_rptlisitm {
            get { return getAttrVal<string>("Id_rptlisitm",null); }
            set { setAttrVal<string>("Id_rptlisitm", value); }
        }
		public string Id_rptlab {
            get { return getAttrVal<string>("Id_rptlab",null); }
            set { setAttrVal<string>("Id_rptlab", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }
		public string Val_reference {
            get { return getAttrVal<string>("Val_reference",null); }
            set { setAttrVal<string>("Val_reference", value); }
        }
		public string Val_max {
            get { return getAttrVal<string>("Val_max",null); }
            set { setAttrVal<string>("Val_max", value); }
        }
		public string Val_min {
            get { return getAttrVal<string>("Val_min",null); }
            set { setAttrVal<string>("Val_min", value); }
        }
		public string Val_rstrptlab {
            get { return getAttrVal<string>("Val_rstrptlab",null); }
            set { setAttrVal<string>("Val_rstrptlab", value); }
        }
		public string Id_unit {
            get { return getAttrVal<string>("Id_unit",null); }
            set { setAttrVal<string>("Id_unit", value); }
        }
		public string Id_deviate {
            get { return getAttrVal<string>("Id_deviate",null); }
            set { setAttrVal<string>("Id_deviate", value); }
        }
		public string Sd_deviate {
            get { return getAttrVal<string>("Sd_deviate",null); }
            set { setAttrVal<string>("Sd_deviate", value); }
        }
		public string Sd_restrptlabtp {
            get { return getAttrVal<string>("Sd_restrptlabtp",null); }
            set { setAttrVal<string>("Sd_restrptlabtp", value); }
        }
		public string Val_range {
            get { return getAttrVal<string>("Val_range",null); }
            set { setAttrVal<string>("Val_range", value); }
        }
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }
		public string Shortname {
            get { return getAttrVal<string>("Shortname",null); }
            set { setAttrVal<string>("Shortname", value); }
        }
		public string Unit_name {
            get { return getAttrVal<string>("Unit_name",null); }
            set { setAttrVal<string>("Unit_name", value); }
        }
		public string Name_deviate {
            get { return getAttrVal<string>("Name_deviate",null); }
            set { setAttrVal<string>("Name_deviate", value); }
        }
        public int Ds {
            get { return getAttrVal<int>("Ds",0);}
            set { setAttrVal<int>("Ds", value); }
        }

        public DateTime? Sv        {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        
        /// <summary>
        /// 返回表名
        /// </summary>
        /// <returns></returns>
        public override string getTableName()
        {
            return "CI_RPT_LAB_ITM";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_rptlisitm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.cirptlab.d.CiRptLabItmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_rptlisitm", "Id_rptlab", "Id_srv", "Sortno", "Val_reference", "Val_max", "Val_min", "Val_rstrptlab", "Id_unit", "Id_deviate", "Sd_deviate", "Sd_restrptlabtp", "Val_range", "Name_srv", "Shortname", "Unit_name", "Name_deviate"};
        }
        
    }
}
