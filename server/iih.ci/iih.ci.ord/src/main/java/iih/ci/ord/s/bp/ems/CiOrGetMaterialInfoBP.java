package iih.ci.ord.s.bp.ems;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.mm.itf.material.d.GetStockReqDTO;
import iih.mm.itf.material.d.MaterialStockDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/*
 * 获得医疗单关联物品信息操作BP
 */
public class CiOrGetMaterialInfoBP {
	/**
	 * 生成皮试医嘱信息操作
	 * @param id_srv
	 * @param ems
	 * @return  CiorderAggDO0  CiSkinTestRstDO1 
	 * @throws BizException
	 */
	public FArrayList  exec(GetStockReqDTO[]  getpristoredtos)  throws BizException{
		if(getpristoredtos==null || getpristoredtos.length==0)return null;
		
		//获得物品基本信息集合
		MeterialDO[] mminfos=CiOrdAppUtils.getMaterialQryService().findByBIds(getMmIds(getpristoredtos), FBoolean.FALSE);
		
		//获得对应仓库物品结存与价格信息  
		//特别注意传入的条数与传出的条数可能不一致
		MaterialStockDTO[] stockdtos=CiOrdAppUtils.getMaterialStockQryService().getMaterialStocks(getpristoredtos); 
		
		return null;
	}
	
	/**
	 * 获得物品id数组
	 * @param getpristoredtos
	 * @return
	 */
	private String[] getMmIds(GetStockReqDTO[]  getpristoredtos){
		String[] ids=new String[getpristoredtos.length]; 
		for(int i=0;i<getpristoredtos.length;i++){
			ids[i]=getpristoredtos[i].getId_mm();
		}
		return ids;
	}
}
