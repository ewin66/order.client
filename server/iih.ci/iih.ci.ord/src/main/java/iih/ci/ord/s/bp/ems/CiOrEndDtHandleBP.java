package iih.ci.ord.s.bp.ems;

import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.ci.ord.ciorder.d.OrdFreqTimeDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 临床医嘱结束时间处理逻辑操作BP
 */
public class CiOrEndDtHandleBP {
	/**
	 * 获得临床医嘱结束时间信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  FDateTime[] exec(CiEmsDTO ems)  throws BizException{
		if(ems==null)return null;
		FDateTime[] rtn=new FDateTime[2];
		rtn[0]=ems.getDt_begin();
		if(CiOrdUtils.isOpUrgentWf(ems.getCode_entp())){//结束日期=开始日期
			FDateTime fd = new FDateTime();
			if(ems.getDt_end()== null){
				rtn[1]=fd.getDateTimeAfter(ems.getDays_or());
			}else{
				rtn[1]=ems.getDt_end();//zwq 2016-09-28修改 结束日期在前台已经计算赋值	
			}
			//rtn[1]=ems.getDt_begin();
		}else if(CiOrdUtils.isIpWf(ems.getCode_entp())){
			String sd_frequnittp=getSd_Frequnittp(ems.getId_freq());
			if(OrSrvSplitUtil.isTemporaryFreq(sd_frequnittp)){
				rtn[1]=ems.getDt_begin();
			}else if(OrSrvSplitUtil.isPlanFreq(sd_frequnittp) && ems.getCiorfreqtimes() != null && ems.getCiorfreqtimes().size() >0){
				//频次 长期备用 临时备用  没有时刻 todo 
				rtn=getMinMaxDateTime(ems.getCiorfreqtimes());
			}
			else{
				rtn[1]=CiOrdUtils.getCiOrDt_end(ems.getDt_end());
			}
		}
		return rtn;
	}
	
	/**
	 * 获得频次周期类型
	 * @param id_freq
	 * @return
	 * @throws BizException
	 */
	private String getSd_Frequnittp(String id_freq) throws BizException{
		FreqDefDO freqdo=OrSrvSplitUtil.getFreqDefDO(id_freq);
		if(freqdo==null)return "";
		return freqdo.getSd_frequnitct();
	}
	
	/**
	 * 获得最大最小时间
	 */
	private FDateTime[] getMinMaxDateTime(FArrayList orfreqtimes){
		if(orfreqtimes==null || orfreqtimes.size()==0)return null;
		OrdFreqTimeDO do1=(OrdFreqTimeDO)orfreqtimes.get(0);
		FDateTime dt0=getDT(do1.getWdno(),do1.getTime_mp());
		FDateTime[] rtns=new FDateTime[]{dt0,dt0};
		for(int i=1;i<orfreqtimes.size();i++){
			do1=(OrdFreqTimeDO)orfreqtimes.get(i);
			dt0=getDT(do1.getWdno(),do1.getTime_mp());
			rtns[0]=OrSrvSplitUtil.getMinDT(rtns[0], dt0);
			rtns[1]=OrSrvSplitUtil.getMaxDT(rtns[1], dt0);
		}
		//OrdFreqTimeDO0=
		return rtns;
	}
	
	private FDateTime getDT(FDate date,FTime time ){
		return new FDateTime(date,time);
	}
}
