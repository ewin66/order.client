package iih.ci.ord.s;

import java.util.ArrayList;
import java.util.List;

import iih.bl.cg.service.i.IBLCancelSettlement;
import iih.ci.ord.d.CijudgeSpecillDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdMedicalInsuranceService;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.util.biz.CiEnContextUtil;
import iih.en.pv.dto.d.Ent4BannerDTO;
import iih.en.pv.entdi.d.EntDiDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医保服务相关接口实现
 * 
 * @author HUMS
 *
 */
@Service(serviceInterfaces = { ICiOrdMedicalInsuranceService.class }, binding = Binding.JSONRPC)
public class CiOrdMedicalInsuranceServiceImpl implements ICiOrdMedicalInsuranceService {

	/**
	 * 根据物品集合获取对应特殊病诊断名称集合
	 */
	@Override
	public FMap getSpecialDiseaseJudgeRstMap(CiEnContextDTO ctx, String[] id_mms) throws BizException {

		// 特殊病诊断判断结果
		FMap judgeRstmap = new FMap();
		// 特殊病判断
		IBLCancelSettlement blservice = CiOrdAppUtils.getIBLCancelSettlement();
		ICiOrdQryService ciordqryservice = CiOrdAppUtils.getCiOrdQryService();
		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();

		// 非医保或患者非特病直接返回
		if (!CiEnContextUtil.IsHpPat(ctx) || banner.getFg_hpspcl() != FBoolean.TRUE)
			return judgeRstmap;

		// 根据物品获取特殊病判断结果集合
		List<CijudgeSpecillDTO> judgeSpecillList = blservice.JudgeSpecillFlag(banner.getNo_hp(), banner.getId_hp(),
				id_mms);
		if (CiOrdUtils.isEmpty(judgeSpecillList) || judgeSpecillList.size() == 0) {
			return judgeRstmap;
		}

		// 当前就诊诊断集合
		EntDiDO[] entDis = null;
		// 获取特殊病药品集合
		for (CijudgeSpecillDTO specill : judgeSpecillList) {
			// 如果是特殊病药
			if (specill.getFg_mmspecill() == FBoolean.TRUE) {
				// 获取当前就诊诊断
				if (entDis == null) {
					entDis = ciordqryservice.getEntDiDOList(banner.getId_ent());
				}

				// 当前就诊诊断是否包含对应药品的特殊病诊断，如果不包含构造返回值
				boolean isContainSpecillDiag = false;
				FMap2 specillDiagMap = specill.getDiagmap();
				for (EntDiDO entDi : entDis) {
					if (specillDiagMap.containsKey(entDi.getCode_didef_dis())) {

						isContainSpecillDiag = true;
						break;
					}
				}

				// 不包含特殊病诊断时，构造返回的FMAP结构
				if (!isContainSpecillDiag) {
					judgeRstmap.put(specill.getId_mm(), specillDiagMap);
				}
			}
		}

		return judgeRstmap;
	}

	@Override
	public String getSpecialDiseaseJudgeRst(CiEnContextDTO ctx, FMap mmMap) throws BizException {

		List<String> idMMList = new ArrayList<String>();
		for (String id_mm : mmMap.keySet()) {
			idMMList.add(id_mm);
		}

		// 获取特殊病校验结果
		FMap specialMap = this.getSpecialDiseaseJudgeRstMap(ctx, idMMList.toArray(new String[idMMList.size()]));
		if (specialMap == null || specialMap.size() == 0) {
			return "";
		}

		StringBuffer specialBuffer = new StringBuffer();
		StringBuffer tempDiagBuffer = new StringBuffer(); // 诊断拼接

		for (String id_mm : specialMap.keySet()) {

			String name_mm = mmMap.get(id_mm).toString();
			specialBuffer.append(name_mm).append("是特殊病药品，未录入其对应特殊病的诊断:");

			FMap2 diagMap = (FMap2) specialMap.get(id_mm);
			for (String key : diagMap.keySet()) {
				tempDiagBuffer.append("," + key).append(" " + diagMap.get(key));
			}

			specialBuffer.append(tempDiagBuffer.substring(1)).append(System.lineSeparator());
		}

		return specialBuffer.toString();
	}

}
