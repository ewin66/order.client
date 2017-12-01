package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 创建用法关联费用的医嘱项目集合信息操作BP
 */
public class CiOrRelUsgFeeOrSrvBuildBP {
	/**
	 * 创建用法关联费用的医嘱项目集合信息操作
	 * @param aggdo
	 * @param relfeesrvdos
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	public OrdSrvDO[] exec(CiorderAggDO aggdo,UsageRelFeeSrvDO[] relfeesrvdos,Hashtable ht)  throws BizException{
		//获得删除项
		OrdSrvDO[] delitms=getDelOrSrvInfos(aggdo,relfeesrvdos, ht);
		
		//有效性校验
		if(relfeesrvdos==null || relfeesrvdos.length==0){
			return delitms;
		}
		
		//参数设置
		//OrdSrvDO[] rtns=new OrdSrvDO[relfeesrvdos.length];
		//改为使用集合，长度未知
		List<OrdSrvDO> rtArray = new ArrayList<OrdSrvDO>();
		OrdSrvItemDatum datum=null;
		String id_srv="";
		
		//遍历
		for(int i=0;i<relfeesrvdos.length;i++){
		//	long startTIme = System.currentTimeMillis(); 
			//获得医嘱对应的项目相关的信息
			if(relfeesrvdos[i]== null)continue;
			datum=createOrSrvDO(aggdo,CiOrdAppUtils.getMedsrvMDORService().findById(relfeesrvdos[i].getId_srv()),relfeesrvdos[i]);
			
			//有效性判断
			if(datum==null || datum.getSrvdo()==null)continue;
			id_srv=datum.getSrvdo().getId_srv();
			
			//医嘱项目对应物品记录处理
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_srv, datum.getSrvmm());
			
			//医嘱项目对应变动用药处理
			//不存在
			
			//医嘱项目设置
			//rtns[i]=datum.getSrvdo();
			//改为使用集合
			rtArray.add(datum.getSrvdo());
			
		//	CiOrdUtils.LogerOutInfo("************CiOrRelUsgFeeOrSrvBuildBP  耗时"+( System.currentTimeMillis()-startTIme));
			
		}
		OrdSrvDO[] rtns=new OrdSrvDO[rtArray.size()];
		return (OrdSrvDO[])CiOrdUtils.mergeObjAry(rtArray.toArray(rtns), delitms);
	}
	
	/**
	 * 生成医嘱服务项目
	 * @param ordo
	 * @param bdsrvdo
	 * @return
	 * @throws BizException 
	 */
	private OrdSrvItemDatum createOrSrvDO(CiorderAggDO aggdo,MedSrvDO bdsrvdo,UsageRelFeeSrvDO usgrelfeesrvdo) throws BizException{
		CiOrCreateSrvMm8UsgFeeBP bp=new CiOrCreateSrvMm8UsgFeeBP();
		return bp.exec(aggdo, bdsrvdo,usgrelfeesrvdo);
	
	}
	
	/**
	 * 获得用法关联已删除的医嘱项目及相关信息
	 * @param aggdo
	 * @param relfeesrvdos
	 * @param ht
	 * @throws BizException 
	 */
	private OrdSrvDO[] getDelOrSrvInfos(CiorderAggDO aggdo,UsageRelFeeSrvDO[] relfeesrvdos,Hashtable ht) throws BizException{
		GetDelOrSrvInfos4UsgRelSrvBP bp=new GetDelOrSrvInfos4UsgRelSrvBP();
		ArrayList<OrdSrvDO> list=bp.exec(aggdo, relfeesrvdos, ht);
		if(list==null || list.size()==0)return null;
		return (OrdSrvDO[])CiOrdUtils.list2Array(list, OrdSrvDO.class);
	}
}
