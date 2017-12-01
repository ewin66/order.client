using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderApobsValidate : IValidate
    {
        public bool OrdValivate(EmsUIDTO headDo, CiorderBaseControl ci)
        {
            LogicEx logicEx = LogicEx.GetInstance();
            List<string> errList = new List<string>();

            if (headDo.Emsapobs.EmsOrObsList == null || headDo.Emsapobs.EmsOrObsList.Count == 0)
            {
                errList.Add("请选择检查项目");
            }
            if (headDo.Emsapobs.EmsOrObsList.Count > 0)
            {
                bool isTrue = false;
                foreach (EmsObsLap obs in headDo.Emsapobs.EmsOrObsList)
                {
                    if (obs.Name_srv == null || obs.Name_srv=="")
                    {
                        isTrue = true;
                    }
                }
                if (isTrue)
                {
                    errList.Add("检查项目不能空");
                }
              
            }

            //if (headDo.Emsapobs.Dt_plan < logicEx.GetServerDataTime())
            //    errList.Add("检查时间不能小于当前时间！");

            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
