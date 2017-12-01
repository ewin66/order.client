package iih.ci.ord.s.bp.ems_v1;

import iih.ci.ord.ciordems.d.EmsDrugItemDO;
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.s.bp.GetOrderBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 药品医疗单处理逻辑
 * 
 * @author wangqz
 *
 */
public class EmsDrugItemBP extends EmsBaseItemBP {

	public EmsDrugItemBP(CiEnContextDTO ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 根据服务id和物品id获取视图模型
	 */
	@Override
	public FMap2 getViewModel(String id_srv, String id_mm) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FMap2 getViewModel(CiOrderDO ord) throws BizException {
		// 获取医疗单接口
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		if (iCiOrdQryService == null)
			return null;
		
		// 获取医疗单
		FMap fmap = iCiOrdQryService.getCiEmsDTO(new String[] { ord.getId_or() });
		CiEmsDTO ems = (CiEmsDTO) fmap.get(ord.getId_or());
		
		// 组织医疗单的主要选项卡信息
		EmsDrugItemDO emsdrugs = handleEmsInfo(ems);
		
		// 提取主服务信息
		handleMasterInfo(ems,emsdrugs);
		 
		// 药品服务项目
		handleDrugItemInfo(ems,emsdrugs);
		
		// 组织返回结果
		FMap2 emsInfoMap = new FMap2();
		emsInfoMap.put("DrugItemDO", emsdrugs);
		emsInfoMap.put("SrvInfoList", emsdrugs.getAttrVal("DrugItemInfo"));
		emsInfoMap.put("DoseDrugMap", emsdrugs.getEmsDoseDrugMap());
		emsInfoMap.put("MeterialInfoList", emsdrugs.getAttrVal("DrugMeterialInfo"));
		
		return emsInfoMap;
	}
	
	
	/**
	 * 处理药品医疗单主要信息 选项卡
	 * 
	 * @param dto
	 * @param emsdrugs
	 * @throws BizException 
	 */
	private EmsDrugItemDO handleEmsInfo(CiEmsDTO dto) throws BizException {
		
		EmsDrugItemDO emsdrugs = new EmsDrugItemDO();
		emsdrugs.setId_srv(dto.getId_srv());
		emsdrugs.setName_srv(dto.getName());
		emsdrugs.setSd_srvtp(dto.getSd_srvtp());
		emsdrugs.setId_srvtp(dto.getId_srvtp());
		emsdrugs.setFg_long(dto.getFg_long());
		// 长临标识
		emsdrugs.setId_freq(dto.getId_freq()); // 医嘱频次 REF 医嘱频次定义
		emsdrugs.setName_freq(dto.getName_freq()); // 医嘱频次名称 SINGLE String
		emsdrugs.setFreqct(dto.getFreqct());// zwq 2016-09-06
		emsdrugs.setSd_frequnitct(dto.getSd_frequnitct());// zwq 2016-09-06
		emsdrugs.setId_route(dto.getId_route()); // 用法 REF 医疗服务_医疗用法
		emsdrugs.setName_route(dto.getName_route()); // 用法名称 SINGLE String
		emsdrugs.setId_routedes(dto.getId_routedes()); // 用法要求 REF 医疗用法要求
		emsdrugs.setName_routedes(dto.getName_routedes()); // 用法要求描述 SINGLE
															// String
		emsdrugs.setId_boil(dto.getId_boil()); // 煎法 REF 医疗服务中药煎法
		emsdrugs.setName_boil(dto.getName_boil()); // 煎法名称 SINGLE String
		emsdrugs.setId_boildes(dto.getId_boildes()); // 煎法要求 REF 中药煎法要求
		emsdrugs.setName_boildes(dto.getName_boildes()); // 煎法要求名称 SINGLE String
		// emsdrugs.setFg_boil(dto.getFg_boil() ); //代煎标识 SINGLE FBoolean
		emsdrugs.setAttrVal("Fg_boil", dto.getFg_boil());
		emsdrugs.setUse_days(dto.getDays_or()); // 医嘱天数 SINGLE Integer
		emsdrugs.setOrders(dto.getOrders()); // 医嘱付数 SINGLE Integer
		emsdrugs.setOrders_boil(dto.getOrders_boil()); // 代煎付数 SINGLE Integer
		// dto.getContent= //医嘱内容 SINGLE 备注 4000
		// emsdrugs.setNote_or( dto.getNote()); //备注 SINGLE 备注 1000
		emsdrugs.setAttrVal("Note_or", dto.getNote()); // 备注 SINGLE 备注 1000
		// emsdrugs.setid_edto.Id_emp_phy; //开立医生 REF 人员基本信息
		// dto.Name_emp_phy //开立医生姓名 SINGLE String
		// dto.Id_dep_phy ; //开立科室 REF 部门 20
		////// dto.Name_dep_phy //开立科室名称 SINGLE String
		// dto.Id_wg_or ; //医疗组 REF 业务组 20 业务
		emsdrugs.setDt_begin_ui(dto.getDt_begin()); // 开始日期 SINGLE FDateTim
		emsdrugs.setDt_end_ui(dto.getDt_end()); // 结束日期 SINGLE FDateTim
		if (emsdrugs.getDt_end_ui() != null && emsdrugs.getDt_end_ui().getYear() == 3000)
			emsdrugs.setDt_end_ui(null);
		emsdrugs.setDt_fail(dto.getDt_invalid()); // 医嘱过期时间 SINGLE FDateTim
		// dto.Fg_bb //婴儿标识 SINGLE FBoolean
		// dto.No_bb //婴儿序号 SINGLE Integer
		emsdrugs.setFg_pmor(dto.getFg_pmor()); // 备用医嘱标识 SINGLE FBoolean
		emsdrugs.setBak_des(dto.getDes_pmor()); // 备用医嘱使用条件描述 SINGLE
		// dto.Fg_active_pm= //备用医嘱启用标识 SINGLE FBoo
		// dto.Id_reltp //关联医嘱类型编码 SINGLE Stri
		// dto.Sd_reltp //关联医嘱类型 SINGLE String
		// dto.Id_or_rel //关联医嘱 SINGLE String
		// dto.Fg_ctlcp //临床路径控制标识 SINGLE FBoo
		// dto.Fg_mr //医疗记录联动标识 SINGLE FBoo
		// emsdrugs.setFg_skintest( dto.Fg_skintest()); //需皮试标识 SINGLE FBoolean
		// dto.Id_skintest_skip_reaso //不皮试原因 SINGLE
		// dto.Sd_skintest_skip_reaso //不皮试原因编码 SING
		emsdrugs.setFg_mp_in(dto.getFg_mp_in()); // 在院执行标识 SINGLE
		emsdrugs.setTimes_mp_in(dto.getTimes_mp_in());// 在院执行次数
		// dto.Times_mp_in //在院执行次数 SINGLE
		// dto.Fg_mp_bed=emsdrugs //床边执行标识 SINGLE
		// int t;
		// int.TryParse(emsdrugs.setFirst_freq, out t);
		// emsdrugs.setFirst_freq( dto.Times_firday_mp.ToString(); //首日执行次数
		// SINGLE
		// emsdrugs.setFg_or_doc( true); //医生医嘱标识 SINGLE
		emsdrugs.setAttrVal("Fg_or_doc", FBoolean.TRUE);
		// emsdrugs.setQuan_firday_mp( dto.getTimes_firday_mp());
		emsdrugs.setAttrVal("Quan_firday_mp", dto.getTimes_firday_mp());
		emsdrugs.setId_dep(dto.getId_dep_mp());// zwq 2016-08-04
		emsdrugs.setName_dep(dto.getName_dep_mp());// zwq 2016-08-04
		
		return emsdrugs;
		
	}

	/**
	 * 处理主服务信息
	 * @param dto
	 * @param emsdrugs
	 * @throws BizException
	 */
	private void handleMasterInfo(CiEmsDTO dto, EmsDrugItemDO emsdrugs) throws BizException{
		// 主服务信息
		CiEmsSrvDTO srv = getMasterSrvDTO(dto);
		if (srv != null) {
			emsdrugs.setFg_treat(srv.getFg_indic());// 医保适应症
			emsdrugs.setFg_dose_anoma(srv.getFg_dose_anoma());
			emsdrugs.setId_unit_med(srv.getId_unit_med());
			emsdrugs.setName_unit_med(srv.getName_unit_med());
			emsdrugs.setFg_self(srv.getFg_self());
			emsdrugs.setFg_outp(srv.getFg_outp());
			emsdrugs.setFg_propc(srv.getFg_propc());
			emsdrugs.setFg_bl(srv.getFg_bl());
			// 主服务关联的药品
			handleDrugMeterialInfo(srv, getCiEnContext(),emsdrugs);
		}
	}
	/**
	 * 获取主服务
	 * 
	 * @param ems
	 * @return
	 */
	private CiEmsSrvDTO getMasterSrvDTO(CiEmsDTO ems) {
		for (Object objSrv : ems.getEmssrvs()) {
			CiEmsSrvDTO srvdto = (CiEmsSrvDTO) objSrv;
			if (srvdto.getId_srv().equals(ems.getId_srv()) && srvdto.getFg_or().booleanValue()) {
				return srvdto;
			}
		}

		return null;
	}

	/**
	 * 处理药品项目信息
	 * 
	 * @param dto
	 * @param emsdrugs
	 */
	private void handleDrugItemInfo(CiEmsDTO dto, EmsDrugItemDO emsdrugs) {
		if (dto.getEmssrvs() == null)
			return;

		FArrayList drugList = new FArrayList(); // 医嘱处置项目
		FMap2 orDoseDrugMap = new FMap2(); // 变动用药数据映射 服务ID : 变动用药列表
		for (Object o : dto.getEmssrvs()) {
			CiEmsSrvDTO p = (CiEmsSrvDTO) o;
			if (p.getFg_or() == null || (p.getFg_or() != null && !p.getFg_or().booleanValue())) {
				continue;
			}
			

			EmsOrDrug drug = new EmsOrDrug();

			drug.setId_orsrv(p.getId_orsrv()); // 医疗单项目主键标识
			// Id_or = //医疗单 SINGLE F
			drug.setSortno(p.getSortno()); // 序号 SINGLE I
			drug.setId_srv(p.getId_srv()); // 医疗服务 REF
			// Id_srv_set //所属服务套 SINGL
			drug.setName_srv(p.getName_srv()); // 医疗服务名称 SINGL
			drug.setId_unit_med(p.getId_unit_med()); // 医疗单位 REF
			drug.setName_unit_med(p.getName_unit_med());// 医疗单位编码 SINGL
			drug.setQuan_med(p.getQuan_med()); // 剂量 SINGLE F
			drug.setPrice(p.getPrice()); // 参考价格 SINGL
			//同频次
			{
				drug.setId_freq(emsdrugs.getId_freq()); // 医嘱频次 REF -- 
				drug.setName_freq(emsdrugs.getName_freq()); // 医嘱频次名称 SINGL
				//drug.setSd_freq(emsdrugs.getSd_frequnitct());// 医嘱频次SD值
				drug.setFreqct(emsdrugs.getFreqct()); // 频次下次数
			}
			// 同用法
			{
				drug.setId_route(emsdrugs.getId_route());
				drug.setName_route(emsdrugs.getName_route());
			}
			// 同周期
			{
				drug.setUse_days(emsdrugs.getUse_days());
			}
			
			// Des_srv //备注 SINGLE
			// Fg_or //医嘱标识 SINGL
			// Fg_bl //费用标识 SINGL
			// Id_org_srv //开立机构 SINGL
			// Id_dep_srv //开立科室 SINGL
			// Id_ward_srv //开立病区 SINGL
			// Id_emp_srv //开立人员 SINGL
			// Dt_last_bl //最近生成日期 SINGL
			// Eu_blmd //划价方式 SINGL
			drug.setId_emsordrug(p.getId_orsrvmm()); // 服务项目物品 SINGL
			drug.setId_mm(p.getId_mm()); // 物品 SINGLE
			drug.setCode_mm(p.getCode_mm()); // 物品编码 SINGL
			drug.setName_mm(p.getName_mm()); // 物品名称 SINGL
			drug.setSpec_mm(p.getSpec_mm());  //规格 SINGLE S

			drug.setId_pgku_cur(p.getId_unit_sale()); // 零售单位 REF
			drug.setName_pgku_cur(p.getName_unit_sale()); // 零售单位名称 SINGL
			drug.setId_unit_base(p.getId_unit_base()); // 基本单位 REF
			drug.setName_unit_base(p.getName_unit_base());// 基本单位名称 SINGL
			drug.setName_unit_sale(p.getName_unit_sale());
			drug.setId_unit_sale(p.getId_unit_sale());
			drug.setQuan_cur(p.getQuan_cur() == null ? FDouble.ZERO_DBL : p.getQuan_cur()); // 总量_当前
																							// SINGL
			drug.setQuan_base(p.getQuan_base()); // 总量_基本 SINGL
			drug.setFactor_cb(p.getFactor_cb()); // 当前基本换算系数 S
			drug.setFactor_mb(p.getFactor_mb()); // 医疗基本换算系数 S
			drug.setId_dosage(p.getId_dosage()); // 药品剂型 SINGL
			drug.setSd_dosage(p.getSd_dosage()); // 药品剂型编码 SINGL
			drug.setId_pharm(p.getId_pharm()); // 药理分类 SINGL
			drug.setSd_pharm(p.getSd_pharm()); // 药理分类编码 SINGL
			drug.setId_pois(p.getId_pois()); // 毒麻分类 SINGL
			drug.setSd_pois(p.getSd_pois()); // 毒麻分类编码 SINGL
			drug.setId_anti(p.getId_anti()); // 抗菌药分类 SINGL
			drug.setSd_anti(p.getSd_anti()); // 抗菌药分类编码 S
			drug.setId_mmtp(p.getId_mmtp()); // 物品类型 SINGL
			drug.setSd_mmtp(p.getSd_mmtp()); // 物品类型编码 SINGL
			drug.setId_val(p.getId_val()); // 价值分类 SINGL
			drug.setSd_val(p.getSd_val()); // 价值分类编码 SINGL
			drug.setId_boildes(p.getId_boildes());// 煎法
			drug.setName_boildes(p.getName_boildes());// 煎法名称
			drug.setFg_propc(p.getFg_propc());// 预防用药标识
			drug.setFg_treat(p.getFg_indic());// 治疗用药标识
			drug.setNote_or(p.getDes_srv());// 备注
			drug.setId_mp_dep(p.getId_dep());// 执行科室id
			drug.setName_mp_dep(p.getName_dep());// 执行科室
			drug.setFg_self(p.getFg_self());// 自备药标识
			drug.setFg_dose_anoma(p.getFg_dose_anoma());// 变动用药标识
			drug.setFg_ctm(p.getFg_selfsrv());// 自定义服务标志
			drug.setFg_selfpay(p.getFg_selfpay()); // 自费标志
			// Indica //适应症 SINGLE S
			// Constr //禁忌症 SINGLE S
			// React //不良反应 SINGL
			// Guide //主要作用 SINGL
			// Fg_otc //OTC标识 SINGL
			// Emsfreqdose //变动用药安排 SINGL
			// Id_body //部位 SINGLE
			// Sd_body //部位编码 SINGL
			// Id_pos //体位 SINGLE
			// Sd_pos //体位编码 SINGL
			// Body_name //部位名称 SINGL
			// Fg_indic //医保适应症标识 S

			drugList.add(drug);

			orDoseDrugMap.put(p.getId_srv(), handleDoseDrugInfo(p));
		}
		emsdrugs.setAttrVal("DrugItemInfo", drugList);
		emsdrugs.setEmsDoseDrugMap(orDoseDrugMap);
	}

	/**
	 * 处理变动用药信息
	 * @param srv
	 * @return
	 */
	private FArrayList handleDoseDrugInfo(CiEmsSrvDTO srv) {

		if (srv.getEmsfreqdose() == null)
			return null;

		FArrayList orDoseDrugList = new FArrayList();
		for (Object o : srv.getEmsfreqdose()) {
			OrdSrvDoseDO item = (OrdSrvDoseDO) o;

			EmsOrDrug drug = new EmsOrDrug();
			drug.setId_emsordrug(item.getId_orsrvdose());
			drug.setId_orsrv(item.getId_orsrv());
			drug.setId_freqtime(item.getId_freqtime());
			drug.setQuan_med(item.getQuan_dose());
			drug.setName_freqtime(item.getId_freqtime());
			drug.setName_unit_med(item.getName_unit_dose());
			drug.setId_unit_med(item.getId_unit_dose());
			orDoseDrugList.add(drug);
		}
		return orDoseDrugList;
	}

	/**
	 * 关联计算该药品服务对应的所有药品信息
	 * @param srv
	 * @param ctx
	 * @param emsdrugs
	 * @throws BizException
	 */
	protected void handleDrugMeterialInfo(CiEmsSrvDTO srv, CiEnContextDTO ctx, EmsDrugItemDO emsdrugs)
			throws BizException {
		if(emsdrugs.getAttrVal("DrugMeterialInfo")== null){
			emsdrugs.setAttrVal("DrugMeterialInfo", new FMap2());
		}
		
		((FMap2)emsdrugs.getAttrVal("DrugMeterialInfo")).put(srv.getId_srv(), getMeterialInfo(srv.getId_srv(), ctx));
	}

	/**
	 * 获取服务下的所有物品信息
	 * @param id_srv
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	private FArrayList getMeterialInfo(String id_srv, CiEnContextDTO ctx) throws BizException {
		FArrayList rtnList = null;
		GetOrderBP bp = new GetOrderBP();
		EmsHeadDO hd = bp.exec(id_srv, ctx);
		rtnList = hd.getEmsdrugitems();
		return rtnList;
	}

	
}
