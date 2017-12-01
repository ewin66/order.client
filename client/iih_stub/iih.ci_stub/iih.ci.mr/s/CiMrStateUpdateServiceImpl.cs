using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;

namespace iih.ci.iih.ci.mr.i
{
    public class ICiMrStateUpdateServiceImpl : ICiMrStateUpdateService
    {
         /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.ICiMrStateUpdateService";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;

        /// <summary>
        /// 构造函数 
        /// 初始化数据
        /// </summary>
        public ICiMrStateUpdateServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 根据id_ent更新病历的提交（ci_mr表）、归档(ci_amr表)状态
        /// </summary>
        /// <returns></returns>
        public void UpdateSubmitAndPigeonholeStateByIdEnt(string id_ent)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            si.invokeString("updateSubmitAndPigeonholeStateByIdEnt", ps.ToArray());
        }
    }
}
