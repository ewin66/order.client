using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciordems.d {
    public enum OrdPicStatusIndex
    {
        /// <summary>
        /// 开立
        /// </summary>
        OPEN = 0,
        /// <summary>
        /// 签署
        /// </summary>
        SIGN = 10,
        /// <summary>
        /// 确认
        /// </summary>
        CONFIRM = 20,
        /// <summary>
        /// 执行中
        /// </summary>
        EXEC = 21,
        /// <summary>
        /// 确认+预停
        /// </summary>
        CONFRIM_PRESTOP = 22,
        /// <summary>
        /// 执行中+预停
        /// </summary>
        EXEC_PRESTOP = 23,
        /// <summary>
        /// 确认+停止
        /// </summary>
        CONFIRM_STOP = 50,
        /// <summary>
        /// 执行中+停止
        /// </summary>
        EXEC_STOP = 51,
        /// <summary>
        /// 完成
        /// </summary>
        OVER = 60,
        /// <summary>
        /// 取消
        /// </summary>
        CANCEL = 61,
        /// <summary>
        /// 不执行
        /// </summary>
        NOTEXEC = 62,
        /// <summary>
        /// 作废
        /// </summary>
        OBSOLETE = 70,
        /// <summary>
        /// 已作废
        /// </summary>
        CANCELLED = 80,
        /// <summary>
        /// 未知状态
        /// </summary>
        UNKNOW = 11
    }
}
