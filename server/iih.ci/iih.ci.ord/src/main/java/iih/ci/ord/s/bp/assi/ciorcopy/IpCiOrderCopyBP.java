package iih.ci.ord.s.bp.assi.ciorcopy;

import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.moreemsdto.d.MoreEmsParamDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.i.IOrdsrvsetRService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.ci.ord.s.bp.assi.JudgeOrderTemplateApplicationTable;
import iih.ci.ord.s.bp.assi.emscopy.AssiToCiEmsCopy;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import iih.ci.ord.tmpl.d.LongTempOrEnum;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.agg.voutils.DOUtil;
import xap.mw.coreitf.d.FBoolean;

public class IpCiOrderCopyBP {

	// 医嘱id集合
	private String[] idOrs;
	// 就诊信息	
	private CiEnContextDTO ciEnContext = null;
	// 医嘱服务查询接口
	private ICiorderRService ciorderRService = null;
	// 服务项目信息查询服务
	// private IMedsrvRService iMedsrvRService;
	// 医嘱套内项目信息查询服务
	private IOrdsrvsetRService iOrdsrvsetRService;
	// 物品服务
	private IOrdsrvmmRService iOrdsrvmmRService;

	public IpCiOrderCopyBP(String[] idOrs, CiEnContextDTO ciEnContext) {

		this.idOrs = idOrs;
		this.ciEnContext = ciEnContext;

		ciorderRService = CiOrdAppUtils.getOrAggQryService();
		// iMedsrvRService = CiOrdAppUtils.getMedsrvRService();
		iOrdsrvsetRService = CiOrdAppUtils.getOrsrvsetQryService();
		iOrdsrvmmRService = CiOrdAppUtils.getOrSrvMmQryService();
	}

