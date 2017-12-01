package iih.ci.ord.s.bp.assi.impl;

import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 将当前就诊环境上下文复制到CiEmsSrvDTO
 * 
 * @author HUMS
 *
 */
public class CopyContextCiEmsSrvServiceImpl extends AbstractAssiCopy<CiEnContextDTO, CiEmsSrvDTO> {

	@Override
	protected void copyPropertys(CiEnContextDTO envinfo, CiEmsSrvDTO srvdto) throws BizException {

		srvdto.setStatus(DOStatus.NEW);

		srvdto.setId_dep_srv(envinfo.getId_dep_or());// 开立科室
		srvdto.setId_ward_srv(envinfo.getId_dep_ns());// 开立病区，门诊该值为空，住院时会有值
		srvdto.setId_emp_srv(envinfo.getId_emp_or());// 开立人员
		srvdto.setDt_create_srv(CiOrdAppUtils.getServerDateTime());// 开立时间
		srvdto.setId_hp(envinfo.getId_hp());// 主医保计划

		srvdto.setEu_sourcemd(OrSrvSourceFromEnum.PHYSIAN);// 医疗单项目数据来源方式

		// 医保就诊，并且都是保内诊断时为医保就诊，否则为自费（保外）
		if (envinfo.getId_hp() != null && HpBeyondEnum.HPDIAG.equals(envinfo.getEu_hpbeyond())) {
			srvdto.setFg_selfpay(FBoolean.FALSE);// 保内，非自费
		} else {
			srvdto.setFg_selfpay(FBoolean.TRUE);// 保外 、自费
		}
	}
}
