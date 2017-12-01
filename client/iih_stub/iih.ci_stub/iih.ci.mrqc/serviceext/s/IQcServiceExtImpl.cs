using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.coreitf.d;
using xap.mw.serviceframework;
using xap.mw.core.data;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.dto.rfmnotice.d;

namespace iih.ci.mrqc.serviceext.i {
    public class IQcServiceExtImpl : IQcServiceExt {
    	
        private string url = XapSvrConfig.BaseUrl + "iih.ci.mrqc/iih.ci.mrqc.serviceext.i.IQcServiceExt";
        //private string url = "http://127.0.0.1.:8080" + "/bin/testDOService";

        private ServiceInvocation si;

        public IQcServiceExtImpl(){
            si = new ServiceInvocationImpl();
            si.url = url;
        }
        
        /// 获取质控缺陷DTO 
        public QaFltDTO[] getIntermediateQcfltDtos(string id_ent, string cqf_submit_user)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(cqf_submit_user);
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getIntermediateQcfltDtos", ps.ToArray());
            return rt;
        }

        public QaFltDTO[] getDeptQcfltDtos(string id_ent, string cqf_submit_user)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(cqf_submit_user);
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getDeptQcfltDtos", ps.ToArray());
            return rt;
        }

        public QaFltDTO[] getTerminalQcfltDtos(string id_ent, string cqf_submit_user)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            ps.Add(cqf_submit_user);
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getTerminalQcfltDtos", ps.ToArray());
            return rt;
        }

        public QaFltDTO[] getTraceQcfltDtos(string id_revision)
        {
            List<object> ps = new List<object>();
            ps.Add(id_revision);
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getTraceQcfltDtos", ps.ToArray());
            return rt;
        }

        /// 获取质控整改DTO 
        public QaNoticeDTO[] getIntermediateQcCorrectNoticeDtos(string id_rfm_user, string id_rfm_dept)
        {
            List<object> ps = new List<object>();
            ps.Add(id_rfm_user);
            ps.Add(id_rfm_dept);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getIntermediateQcCorrectNoticeDtos", ps.ToArray());
            return rt;
        }

         /// 获取科室整改DTO 
        public QaNoticeDTO[] getDeptQcCorrectNoticeDtos(string id_rfm_doctor, string id_rfm_dept)
        {
            List<object> ps = new List<object>();
            ps.Add(id_rfm_doctor);
            ps.Add(id_rfm_dept);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getDeptQcCorrectNoticeDtos", ps.ToArray());
            return rt;
        }
        
             /// 获取终末整改DTO 
        public QaNoticeDTO[] getTerminalQcCorrectNoticeDtos(string id_rfm_doctor, string id_rfm_dept)
        {
            List<object> ps = new List<object>();
            ps.Add(id_rfm_doctor);
            ps.Add(id_rfm_dept);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getTerminalQcCorrectNoticeDtos", ps.ToArray());
            return rt;
        }

        //获取环节质控追踪通知书列表DTO
        public QaNoticeDTO[] getIntermediateQcTraceDtos(string id_exec_doctor)
        {
            List<object> ps = new List<object>();
            ps.Add(id_exec_doctor);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getIntermediateQcTraceDtos", ps.ToArray());
            return rt;
        }
        //获取部门质控追踪通知书列表DTO
        public QaNoticeDTO[] getDeptQcTraceDtos(string id_exec_doctor)
        {
            List<object> ps = new List<object>();
            ps.Add(id_exec_doctor);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getDeptQcTraceDtos", ps.ToArray());
            return rt;
        }
        //获取终末质控追踪通知书列表DTO
        public QaNoticeDTO[] getTerminalQcTraceDtos(string id_exec_doctor)
        {
            List<object> ps = new List<object>();
            ps.Add(id_exec_doctor);
            si.url = url;
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getTerminalQcTraceDtos", ps.ToArray());
            return rt;
        }

        /// 获取质控缺陷DTO 
        public QaFltDTO[] getMrQcfltDto(string id_revision)
        {
            List<object> ps = new List<object>();
            ps.Add(id_revision);
            QaFltDTO[] rt = si.invokeList<QaFltDTO>("getMrQcfltDto", ps.ToArray());
            return rt;
        }

        public QaNoticeDTO[] getNoticeDtosByIdent(string id_ent)
        {
            List<object> ps = new List<object>();
            ps.Add(id_ent);
            QaNoticeDTO[] rt = si.invokeList<QaNoticeDTO>("getNoticeDtosByIdent", ps.ToArray());
            return rt;
        }
    }
}
