package iih.ci.mrfp.dto.i;

import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.inpatient.dto.d.EntForMedRecDTO;
import iih.pi.reg.dto.d.PatiInfoForMrDTO;
import xap.mw.core.data.BizException;

/**
 * 住院病案首页  接口集合
 * @author 杨建兵
 *
 */
public interface CiMrFpService {
	
	/**
	 * 刘羽处查询的相关信息数据 查询患者信息
	 * @param idPat
	 * @return
	 */
	PatiInfoForMrDTO getPatiInfoForMrDTO(String idPat) throws BizException ;
	
	/**
	 * 颜刊处提供dto数据  查询当此就诊信息
	 * @param idEnt
	 * @return
	 */
	EntForMedRecDTO getEntForMedRecDTO(String idEnt) throws BizException ;
	/**
	 * 颜刊处提供dto数据  查询当此就诊信息
	 * @param idEnt
	 * @return
	 * @throws BizException
	 */
	public IpDetailDTO getIpDetailInfo(String idEnt) throws BizException;
}
