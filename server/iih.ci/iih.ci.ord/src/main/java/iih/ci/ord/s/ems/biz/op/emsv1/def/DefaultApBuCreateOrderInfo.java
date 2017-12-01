package iih.ci.ord.s.ems.biz.op.emsv1.def;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.ObjectList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 默认用血医嘱创建逻辑
 * @author wangqingzhu
 *
 */
public class DefaultApBuCreateOrderInfo extends DefaultBaseCreateOrderInfo {
	

	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam) throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPakageInfo = super.createOrderPakageInfo(ctx, szParam);
		//放回用血申请单信息
		for(OrderPackageInfo info:szOrderPakageInfo){
			ObjectList list=new ObjectList();
			list.add(creatOrdBtInfo());
			info.setExtInfoList(list);
		}
		return szOrderPakageInfo;
	}




	public OrdAppBtUseDO creatOrdBtInfo(){
		OrdAppBtUseDO ordbu=new OrdAppBtUseDO();
//		ordbu.setId_apbu(Id_apbu);
//		ordbu.setId_or(Id_or);
//		ordbu.setDt_bu_plan(Dt_bu_plan);
//		ordbu.setNo_applyform(No_applyform);
//		ordbu.setFg_prn(Fg_prn);
//		ordbu.setCnt_prn(Cnt_prn);
		return ordbu;
	}


}
