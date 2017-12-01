package iih.ci.mr.nu.criticalillrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.criticalillrec.d.desc.CriticalillrecAggDODesc;



/**
 * 危重症护理记录单
 */
public class CriticalillrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CriticalillDO getParentDO() {
		return ((CriticalillDO) super.getParentDO());
	}

	public void setParentDO(CriticalillDO headDO) {
		setParent(headDO);
	}

	public CriticalillRecDO[] getCriticalillRecDO() {
		IBaseDO[] dos = getChildren(CriticalillRecDO.class);
		if(dos==null) return null;
		CriticalillRecDO[] result=new CriticalillRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CriticalillRecDO)dos[i];
		}
		return result;
	}
	
	public void setCriticalillRecDO(CriticalillRecDO[] dos) {
		setChildren(CriticalillRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CriticalillrecAggDODesc desc = new CriticalillrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CriticalillDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.criticalillrec.d.CriticalillRecDO")) {
             return new CriticalillRecDO();
         }
         return null;
     }
}