package iih.ci.ord.s.bp.assi.impl.cimes.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.s.bp.assi.impl.cimes.base.BaseCalCiEmsProperty;
import iih.ci.ord.s.bp.emscalculate.total.CalTimesCurBP;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class OpBaseCopyCalCiEmsProperty extends BaseCalCiEmsProperty {

	
	@Override
	protected void setCalTimesCur(CiEmsDTO ciEms) throws BizException {

		ciEms.setTimes_cur(1);
		CalTimesCurBP bp = new CalTimesCurBP();
		int times_cur = bp.exec(ciEms);
		ciEms.setTimes_cur(times_cur);
	}
	
	@Override
	protected void setFgMpIn(CiEmsDTO ciEms) throws BizException {

		FBoolean fgMpIn = FBoolean.TRUE;

		List<String> idRouteList = this.getUsageScope();
		// 西城药品的fg_mp_in 判断逻辑，判断用法id 是否在轻量级中 CIOR0115 是否配置，如果配置返回在院执行标识为True
		if (ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)
				|| ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)) {

			// 在轻量级中 CIOR0115 配置用法内，为在院执行
			if (idRouteList.contains(ciEms.getId_route())) {
				fgMpIn = FBoolean.TRUE;
			} else {
				fgMpIn = FBoolean.FALSE;
			}
		} else if (ciEms.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) { // 草药时在院执行标识为false
			fgMpIn = FBoolean.FALSE;
		}

		ciEms.setFg_mp_in(fgMpIn);
	}

	/**
	 * 获取药品可成组使用用法范围
	 * 
	 * 注：在该范围内的用法对应的在院执行标记为true
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<String> getUsageScope() throws BizException {

		if (StringUtils.isBlank(envinfo.getId_dep_en())) {
			throw new BizException("当前环境参数中就诊科室为空！");
		}
		
		List<String> usageScopeList =new ArrayList<String>();
		
		String orgId = CiOrdAppUtils.getEnvContext().getOrgId();
		//药品可成组使用用法范围设置
		String usageScope = ParamsetQryUtil.getParaString(orgId,
				ICiOrdNSysParamConst.SYS_PARAM_CiPharmGrpableUsageScope);
		
		if (StringUtils.isNotBlank(usageScope)) {
			usageScopeList.addAll(Arrays.asList(usageScope.split(",")));
		}
		
		return usageScopeList;

	}

}
