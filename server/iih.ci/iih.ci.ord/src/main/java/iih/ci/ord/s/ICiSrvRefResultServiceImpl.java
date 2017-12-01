package iih.ci.ord.s;

import iih.ci.ord.i.ICiSrvRefResultService;
import iih.ci.ord.s.bp.srvref.GetSrvRefRstDatumBP;
import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import iih.ci.ord.srvref.d.CiSrvRefResultDTO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;

/**
 * 医嘱服务实现类
 * @author hums
 *
 */
@Service(serviceInterfaces={ICiSrvRefResultService.class}, binding=Binding.JSONRPC)
public class ICiSrvRefResultServiceImpl implements ICiSrvRefResultService {

	@Override
	public CiSrvRefResultDTO[] getSrvRefResult(CiSrvRefParamDTO dto) throws BizException {
		
		GetSrvRefRstDatumBP bp = new GetSrvRefRstDatumBP();
		CiSrvRefResultDTO[] resultDto = bp.exec(dto);
		return resultDto;
	}

}
