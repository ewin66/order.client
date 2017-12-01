package iih.ci.mr.nu.obstetrics.birthrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.birthrec.d.desc.BirthrecAggDODesc;



/**
 * 临产记录
 */
public class BirthrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public BirthrecInfoDO getParentDO() {
		return ((BirthrecInfoDO) super.getParentDO());
	}

	public void setParentDO(BirthrecInfoDO headDO) {
		setParent(headDO);
	}

	public BirthrecInDO[] getBirthrecInDO() {
		IBaseDO[] dos = getChildren(BirthrecInDO.class);
		if(dos==null) return null;
		BirthrecInDO[] result=new BirthrecInDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BirthrecInDO)dos[i];
		}
		return result;
	}
	
	public void setBirthrecInDO(BirthrecInDO[] dos) {
		setChildren(BirthrecInDO.class, dos);
	}
	public BirthrecProDO[] getBirthrecProDO() {
		IBaseDO[] dos = getChildren(BirthrecProDO.class);
		if(dos==null) return null;
		BirthrecProDO[] result=new BirthrecProDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(BirthrecProDO)dos[i];
		}
		return result;
	}
	
	public void setBirthrecProDO(BirthrecProDO[] dos) {
		setChildren(BirthrecProDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		BirthrecAggDODesc desc = new BirthrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new BirthrecInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecInDO")) {
             return new BirthrecInDO();
         }
	    else if (clzName.equals("iih.ci.mr.nu.obstetrics.birthrec.d.BirthrecProDO")) {
             return new BirthrecProDO();
         }
         return null;
     }
}