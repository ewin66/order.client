using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.dto.d
{
    /// <summary>
    /// NurDocStructDEDTO 的摘要说明。
    /// </summary>
    public class NurDocStructDEDTO : BaseDTO {

        public NurDocStructDEDTO() {
 
        }

        /// <summary>
        /// 医疗记录元素ID
        /// </summary>
		public string Id_mrde {
            get { return getAttrVal<string>("Id_mrde",null); }
            set { setAttrVal<string>("Id_mrde", value); }
        }

        /// <summary>
        /// 医疗记录元素名称
        /// </summary>
		public string Name_mrde {
            get { return getAttrVal<string>("Name_mrde",null); }
            set { setAttrVal<string>("Name_mrde", value); }
        }

        /// <summary>
        /// 医疗记录模板元素id
        /// </summary>
		public string Id_mrtplde {
            get { return getAttrVal<string>("Id_mrtplde",null); }
            set { setAttrVal<string>("Id_mrtplde", value); }
        }

        /// <summary>
        /// 数据组ID
        /// </summary>
		public string Id_mrdg {
            get { return getAttrVal<string>("Id_mrdg",null); }
            set { setAttrVal<string>("Id_mrdg", value); }
        }

        /// <summary>
        /// 数据组名称
        /// </summary>
		public string Name_mrdg {
            get { return getAttrVal<string>("Name_mrdg",null); }
            set { setAttrVal<string>("Name_mrdg", value); }
        }

        /// <summary>
        /// 对应公共数据组ID
        /// </summary>
		public string Id_dg {
            get { return getAttrVal<string>("Id_dg",null); }
            set { setAttrVal<string>("Id_dg", value); }
        }

        /// <summary>
        /// 对应公共数据组名称
        /// </summary>
		public string Name_dg {
            get { return getAttrVal<string>("Name_dg",null); }
            set { setAttrVal<string>("Name_dg", value); }
        }

        /// <summary>
        /// 对应公共数据元ID
        /// </summary>
		public string Id_de {
            get { return getAttrVal<string>("Id_de",null); }
            set { setAttrVal<string>("Id_de", value); }
        }

        /// <summary>
        /// 对应公共数据元名称
        /// </summary>
		public string Name_de {
            get { return getAttrVal<string>("Name_de",null); }
            set { setAttrVal<string>("Name_de", value); }
        }

        /// <summary>
        /// 公共数据元编码
        /// </summary>
		public string Code_de {
            get { return getAttrVal<string>("Code_de",null); }
            set { setAttrVal<string>("Code_de", value); }
        }

        /// <summary>
        /// 数据元值
        /// </summary>
		public string Val {
            get { return getAttrVal<string>("Val",null); }
            set { setAttrVal<string>("Val", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mrde", "Name_mrde", "Id_mrtplde", "Id_mrdg", "Name_mrdg", "Id_dg", "Name_dg", "Id_de", "Name_de", "Code_de", "Val"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.dto.d.NurDocStructDEDTO";
        }
    }
}
