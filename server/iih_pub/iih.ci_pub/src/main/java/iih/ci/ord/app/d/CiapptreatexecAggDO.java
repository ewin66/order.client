package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiapptreatexecAggDODesc;



/**
 * 门诊诊疗执行单
 */
public class CiapptreatexecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppTreatExecDO getParentDO() {
		return ((CiAppTreatExecDO) super.getParentDO());
	}

	public void setParentDO(CiAppTreatExecDO headDO) {
		setParent(headDO);
	}

	public CiAppTreatExecOrDO[] getCiAppTreatExecOrDO() {
		IBaseDO[] dos = getChildren(CiAppTreatExecOrDO.class);
		if(dos==null) return null;
		CiAppTreatExecOrDO[] result=new CiAppTreatExecOrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppTreatExecOrDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppTreatExecOrDO(CiAppTreatExecOrDO[] dos) {
		setChildren(CiAppTreatExecOrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiapptreatexecAggDODesc desc = new CiapptreatexecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppTreatExecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppTreatExecOrDO")) {
             return new CiAppTreatExecOrDO();
         }
         return null;
     }
}