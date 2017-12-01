package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrLisSrvVesselRelFeeQry  implements ITransQry{

	private String _id_org;
	private String _sd_specimenvesseltp;
	private String _id_scope_dept;
	private String _code_entp;
	private Integer _reltype;

	public CiOrLisSrvVesselRelFeeQry(String id_org,String id_scope_dept,String code_entp,String sd_specimenvesseltp,Integer reltype){
		_id_org=id_org;
		_id_scope_dept=id_scope_dept;
		_code_entp=code_entp;
		_sd_specimenvesseltp=sd_specimenvesseltp;
		_reltype=reltype;
	}
	 
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id_org);
		rtnParam.addParam(_sd_specimenvesseltp);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		return " select B.Id_Srv,B.Quan_Med as Quan_medu,B.Id_Unit_Med as Id_unit,"+_reltype+" as Reltype "
	          +" from bd_srv_sani A left outer join bd_srv B ON A.Id_Srv=B.Id_Srv  "
	          +" where A.Id_Org=? and A.Sd_Sanitp=? and B.Fg_Use_"+CiOrdUtils.getEntpFldNameStr(_code_entp)+"='Y' and B.Fg_Active='Y'";  
	}
	
	public String getQrySQLStr0() {
		return " select B.Id_Srv,B.Quan_Med as Quan_medu,B.Id_Unit_Med as Id_unit,"+_reltype+" as Reltype "
	          +" from bd_srv_sani A left outer join bd_srv B ON A.Id_Srv=B.Id_Srv  "
	          +" where A.Id_Org='"+_id_org+"' and A.Sd_Sanitp='"+_sd_specimenvesseltp+"' and B.Fg_Use_"+CiOrdUtils.getEntpFldNameStr(_code_entp)+"='Y' and B.Fg_Active='Y'";  
	}

}
