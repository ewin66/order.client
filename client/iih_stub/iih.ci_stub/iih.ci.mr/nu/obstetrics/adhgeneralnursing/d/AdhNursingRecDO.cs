
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.adhgeneralnursing.d
{
    /// <summary>
    /// AdhNursingRecDO 的摘要说明。
    /// </summary>
    public class AdhNursingRecDO : BaseDO {

		public const string TABLE_NAME = "CI_Mr_NU_ADHNR_REC";
		public const string TABLE_ALIAS_NAME = "a1";

        public AdhNursingRecDO() {
        }
		public string Id_adhnr_rec {
            get { return getAttrVal<string>("Id_adhnr_rec",null); }
            set { setAttrVal<string>("Id_adhnr_rec", value); }
        }
		public string Id_adhnr {
            get { return getAttrVal<string>("Id_adhnr",null); }
            set { setAttrVal<string>("Id_adhnr", value); }
        }
		public DateTime? D_rec {
            get { return getAttrVal<FDate>("D_rec",null); }
            set { setAttrVal<FDate>("D_rec", value); }
        }
		public DateTime? T_rec {
            get { return getAttrVal<FTime>("T_rec",null); }
            set { setAttrVal<FTime>("T_rec", value); }
        }
		public FDouble Tem {
            get { return getAttrVal<FDouble>("Tem",null); }
            set { setAttrVal<FDouble>("Tem", value); }
        }
		public int? Pulse {
            get { return getAttrVal<int?>("Pulse",null); }
            set { setAttrVal<int?>("Pulse", value); }
        }
		public int? Breath {
            get { return getAttrVal<int?>("Breath",null); }
            set { setAttrVal<int?>("Breath", value); }
        }
		public int? Sys_pressure {
            get { return getAttrVal<int?>("Sys_pressure",null); }
            set { setAttrVal<int?>("Sys_pressure", value); }
        }
		public int? Dia_pressure {
            get { return getAttrVal<int?>("Dia_pressure",null); }
            set { setAttrVal<int?>("Dia_pressure", value); }
        }
		public int? Fetal_heart {
            get { return getAttrVal<int?>("Fetal_heart",null); }
            set { setAttrVal<int?>("Fetal_heart", value); }
        }
		public int? Fetal_mo {
            get { return getAttrVal<int?>("Fetal_mo",null); }
            set { setAttrVal<int?>("Fetal_mo", value); }
        }
		public int? Ut_contraction {
            get { return getAttrVal<int?>("Ut_contraction",null); }
            set { setAttrVal<int?>("Ut_contraction", value); }
        }
		public int? Eu_tm {
            get { return getAttrVal<int?>("Eu_tm",null); }
            set { setAttrVal<int?>("Eu_tm", value); }
        }
		public int? Da_ut {
            get { return getAttrVal<int?>("Da_ut",null); }
            set { setAttrVal<int?>("Da_ut", value); }
        }
		public string Name_amount {
            get { return getAttrVal<string>("Name_amount",null); }
            set { setAttrVal<string>("Name_amount", value); }
        }
		public int? Dose_amount {
            get { return getAttrVal<int?>("Dose_amount",null); }
            set { setAttrVal<int?>("Dose_amount", value); }
        }
		public string Id_amount_type {
            get { return getAttrVal<string>("Id_amount_type",null); }
            set { setAttrVal<string>("Id_amount_type", value); }
        }
		public string Sd_amount_type {
            get { return getAttrVal<string>("Sd_amount_type",null); }
            set { setAttrVal<string>("Sd_amount_type", value); }
        }
		public string Id_volume {
            get { return getAttrVal<string>("Id_volume",null); }
            set { setAttrVal<string>("Id_volume", value); }
        }
		public string Sd_volume {
            get { return getAttrVal<string>("Sd_volume",null); }
            set { setAttrVal<string>("Sd_volume", value); }
        }
		public int? Dose_volume {
            get { return getAttrVal<int?>("Dose_volume",null); }
            set { setAttrVal<int?>("Dose_volume", value); }
        }
		public int? Skin_condition {
            get { return getAttrVal<int?>("Skin_condition",null); }
            set { setAttrVal<int?>("Skin_condition", value); }
        }
		public string Obsandmea {
            get { return getAttrVal<string>("Obsandmea",null); }
            set { setAttrVal<string>("Obsandmea", value); }
        }
		public string Id_sign {
            get { return getAttrVal<string>("Id_sign",null); }
            set { setAttrVal<string>("Id_sign", value); }
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
		public string Name_amount_type {
            get { return getAttrVal<string>("Name_amount_type",null); }
            set { setAttrVal<string>("Name_amount_type", value); }
        }
		public string Name_volume {
            get { return getAttrVal<string>("Name_volume",null); }
            set { setAttrVal<string>("Name_volume", value); }
        }
		public string Name_sign {
            get { return getAttrVal<string>("Name_sign",null); }
            set { setAttrVal<string>("Name_sign", value); }
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
            return "CI_Mr_NU_ADHNR_REC";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a1";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_adhnr_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_adhnr_rec", "Id_adhnr", "D_rec", "T_rec", "Tem", "Pulse", "Breath", "Sys_pressure", "Dia_pressure", "Fetal_heart", "Fetal_mo", "Ut_contraction", "Eu_tm", "Da_ut", "Name_amount", "Dose_amount", "Id_amount_type", "Sd_amount_type", "Id_volume", "Sd_volume", "Dose_volume", "Skin_condition", "Obsandmea", "Id_sign", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_amount_type", "Name_volume", "Name_sign"};
        }
        
    }
}
