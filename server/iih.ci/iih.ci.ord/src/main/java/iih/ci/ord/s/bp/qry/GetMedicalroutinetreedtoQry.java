/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import java.util.Hashtable;

import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getMedicalroutinetreedtoQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年10月27日 下午8:50:50
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetMedicalroutinetreedtoQry implements ITransQry {

	private String _entp;
	public void exec(String _entp) throws BizException{
		this._entp=_entp;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		return param;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
    
	 private String getSql(){
		
		 return "select  ca.id_parent ,ca.id_ortmplca  "
		 		+ ",   ca.name from bd_srv_ortmpl_ca ca  where ca.fg_routine ='Y' "
				+"   union all "
				+"  select carel.id_ortmplca , carel.id_ortmpl "
				+ " Id_regularorca, tmpl.name from  bd_srv_ortmpl_ca ca  "
				+ " ,bd_srv_ortmpl_ca_rel carel  ,"
				+"  bd_srv_ortmpl tmpl "
				+"  where  ca.id_ortmplca = carel.id_ortmplca "
				+"  and tmpl.id_ortmpl =  carel.id_ortmpl "
				+"  and ca.fg_routine ='Y'"
				+"  and tmpl.fg_active ='Y'"
				+getWhereEntp();
	 }
	 
	 private String getWhereEntp(){
		 if(this._entp.equals("0"))
			 return " and (tmpl.fg_entp_op ='Y' or tmpl.fg_entp_er ='Y')";
		 else if(this._entp.equals("1"))
			 return " and tmpl.fg_entp_ip ='Y'";
		 return "";
	 }
}
