package iih.ci.ord.s.external;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FDateTime;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.ci.ord.i.external.ICiOrdBlService;
import iih.ci.ord.s.external.bp.GetDiagDefDOsBP;

/**
 * 临床对费用提供对外接口
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdBlService.class }, binding = Binding.JSONRPC)
public class CiOrdBlServiceImpl implements ICiOrdBlService {

	/**
	 * 查询诊断
	 */
	@Override
	public DiagDefDO[] GetDiagDefDOs(FDateTime dtStart, FDateTime dtEnd, String nameDi, String codeDi, String idcdsystp,
			String iddica, String idorg, String idgrp) throws BizException {
		GetDiagDefDOsBP bp=new GetDiagDefDOsBP();
		return bp.exec(dtStart, dtEnd, nameDi, codeDi, idcdsystp, iddica, idorg, idgrp);
	}
}
