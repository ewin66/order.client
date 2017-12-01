package iih.ci.ord.hp;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.ems.CiOrAggAndRelDatum;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

public class HpMedicalInsurance {
    
	/**
	 * 医保信息的判断
	 * @param oraggandrelinfo
	 * @param diagList
	 * @return
	 * @throws BizException
	 */
	public static CiOrAggAndRelDatum setMedicalInsurance(CiOrAggAndRelDatum oraggandrelinfo,FArrayList2 diagList)throws BizException{
		if(oraggandrelinfo == null ||diagList==null) return null;
		CiorderAggDO aggDO = oraggandrelinfo.getOraggdo();
		if(aggDO.getOrdSrvDO()  != null && aggDO.getOrdSrvDO().length >0){
			// 入参：患者主医保计划，服务ID集合、性别、新生儿标志、出生日期、诊断信息、开单科室、就诊类型
            // 患者的性别 和出生日期  代优化 ，需要上下文传入过来
			 IPatiMDORService pipatService = (IPatiMDORService)ServiceFinder.find(IPatiMDORService.class);
			 PatDO pipatdo = pipatService.findById(aggDO.getParentDO().getId_pat());
		     // 医保信息
			 BdHpIndicationDTO[] hpIndicationsInfo =  gethpIndications(oraggandrelinfo,pipatdo,diagList);
			 //判断医保
			 if(hpIndicationsInfo== null){
				 aggDO.getParentDO().setEu_hpindicjudge(getOrHpJudgeEnumValue(aggDO));
			 }else{
				 JudgeHPIndication(oraggandrelinfo,hpIndicationsInfo);
			 }

			 
			 
		}
		
		return oraggandrelinfo;
	}
	

	 /**
	  a)若服务无对应的医保限制条件时，则判断方式为【01不限制】。
	  b)若服务有对应的医保限制条件时，
		若针对该医保限制条件，系统可以识别，并能最终确定是否适应（例如限三级医院使用），
	           则判断方式为【11系统确定判断】，系统判断结果为【系统识别的是否适应结果】
		若针对该医保限制条件，系统可以识别，但需要医生做最终确认的（例如限），
	           则判断方式为【12系统辅助判断】，系统判断结果为【系统识别的是否适应结果】
		若针对该医保限制条件，系统不可以识别，需要医生自己判断的，
	          则判断方式为【21医生判断】，系统判断结果为空，默认赋值为N
	  * @param aggDO
	  * @param hpIndicationsInfo
	  */
	 private static void JudgeHPIndication(CiOrAggAndRelDatum oraggandrelinfo,BdHpIndicationDTO[] hpIndicationsInfo)throws BizException{
		 if(oraggandrelinfo != null && hpIndicationsInfo != null){
			 boolean Eu_hpindicjudge = false;
			 boolean temp_Eu_hpindicjudge = false;
			 CiorderAggDO aggDO = oraggandrelinfo.getOraggdo();
			 int num = 0;
			 int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(aggDO.getParentDO().getId_org());
			 for(BdHpIndicationDTO indication: hpIndicationsInfo){
				 OrdSrvDO srvdo = (OrdSrvDO)indication.getCi_orsrvdo();
				 srvdo.setFg_feertnable(FBoolean.TRUE);
				 srvdo.setSd_hpsrvtp(indication.getSd_hpsrvtp());
				 srvdo.setId_hpsrvtp(CiOrdUtils.idHpSrvtpFromSdHpSrvtp(indication.getSd_hpsrvtp()));
				 
				 if(model==2){
						indication.setDes_hplimit(" 医保限制条件："+IsNull(indication.getDes_hplimit())+"\n 院内限制条件："+ IsNull(indication.getDes_hislimit()));
					}else if(model==1){
						indication.setDes_hplimit(" 院内限制条件："+ IsNull(indication.getDes_hislimit()));
					} 
			 
				 if(JudgeHp(indication,srvdo,Eu_hpindicjudge)){
					 temp_Eu_hpindicjudge = true;
				 }
				 for(OrdSrvDO tempordsrv:aggDO.getOrdSrvDO()){
					 if(tempordsrv.getId_srv() == srvdo.getId_srv()){
						 if(srvdo.getFg_selfpay() ==null){
							 aggDO.getParentDO().setFg_orhp(null);
						 }
						 tempordsrv = srvdo;
					 }
				 }

				 num++;
			 }
//			 if(temp_Eu_hpindicjudge){
//				 aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.WAITINGJUDGE); 
//			 }else{
				 //aggDO.getParentDO().setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
			     Integer en_num = getOrHpJudgeEnumValue(aggDO);
				 aggDO.getParentDO().setEu_hpindicjudge(en_num);
				 if(en_num == HpIndicJudgeEnum.SELFPAY ){
					 aggDO.getParentDO().setFg_orhp(FBoolean.FALSE);//自费
				 }
//			 }
			// aggDO.setOrdSrvDO(ordSrvDOS);
		 }
	 }
	
