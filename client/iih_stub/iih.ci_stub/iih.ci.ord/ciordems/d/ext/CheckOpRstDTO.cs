using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;

namespace iih.ci.ord.ciordems.d.ext
{
    public class CheckOpRstDTO : BaseDTO
    {
        public CheckOpRstDTO()
        {

        }

        /// <summary>
        /// 医嘱id
        /// </summary>
        public string Id_or
        {
            get { return getAttrVal<string>("Id_or", null); }
            set { setAttrVal<string>("Id_or", value); }
        }

        /// <summary>
        /// 服务id
        /// </summary>
        public string Id_srv
        {
            get { return getAttrVal<string>("Id_srv", null); }
            set { setAttrVal<string>("Id_srv", value); }
        }

        /// <summary>
        /// 计划手术时间
        /// </summary>
        public DateTime? Dt_plan
        {
            get { return getAttrVal<FDateTime>("Dt_plan", null); }
            set { setAttrVal<FDateTime>("Dt_plan", value); }
        }

        /// <summary>
        /// 麻醉分类
        /// </summary>
        public int? Eu_anesca
        {
            get { return getAttrVal<int?>("Eu_anesca", null); }
            set { setAttrVal<int?>("Eu_anesca", value); }
        }
        
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Id_or", "Id_srv", "Dt_plan", "Eu_anesca"};
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.ext.CheckOpRstDTO";
        }
    }
}
