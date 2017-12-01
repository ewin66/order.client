package iih.ci.mr.nu.chidrenass.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.chidrenass.d.desc.ChidrenassAggDODesc;



/**
 * 高危儿观察护理记录单
 */
public class ChidrenassAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public ChildrenInAsseDO getParentDO() {
		return ((ChildrenInAsseDO) super.getParentDO());
	}

	public void setParentDO(ChildrenInAsseDO headDO) {
		setParent(headDO);
	}

	public ChildrenInAsseNurRecordDO[] getChildrenInAsseNurRecordDO() {
		IBaseDO[] dos = getChildren(ChildrenInAsseNurRecordDO.class);
		if(dos==null) return null;
		ChildrenInAsseNurRecordDO[] result=new ChildrenInAsseNurRecordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(ChildrenInAsseNurRecordDO)dos[i];
		}
		return result;
	}
	
	public void setChildrenInAsseNurRecordDO(ChildrenInAsseNurRecordDO[] dos) {
		setChildren(ChildrenInAsseNurRecordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		ChidrenassAggDODesc desc = new ChidrenassAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new ChildrenInAsseDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.chidrenass.d.ChildrenInAsseNurRecordDO")) {
             return new ChildrenInAsseNurRecordDO();
         }
         return null;
     }
}