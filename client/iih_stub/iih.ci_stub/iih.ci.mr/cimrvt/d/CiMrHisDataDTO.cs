using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.cimrpatsigns.d
{
    /// <summary>
    /// CiMrHisDataDTO 的摘要说明。
    /// </summary>
    public class CiMrHisDataDTO : BaseDTO {

        public CiMrHisDataDTO() {
 
        }

        /// <summary>
        /// 医疗记录ID
        /// </summary>
		public string Id_mr {
            get { return getAttrVal<string>("Id_mr",null); }
            set { setAttrVal<string>("Id_mr", value); }
        }

        /// <summary>
        /// 体征测量主表ID
        /// </summary>
		public string Id_mrvt {
            get { return getAttrVal<string>("Id_mrvt",null); }
            set { setAttrVal<string>("Id_mrvt", value); }
        }

        /// <summary>
        /// 体征测量项目ID
        /// </summary>
		public string Id_mrvtitm {
            get { return getAttrVal<string>("Id_mrvtitm",null); }
            set { setAttrVal<string>("Id_mrvtitm", value); }
        }

        /// <summary>
        /// 就诊ID
        /// </summary>
		public string Id_ent {
            get { return getAttrVal<string>("Id_ent",null); }
            set { setAttrVal<string>("Id_ent", value); }
        }

        /// <summary>
        /// 测量单ID
        /// </summary>
		public string Id_mrtplvt {
            get { return getAttrVal<string>("Id_mrtplvt",null); }
            set { setAttrVal<string>("Id_mrtplvt", value); }
        }

        /// <summary>
        /// 测量时间
        /// </summary>
		public DateTime? Dt_vt {
            get { return getAttrVal<FDateTime>("Dt_vt",null); }
            set { setAttrVal<FDateTime>("Dt_vt", value); }
        }

        /// <summary>
        /// 测量项目ID
        /// </summary>
		public string Id_mrtplvtitm {
            get { return getAttrVal<string>("Id_mrtplvtitm",null); }
            set { setAttrVal<string>("Id_mrtplvtitm", value); }
        }

        /// <summary>
        /// 测量部位
        /// </summary>
		public string Id_vt_pos {
            get { return getAttrVal<string>("Id_vt_pos",null); }
            set { setAttrVal<string>("Id_vt_pos", value); }
        }

        /// <summary>
        /// 辅助措施
        /// </summary>
		public string Id_vt_aux {
            get { return getAttrVal<string>("Id_vt_aux",null); }
            set { setAttrVal<string>("Id_vt_aux", value); }
        }

        /// <summary>
        /// 值
        /// </summary>
		public string Value {
            get { return getAttrVal<string>("Value",null); }
            set { setAttrVal<string>("Value", value); }
        }

        /// <summary>
        /// 值1
        /// </summary>
		public string Value1 {
            get { return getAttrVal<string>("Value1",null); }
            set { setAttrVal<string>("Value1", value); }
        }

        /// <summary>
        /// 值2
        /// </summary>
		public string Value2 {
            get { return getAttrVal<string>("Value2",null); }
            set { setAttrVal<string>("Value2", value); }
        }

        /// <summary>
        /// 值3
        /// </summary>
		public string Value3 {
            get { return getAttrVal<string>("Value3",null); }
            set { setAttrVal<string>("Value3", value); }
        }

        /// <summary>
        /// 体征/事件编码
        /// </summary>
		public string Typecode {
            get { return getAttrVal<string>("Typecode",null); }
            set { setAttrVal<string>("Typecode", value); }
        }

        /// <summary>
        /// 生命体征属性主键
        /// </summary>
		public string Id_srvvt {
            get { return getAttrVal<string>("Id_srvvt",null); }
            set { setAttrVal<string>("Id_srvvt", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_mr", "Id_mrvt", "Id_mrvtitm", "Id_ent", "Id_mrtplvt", "Dt_vt", "Id_mrtplvtitm", "Id_vt_pos", "Id_vt_aux", "Value", "Value1", "Value2", "Value3", "Typecode", "Id_srvvt"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrpatsigns.d.CiMrHisDataDTO";
        }
    }
}
