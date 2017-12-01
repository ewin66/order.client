package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.OrdrptopAggDODesc;



/**
 * 医嘱手术记录
 */
public class OrdrptopAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApRptOpDO getParentDO() {
		return ((OrdApRptOpDO) super.getParentDO());
	}

	public void setParentDO(OrdApRptOpDO headDO) {
		setParent(headDO);
	}

	public OrdApRptOpItemDO[] getOrdApRptOpItemDO() {
		IBaseDO[] dos = getChildren(OrdApRptOpItemDO.class);
		if(dos==null) return null;
		OrdApRptOpItemDO[] result=new OrdApRptOpItemDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdApRptOpItemDO)dos[i];
		}
		return result;
	}
	
	public void setOrdApRptOpItemDO(OrdApRptOpItemDO[] dos) {
		setChildren(OrdApRptOpItemDO.class, dos);
	}
	public RptOpEmpDO[] getRptOpEmpDO() {
		IBaseDO[] dos = getChildren(RptOpEmpDO.class);
		if(dos==null) return null;
		RptOpEmpDO[] result=new RptOpEmpDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(RptOpEmpDO)dos[i];
		}
		return result;
	}
	
	public void setRptOpEmpDO(RptOpEmpDO[] dos) {
		setChildren(RptOpEmpDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OrdrptopAggDODesc desc = new OrdrptopAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApRptOpDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.OrdApRptOpItemDO")) {
             return new OrdApRptOpItemDO();
         }
	    else if (clzName.equals("iih.ci.ord.cior.d.RptOpEmpDO")) {
             return new RptOpEmpDO();
         }
         return null;
     }
}