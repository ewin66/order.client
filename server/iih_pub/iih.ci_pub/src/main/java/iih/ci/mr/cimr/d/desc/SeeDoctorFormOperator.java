package iih.ci.mr.cimr.d.desc;
import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimr.i.ICiemrCudService;
import iih.ci.mr.cimr.i.ICiemrRService;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;

import java.util.Map;

import xap.mw.core.data.BaseDO;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;
import xap.wf.af.bpmn.ProcessDefinition;
import xap.wf.af.bpmn.TaskActivity;
import xap.wf.af.contanier.ProDefsContainer;
import xap.wf.af.context.WfFlowInfoCtx;
import xap.wf.af.engine.IWfBillExtHandler;
import xap.wf.af.engine.TaskProcessUI;
import xap.wf.af.exception.WfRuntimeException;
import xap.wf.af.itf.IWfProDefQry;
import xap.wf.af.server.WfFormInfoCtx;
import xap.wf.af.services.WfServiceFacility;
import xap.wf.af.vos.d.WfProdefDO;
/**
 * 业务流,默认扩展实现类，  回写
 * 
 * @author Bai_He
 *
 */
public class SeeDoctorFormOperator implements IWfBillExtHandler {
	@Override
	public void afterDeleteProDef(ProcessDefinition proDef) {
		// TODO Auto-generated method stub
	}
	@Override
	public void afterInsertProDef(ProcessDefinition proDef, boolean newversion) {
		// TODO Auto-generated method stub
	}
	@Override
	public void afterUpdateProDef(ProcessDefinition proDef) {
		// TODO Auto-generated method stub
	}
	@Override
	public void beforeShowDesigner(String pk_prodef) {
		// TODO Auto-generated method stub
	}
	@Override
	public Map<String, String> getFormFields(BaseDO formvo, String id_prodef) {
		return null;
	}
	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef, TaskActivity task) {
		return null;
	}
	@Override
	public ProcessDefinition getProDefByFlowType(String flowTypePk, boolean isFormCache) {
		IWfProDefQry proDefQry = WfServiceFacility.getProDefQry();
		WfProdefDO[] proDefVos = proDefQry.getProDefByFlwTypePk(flowTypePk);
		return ProDefsContainer.getProDef(proDefVos[0]);
	}
	@Override
	public WfFormInfoCtx getWfmFormInfoCtx(String pk_frmins, String pk_flwtype) {
		return null;
	}
	@Override
	public WfFormInfoCtx[] write(WfFlowInfoCtx flwInfoCtx, WfFormInfoCtx... frmInfoCtx) {
		if (frmInfoCtx.length == 1) { 
			WfFormInfoCtx billInfo = frmInfoCtx[0];
			if (billInfo instanceof CiMrDO) {
				CiMrDO cimrDo = (CiMrDO) billInfo;
				
				ICiemrCudService  s = ServiceFinder.find(ICiemrCudService.class);
				if (cimrDo.getPkVal() == null) {
					try {
						CiMrDO cido=s.insert(new CiMrDO[] { cimrDo })[0];
					} catch (Throwable e) {
						throw new WfRuntimeException(e.getMessage());
					}
				} else {
					try {
     					cimrDo.setStatus(DOStatus.UPDATED);
     					ICiemrRService r = ServiceFinder.find(ICiemrRService.class);
						CiMrDO now = r.findById(cimrDo.getId_mr());
						cimrDo.setSv(now.getSv());	
     					CiMrDO cido=s.update(new CiMrDO[] { cimrDo })[0];
					} catch (Throwable e) {
						throw new WfRuntimeException(e.getMessage());
					}
				}
			}
		}
		return frmInfoCtx;
	}
	@Override
	public TaskProcessUI getPersonlizationUrl(ProcessDefinition proDef, TaskActivity task, WfFormInfoCtx infoCtx) {
		// TODO Auto-generated method stub
		return null;
	}
}
