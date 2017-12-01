using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.bd.srv.d;
using iih.bd.srv.itm.d;
using iih.ci.mrqc.divide.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.mw.core.data;

namespace iih.ci.mrqc.autoqc.i {
    public class IAutoQcServiceImpl : IAutoQcService
    {
    	
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.autoqc.i.IAutoQc";
        //private string url = "http://127.0.0.1.:8080" + "/bin/testDOService";

        private ServiceInvocation si;

        public IAutoQcServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        
        /// getAutoQcDefects 
        public ItmDO[] getAutoQcDefects(string id_ent, String id_qc_type)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_qc_type);
            ItmDO[] rt = si.invokeList<ItmDO>("getAutoQcDefects", ps.ToArray());
            return rt;
        }
        //自动质控配置获取扣分项
        public DivideDO[] getAutoQcDivideDos(string id_ent, string id_qc_type)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(id_qc_type);
            DivideDO[] rt = si.invokeList<DivideDO>("getAutoQcDivideDos", ps.ToArray());
            return rt;
        }
    }
}
