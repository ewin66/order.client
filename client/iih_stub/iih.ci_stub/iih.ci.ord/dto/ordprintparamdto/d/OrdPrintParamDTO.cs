using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordprintparamdto.d
{
    /// <summary>
    /// OrdPrintParamDTO 的摘要说明。
    /// </summary>
    public class OrdPrintParamDTO : BaseDTO {

        public OrdPrintParamDTO() {
 
        }

        /// <summary>
        /// 长临标识
        /// </summary>
		public bool? Fg_long {
            get { return getAttrVal<FBoolean>("Fg_long",null); }
            set { setAttrVal<FBoolean>("Fg_long", value); }
        }

        /// <summary>
        /// 就诊ID
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Code_en {
            get { return getAttrVal<string>("Code_en",null); }
            set { setAttrVal<string>("Code_en", value); }
        }

        /// <summary>
        /// 患者姓名
        /// </summary>
		public string Name_en {
            get { return getAttrVal<string>("Name_en",null); }
            set { setAttrVal<string>("Name_en", value); }
        }

        /// <summary>
        /// 患者ID
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 打印模式
        /// </summary>
		public string Print_mode {
            get { return getAttrVal<string>("Print_mode",null); }
            set { setAttrVal<string>("Print_mode", value); }
        }

        /// <summary>
        /// 页号
        /// </summary>
		public int? Page_num {
            get { return getAttrVal<int?>("Page_num",null); }
            set { setAttrVal<int?>("Page_num", value); }
        }

        /// <summary>
        /// 就诊类型ID
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
        /// 就诊科室ID
        /// </summary>
		public string Id_dep_phy {
            get { return getAttrVal<string>("Id_dep_phy",null); }
            set { setAttrVal<string>("Id_dep_phy", value); }
        }

        /// <summary>
        /// 就诊科室
        /// </summary>
		public string Name_dep_phy {
            get { return getAttrVal<string>("Name_dep_phy",null); }
            set { setAttrVal<string>("Name_dep_phy", value); }
        }

        /// <summary>
        /// 就诊病区ID
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 就诊病区
        /// </summary>
		public string Name_dep_nur {
            get { return getAttrVal<string>("Name_dep_nur",null); }
            set { setAttrVal<string>("Name_dep_nur", value); }
        }

        /// <summary>
        /// 住院号
        /// </summary>
		public string Code_amr_ip {
            get { return getAttrVal<string>("Code_amr_ip",null); }
            set { setAttrVal<string>("Code_amr_ip", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Fg_long", "Id_en", "Code_en", "Name_en", "Id_pat", "Print_mode", "Page_num", "Id_entp", "Code_entp", "Id_dep_phy", "Name_dep_phy", "Id_dep_nur", "Name_dep_nur", "Code_amr_ip"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordprintparamdto.d.OrdPrintParamDTO";
        }
    }
}
