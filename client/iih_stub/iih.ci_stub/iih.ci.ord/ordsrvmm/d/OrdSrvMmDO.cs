
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using System.Collections.Generic;

namespace iih.ci.ord.ordsrvmm.d
{
    /// <summary>
    /// OrdSrvMmDO 的摘要说明。
    /// </summary>
    public class OrdSrvMmDO : BaseDO {

		public const string TABLE_NAME = "ci_or_srv_mm";
		public const string TABLE_ALIAS_NAME = "a0";

        public OrdSrvMmDO() {
        }
		public string Id_orsrvmm {
            get { return getAttrVal<string>("Id_orsrvmm",null); }
            set { setAttrVal<string>("Id_orsrvmm", value); }
        }
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }
		public string Id_pgku_cur {
            get { return getAttrVal<string>("Id_pgku_cur",null); }
            set { setAttrVal<string>("Id_pgku_cur", value); }
        }
		public FDouble Price_pgku_cur {
            get { return getAttrVal<FDouble>("Price_pgku_cur",null); }
            set { setAttrVal<FDouble>("Price_pgku_cur", value); }
        }
		public FDouble Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }
		public string Id_pgku_base {
            get { return getAttrVal<string>("Id_pgku_base",null); }
            set { setAttrVal<string>("Id_pgku_base", value); }
        }
		public int? Quan_num_base {
            get { return getAttrVal<int?>("Quan_num_base",null); }
            set { setAttrVal<int?>("Quan_num_base", value); }
        }
		public int? Quan_den_base {
            get { return getAttrVal<int?>("Quan_den_base",null); }
            set { setAttrVal<int?>("Quan_den_base", value); }
        }
		public FDouble Quan_bed_medu {
            get { return getAttrVal<FDouble>("Quan_bed_medu",null); }
            set { setAttrVal<FDouble>("Quan_bed_medu", value); }
        }
		public FDouble Factor {
            get { return getAttrVal<FDouble>("Factor",null); }
            set { setAttrVal<FDouble>("Factor", value); }
        }
		public FDouble Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }
		public string Id_dosage {
            get { return getAttrVal<string>("Id_dosage",null); }
            set { setAttrVal<string>("Id_dosage", value); }
        }
		public string Sd_dosage {
            get { return getAttrVal<string>("Sd_dosage",null); }
            set { setAttrVal<string>("Sd_dosage", value); }
        }
		public string Id_pharm {
            get { return getAttrVal<string>("Id_pharm",null); }
            set { setAttrVal<string>("Id_pharm", value); }
        }
		public string Sd_pharm {
            get { return getAttrVal<string>("Sd_pharm",null); }
            set { setAttrVal<string>("Sd_pharm", value); }
        }
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }
		public string Sd_val {
            get { return getAttrVal<string>("Sd_val",null); }
            set { setAttrVal<string>("Sd_val", value); }
        }
		public string Id_pois {
            get { return getAttrVal<string>("Id_pois",null); }
            set { setAttrVal<string>("Id_pois", value); }
        }
		public string Sd_pois {
            get { return getAttrVal<string>("Sd_pois",null); }
            set { setAttrVal<string>("Sd_pois", value); }
        }
		public string Id_anti {
            get { return getAttrVal<string>("Id_anti",null); }
            set { setAttrVal<string>("Id_anti", value); }
        }
		public string Sd_anti {
            get { return getAttrVal<string>("Sd_anti",null); }
            set { setAttrVal<string>("Sd_anti", value); }
        }
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }
		public string Id_antipsy {
            get { return getAttrVal<string>("Id_antipsy",null); }
            set { setAttrVal<string>("Id_antipsy", value); }
        }
		public string Sd_antipsy {
            get { return getAttrVal<string>("Sd_antipsy",null); }
            set { setAttrVal<string>("Sd_antipsy", value); }
        }
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }
		public DateTime? Modifiedtime {
            get { return getAttrVal<FDateTime>("Modifiedtime",null); }
            set { setAttrVal<FDateTime>("Modifiedtime", value); }
        }
		public string Modifiedby {
            get { return getAttrVal<string>("Modifiedby",null); }
            set { setAttrVal<string>("Modifiedby", value); }
        }
		public string Createdby {
            get { return getAttrVal<string>("Createdby",null); }
            set { setAttrVal<string>("Createdby", value); }
        }
		public DateTime? Createdtime {
            get { return getAttrVal<FDateTime>("Createdtime",null); }
            set { setAttrVal<FDateTime>("Createdtime", value); }
        }
		public FDouble Quan_bed_transit {
            get { return getAttrVal<FDouble>("Quan_bed_transit",null); }
            set { setAttrVal<FDouble>("Quan_bed_transit", value); }
        }
		public int? Days_available {
            get { return getAttrVal<int?>("Days_available",null); }
            set { setAttrVal<int?>("Days_available", value); }
        }
		public string Id_mupkgutp {
            get { return getAttrVal<string>("Id_mupkgutp",null); }
            set { setAttrVal<string>("Id_mupkgutp", value); }
        }
		public string Sd_mupkgutp {
            get { return getAttrVal<string>("Sd_mupkgutp",null); }
            set { setAttrVal<string>("Sd_mupkgutp", value); }
        }
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }
		public string Indica {
            get { return getAttrVal<string>("Indica",null); }
            set { setAttrVal<string>("Indica", value); }
        }
		public string Constr {
            get { return getAttrVal<string>("Constr",null); }
            set { setAttrVal<string>("Constr", value); }
        }
		public string React {
            get { return getAttrVal<string>("React",null); }
            set { setAttrVal<string>("React", value); }
        }
		public string Name_pgku_cur {
            get { return getAttrVal<string>("Name_pgku_cur",null); }
            set { setAttrVal<string>("Name_pgku_cur", value); }
        }
		public string Name_pgku_base {
            get { return getAttrVal<string>("Name_pgku_base",null); }
            set { setAttrVal<string>("Name_pgku_base", value); }
        }
		public string Ds_code {
            get { return getAttrVal<string>("Ds_code",null); }
            set { setAttrVal<string>("Ds_code", value); }
        }
		public string Ds_name {
            get { return getAttrVal<string>("Ds_name",null); }
            set { setAttrVal<string>("Ds_name", value); }
        }
		public string Pa_code {
            get { return getAttrVal<string>("Pa_code",null); }
            set { setAttrVal<string>("Pa_code", value); }
        }
		public string Pa_name {
            get { return getAttrVal<string>("Pa_name",null); }
            set { setAttrVal<string>("Pa_name", value); }
        }
		public string Val_code {
            get { return getAttrVal<string>("Val_code",null); }
            set { setAttrVal<string>("Val_code", value); }
        }
		public string Val_name {
            get { return getAttrVal<string>("Val_name",null); }
            set { setAttrVal<string>("Val_name", value); }
        }
		public string Pois_code {
            get { return getAttrVal<string>("Pois_code",null); }
            set { setAttrVal<string>("Pois_code", value); }
        }
		public string Pois_name {
            get { return getAttrVal<string>("Pois_name",null); }
            set { setAttrVal<string>("Pois_name", value); }
        }
		public string Anti_code {
            get { return getAttrVal<string>("Anti_code",null); }
            set { setAttrVal<string>("Anti_code", value); }
        }
		public string Anti_name {
            get { return getAttrVal<string>("Anti_name",null); }
            set { setAttrVal<string>("Anti_name", value); }
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
            return "ci_or_srv_mm";
        }
        
        /// <summary>
        /// 返回表别名
        /// </summary>
        /// <returns></returns>
        public override string getAliasTableName()
        {
            return "a0";
        }
        
        /// <summary>
        /// 返回主键字段名
        /// </summary>
        /// <returns></returns>
        public override string getPKFieldName()
        {
            return "Id_orsrvmm";
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ordsrvmm.d.OrdSrvMmDO";
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{"Ds","Sv",  "Id_orsrvmm", "Id_orsrv", "Id_mm", "Code_mm", "Name_mm", "Id_pgku_cur", "Price_pgku_cur", "Quan_cur", "Id_pgku_base", "Quan_num_base", "Quan_den_base", "Quan_bed_medu", "Factor", "Factor_mb", "Id_dosage", "Sd_dosage", "Id_pharm", "Sd_pharm", "Id_val", "Sd_val", "Id_pois", "Sd_pois", "Id_anti", "Sd_anti", "Id_mmtp", "Sd_mmtp", "Id_antipsy", "Sd_antipsy", "Fg_otc", "Modifiedtime", "Modifiedby", "Createdby", "Createdtime", "Quan_bed_transit", "Days_available", "Id_mupkgutp", "Sd_mupkgutp", "Id_srv", "Spec", "Indica", "Constr", "React", "Name_pgku_cur", "Name_pgku_base", "Ds_code", "Ds_name", "Pa_code", "Pa_name", "Val_code", "Val_name", "Pois_code", "Pois_name", "Anti_code", "Anti_name"};
        }
        
    }
}
