package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询频次
 * @author Young
 *
 */
public class GetFreqDefDOsQry implements ITransQry {

	String str = "";

	public GetFreqDefDOsQry(String str) {
		this.str = str;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		String sql = " select freq.Id_freq,freq.Sd_frequnitct,udidoc.Name Fre_name,freq.Name,freq.Freqct,freq.Frequnitct from bd_freq freq "
				+ "left join bd_udidoc udidoc on udidoc.id_udidoc=freq.id_frequnitct "
				+ "where freq.ds<1 and freq.fg_active='Y' and "+this.str;
		return sql;
	}

}
