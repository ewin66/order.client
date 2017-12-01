package iih.ci.ord.i.orsms;

import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import java.util.List;
import xap.mw.core.data.BizException;

/**
 * 临床检验医嘱分合单规则接口
 */
public interface ICiLisOrSmsRule {
	/**
	 * 临床检验医嘱分合单规则接口
	 * @param CiLisOrSmsIoDTO中的FArrayList数据的强类型为CiLisOrInfo4Sms
	 * @return
	 * @throws BizException
	 */
	public List<CiLisOrSmsIoDTO> exec(List<CiLisOrSmsIoDTO> lisorlist)throws BizException;
}
