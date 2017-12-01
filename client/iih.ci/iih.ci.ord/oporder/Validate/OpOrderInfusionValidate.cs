using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// 门诊注射数据验证
    /// </summary>
    class OpOrderInfusionValidate : IValidate
    {
        LogicEx cof = LogicEx.GetInstance();
        public bool OrdValivate(EmsUIDTO headDo, CiorderBaseControl ci)
        {
            
            List<string> errList = new List<string>();
            if (headDo.Emsdrugs.Use_days == null || headDo.Emsdrugs.Use_days == 0)
            {
                errList.Add( "医嘱使用天数不能为空！请检查！");
            }
            foreach (EmsOrDrug ems in headDo.Emsdrugs.EmsOrDrugList)
            {
                if (ems.Quan_cur == null || ems.Quan_cur == 0)
                {
                    errList.Add("【"+ems.Name_srv +"】总量不能为空！请检查！");
                    break;
                }
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
