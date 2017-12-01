using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrqc.itmdto.d
{
    /// <summary>
    /// ItmDTO 的摘要说明。
    /// </summary>
    public class ItmDTO : BaseDTO {

        public ItmDTO() {
 
        }

        /// <summary>
        /// DTO主键
        /// </summary>
		public string Id_itmdto {
            get { return getAttrVal<string>("Id_itmdto",null); }
            set { setAttrVal<string>("Id_itmdto", value); }
        }

        /// <summary>
        /// 质控项主键
        /// </summary>
		public string Id_qa_itm {
            get { return getAttrVal<string>("Id_qa_itm",null); }
            set { setAttrVal<string>("Id_qa_itm", value); }
        }

        /// <summary>
        /// 质控要求
        /// </summary>
		public string Req {
            get { return getAttrVal<string>("Req",null); }
            set { setAttrVal<string>("Req", value); }
        }

        /// <summary>
        /// 扣分标准
        /// </summary>
		public string Deduct_des {
            get { return getAttrVal<string>("Deduct_des",null); }
            set { setAttrVal<string>("Deduct_des", value); }
        }

        /// <summary>
        /// 自动质控标志
        /// </summary>
		public bool? Fg_auto_qa {
            get { return getAttrVal<FBoolean>("Fg_auto_qa",null); }
            set { setAttrVal<FBoolean>("Fg_auto_qa", value); }
        }

        /// <summary>
        /// 缺陷表主键
        /// </summary>
		public string Id_qa_flt {
            get { return getAttrVal<string>("Id_qa_flt",null); }
            set { setAttrVal<string>("Id_qa_flt", value); }
        }

        /// <summary>
        /// 缺陷扣分次数
        /// </summary>
		public int? Deduct_scr_times {
            get { return getAttrVal<int?>("Deduct_scr_times",null); }
            set { setAttrVal<int?>("Deduct_scr_times", value); }
        }

        /// <summary>
        /// 单次扣分值
        /// </summary>
		public double? Once_drp_scr {
            get { return getAttrVal<FDouble>("Once_drp_scr",null); }
            set { setAttrVal<FDouble>("Once_drp_scr", value); }
        }

        /// <summary>
        /// 最大扣分值
        /// </summary>
		public double? Max_drp_scr {
            get { return getAttrVal<FDouble>("Max_drp_scr",null); }
            set { setAttrVal<FDouble>("Max_drp_scr", value); }
        }

        /// <summary>
        /// 扣分类型
        /// </summary>
		public string Id_qa_drp_scr_tp {
            get { return getAttrVal<string>("Id_qa_drp_scr_tp",null); }
            set { setAttrVal<string>("Id_qa_drp_scr_tp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_itmdto", "Id_qa_itm", "Req", "Deduct_des", "Fg_auto_qa", "Id_qa_flt", "Deduct_scr_times", "Once_drp_scr", "Max_drp_scr", "Id_qa_drp_scr_tp"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrqc.itmdto.d.ItmDTO";
        }
    }
}