		private static String IsNull(String limitInfo ){
			if(limitInfo == null) return "";
			return limitInfo;
		}
		/**
		 *  按医保返回值判断医保数据
		 * @param indication
		 * @param srvdo
		 * @param Eu_hpindicjudge
		 * @return
		 * @throws BizException
		 */
		private static boolean JudgeHp(BdHpIndicationDTO indication,OrdSrvDO srvdo, boolean Eu_hpindicjudge)throws BizException{
			if(indication != null){
				if(indication.getFg_indic() != null){
					if(indication.getFg_indic().booleanValue()){
						if("12".equals(indication.getCode_hpindicjudged())){
							 srvdo.setFg_indic(indication.getFg_indic());
							 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
							 srvdo.setDes_hplimit(indication.getDes_hplimit());
							 srvdo.setFg_selfpay(FBoolean.FALSE);
							 Eu_hpindicjudge = true;
						 }else{
							 srvdo.setFg_indic(indication.getFg_indic());
							 srvdo.setDes_hplimit(indication.getDes_hplimit());
							 srvdo.setFg_selfpay(FBoolean.FALSE);
							 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
						 }
					}else{
						   //确认为非适应症时是否提醒医生
						  //@return 默认 是 false 不提醒， true 提醒
						 if(CiOrdUtils.getIsRemind4FgIndicFalseConfirmed().booleanValue()){
							 Eu_hpindicjudge = true;
							 srvdo.setFg_indic(indication.getFg_indic());
							 srvdo.setDes_hplimit(indication.getDes_hplimit());
							 srvdo.setFg_selfpay(FBoolean.TRUE);
							 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
						 }else{
								if("12".equals(indication.getCode_hpindicjudged())){
									 srvdo.setFg_indic(indication.getFg_indic());
									 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
									 srvdo.setDes_hplimit(indication.getDes_hplimit());
									 srvdo.setFg_selfpay(FBoolean.TRUE);
									 Eu_hpindicjudge = true;
								 }else if("21".equals(indication.getCode_hpindicjudged())){
									 //srvdo.setFg_indic(FBoolean.TRUE);
									 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
									 srvdo.setDes_hplimit(indication.getDes_hplimit());
									 srvdo.setFg_selfpay(FBoolean.TRUE);
									 Eu_hpindicjudge = true;
								 }else{ // 一般不会，到这里就有异常数据
									 if(indication.getSd_hpsrvtp() != null && indication.getSd_hpsrvtp()=="3"){
										 srvdo.setFg_indic(indication.getFg_indic());
										 srvdo.setDes_hplimit(indication.getDes_hplimit()+indication.getDes_hislimit());					
										 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
										 srvdo.setFg_selfpay(FBoolean.TRUE); 
									 }else{
										 srvdo.setFg_indic(indication.getFg_indic());
										 srvdo.setDes_hplimit(indication.getDes_hplimit());					
										 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
										 srvdo.setFg_selfpay(FBoolean.TRUE);
									 }
									 
								 }
						 }
					}
				}else{
					if("12".equals(indication.getCode_hpindicjudged())){
						 srvdo.setFg_indic(indication.getFg_indic());
						 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
						 srvdo.setDes_hplimit(indication.getDes_hplimit());
						 srvdo.setFg_selfpay(FBoolean.TRUE);
						 Eu_hpindicjudge = true;
					 }else if("21".equals(indication.getCode_hpindicjudged())){
						 //srvdo.setFg_indic(FBoolean.TRUE);
						 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.WAITINGJUDGE);
						 srvdo.setDes_hplimit(indication.getDes_hplimit());
						 if(srvdo.getFg_selfpay() !=null){
							 srvdo.setFg_indic(new FBoolean(!srvdo.getFg_selfpay().booleanValue()));
							 srvdo.setFg_selfpay(srvdo.getFg_selfpay());
						 }else{
							 srvdo.setFg_indic(FBoolean.FALSE);
							 srvdo.setFg_selfpay(FBoolean.TRUE);
						 }
						 srvdo.setFg_selfpay(null);
						 Eu_hpindicjudge = true;
					 }else{ // 一般不会，到这里就有异常数据
						 srvdo.setFg_indic(indication.getFg_indic());
						 srvdo.setDes_hplimit(indication.getDes_hplimit());					
						 srvdo.setFg_hpindicjudged(HpIndicJudgeEnum.NONEEDJUDGE);
						 srvdo.setFg_selfpay(FBoolean.TRUE);
					 }
				}
				
				 
			}
			return Eu_hpindicjudge;
		}
		 
	 
	 
	 
    /**
     * 调用医保的接口
     * @param aggDO 医嘱信息
     * @param pipatdo 患者信息
     * @param diagList 诊断信息
     * @return
     * @throws BizException
     */
	private static BdHpIndicationDTO[]  gethpIndications(CiOrAggAndRelDatum oraggandrelinfo,PatDO pipatdo,FArrayList2 diagList)throws BizException{
		 ArrayList<BdHpIndicationDTO> hpIndications = new ArrayList<BdHpIndicationDTO>();
		 CiorderAggDO aggDO = oraggandrelinfo.getOraggdo();
		 for(OrdSrvDO srvdo:aggDO.getOrdSrvDO()){
			    // Eu_hpdoctorjudge   0： 未处理 ， 1： 已经处理 ，  其他 
				//if(srvdo.getId_hp() != null && (srvdo.getEu_hpdoctorjudge() == null || srvdo.getEu_hpdoctorjudge()  == 0 )){
			 if(srvdo.getId_hp() != null && srvdo.getFg_hpindicjudged()==null){
					BdHpIndicationDTO hpIndicationDto = new BdHpIndicationDTO();
					hpIndicationDto.setId_srv(srvdo.getId_srv());
					hpIndicationDto.setCi_orsrvdo(srvdo);
					hpIndicationDto.setCi_di_itms(diagList);
					hpIndicationDto.setId_mm(getOrderId_mm(srvdo.getId_srv(),oraggandrelinfo));
					if(pipatdo != null){
						hpIndicationDto.setPipatdo(pipatdo);
						hpIndicationDto.setSd_sex(pipatdo.getSd_sex());
						hpIndicationDto.setDt_birth(pipatdo.getDt_birth());
					}
					hpIndicationDto.setFg_bb(aggDO.getParentDO().getFg_bb());
					hpIndicationDto.setFg_mm(srvdo.getFg_mm());
					hpIndicationDto.setCode_entp(aggDO.getParentDO().getCode_entp());
					hpIndicationDto.setId_dep_or(aggDO.getParentDO().getId_dep_or());
					hpIndicationDto.setUse_day(aggDO.getParentDO().getDays_or());
					hpIndicationDto.setId_hp(srvdo.getId_hp());
					hpIndications.add(hpIndicationDto);
				}else{
					//srvdo.setFg_selfpay(FBoolean.TRUE);
				}
			}
		  //是否有医保计划
		   if(hpIndications != null && hpIndications.size() >0){
			   return  HpService.getHpIndication(hpIndications.toArray(new BdHpIndicationDTO[hpIndications.size()]));
		   }else{
            return null;
		   }
		 
	}
	
	  /**
	   * 获取物品信息
	   * @param oraggandrelinfo
	   * @return
	   */
	 private static String   getOrderId_mm(String id_srv,CiOrAggAndRelDatum oraggandrelinfo){
        String id_mm= null;
		 OrdSrvDO[] orsrvdos=oraggandrelinfo.getOraggdo().getOrdSrvDO();
		 if(orsrvdos != null && orsrvdos.length >0){
			 FMap srvmmmap=getOrdSrvMmDOMap(oraggandrelinfo.getOrattachht());
			 OrdSrvMmDO mm=null;
					//医嘱项目对应的服务物品处理
					if(srvmmmap!=null && srvmmmap.containsKey(id_srv)){
						mm=(OrdSrvMmDO)srvmmmap.get(id_srv);
						//mm.setId_orsrv(id_orsrv);
						id_mm =mm.getId_mm();
					}
		 }
	   return id_mm;
	 }
	
	/**
	 * 获得医嘱项目对应的物品DO  Map数据<id_srv,do>
	 * @param ht
	 * @return
	 */
	private static FMap getOrdSrvMmDOMap(Hashtable ht){
			if(ht == null) return null;
			String key=OrdSrvMmDODesc.CLASS_FULLNAME;
			return (FMap)ht.get(key);
		}
	/**
	 * 根据服务项目的医保是否已经判断标识，为医嘱中医保是否判断标识赋值
	 * @param aggDO
	 * @return
	 */
	private static Integer getOrHpJudgeEnumValue(CiorderAggDO aggDO){
		int nojudge=0,waitingduge=0,judged=0,SELFPAY=0;
		 for(OrdSrvDO srvdo : aggDO.getOrdSrvDO()){
			 if(srvdo.getStatus()==DOStatus.DELETED) continue;
			 Integer fg_hpindicjudged = srvdo.getFg_hpindicjudged();
			 if(fg_hpindicjudged != null && fg_hpindicjudged==HpIndicJudgeEnum.SELFPAY){
				 SELFPAY++;
			 }else if(fg_hpindicjudged==null||fg_hpindicjudged==HpIndicJudgeEnum.NONEEDJUDGE){
				 nojudge++;
			 }else if(fg_hpindicjudged==HpIndicJudgeEnum.WAITINGJUDGE){
					  waitingduge++;
			 }else if(fg_hpindicjudged==HpIndicJudgeEnum.JUDGED){
					 judged++;
			 }
		 }
		 if(SELFPAY>0){
			 return HpIndicJudgeEnum.SELFPAY;
		 }else if(waitingduge>0){
			 return HpIndicJudgeEnum.WAITINGJUDGE;
		 }else if(judged>0){
			 return HpIndicJudgeEnum.JUDGED;
		 }else{
			 return HpIndicJudgeEnum.NONEEDJUDGE;
		 }
	}
}
