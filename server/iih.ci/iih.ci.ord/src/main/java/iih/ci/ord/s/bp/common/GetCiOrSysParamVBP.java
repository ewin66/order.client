package iih.ci.ord.s.bp.common;

import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获得临床医嘱系统参数值操作BP
 */
public class GetCiOrSysParamVBP {
	/**
	 * 获得临床医嘱系统参数值
	 * 需要缓存机制支持以便提高性能
	 * @param id_org
	 * @param id_dep
	 * @param paramcode
	 * @return
	 * @throws BizException
	 */
	public  Object exec(String id_org,String id_dep,String paramcode)  throws BizException{
		//如果缓存中存在则缓存中取值，否则参数系统中取值
		//按道理讲，参数缓存的机制应该由参数框架体系层面来支持
		//从应用方来说应该直接调用下面的工具类就可以了
		//ParamsetQryUtil.getParaString
		return null;
	}

}
