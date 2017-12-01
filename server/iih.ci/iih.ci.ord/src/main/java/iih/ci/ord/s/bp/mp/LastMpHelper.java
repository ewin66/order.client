package iih.ci.ord.s.bp.mp;

import iih.ci.ord.cior.d.CiOrLastMpDTO;
import iih.ci.ord.cior.d.LastOfMpRstTp;

/**
 * 最后一顿助手类
 */
public class LastMpHelper {
	/**
	 * 获得是最后一顿执行时的DTO数据信息
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrLastMpDTO getLastMpInfoDTO(CiOrLastMpDTO param) {
		return getLastMpInfo8RstTp(param, LastOfMpRstTp.THELASTOFMP);
	}

	/**
	 * 获得不是最后一顿执行时的DTO数据信息
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrLastMpDTO getNotLastMpInfoDTO(CiOrLastMpDTO param) {
		return getLastMpInfo8RstTp(param, LastOfMpRstTp.NOTTHELASTOFMP);
	}

	/**
	 * 获得最后一顿执行值未知情况对应的DTO数据信息
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrLastMpDTO getUnknownLastMpInfoDTO(CiOrLastMpDTO param) {
		return getLastMpInfo8RstTp(param, LastOfMpRstTp.UNKNOWN);
	}

	/**
	 * 根据执行最后一顿判断结果类型 获得是最后一顿执行时的DTO数据信息
	 * 
	 * @param param
	 * @return
	 */
	public static CiOrLastMpDTO getLastMpInfo8RstTp(CiOrLastMpDTO param, Integer lastofmprsttp) {
		CiOrLastMpDTO rtn = new CiOrLastMpDTO();
		rtn.setId_or(param.getId_or());
		rtn.setDt_mp_plan(param.getDt_mp_plan());
		rtn.setEu_last(lastofmprsttp);
		rtn.setFg_long(param.getFg_long());

		return rtn;
	}
}
