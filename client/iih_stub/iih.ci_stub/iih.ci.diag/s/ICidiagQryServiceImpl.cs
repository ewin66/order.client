using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Remoting.Messaging;
using System.Text;
using iih.bd.srv.diagdef.d;
using iih.ci.diag.cidiag.d;
using iih.ci.diag.dto.d;
using xap.mw.serviceframework;
using xap.sys.xbd.udi.d;

namespace iih.ci.diag_stub.i
{
    public class ICidiagQryServiceImpl : ICidiagQryService
    {

        private string url = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.i.ICidiagQryService";//ConfigUtil.getServiceUrl();
        private string url_r = XapSvrConfig.BaseUrl + "iihci.diag/iih.ci.diag.i.ICidiagQryService";//ConfigUtil.getServiceUrl();

        private ServiceInvocation si;
        //private CacheHelper<EntDiDO> ch;

        public ICidiagQryServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;

        }


        public DIDTO[] QueryCiDiagDTO(string id, string type)
        {
            List<object> param = new List<object>();
            param.Add(id);
            param.Add(type);
            si.url = url;
            DIDTO[] rtn = si.invokeList<DIDTO>("QueryCiDiagDTO", param.ToArray());
            return rtn;
        }

        public DIDTO[] QuerRef(string id, string type)
        {
            List<object> param = new List<object>();
            param.Add(id);
            param.Add(type);
            si.url = url;
            DIDTO[] rtn = si.invokeList<DIDTO>("QueryCiDiagDTO", param.ToArray());
            return rtn;
        }

        public DiagDefDO[] getDiagDefDOS(String value)
        {
            List<object> param = new List<object>();
            param.Add(value);
            si.url = url;
            DiagDefDO[] rtn = si.invokeList<DiagDefDO>("getDiagDefDOS", param.ToArray());
            return rtn;
        }

        public UdidocDO[] getDiType(string id_en, string type)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(type);
            si.url = url;
            UdidocDO[] rtn = si.invokeList<UdidocDO>("getDiType", param.ToArray());
            return rtn;
        }

        public string getParamType()
        {
            List<object> param = new List<object>();
            si.url = url;
            string rtn = si.invoke<string>("getParamType", param.ToArray());
            return rtn;
        }
        //最新诊断
        public CidiagAggDO[] getLastCiDiags(string id_en)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            si.url = url;
            CidiagAggDO[] rtn = si.invokeList<CidiagAggDO>("getLastCiDiags", param.ToArray());
            return rtn;
        }

        public CidiagAggDO[] getIdEntCiDiS(String id_en)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            si.url = url;
            CidiagAggDO[] rtn = si.invokeList<CidiagAggDO>("getIdEntCiDiS", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取当前就诊对应的诊断明细
        /// </summary>
        /// <param name="id_en">就诊id</param>
        /// <param name="sd_ditp">诊断类型编码</param>
        /// <returns>本次就诊指定类型的诊断明细</returns>
        public CiDiagItemDO[] getCiDiagItems(String id_en, String sd_ditp)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(sd_ditp);
            si.url = url;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("getCiDiagItems", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 当前诊断
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="entp_code"></param>
        /// <returns></returns>
        public CiDiagItemDO getCiDiagItemDO(String id_en, String entp_code)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            param.Add(entp_code);
            si.url = url;
            CiDiagItemDO rtn = si.invoke<CiDiagItemDO>("getCiDiagItemDO", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取本次就诊的保外诊断明细集合
        /// </summary>
        /// <param name="id_en"></param>
        /// <param name="sd_ditp"></param>
        /// <returns></returns>
        public CiDiagItemDO[] getHpjudgetpCiDiagItems(String id_en)
        {
            List<object> param = new List<object>();
            param.Add(id_en);
            si.url = url;
            CiDiagItemDO[] rtn = si.invokeList<CiDiagItemDO>("getHpjudgetpCiDiagItems", param.ToArray());
            return rtn;
        }
    }
}
