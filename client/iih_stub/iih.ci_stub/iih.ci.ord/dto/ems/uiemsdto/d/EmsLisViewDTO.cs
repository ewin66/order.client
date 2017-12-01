using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsLisViewDTO 的摘要说明。
    /// </summary>
    public class EmsLisViewDTO : BaseDTO {

        public EmsLisViewDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务id
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
        /// 明细
        /// </summary>
		public string Details {
            get { return getAttrVal<string>("Details",null); }
            set { setAttrVal<string>("Details", value); }
        }

        /// <summary>
        /// 标本类型ID
        /// </summary>
		public string Id_samptp {
            get { return getAttrVal<string>("Id_samptp",null); }
            set { setAttrVal<string>("Id_samptp", value); }
        }

        /// <summary>
        /// 标本类型SD
        /// </summary>
		public string Sd_samptp {
            get { return getAttrVal<string>("Sd_samptp",null); }
            set { setAttrVal<string>("Sd_samptp", value); }
        }

        /// <summary>
        /// 标本类型名称
        /// </summary>
		public string Name_samptp {
            get { return getAttrVal<string>("Name_samptp",null); }
            set { setAttrVal<string>("Name_samptp", value); }
        }

        /// <summary>
        /// 标本采集时间ID
        /// </summary>
		public string Id_sampcoltime {
            get { return getAttrVal<string>("Id_sampcoltime",null); }
            set { setAttrVal<string>("Id_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间
        /// </summary>
		public string Name_sampcoltime {
            get { return getAttrVal<string>("Name_sampcoltime",null); }
            set { setAttrVal<string>("Name_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时间类型ID
        /// </summary>
		public string Id_sampcollecttimetp {
            get { return getAttrVal<string>("Id_sampcollecttimetp",null); }
            set { setAttrVal<string>("Id_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 标本采集时间类型编码
        /// </summary>
		public string Sd_sampcollecttimetp {
            get { return getAttrVal<string>("Sd_sampcollecttimetp",null); }
            set { setAttrVal<string>("Sd_sampcollecttimetp", value); }
        }

        /// <summary>
        /// 标本采集时长
        /// </summary>
		public string Len_sampcoltime {
            get { return getAttrVal<string>("Len_sampcoltime",null); }
            set { setAttrVal<string>("Len_sampcoltime", value); }
        }

        /// <summary>
        /// 标本采集时长单位
        /// </summary>
		public string Id_unit_sampcoltime {
            get { return getAttrVal<string>("Id_unit_sampcoltime",null); }
            set { setAttrVal<string>("Id_unit_sampcoltime", value); }
        }

        /// <summary>
        /// 加急标识
        /// </summary>
		public bool? Fg_urgent {
            get { return getAttrVal<FBoolean>("Fg_urgent",null); }
            set { setAttrVal<FBoolean>("Fg_urgent", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
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
        /// 单价
        /// </summary>
		public FDouble Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 临床诊断ID
        /// </summary>
		public string Id_di {
            get { return getAttrVal<string>("Id_di",null); }
            set { setAttrVal<string>("Id_di", value); }
        }

        /// <summary>
        /// 临床诊断
        /// </summary>
		public string Name_di {
            get { return getAttrVal<string>("Name_di",null); }
            set { setAttrVal<string>("Name_di", value); }
        }

        /// <summary>
        /// 诊断子项ID
        /// </summary>
		public string Id_diitm {
            get { return getAttrVal<string>("Id_diitm",null); }
            set { setAttrVal<string>("Id_diitm", value); }
        }

        /// <summary>
        /// 检验时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 备注
        /// </summary>
		public string Announcements {
            get { return getAttrVal<string>("Announcements",null); }
            set { setAttrVal<string>("Announcements", value); }
        }

        /// <summary>
        /// sv
        /// </summary>
		public string Sv {
            get { return getAttrVal<string>("Sv",null); }
            set { setAttrVal<string>("Sv", value); }
        }

        /// <summary>
        /// 服务套标识
        /// </summary>
		public bool? Fg_set {
            get { return getAttrVal<FBoolean>("Fg_set",null); }
            set { setAttrVal<FBoolean>("Fg_set", value); }
        }

        /// <summary>
        /// 套内项目
        /// </summary>
		public FArrayList Emslisviewitem {
            get { return getAttrVal<FArrayList>("Emslisviewitem",null); }
            set { setAttrVal<FArrayList>("Emslisviewitem", value); }
        }

        /// <summary>
        /// 单选标识
        /// </summary>
		public bool? Fg_radio {
            get { return getAttrVal<FBoolean>("Fg_radio",null); }
            set { setAttrVal<FBoolean>("Fg_radio", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Sd_srvtp", "Id_srv", "Name_srv", "Details", "Id_samptp", "Sd_samptp", "Name_samptp", "Id_sampcoltime", "Name_sampcoltime", "Id_sampcollecttimetp", "Sd_sampcollecttimetp", "Len_sampcoltime", "Id_unit_sampcoltime", "Fg_urgent", "No_applyform", "Id_dep_mp", "Name_dep_mp", "Price", "Id_di", "Name_di", "Id_diitm", "Dt_plan", "Announcements", "Sv", "Fg_set", "Emslisviewitem", "Fg_radio"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsLisViewDTO";
        }
    }
}
