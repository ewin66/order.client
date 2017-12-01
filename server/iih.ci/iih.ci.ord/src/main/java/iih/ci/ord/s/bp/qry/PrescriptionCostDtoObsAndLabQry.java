/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: PrescriptionCostDtoObsAndLabQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年4月29日 下午3:29:30
 * @Package iih.ci.ord.s.bp.qry Copyright: Copyright (c) 2011 Company:
 *          北大医疗信息技术有限责任公司
 */
public class PrescriptionCostDtoObsAndLabQry implements ITransQry {

	private String patid;
	private FDateTime dtSignB;
	private FDateTime dtSignE;
	private String code_entp;
	private String id_org;

	public PrescriptionCostDtoObsAndLabQry(String patid, FDateTime dtSignB, FDateTime dtSignE, String code_entp, String Id_org) {
		this.patid = patid;
		this.dtSignB = dtSignB;
		this.dtSignE = dtSignE;
		this.code_entp = code_entp;
		this.id_org = Id_org;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam rtnParam = new SqlParam();
		// 检查
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if (dtSignB != null) {
			rtnParam.addParam(dtSignB);
		}
		if (dtSignE != null) {
			rtnParam.addParam(dtSignE);
		}
		// 检验
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if (dtSignB != null) {
			rtnParam.addParam(dtSignB);
		}
		if (dtSignE != null) {
			rtnParam.addParam(dtSignE);
		}
		// 诊疗
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if (dtSignB != null) {
			rtnParam.addParam(dtSignB);
		}
		if (dtSignE != null) {
			rtnParam.addParam(dtSignE);
		}
		
		// 病理
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if (dtSignB != null) {
			rtnParam.addParam(dtSignB);
		}
		if (dtSignE != null) {
			rtnParam.addParam(dtSignE);
		}

		return rtnParam;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		/*public static final String DRUG_TYPE = "01";  //01 药品
		public static final String RIS_TYPE = "02";//02 检查
		public static final String LIS_TYPE = "03";//03检验
		public static final String TREATMENT_TYPE = "04";//04 诊疗
		public static final String PATHGY_TYPE = "05";//05 检查
*/		// TODO Auto-generated method stub
		return getSqlObs() + "  union all  	" + getSqlLab() + " union all  " + getSqltreatment() +" union all " +getSqlPathology();
	}

	private String getSqlObs() {
		StringBuffer sql = new StringBuffer();
		// 检查
		sql.append(" select ci_or_srv.id_orsrv,ci_or_srv.fg_selfpay, ");
		sql.append(" ci_or_srv.id_srv, ");
		sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
		sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
		sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
		sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
		sql.append("  bd_srv.name          as name_srv, ");
		sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
		sql.append(" ci_or_srv.id_medu       as id_unit_med,");
		sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
		sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
		sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
		sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
		sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
		sql.append("  DOC.name name_emp_srv,");
		sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
		sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
		sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
		sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
		//sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_order.fg_orhp   fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
		sql.append(" ci_or_srv_mm.quan_bed_medu, ");
		sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
		sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
		sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
		sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
		sql.append(" bd_srv.code          as code_srv, ");
		sql.append(" en_ent.id_pripat     as id_pripat, ");
		sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
		sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
		sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
		sql.append(" ci_or_srv.name as presrption_name, ");
		sql.append(" ci_or_srv.fg_bl,");
		sql.append(" bdudidoc.name  prestp_name, ");
		sql.append(" ci_or_srv.id_dep_wh,  ");
		sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
		sql.append(" dep.name  name_dep_srv, ");
		sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
		sql.append(" depmp.name  name_dep_mp ,");
		sql.append(" ci_or_srv.fg_specill, ");
		sql.append(" ci_or_srv.fg_extdispense, ");
		sql.append(" ci_or_srv.id_srvca, ");
		sql.append("  en_ent_hp.id_hpkind, ");
		sql.append("  ci_app_ris.code_app  presno, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		sql.append("   '02'  Prntype  ");
		sql.append(" from ci_order ci_order  ");
		sql.append(" inner join ci_or_srv ci_or_srv  ");
		sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
		sql.append(" left join ci_app_ris ci_app_ris  ");
		sql.append(" on ci_order.id_or=ci_app_ris.id_or ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append(" left outer join bd_srv bd_srv ");
		sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append(" inner join en_ent en_ent  ");
		sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent  AND en_ent_hp.fg_MAJ='Y'");
		sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
		sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append(" where  en_ent.fg_canc='N' and ci_order.sd_su_or in (");
		sql.append("'");
		sql.append(ICiDictCodeConst.SD_SU_SIGN);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_XECUTING);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_FINISH);
		sql.append("' ");
		sql.append(")");
		sql.append("   and ci_or_srv.sd_su_bl ='0' and ci_or_srv.ds = 0  ");
		sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
		sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '02%' and ci_or_srv.sd_srvtp not like '0207%')");

