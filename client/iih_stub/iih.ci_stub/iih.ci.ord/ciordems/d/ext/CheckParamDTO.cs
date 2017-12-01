using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.ord.ciordems.d.ext
{
    public class CheckParamDTO : BaseDTO
    {
        public CheckParamDTO()
        {

        }
        /// <summary>
        /// 服务类型编码
        /// </summary>
        public string Sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }
        /// <summary>
        /// 就诊号
        /// </summary>
        public string Id_en
        {
            get { return getAttrVal<string>("Id_en", null); }
            set { setAttrVal<string>("Id_en", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Sd_srvtp", "Id_en"};
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.ext.CheckParamDTO";
        }
    }
}
