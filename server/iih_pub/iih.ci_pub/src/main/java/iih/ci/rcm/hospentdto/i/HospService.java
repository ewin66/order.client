package iih.ci.rcm.hospentdto.i;

import iih.ci.rcm.hospentdto.d.HospEntDTO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;

/**
 * 院感上报 接口集合
 * 
 * @author 杨建兵
 *
 */
public interface HospService {

	/**
	 * 获取上报卡患者列表
	 * 
	 * @param idOrg
	 * @param idDept
	 * @return
	 * @throws BizException
	 */
	HospEntDTO[] getHospEntList(String idGrp, String idOrg, String idDept)
			throws BizException;

	/**
	 * 获取院感漏报患者列表
	 * 
	 * @param idGrp
	 * @param idOrg
	 * @param idDept
	 * @return
	 * @throws BizException
	 */
	PatiVisitDO[] getHospMissingList(String idGrp, String idOrg, String idDept)
			throws BizException;

	/**
	 * 获取院感漏报患者列表
	 * 
	 * @param idGrp
	 * @param idOrg
	 * @param idDept
	 * @return
	 * @throws BizException
	 */
	HospEntDTO[] getHospEntList2(QryRootNodeDTO qryRootNodeDTO)
			throws BizException;

	HospEntDTO[] GetDeleteHospList() throws BizException;

	HospEntDTO[] getAllPageData() throws BizException;
}
