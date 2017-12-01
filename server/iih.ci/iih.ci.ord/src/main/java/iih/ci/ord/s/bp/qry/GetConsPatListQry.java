package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 会诊患者列表 sql 
 * @author li_zheng
 *
 */
public class GetConsPatListQry implements ITransQry {
   private String _id_dept;
   private String _id_emp;
   public GetConsPatListQry(String id_dept,String id_emp){
	   this._id_dept = id_dept;
	   this._id_emp = id_emp;
   }
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_dept);
		sqlparam.addParam(this._id_emp);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
    //todo  0902
	// 2 确认 会诊
	 private String getSql(){
		 return "   select  ciorder.* from ci_order ciorder,ci_ap_cons ap,CI_INVITE_CONS invite "+
                  " where  ciorder.id_or = ap.id_or  "+
				 " and   ap.id_apcons = invite.id_apcons  "+
				 " and   ciorder.sd_srvtp = '"+IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS+"'  "+
				// "  and   ap.sd_constp ='2' "+
				// " and    ciorder.dt_effe  "+
				 " and ( invite.id_dep =? "+
				 " or    invite.Id_Emp =? ) ";
	 }
	 
	/*  select  ciorder.* from ci_order ciorder,ci_ap_cons ap,CI_INVITE_CONS invite
	  where  ciorder.id_or = ap.id_or
	   and   ap.id_orcons = invite.id_apcons
	   and   ciorder.sd_srvtp = '0902'
	   and   ap.sd_constp ='2'-- 确认
	   and    ciorder.dt_effe 
	   and  invite.id_dep =''*/
}
