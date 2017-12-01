package iih.ci.ord.s.bp.validate.chain;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;

/**
 * 校验对象
 * 
 * @author HUMS
 *
 */
public class ValidateDataDTO {

	// CiEmsDTO 医疗单通用的数据模型
	private CiEmsDTO ciEms;

	// 医疗服务对象
	private MedSrvDO medSrv;

	public CiEmsDTO getCiEms() {
		return ciEms;
	}

	public void setCiEms(CiEmsDTO ciEms) {
		this.ciEms = ciEms;
	}

	public MedSrvDO getMedSrv() {
		return medSrv;
	}

	public void setMedSrv(MedSrvDO medSrv) {
		this.medSrv = medSrv;
	}

}
