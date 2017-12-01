package iih.ci.ord.s.bp.assi.impl;

import iih.bd.srv.ems.d.EmsMatchRstDTO;
import iih.bd.srv.ems.d.SrvMatchEmsRstDTO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 从标准模板拷贝属性
 * 
 * @author HUMS
 *
 */
public class CopyCommonCiEmsServiceImpl extends AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> {

	@Override
	public void copyPropertys(CiOrTmplDTO ciOrTmplDTO, CiEmsDTO ciEmsDto) throws BizException {
		
		CiorderAggDO ciOrderAgg = (CiorderAggDO)ciOrTmplDTO.getAttrVal("CiorderAggDO");
		CiOrderDO ciOrder = ciOrderAgg.getParentDO();
		
		// 对应的 bd_srv，传递数据为医嘱模板时
		ciEmsDto.setId_srv(ciOrTmplDTO.getId_srv());
		MedSrvDO medSrvDO = medSrvMap.get(ciEmsDto.getId_srv());
		//MedSrvDO medSrvDO1 = imedsrvMDORService.findById(ciEmsDto.getId_srv());
		if (medSrvDO == null) {
			throw new BizException("标准模板转CiEmsDTO时根据id_srv[" + ciEmsDto.getId_srv() + "]未获取到服务项目");
		}
		
		ciEmsDto.setId_srvtp(ciOrTmplDTO.getId_srvtp());// 医嘱类型
		ciEmsDto.setSd_srvtp(ciOrTmplDTO.getSd_srvtp());// 医嘱类型编码
		// 套服务是否包含套内项目，组套中的套都不包含套内项目
		CiOrTmplSrvDTO tmplSrvDTO = null;
		if (OrSourceFromEnum.IIHCLINICALKITHELPER != ciOrTmplDTO.getEu_orsrcmdtp()) {// 不是来源组套
			// 获取服务项目
			FArrayList ciOrTmplSrvs = ciOrTmplDTO.getOrtmplsrvs();
			tmplSrvDTO = (CiOrTmplSrvDTO) ciOrTmplSrvs.get(0); // 取第0个作为主服务
			// 将模板中的用法、频次、煎法 赋值到CiEmsDTO中
			// 频次
			if (StringUtils.isBlank(tmplSrvDTO.getId_freq())) {
				throw new BizException("频次不能为空！");
			}
			ciEmsDto.setId_freq(tmplSrvDTO.getId_freq());// 频次id
			ciEmsDto.setId_route(tmplSrvDTO.getId_route());// 用法id
			ciEmsDto.setId_routedes(tmplSrvDTO.getId_routedes());// 用法要求
			ciEmsDto.setId_boil(tmplSrvDTO.getId_boil());// 设置煎法id
			ciEmsDto.setId_boildes(tmplSrvDTO.getId_boildes());// 煎法要求id

		}

		ciEmsDto.setDays_or(ciOrTmplDTO.getDays_or());// 医嘱天数

		// TODO 放到MedSrv中补全全，补全频次、频次下次数、用法、用法要求、煎法、煎法要求
		/*
		 * this.setCiEmsDTOUseDetailByMedSrv(ciEmsDto, medSrvDO);*/

		//TODO 已经移动到计算类里执行科室
		/*OrWfDeptInfoDTO deptMpDto = this.getMpDeptID(envinfo, medSrvDO);

		// ciEmsDto.setSd_orrsttp(ciOrTmplDTO.getSd_orrsttp());//医嘱结果编码
		ciEmsDto.setId_dep_mp(deptMpDto.getFirstid_mp_dept());// 执行科室Id
		ciEmsDto.setName_dep_mp(deptMpDto.getFirstname_mp_dept());// 执行科室名称
		*/
		 		
//		ciEmsDto.setId_unit_med("0001Z7100000000GEENQ");// 医学单位
//		ciEmsDto.setName_unit_med("个/日");// 医学单位名称
		
		ciEmsDto.setId_srvca(medSrvDO.getId_srvca());// 医嘱基本分类
		
		ciEmsDto.setInnercode_srvca(medSrvDO.getSrvca_innercode());// 服务分类内码
		
		ciEmsDto.setName_ems(medSrvDO.getName());// 医疗单显示名称

		// ciEmsDto.setId_orpltp(ciOrTmplDTO.getId_orpltp());//医嘱执行闭环类型
		
		// ciEmsDto.setMapkeys(ciOrTmplDTO.getMapkeys());//附加信息Map键值串
		// ciEmsDto.setMapinfo(ciOrTmplDTO.getMapinfo());//相关附加信息MAP
		// ciEmsDto.setFg_syncfee(ciOrTmplDTO.getFg_syncfee());//费用同步标识
		// ciEmsDto.setFreqct(ciOrTmplDTO.getFreqct());//频次下次数
		// ciEmsDto.setFrequnitct(ciOrTmplDTO.getFrequnitct());//频次周期数
		// ciEmsDto.setSd_frequnitct(ciOrTmplDTO.getSd_frequnitct());//频次周期类型编码
		// ciEmsDto.setSrvsetitms(ciOrTmplDTO.getSrvsetitms());//套对应的套内项目集合

		// ciEmsDto.setOrapplysheet(ciOrTmplDTO.getOrapplysheet());//医嘱对应的申请单
		
		ciEmsDto.setFg_set(medSrvDO.getFg_set());// 是否是套
		ciEmsDto.setDes_or(ciOrTmplDTO.getDes_or());// 嘱托

		// ciEmsDto.setCiorfreqtimes(ciOrTmplDTO.getCiorfreqtimes());//医嘱计划频次执行时刻集合
		ciEmsDto.setFg_pres_outp(FBoolean.FALSE);// 出院带药标识
		ciEmsDto.setDt_begin(CiOrdAppUtils.getServerDateTime());// 开始日期

		// 门诊不使用后台匹配医疗单
		SrvMatchEmsRstDTO emsmatch = CiOrdUtils.getFuncClassStr(envinfo, medSrvDO);
		if (emsmatch == null) {
			ciEmsDto.setEmstype(EmsType.COMMON);
			ciEmsDto.setFg_quickwflow(FBoolean.FALSE);
			// throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 配不到医疗单
			// ");
		} else {
			ciEmsDto.setFuncclassstr(emsmatch.getFuncclassstr());// 医疗单URL
			ciEmsDto.setId_srvof(emsmatch.getId_ems());// 医疗单
			ciEmsDto.setFg_quickwflow(emsmatch.getFg_quickwflow());
			try {
				ciEmsDto.setEmstype(Integer.parseInt(CiOrdUtils.getEmsFunclassKVDTO(emsmatch.getFuncclassstr()).getEmstype()));//医疗单类型
			} catch (Exception ex) {
				throw new BizException("医疗服务 ：" + medSrvDO.getName() + " 找不到医疗单类型 ");
			}
		}

		ciEmsDto.setApplyno(CiOrdUtils.getApplyNo(medSrvDO.getSd_srvtp()));// 申请单号
		// ciEmsDto.setFg_urgent(ciOrTmplDTO.getFg_urgent());//加急标识

		// ciEmsDto.setId_orrsttp(ciOrTmplDTO.getId_orrsttp());//医嘱结果
		// ciEmsDto.setId_or(ciOrTmplDTO.getId_or());//医嘱主键标识

		// ciEmsDto.setId_srv_pkg(ciOrTmplDTO.getId_srv_pkg());//服务包
		ciEmsDto.setFg_long(FBoolean.FALSE);// 长临标识

		// ciEmsDto.setEmstype(JudgeEmsType(medSrvDO.getSd_srvtp()));//
		// 医疗单类型(药品)
		ciEmsDto.setFg_boil(ciOrTmplDTO.getFg_boil());// 代煎标识

		ciEmsDto.setOrders(ciOrTmplDTO.getOrders());// 医嘱付数
		ciEmsDto.setOrders_boil(ciOrTmplDTO.getOrders());// 代煎付数
		ciEmsDto.setCode(ciOrTmplDTO.getCode());// 编码
		if (StringUtils.isBlank(ciEmsDto.getCode())) {
			ciEmsDto.setCode(medSrvDO.getCode());// 编码
		}
		ciEmsDto.setName(ciOrTmplDTO.getName());// 医嘱名称
		if (StringUtils.isBlank(ciEmsDto.getName())) {
			ciEmsDto.setName(medSrvDO.getName());
		}
		// ciEmsDto.setNote(ciOrTmplDTO.getNote());//备注
		
		// ciEmsDto.setFg_pmor(ciOrTmplDTO.getFg_pmor());//备用医嘱标识
		// ciEmsDto.setDes_pmor(ciOrTmplDTO.getDes_pmor());//备用医嘱使用条件描述
		// ciEmsDto.setId_or_rel(ciOrTmplDTO.getId_or_rel());//关联医嘱
		// ciEmsDto.setFg_ctlcp(ciOrTmplDTO.getFg_ctlcp());//临床路径控制标识
		// ciEmsDto.setFg_mr(ciOrTmplDTO.getFg_mr());//医疗记录联动标识
		// ciEmsDto.setFg_skintest(ciOrTmplDTO.getFg_skintest());//需皮试标识
		// ciEmsDto.setId_skintest_skip_reaso(ciOrTmplDTO.getId_skintest_skip_reaso());//不皮试原因（废弃不用了）
		// ciEmsDto.setSd_skintest_skip_reaso(ciOrTmplDTO.getSd_skintest_skip_reaso());//不皮试原因编码（废弃不用了）

		// ciEmsDto.setTimes_cur(calTimesCurBP.exec(ciEmsDto));// 总次数
		//TODO 
//		ciEmsDto.setFg_mp_in(mappingProperty.getFgMpIn(ciEmsDto)); // 在院执行状态
		// ciEmsDto.setFg_mp_in(FBoolean.TRUE);// 在院执行标识
		// 从助手生成的医疗单都设置在院执行，（医疗单中可以根据医生患者沟通确定是否需要在院执行）
/*		TODO 移动到计算类中
		if (ciEmsDto.getFg_mp_in() == FBoolean.TRUE) { // 在院执行时
			ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_cur());// 如果是在院执行，助手中的构造的医嘱等于总次数
			
			 * if (ciEmsDto.getTimes_mp_in() != null) { // TODO
			 * 上边没有设置在院执行次数的地方，这个判断没意义
			 * ciEmsDto.setTimes_mp_in(ciEmsDto.getTimes_mp_in()); } else {
			 * ciEmsDto.setTimes_mp_in(CiOrdUtils.JudgeTiemMpIn(ciEmsDto));
			 * ciEmsDto.setTimes_cur(ciEmsDto.getTimes_mp_in());// 总次数 TODO
			 * 总次数逻辑 }
			 
		}*/
/*		TODO 移动到 计算属性的类中
		if (ciEmsDto.getSd_srvtp() != null
				&& ciEmsDto.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
			if (tmplSrvDTO != null && tmplSrvDTO.getQuan_med() != null) {
				ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + tmplSrvDTO.getQuan_med() + " "
						+ medSrvDO.getMed_name() + "," + ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
			} else {
				ciEmsDto.setNote(" " + ciEmsDto.getName_boil() + " " + medSrvDO.getQuan_med() + " "
						+ medSrvDO.getMed_name() + "," + ciEmsDto.getName_freq() + "," + ciEmsDto.getName_route());
			}
		} else {
			// ciEmsDto.setNote();
		}*/
		 ciEmsDto.setFg_mp_bed(FBoolean.FALSE);//床边执行标识 只有检查涉及到床旁执行，是否床旁执行属性通过OpCopyRisPropertyImpl中设置
		// ciEmsDto.setTimes_firday_mp(ciOrTmplDTO.getTimes_firday_mp());//首日执行次数
		// ciEmsDto.setFg_or_doc(ciOrTmplDTO.getFg_or_doc());//医生医嘱标识
		// ciEmsDto.setId_su_or(ciOrTmplDTO.getId_su_or());//医嘱状态
		// ciEmsDto.setSd_su_or(ciOrTmplDTO.getSd_su_or());//医嘱状态编码
		// ciEmsDto.setFg_active_pm(ciOrTmplDTO.getFg_active_pm());//备用医嘱启用标识
		// ciEmsDto.setId_reltp(ciOrTmplDTO.getId_reltp());//关联医嘱类型编码
		// ciEmsDto.setSd_reltp(ciOrTmplDTO.getSd_reltp());//关联医嘱类型
		ciEmsDto.setEu_orsrcmdtp(ciOrTmplDTO.getEu_orsrcmdtp()); // 数据来源类型
																	// OrSourceFromEnum
																	// 既往、组套、模板、常规、分类...
		ciEmsDto.setId_orsrc_main(ciOrTmplDTO.getId_orsrc_main());// 数据来源id
																	// ，既往id_or
																	// ,组套的定义id，模板(常规)id，
																	// 分类id
		ciEmsDto.setId_orsrc_sub(ciOrTmplDTO.getId_orsrc_sub()); // 模板（常规）明细id
		ciEmsDto.setId_orsrc_subsub(ciOrTmplDTO.getId_orsrc_subsub());// 医嘱来源孙标识
		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		/*添加到读取上下文环境 CopyContextCiEmsServiceImpl
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(envinfo.getEu_hpbeyond())) {
			ciEmsDto.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}
		
		ciEmsDto.setBhpjudgerst(envinfo.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDto.setDes_bhpjudgerst(envinfo.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述
		 */
		/* 移动到抽象类中
		if (OrSourceFromEnum.IIHCLINICALKITHELPER == ciOrTmplDTO.getEu_orsrcmdtp()
				&& ciOrTmplDTO.getFg_set() == FBoolean.TRUE) {// 来源组套
			this.setMkrSetProperty(ciEmsDto, envinfo, ciOrTmplDTO, medSrvDO);
		} else {
			// 创建套内项目集合
			ciEmsDto.setSrvsetitms(this.createCiEmsSrvSetItems(ciOrTmplDTO));

			// 医嘱项目
			FArrayList list = this.getEmssrvs(envinfo, ciOrTmplDTO, medSrvDO);
			ciEmsDto.setEmssrvs(list);// 医疗单项目集合
		}

		// 设置服务价格
		this.setCiEmsPrice(ciEmsDto, medSrvDO);

		FArrayList emssrvList = ciEmsDto.getEmssrvs();
		for (Object obj : emssrvList) {
			CiEmsSrvDTO srvDTO = (CiEmsSrvDTO) obj;
			if (srvDTO.getFg_skintest() == FBoolean.TRUE) {
				ciEmsDto.setFg_skintest(FBoolean.TRUE);
				break;
			}
		}*/

		// TODO 代煎付数：计算代煎费用使用，草药的代煎付数等于草药付数
		// TODO 标本管理费用计算：检验门诊一条医嘱对应一组标本采集费 检验属性中标本类型，容器类型

	}

}
