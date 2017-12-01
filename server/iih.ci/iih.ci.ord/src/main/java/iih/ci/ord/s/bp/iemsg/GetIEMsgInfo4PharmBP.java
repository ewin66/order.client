package iih.ci.ord.s.bp.iemsg;

import java.util.Map;

import iih.ci.ord.iemsg.d.IEPharmHerbOrDTO;
import iih.ci.ord.iemsg.d.IEPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEPharmWcOrDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * BS311：用药医嘱信息服 </br>
 * 住院：生成集成平台药品医嘱服务数据信息操作BP
 */
public class GetIEMsgInfo4PharmBP {
	/**
	 * 生成集成平台药品医嘱服务数据信息
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEPharmOrEnDTO[] exec(String id_wc_ors, String id_herb_ors, Map<String, Object> confirminfo)
			throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_wc_ors) && CiOrdUtils.isEmpty(id_herb_ors))
			return null;
		if (CiOrdUtils.isEmpty(confirminfo))
			return null;
		//获得药品医嘱确认数据信息
		IEPharmOrEnDTO headdto = CiIEMsgInfoHelper.map2IEPharmOrEnDTO(confirminfo);

		//获得西成药医嘱集合
		IEPharmWcOrDTO[] wcs = getIeDrugwcMsgInfo(id_wc_ors);

		//获得草药医嘱集合
		IEPharmHerbOrDTO[] herbs = getIeDrugHerbMsgInfo(id_herb_ors);

		//合并处理
		setWcHerbFArrayList(headdto, wcs, herbs);

		return new IEPharmOrEnDTO[] { headdto };
	}

	/**
	 * 设置确认西成药与草药医嘱列表信息
	 * 
	 * @param headdto
	 * @param wcs
	 * @param herbs
	 */
	private void setWcHerbFArrayList(IEPharmOrEnDTO headdto, IEPharmWcOrDTO[] wcs, IEPharmHerbOrDTO[] herbs) {
		if (!CiOrdUtils.isEmpty(wcs)) {//设置西成药医嘱集合信息
			headdto.setId_iepharmwcors(CiOrdUtils.array2FArrayList2(wcs));
		}

		if (!CiOrdUtils.isEmpty(herbs)) {//设置草药药医嘱集合信息
			headdto.setId_iepharmors(CiOrdUtils.array2FArrayList2(herbs));
		}

	}

	/**
	 * 获得集成平台西成药医嘱服务数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmWcOrDTO[] getIeDrugwcMsgInfo(String id_ors) throws BizException {
		GetIEMsgInfo4DrugWcBP bp = new GetIEMsgInfo4DrugWcBP();
		return bp.exec(id_ors);
	}

	/**
	 * 获得集成平台草药医嘱服务数据信息
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private IEPharmHerbOrDTO[] getIeDrugHerbMsgInfo(String id_ors) throws BizException {
		GetIEMsgInfo4DrugHerbBP bp = new GetIEMsgInfo4DrugHerbBP();
		return bp.exec(id_ors);
	}

}
