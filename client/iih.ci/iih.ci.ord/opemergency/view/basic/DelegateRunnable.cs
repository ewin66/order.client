using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using xap.mw.core.utils;
using xap.mw.log;
using xap.rui.appfw.async;
using xap.rui.appfw.extentions;

namespace iih.ci.ord.opemergency.view.basic
{
    class DelegateRunnable : IRunnable
    {
        private BaseFormBizView ownerView = null;

        public DelegateRunnable(BaseFormBizView v)
        {
            ownerView = v;
        }
        public void DirectCall(fNo_Rtn_Param_Three f, object[] szParam)
        {
            List<Object> listParam = new List<object>();
            listParam.Add(f);
            foreach (object p in szParam)
            {
                listParam.Add(p);
            }
          
            AsyncExecute(InnerRunDelegate, listParam);
        }

        public void DirectCall(fNo_Rtn_Param_Two f, object[] szParam)
        {
            List<Object> listParam = new List<object>();
            listParam.Add(f);
            foreach(object p in szParam)
            {
                listParam.Add(p);
            }
            
            AsyncExecute(InnerRunDelegate, listParam);
        }

        public void DirectCall(fNo_Rtn_Param_One f, object param)
        {
            List<Object> listParam = new List<object>();
            listParam.Add(f);
            listParam.Add(param);
            AsyncExecute(InnerRunDelegate, listParam);
        }

        protected void InnerRunDelegate( object p)
        {
            List<Object> listParam = p as List<Object>;
            if (listParam.Count == 2)
            {
                fNo_Rtn_Param_One tmpFunction = (fNo_Rtn_Param_One)listParam[0];
                
                listParam.Remove(tmpFunction);
                ownerView.Invoke(tmpFunction, listParam.ToArray());
            }
            else if (listParam.Count == 3)
            {
                fNo_Rtn_Param_Two tmpFunction = (fNo_Rtn_Param_Two)listParam[0];
                listParam.Remove(tmpFunction);
                ownerView.Invoke(tmpFunction, listParam.ToArray());
            }
            else if (listParam.Count == 4)
            {
                fNo_Rtn_Param_Three tmpFunction = (fNo_Rtn_Param_Three)listParam[0];
                listParam.Remove(tmpFunction);
                ownerView.Invoke(tmpFunction, listParam.ToArray());
            }
        }

        private void AsyncExecute(WaitCallback callBack, object param)
        {
            AsyncExecuteDelegate workDelegate = workArgs =>
            {
                // 异步调用。返回结果保存在参数的Result中。
                workArgs.Result = param;
            };

            AsyncDoneDelegate doneDelegate = doneArgs =>
            {
                //如果已经取消了，则返回
                if (doneArgs.Cancelled)
                    return;
                //如果异步执行时发生了异常，可以在这里处理
                if (doneArgs.Error != null)
                {
                    Exception ex = doneArgs.Error;
                    //记录日志
                    LogManager.GetLogger().ErrorEx(ex.Message, ex);
                    //发布异常到UI
                    ex.Publish();
                    //标记为已处理异常，如果不标记，框架会抛出异常
                    doneArgs.ErrorHandled = true;
                    return;
                }

                //异步执行完毕后，处理异步数据结果
                InnerRunDelegate(doneArgs.Result);
            };

            workDelegate.AsyncExecute(param, doneDelegate);
        }

    }
}
