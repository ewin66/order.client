package iih.ci.ord.s.bp.validate;

import xap.mw.core.data.BizException;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.IpBasicDTO;

/**
 * 医嘱开立时，对人员的就诊状态进行校验
 * @author Administrator
 *
 */
public class CiOrOpenEntStatusValidateBP {
	/**
	 * 只处理住院的情况，患者的就诊状态发生改变（已出院），提示患者已出院
	 * @param or_name 医嘱名称
	 * @param code_entp 就诊类型
	 * @param id_en 就诊id
	 * @param id_dep_phy 前台传来的就诊科室
	 * @throws BizException
	 */
	public void exec(String code_entp,String id_en,String id_dep_phy,String id_dep_nur) throws BizException{
		if(CiOrdUtils.isEmpty(code_entp)) return;
		//只处理住院的情况
		if(!IEnDictCodeConst.SD_ENTP_INPATIENT.equals(code_entp)) return;
		if(CiOrdUtils.isEmpty(id_en)) throw new BizException("患者就诊号不存在！");
		IpBasicDTO basicDto = CiOrdAppUtils.getIEQryService().getIpBasicInfo(id_en);
		if(!CiOrdUtils.isEmpty(basicDto.getSd_status())){
			if(basicDto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALOUT)||basicDto.getSd_status().equals(IEnDictCodeConst.SD_ENSTATUS_IN_HOSPITALQUIT)) throw new BizException("患者当前已经不在院，无法操作医嘱，请重新登录医生站!");
			if(!basicDto.getId_dep_phy().equals(id_dep_phy)) throw new BizException("患者当前就诊科室已经变更，无法操作医嘱，请重新登录医生站！");
			if(!CiOrdUtils.isEmpty(id_dep_nur)&&!basicDto.getId_dep_nur().equals(id_dep_nur)) throw new BizException("患者当前就诊病区已经变更，无法操作医嘱，请重新登录医生站！");
		}
	}
}
