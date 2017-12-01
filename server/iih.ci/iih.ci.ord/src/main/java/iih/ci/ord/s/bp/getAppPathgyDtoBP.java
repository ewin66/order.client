package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.dto.appobsdto.d.AppObsDto;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 病理申请单的查询 就诊预约使用
 * @author li_zheng
 *
 */
public class getAppPathgyDtoBP {
	
	 public static getAppPathgyDtoBP instance;
	 private getAppPathgyDtoBP(){}
	 public static getAppPathgyDtoBP getInstance() throws BizException{
		 if(instance== null){
			 instance = new getAppPathgyDtoBP();
		 }
		 return instance;
	 }
     /**
      * 
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
	  * sql
	  * @param condition
	  * @return
	  */
	 private String getSql(String condition){
		 
		 StringBuffer sb = new StringBuffer();
		 sb.append(" Select ");
		 sb.append(" CI_ORDER.id_or, "); 
		 sb.append(" CI_ORDER.Code_Or,");
		 sb.append(" CI_ORDER.Des_Or,");
		 sb.append(" CI_ORDER.Applyno,   "); 
		 sb.append(" CI_ORDER.Id_Dep_Or,  ");  
		 sb.append(" CI_ORDER. name_or,    ");
		 sb.append(" CI_ORDER. content_or, ");   
		 sb.append(" CI_ORDER. id_en,  ");     
		 sb.append(" CI_ORDER.ID_ENTP,  ");   
		 sb.append("  CI_ORDER.DT_EFFE dt_effe,  ");     
		 sb.append(" CI_ORDER. id_emp_sign, ");   
		 sb.append(" psndoc.name  name_emp_sign, "); 
		 sb.append(" CI_ORDER. id_dep_sign,  "); 
		 sb.append(" bddep.name  name_dep_sign,  ");
		 sb.append(" '' id_srvset,  ");  
		 sb.append(" ''   name_srv,  ");
		sb.append(" CI_ORDER.id_srv   id_srv, "); 
		sb.append(" pat.id_pat id_pat,  ");
		sb.append(" '' body_name,   ");
		sb.append(" '' sd_pos,      ");
		sb.append(" '' quan_medu,    ");
		sb.append(" '' id_medu,     ");
		sb.append(" pat.sd_sex,   ");
		sb.append(" pat.dt_birth,  "); 
		sb.append(" CI_ORDER.Id_Dep_Mp Id_dep_mp, "); 
		sb.append(" lab.fg_urgent  fg_urgent  "); 
		sb.append(" From CI_ORDER  "); 
		sb.append(" inner join ci_ap_pathgy lab on lab.id_or = ci_order.id_or  ");   
		// -- left outer join ci_or_srv  on CI_ORDER.id_or = ci_or_srv.id_or    
		// -- left outer join CI_OR_SRV_SET on CI_ORDER.id_or= CI_OR_SRV_SET.id_or   
		sb.append(" left outer join pi_pat  pat on pat.id_pat = CI_ORDER.Id_Pat  ");  
		sb.append(" left outer join bd_psndoc psndoc on psndoc.id_psndoc = CI_ORDER.id_emp_sign ");   
		sb.append(" left outer join bd_dep bddep on bddep.id_dep = CI_ORDER.Id_Dep_Sign ");   
		sb.append(" where   (CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_CHECKTHROUGH+"'  or   ");
		sb.append(" CI_ORder.sd_su_or ='"+ICiDictCodeConst.SD_SU_SIGN+"')  ");
		sb.append(" and lab.sd_su_pathgy='0' ");
		if(condition != ""){
			sb.append(condition);
		}
		 return sb.toString();
	 }
	
	 
}
