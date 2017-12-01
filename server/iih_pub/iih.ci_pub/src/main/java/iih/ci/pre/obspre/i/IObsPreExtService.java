package iih.ci.pre.obspre.i;

import iih.ci.pre.dto.d.EmergPreDTO;
import iih.en.pv.dto.d.OpRegDTO;
import xap.mw.core.data.BizException;

/**
 * 预检扩展服务接口
 * @author yankan
 *
 */
public interface IObsPreExtService {
	/**
	 * 获取预检模板
	 * @param entpCode 就诊类型
	 * @param depId 科室id	 
	 * @return
	 * @throws BizException
	 */
	EmergPreDTO getPreTpl(String entpCode,String depId) throws BizException;
	/**
	 * 加载预检数据
	 * @param preDTO 预检模板
	 * @return
	 * @throws BizException
	 */
	EmergPreDTO loadData(EmergPreDTO preDTO) throws BizException;
	/**
	 * 获取预检信息
	 * @param opRegDTO 就诊登记DTO
	 * @param entpCode 就诊类型
	 * @return
	 * @throws BizException
	 */
	EmergPreDTO getPreDTO(OpRegDTO opRegDTO,String entpCode) throws BizException;
	/**
	 * 保存预检信息
	 * @param preDTO
	 * @param entpCode 就诊类型
	 * @return
	 * @throws BizException
	 */
	EmergPreDTO savePre(EmergPreDTO preDTO,String entpCode) throws BizException;	
}
