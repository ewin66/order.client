/**
 * 
 */
package iih.ci.ord.s.bp.assi;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * @ClassName: CiOrderTemplateSave
 * @Description: 医嘱助手模板直接保存
 * @author Comsys-li_zheng
 * @date 2016年9月1日 下午3:22:51
 * @Package iih.ci.ord.s.bp.assi
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class CiOrderTemplateSave {
    /**
     *  门急诊医嘱助手 医嘱模板保存
     * @param ortplItemDO //模板明细
     * @return
     * @throws BizException
     */
	public FMap2 SaveTemplate(OrTplNItmDO[] ortplItemDO)throws BizException{
		FMap2 map = new FMap2();
		 //1处理医嘱模板明细 对应的模板个数
		FMap2  orTmplMap =  getTemplate(ortplItemDO);
		 //2判断医嘱模板的类型
		 
		 //3保存医嘱模板到医嘱表和医嘱项目表
		
		 //4返回医嘱列表和异常的医嘱数据
		return map;
	}
	
	/**
	 * 医嘱模板对象
	 * @param ortplItemDO
	 * @return FMap2<id_orTmpl,OrTmplDO> // map <模板id， 模板实体>
	 * @throws BizException
	 */
	private  FMap2 getTemplate(OrTplNItmDO[] ortplItemDO)throws BizException{
		FMap2 map = new FMap2();
		for(OrTplNItmDO item:ortplItemDO){
			String id_ortmpl = item.getId_ortmpl();
			if(!map.containsKey(id_ortmpl)){
				OrTmplDO orTmpDo = CiOrdAppUtils.getIOrtmplMDORService().findById(id_ortmpl);
				map.put(item.getId_ortmpl(), orTmpDo);
			 }
		}
		return map;
	}
	/**
	 * 判断医嘱模板明细类型
	 * @param itemDO
	 */
	private  void JudgeOrderTemplateDetailedType(OrTplNItmDO itemDO)throws BizException{
		     
		     String sd_srvtp = itemDO.getSd_srvtp();
		     if(sd_srvtp != null && sd_srvtp.length()>1){
		    	
		    	 if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){ //药品
		    		 CiEmsSrvDTO emsSrvDto =  CiorderTemplateFieldMapping.JudgeOrTplNItmDOType(itemDO);
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS)){ //检查
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_LIS)){ //检验
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_OP)){ //手术
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){ //治疗
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_NURSE)){ //护理
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SANI)){ //卫才
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_ENTRUST)){ //嘱托
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HEALTH)){ //健康
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_SRVPKG)){ //治疗包
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_PATIMAN)){ //患者管理类 （转科出院死亡 等）
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_FIXFEE)){ //固定费用
		    		  
		    	  }else if(sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD)){ //血液制品
		    		  
		    	  }else{
		    		  
		    	  }
		    	 }
		     }
	
	
	}

