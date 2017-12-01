package iih.ci.ord.s.bp.validate;

import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.cior.d.CiorderAggExtDO;
import iih.ci.ord.cior.d.OrReactType;
import iih.ci.ord.cior.d.ReactExtOrsAndStopOrsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrValidFgLongOrQryBP;
import iih.ci.ord.s.bp.CiOrValidGrpInReactOrQryBP;
import iih.ci.ord.s.bp.exception.ExcludeAllFglongOrCoexistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrCntGt1Exception;
import iih.ci.ord.s.bp.exception.GrpInReactExistMultiOrException;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;

/*
 * 医嘱互斥检查与处理操作BP
 */
public class OrMutexValidateBP {
	/**
	 * 医嘱互斥检查与处理
	 * 返回 要停止的医嘱
	 * @param aggors
	 * @param dt_cur
	 * @return 
	 * @throws BizException
	 */
	public ReactExtOrsAndStopOrsDO exec(CiorderAggDO[] aggors,FArrayList fa) throws BizException{
		//有效性校验
		if(!validateCheck(aggors))return null;
		FDateTime dt_cur=(FDateTime) fa.get(0);
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts=getOrSrvReactInfos(aggors);
		if(srvreacts==null || srvreacts.length==0)return null;//医嘱互斥项目检查
		String id_en=aggors[0].getParentDO().getId_en();
		//参数设置
		CiOrderDO[] willstoporders=null;
		
		//设置医嘱的排斥类型
		CiorderAggExtDO[] oraggextinfos=getReactExtAggDOInfo(aggors,srvreacts);
		
		//获得全排相关医嘱信息 0全排个数 1长期医嘱个数  2全排医嘱索引号   3长期医嘱索引号
		int[] iexallinfos=getExcludeAllOrInfos(oraggextinfos);
		
		//全排斥判断逻辑
		if(iexallinfos[0]==1){//全排
			if(iexallinfos[1]>0){//签署的其它医嘱中含长期医嘱时报错 
				throw new ExcludeAllFglongOrCoexistException(
						oraggextinfos[iexallinfos[2]].getAggdo().getParentDO()
								.getName_or(), oraggextinfos[iexallinfos[3]]
								.getAggdo().getParentDO().getName_or());
			}else{//是全排医嘱时，将停止所有有效长期医嘱（已核对、已签署？）。需要用户干预
//				throw new ExcludeAllOrSignPromptMsg(
//						oraggextinfos[iexallinfos[2]].getAggdo().getParentDO()
//								.getName_or());
				//停止在执行长期有效医嘱停止（仅已签署的、已核对的）
				//CiOrValidFgLongOrQryStopBP
				//校验存在互斥服务项目时，有几个医嘱（医嘱互斥时，排斥医嘱限制单条操作，如果多条，请提示“XX医嘱为排斥医嘱，请先确认其他医嘱！）
				if(aggors.length>1){
					List<CiorderAggDO> reactAggs = getReactOrds(aggors,srvreacts);
					if(reactAggs.size()>0){
						throw new BizException(reactAggs.get(0).getParentDO().getName_or()+"医嘱为排斥医嘱，请先签署其他医嘱！");
					}
				}
				//li_cheng 全排医嘱的开立时间
				dt_cur=oraggextinfos[iexallinfos[2]].getAggdo().getParentDO().getDt_effe();
				willstoporders=getExcludeAllValidFgLongOrs(id_en,dt_cur);
			}
		}else if(iexallinfos[0]>1){//全排医嘱为多个时，报错
			throw new ExcludeAllOrCntGt1Exception();
		}else{//非全排情形的业务逻辑
			//获得组内排斥相关信息 
			//组内排斥医嘱个数  组内排斥组所对应的医嘱集合  排斥组id串
			Object[] oexgrpininfos=getExcludeGrpInOrInfos(oraggextinfos);
			
			//组内排斥判断逻辑
			if((int)oexgrpininfos[0]!=0){
				Hashtable<String,ArrayList<CiorderAggExtDO>> ht=(Hashtable<String,ArrayList<CiorderAggExtDO>>)oexgrpininfos[1];
				String key=isReactGrpMutliOr(ht);
				if(!CiOrdUtils.isEmpty(key)){//待签医嘱中，同一个排斥组是否存在多个医嘱判断
					ArrayList<CiorderAggExtDO> list=ht.get(key); 
					throw new GrpInReactExistMultiOrException(getOrNames(list));
				}else{//是组内排斥时，将停止相关有效长期医嘱（已核对、已签署？）。需要用户干预
					//继续
					//li_cheng
					dt_cur=oraggextinfos[0].getAggdo().getParentDO().getDt_effe();
					willstoporders=getGrpInValidFgLongOrs(id_en,(String)oexgrpininfos[2],dt_cur);
				}
			}			
		}
		fa.remove(0);
		fa.add(dt_cur);
		//返回排斥相关停止的医嘱集合
		return getRtn(oraggextinfos,willstoporders);
		
	}
	/**
	 * 校验存在互斥服务项目时，有几个医嘱（医嘱互斥时，排斥医嘱限制单条操作，如果多条，请提示“XX医嘱为排斥医嘱，请先确认其他医嘱！）
	 * @param aggors
	 * @param srvreacts
	 * @return
	 * @throws BizException 
	 */
	private List<CiorderAggDO> getReactOrds(CiorderAggDO[] aggors,SrvReactDTO[] srvreacts){
		List<CiorderAggDO> reactAggs = new ArrayList<CiorderAggDO>();
		for(CiorderAggDO agg : aggors){
			OrdSrvDO[] srvDOs = agg.getOrdSrvDO();
			for(OrdSrvDO srvdo : srvDOs){
				for(SrvReactDTO react : srvreacts){
					if(srvdo.getId_srv().equals(react.getId_srv())){
						if(!reactAggs.contains(agg)){
							reactAggs.add(agg);
						}
					}
				}
			}
		}
		return reactAggs;
	}
	/**
	 * 获得医嘱名称数组
	 * @param list
	 * @return
	 */
	private String[] getOrNames(ArrayList<CiorderAggExtDO> list){
		//有效性校验
		if(list==null || list.size()==0)return null;
		 
		//参数定义
		String[] rtns=new String[list.size()];
		
		//遍历
		for(int i=0;i<list.size();i++){
			rtns[i]=list.get(i).getAggdo().getParentDO().getName_or();
		}
		return rtns;
	}
	
