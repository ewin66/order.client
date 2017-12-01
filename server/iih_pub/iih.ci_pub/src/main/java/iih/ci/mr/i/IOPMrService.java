package iih.ci.mr.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import iih.bd.srv.emrtpl.d.EmrTplDO;
import iih.bd.srv.mrtplstream.d.EmrTplStreamDO;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;

public interface IOPMrService {

	/**
	 * 保存病历、引用
	 * @param mrDocRefValueDOs
	 * @param ciMrDOs
	 * @param ciMrFsDOs
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 SaveMr(MrDocRefValueDO[] mrDocRefValueDOs,CiMrDO ciMrDO,CiMrFsDO ciMrFsDO) throws BizException; 
	
	/**
	 * 获取处置模板信息
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 GetDefaultMrPreFormats(String id_dept) throws BizException;
	
	
	/**
	 * 获取模板所属自定义分类
	 * @param id_mrtp
	 * @param code_entp
	 * @return
	 * @throws BizException
	 */
	public abstract String GetIdMrctm(String id_mrtp,String code_entp) throws BizException;
	
	/**
	 * 根据当前数据获取所需基本数据
	 * @param ciMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList2 GetData(CiMrDO ciMrDO) throws BizException;
	
	/**
	 * 根据就诊号和数据集获取病历文书
	 * @param id_ent
	 * @param code_sets
	 * @throws BizException
	 */
	public abstract  CiMrDO[] GetCiMrByIdEnt(String id_ent,String[] code_sets) throws BizException;
	
	/**
	 * 根据医疗记录类型ID获得数据集code
	 * @param id_mrtp
	 * @return
	 * @throws BizException
	 */
	public abstract String GetBdSetCodeByMrtp(String id_mrtp) throws BizException;

	/**
	 * 保存另存为模板信息
	 * @param emrTplStreamDo
	 * @param emrTplDo
	 * @return
	 * @throws BizException
	 */
	public abstract EmrTplDO SaveTplAs(EmrTplStreamDO emrTplStreamDo, EmrTplDO emrTplDo) throws BizException;
	/**
	 * 强制更新CiMrDO的提交状态
	 * @param CiMrDO
	 * @return
	 * @throws BizException
	 */
	public abstract void UpdateMrForce(CiMrDO ciMrDO) throws BizException;
}
