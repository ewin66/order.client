using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsObsLap 的摘要说明。
    /// </summary>
    public class EmsObsLap : OrCommonFieldsDTO {

        public EmsObsLap() {
 
        }

        /// <summary>
        /// id
        /// </summary>
		public string Id {
            get { return getAttrVal<string>("Id",null); }
            set { setAttrVal<string>("Id", value); }
        }

        /// <summary>
        /// 部位编码
        /// </summary>
		public string Sd_body {
            get { return getAttrVal<string>("Sd_body",null); }
            set { setAttrVal<string>("Sd_body", value); }
        }

        /// <summary>
        /// 部位名称
        /// </summary>
		public string Name_body {
            get { return getAttrVal<string>("Name_body",null); }
            set { setAttrVal<string>("Name_body", value); }
        }

        /// <summary>
        /// 体位编码
        /// </summary>
		public string Sd_pos {
            get { return getAttrVal<string>("Sd_pos",null); }
            set { setAttrVal<string>("Sd_pos", value); }
        }

        /// <summary>
        /// 体位名称
        /// </summary>
		public string Name_pos {
            get { return getAttrVal<string>("Name_pos",null); }
            set { setAttrVal<string>("Name_pos", value); }
        }

        /// <summary>
        /// 是否可床边执行
        /// </summary>
		public string If_mp_bed {
            get { return getAttrVal<string>("If_mp_bed",null); }
            set { setAttrVal<string>("If_mp_bed", value); }
        }

        /// <summary>
        /// 检验编码
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 检验名称
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 体位id
        /// </summary>
		public string Id_pos {
            get { return getAttrVal<string>("Id_pos",null); }
            set { setAttrVal<string>("Id_pos", value); }
        }

        /// <summary>
        /// 部位id
        /// </summary>
		public string Id_body {
            get { return getAttrVal<string>("Id_body",null); }
            set { setAttrVal<string>("Id_body", value); }
        }

        /// <summary>
        /// 医嘱服务id
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 医嘱医疗单
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型名称
        /// </summary>
		public string Name_srvtp {
            get { return getAttrVal<string>("Name_srvtp",null); }
            set { setAttrVal<string>("Name_srvtp", value); }
        }

        /// <summary>
        /// 检查类型id
        /// </summary>
		public string Id_obstp {
            get { return getAttrVal<string>("Id_obstp",null); }
            set { setAttrVal<string>("Id_obstp", value); }
        }

        /// <summary>
        /// 检查类型名称
        /// </summary>
		public string Name_obstp {
            get { return getAttrVal<string>("Name_obstp",null); }
            set { setAttrVal<string>("Name_obstp", value); }
        }

        /// <summary>
        /// 检查申请单号
        /// </summary>
		public string No_applyobs {
            get { return getAttrVal<string>("No_applyobs",null); }
            set { setAttrVal<string>("No_applyobs", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 床旁执行标志
        /// </summary>
		public bool? Fg_mp_bed {
            get { return getAttrVal<FBoolean>("Fg_mp_bed",null); }
            set { setAttrVal<FBoolean>("Fg_mp_bed", value); }
        }

        /// <summary>
        /// 计划检查时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 诊断id
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
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
        /// 检查目的编码
        /// </summary>
		public string Sd_pps {
            get { return getAttrVal<string>("Sd_pps",null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }

        /// <summary>
        /// 检查目的
        /// </summary>
		public string Id_pps {
            get { return getAttrVal<string>("Id_pps",null); }
            set { setAttrVal<string>("Id_pps", value); }
        }

        /// <summary>
        /// 检查目的描述
        /// </summary>
		public string Des_pps {
            get { return getAttrVal<string>("Des_pps",null); }
            set { setAttrVal<string>("Des_pps", value); }
        }

        /// <summary>
        /// 症状体征描述
        /// </summary>
		public string Des_sympsign {
            get { return getAttrVal<string>("Des_sympsign",null); }
            set { setAttrVal<string>("Des_sympsign", value); }
        }

        /// <summary>
        /// 检查申请单状态
        /// </summary>
		public string Id_su_obs {
            get { return getAttrVal<string>("Id_su_obs",null); }
            set { setAttrVal<string>("Id_su_obs", value); }
        }

        /// <summary>
        /// 检查申请单编码
        /// </summary>
		public string Sd_su_obs {
            get { return getAttrVal<string>("Sd_su_obs",null); }
            set { setAttrVal<string>("Sd_su_obs", value); }
        }

        /// <summary>
        /// 标本类型id
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 标本类型编码
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 选择
        /// </summary>
		public bool? Fg_chk {
            get { return getAttrVal<FBoolean>("Fg_chk",null); }
            set { setAttrVal<FBoolean>("Fg_chk", value); }
        }

        /// <summary>
        /// 注意事项
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 检验分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 采集方法编码
        /// </summary>
		public string Sd_colltp {
            get { return getAttrVal<string>("Sd_colltp",null); }
            set { setAttrVal<string>("Sd_colltp", value); }
        }

        /// <summary>
        /// 采集方法id
        /// </summary>
		public string Id_colltp {
            get { return getAttrVal<string>("Id_colltp",null); }
            set { setAttrVal<string>("Id_colltp", value); }
        }

        /// <summary>
        /// 标本说明
        /// </summary>
		public string Des_labsamp {
            get { return getAttrVal<string>("Des_labsamp",null); }
            set { setAttrVal<string>("Des_labsamp", value); }
        }

        /// <summary>
        /// 容器编码
        /// </summary>
		public string Id_contp {
            get { return getAttrVal<string>("Id_contp",null); }
            set { setAttrVal<string>("Id_contp", value); }
        }

        /// <summary>
        /// 容器id
        /// </summary>
		public string Sd_contp {
            get { return getAttrVal<string>("Sd_contp",null); }
            set { setAttrVal<string>("Sd_contp", value); }
        }

        /// <summary>
        /// 标本需求量
        /// </summary>
		public FDouble Quan {
            get { return getAttrVal<FDouble>("Quan", null); }
            set { setAttrVal<FDouble>("Quan", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

        /// <summary>
        /// 检查组织描述
        /// </summary>
		public string Biopsy {
            get { return getAttrVal<string>("Biopsy",null); }
            set { setAttrVal<string>("Biopsy", value); }
        }

        /// <summary>
        /// 医嘱标志
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 医嘱类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 数值_医疗单位
        /// </summary>
		public FDouble Quan_medu {
            get { return getAttrVal<FDouble>("Quan_medu",null); }
            set { setAttrVal<FDouble>("Quan_medu", value); }
        }

        /// <summary>
        /// 医疗单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 计费标志
        /// </summary>
		public bool? Fg_bl {
            get { return getAttrVal<FBoolean>("Fg_bl",null); }
            set { setAttrVal<FBoolean>("Fg_bl", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }
        public int? Eu_blmd
        {
            get { return getAttrVal<int?>("Eu_blmd", null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }
        /// <summary>
        /// 可选标识
        /// </summary>
		public bool? Fg_edit {
            get { return getAttrVal<FBoolean>("Fg_edit",null); }
            set { setAttrVal<FBoolean>("Fg_edit", value); }
        }

        /// <summary>
        /// 部位可修改标示
        /// </summary>
		public bool? Fg_body_update {
            get { return getAttrVal<FBoolean>("Fg_body_update",null); }
            set { setAttrVal<FBoolean>("Fg_body_update", value); }
        }
        /// <summary>
        /// 定价模式
        /// </summary>
        public string Id_primd
        {
            get { return getAttrVal<string>("Id_primd", null); }
            set { setAttrVal<string>("Id_primd", value); }
        }
        /// <summary>
        /// 标本需求量单位
        /// </summary>
		public string Id_quan {
            get { return getAttrVal<string>("Id_quan",null); }
            set { setAttrVal<string>("Id_quan", value); }
        }

        /// <summary>
        /// 医保
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }

        /// <summary>
        /// 医保名称
        /// </summary>
		public string Name_hp {
            get { return getAttrVal<string>("Name_hp",null); }
            set { setAttrVal<string>("Name_hp", value); }
        }

        /// <summary>
        /// 医保类型
        /// </summary>
		public string Id_hpsrvtp {
            get { return getAttrVal<string>("Id_hpsrvtp",null); }
            set { setAttrVal<string>("Id_hpsrvtp", value); }
        }

        /// <summary>
        /// 医保类型编码
        /// </summary>
		public string Sd_hpsrvtp {
            get { return getAttrVal<string>("Sd_hpsrvtp",null); }
            set { setAttrVal<string>("Sd_hpsrvtp", value); }
        }

        /// <summary>
        /// 数据来源
        /// </summary>
		public int? Eu_sourcemd {
            get { return getAttrVal<int?>("Eu_sourcemd",null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 服务来源
        /// </summary>
		public string Id_srv_src {
            get { return getAttrVal<string>("Id_srv_src",null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 计价方式
        /// </summary>
		public string Priby {
            get { return getAttrVal<string>("Priby",null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /// <summary>
        /// 标本采集时间
        /// </summary>
		public DateTime? Id_sampcoltime {
            get { return getAttrVal<FDateTime>("Id_sampcoltime",null); }
            set { setAttrVal<FDateTime>("Id_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时长
        /// </summary>
		public FDouble Len_sampcoltime {
            get { return getAttrVal<FDouble>("Len_sampcoltime",null); }
            set { setAttrVal<FDouble>("Len_sampcoltime", value); }
        }

        /// <summary>
        /// 时长单位
        /// </summary>
		public string Id_unit_sampcoltime {
            get { return getAttrVal<string>("Id_unit_sampcoltime",null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间类型采集时间类型
        /// </summary>
		public string Id_sampcollecttimetp {
            get { return getAttrVal<string>("Id_sampcollecttimetp",null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 采集时间编码
        /// </summary>
		public string Sd_sampcollecttimetp {
            get { return getAttrVal<string>("Sd_sampcollecttimetp",null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 标本采集时间名称
        /// </summary>
		public string Name_sampcoltime {
            get { return getAttrVal<string>("Name_sampcoltime",null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
        }

        /// <summary>
        /// 采集时长名称
        /// </summary>
		public string Name_len_sampcoltime {
            get { return getAttrVal<string>("Name_len_sampcoltime",null); }
            set { setAttrVal<string>("Name_len_sampcoltime", value); }
        }

        /// <summary>
        /// 采集时间类型名称
        /// </summary>
		public string Name_sampcollecttimetp {
            get { return getAttrVal<string>("Name_sampcollecttimetp",null); }
            set { setAttrVal<string>("Name_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 时长单位名称
        /// </summary>
		public string Name_unit_sampcoltime {
            get { return getAttrVal<string>("Name_unit_sampcoltime",null); }
            set { setAttrVal<string>("Name_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 是否有检查部位
        /// </summary>
		public bool? Fg_pos {
            get { return getAttrVal<FBoolean>("Fg_pos",null); }
            set { setAttrVal<FBoolean>("Fg_pos", value); }
        }

        /// <summary>
        /// 检验分组
        /// </summary>
		public string Id_labgroup {
            get { return getAttrVal<string>("Id_labgroup",null); }
            set { setAttrVal<string>("Id_labgroup", value); }
        }

        /// <summary>
        /// 检验分组编码
        /// </summary>
		public string Sd_labgroup {
            get { return getAttrVal<string>("Sd_labgroup",null); }
            set { setAttrVal<string>("Sd_labgroup", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id", "Sd_body", "Name_body", "Sd_pos", "Name_pos", "If_mp_bed", "Id_srv", "Name_srv", "Sortno", "Id_pos", "Id_body", "Id_orsrv", "Id_or", "Id_srvtp", "Name_srvtp", "Id_obstp", "Name_obstp", "No_applyobs", "Fg_urgent", "Fg_mp_bed", "Dt_plan", "Id_di", "Name_di", "Str_id_di", "Str_name_di", "Sd_pps", "Id_pps", "Des_pps", "Des_sympsign", "Id_su_obs", "Sd_su_obs", "Id_samptp", "Name_samptp", "Sd_samptp", "Fg_chk", "Announcements", "Sv", "Id_srvca", "Sd_colltp", "Id_colltp", "Des_labsamp", "Id_contp", "Sd_contp", "Quan", "No_applyform", "Biopsy", "Fg_or", "Sd_srvtp", "Id_freq", "Quan_medu", "Id_medu", "Fg_bl", "Code_srv", "Fg_edit", "Fg_body_update", "Id_quan", "Id_hp", "Name_hp", "Id_hpsrvtp", "Sd_hpsrvtp", "Eu_sourcemd", "Id_srv_src", "Priby", "Id_sampcoltime", "Len_sampcoltime", "Id_unit_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Name_sampcoltime", "Name_len_sampcoltime", "Name_sampcollecttimetp", "Name_unit_sampcoltime", "Fg_pos", "Id_labgroup", "Sd_labgroup"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsObsLap";
        }
    }
}
