package iih.ci.rcm.contagion.dto.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 组件
 */
public class ContagiondtoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public EntDto getParentDO() {
		return ((EntDto) super.getParentDO());
	}

	public void setParentDO(EntDto headDO) {
		setParent(headDO);
	}

	public Contagiondto[] getContagiondto() {
		return ((Contagiondto[]) getChildren(Contagiondto.class));
	}
	
	public void setContagiondto(Contagiondto[] dos) {
		setChildren(Contagiondto.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new EntDto();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.rcm.contagion.dto.d.Contagiondto")) {
             return new Contagiondto();
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