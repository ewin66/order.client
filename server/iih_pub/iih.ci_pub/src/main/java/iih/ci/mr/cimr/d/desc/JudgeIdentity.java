package iih.ci.mr.cimr.d.desc;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.permfw.user.i.IUserRService;
import xap.wf.af.exception.WfRuntimeException;

public class JudgeIdentity {
	
	public enum identity{
		gcdoctor,
		zzdoctor,
		zrdoctor,
		others
	}
	IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
	IUserRService ss= ServiceFinder.find(IUserRService.class);
	/**
	 * 三级审签判断用户当前位置
	 * @throws BizException 
	 */
	public  identity  getThreeIdentity(String  iduser,String id_ent) throws BizException
	{
		String gcid;
		String zzid;
		String zrid;
		if(id_ent==null||id_ent.equals(""))
		{
			throw new WfRuntimeException("JudgeIdentity：文书就诊号为空");
		}
		MedPsnDTO patVisitenDo = null;
		try {
			patVisitenDo = service.getMedPsn4Mr(id_ent);
		} catch (BizException e) {
			throw new WfRuntimeException("JudgeIdentity："+e.getMessage());
		}	
		
		if(patVisitenDo == null )
		{
			throw new WfRuntimeException("JudgeIdentity：患者DTO为空");
		}
		else
		{
			 String s=  patVisitenDo.getId_emp_phy();
			 gcid=ss.find("a0.ID_PSN = '"+patVisitenDo.getId_emp_phy()+"'", "", FBoolean.FALSE)[0].getId_user();
			 zzid=ss.find("a0.ID_PSN = '"+patVisitenDo.getId_zz_doc()+"'", "", FBoolean.FALSE)[0].getId_user();
			 zrid=ss.find("a0.ID_PSN = '"+patVisitenDo.getId_zr_doc()+"'", "", FBoolean.FALSE)[0].getId_user();
		}
		
		if(zrid==null ||zrid.equals(""))
		{
			throw new WfRuntimeException("JudgeIdentity：患者zr医师为空");
		}
		if(iduser.equals(zrid))//patVisitenDo.getZr_doc_id()
		{
			return identity.zrdoctor;
		}
		
		if(zzid==null ||zzid.equals(""))
		{
			throw new WfRuntimeException("JudgeIdentity：患者zz医师为空");
		}
		if(iduser.equals(zzid))//patVisitenDo.getZz_doc_id()
		{
			return identity.zzdoctor;
		}
		
		if(gcid==null ||gcid.equals(""))
		{
			throw new WfRuntimeException("JudgeIdentity：患者gc医师为空");
		}
		if(iduser.equals(gcid))//patVisitenDo.getEmp_phy_id()
		{
			return identity.gcdoctor;
		}
		return identity.others;
	}
	
	
	
	public enum rounddocrot{
		supdoctor,//上级医师
		subdoctor,//下级医师
	}
	/**
	 * 上级医师查房记录判断用所走流程
	 */
	public  rounddocrot  getSuperDoctor(String  iduser,CiMrDO cimrdo)
	{
		if(cimrdo.getId_emp_higher()==null ||cimrdo.getId_emp_higher().equals(""))
		{
			throw new WfRuntimeException("JudgeIdentity：患者上级查房医师医师为空");
		}
		if(iduser.equals(cimrdo.getId_emp_higher()))
		{
			return rounddocrot.supdoctor;
		}
		
	    return rounddocrot.subdoctor;
	}

}
