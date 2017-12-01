using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordrationaldrugdto.d
{
    /// <summary>
    /// OrdRationalDrugDTO 的摘要说明。
    /// </summary>
    public class OrdRationalDrugDTO : BaseDTO {

        public OrdRationalDrugDTO() {
 
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 签署标识
        /// </summary>
		public bool? Fg_sign {
            get { return getAttrVal<FBoolean>("Fg_sign",null); }
            set { setAttrVal<FBoolean>("Fg_sign", value); }
        }

        /// <summary>
        /// 组号
        /// </summary>
		public string Group_number {
            get { return getAttrVal<string>("Group_number",null); }
            set { setAttrVal<string>("Group_number", value); }
        }

        /// <summary>
        /// 服务主键
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 服务名
        /// </summary>
		public string Name_srv {
            get { return getAttrVal<string>("Name_srv",null); }
            set { setAttrVal<string>("Name_srv", value); }
        }

        /// <summary>
        /// 医嘱服务物品主键标识
        /// </summary>
		public string Id_orsrvmm {
            get { return getAttrVal<string>("Id_orsrvmm",null); }
            set { setAttrVal<string>("Id_orsrvmm", value); }
        }

        /// <summary>
        /// 物品编码
        /// </summary>
		public string Code_mm {
            get { return getAttrVal<string>("Code_mm",null); }
            set { setAttrVal<string>("Code_mm", value); }
        }

        /// <summary>
        /// 物品名称
        /// </summary>
		public string Name_mm {
            get { return getAttrVal<string>("Name_mm",null); }
            set { setAttrVal<string>("Name_mm", value); }
        }

        /// <summary>
        /// 医疗用法主键标识
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法编码
        /// </summary>
        public string Route_code
        {
            get { return getAttrVal<string>("Route_code", null); }
            set { setAttrVal<string>("Route_code", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Route_name {
            get { return getAttrVal<string>("Route_name",null); }
            set { setAttrVal<string>("Route_name", value); }
        }

        /// <summary>
        /// 医嘱天数
        /// </summary>
		public string Days_or {
            get { return getAttrVal<string>("Days_or",null); }
            set { setAttrVal<string>("Days_or", value); }
        }

        /// <summary>
        /// 医嘱频次
        /// </summary>
		public string Id_freq {
            get { return getAttrVal<string>("Id_freq",null); }
            set { setAttrVal<string>("Id_freq", value); }
        }

        /// <summary>
        /// 频次编码
        /// </summary>
		public string Freq_code {
            get { return getAttrVal<string>("Freq_code",null); }
            set { setAttrVal<string>("Freq_code", value); }
        }

        /// <summary>
        /// 频次名称
        /// </summary>
		public string Freq_name {
            get { return getAttrVal<string>("Freq_name",null); }
            set { setAttrVal<string>("Freq_name", value); }
        }

        /// <summary>
        /// 用量
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 医疗单位
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 计量单位编码
        /// </summary>
		public string Medu_code {
            get { return getAttrVal<string>("Medu_code",null); }
            set { setAttrVal<string>("Medu_code", value); }
        }

        /// <summary>
        /// 计量单位名称
        /// </summary>
		public string Medu_name {
            get { return getAttrVal<string>("Medu_name",null); }
            set { setAttrVal<string>("Medu_name", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Fg_sign", "Group_number", "Id_srv", "Name_srv", "Id_orsrvmm", "Code_mm", "Name_mm", "Id_route", "Route_name", "Days_or", "Id_freq", "Freq_code", "Freq_name", "Quan_medu", "Id_medu", "Medu_code", "Medu_name"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordrationaldrugdto.d.OrdRationalDrugDTO";
        }
    }
}
