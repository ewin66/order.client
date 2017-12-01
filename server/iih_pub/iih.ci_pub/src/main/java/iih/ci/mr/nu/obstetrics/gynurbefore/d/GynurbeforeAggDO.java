package iih.ci.mr.nu.obstetrics.gynurbefore.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.gynurbefore.d.desc.GynurbeforeAggDODesc;



/**
 * 妇科护理记录单(非手术、术前)
 */
public class GynurbeforeAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public GyNurBeforeAssDO getParentDO() {
		return ((GyNurBeforeAssDO) super.getParentDO());
	}

	public void setParentDO(GyNurBeforeAssDO headDO) {
		setParent(headDO);
	}

	public GyNurBeforeRecDO[] getGyNurBeforeRecDO() {
		IBaseDO[] dos = getChildren(GyNurBeforeRecDO.class);
		if(dos==null) return null;
		GyNurBeforeRecDO[] result=new GyNurBeforeRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(GyNurBeforeRecDO)dos[i];
		}
		return result;
	}
	
	public void setGyNurBeforeRecDO(GyNurBeforeRecDO[] dos) {
		setChildren(GyNurBeforeRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		GynurbeforeAggDODesc desc = new GynurbeforeAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new GyNurBeforeAssDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.gynurbefore.d.GyNurBeforeRecDO")) {
             return new GyNurBeforeRecDO();
         }
         return null;
     }
}