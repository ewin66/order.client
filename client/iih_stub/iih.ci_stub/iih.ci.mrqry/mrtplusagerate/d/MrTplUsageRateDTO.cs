using System;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.mr.d
{
    /// <summary>
    /// MrTplUsageRate 的摘要说明。
    /// </summary>
    public class MrTplUsageRateDTO : BaseDTO {

        public MrTplUsageRateDTO() {
 
        }

        /// <summary>
        /// 模板名称
        /// </summary>
		public string Name_template {
            get { return getAttrVal<string>("Name_template",null); }
            set { setAttrVal<string>("Name_template", value); }
        }

        /// <summary>
        /// 使用次数
        /// </summary>
		public string Count_usage {
            get { return getAttrVal<string>("Count_usage",null); }
            set { setAttrVal<string>("Count_usage", value); }
        }

        /// <summary>
        /// 门诊/住院记录总数
        /// </summary>
		public string Count_total {
            get { return getAttrVal<string>("Count_total",null); }
            set { setAttrVal<string>("Count_total", value); }
        }

        /// <summary>
        /// 使用率
        /// </summary>
		public string Rate_usage {
            get { return getAttrVal<string>("Rate_usage",null); }
            set { setAttrVal<string>("Rate_usage", value); }
        }

        /// <summary>
        /// 就诊类型
        /// </summary>
		public string Name_entp {
            get { return getAttrVal<string>("Name_entp",null); }
            set { setAttrVal<string>("Name_entp", value); }
        }

        /// <summary>
        /// 模板分类
        /// </summary>
		public string Name_doctype {
            get { return getAttrVal<string>("Name_doctype",null); }
            set { setAttrVal<string>("Name_doctype", value); }
        }

        /// <summary>
        /// 科室名称
        /// </summary>
		public string Name_dep {
            get { return getAttrVal<string>("Name_dep",null); }
            set { setAttrVal<string>("Name_dep", value); }
        }

        /// <summary>
        /// 创建人
        /// </summary>
		public string Name_mrtp_create {
            get { return getAttrVal<string>("Name_mrtp_create",null); }
            set { setAttrVal<string>("Name_mrtp_create", value); }
        }

        /// <summary>
        /// 主键
        /// </summary>
		public string Id_mr_tpl_ur {
            get { return getAttrVal<string>("Id_mr_tpl_ur",null); }
            set { setAttrVal<string>("Id_mr_tpl_ur", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[]{ "Name_template", "Count_usage", "Count_total", "Rate_usage", "Name_entp", "Name_doctype", "Name_dep", "Name_mrtp_create", "Id_mr_tpl_ur"};
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.d.MrTplUsageRate";
        }
    }
}
