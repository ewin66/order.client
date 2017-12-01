package iih.ci.ord.cirptlab.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cirptlab.d.desc.CirptlabAggDODesc;



/**
 * 组件
 */
public class CirptlabAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiRptLabDO getParentDO() {
		return ((CiRptLabDO) super.getParentDO());
	}

	public void setParentDO(CiRptLabDO headDO) {
		setParent(headDO);
	}

	public CiRptLabItmDO[] getCiRptLabItmDO() {
		IBaseDO[] dos = getChildren(CiRptLabItmDO.class);
		if(dos==null) return null;
		CiRptLabItmDO[] result=new CiRptLabItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiRptLabItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiRptLabItmDO(CiRptLabItmDO[] dos) {
		setChildren(CiRptLabItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CirptlabAggDODesc desc = new CirptlabAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiRptLabDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cirptlab.d.CiRptLabItmDO")) {
             return new CiRptLabItmDO();
         }
         return null;
     }
}