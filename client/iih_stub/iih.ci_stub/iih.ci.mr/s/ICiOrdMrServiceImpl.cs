using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.iih.ci.mr.i;
using xap.mw.serviceframework;
using xap.mw.core.data;

namespace iih.ci.iih.ci.mr.i
{
    public class ICiOrdMrServiceImpl : ICiOrdMrService
    {

        /// <summary>
        /// 接口地址
        /// </summary>
        private string url = XapSvrConfig.BaseUrl + "iihci.mr/iih.ci.mr.i.ICiOrdMrFlushData";
        /// <summary>
        /// 调接口服务
        /// </summary>
        private ServiceInvocation si;


        public ICiOrdMrServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 刷新门诊处置数据到病历
        /// </summary>
        /// <param name="id_ent"></param>
        /// <param name="code_entp"></param>
        /// <returns></returns>
        public  Dictionary<String,object> GetOrderMrDtoFlushList(String id_ent, String code_entp)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(code_entp);
            FMap2 map =  si.invoke < FMap2>("getOrderMrDtoFlushList", ps.ToArray());

            Dictionary<String, object> dic = new Dictionary<string, object>();
            foreach (string key in map.Keys)
            {
                dic.Add(key, map[key]);
            }
            return dic;
        }


        /// <summary>
        /// 刷新门诊诊断到病历
        /// </summary>
        /// <param name="id_ent"></param>
        /// <returns></returns>
        public  String GetDiagList(String id_ent)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            string str = string.Empty;
            try
            {
                str = si.invokeString("getDiagList", ps.ToArray());
            }
            catch //(Exception ex)
            {
                
                throw;
            }
            return str;
        }
    }
}
