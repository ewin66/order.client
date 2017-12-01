package iih.ci.ord.s.bp.validate;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.ExcludeAllGrpInCoExistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrSrvMultiException;
import iih.ci.ord.s.bp.exception.GrpInExcludeSrvMutliException;
import xap.mw.core.data.BizException;

/*
 * 医嘱中服务互斥检查与处理操作BP
 * 医嘱保存时使用
 */
public class SrvMutexValidateBP {
	/**
	 * 医嘱中服务互斥检查与处理
	 * @throws BizException
	 */
	public void exec(CiorderAggDO[] aggors) throws BizException{
		//有效性校验
		if(aggors==null||aggors.length>0)return;
		
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts=getOrSrvReactInfos(aggors);
		if(srvreacts==null || srvreacts.length==0)return;//医嘱互斥项目检查
		
		//对服务互斥数据进行分组处理
		Hashtable<String, ArrayList<SrvReactDTO>> reactht = CiOrdUtils
				.getSrvReactHt(srvreacts);
		
		//存在全排医嘱
		if(reactht.containsKey(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL)){
			ArrayList<SrvReactDTO> reactalls=reactht.get(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
			if(reactalls.size()>1){
				throw new ExcludeAllOrSrvMultiException();  //医嘱保存时，医嘱项目中存在多个全排项目错误！
			}
			if(reactht.size()>1){
				throw new ExcludeAllGrpInCoExistException();//医嘱保存时，医嘱项目中全排与组内排斥项目同时存在错误!
			}
		}else{
			if(reactht.size()>0){//组内排斥医嘱的情况
				ArrayList<SrvReactDTO> grpinreactlist=null;
				for(String key:reactht.keySet()){
					grpinreactlist=reactht.get(key);
					if(grpinreactlist!=null && grpinreactlist.size()>1){
						throw new GrpInExcludeSrvMutliException();//医嘱保存时，医嘱项目中同组内排斥项目同时存在异常
					}
				}
			}
		}
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
}
