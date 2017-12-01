package iih.ci.ord.s.bp.oporsplit.help;

public interface OpSplitUtils {
	
	/**
	 * 患者就诊
	 */
	public static final String OPORSPLIT_EN_SQL = " en_ent.id_org," 
												+ " en_ent.id_pat," 
												+ " en_ent.code_entp as sd_entp," 
												+ " ci_order.id_en ";
	
	/**
	 * 医嘱
	 */
	public static final String OPORSPLIT_OR_SQL = " ci_order.id_or,"
												+" ci_order.fg_long,"
												+" ci_order.fg_boil,"
												+" ci_order.id_boil,"
												+" ci_order.orders as quan_or,"
												+" ci_order.orders_boil,"
												+" ci_order.fg_skintest,"
												+" ci_order.sd_su_or as sd_su,"
												+" ci_order.dt_effe,"
												+" ci_order.dt_end,"
												+" ci_order.days_or,"
												+" ci_order.times_mp_in ";
	
	/**
	 * 公用信息
	 */
	public static final String OPORSPLIT_BASE_SQL = " ci_order.id_srvtp,"
												+ "ci_order.sd_srvtp,"
												+" ci_order.id_route,"
												+" ci_order.id_routedes,"
												+" ci_order.id_org_or as id_org_create,"
												+" ci_order.id_dep_or as id_dep_create,"
												+" ci_order.id_emp_or as id_emp_create,"
												+" ci_order.id_freq,"
												+" bd_freq.sd_frequnitct as sd_frequnit,"
												+" bd_freq.frequnitct as frequnitcnt,"
												+" bd_freq.freqct,"
												+" ci_order.dt_entry as dt_create,"
												+" '' as dt_mp_plan ";
	/**
	 * From
	 */
	public static final String OPORSPLIT_FROM_SQL=" ci_order ci_order "
												+" left join en_ent en_ent on ci_order.id_en=en_ent.id_ent "
												+" left join bd_freq bd_freq on ci_order.id_freq=bd_freq.id_freq ";
	
	/**
	 * 基础Where条件
	 */
	public static final String OPORSPLIT_WHERE_SQL=" ci_order.fg_mp_in ='Y'"
												+" and ci_order.code_entp in('00','01') "
												+" and ci_order.fg_sign='Y' "
												+" and ci_order.fg_pmor='N' "
												+" and ci_order.dt_last_bl>=ci_order.dt_effe "
												+" and ci_order.dt_last_bl<=ci_order.dt_end ";
}
