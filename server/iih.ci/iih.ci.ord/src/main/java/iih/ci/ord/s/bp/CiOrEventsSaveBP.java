package iih.ci.ord.s.bp;

import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;

/**
 * 临床医嘱事件保存操作BP
 */
public class CiOrEventsSaveBP {
	/**
	 * 临床医嘱事件保存
	 * @param ors
	 * @return
	 * @throws BizException
	 */
	public void  exec(CiOrderDO[] ors)  throws BizException{
		//构造临床事件数据
		CiOrEventBuildBP bp = new CiOrEventBuildBP();
		CiEventDO[] eventdos = bp.exec(ors);

		//临床事件保存
		CiOrdAppUtils.getCieventService().save(eventdos);
	}
}
