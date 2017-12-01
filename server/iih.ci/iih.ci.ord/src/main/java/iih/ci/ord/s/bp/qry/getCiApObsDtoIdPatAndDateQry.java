/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getCiApObsDtoIdPatAndDate
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年8月24日 上午10:53:24
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCiApObsDtoIdPatAndDateQry implements ITransQry {
    
	private String  _id_pat ="";
	private FDateTime _dtSignB;
	private FDateTime _dtSignE;
	private String _obs_su;
	public getCiApObsDtoIdPatAndDateQry(String[] id_pats,FDateTime dtSignB,FDateTime dtSignE,String[] obs_su){
		this._id_pat = getId_pats(id_pats);
		this._dtSignB = Dateconvert(dtSignB.getDate()," 00:00:00");
		this._dtSignE = Dateconvert(dtSignE.getDate()," 23:59:59");
		this._obs_su = getId_pats(obs_su);
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		return sqlparam;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
	private String getSql(){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" Select  distinct   CI_ORDER.id_or,  CI_ORDER.Id_Dep_Or,   ");
		sb.append("  CI_ORDER. name_or,  CI_ORDER. content_or,   ");
		sb.append("  CI_ORDER. id_en, CI_ORDER.ID_ENTP, ");
		sb.append(" obs.dt_plan dt_effe, CI_ORDER. id_emp_sign,  ");
		sb.append(" psndoc.name  name_emp_sign, CI_ORDER. id_dep_sign,  ");
		sb.append("  bddep.name  name_dep_sign, CI_OR_SRV_SET.id_srvset,  ");
		sb.append("  ci_or_srv.name  name_srv, ci_or_srv.id_srv  id_srv, ");
		sb.append("  CI_OR_SRV_SET.body_name, CI_OR_SRV_SET.sd_pos,  ");
		sb.append(" CI_OR_SRV_SET.quan_medu,CI_OR_SRV_SET.id_medu,  ");
		sb.append(" pat.sd_sex, pat.dt_birth, obs.fg_urgent  fg_urgent , ");
		sb.append(" CI_ORDER.Id_Dep_Mp, depmp.name, ci_or_srv.id_orsrv ");
		sb.append(" From CI_ORDER ");
		sb.append("  inner join ci_ap_obs obs on obs.id_or = ci_order.id_or    ");
		sb.append(" left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  ");
		sb.append("  left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or  ");
		sb.append("  left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat   ");
		sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  ");
		sb.append("  left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign   ");
		sb.append("  left outer join  bd_dep depmp on depmp.id_dep = CI_ORDER.id_dep_mp ");
		sb.append("   where     CI_ORDER.fg_canc ='N'  ");
		if(this._id_pat != null){
			sb.append("  and CI_ORDER.id_pat in ("+this._id_pat+")");
		}
		if(this._dtSignB != null){
			sb.append("  and CI_ORDER.dt_effe >= '"+this._dtSignB+"'");
		}
		if(this._dtSignE != null){
			sb.append(" and CI_ORDER.dt_effe <= '"+this._dtSignE+"'");
		}
		if(this._obs_su != null){
			sb.append("  and  obs.sd_su_obs in ("+this._obs_su+")");
		}
		return sb.toString();
	}
    /**
     * 字符拼接
     * @param id_pats
     * @return
     */
	private String getId_pats(String[] id_pats){
		String id_pat = "";
		if(id_pats != null && id_pats.length >0){
			for(String idpat:id_pats){
				id_pat+= ",'"+idpat +"'";
			}
		}
		if(id_pat != "" && id_pat.length() >0){
			return id_pat.substring(1);
		}
		return null;
	}
	/**
	 * 日期转换
	 * @param fdateTime
	 * @param format
	 * @return
	 */
	  private FDateTime Dateconvert(FDate fdateTime,String  format){
		   if(fdateTime != null){
			   return new FDateTime(fdateTime,new FTime(format));  
		   }else{
			   return null;
		   }
	
	   }
	  //上面的sql
	 /* Select  distinct   CI_ORDER.id_or,  CI_ORDER.Id_Dep_Or,  
      CI_ORDER. name_or,  CI_ORDER. content_or,  
      CI_ORDER. id_en, CI_ORDER.ID_ENTP,   
      obs.dt_plan dt_effe, CI_ORDER. id_emp_sign, 
      psndoc.name  name_emp_sign, CI_ORDER. id_dep_sign, 
      bddep.name  name_dep_sign, CI_OR_SRV_SET.id_srvset,  
      ci_or_srv.name  name_srv, ci_or_srv.id_srv  id_srv,
      CI_OR_SRV_SET.body_name, CI_OR_SRV_SET.sd_pos,    
      CI_OR_SRV_SET.quan_medu,CI_OR_SRV_SET.id_medu,   
      pat.sd_sex, pat.dt_birth, obs.fg_urgent  fg_urgent ,
      CI_ORDER.Id_Dep_Mp, depmp.name, ci_or_srv.id_orsrv
      From CI_ORDER
       inner join ci_ap_obs obs on obs.id_or = ci_order.id_or and obs.sd_su_obs ='0' 
      left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or  
     left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or 
      left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  
      left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign  
     left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign  
      left outer join  bd_dep depmp on depmp.id_dep = CI_ORDER.id_dep_mp
      where    
      obs.sd_su_obs ='0' 
      CI_ORDER.Dt_Effe =''
       and obs.sd_su_obs = '0' "+
       and CI_ORDER.id_pat in ()
       and */
	  
	  
	  
	  
}
