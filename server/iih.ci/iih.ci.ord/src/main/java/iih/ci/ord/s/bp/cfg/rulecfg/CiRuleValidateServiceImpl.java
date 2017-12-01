package iih.ci.ord.s.bp.cfg.rulecfg;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.cfg.rulecfg.ICiRuleValidateService;

/**
 * CI规则校验实现类
 * 
 * @author HUMS
 *
 */
public class CiRuleValidateServiceImpl implements ICiRuleValidateService {

	@Override
	public boolean validateMedSrv(Integer checkPoint, MedSrvDO medSrv) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean validateMedSrv(CiEnContextDTO ctxDTO, Integer checkPoint, MedSrvDO medSrv) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateBySdSrvtp(Integer checkPoint, String sdSrvtp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatorChainByEmsId(String id_srvof) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatorByIdSrv(String id_srv) {
		// TODO Auto-generated method stub
		return false;
	}

}
