using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordsysparam;

namespace iih.ci.ord.opemergency.tool
{
    public class SysParamUtils 
    {
        private static CiorderSysParamDTO SysParam = new CiorderSysParamDTO();

        private SysParamUtils() { }
        /// <summary>
        /// 获得系统参数
        /// </summary>
        /// <returns></returns>
        public static CiorderSysParamDTO getSysParam()
        {
            if (SysParam == null)
            {
                SysParam = new CiorderSysParamDTO();
            }
            return SysParam;
        }

        public static void Clear()
        {
            if (SysParam != null)
            {
                var cst = new AssCostTimeTool("清理本地缓存 - 系统参数缓存（SysParamUtils）： ", true);
                SysParam.Clear();
                cst.SaveTimeLog();
            }
        }

    }
}
