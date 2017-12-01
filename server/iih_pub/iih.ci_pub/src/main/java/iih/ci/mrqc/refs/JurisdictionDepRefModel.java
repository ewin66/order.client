package iih.ci.mrqc.refs;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.refinfo.RefTreeModel;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.securityfw.login.d.OrgSwitchDTO;
import xap.sys.securityfw.login.i.ILogin;

/*
 * 权限科室参照Model
 * */
public class JurisdictionDepRefModel extends RefTreeModel {

	private static final long serialVersionUID = 1L;

	@Override
	public String[] getShowFieldCode() {
		return new String[]{DeptDO.CODE,DeptDO.NAME};
	}


	@Override
	public String[] getShowFieldName() {
		return new String[]{"编码","名称"};
	}

	@Override
	public String getTableName() {
		return new DeptDO().getTableName();
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
	public String[] getHiddenFieldCode() {

		return new String[] { DeptDO.ID_DEP,DeptDO.PYCODE, DeptDO.WBCODE, DeptDO.MNECODE,DeptDO.INNERCODE,DeptDO.ID_PARENT};

	}

	/**
	 * 查询字段名数组
	 */
	@Override
	public String[] getBlurFields() {
		return new String[] { DeptDO.ID_DEP,DeptDO.CODE, DeptDO.NAME, DeptDO.PYCODE, DeptDO.WBCODE, DeptDO.MNECODE,DeptDO.INNERCODE};
	}
	
	@Override
    public List<String> getOrderPart(){
    	
		   List<String> list = new ArrayList<String>();
		   list.add(DeptDO.CODE);
		   return list;
    }
	
	@Override
	public String getRefNameField() {
		return DeptDO.NAME;
	}
/*
	@Override
	public String getChildField() {
		return DeptDO.ID_ORG;
	}
*/
	@Override
	public String getFatherField() {
		return DeptDO.ID_PARENT;
	}
	
	@Override
	public void addWherePart(String wherePart) {

		getWherePart().add(wherePart);
	}
	
	@Override
	public String getRefSql  () 
	{
		
		String id_org = Context.get().getOrgId();
		FBoolean isPortalLogin = FBoolean.FALSE;
		StringBuilder whereSql = new StringBuilder(" Where 1=1 and ds = '0'");
		OrgSwitchDTO orgSwitchDTO;
		try {
			orgSwitchDTO = ServiceFinder.find(ILogin.class).switchOrg(id_org, isPortalLogin);
			FArrayList deptDOpowers = orgSwitchDTO.getSwitchUnits().getDeptDOpowers();
			if(deptDOpowers!=null &&deptDOpowers.size()>0)
			{
				
				whereSql .append(" and id_dep in ('");
				for(int i =0;i<deptDOpowers.size();i++)
				{
					if(i==deptDOpowers.size()-1)
					{
						DeptDO dep = (DeptDO)deptDOpowers.get(i);
						whereSql.append(dep.getId_dep());
						whereSql.append("')");
						
					}
					else
					{
						
						DeptDO dep = (DeptDO)deptDOpowers.get(i);
						whereSql.append(dep.getId_dep());
						whereSql.append("','");
					}
					
				}
			}
			
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		StringBuilder sb = new StringBuilder();
		//sb.append("select * from bd_dep ");
		sb.append("select code,name,id_dep,innercode,pycode,wbcode,mnecode,id_parent from bd_dep ");
		sb.append(whereSql);
		
		List<String> whereList = this.getWherePart();
		if (whereList.size() > 0) {
			for (String where : this.getWherePart()) {
				sb.append(" and (").append(where).append(") ");
			}
		}
		return sb.toString();
		
		
	}
}
