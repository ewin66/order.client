using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hospitalcontagiondto.d
{
    /// <summary>
    /// HospitalContagionDTO 的摘要说明。
    /// </summary>
    public class HospitalContagionDTO : BaseDTO {

        public HospitalContagionDTO() {
 
        }

        /// <summary>
        /// 传染病报告卡主键
        /// </summary>
		public string Id_contagion {
            get { return getAttrVal<string>("Id_contagion",null); }
            set { setAttrVal<string>("Id_contagion", value); }
        }

        /// <summary>
        /// 患者信息
        /// </summary>
		public FArrayList Ls_patient {
            get { return getAttrVal<FArrayList>("Ls_patient",null); }
            set { setAttrVal<FArrayList>("Ls_patient", value); }
        }

        /// <summary>
        /// 传染病报告卡信息
        /// </summary>
		public FArrayList Ls_contagion {
            get { return getAttrVal<FArrayList>("Ls_contagion",null); }
            set { setAttrVal<FArrayList>("Ls_contagion", value); }
        }

        /// <summary>
        /// 性别附卡
        /// </summary>
		public FArrayList Ls_std {
            get { return getAttrVal<FArrayList>("Ls_std",null); }
            set { setAttrVal<FArrayList>("Ls_std", value); }
        }

        /// <summary>
        /// 梅毒附卡
        /// </summary>
		public FArrayList Ls_syphilis {
            get { return getAttrVal<FArrayList>("Ls_syphilis",null); }
            set { setAttrVal<FArrayList>("Ls_syphilis", value); }
        }

        /// <summary>
        /// 手足口附卡
        /// </summary>
		public FArrayList Ls_hfm {
            get { return getAttrVal<FArrayList>("Ls_hfm",null); }
            set { setAttrVal<FArrayList>("Ls_hfm", value); }
        }

        /// <summary>
        /// 乙肝附卡
        /// </summary>
		public FArrayList Ls_hepatitisb {
            get { return getAttrVal<FArrayList>("Ls_hepatitisb",null); }
            set { setAttrVal<FArrayList>("Ls_hepatitisb", value); }
        }

        /// <summary>
        /// 传染病分类
        /// </summary>
		public FArrayList Ls_crb {
            get { return getAttrVal<FArrayList>("Ls_crb",null); }
            set { setAttrVal<FArrayList>("Ls_crb", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_contagion", "Ls_patient", "Ls_contagion", "Ls_std", "Ls_syphilis", "Ls_hfm", "Ls_hepatitisb", "Ls_crb"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hospitalcontagiondto.d.HospitalContagionDTO";
        }
    }
}
