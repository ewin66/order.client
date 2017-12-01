package iih.ci.ord.s.bp.validate;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.cior.d.CiorderAggExtDO;
import iih.ci.ord.cior.d.CiorderAggExtDTO;
import iih.ci.ord.cior.d.OrReactType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/*
 * 临床医嘱签署时，获得扩展的医嘱聚集DO数据信息（含互斥类型属性）操作BP
 */
public class CiOrSignReactExtAggDOGetBP {
	/**
	 * 临床医嘱签署时，获得扩展的医嘱聚集DO数据信息（含互斥类型属性）
	 * @param aggors
	 * @throws BizException
	 */
	public CiorderAggExtDO[] exec(CiorderAggDO[] aggors,SrvReactDTO[] srvreacts) throws BizException{
		//有效性校验与处理
		if(aggors==null || aggors.length==0)return null;
		if(srvreacts==null || srvreacts.length==0){
			return getCiorderAggExtDOs4Null(aggors);
		}
		
		//参数设置
		CiorderAggExtDO[] aggexts=new CiorderAggExtDO[aggors.length];
		Object[] reacttp=null;//互斥类型、互斥组串、互斥组内服务串
		
		//遍历
		for(int i=0;i<aggors.length;i++){
			reacttp=getOrReactType(aggors[i],srvreacts);
			aggexts[i]=createCiorAggExtDO(aggors[i],reacttp);
		}
		
		return aggexts;
		
	}
	
	/**
	 * 获得非排斥扩展医嘱集合数据
	 * @param aggors
	 * @return
	 */
	private CiorderAggExtDO[] getCiorderAggExtDOs4Null(CiorderAggDO[] aggors){
		//参数设置
		CiorderAggExtDO[] rtns=new CiorderAggExtDO[aggors.length];
		
		//遍历
		for(int i=0;i<aggors.length;i++){
			rtns[i]=createCiorAggExtDO(aggors[i],createUnOrReactInfo());
		}
		return rtns;
	}
	
	/**
	 * 获得医嘱的互斥信息
	 * 互斥类型、互斥组串、互斥组内服务串
	 * @param aggdo
	 * @param srvreacts
	 * @return
	 */
	private Object[] getOrReactType(CiorderAggDO aggdo,SrvReactDTO[] srvreacts){
		String orsrvids=CiOrdUtils.getSrvStr8OrAggDO(aggdo);
		if(CiOrdUtils.isEmpty(orsrvids))return createUnOrReactInfo();
		int iN=0;
		String reactidstr="",reactsrvidstr="";
		for(int i=0;i<srvreacts.length;i++){
			if(CiOrdUtils.isInStr(CiOrdUtils.AddDblComma(srvreacts[i].getId_srv()), orsrvids)){
				if(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL.equals(srvreacts[i]
						.getSd_reacttp())){
					if(reactidstr.equals("")){
						reactidstr=srvreacts[i].getId_srvreact();
					}else{
						reactidstr+=CiOrdUtils.COMMA_STR+srvreacts[i].getId_srvreact();
					}
					if(reactidstr.equals("")){
						reactsrvidstr=srvreacts[i].getId_srv();
					}else{
						reactsrvidstr+=CiOrdUtils.COMMA_STR+srvreacts[i].getId_srv();
					}
					
					return createOrReactInfo(reactidstr,reactsrvidstr,OrReactType.EXCLUDEALL);
				}else if(IBdSrvDictCodeConst.SD_REACTTP_GRPINEXCLUDE
						.equals(srvreacts[i].getSd_reacttp())){
					iN+=1;
					if(reactidstr.equals("")){
						reactidstr=srvreacts[i].getId_srvreact();
					}else{
						reactidstr+=CiOrdUtils.COMMA_STR+srvreacts[i].getId_srvreact();
					}
					if(reactidstr.equals("")){
						reactsrvidstr=srvreacts[i].getId_srv();
					}else{
						reactsrvidstr+=CiOrdUtils.COMMA_STR+srvreacts[i].getId_srv();
					}
				}
			}
		}
		if(iN==1)return createOrReactInfo(reactidstr,reactsrvidstr,OrReactType.EXCLUDEGRPIN_SINGLE);
		if(iN>1)return createOrReactInfo(reactidstr,reactsrvidstr,OrReactType.EXCLUDEGRPIN_MULTI);
		return createUnOrReactInfo();
		
	}
	
	/**
	 * 创建医嘱互斥信息
	 * @param reactidstr
	 * @param reactsrvidstr
	 * @param reacttype
	 * @return
	 */
	private Object[] createOrReactInfo(String reactidstr,String reactsrvidstr,Integer reacttype){
		return new Object[]{reacttype,reactidstr,reactsrvidstr};
	}
	/**
	 * 创建不互斥医嘱信息
	 * @return
	 */
	private Object[] createUnOrReactInfo(){
		return createOrReactInfo(null,null,OrReactType.UNREACT);
	}
	
	
	/**
	 * 创建扩展医嘱数据信息
	 * @param aggdo
	 * @param reacttp
	 * @return
	 */
	private CiorderAggExtDO createCiorAggExtDO(CiorderAggDO aggdo,Object[] reacttp){
		CiorderAggExtDO rtn=new CiorderAggExtDO();
		rtn.setReacttype((Integer)reacttp[0]);
		rtn.setId_reacts((String)reacttp[1]);
		rtn.setId_srvs((String)reacttp[2]);
		rtn.setAggdo(aggdo);
		return rtn;
	}
	
}
