using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderOutValidate : IValidate
    {
        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            if (headDo.Emsapout.Des_outtp != null && headDo.Emsapout.Des_outtp.Length >150)
            {
                errList.Add("字数超出了数据库的范围！");
            }

            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
