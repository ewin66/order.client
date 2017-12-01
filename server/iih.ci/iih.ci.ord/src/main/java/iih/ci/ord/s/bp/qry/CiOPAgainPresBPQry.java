package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 重新分方
 * @author li_zheng
 *
 */
public class CiOPAgainPresBPQry implements ITransQry {

	private String _id_dep_sign;
	private String _code_entp;
	private String _id_en;
	public CiOPAgainPresBPQry(String id_dep_sign,String code_entp,String id_en){
		this._id_dep_sign = id_dep_sign;
		this._code_entp = code_entp;
		this._id_en = id_en;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam  pram = new SqlParam();
		return pram;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
	
	private String getSql(){
		return " select ciorsrv.id_pres,ciormm.price_pgku_cur pri, cior.id_or id_or, cior.id_grp,cior.id_org, cior.id_pat,cior.id_en," 
               +" cior.id_entp,cior.code_entp,ciorsrv.id_srvtp,ciorsrv.sd_srvtp,bd_srv_drug.sd_mmtp,   "
               +"  cior.fg_bb fg_bb ,cior.no_bb,cior.dt_entry,cior.id_emp_or,  "
               +"  cior.id_dep_or, cior.fg_vip,  "
               +"  ciorsrv.id_dep_mp id_dep_mp ,bd_dep.sd_clinicalprofessiontp,ciorsrv.id_dep_wh id_dep_wh ," 
               +"  ciorsrv.id_orsrv id_orsrv, ciorsrv.fg_or, " 
                 //li_cheng 2017/3/31  增加fg_or 
               +"   ciorsrv.id_route,ciorsrv.id_routedes ,ciorsrv.id_boil,ciorsrv.id_boildes,ciorsrv.fg_self, ciorsrv.fg_base, " 
               +"  ciormm.sd_pharm sd_pharm,ciormm.sd_anti sd_anti,ciormm.sd_mmtp sd_mmtp,  "
              //自费标志为N 医保 1，自费标志为Y 非医保 0
               +" ciormm.sd_dosage sd_dosage,ciormm.quan_cur,case WHEN (ciorsrv.FG_SELFPAY='N') then '1' else '0' end as fg_hp_pres,"   
               +"  ciormm.sd_pois sd_pois ,ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary,  "
               +"  ciorsrv.fg_self,bd_hp_kind.code_hpkind,bd_hp_kind.name_hpkind ,  "
               +"   ciorsrv.fg_specill,ciorsrv.fg_extdispense   "
               +" from ci_or_srv ciorsrv  left join ci_order cior on ciorsrv.ID_OR=cior.ID_OR   "
               +" left join ci_or_srv_mm ciormm   on ciorsrv.id_orsrv = ciormm.id_orsrv    " 
               +"left join en_ent_hp  on en_ent_hp.fg_maj ='Y' and en_ent_hp.id_ent =  cior.id_en "  
               +" left join  bd_hp_kind  on    en_ent_hp.id_hpkind =  bd_hp_kind.id_hpkind and ciorsrv.id_hp = bd_hp_kind.id_hp  " 
               +" left join bd_dep on bd_dep.id_dep =  cior.id_dep_or   "
               +"left join bd_srv_drug on bd_srv_drug.id_srv = ciorsrv.id_srv "  
               +" where   ciorsrv.sd_su_mp ='0' and ciorsrv.sd_su_bl ='0' and "
               +" cior.fg_sign ='Y' and  cior.fg_canc ='N' and ciorsrv.SD_SRVTP like '01%' and ciorsrv.fg_self='N'  " 
               +" and cior.id_emp_sign = '"+ this._id_dep_sign +"'"
              +" and ciorsrv.id_en =  '"+this._id_en+"'"
              +" and ciorsrv.code_entp = '"+this._code_entp+ "'";
	}
	

}