	/**
	 * 医嘱拷贝BP
	 * 
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	public MoreEmsParamDTO exec() throws BizException {

		String errorMsg = CiEnContextUtil.validateCiEnContext(ciEnContext);
		if(StringUtils.isNotEmpty(errorMsg)){
			throw new BizException(errorMsg);
		}
		
		// 获取复制后的模板信息
		CiOrTmplDTO[] ortmpls = this.getCiOrderCopys();

		// 构造CiEmsDTO
		//AssiMappingToCiEmsBP assiMapping = new AssiMappingToCiEmsBP();
		//CiEmsDTO[] ciEmsDTOs = assiMapping.Mapping(ciEnContext, ortmpls);
		
		AssiToCiEmsCopy ciEmsCopy = new AssiToCiEmsCopy();
		List<CiEmsDTO> ciEmsDTOList = ciEmsCopy.ConvertCiOrTmplToCiEms(ciEnContext,ortmpls);
		CiEmsDTO[] ciEmsDTOs = ciEmsDTOList.toArray(new CiEmsDTO[ciEmsDTOList.size()]);
		
//		String cfgPath = "/ciord/ordercopy/ordcopycfg";
//		String str = ZKCfgMgrUtil.getCfg(String.class, "ciorderCpopy", cfgPath);
		
		// 是否有申请表
		JudgeOrderTemplateApplicationTable apptable = new JudgeOrderTemplateApplicationTable();
		apptable.JudgeOrederTemplateAppTabel(ciEmsDTOs,ciEnContext);

		// 保存CiEmsDTO,并获取未保存成功的ciEmsDTO
		MoreEmsParamDTO paramDTO = SaveCiEmsDTOBPExt.SaveCiEmsDTO(ciEnContext, ciEmsDTOs);
		return paramDTO;
	}
	
	

	/**
	 * 医嘱拷贝到模板对象
	 * 
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	private CiOrTmplDTO[] getCiOrderCopys() throws BizException {

		// 根据ordid获取医嘱
		CiorderAggDO[] ciorderAggs = ciorderRService.findByBIds(idOrs, FBoolean.FALSE);
		if(ciorderAggs == null || idOrs.length != ciorderAggs.length){
			throw new BizRuntimeException("医嘱复制失败，待复制医嘱状态发生改变，请刷新后重试！");
		}
		
		CiOrTmplDTO[] ciorTmpls = new CiOrTmplDTO[ciorderAggs.length];

		for (int i = 0; i < ciorderAggs.length; i++) {
			CiorderAggDO ciOrdAgg = ciorderAggs[i];
			OrdSrvDO[]  ordSrvDs = ciOrdAgg.getOrdSrvDO();
			// 调整服务项目与数据库中服务项目顺序保持一致，否则复制出来的医嘱服务项目顺序与源对象顺序不一致
			DOUtil.ascSort(ordSrvDs, new String[]{OrdSrvDO.SORTNO});
			ciOrdAgg.setOrdSrvDO(ordSrvDs);
			
			// 复制医嘱
			ciorTmpls[i] = this.getCiOrTmplCopy(ciOrdAgg);
			ciorTmpls[i].setAttrVal("CiorderAggDO", ciOrdAgg);
		}

		return ciorTmpls;

	}

	/**
	 * 将医嘱对象转换为临床医嘱模板数据对象
	 * 
	 * @param ciorderAgg
	 *            医嘱
	 * @return 临床医嘱模板数据对象
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private CiOrTmplDTO getCiOrTmplCopy(CiorderAggDO ciorderAgg) throws BizException {

		CiOrderDO ciorderDO = ciorderAgg.getParentDO();
		CiOrTmplDTO ciorTmplCopy = new CiOrTmplDTO();
		// 拷贝医嘱
		this.copyCiOrTmpl(ciorderDO, ciorTmplCopy);

		FArrayList ortmplsrvList = new FArrayList();

		// 如果是套，获取bd_srv中对应的服务，将服务赋值给服务项目，将医嘱中的ci_or_srv_set中的id_srv赋值给套
		if (ciorderDO.getFg_set() == FBoolean.TRUE) {
			ortmplsrvList = this.getCiOrTmplBySrvsetCopy(ciorderDO);
		} else {

			OrdSrvDO[] orderSrvs = ciorderAgg.getOrdSrvDO();
			// 构造医嘱模板服务项目
			for (OrdSrvDO ordSrv : orderSrvs) {

				// 仅拷贝医嘱，计算出来的非医嘱服务不进行拷贝
				if (ordSrv.getFg_or() == FBoolean.TRUE) {
					CiOrTmplSrvDTO dto = new CiOrTmplSrvDTO();
					this.copyCiOrTmplSrv(ordSrv, dto);
					ortmplsrvList.add(dto);
				}
			}
		}
		// 医嘱模板服务项目
		ciorTmplCopy.setOrtmplsrvs(ortmplsrvList);

		return ciorTmplCopy;
	}

	/**
	 * 将医嘱拷贝到临床医嘱模板
	 * 
	 * @param source
	 * @param target
	 */
	private void copyCiOrTmpl(CiOrderDO source, CiOrTmplDTO target) {

		// target.setId_ciortmpl(null);//临床医嘱模板主键标识
		// 临床医嘱来源类型，对应OrSourceFromEnum IIHPatiPastHelper 05 患者既往
		target.setEu_orsrcmdtp(ciEnContext.getEu_orsrcmdtp());
		target.setId_orsrc_main(source.getId_or());// 来源 医嘱id
		// target.setId_orsrc_s(source.getId_orsrc_s());//来源ID_子
		// target.setId_orsrc_gs(source.getId_orsrc_gs());//来源ID_孙
		// target.setCode(source.getCode_or());// 编码 code_or 不是bd_srv中的code code_or用于集成平台
		target.setName(source.getName_or());// 名称
		target.setId_srvtp(source.getId_srvtp());// 医嘱类型
		target.setSd_srvtp(source.getSd_srvtp());// 医嘱类型编码

		// 设置长期临时状态
		if (source.getFg_long() == FBoolean.TRUE) {
			target.setEu_long(LongTempOrEnum.LONGOR);// 长期
		} else if (source.getFg_long() == FBoolean.FALSE) {
			target.setEu_long(LongTempOrEnum.TEMPORARYOR);// 临时
		} else {
			target.setEu_long(LongTempOrEnum.LONGTMPNULLOR);// 不关注长临状态设置为空
		}

		target.setId_freq(source.getId_freq());// 医嘱频次
		target.setId_route(source.getId_route());// 用法
		target.setId_routedes(source.getId_routedes());// 用法要求
		target.setId_boil(source.getId_boil());// 煎法
		target.setId_boildes(source.getId_boildes());// 煎法要求
		target.setFg_boil(source.getFg_boil());// 代煎标识
		target.setDays_or(source.getDays_or());// 医嘱天数
		target.setOrders(source.getOrders());// 医嘱付数
		target.setTimes(source.getTimes_cur());// 医嘱次数
		target.setDes_or(source.getDes_or());// 医嘱描述
		target.setId_srv(source.getId_srv());// 医疗服务id
		target.setFg_set(source.getFg_set());// 套标志

		// target.setOrtmplsrvs(source.getOrtmplsrvs());//医嘱模板项目列表 放到
		// getCiOrTmplCopy中复制
	}

