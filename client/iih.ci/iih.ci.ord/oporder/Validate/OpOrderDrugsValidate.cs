using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// 门诊西药数据验证
    /// </summary>
    class OpOrderDrugsValidate : IValidate
    {
        LogicEx cof = LogicEx.GetInstance();
        public bool OrdValivate(EmsUIDTO headDo, CiorderBaseControl ci)
        {
            
            List<string> errList = new List<string>();
            if (headDo.Emsdrugs.Use_days == null)
            {
                errList.Add("【"+headDo.Emsdrugs.Name_srv+"】使用天数不能为空, 请检查！");
            }
            else if (headDo.Emsdrugs.Use_days == 0)
            {
                errList.Add("【" + headDo.Emsdrugs.Name_srv + "】使用天数不能为 0天,请检查！");
            }
            if (headDo.Emsdrugs.EmsOrDrugList[0].Quan_cur == null || headDo.Emsdrugs.EmsOrDrugList[0].Quan_cur == 0)
            {
                errList.Add("【" + headDo.Emsdrugs.Name_srv +"】总量不能为空！请检查！");
            }
            #region 药品库存的判断
            string mmcounterror = LogicEx.GetInstance().validateDrugCount(headDo.Emsdrugs.EmsOrDrugList.ToList());
            if (!string.IsNullOrEmpty(mmcounterror))
            {
                errList.Add(mmcounterror);
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
