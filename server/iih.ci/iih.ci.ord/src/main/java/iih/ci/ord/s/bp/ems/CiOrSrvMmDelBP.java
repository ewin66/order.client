package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;

/*
 * 医嘱项目删除操作BP
 */
public class CiOrSrvMmDelBP {
	/**
	 * 医嘱项目数据删除
	 * @param srvitmdatum
	 * @param orsrvdo
	 * @return
	 * @throws BizException
	 */
	public  void exec(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo)  throws BizException{
		//有效性校验
		if(!isValidate(srvitmdatum,orsrvdo))return;
		
		//医嘱项目数据信息处理
		orSrvDoHandle(srvitmdatum,orsrvdo);
		
		//物品数据信息处理
		orSrvMmDoHandle(srvitmdatum,orsrvdo);
		
		//变动用药信息处理
		orSrvDoseDoHandle(srvitmdatum,orsrvdo);
		
		//医嘱项目 关联的皮试医嘱数据信息处理逻辑
		orSrvRelSkinOrHandle(srvitmdatum,orsrvdo);
		
	}
	
	/**
	 * 有效性校验
	 * @param srvitmdatum
	 * @param orsrvdo
	 * @return
	 */
	private boolean isValidate(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo){
		if(srvitmdatum==null || orsrvdo==null)return false;
		return true;
	}
	
	/**
	 * 医嘱项目数据信息处理
	 * @param srvitmdatum
	 * @param orsrvdo
	 */
	private void orSrvDoHandle(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo){
		orsrvdo.setStatus(DOStatus.DELETED);
		srvitmdatum.setSrvdo(orsrvdo);
	}
	
	/**
	 * 医嘱项目对应的物品处理
	 * @param srvitmdatum
	 * @param orsrvdo
	 * @throws BizException
	 */
	private void orSrvMmDoHandle(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo) throws BizException{
		CiOrSrvMmsDelGetBP bp=new CiOrSrvMmsDelGetBP();
		OrdSrvMmDO do1=bp.exec(orsrvdo);
		if(do1==null)return;
		srvitmdatum.setSrvmm(do1);
	}
	
	/**
	 * 医嘱项目对应的变动剂量数据信息处理
	 * @param srvitmdatum
	 * @param orsrvdo
	 * @throws BizException
	 */
	private void orSrvDoseDoHandle(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo) throws BizException{
		CiOrSrvDosesDelGetBP bp=new CiOrSrvDosesDelGetBP();
		OrdSrvDoseDO[] do1=bp.exec(orsrvdo);
		if(do1==null)return;
		srvitmdatum.setSrvdoses(do1);
	}
	
	/**
	 * 医嘱项目 关联的皮试医嘱数据信息处理逻辑
	 * @param srvitmdatum
	 * @param orsrvdo
	 */
	private void orSrvRelSkinOrHandle(OrdSrvItemDatum srvitmdatum,OrdSrvDO orsrvdo){
		//不支持不自动做相关的反流程操作  
		//纯手工操作
	}
	
}
