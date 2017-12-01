package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 保存之前验证医嘱 CiOrderDO
 * @author li_zheng
 *
 */
public class CiOrderDOValidateBP {

	/**
	 * 验证医嘱项目的执行科室
	 *  不能为空 null 
	 */
	public void ValidateDeptMp(CiorderAggDO[] ciorList)throws BizException{
		if(ciorList != null && ciorList.length >0){
			//循环医嘱
			String message = "";
			for(CiorderAggDO aggDO: ciorList){
				//循环医嘱项目
				if(aggDO.getOrdSrvDO()== null){
					message ="没有医嘱项目";
					break;
				}
				for(OrdSrvDO srvDO:aggDO.getOrdSrvDO()){
					
					if(srvDO == null){
						message ="没有医嘱项目";
						break;
					}
					if( CiOrdUtils.isEmpty(srvDO.getId_dep_mp())){
						message += aggDO.getParentDO().getName_or()+" \n " 
					    + srvDO.getName() +"没有执行科室"; 
					}
					
					if(srvDO.getFg_selfpay()== null){
						//srvDO.setFg_selfpay(FBoolean.TRUE);
					}
				}
			}
			if(!CiOrdUtils.isEmpty(message)){
				throw  new BizException(message);
			}
		}
		
	}
	
}
