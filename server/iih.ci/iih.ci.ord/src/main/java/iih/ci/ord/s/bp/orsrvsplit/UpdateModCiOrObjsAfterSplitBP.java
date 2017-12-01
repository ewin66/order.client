package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

/***
 * 更新服务拆分后医嘱相关回写对象的操作BP
 */
public class UpdateModCiOrObjsAfterSplitBP {
	/***
	 * 更新服务拆分后医嘱相关回写对象的操作
	 * @param orsrvmmdos
	 * @throws BizException
	 */
	public void exec(Hashtable orsrvmmdos)  throws BizException{
		orSave((ArrayList)orsrvmmdos.get(keys[0]));
		orSrvSave((ArrayList)orsrvmmdos.get(keys[1]));
		orSrvMmSave((ArrayList)orsrvmmdos.get(keys[2]));
	}
	private String[] keys=new String[]{"or","srv","mm"};
	
	/***
	 * 医嘱保存
	 * @param order
	 * @throws BizException
	 */
	private void orSave(ArrayList orders ) throws BizException{
		if(orders==null || orders.size()==0)return;
		ICiorderMDOCudService rs=(ICiorderMDOCudService)ServiceFinder.find(ICiorderMDOCudService.class);
		rs.update(getCiOrders(orders));
	}
	
	/***
	 * 医嘱项目保存
	 * @param orsrvs
	 * @throws BizException
	 */
	private void orSrvSave(ArrayList orsrvs) throws BizException{
		if(orsrvs==null || orsrvs.size()==0)return;
		ICiorderSrvDOCudService rs=(ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class);
		rs.update(getOrdSrvDOs(orsrvs));
	}
	
	/***
	 * 医嘱项目对应物品保存
	 * @param orsrvmms
	 * @throws BizException
	 */
	private void orSrvMmSave(ArrayList orsrvmms) throws BizException{
		if(orsrvmms==null || orsrvmms.size()==0)return;
		IOrdsrvmmCudService rs=(IOrdsrvmmCudService)ServiceFinder.find(IOrdsrvmmCudService.class);
		rs.update(getOrdSrvMmDOs(orsrvmms));
	}
	
	private CiOrderDO[] getCiOrders(ArrayList orders){
		CiOrderDO[] rtn=new CiOrderDO[orders.size()];
		for(int i=0;i<orders.size();i++){
			rtn[i]=(CiOrderDO)orders.get(i);
		}
		return rtn;
	}
	private OrdSrvDO[] getOrdSrvDOs(ArrayList orsrvs){
		OrdSrvDO[] rtn=new OrdSrvDO[orsrvs.size()];
		for(int i=0;i<orsrvs.size();i++){
			rtn[i]=(OrdSrvDO)orsrvs.get(i);
		}
		return rtn;
	}
	private OrdSrvMmDO[] getOrdSrvMmDOs(ArrayList orsrvmms){
		OrdSrvMmDO[] rtn=new OrdSrvMmDO[orsrvmms.size()];
		for(int i=0;i<orsrvmms.size();i++){
			rtn[i]=(OrdSrvMmDO)orsrvmms.get(i);
		}
		return rtn;
	}
}
