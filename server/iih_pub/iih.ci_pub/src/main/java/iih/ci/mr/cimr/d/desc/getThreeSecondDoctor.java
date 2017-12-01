package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.event.IActorListener;
import xap.wf.af.server.WfFormInfoCtx;

/**
 * 三级审签时获取二级审签医师
 */

public class getThreeSecondDoctor implements IActorListener {

	@Override
	public String[] getActors(WfFormInfoCtx wfFormInfoCtx) throws Exception {
		//wfFormInfoCtx=new CiMrDO();
		if (!(wfFormInfoCtx instanceof CiMrDO))
		{
			return null;
		}
		CiMrDO ciMrDo = (CiMrDO)wfFormInfoCtx;
		//ciMrDo.setId_ent("1001Z7100000000GEM3H");
		
		String id_ent = ciMrDo.getId_ent();
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		MedPsnDTO patVisitenDo = null;
		try {
			patVisitenDo = service.getMedPsn4Mr(id_ent);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(patVisitenDo == null)
			return null;
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		String id_psn = patVisitenDo.getId_zz_doc();
		UserDO[] userDos = userService.find(" a0.id_psn = '" + id_psn +"'", null, FBoolean.FALSE);
		if(userDos == null || userDos.length == 0)
			return null;
		String id_user = userDos[0].getId_user();
		Logger.info("取二级审签医师：" + id_user);
		return new String[]{id_user};
	}

}
