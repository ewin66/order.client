package iih.ci.ord.s.ems.biz.op.calcpri;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.primd.i.IPriCalService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 本服务定价模式费用项目查询代理
 * @author wangqingzhu
 *
 */
public class SelfSrvCalcPriModeProxy extends BaseCalcPriModeProxy {

	public SelfSrvCalcPriModeProxy(String id_srv, String name, int num) {
		super(id_srv, name, num);
		// TODO Auto-generated constructor stub 
	}

	@Override
	public PriStdSrvDTO[] Calc() throws BizException {
		// TODO Auto-generated method stub
		FDouble pri = ServiceFinder.find(IPriCalService.class)
				.CalSingleSrvStdPrice(id_srv);
		PriStdSrvDTO priStdSrvDTO = new PriStdSrvDTO();
		priStdSrvDTO.setId_srv(id_srv);
		priStdSrvDTO.setName_srv(name);
		priStdSrvDTO.setPrice(pri);
		return new PriStdSrvDTO[]{priStdSrvDTO};
	}

	@Override
	public String toDesction() {
		// TODO Auto-generated method stub
		return String.format("获取服务【%s】本服务定价模式费用项目", name);
	}

}
