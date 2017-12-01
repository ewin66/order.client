package iih.ci.ord.s.ems.biz.op.ems.pathgy;

import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import iih.ci.ord.ciordems.d.EmsItemInPathgy;
import iih.ci.ord.ciordems.d.EmsPathgyItemDO;
import iih.ci.ord.d.ems.tmpl.ErrorEmsDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.s.ems.biz.meta.ErrorEmsList;
import iih.ci.ord.s.ems.biz.op.base.action.EmsBaseValidate;

/**
 * 病理医疗单有效性检查
 * 
 * @author wangqingzhu
 *
 */
public class EmsPathgyValidate extends EmsBaseValidate {
	@Override
	public ErrorEmsList viewModelValidate(Object[] objEms, CiEnContextDTO ctx) throws BizException {
		ErrorEmsList eeList = new ErrorEmsList();
		
		for (Object obj : objEms) {
			List<String> errorList = new ArrayList<String>();
			EmsPathgyItemDO pathgydo = (EmsPathgyItemDO) obj;

			if (StringUtils.isNullOrEmpty(pathgydo.getId_samptp())) {
				errorList.add(String.format("%s标本类型为空！", pathgydo.getName_srv()));
			}
			if (StringUtils.isNullOrEmpty(pathgydo.getId_di())) {
				errorList.add(String.format("%s临床诊断为空！", pathgydo.getName_srv()));
			}
			if (StringUtils.isNullOrEmpty(pathgydo.getId_mp_dep())) {
				errorList.add(String.format("%s执行科室为空！", pathgydo.getName_srv()));
			}

			FArrayList samplist = pathgydo.getEmsItemInpathgyList();

			if (samplist == null || samplist.size() <= 0) {
				errorList.add("无标本信息，请重新检查！");
				continue;
			}

			//标本信息校验
			checkSampInfo(samplist, errorList);
			
			//
			if (errorList.size() > 0){
				eeList.add(new ErrorEmsDTO(ctx,obj,errorList));
			}
		}
		return eeList;
	}

	@Override
	public ErrorEmsList beforeSaveValidate(Object[] szOrderPackage) throws BizException {
		return null;
	}

	/**
	 * 校验病理标本信息
	 * @param samplist
	 * @param errorList
	 */
	private void checkSampInfo(FArrayList samplist, List<String> errorList) {
		for (Object obj : samplist) {
			EmsItemInPathgy sampDO = (EmsItemInPathgy) obj;
			if (sampDO.getSortno() == null || StringUtils.isNullOrEmpty(sampDO.getSortno().toString())) {
				errorList.add("标本序号不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getName_labsamp())) {
				errorList.add("标本名称不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getBody_coll())) {
				errorList.add("标本采集部位不完整，请重新检查！");
			}

			if (StringUtils.isNullOrEmpty(sampDO.getFixative())) {
				errorList.add("标本固定液不完整，请重新检查！");
			}
			if (sampDO.getQuan_coll() <= 0) {
				errorList.add("标本数量不能为零，请重新检查！");
			}
		}
	}
}
