using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using xap.rui.control.forms.view;
using iih.ci.ord.ciorder.Validate;
using iih.ci.ord.ciorder.d;
using iih.ci.ord.common.utils.msg;
using iih.ci.ord.ciorder.cards;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// 医嘱数据的校验工具类
    /// </summary>
    public class OrderDataVerify
    {
        /// <summary>
        /// 校验医疗单上的必输项
        /// </summary>
        /// <param name="ci"></param>
        /// <returns></returns>
        public bool OrdValidateMustInput(CiorderBaseControl ci)
        {
            if (ci is OrdApBuView)
            {
                string errorInfo = ((OrdApBuView)ci).validateBeforeSave();
                if (!string.IsNullOrWhiteSpace(errorInfo))
                {
                    ci.OrdErrorList.Add(errorInfo);
                    return false;
                }
                return true;
            }
            foreach (var ctl in ci.Controls)
            {
              if (ctl is XapFormControl)
                {

                    if (((XapFormControl) ctl).HasErrors)
                    {
                        string errorstr = ((XapFormControl) ctl).ErrorAlertText;
                        ci.OrdErrorList.Add(string.IsNullOrEmpty(errorstr)? "请输入必填项":errorstr);
                        return false;

                    }
                }
            }
            return true;
        }

        /// <summary>
        /// 使用医疗单上挂接的校验对象进行校验
        /// </summary>
        /// <param name="headDo"></param>
        /// <param name="ci"></param>
        /// <returns></returns>
        public bool OrdBPValidate(EmsUIDTO headDo, CiorderBaseControl ci)
        {
            IValidate val = ci.GetOrdValidate();
            if (val != null)
            {
                return val.OrdValivate(headDo, ci);
            }
            return true;
        }

        /// <summary>
        /// 是否允许进行医嘱复制
        /// </summary>
        /// <param name="order">待复制的医嘱</param>
        /// <returns></returns>
        public static CiOrderDO[] getAllowedCopyOrders(CiOrderDO[] orders)
        {

            StringBuilder builder = new StringBuilder(); ;
            string srvtp = null;

            List<CiOrderDO> orderList = new List<CiOrderDO>();
            foreach (CiOrderDO order in orders)
            {
                srvtp = order.Sd_srvtp;
                //TODO BdSrvTpDictCodeConst 中对应的服务类型与目前使用的不一致，先使用数字等BdSrvTpDictCodeConst中调整后在做修改
                if (srvtp.StartsWith("01") || srvtp.StartsWith("02") || srvtp.StartsWith("03") || srvtp.StartsWith("05") || srvtp.StartsWith("08") || srvtp.StartsWith("1401"))
                {
                    orderList.Add(order);
                }
                else
                {
                    if (builder.Length == 0)
                    {                        
                        builder.Append("以下医嘱不支持复制：").Append(System.Environment.NewLine).Append(order.Name_or);
                    }
                    else
                    {
                        builder.Append("，").Append(order.Name_or);
                    }
                }
            }

            // 如果有异常信息弹出提示信息
            if (orderList.Count == 0)
            {
                builder.Append(System.Environment.NewLine).Append("请重新选择");
                BizAssMessageBoxUtil.ShowInforMsg(builder.ToString());
                return null;
            }
            else if (orderList.Count > 6) // 选择的可复制医嘱最大数超过6不允许复制
            {
                builder.Append(System.Environment.NewLine).Append("医疗单打开医嘱数最多支持6个，请重新选择！！");
                BizAssMessageBoxUtil.ShowInforMsg(builder.ToString());
                return null;
            }
            
            if (builder.Length != 0) { // 选中复制的医嘱中存在不允许复制，还有部分允许复制的医嘱
                        
                builder.Append(System.Environment.NewLine).Append("是否复制其余医嘱？");
                if (BizAssMessageBoxUtil.ShowConfirmMsg(builder.ToString()))
                {
                    return orderList.ToArray<CiOrderDO>();
                }
                else
                {
                    return null;
                }
            }
            return orderList.ToArray<CiOrderDO>();
        }

        #region 无用的 
        ////药品数据验证
        //public bool DrugDataVerify(EmsUIDTO headDo, CiorderBaseControl ci)
        //{
        //    if (headDo.Emsdrugs.Fg_outp.Value)
        //    {
        //        foreach (EmsOrDrug item in headDo.Emsdrugs.EmsOrDrugList)
        //        {
        //            if (item.Quan_cur==null||item.Quan_cur.Value==0)
        //            {
        //                ci.StrErrorInfo = "出院带药，必须填写总量！";
        //                return false;
        //            }

        //        }
        //    }

        //    return true;
        //} 
        #endregion
    }
}
