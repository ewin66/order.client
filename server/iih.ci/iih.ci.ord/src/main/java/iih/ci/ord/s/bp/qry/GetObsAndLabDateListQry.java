package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetObsAndLabDateListQry implements ITransQry {
	public String  _id_ent;
	public String  _type;
	
	public GetObsAndLabDateListQry(String id_ent,String type){
		this._id_ent = id_ent;
		this._type = type;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		// todo 修改
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_ent);
		sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		if(this._type.equalsIgnoreCase("obs")){
			return getSql_obs();
		}
		if(this._type.equalsIgnoreCase("lab")){
			return getSql_lab();
		}
	    return null;
	}
	
	 /**
	  * 检查
	  * @return
	  */
	 private String getSql_obs(){
		 return     "  "
				   + "    select substr(ciorder.dt_effe,1,10) name, sd_srvtp,  ciorder.id_srvtp id,   null  parent   from ci_rpt_obs  obs "
				   +"   left outer join ci_order ciorder on obs.id_or = ciorder.id_or "
				   +"   where ciorder.id_en =?"
				   //+"    and obs.sd_su_lab = '01' "
				   +"    group by  substr(ciorder.dt_effe,1,10), sd_srvtp,ciorder.id_srvtp  "
				   +"  UNION  "
				   +"  select ciorder.name_or||'('|| substr(ciorder.dt_effe,10,14)||')', sd_srvtp, obs.id_rptobs, ciorder.id_srvtp parent  "
				   +"  from ci_rpt_obs  obs "
				   + "  left outer join ci_order ciorder on obs.id_or = ciorder.id_or  " 
				   +"  where ciorder.id_en =?"
		           +"   ";
	 }
    /**
     * 检验
     * @return
     */
	 private String getSql_lab(){
		 return     "  "
				   + "    select substr(ciorder.dt_effe,1,10) name, sd_srvtp,  ciorder.id_srvtp id,   null  parent   from ci_rpt_lab  lab "
				   +"   left outer join ci_order ciorder on lab.id_or = ciorder.id_or "
				   +"   where ciorder.id_en =?"
				   //+"    and lab.sd_su_lab = '01' "
				   +"    group by  substr(ciorder.dt_effe,1,10), sd_srvtp,ciorder.id_srvtp  "
				   +"  UNION  "
				   +"  select ciorder.name_or||'('|| substr(ciorder.dt_effe,10,14)||')', sd_srvtp, lab.Id_rptlab id, ciorder.id_srvtp parent  "
				   +"  from ci_rpt_lab  lab "
				   + "  left outer join ci_order ciorder on lab.id_or = ciorder.id_or  " 
				   +"  where ciorder.id_en =?"
		           +"  ";
	 }
}
