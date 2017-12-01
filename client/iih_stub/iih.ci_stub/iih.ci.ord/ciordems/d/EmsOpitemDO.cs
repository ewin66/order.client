using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using xap.rui.appfw;
using iih.ci.ord.cior.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsOpitemDO 的摘要说明。
    /// </summary>
    public partial class EmsOpitemDO
    {

        public EmsOpitemDO()
        {

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
        /// 诊断名称拼接
        /// </summary>
		public string Str_name_di
        {
            get { return getAttrVal<string>("Str_name_di", null); }
            set { setAttrVal<string>("Str_name_di", value); }
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
        /// 诊断子项目id
        /// </summary>
		public string Id_diitm
        {
            get { return getAttrVal<string>("Id_diitm", null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 诊断id
        /// </summary>
		public string Id_di
        {
            get { return getAttrVal<string>("Id_di", null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 诊断名称
        /// </summary>
		public string Name_diag
        {
            get { return getAttrVal<string>("Name_diag", null); }
            set { setAttrVal<string>("Name_diag", value); }
        }

        /// <summary>
        /// 手术申请单主键
        /// </summary>
		public string Id_emsopitem
        {
            get { return getAttrVal<string>("Id_emsopitem", null); }
            set { setAttrVal<string>("Id_emsopitem", value); }
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// displaynam48
        /// </summary>
		public string Id_orsrv
        {
            get { return getAttrVal<string>("Id_orsrv", null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
		public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 手术名称
        /// </summary>
		public string Name_srv
        {
            get { return getAttrVal<string>("Name_srv", null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_applyform
        {
            get { return getAttrVal<string>("No_applyform", null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

        /// <summary>
        /// 手术编码
        /// </summary>
		public string Code_srv
        {
            get { return getAttrVal<string>("Code_srv", null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 急诊手术
        /// </summary>
		public bool? Fg_er_sug
        {
            get { return getAttrVal<FBoolean>("Fg_er_sug", null); }
            set { setAttrVal<FBoolean>("Fg_er_sug", value); }
        }

        /// <summary>
        /// 限期手术
        /// </summary>
		public bool? Fg_xq_sug
        {
            get { return getAttrVal<FBoolean>("Fg_xq_sug", null); }
            set { setAttrVal<FBoolean>("Fg_xq_sug", value); }
        }

        /// <summary>
        /// 择期手术
        /// </summary>
		public bool? Fg_zq_sug
        {
            get { return getAttrVal<FBoolean>("Fg_zq_sug", null); }
            set { setAttrVal<FBoolean>("Fg_zq_sug", value); }
        }

        /// <summary>
        /// 计划手术时间
        /// </summary>
		public DateTime? Dt_plan
        {
            get { return getAttrVal<FDateTime>("Dt_plan", null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 开立日期
        /// </summary>
		public DateTime? Dt_creat
        {
            get { return getAttrVal<FDateTime>("Dt_creat", null); }
            set { setAttrVal<FDateTime>("Dt_creat", value); }
        }

        /// <summary>
        /// 执行科室id
        /// </summary>
		public string Id_mp_dep
        {
            get { return getAttrVal<string>("Id_mp_dep", null); }
            set { setAttrVal<string>("Id_mp_dep", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_mp_dep
        {
            get { return getAttrVal<string>("Name_mp_dep", null); }
            set { setAttrVal<string>("Name_mp_dep", value); }
        }

        /// <summary>
        /// 手术分级编码
        /// </summary>
		public string Sd_lvlsug
        {
            get { return getAttrVal<string>("Sd_lvlsug", null); }
            set { setAttrVal<string>("Sd_lvlsug", value); }
        }

        /// <summary>
        /// 手术分级
        /// </summary>
		public string Name_lvlsug
        {
            get { return getAttrVal<string>("Name_lvlsug", null); }
            set { setAttrVal<string>("Name_lvlsug", value); }
        }

        /// <summary>
        /// 手术分级id
        /// </summary>
		public string Id_lvlsug
        {
            get { return getAttrVal<string>("Id_lvlsug", null); }
            set { setAttrVal<string>("Id_lvlsug", value); }
        }

        /// <summary>
        /// 麻醉方式编码
        /// </summary>
		public string Sd_anestp
        {
            get { return getAttrVal<string>("Sd_anestp", null); }
            set { setAttrVal<string>("Sd_anestp", value); }
        }

        /// <summary>
        /// 麻醉方式
        /// </summary>
		public string Name_anestp
        {
            get { return getAttrVal<string>("Name_anestp", null); }
            set { setAttrVal<string>("Name_anestp", value); }
        }

        /// <summary>
        /// 麻醉方式id
        /// </summary>
		public string Id_anestp
        {
            get { return getAttrVal<string>("Id_anestp", null); }
            set { setAttrVal<string>("Id_anestp", value); }
        }

        /// <summary>
        /// 药物过敏史
        /// </summary>
		public bool? Fg_allergy
        {
            get { return getAttrVal<FBoolean>("Fg_allergy", null); }
            set { setAttrVal<FBoolean>("Fg_allergy", value); }
        }

        /// <summary>
        /// 是否开展新手术
        /// </summary>
		public bool? Fg_new_sug
        {
            get { return getAttrVal<FBoolean>("Fg_new_sug", null); }
            set { setAttrVal<FBoolean>("Fg_new_sug", value); }
        }

        /// <summary>
        /// 手术中冰冻处理
        /// </summary>
		public bool? Fg_patho
        {
            get { return getAttrVal<FBoolean>("Fg_patho", null); }
            set { setAttrVal<FBoolean>("Fg_patho", value); }
        }

        /// <summary>
        /// 预期输血量
        /// </summary>
		public FDouble Quan_bt_plan
        {
            get { return getAttrVal<FDouble>("Quan_bt_plan", null); }
            set { setAttrVal<FDouble>("Quan_bt_plan", value); }
        }

        /// <summary>
        /// 预期手术时长
        /// </summary>
		public int? Time_sup_plan
        {
            get { return getAttrVal<int?>("Time_sup_plan", null); }
            set { setAttrVal<int?>("Time_sup_plan", value); }
        }

        /// <summary>
        /// 主刀医师id
        /// </summary>
		public string Id_emp_operator
        {
            get { return getAttrVal<string>("Id_emp_operator", null); }
            set { setAttrVal<string>("Id_emp_operator", value); }
        }

        /// <summary>
        /// 主刀医师
        /// </summary>
		public string Name_emp_operator
        {
            get { return getAttrVal<string>("Name_emp_operator", null); }
            set { setAttrVal<string>("Name_emp_operator", value); }
        }

        /// <summary>
        /// 一助id
        /// </summary>
		public string Id_emp_help1
        {
            get { return getAttrVal<string>("Id_emp_help1", null); }
            set { setAttrVal<string>("Id_emp_help1", value); }
        }

        /// <summary>
        /// 一助
        /// </summary>
		public string Name_emp_help1
        {
            get { return getAttrVal<string>("Name_emp_help1", null); }
            set { setAttrVal<string>("Name_emp_help1", value); }
        }

        /// <summary>
        /// 体位编码
        /// </summary>
		public string Sd_sugbodycod
        {
            get { return getAttrVal<string>("Sd_sugbodycod", null); }
            set { setAttrVal<string>("Sd_sugbodycod", value); }
        }

        /// <summary>
        /// 体位
        /// </summary>
		public string Name_sugbodycod
        {
            get { return getAttrVal<string>("Name_sugbodycod", null); }
            set { setAttrVal<string>("Name_sugbodycod", value); }
        }

        /// <summary>
        /// 体位id
        /// </summary>
		public string Id_sugbodycod
        {
            get { return getAttrVal<string>("Id_sugbodycod", null); }
            set { setAttrVal<string>("Id_sugbodycod", value); }
        }

        /// <summary>
        /// 特殊器械
        /// </summary>
		public string Specialreq
        {
            get { return getAttrVal<string>("Specialreq", null); }
            set { setAttrVal<string>("Specialreq", value); }
        }

        /// <summary>
        /// 特殊仪器
        /// </summary>
		public string Specialinstrument
        {
            get { return getAttrVal<string>("Specialinstrument", null); }
            set { setAttrVal<string>("Specialinstrument", value); }
        }

        /// <summary>
        /// 特殊准备
        /// </summary>
		public string Specialdes
        {
            get { return getAttrVal<string>("Specialdes", null); }
            set { setAttrVal<string>("Specialdes", value); }
        }

        /// <summary>
        /// 注意事项
        /// </summary>
		public string Announcements
        {
            get { return getAttrVal<string>("Announcements", null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// 手术申请状态id
        /// </summary>
		public string Id_su
        {
            get { return getAttrVal<string>("Id_su", null); }
            set { setAttrVal<string>("Id_su", value); }
        }

        /// <summary>
        /// 手术申请状态
        /// </summary>
		public string Sd_su
        {
            get { return getAttrVal<string>("Sd_su", null); }
            set { setAttrVal<string>("Sd_su", value); }
        }

        /// <summary>
        /// 角色id
        /// </summary>
		public string Id_role
        {
            get { return getAttrVal<string>("Id_role", null); }
            set { setAttrVal<string>("Id_role", value); }
        }

        /// <summary>
        /// 角色
        /// </summary>
		public string Name_role
        {
            get { return getAttrVal<string>("Name_role", null); }
            set { setAttrVal<string>("Name_role", value); }
        }

        /// <summary>
        /// 人员id
        /// </summary>
		public string Id_emp_op
        {
            get { return getAttrVal<string>("Id_emp_op", null); }
            set { setAttrVal<string>("Id_emp_op", value); }
        }

        /// <summary>
        /// 人员名称
        /// </summary>
		public string Name_emp_op
        {
            get { return getAttrVal<string>("Name_emp_op", null); }
            set { setAttrVal<string>("Name_emp_op", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv
        {
            get { return getAttrVal<FDateTime>("Sv", null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 排序号
        /// </summary>
		public int? Sortno
        {
            get { return getAttrVal<int?>("Sortno", null); }
            set { setAttrVal<int?>("Sortno", value); }
        }

        /// <summary>
        /// 描述
        /// </summary>
		public string Des
        {
            get { return getAttrVal<string>("Des", null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 手术等级id
        /// </summary>
		public string Id_incitp
        {
            get { return getAttrVal<string>("Id_incitp", null); }
            set { setAttrVal<string>("Id_incitp", value); }
        }

        /// <summary>
        /// 手术等级编码
        /// </summary>
		public string Sd_incitp
        {
            get { return getAttrVal<string>("Sd_incitp", null); }
            set { setAttrVal<string>("Sd_incitp", value); }
        }

        /// <summary>
        /// 附加手术编码集合
        /// </summary>
		public string Code_opex_srvs
        {
            get { return getAttrVal<string>("Code_opex_srvs", null); }
            set { setAttrVal<string>("Code_opex_srvs", value); }
        }

        /// <summary>
        /// 附加手术服务id集合
        /// </summary>
		public string Id_opex_srvs
        {
            get { return getAttrVal<string>("Id_opex_srvs", null); }
            set { setAttrVal<string>("Id_opex_srvs", value); }
        }

        /// <summary>
        /// 附加手术服务名称集合
        /// </summary>
		public string Name_opex_srvs
        {
            get { return getAttrVal<string>("Name_opex_srvs", null); }
            set { setAttrVal<string>("Name_opex_srvs", value); }
        }

        /// <summary>
        /// 参考价格
        /// </summary>
		public FDouble Price
        {
            get { return getAttrVal<FDouble>("Price", null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 医学单位ID
        /// </summary>
		public string Id_unit_med
        {
            get { return getAttrVal<string>("Id_unit_med", null); }
            set { setAttrVal<string>("Id_unit_med", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Name_unit_med
        {
            get { return getAttrVal<string>("Name_unit_med", null); }
            set { setAttrVal<string>("Name_unit_med", value); }
        }

        /// <summary>
        /// 医学数量
        /// </summary>
		public FDouble Quan_med
        {
            get { return getAttrVal<FDouble>("Quan_med", null); }
            set { setAttrVal<FDouble>("Quan_med", value); }
        }

        /// <summary>
        /// 频次ID
        /// </summary>
		public string Id_freq
        {
            get { return getAttrVal<string>("Id_freq", null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
		public string Name_freq
        {
            get { return getAttrVal<string>("Name_freq", null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 频次时刻数量
        /// </summary>
		public int? Freqct
        {
            get { return getAttrVal<int?>("Freqct", null); }
            set { setAttrVal<int?>("Freqct", value); }
        }

        /// <summary>
        ///输血前检查指标
        /// </summary>
        public XapDataList<OrdApSugViewItemDO> OpLabItem
        {
            get { return getAttrVal<XapDataList<OrdApSugViewItemDO>>("OpLabItem", null); }
            set { setAttrVal<XapDataList<OrdApSugViewItemDO>>("OpLabItem", value); }
        }

        /// <summary>
        /// 手术人员集合
        /// </summary>
        public XapDataList<EmsItemInOp> OpEmpItem
        {
            get { return getAttrVal<XapDataList<EmsItemInOp>>("OpEmpItem", null); }
            set { setAttrVal<XapDataList<EmsItemInOp>>("OpEmpItem", value); }
        }

        /// <summary>
        /// 手术卫材
        /// </summary>
        public XapDataList<EmsItemInOp> OpMmItem
        {
            get { return getAttrVal<XapDataList<EmsItemInOp>>("EmsOpMms", null); }
            set { setAttrVal<XapDataList<EmsItemInOp>>("EmsOpMms", value); }
        }

        /// <summary>
        /// 手术卫材待选列表
        /// </summary>
        public XapDataList<EmsOrDrug> OpMmItemList
        {
            get { return getAttrVal<XapDataList<EmsOrDrug>>("OpMmItemList", null); }
            set { setAttrVal<XapDataList<EmsOrDrug>>("OpMmItemList", value); }
        }
        /// <summary>
        /// 附加手术
        /// </summary>
        public XapDataList<EmsItemInOp> OpAppendOpItem
        {
            get { return getAttrVal<XapDataList<EmsItemInOp>>("OpAppendOpItem", null); }
            set { setAttrVal<XapDataList<EmsItemInOp>>("OpAppendOpItem", value); }
        }

        /// <summary>
        /// 服务分类内部编码
        /// </summary>
		public string Innercode_srvca
        {
            get { return getAttrVal<string>("Innercode_srvca", null); }
            set { setAttrVal<string>("Innercode_srvca", value); }
        }

        /// <summary>
        /// 费用同步标识
        /// </summary>
		public bool? Fg_syncfee
        {
            get { return getAttrVal<FBoolean>("Fg_syncfee", null); }
            set { setAttrVal<FBoolean>("Fg_syncfee", value); }
        }

        /// <summary>
        /// 医嘱来源
        /// </summary>
		public int? Eu_sourcemd
        {
            get { return getAttrVal<int?>("Eu_sourcemd", null); }
            set { setAttrVal<int?>("Eu_sourcemd", value); }
        }

        /// <summary>
        /// 服务所属
        /// </summary>
		public string Id_srv_src
        {
            get { return getAttrVal<string>("Id_srv_src", null); }
            set { setAttrVal<string>("Id_srv_src", value); }
        }

        /// <summary>
        /// 计价方式
        /// </summary>
		public string Priby
        {
            get { return getAttrVal<string>("Priby", null); }
            set { setAttrVal<string>("Priby", value); }
        }

        /**
	 * 附加手术列表
	 * @return FArrayList
	 */
        public FArrayList OpAppendList
        {
            get { return getAttrVal<FArrayList>("OpAppendList", null); }
            set { setAttrVal<FArrayList>("OpAppendList", value); }
        }

        /**
         * 附加手术人员
         * @return FArrayList
         */
        public FArrayList OpPersonList
        {
            get { return getAttrVal<FArrayList>("OpPersonList", null); }
            set { setAttrVal<FArrayList>("OpPersonList", value); }
        }


        /**
         * 手术动态指标检查项
         * @return FArrayList
         */
        public FArrayList OpCheckIndicatorList
        {
            get { return getAttrVal<FArrayList>("OpCheckIndicatorList", null); }
            set { setAttrVal<FArrayList>("OpCheckIndicatorList", value); }
        }


        /**
         * 手术耗材列表
         * @return FArrayList
         */
        public FArrayList OpSuppliesList
        {
            get { return getAttrVal<FArrayList>("OpSuppliesList", null); }
            set { setAttrVal<FArrayList>("OpSuppliesList", value); }
        }


        /**
         * 手术药品列表
         * @return FArrayList
         */
        public FArrayList OpDrugList
        {
            get { return getAttrVal<FArrayList>("OpDrugList", null); }
            set { setAttrVal<FArrayList>("OpDrugList", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
        /// <summary>
        /// 自费标识
        /// </summary>
        public bool? Fg_selfpay
        {
            get { return getAttrVal<FBoolean>("Fg_selfpay", null); }
            set { setAttrVal<FBoolean>("Fg_selfpay", value); }
        }

        /// <summary>
        /// 记费模式
        /// </summary>
		public int? Eu_blmd
        {
            get { return getAttrVal<int?>("Eu_blmd", null); }
            set { setAttrVal<int?>("Eu_blmd", value); }
        }

        /// <summary>
        /// 麻醉分类
        /// </summary>
        public int? Eu_anesca
        {
            get { return getAttrVal<int?>("Eu_anesca", null); }
            set { setAttrVal<int?>("Eu_anesca", value); }
        }
        /// <summary>
        /// 日间手术标识
        /// </summary>
        public bool? Fg_daysug
        {
            get { return getAttrVal<FBoolean>("Fg_daysug", null); }
            set { setAttrVal<FBoolean>("Fg_daysug", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Str_code_di", "Str_name_di", "Str_id_diitm", "Id_diitm", "Id_di", "Name_diag", "Id_emsopitem", "Id_or", "Id_orsrv", "Id_srv", "Name_srv", "No_applyform", "Code_srv", "Fg_er_sug", "Fg_xq_sug", "Fg_zq_sug", "Dt_plan", "Dt_creat", "Id_mp_dep", "Name_mp_dep", "Sd_lvlsug", "Name_lvlsug", "Id_lvlsug", "Sd_anestp", "Name_anestp", "Id_anestp", "Fg_allergy", "Fg_new_sug", "Fg_patho", "Quan_bt_plan", "Time_sup_plan", "Id_emp_operator", "Name_emp_operator", "Id_emp_help1", "Name_emp_help1", "Sd_sugbodycod", "Name_sugbodycod", "Id_sugbodycod", "Specialreq", "Specialinstrument", "Specialdes", "Announcements", "Id_su", "Sd_su", "Id_role", "Name_role", "Id_emp_op", "Name_emp_op", "Sv", "Sortno", "Des", "Id_incitp", "Sd_incitp", "Code_opex_srvs", "Id_opex_srvs", "Name_opex_srvs", "Price", "Id_unit_med", "Name_unit_med", "Quan_med", "Id_freq", "Name_freq", "Freqct", "Innercode_srvca", "Fg_syncfee", "Eu_sourcemd", "Id_srv_src", "Priby", "Sd_srvtp", "Fg_selfpay", "Eu_blmd", "Eu_anesca", "Fg_daysug" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsOpitemDO";
        }
    }
}
