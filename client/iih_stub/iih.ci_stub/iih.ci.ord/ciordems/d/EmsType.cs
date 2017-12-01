using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.ord.ciordems.d {
    public enum EmsType {
        /// <summary>
        /// 通用药品
        /// </summary>
        COMMONDRUG = 0,
        /// <summary>
        /// 检查
        /// </summary>
        RIS = 1,
        /// <summary>
        /// 检验
        /// </summary>
        LIS = 2,
        /// <summary>
        /// Iv药
        /// </summary>
        IV = 3,
        /// <summary>
        /// 草药
        /// </summary>
        HERB = 4,
        /// <summary>
        /// 手术
        /// </summary>
        OPER = 5,
        /// <summary>
        /// 病理
        /// </summary>
        PATHGY = 6,
        /// <summary>
        /// 备血
        /// </summary>
        BT = 7,
        /// <summary>
        /// 简洁
        /// </summary>
        COMMON = 8,
        /// <summary>
        /// 会诊
        /// </summary>
        CONS = 9,
        /// <summary>
        /// 皮试医疗单
        /// </summary>
        SKINTEST = 10,
        /// <summary>
        /// 用血
        /// </summary>
        BTUSE = 11,
        /// <summary>
        /// 出院
        /// </summary>
        OUTHOSP = 12,
        /// <summary>
        /// 转科
        /// </summary>
        TRANSDEPT = 13,
        /// <summary>
        /// 转病区
        /// </summary>
        TRANSWARD = 14,
    }
}
