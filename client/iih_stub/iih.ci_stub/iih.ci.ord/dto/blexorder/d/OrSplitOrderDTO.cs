using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.blexorder.d
{
    /// <summary>
    /// OrSplitOrderDTO 的摘要说明。
    /// </summary>
    public class OrSplitOrderDTO : BaseDTO {

        public OrSplitOrderDTO() {
 
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
        /// 医嘱内容
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 医嘱名称
        /// </summary>
		public string Name_or {
            get { return getAttrVal<string>("Name_or",null); }
            set { setAttrVal<string>("Name_or", value); }
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
        /// 开立科室病区
        /// </summary>
		public string Id_dep_create {
            get { return getAttrVal<string>("Id_dep_create",null); }
            set { setAttrVal<string>("Id_dep_create", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_create {
            get { return getAttrVal<string>("Id_emp_create",null); }
            set { setAttrVal<string>("Id_emp_create", value); }
        }

        /// <summary>
        /// 最近生成时间（医嘱）
        /// </summary>
		public DateTime? Dt_last_bl_or {
            get { return getAttrVal<FDateTime>("Dt_last_bl_or",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl_or", value); }
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
        /// 医嘱执行状态
        /// </summary>
		public string Or_mp_status {
            get { return getAttrVal<string>("Or_mp_status",null); }
            set { setAttrVal<string>("Or_mp_status", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_grp", "Id_org", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Fg_bb", "No_bb", "Content_or", "Name_or", "Code_or", "Des_or", "Id_orsrvtp", "Sd_orsrvtp", "Id_su_or", "Sd_su_or", "Dt_effe", "Dt_end", "Dt_invalid", "Fg_long", "Fg_boil", "Quan_or", "Orders_boil", "Fg_skintest", "Fg_mp_bed", "Dt_stop", "Name_pati", "Gender", "Dt_birth", "No_bed", "Orattachinfos", "Dt_create", "Id_org_create", "Id_dep_create", "Id_emp_create", "Dt_last_bl_or", "Id_srvtp", "Sd_srvtp", "Id_route", "Id_routedes", "Id_boil", "Id_boildes", "Id_freq", "Id_frequnit", "Sd_frequnit", "Frequnitcnt", "Freqcnt", "Dt_mp_plan", "Durationsec", "Or_mp_status"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO";
        }
    }
}
