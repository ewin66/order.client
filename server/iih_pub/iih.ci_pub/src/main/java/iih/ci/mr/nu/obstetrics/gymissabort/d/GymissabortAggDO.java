package iih.ci.mr.nu.obstetrics.gymissabort.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.gymissabort.d.desc.GymissabortAggDODesc;



/**
 * 妇科稽留流产护理记录单
 */
public class GymissabortAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public GyMissAbortAssDO getParentDO() {
		return ((GyMissAbortAssDO) super.getParentDO());
	}

	public void setParentDO(GyMissAbortAssDO headDO) {
		setParent(headDO);
	}

	public GyMissAbortRecDO[] getGyMissAbortRecDO() {
		IBaseDO[] dos = getChildren(GyMissAbortRecDO.class);
		if(dos==null) return null;
		GyMissAbortRecDO[] result=new GyMissAbortRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(GyMissAbortRecDO)dos[i];
		}
		return result;
	}
	
	public void setGyMissAbortRecDO(GyMissAbortRecDO[] dos) {
		setChildren(GyMissAbortRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		GymissabortAggDODesc desc = new GymissabortAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new GyMissAbortAssDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.gymissabort.d.GyMissAbortRecDO")) {
             return new GyMissAbortRecDO();
         }
         return null;
     }
}