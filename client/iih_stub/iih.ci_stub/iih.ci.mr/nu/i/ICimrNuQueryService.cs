using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;

namespace iih.ci.mr.nu.i
{
    public interface ICimrNuQueryService
    {
        /// <summary>
        /// 护理文书基础服务
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="fullClassName"></param>
        /// <returns></returns>
        BaseDO initData(string id_ent, string fullClassName);

        /// <summary>
        /// 刷新文书患者数据
        /// </summary>
        /// <param name="baseDo"></param>
        /// <returns></returns>
        BaseDO refreshData(BaseDO baseDo);
    }
}
