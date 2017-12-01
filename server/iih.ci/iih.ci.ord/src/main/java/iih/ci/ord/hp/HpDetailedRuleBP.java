/**
 * 
 */
package iih.ci.ord.hp;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * @ClassName: HpDetailedRuleBP
 * @Description: 医保的项目规则
 * @author Comsys-li_zheng
 * @date 2016年11月23日 上午11:29:04
 * @Package iih.ci.ord.hp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class HpDetailedRuleBP {
	
	 public static HpDetailedRuleBP instance;
	 public HpDetailedRuleBP(){};
	 public static HpDetailedRuleBP getInstance(){
		 if(null == instance){
			 instance = new HpDetailedRuleBP();
		 }
		 return instance;
	 }
 
	//保存校验
	public CiHpCheckResultDTO getHpDetailedRule(CiOrAggAndRelDatum oraggandrelinfo,CiEnContextDTO context)throws BizException{
		//诊断信息
		CiorderAggDO aggors =oraggandrelinfo.getOraggdo();
		FArrayList2 diagList  = CiOrdUtils.getDiagItemList(aggors.getParentDO().getId_en());
		//医保信息
		return JudgeCiHpSave(oraggandrelinfo, diagList,context);
	}
	
	//签署校验
	public  CiHpCheckResultDTO getHpOrderSigndRule(CiorderAggDO[] aggors)throws BizException{
		//诊断信息
		 
		FArrayList2 diagList  = CiOrdUtils.getDiagItemList(aggors[0].getParentDO().getId_en());
		//医保信息
		return SignJudgeCiHpSave(aggors, diagList);
	}
	
	
	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
	 * @param aggDO
	 * @return  CiOrAggAndRelDatum oraggandrelinfo
	 */
	 public  CiHpCheckResultDTO  JudgeCiHpSave(CiOrAggAndRelDatum oraggandrelinfo,FArrayList2 diagList,CiEnContextDTO context)throws BizException{
		         CiorderAggDO aggors  =oraggandrelinfo.getOraggdo();
		         String[]  error =null;
				 CiHpCheckDTO ciHpCheckDTO  = new  CiHpCheckDTO();
				 ciHpCheckDTO.setId_pat(aggors.getParentDO().getId_pat());
				 ciHpCheckDTO.setId_ent(aggors.getParentDO().getId_en());
				 ciHpCheckDTO.setCi_di_itms(diagList);
				 //医嘱  ，医嘱项目 ，物品 等 集合信息
				 if(getOrderSrvMmDO(ciHpCheckDTO,oraggandrelinfo,context)){
					 CiHpCheckResultDTO result =  HpService.checkCiHpSave(ciHpCheckDTO);
					 if(result == null){
						 CiOrdUtils.LogerOutInfo(aggors.getParentDO().getName_or()+"  验证规则信息返回null");
					 }else{
						 CiOrdUtils.LogerOutInfo(aggors.getParentDO().getName_or()+"  验证规则信息"+result.toString());
					 }
					/* ItmChkRstDTO chkRstDTO = new ItmChkRstDTO();
					 FMap mp = new FMap();
					 mp.put("10", "单方限制");
					 mp.put("40", "放射类限制");
					 mp.put("50", "超过门诊领量限制");
					 mp.put("60", "超过门诊持有量限制");
					 chkRstDTO.setName_srv("服务名称");
					 chkRstDTO.setError_map(mp);
					 FArrayList rstlist = new  FArrayList();
					 rstlist.add(chkRstDTO);
					 result.setCheckflag(FBoolean.FALSE);
					 result.setErroritm_list(rstlist);*/
					 return result;
				/*	 if(result != null ){
						 if(result.getCheckflag() != FBoolean.TRUE){
							 FMap2 map = result .getFailidorsrvmap();
							   error = getHPMessageError(map);
						 }else{
							 return error;
						 }
					 }*/
				 }
				 return null;	 
	 }
	 
	 /**
	   * 获取需要医保校验的物品<br>
	   * 非自费的服务
	   * @param oraggandrelinfo
	   * @return
	   */
	private boolean getOrderSrvMmDO(CiHpCheckDTO ciHpCheckDTO, CiOrAggAndRelDatum oraggandrelinfo, CiEnContextDTO context) throws BizException {

		CiorderAggDO aggors = oraggandrelinfo.getOraggdo();
		
		if (!CiOrdUtils.isHpUsing(context) || aggors == null) {
			return false;
		}
		
		FArrayList2 hpqry = new FArrayList2();

		FArrayList2 srvList = new FArrayList2();
		HpQryCiorderDTO hpqryCiOrderDto = new HpQryCiorderDTO();
		OrdSrvDO[] orsrvdos = aggors.getOrdSrvDO();
		Map map =new HashMap();//有效的项目
		for (OrdSrvDO srvDO : orsrvdos) {
			
			if(srvDO.getStatus() ==DOStatus.DELETED){
				continue;
			}
			
			// 草药的一个自费，一个医保，不算单方,都自费的传给医保校验不影响
			if(srvDO.getSd_srvtp().startsWith(IBdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG)){
				map.put(srvDO.getId_srv(),srvDO);
				srvList.append(srvDO);
				continue;
			}
			
			if(srvDO.getFg_selfpay() == FBoolean.TRUE || srvDO.getFg_self() == FBoolean.TRUE){
				continue;
			}
			map.put(srvDO.getId_srv(),srvDO);
			srvList.append(srvDO);
		}
		
		if(srvList.size() == 0){
			return false;
		}
		
		getOrderSrvMms(hpqryCiOrderDto, oraggandrelinfo,map);
		hpqryCiOrderDto.setCiorderdo(aggors.getParentDO());
		//hpqryCiOrderDto.setOrdsrvmms(srvMmList);
		hpqryCiOrderDto.setOrdsrvs(srvList);
		hpqry.append(hpqryCiOrderDto);

		ciHpCheckDTO.setSavecidto(hpqry);
		
		return true;
	}
	 
	 /**
	  * 
	  * @param id_orsrv
	  * @throws BizException
	  */
	 private void getOrderSrvMms(HpQryCiorderDTO hpqryCiOrderDto,CiOrAggAndRelDatum oraggandrelinfo,Map map)throws BizException{
		 CiorderAggDO aggors  =oraggandrelinfo.getOraggdo();
		 Hashtable ht = oraggandrelinfo.getOrattachht();
				if(ht == null) return ;
				String key=OrdSrvMmDODesc.CLASS_FULLNAME;
				FMap srvmmmap =  (FMap)ht.get(key);
				 FArrayList2 srvMmList=new FArrayList2();
				 if(srvmmmap != null && srvmmmap.size() >0){
				  for (String id_srv : srvmmmap.keySet()) {
					 // OrdSrvMmDO ordersrvmm  = (OrdSrvMmDO)srvmmmap.get(id_srv);
					  List<OrdSrvMmDO>  list =   ( List<OrdSrvMmDO>)srvmmmap.get(id_srv);
					  if(list != null && list.size() >0){
						for(OrdSrvMmDO ordersrvmm:list){
							  if(id_srv.indexOf("_") >0){
								  ordersrvmm.setId_srv(id_srv.substring(0, id_srv.indexOf("_")));
							  }else{
								  ordersrvmm.setId_srv(id_srv);
							  }
						 
							  //有效医嘱项目对应的物品信息
						      if(map != null && map.containsKey(ordersrvmm.getId_srv())){
						    	  srvMmList.append(ordersrvmm);
						      }
						}  
					  }
				
					 
					}
				}
				 //设置物品信息
				 hpqryCiOrderDto.setOrdsrvmms(srvMmList);
				 
	/*	 if(id_orsrv != ""){
			 FArrayList2 srvMmList=new FArrayList2();
			 String  whereStr = OrdSrvMmDO.ID_ORSRV+" in ("+id_orsrv.substring(1)+")";
			 OrdSrvMmDO[] srvmmDO = CiOrdAppUtils.getOrSrvMmQryService().find(whereStr, OrdSrvMmDO.ID_ORSRV, FBoolean.FALSE);
		      for(OrdSrvMmDO mm: srvmmDO){
		    	  srvMmList.append(mm);
		      }
		      hpqryCiOrderDto.setOrdsrvmms(srvMmList);
		 }*/
	 }
	 
	 
	 /**
	  * 
	  *  @DmEnumDesc(name="单方限制",description="未通过单方限制校验")
	    public static final String SINGLEIDSRV="10"; //单方限制
	    @DmEnumDesc(name="重复开药限制",description="重复开药")
	    public static final String REPEAT_PRES_DRUG="20"; //重复开药限制
	    @DmEnumDesc(name="超过单次执行医嘱领量限制",description="单次执行医嘱领量限制")
	    public static final String GREATER_THAN_ONE_TIME="30"; //超过单次执行医嘱领量限制
	    @DmEnumDesc(name="放射类医嘱限制",description="放射类医嘱限制")
	    public static final String RADIATION_CLASS_ORDER="40"; //放射类医嘱限制
	    @DmEnumDesc(name="超过门诊领量限制",description="超过门诊领量限制")
	    public static final String GREATER_THAN_GET_OEP="50"; //超过门诊领量限制
	    @DmEnumDesc(name="超过门诊持有量限制",description="超过门诊持有量限制")
	    public static final String GREATER_THAN_OWN_OEP="60"; //超过门诊持有量限制
	    @DmEnumDesc(name="超过急诊领量限制",description="超过急诊领量限制")
	    public static final String GREATER_THAN_GET_ER="70"; //超过急诊领量限制

		 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
		 * @param aggDO
		 * @return
		 */
		 public  CiHpCheckResultDTO  SignJudgeCiHpSave(CiorderAggDO[] aggors,FArrayList2 diagList)throws BizException{
			         String[]  error =null;
					 CiHpCheckDTO ciHpCheckDTO  = new  CiHpCheckDTO();
					 ciHpCheckDTO.setId_pat(aggors[0].getParentDO().getId_pat());
					 ciHpCheckDTO.setId_ent(aggors[0].getParentDO().getId_en());
					 ciHpCheckDTO.setCi_di_itms(diagList);
					 //医嘱  ，医嘱项目 ，物品 等 集合信息
					 if(getOrderSignSrvMmDO(ciHpCheckDTO,aggors)){
						 CiHpCheckResultDTO result =  HpService.checkCiHpSave(ciHpCheckDTO);
						 if(result == null){
							 CiOrdUtils.LogerOutInfo(aggors[0].getParentDO().getName_or()+"  验证规则信息返回null");
						 }else{
							 CiOrdUtils.LogerOutInfo(aggors[0].getParentDO().getName_or()+"  验证规则信息"+result.toString());
						 }
						 //测试
						 
					/*	 ItmChkRstDTO chkRstDTO = new ItmChkRstDTO();
						 FMap mp = new FMap();
						 mp.put("10", "单方限制");
						 mp.put("40", "放射类限制");
						 mp.put("50", "超过门诊领量限制");
						 mp.put("60", "超过门诊持有量限制");
						 chkRstDTO.setName_srv("服务名称");
						 chkRstDTO.setError_map(mp);
						 FArrayList rstlist = new  FArrayList();
						 rstlist.add(chkRstDTO);
						 result.setCheckflag(FBoolean.FALSE);
						 result.setErroritm_list(rstlist);*/
						 return result;
					/*	 if(result != null ){
							 if(result.getCheckflag() != FBoolean.TRUE){
								 FMap2 map = result .getFailidorsrvmap();
								   error = getHPMessageError(map);
							 }else{
								 return error;
							 }
						 }*/
					 }
					 return null;	 
		 }
		 
		 
		 
		 
		 
		 /**
		   * 获取物品信息
		   * @param oraggandrelinfo
		   * @return
		   */
		 private  boolean  getOrderSignSrvMmDO(CiHpCheckDTO ciHpCheckDTO,CiorderAggDO[] aggors)throws BizException{
			  boolean  IsHp = false;
			 if(aggors != null && aggors.length >0){
				 FArrayList2 hpqry = new FArrayList2();
				 for(CiorderAggDO aggDO:aggors){
					 // 非自费, 非自备药品校验医保细则
					 if(aggDO.getOrdSrvDO().length >0  
							 && aggDO.getOrdSrvDO()[0].getId_hp() != null
							 && aggDO.getOrdSrvDO()[0].getFg_selfpay() == FBoolean.FALSE
							 && aggDO.getOrdSrvDO()[0].getFg_self() != FBoolean.TRUE
							 ){
					
						 FArrayList2 srvList=new FArrayList2();
						 HpQryCiorderDTO hpqryCiOrderDto = new HpQryCiorderDTO();
						 OrdSrvDO[] orsrvdos=aggDO.getOrdSrvDO();
						 String id_orsrv ="";
						 List<OrdSrvDO>  idSrvList = new java.util.ArrayList<>();
							 for(OrdSrvDO srvDO:orsrvdos){
								 id_orsrv +=",'"+srvDO.getId_orsrv()+"'";
								 idSrvList.add(srvDO);
							    srvList.append(srvDO);
							 } 
						getOrderSignSrvMms(hpqryCiOrderDto,id_orsrv,idSrvList);
						 hpqryCiOrderDto.setCiorderdo(aggDO.getParentDO());
						 //hpqryCiOrderDto.setOrdsrvmms(srvMmList);
						 hpqryCiOrderDto.setOrdsrvs(srvList);
						 hpqry.append(hpqryCiOrderDto);
						 IsHp = true;
					 } 
				 }
				 ciHpCheckDTO.setSavecidto(hpqry);
			 }
			 return IsHp;
		 }
		 
		 /**
		  * 
		  * @param id_orsrv
		  * @throws BizException
		  */
		 private void getOrderSignSrvMms(HpQryCiorderDTO hpqryCiOrderDto,String id_orsrv,List<OrdSrvDO>  idSrvList)throws BizException{
			 if(id_orsrv != ""){
				 FArrayList2 srvMmList=new FArrayList2();
				 String  whereStr = OrdSrvMmDO.ID_ORSRV+" in ("+id_orsrv.substring(1)+")";
				 OrdSrvMmDO[] srvmmDO = CiOrdAppUtils.getOrSrvMmQryService().find(whereStr, OrdSrvMmDO.ID_ORSRV, FBoolean.FALSE);
			      int i = 0;
				 for(OrdSrvMmDO mm: srvmmDO){
					 if(i<=idSrvList.size()){
						 mm.setId_srv(idSrvList.get(i).getId_srv());
						 idSrvList.get(i).setId_mm(mm.getId_mm());
					 }
			    	  srvMmList.append(mm);
			    	  i++;
			      }
			      hpqryCiOrderDto.setOrdsrvmms(srvMmList);
			 }
		 }
}
