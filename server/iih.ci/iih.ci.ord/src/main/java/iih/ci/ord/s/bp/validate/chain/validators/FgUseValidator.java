package iih.ci.ord.s.bp.validate.chain.validators;

import java.util.List;

import org.springframework.util.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.util.tools.BeanUtils;
import iih.ci.ord.s.bp.validate.chain.AbstractChainHandler;
import iih.ci.ord.s.bp.validate.chain.ValidateDataDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 可使用标识校验 <br>
 * 门诊、住院、急诊、体检、家床的可使用标识校验
 * 
 * @author HUMS
 *
 */
public class FgUseValidator extends AbstractChainHandler {

	@Override
	protected void doValidate(CiEnContextDTO ciEnContext, ValidateDataDTO param, List<String> handleResult)
			throws BizException {
		
		MedSrvDO medSrv = param.getMedSrv();
		if (medSrv == null) {
			handleResult.add("初始校验失败，医疗服务对象不能为空！");
			return;
		}

//		String code_entp = ciEnContext.getCode_entp();
//		if (StringUtils.isEmpty(code_entp)) {
//			handleResult.add("就诊类型编码为空！");
//			return;
//		}
//
//		String propertyName = this.getFgUseFiledName(code_entp);
//		if (StringUtils.isEmpty(propertyName)) {
//			handleResult.add("根据就诊类型编码[" + code_entp + "]未获取到对应的可使用标识！");
//			return;
//		}
//
//		Object val = BeanUtils.invokeMethod(medSrv, propertyName);
//
//		if (val == null || (FBoolean) val != FBoolean.TRUE) {
//			handleResult.add("服务[" + medSrv.getName() + "]在当前就诊类型不可用！");
//		}
	}

	@Override
	protected boolean isBreakValidate() {

		return false;
	}

	/**
	 * 获取需要校验的可使用状态的属性名
	 * 
	 * @param code_entp
	 * @return
	 */
	private String getFgUseFiledName(String code_entp) {

		if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(code_entp))
			return "getFg_use_op";// 门诊
		if (IBdFcDictCodeConst.SD_CODE_ENTP_IP.equals(code_entp))
			return "getFg_use_ip";// 住院
		if (IBdFcDictCodeConst.SD_CODE_ENTP_ET.equals(code_entp))
			return "getFg_use_er";// 急诊
		if (IBdFcDictCodeConst.SD_CODE_ENTP_PE.equals(code_entp))
			return "getFg_use_pe";// 体检
		if (IBdFcDictCodeConst.SD_CODE_ENTP_FA.equals(code_entp))
			return "getFg_use_fm";// 家庭

		return "";
	}
}
