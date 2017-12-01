package iih.ci.ord.ciprn.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.ciprn.d.desc.CiprintAggDODesc;



/**
 * 临床打印单
 */
public class CiprintAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiPrnDO getParentDO() {
		return ((CiPrnDO) super.getParentDO());
	}

	public void setParentDO(CiPrnDO headDO) {
		setParent(headDO);
	}

	public CiPrnItmDO[] getCiPrnItmDO() {
		IBaseDO[] dos = getChildren(CiPrnItmDO.class);
		if(dos==null) return null;
		CiPrnItmDO[] result=new CiPrnItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiPrnItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiPrnItmDO(CiPrnItmDO[] dos) {
		setChildren(CiPrnItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiprintAggDODesc desc = new CiprintAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiPrnDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.ciprn.d.CiPrnItmDO")) {
             return new CiPrnItmDO();
         }
         return null;
     }
}