package iih.ci.mr.cimr.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.en.pv.dto.d.MedPsnDTO;
import iih.en.pv.dto.d.PativisitensonDTO;
import iih.en.pv.i.IEnOutQryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.SequenceFlow;
import xap.wf.af.engine.ILogicDecision;
import xap.wf.af.runtime.TaskInstance;
import xap.wf.af.server.WfFormInfoCtx;

public class EmpSubListener implements ILogicDecision
 {

	@Override
	public boolean judge(TaskInstance task, SequenceFlow sf,
			WfFormInfoCtx... formVo) {
		// TODO Auto-generated method stub
		String userId =  Context.get().getUserId();
		String deptId =  Context.get().getDeptId();
		if(formVo==null || formVo.length<=0)
			return false;
		CiMrDO ciMrDo = (CiMrDO)formVo[0];
		String id_ent = ciMrDo.getId_ent();
		EntEmpUtils entUtils = new EntEmpUtils();
		String id_psn = null;
		try {
			id_psn = entUtils.GetUserEmpId(userId);
		} catch (BizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IEnOutQryService service = ServiceFinder.find(IEnOutQryService.class);
		MedPsnDTO medPsnDTO = null;
		try {
			medPsnDTO = service.getMedPsn4Mr(id_ent);
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	
		if(medPsnDTO != null && medPsnDTO.getId_emp_phy() != null && medPsnDTO.getId_emp_phy().equals(id_psn)
				&&(medPsnDTO.getId_zz_doc() == null || !medPsnDTO.getId_zz_doc().equals(id_psn))
				&&(medPsnDTO.getId_zr_doc() == null || !medPsnDTO.getId_zr_doc().equals(id_psn))
				)			
			return true;
		
		return false;
	}

}
