package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.CiordrptbttestAggDODesc;



/**
 * 备血检验结果
 */
public class CiordrptbttestAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiOrdBtTestDO getParentDO() {
		return ((CiOrdBtTestDO) super.getParentDO());
	}

	public void setParentDO(CiOrdBtTestDO headDO) {
		setParent(headDO);
	}

	public CiOrdBtTestItmDO[] getCiOrdBtTestItmDO() {
		IBaseDO[] dos = getChildren(CiOrdBtTestItmDO.class);
		if(dos==null) return null;
		CiOrdBtTestItmDO[] result=new CiOrdBtTestItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiOrdBtTestItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiOrdBtTestItmDO(CiOrdBtTestItmDO[] dos) {
		setChildren(CiOrdBtTestItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiordrptbttestAggDODesc desc = new CiordrptbttestAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiOrdBtTestDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.CiOrdBtTestItmDO")) {
             return new CiOrdBtTestItmDO();
         }
         return null;
     }
}