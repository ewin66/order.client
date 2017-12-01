using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.blexorder.d
{
    /// <summary>
    /// DiagTreatViewRntDataDTO 的摘要说明。
    /// </summary>
    public class DiagTreatViewRntDataDTO : BaseDTO {

        public DiagTreatViewRntDataDTO() {
 
        }

        /// <summary>
        /// 诊疗视图数据主键
        /// </summary>
		public string Id_diagtreat {
            get { return getAttrVal<string>("Id_diagtreat",null); }
            set { setAttrVal<string>("Id_diagtreat", value); }
        }

        /// <summary>
        /// 用药数据
        /// </summary>
		public FArrayList2 Drugdata {
            get { return getAttrVal<FArrayList2>("Drugdata",null); }
            set { setAttrVal<FArrayList2>("Drugdata", value); }
        }

        /// <summary>
        /// 检验数据
        /// </summary>
		public FArrayList2 Labdata {
            get { return getAttrVal<FArrayList2>("Labdata",null); }
            set { setAttrVal<FArrayList2>("Labdata", value); }
        }

        /// <summary>
        /// 检查数据
        /// </summary>
		public FArrayList2 Obsdata {
            get { return getAttrVal<FArrayList2>("Obsdata",null); }
            set { setAttrVal<FArrayList2>("Obsdata", value); }
        }

        /// <summary>
        /// 生命体征数据
        /// </summary>
		public FArrayList2 Bodysignsdata {
            get { return getAttrVal<FArrayList2>("Bodysignsdata",null); }
            set { setAttrVal<FArrayList2>("Bodysignsdata", value); }
        }

        /// <summary>
        /// 就诊号
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 开始时间
        /// </summary>
		public DateTime? Dt_start {
            get { return getAttrVal<FDateTime>("Dt_start",null); }
            set { setAttrVal<FDateTime>("Dt_start", value); }
        }

        /// <summary>
        /// 结束时间
        /// </summary>
		public DateTime? Dt_end {
            get { return getAttrVal<FDateTime>("Dt_end",null); }
            set { setAttrVal<FDateTime>("Dt_end", value); }
        }

        /// <summary>
        /// 医疗记录类型自定义分类
        /// </summary>
		public FArrayList2 Mrctmcas {
            get { return getAttrVal<FArrayList2>("Mrctmcas",null); }
            set { setAttrVal<FArrayList2>("Mrctmcas", value); }
        }

        /// <summary>
        /// 临床医疗记录
        /// </summary>
		public FArrayList2 Cimrs {
            get { return getAttrVal<FArrayList2>("Cimrs",null); }
            set { setAttrVal<FArrayList2>("Cimrs", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_diagtreat", "Drugdata", "Labdata", "Obsdata", "Bodysignsdata", "Id_en", "Dt_start", "Dt_end", "Mrctmcas", "Cimrs"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.blexorder.d.DiagTreatViewRntDataDTO";
        }
    }
}
