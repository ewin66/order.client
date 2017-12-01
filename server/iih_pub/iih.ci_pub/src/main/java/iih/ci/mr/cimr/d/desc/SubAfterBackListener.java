package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;

import java.util.Date;

import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.wf.af.bpmn.UserTaskActivity;
import xap.wf.af.constant.WfTaskFininshType;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.graph.IPort;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class SubAfterBackListener implements IExecutionListener {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(WfEventExecution context) throws Exception {
		Logger.info("任务完成后，更新单据状态");
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		if(taskIns==null){
			return;
		}
		IPort port = taskIns.getNodeInstance().getPort();//获得节点
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
		CiMrDO billDo = (CiMrDO) inner;
		if (WfTaskFininshType.Normal.equals(finishType)) {
			billDo.setId_su_mr(SuMrConst.ID_SUMR_THREELEVELSIGNBY);
			billDo.setSd_su_mr(SuMrConst.SD_SUMR_TWOLEVELSIGNBY);
			billDo.setDir_doctor_date(new FDateTime(new Date()));
			billDo.setId_emp_audit(billDo.getId_dir_doctor());
		} else if (WfTaskFininshType.Reject.equals(finishType)) {
			billDo.setId_su_mr(SuMrConst.ID_SUMR_INTWOLEVELAUDIT);
			billDo.setSd_su_mr(SuMrConst.SD_SUMR_INTWOLEVELAUDIT);
			billDo.setId_emp_audit(null);
			billDo.setMast_doctor_date(null);
			billDo.setDir_doctor_date(null);
		}
		
		Logger.info("三级审签完成");
	}


}
