using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    internal class OrderAplabValidate : IValidate
    {
        public bool OrdValivate(EmsUIDTO headDo, CiorderBaseControl ci) {
            List<string> errList = new List<string>();

            if (headDo.Emsaplab.EmsOrObsList== null || headDo.Emsaplab.EmsOrObsList.Count == 0)
                errList.Add("请选择一个检验项目！");

            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
