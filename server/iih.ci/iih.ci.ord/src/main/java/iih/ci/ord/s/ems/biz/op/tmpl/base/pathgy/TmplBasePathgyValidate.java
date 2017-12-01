package iih.ci.ord.s.ems.biz.op.tmpl.base.pathgy;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import iih.ci.ord.ciordems.d.EmsItemInPathgy;
import iih.ci.ord.ciordems.d.EmsPathgyItemDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 病理医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class TmplBasePathgyValidate extends EmsBaseValidate {
	public ErrorEmsList viewModelValidate(Object objEms, CiEnContextDTO ctx) throws BizException {
		FArrayList errorList = new FArrayList();
		FArrayList objEmsList = (FArrayList) objEms;
		for (Object obj : objEmsList) {
			EmsPathgyItemDO pathgydo = (EmsPathgyItemDO) obj;
			if (pathgydo == null)
				continue;

			if (StringUtils.isNullOrEmpty(pathgydo.getId_samptp())) {
				errorList.append(String.format("%s标本类型为空！", pathgydo.getName_srv()));
			}
			if (StringUtils.isNullOrEmpty(pathgydo.getId_di())) {
				errorList.append(String.format("%s临床诊断为空！", pathgydo.getName_srv()));
			}
			if (StringUtils.isNullOrEmpty(pathgydo.getId_mp_dep())) {
				errorList.append(String.format("%s执行科室为空！", pathgydo.getName_srv()));
			}

			FArrayList samplist = pathgydo.getEmsItemInpathgyList();

			if (samplist == null || samplist.size() <= 0) {
				errorList.append("无标本信息，请重新检查！");
				continue;
			}

			//标本信息校验
			checkSampInfo(samplist, errorList);
		}
		return null;
	}

	public ErrorEmsList beforeSaveValidate(Object objEms) throws BizException {
		return null;
	}

	/**
	 * 校验病理标本信息
	 * @param samplist
	 * @param errorList
	 */
	private void checkSampInfo(FArrayList samplist, FArrayList errorList) {
		for (Object obj : samplist) {
			EmsItemInPathgy sampDO = (EmsItemInPathgy) obj;
			if (sampDO.getSortno() == null || StringUtils.isNullOrEmpty(sampDO.getSortno().toString())) {
				errorList.append("标本序号不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getName_labsamp())) {
				errorList.append("标本名称不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getBody_coll())) {
				errorList.append("标本采集部位不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getFixative())) {
				errorList.append("标本固定液不完整，请重新检查！");
			}
			if (sampDO.getQuan_coll() <= 0) {
				errorList.append("标本数量不能为零，请重新检查！");
			}
		}
	}
}