	/**
	 * 待签医嘱中，同一个排斥组是否存在多个医嘱判断
	 * @param ht
	 * @return
	 */
	private String isReactGrpMutliOr(Hashtable<String,ArrayList<CiorderAggExtDO>> ht){
		for(String key:ht.keySet()){
			if(ht.get(key).size()>1){
				return key;
			}
		}
		return null;
	}
	
	/**
	 * 临床医嘱签署时，获得服务互斥信息数据
	 * @param aggors
	 * @return
	 * @throws BizException
	 */
	private SrvReactDTO[] getOrSrvReactInfos(CiorderAggDO[] aggors) throws BizException{
		CiOrSignOrSrvReactInfoGetBP bp=new CiOrSignOrSrvReactInfoGetBP();
		return bp.exec(aggors);
	}
	
	/**
	 * 获得医嘱聚集扩展信息实体（设置医嘱的排斥类型）
	 * @param aggors
	 * @param srvreacts
	 * @return
	 * @throws BizException
	 */
	private CiorderAggExtDO[] getReactExtAggDOInfo(CiorderAggDO[] aggors,SrvReactDTO[] srvreacts) throws BizException{
		CiOrSignReactExtAggDOGetBP bp=new CiOrSignReactExtAggDOGetBP();
		return bp.exec(aggors, srvreacts);
	}
	
