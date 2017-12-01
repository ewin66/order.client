package iih.ci.ord.s.bp.qry;

import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class UnchargeOrderQry implements ITransQry{
	
	
	 
	private String patid;
	private FDateTime 	dtSignB;
	private FDateTime dtSignE;
	private String code_entp;
	private String id_org;
	
	public UnchargeOrderQry(){
		
		
	}
	
	public UnchargeOrderQry(String patid,
			FDateTime dtSignB, FDateTime dtSignE, String code_entp,String Id_org){
			
		this.patid= patid;
		this.dtSignB = dtSignB;
		this.dtSignE = dtSignE;
		this.code_entp = code_entp;
		this.id_org = Id_org;	
		}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(patid);
		rtnParam.addParam(code_entp);
		rtnParam.addParam(id_org);
		if(dtSignB != null){
			rtnParam.addParam(dtSignB);
		}
		if(dtSignE != null){
			rtnParam.addParam(dtSignE);
		}
		
	
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	
	private String getSql(){
		
		StringBuffer sb = new StringBuffer();
		sb.append("  select t.id_or,t.id_grp,t.id_org,t.id_pat,t.id_entp,t.code_entp,t.id_en,t.name_or as des,t.fg_bb,t.no_bb,");
		sb.append("  t.dt_sign dt_sign ");
		sb.append("  from ci_order t where ");
		sb.append("  t.sd_su_bl='0' and t.sd_su_or='10'  and  t.id_pat=?");
		sb.append("   and t.code_entp= ? and  t.id_org = ?");
		 
		if(dtSignB != null){
			sb.append("and t.dt_sign>=?");
		}
		if(dtSignE != null){
			sb.append(" and t.dt_sign<= ?");
		}
		sb.append("");
       return sb.toString();
	}
}
