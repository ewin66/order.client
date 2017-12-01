using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.blexorder.d
{
    /// <summary>
    /// SrvSplitOrderDTO 的摘要说明。
    /// </summary>
    public class SrvSplitOrderDTO : BaseDTO {

        public SrvSplitOrderDTO() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
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
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
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
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 医嘱编码
        /// </summary>
		public string Code_or {
            get { return getAttrVal<string>("Code_or",null); }
            set { setAttrVal<string>("Code_or", value); }
        }

        /// <summary>
        /// 医嘱备注
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 医嘱类型
        /// </summary>
		public string Id_orsrvtp {
            get { return getAttrVal<string>("Id_orsrvtp",null); }
            set { setAttrVal<string>("Id_orsrvtp", value); }
        }

        /// <summary>
        /// 医嘱类型编码
        /// </summary>
		public string Sd_orsrvtp {
            get { return getAttrVal<string>("Sd_orsrvtp",null); }
            set { setAttrVal<string>("Sd_orsrvtp", value); }
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
        /// 生效日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 失效日期
        /// </summary>
		public DateTime? Dt_invalid {
            get { return getAttrVal<FDateTime>("Dt_invalid",null); }
            set { setAttrVal<FDateTime>("Dt_invalid", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 代煎标识
        /// </summary>
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }

        /// <summary>
        /// 医嘱付数
        /// </summary>
		public int? Quan_or {
            get { return getAttrVal<int?>("Quan_or",null); }
            set { setAttrVal<int?>("Quan_or", value); }
        }

        /// <summary>
        /// 代煎付数
        /// </summary>
		public int? Orders_boil {
            get { return getAttrVal<int?>("Orders_boil",null); }
            set { setAttrVal<int?>("Orders_boil", value); }
        }

        /// <summary>
        /// 皮试标识
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 床边执行标识
        /// </summary>
		public bool? Fg_mp_bed {
            get { return getAttrVal<FBoolean>("Fg_mp_bed",null); }
            set { setAttrVal<FBoolean>("Fg_mp_bed", value); }
        }

        /// <summary>
        /// 停止日期
        /// </summary>
		public DateTime? Dt_stop {
            get { return getAttrVal<FDateTime>("Dt_stop",null); }
            set { setAttrVal<FDateTime>("Dt_stop", value); }
        }

        /// <summary>
        /// 姓名
        /// </summary>
		public string Name_pati {
            get { return getAttrVal<string>("Name_pati",null); }
            set { setAttrVal<string>("Name_pati", value); }
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
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 床号
        /// </summary>
		public string No_bed {
            get { return getAttrVal<string>("No_bed",null); }
            set { setAttrVal<string>("No_bed", value); }
        }

        /// <summary>
        /// 附属信息
        /// </summary>
		public FMap Orattachinfos {
            get { return getAttrVal<FMap>("Orattachinfos",null); }
            set { setAttrVal<FMap>("Orattachinfos", value); }
        }

        /// <summary>
        /// 医嘱服务项目
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 服务名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public int? Sortno {
            get { return getAttrVal<int?>("Sortno",null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 服务项目分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 物品标识
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 数值_医学单位
        /// </summary>
		public double? Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 出院带药标识
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 医嘱标识
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 划价方式
        /// </summary>
		public int? Eu_blmd {
            get { return getAttrVal<int?>("Eu_blmd",null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }

        /// <summary>
        /// 收费标识
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 医保适应症标识
        /// </summary>
		public bool? Fg_indic {
            get { return getAttrVal<FBoolean>("Fg_indic",null); }
            set { setAttrVal<FBoolean>("Fg_indic", value); }
        }

        /// <summary>
        /// 不规则剂量标识
        /// </summary>
		public bool? Fg_dose_anoma {
            get { return getAttrVal<FBoolean>("Fg_dose_anoma",null); }
            set { setAttrVal<FBoolean>("Fg_dose_anoma", value); }
        }

        /// <summary>
        /// 最近生成日期
        /// </summary>
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }

        /// <summary>
        /// 最近执行日期
        /// </summary>
		public DateTime? Dt_last_mp {
            get { return getAttrVal<FDateTime>("Dt_last_mp",null); }
            set { setAttrVal<FDateTime>("Dt_last_mp", value); }
        }

        /// <summary>
        /// 执行机构
        /// </summary>
		public string Id_org_mp {
            get { return getAttrVal<string>("Id_org_mp",null); }
            set { setAttrVal<string>("Id_org_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 医嘱服务执行状态
        /// </summary>
		public string Orsrv_su_mp {
            get { return getAttrVal<string>("Orsrv_su_mp",null); }
            set { setAttrVal<string>("Orsrv_su_mp", value); }
        }

        /// <summary>
        /// 物品
        /// </summary>
		public string Id_mm {
            get { return getAttrVal<string>("Id_mm",null); }
            set { setAttrVal<string>("Id_mm", value); }
        }

        /// <summary>
        /// 物品类型
        /// </summary>
		public string Id_mmtp {
            get { return getAttrVal<string>("Id_mmtp",null); }
            set { setAttrVal<string>("Id_mmtp", value); }
        }

        /// <summary>
        /// 物品类型编码
        /// </summary>
		public string Sd_mmtp {
            get { return getAttrVal<string>("Sd_mmtp",null); }
            set { setAttrVal<string>("Sd_mmtp", value); }
        }

        /// <summary>
        /// 物品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 包装单位_基本
        /// </summary>
		public string Id_pkgu_base {
            get { return getAttrVal<string>("Id_pkgu_base",null); }
            set { setAttrVal<string>("Id_pkgu_base", value); }
        }

        /// <summary>
        /// 包装单位_当前
        /// </summary>
		public string Id_pkgu_cur {
            get { return getAttrVal<string>("Id_pkgu_cur",null); }
            set { setAttrVal<string>("Id_pkgu_cur", value); }
        }

        /// <summary>
        /// 换算系数
        /// </summary>
		public double? Factor {
            get { return getAttrVal<FDouble>("Factor",null); }
            set { setAttrVal<FDouble>("Factor", value); }
        }

        /// <summary>
        /// 系数_医疗基本
        /// </summary>
		public double? Factor_mb {
            get { return getAttrVal<FDouble>("Factor_mb",null); }
            set { setAttrVal<FDouble>("Factor_mb", value); }
        }

        /// <summary>
        /// 单次数量值_分子
        /// </summary>
		public int? Quan_num_base {
            get { return getAttrVal<int?>("Quan_num_base",null); }
            set { setAttrVal<int?>("Quan_num_base", value); }
        }

        /// <summary>
        /// 单次数量值_分母
        /// </summary>
		public int? Quan_den_base {
            get { return getAttrVal<int?>("Quan_den_base",null); }
            set { setAttrVal<int?>("Quan_den_base", value); }
        }

        /// <summary>
        /// 总量_当前包装
        /// </summary>
		public double? Quan_cur {
            get { return getAttrVal<FDouble>("Quan_cur",null); }
            set { setAttrVal<FDouble>("Quan_cur", value); }
        }

        /// <summary>
        /// 床边剩余量_医学单位
        /// </summary>
		public double? Quan_bed_medu {
            get { return getAttrVal<FDouble>("Quan_bed_medu",null); }
            set { setAttrVal<FDouble>("Quan_bed_medu", value); }
        }

        /// <summary>
        /// 参考价格_当前包装
        /// </summary>
		public double? Price_pgku_cur {
            get { return getAttrVal<FDouble>("Price_pgku_cur",null); }
            set { setAttrVal<FDouble>("Price_pgku_cur", value); }
        }

        /// <summary>
        /// OTC标识
        /// </summary>
		public bool? Fg_otc {
            get { return getAttrVal<FBoolean>("Fg_otc",null); }
            set { setAttrVal<FBoolean>("Fg_otc", value); }
        }

        /// <summary>
        /// 价值分类
        /// </summary>
		public string Id_val {
            get { return getAttrVal<string>("Id_val",null); }
            set { setAttrVal<string>("Id_val", value); }
        }

        /// <summary>
        /// 价值分类编码
        /// </summary>
		public string Sd_val {
            get { return getAttrVal<string>("Sd_val",null); }
            set { setAttrVal<string>("Sd_val", value); }
        }

        /// <summary>
        /// 物品包装单位取整模式
        /// </summary>
		public string Pkuroundmode {
            get { return getAttrVal<string>("Pkuroundmode",null); }
            set { setAttrVal<string>("Pkuroundmode", value); }
        }

        /// <summary>
        /// 开立日期
        /// </summary>
		public DateTime? Dt_create {
            get { return getAttrVal<FDateTime>("Dt_create",null); }
            set { setAttrVal<FDateTime>("Dt_create", value); }
        }

        /// <summary>
        /// 开立机构
        /// </summary>
		public string Id_org_create {
            get { return getAttrVal<string>("Id_org_create",null); }
            set { setAttrVal<string>("Id_org_create", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }

        /// <summary>
        /// 护理病区
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
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
        /// 用法
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
        /// 煎法
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
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次周期类型
        /// </summary>
		public string Id_frequnit {
            get { return getAttrVal<string>("Id_frequnit",null); }
            set { setAttrVal<string>("Id_frequnit", value); }
        }

        /// <summary>
        /// 频次周期类型编码
        /// </summary>
		public string Sd_frequnit {
            get { return getAttrVal<string>("Sd_frequnit",null); }
            set { setAttrVal<string>("Sd_frequnit", value); }
        }

        /// <summary>
        /// 频次周期总数
        /// </summary>
		public int? Frequnitcnt {
            get { return getAttrVal<int?>("Frequnitcnt",null); }
            set { setAttrVal<int?>("Frequnitcnt", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
		public int? Freqcnt {
            get { return getAttrVal<int?>("Freqcnt",null); }
            set { setAttrVal<int?>("Freqcnt", value); }
        }

        /// <summary>
        /// 计划执行时间
        /// </summary>
		public DateTime? Dt_mp_plan {
            get { return getAttrVal<FDateTime>("Dt_mp_plan",null); }
            set { setAttrVal<FDateTime>("Dt_mp_plan", value); }
        }

        /// <summary>
        /// 持续时间秒数
        /// </summary>
		public int? Durationsec {
            get { return getAttrVal<int?>("Durationsec",null); }
            set { setAttrVal<int?>("Durationsec", value); }
        }

        /// <summary>
        /// 请领数量
        /// </summary>
		public double? Quan_mp_ap {
            get { return getAttrVal<FDouble>("Quan_mp_ap",null); }
            set { setAttrVal<FDouble>("Quan_mp_ap", value); }
        }

        /// <summary>
        /// 请领数量单位
        /// </summary>
		public string Id_pkgu_ap {
            get { return getAttrVal<string>("Id_pkgu_ap",null); }
            set { setAttrVal<string>("Id_pkgu_ap", value); }
        }

        /// <summary>
        /// 请领后床边余量
        /// </summary>
		public double? Quan_bed_ap_medu {
            get { return getAttrVal<FDouble>("Quan_bed_ap_medu",null); }
            set { setAttrVal<FDouble>("Quan_bed_ap_medu", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_grp", "Id_org", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Fg_bb", "No_bb", "Name_or", "Content_or", "Code_or", "Des_or", "Id_orsrvtp", "Sd_orsrvtp", "Id_su_or", "Sd_su_or", "Dt_effe", "Dt_end", "Dt_invalid", "Fg_long", "Fg_boil", "Quan_or", "Orders_boil", "Fg_skintest", "Fg_mp_bed", "Dt_stop", "Name_pati", "Gender", "Dt_birth", "No_bed", "Orattachinfos", "Id_orsrv", "Id_srv", "Code_srv", "Name_srv", "Sortno", "Id_srvca", "Fg_mm", "Id_medu", "Quan_medu", "Fg_pres_outp", "Fg_or", "Eu_blmd", "Fg_bl", "Fg_indic", "Fg_dose_anoma", "Dt_last_bl", "Dt_last_mp", "Id_org_mp", "Id_dep_mp", "Orsrv_su_mp", "Id_mm", "Id_mmtp", "Sd_mmtp", "Code_mm", "Name_mm", "Id_pkgu_base", "Id_pkgu_cur", "Factor", "Factor_mb", "Quan_num_base", "Quan_den_base", "Quan_cur", "Quan_bed_medu", "Price_pgku_cur", "Fg_otc", "Id_val", "Sd_val", "Pkuroundmode", "Dt_create", "Id_org_create", "Id_dep_create", "Id_dep_nur", "Id_emp_create", "Id_srvtp", "Sd_srvtp", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_freq", "Id_frequnit", "Sd_frequnit", "Frequnitcnt", "Freqcnt", "Dt_mp_plan", "Durationsec", "Quan_mp_ap", "Id_pkgu_ap", "Quan_bed_ap_medu"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO";
        }
    }
}
