package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.defaultv.CiOrFgMpInDefaultVSetBP;
import xap.mw.core.data.BizException;

/**
 * 医疗单默认值设置操作BP
 */
public class CiEmsDefaultValueSetBP {
	/**
	 * 医疗单默认值设置
	 * @param emsdto
	 * @throws BizException
	 */
	public void exec(CiEmsDTO emsdto)  throws BizException{
		
		//在院执行标识默认值设置处理逻辑  测试完之后将下属处理逻辑打开
		fgMpInDefaultVSet(emsdto);
		
	}
	
	/**
	 * 在院执行标识默认值设置处理逻辑
	 * @param emsdto
	 * @throws BizException
	 */
	private void fgMpInDefaultVSet(CiEmsDTO emsdto) throws BizException{
		CiOrFgMpInDefaultVSetBP bp=new CiOrFgMpInDefaultVSetBP();
		bp.exec(emsdto);
	}
}
