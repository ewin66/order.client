package iih.ci.ord.i.ortmpl;

import iih.bd.srv.ortpl.d.OrTmplCaDO;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.ord.dto.newordertemplatedto.d.OrderTemplateRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱模板加载接口
 * @author Young
 *
 */
public interface IOrTmplApplyService {

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
	public OrTmplCaDO[] getOrTmplCaDOs(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp) throws BizException;
	/**
	 * 查询医嘱模板分类关系
	 * @param id_ortmplca
	 * @param sd_ortmpltp
	 * @return
	 * @throws BizException
	 */
	public OrTmplDTO[] getOrTmplDTOs(String id_ortmplca,String sd_ortmpltp) throws BizException;
	/**
	 * 查询医嘱模板明细
	 * @param id_ortmpl
	 * @return
	 * @throws BizException
	 */
	public OrTplNItmDO[] getOrTplNItmDOs(String id_ortmpl) throws BizException;
	/**
	 * 查询医嘱模板明细
	 * @param id_ortmpls
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public OrderTemplateRstDTO getOrTemplateCache(String[] id_ortmpls, CiEnContextDTO ctx) throws BizException;
}
