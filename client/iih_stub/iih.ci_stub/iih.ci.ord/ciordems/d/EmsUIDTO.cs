using System;
using iih.ci.ord.dto.d;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.bd.srv.medsrv.d;
using iih.en.pv.dto.d;
using xap.rui.appfw;

namespace iih.ci.ord.ciordems.d {
    /// <summary>
    /// 一条医嘱所关联的所有的属性表以及这条医嘱所对应的服务项目表
    /// </summary>
    public class EmsUIDTO : BaseDTO {

        public EmsUIDTO() {
        }

        /// <summary>
        /// BD_SRV
        /// </summary>
        public MedSrvDO MedSrvDO {
            get { return getAttrVal<MedSrvDO>("MedSrvDO", null); }
            set { setAttrVal<MedSrvDO>("MedSrvDO", value); }
        }

        /// <summary>
        /// Banner上的信息DTO
        /// </summary>
        public Ent4BannerDTO PatInfo {
            get { return getAttrVal<Ent4BannerDTO>("PatInfo", null); }
            set { setAttrVal<Ent4BannerDTO>("PatInfo", value); }
        }


        /// <summary>
        /// 是否为门诊数据
        /// </summary>
        public bool IsOpData {
            get;
            set;
        }


        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames() {
            return new string[] { "Id_srv", "Id_or", "Id_pat", "Id_en", "Id_entp", "Code_entp", "Id_srvca", "Id_srvtp", "Sd_srvtp", "Emstype", "Id_freq", "Name_freq", "Id_route", "Name_route", "Id_routedes", "Name_routedes", "Id_boil", "Name_boil", "Id_boildes", "Name_boildes", "Days_or", "Orders_boil", "Orders", "Code", "Name", "Des", "Id_emp_phy", "Name_emp_phy", "Id_dep_phy", "Name_dep_phy", "Id_wg_or", "Dt_begin_ui", "Dt_end_ui", "Note", "Emsdrugs", "Emsdrugitems", "Emsrisitems", "Emsoraplab", "Emsapbt", "Funcclassstr", "Id_srvof", "Fg_set" };
        }

        /// <summary>
        /// 前台暂时没用，变动用药的频次， 
        /// 内部类型：[EmsDrugItemDO]
        /// </summary>
        public FArrayList Emsdrugitems {
            get { return getAttrVal<FArrayList>("Emsdrugitems", null); }
            set { setAttrVal<FArrayList>("Emsdrugitems", value); }
        }

        /// <summary>
        /// 
        /// </summary>
        public string Emsrisitems {
            get { return getAttrVal<string>("Emsrisitems", null); }
            set { setAttrVal<string>("Emsrisitems", value); }
        }

        /// <summary>
        /// 当前医疗单的类型
        /// </summary>
        public EmsType EmsType { get; set; }

        /// <summary>
        /// 药品医疗单do
        /// </summary>
        /// <value>
        /// The emsdrugs.
        /// </value>
        public EmsDrugItemDO Emsdrugs {
            get { return getAttrVal<EmsDrugItemDO>("Emsdrugs", null); }
            set { setAttrVal<EmsDrugItemDO>("Emsdrugs", value); }
        }
        /// <summary>
        ///检查医疗单do
        /// </summary>
        /// <value>
        /// The emsobs.
        /// </value>
        /// Author:admin
        /// Date:2015-10-14
        public EmsObsItemDO Emsapobs {
            get { return getAttrVal<EmsObsItemDO>("Emsapobs", null); }
            set { setAttrVal<EmsObsItemDO>("Emsapobs", value); }
        }

        /// <summary>
        ///检验医疗单do
        /// </summary>
        /// <value>
        /// The emsobs.
        /// </value>
        public EmsObsItemDO Emsaplab {
            get { return getAttrVal<EmsObsItemDO>("Emsaplab", null); }
            set { setAttrVal<EmsObsItemDO>("Emsaplab", value); }
        }

        /// <summary>
        ///输血医疗单do
        /// </summary>
        /// <value>
        /// The Emsapbt.
        /// </value>
        public EmsBtItemDO Emsapbt {
            get { return getAttrVal<EmsBtItemDO>("Emsapbt", null); }
            set { setAttrVal<EmsBtItemDO>("Emsapbt", value); }
        }

        /// <summary>
        ///手术医疗单do
        /// </summary>
        /// <value>
        /// The Emsapbt.
        /// </value>
        public EmsOpitemDO Emsapop {
            get { return getAttrVal<EmsOpitemDO>("Emsapop", null); }
            set { setAttrVal<EmsOpitemDO>("Emsapop", value); }
        }
        /// <summary>
        ///病理医疗单do
        /// </summary>
        public EmsPathgyItemDO Emsappathgy {
            get { return getAttrVal<EmsPathgyItemDO>("Emsappathgy", null); }
            set { setAttrVal<EmsPathgyItemDO>("Emsappathgy", value); }
        }

        /// <summary>
        ///会诊医疗单do
        /// </summary>
        public EmsConsItemDO Emsapcons {
            get { return getAttrVal<EmsConsItemDO>("Emsapcons", null); }
            set { setAttrVal<EmsConsItemDO>("Emsapcons", value); }
        }

