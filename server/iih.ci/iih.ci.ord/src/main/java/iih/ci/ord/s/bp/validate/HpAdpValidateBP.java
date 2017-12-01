package iih.ci.ord.s.bp.validate;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import xap.mw.core.data.BizException;

/*
 * 医保适应症检查操作BP
 */
public class HpAdpValidateBP {
	/**
	 * 医保适应症检查
	 * @throws BizException
	 */
	public void exec(CiorderAggDO aggor) throws BizException{
        if(aggor != null && aggor.getOrdSrvDO().length > 0){
        	if(HpIndicJudgeEnum.WAITINGJUDGE == aggor.getParentDO().getEu_hpindicjudge()){
    			throw new BizException(aggor.getParentDO().getName_or() +"：是 待判断的医嘱");
    		}
        	//判断项目级别的 
        	/*for(OrdSrvDO ordSrv :aggor.getOrdSrvDO()){
        	 
        		public static final Integer NONEEDJUDGE=0; //不需要判断
        		public static final Integer WAITINGJUDGE=1; //待判断
        		public static final Integer JUDGED=2; //已判断
        		
        	}*/
        }
	}
}
