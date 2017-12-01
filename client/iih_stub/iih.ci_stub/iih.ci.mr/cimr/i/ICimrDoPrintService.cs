using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mr.cimr.d;

namespace iih.ci.mr.cimr.i
{
    public interface ICimrDoPrintService
    {
        /// <summary>
        /// 获取打印流
        /// </summary>
        /// <param name="Id_ent"> 就诊id</param>
        /// <param name="Id_mrcactm">自定义类型</param>
        /// <returns></returns>
        CiMrDO[] getCimrDo(String id_ent, String Id_mrcactm);
    }
}
