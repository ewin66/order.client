package iih.ci.mr.nu.i;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.xbd.udi.d.UdidocDO;

public interface ICimrNuQueryService {

	/**
	 * 实例化护理文书实体，赋初始值
	 * 
	 * @return
	 * @throws BizException
	 */
	public abstract FArrayList initData(String id_ent, String fullClassName) throws BizException;

	/**
	 * 刷新和编辑时刷新患者的数据
	 * @param baseDO
	 * @return
	 * @throws BizException
	 */
	public FArrayList refreshData(BaseDO baseDO)throws BizException;
	
	/**
	 * 评分结果匹配
	 * 
	 * @param id_ent
	 * @param fullClassName
	 * @return
	 * @throws BizException
	 */
	public UdidocDO calculateResult(FDouble score, String code_udidoc, FBoolean fg_left_close, FBoolean fg_right_close) throws BizException;
}
