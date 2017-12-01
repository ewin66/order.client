package iih.ci.ord.refs;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.orgfw.dept.d.DeptDO;

public class BdCiCfmSrvRefModel  extends RefTreeModel{
	
	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{DeptDO.CODE,DeptDO.NAME};
	}
	
	@Override
	public String[] getHiddenFieldCode() {
		return new String[]{DeptDO.ID_DEP};
	}
	
	@Override
	public String[] getShowFieldName() {
		return new String[]{"部门编码","部门名称"};
	}
	
	@Override
	public String getPkFieldCode() {
		return DeptDO.ID_DEP;
	}
	

	
	@Override
	public String getRefCodeField() {
		return DeptDO.CODE;
	}
	
	@Override
	public String getRefNameField() {
		return DeptDO.NAME;
	}

	@Override
	public String getRefSql() {
		
		String refSql=	"select BD_DEP.code,BD_DEP.name,BD_DEP.id_dep from BD_DEP,BD_DEPL_DEP, BD_DEPL";
        
		StringBuilder sb = new StringBuilder(refSql);
		sb.append(" where 1=1 ");
		
		String sddepttpStr = (String)this.getExtendAttributeValue("sddepttp");
		if(!StringUtil.isEmpty(sddepttpStr)){
			sb.append(" and BD_DEPL_DEP .id_dep  = '" + sddepttpStr +"'");
		}
		sb.append(" and BD_DEPL_DEP .sd_deplrole =0 ");
		sb.append(" and BD_DEPL. id_depl = BD_DEPL_DEP. id_depl ");
	//	sb.append(" and BD_DEPL .sd_depltp = '1' ");
		sb.append(" and BD_DEPL . activestate ='2' ");
		sb.append(" and BD_DEP. id_dep = BD_DEPL_DEP. id_dep ");
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" And (").append(where).append(") ");
			}
		}

		return sb.toString();
	}

	@Override
	public String getTableName() {
		return new DeptDO().getTableName();
	}

}
