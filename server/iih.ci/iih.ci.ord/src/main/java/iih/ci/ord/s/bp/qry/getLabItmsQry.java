package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getLabItmsQry implements ITransQry{
	
	private String patid;
	private String srvs;
	private String time1;
	private String time2;
	
	

	public getLabItmsQry(String patid, String srvs, String time1, String time2) {
	//	super();
		this.patid = patid;
		this.srvs = srvs;
		this.time1 = time1;
		this.time2 = time2;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this.patid);
		sqlparam.addParam(this.time1);
		sqlparam.addParam(this.time2);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return "select lab.DT_RPTLAB,lab.ID_RPTLAB,itm.ID_SRV,itm.VAL_RSTRPTLAB,"
				+ "itm.sd_restrptlabtp from ci_order cior inner join CI_RPT_LAB lab "
				+ "on lab.ID_OR=cior.ID_OR left join CI_RPT_LAB_ITM itm on itm.ID_RPTLAB=lab.ID_RPTLAB "
				+ "where cior.ID_PAT=? and lab.DT_RPTLAB<=? and lab.DT_RPTLAB>=? and itm.id_srv in("+this.srvs+")"					
								+ "  and cior.FG_CANC='N' and cior.Fg_Pmor='N' " ;
	}

}
