package iih.ci.ord.s.ems;

import iih.ci.ord.d.ems.tmpl.TmplLoadDTO;
import iih.ci.ord.d.ems.tmpl.TmplRstDTO;
import iih.ci.ord.d.ems.tmpl.TmplSaveDTO;
import iih.ci.ord.i.ems.ICiTmplMainService;
import iih.ci.ord.s.ems.biz.itf.bp.ITmplLoadBP;
import iih.ci.ord.s.ems.biz.itf.bp.ITmplSaveBP;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.TmplLoadAction;
import iih.ci.ord.s.ems.biz.op.tmpl.tl.ortmpl.TmplSaveAction;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiTmplMainService.class }, binding = Binding.JSONRPC)
public class CiTmplMainServiceImpl implements ICiTmplMainService {

	// 铜陵
	private ITmplLoadBP iTmplLoadBP = new TmplLoadAction();
	private ITmplSaveBP iTmplSaveBP = new TmplSaveAction();
	@Override
	public TmplRstDTO load(TmplLoadDTO ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TmplRstDTO save(TmplSaveDTO ems) throws BizException {
		// TODO Auto-generated method stub
		
		return iTmplSaveBP.save(ems);
	}

}
