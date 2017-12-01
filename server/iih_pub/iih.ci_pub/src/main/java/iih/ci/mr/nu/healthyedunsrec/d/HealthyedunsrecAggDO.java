package iih.ci.mr.nu.healthyedunsrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.healthyedunsrec.d.desc.HealthyedunsrecAggDODesc;



/**
 * 健康教育记录
 */
public class HealthyedunsrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public HealthyEduNsDO getParentDO() {
		return ((HealthyEduNsDO) super.getParentDO());
	}

	public void setParentDO(HealthyEduNsDO headDO) {
		setParent(headDO);
	}

	public HealthyEduNsRecDO[] getHealthyEduNsRecDO() {
		IBaseDO[] dos = getChildren(HealthyEduNsRecDO.class);
		if(dos==null) return null;
		HealthyEduNsRecDO[] result=new HealthyEduNsRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(HealthyEduNsRecDO)dos[i];
		}
		return result;
	}
	
	public void setHealthyEduNsRecDO(HealthyEduNsRecDO[] dos) {
		setChildren(HealthyEduNsRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		HealthyedunsrecAggDODesc desc = new HealthyedunsrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new HealthyEduNsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.healthyedunsrec.d.HealthyEduNsRecDO")) {
             return new HealthyEduNsRecDO();
         }
         return null;
     }
}