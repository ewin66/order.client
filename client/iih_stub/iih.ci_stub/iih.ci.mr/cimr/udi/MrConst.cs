using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace iih.ci.mr_stub.cimr.udi
{
    public static class MrConst
    {
        //    	0X-门诊  1x-急诊  2X-住院      3X-体检   （ X5-接诊  X8-诊毕) 
        //    	01 预约  02挂号 05 就诊  08诊毕  0a续诊  （del： 03-分诊  04-叫号   0b叫号未到 ，因为这三个状态放入en_ent_que中）
        //    	11 登记，15 接诊，18诊毕，13 出报告
        //    	21 预约   22-入院   25-入科  28出院     2a退院
        //    	31 登记，35 接诊，38诊毕，39 出报告

       public static string  PATOUTSTATUS = "08,18,28,38";
    }
}
