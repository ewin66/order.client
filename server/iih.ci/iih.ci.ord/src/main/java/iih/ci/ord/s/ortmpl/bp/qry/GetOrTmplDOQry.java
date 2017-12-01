package iih.ci.ord.s.ortmpl.bp.qry;

import com.mysql.jdbc.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱模板
 * @author Young
 *
 */
public class GetOrTmplDOQry implements ITransQry {

	private String stridortmpls = "";
	private String strSdsrvtp = "";

	public GetOrTmplDOQry(String stridortmpls,String strSdsrvtp) {
		this.stridortmpls = stridortmpls;
		this.strSdsrvtp = strSdsrvtp;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select TMPL.Id_ortmpl,TMPL.Name,TMPL.Sd_ortmpltp,");
		sb.append("TMPL.Id_route,ROUTE.Code Ortmpl_route_code,ROUTE.Name Ortmpl_route_name,");
		sb.append("TMPL.Id_routedes,ROUTEDES.Code Ortmpl_routedes_code,ROUTEDES.Name Ortmpl_routedes_name,");
		sb.append("TMPL.Id_freq,FREQ.Code Ortmpl_freq_code,FREQ.Name Ortmpl_freq_name,");
		sb.append("TMPL.Id_boil,BOIL.Code Ortmpl_boil_code,BOIL.Name Ortmpl_boil_name,");
		sb.append("TMPL.Days_or,TMPL.Orders ");
		sb.append("from bd_srv_ortmpl TMPL ");
		sb.append("left join bd_route ROUTE ON ROUTE.Id_route=TMPL.Id_route ");
		sb.append("left join bd_route_des ROUTEDES ON ROUTEDES.Id_routedes=TMPL.Id_routedes ");
		sb.append("left join bd_freq FREQ ON FREQ.Id_freq=TMPL.Id_freq ");
		sb.append("left join bd_boil BOIL ON BOIL.Id_boil=TMPL.Id_boil ");
		sb.append("where TMPL.Id_ortmpl in (" + this.stridortmpls + ") ");
		sb.append(StringUtils.isNullOrEmpty(this.strSdsrvtp) ? "" : "and TMPL." + this.strSdsrvtp);
		sb.append(" order by TMPL.Seqno");
		
		return sb.toString();
	}

}
