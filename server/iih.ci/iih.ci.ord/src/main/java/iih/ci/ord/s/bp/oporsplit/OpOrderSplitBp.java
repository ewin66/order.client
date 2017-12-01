package iih.ci.ord.s.bp.oporsplit;

import iih.ci.ord.dto.oporsplit.d.OpOrderSplitDTO;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 门诊医嘱拆分逻辑
 * 
 * @author xuxing 2016-9-27 14:21:07
 *
 */
public class OpOrderSplitBp {

	/**
	 * 主入口
	 * 
	 * @return
	 * @throws BizException
	 */
	public OpOrderSplitDTO[] exec(OpOrderSplitDTO[] splitDTOS, String interfacetp) throws BizException {

		// 1、参数校验（医嘱）
		if (splitDTOS == null || splitDTOS.length < 1) {
			return null;
		}

		// 2、拆分
		List<OpOrderSplitDTO> reList = new ArrayList<OpOrderSplitDTO>();
		splitHandle(splitDTOS, reList);

		return reList.toArray(new OpOrderSplitDTO[reList.size()]);
	}

	/**
	 * 拆分处理
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private void splitHandle(OpOrderSplitDTO[] splitDTOS, List<OpOrderSplitDTO> reList) throws BizException {

		Hashtable mapFreq = new Hashtable();

		FDateTime[] validSE = null;

		for (OpOrderSplitDTO splitDTO : splitDTOS) {

			// 门诊没有Aways类的医嘱
			if (OrSrvSplitUtil.isAlwaysFreq1(splitDTO.getSd_frequnit())) {
				continue;
			}

			validSE = getValidStartEndDT(splitDTO);

			split(splitDTO, validSE, mapFreq, reList);
		}
	}

	/**
	 * 获取有效开始结束时间
	 * 
	 * @param splitDTO
	 * @param end
	 * @return
	 */
	private FDateTime[] getValidStartEndDT(OpOrderSplitDTO splitDTO) {

		// FDateTime[] rtn = null;
		// FDateTime[] effectiveDTs = new FDateTime[] { splitDTO.getDt_effe(),
		// splitDTO.getDt_effe() };
		// FDateTime[] inputDTs = new FDateTime[] { splitDTO.getDt_last_bl(),
		// end };
		// rtn = OrSrvSplitUtil.getValidStartEndDT(effectiveDTs, inputDTs);

		FDateTime[] rtn = new FDateTime[] { splitDTO.getDt_effe(), splitDTO.getDt_end() };
		return rtn;

	}

	/**
	 * 拆分
	 * 
	 * @param splitDTO
	 * @param validSE
	 * @param mapFreq
	 * @param reList
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private void split(OpOrderSplitDTO splitDTO, FDateTime[] validSE, Hashtable mapFreq, List<OpOrderSplitDTO> reList) throws BizException {

		OrSplitBp bp = new OrSplitBp();

		bp.exec(splitDTO, validSE, mapFreq, reList);
	}

}
