package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.server.WfFormInfoCtx;

public class StartShenqianListener implements IExecutionListener{
	/**
	 * 开始审签回写状态  已提交
	 */
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		if(inputBillInfo==null){
			return ;
		}
		CiMrDO ciMrDo = (CiMrDO)inputBillInfo;
		ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_SUBMIT);	
		ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_SUBMIT);
	}

}
