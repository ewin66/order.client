package iih.ci.ord.s.bp;

import iih.ci.ord.dto.medicalroutinetreedto.d.Medicalroutinetreedto;

import java.util.List;

import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 住院的助手协定处方的
 * @author li_zheng
 *
 */
public class PrescriptionTreeBP {
    
	/**
	 * 协定处方的住院新的方法
	 * @param type  
	 * @return
	 * @throws BizException
	 */
	public Medicalroutinetreedto[] getPresCriptionDTONew(String type)throws BizException{
		
		StringBuffer sb = new StringBuffer();
		String str=getWhereEntp(type);
		sb.append(" select distinct ortmpl.id_ortmpl id_ortmplca, '' id_parent , ortmpl.name  from bd_srv_ortmpl ortmpl where fg_cipher ='Y' and ortmpl.fg_active ='Y' and fg_entp_ip ='Y'");
		sb.append(str);
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		//param.addParam(id_ent);
		List<Medicalroutinetreedto> result = (List<Medicalroutinetreedto> ) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(
						Medicalroutinetreedto.class));
        if(result != null  && result.size() >0 ){
        	return result.toArray(new Medicalroutinetreedto[result.size()]);
        }else{
          return  null;	
        }
	}
	
	/**
	 * 住院的助手的协定处方tree dto的数据
	 * @param id_temp
	 * @return
	 */
	public Medicalroutinetreedto[] getPresCriptionDTO(String id_temp)throws BizException{
		StringBuilder sb = new StringBuilder();
		String str=getWhereEntp(id_temp);
		sb.append("  select distinct ca.id_ortmplca , ca.id_parent,ca.name from bd_srv_ortmpl_ca  ca,  ");
		sb.append("  bd_srv_ortmpl_ca_rel rel , bd_srv_ortmpl ortmpl ");
		sb.append("  where  ca.id_ortmplca = rel.id_ortmplca ");
		sb.append("   and  rel.id_ortmpl = ortmpl.id_ortmpl ");
		sb.append( " and ortmpl.fg_cipher ='Y' ");
		sb.append( " and ortmpl.fg_active ='Y' ");
		sb.append(str);
		
		sb.append(" union all  ");
		
		sb.append(" select distinct rel.id_ortmpl,rel.id_ortmplca , ortmpl.name from bd_srv_ortmpl_ca  ca, ");
		sb.append("  bd_srv_ortmpl_ca_rel rel , bd_srv_ortmpl ortmpl ");
		sb.append("  where  ca.id_ortmplca = rel.id_ortmplca ");
		sb.append("   and  rel.id_ortmpl = ortmpl.id_ortmpl ");
		sb.append( " and ortmpl.fg_cipher ='Y' ");
		sb.append( " and ortmpl.fg_active ='Y' ");
		sb.append(str);
		
		
		String sql = sb.toString();
		SqlParam param = new SqlParam();
		//param.addParam(id_ent);
		List<Medicalroutinetreedto> result = (List<Medicalroutinetreedto> ) new DAFacade()
				.execQuery(sql, param, new BeanListHandler(
						Medicalroutinetreedto.class));
        if(result != null  && result.size() >0 ){
        	return result.toArray(new Medicalroutinetreedto[result.size()]);
        }else{
          return  null;	
        }
		
	}
	
	private String getWhereEntp(String _entp){
		 if(_entp.equals("0"))
			 return " and (ortmpl.fg_entp_op ='Y' or ortmpl.fg_entp_er ='Y')";
		 else if(_entp.equals("1"))
			 return " and ortmpl.fg_entp_ip ='Y'";
		 return "";
	 }
}
