using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.d
{
    /// <summary>
    /// OrDrugDetailDTO 的摘要说明。
    /// </summary>
    public class OrDrugDetailDTO : BaseDTO {

        public OrDrugDetailDTO() {
 
        }

        /// <summary>
        /// 项目id
        /// </summary>
		public string Id_srv {
            get { return getAttrVal<string>("Id_srv",null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 医嘱id
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 序号
        /// </summary>
		public string Sortno {
            get { return getAttrVal<string>("Sortno",null); }
            set { setAttrVal<string>("Sortno", value); }
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Namesrv {
            get { return getAttrVal<string>("Namesrv",null); }
            set { setAttrVal<string>("Namesrv", value); }
        }

        /// <summary>
        /// 剂量
        /// </summary>
		public string Quan_medu {
            get { return getAttrVal<string>("Quan_medu",null); }
            set { setAttrVal<string>("Quan_medu", value); }
        }

        /// <summary>
        /// 医疗单位id
        /// </summary>
		public string Id_medu {
            get { return getAttrVal<string>("Id_medu",null); }
            set { setAttrVal<string>("Id_medu", value); }
        }

        /// <summary>
        /// 医疗单位
        /// </summary>
		public string Name_medu {
            get { return getAttrVal<string>("Name_medu",null); }
            set { setAttrVal<string>("Name_medu", value); }
        }

        /// <summary>
        /// 用法id
        /// </summary>
		public string Id_route {
            get { return getAttrVal<string>("Id_route",null); }
            set { setAttrVal<string>("Id_route", value); }
        }

        /// <summary>
        /// 用法名称
        /// </summary>
		public string Name_route {
            get { return getAttrVal<string>("Name_route",null); }
            set { setAttrVal<string>("Name_route", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_srv", "Id_or", "Sortno", "Namesrv", "Quan_medu", "Id_medu", "Name_medu", "Id_route", "Name_route"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.OrDrugDetailDTO";
        }
    }
}
