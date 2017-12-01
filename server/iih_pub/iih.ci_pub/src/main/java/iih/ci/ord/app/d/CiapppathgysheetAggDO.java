package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiapppathgysheetAggDODesc;



/**
 * 病理打印申请单
 */
public class CiapppathgysheetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppPathgySheetDO getParentDO() {
		return ((CiAppPathgySheetDO) super.getParentDO());
	}

	public void setParentDO(CiAppPathgySheetDO headDO) {
		setParent(headDO);
	}

	public CiAppPathgySheetSampDO[] getCiAppPathgySheetSampDO() {
		IBaseDO[] dos = getChildren(CiAppPathgySheetSampDO.class);
		if(dos==null) return null;
		CiAppPathgySheetSampDO[] result=new CiAppPathgySheetSampDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppPathgySheetSampDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppPathgySheetSampDO(CiAppPathgySheetSampDO[] dos) {
		setChildren(CiAppPathgySheetSampDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiapppathgysheetAggDODesc desc = new CiapppathgysheetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppPathgySheetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppPathgySheetSampDO")) {
             return new CiAppPathgySheetSampDO();
         }
         return null;
     }
}