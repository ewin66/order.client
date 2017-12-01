
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ordsrvdose.d
{
    /// <summary>
    /// OrdSrvDoseDO 的摘要说明。
    /// </summary>
    public class OrdSrvDoseDO : BaseDO {

        public OrdSrvDoseDO() {
        }
		public string Id_orsrvdose {
            get { return getAttrVal<string>("Id_orsrvdose",null); }
            set { setAttrVal<string>("Id_orsrvdose", value); }
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }
		public string Id_freqtime {
            get { return getAttrVal<string>("Id_freqtime",null); }
            set { setAttrVal<string>("Id_freqtime", value); }
        }
		public DateTime? Dt_freq {
            get { return getAttrVal<FDateTime>("Dt_freq",null); }
            set { setAttrVal<FDateTime>("Dt_freq", value); }
        }
		public int? No_mp {
            get { return getAttrVal<int?>("No_mp",null); }
            set { setAttrVal<int?>("No_mp", value); }
        }
		public double? Quan_dose {
            get { return getAttrVal<FDouble>("Quan_dose",null); }
            set { setAttrVal<FDouble>("Quan_dose", value); }
        }
		public string Id_unit_dose {
            get { return getAttrVal<string>("Id_unit_dose",null); }
            set { setAttrVal<string>("Id_unit_dose", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Name_unit_dose {
            get { return getAttrVal<string>("Name_unit_dose",null); }
            set { setAttrVal<string>("Name_unit_dose", value); }
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
            return "ci_or_srv_dose";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orsrvdose";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrvdose", "Id_orsrv", "Id_or", "Id_freqtime", "Dt_freq", "No_mp", "Quan_dose", "Id_unit_dose", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_unit_dose"};
        }
        
    }
}
