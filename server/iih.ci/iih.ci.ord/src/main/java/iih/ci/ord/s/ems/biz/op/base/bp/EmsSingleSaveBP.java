package iih.ci.ord.s.ems.biz.op.base.bp;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import xap.mw.core.data.BizException;

/**
 * 非药品服务基类
 * @author wangqingzhu
 *
 */
public class EmsSingleSaveBP extends EmsBaseSaveBP {
	@Override
	protected BdSrvInfoList bdSrvInfoListFrom(CiOrderDO orderInfo, OrderSrvMmList ordSrvMmInfoList)
			throws BizException {
		
			MedSrvDO[] szMedSrvInfo = BdSrvInfoUtils.QueryBdSrvInfo(new String[]{orderInfo.getId_srv()});
			return (new BdSrvInfoList(szMedSrvInfo));
		
	}

	@Override
	protected OrderPackageInfo[] mergeOrderPakageInfo(CiEnContextDTO ctx, OrderPackageInfo[] szOrderPakageInfo)
			throws BizException {
		// TODO Auto-generated method stub
		OrderPackageInfo[] szOrderPackageInfo = super.mergeOrderPakageInfo(ctx, szOrderPakageInfo);
		
		for (OrderPackageInfo pInfo : szOrderPakageInfo) {
			//合并申请单信息
			if (!CiOrdUtils.isEmpty(pInfo.getOrderAppSheetList())){
				mergeOrderAppInfo(ctx,pInfo.getOrderAppSheetList().asArray(),pInfo.getExtInfoList().asArray(), pInfo.getUiModel());
			}
		}
		
		return szOrderPackageInfo;
	}

	
	
}
