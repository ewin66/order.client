using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderConsValidate:IValidate
    {
        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            if (headDo.Emsapcons.EmsConsAssistItem.Count==0)
            {
                errList.Add("请录入协诊方！");
            }
            if (headDo.Emsapcons.EmsConsAssistItem.Count != 1)
            {
                string depid = "";
                foreach (EmsItemInCons item in headDo.Emsapcons.EmsConsAssistItem)
                {
                    if (depid != null || depid != "")
                    {
                        if (item.Id_dep_emp.Equals(depid))
                        {
                            errList.Add("请勿重复邀请同一个科室协诊！");
                            break;
                        }
                    }
                    depid = item.Id_dep_emp;
                } 
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
