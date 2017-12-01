using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsTransItemDO 的摘要说明。
    /// </summary>
    public class EmsTransItemDO : OrCommonFieldsDTO{

        public EmsTransItemDO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_emsaptrans {
            get { return getAttrVal<string>("Id_emsaptrans",null); }
            set { setAttrVal<string>("Id_emsaptrans", value); }
        }

        /// <summary>
        /// displaynam8
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// displaynam9
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 转科/跨科
        /// </summary>
		public bool? Fg_tech_trans {
            get { return getAttrVal<FBoolean>("Fg_tech_trans",null); }
            set { setAttrVal<FBoolean>("Fg_tech_trans", value); }
        }

        /// <summary>
        /// 目标科室id
        /// </summary>
		public string Id_dep_to {
            get { return getAttrVal<string>("Id_dep_to",null); }
            set { setAttrVal<string>("Id_dep_to", value); }
        }

        /// <summary>
        /// 目标科室
        /// </summary>
		public string Name_dep_to {
            get { return getAttrVal<string>("Name_dep_to",null); }
            set { setAttrVal<string>("Name_dep_to", value); }
        }

        /// <summary>
        /// 目标病区
        /// </summary>
		public string Name_dep_nur_to {
            get { return getAttrVal<string>("Name_dep_nur_to",null); }
            set { setAttrVal<string>("Name_dep_nur_to", value); }
        }

        /// <summary>
        /// 目标病区id
        /// </summary>
		public string Id_dep_nur_to {
            get { return getAttrVal<string>("Id_dep_nur_to",null); }
            set { setAttrVal<string>("Id_dep_nur_to", value); }
        }

        /// <summary>
        /// 转科原因
        /// </summary>
		public string Des_rea_canc {
            get { return getAttrVal<string>("Des_rea_canc",null); }
            set { setAttrVal<string>("Des_rea_canc", value); }
        }

        /// <summary>
        /// 原科室
        /// </summary>
		public string Id_dep_from {
            get { return getAttrVal<string>("Id_dep_from",null); }
            set { setAttrVal<string>("Id_dep_from", value); }
        }

        /// <summary>
        /// 原病区
        /// </summary>
		public string Id_dep_nur_from {
            get { return getAttrVal<string>("Id_dep_nur_from",null); }
            set { setAttrVal<string>("Id_dep_nur_from", value); }
        }

        /// <summary>
        /// 转科状态
        /// </summary>
		public string Id_su_trans {
            get { return getAttrVal<string>("Id_su_trans",null); }
            set { setAttrVal<string>("Id_su_trans", value); }
        }

        /// <summary>
        /// 转科状态编码
        /// </summary>
		public string Sd_su_trans {
            get { return getAttrVal<string>("Sd_su_trans",null); }
            set { setAttrVal<string>("Sd_su_trans", value); }
        }

        /// <summary>
        /// 申请时间
        /// </summary>
		public DateTime? Dt_trans_apply {
            get { return getAttrVal<FDateTime>("Dt_trans_apply",null); }
            set { setAttrVal<FDateTime>("Dt_trans_apply", value); }
        }
        /// <summary>
        /// 跨科生效时间
        /// </summary>
        public DateTime? Dt_effe
        {
            get { return getAttrVal<FDateTime>("Dt_effe", null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }
        /// <summary>
        /// 跨科失效时间
        /// </summary>
        public DateTime? Dt_end
        {
            get { return getAttrVal<FDateTime>("Dt_end", null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 版本号
        /// </summary>
		public DateTime? Sv {
            get { return getAttrVal<FDateTime>("Sv",null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 服务内部编码
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
            get { return getAttrVal<bool?>("Fg_syncfee", null); }
            set { setAttrVal<bool?>("Fg_syncfee", value); }
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
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_emsaptrans", "Id_or", "Id_orsrv", "Fg_tech_trans", "Id_dep_to", "Name_dep_to", "Name_dep_nur_to", "Id_dep_nur_to", "Des_rea_canc", "Id_dep_from", "Id_dep_nur_from", "Id_su_trans", "Sd_su_trans", "Dt_trans_apply", "Sv", "Fg_selfpay" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsTransItemDO";
        }
    }
}
