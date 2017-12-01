package iih.ci.mr.cimr.d.desc;

import java.util.Date;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
//import xap.wf.af.constant.WfTaskCreateType;

public class OneLastListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;   
	 


	@Override
	public void notify(WfEventExecution context) throws Exception {
		Logger.info("任务创建后,更新单据状态");
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if(taskIns==null){
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();
		
		
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		if (!(port instanceof UserTaskActivity)) {
			return;
		} 
		WfFormInfoCtx inner = inputBillInfo;

		if (!(inner instanceof CiMrDO)) {
			return;
		} 
		CiMrDO ciMrDo = (CiMrDO) inner;
		ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_SUBMIT);
		ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_SUBMIT);
		ciMrDo.setDate_submit(new FDateTime(new Date()));
		ciMrDo.setId_emp_submit(Context.get().getUserId());
		ciMrDo.setId_submit_dept(Context.get().getDeptId());
		Logger.info("提交完成");

	
	}
	
}
