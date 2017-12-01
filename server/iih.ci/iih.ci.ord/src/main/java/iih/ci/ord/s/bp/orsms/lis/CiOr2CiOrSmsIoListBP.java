package iih.ci.ord.s.bp.orsms.lis;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;

/**
 * 分方医嘱到临床医嘱分方数据信息列表集合的转换操作BP
 */
public class CiOr2CiOrSmsIoListBP {
	/**
	 * 分方医嘱到临床医嘱分方数据信息列表集合的转换
	 * 
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	public List<CiLisOrSmsIoDTO> exec(CiOrderDO[] ciors) throws BizException {
		// 分方医嘱格式化为分方数据DTO
		CiLisOrInfo4Sms[] orpressplitdtos = ciOrs2CiOrSmsIoDTOs(ciors);
		if (CiOrdUtils.isEmpty(orpressplitdtos))
			return null;

		// 分方数据DTO到临床医嘱分方数据信息列表数据 并返回
		return CiOrSmsDTO2CiOrSmsList(orpressplitdtos);
	}

	/**
	 * 分方医嘱格式化为分方数据DTO
	 * 
	 * @param ciors
	 * @return
	 * @throws BizException
	 */
	private CiLisOrInfo4Sms[] ciOrs2CiOrSmsIoDTOs(CiOrderDO[] ciors) throws BizException {
		CiOrs2CiOrSmsIoDTOsBP bp = new CiOrs2CiOrSmsIoDTOsBP();
		return bp.exec(ciors);
	}

	/**
	 * 分方数据DTO到临床医嘱分方数据信息列表数据
	 * 
	 * @param smsorinfo
	 * @return
	 */
	private List<CiLisOrSmsIoDTO> CiOrSmsDTO2CiOrSmsList(CiLisOrInfo4Sms[] smsorinfo) {
		List<CiLisOrSmsIoDTO> smslist = new ArrayList<CiLisOrSmsIoDTO>();
		FArrayList2 sms = new FArrayList2();
		CiLisOrSmsIoDTO orderLis = new CiLisOrSmsIoDTO();
		orderLis.setFg_apprule("Y");
		if (smsorinfo == null)
			return sms;
		for (CiLisOrInfo4Sms dto : smsorinfo) {
			sms.add(dto);
		}
		orderLis.setCilisorinfos(sms);
		;
		smslist.add(orderLis);
		return smslist;
	}

}
