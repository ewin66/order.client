package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.CiorappbtAggDODesc;



/**
 * 备血申请单
 */
public class CiorappbtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApBtDO getParentDO() {
		return ((OrdApBtDO) super.getParentDO());
	}

	public void setParentDO(OrdApBtDO headDO) {
		setParent(headDO);
	}

	public OrdApBtViewItemDO[] getOrdApBtViewItemDO() {
		IBaseDO[] dos = getChildren(OrdApBtViewItemDO.class);
		if(dos==null) return null;
		OrdApBtViewItemDO[] result=new OrdApBtViewItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdApBtViewItemDO)dos[i];
		}
		return result;
	}
	
	public void setOrdApBtViewItemDO(OrdApBtViewItemDO[] dos) {
		setChildren(OrdApBtViewItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorappbtAggDODesc desc = new CiorappbtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApBtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.OrdApBtViewItemDO")) {
             return new OrdApBtViewItemDO();
         }
         return null;
     }
}