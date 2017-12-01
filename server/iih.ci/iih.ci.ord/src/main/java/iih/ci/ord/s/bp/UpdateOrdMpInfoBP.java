package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.mm.meterial.d.MeterialDO;
import iih.bd.mm.meterial.i.IMeterialMDORService;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.FeeReverseType;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.ciorder.d.desc.OrdSrvDODesc;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.ICiorderSrvDOCudService;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import iih.ci.ord.ciorder.s.CiorderMDOCrudServiceImpl;
import iih.ci.ord.ciorder.s.CiorderSrvDOCrudServiceImpl;
import iih.ci.ord.dto.orsrvadd.d.OrSrvAddDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.s.OrdsrvmmCrudServiceImpl;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import iih.ci.ord.pres.i.IPresRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.service.time.TimeService;
import xap.mw.core.service.time.impl.TimeServiceImpl;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class UpdateOrdMpInfoBP {	
	
/*	*//**
	 * 发药、退药回写
	 * @param preses
	 * @return
	 * @throws BizException
	 *//*
	public boolean updateOrdMpInfo(DispenseDTO[] preses) throws BizException{
		if(preses == null || preses.length == 0)
			return false;
		
		Map<String,CiPresDO> presMap=getCipresMap();
		Map<String,CiOrderDO> ordMap=getOrdMap();
		Map<String,OrdSrvDO> ordsrvMap=getOrdsrvMap();
		List<CiPresDO> presList = new ArrayList<CiPresDO>();
		List<CiOrderDO> ordList = new ArrayList<CiOrderDO>();
		List<OrdSrvDO> ordsrvList = new ArrayList<OrdSrvDO>();
		
		for(DispenseDTO pres:preses){
			CiPresDO presDO=presMap.get(pres.getId_pres());
			if(presDO!=null){
				presDO.setId_backtp(pres.getId_backtp());		
				presDO.setFg_dispense(pres.getFg_dispense());
				presDO.setFg_back(pres.getFg_back());
				presDO.setStatus(DOStatus.UPDATED);			
				presList.add(presDO);
			}
			FArrayList drugs=pres.getDruglist();
			for(Object obj:drugs){
				OpeDgAppdtDTO drug=(OpeDgAppdtDTO)obj;
				CiOrderDO order=ordMap.get(drug.getId_or());
				OrdSrvDO ordsrv=ordsrvMap.get(drug.getId_ordsrv());
				if(order!=null && !ordList.contains(order)){//医嘱状态
					if(order.getSd_su_or()!=ICiDictCodeConst.SD_SU_MP_PERFORMED){
						order.setId_su_or(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
						order.setSd_su_or(ICiDictCodeConst.SD_SU_MP_PERFORMED);
					}
//					if(!(order.getFg_mp().booleanValue())){//执行标识
//						order.setfg(FBoolean.TRUE);
//					}
//					order.setDt_last_mp(new FDateTime());//最近执行时间
					order.setStatus(DOStatus.UPDATED);
					ordList.add(order);
				}
				if(ordsrv!=null){
					ordsrv.setId_org_mp(drug.getId_or());
					ordsrv.setId_dep_mp(null);
					ordsrv.setId_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
					ordsrv.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED);
					ordsrv.setDt_last_mp(new FDateTime());
					ordsrv.setStatus(DOStatus.UPDATED);
					ordsrvList.add(ordsrv);
				}
			}
		}
		if(presList.size() > 0)
			updatePres(presList);			
		if(ordList.size() > 0)
			updateOrd(ordList);
		if(ordsrvList.size() > 0)
			updateOrdSrv(ordsrvList);
		return true;
	}*/
	
	/**
	 * 
	 * @param orsrvids
	 * @param id_su_bl
	 * @param sd_su_bl
	 * @param dt_last_cg
	 * @return
	 * @throws BizException
	 */
	public FBoolean WriteBackCiOrSrvInfo2(String[] orsrvids,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL) throws BizException{
		if(orsrvids == null || orsrvids.length ==0) throw new BizException("传入的参数 orsrvids[] 数组为空");
	    if(orsrvids[0] == null) throw new BizException("传入的参数 orsrvids[null] 数组值为空");
		long startTime = System.currentTimeMillis();
		OrdSrvDO[] srvs = CiOrdAppUtils.getOrSrvQryService().findByIds(orsrvids, FBoolean.TRUE);
		if(!CiOrdUtils.isEmpty(srvs)){
			for(OrdSrvDO srv : srvs){
				srv.setId_su_bl(id_su_bl);
				srv.setSd_su_bl(sd_su_bl);
				srv.setDt_last_cg(dt_last_cg);
				srv.setEu_feereversetp(BLCGCANCEL);
				if(FeeReverseType.BLCGCANCEL==BLCGCANCEL){
					srv.setId_pres("~");
				}
			}
			CiOrdAppUtils.getOrSrvService().update(srvs);
			String[] id_ors = getArrayOfIdOrs(srvs);
			if(!CiOrdUtils.isEmpty(id_ors)){
				CiorderAggDO[] orderAggs = CiOrdAppUtils.getOrAggQryService().findByBIds(id_ors, FBoolean.FALSE);
				if(!CiOrdUtils.isEmpty(orderAggs)){
					List<CiOrderDO> orderdos = new ArrayList<CiOrderDO>();
					for(CiorderAggDO aggdo : orderAggs){
						CiOrderDO orderdo = aggdo.getParentDO();
						OrdSrvDO[] srvdos = aggdo.getOrdSrvDO();
						if(orderdo.getSd_su_or() == ICiDictCodeConst.SD_SU_OPEN){
							throw new BizRuntimeException("医嘱开立状态不允许进行费用记账操作！");
						}
						//no：未记账个数，yes：已记账个数，back：已退费个数
						int no=0,yes=0,back=0;
						for(OrdSrvDO srv:srvdos){
							//不计费的不参与比较
							if(!srv.getFg_bl().booleanValue()){
								continue;
							}
							String sd_bl = srv.getSd_su_bl();
							if(sd_bl==null||sd_bl.equals("0")){//未记账
								no++;
							}else if(sd_bl.equals("1")){//已记账
								yes++;
							}else if(sd_bl.equals("2")){//退费
								back++;
							}
						}
						if(yes>0){//有一条已记账，医嘱的计费状态为已记账
							orderdo.setSd_su_bl("1");
							orderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_ACCOUNT_ID);
						}else if(no>0&&yes==0&&back==0){//全部未记账，医嘱的计费状态为未记账
							orderdo.setSd_su_bl("0");
							orderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
						}else if(back>0&&no==0&&yes==0){//全部已退费，医嘱的计费状态为已退费
							orderdo.setSd_su_bl("2");
							orderdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_REFOUND_ID);
						}else{
							orderdo.setSd_su_bl("99");//计费异常
							orderdo.setId_su_bl("");
						}
						orderdo.setStatus(DOStatus.UPDATED);
						orderdo.setEu_feereversetp(BLCGCANCEL);
						orderdos.add(orderdo);
					}
					if(orderdos.size()>0){
						CiOrdAppUtils.getOrService().save(orderdos.toArray(new CiOrderDO[orderdos.size()]));
					}
				}
			}
		
			return FBoolean.TRUE;
		}
		CiOrdUtils.LogerOutInfo(" 类  UpdateOrdMpInfoBPle  方法 WriteBackCiOrSrvInfo 耗时"+(System.currentTimeMillis()- startTime));
		return FBoolean.FALSE;
	}
	
	/**
	 * 
	 * @param orsrvids
	 * @param id_su_bl
	 * @param sd_su_bl
	 * @param dt_last_cg
	 * @return
	 * @throws BizException
	 */
	public FBoolean WriteBackCiOrSrvInfo(String[] orsrvids,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg) throws BizException{
		if(orsrvids == null || orsrvids.length ==0) throw new BizException("传入的参数 orsrvids[] 数组为空");
	    if(orsrvids[0] == null) throw new BizException("传入的参数 orsrvids[null] 数组值为空");
		long startTime = System.currentTimeMillis();
		OrdSrvDO[] srvs = CiOrdAppUtils.getOrSrvQryService().findByIds(orsrvids, FBoolean.TRUE);
		if(!CiOrdUtils.isEmpty(srvs)){
			for(OrdSrvDO srv : srvs){
				srv.setId_su_bl(id_su_bl);
				srv.setSd_su_bl(sd_su_bl);
				srv.setDt_last_cg(dt_last_cg);

			}
			CiOrdAppUtils.getOrSrvService().update(srvs);
			String[] id_ors = getArrayOfIdOrs(srvs);
			if(!CiOrdUtils.isEmpty(id_ors)){
				CiorderAggDO[] orderAggs = CiOrdAppUtils.getOrAggQryService().findByBIds(id_ors, FBoolean.FALSE);
				if(!CiOrdUtils.isEmpty(orderAggs)){
					List<CiOrderDO> orderdos = new ArrayList<CiOrderDO>();
					for(CiorderAggDO aggdo : orderAggs){
						CiOrderDO orderdo = aggdo.getParentDO();
						OrdSrvDO[] srvdos = aggdo.getOrdSrvDO();
						if(orderdo.getSd_su_or() == ICiDictCodeConst.SD_SU_OPEN){
							throw new BizRuntimeException("医嘱开立状态不允许进行费用记账操作！");
						}
						//no：未记账个数，yes：已记账个数，back：已退费个数
						int no=0,yes=0,back=0;
						for(OrdSrvDO srv:srvdos){
							//不计费的不参与比较
							if(!srv.getFg_bl().booleanValue()){
								continue;
							}
							String sd_bl = srv.getSd_su_bl();
							if(sd_bl==null||sd_bl.equals("0")){//未记账
								no++;
							}else if(sd_bl.equals("1")){//已记账
								yes++;
							}else if(sd_bl.equals("2")){//退费
								back++;
							}
						}
						if(yes>0){//有一条已记账，医嘱的计费状态为已记账
							orderdo.setSd_su_bl("1");
						}else if(no>0&&yes==0&&back==0){//全部未记账，医嘱的计费状态为未记账
							orderdo.setSd_su_bl("0");
						}else if(back>0&&no==0&&yes==0){//全部已退费，医嘱的计费状态为已退费
							orderdo.setSd_su_bl("2");
						}else{
							orderdo.setSd_su_bl("99");//计费异常
						}
						orderdo.setStatus(DOStatus.UPDATED);
						orderdos.add(orderdo);
					}
					if(orderdos.size()>0){
						CiOrdAppUtils.getOrService().save(orderdos.toArray(new CiOrderDO[orderdos.size()]));
					}
				}
			}
			return FBoolean.TRUE;
		}
		CiOrdUtils.LogerOutInfo(" 类  UpdateOrdMpInfoBPle  方法 WriteBackCiOrSrvInfo 耗时"+(System.currentTimeMillis()- startTime));
		return FBoolean.FALSE;
	}
	/**
	 * 费用回写
	 * @param orsrvids
	 * @param sd_su_cg
	 * @return
	 * @throws BizException
	 */
	public FBoolean old_WriteBackCiOrSrvInfo(String[] orsrvids,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL ) throws BizException{
		if(orsrvids == null || orsrvids.length ==0) throw new BizException("传入的参数 orsrvids[] 数组为空");
	    if(orsrvids[0] == null) throw new BizException("传入的参数 orsrvids[null] 数组值为空");
		long startTime = System.currentTimeMillis();
		String orderIds = getOrderIds(orsrvids);
		//类型  门诊  急诊 留观  住院
		String entTp = JudgeOrderStatus(orderIds);
		if(IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(entTp) ||
		   IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(entTp) ||
		   IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(entTp)){
			//门诊 急诊  体检
			OPUpdataOrderAndSrvStauts(orderIds,orsrvids, id_su_bl, sd_su_bl,dt_last_cg,BLCGCANCEL);
		}else{
			//住院
			IPUpdataOrderAndSrvStauts(orderIds,orsrvids, id_su_bl, sd_su_bl,dt_last_cg,BLCGCANCEL);
		}
		/*OrdSrvDO[] cirsrvs = this.getCiSrvOr(orsrvids);
 
		//判断医嘱的状态是否签署后 和医嘱的就诊类型
	 
		//医嘱集合的主键  判断更新医嘱使用
		Map map   =new HashMap();
		if(cirsrvs != null && cirsrvs.length>0){
			TimeService timeService = new TimeServiceImpl();
			String time = timeService.getUFDateTime().toStdString();
			for(OrdSrvDO  orsrv:cirsrvs){
				//退费时 判断是否已经执行，已经执行的不能退费
				if(ICiDictCodeConst.SD_SU_BL_REFOUND.equals(sd_su_bl) && !orsrv.getFg_feertnable().booleanValue()){
					throw new BizException("已经执行的不能退费");
				}
				orsrv.setSd_su_bl(sd_su_bl);
				orsrv.setId_su_bl(id_su_bl);
				if(dt_last_cg != null){
					orsrv.setDt_last_cg(dt_last_cg);
				}
				orsrv.setStatus(DOStatus.UPDATED);
				if(!map.containsKey(orsrv.getId_or())){
					map.put(orsrv.getId_or(), orsrv.getId_or());
				};
			}
			//// 逻辑不完善 ，没有更新 医嘱的主表  需求在谈论 todo
			*//**
			 * 经过讨论，更新医嘱主表的sd_su_bl 逻辑如下  王琪
			 * 1 收费 正向 逻辑 当项目中任一一条记录进行收费操作，更新主表 sd_su_bl 为 收费状态 
			 * 2 退费 逻辑  退费流程中 （要么不改，要改要判断所有项目全部退费操作）
			 * 
			 *//*
			//更新医嘱项目
			ICiorderSrvDOCudService ordsrvRService=(ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class.getName());
			ordsrvRService.save(cirsrvs);
			//更新医嘱主表
			//if(ICiDictCodeConst.SD_SU_BL_REFOUND != sd_su_bl){
							 
				UpdateOrderSuSuBl(map,sd_su_bl,id_su_bl);
			//}
			// 组合计价模式，需要更新未回写医嘱项目的计费转态
			getOrdSrvDO(cirsrvs);
		}else{
		  //throw new BizException("传入的参数 orsrvids[] 数组为空");
		}*/
		getOrdSrvDOcombinationFree(orderIds,id_su_bl, sd_su_bl,dt_last_cg);
		CiOrdUtils.LogerOutInfo(" 类  UpdateOrdMpInfoBPle  方法 WriteBackCiOrSrvInfo 耗时"+(System.currentTimeMillis()- startTime));
		return FBoolean.TRUE;
	}
	/**
	 * 门诊 更新医嘱和医嘱项目的状态
	 * @param cirsrvs
	 * @return
	 */
	private FBoolean OPUpdataOrderAndSrvStauts(String orderIds,String[] orsrvids,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL)throws BizException{
		/*门诊记账状态逻辑：   20170330   陈妍妍 提出需求  李政 修改   TODO 
		1、医嘱-记账状态
		1）医嘱下所有SRV都是【未记账】状态时，医嘱为【未记账】；医嘱保存处理
		2）医嘱下所有SRV都是【已退费】状态时，医嘱为【已退费】；
		3）医嘱下只要有一条SRV为【已记账】状态时，医嘱为【已记账】
		2、srv -记账状态
		1）SRV未记账时，记账状态为【未记账】医嘱保存处理
		2）SRV已记账后，记账状态为【已记账】
		3）SRV全部退费后，记账状态为【已退费】*/
		//费用传过来的 医嘱项目个数
		Map<String, Integer> map = new HashMap();
		//医嘱项目集合
		 Map<String,OrdSrvDO> ordSrvDOMap =  getOrSrvDOS(orderIds);
		
		 List<OrdSrvDO>  tempOrdSrvDO = new  ArrayList();
		 if(orsrvids != null && orsrvids.length > 0){
			 for(String idsrv:orsrvids){
				 OrdSrvDO  orsrv = ordSrvDOMap.get(idsrv);
				  if(orsrv == null) continue;
				//退费时 判断是否已经执行，已经执行的不能退费
					if(ICiDictCodeConst.SD_SU_BL_REFOUND.equals(sd_su_bl) && !orsrv.getFg_feertnable().booleanValue()){
						throw new BizException("已经执行的不能退费");
					}
					orsrv.setSd_su_bl(sd_su_bl);
					orsrv.setId_su_bl(id_su_bl);
					orsrv.setEu_feereversetp(BLCGCANCEL);
					if(dt_last_cg != null){
						orsrv.setDt_last_cg(dt_last_cg);
					}
					orsrv.setStatus(DOStatus.UPDATED);
					tempOrdSrvDO.add(orsrv);
					if(map.containsKey(orsrv.getId_or())){
						int num = map.get(orsrv.getId_or());
						map.put(orsrv.getId_or(), num+1);
					}else{
						map.put(orsrv.getId_or(),1);
					}	
			 }
			//更新医嘱项目
			ICiorderSrvDOCudService ordsrvRService=(ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class.getName());
		    ordsrvRService.save(tempOrdSrvDO.toArray(new OrdSrvDO[tempOrdSrvDO.size()]));
		  // 更新医嘱
		    if(BLCGCANCEL == FeeReverseType.BLCGCANCEL){
		    	JudgeOrderSdSuBlCALBack(orderIds,map, id_su_bl, sd_su_bl,dt_last_cg,BLCGCANCEL);
		    }else{
		      JudgeOrderSdSuBl(orderIds,map, id_su_bl, sd_su_bl,dt_last_cg,BLCGCANCEL);
		    }
		  
		 }
		return FBoolean.FALSE;
	}
    /**
     * 判断医嘱状态
     * @param orderIds
     * @param orsrvNum
     * @param id_su_bl
     * @param sd_su_bl
     * @param dt_last_cg
     * @throws BizException
     */
	private void JudgeOrderSdSuBl(String orderIds,Map orsrvNum,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL)throws BizException{
		//医嘱集合
		CiOrderDO[] ciOrder= getCiOrders(orderIds);
		//医嘱下的项目个数
		Map OrderSrvNumMap = getOrderCountSrv(orderIds);
		if(ciOrder != null && ciOrder.length >0){
			for(CiOrderDO order:ciOrder){
				
				if(OrderSrvNumMap.get(order.getId_or()) == orsrvNum.get(order.getId_or())){
						 order.setSd_su_bl(sd_su_bl);
						 order.setId_su_bl(id_su_bl);
						 order.setStatus(DOStatus.UPDATED);
					 
				}else{
				   if("1".equals(sd_su_bl)){
					     order.setSd_su_bl(sd_su_bl);
						 order.setId_su_bl(id_su_bl);
						 order.setStatus(DOStatus.UPDATED);  
				   }
				   //退费时 
				   if("2".equals(sd_su_bl)){
					   if(SetOrderSdSuBlStatus(order)==FBoolean.FALSE){
						   order.setSd_su_bl(sd_su_bl);
						   order.setId_su_bl(id_su_bl);
						   order.setStatus(DOStatus.UPDATED);   
					   }    
				   }
				}
			}
			CiOrdAppUtils.getOrService().save(ciOrder);
		}
	}
	/**
     * 判断医嘱状态
     * @param orderIds
     * @param orsrvNum
     * @param id_su_bl
     * @param sd_su_bl
     * @param dt_last_cg
     * @throws BizException
     */
	private void JudgeOrderSdSuBlCALBack(String orderIds,Map orsrvNum,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL)throws BizException{
		//医嘱集合
		CiOrderDO[] ciOrder= getCiOrders(orderIds);
		//医嘱下的项目个数
		Map OrderSrvNumMap = getOrderCountSrv(orderIds);
		if(ciOrder != null && ciOrder.length >0){
			for(CiOrderDO order:ciOrder){
			 
		       if(SetOrderEUfeereversetpStatus(order)==FBoolean.TRUE){
			     order.setEu_feereversetp(BLCGCANCEL);
				}
				if(OrderSrvNumMap.get(order.getId_or()) == orsrvNum.get(order.getId_or())){
						 order.setSd_su_bl(sd_su_bl);
						 order.setId_su_bl(id_su_bl);
						 order.setEu_feereversetp(BLCGCANCEL);
						 order.setStatus(DOStatus.UPDATED);
					 
				}else{
				   if("1".equals(sd_su_bl)){
					     order.setSd_su_bl(sd_su_bl);
						 order.setId_su_bl(id_su_bl);
						 order.setStatus(DOStatus.UPDATED);  
				   }
				   //退费时 
				 if("2".equals(sd_su_bl)){
					   if(SetOrderSdSuBlStatus(order)==FBoolean.FALSE){
						   order.setSd_su_bl(sd_su_bl);
						   order.setId_su_bl(id_su_bl);
						   order.setStatus(DOStatus.UPDATED);   
					   }    
				   }
				}
			}
			CiOrdAppUtils.getOrService().save(ciOrder);
		}
	}
	/**
	 *医嘱的记账状态
	 * @param order
	 */
	private FBoolean SetOrderSdSuBlStatus(CiOrderDO order)throws BizException{
		if(order != null && order.getId_or() != null){
			String  whereStr = " id_or = '"+order.getId_or()+"' and sd_su_bl ='1' ";
			OrdSrvDO[]  ordsrvs = CiOrdAppUtils.getOrSrvQryService().find(whereStr, "id_or", FBoolean.FALSE);
		   if(ordsrvs != null && ordsrvs.length >0){
			  return FBoolean.TRUE; 
		   }
		}
		return FBoolean.FALSE;
	}
	/**
	 *医嘱的记账状态
	 * @param order
	 */
	private FBoolean SetOrderEUfeereversetpStatus(CiOrderDO order)throws BizException{
		if(order != null && order.getId_or() != null){
			String  whereStr = " id_or = '"+order.getId_or()+"'";
			OrdSrvDO[]  ordsrvs = CiOrdAppUtils.getOrSrvQryService().find(whereStr, "id_or", FBoolean.FALSE);
		   
			if(ordsrvs != null && ordsrvs.length >0){
			  int num =0;
			  for(OrdSrvDO ordsrvdo:ordsrvs){
				  if(FeeReverseType.BLCGCANCEL.equals(ordsrvdo.getEu_feereversetp())){
					  num++;
				  }
			  }
			  if(num==ordsrvs.length){
				  return FBoolean.TRUE; 
			  }
			  
		   }
		}
		return FBoolean.FALSE;
	}
	
	 
	/**
	 * 住院 更新医嘱和医嘱项目的状态
	 * @param cirsrvs
	 * @return
	 */
	private FBoolean IPUpdataOrderAndSrvStauts(String orderIds,String[] orsrvids,String id_su_bl,String sd_su_bl,FDateTime dt_last_cg,Integer BLCGCANCEL)throws BizException{
		/*门诊记账状态逻辑：   20170330   陈妍妍 提出需求  李政 修改   TODO 
		1、医嘱-记账状态
		1）医嘱下所有SRV都是【未记账】状态时，医嘱为【未记账】；医嘱保存处理
		2）医嘱下所有SRV都是【已退费】状态时，医嘱为【已退费】；
		3）医嘱下只要有一条SRV为【已记账】状态时，医嘱为【已记账】
		2、srv -记账状态
		1）SRV未记账时，记账状态为【未记账】医嘱保存处理
		2）SRV已记账后，记账状态为【已记账】
		3）SRV全部退费后，记账状态为【已退费】*/
		//费用传过来的 医嘱项目个数
		Map<String, Integer> map = new HashMap();
		//医嘱项目集合
		 Map<String,OrdSrvDO> ordSrvDOMap =  getOrSrvDOS(orderIds);
		
		 List<OrdSrvDO>  tempOrdSrvDO = new  ArrayList();
		 if(orsrvids != null && orsrvids.length > 0){
			 for(String idsrv:orsrvids){
				 OrdSrvDO  orsrv = ordSrvDOMap.get(idsrv);
				 if(orsrv == null) continue;
				//退费时 判断是否已经执行，已经执行的不能退费
					if(ICiDictCodeConst.SD_SU_BL_REFOUND.equals(sd_su_bl) && !orsrv.getFg_feertnable().booleanValue()){
						throw new BizException("已经执行的不能退费");
					}
					orsrv.setSd_su_bl(sd_su_bl);
					orsrv.setId_su_bl(id_su_bl);
					if(dt_last_cg != null){
						orsrv.setDt_last_cg(dt_last_cg);
					}
					orsrv.setStatus(DOStatus.UPDATED);
					tempOrdSrvDO.add(orsrv);
					if(map.containsKey(orsrv.getId_or())){
						int num = map.get(orsrv.getId_or());
						map.put(orsrv.getId_or(), num+1);
					}else{
						map.put(orsrv.getId_or(),1);
					}	
			 }
			//更新医嘱项目
			ICiorderSrvDOCudService ordsrvRService=(ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class.getName());
		    ordsrvRService.save(tempOrdSrvDO.toArray(new OrdSrvDO[tempOrdSrvDO.size()]));
		    // 更新医嘱
		    JudgeOrderSdSuBl(orderIds,map, id_su_bl, sd_su_bl,dt_last_cg,BLCGCANCEL);
		 }
		return FBoolean.FALSE;
	}
	
	/**
	 * 验证医嘱状态  门诊 急诊 体检  没有签署的不能计费
	 * 判断医嘱状态  开立的不能回写 唐禅意的bug
	 * @param cirsrvs
	 * @return  String 医嘱的就诊类型
	 */
	private  String  JudgeOrderStatus(String  ids)throws BizException{
	  if(ids != null && ids.length() >0){
		  Map entTpMap = new  HashMap();
		  CiOrderDO[] ciOrderDO = getCiOrders(ids);
		  if(ciOrderDO != null && ciOrderDO.length>0){
			 for(CiOrderDO icord: ciOrderDO){
				 entTpMap.put(icord.getCode_entp(), icord.getCode_entp());
				 if (icord.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP)
							|| icord.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)
							|| icord.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_PE)){
					 if(icord.getSd_su_or().equals(ICiDictCodeConst.SD_SU_OPEN)){
						 throw new BizException("医嘱： "+icord.getName_or() +" 现在非签署状态 不能计费");
					 }
				 } 
			 } 
		  }  
		 return  IsJudgeEntTp(entTpMap);
	  }
	  return  null;
	}
	
