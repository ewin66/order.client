package iih.ci.ord.s.ems.biz.itf;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;

/**
 * 默认医嘱生成接口
 * @author wangqingzhu
 *
 */
public interface IDefaultCreateOrderInfo {
	
	/**
	 * 创建通用医嘱信息
	 * @param id_srv
	 * @param id_mm
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	abstract public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException;
	
}
