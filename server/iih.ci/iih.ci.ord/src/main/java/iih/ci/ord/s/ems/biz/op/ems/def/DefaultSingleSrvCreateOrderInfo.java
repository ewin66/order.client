package iih.ci.ord.s.ems.biz.op.ems.def;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.ICalcPriModeProxy;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.DefaultCreateParam;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.op.calcpri.CompCalcPriModeProxy;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.BizException;

/**
 * 单服务默认创建方法
 * 
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
			BdSrvMmInfo bdSrvMmInfo = bdSrvMmInfoList.get(index);
			if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(bdSrvMmInfo.getBdSrvInfo().getId_primd())) {
				OrderSrvExtPackage ordSrvExtPackage = CalcPriStdSrvOfOrdSrvList(
						this.getEnContextInfo(), 
						orderPakageInfo.getOrderInfo(), 
						bdSrvMmInfo.getBdSrvInfo(), new CompCalcPriModeProxy(
						bdSrvMmInfo.getBdSrvInfo().getId_srv(), 
						bdSrvMmInfo.getBdSrvInfo().getName(), 
						0));
				// 非套服务 - 组合定价服务信息（费用项目）计算
				if (!CiOrdUtils.isEmpty(ordSrvExtPackage.getOrderSrvMmList())){
					
					orderSrvMmInfoList.addAll(ordSrvExtPackage.getOrderSrvMmList());
				}
			} else {
			// 创建服务信息
				OrderSrvMmInfo ordSrvMmInfo = new OrderSrvMmInfo(assembleOrderSrvInfo(this.getEnContextInfo(),
						orderPakageInfo.getOrderInfo(), bdSrvMmInfo, index), bdSrvMmInfo.getUiModel());
			
				MeterialDO meterialDO = bdSrvMmInfo.getMmInfo();
				handleMpWhDeptInfo(this.getEnContextInfo(), orderPakageInfo.getOrderInfo().getId_dep_mp(),
						ordSrvMmInfo.getOrderSrvInfo(), meterialDO != null ? meterialDO.getId_mm() : null);
			
			// 判断是否为物品服务
				if (bdSrvMmInfo.isMm()) {
					ordSrvMmInfo.setOrderSrvMmInfo(assembleSrvMmInfo(this.getEnContextInfo(),
							ordSrvMmInfo.getOrderSrvInfo(), bdSrvMmInfo.getMmInfo(), bdSrvMmInfo.getSrvDrugInfo()));
				
			}
			orderSrvMmInfoList.add(ordSrvMmInfo);
		}
		}
	
		orderPakageInfo.setOrderSrvMmList(orderSrvMmInfoList);
		return this;
	}
	
	/**
	 * 根据费用对照出来的价表信息构造医嘱服务集合
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param setSrvInfo
	 *            套服务对象
	 * @param szPriStdSrvDTO
	 *            价表集合
	 * @return 医嘱服务对象集合
	 * @throws BizException
	 */
	protected OrderSrvExtPackage CalcPriStdSrvOfOrdSrvList(CiEnContextDTO ctx, CiOrderDO orderInfo, MedSrvDO setSrvInfo,
			ICalcPriModeProxy iCalcPriModeProxy) throws BizException {

		PriStdSrvDTO[] szPriStdSrvDTO = iCalcPriModeProxy.Calc();
		if (CiOrdUtils.isEmpty(szPriStdSrvDTO)){
			throw new BizException(iCalcPriModeProxy.toDesction() + "，费用接口没有返回数据");
		}
		// 获取基础数据服务集合
		StringList idSrvList = new StringList();
		if (!CiOrdUtils.isEmpty(setSrvInfo) && IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(setSrvInfo.getId_primd())) {
			idSrvList.add(setSrvInfo.getId_srv());
		}
		for (PriStdSrvDTO pssd : szPriStdSrvDTO) {
			idSrvList.add(pssd.getId_srv());
		}
		MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(idSrvList.asArray()) ;
		if (CiOrdUtils.isEmpty(szMedSrvInfo)) {
			throw new BizException(String.format("服务[%s]获取套内项目的基础数据失败，请服务基础数据", setSrvInfo.getName()));
		}

		return new OrderSrvExtPackage(setSrvInfo.getId_srv(),createOrderSrvMmList(ctx,orderInfo,szMedSrvInfo,iCalcPriModeProxy.getEuSource()));
	}
	
	
}
