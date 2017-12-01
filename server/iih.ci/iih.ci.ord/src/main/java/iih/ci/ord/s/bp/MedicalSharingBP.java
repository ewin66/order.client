package iih.ci.ord.s.bp;

import java.util.List;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.d.MedicalSharingDTO;
import iih.ci.ord.dto.prescostdto.d.PrescriptionCostDto;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 
 * @author li_zheng
 *
 */
public class MedicalSharingBP {
	
	public static MedicalSharingBP instance;
	private MedicalSharingBP(){};
	public  static MedicalSharingBP getInstance()throws BizException{
		if(null == instance){
			instance = new MedicalSharingBP();	
		}
		return instance;
	}
     /**
      * 开立时，验证是否有签署 未计费的数据
      * @param id_pat
      * @param id_hp
      * @return
      * @throws BizException
      */
	 public MedicalSharingDTO[]  getMedicalSharing(String id_pat,String id_hp)throws BizException{
		 String sql = getsql(id_pat,id_hp);
		 DAFacade dafacade = new DAFacade();
		 List<MedicalSharingDTO> list =  (List<MedicalSharingDTO>)dafacade.execQuery(sql, new BeanListHandler(MedicalSharingDTO.class));
		 if(list != null && list.size() >0){
	    	 return list.toArray(new MedicalSharingDTO[list.size()]); 
	     }
	     return null;
	 
	 }
	 
	 
	 /**
      * 签署时 是否有相同的医嘱（取得开立的医嘱）
      * @param id_pat
      * @param id_hp
      * @return
      * @throws BizException
      */
	 public MedicalSharingDTO[]  getOpenCiOrder(String[] id_or,String id_pat,String id_hp)throws BizException{
		 String sql = getOPensql(id_or,id_pat,id_hp);
		 DAFacade dafacade = new DAFacade();
		 List<MedicalSharingDTO> list =  (List<MedicalSharingDTO>)dafacade.execQuery(sql, new BeanListHandler(MedicalSharingDTO.class));
		 if(list != null && list.size() >0){
	    	 return list.toArray(new MedicalSharingDTO[list.size()]); 
	     }
	     return null;
	 
	 }
	 
	 public FMap2 getMMName(String[] id_ors)throws BizException{
		 FMap2 map = new FMap2();
		 String sql = getMMSql(id_ors);
		 DAFacade dafacade = new DAFacade();
		 List<OrdSrvDO> list =  (List<OrdSrvDO>)dafacade.execQuery(sql, new BeanListHandler(OrdSrvDO.class));
		 if(list != null && list.size() >0){
	    	 for(OrdSrvDO srvdo:list){
	    		 map.put(srvdo.getId_orsrv(), srvdo.getName());
	    	 }
	     }
	     return map;
	 }
	 
	 
	 
	 /**
	  * 签署时 是否有相同的医嘱
	  * @param id_or
	  * @param id_pat
	  * @param id_hp
	  * @return
	  */
	 private String getOPensql(String[] id_or, String id_pat,String id_hp){
		 StringBuffer sb =new StringBuffer();
		  sb.append("  select ci_order.id_or, ci_or_srv_mm.days_available days_or,ci_order.dt_effe,ci_order.dt_entry, ");
		  sb.append("  ci_or_srv.id_orsrv,ci_or_srv.id_pres,ci_or_srv.sd_srvtp, bd_dep.name  dept_name,ci_order.code_or,");
		  sb.append("   ci_or_srv_mm.id_mm,ci_or_srv.name name_srv,bd_hp_srvorca.code ,");
		  sb.append(" ci_or_srv_mm.name_mm  mm_name, "); 
		  sb.append(" bd_psndoc.name  doctor_name "); 
		  sb.append("  from ci_or_srv  ");
		  sb.append("  left join ci_order on ci_or_srv.id_or = ci_order.id_or ");
		  sb.append( "  inner join bd_freq  on bd_freq.id_freq = ci_or_srv.id_freq   and  upper(bd_freq.code)  not in ('ONCE','ST','PRN') ");
		  sb.append("   left join ci_order on ci_or_srv.id_or = ci_order.id_or");
		  sb.append("  left join  ci_or_srv_mm on ci_or_srv_mm.id_orsrv = ci_or_srv.id_orsrv ");
		  sb.append("  left join bd_hp_srvorca on bd_hp_srvorca.id_mm = ci_or_srv_mm.id_mm ");
		  sb.append("  left join  bd_dep bd_dep on bd_dep.id_dep = ci_or_srv.id_dep_srv");
		  sb.append("   left join bd_psndoc  on bd_psndoc.id_psndoc = ci_order.id_emp_or ");
		  sb.append(" where    ci_or_srv.sd_srvtp like '01%' and ci_or_srv.fg_selfpay ='N' ");
		 
			sb.append(" and ci_order.fg_sign='N' ");
			sb.append(" and  ci_or_srv.id_hp='");
			sb.append(id_hp);
			sb.append("'");
			sb.append(" and ci_or_srv.id_pat ='");
			sb.append(id_pat);
			sb.append("'");
			if(id_or != null){
				sb.append(" and ci_or_srv.id_or  in (");
				sb.append(CiOrdUtils.getSqlInStrsWithOutIn(id_or));
				sb.append(")");
		}
		
		
		
		 return sb.toString();
	 }
	 
