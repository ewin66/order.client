package iih.ci.ord.d.ems.ems;

import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.ci.ord.d.ems.base.BaseCiDTO;

public class EmsCrtDTO extends BaseCiDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 医疗单主服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗单主服务id
	 * @param mainSrv
	 */
	public void setId_srv(String mainSrv) {
		setAttrVal("Id_srv", mainSrv);
	}
	
	/**
	 * 医疗单物品id
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * 医疗单物品id
	 * @param mainSrv
	 */
	public void setId_mm(String mainSrv) {
		setAttrVal("Id_mm", mainSrv);
	}
	
	
	/**
	 * 医疗单
	 * @return EmsMatchRstDTO
	 */
	public SrvMatchEmsRstDTO getEmsMgrInfo() {
		return ((SrvMatchEmsRstDTO) getAttrVal("EmsMgrInfo"));
	}
	/**
	 * 医疗单
	 * @param mainSrv
	 */
	public void setEmsMgrInfo(SrvMatchEmsRstDTO EmsMgrInfo) {
		setAttrVal("EmsMgrInfo", EmsMgrInfo);
	}
	
	/**
	 * 医疗单驱动
	 * @return String
	 */
	public String getEmsDriver() {
		return ((String) getAttrVal("EmsDriver"));
	}
	/**
	 * 医疗单驱动
	 * @param mainSrv
	 */
	public void setEmsDriver(String EmsDriver) {
		setAttrVal("EmsDriver", EmsDriver);
	}
}
