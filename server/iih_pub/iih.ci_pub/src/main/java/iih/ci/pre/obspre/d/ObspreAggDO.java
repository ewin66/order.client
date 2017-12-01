package iih.ci.pre.obspre.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.pre.obspre.d.desc.ObspreAggDODesc;



/**
 * 预检
 */
public class ObspreAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ObsPreDO getParentDO() {
		return ((ObsPreDO) super.getParentDO());
	}

	public void setParentDO(ObsPreDO headDO) {
		setParent(headDO);
	}

	public ObsPreSrvDO[] getObsPreSrvDO() {
		IBaseDO[] dos = getChildren(ObsPreSrvDO.class);
		if(dos==null) return null;
		ObsPreSrvDO[] result=new ObsPreSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ObsPreSrvDO)dos[i];
		}
		return result;
	}
	
	public void setObsPreSrvDO(ObsPreSrvDO[] dos) {
		setChildren(ObsPreSrvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ObspreAggDODesc desc = new ObspreAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ObsPreDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.pre.obspre.d.ObsPreSrvDO")) {
             return new ObsPreSrvDO();
         }
         return null;
     }
}