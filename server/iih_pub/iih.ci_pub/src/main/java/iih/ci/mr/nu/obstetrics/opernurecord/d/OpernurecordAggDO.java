package iih.ci.mr.nu.obstetrics.opernurecord.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.opernurecord.d.desc.OpernurecordAggDODesc;



/**
 * 手术护理记录单
 */
public class OpernurecordAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OperNuRecordDO getParentDO() {
		return ((OperNuRecordDO) super.getParentDO());
	}

	public void setParentDO(OperNuRecordDO headDO) {
		setParent(headDO);
	}

	public OperNuRecordEqmDO[] getOperNuRecordEqmDO() {
		IBaseDO[] dos = getChildren(OperNuRecordEqmDO.class);
		if(dos==null) return null;
		OperNuRecordEqmDO[] result=new OperNuRecordEqmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OperNuRecordEqmDO)dos[i];
		}
		return result;
	}
	
	public void setOperNuRecordEqmDO(OperNuRecordEqmDO[] dos) {
		setChildren(OperNuRecordEqmDO.class, dos);
	}
	public OperNuRecordDressDO[] getOperNuRecordDressDO() {
		IBaseDO[] dos = getChildren(OperNuRecordDressDO.class);
		if(dos==null) return null;
		OperNuRecordDressDO[] result=new OperNuRecordDressDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OperNuRecordDressDO)dos[i];
		}
		return result;
	}
	
	public void setOperNuRecordDressDO(OperNuRecordDressDO[] dos) {
		setChildren(OperNuRecordDressDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		OpernurecordAggDODesc desc = new OpernurecordAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OperNuRecordDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordEqmDO")) {
             return new OperNuRecordEqmDO();
         }
	    else if (clzName.equals("iih.ci.mr.nu.obstetrics.opernurecord.d.OperNuRecordDressDO")) {
             return new OperNuRecordDressDO();
         }
         return null;
     }
}