package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderDrugsSplitDateQry implements ITransQry {
	
	private String _id_en;
	private String _id_pat;
	
	public GetOrderDrugsSplitDateQry(String id_en,String id_pat){
		
		this._id_en = id_en;
		this._id_pat = id_pat;
	}
   
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
		sqlparam.addParam(this._id_pat);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	 private String getSql(){
		 
	 return  "   select ciormm.PRICE_PGKU_CUR pri, cior.id_or id_or, cior.id_grp,cior.id_org, cior.id_pat,cior.id_en,"
			     +"  cior.id_entp,cior.id_srvtp,cior.sd_srvtp, "
		         +"  cior.fg_bb fg_bb ,cior.no_bb,cior.dt_entry,cior.id_emp_or,"
		         +"  cior.id_dep_or,"
		         +"  ciorsrv.id_dep_mp id_dep_mp , ciorsrv.id_orsrv id_orsrv,"
		         +"  ciorsrv.id_route,ciorsrv.id_routedes ,ciorsrv.id_boil,ciorsrv.id_boildes,"
		         +"  ciormm.sd_pharm sd_pharm,ciormm.sd_anti sd_anti,ciormm.sd_mmtp sd_mmtp,"
		         + " ciormm.sd_dosage sd_dosage,"
		         +"  ciormm.sd_pois sd_pois ,ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary"
			     +"  from  ci_order cior ,ci_or_srv ciorsrv , ci_or_srv_mm ciormm "
			     +"  where cior.id_or = ciorsrv.id_or "
			     +"  and  ciorsrv.id_orsrv = ciormm.id_orsrv"
			     +"  and  ciormm.sd_mmtp = '0'"
			     +"  and  cior.id_en = ?"
			     +"  and  cior.id_pat = ?";
		 		 
		 
	 }
}