/**
 * 判断医嘱 上的就诊类型  
 *  SD_CODE_ENTP_OP = "00";// 门诊
	SD_CODE_ENTP_ET = "01";// 急诊
	SD_CODE_ENTP_PE = "02";// 体检
	SD_CODE_ENTP_IP = "10";// 住院
	SD_CODE_ENTP_FA = "20";// 家庭病床
	SD_CODE_ENTP_ES = "30";// 出留观标识
 * @param map
 * @return
 */
private   String IsJudgeEntTp(Map<String,String> map){
	 String entTp = "";
	 if(map != null && map.size() == 1){
		 for(String value:map.values()){
			 entTp = value;
		 }
	 }
	 return entTp;
}
	
	
	 
	
	/**
	 * 费用回写
	 * @param orsrvids
	 * @param sd_su_bl
	 * @return
	 * @throws BizException
	 */
	@Deprecated
	public FBoolean UpdateOrdChargeRelInfo(String[] orsrvids,String id_su_bl,String sd_su_bl) throws BizException{
		if(orsrvids==null || orsrvids.length==0){
			return FBoolean.FALSE;
		}
	   List id_orders = new ArrayList();
		Map<String,OrdSrvDO> ordsrvMap=getOrdsrvMap(orsrvids,id_orders);
	 
		Map<String,CiOrderDO> ordMap=getOrdMap(id_orders);
		List<CiOrderDO> ordList = new ArrayList<CiOrderDO>();
		List<OrdSrvDO> ordsrvList = new ArrayList<OrdSrvDO>();
		
		//FDateTime time=new FDateTime();
		TimeService timeService = new TimeServiceImpl();
		String time = timeService.getUFDateTime().toStdString();
		
		for(String id:orsrvids){
			OrdSrvDO ordsrv=ordsrvMap.get(id);
			if(ordsrv!=null){
				ordsrv.setSd_su_bl(sd_su_bl);
				ordsrv.setId_su_bl(id_su_bl);
				ordsrv.setDt_last_bl(new FDateTime(time));
				ordsrv.setStatus(DOStatus.UPDATED);
//				ordsrv.setFg_bl(FBoolean.TRUE);
				ordsrvList.add(ordsrv);
				CiOrderDO order=ordMap.get(ordsrv.getId_or());
				if(order!=null && !ordList.contains(order)){
					//order.setFg_bl(FBoolean.TRUE);
					order.setId_su_bl(id_su_bl);
					order.setSd_su_bl(sd_su_bl);
					order.setStatus(DOStatus.UPDATED);
					ordList.add(order);
				}
			}
		}
				
		if(ordList.size() > 0)
			updateOrd(ordList);
		if(ordsrvList.size() > 0)
			updateOrdSrv(ordsrvList);
		return FBoolean.TRUE;
		
	}
	
	/**
	 * 医嘱执行时补录医嘱服务项目
	 * @param addDTOs
	 * @return
	 * @throws BizException
	 */
	public OrdSrvDO[] insertOrSrvDataWhenPerform(OrSrvAddDTO[] addDTOs) throws BizException {
		
		CiorderMDOCrudServiceImpl ciorderMDOCrudService = new CiorderMDOCrudServiceImpl();
		IMedsrvMDORService medsrvMDORService = ServiceFinder.find(IMedsrvMDORService.class);
		IMeterialMDORService meterialMDORService = ServiceFinder.find(IMeterialMDORService.class);
		
		List<String> orIdList = new ArrayList<String>();
		List<String> srvIdList = new ArrayList<String>();
		List<String> mmIdList = new ArrayList<String>();
		List<OrdSrvDO> insertDOList = new  ArrayList<OrdSrvDO>();
		
		for (OrSrvAddDTO addDTO : addDTOs) {
			if(!orIdList.contains(addDTO.getId_or())){
				orIdList.add(addDTO.getId_or());
			}
			if(!srvIdList.contains(addDTO.getId_srv())){
				srvIdList.add(addDTO.getId_srv());
			}
			if(!StringUtil.isEmpty(addDTO.getId_mm()) && !mmIdList.contains(addDTO.getId_mm())){
				mmIdList.add(addDTO.getId_mm());
			}
		}
		
		CiOrderDO[] ciOrderDOs = ciorderMDOCrudService.findByIds(orIdList.toArray(new String[orIdList.size()]), FBoolean.FALSE);
		MedSrvDO[] medSrvDOs = medsrvMDORService.findByIds(srvIdList.toArray(new String[srvIdList.size()]), FBoolean.FALSE);
		MeterialDO[] meterialDOs = meterialMDORService.findByIds(mmIdList.toArray(new String[mmIdList.size()]), FBoolean.FALSE);
		
		//放入map中便于查找
		Map<String,BaseDO> ciOrdMap =  this.putDOIntoMap(ciOrderDOs,CiOrderDO.ID_OR);
		Map<String,BaseDO> medSrvMap =  this.putDOIntoMap(medSrvDOs,MedSrvDO.ID_SRV);
		Map<String,BaseDO> meterialMap =  this.putDOIntoMap(meterialDOs,MeterialDO.ID_MM);
		
		Map<String,Integer> sortMap = new HashMap<String,Integer>();
		
		for (OrSrvAddDTO addDTO : addDTOs) {
			CiOrderDO orderDO = (CiOrderDO)ciOrdMap.get(addDTO.getId_or());
			MedSrvDO srvDO = (MedSrvDO)medSrvMap.get(addDTO.getId_srv());
			int maxSortNO = 0;
			
			if(sortMap.containsKey(orderDO.getId_or())){
				maxSortNO = sortMap.get(orderDO.getId_or()) + 1;
				sortMap.remove(orderDO.getId_or());
				
			}else{
				//取得现有医嘱服务最大序号
				maxSortNO = this.getMaxOrdSrvSortNO(addDTO.getId_or());
			}
			sortMap.put(addDTO.getId_or(), maxSortNO);
			
			OrdSrvDO ordSrvDO = this.createOrdSrvDO(orderDO, srvDO, addDTO, maxSortNO + 1);
			insertDOList.add(ordSrvDO);
		}
		
		//登录医嘱服务数据
		CiorderSrvDOCrudServiceImpl ciorderSrvDOCrudService = new CiorderSrvDOCrudServiceImpl();
		OrdSrvDO[] ordSrvDOs = ciorderSrvDOCrudService.save(insertDOList.toArray(new OrdSrvDO[insertDOList.size()]));
		
		Map<String,OrSrvAddDTO> srvmmMap = new HashMap<String, OrSrvAddDTO>();
		for (int i = 0; i < ordSrvDOs.length; i++) {
			if(FBoolean.TRUE.equals(ordSrvDOs[i].getFg_mm())){
				srvmmMap.put(ordSrvDOs[i].getId_org_srv(), addDTOs[i]);
			}
		}
		
		if(srvmmMap.size() > 0){
			List<OrdSrvMmDO> srvMmList = new ArrayList<OrdSrvMmDO>();
			for (Entry<String, OrSrvAddDTO> entry : srvmmMap.entrySet()) {
				OrdSrvMmDO ordSrvMmDO = this.createOrdSrvMmDO(entry.getKey(),
						(MeterialDO)meterialMap.get(entry.getValue().getId_mm()),entry.getValue());
				
				srvMmList.add(ordSrvMmDO);
			}
			
			//登录医嘱服务物品数据
			OrdsrvmmCrudServiceImpl ordsrvmmCrudServiceImpl = new OrdsrvmmCrudServiceImpl();
			ordsrvmmCrudServiceImpl.save(srvMmList.toArray(new OrdSrvMmDO[srvMmList.size()]));
		}
		
		return ordSrvDOs;
	}
	
	/**
	 * 更新医嘱表数据
	 * @param drug
	 * @throws BizException
	 */
	private void updateOrd(List<CiOrderDO> ordLis) throws BizException{
		ICiorderMDOCudService ordCudService=(ICiorderMDOCudService)ServiceFinder.find(ICiorderMDOCudService.class.getName());
		ordCudService.save(ordLis.toArray(new CiOrderDO[]{}));
	}
	
	/**
	 * 更新医嘱服务项目数据
	 * @param drug
	 * @throws BizException
	 */
	private void updateOrdSrv(List<OrdSrvDO> ordsrvList) throws BizException{
		ICiorderSrvDOCudService ordsrvCudService=(ICiorderSrvDOCudService)ServiceFinder.find(ICiorderSrvDOCudService.class.getName());
		ordsrvCudService.save(ordsrvList.toArray(new OrdSrvDO[]{}));
		
	}
	
	/**
	 * 更新处方表数据
	 * @param pres
	 * @throws BizException
	 */
	private void updatePres(List<CiPresDO> presList) throws BizException {
		IPresCudService presCudservice=(IPresCudService)ServiceFinder.find(IPresCudService.class.getName());
		presCudservice.save(presList.toArray(new CiPresDO[]{}));
		
	}
	/**
	 * 查找所有处方
	 * @return
	 * @throws BizException
	 */
	private Map<String,CiPresDO> getCipresMap() throws BizException{
		IPresRService presRService=(IPresRService)ServiceFinder.find(IPresRService.class.getName());
		Map<String,CiPresDO> map = new HashMap<String,CiPresDO>();
		CiPresDO[] list = presRService.find(" 1=1 ", null, FBoolean.FALSE);
		for(CiPresDO pres:list){
			map.put(pres.getId_pres(), pres);
		}
		return map;
	}
	/**
	 * 查找所有医嘱
	 * @return
	 * @throws BizException
	 */
	private Map<String,CiOrderDO> getOrdMap(List id_orders) throws BizException{
		ICiorderMDORService ordRService=(ICiorderMDORService)ServiceFinder.find(ICiorderMDORService.class.getName());
		Map<String,CiOrderDO> map = new HashMap<String,CiOrderDO>();
		if(id_orders == null || id_orders.size()<0) return map;
		CiOrderDO[] list = ordRService.find(" a0.Id_or in ( "+id_orders.get(0)+")", null, FBoolean.FALSE);
		for(CiOrderDO ord:list){
			map.put(ord.getId_or(), ord);
		}
		return map;
	}
	
	/**
	 * 医嘱的主键
	 * @param orsrvids
	 * @return 医嘱的主键集合 '','',''
	 * @throws BizException
	 */
	private String getOrderIds(String[] orsrvids)throws BizException{
		CiOrdUtils.LogerOutInfo("费用调用传入的参数 ： "+orsrvids.toString());
		String ids="";
		if(orsrvids!= null){
			  String temp = "";
			 for(String id:orsrvids){
				 if(id != null && id !="") temp += "'"+id+"',"; 
			 }
			 ids = temp.substring(0, temp.lastIndexOf(","));
			 CiOrdUtils.LogerOutInfo("费用调用传入的参数 ： "+ids);
		 //判断医嘱项目是否存在
		 getCiSrvOr(orsrvids);
		 
		String sql = " select distinct id_or from ci_or_srv where id_orsrv in ("+ids+") ";
	    DAFacade df = new  DAFacade();
	    SqlParam sqlparam = new SqlParam();
	     //医嘱的主键
	    List<OrdSrvDO> list = (List<OrdSrvDO>)df.execQuery(sql, sqlparam, new  BeanListHandler(OrdSrvDO.class));
		if(list != null && list.size() >0){
			ids = "";
			for(OrdSrvDO srvDO:list){
				ids +="'"+srvDO.getId_or()+"',"; 
			}
			 ids = ids.substring(0, ids.lastIndexOf(","));
		  }
		}
		return ids;
	}
	
	//医疗服务项目
	 
	private  void getCiSrvOr(String[] orsrvids) throws BizException{
		ICiorderSrvDORService ordsrvRService=(ICiorderSrvDORService)ServiceFinder.find(ICiorderSrvDORService.class.getName());
		String ids = "";
		if(orsrvids!= null){
		  String temp = "";
		 for(String id:orsrvids){
			 temp += "'"+id+"',"; 
		 }
		 ids = temp.substring(0, temp.lastIndexOf(","));
		 CiOrdUtils.LogerOutInfo("费用调用传入的参数 ： "+ids);
		 OrdSrvDO[] list = ordsrvRService.find(" Id_orsrv in ("+ids+")   ", null, FBoolean.FALSE);
		  if(list == null || list.length==0 || list.length != orsrvids.length ){
			  throw new BizException("医嘱项目可能被删除了，请确认");
		  }
		}
		 
	}
	
	/**
	 * 医嘱集合
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	 @Deprecated
	private CiOrderDO[] getCiOrderDOS(String[] ids)throws BizException{
		return CiOrdAppUtils.getOrQryService().findByIds(ids, FBoolean.FALSE);
	}
	/**
	 * 医嘱集合
	 * @param  String ids 
	 * @return CiOrderDO[]s
	 * @throws BizException
	 */
   private CiOrderDO[] getCiOrders(String ids)throws BizException{
	   if(ids== null)return null;
	    String  whereStr = "id_or in ("+ids+")";
	   return CiOrdAppUtils.getOrQryService().find(whereStr, "id_or",FBoolean.FALSE);
   }
   
   /**
    * 医嘱下的所有项目
    * @param ids
    * @return  OrdSrvDO[]
    * @throws BizException
    */
   private Map getOrSrvDOS(String ids)throws BizException{
	   Map<String , OrdSrvDO> map = new HashMap();
	   String id_or = " id_or in ("+ids+") ";
	   OrdSrvDO[] ordSrvDo =  CiOrdAppUtils.getOrSrvQryService().find(id_or, "id_or", FBoolean.FALSE);
       if(ordSrvDo != null && ordSrvDo.length >0){
    	  for(OrdSrvDO srvdo:ordSrvDo ){
    		  map.put(srvdo.getId_orsrv(), srvdo);
    	  } 
       }
	   return map;
   }
   
   
	/**
	 * 医嘱的项目个数
	 * @param ids
	 * @return  map<医嘱id，医嘱的项目个数>
	 * @throws DAException
	 * @throws DAException
	 */
	private  Map getOrderCountSrv(String ids) throws DAException,DAException{
		DAFacade df = new DAFacade();
		SqlParam sqlParam = new SqlParam();
		Map map = new HashMap();
		String sql = "select id_or,count(id_or) days_or  from ci_or_srv where id_or in ("+ids+")  and fg_bl='Y' group by id_or;";
		List<CiOrderDO> list = (List<CiOrderDO>)df.execQuery(sql, sqlParam, new BeanListHandler(CiOrderDO.class));
		if(list != null && list.size() >0){
			for(CiOrderDO orderDO:list){
				map.put(orderDO.getId_or(), orderDO.getDays_or());
			}
		}
		return map;
	}
	
	/**
	 * 组合计价模式，需要更新未回写医嘱项目的计费转态
	 * @param orderSrvDO
	 * @return
	 * @throws BizException
	 */
	private void getOrdSrvDO(OrdSrvDO[] orderSrvDO)throws BizException{
		//根据医嘱id_or 和 fg_bl ='N' and  fg_or ='Y' 查询数据
		// 如果  查询到的结果和 orderSrvDO 数据相等，没有  fg_bl ='N' and  fg_or ='Y'  且是组合定价模式的数据
		//如果不相等  更新的计费标志
		if(orderSrvDO != null && orderSrvDO.length  > 0 ){
			String id_ors = getIdOr(orderSrvDO);
			if(id_ors == "") return ;
			String id_or = " id_or in ("+getIdOr(orderSrvDO)+") and  fg_bl ='N' and sd_su_bl ='0' and  fg_or ='Y'";
			OrdSrvDO[] orSrvDO = CiOrdAppUtils.getOrSrvQryService().find(id_or, "id_or", FBoolean.FALSE);
		    if(orSrvDO  != null && orSrvDO.length >0 ){
		    	for(OrdSrvDO ordsrvdo :orSrvDO){
		    		ordsrvdo.setSd_su_bl(orderSrvDO[0].getSd_su_bl());
		    		ordsrvdo.setId_su_bl(orderSrvDO[0].getId_su_bl());
		    		ordsrvdo.setStatus(DOStatus.UPDATED);
		    	}
		    	CiOrdAppUtils.getOrSrvService().save(orSrvDO);
		    }
		
		} 
	}
	
	/**
	 * 组合计价模式，需要更新未回写医嘱项目的计费转态
	 * @param orderSrvDO
	 * @return
	 * @throws BizException
	 */
	private void getOrdSrvDOcombinationFree(String ids,String id_su_bl, String sd_su_bl,FDateTime dt_last_cg)throws BizException{
		//根据医嘱id_or 和 fg_bl ='N' and  fg_or ='Y' 查询数据
		// 如果  查询到的结果和 orderSrvDO 数据相等，没有  fg_bl ='N' and  fg_or ='Y'  且是组合定价模式的数据
		//如果不相等  更新的计费标志
			if(ids == "" ||ids ==null) return ;
			String id_or = " id_or in ("+ids+") and  fg_bl ='N' and sd_su_bl ='0' and  fg_or ='Y'";
			OrdSrvDO[] orSrvDO = CiOrdAppUtils.getOrSrvQryService().find(id_or, "id_or", FBoolean.FALSE);
		    if(orSrvDO  != null && orSrvDO.length >0 ){
		    	for(OrdSrvDO ordsrvdo :orSrvDO){
		    		ordsrvdo.setSd_su_bl(sd_su_bl);
		    		ordsrvdo.setId_su_bl(id_su_bl);
		    		ordsrvdo.setStatus(DOStatus.UPDATED);
		    	}
		    	CiOrdAppUtils.getOrSrvService().save(orSrvDO);
		    }
		
		  
	}
	/**
	 * 获得医嘱 Id_or  in ('','')
	 * @param orderSrvDO
	 * @return
	 */
	private  String  getIdOr(OrdSrvDO[] orderSrvDO){
		String id_or ="";
		if(orderSrvDO != null && orderSrvDO.length > 0 ){
			for(OrdSrvDO srvDO:orderSrvDO){
				id_or+= ",'"+srvDO.getId_or()+"'";
			}
		}
		if(id_or !="" ){
			id_or = id_or.substring(1);
		}
		return id_or;
	}
	/**
	 * 获得医嘱 Id_or的数组集合
	 * @param orderSrvDO
	 * @return
	 */
	private String[] getArrayOfIdOrs(OrdSrvDO[] orderSrvDO){
		List<String> id_ors = new ArrayList<String>();
		if(orderSrvDO != null && orderSrvDO.length > 0 ){
			for(OrdSrvDO srvDO:orderSrvDO){
				if(!id_ors.contains(srvDO.getId_or())){
					id_ors.add(srvDO.getId_or());
				}
			}
		}
		return id_ors.toArray(new String[id_ors.size()]);
	}
	
	
	private void UpdateOrderSuSuBl(Map<String,String> map,String Sd_su_bl,String Id_su_bl )throws BizException{
		 //查询
		CiOrderDO[] orders = getCiOrderDOIds(map);
		 //set sd_su_bl 的值
		setCiorderSdSuBl(orders,Sd_su_bl,Id_su_bl);
		//更新
		CiOrdAppUtils.getOrService().save(orders);
	}
	
	 /**
	  * 更新医嘱的计费状态
	  * @param ciorders
	  * @param sd_su_bl
	  * @param id_su_bl
	  */
	 private void setCiorderSdSuBl(CiOrderDO[] ciorders,String Sd_su_bl,String Id_su_bl){
		 if(ciorders != null && ciorders.length >0){
			 for(CiOrderDO ciorder:ciorders){
				 ciorder.setSd_su_bl(Sd_su_bl);
				 ciorder.setId_su_bl(Id_su_bl);
				 ciorder.setStatus(DOStatus.UPDATED);
			 }
		 }
		 
	 }
	 
	
     /**
      * 根据医嘱ID 查询医嘱信息
      * @param map
      * @return
      * @throws BizException
      */
	private CiOrderDO[] getCiOrderDOIds(Map<String,String> map)throws BizException{
		
		if(map == null || map.size() ==0) return null;
		String sql = " ";
		for(String key:map.values()){
			sql += "'"+key+"',";
		}
		if(sql != ""){
			sql = sql.substring(0, sql.lastIndexOf(","));
			sql = "("+sql+")";
		}
		CiOrderDO[] orderdos = CiOrdAppUtils.getOrQryService().find(CiOrderDODesc.TABLE_ALIAS_NAME+"."+CiOrderDO.ID_OR +" in "+sql, CiOrderDO.ID_OR, FBoolean.FALSE);
		return orderdos;
	}
	
	/**
	 * 查找所有医嘱服务
	 * @return
	 * @throws BizException
	 */
	private Map<String,OrdSrvDO> getOrdsrvMap(String[] orsrvids,List id_orders) throws BizException{
		ICiorderSrvDORService ordsrvRService=(ICiorderSrvDORService)ServiceFinder.find(ICiorderSrvDORService.class.getName());
		Map<String,OrdSrvDO> map = new HashMap<String,OrdSrvDO>();
		String ids = "";
		
		if(orsrvids!= null){
		  String temp = "";
		 for(String id:orsrvids){
			 temp += "'"+id+"',"; 
		 }
		 ids = temp.substring(0, temp.lastIndexOf(","));
		 OrdSrvDO[] list = ordsrvRService.find(" Id_orsrv in ("+ids+")", null, FBoolean.FALSE);
		  String order_temp ="";
			for(OrdSrvDO ordsrv:list){
				order_temp += "'"+ordsrv.getId_or()+"',";
				map.put(ordsrv.getId_orsrv(), ordsrv);
			}
			if(order_temp != null){
				order_temp = order_temp.substring(0, order_temp.lastIndexOf(","));
			}
			id_orders.add(order_temp);
		}
		
		return map;
	}
	
	/**
	 * 将DO数据放进主键做key的Map中
	 * @param baseDOs
	 * @param keyName
	 * @return
	 */
	private Map<String,BaseDO> putDOIntoMap(BaseDO[] baseDOs,String keyName){
		
		 Map<String,BaseDO> map = new HashMap<String,BaseDO>();
		 if(ArrayUtil.isEmpty(baseDOs)){
			 return map;
		 }
		 
		 for (BaseDO baseDO : baseDOs) {
			 map.put((String)baseDO.getAttrVal(keyName), baseDO);
		 }
		 return map;
	}

	/**
	 * 取得医嘱服务最大序列号
	 * @param ordId
	 * @return
	 * @throws BizException
	 */
	private int getMaxOrdSrvSortNO(String ordId) throws BizException{
		CiorderSrvDOCrudServiceImpl ciorderSrvDOCrudService = new CiorderSrvDOCrudServiceImpl();
		String wherePart = OrdSrvDODesc.TABLE_ALIAS_NAME+".id_or = '"+ordId+"'";
		OrdSrvDO[] ordSrvDOs = ciorderSrvDOCrudService.find(wherePart, "", FBoolean.FALSE);
		
		if(ArrayUtil.isEmpty(ordSrvDOs))
			return -1;
		
		int maxSortNO = 0;
		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			if(maxSortNO <= ordSrvDO.getSortno())
				maxSortNO = ordSrvDO.getSortno();
		}
		
		return maxSortNO;
	}
	
	/**
	 * 生成医嘱服务DO（执行域补录用）
	 * @param orderDO
	 * @param srvDO
	 * @param addDTO
	 * @param sortNO
	 * @return
	 */
	private OrdSrvDO createOrdSrvDO(CiOrderDO orderDO,MedSrvDO srvDO,OrSrvAddDTO addDTO, int sortNO){
		OrdSrvDO ordSrvDO = new OrdSrvDO();
		ordSrvDO.setId_or(orderDO.getId_or());
		ordSrvDO.setId_pat(orderDO.getId_pat());
		ordSrvDO.setId_entp(orderDO.getId_entp());
		ordSrvDO.setCode_entp(orderDO.getCode_entp());
		ordSrvDO.setId_en(orderDO.getId_en());
		ordSrvDO.setSortno(sortNO);
		ordSrvDO.setId_srvtp(srvDO.getId_srvtp());
		ordSrvDO.setSd_srvtp(srvDO.getSd_srvtp());
		ordSrvDO.setId_srv(srvDO.getId_srv());
		ordSrvDO.setName_srv(srvDO.getName());
		ordSrvDO.setFg_dose_anoma(FBoolean.FALSE);
		ordSrvDO.setQuan_medu(addDTO.getQuan());
		ordSrvDO.setId_medu(srvDO.getId_unit_med());
		ordSrvDO.setId_route(orderDO.getId_route());
		ordSrvDO.setId_routedes(orderDO.getId_routedes());
		ordSrvDO.setId_boil(orderDO.getId_boil());
		ordSrvDO.setId_boildes(orderDO.getId_boildes());
		ordSrvDO.setId_freq(orderDO.getId_freq());
		//服务项目开立机构
		//.. TODO
		//执行科室
		ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
		ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
		ordSrvDO.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
		ordSrvDO.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
		ordSrvDO.setDt_last_bl(new FDateTime());
		ordSrvDO.setFg_or(FBoolean.TRUE);
		ordSrvDO.setEu_blmd(srvDO.getEu_blmd());
		ordSrvDO.setFg_bl(srvDO.getFg_bl());
		ordSrvDO.setFg_mm(srvDO.getFg_mm());
		ordSrvDO.setPri(srvDO.getPri());
		//ordSrvDO.setFg_indic(Fg_indic); 医保适用标志
		ordSrvDO.setFg_self(FBoolean.FALSE);
		ordSrvDO.setFg_pres_outp(FBoolean.FALSE);
		ordSrvDO.setStatus(DOStatus.NEW);
		
		return ordSrvDO;
	}

	/**
	 * 生成医嘱服务物品DO（执行域补录用）
	 * @param odSrvId
	 * @param meterialDO
	 * @param addDTO
	 * @return
	 */
	private OrdSrvMmDO createOrdSrvMmDO(String odSrvId,MeterialDO meterialDO,OrSrvAddDTO addDTO){
		OrdSrvMmDO ordSrvMmDO = new OrdSrvMmDO();
		ordSrvMmDO.setId_orsrv(odSrvId);
		ordSrvMmDO.setId_mm(meterialDO.getId_mm());
		//根据接口取得当前包装单位及换算系数等信息 TODO
		ordSrvMmDO.setId_pgku_base(meterialDO.getId_unit_pkgbase());
		
		ordSrvMmDO.setId_mmtp(meterialDO.getId_mmtp());
		ordSrvMmDO.setSd_mmtp(meterialDO.getSd_mmtp());
		ordSrvMmDO.setCode_mm(meterialDO.getCode());
		ordSrvMmDO.setName_mm(meterialDO.getName());
		
		//ordSrvMmDO.setFg_otc(meterialDO.getfg);
		ordSrvMmDO.setSd_val(meterialDO.getSd_val());
		
		ordSrvMmDO.setStatus(DOStatus.NEW);
		return ordSrvMmDO;
	}
}
