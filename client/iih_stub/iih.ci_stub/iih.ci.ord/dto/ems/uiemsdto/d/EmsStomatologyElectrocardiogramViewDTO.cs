using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ems.uiemsdto.d
{
    /// <summary>
    /// EmsStomatologyElectrocardiogramViewDTO 的摘要说明。
    /// </summary>
    public class EmsStomatologyElectrocardiogramViewDTO : BaseDTO {

        public EmsStomatologyElectrocardiogramViewDTO() {
 
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
        /// 计划检查时间
        /// </summary>
		public DateTime? Dt_plan {
            get { return getAttrVal<FDateTime>("Dt_plan",null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 申请单号
        /// </summary>
		public string No_applyform {
            get { return getAttrVal<string>("No_applyform",null); }
            set { setAttrVal<string>("No_applyform", value); }
        }

        /// <summary>
        /// 检查目的ID
        /// </summary>
		public string Id_pps {
            get { return getAttrVal<string>("Id_pps",null); }
            set { setAttrVal<string>("Id_pps", value); }
        }

        /// <summary>
        /// 检查目的SD
        /// </summary>
		public string Sd_pps {
            get { return getAttrVal<string>("Sd_pps",null); }
            set { setAttrVal<string>("Sd_pps", value); }
        }

        /// <summary>
        /// 检查目的
        /// </summary>
		public string Name_pps {
            get { return getAttrVal<string>("Name_pps",null); }
            set { setAttrVal<string>("Name_pps", value); }
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
        /// 临床症状体征
        /// </summary>
		public string Clinicalzztz {
            get { return getAttrVal<string>("Clinicalzztz",null); }
            set { setAttrVal<string>("Clinicalzztz", value); }
        }

        /// <summary>
        /// 套内明细
        /// </summary>
		public string Setitem {
            get { return getAttrVal<string>("Setitem",null); }
            set { setAttrVal<string>("Setitem", value); }
        }

        /// <summary>
        /// 心电图结果（def1）
        /// </summary>
		public string Eegresult {
            get { return getAttrVal<string>("Eegresult",null); }
            set { setAttrVal<string>("Eegresult", value); }
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
		public FArrayList Emsrisviewitems {
            get { return getAttrVal<FArrayList>("Emsrisviewitems",null); }
            set { setAttrVal<FArrayList>("Emsrisviewitems", value); }
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
            return new string[]{ "Id_or", "Id_srv", "Name_srv", "Fg_urgent", "Price", "Sd_srvtp", "Id_dep_mp", "Name_dep_mp", "Filter_dep_mp", "Dt_plan", "No_applyform", "Id_pps", "Sd_pps", "Name_pps", "Id_di", "Name_di", "Clinicalzztz", "Setitem", "Eegresult", "Sv", "Fg_set", "Emsrisviewitems", "Fg_radio"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ems.uiemsdto.d.EmsStomatologyElectrocardiogramViewDTO";
        }
    }
}
