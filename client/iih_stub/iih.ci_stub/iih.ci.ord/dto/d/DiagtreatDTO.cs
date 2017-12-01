using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// DiagtreatDTO 的摘要说明。
    /// </summary>
    public class DiagtreatDTO : BaseDTO {

        public DiagtreatDTO() {
 
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱生效日期
        /// </summary>
		public DateTime? Dt_effe {
            get { return getAttrVal<FDateTime>("Dt_effe",null); }
            set { setAttrVal<FDateTime>("Dt_effe", value); }
        }

        /// <summary>
        /// 医嘱结束时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 出院带药标志
        /// </summary>
		public bool? Fg_pres_outp {
            get { return getAttrVal<FBoolean>("Fg_pres_outp",null); }
            set { setAttrVal<FBoolean>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 婴儿标志
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
        /// 长临标志
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 医嘱内容 
        /// </summary>
		public string Content_or {
            get { return getAttrVal<string>("Content_or",null); }
            set { setAttrVal<string>("Content_or", value); }
        }

        /// <summary>
        /// 服务类型 
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 服务项目
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 医嘱服务项目ID
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 服务项目分类
        /// </summary>
		public string Id_srvca {
            get { return getAttrVal<string>("Id_srvca",null); }
            set { setAttrVal<string>("Id_srvca", value); }
        }

        /// <summary>
        /// 服务项目名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 服务编码
        /// </summary>
		public string Code_srv {
            get { return getAttrVal<string>("Code_srv",null); }
            set { setAttrVal<string>("Code_srv", value); }
        }

        /// <summary>
        /// 物品标志
        /// </summary>
		public bool? Fg_mm {
            get { return getAttrVal<FBoolean>("Fg_mm",null); }
            set { setAttrVal<FBoolean>("Fg_mm", value); }
        }

        /// <summary>
        /// 数值_医学单位
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 医学单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 医嘱标志
        /// </summary>
		public bool? Fg_or {
            get { return getAttrVal<FBoolean>("Fg_or",null); }
            set { setAttrVal<FBoolean>("Fg_or", value); }
        }

        /// <summary>
        /// 不规则剂量标志
        /// </summary>
		public bool? Fg_dose_anoma {
            get { return getAttrVal<FBoolean>("Fg_dose_anoma",null); }
            set { setAttrVal<FBoolean>("Fg_dose_anoma", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 最近生成日期时间
        /// </summary>
		public DateTime? Dt_last_bl {
            get { return getAttrVal<FDateTime>("Dt_last_bl",null); }
            set { setAttrVal<FDateTime>("Dt_last_bl", value); }
        }

        /// <summary>
        /// 频次周期类型
        /// </summary>
		public string Sd_frequnitct {
            get { return getAttrVal<string>("Sd_frequnitct",null); }
            set { setAttrVal<string>("Sd_frequnitct", value); }
        }

        /// <summary>
        /// 频次周期数
        /// </summary>
		public string Frequnitct {
            get { return getAttrVal<string>("Frequnitct",null); }
            set { setAttrVal<string>("Frequnitct", value); }
        }

        /// <summary>
        /// 频次周期下次数
        /// </summary>
		public string Freqct {
            get { return getAttrVal<string>("Freqct",null); }
            set { setAttrVal<string>("Freqct", value); }
        }

        /// <summary>
        /// 医嘱单标志
        /// </summary>
		public bool? Fg_or_form {
            get { return getAttrVal<FBoolean>("Fg_or_form",null); }
            set { setAttrVal<FBoolean>("Fg_or_form", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Dt_effe", "Dt_end", "Fg_pres_outp", "Fg_bb", "No_bb", "Fg_long", "Id_freq", "Content_or", "Sd_srvtp", "Id_srv", "Id_orsrv", "Id_srvca", "Name", "Code_srv", "Fg_mm", "Quan_medu", "Id_medu", "Fg_or", "Fg_dose_anoma", "Id_route", "Dt_last_bl", "Sd_frequnitct", "Frequnitct", "Freqct", "Fg_or_form"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.DiagtreatDTO";
        }
    }
}
