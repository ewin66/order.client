package iih.ci.ord.s.bp.orsrvsplit;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitOrModParamDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;

/***
 * 住院摆药请领存盘操作BP
 */
public class IpDrugDispenseAppSaveBP {
	/***
	 * 住院摆药请领存盘操作
	 * @param param
	 * @param isCharged
	 * @return
	 * @throws BizException
	 */
	public  Integer exec(OrSrvSplitParamDTO param,boolean isCharged)  throws BizException{
		Integer succcnt=0,failcnt=0;
		//有效性校验
		validateCheck(param);
		
		//获得拆分sql对应的有效医嘱/医嘱服务
		BaseDTO[] splitdos=getOrAndSrvSplitSqlRs(param);
		
		//获得服务拆分结果请领量计算结果信息
		ArrayList<ArrayList<SrvSplitOrderDTO>> splitrslist=calSrvSplitRsApplyQuan((SrvSplitOrderDTO[])splitdos);
		
		if(splitrslist==null || splitrslist.size()==0)return 1;
		ArrayList<SrvSplitOrderDTO> tm=null;
		//逐一遍历
		for(int i=0;i<splitrslist.size();i++){
			tm=splitrslist.get(i);
			if(tm==null)continue;
		
			//基于组的组保存处理
			try{
				saveByGrp_RequiresNew(tm,isCharged);
				succcnt+=1;
			}catch(Exception e){
				failcnt+=1;
				//错误信息处理
			}
		}
		if(failcnt==0)return 1;
		if(succcnt==0)return -1;
		return 0;
	}
	
	/***
	 * 有效性校验
	 * @param param
	 * @throws BizException
	 */
	private void validateCheck(OrSrvSplitParamDTO param) throws BizException{
		if(param==null){
			throw new BizException("入口参数为空错误！");
		}
		if(OrSrvSplitUtil.isOrSplitType(param.getEu_orgensplittp())){
			throw new BizException("生成拆分类型不能为查询有效医嘱类型！");
		}
		orgensplittp=param.getEu_orgensplittp();
	}
	private Integer orgensplittp=-1; 
	
	/***
	 * 获得拆分sql的结果集
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private BaseDTO[] getOrAndSrvSplitSqlRs(OrSrvSplitParamDTO param) throws BizException{
		//If interfacetp = 1查询有效物品服务Then   If .flag_pd=true then ????
		GetOrAndSrvSplitSqlRsBP bp=new GetOrAndSrvSplitSqlRsBP();
		return bp.exec(param);
	}
	
	/***
	 * 获得服务拆分结果请领量计算结果信息
	 * @param srvsplitorders
	 * @return
	 * @throws BizException
	 */
	private ArrayList<ArrayList<SrvSplitOrderDTO>> calSrvSplitRsApplyQuan(SrvSplitOrderDTO[] srvsplitorders) throws BizException{
		SrvSplitRsApplyQuanNBP bp=new SrvSplitRsApplyQuanNBP();
		return bp.exec(srvsplitorders);
	}
	
	/***
	 * 草药处理逻辑
	 * @param tm
	 */
	private void herbApplyDataHandle(ArrayList<SrvSplitOrderDTO> tm){
		//草药逻辑
		if(!OrSrvSplitUtil.isDtSrvTypeSame(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG,tm.get(0).getSd_srvtp(),true))return;
		for(int i=0;i<tm.size();i++){
			tm.get(i).setDt_last_mp(tm.get(i).getDt_end());
		}
	}
	
	/***
	 * 周期性小时频次医嘱处理
	 * @param tm
	 * @throws BizException 
	 */
	private void periodHourApplyDataHandle(ArrayList<SrvSplitOrderDTO> tm) throws BizException{
		//周期性小时频次
		if(OrSrvSplitUtil.isPeriodHourFreq(tm.get(0).getSd_frequnit()))return;
		Hashtable ht=getMaxDateTime(tm);
		String key=null;
		FDateTime dt=null;
		for(int i=0;i<tm.size();i++){
			key=tm.get(i).getId_orsrv();
			dt=(FDateTime)ht.get(key);
			tm.get(i).setDt_last_mp(dt);
		}
	}
	
	/***
	 * 获得最大日期时间
	 * @param tm
	 * @return
	 */
	private Hashtable getMaxDateTime(ArrayList<SrvSplitOrderDTO> tm){
		Hashtable ht=new Hashtable();
		SrvSplitOrderDTO do1=null;
		String key=null;
		FDateTime dt=null;
		for(int i=0;i<tm.size();i++){
			do1=tm.get(i);
			key=do1.getId_orsrv();
			if(ht.containsKey(key)){
				dt=(FDateTime)ht.get(key);
				ht.put(key, OrSrvSplitUtil.getMaxDT(dt, do1.getDt_mp_plan()));
			}else{
				ht.put(key, do1.getDt_mp_plan());
			}
		}
		return ht;
	}
	
	/***
	 * 药品请领保存处理逻辑
	 * @param tm
	 */
	private void mpPharmApplyHandle(ArrayList<SrvSplitOrderDTO> tm){
		MpPharmApplyHandleBP bp=new MpPharmApplyHandleBP();
		bp.equals(tm);
	}
	
