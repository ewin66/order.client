using System;
using System.Collections.Generic;
using iih.ci.rcm.contagionrecordop.d;
using xap.mw.core.data;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagionrecordop.i
{
    class IContagionRecordQryServiceImpl : IContagionRecordQryService{

        private string url = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.contagionrecordop.i.IContagionRecordQryService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IContagionRecordQryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }


        public PagingRtnData<ContagionRecordOpDTO> getOpContagionQryDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<ContagionRecordOpDTO> rtn = si.invokePaging<ContagionRecordOpDTO>("getOpContagionQryDTOList", param.ToArray());
            return rtn;
        }

        public ContagionRecordOpDTO[] GetAllPageData() {
            si.url = url;
            List<object> param = new List<object>();
            ContagionRecordOpDTO[] rtn = si.invokeList<ContagionRecordOpDTO>("getAllPageData", param.ToArray());
            return rtn;
        }
    }
}
