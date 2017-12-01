using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.bd.bc.udi;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderOpValidate:IValidate
    {
        public bool OrdValivate( EmsUIDTO headDo, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            #region 计划手术时间大于申请时间
            if (headDo.Emsapop.Dt_plan<headDo.Emsapop.Dt_creat)
            {
               errList.Add("计划手术时间应大于手术申请时间！");
            }
            #endregion
            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            #region 将其他人员表中选择了角色但没有选择人员的数据去掉
            for (int i = headDo.Emsapop.OpEmpItem.Count - 1; i >= 0; i--)
            {
                if (string.IsNullOrEmpty(headDo.Emsapop.OpEmpItem[i].Id_emp_op) && !CiDictCodeConst.SD_OP_ROLE_ZDYS.Equals(headDo.Emsapop.OpEmpItem[i].Sd_role) && !CiDictCodeConst.SD_OP_ROLE_DYZS.Equals(headDo.Emsapop.OpEmpItem[i].Sd_role))
                {
                    headDo.Emsapop.OpEmpItem.RemoveAt(i);
                }
            }
            #endregion
            return true;
        }
    }
}
