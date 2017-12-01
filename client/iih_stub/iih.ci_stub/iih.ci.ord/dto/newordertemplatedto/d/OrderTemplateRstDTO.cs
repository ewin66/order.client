using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using iih.bd.srv.freqdef.d;

namespace iih.ci.iih.ci.ord.dto.newordertemplatedto.d
{
    public class OrderTemplateRstDTO : BaseDTO
    {
        /// <summary>
        ///  频次集合
        /// </summary>
        public Dictionary<Object, string> getFreqdefdo()
        {
            Dictionary<Object, string> frequcdic = new Dictionary<Object, string>();
            FArrayList freqdefList = (FArrayList)Freqdefdo["FreqDefDO"];
            foreach (FreqDefDO freqcdo in freqdefList)
            {
                frequcdic.Add(freqcdo.Id_freq, freqcdo.Name);
            }
            return frequcdic;
        }
        /// <summary>
        /// 频次
        /// </summary>
        public FMap Freqdefdo
        {
            get { return getAttrVal<FMap>("Freqdefdo", null); }
            set { setAttrVal<FMap>("Freqdefdo", value); }
        }
        /// <summary>
        /// 频次
        /// </summary>
        public FMap TemplItm
        {
            get { return getAttrVal<FMap>("TemplItm", null); }
            set { setAttrVal<FMap>("TemplItm", value); }
        }
        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "Freqdefdo", "TemplItm"};
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO";
        }
    }
}
