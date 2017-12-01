package iih.ci.ord.s.bp.operableords;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.validate.CiOrOpenEntStatusValidateBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱可停止校验
 * @author HUMS
 *
 */
public class JudgeStopOrderStatusBP{
	
	public void exec(CiOrderDO[] orders,String id_dep_phy,String id_dep_nur) throws BizException {

		//判断患者就诊状态
		CiOrOpenEntStatusValidateBP entBp = new CiOrOpenEntStatusValidateBP();
		entBp.exec(orders[0].getCode_entp(),orders[0].getId_en(),id_dep_phy,id_dep_nur);
		//判断医嘱的医嘱状态和执行状态是否发生变化
		orStatusValidat(orders);
	}
	private void orStatusValidat(CiOrderDO[] orders) throws BizException {

		String[] idors = new String[orders.length];
		for (int i=0;i<orders.length;i++) {
			idors[i] = orders[i].getId_or();
		}
		CiOrderDO[] ordersDb =  CiOrdAppUtils.getOrQryService().findByIds(idors,FBoolean.FALSE);
		String errorOr = "";
		for(CiOrderDO orderdo : ordersDb){
			if(!(orderdo.getSd_su_or() != ICiDictCodeConst.SD_SU_CHECKSTOP && orderdo.getFg_long() == FBoolean.TRUE && orderdo.getFg_canc() == FBoolean.FALSE&& orderdo.getSd_su_or() != ICiDictCodeConst.SD_SU_FINISH && orderdo.getSd_su_or() != ICiDictCodeConst.SD_SU_CANCEL && orderdo.getSd_su_or() != ICiDictCodeConst.SD_SU_CHECKCANCEL)){
				errorOr+=orderdo.getName_or()+",";
			}
		}
		if(!CiOrdUtils.isEmpty(errorOr)){
			errorOr = errorOr.substring(0, errorOr.length()-1);
			new BizException("医嘱"+errorOr+"的医嘱状态已改变，请刷新界面重试！");
		}
	}

}
