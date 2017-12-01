using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using System.Globalization;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    class OrderCommonValidate : IValidate
    {
        public bool OrdValivate(EmsUIDTO uiDto, CiorderBaseControl ci)
        {
            List<string> errList = new List<string>();
            #region 开始日期不能小于入院日期
            string errMsg = LogicEx.GetInstance().CompareWithAdmission(uiDto.PatInfo.Id_ent, uiDto.Emsdrugs.Dt_begin_ui);
            if (!string.IsNullOrEmpty(errMsg))
            {
                errList.Add(errMsg);
            }
            #endregion

            #region 结束日期要大于开始日期
            DateTime? dtBegin = uiDto.Emsdrugs.Dt_begin_ui;
            DateTime? dtEnd = uiDto.Emsdrugs.Dt_end_ui;
            if (dtBegin != null && dtEnd != null) 
            {
                if (dtEnd < dtBegin) {
                    errList.Add(OrdParam.MESSAGE_TIEMCHECK);
                }
            }
            #endregion

            if (errList.Count > 0)
            {
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            return true;
        }
    }
}
