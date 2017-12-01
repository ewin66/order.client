package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdMmDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderDrugsSplitDateNewQry implements ITransQry {
	
	private String _id_en;
	private String idors;
	private String sd_pois;     //毒麻分类编码
	private String _code_entp;
	public GetOrderDrugsSplitDateNewQry(String id_en,String idors,String code_entp){
		
		this._id_en = id_en;
		this.idors = idors;
		this._code_entp=code_entp;
	}
   
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
//		sqlparam.addParam(this._id_pat);
		return sqlparam;
	}
	
	/*
	麻醉药品
	一类精神药品
	二类精神药品
	毒性药品
	放射性药品
	*/
    private String getsd_pois(){
    	
		sd_pois = "'" + IBdMmDictCodeConst.SD_POIS_MAZUI + "','" + IBdMmDictCodeConst.SD_POIS_JINGSHEN_1 + "','"
				+ IBdMmDictCodeConst.SD_POIS_JINGSHEN_2 + "','" + IBdMmDictCodeConst.SD_POIS_POISON + "','"
				+ IBdMmDictCodeConst.SD_POIS_RADIO + "'";

		return sd_pois;
    }
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if(_code_entp.equals(IBdFcDictCodeConst.SD_CODE_ENTP_IP)){
			 getsd_pois();
			return getSql_IP();
		}else{
			return getSql();	
		}
		 
	}
     /**
      * 门诊的分方
      * @return
      */
	private String getSql() {

		String str = "   select distinct ciormm.price_pgku_cur pri, cior.id_or, cior.id_grp, cior.id_org, cior.id_pat, cior.id_en,"
				+ "  cior.id_entp, cior.code_entp, ciorsrv.id_srvtp, ciorsrv.sd_srvtp, bd_srv_drug.sd_mmtp,"
				+ "  cior.fg_bb,cior.no_bb, cior.dt_entry, cior.id_emp_or,"
				+ "  cior.id_dep_or, cior.fg_vip,"
				+ "  ciorsrv.id_dep_mp, bd_dep.sd_clinicalprofessiontp, ciorsrv.id_dep_wh, ciorsrv.id_orsrv, ciorsrv.fg_or,"//li_cheng 2017/3/31  增加fg_or 
				+ "  ciorsrv.id_route, ciorsrv.id_routedes, ciorsrv.id_boil, ciorsrv.id_boildes, ciorsrv.fg_self, ciorsrv.fg_base,"
				+ "  ciormm.sd_pharm, ciormm.sd_anti, ciormm.sd_mmtp,"
				//自费标志为N 医保 1，自费标志为Y 非医保 0
				+ "  ciormm.sd_dosage, ciormm.quan_cur, case WHEN (ciorsrv.FG_SELFPAY='N') then '1' else '0' end as fg_hp_pres, "
				+ "  ciormm.sd_pois, ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary,"
				+ "  ciorsrv.fg_self, bd_hp_kind.code_hpkind, bd_hp_kind.name_hpkind,"
				+ "  ciorsrv.fg_specill, ciorsrv.fg_extdispense "
				+ "  from ci_order cior left join ci_or_srv ciorsrv on ciorsrv.ID_OR=cior.ID_OR "
				+ "  left join ci_or_srv_mm ciormm on ciorsrv.id_orsrv = ciormm.id_orsrv "
				+ "  left join en_ent_hp on en_ent_hp.fg_maj ='Y' and en_ent_hp.id_ent = cior.id_en "
				+ "  left join bd_hp_kind on en_ent_hp.id_hpkind = bd_hp_kind.id_hpkind and ciorsrv.id_hp = bd_hp_kind.id_hp "
				+ "  left join bd_dep on bd_dep.id_dep = cior.id_dep_or "
				+ "  left join bd_srv_drug on bd_srv_drug.id_srv = ciorsrv.id_srv "
				+ "  where cior.id_or in ("+ this.idors+ ")"
				+"   and  cior.fg_canc ='N'  "
				+ "  and (ciorsrv.ID_PRES='~' or ciorsrv.ID_PRES=null) and ciorsrv.SD_SRVTP like '01%' and ciorsrv.fg_self='N' "
				+ "  and cior.sd_su_or='10' and cior.id_en = ?";
		return str;
	}
	 
	 /**
	  * 住院的分方
	  * @return
	  */
	private String getSql_IP() {
		String str = "   select ciorsrv.pri, cior.id_or, cior.id_grp, cior.id_org, cior.id_pat, cior.id_en,"
				+ "  cior.id_entp, cior.code_entp, ciorsrv.id_srvtp, ciorsrv.sd_srvtp, "
				+ "  cior.fg_bb, cior.no_bb, cior.dt_entry, cior.id_emp_or,"
				+ "  cior.id_dep_or, ciorsrv.id_dep_mp, ciorsrv.id_dep_wh, ciorsrv.id_orsrv, ciorsrv.fg_or,"
				+ "  ciorsrv.id_route,ciorsrv.id_routedes, ciorsrv.id_boil, ciorsrv.id_boildes, ciorsrv.fg_base,"
				+ "  ciormm.sd_pharm, ciormm.sd_anti, ciormm.sd_mmtp sd_mmtp,"
				+ "  ciormm.sd_dosage, ciormm.quan_cur, case WHEN (ciorsrv.fg_indic='Y' and (ciorsrv.sd_hpsrvtp='1' or ciorsrv.sd_hpsrvtp='0')) then '1' else '0' end as fg_hp_pres, "
				+ "  ciormm.sd_pois, ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary ,"
				+ "  ciorsrv.fg_self"
				+ "  from ci_order cior "
				+ "  left join ci_or_srv ciorsrv on ciorsrv.ID_OR=cior.ID_OR "
				+ "  left join ci_or_srv_mm ciormm on ciorsrv.id_orsrv = ciormm.id_orsrv "
				+ "  where cior.id_or in ("+ this.idors+ ") "
				+ "  and (ciorsrv.ID_PRES='~' or ciorsrv.ID_PRES=null) and ciorsrv.fg_self='N' "
				+ "  and (ciormm.sd_pois in ("+ this.getsd_pois()+ ") "
				+ "  or (cior.fg_pres_outp  ='Y' and ciorsrv.SD_SRVTP like '01%') or (cior.SD_SRVTP like '0103%' and ciorsrv.SD_SRVTP like '0103%'))"
				+ "  and cior.sd_su_or='10' and cior.id_en = ?"; //li_cheng   出院带药加上是否是药品判断
		return str;
	}
}
