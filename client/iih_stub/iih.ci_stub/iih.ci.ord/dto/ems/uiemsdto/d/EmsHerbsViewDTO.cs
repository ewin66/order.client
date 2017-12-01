using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsHerbsViewDTO 的摘要说明。
    /// </summary>
    public class EmsHerbsViewDTO : BaseDTO {

        public EmsHerbsViewDTO() {
 
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
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 频次ID
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 频次数量
        /// </summary>
		public string Freqct {
            get { return getAttrVal<string>("Freqct",null); }
            set { setAttrVal<string>("Freqct", value); }
        }

        /// <summary>
        /// 用法要求ID
        /// </summary>
		public string Id_routedes {
            get { return getAttrVal<string>("Id_routedes",null); }
            set { setAttrVal<string>("Id_routedes", value); }
        }

        /// <summary>
        /// 用法要求
        /// </summary>
		public string Name_routedes {
            get { return getAttrVal<string>("Name_routedes",null); }
            set { setAttrVal<string>("Name_routedes", value); }
        }

        /// <summary>
        /// 处置周期
        /// </summary>
		public string Usedays {
            get { return getAttrVal<string>("Usedays",null); }
            set { setAttrVal<string>("Usedays", value); }
        }

        /// <summary>
        /// 在院执行标识
        /// </summary>
		public bool? Fg_times_in {
            get { return getAttrVal<FBoolean>("Fg_times_in",null); }
            set { setAttrVal<FBoolean>("Fg_times_in", value); }
        }

        /// <summary>
        /// 在院执行次数
        /// </summary>
		public string Times_in {
            get { return getAttrVal<string>("Times_in",null); }
            set { setAttrVal<string>("Times_in", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Des_or {
            get { return getAttrVal<string>("Des_or",null); }
            set { setAttrVal<string>("Des_or", value); }
        }

        /// <summary>
        /// 煎法ID
        /// </summary>
		public string Id_boil {
            get { return getAttrVal<string>("Id_boil",null); }
            set { setAttrVal<string>("Id_boil", value); }
        }

        /// <summary>
        /// 煎法
        /// </summary>
		public string Name_boil {
            get { return getAttrVal<string>("Name_boil",null); }
            set { setAttrVal<string>("Name_boil", value); }
        }

        /// <summary>
        /// 煎法过滤条件
        /// </summary>
		public string Filter_boil {
            get { return getAttrVal<string>("Filter_boil",null); }
            set { setAttrVal<string>("Filter_boil", value); }
        }

        /// <summary>
        /// 用法ID
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 用法过滤条件
        /// </summary>
		public string Filter_route {
            get { return getAttrVal<string>("Filter_route",null); }
            set { setAttrVal<string>("Filter_route", value); }
        }

        /// <summary>
        /// 代加工
        /// </summary>
		public bool? Fg_boil {
            get { return getAttrVal<FBoolean>("Fg_boil",null); }
            set { setAttrVal<FBoolean>("Fg_boil", value); }
        }

        /// <summary>
        /// 外配药
        /// </summary>
		public bool? Fg_extdispense {
            get { return getAttrVal<FBoolean>("Fg_extdispense",null); }
            set { setAttrVal<FBoolean>("Fg_extdispense", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }

        /// <summary>
        /// 次数
        /// </summary>
		public string Times_cur {
            get { return getAttrVal<string>("Times_cur",null); }
            set { setAttrVal<string>("Times_cur", value); }
        }

        /// <summary>
        /// 领量
        /// </summary>
		public string Availabledays {
            get { return getAttrVal<string>("Availabledays",null); }
            set { setAttrVal<string>("Availabledays", value); }
        }

        /// <summary>
        /// 草药药品
        /// </summary>
		public FArrayList Emsherbsviewitems {
            get { return getAttrVal<FArrayList>("Emsherbsviewitems",null); }
            set { setAttrVal<FArrayList>("Emsherbsviewitems", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Sd_srvtp", "Id_freq", "Name_freq", "Freqct", "Id_routedes", "Name_routedes", "Usedays", "Fg_times_in", "Times_in", "Des_or", "Id_boil", "Name_boil", "Filter_boil", "Id_route", "Name_route", "Filter_route", "Fg_boil", "Fg_extdispense", "Sv", "Times_cur", "Availabledays", "Emsherbsviewitems"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsHerbsViewDTO";
        }
    }
}
