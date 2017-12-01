package iih.ci.mr.cimr.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

    public class EntEmpUtils {
	public String getEnDoc(CiMrDO ciMrDo, String sd_doc) throws BizException
	{
		String id_ent = ciMrDo.getId_ent();
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		MedPsnDTO medPsnDTO = null;
		try {
			medPsnDTO = service.getMedPsn4Mr(id_ent);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(medPsnDTO == null)
			return null;
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		String id_psn = null;
		if("11".equals(sd_doc))
		{
			id_psn = medPsnDTO.getId_emp_phy();
		}
		if("12".equals(sd_doc))
		{
			id_psn = medPsnDTO.getId_zz_doc();
		}
		if("13".equals(sd_doc))
		{
			id_psn = medPsnDTO.getId_zr_doc();
		}
		UserDO[] userDos = userService.find(" a0.id_psn = '" + id_psn +"'", null, FBoolean.FALSE);
		if(userDos == null || userDos.length == 0)
			return null;
		return userDos[0].getId_user();
		
	}
	
	public String GetUserEmpId(String id_user) throws BizException
	{
		if(id_user == null || "".equals(id_user))
			return null;
		IUserRService userService = ServiceFinder.find(IUserRService.class);
		UserDO userDo = userService.findById(id_user);
		if(userDo == null)
			return null;
		String id_psn = userDo.getId_psn();
		return id_psn;
		
	}

}
