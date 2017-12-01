package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class OutDeptCheckOrderQry implements ITransQry {
	
	private String _id_en;
	
	public OutDeptCheckOrderQry(String id_en){
		this._id_en = id_en;
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(this._id_en);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
   
	private String getSql(){
		return " select suor.name as suname , ord.id_su_or,ord.fg_long,srvtp.name srvname ,srv.id_srvtp,ord.des_or,ord.dt_effe,"
       +" ps.name as empname ,ord.id_emp_or,dep.name as deptname,srv.id_dep_mp,srv.dt_last_mp"
       +"  from  ci_order ord "
       +"  left join  ci_or_srv srv  on ord.id_or = srv.id_or"
       +"  left join  bd_udidoc  suor on     ord.id_su_or =  suor.id_udidoc and suor.id_udidocList ='0001ZZ2000000000004N' "
       +"  left join  bd_udidoc  srvtp on     srv.id_srvtp =  srvtp.id_udidoc and srvtp.id_udidocList ='0001ZZ2000000000000T' "
       +"  left join  bd_dep   dep  on dep.id_dep = srv.id_dep_mp"
       +"  left join   bd_psndoc ps on ps.id_psndoc = ord.id_emp_or"
       +"  where ord.id_en = ?";
			 
	}
}
