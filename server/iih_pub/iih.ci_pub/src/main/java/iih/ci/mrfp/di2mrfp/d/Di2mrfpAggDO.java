package iih.ci.mrfp.di2mrfp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrfp.di2mrfp.d.desc.Di2mrfpAggDODesc;



/**
 * 住院病案首页_诊断
 */
public class Di2mrfpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrfpDiDO getParentDO() {
		return ((CiMrfpDiDO) super.getParentDO());
	}

	public void setParentDO(CiMrfpDiDO headDO) {
		setParent(headDO);
	}

	public CiMrFpXydiDO[] getCiMrFpXydiDO() {
		IBaseDO[] dos = getChildren(CiMrFpXydiDO.class);
		if(dos==null) return null;
		CiMrFpXydiDO[] result=new CiMrFpXydiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrFpXydiDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrFpXydiDO(CiMrFpXydiDO[] dos) {
		setChildren(CiMrFpXydiDO.class, dos);
	}
	public CiMrfpZydiDO[] getCiMrfpZydiDO() {
		IBaseDO[] dos = getChildren(CiMrfpZydiDO.class);
		if(dos==null) return null;
		CiMrfpZydiDO[] result=new CiMrfpZydiDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrfpZydiDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrfpZydiDO(CiMrfpZydiDO[] dos) {
		setChildren(CiMrfpZydiDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Di2mrfpAggDODesc desc = new Di2mrfpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrfpDiDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrfp.di2mrfp.d.CiMrFpXydiDO")) {
             return new CiMrFpXydiDO();
         }
	    else if (clzName.equals("iih.ci.mrfp.di2mrfp.d.CiMrfpZydiDO")) {
             return new CiMrfpZydiDO();
         }
         return null;
     }
}