package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMeterialDOByWhereSqlQry  implements ITransQry{

	private String whereSql;
	
	
	

	public GetMeterialDOByWhereSqlQry(String whereSql){
		this.whereSql=whereSql;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(whereSql);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sb = new StringBuilder();
		sb.append("select * from bd_mm ");
		if(!CiOrdUtils.isEmpty(this.whereSql)){
			sb.append("where "+this.whereSql);
		}
		return sb.toString();
	}
}
