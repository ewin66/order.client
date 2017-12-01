using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mrfp.hospitalfirstpagedto.d
{
    /// <summary>
    /// HospitalFirstPageDTO 的摘要说明。
    /// </summary>
    public class HospitalFirstPageDTO : BaseDTO {

        public HospitalFirstPageDTO() {
 
        }

        /// <summary>
        /// 病案首页主键
        /// </summary>
		public string Id_mrfp {
            get { return getAttrVal<string>("Id_mrfp",null); }
            set { setAttrVal<string>("Id_mrfp", value); }
        }

        /// <summary>
        /// 病案首页主表
        /// </summary>
		public FArrayList Ls_mrfp {
            get { return getAttrVal<FArrayList>("Ls_mrfp",null); }
            set { setAttrVal<FArrayList>("Ls_mrfp", value); }
        }

        /// <summary>
        /// 费用
        /// </summary>
		public FArrayList Ls_bl {
            get { return getAttrVal<FArrayList>("Ls_bl",null); }
            set { setAttrVal<FArrayList>("Ls_bl", value); }
        }

        /// <summary>
        /// 诊断
        /// </summary>
		public FArrayList Ls_dia {
            get { return getAttrVal<FArrayList>("Ls_dia",null); }
            set { setAttrVal<FArrayList>("Ls_dia", value); }
        }

        /// <summary>
        /// 其他信息
        /// </summary>
		public FArrayList Ls_other {
            get { return getAttrVal<FArrayList>("Ls_other",null); }
            set { setAttrVal<FArrayList>("Ls_other", value); }
        }

        /// <summary>
        /// 患者信息
        /// </summary>
		public FArrayList Ls_patient {
            get { return getAttrVal<FArrayList>("Ls_patient",null); }
            set { setAttrVal<FArrayList>("Ls_patient", value); }
        }

        /// <summary>
        /// 手术信息
        /// </summary>
		public FArrayList Ls_sug {
            get { return getAttrVal<FArrayList>("Ls_sug",null); }
            set { setAttrVal<FArrayList>("Ls_sug", value); }
        }

        /// <summary>
        /// 重症监护
        /// </summary>
		public FArrayList Ls_intencare {
            get { return getAttrVal<FArrayList>("Ls_intencare",null); }
            set { setAttrVal<FArrayList>("Ls_intencare", value); }
        }

        /// <summary>
        /// 审核人信息
        /// </summary>
		public FArrayList Ls_audit {
            get { return getAttrVal<FArrayList>("Ls_audit",null); }
            set { setAttrVal<FArrayList>("Ls_audit", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mrfp", "Ls_mrfp", "Ls_bl", "Ls_dia", "Ls_other", "Ls_patient", "Ls_sug", "Ls_intencare", "Ls_audit"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mrfp.hospitalfirstpagedto.d.HospitalFirstPageDTO";
        }
    }
}
