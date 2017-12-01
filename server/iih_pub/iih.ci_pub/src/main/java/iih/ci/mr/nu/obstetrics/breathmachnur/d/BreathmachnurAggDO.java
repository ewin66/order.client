package iih.ci.mr.nu.obstetrics.breathmachnur.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.breathmachnur.d.desc.BreathmachnurAggDODesc;



/**
 * 呼吸机治疗观察记录单
 */
public class BreathmachnurAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BreathMachInfoDO getParentDO() {
		return ((BreathMachInfoDO) super.getParentDO());
	}

	public void setParentDO(BreathMachInfoDO headDO) {
		setParent(headDO);
	}

	public BreathMachRecDO[] getBreathMachRecDO() {
		IBaseDO[] dos = getChildren(BreathMachRecDO.class);
		if(dos==null) return null;
		BreathMachRecDO[] result=new BreathMachRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BreathMachRecDO)dos[i];
		}
		return result;
	}
	
	public void setBreathMachRecDO(BreathMachRecDO[] dos) {
		setChildren(BreathMachRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BreathmachnurAggDODesc desc = new BreathmachnurAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BreathMachInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.breathmachnur.d.BreathMachRecDO")) {
             return new BreathMachRecDO();
         }
         return null;
     }
}