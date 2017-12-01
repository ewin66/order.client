package iih.ci.ord.s.bp.validate.assi;

import java.util.List;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.IEmsValidate4OtherBP;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 医疗单有效性检查
 * @author qzwang
 *
 */
public class CiEmsValidate implements IEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO,List<String> errorList) throws BizException {
		// 获取服务类型
		String sd_srvtp = emsDTO.getSd_srvtp();
		if (!StringUtil.isEmpty(sd_srvtp)) {
			IEmsValidate4OtherBP bp = getEmsValidateBP(sd_srvtp);
			if (null != bp) {
				return bp.exec(emsDTO,errorList);
			}
		}
		else{
			errorList.add("医疗单服务类型为空");
		}
		
		return false;
	}

	private IEmsValidate4OtherBP getEmsValidateBP(String sd_srvtp) {
		if (StringUtil.isEmpty(sd_srvtp)) {
			return null;
		}

		switch (sd_srvtp.substring(0, 2)) {
		// 药品
		case "01": // 药品
			switch (sd_srvtp.substring(2, 4)) {
			case "01": // 西药
			case "02":
				switch (sd_srvtp.substring(4)) {
				case "03":
				case "04":// 注射类
				default:// 口服类
					return new CiEmsValidate4DrugBP();
				}
			case "03":// 草药
				return new CiEmsValidate4HerbsBP();
			}
			break;

		// 检查
		case "02":// 检查属性

			switch (sd_srvtp.substring(2, 4)) {
			case "07":// 病理
				return new CiEmsValidate4PythgyBP();
			default:// 检查
				return new CiEmsValidate4RisBP();
			}

			// 检验
		case "03":

			return new CiEmsValidate4LisBP();

		// 手术
		case "04": // 手术属性
			switch (sd_srvtp.substring(2, 4)) {
			case "01":
				break;
			default:
				break;
			}
			break;

		// 通用医疗单
		case "05":
		case "06":
		case "08":
		case "99":
			return new CiEmsValidate4OtherBP();

		// 会诊
		case "09":// 会诊
			switch (sd_srvtp.substring(2, 4)) {
			case "01":// 会诊
			case "02":// 会诊
				return new CiEmsValidate4ConsBP();
			default:
				break;
			}
			break;

		case "12": {
			switch (sd_srvtp.substring(2, 4)) {
			case "01":// 转科
			case "04":// 跨科
				return new CiEmsValidate4TransBP();
			case "02":// // 1202 出院 1203 宣布临床死亡
			case "03"://
				return new CiEmsValidate4OutHospBP();

			case "05":// 转病区

				break;
			default:
				break;
			}
		}

			break;

		// 14 输血 用血
		case "14":// 输血
			switch (sd_srvtp.substring(4, 6)) {

			// 140101 血液制品
			// 140102 用血
			case "01":// 输血 备血

				return new CiEmsValidate4ApbtBP();

			case "02":// 用血
				return new CiEmsValidate4ApbuBP();

			default:
				break;
			}
			break;
		default:
			return new CiEmsValidate4OtherBP();

		}

		return null;

	}
}
