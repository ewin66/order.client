package iih.ci.mr.cimrsfmsec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.cimrsfmsec.d.desc.CimrsfmsecAggDODesc;



/**
 * 医疗记录智能表单段落
 */
public class CimrsfmsecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CimrsfmsecDO getParentDO() {
		return ((CimrsfmsecDO) super.getParentDO());
	}

	public void setParentDO(CimrsfmsecDO headDO) {
		setParent(headDO);
	}

	public CimrsfmsecitmDO[] getCimrsfmsecitmDO() {
		IBaseDO[] dos = getChildren(CimrsfmsecitmDO.class);
		if(dos==null) return null;
		CimrsfmsecitmDO[] result=new CimrsfmsecitmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CimrsfmsecitmDO)dos[i];
		}
		return result;
	}
	
	public void setCimrsfmsecitmDO(CimrsfmsecitmDO[] dos) {
		setChildren(CimrsfmsecitmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrsfmsecAggDODesc desc = new CimrsfmsecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CimrsfmsecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.cimrsfmsec.d.CimrsfmsecitmDO")) {
             return new CimrsfmsecitmDO();
         }
         return null;
     }
}