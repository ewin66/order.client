package iih.ci.mr.nu.obstetrics.antennurbaby.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.antennurbaby.d.desc.AntennurbabyAggDODesc;



/**
 * 产科婴儿护理记录
 */
public class AntennurbabyAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AntNurBabyDO getParentDO() {
		return ((AntNurBabyDO) super.getParentDO());
	}

	public void setParentDO(AntNurBabyDO headDO) {
		setParent(headDO);
	}

	public AntNurBabyBrserDO[] getAntNurBabyBrserDO() {
		IBaseDO[] dos = getChildren(AntNurBabyBrserDO.class);
		if(dos==null) return null;
		AntNurBabyBrserDO[] result=new AntNurBabyBrserDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AntNurBabyBrserDO)dos[i];
		}
		return result;
	}
	
	public void setAntNurBabyBrserDO(AntNurBabyBrserDO[] dos) {
		setChildren(AntNurBabyBrserDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AntennurbabyAggDODesc desc = new AntennurbabyAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AntNurBabyDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.antennurbaby.d.AntNurBabyBrserDO")) {
             return new AntNurBabyBrserDO();
         }
         return null;
     }
}