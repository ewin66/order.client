package iih.ci.ord.s.ortmpl;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ortmpl.IOrTmplApplyService;
import iih.ci.ord.s.ortmpl.bp.GetOrTplNItmDTOsCacheBP;
import iih.ci.ord.s.ortmpl.bp.getOrTmplCaDOsBP;
import iih.ci.ord.s.ortmpl.bp.getOrTmplDTOsBP;
import iih.ci.ord.s.ortmpl.bp.getOrTplNItmDOsBP;

/**
 * 医嘱模板应用接口
 * @author Young
 *
 */
@Service(serviceInterfaces = { IOrTmplApplyService.class }, binding = Binding.JSONRPC)
public class OrTmplApplyServiceImpl implements IOrTmplApplyService {

	/**
	 * 查询医嘱模板分类
	 * @param id_grp
	 * @param id_org
	 * @param id_dep
	 * @param id_emp
	 * @param sd_ortmpltp
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrTmplCaDO[] getOrTmplCaDOs(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp) throws BizException {
		// TODO Auto-generated method stub
		getOrTmplCaDOsBP bp = new getOrTmplCaDOsBP();
		return bp.exec(id_grp, id_org, id_dep, id_emp, sd_ortmpltp);
		
	}
	/**
	 * 查询医嘱模板分类关系
	 * @param id_ortmplca
	 * @param sd_ortmpltp
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrTmplDTO[] getOrTmplDTOs(String id_ortmplca, String sd_ortmpltp) throws BizException{
		// TODO Auto-generated method stub
		getOrTmplDTOsBP bp = new getOrTmplDTOsBP();
		return bp.exec(id_ortmplca, sd_ortmpltp);
	}
	/**
	 * 查询医嘱模板明细
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrTplNItmDO[] getOrTplNItmDOs(String id_ortmpl) throws BizException{
		// TODO Auto-generated method stub
		getOrTplNItmDOsBP bp = new getOrTplNItmDOsBP();
		return bp.exec(id_ortmpl);
	}
	/**
	 * 查询医嘱模板明细
	 * @param id_ortmpls
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	@Override
	public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpls, CiEnContextDTO ctx) throws BizException{
		// TODO Auto-generated method stub
		GetOrTplNItmDTOsCacheBP bp = new GetOrTplNItmDTOsCacheBP();
		return bp.exec(id_ortmpls, ctx);
	}

}
