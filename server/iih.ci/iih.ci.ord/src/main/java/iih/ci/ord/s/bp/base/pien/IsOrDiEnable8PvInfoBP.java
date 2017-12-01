package iih.ci.ord.s.bp.base.pien;

import iih.ci.ord.emsdi.d.CiPvInfoDTO;
import iih.ci.ord.emsdi.d.PvStatusQryRstEnum;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.data.BizException;

/**
 * 根据患者就诊信息判断临床医嘱与诊断信息是否可开立操作BP
 */
public class IsOrDiEnable8PvInfoBP {
	/**
	 * 根据患者就诊信息判断临床医嘱与诊断信息是否可开立
	 * @param agentdo
	 * @throws BizException
	 */
	public Integer exec(CiPvInfoDTO pvinfo)  throws BizException{
		//有效性判断
		if(CiOrdUtils.isEmpty(pvinfo))return PvStatusQryRstEnum.PVINFOPARAMCHECKNULL;
		
		PatiVisitDO endo=CiOrdAppUtils.getPativisitQryService().findById(pvinfo.getId_en());
		if(CiOrdUtils.isEmpty(endo))return PvStatusQryRstEnum.PVINFOQRYDONULL;
		
		if(CiOrdUtils.isTrue(endo.getFg_canc())){//退诊患者
			return PvStatusQryRstEnum.CANCELEDPATI;
		}else if(isIpOut(endo)){ //住院已出院
			return PvStatusQryRstEnum.OUTHOSPPATI;
		}else if(isTransDept(endo,pvinfo)){ //已转科完成
			return PvStatusQryRstEnum.TRANSDEPTPATI;
		}
		return PvStatusQryRstEnum.NORMAL;
	}
	
	/**
	 * 是否住院已出院
	 * @param endo
	 * @return
	 */
	private boolean isIpOut(PatiVisitDO endo){
		if(!CiOrdUtils.isTrue(endo.getFg_ip()) && CiOrdUtils.isIpWf(endo.getCode_entp()))return true;
		return false;
	}
	
	/**
	 * 是否转科完毕
	 * 不包含转病区
	 * @param endo
	 * @return
	 */
	private boolean isTransDept(PatiVisitDO endo,CiPvInfoDTO pvinfo){
		if(!CiOrdUtils.isTrue(endo.getFg_ip()))return false;
		if((!CiOrdUtils.isEmpty(endo.getId_dep_phy()) && !CiOrdUtils.isEmpty(pvinfo.getId_dep_en())) && !endo.getId_dep_phy().equals(pvinfo.getId_dep_en()))return true;
		return false;
	}
	
	
}
