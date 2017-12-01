package iih.ci.ord.s.bp.validate.assi;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.s.bp.validate.assi.common.IEmsValidate4OtherBP;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 备血医疗单有效性检查
 * 
 * @author qzwang
 *
 */
public class CiEmsValidate4ApbtBP implements IEmsValidate4OtherBP {

	@Override
	public boolean exec(CiEmsDTO emsDTO, List<String> errorList) throws BizException {
		// TODO Auto-generated method stub
		PatDO pat = getPatDO(emsDTO.getId_pat());

		CiorappbtAggDO aggdo = getAppBt(emsDTO);
		if (aggdo == null)
			return false;
		OrdApBtDO ordApBt = aggdo.getParentDO();
		
		if (pat.getSd_sex().equals("2") && pat.getDt_birth() != null) {

			if (validateage(pat.getDt_birth()) && (ordApBt.getParturition_cnt() == null || ordApBt.getPregnant_num() == null)) {
				errorList.add("年满18岁的女性患者，生育史必填！");
			}
		}

		// 献血史勾选上后，献血证号必填
		if (ordApBt.getFg_db() != null && ordApBt.getFg_db() == FBoolean.TRUE && ordApBt.getNo_db() == null) {
			errorList.add("请填写献血证号！");
		}
		
		// 助手开立备血不设置预定输血方式，需要判断
		if(StringUtils.isBlank(ordApBt.getId_mode_bt())){
			errorList.add("请选择预定输血方式！");
		}

		if (errorList.size() > 0) {

			return false;
		}
		return true;
	}

	private PatDO getPatDO(String id_pat) throws BizException {

		IPatiMDORService service = ServiceFinder.find(IPatiMDORService.class);
		PatDO pat = service.findById(id_pat);
		return pat;
	}

	// 女性年满18岁，生育史必填
	private boolean validateage(FDate birthdate) {

		Date d = new Date();
		FDate olddate = new FDate(new Date(d.getYear() - 18, d.getMonth(), d.getDay()));
		if (birthdate.before(olddate))
			return false;
		else {
			return true;
		}
	}

	private CiorappbtAggDO getAppBt(CiEmsDTO emsDTO) {

		FMap m = emsDTO.getOrapplysheet();
		CiorappbtAggDO agg = null;
		if (m.containsKey("7"))
			agg = (CiorappbtAggDO) m.get("7");
		return agg;
	}

}
