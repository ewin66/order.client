package iih.ci.mr.nu.obstetrics.adhgeneralnursing.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.desc.AdhgeneralnursingAggDODesc;



/**
 * 妇产科护理观察记录
 */
public class AdhgeneralnursingAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AdhNursingDO getParentDO() {
		return ((AdhNursingDO) super.getParentDO());
	}

	public void setParentDO(AdhNursingDO headDO) {
		setParent(headDO);
	}

	public AdhNursingRecDO[] getAdhNursingRecDO() {
		IBaseDO[] dos = getChildren(AdhNursingRecDO.class);
		if(dos==null) return null;
		AdhNursingRecDO[] result=new AdhNursingRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AdhNursingRecDO)dos[i];
		}
		return result;
	}
	
	public void setAdhNursingRecDO(AdhNursingRecDO[] dos) {
		setChildren(AdhNursingRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AdhgeneralnursingAggDODesc desc = new AdhgeneralnursingAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AdhNursingDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.adhgeneralnursing.d.AdhNursingRecDO")) {
             return new AdhNursingRecDO();
         }
         return null;
     }
}