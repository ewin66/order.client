package iih.ci.ord.s.bp.base.bizline;

import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 根据科室与病区关系业务线类型
 * 获得病区或科室对应的部门主键串操作BP
 * id_dep1,id_dep2,.....
 * 这个内容最终应调整到BD资源模块中
 */
public class GetDeptsStr8DepWardRelBlTpBP {
	/**
	 * 根据科室与病区关系业务线类型获得病区或科室对应的部门主键串
	 * @param id_org
	 * @param id_ward
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_org,String id_dep_src,FBoolean isward)  throws BizException{
		//根据业务线概念获得病区对应的科室主键集合信息
		String[] id_deps=getDeptIDsOfWard8BizLine(id_org,id_dep_src,isward);
		
		//获得科室主键串
		return CiOrdUtils.aryToString(id_deps);
	}
	
	/**
	 * 根据业务线概念获得病区对应的科室主键集合信息
	 * @param id_org
	 * @param id_ward
	 * @return
	 * @throws BizException
	 */
	private String[] getDeptIDsOfWard8BizLine(String id_org,String id_ward,FBoolean isward) throws BizException{
		GetDeptIDs8DepWardRelBlTpBP bp=new GetDeptIDs8DepWardRelBlTpBP();
		return bp.exec(id_org, id_ward,isward);
	}
}
