using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ems.d
{
    /// <summary>
    /// CiEmsDTO 的摘要说明。
    /// </summary>
    public class CiEmsDTO : BaseDTO {

        public CiEmsDTO() {
 
        }

        /// <summary>
        /// 医嘱主键标识
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
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
        /// 医嘱类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 医嘱类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 对应服务
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务包
        /// </summary>
		public string Id_srv_pkg {
            get { return getAttrVal<string>("Id_srv_pkg",null); }
            set { setAttrVal<string>("Id_srv_pkg", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 医疗单类型
        /// </summary>
		public int? Emstype {
            get { return getAttrVal<int?>("Emstype",null); }
            set { setAttrVal<int?>("Emstype", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 医嘱频次名称
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求描述
        /// </summary>
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法名称
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 煎法要求
        /// </summary>
		public string Id_boildes {
            get { return getAttrVal<string>("Id_boildes",null); }
            set { setAttrVal<string>("Id_boildes", value); }
        }

        /// <summary>
        /// 煎法要求名称
        /// </summary>
		public string Name_boildes {
            get { return getAttrVal<string>("Name_boildes",null); }
            set { setAttrVal<string>("Name_boildes", value); }
        }

        /// <summary>
        /// 代煎标识
        /// </summary>
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }

        /// <summary>
        /// 医嘱天数
        /// </summary>
		public int? Days_or {
            get { return getAttrVal<int?>("Days_or",null); }
            set { setAttrVal<int?>("Days_or", value); }
        }

        /// <summary>
        /// 医嘱付数
        /// </summary>
		public int? Orders {
            get { return getAttrVal<int?>("Orders",null); }
            set { setAttrVal<int?>("Orders", value); }
        }

        /// <summary>
        /// 代煎付数
        /// </summary>
		public int? Orders_boil {
            get { return getAttrVal<int?>("Orders_boil",null); }
            set { setAttrVal<int?>("Orders_boil", value); }
        }

        /// <summary>
        /// 编码
        /// </summary>
		public string Code {
            get { return getAttrVal<string>("Code",null); }
            set { setAttrVal<string>("Code", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content {
            get { return getAttrVal<string>("Content",null); }
            set { setAttrVal<string>("Content", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Note {
            get { return getAttrVal<string>("Note",null); }
            set { setAttrVal<string>("Note", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_phy {
            get { return getAttrVal<string>("Id_emp_phy",null); }
            set { setAttrVal<string>("Id_emp_phy", value); }
        }

        /// <summary>
        /// 开立医生姓名
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 开立科室名称
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 医疗组
        /// </summary>
		public string Id_wg_or {
            get { return getAttrVal<string>("Id_wg_or",null); }
            set { setAttrVal<string>("Id_wg_or", value); }
        }

        /// <summary>
        /// 开始日期
        /// </summary>
		public DateTime? Dt_begin {
            get { return getAttrVal<FDateTime>("Dt_begin",null); }
            set { setAttrVal<FDateTime>("Dt_begin", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 医嘱过期时间
        /// </summary>
		public DateTime? Dt_invalid {
            get { return getAttrVal<FDateTime>("Dt_invalid",null); }
            set { setAttrVal<FDateTime>("Dt_invalid", value); }
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
        /// 备用医嘱标识
        /// </summary>
		public bool? Fg_pmor {
            get { return getAttrVal<FBoolean>("Fg_pmor",null); }
            set { setAttrVal<FBoolean>("Fg_pmor", value); }
        }

        /// <summary>
        /// 备用医嘱使用条件描述
        /// </summary>
		public string Des_pmor {
            get { return getAttrVal<string>("Des_pmor",null); }
            set { setAttrVal<string>("Des_pmor", value); }
        }

        /// <summary>
        /// 备用医嘱启用标识
        /// </summary>
		public bool? Fg_active_pm {
            get { return getAttrVal<FBoolean>("Fg_active_pm",null); }
            set { setAttrVal<FBoolean>("Fg_active_pm", value); }
        }

        /// <summary>
        /// 关联医嘱类型编码
        /// </summary>
		public string Id_reltp {
            get { return getAttrVal<string>("Id_reltp",null); }
            set { setAttrVal<string>("Id_reltp", value); }
        }

        /// <summary>
        /// 关联医嘱类型
        /// </summary>
		public string Sd_reltp {
            get { return getAttrVal<string>("Sd_reltp",null); }
            set { setAttrVal<string>("Sd_reltp", value); }
        }

        /// <summary>
        /// 关联医嘱
        /// </summary>
		public string Id_or_rel {
            get { return getAttrVal<string>("Id_or_rel",null); }
            set { setAttrVal<string>("Id_or_rel", value); }
        }

        /// <summary>
        /// 临床路径控制标识
        /// </summary>
		public bool? Fg_ctlcp {
            get { return getAttrVal<FBoolean>("Fg_ctlcp",null); }
            set { setAttrVal<FBoolean>("Fg_ctlcp", value); }
        }

        /// <summary>
        /// 医疗记录联动标识
        /// </summary>
		public bool? Fg_mr {
            get { return getAttrVal<FBoolean>("Fg_mr",null); }
            set { setAttrVal<FBoolean>("Fg_mr", value); }
        }

        /// <summary>
        /// 需皮试标识
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 不皮试原因（废弃不用了）
        /// </summary>
		public string Id_skintest_skip_reaso {
            get { return getAttrVal<string>("Id_skintest_skip_reaso",null); }
            set { setAttrVal<string>("Id_skintest_skip_reaso", value); }
        }

        /// <summary>
        /// 不皮试原因编码（废弃不用了）
        /// </summary>
		public string Sd_skintest_skip_reaso {
            get { return getAttrVal<string>("Sd_skintest_skip_reaso",null); }
            set { setAttrVal<string>("Sd_skintest_skip_reaso", value); }
        }

        /// <summary>
        /// 在院执行标识
        /// </summary>
		public bool? Fg_mp_in {
            get { return getAttrVal<FBoolean>("Fg_mp_in",null); }
            set { setAttrVal<FBoolean>("Fg_mp_in", value); }
        }

        /// <summary>
        /// 在院执行次数
        /// </summary>
		public int? Times_mp_in {
            get { return getAttrVal<int?>("Times_mp_in",null); }
            set { setAttrVal<int?>("Times_mp_in", value); }
        }

        /// <summary>
        /// 床边执行标识
        /// </summary>
		public bool? Fg_mp_bed {
            get { return getAttrVal<FBoolean>("Fg_mp_bed",null); }
            set { setAttrVal<FBoolean>("Fg_mp_bed", value); }
        }

        /// <summary>
        /// 首日执行次数
        /// </summary>
		public int? Times_firday_mp {
            get { return getAttrVal<int?>("Times_firday_mp",null); }
            set { setAttrVal<int?>("Times_firday_mp", value); }
        }

        /// <summary>
        /// 医生医嘱标识
        /// </summary>
		public bool? Fg_or_doc {
            get { return getAttrVal<FBoolean>("Fg_or_doc",null); }
            set { setAttrVal<FBoolean>("Fg_or_doc", value); }
        }

        /// <summary>
        /// 医嘱状态
        /// </summary>
		public string Id_su_or {
            get { return getAttrVal<string>("Id_su_or",null); }
            set { setAttrVal<string>("Id_su_or", value); }
        }

        /// <summary>
        /// 医嘱状态编码
        /// </summary>
		public string Sd_su_or {
            get { return getAttrVal<string>("Sd_su_or",null); }
            set { setAttrVal<string>("Sd_su_or", value); }
        }

        /// <summary>
        /// 医疗单项目集合
        /// </summary>
		public FArrayList Emssrvs {
            get { return getAttrVal<FArrayList>("Emssrvs",null); }
            set { setAttrVal<FArrayList>("Emssrvs", value); }
        }

        /// <summary>
        /// 医嘱计划频次执行时刻集合
        /// </summary>
		public FArrayList Ciorfreqtimes {
            get { return getAttrVal<FArrayList>("Ciorfreqtimes",null); }
            set { setAttrVal<FArrayList>("Ciorfreqtimes", value); }
        }

        /// <summary>
        /// 套对应的套内项目集合
        /// </summary>
		public FMap Srvsetitms {
            get { return getAttrVal<FMap>("Srvsetitms",null); }
            set { setAttrVal<FMap>("Srvsetitms", value); }
        }

        /// <summary>
        /// 医嘱对应的申请单
        /// </summary>
		public FMap Orapplysheet {
            get { return getAttrVal<FMap>("Orapplysheet",null); }
            set { setAttrVal<FMap>("Orapplysheet", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
		public string Id_dept_en {
            get { return getAttrVal<string>("Id_dept_en",null); }
            set { setAttrVal<string>("Id_dept_en", value); }
        }

        /// <summary>
        /// 护理单元
        /// </summary>
		public string Id_dept_ns {
            get { return getAttrVal<string>("Id_dept_ns",null); }
            set { setAttrVal<string>("Id_dept_ns", value); }
        }

        /// <summary>
        /// 是否是套
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 嘱托
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 出院带药标识
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 医疗单URL
        /// </summary>
		public string Funcclassstr {
            get { return getAttrVal<string>("Funcclassstr",null); }
            set { setAttrVal<string>("Funcclassstr", value); }
        }

        /// <summary>
        /// 医疗单
        /// </summary>
		public string Id_srvof {
            get { return getAttrVal<string>("Id_srvof",null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string Applyno {
            get { return getAttrVal<string>("Applyno",null); }
            set { setAttrVal<string>("Applyno", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 总次数
        /// </summary>
		public int? Times_cur {
            get { return getAttrVal<int?>("Times_cur",null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }

        /// <summary>
        /// 医嘱结果
        /// </summary>
		public string Id_orrsttp {
            get { return getAttrVal<string>("Id_orrsttp",null); }
            set { setAttrVal<string>("Id_orrsttp", value); }
        }

        /// <summary>
        /// 医嘱结果编码
        /// </summary>
		public string Sd_orrsttp {
            get { return getAttrVal<string>("Sd_orrsttp",null); }
            set { setAttrVal<string>("Sd_orrsttp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_unit_med {
            get { return getAttrVal<string>("Id_unit_med",null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 数量_医学单位
        /// </summary>
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 医嘱基本分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 医学单位名称
        /// </summary>
		public string Name_unit_med {
            get { return getAttrVal<string>("Name_unit_med",null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 服务分类内码
        /// </summary>
		public string Innercode_srvca {
            get { return getAttrVal<string>("Innercode_srvca",null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
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
        /// 医疗单应用场景
        /// </summary>
		public int? Emsappmode {
            get { return getAttrVal<int?>("Emsappmode",null); }
            set { setAttrVal<int?>("Emsappmode", value); }
        }

        /// <summary>
        /// 医疗单显示名称
        /// </summary>
		public string Name_ems {
            get { return getAttrVal<string>("Name_ems",null); }
            set { setAttrVal<string>("Name_ems", value); }
        }

        /// <summary>
        /// 医嘱执行闭环类型
        /// </summary>
		public string Id_orpltp {
            get { return getAttrVal<string>("Id_orpltp",null); }
            set { setAttrVal<string>("Id_orpltp", value); }
        }

        /// <summary>
        /// 执行科室名称
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 附加信息Map键值串
        /// </summary>
		public string Mapkeys {
            get { return getAttrVal<string>("Mapkeys",null); }
            set { setAttrVal<string>("Mapkeys", value); }
        }

        /// <summary>
        /// 相关附加信息MAP
        /// </summary>
		public FMap2 Mapinfo {
            get { return getAttrVal<FMap2>("Mapinfo",null); }
            set { setAttrVal<FMap2>("Mapinfo", value); }
        }

        /// <summary>
        /// 费用同步标识
        /// </summary>
		public bool? Fg_syncfee {
            get { return getAttrVal<FBoolean>("Fg_syncfee",null); }
            set { setAttrVal<FBoolean>("Fg_syncfee", value); }
        }

        /// <summary>
        /// 频次下次数
        /// </summary>
		public int? Freqct {
            get { return getAttrVal<int?>("Freqct",null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        /// 频次周期数
        /// </summary>
		public int? Frequnitct {
            get { return getAttrVal<int?>("Frequnitct",null); }
            set { setAttrVal<int?>("Frequnitct", value); }
        }

        /// <summary>
        /// 频次周期类型编码
        /// </summary>
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

        /// <summary>
        /// 医保适应症判断标识枚举
        /// </summary>
		public int? Eu_hpindicjudge {
            get { return getAttrVal<int?>("Eu_hpindicjudge",null); }
            set { setAttrVal<int?>("Eu_hpindicjudge", value); }
        }

        /// <summary>
        /// 非径内医嘱判断标识枚
        /// </summary>
		public int? Eu_uncporjudge {
            get { return getAttrVal<int?>("Eu_uncporjudge",0); }
            set { setAttrVal<int?>("Eu_uncporjudge", value); }
        }

        /// <summary>
        /// 径外医嘱使用说明
        /// </summary>
		public string Reason_uncporuse {
            get { return getAttrVal<string>("Reason_uncporuse",null); }
            set { setAttrVal<string>("Reason_uncporuse", value); }
        }

        /// <summary>
        /// 患者入径标识
        /// </summary>
		public string Fg_cp {
            get { return getAttrVal<string>("Fg_cp",null); }
            set { setAttrVal<string>("Fg_cp", value); }
        }

        /// <summary>
        /// 医嘱目的
        /// </summary>
		public string Purpose_or {
            get { return getAttrVal<string>("Purpose_or",null); }
            set { setAttrVal<string>("Purpose_or", value); }
        }

        /// <summary>
        /// 可退费标识
        /// </summary>
		public bool? Fg_feertnable {
            get { return getAttrVal<FBoolean>("Fg_feertnable",null); }
            set { setAttrVal<FBoolean>("Fg_feertnable", value); }
        }

        /// <summary>
        /// 简化的流程标识
        /// </summary>
		public bool? Fg_quickwflow {
            get { return getAttrVal<FBoolean>("Fg_quickwflow",null); }
            set { setAttrVal<FBoolean>("Fg_quickwflow", value); }
        }

        /// <summary>
        /// 医嘱来源模式类型
        /// </summary>
		public string Eu_orsrcmdtp {
            get { return getAttrVal<string>("Eu_orsrcmdtp",null); }
            set { setAttrVal<string>("Eu_orsrcmdtp", value); }
        }

        /// <summary>
        /// 医嘱来源主标识
        /// </summary>
		public string Id_orsrc_main {
            get { return getAttrVal<string>("Id_orsrc_main",null); }
            set { setAttrVal<string>("Id_orsrc_main", value); }
        }

        /// <summary>
        /// 医嘱来源子标识
        /// </summary>
		public string Id_orsrc_sub {
            get { return getAttrVal<string>("Id_orsrc_sub",null); }
            set { setAttrVal<string>("Id_orsrc_sub", value); }
        }

        /// <summary>
        /// 医嘱来源孙标识
        /// </summary>
		public string Id_orsrc_subsub {
            get { return getAttrVal<string>("Id_orsrc_subsub",null); }
            set { setAttrVal<string>("Id_orsrc_subsub", value); }
        }

        /// <summary>
        /// 基本医保判断结果数据信息
        /// </summary>
		public string Bhpjudgerst {
            get { return getAttrVal<string>("Bhpjudgerst",null); }
            set { setAttrVal<string>("Bhpjudgerst", value); }
        }

        /// <summary>
        /// 基本医保判断结果数据信息描述
        /// </summary>
		public string Des_bhpjudgerst {
            get { return getAttrVal<string>("Des_bhpjudgerst",null); }
            set { setAttrVal<string>("Des_bhpjudgerst", value); }
        }
        /// <summary>
        /// 时间戳
        /// </summary>
        public DateTime? Sv
        {
            get { return getAttrVal<FDateTime>("Sv", null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }
        /// <summary>
        /// 费用项是否已经计算过标志
        /// </summary>
        public bool? Fg_prisrvhandled
        {
            get { return getAttrVal<FBoolean>("Fg_prisrvhandled", null); }
            set { setAttrVal<FBoolean>("Fg_prisrvhandled", value); }
        }
        /// <summary>
        /// VIP标识
        /// </summary>
        public bool? Fg_vip
        {
            get { return getAttrVal<FBoolean>("Fg_vip", null); }
            set { setAttrVal<FBoolean>("Fg_vip", value); }
        }

        /// <summary>
        /// 超量开单原因id
        /// </summary>
		public string Id_excessive_reason
        {
            get { return getAttrVal<string>("Id_excessive_reason", null); }
            set { setAttrVal<string>("Id_excessive_reason", value); }
        }

        /// <summary>
        /// 超量开单原因sd
        /// </summary>
		public string Sd_excessive_reason
        {
            get { return getAttrVal<string>("Sd_excessive_reason", null); }
            set { setAttrVal<string>("Sd_excessive_reason", value); }
        }

        /// <summary>
        /// 超量开单原因名称
        /// </summary>
		public string Name_excessive_reason
        {
            get { return getAttrVal<string>("Name_excessive_reason", null); }
            set { setAttrVal<string>("Name_excessive_reason", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_or", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Id_srvtp", "Sd_srvtp", "Id_srv", "Id_srv_pkg", "Fg_long", "Emstype", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Fg_boil", "Days_or", "Orders", "Orders_boil", "Code", "Name", "Content", "Note", "Id_emp_phy", "Name_emp_phy", "Id_dep_phy", "Name_dep_phy", "Id_wg_or", "Dt_begin", "Dt_end", "Dt_invalid", "Fg_bb", "No_bb", "Fg_pmor", "Des_pmor", "Fg_active_pm", "Id_reltp", "Sd_reltp", "Id_or_rel", "Fg_ctlcp", "Fg_mr", "Fg_skintest", "Id_skintest_skip_reaso", "Sd_skintest_skip_reaso", "Fg_mp_in", "Times_mp_in", "Fg_mp_bed", "Times_firday_mp", "Fg_or_doc", "Id_su_or", "Sd_su_or", "Emssrvs", "Ciorfreqtimes", "Srvsetitms", "Orapplysheet", "Id_dept_en", "Id_dept_ns", "Fg_set", "Des_or", "Fg_pres_outp", "Funcclassstr", "Id_srvof", "Applyno", "Fg_urgent", "Times_cur", "Id_orrsttp", "Sd_orrsttp", "Id_dep_mp", "Id_unit_med", "Quan_medu", "Id_srvca", "Name_unit_med", "Innercode_srvca", "Id_grp", "Id_org", "Emsappmode", "Name_ems", "Id_orpltp", "Name_dep_mp", "Mapkeys", "Mapinfo", "Fg_syncfee", "Freqct", "Frequnitct", "Sd_frequnitct", "Eu_hpindicjudge", "Eu_uncporjudge", "Reason_uncporuse", "Fg_cp", "Purpose_or", "Fg_feertnable", "Fg_quickwflow", "Eu_orsrcmdtp", "Id_orsrc_main", "Id_orsrc_sub", "Id_orsrc_subsub", "Bhpjudgerst", "Des_bhpjudgerst", "Sv", "Fg_prisrvhandled", "Fg_vip", "Id_excessive_reason", "Sd_excessive_reason", "Name_excessive_reason" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ems.d.CiEmsDTO";
        }
    }
}
