package iih.ci.ord.s.ems.biz.op.emsv1.herbs.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsSaveBP;
import xap.mw.core.data.BizException;

public class EmsHerbsSaveBP extends EmsDrugsSaveBP {


	/**
	 * 处理煎法信息
	 * 
	 * @param srvInfo
	 * @param uiModelInfo
	 */
	protected void handleOrderSrvBoilInfo(OrdSrvDO srvInfo, Object uiModelInfo) throws BizException {
		//		ordInfo.setId_boil(String Id_boil) ;
		//		ordInfo.setId_boildes(String Id_boildes) ;
	}
	
	@Override
	protected OrderKey2UiModelMap assembleOrderKey2UiModelMap(List<Object> listUiModel) {
		// TODO Auto-generated method stub
		return super.assembleOrderKey2UiModelMap(listUiModel);
	}


	@Override
	protected SrvKey2UiModelMap assembleSrvKey2UiModelMap(Object uiModel) {
		// TODO Auto-generated method stub
		return super.assembleSrvKey2UiModelMap(uiModel);
	}
}
