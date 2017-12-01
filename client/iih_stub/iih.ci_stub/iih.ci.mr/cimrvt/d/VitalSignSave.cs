using iih.ci.mr.cimr.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.mr.cimrvt.d
{
    public class VitalSignSave : BaseDTO
    {
        public VitalSignSave()
        {
        }

        public VitalSignSave(CiMrDO cimrDO, CimrvtAggDO aggDO)
        {
            CimrDO = cimrDO;
            AggDO = aggDO;
        }

        /// <summary>
        /// 医疗记录
        /// </summary>
        public CiMrDO CimrDO
        {
            get { return getAttrVal<CiMrDO>("CimrDO", null); }
            set { setAttrVal<CiMrDO>("CimrDO", value); }
        }

        /// <summary>
        /// 医疗记录模板
        /// </summary>
        public CimrvtAggDO AggDO
        {
            get { return getAttrVal<CimrvtAggDO>("AggDO", null); }
            set { setAttrVal<CimrvtAggDO>("AggDO", value); }
        }

        /// <summary>
        /// 返回属性列表
        /// </summary>
        /// <returns></returns>
        public override string[] getAttrNames()
        {
            return new string[] { "CimrDO", "AggDO" };
        }

        /// <summary>
        /// 返回全路径DO类名
        /// </summary>
        /// <returns></returns>
        public override string getFullClassName()
        {
            return "iih.ci.mr.cimrstblsec.d.VitalSignSave";
        }

    }
}
