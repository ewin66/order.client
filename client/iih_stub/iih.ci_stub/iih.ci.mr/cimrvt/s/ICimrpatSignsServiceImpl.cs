using iih.bd.srv.medsrv.d;
using iih.bd.srv.mrtplvt.d;
using iih.ci.mr.cimrpatsigns.d;
using System.Collections.Generic;
using xap.mw.serviceframework;

namespace iih.ci.mr.i
{
    public class ICiMrServiceExtImpl : ICiMrServiceExt
    {
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.i.ICiMrServiceExt";

        private ServiceInvocation si;

        public ICiMrServiceExtImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url;
        }

        /// <summary>
        /// 获取患者信息列表
        /// </summary>
        /// <param name="code_entp"></param>
        /// <param name="sd_status"></param>
        /// <param name="id_dep_nur"></param>
        /// <param name="whereStr"></param>
        /// <returns></returns>
        public PatDTO[] FindPatDTO(Patparam patparam)
        {
            List<object> param = new List<object>();
            param.Add(patparam);
            si.url = url;
            PatDTO[] rtn = si.invokeList<PatDTO>("FindPatDTO", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取医疗记录模板的全部数据元
        /// </summary>
        /// <param name="id_mrtpl"></param>
        /// <returns></returns>
        public MedSrvVtDO[] getMedSrvVtDO(string id_mrtpl)
        {
            List<object> param = new List<object>();
            param.Add(id_mrtpl);
            si.url = url;
            MedSrvVtDO[] rtn = si.invokeList<MedSrvVtDO>("getMedSrvVtDO", param.ToArray());
            return rtn;
        }


        /// <summary>
        /// 根据测量分类ID获取全部测量项目，其中def1存放测量项目名字（来源服务，DB_SRV）
        /// </summary>
        /// <param name="id_vtca"></param>
        /// <returns></returns>
        public MrtplVtItmDO[] getMrtplVtItmDO(string id_mrtplvt)
        {
            List<object> param = new List<object>();
            param.Add(id_mrtplvt);
            si.url = url;
            MrtplVtItmDO[] rtn = si.invokeList<MrtplVtItmDO>("getMrtplVtItmDO", param.ToArray());
            return rtn;
        }

        /// <summary>
        /// 获取患者历史录入数据
        /// </summary>
        /// <param name="id_ent">就诊ID</param>
        /// <param name="id_mrtplvt">测量ID</param>
        /// <param name="dt_vt">测量时间</param>
        /// <returns></returns>
        public CiMrHisDataDTO[] getCiMrHisData(string id_ent, string id_mrtplvt, string dt_vt)
        {
            List<object> param = new List<object>();
            param.Add(id_ent);
            param.Add(id_mrtplvt);
            param.Add(dt_vt);
            CiMrHisDataDTO[] rtn = si.invokeList<CiMrHisDataDTO>("getCiMrHisData", param.ToArray());
            return rtn;
        }
    }
}
