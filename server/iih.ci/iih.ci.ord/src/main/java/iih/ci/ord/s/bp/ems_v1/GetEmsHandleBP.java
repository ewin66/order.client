package iih.ci.ord.s.bp.ems_v1;

import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 医疗单处理
 * @author vivi
 *
 */
public class GetEmsHandleBP implements EmsType {
	
	public FMap2 exec(CiOrderDO[] szOrders, int[] szEmsType, CiEnContextDTO ctx){
		int index  = 0;
		FArrayList emsList = new FArrayList();
		FArrayList errorList = new FArrayList();
		for (CiOrderDO ord : szOrders){
			EmsBaseItemBP bp = getEmsItemBP(szEmsType[index++],ctx);
			if (null != bp){
				try{
					emsList.add(bp.getViewModel(ord));
				}
				catch(BizException e){
					errorList.add(String.format("医嘱[%s]发生错误: %s", ord.getContent_or(),e.getMessage()));
				}
				catch(Exception e){
					errorList.add(String.format("医嘱[%s]发生错误: %s", ord.getContent_or(),e.getMessage()));
				}
				
			}
		}
		// ServiceFinder.find(IMedsrvRService.class).findById(id);
		FMap2 rtnMap = new FMap2();
		//rtnMap.put("medsrv", emsList);
		rtnMap.put("viewmodels", emsList);
		if (errorList.size() > 0){
			rtnMap.put("errors", errorList);
		}
		return rtnMap;
	}
	
	/**
	 * 此处的获取医疗单处理器，应该通过【医疗单管理】节点配置
	 * @param szEmsType
	 * @param ctx
	 * @return
	 */
	private EmsBaseItemBP getEmsItemBP(int szEmsType,CiEnContextDTO ctx){
		
		if (szEmsType == COMMONDRUG) //通用药品
		{
			return new EmsDrugItemBP(ctx);
		}
		else if (szEmsType == RIS) //检查
		{
			return new EmsRisItemBP(ctx);
		}
		else if (szEmsType == LIS) //检验
		{
			return new EmsLisItemBP(ctx);
		}
		else if (szEmsType == IV) //Iv药
		{
			return new EmsInjectionItemBP(ctx);
		}
		else if (szEmsType == HERB) //草药
		{
			return new EmsHerbsItemBP(ctx);
		}
		else if (szEmsType == OPER) //手术
		{
			return new EmsOprItemBP(ctx);
		}
		else if (szEmsType == PATHGY) //病理
		{
			return new EmsPathologyItemBP(ctx);
		}
		else if (szEmsType == BT) //备血
		{
			return new EmsPobItemBP(ctx);
		}
		else if (szEmsType == COMMON) //简洁
		{
			return new EmsTreatItemBP(ctx);
		}
		else if (szEmsType == CONS) //会诊
		{
			return new EmsConsItemBP(ctx);
		}
		else if (szEmsType == SKINTEST) //皮试医疗单
		{
			return new EmsSkinTestItemBP(ctx);
		}
		else if (szEmsType == BTUSE) //用血
		{
			return new EmsTobItemBP(ctx);
		}
		else if (szEmsType == TRANSDEPT) //转科
		{
			return new EmsTransDeptItemBP(ctx);
		}
		else if (szEmsType == OUTHOSP) //出院
		{
			return new EmsOutHspItemBP(ctx);
		}
		else if (szEmsType == TRANSWARD) //转病区
		{
			return new EmsTransWardItemBP(ctx);
		}
		
		return new EmsCommItemBP(ctx);
	}

}
