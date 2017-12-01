package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getTreeOrdApConsDOQry implements ITransQry {

	private String _id_ent;
	public getTreeOrdApConsDOQry(String id_ent){
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
		return getSql();
	}

	 private String getSql(){
		 return " select cons.* ,ciorder.name_or as Name_constp from  ci_ap_cons cons "+
				"  left outer join ci_order ciorder on ciorder.id_or = cons.id_or  "+
				"   left outer join bd_udidoc bd  on bd.id_udidoc = cons.id_constp  "+
				"  where cons.sd_su_cons  >= '4' "+
				"   and ciorder.id_en =? and ciorder.ds=0 and ciorder.FG_CANC='N' and ciorder.FG_STOP='N' and ciorder.FG_SIGN='Y'";
	 }
}
