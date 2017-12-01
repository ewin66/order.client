using System;
using System.Collections.Generic;
//using iih.ci.rcm.contagion.s.itf;
using xap.mw.core.utils;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.mw.core.data;
using xap.sys.appfw.tmpl.qryscheme; 
using iih.ci.rcm.contagion.d;
using iih.ci.rcm.contagion.dto;
using iih.ci.rcm.contagion.dto.d;
using xap.sys.basebiz.appfwdata;
using xap.sys.appfw.tmpl.qryscheme.qrydto;

namespace iih.ci.rcm.contagion.i
{
    public class IContagionCrudServiceExtImpl : IContagionCrudServiceExt
    {
        
        private string url   = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.contagion.i.IContagionCudServiceExt";//ConfigUtil.getServiceUrl();
       
        
        private ServiceInvocation si;
        private CacheHelper<Contagiondto> ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IContagionCrudServiceExtImpl()
        {
            ch = new CacheHelper<Contagiondto>();
            si = new ServiceInvocationImpl();
            si.url = url;
        }

   

        /// <summary>
        /// 根据id值查找组件AggDO数据
        /// </summary>
        /// <param name="id"></param>
        /// <returns></returns>
        public Contagiondto[] getCotagions(String id_ent)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            Contagiondto[] rtn = si.invokeList<Contagiondto>("getCotagions", param.ToArray());
            return rtn;
        }

        public Contagiondto[] getCotagionlist(String id_ent)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            Contagiondto[] rtn = si.invokeList<Contagiondto>("getCotagionlist", param.ToArray());
            return rtn;
        }

        public Contagiondto[] getChildCotagions(String p_id)
        {
            List<object> param = new List<object>();
            param.Add(p_id);
            Contagiondto[] rtn = si.invokeList<Contagiondto>("getChildCotagions", param.ToArray());
            return rtn;
        }

        public EntDto[] getEnts(QryRootNodeDTO qryRootNodeDTO)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            EntDto[] rtn = si.invokeList<EntDto>("getEnts", param.ToArray());
            return rtn;
        }
        public EntDto[] getEnts2(QryRootNodeDTO qryRootNodeDTO)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            EntDto[] rtn = si.invokeList<EntDto>("getEnts2", param.ToArray());
            return rtn;
        }


        public PagingRtnData<EntDto> getEntDTOList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
        {
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            param.Add(paginationInfo);
            si.url = url;
            PagingRtnData<EntDto> rtn = si.invokePaging<EntDto>("getEntDTOList", param.ToArray());
            return rtn;
        }

        public EntDto[] GetAllPageData()
        {
            si.url = url;
            List<object> param = new List<object>();
            EntDto[] rtn = si.invokeList<EntDto>("getAllPageData", param.ToArray());
            return rtn;
        }
    }
}