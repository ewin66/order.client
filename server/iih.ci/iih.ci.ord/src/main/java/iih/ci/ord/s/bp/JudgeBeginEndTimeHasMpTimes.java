package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.freqdef.d.FreqTimeDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;

/**
 * 判断开始和结束日期之间是否有有效执行顿数
 * @author Administrator
 *
 */
public class JudgeBeginEndTimeHasMpTimes {
	public void exec(FDateTime[] dts,String id_freq) throws BizException{
		if(CiOrdUtils.isEmpty(id_freq)) return;
		if(!this.validate(dts)) return;
		FreqDefDO defDO = CiOrdAppUtils.getFreqdefMDORService().findById(id_freq);
		if(CiOrdUtils.isEmpty(defDO)) return;
		FreqTimeDO[] fTimeDos = CiOrdAppUtils.getFreqTimeDORService().find("id_freq='"+id_freq+"'", "sortno", FBoolean.FALSE);
		if(CiOrdUtils.isEmpty(fTimeDos)) return;
		String sd_fre = defDO.getSd_frequnitct();//频次的sd
		if(IBdSrvDictCodeConst.SD_FREQNUNITCT_DAY.equals(sd_fre)){//天
			boolean flag = false;
			for(int i=0;i<fTimeDos.length;i++){
				FDateTime dtLast = null;
				if(fTimeDos[i].getWdno()==1){
					dtLast = new FDateTime(dts[0].getBeginDate().getDateAfter(fTimeDos[i].getWdno()-1),fTimeDos[i].getTime_mp());
					if(!CiOrdUtils.isEmpty(dtLast)){
						dtLast = dts[0].compareTo(dtLast)>0?new FDateTime(dts[0].getBeginDate().getDateAfter(fTimeDos[i].getWdno()),fTimeDos[i].getTime_mp()):dtLast;
						if(dts[0].compareTo(dtLast)<=0&&dts[1].compareTo(dtLast)>=0){
							flag = true;
							break;
						}
					}
				}else{
					dtLast = new FDateTime(dts[0].getBeginDate().getDateAfter(fTimeDos[i].getWdno()),fTimeDos[i].getTime_mp());
					if(!CiOrdUtils.isEmpty(dtLast)){
						if(dts[0].compareTo(dtLast)<=0&&dts[1].compareTo(dtLast)>=0){
							flag = true;
							break;
						}
					}
				}
			}
			if(!flag){
				throw new BizException("开始结束时间内没有有效执行顿数！");
			}
		}else if(IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(sd_fre)){//周
			int week = dts[0].getWeek();//开始时间是周几
			boolean flag = false;
			for(int i=0;i<fTimeDos.length;i++){
				int weekPlan = fTimeDos[i].getWdno();
				FDateTime dtLast = null;
				if(weekPlan < week){
					dtLast = new FDateTime(dts[0].getBeginDate().getDateAfter(7-week+weekPlan),fTimeDos[i].getTime_mp());
				}else{
					dtLast = new FDateTime(dts[0].getBeginDate().getDateAfter(weekPlan-week),fTimeDos[i].getTime_mp());
				}
				if(!CiOrdUtils.isEmpty(dtLast)){
					if(dts[0].compareTo(dtLast)<=0&&dts[1].compareTo(dtLast)>=0){
						flag = true;
						break;
					}
				}
			}
			if(!flag){
				throw new BizException("开始结束时间内没有有效执行顿数！");
			}
		}
	}
	private boolean validate(FDateTime[] dts){
		if(CiOrdUtils.isEmpty(dts)){
			return false;
		}
		
		if(CiOrdUtils.isEmpty(dts[0])||dts[0] == null){return false;}
		if(CiOrdUtils.isEmpty(dts[1])||dts[1] == null){return false;}
		return true;
	}
}
