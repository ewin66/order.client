package iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.treat;

import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseSetAction;
import iih.ci.ord.s.ems.biz.op.tmpl.gj.ortmpl.treat.bp.TmplTreatSaveBP;
/**
 * 治疗医疗单逻辑执行器
 * @author wangqingzhu
 *
 */
public class TmplTreatAction extends EmsBaseSetAction {

	public TmplTreatAction() {
		
//		setEmsLoadBP(new TmplTreatLoadBP());
		setEmsSaveBP(new TmplTreatSaveBP());
	}
  
}
