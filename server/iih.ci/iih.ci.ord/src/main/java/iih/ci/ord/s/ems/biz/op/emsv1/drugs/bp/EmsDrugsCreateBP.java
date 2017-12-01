package iih.ci.ord.s.ems.biz.op.emsv1.drugs.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedsrvAggDO;
import iih.bd.srv.medsrv.i.IMedsrvRService;
import iih.bd.srv.routedosage.d.RouteDosageRefDO;
import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.dto.d.SkinTestParamDTO;
import iih.ci.ord.dto.d.SkinTestRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.hp.HpService;
import iih.ci.ord.hp.HpService.MedSrvHpParam;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.common.CiOrParamUtils;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.quantum.times.GetTotalTimesBP;
import iih.ci.ord.s.ems.biz.op.base.bp.EmsBaseCreateBP;
import iih.ci.ord.s.ems.biz.utils.DeptInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsExtInfoUtils;
import iih.ci.ord.s.ems.biz.utils.OrderEmsHpInfoUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.CiOrdemsErrorCodeEnum;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.mm.itf.material.i.IMaterialBaseInfoService;
import iih.mm.itf.materialunitdto.d.MaterialUnitDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 药品医疗单创建逻辑
 * @author wangqingzhu
 *
 */
public class EmsDrugsCreateBP extends EmsBaseCreateBP{
	private FBoolean cusFg_selfpay = null;
	
