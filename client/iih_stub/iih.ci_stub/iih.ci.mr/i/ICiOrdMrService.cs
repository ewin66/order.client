using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.iih.ci.mr.i
{
    public interface ICiOrdMrService
    {
        /// <summary>
        /// 刷新门诊处置数据到病历
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        Dictionary<string, object> GetOrderMrDtoFlushList(String id_ent, String code_entp);
	
	
        /// <summary>
        /// 刷新门诊诊断到病历
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
	      String GetDiagList(String id_ent) ;
    }
}
