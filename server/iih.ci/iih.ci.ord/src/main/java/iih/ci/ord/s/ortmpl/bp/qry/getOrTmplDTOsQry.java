package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱模板分类关系
 * @author Young
 *
 */
public class getOrTmplDTOsQry implements ITransQry {

	private String id_ortmplca;
	private String sd_ortmpltp;
	
	public getOrTmplDTOsQry(String id_ortmplca,String sd_ortmpltp){
		this.id_ortmplca=id_ortmplca;
		this.sd_ortmpltp=sd_ortmpltp;
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
		sb.append("select REL.Id_ortmplcarel,REL.Id_ortmplca,REL.Fg_sync as Fg_sync_carel,TMPL.Id_ortmpl,TMPL.Sd_ortmpltp,TMPL.Name from bd_srv_ortmpl_ca_rel REL left join bd_srv_ortmpl TMPL on REL.Id_ortmpl = TMPL.Id_ortmpl where ");
		sb.append("REL.Id_ortmplca in ("+this.id_ortmplca+") ");
		sb.append("and TMPL.sd_ortmpltp in ("+this.sd_ortmpltp+") ");
		sb.append("and TMPL.fg_active='Y' and TMPL.fg_sync='N' and TMPL.fg_entp_op='Y'");

		sb.append(" order by TMPL.Seqno");
		
		return sb.toString();
	}

}