	public EmsRstDTO[] create(EmsCrtDTO[] emsarray)  throws BizException {
		EmsCrtDTO ems = emsarray[0];
		List<EmsRstDTO> rsts = new ArrayList<EmsRstDTO>();
		EmsRstDTO rst = new EmsRstDTO();
		// 获取主服务信息
		MedsrvAggDO aggDO = ServiceFinder.find(IMedsrvRService.class).findById(ems.getId_srv());
		if (aggDO == null){
			throw new BizException("查询主服务信息失败！",CiOrdemsErrorCodeEnum.ERRORCODE_EMS_MAINSRV_NULL);
		}
		//TODO 自费标识，重构医保共享校验删除根据传入参数fg_selfpay判断逻辑

		String fg_selfpayStr = ems.getExtension()!=null && ems.getExtension().containsKey("CustomInfo")? ems.getExtension().get("CustomInfo").toString():null;
		if("Y".equals(fg_selfpayStr)){
			cusFg_selfpay = FBoolean.TRUE;
		}
		// 合成主UI模型对象
		EmsDrugItemDO emsModel = getCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv());
		if(null == emsModel){
			emsModel = emsModelFrom(aggDO.getParentDO(),ems.getEnContext());
			putCache(L1SessionKeyWith(ems.getEnContext()), ems.getId_srv(),emsModel);
		}		
		// 可变部分赋值
		{
			FDateTime tm = CiOrdAppUtils.getServerDateTime();
			emsModel.setUse_days(1);
			GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
			Integer totalTimes = totalTimesBP.getTotalTimes(aggDO.getParentDO().getId_freq(), emsModel.getUse_days());
			emsModel.setTimes_cur(totalTimes);
			emsModel.setDt_begin_ui(tm);		// SINGLE
			emsModel.setDt_end_ui(new FDateTime(tm.getBeginDate().getDateAfter(1),tm.getUFTime()));	
		}		
		// 获取执行科室
		OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ems.getEnContext(), aggDO.getParentDO(),  ems.getId_mm(), null);
		if (null == wf) {
			// 封装错误信息
			FArrayList errorlist=new FArrayList();
			errorlist.add("获取执行科室失败");
			OrderEmsExtInfoUtils.SetErrMsg(rst, errorlist);
			rsts.add(rst);
			return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
		}

		// 设置执行科室属性
		emsModel.setStr_mp_dep_ids(wf.getId_mp_depts());
		emsModel.setId_dep(wf.getFirstid_mp_dept());
		emsModel.setName_dep(wf.getFirstname_mp_dept());
		
		EmsOrDrug drug = this.drugInfoFrom(ems.getId_srv(), ems.getId_mm(), ems.getEnContext());
		{
			drug.setStatus(DOStatus.NEW);
			// 使用天数
			drug.setUse_days(emsModel.getUse_days());
			// 执行科室
			drug.setId_mp_dep(wf.getFirstid_mp_dept());
			drug.setName_mp_dep(wf.getFirstname_mp_dept());
			drug.setId_dep_wh(wf.getId_dept_wh());
			drug.setName_dep_wh(wf.getName_dept_wh());
			drug.setStr_wh_dep_ids(wf.getId_dept_whs());
			// 服务类型
			drug.setId_srvtp(aggDO.getParentDO().getId_srvtp());
			drug.setSd_srvtp(aggDO.getParentDO().getSd_srvtp());
	
			// 剂量、剂量单位界面展示使用虚拟字段，用于实现前台切换剂量单位
			drug.setQuan_medu_virtual(drug.getQuan_med());
			drug.setName_unit_medu_virtual(drug.getName_unit_med());
	
			// 外配药标识默认为false
			drug.setFg_extdispense(FBoolean.FALSE);
	
			// 计算总量
			CalQuantumBP quantumBP = new CalQuantumBP();
			//应该取门诊的取整模式
			FDouble quan_cur = quantumBP.getMMQuantum(drug.getSd_opmutp(), emsModel.getQuan_med(),
					new FDouble(drug.getFactor_mb()), drug.getFactor_cb(), emsModel.getTimes_cur());
			drug.setQuan_cur(quan_cur);
	
			// 设置物品总价
			drug.setTotalprice(drug.getPrice().multiply(drug.getQuan_cur()));
			// 药品里边集合开立时只有一个
		
			emsModel.setFactor_mb(String.valueOf(drug.getFactor_mb()));

			// 获取皮试结果
			OrderEmsExtInfoUtils.SetSkinTestRstDTO(rst, this.getSkinTestCheckResult(drug, ems.getEnContext()));
			//特殊病判断
			String isShowWarnInfo = OrderEmsHpInfoUtils.judgeSpecillFlag( ems.getEnContext(),ems.getId_mm());
			
			
			if(isShowWarnInfo != "" && isShowWarnInfo != null){
				OrderEmsExtInfoUtils.SetSpecialDrugWarnInfo(rst, "该特殊病药品未录入对应的诊断，请补充诊断"+isShowWarnInfo );
				OrderEmsExtInfoUtils.SetIsShowWarnInfo(rst, true);
			}else{
				OrderEmsExtInfoUtils.SetIsShowWarnInfo(rst, false);
			}
		}
					
		// 医嘱列表显示结果
		FArrayList drugList = new FArrayList();
		drugList.add(drug);
		emsModel.setEmsOrDrugListEx(drugList);
		
		// 添加剂型，用于前台根据剂型过滤成组药品
		OrderEmsExtInfoUtils.SetDosagesFilter(rst,getDrugRouteOfDoSages(aggDO.getParentDO().getId_route()));

		// 主服务对象
		OrderEmsExtInfoUtils.SetCustomInfo(rst, aggDO.getParentDO()	);
		
		// 保存执行科室过滤条件
        OrderEmsExtInfoUtils.SetMpDepFilter(rst, wf.getId_mp_depts());

		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		// 保存物资流向
		OrderEmsExtInfoUtils.SetWhDepFilter(rst, wf.getId_dept_whs());
		OrderEmsExtInfoUtils.SetWhDepId(rst, wf.getId_dept_wh());
		OrderEmsExtInfoUtils.SetWhDepName(rst, wf.getName_dept_wh());
		// 返回值处理
		
		rst.setDocument(this.handleReturnDocument(emsModel));
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(emsModel.serializeJson()));
		rst.setEmsDriver(EmsType.COMMONDRUG.toString());
		
		rsts.add(rst);
		return (EmsRstDTO[]) rsts.toArray(new EmsRstDTO[rsts.size()]);
	}

