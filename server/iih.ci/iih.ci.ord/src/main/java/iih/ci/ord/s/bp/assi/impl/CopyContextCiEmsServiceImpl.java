package iih.ci.ord.s.bp.assi.impl;

import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.HpIndicJudgeEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import xap.mw.core.data.DOStatus;
import xap.sys.securityfw.switchdept.d.PsnInfo;

/**
 * 拷贝当前就诊上下文环境
 * 
 * @author HUMS
 *
 */
public class CopyContextCiEmsServiceImpl extends AbstractAssiCopy<CiEnContextDTO, CiEmsDTO> {

	@Override
	public void copyPropertys(CiEnContextDTO envinfo, CiEmsDTO ciEmsDto) {

		ciEmsDto.setStatus(DOStatus.NEW);// 设置为新建状态

		ciEmsDto.setId_pat(envinfo.getId_pat());// 患者
		ciEmsDto.setId_en(envinfo.getId_en());// 就诊
		ciEmsDto.setId_entp(envinfo.getId_entp());// 就诊类型
		ciEmsDto.setCode_entp(envinfo.getCode_entp());// 就诊类型编码

		ciEmsDto.setId_grp(envinfo.getId_grp());// 所属集团
		ciEmsDto.setId_org(envinfo.getId_org());// 所属组织
		ciEmsDto.setEmsappmode(envinfo.getEmsappmode());// 医疗单应用场景

		ciEmsDto.setId_dept_en(envinfo.getId_dep_en());// 就诊科室
		ciEmsDto.setId_dept_ns(envinfo.getId_dep_ns());// 护理单元

		PsnInfo psnInfo = envinfo.getPsnInfo();
		ciEmsDto.setId_emp_phy(psnInfo.getId_psndoc());// 开立医生 与 envinfo.getId_emp_or()相同
		ciEmsDto.setName_emp_phy(psnInfo.getName());// 开立医生名称
		
		ciEmsDto.setId_dep_phy(envinfo.getId_dep_or());// 开立科室
		ciEmsDto.setId_wg_or(envinfo.getId_wg_or());// 医疗组

		ciEmsDto.setFg_bb(envinfo.getFg_bb());// 婴儿标识
		ciEmsDto.setNo_bb(envinfo.getNo_bb());// 婴儿序号

		// 存在保外诊断时，医保就诊状态调整为不需要判断医保状态（非医保状态）
		if (HpBeyondEnum.HPEXTERNALDIAG.equals(envinfo.getEu_hpbeyond())) {
			ciEmsDto.setEu_hpindicjudge(HpIndicJudgeEnum.NONEEDJUDGE);
		}

		ciEmsDto.setBhpjudgerst(envinfo.getBhpjudgerst()); // 基本医保判断结果数据信息
		ciEmsDto.setDes_bhpjudgerst(envinfo.getDes_bhpjudgerst()); // 基本医保判断结果数据信息描述
	}


}
