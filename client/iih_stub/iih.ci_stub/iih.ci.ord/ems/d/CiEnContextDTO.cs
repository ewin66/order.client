using iih.en.pv.dto.d;
using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.sys.orgfw.dept.d;
using xap.sys.orgfw.group.d;
using xap.sys.orgfw.org.d;
using xap.sys.permfw.user.d;
using xap.sys.securityfw.switchdept;

namespace iih.ci.ord.ems.d
{
    /// <summary>
    /// CiEnContextDTO 的摘要说明。
    /// </summary>
    public class CiEnContextDTO : BaseDTO {

        public CiEnContextDTO() {
 
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
        /// 就诊类型id
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
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
        /// 主医保数据
        /// </summary>
		public string Id_hp {
            get { return getAttrVal<string>("Id_hp",null); }
            set { setAttrVal<string>("Id_hp", value); }
        }
        /// <summary>
        /// 默认的医保计划（患者医保计划为空或是高端商保的情况）
        /// </summary>
        public string Id_hp_default
        {
            get { return getAttrVal<string>("Id_hp_default", null); }
            set { setAttrVal<string>("Id_hp_default", value); }
        }
        /// <summary>
        /// 当前就诊科室
        /// </summary>
		public string Id_dep_en {
            get { return getAttrVal<string>("Id_dep_en",null); }
            set { setAttrVal<string>("Id_dep_en", value); }
        }

        /// <summary>
        /// 当前就诊病区
        /// </summary>
		public string Id_dep_ns {
            get { return getAttrVal<string>("Id_dep_ns",null); }
            set { setAttrVal<string>("Id_dep_ns", value); }
        }

        /// <summary>
        /// 开立科室
        /// </summary>
		public string Id_dep_or {
            get { return getAttrVal<string>("Id_dep_or",null); }
            set { setAttrVal<string>("Id_dep_or", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Id_emp_or {
            get { return getAttrVal<string>("Id_emp_or",null); }
            set { setAttrVal<string>("Id_emp_or", value); }
        }

        /// <summary>
        /// 开立医疗组
        /// </summary>
		public string Id_wg_or {
            get { return getAttrVal<string>("Id_wg_or",null); }
            set { setAttrVal<string>("Id_wg_or", value); }
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
        /// 患者入径标识
        /// </summary>
		public bool? Fg_cp {
            get { return getAttrVal<FBoolean>("Fg_cp",null); }
            set { setAttrVal<FBoolean>("Fg_cp", value); }
        }

        /// <summary>
        /// 本次就诊是否为医保就诊
        /// </summary>
		public bool? Fg_hpfundpay {
            get { return getAttrVal<FBoolean>("Fg_hpfundpay",null); }
            set { setAttrVal<FBoolean>("Fg_hpfundpay", value); }
        }

        /// <summary>
        /// 医保患者黑白名单
        /// </summary>
		public string Eu_inhpbbr {
            get { return getAttrVal<string>("Eu_inhpbbr",null); }
            set { setAttrVal<string>("Eu_inhpbbr", value); }
        }

        /// <summary>
        /// 保外诊断
        /// </summary>
		public string Eu_hpbeyond {
            get { return getAttrVal<string>("Eu_hpbeyond",null); }
            set { setAttrVal<string>("Eu_hpbeyond", value); }
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
        /// 医嘱来源
        /// </summary>
		public string Eu_orsrcmdtp {
            get { return getAttrVal<string>("Eu_orsrcmdtp",null); }
            set { setAttrVal<string>("Eu_orsrcmdtp", value); }
        }

        /// <summary>
        /// banner就诊信息
        /// </summary>
		public Ent4BannerDTO Ent4BannerDTO
        {
            get { return getAttrVal<Ent4BannerDTO>("Ent4BannerDTO", null); }
            set { setAttrVal<Ent4BannerDTO>("Ent4BannerDTO", value); }
        }

            /// <summary>
            /// 集团
            /// </summary>
            public GroupDO Group {
            get { return getAttrVal<GroupDO>("Group",null); }
            set { setAttrVal<GroupDO>("Group", value); }
        }

        /// <summary>
        /// 组织
        /// </summary>
		public OrgDO Org {
            get { return getAttrVal<OrgDO>("Org",null); }
            set { setAttrVal<OrgDO>("Org", value); }
        }

        /// <summary>
        /// 科室
        /// </summary>
		public DeptDO Dept {
            get { return getAttrVal<DeptDO>("Dept",null); }
            set { setAttrVal<DeptDO>("Dept", value); }
        }

        /// <summary>
        /// 人员
        /// </summary>
		public PsnInfo PsnInfo{
            get { return getAttrVal<PsnInfo>("PsnInfo", null); }
            set { setAttrVal<PsnInfo>("PsnInfo", value); }
        }

        /// <summary>
        /// 用户
        /// </summary>
		public UserDO User {
            get { return getAttrVal<UserDO>("User",null); }
            set { setAttrVal<UserDO>("User", value); }
        }

        /// <summary>
        ///  医嘱助手 类型  medsrv:医疗服务  templ: 医嘱模板 ,technology: 医技常规
        /// </summary>
        public string Assistant_type
        {
            get { return getAttrVal<string>("Assistant_type", null); }
            set { setAttrVal<string>("Assistant_type", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_grp", "Id_org", "Emsappmode", "Id_entp", "Code_entp", "Id_pat", "Id_en", "Id_hp", "Id_dep_en", "Id_dep_ns", "Id_dep_or", "Id_emp_or", "Id_wg_or", "Fg_bb", "No_bb", "Fg_cp", "Fg_hpfundpay", "Eu_inhpbbr", "Eu_hpbeyond", "Bhpjudgerst", "Des_bhpjudgerst", "Eu_orsrcmdtp", "Ent4bannerdto", "Group", "Org", "Dept", "PsnInfo", "User", "Id_hp_default" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ems.d.CiEnContextDTO";
        }
    }
}
