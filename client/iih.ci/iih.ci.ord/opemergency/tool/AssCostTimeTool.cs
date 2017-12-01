
using iih.ci.ord.common.log;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.log;
using xap.rui.control.extentions;

namespace iih.ci.ord.opemergency.tool
{
    /// <summary>
    /// <para>描    述 :                     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.opemergency.tool    </para>    
    /// <para>类 名 称 :  Class1					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  vivi         				</para> 
    /// <para>修 改 人 :  vivi         				</para> 
    /// <para>创建时间 :  11/7/2016 5:27:40 PM             </para>
    /// <para>更新时间 :  11/7/2016 5:27:40 PM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class AssCostTimeTool
    {
        bool bAuto = false;
        String mDescription = "耗时：";
        System.Diagnostics.Stopwatch stopwatch = new System.Diagnostics.Stopwatch();
        DateTime tBeginTime;
        public static bool Enabled = true;
        public AssCostTimeTool(String desc,bool auto)
        {
            if (Enabled) {
                tBeginTime = this.NowTime();
                mDescription = desc;
                bAuto = auto;
                stopwatch.Start();
            }
           
        }

        public void Reset(String d)
        {
            if (Enabled) {
                tBeginTime = this.NowTime();
                this.mDescription = d;
                stopwatch.Reset();
                stopwatch.Restart();
            }
        }

        public void SaveTimeLog()
        {
            if (Enabled) {
                stopwatch.Stop();
                String msg = String.Format("【CI】{0} {1} 毫秒。 (开始：{2} 到 {3})", mDescription,
                    stopwatch.ElapsedMilliseconds, tBeginTime.ToString("yyyy-MM-dd HH:mm:ss.fff"), this.NowTime().ToString("yyyy-MM-dd HH:mm:ss.fff"));
                LogManager.GetLogger().DebugEx(msg);
                CiLog4OpStation.WriteLog(msg);
            }
        }
        ~AssCostTimeTool()
        {
            if (Enabled) {
                if (bAuto) {
                    SaveTimeLog();
                }
            }
        }
    }
}
