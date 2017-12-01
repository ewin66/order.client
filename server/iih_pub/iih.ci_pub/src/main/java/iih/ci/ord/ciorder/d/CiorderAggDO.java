package iih.ci.ord.ciorder.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.ciorder.d.desc.CiorderAggDODesc;



/**
 * 临床医嘱
 */
public class CiorderAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiOrderDO getParentDO() {
		return ((CiOrderDO) super.getParentDO());
	}

	public void setParentDO(CiOrderDO headDO) {
		setParent(headDO);
	}

	public OrdSrvDO[] getOrdSrvDO() {
		IBaseDO[] dos = getChildren(OrdSrvDO.class);
		if(dos==null) return null;
		OrdSrvDO[] result=new OrdSrvDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdSrvDO)dos[i];
		}
		return result;
	}
	
	public void setOrdSrvDO(OrdSrvDO[] dos) {
		setChildren(OrdSrvDO.class, dos);
	}
	public OrdDrugDO[] getOrdDrugDO() {
		IBaseDO[] dos = getChildren(OrdDrugDO.class);
		if(dos==null) return null;
		OrdDrugDO[] result=new OrdDrugDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdDrugDO)dos[i];
		}
		return result;
	}
	
	public void setOrdDrugDO(OrdDrugDO[] dos) {
		setChildren(OrdDrugDO.class, dos);
	}
	public OrdFreqTimeDO[] getOrdFreqTimeDO() {
		IBaseDO[] dos = getChildren(OrdFreqTimeDO.class);
		if(dos==null) return null;
		OrdFreqTimeDO[] result=new OrdFreqTimeDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrdFreqTimeDO)dos[i];
		}
		return result;
	}
	
	public void setOrdFreqTimeDO(OrdFreqTimeDO[] dos) {
		setChildren(OrdFreqTimeDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorderAggDODesc desc = new CiorderAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiOrderDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.ciorder.d.OrdSrvDO")) {
             return new OrdSrvDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciorder.d.OrdDrugDO")) {
             return new OrdDrugDO();
         }
	    else if (clzName.equals("iih.ci.ord.ciorder.d.OrdFreqTimeDO")) {
             return new OrdFreqTimeDO();
         }
         return null;
     }
}