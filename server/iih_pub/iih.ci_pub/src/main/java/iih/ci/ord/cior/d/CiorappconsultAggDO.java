package iih.ci.ord.cior.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;
import xap.mw.coreitf.i.IBaseDO;
import iih.ci.ord.cior.d.desc.CiorappconsultAggDODesc;



/**
 * 会诊申请单
 */
public class CiorappconsultAggDO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdApConsDO getParentDO() {
		return ((OrdApConsDO) super.getParentDO());
	}

	public void setParentDO(OrdApConsDO headDO) {
		setParent(headDO);
	}

	public CiordInviteConsDO[] getCiordInviteConsDO() {
		IBaseDO[] dos = getChildren(CiordInviteConsDO.class);
		if(dos==null) return null;
		CiordInviteConsDO[] result=new CiordInviteConsDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(CiordInviteConsDO)dos[i];
		}
		return result;
	}
	
	public void setCiordInviteConsDO(CiordInviteConsDO[] dos) {
		setChildren(CiordInviteConsDO.class, dos);
	}
	public OrConsApAuditDO[] getOrConsApAuditDO() {
		IBaseDO[] dos = getChildren(OrConsApAuditDO.class);
		if(dos==null) return null;
		OrConsApAuditDO[] result=new OrConsApAuditDO[dos.length];
		for(int i=0;i<dos.length;i++){
			result[i]=(OrConsApAuditDO)dos[i];
		}
		return result;
	}
	
	public void setOrConsApAuditDO(OrConsApAuditDO[] dos) {
		setChildren(OrConsApAuditDO.class, dos);
	}

	@Override
	public IAggDesc getAggDesc() {
		CiorappconsultAggDODesc desc = new CiorappconsultAggDODesc();

		return desc;
	}
	
	 public  BaseDO createParentDO() {
         return new OrdApConsDO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.cior.d.CiordInviteConsDO")) {
             return new CiordInviteConsDO();
         }
	    else if (clzName.equals("iih.ci.ord.cior.d.OrConsApAuditDO")) {
             return new OrConsApAuditDO();
         }
         return null;
     }
}