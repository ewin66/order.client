package iih.ci.mr.cimr.d.desc;

import iih.bd.bc.udi.pub.SuMrConst;
import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.context.PwfmContext;
import xap.wf.af.event.IExecutionListener;
import xap.wf.af.event.WfEventExecution;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.utils.WfTaskUtil;

public class ThreeZRejectListener implements IExecutionListener{
	/**
	 * 三级医师查房记录  主任监听驳回
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
			ciMrDo.setId_su_mr(SuMrConst.ID_SUMR_REJECT);
			ciMrDo.setSd_su_mr(SuMrConst.SD_SUMR_REJECT);
		}
		
		String node_code = PwfmContext.getCurrentBpmnSession().getResponse()
				.getOutPutTaskInstances()[0].getNodeInstance().getNodeInsDO()
				.getNodeins_code();
		
	    if(node_code.equals("2")){ //第一个节点
	    	
	    }
	    
	}

}
