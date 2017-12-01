package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.d.desc.JudgeIdentity.identity;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class ThreeGCListener implements ILogicDecision {
	/**
	 * 三级医师查房记录 线监听 管床
	 */
	@Override
	public boolean judge(TaskInstance task, SequenceFlow sf,
			WfFormInfoCtx... formVo) {
		String userId =  Context.get().getUserId();
		if(formVo==null || formVo.length<=0)
			return false;
		
		
		CiMrDO ciMrDo = (CiMrDO)formVo[0];
		if(ciMrDo==null){
			return true;
		}
		String id_ent = ciMrDo.getId_ent();
		JudgeIdentity jui=new JudgeIdentity();
		try {
			identity iduser=jui.getThreeIdentity(userId, id_ent);
			if(iduser.equals(identity.gcdoctor)||iduser.equals(identity.others))
			{
				return true;
			}
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

}
