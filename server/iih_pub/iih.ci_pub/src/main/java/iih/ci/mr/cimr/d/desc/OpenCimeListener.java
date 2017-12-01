package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.utils.WfTaskUtil;

public class OpenCimeListener implements IExecutionListener{
	/**
	 * 文书打开回写状态  审签中
	 */
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		// TODO Auto-generated method stub
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		
		TaskInstance taskIn = PwfmContext.getCurrentBpmnSession().getTask();
		TaskInstance startTaskIns = WfTaskUtil.getStartTaskInsByCntTask(taskIn);
		TaskInstance[] tasks = WfTaskUtil.getAllPreTaskByCntTask(taskIn);
		String exeUser = tasks[0].getId_executer();
		if(exeUser.equals(startTaskIns.getId_owner())){
			CiMrDO ciMrDo = (CiMrDO)inputBillInfo;
			ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_SIGNING);
			ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_SIGNING);
		}
		
	}

}
