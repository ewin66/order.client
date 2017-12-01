package iih.ci.ord.s.bp.assi.impl;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilDesDO;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.medusage.d.MedUsageDesDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 拷贝MedSrv属性
 * 
 * @author HUMS
 *
 */
public class CopyMedSrvToCiEmsServiceImpl extends AbstractAssiCopy<MedSrvDO, CiEmsDTO> {

	@Override
	public void copyPropertys(MedSrvDO medSrvDO, CiEmsDTO ciEmsDto) throws BizException {

		// 频次
		if (StringUtils.isBlank(ciEmsDto.getId_freq())) {
			ciEmsDto.setId_freq(medSrvDO.getId_freq());
		}

		// 获取SD中频次
		FreqDefDO freqDef = ifreqdefMDORService.findById(ciEmsDto.getId_freq());
		if (freqDef == null) {
			throw new BizException("获取频次SD失败！");
		}

		ciEmsDto.setFg_long(freqDef.getFg_long());

		ciEmsDto.setName_freq(freqDef.getName());// 医嘱频次名称
		ciEmsDto.setFreqct(freqDef.getFreqct()); // 频次周期下次数
		ciEmsDto.setSd_frequnitct(freqDef.getSd_frequnitct()); // 频次周期类型编码
		ciEmsDto.setFrequnitct(freqDef.getFrequnitct());
		// 根据周期类型确定医嘱默认天数，住院医嘱天数允许为空
		if (!IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(ciEmsDto.getCode_entp()) && ciEmsDto.getDays_or() == null) {
			if (IBdSrvDictCodeConst.SD_FREQNUNITCT_WEEK.equals(ciEmsDto.getSd_frequnitct())) { // 如果频次周期类型是星期，返回一个周期的天数
				ciEmsDto.setDays_or(7);
			} else {
				ciEmsDto.setDays_or(1);
			}
		}

		// 设置用法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_route())) {

			MedUsageDO medUsage = imedusageRService.findById(ciEmsDto.getId_route()); // 用法
			if (medUsage == null) {
				throw new BizException("获取用法SD失败！");
			}
			ciEmsDto.setName_route(medUsage.getName());// 用法名称
		} else {
			ciEmsDto.setId_route(medSrvDO.getId_route());// 用法
			ciEmsDto.setName_route(medSrvDO.getRoute_name());// 用法名称
		}

		// 用法要求，设置用法要求id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_routedes())) {
			
			String[] id_routedes = ciEmsDto.getId_routedes().split(",");

			MedUsageDesDO[] medUsageDesArr = imedusagedesRService.findByIds(id_routedes,FBoolean.FALSE);
			if (medUsageDesArr == null) {
				throw new BizException("获取用法要求SD失败！");
			}
			
			StringBuffer usageNameBuffer = new StringBuffer();
			for(MedUsageDesDO medUsageDes : medUsageDesArr){
				usageNameBuffer.append(","+medUsageDes.getName());
			}
			
			ciEmsDto.setName_routedes(usageNameBuffer.substring(1));
		} else {
			ciEmsDto.setId_routedes(medSrvDO.getId_routedes());
			ciEmsDto.setName_routedes(medSrvDO.getRoutedes_name());
		}

		// 设置煎法id、名称
		if (StringUtils.isNotBlank(ciEmsDto.getId_boil())) {

			CHerbBoilMdDO cHerbBoilMd = icherbboilmdMDORService.findById(ciEmsDto.getId_boil());
			if (cHerbBoilMd == null) {
				throw new BizException("获取煎法SD失败！");
			}
			ciEmsDto.setName_boil(cHerbBoilMd.getName());
		} else {
			ciEmsDto.setId_boil(medSrvDO.getId_boil());
			ciEmsDto.setName_boil(medSrvDO.getBoil_name());
		}

		// 煎法要求
		if (StringUtils.isNotBlank(ciEmsDto.getId_boildes())) {

			CHerbBoilDesDO cherbBoilDes = icHerbBoilDesDORService.findById(ciEmsDto.getId_boildes());
			if (cherbBoilDes == null) {
				throw new BizException("煎法要求SD失败！");
			}
			ciEmsDto.setName_boildes(cherbBoilDes.getName());
		} else {
			ciEmsDto.setId_boildes(medSrvDO.getId_boildes());
			ciEmsDto.setName_boildes(medSrvDO.getBoildes_name());
		}

	}

}
