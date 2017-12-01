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

public class SaveHealthCheckReportBP {
	
	public CiOrderDO[] exec(OrdSrvDO[] orsrvdos,String[] id_ors) throws BizException{
		//bug:0110074 点医嘱列表上的"保"字，修改医保适应症，保存后医嘱内容重复拼接 by yzh 2017-11-02 09:30:14
		for (OrdSrvDO orsrvdo : orsrvdos) {
			orsrvdo.setName(orsrvdo.getName_srv());
		}
		CiOrdAppUtils.getICiorderSrvDOCudService().save(orsrvdos);
		CiOrderDO[] ords =  CiOrdAppUtils.getCiorderMDORService().findByIds(id_ors, FBoolean.FALSE);
		//outer: 
			for(CiOrderDO order : ords){
				order.setFg_orhp(FBoolean.FALSE);
				order.setEu_hpindicjudge(HpIndicJudgeEnum.JUDGED);
				order.setStatus(DOStatus.UPDATED);
				for(OrdSrvDO orsrvdo :orsrvdos){
					if(orsrvdo.getId_or().equals(order.getId_or())){
						if(orsrvdo.getFg_hpindicjudged()==HpIndicJudgeEnum.WAITINGJUDGE){
							order.setEu_hpindicjudge(HpIndicJudgeEnum.WAITINGJUDGE);
						}
						if(orsrvdo.getFg_selfpay().equals(FBoolean.FALSE)){
							order.setFg_orhp(FBoolean.TRUE);
						}
						//order.setStatus(DOStatus.UPDATED);
						//continue outer;
					}
						
				}
		}
		return CiOrdAppUtils.getOrService().save(ords);
	}
}
