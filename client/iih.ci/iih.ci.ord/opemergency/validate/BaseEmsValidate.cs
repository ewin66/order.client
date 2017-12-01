using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.opemergency.ems;
using xap.rui.control.forms.view;
using iih.ci.ord.opemergency.ems.common;
using xap.cli.sdk.controls;
using iih.ci.ord.opemergency.view;

namespace iih.ci.ord.opemergency.validate
{
    /// <summary>
    /// 医疗单有效性检查基类 - 必填项检查
    /// </summary>
    public class BaseEmsValidate : IEmsValidate
    {
        public virtual bool OrdValivate(object model, BaseEmsView sender)
        {
            sender.OrdErrorList.Clear();
            #region 必填项检查

            foreach (var ctl in sender.Controls)
            {
                if (ctl is XapFormControl)
                {
                    if (((XapFormControl)ctl).HasErrors)
                    {
                        sender.OrdErrorList.Add(String.IsNullOrEmpty((ctl as XapFormControl).ErrorAlertText)?"请将必填项填写完整" : (ctl as XapFormControl).ErrorAlertText);
                        return false;
                    }
                }
                else if(ctl is XLayoutPanel)
                {
                    foreach(var ctrTemp in (ctl as XLayoutPanel).Controls)
                    {
                        if (ctrTemp is BaseFormBizView)
                        {
                            if (((BaseFormBizView)ctrTemp).ExistErrors())
                            {
                                sender.OrdErrorList.Add(String.IsNullOrEmpty(((BaseFormBizView)ctrTemp).GetErrorText()) ? "请将必填项填写完整" : ((BaseFormBizView)ctrTemp).GetErrorText());
                                return false;
                            }
                        }
                    }
                }
            }
            #endregion
            return true;
        }
    }
}
