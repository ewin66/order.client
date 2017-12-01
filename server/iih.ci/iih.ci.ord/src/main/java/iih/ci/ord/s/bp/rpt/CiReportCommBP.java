package iih.ci.ord.s.bp.rpt;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;

import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

public class CiReportCommBP {
	/**
	 * 根据医嘱ID获取就诊相关信息。
	 */
	public static Map<String,Object> findEntInfoByOrId(String orId) throws BizException {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select t0.id_srv, t1.id_ent, t1.name_pat, t1.code as ent_code ");
		sqlSb.append("from ci_order t0 ");
		sqlSb.append("  left join en_ent t1 on t0.id_en=t1.id_ent ");
		sqlSb.append("where ");
		sqlSb.append("  t0.ds=0 ");
		sqlSb.append("  and t0.fg_canc='N' ");		
		sqlSb.append("  and t0.id_or='" + orId + "' ");
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	/**
	 * 根据医嘱ID获取医嘱相关信息。(因为医嘱的模型还不稳定，暂时通过该方法实现)
	 */
	public static Map<String,Object> findCiOrderInfoByOrId(String orId) throws BizException {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select t0.code_or as code, t0.name_or as name, t0.fg_set,t0.id_srv ");
		sqlSb.append("from ci_order t0 ");
		sqlSb.append("where ");
		sqlSb.append("  t0.ds=0 ");
		sqlSb.append("  and t0.fg_canc='N' ");		
		sqlSb.append("  and t0.id_or='" + orId + "' ");
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	
	public static Map<String,Object> findCiOrSrvInfoByOrId(String orId, String srvId) throws BizException {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select t0.name as name_bt, to_char(quan_medu) as quan_medu, id_medu, BD_MEASDOC.name medu_name ");
		sqlSb.append("from ci_or_srv t0 ");
		sqlSb.append(" left outer join BD_MEASDOC on t0.id_medu = BD_MEASDOC.Id_Measdoc ");
		sqlSb.append("where ");
		sqlSb.append("  t0.ds=0 ");
		sqlSb.append("  and t0.id_or='" + orId + "' ");		
		sqlSb.append("  and t0.id_srv='" + srvId + "' ");
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}
	
	/**
	 * 查询备血用血量
	 * @param orId
	 * @param srvId
	 * @return
	 * @throws BizException
	 */
	public static Map<String,Object> findQuanInfoByOrId(String orId) throws BizException {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select t0.name as name_bt, to_char( (select sum(quan_medu) from ci_or_srv where ds = 0 and id_or = '" + orId + "' and sd_srvtp ='" + IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE + "' )) as quan_medu, id_medu, BD_MEASDOC.name medu_name ");
		sqlSb.append("from ci_or_srv t0 ");
		sqlSb.append(" left outer join BD_MEASDOC on t0.id_medu = BD_MEASDOC.Id_Measdoc ");
		sqlSb.append("where ");
		sqlSb.append("  t0.ds=0 ");
		sqlSb.append("  and t0.id_or='" + orId + "' ");		
		sqlSb.append("  and t0.sd_srvtp='" + IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE + "' ");
		
		@SuppressWarnings("unchecked")
		List<Map<String, Object>> result = (List<Map<String, Object>>) new DAFacade()
				.execQuery(sqlSb.toString(), new MapListHandler());
		
		if (result != null && result.size() > 0) {
			return result.get(0);
		}
		return null;
	}	
}
