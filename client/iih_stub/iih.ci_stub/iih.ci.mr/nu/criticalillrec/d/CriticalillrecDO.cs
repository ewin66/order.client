
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.mr.nu.criticalillrec.d
{
    /// <summary>
    /// CriticalillRecDO 的摘要说明。
    /// </summary>
    public class CriticalillRecDO : BaseDO {

		public const string TABLE_NAME = "ci_mr_nu_ctri_rec";
		public const string TABLE_ALIAS_NAME = "a1";

        public CriticalillRecDO() {
        }
		public string Id_ctri_rec {
            get { return getAttrVal<string>("Id_ctri_rec",null); }
            set { setAttrVal<string>("Id_ctri_rec", value); }
        }
		public string Id_ctri {
            get { return getAttrVal<string>("Id_ctri",null); }
            set { setAttrVal<string>("Id_ctri", value); }
        }
		public DateTime? D_cri {
            get { return getAttrVal<FDate>("D_cri",null); }
            set { setAttrVal<FDate>("D_cri", value); }
        }
		public DateTime? T_cri {
            get { return getAttrVal<FTime>("T_cri",null); }
            set { setAttrVal<FTime>("T_cri", value); }
        }
		public FDouble Tem {
            get { return getAttrVal<FDouble>("Tem",null); }
            set { setAttrVal<FDouble>("Tem", value); }
        }
		public FDouble Pulse {
            get { return getAttrVal<FDouble>("Pulse",null); }
            set { setAttrVal<FDouble>("Pulse", value); }
        }
		public FDouble Breath {
            get { return getAttrVal<FDouble>("Breath",null); }
            set { setAttrVal<FDouble>("Breath", value); }
        }
		public int? Dia_pressure {
            get { return getAttrVal<int?>("Dia_pressure",null); }
            set { setAttrVal<int?>("Dia_pressure", value); }
        }
		public int? Sys_pressure {
            get { return getAttrVal<int?>("Sys_pressure",null); }
            set { setAttrVal<int?>("Sys_pressure", value); }
        }
		public FDouble Pulse_oxygen_saturation {
            get { return getAttrVal<FDouble>("Pulse_oxygen_saturation",null); }
            set { setAttrVal<FDouble>("Pulse_oxygen_saturation", value); }
        }
		public string Id_oxygen_inhalation {
            get { return getAttrVal<string>("Id_oxygen_inhalation",null); }
            set { setAttrVal<string>("Id_oxygen_inhalation", value); }
        }
		public string Sd_oxygen_inhalation {
            get { return getAttrVal<string>("Sd_oxygen_inhalation",null); }
            set { setAttrVal<string>("Sd_oxygen_inhalation", value); }
        }
		public FDouble Fio2 {
            get { return getAttrVal<FDouble>("Fio2",null); }
            set { setAttrVal<FDouble>("Fio2", value); }
        }
		public string Id_pipe_type {
            get { return getAttrVal<string>("Id_pipe_type",null); }
            set { setAttrVal<string>("Id_pipe_type", value); }
        }
		public string Name_pipe_type {
            get { return getAttrVal<string>("Name_pipe_type",null); }
            set { setAttrVal<string>("Name_pipe_type", value); }
        }
		public string Sd_pipe_type {
            get { return getAttrVal<string>("Sd_pipe_type",null); }
            set { setAttrVal<string>("Sd_pipe_type", value); }
        }
		public DateTime? Dt_extubation {
            get { return getAttrVal<FDateTime>("Dt_extubation",null); }
            set { setAttrVal<FDateTime>("Dt_extubation", value); }
        }
		public string Amount {
            get { return getAttrVal<string>("Amount",null); }
            set { setAttrVal<string>("Amount", value); }
        }
		public int? Dose_in {
            get { return getAttrVal<int?>("Dose_in",null); }
            set { setAttrVal<int?>("Dose_in", value); }
        }
		public int? Speed {
            get { return getAttrVal<int?>("Speed",null); }
            set { setAttrVal<int?>("Speed", value); }
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
		public int? Dose_out {
            get { return getAttrVal<int?>("Dose_out",null); }
            set { setAttrVal<int?>("Dose_out", value); }
        }
		public string Id_color_cha {
            get { return getAttrVal<string>("Id_color_cha",null); }
            set { setAttrVal<string>("Id_color_cha", value); }
        }
		public string Sd_color_cha {
            get { return getAttrVal<string>("Sd_color_cha",null); }
            set { setAttrVal<string>("Sd_color_cha", value); }
        }
		public int? Skin_condition {
            get { return getAttrVal<int?>("Skin_condition",null); }
            set { setAttrVal<int?>("Skin_condition", value); }
        }
		public string Ys {
            get { return getAttrVal<string>("Ys",null); }
            set { setAttrVal<string>("Ys", value); }
        }
		public string Xz {
            get { return getAttrVal<string>("Xz",null); }
            set { setAttrVal<string>("Xz", value); }
        }
		public string Jchl {
            get { return getAttrVal<string>("Jchl",null); }
            set { setAttrVal<string>("Jchl", value); }
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
		public string Name_oxygen_inhalation {
            get { return getAttrVal<string>("Name_oxygen_inhalation",null); }
            set { setAttrVal<string>("Name_oxygen_inhalation", value); }
        }
		public string Name_amount_type {
            get { return getAttrVal<string>("Name_amount_type",null); }
            set { setAttrVal<string>("Name_amount_type", value); }
        }
		public string Name_volume {
            get { return getAttrVal<string>("Name_volume",null); }
            set { setAttrVal<string>("Name_volume", value); }
        }
		public string Name_color_cha {
            get { return getAttrVal<string>("Name_color_cha",null); }
            set { setAttrVal<string>("Name_color_cha", value); }
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
            return "ci_mr_nu_ctri_rec";
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
            return "Id_ctri_rec";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.criticalillrec.d.CriticalillRecDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_ctri_rec", "Id_ctri", "D_cri", "T_cri", "Tem", "Pulse", "Breath", "Dia_pressure", "Sys_pressure", "Pulse_oxygen_saturation", "Id_oxygen_inhalation", "Sd_oxygen_inhalation", "Fio2", "Id_pipe_type", "Name_pipe_type", "Sd_pipe_type", "Dt_extubation", "Amount", "Dose_in", "Speed", "Id_amount_type", "Sd_amount_type", "Id_volume", "Sd_volume", "Dose_out", "Id_color_cha", "Sd_color_cha", "Skin_condition", "Ys", "Xz", "Jchl", "Obsandmea", "Id_sign", "Createdby", "Createdtime", "Modifiedby", "Modifiedtime", "Name_oxygen_inhalation", "Name_amount_type", "Name_volume", "Name_color_cha", "Name_sign"};
        }
        
    }
}
