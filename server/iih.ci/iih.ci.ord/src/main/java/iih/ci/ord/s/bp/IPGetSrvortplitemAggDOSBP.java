/**
 * 
 */
package iih.ci.ord.s.bp;




import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.cherbboilmd.i.ICherbboilmdMDORService;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqdefAggDO;
import iih.bd.srv.freqdef.i.IFreqdefRService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.i.IMedusageRService;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplItmDtDO;
import iih.bd.srv.ortpl.d.OrTplItmSetDO;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.d.SrvortplitemAggDO;
import iih.bd.srv.ortpl.d.desc.OrTmplDODesc;
import iih.ci.ord.dto.newordertemplatedto.d.NewOrderTemplateDTO;
import iih.ci.ord.dto.ordertemplatedto.d.OrderTemplateDTO;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.bp.GetSrvPriceBP;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.bp.qry.GetMedSrvAllItemDOBP;
import iih.ci.ord.s.bp.qry.GetMedSrvItemDOBP;
import iih.ci.ord.s.bp.qry.SrvSetItemQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

/**
 * @ClassName: getSrvortplitemAggDOSBP
 * @Description: 住院 医嘱助手 医嘱模板项目 
 * @author Comsys-li_zheng
 * @date 2016年3月9日 下午1:33:56
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class IPGetSrvortplitemAggDOSBP {
	
	  private FMap freqMap; //频次集合
	  private FMap measDocMap;//剂量单位
	  private FMap routeMap;//用法集合
	  private FMap boilMap;//煎法集合
	  private FArrayList templateList;
	  private FArrayList NewTmplateList;
	  Map<String, FDouble> srvMapPrice ;//非物品价格
	  Map<String, FDouble> mmMapPrice ;//物品价格
	  
	  Map<String, String> srvMapMedical ;//非物品医保目录
	  Map<String, String> mmMapMedical ;//物品医保目录
	  
	  Map<String, String> Id_mmMap; //物品id集合
	  Map<String, String> Id_srvMap;//项目id 集合
	  
	  //项目是否停用
	  FMap2  bdsrvUserMap;
	  List<OrdSrvChangedInfoDTO> infoList;
	  
	 public static IPGetSrvortplitemAggDOSBP instance;
	 public static IPGetSrvortplitemAggDOSBP getInstance() throws BizException{
		 if(instance== null){
			 instance = new IPGetSrvortplitemAggDOSBP();
		 }
		 return instance;
	 }
	  
	  public IPGetSrvortplitemAggDOSBP()throws BizException{
		  this.getFreqDefDO();
		  this.getMeasDocDO();
		  this.getBoilDO();
		  //this.getRouteDO();
	  }
	  /**
       *zwq添加缓存模板数据时使用
       * @param id_ortmpl
       * @return
       * @throws BizException
       */
	  public FMap getNewOrderTemplateDTO2(String Id_pripat,String id_hp,String code_entp)throws BizException{
			  this.templateList = new FArrayList();
			  this.infoList = new ArrayList();
			  String whereStr =" 1=1";
			  if(getEnTp(code_entp) != null ){
				  whereStr += "  and " +getEnTp(code_entp); 
			  }
			  OrtmplAggDO[] aggdo = CiOrdAppUtils.getIOrtmplRService().find(whereStr, OrTmplDODesc.PRIMARYKEY_FIELDNAME, FBoolean.FALSE);

			  return HandleOrTmplate(aggdo,Id_pripat,id_hp,code_entp);
			 //return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	   /**
       * 新的医嘱模板的逻辑(20170510 改造)
       * @param id_ortmpl
       * @return
       * @throws BizException
       */
	  public FMap getNewOrderTemplateDTO2(String[] id_ortmpl,String Id_pripat,String id_hp,String code_entp)throws BizException{
			  this.templateList = new FArrayList();
			  this.infoList = new ArrayList();
			  String  whereStr = OrTmplDODesc.PRIMARYKEY_FIELDNAME +" in ( "+CiOrdUtils.IdsConveretCharacterString(id_ortmpl)+" )";
			  if(getEnTp(code_entp) != null ){
				  whereStr += "  and " +getEnTp(code_entp); 
			  }
			  OrtmplAggDO[] aggdo = CiOrdAppUtils.getIOrtmplRService().find(whereStr, OrTmplDODesc.PRIMARYKEY_FIELDNAME, FBoolean.FALSE);

			  return HandleOrTmplate(aggdo,Id_pripat,id_hp,code_entp);
			 //return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	  private String getEnTp(String code_entp){
		  String entp =  null ;
		  if(code_entp != null && IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(code_entp)){
			  entp = "fg_entp_op ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_EMERGENCY.equals(code_entp)){
			  entp = "fg_entp_er ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_INPATIENT.equals(code_entp)){
			  entp = "fg_entp_ip ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_PHYSICALEXAM.equals(code_entp)){
			  entp = "fg_entp_fm ='Y'";
		  }
		  return entp;
	  }
	  
	  /**
	   * 价格 医保，服务的启用 处理
	   * @param aggdo
	   * @param Id_pripat
	   * @param id_hp
	   * @param code_entp
	   * @return
	   * @throws BizException
	   */
	  private FMap HandleOrTmplate(OrtmplAggDO[] aggdo,String Id_pripat,String id_hp,String code_entp)throws BizException{
		  FMap   map = new FMap();  
		  int num =0;
		  if(aggdo != null && aggdo.length >0){
			  for(OrtmplAggDO agg: aggdo){
				  num++;
				  this.NewTmplateList =  new FArrayList(); 
				  FArrayList temp = new FArrayList();
				  //处理时数据  
				  OrtmplateConvertTONewTmplateDTO(agg);
				  if(this.NewTmplateList != null && this.NewTmplateList.size()!=0){
					  temp = this.NewTmplateList;
					  map.put(agg.getParentDO().getId_ortmpl(), temp) ;
				  }
			  }
		  }
		  //服务集合 
		  HandleFMap2(map,Id_pripat,id_hp,code_entp);
		   //设置价格 医保和服务的启停
		  setvalue(map);
		  return map;
	  }	   
	  
	  private FArrayList2 FMapTOFArrayList2(FMap2 map){
		  FArrayList2  f2 = new  FArrayList2();
		  Iterator entrys=  map.entrySet().iterator();
		  while(entrys.hasNext())
		  {
			  Map.Entry entry = (Map.Entry) entrys.next();
			  FArrayList2 TemplateList = (FArrayList2) entry.getValue(); 
			  
			  return TemplateList;
		  }
		  return f2;
	  }
	  
	  
	  private void HandleFMap2(FMap map,String Id_pripat,String id_hp,String code_entp)throws BizException{
		  if(map != null && map.size() >0){
			  this.Id_mmMap = new HashMap();
			  this.Id_srvMap = new HashMap();
			  this.bdsrvUserMap = new FMap2();
			  Iterator entrys=  map.entrySet().iterator();
			  while(entrys.hasNext())
			  {  
				Map.Entry entry = (Map.Entry) entrys.next();
				FArrayList TemplateList = (FArrayList) entry.getValue(); 
				if(TemplateList != null && TemplateList.size() > 0)
					{ 
						for(int i=0;i<TemplateList.size();i++){
							NewOrderTemplateDTO dto = (NewOrderTemplateDTO)TemplateList.get(i);
							FArrayList  list =  dto.getItemlist();
							HandlOrTplNItmDOlist(list);
						}
					}
			    } 
				//价格
			     List<String> Id_mmList = null;
			     if(this.Id_mmMap != null && this.Id_mmMap.size() >0){
			    	 Id_mmList = new ArrayList<String>(this.Id_mmMap.keySet());
			     }
			     List<String> Id_srvList =null;
			     if(this.Id_srvMap != null && this.Id_srvMap.size() >0){
			    	 Id_srvList = new ArrayList<String>(this.Id_srvMap.keySet());
			     }
 
				setPrice(Id_pripat,Id_srvList,Id_mmList);
				//医保目录
				MedicareCataLogSrv(id_hp,Id_srvList);
				MedicareCataLogMm(id_hp,Id_mmList);
				//服务是否停用
				if(this.infoList != null && this.infoList.size() >0){
					this.ChangedSrvValidate(this.infoList.toArray(new OrdSrvChangedInfoDTO[this.infoList.size()]), code_entp);
				}
			 
		  }
	  }
	  
	  
	  /**
	   * set 价格医保信息
	   * @param map
	   */
	  private void setvalue(FMap map){
		  if(map != null && map.size() >0){
			  Iterator entrys=  map.entrySet().iterator();
			  while(entrys.hasNext())
			  {
				Map.Entry entry = (Map.Entry) entrys.next();
				FArrayList TemplateList = (FArrayList) entry.getValue(); 
				if(TemplateList != null && TemplateList.size() > 0)
					{
						for(int i=0;i<TemplateList.size();i++){
							NewOrderTemplateDTO dto = (NewOrderTemplateDTO)TemplateList.get(i);
							FArrayList  list =  dto.getItemlist();
							HandlOrTplNItmDOSetValue(list,dto);
						}
					}
			    }
		  }
	  }
	  
	  //获取价格信息
	  private  void setPrice(String idPriPat, List<String> idSrvList,List<String> idMmList){
		  GetSrvPriceBP priceBP = new GetSrvPriceBP();
		   srvMapPrice=  priceBP.getSrvPrice(idPriPat,idSrvList); 
		   mmMapPrice=  priceBP.getMMPrice(idMmList);
	  }
	  /**
	   * 获取医保信息
	   * @param list
	   */
	  private void  HandlOrTplNItmDOlist(FArrayList list){
		   if(list != null && list.size() >0){
			   for(int i=0;i<list.size();i++){
				   OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();				  
				   OrTplNItmDO itemDo = (OrTplNItmDO)list.get(i);
				   if(itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					   this.Id_mmMap.put(itemDo.getId_mm(), itemDo.getId_mm());
					   dto.setId_srv(itemDo.getId_srv());
					   dto.setId_mm(itemDo.getId_mm());
					   this.infoList.add(dto);
				   }else{
					   this.Id_srvMap.put(itemDo.getId_srv(), itemDo.getId_srv());
					   if(!CiOrdUtils.isEmpty(itemDo.getId_srv_set())&&!this.Id_srvMap.containsKey(itemDo.getId_srv_set())){
						   this.Id_srvMap.put(itemDo.getId_srv_set(), itemDo.getId_srv_set());
						   dto.setId_srv(itemDo.getId_srv_set());
					   }else{
						   dto.setId_srv(itemDo.getId_srv());
					   }
					   this.infoList.add(dto);
				   }
				   
			   }
		   }
	  }
	  
	  //设置价格和医保信息
	  private void  HandlOrTplNItmDOSetValue(FArrayList list,NewOrderTemplateDTO dto){
		   if(list != null && list.size() >0){
			   if(this.srvMapPrice != null && this.srvMapPrice.containsKey(dto.getId_srv())){
				   dto.setPrice(formatePriceLength(this.srvMapPrice.get(dto.getId_srv())));
			    }
			   if(this.mmMapMedical != null && this.mmMapMedical.containsKey(dto.getId_srv())){
				   dto.setName_hp(this.mmMapMedical.get(dto.getId_srv()));					   
				}
			   if(this.srvMapMedical != null && this.srvMapMedical.containsKey(dto.getId_srv())){
				   dto.setName_hp(this.srvMapMedical.get(dto.getId_srv()));					   
				}
			   
			   if(this.bdsrvUserMap != null ){
				   
				   String key = dto.getId_srv();
				   if(this.bdsrvUserMap.containsKey(key)){
					   dto.setDescription((String)(this.bdsrvUserMap.get(key)));	
					   dto.setFg_active(FBoolean.FALSE);
				   }else{
					   // 拼接id_srv,id_mm 作为key值
					   key += StringUtils.isBlank(dto.getId_mm()) ? "" :","+dto.getId_mm();
					   
					   if( this.bdsrvUserMap.containsKey(key)){
						   dto.setDescription((String)(this.bdsrvUserMap.get(key)));	
						   dto.setFg_active(FBoolean.FALSE);
					   }
				   }
			   }
			   
			   
			   for(int i=0;i<list.size();i++){
				   OrTplNItmDO itemDo = (OrTplNItmDO)list.get(i);

				   if(itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
					   if(this.mmMapPrice != null && this.mmMapPrice.containsKey(itemDo.getId_srv()+","+itemDo.getId_mm())){
						   itemDo.setPrice(formatePriceLength(this.mmMapPrice.get(itemDo.getId_srv()+","+itemDo.getId_mm())));
					   }
					  if(this.mmMapMedical != null && this.mmMapMedical.containsKey(itemDo.getId_mm())){
						  itemDo.setName_hp(this.mmMapMedical.get(itemDo.getId_mm()));					   
						 }
					  
					if (this.bdsrvUserMap != null) {

						String key2 = itemDo.getId_srv();
						if (this.bdsrvUserMap.containsKey(key2)) {

							itemDo.setDescription((String) (this.bdsrvUserMap.get(key2)));
							itemDo.setFg_active(FBoolean.FALSE);
						} else {
							// 拼接id_srv,id_mm作为key值
							key2 += StringUtils.isBlank(itemDo.getId_mm()) ? "" : "," + itemDo.getId_mm();
							if (this.bdsrvUserMap.containsKey(key2)) {

								itemDo.setDescription((String) (this.bdsrvUserMap.get(key2)));
								itemDo.setFg_active(FBoolean.FALSE);
							}
						}
					}
					
					  
					  
					   
				   }else{
					   if(this.srvMapPrice != null && this.srvMapPrice.containsKey(itemDo.getId_srv())){
						   itemDo.setPrice(formatePriceLength(this.srvMapPrice.get(itemDo.getId_srv())));
					    }
					  if(this.srvMapMedical != null && this.srvMapMedical.containsKey(itemDo.getId_srv())){
						  itemDo.setName_hp(this.srvMapMedical.get(itemDo.getId_srv()));					   
						 }
					  if(this.bdsrvUserMap != null && this.bdsrvUserMap.containsKey(itemDo.getId_srv())){ 
						  itemDo.setDescription((String)(this.bdsrvUserMap.get(itemDo.getId_srv())));		
						  itemDo.setFg_active(FBoolean.FALSE);
						  if(dto.getUi_flag() != null && dto.getUi_flag()=="1"){
							  dto.setFg_active(FBoolean.FALSE);//套的不可启用  （套有一个项目停用的 套就停用  王琪）
							  dto.setDescription((String)(this.bdsrvUserMap.get(itemDo.getId_srv())));
						  }
						}
				   }
				   
			   }
		   }
	  }
	  
	  /**
	   * 服务的启停接口
	   * @param ordSrvChangedInfoDTO
	   * @param code_entp
	   * @throws BizException
	   */
	private void  ChangedSrvValidate(OrdSrvChangedInfoDTO[] ordSrvChangedInfoDTO,String code_entp)throws BizException{
	 OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
	  this.bdsrvUserMap = bp.exec(ordSrvChangedInfoDTO, code_entp);
	}  
	  
	  
	  
	  
	  
	  //模板转换成NewTmplateDTO
	  private void OrtmplateConvertTONewTmplateDTO(OrtmplAggDO aggdo)throws BizException{
		  OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
		  //Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品), 5 草药显示,  6  诊疗 , 4 :其它 (NewTemplteDTO  的 str 赋值显示子项没有checkbox)
		// 模板类型
			/// 成组西成药
			//public static final String SD_ORTMPLTP_CZXCY = "01";
			/// 草药方剂
			//public static final String SD_ORTMPLTP_CYFJ = "02";
			/// 复合模板
			//public static final String SD_ORTMPLTP_FHMBA = "11";
		    /// 检查模板
		   // public static final String SD_ORTMPLTP_RIS = "12";
		    /// 检验模板
		   // public static final String SD_ORTMPLTP_LIS = "13";
		    /// 诊疗模板
		   // public static final String SD_ORTMPLTP_TREAT = "14";
		  // 初始化用法
		  this.getRouteDO(aggdo);
		  
		  if(IBdSrvDictCodeConst.SD_ORTMPLTP_FHMBA.equals(aggdo.getParentDO().getSd_ortmpltp())
			||IBdSrvDictCodeConst.SD_ORTMPLTP_RIS.equals(aggdo.getParentDO().getSd_ortmpltp())
		    ||IBdSrvDictCodeConst.SD_ORTMPLTP_LIS.equals(aggdo.getParentDO().getSd_ortmpltp())
		    ||IBdSrvDictCodeConst.SD_ORTMPLTP_TREAT.equals(aggdo.getParentDO().getSd_ortmpltp())){
			//复合模板 
			  setOrTemplateFuhemoban(aggdo);
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(aggdo.getParentDO().getSd_ortmpltp())){
		   //西成药模板  
			   setOrTemplateXCY(aggdo);
			   
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(aggdo.getParentDO().getSd_ortmpltp())){
			   //草药模板  
			   setOrTemplateCYFJ(aggdo);
		   }else{
			   
		   }
	  }
	  

	  /**
	   * 医保目录 非药品
	   * @param id_hp
	   * @param id_srv
	   * @return
	   */
	  private void MedicareCataLogSrv(String id_hp,List<String> id_srvs){
		  srvMapMedical = new HashMap();
		  if(id_hp == null || id_hp ==""){
			  
		  }else{
			  String sql = "select  bd_hp_srvorca.id_srv, bd_udidoc.name  "
			   		   +"  from bd_hp_srvorca , bd_udidoc"
	                   +" where bd_hp_srvorca.id_hpsrvtp = bd_udidoc.id_udidoc"
					   +" and  bd_hp_srvorca.id_hp = '"+id_hp+"'"
					   +" and bd_hp_srvorca.id_srv  in ("+CiOrdUtils.ListConveretCharacterString(id_srvs)+")";
			   try{
					   List<Map<String, Object>> priMapList = null;
					   priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql,
								new MapListHandler());
					   if(priMapList != null && priMapList.size() >0){
						 for(Map<String, Object> priObjMap : priMapList){
							 String key = (String) priObjMap.get("id_srv");
							 String value = (String) priObjMap.get("name");
							 srvMapMedical.put(key, value);
						  }  
					    }
			     }catch (DAException e) {
					throw new BizRuntimeException(e.getMessage());
				}
		  }
		   
		   
	  }
	  /**
	   * 医保目录药品
	   * @param id_hp
	   * @param id_mm
	   * @return
	   */
	  private void MedicareCataLogMm(String id_hp,List<String> id_mms){
		   mmMapMedical= new HashMap();
		   if(id_hp == null || id_hp ==""){
				  
			}else{
				 //select bd_hp_srvorca.id_hp,bd_hp_srvorca.id_srv,bd_hp_srvorca.id_mm, bd_udidoc.name 
				   String sql = "select  bd_hp_srvorca.id_mm, bd_udidoc.name  "
					   		   +"  from bd_hp_srvorca , bd_udidoc"
			                   +" where bd_hp_srvorca.id_hpsrvtp = bd_udidoc.id_udidoc"
							   +" and  bd_hp_srvorca.id_hp = '"+id_hp+"'"
							   +" and bd_hp_srvorca.id_mm  in ("+CiOrdUtils.ListConveretCharacterString(id_mms)+") ";
				   
				   try{
					      List<Map<String, Object>> priMapList = null;
						   priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql,
									new MapListHandler());
						   if(priMapList != null && priMapList.size() >0){
								 for(Map<String, Object> priObjMap : priMapList){
									 String key = (String) priObjMap.get("id_mm");
									 String value = (String) priObjMap.get("name");
									 mmMapMedical.put(key, value);
								  }  
							    }
					   }catch (DAException e) {
							throw new BizRuntimeException(e.getMessage());
					   }
		   }   
	  }
	  
	  
