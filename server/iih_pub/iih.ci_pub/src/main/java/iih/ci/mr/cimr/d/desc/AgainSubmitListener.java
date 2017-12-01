package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.utils.WfTaskUtil;

public class AgainSubmitListener implements IExecutionListener{

	/**
	 * 再次提交回写状态
	 */
	@Override
	public void notify(WfEventExecution arg0) throws Exception {
		WfFormInfoCtx inputBillInfo = PwfmContext.getCurrentBpmnSession()
				.getInputBillInfo();
		String userPk = PwfmContext.getCurrentBpmnSession().getCntUserPk();
		TaskInstance taskIns = PwfmContext.getCurrentBpmnSession().getTask();
		TaskInstance startTaskIns = WfTaskUtil.getStartTaskInsByCntTask(taskIns);
		String startUserPk = startTaskIns.getId_owner();
		if(userPk.equals(startUserPk)){
			CiMrDO ciMrDo = (CiMrDO)inputBillInfo;
			ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_SUBMIT);
			ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_SUBMIT);

		}

	}

}
