package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiAppTreatExecDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.ciprn.d.CiPrnDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;


/**
 * 诊断保存时更新医嘱中的保外诊断属性
 * 
 * @author HUMS
 *
 */
public class CiOrderUpdateHpCiDiBP {

	// 医嘱读写服务接口
	private ICiorderMDORService iciorderMDORService;
	private ICiorderMDOCudService iciorderMDOCudService;

	// 服务项目读写接口
	private IOrdSrvDORService iordSrvDORService;
	private IOrdSrvDOCudService iordSrvDOCudService;
	//agg 查询集合
	private   ICiorderRService iOrAggQryService;	

	private CiEnContextDTO context;

	public CiOrderUpdateHpCiDiBP(CiEnContextDTO context) {

		this.context = context;

		iciorderMDORService = CiOrdAppUtils.getOrQryService();
		iciorderMDOCudService = CiOrdAppUtils.getOrService();

		iordSrvDORService = CiOrdAppUtils.getOrSrvQryService();
		iordSrvDOCudService = CiOrdAppUtils.getOrSrvService();
		
		iOrAggQryService = CiOrdAppUtils.getOrAggQryService();
	}
    /**
     * 开立 签署 未结算的的医嘱
     * @param id_ent
     * @return
     */
	public FBoolean getEffectiveOrder(String id_ent)throws BizException{
		String whereStr ="id_en='"+id_ent+"' and fg_orhp='N' and  fg_canc = 'N' ";
		CiorderAggDO[] aggorderDO = iOrAggQryService.find(whereStr, "sv", FBoolean.FALSE);
		Map map = getIdOrsrvID(aggorderDO);
	    String[] idOrsrv = CiOrdUtils.getMapConveretArr(map);
	  //判断是否结算   【Y：已经结算， N 未结算】
		FMap settleAccountsMap = CiOrdAppUtils.getIBlOutQryService().getOrSrvStStatus(idOrsrv);
		if(IsSettleAccount(settleAccountsMap)==FBoolean.TRUE){
			return FBoolean.TRUE;
		}else{
		   return FBoolean.FALSE;	
		}
		
	}
	private FBoolean  IsSettleAccount(FMap settleAccountsMap){
		if(settleAccountsMap == null)return FBoolean.FALSE;
		for(Object v:settleAccountsMap.values()){
			if(v==FBoolean.FALSE){
				return FBoolean.TRUE;
			}
		}
		return FBoolean.FALSE;
	}
	
	/**
	 *医嘱项目的集合ID
	 * @param aggorderDO
	 * @return
	 */
	private Map getIdOrsrvID(CiorderAggDO[] aggorderDO){
		Map map =  new  HashMap();
		if(aggorderDO != null && aggorderDO.length > 0 ){
		 for(CiorderAggDO aggdo: aggorderDO){
			 if(aggdo != null && aggdo.getOrdSrvDO() != null &&
					 aggdo.getOrdSrvDO().length >0){
				for(OrdSrvDO ordsrvdo:aggdo.getOrdSrvDO()){
					map.put(ordsrvdo.getId_orsrv(), ordsrvdo.getId_orsrv());
				} 
			 }
		 }	
		}
		return map;
	}
	
	/**
	 * 更新开立状态医嘱、医嘱项目中的保外诊断属性
	 * 
	 * @throws BizException
	 */
	public void execUpdateOrds() throws BizException {
		/* bug 109472    该问题修改方案如下：
		1、医生站：自费诊断保存后，未结算费用、单据都应变为自费，并且提示医生进行单据重打。
		2、收费界面：增加单据是医保还是自费显示信息。

		医生站详细修改方案，自费诊断添加如下逻辑：
		E. 若药品为特殊病药，则需要将其特殊病标志设置为false
		 将未结算的医保单据修改为非医保
		A. 查询本次就诊下的医保标志为Y，费用已结算标志fg_blsettled = N的单据。
		B. 若单据为处方：
		1、将医保标志修改为N
		2、修改处方类型：将医疗保险处方笺类型调整为自费的处方类型，如门诊处方笺或急诊处方笺。其中毒麻、精一处方类型不需要变。建议改部分走处方类型分方规则来实现。
		3、修改处方标志：涉及标志为医保标志、特殊病标志
		C. 若单据为非处方：则将其医保标志设置为N
		 弹出提示信息【存在保外诊断，患者应全额自费。其中未结算的费用因此变成自费，请重打该部分单据。】 */
		List<String> idOrList = null;
		Map  map  = new  HashMap();//没有结算的处方主键
		Map  IdOrmap  = new  HashMap();//医嘱主键
		String ciOrderwhereStr = "id_en = '" + context.getId_en() + "' and sd_su_or in ('0','10') and fg_canc = 'N'";
		CiOrderDO[] ciorders = iciorderMDORService.find(ciOrderwhereStr, "", FBoolean.FALSE);

		if (ciorders != null && ciorders.length > 0) {

			this.updateCiOrders(ciorders);

			idOrList = new ArrayList<String>();
			for (CiOrderDO ciOrder : ciorders) {
				idOrList.add(ciOrder.getId_or());
				IdOrmap.put(ciOrder.getId_or(), ciOrder.getId_or());
			}
			
			//this.execUpdateOrdSrvs(idOrList.toArray(new String[idOrList.size()]));
		}
		//未结算的医嘱项目更新成自费
		UpDataCiORSrvDOFgSelfPay(IdOrmap,map);
		if(map != null && map.size() >0){
			// 修改处方（医保的处方）
			UpdateCipres(map);
			//修改 非药品的打印类型
			updateNotDrugPrn(idOrList,map);
			}
		
	}