protected EmsDrugItemDO emsModelFrom(MedSrvDO medSrv,CiEnContextDTO ctx)throws BizException{
		
		EmsDrugItemDO emsDrugItem = new EmsDrugItemDO();
		emsDrugItem.setId_org(ctx.getId_org());
		emsDrugItem.setId_srv(medSrv.getId_srv());//服务项目id
		emsDrugItem.setName_srv(medSrv.getName());//服务项目名称
		emsDrugItem.setId_srvtp(medSrv.getId_srvtp());//服务项目类型id
		emsDrugItem.setSd_srvtp(medSrv.getSd_srvtp());//服务项目类型sd
		emsDrugItem.setId_freq(medSrv.getId_freq());//频次
		emsDrugItem.setName_freq(medSrv.getFreq_name());//频次名称
		emsDrugItem.setFreqct(medSrv.getFreqct());//频次下次数
		emsDrugItem.setSd_frequnitct(medSrv.getSd_frequnitct());// 频次单位编码  频次周期类型
		emsDrugItem.setId_route(medSrv.getId_route());//用法
		emsDrugItem.setName_route(medSrv.getRoute_name());//用法名称
		emsDrugItem.setId_routedes(medSrv.getId_routedes());//用法要求
		emsDrugItem.setName_routedes(medSrv.getRoutedes_name());
		emsDrugItem.setName_unit_med(medSrv.getMed_name());// 计量单位名称
		emsDrugItem.setId_unit_med(medSrv.getId_unit_med());// 医学单位
		emsDrugItem.setFg_mm(medSrv.getFg_mm()); //物品标识
		emsDrugItem.setQuan_med(medSrv.getQuan_med()); // 剂量
		emsDrugItem.setFg_long(medSrv.getFg_long());//长临标识
		emsDrugItem.setFg_pmor(FBoolean.FALSE);// TODO 备用医嘱标识
		emsDrugItem.setFg_dose_anoma(FBoolean.FALSE);// 变动用药标识
		emsDrugItem.setFg_outp(FBoolean.FALSE);// 出院带药标识
		emsDrugItem.setNote_or(medSrv.getNote()); //备注
		emsDrugItem.setFg_bl(medSrv.getFg_bl());//费用标识
		emsDrugItem.setName_route(medSrv.getRoute_name());//用法名称
		emsDrugItem.setName_routedes(medSrv.getRoutedes_name());//用法要求名称
		emsDrugItem.setFg_propc(FBoolean.FALSE);//预防用药标识
		emsDrugItem.setId_route(medSrv.getId_route()); //  用法
		emsDrugItem.setName_route(medSrv.getRoute_name()); // 用法名称
		emsDrugItem.setId_freq(medSrv.getId_freq()); // 频次		
		emsDrugItem.setName_freq(medSrv.getFreq_name()); // 频次名称
		emsDrugItem.setSd_frequnitct(medSrv.getSd_frequnitct()); // 频次周期类型编码
		emsDrugItem.setFreqct(medSrv.getFreqct()); // 频次周期下次数	
		emsDrugItem.setEu_orsrcmdtp(OrSourceFromEnum.IIHSRVREF);
		emsDrugItem.setStatus(DOStatus.NEW);
		
		// 设置默认医嘱天数
		if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(emsDrugItem.getSd_frequnitct())) { //如果频次周期类型是星期，返回一个周期的天数
			emsDrugItem.setUse_days(7);
		} else {
			emsDrugItem.setUse_days(1);
		}
		// 开始时间 -- 
		emsDrugItem.setDt_begin_ui(CiOrdAppUtils.getServerDateTime()); // 开始时间
		// 截止时间
		emsDrugItem.setDt_end_ui(new FDateTime(emsDrugItem.getDt_begin_ui().getBeginDate().getDateAfter(1),emsDrugItem.getDt_begin_ui().getUFTime()));	
		// 计算总次数
		GetTotalTimesBP totalTimesBP = new GetTotalTimesBP();
		Integer times_cur = totalTimesBP.getTotalTimes(emsDrugItem.getId_freq(), emsDrugItem.getUse_days());
		emsDrugItem.setTimes_cur(times_cur);
		
		return emsDrugItem;
	}

	protected EmsOrDrug drugInfoFrom(String id_srv, String id_mm, CiEnContextDTO ctx) throws BizException{
		
		// 联合查询获取 EmsOrDrug 对象
		StringBuilder sqlSB = new StringBuilder();
		sqlSB.append(" SELECT  A.id_srvtp,A.sd_srvtp,A.id_srv,A.code as code_srv, A.name as name_srv,A.id_unit_med,D.name as name_unit_med,A.sd_mmbind_op,A.sd_mmbind_er, A.fg_bl,A.id_primd as id_pri,")
				.append(" B.id_mm,B.spec as spec_mm,B.name as name_mm,B.price,B.des as des_mm,B.sup_name as name_sup,B.code as code_mm ,")
				.append(" B.id_mupkgutp,B.sd_mupkgutp,B.id_opmutp,B.sd_opmutp,B.Factor_mb,B.factor_sb as factor_cb,B.id_val,B.sd_val,B.Id_Srvskin,B.Fg_skin as fg_skintest,")
			    .append(" drug.id_dosage ,drug.sd_dosage ,drug.id_pharm ,drug.sd_pharm ,")
			    .append(" drug.sd_pois ,drug.id_pois ,drug.id_anti ,drug.sd_anti ,drug.fg_pois ,drug.fg_anti ,B.id_mmtp,B.sd_mmtp,")
			    .append(" C.id_measdoc as id_unit_sale,C.name as name_unit_sale , E.id_measdoc as id_unit_base, E.name as name_unit_base, ")
			    .append(" A.quan_med,A.fg_mm,A.fg_ctm,A.id_primd id_pri,")
			    .append(" A.id_boil, F1.name as name_boil, ")
			    .append(" A.id_boildes,F.name as Name_boildes,")
			    .append(" G.id_freq,G.name as name_freq,G.freqct,G.SD_FREQUNITCT,")
			    .append(" A.id_route,H.name as name_route, ")
			    .append(" A.id_routedes,I.name as name_routedes ")
	    		.append(" from bd_srv A left outer join bd_mm B on A.id_srv = B.id_srv  ")
	    		.append(" left outer join bd_srv_drug  drug on drug.id_srv = A.ID_SRV")
	    		.append(" left outer join bd_measdoc C on B.id_unit_pkgsp=C.id_measdoc ")
	    		.append(" left outer join bd_measdoc D on A.id_unit_med=D.id_measdoc")
	    		.append(" left outer join bd_measdoc E on B.id_unit_pkgbase=E.id_measdoc ")
	    		.append(" left outer join bd_boil_des F  on A.Id_Boildes = F.Id_Boildes ")
	    		.append(" left outer join bd_boil F1  on A.Id_Boil = F1.Id_Boil ")
	    		.append(" left outer join bd_freq G on G.id_freq = A.id_freq")
	    		.append(" left outer join bd_route H on H.id_route = A.id_route")
	    		.append(" left outer join bd_route_des I on I.id_routedes = A.id_routedes")
	    		.append(" WHERE  B.fg_active =  'Y'  and B.ds ='0' and A.id_srv = ? and B.id_mm = ? ");
		// EnvContextUtil.processEnvContext(baseDO)
		SqlParam param = new SqlParam();
		param.addParam(id_srv);
		param.addParam(id_mm);
		DAFacade daf = new DAFacade();
		EmsOrDrug drug = (EmsOrDrug)daf.execQuery(sqlSB.toString(), param, new BeanHandler(EmsOrDrug.class));
		
		// 检验是否绑定物品
		if (CiOrdUtils.isEmpty(drug)||(CiOrdUtils.isTrue(drug.getFg_mm()) && CiOrdUtils.isEmpty(drug.getId_mm()))){
			throw new BizException(drug.getName_srv() + " 没有绑定物品 或者 物品没有启用");
		}
		
		//启用医保判断的方法,并将医保计划等信息设置到drug对象中
		if (CiOrdUtils.isHpUsing(ctx) && !FBoolean.TRUE.equals(cusFg_selfpay)){
			Map<String,BdHpIndicationDTO> tmpBdHpIndicationDTOCache = HpService.getMedSrvHpService(new MedSrvHpParam[]{ 
					new MedSrvHpParam(drug.getId_srv(),drug.getId_mm())}, ctx);
			if (tmpBdHpIndicationDTOCache != null && tmpBdHpIndicationDTOCache.size() > 0 ) {
				BdHpIndicationDTO hpIndiccation = (BdHpIndicationDTO)tmpBdHpIndicationDTOCache.values().toArray()[0];
				
				drug.setFg_treat(hpIndiccation.getFg_indic());
				drug.setFg_selfpay(drug.getSd_srvtp() != null && drug.getSd_srvtp().startsWith("0103")?FBoolean.FALSE:
					(CiOrdUtils.isTrue(hpIndiccation.getFg_indic())?FBoolean.FALSE:FBoolean.TRUE));
				
				int model = CiOrParamUtils.getMedInsuranceIndicInfoModelSet(ctx.getId_org());
				if(model==2){
					drug.setLimit("医保限制条件："+IsNull(hpIndiccation.getDes_hplimit())+"\n  院内限制条件："+ IsNull(hpIndiccation.getDes_hislimit()));
				}else if(model==1){
					drug.setLimit("院内限制条件："+ IsNull(hpIndiccation.getDes_hislimit()));
				}else{
					drug.setLimit(hpIndiccation.getDes_hplimit());
				}
				
				drug.setId_hp(ctx.getId_hp());
				drug.setSd_hpsrvtp(hpIndiccation.getSd_hpsrvtp());
				drug.setId_hpsrvtp(!CiOrdUtils.isEmpty(drug.getSd_hpsrvtp())?CiOrdUtils.idHpSrvtpFromSdHpSrvtp(drug.getSd_hpsrvtp()):null);
				drug.setFg_hpindicjudged(CiOrdUtils.getFg_hpindicjudged(hpIndiccation));
				drug.setBdHpIndicationDTO(new FArrayList().append(hpIndiccation));
			}
		}else{//非医保适应症时，自费标识应该为true
			drug.setFg_selfpay(FBoolean.TRUE);
			drug.setFg_hpindicjudged(0);
		}
		
		// 计量单位
		// 物品单位服务
		IMaterialBaseInfoService materService = ServiceFinder.find(IMaterialBaseInfoService.class);
		{
			Map<String,List<MaterialUnitDTO>> tmpMaterialUnitDTOCache = new HashMap<String,List<MaterialUnitDTO>>();
			
			MaterialUnitDTO[] szMaterUnit = materService.getMMunitByEntp(new String[]{id_mm}, ctx.getCode_entp());
			for(MaterialUnitDTO unit : szMaterUnit){
				if(tmpMaterialUnitDTOCache.containsKey(unit.getId_mm())){
					tmpMaterialUnitDTOCache.get(unit.getId_mm()).add(unit);
				}
				else{
					List<MaterialUnitDTO> materialList = new ArrayList<MaterialUnitDTO>();
					materialList.add(unit);
					tmpMaterialUnitDTOCache.put(unit.getId_mm(), materialList);
				}
			}
			
			if (tmpMaterialUnitDTOCache.size() == 0){
				throw new BizException(" 物品" + drug.getName_mm() + "没有对应的单位");
			}
			// 设置药品单位相关信息
			List<MaterialUnitDTO> tmpMaterialUnitList = tmpMaterialUnitDTOCache.get(drug.getId_mm());
			MaterialUnitDTO tmpMaterialUnitInfo = tmpMaterialUnitList.get(0);
			drug.setId_unit_sale(tmpMaterialUnitInfo.getId_measdoc());
			drug.setFactor_cb(tmpMaterialUnitInfo.getFactor());//基本包装单位和总量单位间的换算系数
			drug.setName_unit_sale(tmpMaterialUnitInfo.getMeasdoc_name());
			drug.setPrice(tmpMaterialUnitInfo.getPrice());//单价
			// 处理拼接信息
			StringBuilder unitIdSB = new StringBuilder();
			StringBuilder unitNameSB = new StringBuilder();
			StringBuilder unitWhereSB = new StringBuilder();
			StringBuilder factorSB = new StringBuilder();
			for (MaterialUnitDTO materialUnitInfo : tmpMaterialUnitList) {
				unitIdSB.append(",").append(materialUnitInfo.getId_measdoc());
				unitNameSB.append(",").append(materialUnitInfo.getMeasdoc_name());
				unitWhereSB.append(",'").append(materialUnitInfo.getId_measdoc()).append("'");
				factorSB.append(CiOrdUtils.isEmpty(materialUnitInfo.getFactor())?",1":"," + materialUnitInfo.getFactor());
			}
			drug.setStr_unit_pkg_ids(unitWhereSB.substring(1));
			FMap fmap = new FMap();
			if (unitIdSB.length() > 0) {
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_ID_MEASDOC, unitIdSB.substring(1));

			}
			if (unitNameSB.length() > 0) {
				fmap.put(ICiDictCodeConst.EMSORDRUG_RELATIVE_FIELD_MEASDOC_NAME, unitNameSB.substring(1));
			}
			if (factorSB.length() > 0) {
				fmap.put("factor", factorSB.toString().substring(1));
			}
			drug.setRelativefieldmap(fmap);
		}
		
		return drug;
	}
	
	private String IsNull(String limitInfo ){
		if(limitInfo == null) return "";
		return limitInfo;
	}
	/**
	 * 获取皮试结果
	 * 
	 * @param drug
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private SkinTestRstDTO getSkinTestCheckResult(EmsOrDrug drug, CiEnContextDTO ctx) throws BizException {

		// 非皮试药品，不获取皮试校验结果
		if (!FBoolean.TRUE.equals(drug.getFg_skintest())) {
			return null;
		}

		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();

		SkinTestParamDTO param = new SkinTestParamDTO();
		param.setId_mm(drug.getId_mm());
		param.setId_org(ctx.getId_org());
		param.setId_pi(ctx.getId_pat());
		param.setDt_birth(FDate.getDate(banner.getDt_birth()));
		param.setId_srv(drug.getId_srv());
		param.setId_skinsrv(drug.getId_srvskin());
		return CiOrdAppUtils.getCiOrdQryService().skinTestLogicMainBP(param);
	}

	/**
	 * 拼接用法关联的剂型id字符串
	 * 
	 * @param id_route 用法id
	 * @return 剂型字符串 结构 'arc','asdff','ffds'
	 * @throws BizException
	 */

	private String getDrugRouteOfDoSages(String id_route) throws BizException {

		// 自定义服务 的用法为空
		if (StringUtils.isBlank(id_route)) {
			return "";
		}
		StringBuffer idDosagesBuffer = null;
		// TODO 可以转换为只查询剂型id集合
		RouteDosageRefDO[] routeDosages = CiOrdAppUtils.getIRoutedosageRService().find("id_route='" + id_route + "'", null, FBoolean.FALSE);
       //加上RouteDosageRefDO[]数组长度为0的判别条件
		if (routeDosages != null&&routeDosages.length>0) {
			idDosagesBuffer = new StringBuffer();
			for (RouteDosageRefDO routeDosageRef : routeDosages) {
				idDosagesBuffer.append(",'" + routeDosageRef.getId_dosage() + "'");
			}
			return idDosagesBuffer.substring(1);
		}
		return "";
	}
}