        /// <summary>
        ///转科申请单do
        /// </summary>
        public EmsTransItemDO Emsaptrans {
            get { return getAttrVal<EmsTransItemDO>("Emsaptrans", null); }
            set { setAttrVal<EmsTransItemDO>("Emsaptrans", value); }
        }

        /// <summary>
        ///出院申请单do
        /// </summary>
        public EmsOutItemDO Emsapout {
            get { return getAttrVal<EmsOutItemDO>("Emsapout", null); }
            set { setAttrVal<EmsOutItemDO>("Emsapout", value); }
        }

        /// <summary>
        /// 用血
        /// </summary>
        public CiordubDTO CiordubDTO {
            get { return getAttrVal<CiordubDTO>("CiordubDTO", null); }
            set { setAttrVal<CiordubDTO>("CiordubDTO", value); }
        }


        /// <summary>
        /// 医疗单URL
        /// </summary>
        public string Funcclassstr {
            get { return getAttrVal<string>("Funcclassstr", null); }
            set { setAttrVal<string>("Funcclassstr", value); }
        }

        /// <summary>
        /// 医疗单
        /// </summary>
        public string Id_srvof {
            get { return getAttrVal<string>("Id_srvof", null); }
            set { setAttrVal<string>("Id_srvof", value); }
        }
        /// <summary>
        /// 诊断名称拼接
        /// </summary>
        public string Str_name_di
        {
            get { return getAttrVal<string>("Str_name_di", null); }
            set { setAttrVal<string>("Str_name_di", value); }
        }
        /// <summary>
        /// 诊断编码拼接
        /// </summary>
        public string Str_code_di
        {
            get { return getAttrVal<string>("Str_code_di", null); }
            set { setAttrVal<string>("Str_code_di", value); }
        }

        /// <summary>
        /// 临床诊断id拼接
        /// </summary>
        public string Str_id_diitm
        {
            get { return getAttrVal<string>("Str_id_diitm", null); }
            set { setAttrVal<string>("Str_id_diitm", value); }
        }
        /// <summary>
        /// 临床诊断子项目id
        /// </summary>
        public string Id_diitm
        {
            get { return getAttrVal<string>("Id_diitm", null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }
        public string Str_id_di 
        {
            get { return getAttrVal<string>("Str_id_di", null); }
            set { setAttrVal<string>("Str_id_di", value); }
        }
        /// <summary>
        /// 医保适应症判断标识枚举
        /// </summary>
        public int? Eu_hpindicjudge
        {
            get { return getAttrVal<int?>("Eu_hpindicjudge", null); }
            set { setAttrVal<int?>("Eu_hpindicjudge", value); }
        }

        /// <summary>
        /// 非径内医嘱判断标识枚
        /// </summary>
        public int? Eu_uncporjudge
        {
            get { return getAttrVal<int?>("Eu_uncporjudge", 0); }
            set { setAttrVal<int?>("Eu_uncporjudge", value); }
        }

        /// <summary>
        /// 径外医嘱使用说明
        /// </summary>
        public string Reason_uncporuse
        {
            get { return getAttrVal<string>("Reason_uncporuse", null); }
            set { setAttrVal<string>("Reason_uncporuse", value); }
        }

        /// <summary>
        /// 患者入径标识
        /// </summary>
        public string Fg_cp
        {
            get { return getAttrVal<string>("Fg_cp", null); }
            set { setAttrVal<string>("Fg_cp", value); }
        }

        /// <summary>
        /// 医嘱目的
        /// </summary>
        public string  Purpose_or
        {
            get { return getAttrVal<string>("Purpose_or", null); }
            set { setAttrVal<string>("Purpose_or", value); }
        }
        /// <summary>
        /// 总次数
        /// </summary>
        public int? Times_cur
        {
            get { return getAttrVal<int?>("Times_cur", null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }
        /// <summary>
        /// 医嘱天数
        /// </summary>
        public int? Days_or
        {
            get { return getAttrVal<int?>("Days_or", null); }
            set { setAttrVal<int?>("Days_or", value); }
        }
        /// <summary>
        /// 开始日期
        /// </summary>
        public DateTime? Dt_begin_ui
        {
            get { return getAttrVal<FDateTime>("Dt_begin_ui", null); }
            set { setAttrVal<FDateTime>("Dt_begin_ui", value); }
        }

        /// <summary>
        /// 结束日期
        /// </summary>
        public DateTime? Dt_end_ui
        {
            get { return getAttrVal<FDateTime>("Dt_end_ui", null); }
            set { setAttrVal<FDateTime>("Dt_end_ui", value); }
        }
        /// <summary>
        /// 在院执行次数
        /// </summary>
        public int? Times_mp_in
        {
            get { return getAttrVal<int?>("Times_mp_in", null); }
            set { setAttrVal<int?>("Times_mp_in", value); }
        }
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName() {
            return "iih.ci.ord.ciordems.d.EmsUIDTO";
        }

    
    }
}
