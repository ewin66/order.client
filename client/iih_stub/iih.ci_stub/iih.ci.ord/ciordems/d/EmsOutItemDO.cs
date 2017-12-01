using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// EmsOutItemDO 的摘要说明。
    /// </summary>
    public class EmsOutItemDO : OrCommonFieldsDTO{

        public EmsOutItemDO() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_emsapout {
            get { return getAttrVal<string>("Id_emsapout",null); }
            set { setAttrVal<string>("Id_emsapout", value); }
        }

        /// <summary>
        /// displaynam14
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// displaynam15
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 出院科室id
        /// </summary>
		public string Id_dep_out {
            get { return getAttrVal<string>("Id_dep_out",null); }
            set { setAttrVal<string>("Id_dep_out", value); }
        }

        /// <summary>
        /// 出院科室
        /// </summary>
		public string Name_dep_out {
            get { return getAttrVal<string>("Name_dep_out",null); }
            set { setAttrVal<string>("Name_dep_out", value); }
        }

        /// <summary>
        /// 出院病区id
        /// </summary>
		public string Id_dep_nur_out {
            get { return getAttrVal<string>("Id_dep_nur_out",null); }
            set { setAttrVal<string>("Id_dep_nur_out", value); }
        }

        /// <summary>
        /// 出院病区
        /// </summary>
		public string Name_dep_nur_out {
            get { return getAttrVal<string>("Name_dep_nur_out",null); }
            set { setAttrVal<string>("Name_dep_nur_out", value); }
        }

        /// <summary>
        /// 出院床位id
        /// </summary>
		public string Id_bed_out {
            get { return getAttrVal<string>("Id_bed_out",null); }
            set { setAttrVal<string>("Id_bed_out", value); }
        }

        /// <summary>
        /// 出院床位
        /// </summary>
		public string Name_bde_out {
            get { return getAttrVal<string>("Name_bde_out",null); }
            set { setAttrVal<string>("Name_bde_out", value); }
        }

        /// <summary>
        /// 31日再入院计划
        /// </summary>
		public bool? Fg_again31 {
            get { return getAttrVal<FBoolean>("Fg_again31",null); }
            set { setAttrVal<FBoolean>("Fg_again31", value); }
        }

        /// <summary>
        /// 31日再入院目的
        /// </summary>
		public string Des_again31 {
            get { return getAttrVal<string>("Des_again31",null); }
            set { setAttrVal<string>("Des_again31", value); }
        }

        /// <summary>
        /// 离院方式id
        /// </summary>
		public string Id_outtp {
            get { return getAttrVal<string>("Id_outtp",null); }
            set { setAttrVal<string>("Id_outtp", value); }
        }

        /// <summary>
        /// 离院方式编码
        /// </summary>
		public string Sd_outtp {
            get { return getAttrVal<string>("Sd_outtp",null); }
            set { setAttrVal<string>("Sd_outtp", value); }
        }

        /// <summary>
        /// 离院方式
        /// </summary>
		public string Name_outtp {
            get { return getAttrVal<string>("Name_outtp",null); }
            set { setAttrVal<string>("Name_outtp", value); }
        }

        /// <summary>
        /// 离院描述
        /// </summary>
		public string Des_outtp {
            get { return getAttrVal<string>("Des_outtp",null); }
            set { setAttrVal<string>("Des_outtp", value); }
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
        /// sv
        /// </summary>
        public DateTime? Sv
        {
            get { return getAttrVal<FDateTime>("Sv", null); }
            set { setAttrVal<FDateTime>("Sv", value); }
        }

        /// <summary>
        /// 出院时间
        /// </summary>
        public DateTime? Dt_out
        {
            get { return getAttrVal<FDateTime>("Dt_out", null); }
            set { setAttrVal<FDateTime>("Dt_out", value); }
        }

        /// <summary>
        /// 是否死亡
        /// </summary>
        public bool? Fg_death
        {
            get { return getAttrVal<FBoolean>("Fg_death", false); }
            set { setAttrVal<FBoolean>("Fg_death", value); }
        }

        /// <summary>
        /// 死亡尸检标识
        /// </summary>
        public bool? Fg_autopsy
        {
            get { return getAttrVal<FBoolean>("Fg_autopsy", false); }
            set { setAttrVal<FBoolean>("Fg_autopsy", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_emsapout", "Id_or", "Id_orsrv", "Id_dep_out", "Name_dep_out", "Id_dep_nur_out", "Name_dep_nur_out", "Id_bed_out", "Name_bde_out", "Fg_again31", "Des_again31", "Id_outtp", "Sd_outtp", "Name_outtp", "Des_outtp", "Sv", "Dt_out", "Fg_death", "Fg_autopsy" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.EmsOutItemDO";
        }
    }
}
