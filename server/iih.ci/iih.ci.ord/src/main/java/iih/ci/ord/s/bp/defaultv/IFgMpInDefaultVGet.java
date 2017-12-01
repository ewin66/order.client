package iih.ci.ord.s.bp.defaultv;

import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱在院执行默认值获得通用接口
 */
public interface IFgMpInDefaultVGet {
	public FBoolean exec(CiEmsDTO emsdto)  throws BizException;
}