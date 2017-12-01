package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiapptreatsheetAggDODesc;



/**
 * 诊疗申请单
 */
public class CiapptreatsheetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppTreatSheetDO getParentDO() {
		return ((CiAppTreatSheetDO) super.getParentDO());
	}

	public void setParentDO(CiAppTreatSheetDO headDO) {
		setParent(headDO);
	}

	public CiAppTreatSheetOrDO[] getCiAppTreatSheetOrDO() {
		IBaseDO[] dos = getChildren(CiAppTreatSheetOrDO.class);
		if(dos==null) return null;
		CiAppTreatSheetOrDO[] result=new CiAppTreatSheetOrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppTreatSheetOrDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppTreatSheetOrDO(CiAppTreatSheetOrDO[] dos) {
		setChildren(CiAppTreatSheetOrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiapptreatsheetAggDODesc desc = new CiapptreatsheetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppTreatSheetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppTreatSheetOrDO")) {
             return new CiAppTreatSheetOrDO();
         }
         return null;
     }
}