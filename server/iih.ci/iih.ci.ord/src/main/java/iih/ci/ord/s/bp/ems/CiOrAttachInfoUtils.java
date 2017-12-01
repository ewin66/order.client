package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciord.d.desc.OrSrvAgentInfoDODesc;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.FMap;
import xap.sys.appfw.orm.model.agg.BaseAggDO;

public class CiOrAttachInfoUtils {

	/**
	 * 医嘱项目对应物品记录添加到Hashtable中
	 * @param htattachinfo
	 * @param id_srv
	 * @param srvmmdo
	 */
	public static void addOrdSrvMmDO(Hashtable htattachinfo,String id_srv,OrdSrvMmDO srvmmdo){
		String key=OrdSrvMmDODesc.CLASS_FULLNAME;
		
		//增加逻辑
		if(srvmmdo!=null && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				if(((FMap)htattachinfo.get(key)).containsKey(id_srv+"_"+srvmmdo.getId_mm())){
					((List<OrdSrvMmDO>)((FMap)htattachinfo.get(key)).get(id_srv+"_"+srvmmdo.getId_mm())).add(srvmmdo);
				}else{
					FMap map =  new FMap();
					//因为存在前台将服务删除后，又重新添加进来，那么从前台过来的数据会有两条，一条删除，一条新建。所以使用集合来存储
					List<OrdSrvMmDO> mmList = new ArrayList<OrdSrvMmDO>();
					mmList.add(srvmmdo);
					((FMap)htattachinfo.get(key)).put(id_srv+"_"+srvmmdo.getId_mm(), mmList);
				}
			}else{
				FMap map =  new FMap();
				//因为存在前台将服务删除后，又重新添加进来，那么从前台过来的数据会有两条，一条删除，一条新建。所以使用集合来存储
				List<OrdSrvMmDO> mmList = new ArrayList<OrdSrvMmDO>();
				mmList.add(srvmmdo);
				map.put(id_srv+"_"+srvmmdo.getId_mm(), mmList);
				htattachinfo.put(key, map);
				
			}
		}
	}
