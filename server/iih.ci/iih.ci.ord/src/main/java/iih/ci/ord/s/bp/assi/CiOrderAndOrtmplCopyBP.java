package iih.ci.ord.s.bp.assi;

import java.util.ArrayList;
import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.ems.d.EmsAppModeEnum;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.bd.srv.ortpl.d.OrtmplAggDO;
import iih.bd.srv.ortpl.i.IOrtmplRService;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.mkr.ms.mkrms.d.MkrMsOrtpl;
import iih.mkr.ms.mkrms.d.MkrMsSrvDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱模板和医嘱转换成医嘱模板保存
 * 
 * @author HUMS
 *
 */
public class CiOrderAndOrtmplCopyBP {

	// 医疗服务集合
	private FArrayList mkrMsSrvDOList;
	// 医嘱模板id集合
	private FArrayList mkrMsMrtplDOList;
	// banner对象
	private Ent4BannerDTO bannerDTO;
	// 数据来源OrSourceFromEnum.IIHClinicalKitHelper 06 组套 
	// 医嘱模板Agg查询服务
	private IOrtmplRService ortmplRService;
	// OrTplNItmDO对象 转换为CiOrTmplDTO对象BP
	private ConvertOrtmlNItem2CiOrTmplBP convertOrtmlNItemBP;
	// 医疗服务转标准医嘱模板BP
	private MkrMsSrv2OrTmplBP mkrMsSrv2OrTmplBP;
	
	public CiOrderAndOrtmplCopyBP(FArrayList mkrMsSrvDOList, FArrayList mkrMsMrtplDOList, Ent4BannerDTO bannerDTO) {

		// 医疗服务集合
		this.mkrMsSrvDOList = mkrMsSrvDOList;
		// 医嘱模板id集合
		this.mkrMsMrtplDOList = mkrMsMrtplDOList;
		this.bannerDTO = bannerDTO;
		ortmplRService = CiOrdAppUtils.getIOrtmplRService();
		convertOrtmlNItemBP = new ConvertOrtmlNItem2CiOrTmplBP(OrSourceFromEnum.IIHCLINICALKITHELPER);
		mkrMsSrv2OrTmplBP = new MkrMsSrv2OrTmplBP();
		
	}

	public MoreEmsParamDTO exec() throws BizException {

		// 获取环境信息
		CiEnContextDTO context  =CiEnContextUtil.getCiEnContext(bannerDTO, EmsAppModeEnum.SVEMSAPPMODE);
		
		// 标准医嘱模板集合
		List<CiOrTmplDTO> ciorTmplList = new ArrayList<CiOrTmplDTO>();

		// 获取医疗服务转换的模板对象集合
		List<CiOrTmplDTO> srvCiorTmplList = this.getMkrMsSrvCopy();
		if (srvCiorTmplList != null) {
			ciorTmplList.addAll(srvCiorTmplList);
		}

		// 获取医嘱模板转换的模板对象集合
		List<CiOrTmplDTO> mrtplCiorTmplList = this.getMkrMsMrtplCopy();
		if (mrtplCiorTmplList != null) {
			ciorTmplList.addAll(mrtplCiorTmplList);
		}

		// 构造CiEmsDTO
		CiOrTmplAggDTOMappingCiEmsDTO ciOrTmpl = new CiOrTmplAggDTOMappingCiEmsDTO();
		return ciOrTmpl.Mapping(context, ciorTmplList.toArray(new CiOrTmplDTO[ciorTmplList.size()]));

		/*// 是否有申请表
		JudgeOrderTemplateApplicationTable apptable = new JudgeOrderTemplateApplicationTable();
		apptable.JudgeOrederTemplateAppTabel(ciEmsDTOs,context);

		// 保存CiEmsDTO,并获取未保存成功的ciEmsDTO
		MoreEmsParamDTO paramDTO = SaveCiEmsDTOBP.SaveCiEmsDTO(context, ciEmsDTOs);

		return paramDTO;*/
	}

