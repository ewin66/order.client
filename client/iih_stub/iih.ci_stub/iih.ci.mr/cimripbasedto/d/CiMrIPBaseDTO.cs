using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimripbasedto.d
{
    /// <summary>
    /// CiMrIPBaseDTO 的摘要说明。
    /// </summary>
    public class CiMrIPBaseDTO : BaseDTO {

        public CiMrIPBaseDTO() {
 
        }

        /// <summary>
        /// 域ID
        /// </summary>
		public string Id_pre {
            get { return getAttrVal<string>("Id_pre",null); }
            set { setAttrVal<string>("Id_pre", value); }
        }

        /// <summary>
        /// 患者ID
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 就诊次数（门诊）
        /// </summary>
		public string Times_op {
            get { return getAttrVal<string>("Times_op",null); }
            set { setAttrVal<string>("Times_op", value); }
        }

        /// <summary>
        /// 就诊次数（住院）
        /// </summary>
		public string Times_ip {
            get { return getAttrVal<string>("Times_ip",null); }
            set { setAttrVal<string>("Times_ip", value); }
        }

        /// <summary>
        /// 就诊类别编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 就诊类别名称
        /// </summary>
		public string Name_entp {
            get { return getAttrVal<string>("Name_entp",null); }
            set { setAttrVal<string>("Name_entp", value); }
        }

        /// <summary>
        /// 影像号
        /// </summary>
		public string Id_img {
            get { return getAttrVal<string>("Id_img",null); }
            set { setAttrVal<string>("Id_img", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 患者年龄
        /// </summary>
		public string Age {
            get { return getAttrVal<string>("Age",null); }
            set { setAttrVal<string>("Age", value); }
        }

        /// <summary>
        /// 患者性别编码
        /// </summary>
		public string Code_sex {
            get { return getAttrVal<string>("Code_sex",null); }
            set { setAttrVal<string>("Code_sex", value); }
        }

        /// <summary>
        /// 患者性别名称
        /// </summary>
		public string Sex {
            get { return getAttrVal<string>("Sex",null); }
            set { setAttrVal<string>("Sex", value); }
        }

        /// <summary>
        /// 出生日期
        /// </summary>
		public DateTime? Dt_birth {
            get { return getAttrVal<FDate>("Dt_birth",null); }
            set { setAttrVal<FDate>("Dt_birth", value); }
        }

        /// <summary>
        /// 民族编码
        /// </summary>
		public string Code_nation {
            get { return getAttrVal<string>("Code_nation",null); }
            set { setAttrVal<string>("Code_nation", value); }
        }

        /// <summary>
        /// 民族名称
        /// </summary>
		public string Nation {
            get { return getAttrVal<string>("Nation",null); }
            set { setAttrVal<string>("Nation", value); }
        }

        /// <summary>
        /// 出生地
        /// </summary>
		public string Add {
            get { return getAttrVal<string>("Add",null); }
            set { setAttrVal<string>("Add", value); }
        }

        /// <summary>
        /// 科室编码
        /// </summary>
		public string Code_dept {
            get { return getAttrVal<string>("Code_dept",null); }
            set { setAttrVal<string>("Code_dept", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Dept {
            get { return getAttrVal<string>("Dept",null); }
            set { setAttrVal<string>("Dept", value); }
        }

        /// <summary>
        /// 病区名称
        /// </summary>
		public string Dep_nuradm {
            get { return getAttrVal<string>("Dep_nuradm",null); }
            set { setAttrVal<string>("Dep_nuradm", value); }
        }

        /// <summary>
        /// 床位号
        /// </summary>
		public string Name_bed {
            get { return getAttrVal<string>("Name_bed",null); }
            set { setAttrVal<string>("Name_bed", value); }
        }

        /// <summary>
        /// 记录时间
        /// </summary>
		public DateTime? Dt_record {
            get { return getAttrVal<FDateTime>("Dt_record",null); }
            set { setAttrVal<FDateTime>("Dt_record", value); }
        }

        /// <summary>
        /// 医生编码
        /// </summary>
		public string Code_doc {
            get { return getAttrVal<string>("Code_doc",null); }
            set { setAttrVal<string>("Code_doc", value); }
        }

        /// <summary>
        /// 医生名称
        /// </summary>
		public string Doc {
            get { return getAttrVal<string>("Doc",null); }
            set { setAttrVal<string>("Doc", value); }
        }

        /// <summary>
        /// 医疗机构编码
        /// </summary>
		public string Code_org {
            get { return getAttrVal<string>("Code_org",null); }
            set { setAttrVal<string>("Code_org", value); }
        }

        /// <summary>
        /// 医疗机构名称
        /// </summary>
		public string Org {
            get { return getAttrVal<string>("Org",null); }
            set { setAttrVal<string>("Org", value); }
        }

        /// <summary>
        /// 修改日期
        /// </summary>
		public DateTime? Dt_update {
            get { return getAttrVal<FDateTime>("Dt_update",null); }
            set { setAttrVal<FDateTime>("Dt_update", value); }
        }

        /// <summary>
        /// 修改医生编码
        /// </summary>
		public string Code_up_doc {
            get { return getAttrVal<string>("Code_up_doc",null); }
            set { setAttrVal<string>("Code_up_doc", value); }
        }

        /// <summary>
        /// 修改医生名称
        /// </summary>
		public string Up_doc {
            get { return getAttrVal<string>("Up_doc",null); }
            set { setAttrVal<string>("Up_doc", value); }
        }

        /// <summary>
        /// 审签人信息集合
        /// </summary>
		public FArrayList Ls_audit {
            get { return getAttrVal<FArrayList>("Ls_audit",null); }
            set { setAttrVal<FArrayList>("Ls_audit", value); }
        }

        /// <summary>
        /// 关联医嘱信息集合
        /// </summary>
		public FArrayList Ls_order {
            get { return getAttrVal<FArrayList>("Ls_order",null); }
            set { setAttrVal<FArrayList>("Ls_order", value); }
        }

        /// <summary>
        /// 影像索引号
        /// </summary>
		public string Ima_index {
            get { return getAttrVal<string>("Ima_index",null); }
            set { setAttrVal<string>("Ima_index", value); }
        }

        /// <summary>
        /// 手术开始时间
        /// </summary>
		public DateTime? Dt_ope_start {
            get { return getAttrVal<FDateTime>("Dt_ope_start",null); }
            set { setAttrVal<FDateTime>("Dt_ope_start", value); }
        }

        /// <summary>
        /// 手术结束时间
        /// </summary>
		public DateTime? Dt_ope_end {
            get { return getAttrVal<FDateTime>("Dt_ope_end",null); }
            set { setAttrVal<FDateTime>("Dt_ope_end", value); }
        }

        /// <summary>
        /// 手术名称编码
        /// </summary>
		public string Code_ope {
            get { return getAttrVal<string>("Code_ope",null); }
            set { setAttrVal<string>("Code_ope", value); }
        }

        /// <summary>
        /// 手术名称
        /// </summary>
		public string Ope {
            get { return getAttrVal<string>("Ope",null); }
            set { setAttrVal<string>("Ope", value); }
        }

        /// <summary>
        /// 手术间编码
        /// </summary>
		public string Code_ope_room {
            get { return getAttrVal<string>("Code_ope_room",null); }
            set { setAttrVal<string>("Code_ope_room", value); }
        }

        /// <summary>
        /// 手术间名称
        /// </summary>
		public string Ope_room {
            get { return getAttrVal<string>("Ope_room",null); }
            set { setAttrVal<string>("Ope_room", value); }
        }

        /// <summary>
        /// 切口愈合等级编码
        /// </summary>
		public string Cocde_incicondi {
            get { return getAttrVal<string>("Cocde_incicondi",null); }
            set { setAttrVal<string>("Cocde_incicondi", value); }
        }

        /// <summary>
        /// 切口愈合等级名称
        /// </summary>
		public string Incicondi {
            get { return getAttrVal<string>("Incicondi",null); }
            set { setAttrVal<string>("Incicondi", value); }
        }

        /// <summary>
        /// 麻醉方式编码
        /// </summary>
		public string Code_anestp {
            get { return getAttrVal<string>("Code_anestp",null); }
            set { setAttrVal<string>("Code_anestp", value); }
        }

        /// <summary>
        /// 麻醉方式名称
        /// </summary>
		public string Anestp {
            get { return getAttrVal<string>("Anestp",null); }
            set { setAttrVal<string>("Anestp", value); }
        }

        /// <summary>
        /// 术前简历
        /// </summary>
		public string Ope_res {
            get { return getAttrVal<string>("Ope_res",null); }
            set { setAttrVal<string>("Ope_res", value); }
        }

        /// <summary>
        /// 操作步骤
        /// </summary>
		public string Ope_step {
            get { return getAttrVal<string>("Ope_step",null); }
            set { setAttrVal<string>("Ope_step", value); }
        }

        /// <summary>
        /// 术者信息结合
        /// </summary>
		public FArrayList Ls_ope_doc {
            get { return getAttrVal<FArrayList>("Ls_ope_doc",null); }
            set { setAttrVal<FArrayList>("Ls_ope_doc", value); }
        }

        /// <summary>
        /// 助手信息集合
        /// </summary>
		public FArrayList Ls_ope_ass {
            get { return getAttrVal<FArrayList>("Ls_ope_ass",null); }
            set { setAttrVal<FArrayList>("Ls_ope_ass", value); }
        }

        /// <summary>
        /// 护士信息结合
        /// </summary>
		public FArrayList Ls_ope_nur {
            get { return getAttrVal<FArrayList>("Ls_ope_nur",null); }
            set { setAttrVal<FArrayList>("Ls_ope_nur", value); }
        }

        /// <summary>
        /// 出院时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 住院天数
        /// </summary>
		public int? Ip_day {
            get { return getAttrVal<int?>("Ip_day",null); }
            set { setAttrVal<int?>("Ip_day", value); }
        }

        /// <summary>
        /// 出院情况信息
        /// </summary>
		public string Leave_info {
            get { return getAttrVal<string>("Leave_info",null); }
            set { setAttrVal<string>("Leave_info", value); }
        }

        /// <summary>
        /// 出院诊断证明书信息
        /// </summary>
		public string Leave_dia_info {
            get { return getAttrVal<string>("Leave_dia_info",null); }
            set { setAttrVal<string>("Leave_dia_info", value); }
        }

        /// <summary>
        /// 出院后多少周复诊
        /// </summary>
		public string Leave_week_rv {
            get { return getAttrVal<string>("Leave_week_rv",null); }
            set { setAttrVal<string>("Leave_week_rv", value); }
        }

        /// <summary>
        /// 采史日期
        /// </summary>
		public DateTime? Dt_ga_mh {
            get { return getAttrVal<FDateTime>("Dt_ga_mh",null); }
            set { setAttrVal<FDateTime>("Dt_ga_mh", value); }
        }

        /// <summary>
        /// 采史人地址
        /// </summary>
		public string Add_ga_mh {
            get { return getAttrVal<string>("Add_ga_mh",null); }
            set { setAttrVal<string>("Add_ga_mh", value); }
        }

        /// <summary>
        /// 采史人电话
        /// </summary>
		public string Pho_ga_mh {
            get { return getAttrVal<string>("Pho_ga_mh",null); }
            set { setAttrVal<string>("Pho_ga_mh", value); }
        }

        /// <summary>
        /// 病史陈述者名称
        /// </summary>
		public string Ga_mh {
            get { return getAttrVal<string>("Ga_mh",null); }
            set { setAttrVal<string>("Ga_mh", value); }
        }

        /// <summary>
        /// 采史人关系编码
        /// </summary>
		public string Code_ga_mh_re {
            get { return getAttrVal<string>("Code_ga_mh_re",null); }
            set { setAttrVal<string>("Code_ga_mh_re", value); }
        }

        /// <summary>
        /// 采史人关系名称
        /// </summary>
		public string Ga_mh_re {
            get { return getAttrVal<string>("Ga_mh_re",null); }
            set { setAttrVal<string>("Ga_mh_re", value); }
        }

        /// <summary>
        /// 可靠程度编码
        /// </summary>
		public string Code_re_de {
            get { return getAttrVal<string>("Code_re_de",null); }
            set { setAttrVal<string>("Code_re_de", value); }
        }

        /// <summary>
        /// 可靠程度名称
        /// </summary>
		public string Re_de {
            get { return getAttrVal<string>("Re_de",null); }
            set { setAttrVal<string>("Re_de", value); }
        }

        /// <summary>
        /// 主诉
        /// </summary>
		public string Ch_co {
            get { return getAttrVal<string>("Ch_co",null); }
            set { setAttrVal<string>("Ch_co", value); }
        }

        /// <summary>
        /// 现病史
        /// </summary>
		public string Ill_ht {
            get { return getAttrVal<string>("Ill_ht",null); }
            set { setAttrVal<string>("Ill_ht", value); }
        }

        /// <summary>
        /// 既往史
        /// </summary>
		public string Pa_ht {
            get { return getAttrVal<string>("Pa_ht",null); }
            set { setAttrVal<string>("Pa_ht", value); }
        }

        /// <summary>
        /// 药物过敏史
        /// </summary>
		public string Me_al_ht {
            get { return getAttrVal<string>("Me_al_ht",null); }
            set { setAttrVal<string>("Me_al_ht", value); }
        }

        /// <summary>
        /// 家族史
        /// </summary>
		public string Fa_ht {
            get { return getAttrVal<string>("Fa_ht",null); }
            set { setAttrVal<string>("Fa_ht", value); }
        }

        /// <summary>
        /// 社会/个人史
        /// </summary>
		public string Pe_ht {
            get { return getAttrVal<string>("Pe_ht",null); }
            set { setAttrVal<string>("Pe_ht", value); }
        }

        /// <summary>
        /// 婚育史
        /// </summary>
		public string Ma_ht {
            get { return getAttrVal<string>("Ma_ht",null); }
            set { setAttrVal<string>("Ma_ht", value); }
        }

        /// <summary>
        /// 体格检查信息
        /// </summary>
		public string Ph_ex_info {
            get { return getAttrVal<string>("Ph_ex_info",null); }
            set { setAttrVal<string>("Ph_ex_info", value); }
        }

        /// <summary>
        /// 专科检查章节标题
        /// </summary>
		public string Sp_ex_title {
            get { return getAttrVal<string>("Sp_ex_title",null); }
            set { setAttrVal<string>("Sp_ex_title", value); }
        }

        /// <summary>
        /// 专科检查
        /// </summary>
		public string Sp_ex {
            get { return getAttrVal<string>("Sp_ex",null); }
            set { setAttrVal<string>("Sp_ex", value); }
        }

        /// <summary>
        /// 辅助检查章节标题
        /// </summary>
		public string Su_ex_title {
            get { return getAttrVal<string>("Su_ex_title",null); }
            set { setAttrVal<string>("Su_ex_title", value); }
        }

        /// <summary>
        /// 辅助检查
        /// </summary>
		public string Su_ex {
            get { return getAttrVal<string>("Su_ex",null); }
            set { setAttrVal<string>("Su_ex", value); }
        }

        /// <summary>
        /// 文书内容
        /// </summary>
		public string Mr_area {
            get { return getAttrVal<string>("Mr_area",null); }
            set { setAttrVal<string>("Mr_area", value); }
        }

        /// <summary>
        /// 入院情况
        /// </summary>
		public string In_si {
            get { return getAttrVal<string>("In_si",null); }
            set { setAttrVal<string>("In_si", value); }
        }

        /// <summary>
        /// 诊疗经过
        /// </summary>
		public string Treatment {
            get { return getAttrVal<string>("Treatment",null); }
            set { setAttrVal<string>("Treatment", value); }
        }

        /// <summary>
        /// 死亡日期
        /// </summary>
		public DateTime? Dt_de {
            get { return getAttrVal<FDateTime>("Dt_de",null); }
            set { setAttrVal<FDateTime>("Dt_de", value); }
        }

        /// <summary>
        /// 抢救过程
        /// </summary>
		public string Re_pr {
            get { return getAttrVal<string>("Re_pr",null); }
            set { setAttrVal<string>("Re_pr", value); }
        }

        /// <summary>
        /// 死亡原因
        /// </summary>
		public string De_re {
            get { return getAttrVal<string>("De_re",null); }
            set { setAttrVal<string>("De_re", value); }
        }

        /// <summary>
        /// 签名人编码
        /// </summary>
		public string Code_doc_sign {
            get { return getAttrVal<string>("Code_doc_sign",null); }
            set { setAttrVal<string>("Code_doc_sign", value); }
        }

        /// <summary>
        /// 签名人名称
        /// </summary>
		public string Doc_sign {
            get { return getAttrVal<string>("Doc_sign",null); }
            set { setAttrVal<string>("Doc_sign", value); }
        }

        /// <summary>
        /// 病历及诊治摘要
        /// </summary>
		public string Mr_ab {
            get { return getAttrVal<string>("Mr_ab",null); }
            set { setAttrVal<string>("Mr_ab", value); }
        }

        /// <summary>
        /// 出院医嘱内容
        /// </summary>
		public string Or_le_ar {
            get { return getAttrVal<string>("Or_le_ar",null); }
            set { setAttrVal<string>("Or_le_ar", value); }
        }

        /// <summary>
        /// 诊断信息集合
        /// </summary>
		public FArrayList Ls_dia {
            get { return getAttrVal<FArrayList>("Ls_dia",null); }
            set { setAttrVal<FArrayList>("Ls_dia", value); }
        }

        /// <summary>
        /// 章节信息集合
        /// </summary>
		public FArrayList Ls_sec {
            get { return getAttrVal<FArrayList>("Ls_sec",null); }
            set { setAttrVal<FArrayList>("Ls_sec", value); }
        }

        /// <summary>
        /// 讨论时间
        /// </summary>
		public DateTime? Dt_meet {
            get { return getAttrVal<FDateTime>("Dt_meet",null); }
            set { setAttrVal<FDateTime>("Dt_meet", value); }
        }

        /// <summary>
        /// 会议主持者集合
        /// </summary>
		public FArrayList Ls_me_ho {
            get { return getAttrVal<FArrayList>("Ls_me_ho",null); }
            set { setAttrVal<FArrayList>("Ls_me_ho", value); }
        }

        /// <summary>
        /// 会议参加者集合
        /// </summary>
		public FArrayList Ls_me_pa {
            get { return getAttrVal<FArrayList>("Ls_me_pa",null); }
            set { setAttrVal<FArrayList>("Ls_me_pa", value); }
        }

        /// <summary>
        /// 地点信息
        /// </summary>
		public string Me_add {
            get { return getAttrVal<string>("Me_add",null); }
            set { setAttrVal<string>("Me_add", value); }
        }

        /// <summary>
        /// 讨论结论
        /// </summary>
		public string Me_co {
            get { return getAttrVal<string>("Me_co",null); }
            set { setAttrVal<string>("Me_co", value); }
        }

        /// <summary>
        /// 参照本例应借鉴的问题
        /// </summary>
		public string Me_le {
            get { return getAttrVal<string>("Me_le",null); }
            set { setAttrVal<string>("Me_le", value); }
        }

        /// <summary>
        /// 数据集编码
        /// </summary>
		public string Code_set {
            get { return getAttrVal<string>("Code_set",null); }
            set { setAttrVal<string>("Code_set", value); }
        }

        /// <summary>
        /// 文书二进制
        /// </summary>
		public byte[] Fs {
            get { return getAttrVal<byte[]>("Fs",null); }
            set { setAttrVal<byte[]>("Fs", value); }
        }

        /// <summary>
        /// 入院时间
        /// </summary>
		public DateTime? Dt_acpt {
            get { return getAttrVal<FDateTime>("Dt_acpt",null); }
            set { setAttrVal<FDateTime>("Dt_acpt", value); }
        }

        /// <summary>
        /// 病理诊断
        /// </summary>
		public string Pa_dia {
            get { return getAttrVal<string>("Pa_dia",null); }
            set { setAttrVal<string>("Pa_dia", value); }
        }

        /// <summary>
        /// 经治医师陈述
        /// </summary>
		public string Ob_va {
            get { return getAttrVal<string>("Ob_va",null); }
            set { setAttrVal<string>("Ob_va", value); }
        }

        /// <summary>
        /// 接口服务id
        /// </summary>
		public string Id_server {
            get { return getAttrVal<string>("Id_server",null); }
            set { setAttrVal<string>("Id_server", value); }
        }

        /// <summary>
        /// 文书主键
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 就诊主键
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 消息类型
        /// </summary>
		public string Type_message {
            get { return getAttrVal<string>("Type_message",null); }
            set { setAttrVal<string>("Type_message", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_pre", "Id_pat", "Id_ent", "Times_op", "Times_ip", "Code_entp", "Name_entp", "Id_img", "Name", "Age", "Code_sex", "Sex", "Dt_birth", "Code_nation", "Nation", "Add", "Code_dept", "Dept", "Dep_nuradm", "Name_bed", "Dt_record", "Code_doc", "Doc", "Code_org", "Org", "Dt_update", "Code_up_doc", "Up_doc", "Ls_audit", "Ls_order", "Ima_index", "Dt_ope_start", "Dt_ope_end", "Code_ope", "Ope", "Code_ope_room", "Ope_room", "Cocde_incicondi", "Incicondi", "Code_anestp", "Anestp", "Ope_res", "Ope_step", "Ls_ope_doc", "Ls_ope_ass", "Ls_ope_nur", "Dt_end", "Ip_day", "Leave_info", "Leave_dia_info", "Leave_week_rv", "Dt_ga_mh", "Add_ga_mh", "Pho_ga_mh", "Ga_mh", "Code_ga_mh_re", "Ga_mh_re", "Code_re_de", "Re_de", "Ch_co", "Ill_ht", "Pa_ht", "Me_al_ht", "Fa_ht", "Pe_ht", "Ma_ht", "Ph_ex_info", "Sp_ex_title", "Sp_ex", "Su_ex_title", "Su_ex", "Mr_area", "In_si", "Treatment", "Dt_de", "Re_pr", "De_re", "Code_doc_sign", "Doc_sign", "Mr_ab", "Or_le_ar", "Ls_dia", "Ls_sec", "Dt_meet", "Ls_me_ho", "Ls_me_pa", "Me_add", "Me_co", "Me_le", "Code_set", "Fs", "Dt_acpt", "Pa_dia", "Ob_va", "Id_server", "Id_mr", "Id_en", "Type_message"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimripbasedto.d.CiMrIPBaseDTO";
        }
    }
}