	/**
	 * 更新指定医嘱、医嘱项目的保外诊断属性
	 * 
	 * @param idOrs
	 * @throws BizException
	 */
	public void execUpdateOrds(String[] idOrs) throws BizException {

		CiOrderDO[] ciorders = iciorderMDORService.findByIds(idOrs, FBoolean.FALSE);

		if (ciorders != null && ciorders.length > 0) {
			// 更新医嘱中的医保适应症判断结果
			this.updateCiOrders(ciorders);
			// 更新服务项目中的是否自费标识为自费
			this.execUpdateOrdSrvs(idOrs);
		}
	}
    //更新医嘱项目的自费标志（有保外诊断时 未计算的医嘱项目）
	private void UpDataCiORSrvDOFgSelfPay(Map IdOrmap,Map  id_presmap)throws BizException{
		if(IdOrmap != null && IdOrmap.size() >0){	
		String sql = "select id_orsrv from ci_or_srv where id_or in ("+  CiOrdUtils.getMapConveretstr2(IdOrmap) +")";
		DAFacade cade = new DAFacade();
		List<OrdSrvDO> ciorsrvDOLst = (List<OrdSrvDO>) cade.execQuery(sql, new BeanListHandler(OrdSrvDO.class));
		if(ciorsrvDOLst != null && ciorsrvDOLst.size() >0){
		  String[] idOrsrv = new String[ciorsrvDOLst.size()];
		    int i=0;
		    
			for(OrdSrvDO orderdo:ciorsrvDOLst){
				idOrsrv[i]=orderdo.getId_orsrv();
				i++;
		      }	
			//判断是否结算   【Y：已经结算， N 未结算】
		   FMap map = CiOrdAppUtils.getIBlOutQryService().getOrSrvStStatus(idOrsrv);
	      /*  if(map== null){
	           map  =new FMap();
	         for(String id :idOrsrv){
	        	 map.put(id, FBoolean.FALSE);
	         }
	        }*/
			String idorsrv = "id_orsrv in (" + MapToString(map) + ")";
			OrdSrvDO[] ordSrvs = iordSrvDORService.find(idorsrv, null, FBoolean.FALSE);
			for (OrdSrvDO ordSrv : ordSrvs) {
				if(ordSrv.getId_pres() != null){
					id_presmap.put(ordSrv.getId_pres(), ordSrv.getId_pres());//处方主键
				}
			
				ordSrv.setFg_selfpay(FBoolean.TRUE);
				ordSrv.setFg_specill(FBoolean.FALSE);
				ordSrv.setStatus(DOStatus.UPDATED);
			}			// 更新医嘱和服务项目中
			iordSrvDOCudService.save(ordSrvs);
		}
	  }
	}
	
	private String MapToString(FMap map){
		if(map ==null)return null;
		StringBuffer sb = new StringBuffer();
		for(String key : map.keySet()){ 
			   FBoolean  value = (FBoolean)map.get(key);
			   if(value == FBoolean.FALSE){
				   sb.append("'");
				   sb.append(key);
				   sb.append("',");
			   }
		} 
		if(sb.lastIndexOf(",")>0){
		  return sb.substring(0, sb.lastIndexOf(","));	
		}
		return null;
	}
	/**
	 * 更新医嘱服务项目中自费标识改为自费
	 * 
	 * @param idOrs
	 * @throws BizException
	 */
	public void execUpdateOrdSrvs(String[] idOrs) throws BizException {

		StringBuffer buffer = new StringBuffer();
		if (idOrs != null && idOrs.length > 0) {

			// 将原医保就诊的医嘱内容修改为非医保状态
			for (String idOr : idOrs) {
				buffer.append(",'" + idOr + "'");
			}
			// 将原有的服务项目中自费标识改为自费
			String orSrvWhereStr = "id_or in (" + buffer.substring(1) + ")";
			OrdSrvDO[] ordSrvs = iordSrvDORService.find(orSrvWhereStr, null, FBoolean.FALSE);
			for (OrdSrvDO ordSrv : ordSrvs) {
				ordSrv.setFg_selfpay(FBoolean.TRUE);
			}

			// 更新医嘱和服务项目中
			iordSrvDOCudService.update(ordSrvs);
		}
	}

