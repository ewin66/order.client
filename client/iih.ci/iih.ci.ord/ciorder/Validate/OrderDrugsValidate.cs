using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ciorder.utils;
using iih.bd.bc.udi;

namespace iih.ci.ord.ciorder.Validate
{
    /// <summary>
    /// 住院西药数据验证
    /// </summary>
    class OrderDrugsValidate : IValidate
    {
        LogicEx cof = LogicEx.GetInstance();
        public bool OrdValivate(EmsUIDTO headDo, CiorderBaseControl ci)
        {
            
            
            List<string> errList = new List<string>();
            if (headDo.Emsdrugs.EmsOrDrugList.Count == 0)
            {
                errList.Add("请选择药品服务！");
                ci.OrdErrorList.AddRange(errList);
                return false;
            }
            #region 出院带药下必须填写总量
            if (headDo.Emsdrugs.Fg_outp.Value)
            {
                foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
                {
                    if (item.Quan_cur == null || item.Quan_cur.ToDouble() <= 0)
                    {
                        errList.Add("出院带药必须填写总量,且大于0！");
                    }
                    if (item.Name_unit_sale == null || item.Name_unit_sale == "")
                    {
                        errList.Add("出院带药必须填写总量单位！");
                    }
                }
            }
            foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
            {
                if (item.Quan_med == null || item.Quan_med.ToDouble() <= 0)
                {
                    errList.Add(item.Name_srv+"剂量不能为空且要求大于0！");
                }
            }
            #endregion
            #region 长期标志下，使用天数必填

            #endregion
            #region 总量不能为0
            //foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
            //{
            //    if (item.Quan_cur == null || item.Quan_cur.Value == 0 || item.Quan_cur.Value < 0)
            //    {
            //        errList.Add("总量必须大于0！");
            //    }
            //}
            #endregion

            #region 执行次数不能大于频次数
            if (!headDo.IsOpData)
            {
                //if (headDo.Emsdrugs.Quan_firday_mp == null)
                //{
                //    errList.Add("首次执行次数不能为空！");
                //}
                if ((headDo.Emsdrugs.Freqct != null) && (headDo.Emsdrugs.Quan_firday_mp > headDo.Emsdrugs.Freqct))
                {
                    errList.Add("首次执行次数不能大于医嘱频次数！");
                }
            }


            #endregion

            #region

            #endregion

            #region 开始日期不能小于入院日期
            string errMsg = cof.CompareWithAdmission(headDo.PatInfo.Id_ent, headDo.Emsdrugs.Dt_begin_ui);
            if (!string.IsNullOrEmpty(errMsg))
            {
                errList.Add(errMsg);
            }
            #endregion



            #region 结束日期不能小于开始日期
            if (headDo.Emsdrugs.Dt_end_ui != null && (headDo.Emsdrugs.Dt_begin_ui > headDo.Emsdrugs.Dt_end_ui))
                errList.Add("结束日期不能在开始日期之前！");

            #endregion



            #region  频次=星期时，当录入值必须为7的倍数
            if (!string.IsNullOrEmpty(headDo.Emsdrugs.Sd_srvtp) && headDo.Emsdrugs.Sd_srvtp.Equals(BdSrvDictCodeConst.SD_FREQUNIT_WEEK) && headDo.Emsdrugs.Use_days % 7 != 0)
            {
                errList.Add("周为频次下，天数必须是7的倍数!");
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
