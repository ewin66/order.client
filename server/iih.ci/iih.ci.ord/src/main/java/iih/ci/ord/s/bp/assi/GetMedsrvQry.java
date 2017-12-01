package iih.ci.ord.s.bp.assi;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetMedsrvQry implements ITransQry {

private String strIdsrvs = "";
	
	public GetMedsrvQry(String strIdsrvs){
		this.strIdsrvs = strIdsrvs;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select Id_srv,Id_freq,Id_route,Id_routedes,Id_boil,Id_boildes,Quan_med,Id_unit_med,Fg_set ");
		sb.append("from bd_srv ");
		sb.append("where id_srv in (" + this.strIdsrvs + ")");
		
		return sb.toString();
	}

}
