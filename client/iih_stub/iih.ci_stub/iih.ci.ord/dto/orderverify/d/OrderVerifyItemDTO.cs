using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.orderverify.d
{
    /// <summary>
    /// OrderVerifyItemDTO 的摘要说明。
    /// </summary>
    public class OrderVerifyItemDTO : BaseDTO {

        public OrderVerifyItemDTO() {
 
        }

        /// <summary>
        /// 医嘱ID
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 医嘱服务项目ID
        /// </summary>
		public string Id_orsrv {
            get { return getAttrVal<string>("Id_orsrv",null); }
            set { setAttrVal<string>("Id_orsrv", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 规格
        /// </summary>
		public string Spec {
            get { return getAttrVal<string>("Spec",null); }
            set { setAttrVal<string>("Spec", value); }
        }

        /// <summary>
        /// 计量
        /// </summary>
		public string Dose {
            get { return getAttrVal<string>("Dose",null); }
            set { setAttrVal<string>("Dose", value); }
        }

        /// <summary>
        /// 数量
        /// </summary>
		public string Quan {
            get { return getAttrVal<string>("Quan",null); }
            set { setAttrVal<string>("Quan", value); }
        }

        /// <summary>
        /// 单位
        /// </summary>
		public string Name_unit {
            get { return getAttrVal<string>("Name_unit",null); }
            set { setAttrVal<string>("Name_unit", value); }
        }

        /// <summary>
        /// 用法
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }

        /// <summary>
        /// 频次
        /// </summary>
		public string Name_freq {
            get { return getAttrVal<string>("Name_freq",null); }
            set { setAttrVal<string>("Name_freq", value); }
        }

        /// <summary>
        /// 标志
        /// </summary>
		public string Sign {
            get { return getAttrVal<string>("Sign",null); }
            set { setAttrVal<string>("Sign", value); }
        }

        /// <summary>
        /// 皮试
        /// </summary>
		public string Skin {
            get { return getAttrVal<string>("Skin",null); }
            set { setAttrVal<string>("Skin", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_orsrv", "Name", "Spec", "Dose", "Quan", "Name_unit", "Name_route", "Name_freq", "Sign", "Skin"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.orderverify.d.OrderVerifyItemDTO";
        }
    }
}
