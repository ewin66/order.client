using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.nu.dto.d
{
    /// <summary>
    /// NurDocStructDGDTO 的摘要说明。
    /// </summary>
    public class NurDocStructDGDTO : BaseDTO {

        public NurDocStructDGDTO() {
 
        }

        /// <summary>
        /// 医疗数据组id
        /// </summary>
		public string Id_mrdg {
            get { return getAttrVal<string>("Id_mrdg",null); }
            set { setAttrVal<string>("Id_mrdg", value); }
        }

        /// <summary>
        /// 医疗记录组
        /// </summary>
		public string Name_mrdg {
            get { return getAttrVal<string>("Name_mrdg",null); }
            set { setAttrVal<string>("Name_mrdg", value); }
        }

        /// <summary>
        /// 公共数据组id
        /// </summary>
		public string Id_dg {
            get { return getAttrVal<string>("Id_dg",null); }
            set { setAttrVal<string>("Id_dg", value); }
        }

        /// <summary>
        /// 公共数据组名称
        /// </summary>
		public string Name_dg {
            get { return getAttrVal<string>("Name_dg",null); }
            set { setAttrVal<string>("Name_dg", value); }
        }

        /// <summary>
        /// 父级数据组ID
        /// </summary>
		public string Id_mrdg_par {
            get { return getAttrVal<string>("Id_mrdg_par",null); }
            set { setAttrVal<string>("Id_mrdg_par", value); }
        }

        /// <summary>
        /// 父数据组名称
        /// </summary>
		public string Name_mrdg_par {
            get { return getAttrVal<string>("Name_mrdg_par",null); }
            set { setAttrVal<string>("Name_mrdg_par", value); }
        }

        /// <summary>
        /// 医疗记录元素集合
        /// </summary>
		public FArrayList Mrdedtos {
            get { return getAttrVal<FArrayList>("Mrdedtos",null); }
            set { setAttrVal<FArrayList>("Mrdedtos", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mrdg", "Name_mrdg", "Id_dg", "Name_dg", "Id_mrdg_par", "Name_mrdg_par", "Mrdedtos"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.nu.dto.d.NurDocStructDGDTO";
        }
    }
}
