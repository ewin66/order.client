using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.ord.ciordems.d;
using iih.ci.ord_stub.service.i;
using xap.mw.serviceframework;
using xap.rui.appfw;
using iih.ci.ord.ems.d;

namespace iih.ci.ord_stub.service.i
{
    class ICiOrdCrudServiceImpl: ICiOrdCrudService
    {
        private string url = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiOrdMaintainService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "xap.ci.ord/iih.ci.ord.i.ICiOrdQryService";//ConfigUtil.getServiceUrl();
        
        private ServiceInvocation si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public ICiOrdCrudServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        public void delete(EmsUIDTO[] dos, EmsType orderType)
        {
            throw new NotImplementedException();
        }

        public EmsUIDTO[] insert(EmsUIDTO[] dos, EmsType orderType)
        {
            throw new NotImplementedException();
        }

        public EmsUIDTO[] save(EmsUIDTO[] dos, EmsType orderType)
        {
            throw new NotImplementedException();
        }

        public EmsUIDTO[] update(EmsUIDTO[] dos, EmsType orderType)
        {
            throw new NotImplementedException();
        }

        public void logicDelete(EmsUIDTO[] dos, EmsType orderType)
        {
            throw new NotImplementedException();
        }

        public EmsUIDTO findById(string id, string orderType,string code_entp,CiEnContextDTO contextdto=null)
        {
            #region "缓存处理"
            //if (ch.IsCached("find"))
            //{
            //    return ch.find(condition, orderStr);
            //}
            #endregion
            List<object> param = new List<object>();
            param.Add(id);
            param.Add(orderType);
            param.Add(code_entp);
            param.Add(contextdto);
            si.url = url_r;
            EmsUIDTO rtn = si.invoke<EmsUIDTO>("getEmsHeadDO", param.ToArray());
            #region "数据缓存逻辑新增"

            #endregion
            return rtn;
        }

        
        public EmsUIDTO[] find(String condition, string orderStr, EmsType orderType)
        {
            return null; 
        }
    }
}
