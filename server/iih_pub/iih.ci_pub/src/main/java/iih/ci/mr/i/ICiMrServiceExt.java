package iih.ci.mr.i;

import iih.bd.srv.medsrv.d.MedSrvVtDO;
import iih.bd.srv.mrtplvt.d.MrtplVtItmDO;
import iih.ci.mr.cimrpatsigns.d.CiMrHisDataDTO;
import iih.ci.mr.cimrpatsigns.d.PatDTO;
import iih.ci.mr.cimrpatsigns.d.Patparam;
import iih.ci.mr.d.MrTreeListDTO;
import iih.ci.mr.d.WaitDoctorDto;
import iih.ci.mr.knowledge.d.Knowledgedto;
import xap.mw.core.data.BizException;

public interface ICiMrServiceExt {

	/**
	 * 患者列表(xuxing_2016-05-03)
	 * 
	 * @param code_entp
	 * @param sd_status
	 * @param id_dep_nur
	 * @param whereType
	 * @param key
	 * @return
	 * @throws BizException
	 */
	public abstract PatDTO[] FindPatDTO(Patparam patparam) throws BizException;

	/**
	 * 获取医疗服务（生命体征属性）(xuxing_2016-05-03)
	 * 
	 * @param id_vtca
	 * @return
	 * @throws BizException
	 */
	public abstract MedSrvVtDO[] getMedSrvVtDO(String id_vtca) throws BizException;

	/**
	 * 根据体征模板获取体征测量项目(xuxing_2016-05-03)
	 * 
	 * @param id_mrtplvt
	 * @return
	 * @throws BizException
	 */
	public abstract MrtplVtItmDO[] getMrtplVtItmDO(String id_mrtplvt) throws BizException;

	/**
	 * 获取患者的历史体征信息(xuxing_2016-05-03)
	 * 
	 * @param id_ents
	 * @param id_mrtplvt
	 * @param dt_vt
	 * @return
	 * @throws BizException
	 */
	public abstract CiMrHisDataDTO[] getCiMrHisData(String id_ents, String id_mrtplvt, String dt_vt) throws BizException;

	/**
	 * 
	 * @param name
	 * @return String[]
	 * @throws BizException
	 */
	public abstract String[] GetMrTpList(String str) throws BizException;

	/**
	 * 
	 * @param name
	 * @return MrTreeListDTO[]
	 * @throws BizException
	 */
	public abstract MrTreeListDTO[] getMrTreeList(String name) throws BizException;

	/**
	 * 刷新处置 如有问题 call zouhaiqiang
	 */
	public abstract String getCiOrderDOList(String strWhere) throws BizException;

	/**
	 * 根据用户id检索数据
	 * 
	 * @throws BizException
	 */
	public abstract Knowledgedto[] GetKnowledges(String id_user, String gr) throws BizException;

	public abstract Knowledgedto[] GetKnowledge(String id_user, String id_dept, String grName, String ksName) throws BizException;

	public abstract Knowledgedto[] GetKnowledgeks(String id_dept, String ks) throws BizException;

	/**
	 * 根据名称检索数据
	 * 
	 * @throws BizException
	 */
	public abstract Knowledgedto[] GetKnowledgeName(String id_user, String id_dept, String grName, String ksName, String name) throws BizException;

	public abstract Knowledgedto[] GetKnowledgeksName(String id_dept, String ksName, String name) throws BizException;

	public abstract Knowledgedto[] GetKnowledgeNamegr(String id_user, String grName, String name) throws BizException;

	public abstract WaitDoctorDto[] getWaitDoctorDto(String id_user, String id_dep_phy, String sd_status) throws BizException;

	public abstract WaitDoctorDto[] queryWaitDoctorDto(String code, String name, String dt_acpt, String dt_end, String id_user, String id_dep_phy, String sd_status) throws BizException;
}
