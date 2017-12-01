package iih.ci.ord.s.listener;

import java.util.HashMap;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import iih.ci.ord.cior.d.CiOrderTypeEnum;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrPubUtils;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.listener.AbstractOrSignListener;

/**
 * 下达用血医嘱侦听器插件
 */
public class UseBtOrSignListener extends AbstractOrSignListener {

	@Override
	protected void doYourActionAfterOrSign(CiOrderDO[] ors) throws BizException {
		//改变备血医嘱的可用血余量
		HashMap<String,FDouble> map = new HashMap<String,FDouble>();
		String[] idors = new String[ors.length];
		StringBuffer ids = new StringBuffer();
		int i = 0;
		for(CiOrderDO order : ors){
			String id_or_rel = order.getId_or_rel();
			//获得医嘱聚集数据集合
			CiorderAggDO aggor = CiOrdAppUtils.getOrAggQryService().findById(order.getId_or());
			FDouble quan_med=new FDouble(0);
			if(aggor!=null){
				quan_med = aggor.getOrdSrvDO()[0].getQuan_medu();
			}
			if(CiOrdUtils.isEmpty(id_or_rel)){
				new BizException("用血医嘱关联的备血医嘱id为空！");
			}
			map.put(id_or_rel, quan_med);
			idors[i] = id_or_rel;
			ids.append("'"+id_or_rel+"'");
			if(i!=ors.length-1){
				ids.append(",");
			}
			i++;
		}
		ICiorappbtMDORService btService = CiOrdAppUtils.getICiorappbtMDORService();
		OrdApBtDO[] apbtArray = btService.find(String.format("id_or in (%s)", ids), "", FBoolean.FALSE);
		for(OrdApBtDO apbtdo : apbtArray){
			 double num = (apbtdo.getNum_margin_bu().toDouble()-map.get(apbtdo.getId_or()).toDouble());
			apbtdo.setNum_margin_bu(new FDouble(num));
			apbtdo.setStatus(DOStatus.UPDATED);
		}
		 CiOrdAppUtils.getICiorappbtMDOCudService().save(apbtArray);
	}

	@Override
	protected boolean isSpecificOrder(CiOrderDO or) {
		//是否为用血医嘱判断
		if (CiOrderTypeEnum.USEBTORDER.equals(CiOrPubUtils
				.getCiOrderType(or)))
			return true;
		return false;
	}
}
