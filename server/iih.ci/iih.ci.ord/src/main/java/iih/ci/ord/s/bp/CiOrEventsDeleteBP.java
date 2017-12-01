package iih.ci.ord.s.bp;

import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/*
 * 临床医嘱对应的事件删除操作BP
 */
public class CiOrEventsDeleteBP {
	/**
	 * 临床医嘱对应的事件删除
	 * @param id_or
	 * @throws BizException
	 */
	public void  exec(String id_or)  throws BizException{
		CiEventDO[] eventdos=CiOrdAppUtils.getCieventQryService().find(CiOrderDODesc.TABLE_ALIAS_NAME+".id_or='"+id_or+"'", "", FBoolean.FALSE);
		if(eventdos!=null && eventdos.length!=0){
			CiOrdAppUtils.getCieventService().logicDelete(eventdos);
		}
	}
	/**
	 * 临床医嘱对应的事件删除
	 * @param id_ors
	 * @throws BizException
	 */
	public void  exec(String[] id_ors)  throws BizException{
		CiEventDO[] eventdos=CiOrdAppUtils.getCieventQryService().findByAttrValStrings("Id_or", id_ors);
		if(eventdos!=null && eventdos.length!=0){
			CiOrdAppUtils.getCieventService().logicDelete(eventdos);
		}
	}
}
