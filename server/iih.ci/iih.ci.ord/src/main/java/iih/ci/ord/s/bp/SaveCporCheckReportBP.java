package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

public class SaveCporCheckReportBP {
	
	public CiOrderDO[] exec(OrdSrvDO[] orsrvdos,String[] id_ors) throws BizException{
		
		CiOrdAppUtils.getICiorderSrvDOCudService().save(orsrvdos);
		CiOrderDO[] ords =  CiOrdAppUtils.getCiorderMDORService().findByIds(id_ors, FBoolean.FALSE);
		outer: for(CiOrderDO order : ords){
			for(OrdSrvDO orsrvdo :orsrvdos){
				if(orsrvdo.getFg_hpindicjudged()==HpIndicJudgeEnum.WAITINGJUDGE){
					order.setEu_hpindicjudge(HpIndicJudgeEnum.WAITINGJUDGE);
					order.setStatus(DOStatus.UPDATED);
					continue outer;
				}
					
			}
			order.setEu_hpindicjudge(HpIndicJudgeEnum.JUDGED);
			order.setStatus(DOStatus.UPDATED);
		}
		return CiOrdAppUtils.getOrService().save(ords);
	}
}