	/**
	 * 更新医嘱中相关的医保适应症状态
	 * 
	 * @param ciorders
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] updateCiOrders(CiOrderDO[] ciorders) throws BizException {

		// 将原医保就诊的医嘱内容修改为非医保状态
		for (CiOrderDO ciOrderDO : ciorders) {
             if(ciOrderDO.getSd_srvtp() != null && ciOrderDO.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
            	 ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);// 医保适应症判断标识枚举
             }else{
            	 ciOrderDO.setEu_hpindicjudge(HpIndicJudgeEnum.SELFPAY);
             }
             ciOrderDO.setFg_orhp(FBoolean.FALSE);
			ciOrderDO.setBhpjudgerst(context.getBhpjudgerst()); // 基本医保判断结果数据信息
			ciOrderDO.setDes_bhpjudgerst(context.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述，保外诊断id串
 
			
		}

		// 更新医嘱和服务项目中
		return iciorderMDOCudService.update(ciorders);
	}
     /**
      * 开立自费诊断时修改处方 类型 处方名称，处方标识
      * @param map
      * @throws BizException
      */
	 private void UpdateCipres(Map map)throws BizException{
		 if(map != null && map.size() >0) {
		 String id_pres = "id_pres in ( "+ CiOrdUtils.getMapConveretstr2(map) +") and  fg_hp_pres ='Y'"; //   医保 1，  非医保 0
		 if(id_pres != null){
			 //查血要修改的处方
			 CiPresDO[] ciPresDO = CiOrdAppUtils.getCiPresQryService().find(id_pres, "sv", FBoolean.FALSE); 
		     //处理逻辑
			  if(ciPresDO != null && ciPresDO.length >0){
				 for(CiPresDO cipres:ciPresDO){
					 if(IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(cipres.getCode_entp())){
						//门诊 
					  cipres.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_MZCFJ);
					  cipres.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_MZCFJ);
					  cipres.setSd_srvtp(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MZCFJ);
					 }else if (IEnDictCodeConst.SD_ENTP_EMERGENCY.equals(cipres.getCode_entp())){
						 //急诊
				       cipres.setName(PKUSplitConst.NAME_UDIDOC_PRESCRIPTION_JZCFJ);
				       cipres.setId_prestp(PKUSplitConst.ID_UDIDOC_PKU_PRESCRIPTION_JZCFJ);
					   cipres.setSd_srvtp(PKUSplitConst.SD_UDIDOC_PRESCRIPTION_JZCFJ);
					 }
					 cipres.setFg_hp_pres(FBoolean.FALSE);
					 cipres.setId_prestpword(Replace(cipres.getId_prestpword(),PKUSplitConst.ID_PRESCRIPTION_FLAG_YB));
					 cipres.setSd_prestpword(Replace(cipres.getSd_prestpword(),PKUSplitConst.ID_PRESCRIPTION_FLAG_YB));
					 cipres.setStatus(DOStatus.UPDATED);
				 } 
			  }
			 //保存修改后的处方
			 CiOrdAppUtils.getCiPresService().save(ciPresDO);
		 }
	   } 
	 }
	 /**
	  * 
	  * @param presword
	  * @param replaceword
	  * @return
	  */
	 private String Replace(String presword,String replaceword){
		 if(presword == null || presword=="")return "";
		 if(presword.indexOf(replaceword) >0){
			 presword = presword.replace(replaceword+",","");
			 presword = presword.replace(replaceword,"");
		 }
		 return presword;
	 }
      /**
       * 修改非药品的医保标志， 检查 检验 治疗 费用清单
       * @param idOrList
       * @param map
       */
	 private void updateNotDrugPrn(List<String> idOrList,Map map)throws BizException{
		 //检查    ci_app_ris c
		 updateCiAppRis(idOrList);
		 //病理 ci_app_pathgy
		 updateCiAppPathgy(idOrList);
		 //检验  i_app_lis e ,  ci_app_lis_or 
		 updateCiAppLis(idOrList);
		 //治疗   ci_app_treatexec  treatexec, ci_app_treatexec_or -- 治疗
		 updateCiAppTreatexec(idOrList);
		 //费用清单    ci_prn , ci_prn_item 
		 updateCiAppCiprn(map);
	 }
	 
	 private void updateCiAppLis(List<String> idOrList)throws BizException{
 		 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select e.* from ci_app_lis e , "); 
 		 sb.append(" ci_app_lis_or r where e.id_ciapplissheet = r.id_ciapplissheet ");
 		 sb.append(" and e.fg_hp_pres ='Y' and r.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppLisSheetDO> ciAppLisSheetDO = ( List<CiAppLisSheetDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppLisSheetDO.class));
	     if(ciAppLisSheetDO != null && ciAppLisSheetDO.size() >0){
	    	 for(CiAppLisSheetDO lissheetDO:ciAppLisSheetDO){
	    		 lissheetDO.setFg_hp_pres(FBoolean.FALSE);
	    		 lissheetDO.setStatus(DOStatus.UPDATED);
	    	 }
	    	 CiOrdAppUtils.getICiapplissheetMDOCudService().save(ciAppLisSheetDO.toArray( new CiAppLisSheetDO[ciAppLisSheetDO.size()]));
	     }
	 }
     private void updateCiAppPathgy(List<String> idOrList)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
    	 sb.append(" select e.* from ci_app_pathgy e "); 
 		 sb.append(" where   e.fg_hp ='Y' and  e.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppPathgySheetDO> ciAppPathgySheetDO = (List<CiAppPathgySheetDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppPathgySheetDO.class));
		 if(ciAppPathgySheetDO != null && ciAppPathgySheetDO.size() >0){
			 for(CiAppPathgySheetDO ciAppPathgyDO:ciAppPathgySheetDO){
				 ciAppPathgyDO.setFg_hp(FBoolean.FALSE);
				 ciAppPathgyDO.setStatus(DOStatus.UPDATED);
			 }
			 CiOrdAppUtils.getICiapppathgysheetMDOCudService().save(ciAppPathgySheetDO.toArray( new CiAppPathgySheetDO[ciAppPathgySheetDO.size()] ));
		 }
	 }
     private void updateCiAppRis(List<String> idOrList)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select e.* from ci_app_ris e  "); 
 		 sb.append(" where  e.fg_hp ='Y' and e.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppRisSheetDO> ciAppRisSheetDO = (List<CiAppRisSheetDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppRisSheetDO.class));
		 if(ciAppRisSheetDO != null && ciAppRisSheetDO.size() > 0){
			for(CiAppRisSheetDO ciappRisDO:ciAppRisSheetDO){
				 ciappRisDO.setFg_hp(FBoolean.FALSE);
				 ciappRisDO.setStatus(DOStatus.UPDATED);
			} 
			CiOrdAppUtils.getICiapprissheetCudService().save(ciAppRisSheetDO.toArray(new CiAppRisSheetDO[ciAppRisSheetDO.size()] ));
		 }
	 }
     private void updateCiAppTreatexec(List<String> idOrList)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select treatexec.* from ci_app_treatexec  treatexec, "); 
 		 sb.append(" ci_app_treatexec_or  treatexec_or  where treatexec.id_ciapptreatexec = treatexec_or.id_ciapptreatexec ");
 		 sb.append(" and treatexec.fg_hp ='Y' and treatexec_or.id_or in ("+CiOrdUtils.ListConveretCharacterString(idOrList)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiAppTreatExecDO> TreatexecDO = (List<CiAppTreatExecDO>) df.execQuery(sb.toString(), new BeanListHandler(CiAppTreatExecDO.class));
		 if(TreatexecDO != null && TreatexecDO.size() >0){
			 for(CiAppTreatExecDO treatDO:TreatexecDO){
				 treatDO.setFg_hp(FBoolean.FALSE);
				 treatDO.setStatus(DOStatus.UPDATED);
			 }
			 CiOrdAppUtils.getICiapptreatexecMDOCudService().save(TreatexecDO.toArray(new CiAppTreatExecDO[TreatexecDO.size()]));
		 }
	 }
     private void updateCiAppCiprn(Map map)throws BizException{
    	 StringBuffer  sb = new StringBuffer();
 		 sb.append(" select ciprn.* from  ci_prn ciprn, "); 
 		 sb.append(" ci_prn_item item  where ciprn.id_ciprn = item.id_ciprn ");
 		 sb.append(" and ciprn.fg_hp ='Y' and item.id_biz in  ("+CiOrdUtils.getMapConveretstr2(map)+")  ");
	     DAFacade   df = new DAFacade();
	     List<CiPrnDO> ciprnDO = (List<CiPrnDO>) df.execQuery(sb.toString(), new BeanListHandler(CiPrnDO.class));
		 if(ciprnDO != null && ciprnDO.size() >0){
			for(CiPrnDO ciprn:ciprnDO){
				ciprn.setFg_hp(FBoolean.FALSE);
				ciprn.setStatus(DOStatus.UPDATED);
			} 
			CiOrdAppUtils.getICiprintMDOCudService().save(ciprnDO.toArray(new CiPrnDO[ciprnDO.size()]));
		 }
	 }
}
