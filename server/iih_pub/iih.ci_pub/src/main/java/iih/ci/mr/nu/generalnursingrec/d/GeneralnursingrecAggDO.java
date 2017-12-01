package iih.ci.mr.nu.generalnursingrec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.generalnursingrec.d.desc.GeneralnursingrecAggDODesc;



/**
 * 一般护理记录
 */
public class GeneralnursingrecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public GeneralNursingDO getParentDO() {
		return ((GeneralNursingDO) super.getParentDO());
	}

	public void setParentDO(GeneralNursingDO headDO) {
		setParent(headDO);
	}

	public GeneralNursingRecDO[] getGeneralNursingRecDO() {
		IBaseDO[] dos = getChildren(GeneralNursingRecDO.class);
		if(dos==null) return null;
		GeneralNursingRecDO[] result=new GeneralNursingRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(GeneralNursingRecDO)dos[i];
		}
		return result;
	}
	
	public void setGeneralNursingRecDO(GeneralNursingRecDO[] dos) {
		setChildren(GeneralNursingRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		GeneralnursingrecAggDODesc desc = new GeneralnursingrecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new GeneralNursingDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.generalnursingrec.d.GeneralNursingRecDO")) {
             return new GeneralNursingRecDO();
         }
         return null;
     }
}