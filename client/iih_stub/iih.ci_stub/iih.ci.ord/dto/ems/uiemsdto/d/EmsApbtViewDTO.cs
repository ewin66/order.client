using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsApbtViewDTO 的摘要说明。
    /// </summary>
    public class EmsApbtViewDTO : BaseDTO {

        public EmsApbtViewDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务ID
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 处置项目
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 输血成分ID
        /// </summary>
		public string Id_srv_set {
            get { return getAttrVal<string>("Id_srv_set",null); }
            set { setAttrVal<string>("Id_srv_set", value); }
        }

        /// <summary>
        /// 输血成分
        /// </summary>
		public string Name_srv_set {
            get { return getAttrVal<string>("Name_srv_set",null); }
            set { setAttrVal<string>("Name_srv_set", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 单价
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 执行科室ID
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 执行科室过滤条件
        /// </summary>
		public string Filter_dep_mp {
            get { return getAttrVal<string>("Filter_dep_mp",null); }
            set { setAttrVal<string>("Filter_dep_mp", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 备血用量
        /// </summary>
		public string Quan_med {
            get { return getAttrVal<string>("Quan_med",null); }
            set { setAttrVal<string>("Quan_med", value); }
        }

        /// <summary>
        /// 计划用血时间
        /// </summary>
		public DateTime? Dt_bt_pl {
            get { return getAttrVal<FDateTime>("Dt_bt_pl",null); }
            set { setAttrVal<FDateTime>("Dt_bt_pl", value); }
        }

        /// <summary>
        /// 输血需求状态ID
        /// </summary>
		public string Id_demandsu_bt {
            get { return getAttrVal<string>("Id_demandsu_bt",null); }
            set { setAttrVal<string>("Id_demandsu_bt", value); }
        }

        /// <summary>
        /// 输血需求状态SD
        /// </summary>
		public string Sd_demandsu_bt {
            get { return getAttrVal<string>("Sd_demandsu_bt",null); }
            set { setAttrVal<string>("Sd_demandsu_bt", value); }
        }

        /// <summary>
        /// 输血需求状态
        /// </summary>
		public string Name_demandsu_bt {
            get { return getAttrVal<string>("Name_demandsu_bt",null); }
            set { setAttrVal<string>("Name_demandsu_bt", value); }
        }

        /// <summary>
        /// 诊断ID
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
        /// 用血目的ID
        /// </summary>
		public string Id_pps_bt {
            get { return getAttrVal<string>("Id_pps_bt",null); }
            set { setAttrVal<string>("Id_pps_bt", value); }
        }

        /// <summary>
        /// 用血目的SD
        /// </summary>
		public string Sd_pps_bt {
            get { return getAttrVal<string>("Sd_pps_bt",null); }
            set { setAttrVal<string>("Sd_pps_bt", value); }
        }

        /// <summary>
        /// 用血目的
        /// </summary>
		public string Name_pps_bt {
            get { return getAttrVal<string>("Name_pps_bt",null); }
            set { setAttrVal<string>("Name_pps_bt", value); }
        }

        /// <summary>
        /// 预定输血方式ID
        /// </summary>
		public string Id_mode_bt {
            get { return getAttrVal<string>("Id_mode_bt",null); }
            set { setAttrVal<string>("Id_mode_bt", value); }
        }

        /// <summary>
        /// 预定输血方式SD
        /// </summary>
		public string Sd_mode_bt {
            get { return getAttrVal<string>("Sd_mode_bt",null); }
            set { setAttrVal<string>("Sd_mode_bt", value); }
        }

        /// <summary>
        /// 预定输血方式
        /// </summary>
		public string Name_mode_bt {
            get { return getAttrVal<string>("Name_mode_bt",null); }
            set { setAttrVal<string>("Name_mode_bt", value); }
        }

        /// <summary>
        /// 输血史ID
        /// </summary>
		public string Id_his_bt {
            get { return getAttrVal<string>("Id_his_bt",null); }
            set { setAttrVal<string>("Id_his_bt", value); }
        }

        /// <summary>
        /// 输血史SD
        /// </summary>
		public string Sd_his_bt {
            get { return getAttrVal<string>("Sd_his_bt",null); }
            set { setAttrVal<string>("Sd_his_bt", value); }
        }

        /// <summary>
        /// 输血史
        /// </summary>
		public string Name_his_bt {
            get { return getAttrVal<string>("Name_his_bt",null); }
            set { setAttrVal<string>("Name_his_bt", value); }
        }

        /// <summary>
        /// 孕
        /// </summary>
		public int? Pregnant_num {
            get { return getAttrVal<int?>("Pregnant_num",null); }
            set { setAttrVal<int?>("Pregnant_num", value); }
        }

        /// <summary>
        /// 产
        /// </summary>
		public int? Parturition_cnt {
            get { return getAttrVal<int?>("Parturition_cnt",null); }
            set { setAttrVal<int?>("Parturition_cnt", value); }
        }

        /// <summary>
        /// 献血史
        /// </summary>
		public bool? Fg_db {
            get { return getAttrVal<FBoolean>("Fg_db",null); }
            set { setAttrVal<FBoolean>("Fg_db", value); }
        }

        /// <summary>
        /// 献血证号
        /// </summary>
		public string No_db {
            get { return getAttrVal<string>("No_db",null); }
            set { setAttrVal<string>("No_db", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Id_srv_set", "Name_srv_set", "Fg_urgent", "Price", "Sd_srvtp", "Id_dep_mp", "Name_dep_mp", "Filter_dep_mp", "Des_or", "Quan_med", "Dt_bt_pl", "Id_demandsu_bt", "Sd_demandsu_bt", "Name_demandsu_bt", "Id_di", "Name_di", "Id_pps_bt", "Sd_pps_bt", "Name_pps_bt", "Id_mode_bt", "Sd_mode_bt", "Name_mode_bt", "Id_his_bt", "Sd_his_bt", "Name_his_bt", "Pregnant_num", "Parturition_cnt", "Fg_db", "No_db", "Sv"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsApbtViewDTO";
        }
    }
}
