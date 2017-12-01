package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class getSuperiorDoctor implements IActorListener {
	
	/**
	 * 获取上级查房医师
	 */
	@Override
	public String[] getActors(WfFormInfoCtx wfFormInfoCtx) throws Exception {
		if (!(wfFormInfoCtx instanceof CiMrDO))
		{
			return null;
		}
		CiMrDO ciMrDo = (CiMrDO)wfFormInfoCtx;
		String id_doctor= ciMrDo.getId_emp_higher();
		return new String[]{id_doctor};
	}

}
