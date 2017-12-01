package iih.ci.ord.s.bp.ems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 生成医嘱项目信息（含物品）集合操作BP
 */
public class CiOrCreateSrvMms8EmsBP {
	/**
	 * 生成医嘱项目信息（含物品）（医嘱模式套合计处理逻辑）
	 * @param ordo
	 * @param ems
	 * @param indexes（首个为套不包含其）
	 * @param ht 
	 * @return
	 * @throws BizException
	 */
	public  ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht)  throws BizException{
		//有效性校验
		if(indexes==null || indexes.length==0)return null;
		 long startTime = System.currentTimeMillis();
		//获得删除项（套内原来有，现在无）理论上应该不存在这种情况
		ArrayList<OrdSrvDO> delitms=getDelOrSrvInfos(aggdo,ems,indexes,ht);
		
		//参数设置
		 ArrayList<OrdSrvDO> rtns=new  ArrayList<OrdSrvDO>();
		 OrdSrvItemDatum datum=null;
		 String id_srv_set=CiOrdUtils.getEmsItemIdSrv(ems, indexes[0]); //2016-06-28
		 String id_srv="";
		 
		//遍历
		for(int i=1;i<indexes.length;i++){
			//创建医嘱项目物品相关信息
			datum=createSrvMmInfo(aggdo,ems,i);
			
			//返回结果判断
			if(datum.getSrvdo()==null)continue;
			id_srv=datum.getSrvdo().getId_srv();
			datum.getSrvdo().setId_srv_src(id_srv_set);
			
			//医嘱项目对应物品记录处理
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_srv, datum.getSrvmm());
			
			//医嘱项目对应变动用药处理
			CiOrAttachInfoUtils.addOrdSrvDoseDOs(ht, id_srv, datum.getSrvdoses());

			//医嘱项目列表处理
			rtns.add(datum.getSrvdo());
		}
		CiOrdUtils.getlogger().info("生成医嘱项目信息（含物品）（医嘱模式套合计处理逻辑）(CiOrCreateSrvMms8EmsBP) 耗时"+( System.currentTimeMillis()-startTime));
		return CiOrdUtils.mergeArrayList(rtns, delitms);
	}
	public  ArrayList<OrdSrvDO> exec(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap)  throws BizException{
		//有效性校验
		if(indexes==null || indexes.length==0)return null;
		 long startTime = System.currentTimeMillis();
		//获得删除项（套内原来有，现在无）理论上应该不存在这种情况
		ArrayList<OrdSrvDO> delitms=getDelOrSrvInfos(aggdo,ems,indexes,ht);
		
		//参数设置
		 ArrayList<OrdSrvDO> rtns=new  ArrayList<OrdSrvDO>();
		 OrdSrvItemDatum datum=null;
		 String id_srv_set=CiOrdUtils.getEmsItemIdSrv(ems, indexes[0]); //2016-06-28
		 String id_srv="";
		 
		//遍历
		for(int i=1;i<indexes.length;i++){
			//创建医嘱项目物品相关信息
			datum=createSrvMmInfo(aggdo,ems,i,bdsrvinsetClinicalMap);
			
			//返回结果判断
			if(datum.getSrvdo()==null)continue;
			id_srv=datum.getSrvdo().getId_srv();
			datum.getSrvdo().setId_srv_src(id_srv_set);
			
			//医嘱项目对应物品记录处理
			CiOrAttachInfoUtils.addOrdSrvMmDO(ht, id_srv, datum.getSrvmm());
			
			//医嘱项目对应变动用药处理
			CiOrAttachInfoUtils.addOrdSrvDoseDOs(ht, id_srv, datum.getSrvdoses());

			//医嘱项目列表处理
			rtns.add(datum.getSrvdo());
		}
		CiOrdUtils.getlogger().info("生成医嘱项目信息（含物品）（医嘱模式套合计处理逻辑）(CiOrCreateSrvMms8EmsBP) 耗时"+( System.currentTimeMillis()-startTime));
		return CiOrdUtils.mergeArrayList(rtns, delitms);
	}
	/**
	 * 根据ems服务物品信息生成医嘱项目信息
	 * @param ordo
	 * @param ems
	 * @param index
	 * @return
	 * @throws BizException
	 */
	private OrdSrvItemDatum createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,int index) throws BizException{
		CiOrCreateSrvMm8EmsBP bp=new CiOrCreateSrvMm8EmsBP();
		return bp.exec(aggdo, ems, index);
	}
	private OrdSrvItemDatum createSrvMmInfo(CiorderAggDO aggdo,CiEmsDTO ems,int index,Map<String,MedSrvSetItemDO> bdsrvinsetClinicalMap) throws BizException{
		CiOrCreateSrvMm8EmsBP bp=new CiOrCreateSrvMm8EmsBP();
		return bp.exec(aggdo, ems, index,bdsrvinsetClinicalMap);
	}
	/**
	 * 获得套内项目已删除的医嘱项目及相关信息（套合计模式）
	 * @param aggdo
	 * @param ems
	 * @param indexes
	 * @param ht
	 * @return
	 * @throws BizException
	 */
	private ArrayList<OrdSrvDO> getDelOrSrvInfos(CiorderAggDO aggdo,CiEmsDTO ems,Integer[] indexes,Hashtable ht) throws BizException{
		return null;
	}
	 
}
