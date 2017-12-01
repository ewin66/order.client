package iih.ci.ord.i.ems;

import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsLoadDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.d.ems.ems.EmsSaveDTO;
import xap.mw.core.data.BizException;

/**
 * 医疗单主服务接口
 * @author wangqingzhu
 *
 */
public interface ICiEmsMainService {

	/**
	 * 创建医疗单UI对象
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] create(EmsCrtDTO[] emsarray) throws BizException ;
	
	/**
	 * 加载医疗单
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO[] load(EmsLoadDTO[] emsarray) throws BizException ;
	
	/**
	 * 保存医疗单
	 * @param ems
	 * @return
	 */
	public abstract EmsRstDTO save(EmsSaveDTO ems) throws BizException ;
}
