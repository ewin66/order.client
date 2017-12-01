package iih.ci.ord.s.bp;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.ICiEventConst;
import iih.ci.ord.s.bp.event.FireOrNsCheckEvent4IeBP;
import iih.ci.ord.s.bp.exception.CiOrOperatorCheckException;
import xap.mw.core.data.BizException;
import xap.sys.appfw.businessevent.IEventType;

/**
 *  临床医嘱的签署核对、作废核对、停止核对操作BP
 */
public class CiOrderSCSCheckBP {
	/**
	 * 临床医嘱的核对（签署核对、作废核对、停止核对）
	 * @param ciorders
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String[] id_sign_ors,String[] id_canc_ors,String[] id_stop_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_sign_ors) && CiOrdUtils.isEmpty(id_canc_ors) && CiOrdUtils.isEmpty(id_stop_ors) ){
			
			throw new CiOrOperatorCheckException();
			//return null;
		}
			
		
		//2016-08-19      集成平台事件新增逻辑
		Hashtable<String,Hashtable<String,String>> htors8ieevent=new Hashtable<String,Hashtable<String,String>>();
		Hashtable<String,String> htor=new Hashtable<String,String>();
		String id_or=null;
		
		
		List<CiOrderDO> orders=new ArrayList<CiOrderDO>();
		if(id_sign_ors!=null&&id_sign_ors.length>0){
			CiOrderCheckBP bp=new CiOrderCheckBP();
			CiOrderDO[] ors=bp.exec(id_sign_ors);
			for (CiOrderDO ciOrderDO : ors) {
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,false,"0",htor);//2016-08-19      集成平台事件新增逻辑
			}
		}
		if(id_canc_ors!=null&&id_canc_ors.length>0){
			CiOrderCancChkBP bp=new CiOrderCancChkBP();
			CiOrderDO[] ors=bp.exec(id_canc_ors);
			for (CiOrderDO ciOrderDO : ors) {
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,true,"1",htor);//2016-08-19      集成平台事件新增逻辑
			}
		
		}
		if(id_stop_ors!=null&&id_stop_ors.length>0){
			CiOrderStopChkBP bp=new CiOrderStopChkBP();
			CiOrderDO[] ors=bp.exec(id_stop_ors);
			for (CiOrderDO ciOrderDO : ors) {
				orders.add(ciOrderDO);
				orGrpHandle4IeEvent(htors8ieevent,ciOrderDO,true,"2",htor);//2016-08-19      集成平台事件新增逻辑
			}
			
		}
		
		CiOrderDO[] rtn=orders.toArray(new CiOrderDO[1]);
	
		//按就诊触发事件 集成平台事件   2016-08-19  新增逻辑       集成平台有问题，暂时注掉 
		fireEvent4Ie8Pv(htors8ieevent,htor);   
		
		//ICiEventConst.CIOR_STATUS_EVENT_SOURCEID   2016-08-26forlc
		CiOrdUtils.fireBDEvent(ICiEventConst.CIOR_STATUS_EVENT_SOURCEID,IEventType.TYPE_UPDATE_AFTER,rtn);
		
		return rtn;
	}
	
	/**
	 * 触发事件
	 * 集成平台事件
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie8Pv(Hashtable<String,Hashtable<String,String>> htors8ieevent,Hashtable<String,String> htor) throws BizException{
		//有效性校验 
		if(CiOrdUtils.isEmpty(htors8ieevent))return;
		
		//参数设置
        Enumeration<String> en1 = htors8ieevent.keys();
        String key="";
        
        //遍历
        while(en1.hasMoreElements()) {
        	key=en1.nextElement();
        	fireEvent4Ie(htors8ieevent.get(key),htor.get(key));
       }
	}
	
	/**
	 * 触发事件
	 * 集成平台事件
	 * @param id_sign_ors
	 * @param id_canc_ors
	 * @param id_stop_ors
	 * @throws BizException
	 */
	private void fireEvent4Ie(Hashtable<String,String> htors8ieevent,String id_or) throws BizException{
		FireOrNsCheckEvent4IeBP bp=new FireOrNsCheckEvent4IeBP();
		bp.exec(htors8ieevent,id_or);
	}
	
	/**
	 * 医嘱数据组织
	 * @param ht
	 * @param or
	 * @param iscancStp
	 */
	private void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> ht,CiOrderDO or,boolean iscancStp,String signStr,Hashtable<String,String> htor){
		String ieeventtype="";
		
		//事件类型获得
		if(iscancStp){ieeventtype=ICiIEEventConst.EVENT_IE_CIOR_NSCHK_CANC_STOP;}
		else{ieeventtype=CiOrdUtils.getIeEventTypeStr(or.getSd_srvtp());}
		
		//就诊数据组织
		if(!htor.containsKey(or.getId_en())){htor.put(or.getId_en(), signStr+or.getId_or());}
		
		//医嘱数据组织
		orGrpHandle4IeEvent(ht,or,ieeventtype);
	}
	
	
	/**
	 * 医嘱数据组织
	 * @param ht
	 * @param or
	 */
	private void orGrpHandle4IeEvent(Hashtable<String,Hashtable<String,String>> ht,CiOrderDO or,String ieeventtype){
		//有效性校验
		if(CiOrdUtils.isEmpty(ieeventtype))return;
		String id_en=or.getId_en();
		if(ht.containsKey(id_en)){
			Hashtable<String,String> ht0=ht.get(id_en);
			htEventTypeHandle(ieeventtype,ht0, or);
			ht.put(id_en, ht0);
		}else{
			Hashtable<String,String> ht0=new Hashtable<String,String>();
			htEventTypeHandle(ieeventtype,ht0, or);
			ht.put(id_en, ht0);
		}

	}
	
	/**
	 * 按事件类型处理逻辑
	 * @param ieeventtype
	 * @param ht
	 * @param or
	 */
	private void htEventTypeHandle(String ieeventtype,Hashtable<String,String> ht,CiOrderDO or){
		if(ht.containsKey(ieeventtype)){
			String ors=ht.get(ieeventtype)+CiOrdUtils.COMMA_STR+or.getId_or();
			ht.put(ieeventtype, ors);
		}else{
			ht.put(ieeventtype, or.getId_or());
		}
	}


}
