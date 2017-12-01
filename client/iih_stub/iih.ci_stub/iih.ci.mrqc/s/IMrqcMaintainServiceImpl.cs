using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using iih.ci.mrqc.d;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.qared.d;
using iih.ci.mrqc.revisionnotice.d;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.rui.appfw;

namespace iih.ci.mrqc.i
{
    class IMrqcMaintainServiceImpl : IMrqcMaintainService
    {
        private string url_r = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.i.IMrqcMaintainService";
        private string url_n = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.serviceext.i.IQcServiceExt";
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mr/iih.ci.mr.assist.i.IDiagnosisRService";

        
        private ServiceInvocation si;
        /// <summary>
        /// 构造函数
        /// </summary>S
        public IMrqcMaintainServiceImpl()
        {
            si = new ServiceInvocationImpl();
            si.url = url_r;
            si.url = url_n;
        }

        public FBoolean saveRevNotice(RevisionNoticeDO revnotice, QaFltDTO[] qaflt, QaRecordDO qarecord,string id_amr)
        {
            List<object> param = new List<object> { revnotice, qaflt, qarecord, id_amr };
            si.url = url_r;
            FBoolean rtn = si.invoke<FBoolean>("SaveRevNotice", param.ToArray());
            return rtn;
        }

        public FBoolean updateStatus(QaFltDTO[] qaflt)
        {
            List<object> param = new List<object> { qaflt };
            si.url = url_r;
            FBoolean rtn = si.invoke<FBoolean>("updateStatus", param.ToArray());
            return rtn;
        }

        public Cidiagdto[] getCidiagdto(string id_ent)
        {
            List<object> param = new List<object>();
            si.url = url;
            param.Add(id_ent);
            Cidiagdto[] rtn = si.invokeList<Cidiagdto>("getCidiagdto", param.ToArray());
            return rtn;
        }
    }
}