		// sql.append("      and   p.id_pres ='~' and p.sd_srvtp not like '01%'");
		sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		if (dtSignB != null) {
			sql.append("and ci_order.dt_sign>=?");
		}
		if (dtSignE != null) {
			sql.append(" and ci_order.dt_sign<= ?");
		}
		return sql.toString();
	}
  
	
	private String getSqlPathology() {
		StringBuffer sql = new StringBuffer();
		// 病理
		sql.append(" select ci_or_srv.id_orsrv, ci_or_srv.fg_selfpay, ");
		sql.append(" ci_or_srv.id_srv, ");
		sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
		sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
		sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
		sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
		sql.append("  bd_srv.name          as name_srv, ");
		sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
		sql.append(" ci_or_srv.id_medu       as id_unit_med,");
		sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
		sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
		sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
		sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
		sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
		sql.append("  DOC.name name_emp_srv,");
		sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
		sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
		sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
		sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
		sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
		sql.append(" ci_or_srv_mm.quan_bed_medu, ");
		sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
		sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
		sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
		sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
		sql.append(" bd_srv.code          as code_srv, ");
	
		sql.append(" en_ent.id_pripat     as id_pripat, ");
		sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
		sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
		sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
		sql.append(" ci_or_srv.name as presrption_name, ");
		sql.append(" ci_or_srv.fg_bl,");
		sql.append(" bdudidoc.name  prestp_name, ");
		sql.append(" ci_or_srv.id_dep_wh,  ");
		sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
		sql.append(" dep.name  name_dep_srv, ");
		sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
		sql.append(" depmp.name  name_dep_mp ,");
		sql.append(" ci_or_srv.fg_specill, ");
		sql.append(" ci_or_srv.fg_extdispense, ");
		sql.append(" ci_or_srv.id_srvca, ");
		sql.append("  en_ent_hp.id_hpkind, ");
		sql.append("  ci_app_pathgy.code_app  presno, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		sql.append("   '05'  Prntype  ");
		sql.append(" from ci_order ci_order  ");
		sql.append(" inner join ci_or_srv ci_or_srv  ");
		sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
		sql.append(" left join ci_app_pathgy ci_app_pathgy  ");
		sql.append(" on ci_order.id_or=ci_app_pathgy.id_or ");
		sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append(" left outer join bd_srv bd_srv ");
		sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append(" inner join en_ent en_ent  ");
		sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent ");
		sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
		sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append(" where en_ent.fg_canc='N' and ci_order.sd_su_or in (");
		sql.append("'");
		sql.append(ICiDictCodeConst.SD_SU_SIGN);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_XECUTING);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_FINISH);
		sql.append("' ");
		sql.append(")");
		sql.append("   and ci_or_srv.sd_su_bl ='0' and ci_or_srv.ds = 0  ");
		sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
		sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '0207%')");

		// sql.append("      and   p.id_pres ='~' and p.sd_srvtp not like '01%'");
		sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		if (dtSignB != null) {
			sql.append("and ci_order.dt_sign>=?");
		}
		if (dtSignE != null) {
			sql.append(" and ci_order.dt_sign<= ?");
		}
		return sql.toString();
	}
	
	private String getSql() {
		String sql = new String();
		sql = " select p.id_orsrv, p.id_srv," + " p.id_or,tt.id_or  id_pres, " + " p.id_pat,p.id_entp, " + " p.code_entp,p.id_en, " + " p.sortno,p.id_srvtp, " + " p.sd_srvtp,p.id_srv, "
				+ " s.name          as name_srv, " + " p.quan_total_medu     as quan_med,  " + " p.id_medu       as id_unit_med," + " p.id_route,p.id_routedes, " + " p.id_boil,p.id_boildes, "
				+ " p.id_freq,p.id_org_srv, " + " p.id_dep_srv,p.id_wg_or      as id_wg_srv, " + " p.id_emp_srv,p.id_org_mp, " + " p.id_dep_mp,p.id_su_mp, " + " p.sd_su_mp,p.id_su_bl, "
				+ " p.sd_su_bl,p.dt_last_bl    as dt_bl_last," + " p.fg_mm,p.fg_indic,p.fg_propc, " + " case p.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,q.id_orsrvmm, "
				+ " q.id_mm,q.quan_cur, " + " q.quan_bed_medu, " + " q.id_pgku_cur   as id_unit_cur, " + " q.id_pgku_base  as id_unit_base, " + " q.factor        as factor_cb, "
				+ " q.code_mm,q.id_mmtp,q.code_mm, " + " s.code          as code_srv, " + " t.id_pripat     as id_pripat, " + " q.name_mm,tt.id_org,tt.id_grp, " + " tt.name_or as des,tt.fg_bb, "
				+ " tt.no_bb,tt.dt_sign, " + " p.name as presrption_name, " + " p.fg_bl," + " bdudidoc.name  prestp_name, " + " p.id_dep_wh,  " + " p.id_hp,p.ID_HPSRVTP,p.SD_HPSRVTP ,"
				+ " dep.name  name_dep_srv, " + " tt.applyno  code, tt.sv ci_sv," + " depmp.name  name_dep_mp ," + " p.fg_specill, " + " p.fg_extdispense, " + "  en_ent_hp.id_hpkind "
				+ " from ci_order tt  " + " inner join ci_or_srv p  " + " on tt.id_or=p.id_or " + " left join ci_or_srv_mm q " + " on p.id_orsrv = q.id_orsrv " + " left outer join bd_srv s "
				+ " on s.id_srv = p.id_srv " + " inner join en_ent t  " + " on p.id_en = t.id_ent " + " left outer join en_ent_hp on en_ent_hp.id_ent = t.id_ent "
				+ "  left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =p.id_srvtp " + "   left join bd_dep  dep on dep.id_dep = p.id_dep_srv "
				+ "   left join bd_dep  depmp on depmp.id_dep = p.id_dep_mp  " + "  where   (tt.sd_su_or='" + ICiDictCodeConst.SD_SU_SIGN + "' or tt.eu_orsrcmdtp = '0C' )  and p.sd_su_bl ='0' "
				+ "  and p.fg_bl = 'Y' and tt.ds = 0 and p.ds = 0 "
				// +"      and   p.id_pres ='~' and (tt.sd_srvtp like '02%' or  tt.sd_srvtp like '03%')"
				+ "      and   p.id_pres ='~' and p.sd_srvtp not like '01%'" + "  and  tt.id_pat=?  and tt.code_entp= ? and  tt.id_org = ? " + " and  tt.ds = 0 ";

		if (dtSignB != null) {
			sql += "and tt.dt_sign>=?";
		}
		if (dtSignE != null) {
			sql += " and tt.dt_sign<= ?";
		}
		// sql.append( "  order by id_pres,dt_sign desc");;

		return sql.toString();
	}

	private String getSqlLab() {
		StringBuffer sql = new StringBuffer();
		// 检验
		sql.append(" select ci_or_srv.id_orsrv, ci_or_srv.fg_selfpay, ");
		sql.append(" ci_or_srv.id_srv, ");
		sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
		sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
		sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
		sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
		sql.append("  bd_srv.name          as name_srv, ");
		sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
		sql.append(" ci_or_srv.id_medu       as id_unit_med,");
		sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
		sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
		sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
		sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
		sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
		sql.append("  DOC.name name_emp_srv,");
		sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
		sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
		sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
		sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
		//sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_order.fg_orhp   fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
		sql.append(" ci_or_srv_mm.quan_bed_medu, ");
		sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
		sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
		sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
		sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
		sql.append(" bd_srv.code          as code_srv, ");
		sql.append(" en_ent.id_pripat     as id_pripat, ");
		sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
		sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
		sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
		sql.append(" ci_or_srv.name as presrption_name, ");
		sql.append(" ci_or_srv.fg_bl,");
		sql.append(" bdudidoc.name  prestp_name, ");
		sql.append(" ci_or_srv.id_dep_wh,  ");
		sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
		sql.append(" dep.name  name_dep_srv, ");
		sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
		sql.append(" depmp.name  name_dep_mp ,");
		sql.append(" ci_or_srv.fg_specill, ");
		sql.append(" ci_or_srv.fg_extdispense, ");
		sql.append(" ci_or_srv.id_srvca, ");
		sql.append("  en_ent_hp.id_hpkind, ");
		sql.append("  ci_app_lis.code_app presno, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		sql.append("   '03'  Prntype  ");
		sql.append(" from ci_order ci_order  ");
		sql.append(" inner join ci_or_srv ci_or_srv  ");
		sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append("   left JOIN ci_app_lis_or ci_app_lis_or ON ci_order.id_or = ci_app_lis_or.id_or ");
		sql.append("  left JOIN ci_app_lis ci_app_lis ON ci_app_lis.id_ciapplissheet = ci_app_lis_or.id_ciapplissheet  ");
		 
		sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append(" left outer join bd_srv bd_srv ");
		sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append(" inner join en_ent en_ent  ");
		sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent  AND en_ent_hp.fg_MAJ='Y'");
		sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
		sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append(" where  en_ent.fg_canc='N' and ci_order.sd_su_or in (");
		sql.append("'");
		sql.append(ICiDictCodeConst.SD_SU_SIGN);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_XECUTING);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_FINISH);
		sql.append("' ");
		sql.append(")");
		sql.append("  and ci_or_srv.sd_su_bl ='0' and ci_or_srv.ds = 0 ");
		sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 ");
		sql.append("     and   ci_or_srv.id_pres ='~' and (  ci_or_srv.sd_srvtp like '03%')");

		// sql.append("      and   p.id_pres ='~' and p.sd_srvtp not like '01%'");
		sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		if (dtSignB != null) {
			sql.append("and ci_order.dt_sign>=?");
		}
		if (dtSignE != null) {
			sql.append(" and ci_order.dt_sign<= ?");
		}

		return sql.toString();
	}

	// 诊疗
	private String getSqltreatment() {
		StringBuffer sql = new StringBuffer();
		// 检验
		sql.append(" select ci_or_srv.id_orsrv, ci_or_srv.fg_selfpay, ");
		sql.append(" ci_or_srv.id_srv, ");
		sql.append(" ci_or_srv.id_or,ci_order.id_or  id_pres, ");
		sql.append(" ci_or_srv.id_pat,ci_or_srv.id_entp, ");
		sql.append(" ci_or_srv.code_entp,ci_or_srv.id_en, ");
		sql.append(" ci_or_srv.sortno,ci_or_srv.id_srvtp,   ci_or_srv.sd_srvtp, ");
		sql.append("  bd_srv.name          as name_srv, ");
		sql.append(" ci_or_srv.quan_total_medu     as quan_med,  ");
		sql.append(" ci_or_srv.id_medu       as id_unit_med,");
		sql.append(" ci_or_srv.id_route,ci_or_srv.id_routedes, ");
		sql.append(" ci_or_srv.id_boil,ci_or_srv.id_boildes, ");
		sql.append(" ci_or_srv.id_freq,ci_or_srv.id_org_srv, ");
		sql.append(" ci_or_srv.id_dep_srv,ci_or_srv.id_wg_or      as id_wg_srv, ");
		sql.append(" ci_or_srv.id_emp_srv,ci_or_srv.id_org_mp, ");
		sql.append("  DOC.name name_emp_srv,");
		sql.append(" ci_or_srv.id_dep_mp,ci_or_srv.id_su_mp, ");
		sql.append(" ci_or_srv.sd_su_mp,ci_or_srv.id_su_bl, ");
		sql.append(" ci_or_srv.sd_su_bl,ci_or_srv.dt_last_bl    as dt_bl_last, ");
		sql.append(" ci_or_srv.fg_mm,ci_or_srv.fg_indic,ci_or_srv.fg_propc, ");
		sql.append(" case ci_or_srv.fg_selfpay  when 'Y' then 'N' when 'N' then 'Y' end as fg_self,ci_or_srv_mm.id_orsrvmm, ");
		//sql.append(" ci_order.fg_orhp   fg_self,ci_or_srv_mm.id_orsrvmm, ");
		sql.append(" ci_or_srv_mm.id_mm,ci_or_srv_mm.quan_cur, ");
		sql.append(" ci_or_srv_mm.quan_bed_medu, ");
		sql.append(" ci_or_srv_mm.id_pgku_cur   as id_unit_cur, ");
		sql.append(" ci_or_srv_mm.id_pgku_base  as id_unit_base, ");
		sql.append(" ci_or_srv_mm.factor        as factor_cb, ");
		sql.append(" ci_or_srv_mm.code_mm,ci_or_srv_mm.id_mmtp,ci_or_srv_mm.code_mm, ");
		sql.append(" bd_srv.code          as code_srv, ");
		sql.append(" en_ent.id_pripat     as id_pripat, ");
		sql.append(" ci_or_srv_mm.name_mm,ci_order.id_org,ci_order.id_grp, ");
		sql.append(" ci_order.name_or as des,ci_order.fg_bb, ");
		sql.append(" ci_order.no_bb,ci_order.dt_sign, ");
		sql.append(" ci_or_srv.name as presrption_name, ");
		sql.append(" ci_or_srv.fg_bl,");
		sql.append(" bdudidoc.name  prestp_name, ");
		sql.append(" ci_or_srv.id_dep_wh,  ");
		sql.append(" ci_or_srv.id_hp,ci_or_srv.ID_HPSRVTP,ci_or_srv.SD_HPSRVTP ,");
		sql.append(" dep.name  name_dep_srv, ");
		sql.append(" ci_order.applyno  code, ci_order.sv ci_sv,");
		sql.append(" depmp.name  name_dep_mp ,");
		sql.append(" ci_or_srv.fg_specill, ");
		sql.append(" ci_or_srv.fg_extdispense, ");
		sql.append(" ci_or_srv.id_srvca, ");
		sql.append("  en_ent_hp.id_hpkind, ");
		//sql.append("    ci_prn.code_prn presno, ");
		 sql.append("  case  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '02%' then ci_app_ris.code_app  ");
		 sql.append("   when ci_prn.code_prn is null and  ci_order.sd_srvtp like '03%' then ci_app_lis.code_app ");
		 sql.append("  when  ci_prn.code_prn is not null  then  ci_prn.code_prn  ");
		 sql.append("   end   presno, ");
		//手动划价 需要查出 eu_blmd,pri,pri_std,pri_ratio by yzh 2017-10-24 09:57:03
		 sql.append("   ci_or_srv.eu_blmd,ci_or_srv.pri,ci_or_srv.pri_std,ci_or_srv.pri_ratio, ");
		 sql.append("  case  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '02%' then '02'  ");
	     sql.append("  when ci_prn.code_prn is null and  ci_order.sd_srvtp like '03%' then '03'   ");
	     sql.append("    when  ci_prn.code_prn is not null  then  '04'   ");
	     sql.append("    end   Prntype  ");

		sql.append(" from ci_order ci_order  ");
		sql.append(" inner join ci_or_srv ci_or_srv  ");
		sql.append(" on ci_order.id_or=ci_or_srv.id_or ");
		sql.append("  INNER JOIN BD_PSNDOC DOC ON DOC.ID_PSNDOC=ci_or_srv.id_emp_srv");
		sql.append(" left join ci_prn_item ci_prn_item ");
		sql.append(" on ci_prn_item.id_biz = ci_or_srv.id_orsrv ");

		sql.append(" left join ci_prn ci_prn ");
		sql.append(" on ci_prn.id_ciprn = ci_prn_item.id_ciprn ");
		sql.append("  left outer join  ci_app_ris ci_app_ris    on ci_app_ris.id_or = ci_order.id_or   ");
		sql.append("  left outer join ci_app_lis_or ci_app_lis_or on ci_app_lis_or.id_or = ci_order.id_or ");
		sql.append("  left outer join  ci_app_lis ci_app_lis on ci_app_lis.id_ciapplissheet= ci_app_lis_or.id_ciapplissheet ");
	 

		sql.append(" left join ci_or_srv_mm ci_or_srv_mm ");
		sql.append(" on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		sql.append(" left outer join bd_srv bd_srv ");
		sql.append(" on bd_srv.id_srv = ci_or_srv.id_srv ");
		sql.append(" inner join en_ent en_ent  ");
		sql.append(" on ci_or_srv.id_en = en_ent.id_ent ");
		sql.append(" left outer join en_ent_hp on en_ent_hp.id_ent = en_ent.id_ent  AND en_ent_hp.fg_MAJ='Y'");
		sql.append(" left outer join bd_udidoc bdudidoc on bdudidoc.id_udidoc =ci_or_srv.id_srvtp ");
		sql.append(" left join bd_dep  dep on dep.id_dep = ci_or_srv.id_dep_srv ");
		sql.append(" left join bd_dep  depmp on depmp.id_dep = ci_or_srv.id_dep_mp  ");
		sql.append(" where en_ent.fg_canc='N' and ( ci_order.sd_su_or in (");
		sql.append("'");
		sql.append(ICiDictCodeConst.SD_SU_SIGN);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_XECUTING);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_DOCTORSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_CHECKSTOP);
		sql.append("','");
		sql.append(ICiDictCodeConst.SD_SU_FINISH);
		sql.append("' ");
		sql.append(")");
		sql.append("  or  ci_order.eu_orsrcmdtp ='0C' )");
		sql.append("  and ci_or_srv.sd_su_bl ='0' ");
		sql.append("  and ci_or_srv.fg_bl = 'Y' and ci_or_srv.ds = 0 and ci_order.ds = 0 ");
		sql.append("     and   ci_or_srv.id_pres ='~' ");
		sql.append(" and   ci_or_srv.sd_srvtp  not like '01%' ");
		sql.append(" and   ci_or_srv.sd_srvtp  not like '02%' ");
		sql.append(" and   ci_or_srv.sd_srvtp  not like '03%' ");
		// sql.append("      and   p.id_pres ='~' and p.sd_srvtp not like '01%'");
		sql.append("  and  ci_order.id_pat=?  and ci_order.code_entp= ? and  ci_order.id_org = ? ");
		if (dtSignB != null) {
			sql.append("and ci_order.dt_sign>=?");
		}
		if (dtSignE != null) {
			sql.append(" and ci_order.dt_sign<= ?");
		}
		// sql.append( "  order by id_pres,dt_sign desc");;

		return sql.toString();
	}
}
