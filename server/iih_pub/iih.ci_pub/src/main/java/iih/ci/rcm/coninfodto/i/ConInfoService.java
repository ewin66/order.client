package iih.ci.rcm.coninfodto.i;

import iih.ci.rcm.coninfodto.d.ConInfoDTO;
import xap.mw.core.data.BizException;

/**
 * 传染病已删除列表
 * 
 * @author tangws
 * @date 2017年4月27日 上午10:53:33
 */
public interface ConInfoService {

	ConInfoDTO[] GetContagions() throws BizException;

}
