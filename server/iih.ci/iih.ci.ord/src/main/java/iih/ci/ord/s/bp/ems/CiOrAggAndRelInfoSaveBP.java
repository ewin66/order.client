package iih.ci.ord.s.bp.ems;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.pp.hp.d.BdHpCtrDO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckFailResultEnum;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.bl.hp.dto.d.ItmChkRstDTO;
import iih.ci.ord.ciord.d.OrSrvAgentInfoDO;
import iih.ci.ord.ciord.d.desc.OrSrvAgentInfoDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.hp.HpDetailedRuleBP;
import iih.ci.ord.hp.HpMedicalInsurance;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrEventsSaveBP;
import iih.ci.ord.s.bp.CiOrderDOValidateBP;
import iih.ci.ord.s.bp.ValidateOrderAndDiagBP;
import iih.ci.ord.s.bp.base.pien.CiOrSrvAgentInfoSaveBP;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.hp.cp.docinfodto.d.CpOrderJudge;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

/*
 * 临床医嘱及相关实体信息保存操作BP
 */
public class CiOrAggAndRelInfoSaveBP{
	 
	/**
	 * 临床医嘱及相关实体信息保存
	 * @param oraggandrelinfo
	 * @param iseventsave
	 * @param iemstp
	 * @return
	 * @throws BizException
	 */
	public CiorderAggDO exec(CiOrAggAndRelDatum oraggandrelinfo,boolean iseventsave,int iemstp) throws BizException{
		if(oraggandrelinfo==null || oraggandrelinfo.getOraggdo()==null)return null;
		  //保存之前的验证  执行科室
		String medicalinfo ="";
		CiorderAggDO[] ciorList = {oraggandrelinfo.getOraggdo()};
		CiOrderDOValidateBP bp = new CiOrderDOValidateBP();
		bp.ValidateDeptMp(ciorList);
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		//医保细规则TODO 待修改  10,40时保存返回提示
	
	
		if (CiOrdUtils.isHpUsing(context)) {
			String eu_orsrcmdtp = oraggandrelinfo.getOraggdo().getParentDO().getEu_orsrcmdtp();
			// 服务分类,模板,历史进来的数据不验证医保规则
			if (!OrSourceFromEnum.IIHSRVCAHELPER.equals(eu_orsrcmdtp)
					&& !OrSourceFromEnum.IIHORTMPLHELPER.equals(eu_orsrcmdtp)
					&& !OrSourceFromEnum.IIHMTROUTINEHELPER.equals(eu_orsrcmdtp)
					&& !OrSourceFromEnum.IIHPATIPASTHELPER.equals(eu_orsrcmdtp)
					&& !OrSourceFromEnum.IIHCLINICALKITHELPER.equals(eu_orsrcmdtp)
					) {
				// 医保的规则条件
				HpDetailedRuleBP hpDetailedRule = new HpDetailedRuleBP();
				CiHpCheckResultDTO result = hpDetailedRule.getHpDetailedRule(oraggandrelinfo, context);
				// HPMessage = new String[2];
				// HPMessage[0]="ceshi";
				// HPMessage[1]="10";
				  String keys ="";
				  String id_srv = "";
				if (result != null && !result.getCheckflag().booleanValue()) {
					FArrayList  rstDTOList = result.getErroritm_list();
					if(rstDTOList != null){
					  for(int i =0;i<rstDTOList.size();i++){
						  //TODO,新的保存完成 注释掉
						  ItmChkRstDTO  rstDTO =  (ItmChkRstDTO)rstDTOList.get(i);
						  FMap map = rstDTO.getError_map();
						  List<String> mapKeyList = new ArrayList<String>(map.keySet()); 
						  id_srv = rstDTO.getId_srv();
						  for(String key: mapKeyList){
							  keys +=key+",";
							  medicalinfo +=map.get(key)+"\n";  
						  }
					  } 						
					}
					if(medicalinfo != "" && oraggandrelinfo.getOraggdo() != null){
						if(WarningAndStop(keys)==FBoolean.TRUE){
							medicalinfo ="Stop^"+ medicalinfo;
						}else{
							medicalinfo ="warning^"+ medicalinfo;
							setFg_hpindicjudged(oraggandrelinfo.getOraggdo());
						}
						oraggandrelinfo.getOraggdo().getParentDO().setMdicalinfo(medicalinfo);
						String mm_name = getOrderMMName(id_srv,oraggandrelinfo);
						if(mm_name!= null){
							String name_or = oraggandrelinfo.getOraggdo().getParentDO().getName_or();
							oraggandrelinfo.getOraggdo().getParentDO().setName_or(name_or+"("+mm_name+")");
						};
					}
					//住院 TODO
					if(context != null  && !IEnDictCodeConst.SD_ENTP_INPATIENT.equals(context.getCode_entp())){
						CiOrdUtils.setorderAggMap(context,oraggandrelinfo);
						CiOrdUtils.setTypeMap(iemstp);
						//if(medicalinfo.indexOf("Stop^")>0){
							return oraggandrelinfo.getOraggdo();
						//}
						
					}
				}
			}
		}
		
		//判断是否临床路径患者
		String id_ent = oraggandrelinfo.getOraggdo().getParentDO().getId_en();
		if(CiOrdAppUtils.getIHpcpAppItfService().getEntIncpFlagExcludeWaitcp(id_ent)){
			try{
				CiOrdAppUtils.getIHpcpAppItfService().checkCiorderSrv(id_ent, ciorList);
				transMMUncporToCiOrdEuUncpor(ciorList);
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		int i = 0;
		//高端商保判断是每条医嘱的金额 不能超过限制的 金额
		
		Ent4BannerDTO banner = context.getEnt4BannerDTO();
		if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
				banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
				&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
			//高端商保标志·
			
			 String id_hp = "id_hp ='"+banner.getId_hp()+"'";
			 BdHpCtrDO[] hpctr = CiOrdAppUtils.getIBdHpCtrDORService().find(id_hp, "", FBoolean.FALSE);
			if(hpctr != null &&  hpctr.length >0){
				BdHpCtrDO hpctrdo = hpctr[0];
				if(hpctrdo.getOr_limit_amt() !=null && !hpctrdo.getOr_limit_amt().isTrimZero()){
					FDouble sumprice =  getSumPrice(oraggandrelinfo);
					if(Double.compare(sumprice.getDouble(), hpctrdo.getOr_limit_amt().getDouble()) >0){
						 throw new BizException("医嘱的金额超出限制 "+hpctrdo.getOr_limit_amt().getDouble());
					}
				}
			}
			
		}else if( banner != null && banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("1")){
			//医保信息   改成 在签署时调用 2016-11-23
			//JudgeCiHpSave(oraggandrelinfo, diagList);
			//适应症 信息    是否启用医保标志
			if(CiOrdUtils.isHpUsing(context)){
				FArrayList2 diagList  = CiOrdUtils.getDiagItemList(oraggandrelinfo.getOraggdo().getParentDO().getId_en());
			   //setMedicalInsurance(oraggandrelinfo,diagList);
			   HpMedicalInsurance.setMedicalInsurance(oraggandrelinfo, diagList);
			}else{
				if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
						banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
						){
			     if(oraggandrelinfo.getOraggdo().getParentDO().getSd_srvtp() != null && oraggandrelinfo.getOraggdo().getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				   oraggandrelinfo.getOraggdo().getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
	             }else{
	            	 oraggandrelinfo.getOraggdo().getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.SELFPAY);
	             }
			     setOrsrvDOSelfPay( oraggandrelinfo.getOraggdo());
			   }
			}
			
		}
		