	/***
	 * 药品请领保存处理逻辑
	 * @param tm
	 * @throws BizException 
	 */
	private void blOrSplitChargeSave(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged) throws BizException{
		//计费有效性校验
		if(!isCharge(tm,isCharged))return;
		
		BlOrSplitChargeSaveBP bp0=new BlOrSplitChargeSaveBP();
		bp0.exec(tm.get(0));
	}
	
	/***
	 * 是否计费
	 * @param tm
	 * @param isCharged
	 * @return
	 */
	private boolean isCharge(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged){
		FDouble quan_ap=tm.get(0).getQuan_mp_ap();
		if(!isCharged)return false;
		if(quan_ap==null || quan_ap.floatValue()==0)return false;
		return true;
	}
	
	/***
	 * 余量法床边量处理逻辑
	 * @param tm
	 * @param isCharged
	 */
	private void quanBedMeduHandle(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged){
		
		//计费有效性校验
		if(!isCharge(tm,isCharged))return;
		if(!isGrpRemains(tm.get(0)))return;
		
		SrvSplitOrderDTO dto=tm.get(0);
		FDouble quan_bed_ap_medu=getNewQuanBed(dto.getQuan_bed_medu(),dto.getQuan_mp_ap(),dto.getFactor_mb());
		//遍历
		for(int i=0;i<tm.size();i++){
			dto=tm.get(i);
			dto.setQuan_bed_ap_medu(quan_bed_ap_medu);
		}
	}
	
	/***
	 * 获得清零后床边余量
	 * @param remains
	 * @param quan_app
	 * @param factor_mb
	 * @return
	 */
	private FDouble getNewQuanBed(FDouble remains,FDouble quan_app,FDouble factor_mb){
		if(remains==null)remains=new FDouble(0);
		return remains.add(quan_app.multiply(factor_mb));
	}
	
	/***
	 * 医嘱回写
	 * @param tm
	 * @param isCharged
	 * @throws BizException 
	 */
	private void orInfoUpdateAfterSplit(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged) throws BizException{
		OrSrvSplitOrModParamDTO[] params=getOrSrvSplitOrModParams(tm,isCharged);
		CiOrInfoUpdateAfterSplitBP bp=new CiOrInfoUpdateAfterSplitBP();
		bp.exec(params);  //整组的 quan_bed_ap_medu量相同  且仅对余量组有效
	}
	
	/***
	 * 获得医嘱回写参数
	 * @param tm
	 * @return
	 */
	private OrSrvSplitOrModParamDTO[] getOrSrvSplitOrModParams(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged){
		if(tm==null || tm.size()==0)return null;
		Hashtable ht=new Hashtable();
		String key="";
		for(int i=0;i<tm.size();i++){
			key=tm.get(i).getId_orsrv();
			if(ht.containsKey(key)){
				
			}else{
				ht.put(key, getOrSrvSplitOrModParams(tm.get(i),isCharged));
			}
		}
		
		List<OrSrvSplitOrModParamDTO> reList=new ArrayList<OrSrvSplitOrModParamDTO>();
		for (Object obj : ht.values()) {
			reList.add((OrSrvSplitOrModParamDTO)obj);
		}
		return reList.toArray(new OrSrvSplitOrModParamDTO[reList.size()]);
		//return (OrSrvSplitOrModParamDTO[])ht.values().toArray();
	}
	
	/***
	 * 获得最近生成时间
	 * @param tm
	 * @return
	 */
	private OrSrvSplitOrModParamDTO getOrSrvSplitOrModParams(SrvSplitOrderDTO tm,boolean isCharged){
		OrSrvSplitOrModParamDTO rtn=new OrSrvSplitOrModParamDTO();
		rtn.setId_orsrv(tm.getId_orsrv());
		rtn.setId_or(tm.getId_or());
		rtn.setDt_split_end(tm.getDt_last_bl());
		rtn.setEu_orgensplittp(orgensplittp);
		if(isGrpRemains(tm)){
			rtn.setQuan_bed_ap_medu(tm.getQuan_bed_ap_medu());
		}else{
			rtn.setQuan_bed_ap_medu(null);
		}
		rtn.setFg_charged(new FBoolean(isCharged));
		return rtn;
	}
	/***
	 * 余量法分组
	 * @param tm
	 * @return
	 */
	private boolean isGrpRemains(SrvSplitOrderDTO tm){
		return IOrAndSrvSplitConst.SPLITRS_GRPTP_REMAINS.equals(tm.getPkuroundmode());
	}
	
	
	
	/***
	 * 基于组的组保存处理
	 * @throws BizException 
	 */
	private void saveByGrp_RequiresNew(ArrayList<SrvSplitOrderDTO> tm,boolean isCharged) throws BizException{
		//请领保存
		mpPharmApplyHandle(tm);
		
		//草药数据处理规则
		herbApplyDataHandle(tm);
		
		//频次周期小时类型 处理规则
		periodHourApplyDataHandle(tm);
		
		//急费处理逻辑
		blOrSplitChargeSave(tm,isCharged);
		
		//床边量处理
		quanBedMeduHandle(tm,isCharged);
		
		//医嘱回写处理
		orInfoUpdateAfterSplit(tm,isCharged);
	}
	
}
