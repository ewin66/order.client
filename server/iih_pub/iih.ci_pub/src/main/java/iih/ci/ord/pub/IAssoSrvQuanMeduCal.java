package iih.ci.ord.pub;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/**
 * 关联服务用量计算外挂函数接口类
 */
public interface IAssoSrvQuanMeduCal {
	public abstract FDouble calculate() throws BizException;         //关联服务用量计算外挂函数计算 
}