	 /**
	  * 开立时，验证本院是否有签署 未计费的数据
	  * @param id_pat
	  * @param id_hp
	  * @return
	  */
	 private String getsql(String id_pat,String id_hp){
		  StringBuffer sb = new StringBuffer();
		  sb.append("  select ci_order.id_or, ci_or_srv_mm.days_available days_or,ci_order.dt_effe,ci_order.dt_entry, ");
		  sb.append("  ci_or_srv.id_orsrv,ci_or_srv.id_pres,ci_or_srv.sd_srvtp, bd_dep.name  dept_name,ci_order.code_or,");
		  sb.append("   ci_or_srv_mm.id_mm,ci_or_srv.name name_srv,bd_hp_srvorca.code ,");
		  sb.append(" ci_or_srv_mm.name_mm  mm_name, "); 
		  sb.append(" bd_psndoc.name  doctor_name "); 
		  sb.append("  from ci_or_srv  ");
		  sb.append("  left join ci_order on ci_or_srv.id_or = ci_order.id_or ");
		  sb.append( "  inner join bd_freq  on bd_freq.id_freq = ci_or_srv.id_freq   and  upper(bd_freq.code)  not in ('ONCE','ST','PRN')");
		  sb.append("   left join ci_order on ci_or_srv.id_or = ci_order.id_or");
		  sb.append("  left join  ci_or_srv_mm on ci_or_srv_mm.id_orsrv = ci_or_srv.id_orsrv ");
		  sb.append("  left join bd_hp_srvorca on bd_hp_srvorca.id_mm = ci_or_srv_mm.id_mm ");
		  sb.append("  left join  bd_dep bd_dep on bd_dep.id_dep = ci_or_srv.id_dep_srv");
		  sb.append("  left join bd_psndoc  on bd_psndoc.id_psndoc = ci_order.id_emp_sign ");
		  sb.append("   where  ci_or_srv.code_entp in ('00','01')  ");
		 
		  sb.append("   and    ci_order.fg_sign ='Y'  and ci_order.fg_canc ='N' ");
		  sb.append("   and    ci_or_srv.fg_selfpay ='N'   and  ci_or_srv. fg_self ='N'  ");
		  sb.append("  and ci_or_srv.sd_srvtp like '01%' and ci_or_srv.sd_su_bl='0'  ");
		  if(id_pat != null ){
			  sb.append("  and  ci_or_srv.id_pat = '");
			  sb.append(id_pat);
			  sb.append("'");
		  }
		  if(id_hp != null){
			  sb.append("  and  bd_hp_srvorca.id_hp = '");
			  sb.append(id_hp);
			  sb.append("'");
		  }
		  return sb.toString();
	 }
	 /**
	  * 物品和项目的对应关系
	  * @return
	  */
	 private String getMMSql(String[] id_ors){
		 StringBuffer sb = new StringBuffer();
		 sb.append(" select ci_or_srv.id_orsrv, ci_or_srv_mm.name_mm  name  from ci_or_srv_mm ");
		 sb.append(" inner join ci_or_srv on ci_or_srv.id_orsrv = ci_or_srv_mm.id_orsrv ");
		 sb.append("  where ci_or_srv.sd_srvtp like '01%' and ci_or_srv.sd_srvtp not like '0103%' and id_or in (");
		 sb.append(CiOrdUtils.IdsConveretCharacterString(id_ors));
		 sb.append(")");
		 return sb.toString();
	 }
}
