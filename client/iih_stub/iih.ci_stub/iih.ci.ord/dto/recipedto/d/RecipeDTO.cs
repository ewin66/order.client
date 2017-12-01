using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.recipedto.d
{
    /// <summary>
    /// RecipeDTO 的摘要说明。
    /// </summary>
    public class RecipeDTO : BaseDTO {

        public RecipeDTO() {
 
        }

        /// <summary>
        /// 药品处方主键
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 诊断序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 诊断编码
        /// </summary>
		public string Didef_code {
            get { return getAttrVal<string>("Didef_code",null); }
            set { setAttrVal<string>("Didef_code", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Didef_name {
            get { return getAttrVal<string>("Didef_name",null); }
            set { setAttrVal<string>("Didef_name", value); }
        }

        /// <summary>
        /// 病历信息
        /// </summary>
		public string Mr_content {
            get { return getAttrVal<string>("Mr_content",null); }
            set { setAttrVal<string>("Mr_content", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// his科室编码
        /// </summary>
		public string Code_dep {
            get { return getAttrVal<string>("Code_dep",null); }
            set { setAttrVal<string>("Code_dep", value); }
        }

        /// <summary>
        /// 医保计划下科别编码
        /// </summary>
		public string Depcode_hp {
            get { return getAttrVal<string>("Depcode_hp",null); }
            set { setAttrVal<string>("Depcode_hp", value); }
        }

        /// <summary>
        /// 医保计划下科别名称
        /// </summary>
		public string Depname_hp {
            get { return getAttrVal<string>("Depname_hp",null); }
            set { setAttrVal<string>("Depname_hp", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Id_dep_name {
            get { return getAttrVal<string>("Id_dep_name",null); }
            set { setAttrVal<string>("Id_dep_name", value); }
        }

        /// <summary>
        /// 开立医生名称
        /// </summary>
		public string Id_emp_name {
            get { return getAttrVal<string>("Id_emp_name",null); }
            set { setAttrVal<string>("Id_emp_name", value); }
        }

        /// <summary>
        /// 处方类型
        /// </summary>
		public string Id_prestp {
            get { return getAttrVal<string>("Id_prestp",null); }
            set { setAttrVal<string>("Id_prestp", value); }
        }

        /// <summary>
        /// 处方编码
        /// </summary>
		public string Sd_prestp {
            get { return getAttrVal<string>("Sd_prestp",null); }
            set { setAttrVal<string>("Sd_prestp", value); }
        }

        /// <summary>
        /// 代开药标志
        /// </summary>
		public bool? Helpmedicineflag {
            get { return getAttrVal<FBoolean>("Helpmedicineflag",null); }
            set { setAttrVal<FBoolean>("Helpmedicineflag", value); }
        }

        /// <summary>
        /// 处方时间
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 挂号交易流水号
        /// </summary>
		public string Registertradeno {
            get { return getAttrVal<string>("Registertradeno",null); }
            set { setAttrVal<string>("Registertradeno", value); }
        }

        /// <summary>
        /// 单据类型
        /// </summary>
		public string Billstype {
            get { return getAttrVal<string>("Billstype",null); }
            set { setAttrVal<string>("Billstype", value); }
        }

        /// <summary>
        /// 本院科别名称
        /// </summary>
		public string Hospital_dept_name {
            get { return getAttrVal<string>("Hospital_dept_name",null); }
            set { setAttrVal<string>("Hospital_dept_name", value); }
        }

        /// <summary>
        /// 患者主键
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 处方类型名称
        /// </summary>
		public string Prestp_name {
            get { return getAttrVal<string>("Prestp_name",null); }
            set { setAttrVal<string>("Prestp_name", value); }
        }

        /// <summary>
        /// 处方类型（1医保内，2 医保外）
        /// </summary>
		public bool? Recipetype {
            get { return getAttrVal<FBoolean>("Recipetype",null); }
            set { setAttrVal<FBoolean>("Recipetype", value); }
        }

        /// <summary>
        /// （费用使用）备注
        /// </summary>
		public string Remark {
            get { return getAttrVal<string>("Remark",null); }
            set { setAttrVal<string>("Remark", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pres", "Sortno", "Didef_code", "Didef_name", "Mr_content", "Id_dep_or", "Code_dep", "Depcode_hp", "Depname_hp", "Id_emp_or", "Id_dep_name", "Id_emp_name", "Id_prestp", "Sd_prestp", "Helpmedicineflag", "Dt_entry", "Des", "Registertradeno", "Billstype", "Hospital_dept_name", "Id_pat", "Id_en", "Prestp_name", "Recipetype", "Remark"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.recipedto.d.RecipeDTO";
        }
    }
}
