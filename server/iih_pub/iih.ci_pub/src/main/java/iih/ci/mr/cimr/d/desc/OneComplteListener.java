package iih.ci.mr.cimr.d.desc;

import java.util.Date;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
//import xap.wf.af.constant.WfTaskCreateType;
import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class OneComplteListener implements IExecutionListener {
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
			ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_TWOLEVELSIGNBY);
			ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_TWOLEVELSIGNBY);
			ciMrDo.setId_emp_audit(Context.get().getUserId());
			ciMrDo.setMast_doctor_date(new FDateTime(new Date()));
			
		} else if (WfTaskFininshType.Reject.equals(finishType)) {
			ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_NEW);
			ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_NEW);
			ciMrDo.setId_emp_audit(null);
			ciMrDo.setMast_doctor_date(null);
			ciMrDo.setDate_submit(null);
			ciMrDo.setId_su_mr(null);
			ciMrDo.setId_submit_dept(null);
		}
		
		Logger.info("二级审签完成");
	}
	
}
