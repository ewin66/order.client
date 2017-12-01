/**
 * 
 */
package iih.ci.ord.s.bp.assi;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.desc.ent.dataobject.DmEnumDesc;

/**
 * @ClassName: JudgeOrderTemlateType
 * @Description: 判断模板的类型
 * @author Comsys-li_zheng
 * @date 2016年9月12日 下午8:02:17
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class JudgeOrderTemlateType {
    
	 private static List herbalDruglist = new ArrayList();//草药 注射（多服务的药品）
	 private static List commonDruglist = new ArrayList();//草药（当服务的药品）
	
	public  static FMap2 JudgeOrederTemlate(OrTplNItmDO[] ortplItems)throws BizException{
		FMap2  map =new FMap2();
		herbalDruglist.clear();
		commonDruglist.clear();
		if(ortplItems == null ||ortplItems.length == 0) return null;
		OrtemplateGrouping(map,ortplItems);
		
		//判断模板的类型  基础模板  服务 和套
//		List<OrTplNItmDO> list = JudgeTmplType(ortplItemDO);
//		
//		for(OrTplNItmDO itemDO:list){
//			JudgeOrderTemplateDetailedType(itemDO);
//		}
//         map.put(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG, commonDruglist);
//         map.put(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, herbalDruglist);
		return map;
	}
    /**
     * 医嘱项目 一个医嘱模板的 是一条医嘱
     * @param map
     * @param ortplItemDO
     * @throws BizException
     */
	private static  void OrtemplateGrouping(FMap2  map,OrTplNItmDO[] ortplItems)throws BizException{
		if(ortplItems != null && ortplItems.length >0){
			List itemlist  = null;
			List<String>  ortmplList = new ArrayList();
			for(OrTplNItmDO item: ortplItems){
				ortmplList.add(item.getId_ortmpl());
				String key = item.getId_ortmpl()+item.getIdentical_ortmpl()+item.getSd_srvtp().substring(0, 2);
				if(map.containsKey(key)){
					itemlist = (List)map.get(key);
					itemlist.add(item);
				}else{
				 List  temp = new ArrayList();
				  temp.add(item);
				 map.put(key, temp);
				}
			}
			 map.put("ortmplList",ortmplList);
		}
	}
	
	
	
	/**
	 * @DmEnumDesc(name="模板",description="基础医嘱模板")
		public static final Integer ORTMPL=0; //模板
	    @DmEnumDesc(name="服务",description="医疗服务")
		public static final Integer SRV=1; //服务
	    @DmEnumDesc(name="套",description="服务套")
		public static final Integer SRVSET=2; //套
	 * @param ortplItemDO
	 */
	private static List<OrTplNItmDO> JudgeTmplType(OrTplNItmDO[] ortplItemDO)throws BizException{
		 List list = new ArrayList();
		 for(OrTplNItmDO itemDO: ortplItemDO){
			 if(OrTplItmTypeEnum.ORTMPL.equals(itemDO.getEu_ortplitmtp())){
				 getBdSrvORTmplItem(list,itemDO.getId_srv());
			 }else{
				 list.add(itemDO);
			 }
		 }
		 return list;
	}
	
	/**
	 * 医嘱模板引用基础模板的 
	 * @param list
	 * @param id_ortmpl
	 * @throws BizException
	 */
	private  static void getBdSrvORTmplItem(List<OrTplNItmDO> list ,String id_ortmpl)throws BizException{
		 String whereStr = OrTplNItmDO.ID_ORTMPL + " = '"+ id_ortmpl  +"'";
		 OrTplNItmDO[] itemDOS =  CiOrdAppUtils.getIOrTplNItmDORService().find(whereStr, OrTplNItmDO.ID_ORTMPL, FBoolean.FALSE);
	     if(itemDOS != null && itemDOS.length >0){
	    	 for(OrTplNItmDO itemDO:itemDOS){
	    		 list.add(itemDO); 
	    	 }
	     }
	}
	
	
	/**
	 * 判断医嘱模板明细类型
	 * @param itemDO
	 */
	private static void JudgeOrderTemplateDetailedType(OrTplNItmDO itemDO)throws BizException{
		     
		     String sd_srvtp = itemDO.getSd_srvtp();
		     if(sd_srvtp != null && sd_srvtp.length()>1){
		    	 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){ //药品
		    		 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG_ZX)
				    		   ||sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG) ){
				    		  //注射类药品  和草药
		    			      if(herbalDruglist != null && herbalDruglist.size() >0){
		    			    	  //判断同一类型 是否是 同一模板下的项目
		    			    	  OrTplNItmDO temp = (OrTplNItmDO)herbalDruglist.get(herbalDruglist.size()-1);
		    			    	  if(temp.getId_ortmpl().equals(itemDO.getId_ortmpl())){
		    			    		  herbalDruglist.add(itemDO);
		    			    	  }else{
		    			    		  commonDruglist.add(itemDO);
		    			    	  }
		    			      }else if(herbalDruglist.size()==0){
	    			    		  herbalDruglist.add(itemDO);
	    			    	  }
		    			      
				    		 }else{
				    		  // 普通药品和其他药 
				    			 commonDruglist.add(itemDO);
				    		 }
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){ //检查
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){ //检验
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){ //手术
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){ //治疗
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)){ //护理
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)){ //卫才
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){ //嘱托
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HEALTH)){ //健康
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SRVPKG)){ //治疗包
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN)){ //患者管理类 （转科出院死亡 等）
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_FIXFEE)){ //固定费用
		    		  commonDruglist.add(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)){ //血液制品
		    		  commonDruglist.add(itemDO);
		    	  }else{
		    		  commonDruglist.add(itemDO);
		    	  }
		    	 }else{
		    		// sd_srvtp为空的时 处理
		    	 }
		     }
	
}
