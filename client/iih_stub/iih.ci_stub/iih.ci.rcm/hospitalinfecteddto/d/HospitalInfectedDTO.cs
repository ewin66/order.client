using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.rcm.hospitalinfecteddto.d
{
    /// <summary>
    /// HospitalInfectedDTO 的摘要说明。
    /// </summary>
    public class HospitalInfectedDTO : BaseDTO {

        public HospitalInfectedDTO() {
 
        }

        /// <summary>
        /// 院感上报主键
        /// </summary>
		public string Id_hospitalreport {
            get { return getAttrVal<string>("Id_hospitalreport",null); }
            set { setAttrVal<string>("Id_hospitalreport", value); }
        }

        /// <summary>
        /// 病人基本信息
        /// </summary>
		public FArrayList Ls_patient {
            get { return getAttrVal<FArrayList>("Ls_patient",null); }
            set { setAttrVal<FArrayList>("Ls_patient", value); }
        }

        /// <summary>
        /// 院感上报信息
        /// </summary>
		public FArrayList Ls_hosrep {
            get { return getAttrVal<FArrayList>("Ls_hosrep",null); }
            set { setAttrVal<FArrayList>("Ls_hosrep", value); }
        }

        /// <summary>
        /// 抗菌用药
        /// </summary>
		public FArrayList Ls_antuse {
            get { return getAttrVal<FArrayList>("Ls_antuse",null); }
            set { setAttrVal<FArrayList>("Ls_antuse", value); }
        }

        /// <summary>
        /// 药敏信息
        /// </summary>
		public FArrayList Ls_drugsen {
            get { return getAttrVal<FArrayList>("Ls_drugsen",null); }
            set { setAttrVal<FArrayList>("Ls_drugsen", value); }
        }

        /// <summary>
        /// 感染部位
        /// </summary>
		public FArrayList Ls_consite {
            get { return getAttrVal<FArrayList>("Ls_consite",null); }
            set { setAttrVal<FArrayList>("Ls_consite", value); }
        }

        /// <summary>
        /// 手术切口感染
        /// </summary>
		public FArrayList Ls_operincinfect {
            get { return getAttrVal<FArrayList>("Ls_operincinfect",null); }
            set { setAttrVal<FArrayList>("Ls_operincinfect", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_hospitalreport", "Ls_patient", "Ls_hosrep", "Ls_antuse", "Ls_drugsen", "Ls_consite", "Ls_operincinfect"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.rcm.hospitalinfecteddto.d.HospitalInfectedDTO";
        }
    }
}
