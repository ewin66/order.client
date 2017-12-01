using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hospitalinfectiondto.d
{
    /// <summary>
    /// HospitalInfectionDTO 的摘要说明。
    /// </summary>
    public class HospitalInfectionDTO : BaseDTO {

        public HospitalInfectionDTO() {
 
        }

        /// <summary>
        /// 名称
        /// </summary>
		public string Name {
            get { return getAttrVal<string>("Name",null); }
            set { setAttrVal<string>("Name", value); }
        }

        /// <summary>
        /// 节点id
        /// </summary>
		public string Id_node {
            get { return getAttrVal<string>("Id_node",null); }
            set { setAttrVal<string>("Id_node", value); }
        }

        /// <summary>
        /// 父节点id
        /// </summary>
		public string Id_parent_node {
            get { return getAttrVal<string>("Id_parent_node",null); }
            set { setAttrVal<string>("Id_parent_node", value); }
        }

        /// <summary>
        /// 类型
        /// </summary>
		public string Style {
            get { return getAttrVal<string>("Style",null); }
            set { setAttrVal<string>("Style", value); }
        }

        /// <summary>
        /// 是否主卡
        /// </summary>
		public bool? Is_main_card {
            get { return getAttrVal<FBoolean>("Is_main_card",null); }
            set { setAttrVal<FBoolean>("Is_main_card", value); }
        }

        /// <summary>
        /// 是否副卡
        /// </summary>
		public bool? Is_vice_card {
            get { return getAttrVal<FBoolean>("Is_vice_card",null); }
            set { setAttrVal<FBoolean>("Is_vice_card", value); }
        }

        /// <summary>
        /// 报卡状态
        /// </summary>
		public string Report_status {
            get { return getAttrVal<string>("Report_status",null); }
            set { setAttrVal<string>("Report_status", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Name", "Id_node", "Id_parent_node", "Style", "Is_main_card", "Is_vice_card", "Report_status"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hospitalinfectiondto.d.HospitalInfectionDTO";
        }
    }
}
