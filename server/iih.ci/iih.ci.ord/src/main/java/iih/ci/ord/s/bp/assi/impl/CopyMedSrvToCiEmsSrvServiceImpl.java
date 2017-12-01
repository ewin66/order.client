package iih.ci.ord.s.bp.assi.impl;

import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvRisDO;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 拷贝服务项目
 * 
 * @author HUMS
 *
 */
public class CopyMedSrvToCiEmsSrvServiceImpl extends AbstractAssiCopy<MedSrvDO, CiEmsSrvDTO> {

	@Override
	protected void copyPropertys(MedSrvDO medSrv, CiEmsSrvDTO srvdto) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			srvdto.setId_freq(medSrv.getId_freq());
		}

		// 设置用法id
		if (StringUtils.isBlank(srvdto.getId_route())) {
			srvdto.setId_route(medSrv.getId_route());
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isBlank(srvdto.getId_routedes())) {
			srvdto.setId_routedes(medSrv.getId_routedes());
		}

		// 设置煎法id
		if (StringUtils.isBlank(srvdto.getId_boil())) {
			srvdto.setId_boil(medSrv.getId_boil());
		}

		// 煎法要求
		if (StringUtils.isBlank(srvdto.getId_boildes())) {
			srvdto.setId_boildes(medSrv.getId_boildes());
		}

		// 设置频次、用法、用法要求、煎法、煎法要求
		this.setCiEmsSrvUseDetail(srvdto, medSrv);

		// srvdto.setId_orsrv(tmplSrv.getId_orsrv());//医疗单项目主键标识
		// srvdto.setId_or(tmplSrv.getId_or());//医疗单
		// srvdto.setSortno(sortNo);// 序号

		if (StringUtils.isBlank(srvdto.getId_srv())) {
			srvdto.setId_srv(medSrv.getId_srv());// 医疗服务
		}

		if (StringUtils.isBlank(srvdto.getId_srvtp())) {
			srvdto.setId_srvtp(medSrv.getId_srvtp());// 服务类型
		}

		if (StringUtils.isBlank(srvdto.getSd_srvtp())) {
			srvdto.setSd_srvtp(medSrv.getSd_srvtp());// 服务类型编码
		}

		srvdto.setCode_srv(medSrv.getCode());// 医疗服务编码
		srvdto.setName_srv(medSrv.getName());// 医疗服务名称
		srvdto.setId_srvca(medSrv.getId_srvca());// 服务项目基本分类

		if (isFDoubleEmpty(srvdto.getQuan_med())) {
			srvdto.setQuan_med(medSrv.getQuan_med());// 医学单位数值（剂量）
		}

		if (StringUtils.isBlank(srvdto.getId_unit_med()) || StringUtils.isBlank(srvdto.getName_unit_med())) {
			srvdto.setId_unit_med(medSrv.getId_unit_med());// 医学单位(剂量单位)
			srvdto.setName_unit_med(medSrv.getMed_name()); // 医学单位名称（剂量单位名称）
		}		

		srvdto.setPrice(medSrv.getPri());// 参考价格 TODO 参考价为空时需要重新计算

		// srvdto.setFg_dose_anoma(tmplSrv.getFg_dose_anoma());//变动用药标识
		// srvdto.setDes_srv(tmplSrv.getDes_srv());//备注

		srvdto.setFg_mm(medSrv.getFg_mm());// 物品标识
		srvdto.setFg_set(medSrv.getFg_set());// 服务套标识 套内项目全设置为False TODO
		// srvdto.setId_srv_set(medSrv.getId_srv()); 在循环过程中设置该属性

		/*
		 * //TODO 移动到服务项目的映射中 MedSrvSetItemDO medSrvSetItem =
		 * setItemSrvMap.get(srvdto.getId_srv()); if(medSrvSetItem != null){
		 * srvdto.setFg_or(medSrvSetItem.getFg_clinical());// 医嘱标识 }else{
		 * srvdto.setFg_or(medSrv.getFg_or());// 医嘱标识 }
		 */

		srvdto.setFg_bl(medSrv.getFg_bl());// 费用标识
		// srvdto.setFg_self(medSrvDO.getFg_self());//自备药标识
		// srvdto.setFg_outp(tmplSrv.getFg_outp());//出院带药标识（废弃不用了）
		// srvdto.setFg_propc(tmplSrv.getFg_propc());//预防用药标识
		// srvdto.setFg_treat(tmplSrv.getFg_treat());//治疗用药标识
		// srvdto.setId_org_srv(envinfo.getId_org_or());//开立机构
		// srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		// srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		// srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		// srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		// OrWfDeptInfoDTO deptMpDTo1 = getMpDeptID(envinfo, medSrv); // 执行科室
		//
		// srvdto.setId_dep(deptMpDTo.getFirstid_mp_dept());// 执行科室
		// srvdto.setName_dep(deptMpDTo.getFirstname_mp_dept());// 执行科室名称
		// srvdto.setDt_last_bl(tmplSrv.getDt_last_bl());//最近生成日期
		srvdto.setEu_blmd(medSrv.getEu_blmd());// 划价方式
		// srvdto.setId_orsrvmm(tmplSrv.getId_orsrvmm());//服务项目物品
		// srvdto.setId_mm(tmplSrv.getId_mm());// 物品

		// srvdto.setEmsfreqdose(tmplSrv.getEmsfreqdose());//变动用药安排

		// srvdto.setFg_indic(tmplSrv.getFg_indic());//医保适应症标识
		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式
		// srvdto.setSrv_sv(medSrvDO.getSrv_sv());//服务版本号
		// srvdto.setMm_sv(tmplSrv.getMm_sv());//物品版本号
		// srvdto.setFg_skintest(tmplSrv.getFg_skintest());//需皮试标识
		// srvdto.setId_skintest_skip_reason(tmplSrv.getId_skintest_skip_reason());//不皮试原因
		// srvdto.setSd_skintest_skip_reason(tmplSrv.getSd_skintest_skip_reason());//不皮试原因编码
		// srvdto.setId_reltp(tmplSrv.getId_reltp());//关联类型
		// srvdto.setSd_reltp(tmplSrv.getSd_reltp());//关联类型编码
		// srvdto.setId_or_rel(tmplSrv.getId_or_rel());//关联医嘱
		// srvdto.setFg_skintest_rst(tmplSrv.getFg_skintest_rst());//皮试是否有结果
		srvdto.setFg_selfsrv(medSrv.getFg_ctm());// 自定义服务标识
		// srvdto.setId_srv_src(tmplSrv.getId_srv_src());//所属来源服务
		// srvdto.setQuan_total_medu(tmplSrv.getQuan_total_medu());// 服务总量
		srvdto.setId_primd(medSrv.getId_primd());// 定价模式
		// srvdto.setFg_selfpay(medSrvDO.getFg_selfpay());//自费标识
		// srvdto.setId_hp(envinfo.getId_hp());// 主医保计划
		// srvdto.setId_hpsrvtp(tmplSrv.getId_hpsrvtp());//医保目录类型
		// srvdto.setSd_hpsrvtp(tmplSrv.getSd_hpsrvtp());//医保目录类型编码
		// srvdto.setId_dep_wh(deptMpDTo.getId_dep_wh());// 仓库
		// srvdto.setEmsagentinfo(tmplSrv.getEmsagentinfo());//毒麻药品服务代办人信息
		srvdto.setInnercode_srvca(medSrv.getSrvca_code());// 服务分类内码
		// srvdto.setSd_frequnitct(tmplSrv.getSd_frequnitct());//频次周期类型
		// srvdto.setFrequnitct(tmplSrv.getFrequnitct());//频次周期数
		// srvdto.setFreqct(tmplSrv.getFreqct());//频次周期下次数
		// srvdto.setName_hpsrvtp(tmplSrv.getName_hpsrvtp());//医保目录名称
		// srvdto.setLimit(tmplSrv.getLimit());//限制报销条件
		// srvdto.setAmt_total(tmplSrv.getAmt_total());//总金额
		// srvdto.setName_dep_wh(deptMpDTo.getId_dep_wh());// 库房名称
		// srvdto.setId_unit_cg(tmplSrv.getId_unit_cg());//计费单位
		// srvdto.setName_unit_cg(meterial.getParentDO().getName_unit_cg());//计费单位名称
		// srvdto.setQuan_cgbase(meterial.getParentDO().getQuan_cgbase());//计费基数
		// srvdto.setFactor_cm(meterial.getParentDO().getFactor_cm());//系数_费医
		// srvdto.setSd_roundmd_cg(meterial.getParentDO().getSd_roundmd_cg());//计费取整模式

		// srvdto.setAmt_cur(tmplSrv.getAmt_cur());//金额
		// srvdto.setQuan_stock(tmplSrv.getQuan_stock());//可用库存
		// srvdto.setId_srvskin(tmplSrv.getId_srvskin());//对应皮试服务
		// srvdto.setMapkeys(tmplSrv.getMapkeys());//关联信息Map键值串
		// srvdto.setMapinfo(tmplSrv.getMapinfo());//服务与物品关联信息MAP
		// srvdto.setPriby(tmplSrv.getPriby());//计价依据
		// srvdto.setFg_base(tmplSrv.getFg_base());//基数药标识

		MedSrvRisDO medSrvRis = srvRisMap.get(srvdto.getId_srv());
		if (medSrvRis != null && srvdto.getFg_set() != FBoolean.TRUE) {
			srvdto.setId_body(medSrvRis.getId_body());// 部位
			srvdto.setSd_body(medSrvRis.getSd_body());// 部位编码
			srvdto.setBody_name(medSrvRis.getName_body());// 部位名称
			srvdto.setId_pos(medSrvRis.getId_pos());// 体位
			srvdto.setSd_pos(medSrvRis.getSd_pos());// 体位编码
			srvdto.setPos_name(medSrvRis.getName_pos());// 体位名称
		}
		
		// TODO 调用计算总量方法
	}
	
	/**
	 * 设置CiEmsSrvDTO 频次、用法、用法要求、煎法、煎法要求
	 * 
	 * @param ciEmsDto
	 * @param tmplSrvDTO CiEmsDTO ciEmsDto
	 * @throws BizException 
	 */
	private void setCiEmsSrvUseDetail(CiEmsSrvDTO srvdto, MedSrvDO medSrvDO) throws BizException {

		// 频次
		if (StringUtils.isBlank(srvdto.getId_freq())) {
			throw new BizException("频次不能为空！");
		}

		FreqDefDO freqDef = ifreqdefMDORService.findById(srvdto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}
		srvdto.setId_freq(freqDef.getId_freq());
		srvdto.setName_freq(freqDef.getName());// 医嘱频次名称
		srvdto.setFreqct(freqDef.getFreqct()); // 频次周期下次数		
		srvdto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期编码
		srvdto.setFrequnitct(freqDef.getFreqct());// TODO 频次周期数，使用混淆	

		// 设置用法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(srvdto.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			srvdto.setName_route(medUsage.getName());// 用法名称
		} else {
			srvdto.setId_route(medSrvDO.getId_route());// 用法
			srvdto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(srvdto.getId_routedes())) {

			String[] id_routedes = srvdto.getId_routedes().split(",");

			MedUsageDesDO[] medUsageDesArr = imedusagedesRService.findByIds(id_routedes,FBoolean.FALSE);
			if (medUsageDesArr == null) {
				throw new BizException("获取用法要求SD失败！");
			}
			
			StringBuffer usageNameBuffer = new StringBuffer();
			for(MedUsageDesDO medUsageDes : medUsageDesArr){
				usageNameBuffer.append(","+medUsageDes.getName());
			}
			
			srvdto.setName_routedes(usageNameBuffer.substring(1));
		} else {
			srvdto.setId_routedes(medSrvDO.getId_routedes());
			srvdto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(srvdto.getId_boil())) {
			CHerbBoilMdDO cHerbBoilMd = icherbboilmdMDORService.findById(srvdto.getId_boil());
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			srvdto.setName_boil(cHerbBoilMd.getName());
		} else {
			srvdto.setId_boil(medSrvDO.getId_boil());
			srvdto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(srvdto.getId_boildes())) {
			CHerbBoilDesDO cherbBoilDes = icHerbBoilDesDORService.findById(srvdto.getId_boildes());
			if (cherbBoilDes == null) {
				throw new BizException("获取煎法要求SD失败！");
			}
			srvdto.setName_boildes(cherbBoilDes.getName());
		} else {
			srvdto.setId_boildes(medSrvDO.getId_boildes());
			srvdto.setName_boildes(medSrvDO.getBoildes_name());
		}
	}

}
