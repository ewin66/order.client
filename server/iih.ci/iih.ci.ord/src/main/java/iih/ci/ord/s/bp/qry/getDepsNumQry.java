package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getDepsNumQry implements ITransQry{
	
	private String iddep;
	
	

	public getDepsNumQry(String iddep) {
		
		this.iddep = iddep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this.iddep);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return "Select  count(BD_DEPL_DEP . id_dep)  from BD_DEPL_DEP, BD_DEPL "
				+ " where BD_DEPL_DEP .id_dep =? and BD_DEPL_DEP .sd_deplrole ='0' "
				+ " and BD_DEPL. id_depl = BD_DEPL_DEP. id_depl "
				+ " and BD_DEPL .Sd_Deptltp = '1' ";

	}

}
