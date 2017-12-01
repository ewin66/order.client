using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordprintdto.d
{
    /// <summary>
    /// OrdPrintCfgDTO 的摘要说明。
    /// </summary>
    public class OrdPrintCfgDTO : BaseDTO {

        public OrdPrintCfgDTO() {
 
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 服务类型
        /// </summary>
		public string Id_srvtp {
            get { return getAttrVal<string>("Id_srvtp",null); }
            set { setAttrVal<string>("Id_srvtp", value); }
        }

        /// <summary>
        /// 服务类型编码
        /// </summary>
		public string Sd_srvtp {
            get { return getAttrVal<string>("Sd_srvtp",null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public string Fg_long {
            get { return getAttrVal<string>("Fg_long",null); }
            set { setAttrVal<string>("Fg_long", value); }
        }

        /// <summary>
        /// 服务名
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 剂量单位
        /// </summary>
		public string Medu_name {
            get { return getAttrVal<string>("Medu_name",null); }
            set { setAttrVal<string>("Medu_name", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 物品规格
        /// </summary>
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Route_name {
            get { return getAttrVal<string>("Route_name",null); }
            set { setAttrVal<string>("Route_name", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
		public string Freq_name {
            get { return getAttrVal<string>("Freq_name",null); }
            set { setAttrVal<string>("Freq_name", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_entp", "Code_entp", "Id_srvtp", "Sd_srvtp", "Fg_long", "Name_srv", "Quan_medu", "Medu_name", "Name_mm", "Spec", "Route_name", "Freq_name"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordprintdto.d.OrdPrintCfgDTO";
        }
    }
}
