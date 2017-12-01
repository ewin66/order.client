package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱模板明细
 * @author Young
 *
 */
public class GetOrTplNItmDOQry implements ITransQry {

	private String stridortmpls = "";
	
	public GetOrTplNItmDOQry(String stridortmpls){
		this.stridortmpls = stridortmpls;
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
		sb.append("select ITEM.Id_ortmplitm,ITEM.Id_ortmpl,ITEM.Id_srv,ITEM.Sd_srvtp,SRV.Name Ortplnitm_srv_name,SRV.Ismulexec,SRV.Ismuldose,");
		sb.append("ITEM.Id_mm,MM.Name Ortplnitm_mm_name,");
		sb.append("ITEM.Quan_med,MEAS.Name Ortplnitm_unit_name,ITEM.Days_or,ITEM.Eu_ortplitmtp,");
		sb.append("FREQ.Name Ortplnitm_freq_name,");
		sb.append("DEP.Name Ortplnitm_mp_name ");
		sb.append("from bd_srv_ortmpl_itm ITEM ");
		sb.append("left join bd_srv SRV ON SRV.Id_srv=ITEM.Id_srv ");
		sb.append("left join bd_mm MM ON MM.Id_mm=ITEM.Id_mm ");
		sb.append("left join bd_freq FREQ ON FREQ.Id_freq=ITEM.Id_freq ");
		sb.append("left join bd_dep DEP ON DEP.Id_dep=ITEM.Id_dep_mp ");
		sb.append("left join bd_measdoc MEAS ON MEAS.Id_measdoc=ITEM.Id_unit_med ");
		sb.append("where ITEM.Id_ortmpl in (" + this.stridortmpls + ") order by ITEM.Id_ortmpl,ITEM.Sortno");
		
		return sb.toString();
	}
}
