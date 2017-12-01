package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.ortpl.dto.OrTmplDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class getTemplateClassIficationBP {
  
	public   FMap getTemplateClassIfication(String en_entp,String id_dept,String id_emp,String sd_tp)throws BizException{
		long start = System.currentTimeMillis();
		String id_org = CiOrdAppUtils.getEnvContext().getOrgId();
		 FMap map = new FMap();
		 String fg_use= getEnTp(en_entp); 
		 StringBuffer sql = new StringBuffer();
		 if(fg_use != ""){
			  sql.append(" select * from  (");
			  sql.append(getfunHispitals(id_org));
			  sql.append(" and ");
			  sql.append(fg_use);
			  
			  sql.append(" union all ");
			  sql.append(getDept(id_dept));
			  sql.append(" and ");
			  sql.append(fg_use);
			  
			  sql.append(" union all ");
			  sql.append(getpersonal(id_emp));
			  sql.append(" and ");
			  sql.append(fg_use);
			  sql.append(" ) order by  pycode asc ");
		 
		 }else {
			sql.append(" select * from  (");
			sql.append(getfunHispitals(id_org));
			sql.append(" union all ");
			sql.append(getDept(id_dept));
			sql.append(" union all ");
			sql.append(getpersonal(id_emp));
			sql.append(" ) order by  pycode asc ");
		 }
		
		List<OrTmplDTO> hispital = (List<OrTmplDTO> ) new DAFacade()
		.execQuery(sql.toString(),  new BeanListHandler(
				OrTmplDTO.class));
		
		 
		map.put(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID, ListConvertFArrayList2(hispital));
		//map.put(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID, ListConvertFArrayList2(dept));
		//map.put(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID, ListConvertFArrayList2(personal));
		CiOrdUtils.LogerOutInfo("类 getTemplateClassIficationBP 模板分类耗时"+(System.currentTimeMillis()-start));
		return map;
	}
	
	  private String getEnTp(String code_entp){
		  String entp =  null ;
		  if(code_entp != null && IEnDictCodeConst.SD_ENTP_OUTPATIENT.equals(code_entp)){
			  entp = " fg_entp_op ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_EMERGENCY.equals(code_entp)){
			  entp = " fg_entp_er ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_INPATIENT.equals(code_entp)){
			  entp = " fg_entp_ip ='Y'";
		  }else if(code_entp != null && IEnDictCodeConst.SD_ENTP_PHYSICALEXAM.equals(code_entp)){
			  entp = "  fg_entp_fm ='Y'";
		  }
		  return entp;
	  }
	
	
	private FArrayList ListConvertFArrayList2(List<OrTmplDTO> list){
		FArrayList Flist = new FArrayList();
		if(list != null){
			for(OrTmplDTO dto:list){
				Flist.add(dto);
			}
		}
		return Flist;
	}
	
	
	private String getfunHispitals(String id_org){
		 StringBuffer sb = new StringBuffer();
		  sb.append(" select  'H' Id_ortmplcarel, '");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' Id_ortmpl,'全院' name , 'pycode' pycode, '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual" );
		  sb.append(" union all ");
		  sb.append(" select ca.id_ortmplca  Id_ortmplcarel,  ca.id_ortmplca|| 'H' Id_ortmpl , ca.name,ca.pycode,case  ca.id_parent || 'H' when '~H' then '");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' else  ca.id_parent || 'H' end id_ortmplca ,'' sd_ortmpltp ,'0' as OrtmplType from bd_srv_ortmpl_ca ca ");
		  sb.append( "   where ca.id_org ='"+id_org+"'");
		  sb.append("  union all ");
		  sb.append( "  select ortmpl.id_ortmpl  Id_ortmplcarel  ,");
		  sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		  sb.append(" ortmpl.id_ortmpl || 'H' end  Id_ortmpl,  ");
		  sb.append(" ortmpl.name , ortmpl.pycode,carel.id_ortmplca|| 'H' id_ortmplca ,ortmpl.sd_ortmpltp ,'1' as OrtmplType from ");
		  sb.append("  bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		  sb.append(" where  ortmpl.id_ortmpl = carel.id_ortmpl and ortmpl.id_srvorrt='");
		  sb.append(IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID);
		  sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y'   and carel.fg_sync='Y' ");
		  if(id_org != null && id_org != ""){
			  sb.append( " and  ortmpl.id_org ='"+id_org+"'");
		  }
		
		  return sb.toString();
		/*return  " select  'H' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' Id_ortmpl,'全院' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "
                +" union all "
				+" select ca.id_ortmplca  Id_ortmplcarel,  ca.id_ortmplca|| 'H' Id_ortmpl , ca.name,case  ca.id_parent || 'H' when '~H' then '"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' else  ca.id_parent || 'H' end id_ortmplca ,'' sd_ortmpltp ,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				"  where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"' and ca.ds='0'"+
				"  union all "+
				"  select ortmpl.id_ortmpl  Id_ortmplcarel  ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'H' end  Id_ortmpl,  "
				+" ortmpl.name ,carel.id_ortmplca|| 'H' id_ortmplca ,ortmpl.sd_ortmpltp ,'1' as OrtmplType from "+
				"  bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				"  where  ortmpl.id_ortmpl = carel.id_ortmpl and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_HOSPIAL_ID+"'"
				+" and ortmpl.ds='0' and carel.ds='0'  ";
				 */
				 
		}
	
	
	private String getDept(String id_dep){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select  'D' Id_ortmplcarel, '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("' Id_ortmpl,'科室' name , 'pycode' pycode, '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual ");
		sb.append(" union all ");
		sb.append(" select ca.id_ortmplca  Id_ortmplcarel  ,ca.id_ortmplca||'D' Id_ortmpl ,ca.name,ca.pycode,case  ca.id_parent || 'D' when '~D' then '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("' else  ca.id_parent || 'D' end id_ortmplca, '' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca ");
		sb.append(" where ca.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("'  and  ca.id_dep='");
		sb.append(id_dep);
		sb.append("' and ca.ds='0'");
		sb.append(" union all ");
	 
		sb.append(" select ortmpl.id_ortmpl  Id_ortmplcarel ,");
		sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		sb.append(" ortmpl.id_ortmpl || 'D' end  Id_ortmpl,  ");
		sb.append(" ortmpl.name ,ortmpl.pycode,carel.id_ortmplca||'D' id_ortmplca,ortmpl.sd_ortmpltp,'1' as OrtmplType from ");
		sb.append(" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		sb.append(" where  ortmpl.id_ortmpl = carel.id_ortmpl ");
		sb.append(" and ortmpl.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID);
		sb.append("'  and ortmpl.id_dep='");
		sb.append(id_dep);
		sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y'  and carel.fg_sync='Y'  ");
		return sb.toString();
	/*	return  " select  'D' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"' Id_ortmpl,'科室' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "+
				" union all "+
				" select ca.id_ortmplca  Id_ortmplcarel  ,ca.id_ortmplca||'D' Id_ortmpl ,ca.name,case  ca.id_parent || 'D' when '~D' then '"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"' else  ca.id_parent || 'D' end id_ortmplca, '' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				" where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"+
				"  and  ca.id_dep='"+ id_dep+"' and ca.ds='0'" + 
				" union all "+
				" select ortmpl.id_ortmpl  Id_ortmplcarel ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'D' end  Id_ortmpl,  "
				+ "ortmpl.name ,carel.id_ortmplca||'D' id_ortmplca,ortmpl.sd_ortmpltp,'1' as OrtmplType from "+
				" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				" where  ortmpl.id_ortmpl = carel.id_ortmpl "
				+ " and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_DEPARTMENT_ID+"'"
				+"  and ortmpl.id_dep='"+id_dep+"' and ortmpl.ds='0' and carel.ds='0'    "
				;*/
				 
		}
	
	private String getpersonal(String id_emp){
		
		StringBuffer sb = new StringBuffer();
		sb.append(" select  'R' Id_ortmplcarel, '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' Id_ortmpl,'个人' name , 'pycode' pycode, '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual ");
		sb.append(" union all ");
		sb.append(" select ca.id_ortmplca  Id_ortmplcarel ,ca.id_ortmplca||'R' Id_ortmpl ,ca.name,ca.pycode,case  ca.id_parent || 'R' when '~R' then '");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' else  ca.id_parent || 'R' end id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca ");
		sb.append(" where ca.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("' and  ca.id_emp='");
		sb.append(id_emp);
		sb.append("' and ca.ds='0'");
		sb.append(" union all ");
		sb.append(" select ortmpl.id_ortmpl Id_ortmplcarel ,");
		sb.append(" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else ");
		sb.append(" ortmpl.id_ortmpl || 'R' end  Id_ortmpl,  ");
		sb.append(" ortmpl.name ,ortmpl.pycode,carel.id_ortmplca||'R' id_ortmplca ,ortmpl.sd_ortmpltp,'1' as OrtmplType from ");
		sb.append(" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  ");
		sb.append("  where  ortmpl.id_ortmpl = carel.id_ortmpl ");
		sb.append("  and ortmpl.id_srvorrt='");
		sb.append(IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID);
		sb.append("'  and ortmpl.id_emp ='");
		sb.append(id_emp);
		sb.append("' and ortmpl.ds='0' and carel.ds='0' and ortmpl.fg_active='Y'   and carel.fg_sync='Y'  ");
		return sb.toString();
		
		/*return  " select  'R' Id_ortmplcarel, '"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"' Id_ortmpl,'个人' name , '0' id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from dual "+
				" union all "+
				" select ca.id_ortmplca  Id_ortmplcarel ,ca.id_ortmplca||'R' Id_ortmpl ,ca.name,case  ca.id_parent || 'R' when '~R' then '"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"' else  ca.id_parent || 'R' end id_ortmplca,'' sd_ortmpltp,'0' as OrtmplType from bd_srv_ortmpl_ca ca "+
				" where ca.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"+
				" and  ca.id_emp='" +id_emp+"' and ca.ds='0'"+
				" union all "+
				" select ortmpl.id_ortmpl Id_ortmplcarel ,"
				+" case when carel.fg_sync ='N' then ortmpl.id_ortmpl || 'X' else "
				+" ortmpl.id_ortmpl || 'R' end  Id_ortmpl,  "
				+ " ortmpl.name ,carel.id_ortmplca||'R' id_ortmplca ,ortmpl.sd_ortmpltp,'1' as OrtmplType from "+
				" bd_srv_ortmpl ortmpl ,bd_srv_ortmpl_ca_rel carel  "+  
				"  where  ortmpl.id_ortmpl = carel.id_ortmpl "
				+"  and ortmpl.id_srvorrt='"+IBdSrvDictCodeConst.SD_OWTP_PERSONAL_ID+"'"
				+"  and ortmpl.id_emp ='"+id_emp+"' and ortmpl.ds='0' and carel.ds='0'   "
				;*/
				 
		}
}
