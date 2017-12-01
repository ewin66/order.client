package iih.ci.ord.pub;

public interface ICiOrValidateConst {
	/**
	 * 获得医嘱项目中所有医疗服务的SQL串片段（传入参数为医嘱id串）
	 */
	public static final String GET_ORSRV_IDS_SQLSTR=" in (select distinct id_srv from ci_or_srv where id_or in (%s))";

	/**
	 * 获得医嘱项目中所有医疗服务的SQL串片段（传入参数为医嘱id串）
	 */
	public static final String GET_ORSRV_ID_SQLSTR=" in (select distinct id_srv from ci_or_srv where id_or=%s)";
	
	/**
	 * 组内排斥医嘱签署时，获得有效的组内排斥医嘱SQL串（停止该医嘱时使用）,不包含出院带药医嘱
	 */
	public static final String GET_ORIDS_4VALIDGRPIN_SQLSTR="select distinct A.Id_Or from ci_order A "
              			+" inner join ci_or_srv B ON A.id_or=B.Id_Or and A.fg_pres_outp='N'"
              			+" where A.Id_En='%1$s' and ((A.Fg_Sign='Y' and A.Fg_Chk='N') or (A.Fg_Chk='Y' and A.Fg_Canc='N'))   "
              			+"       and A.Fg_Long='Y' and A.Dt_Effe<='%2$s' and A.Dt_End>='%3$s'  "
              			+"       and B.Id_Srv in (select id_srv from bd_srv_react_itm where id_srvreact in (%4$s))";

}
