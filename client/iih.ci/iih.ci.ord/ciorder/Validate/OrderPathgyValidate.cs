using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderPathgyValidate : IValidate
    {

        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            //if (headDo.Emsappathgy.EmsItemInpathgy == null || headDo.Emsappathgy.EmsItemInpathgy.Count == 0)
            //{
            //    errList.Add("没有标本信息");
            //}
            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
