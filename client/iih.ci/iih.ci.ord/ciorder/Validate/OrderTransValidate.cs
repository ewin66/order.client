using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderTransValidate : IValidate
    {
        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            if (headDo.Emsaptrans.Id_dep_to==headDo.Emsaptrans.Id_dep_from && headDo.Emsaptrans.Id_dep_nur_to==headDo.Emsaptrans.Id_dep_nur_from)
            {
                errList.Add("目标科室、目标病区不能与原科室、原病区相同！");
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
