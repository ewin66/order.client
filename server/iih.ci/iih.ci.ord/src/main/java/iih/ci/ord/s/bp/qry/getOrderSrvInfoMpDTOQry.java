/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getOrderSrvInfoMpDTOQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年5月25日 下午5:23:56
 * @Package iih.ci.ord.s.bp.qry Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class getOrderSrvInfoMpDTOQry implements ITransQry {

	public String[] _id_ors;

	public getOrderSrvInfoMpDTOQry(String[] id_ors) {
		this._id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();

		if (_id_ors != null && _id_ors.length > 0) {

			for (String id_or : _id_ors) {
				param.addParam(id_or);
			}
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}

	private String getSql() {

		StringBuffer sql = new StringBuffer();
		sql.append(" select   ");
		sql.append(" ci_or_srv.id_or,  ");
		sql.append(" ci_or_srv.name srv_name,  ");
		sql.append(" ( ");
		sql.append("   case when ci_or_srv.fg_self='Y' then concat(ci_or_srv.name,'(自备)') ");
		sql.append("   else bd_mm.name end ");
		sql.append(" )drug_name,  ");
		sql.append(" bd_mm.spec,  ");
		sql.append(" ci_or_srv.quan_medu,  ");
		sql.append(" bd_measdoc.name  quan_medu_name, ");
		sql.append(" bd_route.name route_name, ");
		sql.append(" bd_freq.name  freq_name   ");
		sql.append(" from  ci_or_srv   ci_or_srv   ");
		sql.append(" left outer join ci_or_srv_mm  ci_or_srv_mm on ci_or_srv_mm.id_orsrv = ci_or_srv.id_orsrv ");
		sql.append(" left outer join bd_mm bd_mm on bd_mm.id_mm = ci_or_srv_mm.id_mm   ");
		sql.append(" left outer join bd_route bd_route  on bd_route.id_route = ci_or_srv.id_route   ");
		sql.append(" left outer join bd_measdoc bd_measdoc on bd_measdoc.id_measdoc = ci_or_srv.id_medu  ");
		sql.append(" left outer join bd_freq bd_freq on bd_freq.id_freq = ci_or_srv.id_freq   ");
		sql.append(" where ci_or_srv.fg_or ='Y'   ");

		if (_id_ors != null && _id_ors.length > 0) {

			String whereInStr = "";

			for (int i = 0; i < _id_ors.length; i++) {

				whereInStr += (whereInStr.length() == 0 ? "" : ",") + "?";
			}

			sql.append(" and ci_or_srv.id_or in ( " + whereInStr + ")");

		} else {

			sql.append(" and 1=2 ");
		}

		sql.append(" ORDER BY ci_or_srv.sortno ASC ");

		return sql.toString();
	}
}
