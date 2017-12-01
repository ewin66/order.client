
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.rui.control.forms.view;
using xap.rui.engine;
using xap.cli.sdk.render;
using xap.rui.control.extentions;
using iih.ci.ord.ciorder.viewmodel.impext;
using iih.ci.iih.ci.ord.i;
using xap.cli.sdk.render.Items;

namespace iih.ci.ord.ciorder.utils
{
    /// <summary>
    /// <para>描    述 :           日期控件的最大和最小值设定          			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.ciorder.utils    </para>    
    /// <para>类 名 称 :  TimerComboBoxMaxAndMin					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  Administrator         				</para> 
    /// <para>修 改 人 :  Administrator         				</para> 
    /// <para>创建时间 :  2017/2/21 16:13:22             </para>
    /// <para>更新时间 :  2017/2/21 16:13:22             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2017. All rights reserved.</para> 
    /// </summary>
    public class TimerComboBoxMaxAndMin
    {
        private static TimerComboBoxMaxAndMin currentMaxAndMin;
        private TimerComboBoxMaxAndMin() { }
        public static TimerComboBoxMaxAndMin GetInstance() {
            if (currentMaxAndMin == null) {
                currentMaxAndMin = new TimerComboBoxMaxAndMin();
            }
            return currentMaxAndMin;
        }
        public void setMaxMinTime(XapFormControl xapFormControl1,BaseContext Context,string tabName,string itemkey,string id_ent) {
            UserRender us = xapFormControl1.GetUserRender(tabName, itemkey);
            if (us  != null && us.Renders[0] is XCalendarTimerComboBox)
            {
                XCalendarTimerComboBox dt_begin = us.Renders[0] as XCalendarTimerComboBox;
                if (dt_begin != null)
                {
                    DateTime datetime = this.NowTime();
                    dt_begin.TodayDateTime = datetime;
                    dt_begin.MinDate = new GetInHosTime().GetPatInHosTime(id_ent);
                    try
                    {
                        int maxHours = Context.GetGroupParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OrEarlyEntryMaxHours);
                        dt_begin.MaxDate = datetime.AddHours(maxHours);
                    }
                    catch //(Exception e)
                    {
                        this.ShowInfo("无法取得最大开立时间参数!");
                    }
                }
            }
            else if (us != null &&  us.Renders[0] is XCalendarComboBox)
            {
                XCalendarComboBox dt_begin = us.Renders[0] as XCalendarComboBox;
                if (dt_begin != null)
                {
                    DateTime datetime = this.NowTime();
                    dt_begin.TodayDate = datetime;
                    dt_begin.MinDate = new GetInHosTime().GetPatInHosTime(id_ent);
                    try
                    {
                        int maxHours = Context.GetGroupParam<int>(ICiOrdNSysParamConst.SYS_PARAM_OrEarlyEntryMaxHours);
                        dt_begin.MaxDate = datetime.AddHours(maxHours);
                    }
                    catch //(Exception e)
                    {
                        this.ShowInfo("无法取得最大开立时间参数!");
                    }
                }
            }
        }
        /// <summary>
        /// 设置时间控件的最大值
        /// </summary>
        /// <param name="xapFormControl1"></param>
        /// <param name="Context"></param>
        /// <param name="tabName"></param>
        /// <param name="itemkey"></param>
        /// <param name="datetime"></param>
        public void setMaxTime(XapFormControl xapFormControl1, BaseContext Context, string tabName, string itemkey, DateTime datetime)
        {
            UserRender us = xapFormControl1.GetUserRender(tabName, itemkey);
            if (us.Renders[0] is XCalendarTimerComboBox)
            {
                XCalendarTimerComboBox timebox = us.Renders[0] as XCalendarTimerComboBox;
                if (timebox != null)
                {
                    if (datetime != null)
                    {
                        timebox.MaxDate = datetime;
                    }
                    else {
                        timebox.MaxDate = null;
                    }
                }
            }
            else if (us.Renders[0] is XCalendarComboBox)
            {
                XCalendarComboBox timebox = us.Renders[0] as XCalendarComboBox;
                if (timebox != null)
                {
                    if (datetime != null)
                    {
                        timebox.MaxDate = datetime;
                    }
                    else
                    {
                        timebox.MaxDate = null;
                    }
                }
            }
        }
        /// <summary>
        /// 设置时间控件的最小值
        /// </summary>
        /// <param name="xapFormControl1"></param>
        /// <param name="Context"></param>
        /// <param name="tabName"></param>
        /// <param name="itemkey"></param>
        /// <param name="datetime"></param>
        public void setMinTime(XapFormControl xapFormControl1, BaseContext Context, string tabName, string itemkey, DateTime? datetime)
        {
            UserRender us = xapFormControl1.GetUserRender(tabName, itemkey);
            if (us.Renders[0] is XCalendarTimerComboBox)
            {
                XCalendarTimerComboBox timebox = us.Renders[0] as XCalendarTimerComboBox;
                if (timebox != null)
                {
                    if (datetime != null)
                    {
                        timebox.MinDate = datetime;
                    }
                    else
                    {
                        timebox.MinDate = null;
                    }
                }
            }
            else if (us.Renders[0] is XCalendarComboBox)
            {
                XCalendarComboBox timebox = us.Renders[0] as XCalendarComboBox;
                if (timebox != null)
                {
                    if (datetime != null)
                    {
                        timebox.MinDate = datetime;
                    }
                    else
                    {
                        timebox.MinDate = null;
                    }
                }
            }
        }
    }
}