	/**
	 * 将医嘱服务项目拷贝到模板中
	 */
	public void copyCiOrTmplSrv(OrdSrvDO source, CiOrTmplSrvDTO target) throws BizException {

		// target.setId_ciortmplsrv(null);// 临床医嘱模板项目主键标识
		// target.setId_ciortmpl(null);// 临床医嘱模板
		target.setSortno(source.getSortno());// 序号
		target.setId_srv(source.getId_srv());// 服务

		// 如果是自定义服务
		target.setFg_selfsrv(source.getFg_selfsrv());// 自定义服务标识
		if (source.getFg_selfsrv() == FBoolean.TRUE) {
			target.setName_selfsrv(source.getName_srv());// 自定义服务名
		}

		target.setFg_set(source.getFg_set());// 套标识
		target.setId_srvtp(source.getId_srvtp());// 服务类型
		target.setSd_srvtp(source.getSd_srvtp());// 服务类型编码
		target.setId_freq(source.getId_freq());// 频次
		target.setId_route(source.getId_route());// 用法
		target.setId_routedes(source.getId_routedes());// 用法要求
		target.setId_boil(source.getId_boil());// 煎法
		target.setId_boildes(source.getId_boildes());// 煎法要求
		target.setId_unit_med(source.getId_medu());// 医学单位 ? TODO 服务中医疗单位 ？
		target.setAttrVal("Name_unit_med", source.getMedu_name()); // 医学单位名称
		target.setQuan_med(source.getQuan_medu());// 医学单位数值
		target.setQuan_total_medu(source.getQuan_total_medu());// 服务总量
		// target.setId_dep_mp(source.getId_dep_mp());// 执行科室 取当环境中的执行科室

		// 如果是物品
		if (source.getFg_mm() == FBoolean.TRUE) {

			OrdSrvMmDO mm = this.getOrdSrvMm(source.getId_orsrv());
			if (mm != null) {
				target.setId_mm(mm.getId_mm());// 关联物品
			}
		}
	}

	/**
	 * 通过医疗服务获取对应的服务项目
	 * 
	 * @param idSrv
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private FArrayList getCiOrTmplBySrvsetCopy(CiOrderDO ciorder) throws BizException {

		// 对应服务套，将医嘱转化为模板中的服务项目（数据相同没有必要在取一次bd_srv）
		// this.copyCiOrTmplSrv(ciorderDO, ciOrTmplSrvDTO);

		String whereStr = "id_or = '" + ciorder.getId_or() + "'";
		OrdSrvSetDO[] srvSetDOs = iOrdsrvsetRService.find(whereStr, "sortno", FBoolean.TRUE);

		FArrayList ciOrTmplSrvList = new FArrayList();
		for (OrdSrvSetDO ordSrvSet : srvSetDOs) {

			CiOrTmplSrvDTO ciOrTmplSrv = new CiOrTmplSrvDTO();
			copyOrdSrvSet2TmplSrv(ordSrvSet, ciOrTmplSrv);
			ciOrTmplSrvList.add(ciOrTmplSrv);
		}

		return ciOrTmplSrvList;
	}

	/**
	 * 套内项目转换医嘱模板项目
	 * 
	 * @param ordSrvSet
	 * @return
	 */
	private void copyOrdSrvSet2TmplSrv(OrdSrvSetDO source, CiOrTmplSrvDTO target) {

		// target.setId_ciortmplsrv(source.getId_ciortmplsrv()); //临床医嘱模板项目主键标识
		// target.setId_ciortmpl(source.getId_ciortmpl()); //临床医嘱模板
		target.setSortno(source.getSortno()); // 序号
		target.setId_srv(source.getId_srvset()); // 服务
		target.setFg_selfsrv(FBoolean.FALSE); // 自定义服务标识
		target.setName_selfsrv(source.getName()); // 自定义服务名
		target.setFg_set(FBoolean.FALSE); // 套标识
		// target.setId_srvtp(source.getId_srvtp()); //服务类型
		// target.setSd_srvtp(source.getSet_sd_srvtp()); // 服务类型编码
		target.setId_freq(source.getId_freqdef()); // 频次
		target.setId_route(source.getId_route()); // 用法
		target.setId_routedes(source.getId_routedes()); // 要求
		// target.setId_boil(source.getId_boil()); //煎法
		// target.setId_boildes(source.getId_boildes()); //中医要求
		target.setId_unit_med(source.getId_medu()); // 医学单位
		target.setQuan_med(source.getQuan_medu()); // 医学单位数值
		// target.setQuan_total_medu(source.getQuan_total_medu()); //服务总量
		// target.setId_dep_mp(source.getId_dep_mp()); //执行科室
		// target.setId_mm(source.getId_mm()); //关联物品
		// target.setSrvsetitms(source.getSrvsetitms()); //套内项目集合

	}

