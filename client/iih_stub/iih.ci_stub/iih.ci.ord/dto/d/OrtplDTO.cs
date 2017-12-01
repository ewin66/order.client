using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using iih.bd.srv.ortpl.d;

namespace iih.ci.ord_stub.dto.d
{
    public class OrtplDTO : BaseDTO
    {
        public OrtplDTO()
        {
        }
        /// <summary>
        /// 包含的服务类型
        /// </summary>
        public string sd_srvtp
        {
            get { return getAttrVal<string>("Sd_srvtp", null); }
            set { setAttrVal<string>("Sd_srvtp", value); }
        }

        /// <summary>
        /// 包含排除的服务类型
        /// </summary>
        public string excludeSd_srvtp
        {
            get { return getAttrVal<string>("ExcludeSd_srvtp", null); }
            set { setAttrVal<string>("ExcludeSd_srvtp", value); }
        }
        /// <summary>
        /// 查询关键字
        /// </summary>
        public string strWhere
        {
            get { return getAttrVal<string>("StrWhere", null); }
            set { setAttrVal<string>("StrWhere", value); }
        }
        /// <summary>
        /// 模板对象
        /// </summary>
        public OrTplDO model
        {
            get { return getAttrVal<OrTplDO>("Model", null); }
            set { setAttrVal<OrTplDO>("Model", value); }
        }
        /// <summary>
        /// 医保计划
        /// </summary>
        public string Healthca
        {
            get { return getAttrVal<string>("Healthca", null); }
            set { setAttrVal<string>("Healthca", value); }
        }
        public override string[] getAttrNames()
        {
            return new string[] { "Sd_srvtp", "ExcludeSd_srvtp", "StrWhere", "Model", "Healthca" };
        }
        
        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.d.OrtplDTO";
        }
    }
}
