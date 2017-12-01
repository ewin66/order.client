package iih.ci.ord.s.bp.event;

import iih.bd.bc.event.pub.ICiIEEventConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.pub.CiOrdUtils;
import xap.ip.cfg.XipCfg;
import xap.mw.core.data.BizException;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 门诊医技补录项目保存后进行集成平台门诊事件发送 （集成平台事件）
 */
public class FireOpOrMedicalRecordSaveEvent4Ie extends FireOpOrSignEvent4IeBP {
	/**
	 * 
	 * @param htors8ieevent
	 * @throws BizException
	 */
	protected void fireEvent4Ie(Hashtable<String, String> htors8ieevent) throws BizException {
		// 如果inDb=disable，那么所有的消息不入库
		if (!XipCfg.instance().isEnableInDb()) {
			return;
		}		
		// 有效性验证
		if (CiOrdUtils.isEmpty(htors8ieevent))
			return;
		// 集成平台治疗消息体数据生成并触发相应事件
		fireEvent4Treat(htors8ieevent, ICiIEEventConst.EVENT_IE_CIOR_OP_TREAT);

	}
	/**
	 * 获得签署医嘱信息
	 * @param newObjs
	 * @return
	 */
	protected CiOrderDO[] getOrdInfo8Status(Object[] newObjs){
		CiOrderDO ordo;
		ArrayList<CiOrderDO> rtn=new ArrayList<CiOrderDO>();
		
		//遍历
		for(Object obj: newObjs ){
			ordo=(CiOrderDO) obj;
			//是否为医技补录医嘱
			if(!isOrStatusCheck(ordo))continue;
			//加入列表中
			rtn.add(ordo);
		}
		
		//空判断
		if(rtn==null || rtn.size()==0)return null;
		
		//返回值
		return rtn.toArray(new CiOrderDO[0]);
	}
	/**
	 * 判断医嘱是医技补录的
	 * @param ordo
	 * @return
	 */
	protected boolean isOrStatusCheck(CiOrderDO ordo){
		if(ordo==null)return false;
		if(OrSourceFromEnum.IIHMEDTECHORDERS.equals(ordo.getEu_orsrcmdtp()))
			return true;
		return false;
	}
}
