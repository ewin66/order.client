package iih.ci.ord.app.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.app.d.desc.CiapplissheetAggDODesc;



/**
 * 检验申请单
 */
public class CiapplissheetAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiAppLisSheetDO getParentDO() {
		return ((CiAppLisSheetDO) super.getParentDO());
	}

	public void setParentDO(CiAppLisSheetDO headDO) {
		setParent(headDO);
	}

	public CiAppLisSheetOrDO[] getCiAppLisSheetOrDO() {
		IBaseDO[] dos = getChildren(CiAppLisSheetOrDO.class);
		if(dos==null) return null;
		CiAppLisSheetOrDO[] result=new CiAppLisSheetOrDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiAppLisSheetOrDO)dos[i];
		}
		return result;
	}
	
	public void setCiAppLisSheetOrDO(CiAppLisSheetOrDO[] dos) {
		setChildren(CiAppLisSheetOrDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiapplissheetAggDODesc desc = new CiapplissheetAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiAppLisSheetDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.app.d.CiAppLisSheetOrDO")) {
             return new CiAppLisSheetOrDO();
         }
         return null;
     }
}