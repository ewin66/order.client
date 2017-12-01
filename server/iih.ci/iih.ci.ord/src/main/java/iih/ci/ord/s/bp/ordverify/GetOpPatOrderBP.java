package iih.ci.ord.s.bp.ordverify;

import iih.ci.ord.dto.orderverify.d.OrderVerifyCondDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyPatDTO;
import iih.ci.ord.dto.orderverify.d.OrderVerifyStateEnum;
import iih.ci.ord.i.ICiOrdVerifyService;
import iih.pi.reg.i.IPiRegQryService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 门诊查询患者医嘱
 * @author ly
 *
 */
public class GetOpPatOrderBP {
	

	@SuppressWarnings("unchecked")
	public OrderVerifyPatDTO[] exec(OrderVerifyCondDTO cond) throws BizException{
		
		//模糊查询患者
		IPiRegQryService piRegQryService = ServiceFinder.find(IPiRegQryService.class);
		//String[] patIds = piRegQryService.getPatIdBySpecialCondFuzzy(cond.getPat_cond_type(), cond.getPat_cond_value());
		
		String subSql = piRegQryService.getPatIdBySpecialCondFuzzySql(cond.getPat_cond_type(), cond.getPat_cond_value());
		
		StringBuilder sqlSb = new StringBuilder(this.getBaseSql());
		SqlParam sqlParam = new SqlParam();
		
		/*if(!ArrayUtil.isEmpty(patIds)){
			String inSql = this.getInSql(patIds);
			sqlSb.append("and ci_order.id_pat in " + inSql + " ");
		}*/
		
		if(!StringUtil.isEmpty(subSql)){
			sqlSb.append("and ci_order.id_pat in (" + subSql + ") ");
		}
		
		if(!StringUtil.isEmpty(cond.getVerify_state())){
			sqlSb.append(this.getEuVerifySql(cond.getVerify_state()));
		}
		
		if(cond.getDt_begin() != null){
			sqlSb.append("and ci_order.dt_verify_pharm >= ? ");
			sqlParam.addParam(cond.getDt_begin());
		}
		
		if(FBoolean.TRUE.equals(cond.getFg_op())){
			sqlSb.append("and ci_order.code_entp in ('00','01') ");
		}else{
			sqlSb.append("and ci_order.code_entp = '10' ");
			sqlSb.append("and ci_order.fg_chk = 'Y' ");
		}
		
		//执行科室条件
		//sqlSb.append(this.getDeptMpSql()); 去掉执行科室条件
		//sqlParam.addParam(Context.get().getDeptId());
		
		//费用条件
		sqlSb.append(this.getBlCondSql());
		
		//数据权限条件
		String datapreSql = this.getDataperSql();
		if(!StringUtil.isEmpty(datapreSql)){
			sqlSb.append(String.format(" %s ", datapreSql));
		}
		
		sqlSb.append(this.getOrderPart());
		
		List<OrderVerifyPatDTO> result = (List<OrderVerifyPatDTO>) new DAFacade().
				execQuery(sqlSb.toString(), sqlParam, new BeanListHandler(OrderVerifyPatDTO.class));

		if(ListUtil.isEmpty(result))
			return null;
		
		//合并结果集  ,按照患者，审核状态合并...就诊id暂时只保留一个
		Map<String,OrderVerifyPatDTO> totalMap = new HashMap<String,OrderVerifyPatDTO>();
		for (OrderVerifyPatDTO item : result) {
			
			//审核状态是驳回合并到已审核
			if(item.getEu_verify_pharm() == 2){
				item.setEu_verify_pharm(1);
			}
			String key = item.getId_pat() + item.getId_dep() + item.getEu_verify_pharm();
			if(totalMap.containsKey(key)){
				OrderVerifyPatDTO patDto = totalMap.get(key);
				patDto.setOrd_num(patDto.getOrd_num() + 1);
				patDto.setId_or(patDto.getId_or() + "," + item.getId_or());//拼接id_or
				
			}else{
				totalMap.put(key, item);
			}
		}
		
		OrderVerifyPatDTO[] pats = totalMap.values().toArray(new OrderVerifyPatDTO[totalMap.size()]);
		
		Arrays.sort(pats, new Comparator<OrderVerifyPatDTO>(){
			@Override
			public int compare(OrderVerifyPatDTO o1, OrderVerifyPatDTO o2) {
				if(o2.getMax_dt_entry() == null && o1.getMax_dt_entry() == null)
					return 0;
				else if(o2.getMax_dt_entry() != null && o1.getMax_dt_entry() == null)
					return 1;
				else if(o2.getMax_dt_entry() == null && o1.getMax_dt_entry() != null)
					return -1;
				else
					return o2.getMax_dt_entry().compareTo(o1.getMax_dt_entry());
			}});
		
		return pats;
		
	}
	
