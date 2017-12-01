package iih.ci.diag.dto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 诊断headdto
 */
public class DidtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public Headdto getParentDO() {
		return ((Headdto) super.getParentDO());
	}

	public void setParentDO(Headdto headDO) {
		setParent(headDO);
	}

	public Cididtozy[] getCididtozy() {
		return ((Cididtozy[]) getChildren(Cididtozy.class));
	}
	
	public void setCididtozy(Cididtozy[] dos) {
		setChildren(Cididtozy.class, dos);
	}
	public Cidixy[] getCidixy() {
		return ((Cidixy[]) getChildren(Cidixy.class));
	}
	
	public void setCidixy(Cidixy[] dos) {
		setChildren(Cidixy.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new Headdto();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.diag.dto.d.Cididtozy")) {
             return new Cididtozy();
         }
	    else if (clzName.equals("iih.ci.diag.dto.d.Cidixy")) {
             return new Cidixy();
         }
         return null;
     }
    
    /**
     * AggDTO 中元数据描述不存在，此方法不应使用 
     */ 
    @Override
	public IAggDesc getAggDesc() {
		return null;
	}

}