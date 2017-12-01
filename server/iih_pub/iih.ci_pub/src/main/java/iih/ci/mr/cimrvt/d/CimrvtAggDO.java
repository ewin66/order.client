package iih.ci.mr.cimrvt.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.cimrvt.d.desc.CimrvtAggDODesc;



/**
 * 临床生命体征测量
 */
public class CimrvtAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrVtDO getParentDO() {
		return ((CiMrVtDO) super.getParentDO());
	}

	public void setParentDO(CiMrVtDO headDO) {
		setParent(headDO);
	}

	public CiMrVtItmDO[] getCiMrVtItmDO() {
		IBaseDO[] dos = getChildren(CiMrVtItmDO.class);
		if(dos==null) return null;
		CiMrVtItmDO[] result=new CiMrVtItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrVtItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrVtItmDO(CiMrVtItmDO[] dos) {
		setChildren(CiMrVtItmDO.class, dos);
	}
	public CiMrVtEvDO[] getCiMrVtEvDO() {
		IBaseDO[] dos = getChildren(CiMrVtEvDO.class);
		if(dos==null) return null;
		CiMrVtEvDO[] result=new CiMrVtEvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrVtEvDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrVtEvDO(CiMrVtEvDO[] dos) {
		setChildren(CiMrVtEvDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrvtAggDODesc desc = new CimrvtAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrVtDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.cimrvt.d.CiMrVtItmDO")) {
             return new CiMrVtItmDO();
         }
	    else if (clzName.equals("iih.ci.mr.cimrvt.d.CiMrVtEvDO")) {
             return new CiMrVtEvDO();
         }
         return null;
     }
}