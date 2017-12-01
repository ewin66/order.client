package iih.ci.ord.s.bp.base.emsdi;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UIEmsEnvDTO;
import iih.ci.ord.emsdi.d.BdSrv4EmsDiDTO;
import iih.ci.ord.emsdi.d.EmsDiDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.common.FieldMapping;
import iih.ci.ord.s.bp.exception.GenEmsDiInfo8BdSrvParameterNUllException;
import xap.mw.core.data.BizException;

/**
 * 根据医疗服务信息参数，生成医疗单界面初始化数据信息操作BP
 * （单服务情形）
 */
public class GenEmsDiInfo8BdSrvBP {
	/**
	 * 根据医疗服务信息参数，生成医疗单界面初始化数据信息
	 * （单服务情形）
	 * @param envinfo
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public CiEmsDTO exec(CiEnContextDTO envinfo,BdSrv4EmsDiDTO param)  throws BizException{
		if(envinfo == null || param == null) throw  new GenEmsDiInfo8BdSrvParameterNUllException();
		CiEmsDTO emsDto = new  CiEmsDTO();
		MedSrvDO medSrvDO = this.getMedSrvDOFindById(param.getId_srv());
		if(medSrvDO == null) throw new GenEmsDiInfo8BdSrvParameterNUllException("medSrvDO is null");
		//映射上下文字段
		FieldMapping fieldMapping = new FieldMapping();
		fieldMapping.MedSrvDOMappingCiEmsDTO(envinfo,medSrvDO, emsDto);
		return emsDto;
	}
	/**
	 * 查询 bd_srv
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO getMedSrvDOFindById(String id_srv) throws BizException{
		return CiOrdAppUtils.getIMedsrvMDORService().findById(id_srv);
	}
}
