package iih.ci.ord.s.ems.biz.op.tmpl.base.apbt;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.sf.core.util.ServiceFinder;
import iih.ci.ord.ciordems.d.EmsBtItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;

/**
 * 备血医疗单有效性检查
 * @author wangqingzhu
 *
 */
public class TmplBaseApBtValidate extends EmsBaseValidate {

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx)
			throws BizException {
		EmsBtItemDO btdo=(EmsBtItemDO)objEms;
		if(btdo==null)return null;
		FArrayList errorList=new FArrayList();
		PatDO pat = getPatDO(ctx.getId_pat());
		if (pat.getSd_sex().equals("2") && pat.getDt_birth() != null) {

			if (validateage(pat.getDt_birth()) && (btdo.getParturition_cnt() == null || btdo.getPregnat_num() == null)) {
				errorList.add("年满18岁的女性患者，生育史必填！");
			}
		}
		// 献血史勾选上后，献血证号必填
		if (btdo.getFg_db() != null && FBoolean.TRUE.equals(btdo.getFg_db()) && btdo.getNo_db() == null) {
			errorList.add("请填写献血证号！");
		}

		// 助手开立备血不设置预定输血方式，需要判断
		if(StringUtils.isBlank(btdo.getId_mode())){
			errorList.add("请选择预定输血方式！");
		}
		return null;
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
}
