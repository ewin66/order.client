using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using xap.mw.core.data;
using xap.mw.coreitf.d;
using iih.ci.mrqc.qaflt.d;
using iih.ci.mrqc.dto.rfmnotice.d;

namespace iih.ci.mrqc.serviceext.i
{
    public interface IQcServiceExt
    {
        /// 获取环节质控缺陷DTO 
        QaFltDTO[] getIntermediateQcfltDtos(string id_ent, string cqf_submit_user);
        // 获取科室质控缺陷DTO 
        QaFltDTO[] getDeptQcfltDtos(string id_ent, string cqf_submit_user);
        // 获取终末质控缺陷DTO 
        QaFltDTO[] getTerminalQcfltDtos(string id_ent, string cqf_submit_user);
        //获取质控整改DTO
        QaNoticeDTO[] getIntermediateQcCorrectNoticeDtos(string id_rfm_user, string id_rfm_dept);
        //获取科室整改DTO
        QaNoticeDTO[] getDeptQcCorrectNoticeDtos(string id_rfm_doctor, string id_rfm_dept);
        //获取终末整改DTO
        QaNoticeDTO[] getTerminalQcCorrectNoticeDtos(string id_rfm_doctor, string id_rfm_dept);
        
        QaFltDTO[] getTraceQcfltDtos(string id_revision);
        //获取环节质控追踪通知书列表DTO
        QaNoticeDTO[] getIntermediateQcTraceDtos(string id_exec_doctor);
        //获取科室质控追踪通知书列表DTO
        QaNoticeDTO[] getDeptQcTraceDtos(string id_exec_doctor);
        //获取终末质控追踪通知书列表DTO
        QaNoticeDTO[] getTerminalQcTraceDtos(string id_exec_doctor);
        
        
        QaFltDTO[] getMrQcfltDto(string id_revision);
        //获取患者所有代办整改通知
        QaNoticeDTO[] getNoticeDtosByIdent(string id_ent);
    }
}
