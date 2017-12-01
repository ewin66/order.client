using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.ord.ciordems.d.ext
{
    public class CheckRstDTO : BaseDTO
    {
        public CheckRstDTO()
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
        /// 医疗单类型
        /// </summary>
        public string EmsDriver
        {
            get { return getAttrVal<string>("EmsDriver", null); }
            set { setAttrVal<string>("EmsDriver", value); }
        }
        /// <summary>
        /// 返回信息集合
        /// </summary>
        public FArrayList RtnMsgList
        {
            get { return getAttrVal<FArrayList>("RtnMsgList", null); }
            set { setAttrVal<FArrayList>("RtnMsgList", value); }
        }
        /// <summary>
        ///提示信息
        /// </summary>
        public string TipMsg
        {
            get { return getAttrVal<string>("TipMsg", null); }
            set { setAttrVal<string>("TipMsg", value); }
        }
        /// <summary>
        ///提示类型：0 不处理；1 中断；2 提示是否继续；3 仅提示
        /// </summary>
        public int Eu_tiptp
        {
            get { return getAttrVal<int>("Eu_tiptp", 0); }
            set { setAttrVal<int>("Eu_tiptp", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Sd_srvtp", "EmsDriver", "RtnMsgList", "TipMsg" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.ciordems.d.ext.CheckRstDTO";
        }
    }
}