	/**
	 * 获得医嘱全排相关信息
	 * @param oraggextinfos
	 * @return
	 */
	private int[] getExcludeAllOrInfos(CiorderAggExtDO[] oraggextinfos){
		ArrayList<CiorderAggDO> reactallors=new ArrayList<CiorderAggDO>();
		int iL_fglong=0,fglong_index=-1,reactall_index=-1;
		for(int i=0;i<oraggextinfos.length;i++){
			//全排医嘱判断
			if(OrReactType.EXCLUDEALL.equals(oraggextinfos[i].getReacttype())){//BdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL
				reactall_index=i;
				reactallors.add(oraggextinfos[i].getAggdo());
			}else{//非全排时是否存在长期医嘱判断
				if(oraggextinfos[i].getAggdo().getParentDO().getFg_long().booleanValue()){
					iL_fglong+=1;
					fglong_index=i;
				}
			}
		}
		return new int[]{reactallors.size(),iL_fglong,reactall_index,fglong_index};
	}
	
	

	
	/**
	 * 获得医嘱组排相关信息
	 * 组内排斥医嘱个数  组内排斥组所对应的医嘱集合  排斥组id串
	 * @param oraggextinfos
	 * @return
	 */
	private Object[] getExcludeGrpInOrInfos(CiorderAggExtDO[] oraggextinfos){
		//参数设置
		int iL_grpin=0;
		String[] tms=null;
		String key="";
		String grpinreactids="";
		Hashtable<String,ArrayList<CiorderAggExtDO>> ht=new Hashtable<String,ArrayList<CiorderAggExtDO>>();
		ArrayList<CiorderAggExtDO> list=null;
		//遍历
		for(int i=0;i<oraggextinfos.length;i++){
			if(OrReactType.EXCLUDEGRPIN_SINGLE.equals(oraggextinfos[i].getReacttype()) || 
			   OrReactType.EXCLUDEGRPIN_MULTI.equals(oraggextinfos[i].getReacttype())){
				iL_grpin+=1;
				tms=oraggextinfos[i].getId_reacts().split(CiOrdUtils.COMMA_STR);
				for(int j=0;j<tms.length;j++){
					key=tms[j];
					if(ht.containsKey(key)){
						ht.get(key).add(oraggextinfos[i]);
					}else{
						grpinreactids+=CiOrdUtils.COMMA_STR+key;
						list=new ArrayList<CiorderAggExtDO>();
						list.add(oraggextinfos[i]);
						ht.put(key,list);
					}
				}
			}
		}
		if(!grpinreactids.equals(""))grpinreactids=grpinreactids.substring(1);
		return new Object[]{iL_grpin,ht,grpinreactids};
	}
	
	/**
	 * 获得临床在执行的有效长期医嘱（全排斥时使用）
	 * @param id_en
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] getExcludeAllValidFgLongOrs(String id_en,FDateTime dt_cur) throws BizException{
		//获得在执行的有效长期医嘱
		CiOrValidFgLongOrQryBP bp=new CiOrValidFgLongOrQryBP();
		return bp.exec(id_en, dt_cur);
	}
	
	/**
	 * 获得临床在执行的有效长期医嘱（组内排斥时使用）
	 * @param id_en
	 * @param dt_cur
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] getGrpInValidFgLongOrs(String id_en,String id_srvreacts,FDateTime dt_cur) throws BizException{
		//获得在执行的有效长期医嘱
		CiOrValidGrpInReactOrQryBP bp=new CiOrValidGrpInReactOrQryBP();
		return bp.exec(id_en,id_srvreacts, dt_cur);

	}
	
	/**
	 * 有效性校验
	 * @param aggors
	 * @return
	 */
	public boolean validateCheck(CiorderAggDO[] aggors){
		if(aggors==null || aggors.length==0)return false;
		if(!CiOrdUtils.isIpWf(aggors[0].getParentDO().getCode_entp()))return false;
		
		return true;
	}
	
	/**
	 * 获得返回值
	 * @param oraggextinfos
	 * @param willstoporders
	 * @return
	 */
	private ReactExtOrsAndStopOrsDO getRtn(CiorderAggExtDO[] oraggextinfos,CiOrderDO[] willstoporders){
		ReactExtOrsAndStopOrsDO rtn=new ReactExtOrsAndStopOrsDO();
		rtn.setStopordos(CiOrdUtils.array2FArrayList(willstoporders));
		rtn.setReactextdos(CiOrdUtils.array2FArrayList(oraggextinfos));
		return rtn;
	}
}
