package iih.ci.ord.dto.unchargeordinfo.d;

import xap.sys.appfw.orm.model.agg.BaseAggDO;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.i.IAggDesc;

/**
 * 未记账医嘱数据信息
 */
public class UnchargeordinfoAggDTO extends BaseAggDO {
	private static final long serialVersionUID = 1L;

	@Override
	public UnchargeOrdDTO getParentDO() {
		return ((UnchargeOrdDTO) super.getParentDO());
	}

	public void setParentDO(UnchargeOrdDTO headDO) {
		setParent(headDO);
	}

	public UnchargeOrdSrvDTO[] getUnchargeOrdSrvDTO() {
		return ((UnchargeOrdSrvDTO[]) getChildren(UnchargeOrdSrvDTO.class));
	}
	
	public void setUnchargeOrdSrvDTO(UnchargeOrdSrvDTO[] dos) {
		setChildren(UnchargeOrdSrvDTO.class, dos);
	}

	 public  BaseDO createParentDO() {
         return new UnchargeOrdDTO();
     }

     public  BaseDO createChildDO(String clzName) {
	     if (clzName.equals("iih.ci.ord.dto.unchargeordinfo.d.UnchargeOrdSrvDTO")) {
             return new UnchargeOrdSrvDTO();
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