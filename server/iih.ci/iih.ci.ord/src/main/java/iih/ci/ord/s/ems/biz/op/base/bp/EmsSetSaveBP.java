package iih.ci.ord.s.ems.biz.op.base.bp;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfoList;
import iih.ci.ord.s.ems.biz.meta.OrderSavedRstInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.def.DefaultSetCreateOrderInfo;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;

/**
 * 医疗单服务套保存逻辑处理
 * @author wangqingzhu
 *
 */
public class EmsSetSaveBP extends EmsSingleSaveBP {
	
	/**
	 * 合并用户数据到默认医嘱中
	 * @param ctx 就诊上下文
	 * @param szOrderPakageInfo 批量医嘱包信息
	 * @return 批量医嘱包信息（合并过信息）
	 * @throws BizException 业务异常
	 */
	protected OrderPackageInfo[]  mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo) throws BizException{
		// 
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			
			// 合并医嘱UI模型数据
			mergeOrderInfo(ctx, pInfo.getOrderInfo(), pInfo.getUiModel());
			
			// 服务套内项目保存信息重新创建
			if (pInfo.isSet()){
				if(pInfo.isNew()){
					// 新建医嘱时候，删除服务信息
					if(!pInfo.isOrderSrvMmListEmpty())pInfo.getOrderSrvMmList().clear();
					if (!pInfo.isOrderSrvSetListEmpty())pInfo.getOrderSrvSetList().clear();
				}
				else{
				 // 逻辑删除医嘱服务中的数据
					pInfo.getOrderSrvMmList().logicDelete();
					pInfo.getOrderSrvSetList().logicDelete();
				}
				
				// 重建套内临床项目
				SrvKey2UiModelMap setItemKey2UiModelMap = assembleSrvSetItemKey2UiModelMap(pInfo.getUiModel());
				OrderSrvExtPackage orderSrvExtPackage = ((DefaultSetCreateOrderInfo)getDefaultCreateOrderInfo()).
						CalcSrvFeesOrdSrvInfo(
								ctx, // 就诊上下文
								pInfo.getOrderInfo(), // 医嘱信息
								new BdSrvMmInfo(
										pInfo.getMainSrvInfo(), // 定义态基础服务信息
										pInfo.getUiModel() // 客户UI对象
										),
								setItemKey2UiModelMap.asKeyArray() // 临床套内项目与客户UI模型关系表
								);
				// 计算套内非临床
				MedSrvSetItemDO[] szMedSrvSetItemDO = BdSrvInfoUtils.QueryMedSrvSetItemBy(pInfo.getMainSrvInfo().getId_srv(), false);
				OrderSrvExtPackage orderSrvExtPackage1 = ((DefaultSetCreateOrderInfo)this.getDefaultCreateOrderInfo()).CalcSrvFeesOrdSrvInfo(ctx, pInfo.getOrderInfo(), new BdSrvMmInfo(pInfo.getMainSrvInfo()), szMedSrvSetItemDO);
				if (!CiOrdUtils.isEmpty(orderSrvExtPackage)&&!CiOrdUtils.isEmpty(orderSrvExtPackage1)) {
					orderSrvExtPackage.merge(orderSrvExtPackage1);
				}
				// 将新计算出来的服务套内项目附加到医嘱包中
				pInfo.append(orderSrvExtPackage.getOrdSrvSetInfoList());
				pInfo.append(orderSrvExtPackage.getOrderSrvMmList());
				for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()){
					// 处理其他信息
					afterMergeOrderSrvInfo(ctx,pInfo.getOrderInfo(),srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
				}
			}
			else{
				if(pInfo.getMainSrvInfo().getId_primd().equals(IBdPrimdCodeConst.ID_PRI_SRV_COMP)){
					/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
					// TODO:非套组合计价服务
					for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()) {
						// 合并服务信息
						mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), pInfo.getUiModel());
						// 处理其他信息
						afterMergeOrderSrvInfo(ctx, pInfo.getOrderInfo(), srvMmInfo.getOrderSrvInfo(),
								pInfo.getUiModel());

						if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())) {
							mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(), pInfo.getUiModel());
						}
					}
					/////////添加检验、检查、诊疗多剂量多次执行，杨敬本20171111
				}else{
					
					for (OrderSrvMmInfo srvMmInfo : pInfo.getOrderSrvMmList()){
						// 合并服务信息
						mergeOrderSrvInfo(ctx, srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
						// 处理其他信息
						afterMergeOrderSrvInfo(ctx,pInfo.getOrderInfo(),srvMmInfo.getOrderSrvInfo(), srvMmInfo.getUiModel());
						
						if (CiOrdUtils.isTrue(srvMmInfo.getOrderSrvInfo().getFg_mm())){
							mergeOrderMmInfo(ctx, srvMmInfo.getOrderSrvMmInfo(), srvMmInfo.getUiModel());
						}
					}
				}
				
			}
			
			// 合并医嘱服务申请单
			if (!CiOrdUtils.isEmpty( pInfo.getOrderAppSheetList())) {
				mergeOrderAppInfo(ctx, pInfo.getOrderAppSheetList().asArray(), pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
				// 合并申请单之后处理
				afterMergeOrderAppInfo(ctx, pInfo.getOrderInfo(), pInfo.getOrderAppSheetList().asArray(), pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
			// 处理服务套医嘱医保信息
			handleOrderHpInfo(ctx, pInfo.getOrderInfo());
			// 处理医嘱服务医保信息
			OrderSrvMmList szOrdSrvMmInfo = pInfo.getOrderSrvMmList();
			handleSrvHpInfo(ctx, szOrdSrvMmInfo);
			// 处理其他的医保信息
			OrdSrvDO[] szOrdSrvInfo = pInfo.getOrderSrvList();
			afterHandleHpInfo(ctx, pInfo.getOrderInfo(), szOrdSrvInfo);
		}
		return szOrderPakageInfo;
	}
	
	/**
	 * 将前端选择的临床套内项目转化为服务ID的映射表
	 * @param objInfo
	 * @return
	 */
	protected SrvKey2UiModelMap assembleSrvSetItemKey2UiModelMap(Object objInfo){
		assert false : "服务套项目必须实现该方法：将前台选择的套内项目集合转化为服务ID的映射关系";
		
		return null;
	}
	
	/**
	 * 合并套项目信息
	 * 
	 * @param ctx
	 * @param setSrvList
	 * @param uiModel
	 * @throws BizException
	 */
	protected void mergeOrderSetInfo(CiEnContextDTO ctx, OrdSrvSetDO[] setSrvList, Object uiModel) throws BizException {
		
	}

	@Override
	protected OrderSavedRstInfo[] handleSaveOrderPackageList(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPackageInfo)
			throws BizException {
		// TODO Auto-generated method stub
		OrderSavedRstInfo[] szOrderSavedRstInfo = super.handleSaveOrderPackageList(ctx, szOrderPackageInfo);
		
		// 保存医嘱服务套内项目信息
		OrderPackageInfoList orderPackageInfoList = new OrderPackageInfoList(szOrderPackageInfo);
		OrdSrvSetDO[] szOrdSrvSetInfo = orderPackageInfoList.asOrderSrvSetArray();
		mergeOrderSetInfo(ctx, szOrdSrvSetInfo, szOrderPackageInfo[0].getUiModel());
		if (!CiOrdUtils.isEmpty(szOrdSrvSetInfo)){
			szOrdSrvSetInfo = CiOrdAppUtils.getOrsrvsetService().save(szOrdSrvSetInfo);
		}
		return szOrderSavedRstInfo;
	}
	
	
	
}
