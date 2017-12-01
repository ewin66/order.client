package iih.ci.ord.i.orsms;

import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;

import java.util.List;

import xap.mw.core.data.BizException;

/**
 * 临床检验医嘱打印合单规则编排插件接口
 */
public interface ICiLisOrSmsRuleArrange {
	/**
	 * 临床检验医嘱打印合单规则编排插件接口
	 * CiLisOrSmsIoDTO中的FArrayList数据的强类型为CiLisOrInfo4Sms
	 * @param lisorlist：
	 * @return
	 * @throws BizException
	 */
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist)throws BizException; 

}
