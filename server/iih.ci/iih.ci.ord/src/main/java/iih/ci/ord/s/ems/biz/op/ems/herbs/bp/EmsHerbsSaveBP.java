package iih.ci.ord.s.ems.biz.op.ems.herbs.bp;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.OrderKey2UiModelMap;
import iih.ci.ord.s.ems.biz.meta.SrvKey2UiModelMap;
import iih.ci.ord.s.ems.biz.op.ems.drugs.bp.EmsDrugsSaveBP;
import iih.ci.ord.s.ems.biz.utils.orcontent.CiOrContentUtils;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.DrugOrContentParam;
import iih.ci.ord.s.ems.biz.utils.orcontent.dto.OrContentDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

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
	protected void afterMergeOrderSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO srvInfo, Object uiModel)
			throws BizException {
		srvInfo.setId_boil(orderInfo.getId_boil());
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

	@Override
	protected void mergeOrderSrvInfo(CiEnContextDTO ctx, OrdSrvDO srvInfo, Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.mergeOrderSrvInfo(ctx, srvInfo, uiModel);
	}

	@Override
	protected void mergeOrderInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, Object uiModel) throws BizException {
		// TODO Auto-generated method stub
		super.mergeOrderInfo(ctx, orderInfo, uiModel);
		EmsDrugItemDO drugItem = (EmsDrugItemDO) uiModel;
		orderInfo.setOrders(drugItem.getOrders());
		List<OrContentDTO> orContentDtos = new ArrayList<OrContentDTO>();
		FArrayList drugList = drugItem.getEmsOrDrugListEx();
		for(int i=0;i<drugList.size();i++){
			EmsOrDrug drug = (EmsOrDrug)drugList.get(i);
			OrContentDTO orContentDTO = new OrContentDTO(drug.getName_srv(), drug.getQuan_med(), drug.getName_unit_med(), drug.getFg_self() == null?false:drug.getFg_self().booleanValue());
			orContentDtos.add(orContentDTO);
		}
		DrugOrContentParam param = new DrugOrContentParam(orderInfo.getSd_srvtp(),orderInfo.getFreq_name(),orderInfo.getDays_or(),orderInfo.getRoute_name(),orderInfo.getNote_or(),orContentDtos);
		//DrugOrContentParam param = new DrugOrContentParam(orderInfo.getSd_srvtp(),orderInfo.getFreq_name(),orderInfo.getDays_or(),orderInfo.getRoute_name(),orderInfo.getNote_or(),drugItem.getEmsOrDrugListEx());
		CiOrContentDO ciOrContentDO = CiOrContentUtils.create(param);
		ciOrContentDO.setTitle(orderInfo.getOrders()==null?"":orderInfo.getOrders()+"");
		orderInfo.setContent_or(ciOrContentDO.toString());
		orderInfo.setFg_boil(drugItem.getFg_boil());
		orderInfo.setOrders_boil(drugItem.getOrders_boil());
		orderInfo.setId_boil(drugItem.getId_boil());
		orderInfo.setId_boildes(drugItem.getId_boildes());
	}
	
	
}
