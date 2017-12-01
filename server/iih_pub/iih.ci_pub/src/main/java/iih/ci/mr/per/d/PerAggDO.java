package iih.ci.mr.per.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.per.d.desc.PerAggDODesc;



/**
 * 组件
 */
public class PerAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public PerDO getParentDO() {
		return ((PerDO) super.getParentDO());
	}

	public void setParentDO(PerDO headDO) {
		setParent(headDO);
	}

	public PerListDO[] getPerListDO() {
		IBaseDO[] dos = getChildren(PerListDO.class);
		if(dos==null) return null;
		PerListDO[] result=new PerListDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(PerListDO)dos[i];
		}
		return result;
	}
	
	public void setPerListDO(PerListDO[] dos) {
		setChildren(PerListDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		PerAggDODesc desc = new PerAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new PerDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.per.d.PerListDO")) {
             return new PerListDO();
         }
         return null;
     }
}