using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordpres.d
{
    /// <summary>
    /// OrdPresDTO 的摘要说明。
    /// </summary>
    public class OrdPresDTO : BaseDTO {

        public OrdPresDTO() {
 
        }

        /// <summary>
        /// 处方
        /// </summary>
		public string Id_pres {
            get { return getAttrVal<string>("Id_pres",null); }
            set { setAttrVal<string>("Id_pres", value); }
        }

        /// <summary>
        /// 所属集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pati {
            get { return getAttrVal<string>("Id_pati",null); }
            set { setAttrVal<string>("Id_pati", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_pati {
            get { return getAttrVal<string>("Name_pati",null); }
            set { setAttrVal<string>("Name_pati", value); }
        }

        /// <summary>
        /// 费别
        /// </summary>
		public string Name_patica {
            get { return getAttrVal<string>("Name_patica",null); }
            set { setAttrVal<string>("Name_patica", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 临床诊断
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 临床诊断明细
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断编码拼接
        /// </summary>
		public string Str_id_di {
            get { return getAttrVal<string>("Str_id_di",null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }

        /// <summary>
        /// 诊断名称拼接
        /// </summary>
		public string Str_name_di {
            get { return getAttrVal<string>("Str_name_di",null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 处方类型
        /// </summary>
		public string Id_prestp {
            get { return getAttrVal<string>("Id_prestp",null); }
            set { setAttrVal<string>("Id_prestp", value); }
        }

        /// <summary>
        /// 处方类型编码
        /// </summary>
		public string Sd_prestp {
            get { return getAttrVal<string>("Sd_prestp",null); }
            set { setAttrVal<string>("Sd_prestp", value); }
        }
        /// <summary>
        /// 处方类型
        /// </summary>
		public string Id_prestpWord
        {
            get { return getAttrVal<string>("Id_prestpWord", null); }
            set { setAttrVal<string>("Id_prestpWord", value); }
        }

        /// <summary>
        /// 处方类型编码
        /// </summary>
		public string Sd_prestpWord
        {
            get { return getAttrVal<string>("Sd_prestpWord", null); }
            set { setAttrVal<string>("Sd_prestpWord", value); }
        }

        /// <summary>
        /// 处方类型名称
        /// </summary>
		public string Name_prestp {
            get { return getAttrVal<string>("Name_prestp",null); }
            set { setAttrVal<string>("Name_prestp", value); }
        }

        /// <summary>
        /// 处方编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 处方名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Name_dep_or {
            get { return getAttrVal<string>("Name_dep_or",null); }
            set { setAttrVal<string>("Name_dep_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 开立医生名称
        /// </summary>
		public string Name_emp_or {
            get { return getAttrVal<string>("Name_emp_or",null); }
            set { setAttrVal<string>("Name_emp_or", value); }
        }

        /// <summary>
        /// 开立日期
        /// </summary>
		public DateTime? Dt_entry {
            get { return getAttrVal<FDateTime>("Dt_entry",null); }
            set { setAttrVal<FDateTime>("Dt_entry", value); }
        }

        /// <summary>
        /// 婴儿标识
        /// </summary>
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }

        /// <summary>
        /// 婴儿序号
        /// </summary>
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }

        /// <summary>
        /// 婴儿
        /// </summary>
		public string Id_bb {
            get { return getAttrVal<string>("Id_bb",null); }
            set { setAttrVal<string>("Id_bb", value); }
        }

        /// <summary>
        /// 医疗用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 中药煎法
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法要求
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 收费标识
        /// </summary>
		public bool? Fg_charge {
            get { return getAttrVal<FBoolean>("Fg_charge",null); }
            set { setAttrVal<FBoolean>("Fg_charge", value); }
        }

        /// <summary>
        /// 发药标识
        /// </summary>
		public bool? Fg_dispense {
            get { return getAttrVal<FBoolean>("Fg_dispense",null); }
            set { setAttrVal<FBoolean>("Fg_dispense", value); }
        }

        /// <summary>
        /// 退药类型
        /// </summary>
		public string Id_backtp {
            get { return getAttrVal<string>("Id_backtp",null); }
            set { setAttrVal<string>("Id_backtp", value); }
        }

        /// <summary>
        /// 退药类型编码
        /// </summary>
		public string Sd_backtp {
            get { return getAttrVal<string>("Sd_backtp",null); }
            set { setAttrVal<string>("Sd_backtp", value); }
        }

        /// <summary>
        /// 处方退药标识
        /// </summary>
		public bool? Fg_back {
            get { return getAttrVal<FBoolean>("Fg_back",null); }
            set { setAttrVal<FBoolean>("Fg_back", value); }
        }

        /// <summary>
        /// 关联原处方
        /// </summary>
		public string Id_pres_rel {
            get { return getAttrVal<string>("Id_pres_rel",null); }
            set { setAttrVal<string>("Id_pres_rel", value); }
        }

        /// <summary>
        /// 医生签名
        /// </summary>
		public string Id_emp {
            get { return getAttrVal<string>("Id_emp",null); }
            set { setAttrVal<string>("Id_emp", value); }
        }

        /// <summary>
        /// 处方药品
        /// </summary>
		public FArrayList Presdrugs {
            get { return getAttrVal<FArrayList>("Presdrugs",null); }
            set { setAttrVal<FArrayList>("Presdrugs", value); }
        }

        /// <summary>
        /// 发药人
        /// </summary>
		public string Id_emp_disp {
            get { return getAttrVal<string>("Id_emp_disp",null); }
            set { setAttrVal<string>("Id_emp_disp", value); }
        }

        /// <summary>
        /// 发药人名称
        /// </summary>
		public string Name_emp_disp {
            get { return getAttrVal<string>("Name_emp_disp",null); }
            set { setAttrVal<string>("Name_emp_disp", value); }
        }

        /// <summary>
        /// 发药时间
        /// </summary>
		public DateTime? Dt_disp {
            get { return getAttrVal<FDateTime>("Dt_disp",null); }
            set { setAttrVal<FDateTime>("Dt_disp", value); }
        }

        /// <summary>
        /// 收费日期
        /// </summary>
		public string Dt_charge {
            get { return getAttrVal<string>("Dt_charge",null); }
            set { setAttrVal<string>("Dt_charge", value); }
        }

        /// <summary>
        /// 退药原因
        /// </summary>
		public string Reason_rtn {
            get { return getAttrVal<string>("Reason_rtn",null); }
            set { setAttrVal<string>("Reason_rtn", value); }
        }

        /// <summary>
        /// 批次号
        /// </summary>
		public string Batchno {
            get { return getAttrVal<string>("Batchno",null); }
            set { setAttrVal<string>("Batchno", value); }
        }

        /// <summary>
        /// 条形码（就诊号）
        /// </summary>
		public string Barcode {
            get { return getAttrVal<string>("Barcode",null); }
            set { setAttrVal<string>("Barcode", value); }
        }

        /// <summary>
        /// 医疗机构登记号
        /// </summary>
		public string Regnum_org {
            get { return getAttrVal<string>("Regnum_org",null); }
            set { setAttrVal<string>("Regnum_org", value); }
        }

        /// <summary>
        /// 毒麻处方号
        /// </summary>
		public string Code_poishempres {
            get { return getAttrVal<string>("Code_poishempres",null); }
            set { setAttrVal<string>("Code_poishempres", value); }
        }

        /// <summary>
        /// 性别
        /// </summary>
		public string Gender {
            get { return getAttrVal<string>("Gender",null); }
            set { setAttrVal<string>("Gender", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public string Birth {
            get { return getAttrVal<string>("Birth",null); }
            set { setAttrVal<string>("Birth", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public double? Age {
            get { return getAttrVal<FDouble>("Age",null); }
            set { setAttrVal<FDouble>("Age", value); }
        }

        /// <summary>
        /// 身份证号
        /// </summary>
		public string Idno {
            get { return getAttrVal<string>("Idno",null); }
            set { setAttrVal<string>("Idno", value); }
        }

        /// <summary>
        /// 工作单位
        /// </summary>
		public string Workunit {
            get { return getAttrVal<string>("Workunit",null); }
            set { setAttrVal<string>("Workunit", value); }
        }

        /// <summary>
        /// 代办人
        /// </summary>
		public string Psn_agent {
            get { return getAttrVal<string>("Psn_agent",null); }
            set { setAttrVal<string>("Psn_agent", value); }
        }

        /// <summary>
        /// 代办人身份证号
        /// </summary>
		public string Idno_agent {
            get { return getAttrVal<string>("Idno_agent",null); }
            set { setAttrVal<string>("Idno_agent", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 就诊次数
        /// </summary>
		public int? Num_pv {
            get { return getAttrVal<int?>("Num_pv",null); }
            set { setAttrVal<int?>("Num_pv", value); }
        }

        /// <summary>
        /// 过敏史
        /// </summary>
		public string Des_alcla {
            get { return getAttrVal<string>("Des_alcla",null); }
            set { setAttrVal<string>("Des_alcla", value); }
        }

        /// <summary>
        /// 总金额
        /// </summary>
		public double? Amt_total {
            get { return getAttrVal<FDouble>("Amt_total",null); }
            set { setAttrVal<FDouble>("Amt_total", value); }
        }

        /// <summary>
        /// 打印单据类型id
        /// </summary>
		public string Id_ciprnsheettp {
            get { return getAttrVal<string>("Id_ciprnsheettp",null); }
            set { setAttrVal<string>("Id_ciprnsheettp", value); }
        }

        /// <summary>
        /// 打印单据类型编码
        /// </summary>
		public string Sd_ciprnsheettp {
            get { return getAttrVal<string>("Sd_ciprnsheettp",null); }
            set { setAttrVal<string>("Sd_ciprnsheettp", value); }
        }

        /// <summary>
        /// 打印单据类型名称
        /// </summary>
		public string Name_ciprnsheettp {
            get { return getAttrVal<string>("Name_ciprnsheettp",null); }
            set { setAttrVal<string>("Name_ciprnsheettp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pres", "Id_grp", "Id_org", "Id_pati", "Name_pati", "Name_patica", "Id_entp", "Code_entp", "Id_en", "Id_di", "Id_diitm", "Str_id_di", "Str_name_di", "Id_srvtp", "Sd_srvtp", "Id_prestp", "Sd_prestp", "Name_prestp", "Code", "Name", "Id_dep_or", "Name_dep_or", "Id_emp_or", "Name_emp_or", "Dt_entry", "Fg_bb", "No_bb", "Id_bb", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Fg_charge", "Fg_dispense", "Id_backtp", "Sd_backtp", "Fg_back", "Id_pres_rel", "Id_emp", "Presdrugs", "Id_emp_disp", "Name_emp_disp", "Dt_disp", "Dt_charge", "Reason_rtn", "Batchno", "Barcode", "Regnum_org", "Code_poishempres", "Gender", "Birth", "Age", "Idno", "Workunit", "Psn_agent", "Idno_agent", "Id_dep_mp", "Name_dep_mp", "Num_pv", "Des_alcla", "Amt_total", "Id_ciprnsheettp", "Sd_ciprnsheettp", "Name_ciprnsheettp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordpres.d.OrdPresDTO";
        }
    }
}
