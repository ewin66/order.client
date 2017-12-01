package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 检查申请单
 * @author li_zheng
 *
 */
public class getAppObsDtoBP {

 public static getAppObsDtoBP instance;
 private getAppObsDtoBP(){}
 public static getAppObsDtoBP getInstance()throws BizException{
	 if(instance ==null){
		instance = new getAppObsDtoBP(); 
	 }
	 return instance;
 }
	
	/** 
	 * @param condition
	 * @return
	 * @throws BizException
	 */
	public AppObsDto[] exce(String condition)throws BizException
	{
		 String sql = getSql(condition);
		 DAFacade dafacade = new DAFacade();
		 List<AppObsDto> AppObsDtoList = (List<AppObsDto>)dafacade.execQuery(sql, new  BeanListHandler(AppObsDto.class));
		 if(AppObsDtoList== null) return null;
		 return AppObsDtoList.toArray(new AppObsDto[AppObsDtoList.size()]); 
	}
	
	
	/**
	 * 
	 * @param condition
	 * @return
	 */
	private String getSql(String condition){
		 StringBuffer sb = new StringBuffer();
	         sb.append(" Select   distinct  "); 
	         sb.append(" ci_order.id_or,   ");  
	         sb.append(" ci_order.Id_Dep_Or,   "); 
	         sb.append(" ci_order.Applyno,   "); 
	         sb.append(" CI_ORDER.Code_Or,");
			 sb.append(" CI_ORDER.Des_Or,");
	        sb.append(" ci_order.name_or,  ");  
	        sb.append(" ci_order.content_or,   ");  
	        sb.append(" ci_order.id_en,     "); 
	        sb.append(" ci_order.ID_ENTP,   "); 
	        sb.append(" ci_order.Id_Dep_Mp Id_dep_mp,"); 
	        sb.append(" lab.dt_plan dt_effe,    ");   
	        sb.append(" ci_order.id_emp_sign,  ");  
	        sb.append(" psndoc.name name_emp_sign, ");  
	        sb.append(" ci_order.id_dep_sign,  "); 
	        sb.append( " bddep.name name_dep_sign, ");  
	        sb.append( " '' id_srvset,   ");  
	        sb.append(" ci_order.name_or name_srv, "); 
	        sb.append(" ci_order.id_srv, "); 
	        sb.append(" '' body_name,  "); 
	        sb.append(" '' sd_pos,     "); 
	        sb.append(" '' quan_medu,   ");  
	        sb.append(" '' id_medu,   "); 
	        sb.append(" pat.sd_sex,  ");  
	        sb.append(" pat.dt_birth,  "); 
	        sb.append(" lab.fg_urgent  fg_urgent,  ");  
	        sb.append(" lab.sd_su_obs ");  
	        sb.append(" From CI_ORDER ");  
	        sb.append(" inner join ci_ap_obs lab on lab.id_or = ci_order.id_or and lab.sd_su_obs ='0'  "); 
	         //" left outer join ci_or_srv  on ci_order.id_or = ci_or_srv.id_or  and ci_or_srv.fg_or='Y' "+  当服务套时查询错误，改为使用ci_order中的主服务
	        sb.append( " left outer join pi_pat  pat on pat.id_pat = ci_order.Id_Pat ");   
	        sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = ci_order.id_emp_sign  ");  
	        sb.append(" left outer join bd_dep bddep on bddep.id_dep = ci_order.Id_Dep_Sign   ");  
	        sb.append(" where   ( ci_order.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'"); 
	        sb.append(" or  ci_order.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')"); 
            if(condition != null){
            	sb.append(condition);
            }
	/*         " and  CI_ORDER.Sd_Su_Bl in ("+StrMerge(sd_su_bl)+") "+
	         " and ci_order.code_entp  in  "+getEntps(entps)+
	         " and ci_order.id_dep_mp = ?"+
	         " and ci_order.dt_effe >= ? and  ci_order.dt_effe <= ?";*/
	        return sb.toString();
	}
	
}
