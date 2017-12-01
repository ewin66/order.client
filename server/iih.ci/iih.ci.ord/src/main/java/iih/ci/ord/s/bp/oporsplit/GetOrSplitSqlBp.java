package iih.ci.ord.s.bp.oporsplit;

import iih.ci.ord.dto.oporsplit.d.OpOrSplitParamDTO;
import iih.ci.ord.dto.oporsplit.d.OpOrderSplitDTO;
import iih.ci.ord.s.bp.oporsplit.help.OpSplitUtils;
import iih.ci.ord.s.bp.oporsplit.help.StrProcesUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;

/**
 * 门急诊医嘱拆分查询逻辑
 * 
 * @author xuxing 2016-09-28
 *
 */
public class GetOrSplitSqlBp {

	/**
	 * 主入口
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public BaseDTO[] exec(OpOrSplitParamDTO param) throws BizException {

		// 1、参数校验
		validation(param);

		// 2、查询数据
		OpOrderSplitDTO[] rtn = queryData(param);

		return rtn;
	}

	/**
	 * 参数校验
	 * 
	 * @param param
	 * @throws BizException
	 */
	private void validation(OpOrSplitParamDTO param) throws BizException {

		if (param == null) {

			throw new BizException("门急诊医嘱拆分：拆分参数为空异常！");
		}

		if (param.getDt_split() == null) {

			throw new BizException("门急诊医嘱拆分：拆分触发时间为空异常！");
		}

	}

	/**
	 * 查询数据
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OpOrderSplitDTO[] queryData(OpOrSplitParamDTO param) throws BizException {

		String SqlStr = getSqlStr() + getConditionStr(param);

		OpOrderSplitDTO[] rtn = (OpOrderSplitDTO[]) OrSrvSplitUtil.getDORstWithDao(SqlStr, OpOrderSplitDTO.class);

		return rtn;
	}

	/**
	 * 获取基础Sql串
	 * 
	 * @return
	 */
	private String getSqlStr() {

		StringBuffer SqlStr = new StringBuffer();

		SqlStr.append(" select ");
		SqlStr.append(OpSplitUtils.OPORSPLIT_EN_SQL + ",");
		SqlStr.append(OpSplitUtils.OPORSPLIT_OR_SQL + ",");
		SqlStr.append(OpSplitUtils.OPORSPLIT_BASE_SQL);
		SqlStr.append(" from ");
		SqlStr.append(OpSplitUtils.OPORSPLIT_FROM_SQL);
		SqlStr.append(" where ");
		SqlStr.append(OpSplitUtils.OPORSPLIT_WHERE_SQL);

		return SqlStr.toString();
	}

	/**
	 * 根据拆分参数获取条件
	 * 
	 * @param param
	 * @return
	 */
	private String getConditionStr(OpOrSplitParamDTO param) {

		StringBuffer whereStr = new StringBuffer();

		// 就诊
		String whereEnt = StrProcesUtils.getWhereStr(param.getId_ens());
		if (!StringUtil.isEmptyWithTrim(whereEnt)) {
			whereStr.append(" and ci_order.id_en " + whereEnt);
		}

		// 医嘱
		String whereOr = StrProcesUtils.getWhereStr(param.getId_ors());
		if (!StringUtil.isEmptyWithTrim(param.getId_ors())) {
			whereStr.append(" and ci_order.id_or " + whereOr);
		}

		// 服务类型
		String whereSrvtp = StrProcesUtils.getWhereStr(param.getSd_srvtps());
		if (!StringUtil.isEmptyWithTrim(param.getSd_srvtps())) {
			whereStr.append(" and ci_order.sd_srvtp " + whereSrvtp);
		}

		// 给药途径
		String whereRoute = StrProcesUtils.getWhereStr(param.getId_routes());
		if (!StringUtil.isEmptyWithTrim(param.getId_routes())) {
			whereStr.append(" and ci_order.id_route " + whereRoute);
		}

		// 执行科室
		String whereDep = StrProcesUtils.getWhereStr(param.getId_dep_mp());
		if (!StringUtil.isEmptyWithTrim(param.getId_dep_mp())) {
			whereStr.append(" and ci_order.id_dep_mp " + whereDep);
		}

		// 拆分截止时间
		whereStr.append(" and ci_order.dt_end <='" + param.getDt_split() + "'");

		return whereStr.toString();
	}

}
