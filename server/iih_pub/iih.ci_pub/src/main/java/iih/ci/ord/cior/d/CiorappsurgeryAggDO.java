package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.CiorappsurgeryAggDODesc;



/**
 * 手术申请
 */
public class CiorappsurgeryAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApOpDO getParentDO() {
		return ((OrdApOpDO) super.getParentDO());
	}

	public void setParentDO(OrdApOpDO headDO) {
		setParent(headDO);
	}

	public OrdOpEmpDO[] getOrdOpEmpDO() {
		IBaseDO[] dos = getChildren(OrdOpEmpDO.class);
		if(dos==null) return null;
		OrdOpEmpDO[] result=new OrdOpEmpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdOpEmpDO)dos[i];
		}
		return result;
	}
	
	public void setOrdOpEmpDO(OrdOpEmpDO[] dos) {
		setChildren(OrdOpEmpDO.class, dos);
	}
	public OrdOpMmDO[] getOrdOpMmDO() {
		IBaseDO[] dos = getChildren(OrdOpMmDO.class);
		if(dos==null) return null;
		OrdOpMmDO[] result=new OrdOpMmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdOpMmDO)dos[i];
		}
		return result;
	}
	
	public void setOrdOpMmDO(OrdOpMmDO[] dos) {
		setChildren(OrdOpMmDO.class, dos);
	}
	public OrdApSugViewItemDO[] getOrdApSugViewItemDO() {
		IBaseDO[] dos = getChildren(OrdApSugViewItemDO.class);
		if(dos==null) return null;
		OrdApSugViewItemDO[] result=new OrdApSugViewItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdApSugViewItemDO)dos[i];
		}
		return result;
	}
	
	public void setOrdApSugViewItemDO(OrdApSugViewItemDO[] dos) {
		setChildren(OrdApSugViewItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorappsurgeryAggDODesc desc = new CiorappsurgeryAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApOpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.OrdOpEmpDO")) {
             return new OrdOpEmpDO();
         }
	    else if (clzName.equals("iih.ci.ord.cior.d.OrdOpMmDO")) {
             return new OrdOpMmDO();
         }
	    else if (clzName.equals("iih.ci.ord.cior.d.OrdApSugViewItemDO")) {
             return new OrdApSugViewItemDO();
         }
         return null;
     }
}