		/*if(medicalinfo != "" && banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
				banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET) ){
			setFg_selfPay(oraggandrelinfo.getOraggdo());
		}*/
		
		// 设置医嘱是否保内标识
		this.setOrdFg_orhp(oraggandrelinfo.getOraggdo());
		//验证医保和诊断关系
		if(banner != null && banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("1")){
			String orderdiagmeg =ValidateOrderAndDig(oraggandrelinfo.getOraggdo());
			if(orderdiagmeg != null){
				throw new BizException(orderdiagmeg);
			}
	    }
		//医嘱保存
		CiorderAggDO aggdo=orAggDOSave(oraggandrelinfo.getOraggdo());
		//附属信息保存
		orAggAttachInfoSave(aggdo,oraggandrelinfo.getOrattachht(),iemstp);
		
		//医嘱事件数据保存
		ciEventInfoSave(aggdo,iseventsave);
		if(medicalinfo != null && aggdo != null){
			aggdo.getParentDO().setMdicalinfo(medicalinfo);
		}
		//结果返回
		return aggdo;
	}
	
	/**
	 * 医保医嘱和诊断的强制关系
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	private String ValidateOrderAndDig(CiorderAggDO aggdo)throws BizException{
		ValidateOrderAndDiagBP bp = new ValidateOrderAndDiagBP();
		Map<String,String> idHPmap = new HashMap();
		FMap idsrvMap = getHPsrvItem(aggdo,idHPmap);
		if(idsrvMap.isEmpty())return null;
		String id_ent = aggdo.getParentDO().getId_en();
		String id_hp = idHPmap.get("id_hp");
	    String[] id_srvs= CiOrdUtils.getMapConveretArr(idsrvMap);
		FMap  map = bp.getValidateOrderAndDiag(id_ent, id_hp, id_srvs);
		if(map != null){
		  return	aggdo.getParentDO().getName_or()+" 为医保医嘱 缺少诊断："
				  +CiOrdUtils.getFMapValuesConveretstrNoQuotes(map);
		}
		return  null;
	}
	
	
	/**
	 * 
	 * @param aggdo
	 * @return
	 */
	private FMap getHPsrvItem(CiorderAggDO aggdo,Map IDHpMap){
		FMap map = new FMap();
		if(aggdo == null) return null;
		for(OrdSrvDO srvdo :aggdo.getOrdSrvDO()){
			if(srvdo.getFg_selfpay()==FBoolean.FALSE){
				map.put(srvdo.getId_srv(), srvdo.getId_srv());
				IDHpMap.put("id_hp", srvdo.getId_hp());
			}
		}
		return map;
	}
	
	/**
	 * 
	 * @param ciorderAgg
	 */
	private void setOrsrvDOSelfPay(CiorderAggDO ciorderAgg){
		OrdSrvDO[] ordSrvs = ciorderAgg.getOrdSrvDO();
		if(ordSrvs != null && ordSrvs.length >0){
			for(OrdSrvDO orsrvdo: ordSrvs){
				orsrvdo.setFg_selfpay(FBoolean.TRUE);
			}
		}
	}
	/**
	 * 设置医嘱中是否为医保标识
	 * 医嘱项目分：临床费用项目和执行操作费用项目。该标识为true时标识该医嘱中临床费用项目中至少有一条fg_selfpay=false的。
	 * 特别说明fg_selfpay=true是保外（自费）、fg_selfpay=false是保内
	 * 
	 * @param ciorderAgg
	 */
	private void setOrdFg_orhp(CiorderAggDO ciorderAgg) {

		CiOrderDO ciOrder = ciorderAgg.getParentDO();
		OrdSrvDO[] ordSrvs = ciorderAgg.getOrdSrvDO();

		ciOrder.setFg_orhp(FBoolean.FALSE); // 自费
		for (OrdSrvDO ordSrv : ordSrvs) {
			if(ciOrder.getEu_hpindicjudge()==HpIndicJudgeEnum.SELFPAY){
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_hpindicjudged(HpIndicJudgeEnum.SELFPAY);
				if(ordSrv.getStatus() == DOStatus.UNCHANGED) ordSrv.setStatus(DOStatus.UPDATED);
			}
			if (ordSrv.getFg_selfpay() == FBoolean.FALSE) {
				ciOrder.setFg_orhp(FBoolean.TRUE); // 医保
				break;
			}
			
		}
	}
	
	/**
	 * 草药单方自费以判断
	 * @param aggdo
	 */
	private void setFg_hpindicjudged(CiorderAggDO aggdo) {
		if (aggdo.getParentDO().getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)
				&& aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length > 0) {
			for (OrdSrvDO srvdo : aggdo.getOrdSrvDO()) {
				if (srvdo.getSd_srvtp() != null
						&& srvdo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					srvdo.setFg_selfpay(FBoolean.TRUE);
					srvdo.setFg_indic(FBoolean.FALSE);
					srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
				}

			}
		}
	}
	
	/**
	 * 保存时 提示信息还是终止保存；
	 * @param keys
	 * @return
	 */
   private  FBoolean  WarningAndStop(String keys){
	   if(keys != ""){
			   if(keys.contains(CiHpCheckFailResultEnum.REPEAT_PRES_DRUG)){
				   return FBoolean.TRUE;
			   }
			 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_ONE_TIME)){
				 return FBoolean.TRUE;
					   }
			 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_OEP)){
				 return FBoolean.TRUE;
			 }
			 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_OWN_OEP)){
				 return FBoolean.TRUE;
			 }
			 if(keys.contains(CiHpCheckFailResultEnum.GREATER_THAN_GET_ER)){
				 return FBoolean.TRUE;
			 }
			 return FBoolean.FALSE;
	   }
	   
	   return  FBoolean.FALSE;
   }
	
   
   /**
	   * 物品名称
	   * @param oraggandrelinfo
	   * @return
	   */
	 private  String  getOrderMMName(String id_srv,CiOrAggAndRelDatum oraggandrelinfo){
     String MM_name= null;
		 OrdSrvDO[] orsrvdos=oraggandrelinfo.getOraggdo().getOrdSrvDO();
		 if(orsrvdos != null && orsrvdos.length >0){
			 FMap srvmmmap=getOrdSrvMmDOMapName(oraggandrelinfo.getOrattachht());
			 OrdSrvMmDO mm=null;
					//医嘱项目对应的服务物品处理 
					if(srvmmmap!=null){
						  for(Object key:srvmmmap.keySet()){
					        	//if(key.toString().startsWith(id_srv)){
					        	  List  list = (ArrayList)srvmmmap.get(key.toString());
					        		if(list != null){
					        		for(int i =0;i<list.size();i++){
					        			OrdSrvMmDO srvmmdo = (OrdSrvMmDO)list.get(0);
					        			if(srvmmdo != null){
					        			 return srvmmdo.getName_mm();	
					        		 }
					        	  }
					        	}
					        	 
					        	//}
					        }
					
					}
		 }
	   return MM_name;
	 }
	 
		/**
		 * 获得医嘱项目对应的物品DO  Map数据<id_srv,do>
		 * @param ht
		 * @return
		 */
		private static FMap getOrdSrvMmDOMapName(Hashtable ht){
				if(ht == null) return null;
				String key=OrdSrvMmDODesc.CLASS_FULLNAME;
				return (FMap)ht.get(key);
			}
	
	/**
	 * 每条医嘱的总金额
	 * @param aggdo
	 * @return
	 */
	private FDouble  getSumPrice(CiOrAggAndRelDatum orAggAndRelDatum){
	   
	     FDouble fSumPrice = FDouble.ZERO_DBL;
	     
	     CiorderAggDO aggdo = orAggAndRelDatum.getOraggdo();
	     String key=OrdSrvMmDODesc.CLASS_FULLNAME;
	     FMap mmMap = null;
	     if(!CiOrdUtils.isEmpty(orAggAndRelDatum.getOrattachht()))
			mmMap =(FMap)orAggAndRelDatum.getOrattachht().get(key);
			
		 if(aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length >0){
			 OrdSrvDO[] ordsrvDO = aggdo.getOrdSrvDO();
			 List  tempList= null;
			 int i =0;
			 for(OrdSrvDO srvdo: ordsrvDO){ 
				if(srvdo.getFg_bl() == FBoolean.TRUE && 
						(srvdo.getEu_sourcemd()==OrSrvSourceFromEnum.PHYSIAN||srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMPRIMD||srvdo.getEu_sourcemd() == OrSrvSourceFromEnum.AGENTFROMCOMPPRIMD) && 
						srvdo.getPri() != null ){
					
					if (srvdo.getFg_mm() == FBoolean.TRUE && null != mmMap)
					{
						if(tempList == null){
							tempList = getMap(mmMap);
						}
						if(tempList != null && i<tempList.size()){
							List<OrdSrvMmDO> list = (List<OrdSrvMmDO>)mmMap.get(tempList.get(i));
							if(list != null && list.size() >0){
							 for(OrdSrvMmDO mm:list){
							     fSumPrice = fSumPrice.add(mm.getPrice_pgku_cur().multiply(mm.getQuan_cur()));
							 }	
							}
							
						}
					}
					else{
						if ( srvdo.getQuan_total_medu() != null)
						fSumPrice = fSumPrice.add(srvdo.getPri().multiply(srvdo.getQuan_total_medu()));
					}
					 
				}
				i++; 
			} 
		 }
	     return fSumPrice;// new FDouble().sum(sumprice);
	}
	

     /**
      * 诊断信息
      * @param id_ent
      * @return
      */
	 private FArrayList2 getDiagList(String id_ent)throws BizException{
		 FArrayList2 list = new FArrayList2();
		 String[] diag = CiOrdUtils.getDiag(id_ent);
		 for(String item:diag){
			 list.append(item);
		 }
		 return list;
	 }
	
	/**
	 * 医嘱保存
	 * @param aggdo
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO orAggDOSave(CiorderAggDO aggdo) throws BizException{
		CiOrdUtils.LogerOutInfo("医嘱基本保存的 方法  orAggDOSave " + "  "+"医嘱类型 "+aggdo.getParentDO().getSd_srvtp() +"医嘱名称："+aggdo.getParentDO().getNote_or());
		long startTime = System.currentTimeMillis();
		setFG_feertnable(aggdo);
		
		ICiorderCudService orservice=CiOrdAppUtils.getOrAggService();
		CiorderAggDO[] aggdos=orservice.save(new CiorderAggDO[] {aggdo});
		CiOrdUtils.LogerOutInfo("医嘱基本保存的 方法  orAggDOSave  耗时"+( System.currentTimeMillis()-startTime));
		if(aggdos==null || aggdos.length==0)return null;
		return aggdos[0];
	}
	//设置退费标志
	private void setFG_feertnable(CiorderAggDO aggdo){
		if(aggdo != null && aggdo.getOrdSrvDO() != null && aggdo.getOrdSrvDO().length >0){
		  for(OrdSrvDO srvdo:aggdo.getOrdSrvDO()){
			  srvdo.setFg_feertnable(FBoolean.TRUE);
		  }	
		}
	}
	/**
	 * 医嘱临床事件数据保存
	 * @param aggdos
	 * @return
	 * @throws BizException
	 */
	private void ciEventInfoSave(CiorderAggDO aggdo,boolean iseventsave) throws BizException{
		//有效性校验
		if(!iseventsave)return;
		if(aggdo==null)return;
		
		CiOrEventsSaveBP bp=new CiOrEventsSaveBP();
		bp.exec(new CiOrderDO[]{aggdo.getParentDO()});
	}
	
	/**
	 * 医嘱关联实体保存
	 * @param aggdo
	 * @param ht
	 * @throws NegativeArraySizeException 
	 * @throws BizException 
	 */
	private void orAggAttachInfoSave(CiorderAggDO aggdo,Hashtable ht,int iemstp) throws BizException, NegativeArraySizeException{
		if(aggdo==null || ht==null || ht.size()==0)return;
		CiOrderDO ordo=aggdo.getParentDO();
		OrdSrvDO[] orsrvdos=aggdo.getOrdSrvDO();
		
		//临时 map
		 Map map = new HashMap();
		//医嘱项目对应物品记录的保存  医嘱项目对应变动用药记  医嘱及医嘱项目对应的套内项目
		FMap srvmmmap=getOrdSrvMmDOMap(ht);
		FMap srvdosesmap=getOrdSrvDoseDOsMap(ht);
		FMap srvagentmap=getOrSrvAgentInfoDOMap(ht);
		FMap srvsetsmap=getOrdSrvSetDOMap(ht);
		FMap orappmap=getOrAppSheetInfoMap(ht,iemstp);
		if((srvmmmap==null || srvmmmap.size()==0) && 
		   (srvdosesmap==null || srvdosesmap.size()==0) &&
		   (srvsetsmap==null || srvsetsmap.size()==0) &&
		   (orappmap==null || orappmap.size()==0)
		   )return;
		
		//参数设置
		String id_srv="",id_or=ordo.getId_or(),id_orsrv="";
		ArrayList<OrdSrvMmDO> srvmmdo=new ArrayList<OrdSrvMmDO>();
		ArrayList<OrSrvAgentInfoDO> agentdo=new ArrayList<OrSrvAgentInfoDO>();
		ArrayList<OrdSrvDoseDO> srvdosedo=new ArrayList<OrdSrvDoseDO>();
		ArrayList<OrdSrvSetDO> srvsetdo=new ArrayList<OrdSrvSetDO>();
		AgentInfoMap2List4DelStatus(agentdo,srvagentmap);
		OrdSrvMmDO mm=null;
		OrdSrvDoseDO[] doses=null;
		OrdSrvSetDO[] sets=null;
		OrSrvAgentInfoDO srvagent=null;
		//补全mm对象的数据
		completionSrvMm(srvmmdo,orsrvdos,srvmmmap);
		if(orsrvdos!=null){
			//遍历
		     List tempList =  null;;
			for(int i=0;i<orsrvdos.length;i++){
				id_srv=orsrvdos[i].getId_srv();
				if(CiOrdUtils.isEmpty(id_or)){id_or=orsrvdos[i].getId_or();}
				id_orsrv=orsrvdos[i].getId_orsrv();
				
				//代办人的处理修改为，在签署的时候录入
//				//医嘱项目对应的代办人处理
//				if(srvagentmap!=null && srvagentmap.containsKey(id_srv)){
//					srvagent=(OrSrvAgentInfoDO)srvagentmap.get(id_srv);
//					srvagent.setId_or(id_or);
//					srvagent.setId_orsrv(id_orsrv);
//					agentdo.add(srvagent);
//				}
				
				//医嘱项目对应的变动剂量处理
				if(srvdosesmap!=null && srvdosesmap.containsKey(id_srv)){
					doses=(OrdSrvDoseDO[])srvdosesmap.get(id_srv);
					for(int j=0;j<doses.length;j++){
						doses[j].setId_or(id_or);
						doses[j].setId_orsrv(id_orsrv);
						srvdosedo.add(doses[j]);
					}
				}
				
				//医嘱项目对应的套内项目处理
		         //为什么放在 循环里面？
//				if(srvsetsmap!=null && srvsetsmap.containsKey(ordo.getId_srv())){
//					sets=(OrdSrvSetDO[])srvsetsmap.get(ordo.getId_srv());
//					for(int j=0;j<sets.length;j++){
//							sets[j].setId_or(id_or);
//							sets[j].setId_orsrv(id_orsrv);
//							srvsetdo.add(sets[j]);
//					}
//				}
			}
		}
		 // todo  暂时 放到 循环外面  如有不对在修改  李政
		if(srvsetsmap!=null && srvsetsmap.containsKey(ordo.getId_srv())){
			sets=(OrdSrvSetDO[])srvsetsmap.get(ordo.getId_srv());
			//获得医嘱服务项目中的第一条数据的id_orsrv，为set表赋值;zwq
			if(!CiOrdUtils.isEmpty(orsrvdos)&&orsrvdos.length>0){
				id_orsrv=orsrvdos[0].getId_orsrv();
			}
			for(int j=0;j<sets.length;j++){
					sets[j].setId_or(id_or);
					sets[j].setId_orsrv(id_orsrv);
					srvsetdo.add(sets[j]);

				
			}
		}
		if(srvsetsmap!=null && srvsetsmap.containsKey(id_or)){
			sets=(OrdSrvSetDO[])srvsetsmap.get(id_or);
			for(int j=0;j<sets.length;j++){
				//if(!map.containsKey(sets[j].getId_orsrv())){
				sets[j].setId_or(id_or);
				//sets[j].setId_orsrv(id_orsrv);
				srvsetdo.add(sets[j]);
				//map.put(sets[j].getId_orsrv(), sets[j].getId_orsrv());
				//}
			}
		}
	
		if(srvmmdo!=null && srvmmdo.size()!=0){
			CiOrdAppUtils.getOrsrvmmService().save((OrdSrvMmDO[]) srvmmdo.toArray((OrdSrvMmDO[]) Array.newInstance(OrdSrvMmDO.class, srvmmdo.size())));
		}
		
		if(!CiOrdUtils.isEmpty(agentdo)){
			orSrvAgentInfoSave(agentdo);
		}
		
		if(srvdosedo!=null && srvdosedo.size()!=0){
			CiOrdAppUtils.getOrsrvdoseService().save((OrdSrvDoseDO[]) srvdosedo.toArray((OrdSrvDoseDO[]) Array.newInstance(OrdSrvDoseDO.class, 0)));
		}
		
		if(srvsetdo!=null && srvsetdo.size()!=0){
			CiOrdAppUtils.getOrsrvsetService().save((OrdSrvSetDO[]) srvsetdo.toArray((OrdSrvSetDO[]) Array.newInstance(OrdSrvSetDO.class, 0)));
		}
		
		//医嘱对应的申请单保存
		ciOrAppSaveHandle(orappmap,id_or,iemstp);
	}
	/**
	 * 
	 * @param srvmmdo 存放用于保存的物品对象
	 * @param orsrvdos 物品的收费项目
	 * @param srvmmmap HashMap中存储物品对象的map
	 */
	private void completionSrvMm(ArrayList<OrdSrvMmDO> srvmmdo,OrdSrvDO[] orsrvdos,FMap srvmmmap){
		//服务对应的物品处理
			//1、将物品服务放入Map中,key=id_srv+id_mm
			Map<String,OrdSrvDO> srvMap = new HashMap<String,OrdSrvDO>();
			for(OrdSrvDO srvdo : orsrvdos){
				if(!CiOrdUtils.isEmpty(srvdo.getFg_mm())&&srvdo.getFg_mm().booleanValue()){
					srvMap.put(srvdo.getId_srv()+srvdo.getId_mm(), srvdo);
				}
			}
			if(!srvMap.isEmpty()){
				Iterator iter = srvmmmap.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry entry  = (Map.Entry)iter.next();
					List<OrdSrvMmDO> mmDOList = (List<OrdSrvMmDO>)entry.getValue();
					if(!CiOrdUtils.isEmpty(mmDOList)){
						for(OrdSrvMmDO mmDO : mmDOList){
							srvmmdo.add(mmDO);
							String mmKey = mmDO.getId_srv()+mmDO.getId_mm();
							if(srvMap.containsKey(mmKey)){
								mmDO.setId_orsrv(srvMap.get(mmKey).getId_orsrv());
							}
						}
					}
				}
			}
	 }
	/**
	 * 医嘱对应的申请单保存处理
	 * @param orappmap
	 * @param id_or
	 * @param iemstp
	 * @throws BizException 
	 */
	private void ciOrAppSaveHandle(FMap orappmap,String id_or,int iemstp) throws BizException{
		//有效性判断
		if(orappmap==null || orappmap.size()==0 || iemstp==-1 || CiOrdUtils.isEmpty(id_or))return;
		
		CiOrRelAppSheetSaveBP bp=new CiOrRelAppSheetSaveBP();
		bp.exec(orappmap.get(CiOrdUtils.ORAPP_SHEET_KEY), id_or, iemstp);
	}
	
	/**
	 * 获得医嘱项目对应的物品DO  Map数据<id_srv,do>
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvMmDOMap(Hashtable ht){
		if(ht == null) return null;
		String key=OrdSrvMmDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱项目对应变动剂量DO  Map数据<id_srv,do[]>
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvDoseDOsMap(Hashtable ht){
		String key=OrdSrvDoseDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱项目对应代办人DO  Map数据<id_srv,do>
	 * @param ht
	 * @return
	 */
	private FMap getOrSrvAgentInfoDOMap(Hashtable ht){
		String key=OrSrvAgentInfoDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱或医嘱项目对应的套DO  Map数据<id_srv_set,dos>
	 * @param ht
	 * @return
	 */
	private FMap getOrdSrvSetDOMap(Hashtable ht){
		String key=OrdSrvSetDODesc.CLASS_FULLNAME;
		return (FMap)ht.get(key);
	}
	
	/**
	 * 获得医嘱申请单对应DO或aggdo  Map数据<CiOrdUtils.ORAPP_SHEET_KEY,dos>
	 * @param ht
	 * @return
	 */
	private FMap getOrAppSheetInfoMap(Hashtable ht,int iemstp){
		String key=CiOrdUtils.getOrAppClizname(iemstp);
		return (FMap)ht.get(key);
	}
	
	/**
	 * 毒麻药品服务代办人信息保存
	 * @param agentdo
	 * @throws BizException
	 */
	private void orSrvAgentInfoSave(ArrayList<OrSrvAgentInfoDO> agentdo) throws BizException{
		CiOrSrvAgentInfoSaveBP bp=new CiOrSrvAgentInfoSaveBP();
		bp.exec(agentdo);
	}

	/**
	 * 代理人信息（删除的）转换到列表中
	 * @param agentdos
	 * @param srvagentmap
	 */
	private void AgentInfoMap2List4DelStatus(ArrayList<OrSrvAgentInfoDO> agentdos,FMap srvagentmap){
		//空校验
		if(CiOrdUtils.isEmpty(srvagentmap))return;
		
		//参数
		String key="";
		OrSrvAgentInfoDO agentdo=null;
		Iterator it=srvagentmap.keySet().iterator();

		//遍历
		while(it.hasNext()){
			agentdo=(OrSrvAgentInfoDO)srvagentmap.get(it.next());
		    if(CiOrdUtils.isDODel(agentdo)){
		    	
		    	agentdos.add(agentdo);
		    	
		    }
		}
	}
	/***
	 * 将物品域返回的临床路径字段转换为医嘱域中用于显示临床路径图标的字段
	 * 物品域返回的值：0： 非径内医嘱,1:径内医嘱,-1:路径无关联
	 * 医嘱域：0：不需要判断，1：待判断，2:已判断
	 * @param aggdos
	 */
	 private void transMMUncporToCiOrdEuUncpor(CiorderAggDO[] aggdos){
		 if(CiOrdUtils.isEmpty(aggdos)) return;
		 for(CiorderAggDO aggdo : aggdos){
			 CiOrderDO ciOrdDO = aggdo.getParentDO();
			 if(ciOrdDO==null) continue;
			 Integer cpor = ciOrdDO.getEu_uncporjudge();
			 if(cpor==null||cpor==CpOrderJudge.OWNCP||cpor==CpOrderJudge.NONRELCP){
				 ciOrdDO.setEu_uncporjudge(HpIndicJudgeEnum.NONEEDJUDGE);
			 }else if(cpor==CpOrderJudge.NONOWNCP){
				 ciOrdDO.setEu_uncporjudge(HpIndicJudgeEnum.WAITINGJUDGE);
			 }
		 }
	 }

	 /**
	  * 
	  * @param srvmmmap
	  * @return
	  */
	 private  List<String> getMap(FMap srvmmmap){
		 List  list = new ArrayList();
		if(srvmmmap != null ){
			Iterator entrys = srvmmmap.entrySet().iterator();
			while (entrys.hasNext()) {
				Map.Entry entry = (Map.Entry) entrys.next();
				list.add(entry.getKey().toString());
			  }
		}
		 return list;
	 }
	 
}



