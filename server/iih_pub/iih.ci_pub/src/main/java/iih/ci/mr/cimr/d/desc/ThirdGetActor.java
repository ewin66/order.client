package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.EntEmpUtils;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

public class ThirdGetActor implements IActorListener{
	/**ss
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getActors(WfFormInfoCtx arg0) throws Exception {
		// TODO Auto-generated method stub
		if (!(arg0 instanceof CiMrDO))
		{
			return null;
		}
		CiMrDO ciMrDo = (CiMrDO)arg0;
		EntEmpUtils entUtils = new EntEmpUtils();
		String id_user = entUtils.getEnDoc(ciMrDo, "13");
		return new String[]{id_user};
	}
}
