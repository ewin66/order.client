using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.ordpres.d
{
    /// <summary>
    /// PresPrintParamDTO 的摘要说明。
    /// </summary>
    public class PresPrintParamDTO : BaseDTO {

        public PresPrintParamDTO() {
 
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 处方串（逗号分隔）
        /// </summary>
		public string Id_preses {
            get { return getAttrVal<string>("Id_preses",null); }
            set { setAttrVal<string>("Id_preses", value); }
        }

        /// <summary>
        /// 年龄
        /// </summary>
		public double? Age {
            get { return getAttrVal<FDouble>("Age",null); }
            set { setAttrVal<FDouble>("Age", value); }
        }

        /// <summary>
        /// 过敏史
        /// </summary>
		public string Des_alcla {
            get { return getAttrVal<string>("Des_alcla",null); }
            set { setAttrVal<string>("Des_alcla", value); }
        }

        /// <summary>
        /// 客户扩展字段1
        /// </summary>
		public string Def1 {
            get { return getAttrVal<string>("Def1",null); }
            set { setAttrVal<string>("Def1", value); }
        }

        /// <summary>
        /// 客户扩展字段2
        /// </summary>
		public string Def2 {
            get { return getAttrVal<string>("Def2",null); }
            set { setAttrVal<string>("Def2", value); }
        }

        /// <summary>
        /// 客户扩展字段3
        /// </summary>
		public string Def3 {
            get { return getAttrVal<string>("Def3",null); }
            set { setAttrVal<string>("Def3", value); }
        }

        /// <summary>
        /// 客户扩展字段4
        /// </summary>
		public string Def4 {
            get { return getAttrVal<string>("Def4",null); }
            set { setAttrVal<string>("Def4", value); }
        }

        /// <summary>
        /// 客户扩展字段5
        /// </summary>
		public string Def5 {
            get { return getAttrVal<string>("Def5",null); }
            set { setAttrVal<string>("Def5", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_en", "Id_preses", "Age", "Des_alcla", "Def1", "Def2", "Def3", "Def4", "Def5"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.ordpres.d.PresPrintParamDTO";
        }
    }
}
