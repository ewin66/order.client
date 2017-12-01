package iih.ci.mr.nu.obstetrics.gynurafter.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.gynurafter.d.desc.GynurafterAggDODesc;



/**
 * 妇科护理记录单(术后)
 */
public class GynurafterAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public GyNurAfterAssDO getParentDO() {
		return ((GyNurAfterAssDO) super.getParentDO());
	}

	public void setParentDO(GyNurAfterAssDO headDO) {
		setParent(headDO);
	}

	public GyNurAfterRecDO[] getGyNurAfterRecDO() {
		IBaseDO[] dos = getChildren(GyNurAfterRecDO.class);
		if(dos==null) return null;
		GyNurAfterRecDO[] result=new GyNurAfterRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(GyNurAfterRecDO)dos[i];
		}
		return result;
	}
	
	public void setGyNurAfterRecDO(GyNurAfterRecDO[] dos) {
		setChildren(GyNurAfterRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		GynurafterAggDODesc desc = new GynurafterAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new GyNurAfterAssDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.gynurafter.d.GyNurAfterRecDO")) {
             return new GyNurAfterRecDO();
         }
         return null;
     }
}