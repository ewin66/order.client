package iih.ci.ord.s.bp.ordverify;

import iih.ci.ord.dto.orderverify.d.OrderVerifyDTO;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 通过医嘱id取得医嘱相关信息
 * @author ly
 *
 */
public class GetOrderByIdsBP {

	private static final String SPLIT_STR = ",";
	
	public OrderVerifyDTO[] exec(String orIds) throws BizException{
		
		if(StringUtil.isEmpty(orIds))
			return null;
		
		String[] ids = orIds.split(SPLIT_STR);
		String inWhereSql = "(";
		for (String str : ids) {
			inWhereSql += "'" + str + "',";
		}
		
		inWhereSql = inWhereSql.substring(0, inWhereSql.length() - 1);
		inWhereSql += ")";
		
		String sql = this.getBaseSql();
		sql += "where ord.id_or in " + inWhereSql;
		sql += " order by ord.dt_entry desc ";
		
		@SuppressWarnings("unchecked")
		List<OrderVerifyDTO> result = (List<OrderVerifyDTO>) new DAFacade()
				.execQuery(sql, null, new BeanListHandler(OrderVerifyDTO.class));
		
		if(ListUtil.isEmpty(result)){
			return null;
		}
		
		return result.toArray(new OrderVerifyDTO[result.size()]);
	}
	
	/**
	 * 医嘱数据基本sql
	 * @return
	 */
	private String getBaseSql(){
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select ord.id_or,");
		sqlSb.append("ord.code_or,");
		sqlSb.append("ord.content_or,");
		sqlSb.append("ord.dt_effe,");
		sqlSb.append("ord.dt_invalid,");
		sqlSb.append("ord.fg_long,");
		sqlSb.append("ord.fg_bb,");
		sqlSb.append("ord.eu_verify_pharm,");
		sqlSb.append("ord.des_verify_pharm,");
		sqlSb.append("ord.id_ecep_level_pharm,");
		sqlSb.append("ord.sd_excep_level_pharm,");
		sqlSb.append("doc1.name as name_excep_level_pharm,");
		sqlSb.append("ord.des_verify_sys,");
		sqlSb.append("ord.id_ecep_level_sys,");
		sqlSb.append("ord.sd_excep_level_sys,");
		sqlSb.append("doc2.name as name_excep_level_sys,");
		sqlSb.append("ord.id_emp_verify_pharm,");
		sqlSb.append("psn.name as name_emp_verify_pharm,");
		sqlSb.append("dt_verify_pharm ");
		sqlSb.append("from ci_order ord ");
		sqlSb.append("left join bd_psndoc psn ");
		sqlSb.append("on ord.id_emp_verify_pharm = psn.id_psndoc ");
		sqlSb.append("left join bd_udidoc doc1 ");
		sqlSb.append("on ord.id_ecep_level_pharm = doc1.id_udidoc ");
		sqlSb.append("left join bd_udidoc doc2 ");
		sqlSb.append("on ord.id_ecep_level_sys = doc2.id_udidoc ");
		
		return sqlSb.toString();
	}
}
