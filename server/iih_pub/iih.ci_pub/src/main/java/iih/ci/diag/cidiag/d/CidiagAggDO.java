package iih.ci.diag.cidiag.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.diag.cidiag.d.desc.CidiagAggDODesc;



/**
 * 临床诊断
 */
public class CidiagAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiDiagDO getParentDO() {
		return ((CiDiagDO) super.getParentDO());
	}

	public void setParentDO(CiDiagDO headDO) {
		setParent(headDO);
	}

	public CiDiagItemDO[] getCiDiagItemDO() {
		IBaseDO[] dos = getChildren(CiDiagItemDO.class);
		if(dos==null) return null;
		CiDiagItemDO[] result=new CiDiagItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiDiagItemDO)dos[i];
		}
		return result;
	}
	
	public void setCiDiagItemDO(CiDiagItemDO[] dos) {
		setChildren(CiDiagItemDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CidiagAggDODesc desc = new CidiagAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiDiagDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.diag.cidiag.d.CiDiagItemDO")) {
             return new CiDiagItemDO();
         }
         return null;
     }
}