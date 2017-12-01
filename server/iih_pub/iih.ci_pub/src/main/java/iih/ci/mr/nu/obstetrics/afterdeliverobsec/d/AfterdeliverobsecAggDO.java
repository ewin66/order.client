package iih.ci.mr.nu.obstetrics.afterdeliverobsec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.desc.AfterdeliverobsecAggDODesc;



/**
 * 产后观察记录
 */
public class AfterdeliverobsecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AfterDeliveInfoDO getParentDO() {
		return ((AfterDeliveInfoDO) super.getParentDO());
	}

	public void setParentDO(AfterDeliveInfoDO headDO) {
		setParent(headDO);
	}

	public AfterDeliveRecDO[] getAfterDeliveRecDO() {
		IBaseDO[] dos = getChildren(AfterDeliveRecDO.class);
		if(dos==null) return null;
		AfterDeliveRecDO[] result=new AfterDeliveRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AfterDeliveRecDO)dos[i];
		}
		return result;
	}
	
	public void setAfterDeliveRecDO(AfterDeliveRecDO[] dos) {
		setChildren(AfterDeliveRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AfterdeliverobsecAggDODesc desc = new AfterdeliverobsecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AfterDeliveInfoDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.afterdeliverobsec.d.AfterDeliveRecDO")) {
             return new AfterDeliveRecDO();
         }
         return null;
     }
}