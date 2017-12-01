package iih.ci.ord.s.bp.validate;

import java.util.ArrayList;
import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.CiOrOpenSrvReactOrSrvInfoBP;
import iih.ci.ord.s.bp.exception.CiOrOpenSrvReactCheckException;
import iih.ci.ord.s.bp.exception.ExcludeAllGrpInCoExistException;
import iih.ci.ord.s.bp.exception.ExcludeAllOrSrvMultiException;
import iih.ci.ord.s.bp.exception.GrpInExcludeSrvMutliException;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import iih.ci.ord.srvreact.d.OrOpenSrvReactDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 医嘱开立时，医嘱项目互斥有效性校验操作BP
 * （含出院、转科、死亡等唯一性问题）
 */
public class CiOrOpenOrSrvReactValidateBP {
	/**
	 * 医嘱开立时，医嘱项目互斥有效性校验
	 * 含出院、转科、死亡等唯一性问题
	 * @param ems
	 * @throws BizException
	 */
	public void exec(CiEmsDTO ems) throws BizException{
		//有效性判断
		if(!isValidate(ems))return;
		
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		SrvReactDTO[] srvreacts=getOrSrvReactInfos(ems);
		if(srvreacts==null || srvreacts.length==0)return;//医嘱互斥项目检查
		
		//对服务互斥数据进行分组处理
		Hashtable<String, ArrayList<SrvReactDTO>> reactht = CiOrdUtils
				.getSrvReactHt(srvreacts);
		String id_pi=ems.getId_pat();
		String id_pv=ems.getId_en();
		String id_or=ems.getId_or();
		String id_srvreacts=CiOrdUtils.getSrvReactIdStrs(srvreacts);
		FDateTime[] openOrDts=new FDateTime[]{ems.getDt_begin(),ems.getDt_end()}; //???
		
		//存在全排医嘱
		if(reactht.containsKey(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL)){
			ArrayList<SrvReactDTO> reactalls=reactht.get(IBdSrvDictCodeConst.SD_REACTTP_EXCLUDEALL);
			if(reactalls.size()>1){
				throw new ExcludeAllOrSrvMultiException();  //医嘱保存时，医嘱项目中存在多个全排项目错误！
			}
			if(reactht.size()>1){
				throw new ExcludeAllGrpInCoExistException();//医嘱保存时，医嘱项目中全排与组内排斥项目同时存在错误!
			}
			
			//医嘱开立时，互斥医嘱有效性检查处理
			ciOrOpenSrvReactOrsHandle(id_pi,id_pv,id_or,id_srvreacts,openOrDts,true);
		}else {
			if(reactht.size()>0){//组内排斥医嘱的情况
				ArrayList<SrvReactDTO> grpinreactlist=null;
				for(String key:reactht.keySet()){
					grpinreactlist=reactht.get(key);
					if(grpinreactlist!=null && grpinreactlist.size()>1){
						throw new GrpInExcludeSrvMutliException();//医嘱保存时，医嘱项目中同组内排斥项目同时存在异常
					}
				}
			}
			
			//医嘱开立时，互斥医嘱有效性检查处理
			ciOrOpenSrvReactOrsHandle(id_pi,id_pv,id_or,id_srvreacts,openOrDts,false);
			
		}
	}
	
	/**
	 * 医嘱开立时，互斥医嘱有效性检查处理
	 * @param id_pi
	 * @param id_pv
	 * @param id_or
	 * @param id_srvreact
	 * @param isAllExclude
	 * @throws BizException 
	 */
	private void ciOrOpenSrvReactOrsHandle(String id_pi,String id_pv,String id_or,String id_srvreacts,FDateTime[] openOrDts,boolean isAllExclude) throws BizException{
		//获得互斥医嘱相关数据信息
		OrOpenSrvReactDTO[] reactOrinfos=getCiOrOpenSrvReactOrSrvInfo(id_pi,id_pv,id_or,id_srvreacts);
		
		//有效性检查
		if(CiOrdUtils.isEmpty(reactOrinfos))return;
		String errMsg="";
		//时间重叠性检查
		for(int i=0;i<reactOrinfos.length;i++){
			if(isAllExclude)
			{
				errMsg+=reactOrinfos[i].getName_srv()+CiOrdUtils.CRLF; 
			}else{
				if(isTimeOverlapped(new FDateTime[]{reactOrinfos[i].getDt_effe(),reactOrinfos[i].getDt_end()},openOrDts)){
					errMsg+=reactOrinfos[i].getName_srv()+CiOrdUtils.CRLF; 
				}
			}
			
		}
		
		//异常情况处理
		if(!CiOrdUtils.isEmpty(errMsg)){
			if(isAllExclude)
			{
				errMsg="医嘱开立时，存在如下全排斥医嘱："+CiOrdUtils.CRLF+errMsg+"请处理完毕后再开立本医嘱！";
			}else{
				errMsg="医嘱开立时，存在如下开始结束重叠医嘱："+CiOrdUtils.CRLF+errMsg+"请处理完毕后再开立本医嘱！";
			}
			throw new CiOrOpenSrvReactCheckException(errMsg);
		}
	}
	
	/**
	 * 临床医嘱开立保存时，获得服务互斥信息数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	private SrvReactDTO[] getOrSrvReactInfos(CiEmsDTO ems) throws BizException{
		CiOrOpenOrSrvReactInfoGetBP bp=new CiOrOpenOrSrvReactInfoGetBP();
		return bp.exec(ems);
	}
	
	/**
	 * 有效性判断
	 * @param ems
	 * @return
	 */
	private boolean isValidate(CiEmsDTO ems){
		if(CiOrdUtils.isEmpty(ems))return false;
		if(CiOrdUtils.isEmpty(ems.getId_pat()) || 
				CiOrdUtils.isEmpty(ems.getId_pat()))return false;
		return true;
	}
	
	/**
	 * 医嘱开立时，与其互斥医嘱信息数据
	 * @param id_pi
	 * @param id_pv
	 * @param id_or
	 * @param id_srvreact
	 * @return
	 * @throws BizException
	 */
	private OrOpenSrvReactDTO[] getCiOrOpenSrvReactOrSrvInfo(String id_pi,String id_pv,String id_or,String id_srvreacts) throws BizException{
		CiOrOpenSrvReactOrSrvInfoBP bp=new CiOrOpenSrvReactOrSrvInfoBP();
		return bp.exec(id_pi, id_pv, id_or, id_srvreacts);
	}
	
	/**
	 * 重叠时间判断
	 * @param dt1
	 * @param dt2
	 * @return
	 */
	private boolean isTimeOverlapped(FDateTime[] dt1,FDateTime[] dt2){
		FDateTime[] dt=OrSrvSplitUtil.getValidStartEndDT(dt1, dt2);
		if(dt==null)return false;
		return true;
	}
}
