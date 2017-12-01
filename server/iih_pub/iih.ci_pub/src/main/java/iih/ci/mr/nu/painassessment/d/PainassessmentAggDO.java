package iih.ci.mr.nu.painassessment.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.painassessment.d.desc.PainassessmentAggDODesc;



/**
 * 疼痛护理评估表
 */
public class PainassessmentAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PainAssessDO getParentDO() {
		return ((PainAssessDO) super.getParentDO());
	}

	public void setParentDO(PainAssessDO headDO) {
		setParent(headDO);
	}

	public PainAssessItmDO[] getPainAssessItmDO() {
		IBaseDO[] dos = getChildren(PainAssessItmDO.class);
		if(dos==null) return null;
		PainAssessItmDO[] result=new PainAssessItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PainAssessItmDO)dos[i];
		}
		return result;
	}
	
	public void setPainAssessItmDO(PainAssessItmDO[] dos) {
		setChildren(PainAssessItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PainassessmentAggDODesc desc = new PainassessmentAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PainAssessDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.painassessment.d.PainAssessItmDO")) {
             return new PainAssessItmDO();
         }
         return null;
     }
}