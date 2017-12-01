using System;
using System.Collections.Generic;
using iih.ci.rcm.hospentdto.d;
using iih.en.pv.pativisit.d;
using xap.mw.serviceframework;
using xap.rui.appfw;
using xap.sys.appfw.tmpl.qryscheme.qrydto;


namespace iih.ci.rcm.hospentdto.i
{
    public class IHospServiceImpl : IHospService
    {
        private readonly string _url   = XapSvrConfig.BaseUrl + "iihci.rcm/iih.ci.rcm.hospentdto.i.HospService";
   
        private readonly ServiceInvocation _si;
        private readonly CacheHelper<HospEntDTO> _ch;
        /// <summary>
        /// 构造函数
        /// </summary>
        public IHospServiceImpl()
        {
            _ch = new CacheHelper<HospEntDTO>();
            _si = new ServiceInvocationImpl();
            _si.url = _url;
        }

        public HospEntDTO[] GetHospEntList(String idGrp, String idOrg, String idDept)
        {
            List<object> param = new List<object>();
            param.Add(idGrp);
            param.Add(idOrg);
            param.Add(idDept);
            _si.url = _url;
            HospEntDTO[] rtn = _si.invokeList<HospEntDTO>("getHospEntList", param.ToArray());
            return rtn;
        }

        public PatiVisitDO[] GetHospMissingList(string idGrp, string idOrg, string idDept)
        {
            List<object> param = new List<object>();
            param.Add(idGrp);
            param.Add(idOrg);
            param.Add(idDept);
            _si.url = _url;
            PatiVisitDO[] rtn = _si.invokeList<PatiVisitDO>("getHospMissingList", param.ToArray());
            return rtn;
        }

        public HospEntDTO[] GetHospEntList2(QryRootNodeDTO qryRootNodeDTO)
        {
            //            #region "缓存处理"
            //            if (_ch.IsCached("GetHospEntList"))
            //            {
            //                return _ch.FindCacheList(idOrg, idDept);
            //            }
            //            #endregion
            List<object> param = new List<object>();
            param.Add(qryRootNodeDTO);
            _si.url = _url;
            HospEntDTO[] rtn = _si.invokeList<HospEntDTO>("getHospEntList2", param.ToArray());
            return rtn;
        }

        public HospEntDTO[] GetDeleteHospList()
        {
            _si.url = _url;
            List<object> param = new List<object>();
            HospEntDTO[] rtn = _si.invokeList<HospEntDTO>("GetDeleteHospList", param.ToArray());
            return rtn;
        }

        public HospEntDTO[] GetAllPageData()
        {
            _si.url = _url;
            List<object> param = new List<object>();
            HospEntDTO[] rtn = _si.invokeList<HospEntDTO>("getAllPageData", param.ToArray());
            return rtn;
        }

    }
}