package iih.ci.mr.nu.obstetrics.antenatalassess.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.nu.obstetrics.antenatalassess.d.desc.AntenatalassessAggDODesc;



/**
 * 产科护理记录单(产后、术后)
 */
public class AntenatalassessAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public AntenAssDO getParentDO() {
		return ((AntenAssDO) super.getParentDO());
	}

	public void setParentDO(AntenAssDO headDO) {
		setParent(headDO);
	}

	public AntenNurBserRecDO[] getAntenNurBserRecDO() {
		IBaseDO[] dos = getChildren(AntenNurBserRecDO.class);
		if(dos==null) return null;
		AntenNurBserRecDO[] result=new AntenNurBserRecDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(AntenNurBserRecDO)dos[i];
		}
		return result;
	}
	
	public void setAntenNurBserRecDO(AntenNurBserRecDO[] dos) {
		setChildren(AntenNurBserRecDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		AntenatalassessAggDODesc desc = new AntenatalassessAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new AntenAssDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.nu.obstetrics.antenatalassess.d.AntenNurBserRecDO")) {
             return new AntenNurBserRecDO();
         }
         return null;
     }
}