package iih.ci.mrfp.other2mrfp.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mrfp.other2mrfp.d.desc.Other2mrfpAggDODesc;



/**
 * 病案首页其他信息
 */
public class Other2mrfpAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrFpOtherDO getParentDO() {
		return ((CiMrFpOtherDO) super.getParentDO());
	}

	public void setParentDO(CiMrFpOtherDO headDO) {
		setParent(headDO);
	}

	public CiMrfpIntenCareDO[] getCiMrfpIntenCareDO() {
		IBaseDO[] dos = getChildren(CiMrfpIntenCareDO.class);
		if(dos==null) return null;
		CiMrfpIntenCareDO[] result=new CiMrfpIntenCareDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrfpIntenCareDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrfpIntenCareDO(CiMrfpIntenCareDO[] dos) {
		setChildren(CiMrfpIntenCareDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		Other2mrfpAggDODesc desc = new Other2mrfpAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrFpOtherDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mrfp.other2mrfp.d.CiMrfpIntenCareDO")) {
             return new CiMrfpIntenCareDO();
         }
         return null;
     }
}