//	public static void addOrdSrvMmDO(Hashtable htattachinfo,String id_srv,OrdSrvMmDO srvmmdo){
//		String key=OrdSrvMmDODesc.CLASS_FULLNAME;
//		
//		//增加逻辑
//		if(srvmmdo!=null && htattachinfo!=null){
//			if(htattachinfo.containsKey(key)){
//				((FMap)htattachinfo.get(key)).put(id_srv+"_"+srvmmdo.getId_mm(),srvmmdo);
//			}else{
//				FMap map =  new FMap();
//				map.put(id_srv+"_"+srvmmdo.getId_mm(), srvmmdo);
//				htattachinfo.put(key, map);
//				
//			}
//		}
//	}
	/**
	 * 医嘱项目对应变动用药记录添加到Hashtable中
	 * @param htattachinfo
	 * @param id_srv
	 * @param srvdoses
	 */
	public static void addOrdSrvDoseDOs(Hashtable htattachinfo,String id_srv,OrdSrvDoseDO[] srvdoses){
		String key=OrdSrvDoseDODesc.CLASS_FULLNAME;
		
		//增加逻辑
		if(srvdoses!=null && srvdoses.length!=0 && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(id_srv,srvdoses);
			}else{
//				htattachinfo.put(key, (new FMap()).put(id_srv,srvdoses));//FMap报空
				FMap map=new FMap();
				map.put(id_srv,srvdoses);
				htattachinfo.put(key, map);
			}
		}
	}
	
	/**
	 * 医嘱项目对应代办人记录添加到Hashtable中
	 * @param htattachinfo
	 * @param id_srv
	 * @param srvagentinfo
	 */
	public static void addOrSrvAgentInfoDO(Hashtable htattachinfo,String id_srv,OrSrvAgentInfoDO srvagentinfo){
		String key=OrSrvAgentInfoDODesc.CLASS_FULLNAME;
		
		//增加逻辑
		if(srvagentinfo!=null && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(id_srv,srvagentinfo);
			}else{
				FMap map=new FMap();
				map.put(id_srv,srvagentinfo);
				htattachinfo.put(key, map);
			}
		}
	}
	/**
	 * 医嘱及医嘱项目对应的套内项目添加到Hashtable中
	 * @param htattachinfo
	 * @param id_srv_set
	 * @param orsrvsets
	 */
	public static void addOrdSrvSetDOs(Hashtable htattachinfo,String id_srv_set,OrdSrvSetDO[] orsrvsets){
		String key=OrdSrvSetDODesc.CLASS_FULLNAME;
		
		//增加逻辑
		if(orsrvsets!=null && orsrvsets.length!=0 && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				
				((FMap)htattachinfo.get(key)).put(orsrvsets[0].getId_srvset(),orsrvsets);
			}else{
				FMap map = new FMap();
				map.put(orsrvsets[0].getId_srvsetdef(),orsrvsets);
				htattachinfo.put(key, map);
			}
		}
	}
	
	/**
	 * 医嘱对应的申请单数据添加到Hashtable中
	 * @param htattachinfo
	 * @param key
	 * @param appdo
	 */
	public static void addOrAppDO(Hashtable htattachinfo,int iemstype,BaseDO appdo){
		String key=CiOrdUtils.getOrAppClizname(iemstype);
		//增加逻辑
		if(appdo!=null  && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(CiOrdUtils.ORAPP_SHEET_KEY,appdo);
			}else{
				FMap map = new FMap();
				map.put(CiOrdUtils.ORAPP_SHEET_KEY,appdo);
				htattachinfo.put(key,map);
			}
		}
	} 
	
	/**
	 * 医嘱对应的申请单数据添加到Hashtable中
	 * @param htattachinfo
	 * @param key
	 * @param appdo
	 */
	public static void addOrAppDatumObj(Hashtable htattachinfo,int iemstype,Object appdo){
		String key=CiOrdUtils.getOrAppClizname(iemstype);
		//增加逻辑
		if(appdo!=null  && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(CiOrdUtils.ORAPP_SHEET_KEY,appdo);
			}else{
				FMap map = new FMap();
				map.put(CiOrdUtils.ORAPP_SHEET_KEY,appdo);
				htattachinfo.put(key, map);
			}
		}
	} 
	
	/**
	 * 医嘱对应的申请单数据添加到Hashtable中
	 * @param htattachinfo
	 * @param key
	 * @param appdo
	 */
	public static void addOrAppAggDO(Hashtable htattachinfo,int iemstype,BaseAggDO appaagdo){
		String key=CiOrdUtils.getOrAppClizname(iemstype);
		//增加逻辑
		if(appaagdo!=null  && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(CiOrdUtils.ORAPP_SHEET_KEY,appaagdo);
			}else{
				FMap map = new FMap();
				map.put(CiOrdUtils.ORAPP_SHEET_KEY,appaagdo);
				htattachinfo.put(key, map);
			}
		}
	}
	
	/**
	 * 服务对应的皮试医嘱数据添加到Hashtable中
	 * @param htattachinfo
	 * @param id_srv
	 * @param oraggandreldatum
	 */
	public static void addOrSrvRelSkinOr(Hashtable htattachinfo,String id_srv_mm,CiOrAggAndRelDatum oraggandreldatum){
		String key=ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST;
		//增加逻辑
		if(oraggandreldatum!=null  && htattachinfo!=null){
			if(htattachinfo.containsKey(key)){
				((FMap)htattachinfo.get(key)).put(id_srv_mm,oraggandreldatum);
			}else{
				FMap map = new FMap();
				map.put(id_srv_mm,oraggandreldatum);
				htattachinfo.put(key, map);
			}
		}
	}
	/**
	 * 获得医嘱对应的皮试医嘱数据信息  Map数据<id_srv+","+id_mm,aggandreldatum>
	 * @param ht
	 * @return
	 */
	public static FMap getRelSkinOrDOMap(Hashtable ht){
		String key=ICiDictCodeConst.SD_RELTYPE_ID_SKINTEST;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱项目对应的物品DO  Map数据<id_srv,do>
	 * @param ht
	 * @return
	 */
	public static FMap getOrdSrvMmDOMap(Hashtable ht){
		String key=OrdSrvMmDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱项目对应变动剂量DO  Map数据<id_srv,do[]>
	 * @param ht
	 * @return
	 */
	public static FMap getOrdSrvDoseDOsMap(Hashtable ht){
		String key=OrdSrvDoseDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱项目代办人数据信息DO（毒麻药时）  Map数据<id_srv,do[]>
	 * @param ht
	 * @return
	 */
	public static FMap getOrSrvAgentInfoDOMap(Hashtable ht){
		String key=OrSrvAgentInfoDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱或医嘱项目对应的套DO  Map数据<id_srv_set,dos>
	 * @param ht
	 * @return
	 */
	public static FMap getOrdSrvSetDOMap(Hashtable ht){
		String key=OrdSrvSetDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱申请单对应DO或aggdo  Map数据<CiOrdUtils.ORAPP_SHEET_KEY,dos>
	 * @param ht
	 * @return
	 */
	public static FMap getOrAppSheetInfoMap(Hashtable ht,int iemstp){
		String key=CiOrdUtils.getOrAppClizname(iemstp);
		return (FMap)ht.get(key);
	}
}
