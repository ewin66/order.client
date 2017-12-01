package iih.ci.ord.s.ems;

import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.d.ems.thr.ThirdRstDTO;
import iih.ci.ord.i.ems.ICiOrderThirdService;
import iih.ci.ord.s.ems.biz.third.MpOrderFeeAction;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

@Service(serviceInterfaces = { ICiOrderThirdService.class }, binding = Binding.JSONRPC)
public class CiOrderThirdServiceImpl implements ICiOrderThirdService{

	private MpOrderFeeAction mpOrderFeeAction = new MpOrderFeeAction();
	
	@Override
	public ThirdRstDTO save(CiorderAggDO[] szOrderAggInfo) throws BizException {
		// TODO Auto-generated method stub
		return mpOrderFeeAction.save(szOrderAggInfo);
	}

	@Override
	public ThirdRstDTO delete(String[] szId_or) throws BizException {
		// TODO Auto-generated method stub
		return mpOrderFeeAction.delete(szId_or);
	}

}
