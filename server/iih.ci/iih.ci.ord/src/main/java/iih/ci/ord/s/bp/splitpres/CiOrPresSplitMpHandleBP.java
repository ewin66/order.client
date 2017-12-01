package iih.ci.ord.s.bp.splitpres;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.mp.dg.i.IMpDgOutService;

/**
 *  临床医嘱处方分方后执行域相关处理操作BP
 */
public class CiOrPresSplitMpHandleBP {

	/**
	 * 临床医嘱处方分方后执行域相关处理
	 * @param cipres
	 * @throws BizException
	 */
	public  void exec(CiPresDO[] cipres)throws BizException{
		//空判断
		if(CiOrdUtils.isEmpty(cipres))return;
		
		//分方后，处方主键标识插入执行域处方状态数据表
		insertPresStatusData(cipres);

	}
	
	/**
	 * 分方后，处方主键标识插入执行域处方状态数据表
	 * @param presArray
	 * @throws BizException 
	 */
	private void insertPresStatusData(CiPresDO[] cipres) throws BizException{
		//获得处方主键标识集合 
		 String[] presArray = getIdpres(cipres);
		 
		 //分方后，处方主键标识插入执行域处方状态数据表
		 if(presArray != null && presArray.length >0){
			  ServiceFinder.find(IMpDgOutService.class).insertPresStatusData(presArray);
		 }
	}
	
	/**
	 * 获得处方id_pres数组
	 * @param cipres
	 * @return
	 */
    private String[] getIdpres(CiPresDO[] cipres){
   	 if(cipres== null || cipres.length==0) return null;
   	 String[] presArray = new String[cipres.length];
   	 int i = 0;
   	 for(CiPresDO pres:cipres){
   		 presArray[i] = pres.getId_pres();
   		 i++;
   	 }
   	 
   	 return presArray;
    }
    
}
