package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.dto.blexorder.d.OrGenSplitTpEnum;
import iih.ci.ord.dto.blexorder.d.OrSplitOrderDTO;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.OrSrvSplitDTO;
import iih.ci.ord.dto.orsrvsplitorder.d.SrvSplitDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

public class getOrSplitSqlRsBp {

	/***
	 * 获得执行与记费的医嘱或服务拆分时的有效医嘱sql对应的结果值
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public BaseDTO exec(OrSrvSplitParamDTO param) throws BizException {

		OrSrvSplitDTO reDTO = new OrSrvSplitDTO();

		FArrayList splitOrArry = new FArrayList();
		FArrayList splitSrvArry = new FArrayList();

		// 医嘱查询
		param.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYOR);
		GetOrAndSrvSplitSqlRsBP orBp = new GetOrAndSrvSplitSqlRsBP();
		OrSplitOrderDTO[] orSplitRes = (OrSplitOrderDTO[]) orBp.exec(param);

		if (orSplitRes != null) {

			// 医嘱拆分
			SplitOrAndSrvSplitSqlRsBP orSplitbp = new SplitOrAndSrvSplitSqlRsBP();
			orSplitRes = (OrSplitOrderDTO[]) orSplitbp.exec(orSplitRes, null, param.getDt_split_end(), OrGenSplitTpEnum.SPLITBYOR);
			if (orSplitRes != null) {
				for (OrSplitOrderDTO orSplitOrderDTO : orSplitRes) {
					splitOrArry.add(orSplitOrderDTO);
				}
			}
			reDTO.setOrsplitarry(splitOrArry);
		}

		// 服务查询
		param.setEu_orgensplittp(OrGenSplitTpEnum.SPLITBYSRVMM);
		GetOrAndSrvSplitSqlRsBP srvBp = new GetOrAndSrvSplitSqlRsBP();
		SrvSplitOrderDTO[] srvSplitRes = (SrvSplitOrderDTO[]) srvBp.exec(param);

		if (srvSplitRes != null) {
			// 服务拆分
			SplitOrAndSrvSplitSqlRsBP srvSplitbp = new SplitOrAndSrvSplitSqlRsBP();
			srvSplitRes = (SrvSplitOrderDTO[]) srvSplitbp.exec(srvSplitRes, null, param.getDt_split_end(), OrGenSplitTpEnum.SPLITBYSRVMM);
			if (srvSplitRes != null) {
				for (SrvSplitOrderDTO srvSplitOrderDTO : srvSplitRes) {
					splitSrvArry.add(srvSplitOrderDTO);
				}
			}
			reDTO.setSrvsplitarry(splitSrvArry);
		}
		
		return reDTO;
	}
}
