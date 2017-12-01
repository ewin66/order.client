package iih.ci.ord.s.bp.base.bizline;

import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.d.desc.DeptDODesc;

/**
 * 根据科室与病区关系业务线类型
 * 获得病区或科室对应的部门信息集合操作BP
 * 这个内容最终应调整到BD资源模块中
 */
public class GetDepts8DepWardRelBlTpBP {
	/**
	 * 根据科室与病区关系业务线类型获得病区或科室对应的部门信息集合
	 * @param id_org
	 * @param id_dep_src
	 * @param issrcward
	 * @return
	 * @throws BizException
	 */
	public DeptDO[] exec(String id_org,String id_dep_src,FBoolean issrcward)  throws BizException{
		//有效性校验
		if(!validateCheck(id_org,id_dep_src))return null;
		
		//获得查询sql串
		String whereStr=getSQlStr(id_org,id_dep_src,issrcward);
		
		//查询
		DeptDO[] deptdos=CiOrdAppUtils.getDeptQryService().find(whereStr, "", FBoolean.FALSE);
		
		//结果返回
		return deptdos;
	}
	
	/**
	 * 有效性校验
	 * @param id_org
	 * @param id_ward
	 * @return
	 */
	private boolean validateCheck(String id_org,String id_ward){
		if(CiOrdUtils.isEmpty(id_org) || CiOrdUtils.isEmpty(id_ward))return false;
		return true;
	}
	
	/**
	 * 获得SQl串
	 * @param id_org
	 * @param id_ward
	 * @return
	 */
	private String getSQlStr(String id_org,String id_ward,FBoolean issrcward){
		String sql=BizLineHelper.getSqlPart4DeptWardRel(id_org,id_ward,issrcward);
		return DeptDODesc.TABLE_ALIAS_NAME+"."+DeptDO.ID_DEP +" in ("+sql+")";
	}
	
	
}
