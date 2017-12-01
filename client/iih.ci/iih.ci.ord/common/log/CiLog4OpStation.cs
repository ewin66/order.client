using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.cli.sdk.render;

namespace iih.ci.ord.common.log
{
    /// <summary>
    /// <para>描    述 :  门诊医生站日志管理     			</para>
    /// <para>说    明 :                     			</para>
    /// <para>项目名称 :  iih.ci.ord.common.log    </para>    
    /// <para>类 名 称 :  CiLog4OpStation					</para> 
    /// <para>版 本 号 :  v1.0.0.0           			</para> 
    /// <para>作    者 :  qzwang         				</para> 
    /// <para>修 改 人 :  qzwang         				</para> 
    /// <para>创建时间 :  10/17/2016 8:45:14 AM             </para>
    /// <para>更新时间 :  10/17/2016 8:45:14 AM             </para> 
    /// <para>Copyright @ 北大医信（IIH项目组） 2016. All rights reserved.</para> 
    /// </summary>
    public class CiLog4OpStation
    {
        private static LogManagerEX logManager = new LogManagerEX();
        
        public static void WriteLog(LogFile logFile, string msg)
        {
            logManager.WriteLog(logFile, msg);
        }
        public static void WriteLog(string logFile, string msg)
        {
            logManager.WriteLog(logFile, msg);
        }

        public static void WriteLog(String msg)
        {
            logManager.WriteLog("OpWorkStation_", msg);
        }
    }
}
