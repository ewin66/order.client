using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.coreitf.d;
using iih.ci.ord.ciordems.d;
using iih.ci.ord.ems.d;
using xap.mw.core.data;

namespace iih.ci.ord_stub.ciordems.s
{
    public class ICiordemsCrudServiceImpl<T>  
    {
        private string url = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.ciordems.i.ICiordermsCudService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.ciordems.i.ICiordermsRService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
        private CacheHelper<EmsUIDTO> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiordemsCrudServiceImpl()
        {
            ch = new CacheHelper<EmsUIDTO>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public EmsUIDTO[] find(String condition, string orderStr)
        {
            #region "缓存处理"
            //if (ch.IsCached("find"))
            //{
            //    return ch.find(condition, orderStr);
            //}
            #endregion
            List<object> param = new List<object>();
            param.Add(condition);
            param.Add(orderStr);
            //param.Add(isLazy);
            si.url = url_r;
            EmsUIDTO[] rtn = si.invokeList<EmsUIDTO>("find", param.ToArray());
            #region "数据缓存逻辑新增"
 
            #endregion
            return rtn;
        }

        #region "数据缓存逻辑新增"
        /// <summary>
        /// 查询返回数据的处理
        /// </summary>
        /// <param name="aggdos"></param>
        private void handleRtn(xap.mw.core.data.BaseDTO[] aggdos)
        {
            if (aggdos == null || aggdos.Length == 0 || aggdos.Length == 1) return;
            foreach (xap.mw.core.data.BaseDTO agg in aggdos)
            {
                //agg.service = this;
            }
        }
        #endregion

        #region
        // 性能优化，增加创建医疗单接口
        public FArrayList loadEms4Drug(CiEnContextDTO ctx, String id_srv, String id_mm)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);
            param.Add(id_mm);
            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Drug", param.ToArray());
           
        }
        public FArrayList loadEms4Ris(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);
     
            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Ris", param.ToArray());
        }
        public FArrayList loadEms4Lis(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);

            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Lis", param.ToArray());
        }
        public FArrayList loadEms4Ops(CiEnContextDTO ctx, String id_srv, String id_ems)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);
            param.Add(id_ems);
            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Ops", param.ToArray());
        }
        public FArrayList loadEms4Treat(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);
           
            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Treat", param.ToArray());
        }
        public FArrayList loadEms4Cons(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);

            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Cons", param.ToArray());
        }
        public FArrayList loadEms4Apbt(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);

            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Apbt", param.ToArray());
        }
        public FArrayList loadEms4Apbu(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);

            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Apbu", param.ToArray());
        }
        public FArrayList loadEms4Pathgy(CiEnContextDTO ctx, String id_srv)
        {
            List<object> param = new List<object>();
            param.Add(ctx);
            param.Add(id_srv);

            si.url = url_r;
            return si.invoke<FArrayList>("loadEms4Pathgy", param.ToArray());
        }
        #endregion
    }
}
