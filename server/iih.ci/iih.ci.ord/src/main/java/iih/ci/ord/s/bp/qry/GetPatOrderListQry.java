package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPatOrderListQry implements ITransQry {

	public String _id_ent;
	
	public GetPatOrderListQry(String id_ent){
		this._id_ent = id_ent;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetSql();
	}
	
	private String GetSql(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("  select a.*,b.name as name_freq,c.name as name_route,  measdoc.name ");
		sb.append(" from ( ");
		sb.append(" select cior.id_or,cior.content_or,cior.days_or,   orsrv.quan_medu, ");
		sb.append("  cior.id_su_or,cior.sd_su_or, '' name_su_or, ");
		sb.append(" orsrv.id_route,orsrv.id_freq, orsrv.id_medu ");
		sb.append(" from ci_order cior , ci_or_srv  orsrv ");
		sb.append(" where cior.id_or = orsrv.id_or ");
		sb.append("and cior.id_en = ?");
		sb.append(" ) a left   join  bd_freq b  on a.id_freq = b.id_freq ");
		sb.append(" left   join bd_route c on a.id_route = c.id_route  ");
		
		sb.append("  left join bd_measdoc  measdoc ");
		sb.append("  on a.id_medu = measdoc.id_measdoc ");
		return  sb.toString();
 
	}

	// 以上  sql
	/*select a.*,c.name as name_freq,b.name as name_route 
	from (   
	   select cior.id_or,cior.content_or,cior.days_or,
	          cior.id_su_or,cior.sd_su_or, '' name_su_or,
	          orsrv.id_route,orsrv.id_freq
	   from ci_order cior , ci_or_srv  orsrv
	       where cior.id_or = orsrv.id_or
	       -- and cior.id_or =''
	        ) a left   join  bd_freq b  on a.id_freq = b.id_freq
	        left   join bd_route c on a.id_route = c.id_route*/
}
