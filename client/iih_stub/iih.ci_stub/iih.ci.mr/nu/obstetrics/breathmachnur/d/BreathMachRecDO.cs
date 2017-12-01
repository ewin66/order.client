
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.obstetrics.breathmachnur.d
{
    /// <summary>
    /// BreathMachRecDO 的摘要说明。
    /// </summary>
    public class BreathMachRecDO : BaseDO {

		public const string TABLE_NAME = "CI_MR_NU_BTHMACH_REC";
		public const string TABLE_ALIAS_NAME = "a1";

        public BreathMachRecDO() {
        }
		public string Id_bthmachrec {
            get { return getAttrVal<string>("Id_bthmachrec",null); }
            set { setAttrVal<string>("Id_bthmachrec", value); }
        }
		public string Id_bthmach {
            get { return getAttrVal<string>("Id_bthmach",null); }
            set { setAttrVal<string>("Id_bthmach", value); }
        }
		public DateTime? Dt_rec {
            get { return getAttrVal<FDateTime>("Dt_rec",null); }
            set { setAttrVal<FDateTime>("Dt_rec", value); }
        }
		public string Id_mechanical_ventilation {
            get { return getAttrVal<string>("Id_mechanical_ventilation",null); }
            set { setAttrVal<string>("Id_mechanical_ventilation", value); }
        }
		public string Sd_mechanical_ventilation {
            get { return getAttrVal<string>("Sd_mechanical_ventilation",null); }
            set { setAttrVal<string>("Sd_mechanical_ventilation", value); }
        }
		public FDouble Fr {
            get { return getAttrVal<FDouble>("Fr",null); }
            set { setAttrVal<FDouble>("Fr", value); }
        }
		public FDouble Pip {
            get { return getAttrVal<FDouble>("Pip",null); }
            set { setAttrVal<FDouble>("Pip", value); }
        }
		public FDouble P {
            get { return getAttrVal<FDouble>("P",null); }
            set { setAttrVal<FDouble>("P", value); }
        }
		public FDouble Peep {
            get { return getAttrVal<FDouble>("Peep",null); }
            set { setAttrVal<FDouble>("Peep", value); }
        }
		public FDouble Map {
            get { return getAttrVal<FDouble>("Map",null); }
            set { setAttrVal<FDouble>("Map", value); }
        }
		public FDouble Rr_machine {
            get { return getAttrVal<FDouble>("Rr_machine",null); }
            set { setAttrVal<FDouble>("Rr_machine", value); }
        }
		public FDouble F {
            get { return getAttrVal<FDouble>("F",null); }
            set { setAttrVal<FDouble>("F", value); }
        }
		public FDouble It {
            get { return getAttrVal<FDouble>("It",null); }
            set { setAttrVal<FDouble>("It", value); }
        }
		public FDouble Ie {
            get { return getAttrVal<FDouble>("Ie",null); }
            set { setAttrVal<FDouble>("Ie", value); }
        }
		public FDouble Fio2 {
            get { return getAttrVal<FDouble>("Fio2",null); }
            set { setAttrVal<FDouble>("Fio2", value); }
        }
		public FDouble Tem {
            get { return getAttrVal<FDouble>("Tem",null); }
            set { setAttrVal<FDouble>("Tem", value); }
        }
		public int? Heart_rate {
            get { return getAttrVal<int?>("Heart_rate",null); }
            set { setAttrVal<int?>("Heart_rate", value); }
        }
		public int? Respiratory_frequency {
            get { return getAttrVal<int?>("Respiratory_frequency",null); }
            set { setAttrVal<int?>("Respiratory_frequency", value); }
        }
		public int? Dbp {
            get { return getAttrVal<int?>("Dbp",null); }
            set { setAttrVal<int?>("Dbp", value); }
        }
		public int? Sbp {
            get { return getAttrVal<int?>("Sbp",null); }
            set { setAttrVal<int?>("Sbp", value); }
        }
		public FDouble Spo2 {
            get { return getAttrVal<FDouble>("Spo2",null); }
            set { setAttrVal<FDouble>("Spo2", value); }
        }
		public string Name_drug {
            get { return getAttrVal<string>("Name_drug",null); }
            set { setAttrVal<string>("Name_drug", value); }
        }
		public int? Dose_drugs {
            get { return getAttrVal<int?>("Dose_drugs",null); }
            set { setAttrVal<int?>("Dose_drugs", value); }
        }
		public string Id_route_drug {
            get { return getAttrVal<string>("Id_route_drug",null); }
            set { setAttrVal<string>("Id_route_drug", value); }
        }
		public string Sd_route_drug {
            get { return getAttrVal<string>("Sd_route_drug",null); }
            set { setAttrVal<string>("Sd_route_drug", value); }
        }
		public int? Spped_drug {
            get { return getAttrVal<int?>("Spped_drug",null); }
            set { setAttrVal<int?>("Spped_drug", value); }
        }
		public string Id_unit_speed {
            get { return getAttrVal<string>("Id_unit_speed",null); }
            set { setAttrVal<string>("Id_unit_speed", value); }
        }
		public string Sd_unit_speed {
            get { return getAttrVal<string>("Sd_unit_speed",null); }
            set { setAttrVal<string>("Sd_unit_speed", value); }
        }
		public string Id_diet {
            get { return getAttrVal<string>("Id_diet",null); }
            set { setAttrVal<string>("Id_diet", value); }
        }
		public string Sd_diet {
            get { return getAttrVal<string>("Sd_diet",null); }
            set { setAttrVal<string>("Sd_diet", value); }
        }
		public string Id_dosein_way {
            get { return getAttrVal<string>("Id_dosein_way",null); }
            set { setAttrVal<string>("Id_dosein_way", value); }
        }
		public string Sd_dosein_way {
            get { return getAttrVal<string>("Sd_dosein_way",null); }
            set { setAttrVal<string>("Sd_dosein_way", value); }
        }
		public int? Dose_drink {
            get { return getAttrVal<int?>("Dose_drink",null); }
            set { setAttrVal<int?>("Dose_drink", value); }
        }
		public int? Shit {
            get { return getAttrVal<int?>("Shit",null); }
            set { setAttrVal<int?>("Shit", value); }
        }
		public int? A_skit {
            get { return getAttrVal<int?>("A_skit",null); }
            set { setAttrVal<int?>("A_skit", value); }
        }
		public int? Urine {
            get { return getAttrVal<int?>("Urine",null); }
            set { setAttrVal<int?>("Urine", value); }
        }
		public int? A_urine {
            get { return getAttrVal<int?>("A_urine",null); }
            set { setAttrVal<int?>("A_urine", value); }
        }
		public string Id_suction_way {
            get { return getAttrVal<string>("Id_suction_way",null); }
            set { setAttrVal<string>("Id_suction_way", value); }
        }
		public string Sd_suction_way {
            get { return getAttrVal<string>("Sd_suction_way",null); }
            set { setAttrVal<string>("Sd_suction_way", value); }
        }
		public string Nature {
            get { return getAttrVal<string>("Nature",null); }
            set { setAttrVal<string>("Nature", value); }
        }
		public string Id_skin_color {
            get { return getAttrVal<string>("Id_skin_color",null); }
            set { setAttrVal<string>("Id_skin_color", value); }
        }
		public string Sd_skin_color {
            get { return getAttrVal<string>("Sd_skin_color",null); }
            set { setAttrVal<string>("Sd_skin_color", value); }
        }
		public string Id_skin {
            get { return getAttrVal<string>("Id_skin",null); }
            set { setAttrVal<string>("Id_skin", value); }
        }
		public string Sd_skin {
            get { return getAttrVal<string>("Sd_skin",null); }
            set { setAttrVal<string>("Sd_skin", value); }
        }
		public string Id_pipe {
            get { return getAttrVal<string>("Id_pipe",null); }
            set { setAttrVal<string>("Id_pipe", value); }
        }
		public string Sd_pipe {
            get { return getAttrVal<string>("Sd_pipe",null); }
            set { setAttrVal<string>("Sd_pipe", value); }
        }
		public string Bqbhjcl {
            get { return getAttrVal<string>("Bqbhjcl",null); }
            set { setAttrVal<string>("Bqbhjcl", value); }
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
		public string Name_mechanical_ventilation {
            get { return getAttrVal<string>("Name_mechanical_ventilation",null); }
            set { setAttrVal<string>("Name_mechanical_ventilation", value); }
        }
		public string Name_route_drug {
            get { return getAttrVal<string>("Name_route_drug",null); }
            set { setAttrVal<string>("Name_route_drug", value); }
        }
		public string Name_unit_speed {
            get { return getAttrVal<string>("Name_unit_speed",null); }
            set { setAttrVal<string>("Name_unit_speed", value); }
        }
		public string Name_diet {
            get { return getAttrVal<string>("Name_diet",null); }
            set { setAttrVal<string>("Name_diet", value); }
        }
		public string Name_dosein_way {
            get { return getAttrVal<string>("Name_dosein_way",null); }
            set { setAttrVal<string>("Name_dosein_way", value); }
        }
		public string Name_suction_way {
            get { return getAttrVal<string>("Name_suction_way",null); }
            set { setAttrVal<string>("Name_suction_way", value); }
        }
		public string Name_skin_color {
            get { return getAttrVal<string>("Name_skin_color",null); }
            set { setAttrVal<string>("Name_skin_color", value); }
        }
		public string Name_skin {
            get { return getAttrVal<string>("Name_skin",null); }
            set { setAttrVal<string>("Name_skin", value); }
        }
		public string Name_pipe {
            get { return getAttrVal<string>("Name_pipe",null); }
            set { setAttrVal<string>("Name_pipe", value); }
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
            return "CI_MR_NU_BTHMACH_REC";
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
            return "Id_bthmachrec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_bthmachrec", "Id_bthmach", "Dt_rec", "Id_mechanical_ventilation", "Sd_mechanical_ventilation", "Fr", "Pip", "P", "Peep", "Map", "Rr_machine", "F", "It", "Ie", "Fio2", "Tem", "Heart_rate", "Respiratory_frequency", "Dbp", "Sbp", "Spo2", "Name_drug", "Dose_drugs", "Id_route_drug", "Sd_route_drug", "Spped_drug", "Id_unit_speed", "Sd_unit_speed", "Id_diet", "Sd_diet", "Id_dosein_way", "Sd_dosein_way", "Dose_drink", "Shit", "A_skit", "Urine", "A_urine", "Id_suction_way", "Sd_suction_way", "Nature", "Id_skin_color", "Sd_skin_color", "Id_skin", "Sd_skin", "Id_pipe", "Sd_pipe", "Bqbhjcl", "Id_sign", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_mechanical_ventilation", "Name_route_drug", "Name_unit_speed", "Name_diet", "Name_dosein_way", "Name_suction_way", "Name_skin_color", "Name_skin", "Name_pipe", "Name_sign"};
        }
        
    }
}
