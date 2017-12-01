package iih.ci.ord.refs;

import java.util.List;

import iih.ci.ord.cior.d.OrdAppBtUseDO;
import xap.sys.appfw.refinfo.RefGridModel;

public class OrdAppBtUseRefModel extends RefGridModel{
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public String[] getShowFieldCode() {
		
		return new String[]{"No_applyform","Namr_or","Name_pat"};
	}

	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{"id_dep_mp","Id_apbu","Id_or"};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"用血申请单号","医嘱名称","患者姓名"};
	}
	
	@Override
	public String getPkFieldCode() {
		return "No_applyform"; 
	}
	
	@Override
	public String getRefCodeField() {
		return "No_applyform";
	}
	
	@Override
	public String getRefNameField() {
		return "No_applyform";
	}
	
	@Override
	public String getRefSql() {
		
		StringBuffer refSql=new StringBuffer();				

		refSql.append("select * from ");
		refSql.append("( ");
		refSql.append("  select  ");
		refSql.append("  apbu.no_applyform, ");
		refSql.append("  ord.name_or, ");
		refSql.append("  enent.name_pat, ");
		refSql.append("  (select id_dep_wh from ci_or_srv where id_or = apbu.id_or and fg_or = 'Y' and rownum = 1) as id_dep_mp, ");		
		refSql.append("  apbu.ID_APBU, ");
		refSql.append("  apbu.ID_OR, ");
		refSql.append("  pipat.pycode, ");
		refSql.append("  pipat.wbcode  ");
		refSql.append("  from CI_AP_BU apbu ");
		refSql.append("  inner join ci_order ord on apbu.id_or=ord.id_or ");
		//refSql.append("  inner join ci_or_srv orsrv on orsrv.id_or=ord.id_or and orsrv.id_srv=ord.id_srv ");
		refSql.append("  left join en_ent enent on enent.id_ent=ord.id_en ");
		refSql.append("  left join pi_pat pipat on pipat.id_pat=enent.id_pat ");
		refSql.append("  where nvl(apbu.NO_APPLYFORM,'~')<>'~' ");
		refSql.append(")ci_ap_bu where 1=1 ");
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				refSql.append(" And (").append(where).append(") ");
			}
		}
		     	
		return refSql.toString();
	}
	
	@Override
	public String getTableName() {
		return new OrdAppBtUseDO().getTableName();	
	}
	
	//模糊查询
	@Override
	public String[] getBlurFields() {
		
		return new String[]{"no_applyform","name_or","name_pat","pycode","wbcode"};
}
	
}
