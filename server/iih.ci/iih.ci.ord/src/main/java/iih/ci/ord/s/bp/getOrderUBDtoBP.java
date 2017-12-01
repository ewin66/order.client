package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.d.CiordubDTO;
import iih.en.que.dto.d.TriageQueSiteDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class getOrderUBDtoBP {
	
	/**
	 * 用血申请单
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	public  CiordubDTO execub(String id_or)  throws BizException{
		
		StringBuilder builder = new StringBuilder();
		builder.append("Select mea.NAME name_unit, srv.quan_medu, CI_RPT_BTTEST.num_bt,CI_AP_BT.num_margin_bu, CI_AP_BT.no_applyform applyform,  cv.name orsrvname, cv.quan_medu quan_medu_ub, cv.ID_MEDU id_unit, cu.DT_BU_PLAN dt_bu_pl_ub, ");
		builder.append("c.id_route, c.ID_EMP_OR id_emp_create, c.des_or, cu.no_applyform no_applyform_ub, c.DT_ENTRY dt_create,  ");
		builder.append("c.id_or_rel id_or From CI_ORDER c inner join CI_OR_SRV cv on c.id_or = cv.id_or inner join CI_AP_BU cu on c.id_or = cu.id_or   ");
		builder.append(" Left outer join bd_measdoc mea on mea.ID_MEASDOC = cv.ID_MEDU   ");
		builder.append("  inner join CI_AP_BT on CI_AP_BT.id_or = c.id_or_rel  ");
		builder.append("   left join CI_RPT_BTTEST on CI_RPT_BTTEST.id_or =  c.id_or_rel ");
		builder.append(" inner join ci_or_SRV srv on srv.id_or =c.id_or_rel and srv.sd_srvtp='"+IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE+"'");
		builder.append("Where c.id_or =? And cv. id_srv = c. id_srv ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_or);
		CiordubDTO result = (CiordubDTO) new DAFacade()
				.execQuery(sql, param, new BeanHandler(
						CiordubDTO.class));
		
	    return result;
	
	}
	/**
	 * 备血申请列表
	 * @param 
	 * @return
	 * @throws BizException
	 */
	public  CiordubDTO[] execpbt(String id_ent)  throws BizException{
		
		StringBuilder builder = new StringBuilder();
		builder.append("Select mea.name name_unit, cior.id_or,CI_AP_BT.no_applyform applyform,cior.id_srv,");
		builder.append(" srv.name orsrvname,srv.quan_medu,srv.ID_MEDU id_unit, ");
		builder.append(" CI_RPT_BTTEST.num_bt,CI_AP_BT.dt_bt_pl,cior.id_emp_sign,");
		builder.append(" CI_AP_BT.num_margin_bu,psn.name as Name_emp_sign  From ci_order cior  ");
		builder.append(" Left join ci_or_SRV srv on  srv.id_or = cior.id_or ");
		builder.append(" Left join CI_AP_BT   on  CI_AP_BT.id_or = cior.id_or ");
		builder.append(" Left join CI_RPT_BTTEST on  CI_RPT_BTTEST.id_or = cior.id_or");
		builder.append(" Left join bd_measdoc mea on  mea.ID_MEASDOC = srv.ID_MEDU ");
		builder.append(" Left join bd_psndoc psn on cior.id_emp_or=psn.id_psndoc");
		builder.append(" Where cior.id_en =? ");
		builder.append(" And srv.sd_srvtp = '140101' ");
		builder.append(" And cior.FG_SIGN = 'Y'  ");
		builder.append(" And cior.fg_canc ='N' ");
		builder.append(" And CI_AP_BT.num_margin_bu >0");
//		builder.append(" And srv.id_srv = cior.id_srv");
		builder.append(" Order by CI_AP_BT.dt_bt_pl");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		List<CiordubDTO> result = (List<CiordubDTO> ) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(
						CiordubDTO.class));
		if(!ListUtil.isEmpty(result)){
			return result.toArray(new CiordubDTO[0]);
		}
	    return null;
	    
	    
	    
	
	}

}
