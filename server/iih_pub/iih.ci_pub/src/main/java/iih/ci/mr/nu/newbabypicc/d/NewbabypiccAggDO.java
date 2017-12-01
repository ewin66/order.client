package iih.ci.mr.nu.newbabypicc.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.newbabypicc.d.desc.NewbabypiccAggDODesc;



/**
 * 新生儿科picc护理信息
 */
public class NewbabypiccAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public NewBabyPiccDO getParentDO() {
		return ((NewBabyPiccDO) super.getParentDO());
	}

	public void setParentDO(NewBabyPiccDO headDO) {
		setParent(headDO);
	}

	public NewBabyPiccRecDO[] getNewBabyPiccRecDO() {
		IBaseDO[] dos = getChildren(NewBabyPiccRecDO.class);
		if(dos==null) return null;
		NewBabyPiccRecDO[] result=new NewBabyPiccRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(NewBabyPiccRecDO)dos[i];
		}
		return result;
	}
	
	public void setNewBabyPiccRecDO(NewBabyPiccRecDO[] dos) {
		setChildren(NewBabyPiccRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		NewbabypiccAggDODesc desc = new NewbabypiccAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new NewBabyPiccDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.newbabypicc.d.NewBabyPiccRecDO")) {
             return new NewBabyPiccRecDO();
         }
         return null;
     }
}