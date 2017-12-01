using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.unchargeordinfo.d
{
    /// <summary>
    /// UnchargeOrdDTO 的摘要说明。
    /// </summary>
    public class UnchargeOrdDTO : BaseDTO {

        public UnchargeOrdDTO() {
 
        }

        /// <summary>
        /// 医嘱
        /// </summary>
		public string Id_or {
            get { return getAttrVal<string>("Id_or",null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 所属集团
        /// </summary>
		public string Id_grp {
            get { return getAttrVal<string>("Id_grp",null); }
            set { setAttrVal<string>("Id_grp", value); }
        }

        /// <summary>
        /// 所属组织
        /// </summary>
		public string Id_org {
            get { return getAttrVal<string>("Id_org",null); }
            set { setAttrVal<string>("Id_org", value); }
        }

        /// <summary>
        /// 患者
        /// </summary>
		public string Id_pat {
            get { return getAttrVal<string>("Id_pat",null); }
            set { setAttrVal<string>("Id_pat", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Id_entp {
            get { return getAttrVal<string>("Id_entp",null); }
            set { setAttrVal<string>("Id_entp", value); }
        }

        /// <summary>
        /// 就诊类型编码
        /// </summary>
		public string Code_entp {
            get { return getAttrVal<string>("Code_entp",null); }
            set { setAttrVal<string>("Code_entp", value); }
        }

        /// <summary>
        /// 就诊
        /// </summary>
		public string Id_en {
            get { return getAttrVal<string>("Id_en",null); }
            set { setAttrVal<string>("Id_en", value); }
        }

        /// <summary>
        /// 医嘱内容
        /// </summary>
		public string Des {
            get { return getAttrVal<string>("Des",null); }
            set { setAttrVal<string>("Des", value); }
        }

        /// <summary>
        /// 婴儿标识
        /// </summary>
		public bool? Fg_bb {
            get { return getAttrVal<FBoolean>("Fg_bb",null); }
            set { setAttrVal<FBoolean>("Fg_bb", value); }
        }

        /// <summary>
        /// 婴儿序号
        /// </summary>
		public int? No_bb {
            get { return getAttrVal<int?>("No_bb",null); }
            set { setAttrVal<int?>("No_bb", value); }
        }

        /// <summary>
        /// 签署时间
        /// </summary>
		public DateTime? Dt_sign {
            get { return getAttrVal<FDateTime>("Dt_sign",null); }
            set { setAttrVal<FDateTime>("Dt_sign", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_or", "Id_grp", "Id_org", "Id_pat", "Id_entp", "Code_entp", "Id_en", "Des", "Fg_bb", "No_bb", "Dt_sign"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdDTO";
        }
    }
}
