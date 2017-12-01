package iih.ci.diag.i.external;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

/**
 * 诊断对外提供接口
 * 
 * @author HUMS
 *
 */
public interface ICidiagExtQryService {
	/**
	 * @author yzh 2017-06-12 20:19:47
	 * @param code_ditp 诊断类型编码
	 * @param code_entp 就诊类型 00 门诊 10 住院
	 * @return FMap2 存放的key : code|name 对应 诊断类型编码和诊断类型名称
	 * @throws BizException
	 */
	public abstract FMap2 ConvertDiagType(String code_ditp,String code_entp)throws BizException;
}
