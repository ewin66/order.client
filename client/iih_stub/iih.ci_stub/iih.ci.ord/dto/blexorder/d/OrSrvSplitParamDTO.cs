using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.dto.blexorder.d
{
    /// <summary>
    /// OrSrvSplitParamDTO 的摘要说明。
    /// </summary>
    public class OrSrvSplitParamDTO : BaseDTO {

        public OrSrvSplitParamDTO() {
 
        }

        /// <summary>
        /// 就诊主键串
        /// </summary>
		public string Id_ens {
            get { return getAttrVal<string>("Id_ens",null); }
            set { setAttrVal<string>("Id_ens", value); }
        }

        /// <summary>
        /// 医嘱主键串
        /// </summary>
		public string Id_ors {
            get { return getAttrVal<string>("Id_ors",null); }
            set { setAttrVal<string>("Id_ors", value); }
        }

        /// <summary>
        /// 服务类型主键串
        /// </summary>
		public string Sd_srvtps {
            get { return getAttrVal<string>("Sd_srvtps",null); }
            set { setAttrVal<string>("Sd_srvtps", value); }
        }

        /// <summary>
        /// 医嘱用法主键串
        /// </summary>
		public string Id_routes {
            get { return getAttrVal<string>("Id_routes",null); }
            set { setAttrVal<string>("Id_routes", value); }
        }

        /// <summary>
        /// 医嘱长临枚举项
        /// </summary>
		public int? Eu_orlongtemp {
            get { return getAttrVal<int?>("Eu_orlongtemp",null); }
            set { setAttrVal<int?>("Eu_orlongtemp", value); }
        }

        /// <summary>
        /// 护理单元
        /// </summary>
		public string Id_dep_nur {
            get { return getAttrVal<string>("Id_dep_nur",null); }
            set { setAttrVal<string>("Id_dep_nur", value); }
        }

        /// <summary>
        /// 执行科室
        /// </summary>
		public string Id_dep_mp {
            get { return getAttrVal<string>("Id_dep_mp",null); }
            set { setAttrVal<string>("Id_dep_mp", value); }
        }

        /// <summary>
        /// 服务项目串
        /// </summary>
		public string Id_srvs {
            get { return getAttrVal<string>("Id_srvs",null); }
            set { setAttrVal<string>("Id_srvs", value); }
        }

        /// <summary>
        /// 住院带药枚举项
        /// </summary>
		public int? Fg_pres_outp {
            get { return getAttrVal<int?>("Fg_pres_outp",null); }
            set { setAttrVal<int?>("Fg_pres_outp", value); }
        }

        /// <summary>
        /// 拆分开始时间
        /// </summary>
		public DateTime? Dt_split_start {
            get { return getAttrVal<FDateTime>("Dt_split_start",null); }
            set { setAttrVal<FDateTime>("Dt_split_start", value); }
        }

        /// <summary>
        /// 拆分结束时间
        /// </summary>
		public DateTime? Dt_split_end {
            get { return getAttrVal<FDateTime>("Dt_split_end",null); }
            set { setAttrVal<FDateTime>("Dt_split_end", value); }
        }

        /// <summary>
        /// 医嘱生成拆分类型枚举
        /// </summary>
		public int? Eu_orgensplittp {
            get { return getAttrVal<int?>("Eu_orgensplittp",null); }
            set { setAttrVal<int?>("Eu_orgensplittp", value); }
        }

        /// <summary>
        /// 附属字段
        /// </summary>
		public FMap Attachfields {
            get { return getAttrVal<FMap>("Attachfields",null); }
            set { setAttrVal<FMap>("Attachfields", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Id_ens", "Id_ors", "Sd_srvtps", "Id_routes", "Eu_orlongtemp", "Id_dep_nur", "Id_dep_mp", "Id_srvs", "Fg_pres_outp", "Dt_split_start", "Dt_split_end", "Eu_orgensplittp", "Attachfields"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO";
        }
    }
}
