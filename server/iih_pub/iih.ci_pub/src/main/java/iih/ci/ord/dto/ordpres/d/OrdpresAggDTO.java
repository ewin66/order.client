package iih.ci.ord.dto.ordpres.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 医嘱处方
 */
public class OrdpresAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public OrdPresDTO getParentDO() {
		return ((OrdPresDTO) super.getParentDO());
	}

	public void setParentDO(OrdPresDTO headDO) {
		setParent(headDO);
	}

	public PresDrugDTO[] getPresDrugDTO() {
		return ((PresDrugDTO[]) getChildren(PresDrugDTO.class));
	}
	
	public void setPresDrugDTO(PresDrugDTO[] dos) {
		setChildren(PresDrugDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new OrdPresDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.dto.ordpres.d.PresDrugDTO")) {
             return new PresDrugDTO();
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