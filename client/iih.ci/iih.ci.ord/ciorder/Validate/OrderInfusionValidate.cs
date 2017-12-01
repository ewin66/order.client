using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// iv药保存数据验证
    /// </summary>
    class OrderInfusionValidate : IValidate
    {
        LogicEx cof = LogicEx.GetInstance();
        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            #region 出院带药下必须填写总量
            List<string> errList = new List<string>();
            if (headDo.Emsdrugs.Fg_outp != null && headDo.Emsdrugs.Fg_outp.Value)
            {
                foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
                {
                    if (item.Quan_cur == null || item.Quan_cur.ToDouble() <= 0)
                    {
                        errList.Add("出院带药必须填写总量,且大于0！");
                    }

                }
            }
            #endregion

            #region 开始日期不能小于入院日期
            if (!headDo.IsOpData)
            {
                string errMsg = cof.CompareWithAdmission(headDo.PatInfo.Id_ent, headDo.Emsdrugs.Dt_begin_ui);
                if (!string.IsNullOrEmpty(errMsg))
                {
                    errList.Add(errMsg);
                }
            }
            #endregion


            #region 结束日期不能大于开始日期
            if (headDo.Emsdrugs.Dt_end_ui != null && (headDo.Emsdrugs.Dt_begin_ui > headDo.Emsdrugs.Dt_end_ui))
                errList.Add("结束日期不能在开始日期之前！");

            #endregion



            bool bcf = headDo.Emsdrugs.EmsOrDrugList.GroupBy(i => i.Id_mm).Where(g => g.Count() > 1).Count() >= 1;
            if (bcf)
            {
                ci.OrdErrorList.Add("药品有重复！");
            }
            #region 空药品
            if (headDo.Emsdrugs.EmsOrDrugList.Count(p => p.Id_srv == null || p.Id_srv == "") > 0)
            {
                ci.OrdErrorList.Add("药品有空数据！");
            }

            #endregion

            #region 总量大于0
            foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
            {
                if (item.Quan_med == null || item.Quan_med.ToDouble() <= 0)
                {
                    ci.OrdErrorList.Add(item.Name_mm + "剂量必须大于0！");
                }
            }
            #endregion


            #region 药品不能为空
            if (headDo.Emsdrugs.EmsOrDrugList.Count == 0)
            {
                errList.Add("药品不能为空！");
            }
            #endregion
            #region
            if (headDo.Emsdrugs.Use_days < 0)
            {
                errList.Add("用药天数小于0！");
            }
            #endregion
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
