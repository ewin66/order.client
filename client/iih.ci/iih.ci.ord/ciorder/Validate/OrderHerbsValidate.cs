using iih.ci.ord.ciordems.d;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciorder.viewmodel;
using iih.ci.ord.ciorder.utils;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// 草药数据验证
    /// </summary>
    class OrderHerbsValidate : IValidate
    {
        public bool OrdValivate(ciordems.d.EmsUIDTO headDo, CiorderBaseControl ci)
        {
            if (headDo.Emsdrugs.Orders < 1)
            {
                ci.OrdErrorList.Add("医嘱付数不能小于1");
            }
            if (headDo.IsOpData)
            { 
                if (headDo.Emsdrugs.Dt_end_ui != null && (headDo.Emsdrugs.Dt_begin_ui.Value<DateTime.Now.AddMinutes(-10)))
                ci.OrdErrorList.Add("开始日期不能在当前日期之前！");
                
            }
          

            if (headDo.Emsdrugs.Dt_end_ui != null && (headDo.Emsdrugs.Dt_begin_ui > headDo.Emsdrugs.Dt_end_ui))
                ci.OrdErrorList.Add("结束日期不能在开始日期之前！");
            //校验在开始时间和结束时间之间有没有有效执行顿数，没有给提示
            new OrderDrugHerbViewModel().judgeBeginEndTimeHasMpTimes(headDo.Emsdrugs.Dt_begin_ui, headDo.Emsdrugs.Dt_end_ui, headDo.Emsdrugs.Id_freq);
            if (headDo.Emsdrugs.EmsOrDrugList.Count==0)
            {
                ci.OrdErrorList.Add("没有任何药品！");
            }

            bool bcf = headDo.Emsdrugs.EmsOrDrugList.GroupBy(i => i.Id_mm).Where(g => g.Count() > 1).Count() >= 1;
            if (bcf)
            {
                ci.OrdErrorList.Add("药品有重复！");
            }
            #region 空药品
            if (headDo.Emsdrugs.EmsOrDrugList.Count(p => p.Id_srv == null || p.Id_srv == "" || p.Name_srv == null || p.Name_srv == "" || p.Spec_mm == null || p.Spec_mm == "" || p.Spec_mm == null || p.Spec_mm == "") > 0)
            {
                ci.OrdErrorList.Add("药品有空数据！");
            }

            #endregion

            #region 总量大于0
            foreach ( EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
            {
                if (item.Quan_med==null||item.Quan_med.ToDouble()<=0)
                {
                     ci.OrdErrorList.Add(item.Name_mm+"剂量必须大于0！");
                }
            }
            #endregion
            #region 药品库存的判断
            string mmcounterror = LogicEx.GetInstance().validateDrugCount(headDo.Emsdrugs.EmsOrDrugList.ToList());
            if (!string.IsNullOrEmpty(mmcounterror))
            {
                ci.OrdErrorList.Add(mmcounterror);
            }
            #endregion


            return true;
        }
    }
}
