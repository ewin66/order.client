package iih.ci.ord.dto.hp.d;

import iih.ci.ord.ciorder.d.CiOrderDO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList2;

/**
 * 
 * 医嘱查询实体 DTO数据
 * 注意：由于元数据生成的DTO无法关联DO对象，手动修改文件 
 * 
 */
public class HpQryCiorderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱DO对象
	 * @return String
	 */
	public CiOrderDO getCiorderdo() {
		return ((CiOrderDO) getAttrVal("Ciorderdo"));
	}
	/**
	 * 医嘱DO对象
	 * @param Ciorderdo
	 */
	public void setCiorderdo(CiOrderDO Ciorderdo) {
		setAttrVal("Ciorderdo", Ciorderdo);
	}
	/**
	 * 医疗服务集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdsrvs() {
		return ((FArrayList2) getAttrVal("Ordsrvs"));
	}
	/**
	 * 医疗服务集合
	 * @param Ordsrvs
	 */
	public void setOrdsrvs(FArrayList2 Ordsrvs) {
		setAttrVal("Ordsrvs", Ordsrvs);
	}
	/**
	 * 医嘱对应物品集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdsrvmms() {
		return ((FArrayList2) getAttrVal("Ordsrvmms"));
	}
	/**
	 * 医嘱对应物品集合
	 * @param Ordsrvmms
	 */
	public void setOrdsrvmms(FArrayList2 Ordsrvmms) {
		setAttrVal("Ordsrvmms", Ordsrvmms);
	}
}