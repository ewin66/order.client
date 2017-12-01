using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsDrugsViewDTO 的摘要说明。
    /// </summary>
    public class EmsDrugsViewDTO : BaseDTO {

        public EmsDrugsViewDTO() {
 
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
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }

        /// <summary>
        /// 次数
        /// </summary>
		public int? Times_cur {
            get { return getAttrVal<int?>("Times_cur",null); }
            set { setAttrVal<int?>("Times_cur", value); }
        }

        /// <summary>
        /// 领量
        /// </summary>
		public int? Availabledays {
            get { return getAttrVal<int?>("Availabledays",null); }
            set { setAttrVal<int?>("Availabledays", value); }
        }

        /// <summary>
        /// 西药药品
        /// </summary>
		public FArrayList Emsdrugsviewitems {
            get { return getAttrVal<FArrayList>("Emsdrugsviewitems",null); }
            set { setAttrVal<FArrayList>("Emsdrugsviewitems", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Sd_srvtp", "Id_freq", "Name_freq", "Freqct", "Id_routedes", "Name_routedes", "Usedays", "Fg_times_in", "Times_in", "Des_or", "Sv", "Times_cur", "Availabledays", "Emsdrugsviewitems"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsDrugsViewDTO";
        }
    }
}
