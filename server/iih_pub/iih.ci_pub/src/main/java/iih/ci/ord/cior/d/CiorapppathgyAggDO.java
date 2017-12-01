package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.CiorapppathgyAggDODesc;



/**
 * 病理申请单
 */
public class CiorapppathgyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApPathgyDO getParentDO() {
		return ((OrdApPathgyDO) super.getParentDO());
	}

	public void setParentDO(OrdApPathgyDO headDO) {
		setParent(headDO);
	}

	public OrdApPathgySampDO[] getOrdApPathgySampDO() {
		IBaseDO[] dos = getChildren(OrdApPathgySampDO.class);
		if(dos==null) return null;
		OrdApPathgySampDO[] result=new OrdApPathgySampDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdApPathgySampDO)dos[i];
		}
		return result;
	}
	
	public void setOrdApPathgySampDO(OrdApPathgySampDO[] dos) {
		setChildren(OrdApPathgySampDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorapppathgyAggDODesc desc = new CiorapppathgyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApPathgyDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.OrdApPathgySampDO")) {
             return new OrdApPathgySampDO();
         }
         return null;
     }
}