using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d
{
    /// <summary>
    /// OpPresList 的摘要说明。
    /// </summary>
    public class OpPresList : BaseDTO {

        public OpPresList() {
 
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_opordpres {
            get { return getAttrVal<string>("Id_opordpres",null); }
            set { setAttrVal<string>("Id_opordpres", value); }
        }

        /// <summary>
        /// 处方类型
        /// </summary>
		public string Name_prestp {
            get { return getAttrVal<string>("Name_prestp",null); }
            set { setAttrVal<string>("Name_prestp", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Name_dep_mp {
            get { return getAttrVal<string>("Name_dep_mp",null); }
            set { setAttrVal<string>("Name_dep_mp", value); }
        }

        /// <summary>
        /// 提示
        /// </summary>
		public bool? Fg_skintest {
            get { return getAttrVal<FBoolean>("Fg_skintest",null); }
            set { setAttrVal<FBoolean>("Fg_skintest", value); }
        }

        /// <summary>
        /// 处方号
        /// </summary>
		public int? Pres_no {
            get { return getAttrVal<int?>("Pres_no",null); }
            set { setAttrVal<int?>("Pres_no", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Order_des {
            get { return getAttrVal<string>("Order_des",null); }
            set { setAttrVal<string>("Order_des", value); }
        }

        /// <summary>
        /// 价格
        /// </summary>
		public double? Price {
            get { return getAttrVal<FDouble>("Price",null); }
            set { setAttrVal<FDouble>("Price", value); }
        }

        /// <summary>
        /// 开立医生
        /// </summary>
		public string Name_emp_phy {
            get { return getAttrVal<string>("Name_emp_phy",null); }
            set { setAttrVal<string>("Name_emp_phy", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_opordpres", "Name_prestp", "Name_dep_mp", "Fg_skintest", "Pres_no", "Order_des", "Price", "Name_emp_phy"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.OpPresList";
        }
    }
}
