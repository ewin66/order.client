package iih.ci.mr.nu.newbornveinnur.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.newbornveinnur.d.desc.NewbornveinnurAggDODesc;



/**
 * 新生儿科脐静脉护理记录单（一）
 */
public class NewbornveinnurAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NewBornVeinNurDO getParentDO() {
		return ((NewBornVeinNurDO) super.getParentDO());
	}

	public void setParentDO(NewBornVeinNurDO headDO) {
		setParent(headDO);
	}

	public NewBornVeinNurRecordDO[] getNewBornVeinNurRecordDO() {
		IBaseDO[] dos = getChildren(NewBornVeinNurRecordDO.class);
		if(dos==null) return null;
		NewBornVeinNurRecordDO[] result=new NewBornVeinNurRecordDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NewBornVeinNurRecordDO)dos[i];
		}
		return result;
	}
	
	public void setNewBornVeinNurRecordDO(NewBornVeinNurRecordDO[] dos) {
		setChildren(NewBornVeinNurRecordDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NewbornveinnurAggDODesc desc = new NewbornveinnurAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NewBornVeinNurDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurRecordDO")) {
             return new NewBornVeinNurRecordDO();
         }
         return null;
     }
}