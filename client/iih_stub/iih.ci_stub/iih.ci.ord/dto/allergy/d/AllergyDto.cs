using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.allergy.d
{
    /// <summary>
    /// AllergyDto 的摘要说明。
    /// </summary>
    public class AllergyDto : BaseDTO {

        public AllergyDto() {
 
        }

        /// <summary>
        /// 过敏史
        /// </summary>
		public string Id_patal {
            get { return getAttrVal<string>("Id_patal",null); }
            set { setAttrVal<string>("Id_patal", value); }
        }

        /// <summary>
        /// 患者id
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 过敏史分类名称
        /// </summary>
		public string Name_altp {
            get { return getAttrVal<string>("Name_altp",null); }
            set { setAttrVal<string>("Name_altp", value); }
        }

        /// <summary>
        /// displaynam4
        /// </summary>
		public string Name_alcla {
            get { return getAttrVal<string>("Name_alcla",null); }
            set { setAttrVal<string>("Name_alcla", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_patal", "Id_pat", "Name_altp", "Name_alcla"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.allergy.d.AllergyDto";
        }
    }
}