	/**
	 * 基础sql
	 * @return
	 */
	private String getBaseSql(){
		
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select pat.id_pat, ");
		sqlSb.append("ci_order.id_dep_or as id_dep, ");
		sqlSb.append("ci_order.id_dep_chk, ");
		sqlSb.append("ci_order.id_or, ");
		sqlSb.append("ci_order.id_en, ");
		sqlSb.append("ci_order.dt_entry as max_dt_entry, ");
		sqlSb.append("pat.code as code_pat, ");
		sqlSb.append("pat.name as name_pat, ");
		sqlSb.append("dep.name as name_dep, ");
		sqlSb.append("dep2.name as name_dep_chk, ");
		sqlSb.append("1 ord_num, ");
		sqlSb.append("ci_order.eu_verify_pharm ");
		sqlSb.append("from ci_order ci_order ");
		sqlSb.append("inner join pi_pat pat ");
		sqlSb.append("on ci_order.id_pat = pat.id_pat ");
		sqlSb.append("left join bd_dep dep ");
		sqlSb.append("on ci_order.id_dep_or = dep.id_dep ");
		sqlSb.append("left join bd_dep dep2 ");
		sqlSb.append("on ci_order.id_dep_chk = dep2.id_dep ");
		sqlSb.append("where ci_order.ds = 0 ");
		sqlSb.append("and (ci_order.sd_su_or = '10' or ci_order.sd_su_or = '20') ");
		//sqlSb.append("and ord.fg_stop = 'N' ");
		//sqlSb.append("and ord.fg_canc = 'N' ");
		sqlSb.append("and ci_order.fg_sign = 'Y' ");
		sqlSb.append("and substr(ci_order.sd_srvtp,1,2) = '01' ");
		
		return sqlSb.toString();
	}
	
	/**
	 * 执行科室条件
	 * @return
	 */
	private String getDeptMpSql(){
		
		String str = "and exists (select 1 from ci_or_srv orsrv "
				+ "where orsrv.id_or = ci_order.id_or "
				+ "and orsrv.id_dep_mp = ? ) ";
				
		return str;
	}
	
	/**
	 * 收费条件
	 * @return
	 */
	private String getBlCondSql(){
		String str = " and exists (select 1 from ci_or_srv orsrv "
				+ "where orsrv.id_or = ci_order.id_or "
				+ "and orsrv.sd_su_bl <> '2' ) ";
				
		return str;
	}
	
	/**
	 * 获取数据权限条件
	 * @return
	 */
	private String getDataperSql() throws BizException{
		
		//取得对应数据权限
		String whereSql = new GetDataperBP().exec();
		
		if(StringUtil.isEmpty(whereSql)){
			throw new BizException("该用户和用户对应角色没有审核权限，请在配置数据权限后重试。");
		}
		
		return  "and (" + whereSql + ")";
	}
	
	/**
	 * 排序部分
	 * @return
	 */
	private String getOrderPart(){
		StringBuilder sqlSb = new StringBuilder();
		//医嘱开立时间
		sqlSb.append("order by ci_order.dt_entry desc ");
		return sqlSb.toString();
	}
	
	/**
	 * 审核状态条件
	 * @param verifyState
	 * @return
	 */
	private String getEuVerifySql(String verifyState){
		
		String sql = "and ci_order.eu_verify_pharm in (%s) ";
		String s = "";
		if(ICiOrdVerifyService.VERIFY_STATE_NOT.equals(verifyState)){
			s = OrderVerifyStateEnum.NOTVERIFY + "";
		}else if(ICiOrdVerifyService.VERIFY_STATE_HAS.equals(verifyState)){
			s = OrderVerifyStateEnum.PASS + "," + OrderVerifyStateEnum.REJECT;
		}else{
			s = OrderVerifyStateEnum.FORCE + "";
		}
		
		return String.format(sql, s);
	}

	/**
	 * 取得in条件串
	 * @param patIds
	 * @return
	 */
	private String getInSql(String[] patIds){
		
		String inSql = "(";
		
		for (String str : patIds) {
			
			inSql += "'" + str + "',";
		}
		
		inSql = inSql.substring(0, inSql.length() - 1);
		inSql += ")";
				
	    return inSql;
	}
}
