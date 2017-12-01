package iih.ci.ord.s.bp.srvref;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitDO;
import iih.bd.srv.deptsrvlimit.d.DeptSrvLimitItemDO;
import iih.bd.srv.deptsrvlimit.d.DeptsrvlimitAggDO;
import iih.bd.srv.deptsrvlimit.d.desc.DeptSrvLimitDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.DeptSrvLimitBWMixedException;

/**
 * 获得部门服务限制明细数据对应sql字串操作BP
 */
public class GetDeptSrvLimitSQLStrBP {
	/**
	 * 获得部门服务限制明细数据对应sql字串
	 * @param id_dept
	 * @return
	 * @throws BizException 
	 */
	public String exec(String id_dept) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_dept))return null;
		
		//获得部门服务限制数据信息
		DeptsrvlimitAggDO depsrvlimitagg=getDeptsrvlimitInfo(id_dept);
		if(depsrvlimitagg==null)return null;		
		
		//返回限制sql串片段
		return getDeptLimitStr(depsrvlimitagg);
	}
	
	/**
	 * 获得部门服务限制数据信息
	 * @param id_dept
	 * @return
	 * @throws BizException
	 */
	private DeptsrvlimitAggDO getDeptsrvlimitInfo(String id_dept) throws BizException{
		String whereStr=DeptSrvLimitDODesc.TABLE_ALIAS_NAME+"."+DeptSrvLimitDO.ID_DEP+"='"+id_dept+"'";
		DeptsrvlimitAggDO[] aggs=CiOrdAppUtils.getDeptSrvLimitQryService().find(whereStr, "", FBoolean.FALSE);
		if(CiOrdUtils.isEmpty(aggs))return null;
		if(aggs.length>1)throw new DeptSrvLimitBWMixedException();
		return aggs[0];
	}
	
	/**
	 * 获得部门服务限制sql串片段
	 * @param depsrvlimitagg
	 * @return
	 */
	private String getDeptLimitStr(DeptsrvlimitAggDO depsrvlimitagg){
		DeptSrvLimitDO limitdo=depsrvlimitagg.getParentDO();
		DeptSrvLimitItemDO[] limititems=depsrvlimitagg.getDeptSrvLimitItemDO();
		if(limitdo==null || limititems==null || limititems.length==0)return "";
	
		return SrvRefUtils.getDeptSrvLimitSQLStr(limititems, limitdo.getFg_black());
	}
}
