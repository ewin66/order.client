package iih.ci.mrqc.serviceext.i;

import xap.mw.core.data.BizException;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.d.Cidiagdto;
import iih.ci.mrqc.dto.rfmnotice.d.QaNoticeDTO;

/**
* 病历缺陷扩展服务操作接口方法服务
*/
public interface IQcServiceExt {

    /**
	*  获取环节质控缺陷DTO
	*/
    public abstract  QaFltDTO[] getIntermediateQcfltDtos( String id_ent, String cqf_submit_user ) throws BizException;
    /**
	*  获取科室质控缺陷DTO 
	*/
    public abstract  QaFltDTO[] getDeptQcfltDtos( String id_ent, String cqf_submit_user ) throws BizException;
    /**
	*  获取终末质控缺陷DTO 
	*/
    public abstract  QaFltDTO[] getTerminalQcfltDtos( String id_ent, String cqf_submit_user ) throws BizException;
//    /**
//	*  获取质控缺陷DTO
//	*/
//    public abstract  QaFltDTO[] getTraceQcfltDtos( String id_revision ) throws BizException;
    /**
	*  获取质控整改DTO
	*/
    public abstract  QaNoticeDTO[] getIntermediateQcCorrectNoticeDtos( String id_rfm_doctor,String id_rfm_dept) throws BizException;
    /**
   	*  获取科室整改DTO
   	*/
       public abstract  QaNoticeDTO[] getDeptQcCorrectNoticeDtos( String id_rfm_doctor,String id_rfm_dept) throws BizException;
     /**
     *  获取终末整改DTO
     */
       public abstract  QaNoticeDTO[] getTerminalQcCorrectNoticeDtos( String id_rfm_doctor,String id_rfm_dept) throws BizException;
       
   /**
   *  获取环节质控追踪通知书列表DTO
   */
    public abstract  QaNoticeDTO[] getIntermediateQcTraceDtos(String id_exec_doctor) throws BizException;
    /**
   	*  获取部门质控追踪通知书列表DTO
   	*/
    public abstract  QaNoticeDTO[] getDeptQcTraceDtos(String id_exec_doctor) throws BizException;
    /**
   	*  获取终末质控追踪通知书列表DTO
   	*/
    public abstract  QaNoticeDTO[] getTerminalQcTraceDtos(String id_exec_doctor) throws BizException;
    
    /**
	*  获取整改缺陷DTO 根据通知书获取缺陷数
	*/
    public abstract  QaFltDTO[] getMrQcfltDto( String id_revision ) throws BizException;
    
    /**
   	*  获取诊断DTO
   	*/
    public abstract  Cidiagdto[] getCidiagdto( String id_ent ) throws BizException;
       /**
	   	*  根据患者id_ent查询所有待整改通知
	   	*/
	public abstract  QaNoticeDTO[] getNoticeDtosByIdent(String id_ent) throws BizException;
}