	/**
	 * 获取服务对应的物品
	 * 
	 * @param idOrsrv
	 * @return
	 * @throws BizException
	 */
	public OrdSrvMmDO getOrdSrvMm(String idOrsrv) throws BizException {

		String whereStr = "id_orsrv = '" + idOrsrv + "'";
		OrdSrvMmDO[] ordSrvMms = iOrdsrvmmRService.find(whereStr, null, FBoolean.FALSE);
		if (ordSrvMms != null && ordSrvMms.length > 0) {
			return ordSrvMms[0];
		}
		return null;
	}

	/**
	 * 拷贝其他内容:服务套、护理、输血、备血、手术、检验、检查、病理、皮试、会诊、出院
	 * 
	 * @param sourceAgg
	 * @param targetAgg
	 * @throws BizException
	 */
	private void copyOthers(CiorderAggDO[] sourceAggs, CiorderAggDO[] targetAggs) throws BizException {

		for (int i = 0; i < sourceAggs.length; i++) {

			CiOrderDO sourceOrd = sourceAggs[i].getParentDO();
			CiOrderDO targetOrd = targetAggs[i].getParentDO();
			String srvtp = sourceOrd.getCode_entp();

			if (CiOrdUtils.isPharmacy(srvtp)) { // 药品 （西药 草药 ）
				/*
				 * OrdSrvMmBP bp = new OrdSrvMmBP(sourceAggs[i], targetAggs[i]);
				 * bp.exec();
				 */

			} else if (CiOrdUtils.isRisSrv(srvtp)) {// 检查 (病理)
				/*
				 * OrdApObsCopyBP bp = new OrdApObsCopyBP(); bp.exec(sourceOrd,
				 * targetOrd);
				 */

			} else if (CiOrdUtils.isLisSrv(srvtp)) { // 检验
				/*
				 * OrdApLabCopyBP bp = new OrdApLabCopyBP(); bp.exec(sourceOrd,
				 * targetOrd);
				 */

			} else if (CiOrdUtils.isOpSrv(srvtp)) { // 手术
				/*
				 * OrdApOpCopyBP bp = new OrdApOpCopyBP(); bp.exec(sourceOrd,
				 * targetOrd);
				 */

			} else if (CiOrdUtils.isConsultSrv(srvtp)) {// 会诊
				/*
				 * OrdApConsBP bp = new OrdApConsBP(sourceOrd, targetOrd);
				 * bp.exec();
				 */
			} else if (CiOrdUtils.isBtSrv(srvtp)) {// 备血
				/*
				 * OrdApBtCopyBP bp = new OrdApBtCopyBP(sourceOrd, targetOrd);
				 * bp.exec();
				 */

			} else if (CiOrdUtils.isBtUseSrv(srvtp)) {// 用血
				/*
				 * OrdAppBtUseBP bp = new OrdAppBtUseBP(); bp.exec(sourceOrd,
				 * targetOrd);
				 */

			} else if (CiOrdUtils.isNurseSrv(srvtp)) { // 护理 TODO 没有对应业务表

			} else if (CiOrdUtils.isTreatSrv(srvtp)) {// 治疗 TODO 没有对应业务表

			}
		}

	}

}
