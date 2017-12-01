package iih.ci.mr.cimrstblsec.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.mr.cimrstblsec.d.desc.CimrstblsecAggDODesc;



/**
 * 临床医疗记录智能表格段落
 */
public class CimrstblsecAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public CiMrSTblSecDO getParentDO() {
		return ((CiMrSTblSecDO) super.getParentDO());
	}

	public void setParentDO(CiMrSTblSecDO headDO) {
		setParent(headDO);
	}

	public CiMrSTblSecItmDO[] getCiMrSTblSecItmDO() {
		IBaseDO[] dos = getChildren(CiMrSTblSecItmDO.class);
		if(dos==null) return null;
		CiMrSTblSecItmDO[] result=new CiMrSTblSecItmDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiMrSTblSecItmDO)dos[i];
		}
		return result;
	}
	
	public void setCiMrSTblSecItmDO(CiMrSTblSecItmDO[] dos) {
		setChildren(CiMrSTblSecItmDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CimrstblsecAggDODesc desc = new CimrstblsecAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new CiMrSTblSecDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.mr.cimrstblsec.d.CiMrSTblSecItmDO")) {
             return new CiMrSTblSecItmDO();
         }
         return null;
     }
}