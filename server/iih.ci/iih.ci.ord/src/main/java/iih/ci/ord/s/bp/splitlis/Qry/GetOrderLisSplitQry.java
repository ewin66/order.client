package iih.ci.ord.s.bp.splitlis.Qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrderLisSplitQry implements ITransQry {
	
	private String _id_en;
	private String idors;
	private String sd_pois;     //毒麻分类编码
	private String _code_entp;
	public GetOrderLisSplitQry(String id_en,String idors,String code_entp){
		
		this._id_en = id_en;
		this.idors = idors;
		this._code_entp=code_entp;
	}
   
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
//		sqlparam.addParam(this._id_pat);
		return sqlparam;
	}
	
	
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub

			return getSql();	
		
		 
	}
     /**
      * 门诊的合单
      * @return
      */
	 private String getSql(){
		 		 
	 return  "   select cior.id_or id_or, cior.id_grp,cior.id_org, cior.id_pat,cior.id_en,cior.id_dep_mp,id_entp,code_entp,"
			 +"cior.id_or id_or, cior.id_grp,cior.id_org, cior.id_pat,cior.id_en,cior.id_dep_mp,"
			 +" lab.cnt_prn, lab.fg_prn,"
			 + "lab.str_code_di str_code_di,lab.str_id_diitm str_id_diitm,lab.str_name_di str_name_di,M.ID_DIITM id_diitm,lab.name_diag name_diag,M.id_di id_di, "
			 + " cior.id_dep_or id_dep_app,cior.id_org_or id_org_app,cior.id_emp_or id_emp_app,"
			 +" lab.announcements announcements,lab.id_unit_sampcoltime id_unit_sampcoltime,"
			 + "lab.len_sampcoltime len_sampcoltime,cior.no_bb,cior.fg_bb,"			 
			 +" lab.id_srvca, lab.sd_samptp,lab.id_samptp,lab.fg_urgent,lab.id_sampcoltime "
		         +"  from  ci_order cior left join ci_ap_lab lab on lab.ID_OR=cior.ID_OR "
		         +"       left outer join ci_di_itm M ON lab.Id_Diitm=M.ID_DIITM "
			     +"  where cior.id_or in ("+this.idors+")"	
			     + "' and  cior.sd_srvtp like '" + IBdSrvDictCodeConst.SD_SRVTP_LIS + "%' )"
			     + " and cior.sd_su_or='10' "
			     +"  and  cior.id_en = ?";

	 }
	 	 
}
