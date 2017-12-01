package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱模板分类
 * @author Young
 *
 */
public class getOrTmplCaDOsQry implements ITransQry {

	private String id_grp;//集团
	private String id_org;//组织
	private String id_dep;//科室
	private String id_emp;//个人
	private String sd_ortmpltp;//模板类型
	
	public getOrTmplCaDOsQry(String id_grp, String id_org, String id_dep, String id_emp, String sd_ortmpltp) {
		this.id_grp = id_grp;
		this.id_org = id_org;
		this.id_dep = id_dep;
		this.id_emp = id_emp;
		this.sd_ortmpltp = sd_ortmpltp;
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
		sb.append("select id_ortmplca,name,des,id_parent,innercode,id_srvorrt,sd_srvorrt from bd_srv_ortmpl_ca ");
		sb.append(" where (sd_srvorrt='0' and id_grp='" + this.id_grp + "' and id_org='" + this.id_org);
		sb.append("') or (sd_srvorrt='1' and id_dep='" + this.id_dep + "') or (sd_srvorrt='2' and id_emp='" + this.id_emp + "')");
//		sb.append("and id_ortmplca in (select id_ortmplca from bd_srv_ortmpl_ca_rel REL left join bd_srv_ortmpl TMPL on TMPL.id_ortmpl=REL.id_ortmpl ");
//		sb.append("where TMPL.fg_active='Y' and TMPL.fg_sync='N' and TMPL.fg_entp_op='Y' and TMPL.sd_ortmpltp='" + this.sd_ortmpltp + "')");
		return sb.toString();
	}

}
