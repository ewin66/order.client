package iih.ci.ord.s.ems;

import iih.ci.ord.d.ems.fee.FeeListCrtDTO;
import iih.ci.ord.d.ems.fee.FeeListLoadDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.d.ems.fee.FeeListSaveDTO;
import iih.ci.ord.i.ems.ICiFeeListMainService;
import iih.ci.ord.s.ems.biz.op.fee.FeeListCreateAction;
import iih.ci.ord.s.ems.biz.op.fee.FeeListLoadAction;
import iih.ci.ord.s.ems.biz.op.fee.FeeListSaveAction;
import iih.ci.ord.s.ems.biz.op.fee.FeeListValidate;
import iih.ci.ord.s.ems.biz.op.fee.bp.FeeListCreateBP;
import iih.ci.ord.s.ems.biz.op.fee.bp.FeeListLoadBP;
import iih.ci.ord.s.ems.biz.op.fee.bp.FeeListSaveBP;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 费用清单主服务
 * @author wangqingzhu
 *
 */
@Service(serviceInterfaces = { ICiFeeListMainService.class }, binding = Binding.JSONRPC)
public class CiFeeListMainServiceImpl implements ICiFeeListMainService {

	@Override
	public FeeListRstDTO create(FeeListCrtDTO crt) throws BizException {
		// TODO Auto-generated method stub
		return new FeeListCreateAction(new FeeListCreateBP()).create(crt);
	}

	@Override
	public FeeListRstDTO load(FeeListLoadDTO ld) throws BizException {
		// TODO Auto-generated method stub
		return new FeeListLoadAction(new FeeListLoadBP()).load(ld);
	}

	@Override
	public FeeListRstDTO save(FeeListSaveDTO sv) throws BizException {
		// TODO Auto-generated method stub
		return new FeeListSaveAction(new FeeListSaveBP(new FeeListValidate())).save(sv);
	}

}
