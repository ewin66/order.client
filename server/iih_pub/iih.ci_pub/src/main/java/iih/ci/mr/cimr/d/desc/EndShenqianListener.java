package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.server.WfFormInfoCtx;

public class EndShenqianListener implements IExecutionListener{
	
	/**
	 * 审签完成回写状态
	 */
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		if(inputBillInfo==null){
			return;
		}
		CiMrDO ciMrDo = (CiMrDO)inputBillInfo;
		ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_COMPLETE);
		ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_COMPLETE);
		
		
	}

}
