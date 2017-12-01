package iih.ci.ord.s.ems.biz.op.emsv1.def;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import xap.mw.core.data.BizException;

/**
 * 单服务默认创建方法
 * @author wangqingzhu
 *
 */
public class DefaultSingleSrvCreateOrderInfo extends DefaultBaseCreateOrderInfo {

	@Override
	public OrderPackageInfo[] createOrderPakageInfo(CiEnContextDTO ctx, DefaultCreateParam[] szParam)
			throws BizException {
		// TODO Auto-generated method stub
		return super.createOrderPakageInfo(ctx, szParam);
	}

	@Override
	protected DefaultBaseCreateOrderInfo createOrderSrvAExtInfo( OrderPackageInfo orderPakageInfo,
			BdSrvMmInfoList bdSrvMmInfoList) throws BizException {
		// 组装服务信息列表并设置到Agg结构的服务列表中
		
	
		OrderSrvMmList orderSrvMmInfoList = new OrderSrvMmList();
		for (int index = 0; index < bdSrvMmInfoList.size(); ++index){
			// 创建服务信息
			OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(
					assembleOrderSrvInfo(this.getEnContextInfo(),
							orderPakageInfo.getOrderInfo(), 
							bdSrvMmInfoList.get(index), index),
					bdSrvMmInfoList.get(index).getUiModel()
					);
			
			MeterialDO meterialDO = bdSrvMmInfoList.get(index).getMmInfo();
			handleMpWhDeptInfo(this.getEnContextInfo(),
					orderPakageInfo.getOrderInfo().getId_dep_mp(), 
					ordSrvMmInfo.getOrderSrvInfo(),
					meterialDO!=null?meterialDO.getId_mm():null);
			
			// 判断是否为物品服务
			if (bdSrvMmInfoList.get(index).isMm()){
				ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(
						this.getEnContextInfo(), 
						ordSrvMmInfo.getOrderSrvInfo(), 
						bdSrvMmInfoList.get(index).getMmInfo(), 
						bdSrvMmInfoList.get(index).getSrvDrugInfo()));
				
			}
			orderSrvMmInfoList.add(ordSrvMmInfo);
		}
	
		orderPakageInfo.setOrderSrvMmList(orderSrvMmInfoList);
		return this;
	}
	
}
