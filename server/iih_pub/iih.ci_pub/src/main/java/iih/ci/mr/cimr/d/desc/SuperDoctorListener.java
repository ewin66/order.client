package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.JudgeIdentity.identity;
import iih.ci.mr.cimr.d.desc.JudgeIdentity.rounddocrot;
import xap.mw.core.data.Context;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class SuperDoctorListener implements ILogicDecision {
	/**
	 * 上级医师查房线接听，判断是上级医师
	 */
	@Override
	public boolean judge(TaskInstance arg0, SequenceFlow arg1,
			WfFormInfoCtx... formVo) {
		String userId =  Context.get().getUserId();
		if(formVo==null || formVo.length<=0)
			return false;
		
		
		CiMrDO ciMrDo = (CiMrDO)formVo[0];
		JudgeIdentity jui=new JudgeIdentity();
		if(jui.getSuperDoctor(userId, ciMrDo).equals(rounddocrot.supdoctor))
		{
			return true;
		}
		return false;
	}

}
