package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class ThreeComplteListener implements IExecutionListener{
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution context) throws Exception {
		Logger.info("任务完成后，更新单据状态");
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

		WfTaskFininshType finishType = taskIns.getFinishType();
		WfFormInfoCtx inner = inputBillInfo;
		if (!(inner instanceof CiMrDO)) {
			return;
		} 
		CiMrDO ciMrDo = (CiMrDO) inner;
		if (WfTaskFininshType.Normal.equals(finishType)) {
			ciMrDo.setId_su_mr("流程结束！");
		} else if (WfTaskFininshType.Reject.equals(finishType)) {
			ciMrDo.setId_su_mr("三级审签驳回");
//				String title = (String)billDo.getAttributeValue("test_title");
//				targetTaskIns[0].setTitile(title);
//				targetTaskIns[0].asyn();
		}
		
		Logger.info("The status of purchase plan had been updated.");
	}

}