//==============old 模板======================================================================	  
	  
       /**
        *  医嘱模板的逻辑
        * @param id_ortmpl
        * @return
        * @throws BizException
        */
	  @Deprecated
	  public NewOrderTemplateDTO[] getNewOrderTemplateDTO(String id_ortmpl)throws BizException{
			  this.templateList = new FArrayList(); 
			  this.NewTmplateList = new FArrayList();
			  getTemplateType(id_ortmpl);
			 return (NewOrderTemplateDTO[]) this.templateList.toArray(new NewOrderTemplateDTO[0]);
	  }
	  
	  private void getTemplateType(String id_ortmpl)throws BizException{ 
		  OrtmplAggDO aggdo = CiOrdAppUtils.getIOrtmplRService().findById(id_ortmpl);
		  if(aggdo == null){
			  return;
		  }
		  OrTmplDO orTmpl = aggdo.getParentDO();
		  // 初始化用法
		  this.getRouteDO(aggdo);
		  
		  OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
		  //Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品), 5 草药显示,  4 :其它 (NewTemplteDTO  的 str 赋值显示子项没有checkbox)
		  //复合模板  
		  //西成药模板 
		  //草药模板
		  
		  if(IBdSrvDictCodeConst.SD_ORTMPLTP_FHMBA.equals(aggdo.getParentDO().getSd_ortmpltp())||IBdSrvDictCodeConst.SD_ORTMPLTP_RIS.equals(aggdo.getParentDO().getSd_ortmpltp())||IBdSrvDictCodeConst.SD_ORTMPLTP_LIS.equals(aggdo.getParentDO().getSd_ortmpltp())){
			//复合模板 
			  setOrTemplateFuhemoban(aggdo);
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(aggdo.getParentDO().getSd_ortmpltp())){
		   //西成药模板  
			   setOrTemplateXCY(aggdo);
			   
		   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(aggdo.getParentDO().getSd_ortmpltp())){
			   //草药模板  
			   setOrTemplateCYFJ(aggdo);
		   }else{
			   
		   }
		  
		  
		  
	/*	  for(OrTplNItmDO ortmpl: orTplItem){
			  NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
			  template.setFreqdefdo(freqMap);
			  template.setMeasdocdo(measDocMap);
			  template.setRoutedo(routeMap);
			  template.setBoildo(boilMap);
			  template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
			  this.setNewTemplateDTO(template, ortmpl,aggdo);
			  this.templateList.append(template);
		  }*/
	  }
	  
	  private void  setOrTemplateFuhemoban( OrtmplAggDO aggdo) throws BizException{
		  if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
			  OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
			  for(OrTplNItmDO  item:orTplItem){
				if(OrTplItmTypeEnum.ORTMPL.equals(item.getEu_ortplitmtp())){
					 OrtmplAggDO tempAggDO = CiOrdAppUtils.getIOrtmplRService().findById(item.getId_srv());
					 if(IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(tempAggDO.getParentDO().getSd_ortmpltp())){
						   //西成药模板  
							   setOrTemplateXCY(tempAggDO);
							   
						   }else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(tempAggDO.getParentDO().getSd_ortmpltp())){
							   //草药模板  
							   setOrTemplateCYFJ(tempAggDO);
						   }
					 
					 
				}else if(OrTplItmTypeEnum.SRV.equals(item.getEu_ortplitmtp())){
					 NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					 template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					  template.setFreqdefdo(freqMap);
					  template.setMeasdocdo(measDocMap);
					  template.setRoutedo(routeMap);
					  template.setBoildo(boilMap);
					  template.setId_srv(item.getId_srv());
					  template.setId_mm(item.getId_mm());
					  template.setSd_srvtp(item.getSd_srvtp());
					  template.setName_freq(item.getOrtplnitm_freq_name());
					  template.setDays_or(item.getDays_or());
					  template.setName_route(item.getOrtplnitm_route_name());
					  template.setName_routedes(item.getOrtplnitm_boildes_name());
					 FArrayList Itemlist = new FArrayList();
					 if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)){
						 template.setUi_flag("3");
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 template.setId(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("4");
						 template.setTemplatetype(FBoolean.TRUE);
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else if(item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)){
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("6");//诊疗项目
						// template.setTemplatetype(FBoolean.TRUE);
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }else{
						// NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
						 
						 template.setId(item.getId_ortmplitm());
						 template.setName(aggdo.getParentDO().getName());
						 template.setId_boil(item.getId_boil());
						 template.setId_route(item.getId_route());
						 template.setId_freq(item.getId_freq());
						 template.setName_route(item.getOrtplnitm_route_name());
						 template.setName_boil(item.getOrtplnitm_boil_name());
						 template.setName_freq(item.getOrtplnitm_freq_name());
						 template.setUi_flag("4");
						 item.setIdentical_ortmpl(item.getId_ortmplitm());
						 Itemlist.add(item);
						 template.setItemlist(Itemlist);
					 }
					 template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
					 this.templateList.append(template);
					 this.NewTmplateList.append(template);
				 }else if(OrTplItmTypeEnum.SRVSET.equals(item.getEu_ortplitmtp())){
					 NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					 template.setName(item.getOrtplnitm_srv_name());
					 template.setId(item.getId_ortmplitm());
					 template.setUi_flag("1");
					  template.setFreqdefdo(freqMap);
					  template.setMeasdocdo(measDocMap);
					  template.setRoutedo(routeMap);
					  template.setBoildo(boilMap);
					 //template.setItem(Item);
					  template.setName_freq(item.getOrtplnitm_freq_name());
					  template.setDays_or(item.getDays_or());
					  template.setName_route(item.getOrtplnitm_route_name());
					  template.setName_routedes(item.getOrtplnitm_boildes_name());
					  template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					 template.setItemlist(getOrTplNItmDOSet(item));
					 template.setId_srv(item.getId_srv());
					 template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
					 this.templateList.append(template);
					 this.NewTmplateList.append(template);
				 }
				  
				  
			  }
		  }
	  }
	  
	  
	  
	  
	  /**
	   * 西成药
	   * @param aggdo
	   * @throws BizException
	   */
	   private void setOrTemplateXCY(OrtmplAggDO aggdo)throws BizException{
		   if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
			   OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
			   FArrayList Itemlist = new FArrayList();
			   NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
			   template.setId(aggdo.getParentDO().getId_ortmpl());
			   template.setName(aggdo.getParentDO().getName());
			   template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
			   template.setUi_flag("2");
			   template.setFreqdefdo(freqMap);
			   template.setMeasdocdo(measDocMap);
			   template.setRoutedo(routeMap);
			   template.setBoildo(boilMap);
			   template.setName_route(aggdo.getParentDO().getOrtmpl_route_name());
			   template.setName_routedes(aggdo.getParentDO().getOrtmpl_routedes_name());
			   template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y 页面显示控件判断使用
			   if(orTplItem != null && orTplItem.length >0){
				   int num = orTplItem.length;
				   int seq =0;
				   for(OrTplNItmDO item:orTplItem){
					   item.setDays_or(aggdo.getParentDO().getDays_or());
					   item.setOrtplnitm_route_code(aggdo.getParentDO().getOrtmpl_route_code());
					   item.setOrtplnitm_route_name(aggdo.getParentDO().getOrtmpl_route_name());
					   item.setOrtplnitm_routedes_name(aggdo.getParentDO().getOrtmpl_routedes_code());
					   item.setOrtplnitm_routedes_name(aggdo.getParentDO().getOrtmpl_routedes_name());
					   
					   item.setOrtplnitm_freq_code(aggdo.getParentDO().getOrtmpl_freq_code());
					   item.setOrtplnitm_freq_name(aggdo.getParentDO().getOrtmpl_freq_name());
					   template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					   item.setIdentical_ortmpl(aggdo.getParentDO().getId_ortmpl());
					   
					      template.setName_freq(item.getOrtplnitm_freq_name());
						  template.setDays_or(item.getDays_or());
//						  template.setName_route(item.getOrtplnitm_route_name());
//						  template.setName_routedes(item.getOrtplnitm_boildes_name());
					   if(num==2){
						   if(seq==0){
							   item.setOrtplnitm_mm_name("┏ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┏ "+item.getOrtplnitm_srv_name());
						   }else{
							   item.setOrtplnitm_mm_name("┗ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┗ "+item.getOrtplnitm_srv_name());
						   }
						   
					   }else if(num >2){
						   if(seq==0){
							   item.setOrtplnitm_mm_name("┏ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┏ "+item.getOrtplnitm_srv_name());
						   }else if(seq==num-1){
							   item.setOrtplnitm_mm_name("┗ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┗ "+item.getOrtplnitm_srv_name());
						   }else{
							   item.setOrtplnitm_mm_name("┠ "+item.getOrtplnitm_mm_name());
							   item.setOrtplnitm_srv_name("┠ "+item.getOrtplnitm_srv_name());
						   }
					   } 
					   
					   Itemlist.append(item);
					   template.setId_srv(item.getId_srv());
					   template.setId_mm(item.getId_mm());
					   template.setSd_srvtp(item.getSd_srvtp());
					   seq++;
				   } 
			   }
			 
			   template.setItemlist(Itemlist);
			   this.templateList.append(template);
			   this.NewTmplateList.append(template);
		   }
	   }
	  
	   /**
		   *  草药方剂
		   * @param aggdo
		   * @throws BizException
		   */
		   private void setOrTemplateCYFJ(OrtmplAggDO aggdo)throws BizException{
			   if(aggdo != null && aggdo.getOrTplNItmDO().length >0){
				   OrTplNItmDO[] orTplItem = aggdo.getOrTplNItmDO();
				   FArrayList Itemlist = new FArrayList();
				   NewOrderTemplateDTO  template = new NewOrderTemplateDTO();
					template.setId(aggdo.getParentDO().getId_ortmpl());
					template.setName(aggdo.getParentDO().getName());
					template.setId_boil(aggdo.getParentDO().getId_boil());
					template.setId_route(aggdo.getParentDO().getId_route());
					template.setId_freq(aggdo.getParentDO().getId_freq());
					template.setName_route(aggdo.getParentDO().getOrtmpl_route_name());
					template.setName_boil(aggdo.getParentDO().getOrtmpl_boil_name());
					template.setName_freq(aggdo.getParentDO().getOrtmpl_freq_name());
					template.setId(aggdo.getParentDO().getId_ortmpl());
					template.setName(aggdo.getParentDO().getName());
					template.setTemplatetype(FBoolean.TRUE);// 其它模板时N ，草药模板时 Y
					template.setOrders(aggdo.getParentDO().getOrders());										// 页面显示控件判断使用
					template.setUi_flag("5");
					template.setName_routedes(aggdo.getParentDO().getOrtmpl_routedes_name());
					template.setFreqdefdo(freqMap);
					template.setMeasdocdo(measDocMap);
					template.setRoutedo(routeMap);
					template.setBoildo(boilMap);
					for (OrTplNItmDO item : orTplItem) {
						item.setOrders(aggdo.getParentDO().getOrders());
						template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
						item.setIdentical_ortmpl(item.getId_ortmpl());
						item.setId_boil(aggdo.getParentDO().getId_boil());
						item.setOrtplnitm_boil_name(aggdo.getParentDO().getOrtmpl_boil_name());
						Itemlist.append(item);
						template.setId_srv(item.getId_srv());
						template.setId_mm(item.getId_mm());
						template.setSd_srvtp(item.getSd_srvtp());
						template.setName_freq(item.getOrtplnitm_freq_name());
					    template.setDays_or(item.getDays_or());
					    template.setName_route(item.getOrtplnitm_route_name());
					    template.setName_routedes(item.getOrtplnitm_boildes_name());
					}
					template.setItemlist(Itemlist);
					this.templateList.append(template);
					this.NewTmplateList.append(template);
			   }
		   }
		  
	  
	  /**
	   *  
	   *  Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品), 5 草药显示,  4 :其它 (NewTemplteDTO  的 str 赋值显示子项没有checkbox)
	   * 判断医嘱模板的类型 
	   * @param template
	   * @param ortmpl
	   */
	  private void setNewTemplateDTO(NewOrderTemplateDTO  template,OrTplNItmDO ortmpl,OrtmplAggDO aggdo)throws BizException{
		  if(ortmpl != null){
			  FArrayList list = new FArrayList();
			 if(OrTplItmTypeEnum.ORTMPL.equals(ortmpl.getEu_ortplitmtp())){
				  OrtmplAggDO tempAgg = CiOrdAppUtils.getIOrtmplRService().findById(ortmpl.getId_srv());
				  /* 01	成组西成药   映射  2  多药品
				     02	草药方剂    映射  4  str 赋值
				     11	复合模板     继续拆分   */
				 if("01".equals(tempAgg.getParentDO().getSd_ortmpltp())){
					 template.setUi_flag("2");
					 template.setName(tempAgg.getParentDO().getName());
					 template.setId(ortmpl.getId_ortmpl());
					 ArryToList(tempAgg.getOrTplNItmDO(),list);
					 template.setItemlist(list);
				 }else if("02".equals(tempAgg.getParentDO().getSd_ortmpltp())){
					 template.setUi_flag("1");
					 template.setName(tempAgg.getParentDO().getName());
					 template.setId(ortmpl.getId_ortmpl());
					 String str = ArryToList(tempAgg.getOrTplNItmDO(),list);
					 template.setStr(str);
					 template.setItemlist(list);
				 }else if("11".equals(tempAgg.getParentDO().getSd_ortmpltp())){
					 getTemplateType(tempAgg.getParentDO().getId_ortmpl());
				 }
				 
				/* template.setId(ortmpl.getId_ortmpl());
				 template.setName(aggdo.getParentDO().getName());
				 template.setUi_flag("1");*/
				 getOrTplNItmDOFArrayList(ortmpl.getId_srv(),template);
			 }else if(OrTplItmTypeEnum.SRV.equals(ortmpl.getEu_ortplitmtp())){
				 if(ortmpl.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG) || ortmpl.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)){
					 template.setUi_flag("3");
					 template.setId(ortmpl.getId_ortmpl());
					 list.add(ortmpl);
					 template.setItemlist(list);
				 }else if(ortmpl.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)){
					 template.setId(ortmpl.getId_ortmpl());
					 template.setName(aggdo.getParentDO().getName());
					 template.setId_boil(ortmpl.getId_boil());
					 template.setId_route(ortmpl.getId_route());
					 template.setId_freq(ortmpl.getId_freq());
					 template.setName_route(ortmpl.getOrtplnitm_route_name());
					 template.setName_boil(ortmpl.getOrtplnitm_boil_name());
					 template.setName_freq(ortmpl.getOrtplnitm_freq_name());
					 template.setUi_flag("4");
					 template.setTemplatetype(FBoolean.TRUE);
					 list.add(ortmpl);
					 template.setItemlist(list);
				 }else{
					 template.setId(ortmpl.getId_ortmpl());
					 template.setName(aggdo.getParentDO().getName());
//					 template.setId_boil(ortmpl.getId_boil());
//					 template.setId_route(ortmpl.getId_route());
//					 template.setId_freq(ortmpl.getId_freq());
//					 template.setName_route(ortmpl.getOrtplnitm_route_name());
//					 template.setName_boil(ortmpl.getOrtplnitm_boil_name());
//					 template.setName_freq(ortmpl.getOrtplnitm_freq_name());
					 template.setUi_flag("4");
			 
					 list.add(ortmpl);
					 template.setItemlist(list);
				 }
				 
			 }else if(OrTplItmTypeEnum.SRVSET.equals(ortmpl.getEu_ortplitmtp())){
				 template.setName(ortmpl.getOrtplnitm_srv_name());
				 template.setId(ortmpl.getId_ortmplitm());
				 template.setUi_flag("1");
				 //template.setItem(Item);
				 template.setItemlist(getOrTplNItmDOSet(ortmpl));
			 }
			
		  }
	  }
	  
	  private  String   ArryToList( OrTplNItmDO[] orTplNItmDO,FArrayList list){
		  String str = "";
		  if(orTplNItmDO != null && orTplNItmDO.length  >0){
			for(OrTplNItmDO item: orTplNItmDO){
				str += ","+item.getOrtplnitm_srv_name();
				list.append(item);
			}
			if(str !=  ""){
				return str.substring(1);
			}
		  }
		  return str;
	  }
	  
	  
	  /**
	   * 
	   * @param id_srv 套id
	   * @param SrvSetName 套名臣
	   * @param id_ortmpl
	   * @return
	   * @throws BizException
	   */
	  private FArrayList getOrTplNItmDOSet(OrTplNItmDO ortmpl)throws BizException{
		  FArrayList list = new FArrayList();
		  //id_srv 是套的 id
		  GetMedSrvItemDOBP qry = new GetMedSrvItemDOBP(ortmpl.getId_srv());
		  MedSrvSetItemDO[] rtn = (MedSrvSetItemDO[])AppFwUtil.getDORstWithDao(qry, MedSrvSetItemDO.class);
		  MappingOrItem(list,rtn,ortmpl);
		  return list;
	  }
	   /**
	    * 套本身
	    * @param ortmpl
	    * @return
	    * @throws BizException
	    */
	   private OrTplNItmDO MappingOrSetItem(OrTplNItmDO ortmpl)throws BizException{
		   MedSrvDO medsrvDO =  CiOrdAppUtils.getMedsrvMDORService().findById(ortmpl.getId_srv());
		   if(medsrvDO != null ){
			   OrTplNItmDO item = new OrTplNItmDO();
				 item.setId_srv(medsrvDO.getId_srv());
				 item.setOrtplnitm_srv_name(medsrvDO.getName());
				 item.setId_ortmpl(ortmpl.getId_ortmpl());
				 item.setId_boil(medsrvDO.getId_boil());
				 item.setId_boildes(medsrvDO.getId_boildes());
				 item.setQuan_med(medsrvDO.getQuan_med());
				 item.setId_freq(medsrvDO.getId_freq());
				 //item.setId_mm(medsrvDO.getId_mm);
				 item.setId_ortmplitm(medsrvDO.getId_srv()+ortmpl.getId_ortmpl());
				 item.setId_route(medsrvDO.getId_route());
				 item.setId_routedes(medsrvDO.getId_routedes());
				 item.setId_srvtp(medsrvDO.getId_srvtp());
				 item.setSd_srvtp(medsrvDO.getSd_srvtp());
				 item.setId_unit_med(medsrvDO.getId_unit_med());
				 item.setOrtplnitm_boildes_name(medsrvDO.getBoil_name());
				 item.setOrtplnitm_freq_name(medsrvDO.getFreq_name());
				 item.setOrtplnitm_route_name(medsrvDO.getRoute_name());
				 item.setOrtplnitm_routedes_name(medsrvDO.getRoutedes_name());
				 item.setOrtplnitm_unit_name(medsrvDO.getMed_name());
				 return item; 
		   }
		   return null;
	   }
	  
	  
      /**
       * 模板是套时 套内明细内容
       * @param list
       * @param rtn 套内集合
       * @param id_ortmpl 模板id
       * @param id_srvset 套id
       */
	  private void MappingOrItem(FArrayList list,MedSrvSetItemDO[] rtn,OrTplNItmDO ortmpl){
		  if(rtn != null && rtn.length > 0){
			 for(MedSrvSetItemDO medSrvset:rtn){
				 OrTplNItmDO item = new OrTplNItmDO();
				 item.setId_srv(medSrvset.getId_srv_itm());
				 item.setOrtplnitm_srv_name(medSrvset.getSrv_name());
				 item.setId_ortmpl(ortmpl.getId_ortmpl());
				 item.setId_boil(medSrvset.getId_boil());
				 item.setId_boildes(medSrvset.getId_boildes());
				 item.setQuan_med(medSrvset.getQuan_medu());
				 item.setId_freq(medSrvset.getId_freq());
				 //item.setId_mm(medSrv.getId_mm);
				 item.setId_ortmplitm(medSrvset.getId_srv_itm()+medSrvset.getId_srv());
				 item.setId_route(medSrvset.getId_route());
				 item.setId_routedes(medSrvset.getId_routedes());
				 item.setId_srvtp(ortmpl.getId_srvtp());
				 item.setSd_srvtp(ortmpl.getSd_srvtp());
				 item.setId_unit_med(medSrvset.getId_medu());
				 item.setOrtplnitm_boildes_name(medSrvset.getBoil_name());
				 item.setOrtplnitm_freq_name(medSrvset.getFreq_name());
				 item.setOrtplnitm_route_name(medSrvset.getRoute_name());
				 item.setOrtplnitm_routedes_name(medSrvset.getRoutedes_name());
				 item.setOrtplnitm_unit_name(medSrvset.getMedu_name());
				 item.setFg_edit(medSrvset.getFg_edit());
				 item.setIdentical_ortmpl(medSrvset.getId_srv());
				 item.setId_srv_set(medSrvset.getId_srv());
				 item.setOrtplnitm_mm_name(ortmpl.getOrtplnitm_srv_name());////借用这个字段存套的 名称  需求还在 ，待优化
				 item.setFg_clinical(medSrvset.getFg_clinical());//套内临床标识
				 //item.setOrtplnitm_boil_code(medSrv.getOrtplnitm_boil_code);
				 //item.setId_boil(Id_boil);
				 //todo 继续
				 list.add(item);
			 }
		  }
	  }
	  
	  /**
	   * 
	   * @param id_ortmpl
	   * @return
	   * @throws BizException
	   */
	  private  void getOrTplNItmDOFArrayList(String id_ortmpl,NewOrderTemplateDTO  template)throws BizException{
		  FArrayList list = new FArrayList();
		  String str = "";
		  String whereStr =  OrTplNItmDO.ID_ORTMPL+" ='"+id_ortmpl+"'";
		  OrTplNItmDO[] temp =  CiOrdAppUtils.getIOrTplNItmDORService().find(whereStr, OrTplNItmDO.ID_ORTMPL, FBoolean.FALSE);
	      for(OrTplNItmDO item :temp){
	    	  list.add(item);
	    	  str += ","+item.getOrtplnitm_srvtp_name();
	      }
	      if(str !=""){
	    	  template.setStr(str.substring(1));
	      }
	      template.setItemlist(list);
	  }
	  
	//==================================================================================== 
	/**
	 * 旧模板的逻辑
	 * @param id_srvortpl
	 * @return
	 * @throws BizException
	 */
	public OrderTemplateDTO getSrvortplitemAggDOS(String id_srvortpl) throws BizException{
		if(id_srvortpl == null ) throw new  BizException("parameter :id_srvortpl is null ");
		 OrderTemplateDTO  orderTemplateDto = new OrderTemplateDTO();
		 FMap  srvoritemAgg = new FMap();
		 SrvortplitemAggDO[] srvortplItem =  CiOrdAppUtils.getISrvortplitemRService().find("a0.ds ='0' and  a0.id_srvortpl ='"+id_srvortpl+"'", "id_srvortpl", FBoolean.FALSE);
	     if(srvortplItem != null && srvortplItem.length>0){
	    	 //页面显示 逻辑 ，
	    	  FArrayList list = srvOrTplItem(srvortplItem);
	    	 srvoritemAgg.put("SrvortplitemAggDO", list);
	     }
	   
	     orderTemplateDto.setFreqdefdo(freqMap);
	     orderTemplateDto.setMeasdocdo(measDocMap);
	     orderTemplateDto.setSrvortplitemaggdo(srvoritemAgg);
		 return  orderTemplateDto;
	}
	
	/**
	 *  Ui_flag  1 :套 ,  2:(多药品)药品, 3:(单一药品),  4 :其它
	 * @param srvortplItem
	 */
	private FArrayList  srvOrTplItem(SrvortplitemAggDO[] srvortplItem)throws BizException{
		 FArrayList  list = new FArrayList();
		for(SrvortplitemAggDO item :srvortplItem){
			//项目是否选中
			setFgcheck(item );
			
			// 1 :套
			if(item.getParentDO().getFg_set() != null && 
					item.getParentDO().getFg_set().booleanValue()){
				item.getParentDO().setUi_flag("1");
				// 从bd_srv 取数据（需求讨论的）
				getBdSrvSetItem(item);
				
			}			
			//2:(多药品)药品,
			else if(item.getParentDO().getSd_srvtp() != null && 
					item.getParentDO().getSd_srvtp().startsWith("01") && 
					item.getOrTplItmDtDO().length>1){
				item.getParentDO().setUi_flag("2");
				item.getParentDO().setName_route(item.getOrTplItmDtDO()[0].getName_route());
			}			
			//3:(单一药品), 
			else if(item.getParentDO().getSd_srvtp() != null && 
					item.getParentDO().getSd_srvtp().startsWith("01") && 
					item.getOrTplItmDtDO().length==1){
				item.getParentDO().setUi_flag("3");
			}else{
				//4 :其它
				item.getParentDO().setUi_flag("4");
			}
			
			list.add(item);
		}
		return list;
	}
	
	// 判断是否选中
	private void setFgcheck(SrvortplitemAggDO item ){
		
		if(item != null && item.getOrTplItmDtDO().length >0){
			for(OrTplItmDtDO itemdo:item.getOrTplItmDtDO()){
				itemdo.setFg_check(FBoolean.FALSE);
			}
		}
	}
  // 服务套 项目
  private void getBdSrvSetItem(SrvortplitemAggDO item)throws BizException{
	  if(item != null && item.getParentDO().getId_srv() != null 
			  && item.getParentDO().getFg_set().booleanValue()){
		    SrvSetItemQry srvsetitemQry = new SrvSetItemQry(item.getParentDO().getId_srv());
			 MedSrvDO[] medSrvList = (MedSrvDO[])AppFwUtil.getDORstWithDao(srvsetitemQry, MedSrvDO.class);
			 OrTplItmDtDO[] itemDOArray =  new OrTplItmDtDO[medSrvList.length];
			 int i = 0;
			  for(MedSrvDO medrvdo:medSrvList){
				  OrTplItmDtDO   ortplitem= new OrTplItmDtDO(); 
				  ortplitem.setId_srvortplorsrv(item.getParentDO().getId_srvortplor());
				  ortplitem.setId_srv(medrvdo.getId_srv());
				  ortplitem.setId_srvtp(medrvdo.getId_srvtp());
				  ortplitem.setSd_srvtp(medrvdo.getSd_srvtp());
				  ortplitem.setId_route(medrvdo.getId_route());
				  ortplitem.setId_freq(medrvdo.getId_freq());
				  ortplitem.setCode_freq(medrvdo.getFreq_code());
				  ortplitem.setCode_route(medrvdo.getRoute_code());
				  ortplitem.setId_unit_med(medrvdo.getId_unit_med());
				  ortplitem.setQuan_med(medrvdo.getQuan_med());
				  ortplitem.setName_srv(medrvdo.getName());
				  
				  ortplitem.setFg_check(setFgSetCheck(item,medrvdo.getId_srv()));
				  itemDOArray[i] = ortplitem;
				  i++;
			  }
			 item.setOrTplItmDtDO(itemDOArray);
	  }
  } 
	
  /**
   * 项目是否选中	
   * @param item
   * @param id_srv
   * @return
   */
  private FBoolean setFgSetCheck(SrvortplitemAggDO item,String id_srv){
	  FBoolean isBoolean = FBoolean.FALSE;
	  
	    for(OrTplItmSetDO setDO:item.getOrTplItmSetDO()){
	    	if(setDO.getId_srv() == id_srv){
	    		isBoolean = FBoolean.TRUE;
	    	}
	    }
	  return isBoolean;
  }
   /**
    * 频次集合
    * @throws BizException
    */
	private void getFreqDefDO()throws BizException{
	IFreqdefRService freqService =ServiceFinder.find(IFreqdefRService.class);
	FreqdefAggDO[] freqDef = freqService.find(" fg_use_op='Y' ", "Name", FBoolean.FALSE);
		if(freqDef != null ){
			this.freqMap = new FMap();
			FArrayList freqdo =  new FArrayList();
		   for(FreqdefAggDO freq:freqDef){
			   FreqDefDO newFreq = new FreqDefDO();
			   newFreq.setId_freq(freq.getParentDO().getId_freq());
			   newFreq.setSd_frequnitct(freq.getParentDO().getSd_frequnitct());
			   newFreq.setFre_name(freq.getParentDO().getFre_name());
			   newFreq.setName(freq.getParentDO().getName());
			   newFreq.setFreqct(freq.getParentDO().getFreqct());
			   newFreq.setFrequnitct(freq.getParentDO().getFrequnitct());
			   freqdo.add(newFreq);
		   }	
		   this.freqMap.put("FreqDefDO", freqdo);
		}
	}
	/**
	 * 单位集合
	 * @throws BizException
	 */
	private void getMeasDocDO()throws BizException{
		DAFacade daFacade = new DAFacade();
		//String sql = "select   *  from bd_measdoc ";
		IMeasdocRService measService =ServiceFinder.find(IMeasdocRService.class);
		MeasDocDO[] measDoc = measService.find("1=1", "", FBoolean.FALSE);
		//List<MeasDocDO> measDoc = (List<MeasDocDO>)daFacade.execQuery(sql, new BeanListHandler(MeasDocDO.class));
        if(measDoc != null && measDoc.length >0){
        	this.measDocMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(MeasDocDO item :measDoc)
        	{
        		MeasDocDO newMeasDoc = new MeasDocDO();
        		newMeasDoc.setId_measdoc(item.getId_measdoc());
        		newMeasDoc.setMeasdoc_name(item.getMeasdoc_name());
        		measlist.add(newMeasDoc);
        	}
        	this.measDocMap.put("MeasDocDO",measlist);
        }
	}
	/**
	 * 煎法集合
	 * @throws BizException
	 */
	private void getBoilDO()throws BizException{
		DAFacade daFacade = new DAFacade();
		//String sql = "select   *  from bd_measdoc ";
		ICherbboilmdMDORService measService =ServiceFinder.find(ICherbboilmdMDORService.class);
		CHerbBoilMdDO[] measDoc = measService.find("1=1", "", FBoolean.FALSE);
		//List<MeasDocDO> measDoc = (List<MeasDocDO>)daFacade.execQuery(sql, new BeanListHandler(MeasDocDO.class));
        if(measDoc != null && measDoc.length >0){
        	this.boilMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(CHerbBoilMdDO item :measDoc)
        	{
        		CHerbBoilMdDO mddo = new CHerbBoilMdDO();
        		mddo.setId_boil(item.getId_boil());
        		mddo.setName(item.getName());
        		measlist.add(mddo);
        	}
        	this.boilMap.put("CHerbBoilMdDO",measlist);
        }
	}
	/**
	 * 用法集合
	 * @throws BizException
	 */
	private void getRouteDO(OrtmplAggDO ortmplAgg)throws BizException{
		
		MedUsageDO[] medUsages = null;
		OrTplNItmDO[] orTplNItms = ortmplAgg.getOrTplNItmDO();
		if(orTplNItms != null && orTplNItms.length > 0) {
		    String sd_srvtp = orTplNItms[0].getSd_srvtp();
		  // 如果是草药，根据草药固定的剂型查询剂型关联的用法
			if(CiOrdUtils.isHerbOrder(sd_srvtp)){
				DAFacade daFacade = new DAFacade();
				String sql = "select distinct a.*  from bd_route a "
						+ "	left join bd_route_dosage_ref b on a.id_route = b.id_route"
						+ " where b.id_dosage = '%s' and  b.ds=0 and a.ds= 0";
				sql = String.format(sql, IBdSrvDictCodeConst.ID_DOSAGE_HERB);
				List<MedUsageDO> medUsageList = (List<MedUsageDO>)daFacade.execQuery(sql, new BeanListHandler(MedUsageDO.class));
				medUsages = medUsageList.toArray(new MedUsageDO[medUsageList.size()]);
				
		}else{
			IMedusageRService measService =ServiceFinder.find(IMedusageRService.class);
			medUsages = measService.find("1=1", "", FBoolean.FALSE);
		}
		
        if(medUsages != null && medUsages.length >0){
        	this.routeMap = new FMap(); 
        	FArrayList measlist =  new FArrayList();
        	for(MedUsageDO medUsage :medUsages)
        	{
        		MedUsageDO usage = new MedUsageDO();
        		usage.setId_route(medUsage.getId_route());
        		usage.setName(usage.getName());
        		measlist.add(usage);
        	}
        	this.routeMap.put("MedUsageDO",measlist);
        }
	  }
	}
	/**
	 * 价格长度处理,四舍五入
	 * @param price
	 * @return
	 */
	private FDouble formatePriceLength(FDouble price){
		//四舍五入
		if(CiOrdUtils.isEmpty(price)) return new FDouble(0.00);
		return price.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}

	public FMap getFreqMap() {
		return freqMap;
	}

	public FMap getBoilMap() {
		return boilMap;
	}

	public FMap getMeasDocMap() {
		return measDocMap;
	}

	public FMap getRouteMap() {
		return routeMap;
	}
	
}