	/**
	 * 获取医疗服务的转换的模板对象
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<CiOrTmplDTO> getMkrMsSrvCopy() throws BizException {

		List<CiOrTmplDTO> ciorTmplList = null;
		if (mkrMsSrvDOList == null || mkrMsSrvDOList.size() == 0) {
			return ciorTmplList;
		}

		ciorTmplList = new ArrayList<CiOrTmplDTO>();

		for (Object obj : mkrMsSrvDOList) {
			MkrMsSrvDO mkrMsSrv = (MkrMsSrvDO) obj;

			CiOrTmplDTO ciOrTmpl = mkrMsSrv2OrTmplBP.exec(mkrMsSrv, OrSourceFromEnum.IIHCLINICALKITHELPER);
			ciorTmplList.add(ciOrTmpl);

		}
		return ciorTmplList;
	}

	/**
	 * 获取医嘱模板转换的标准模板对象集合
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<CiOrTmplDTO> getMkrMsMrtplCopy() throws BizException {

		// 医嘱模板集合
		List<String> tmplIdList = new ArrayList<String>();
		// 转换后的医嘱模板集合
		List<CiOrTmplDTO> ciOrTmplList = new ArrayList<CiOrTmplDTO>();

		if (mkrMsMrtplDOList == null || mkrMsMrtplDOList.size() == 0) {
			return null;
		}

		// 获取组套中关联的医嘱模板id集合
		for (Object obj : mkrMsMrtplDOList) {
			MkrMsOrtpl ortpl = (MkrMsOrtpl) obj;
			tmplIdList.add(ortpl.getId_srvortpl());
		}

		// 根据id获取全部的模板Agg,并将医嘱模板转换为医嘱模板DTO对象集合
		OrtmplAggDO[] ortmplAggs = ortmplRService.findByIds(tmplIdList.toArray(new String[] {}), FBoolean.FALSE);
		for (OrtmplAggDO ortmplAgg : ortmplAggs) {

			// 将医嘱模板明细转换为临床医嘱模板DTO
			ciOrTmplList.addAll(this.getCiOrTmpls(ortmplAgg));
		}

		return ciOrTmplList;
	}

	/**
	 * 根据医嘱模板获取对应的标准模板
	 * 注：医嘱模板转换为医嘱时，单模板转换为一条医嘱，复合模板转换为医嘱时，复合模板中的单独模板作为一条医嘱，复合模板中的每个服务作为一个医嘱
	 * 
	 * @param ortmplAgg
	 * @return
	 * @throws BizException
	 */
	private List<CiOrTmplDTO> getCiOrTmpls(OrtmplAggDO ortmplAgg) throws BizException {

		// 标准医嘱模板集合
		List<CiOrTmplDTO> ciOrTmplList = new ArrayList<CiOrTmplDTO>();

		// 医嘱模板明细集合
		OrTplNItmDO[] tempItems = null;

		// 医嘱模板主表
		OrTmplDO orTmpl = ortmplAgg.getParentDO();
		OrTplNItmDO[] ortplItems = ortmplAgg.getOrTplNItmDO();

		// 如果是复合模板，每条明细都作为一条医嘱
		if (IBdSrvDictCodeConst.ID_ORTMPLTP_COMPOUND_A.equals(orTmpl.getId_ortmpltp())) {

			for (OrTplNItmDO ortplItem : ortplItems) {
				// 如果明细类型是基础模板，取子模板的OrTplNItmDO转成标准模板，否则每条明细作为一个模板
				if (OrTplItmTypeEnum.ORTMPL.equals(ortplItem.getEu_ortplitmtp())) {

					OrtmplAggDO ortmplAggDO = ortmplRService.findById(ortplItem.getId_ortmpl());
					tempItems = ortmplAggDO.getOrTplNItmDO();

				} else {// 是套或服务

					if (OrTplItmTypeEnum.SRVSET.equals(ortplItem.getEu_ortplitmtp())) { // 如果是套
						ortplItem.setId_srv_set(ortplItem.getId_srv());
					}
					tempItems = new OrTplNItmDO[] { ortplItem };
				}

				for (OrTplNItmDO orTplNItm : tempItems) {
					orTplNItm.setIdentical_ortmpl(orTmpl.getId_ortmpltp());
				}
				ciOrTmplList.addAll(convertOrtmlNItemBP.exec(tempItems));
			}

		} else {
			// 不是复合模板（基础模板）,全部的明细转成一条医嘱
			ciOrTmplList.addAll(convertOrtmlNItemBP.exec(ortplItems));
		}

		return ciOrTmplList;
	}

	/**
	 * 将组套中医疗服务转CiOrTmplDTO对象
	 * 
	 * @param mkrMsSrv
	 * @return
	 */
	private CiOrTmplDTO convertMkrMsSrvToCiOrTmpl(MkrMsSrvDO mkrMsSrv) {

		CiOrTmplDTO ciorTmpl = new CiOrTmplDTO();

		return ciorTmpl;
	}
}
