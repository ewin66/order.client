package iih.ci.ord.s.bp.base.bizline;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;

/**
 * 业务线助手类
 */
public class BizLineHelper {
	//获得科室对应的病区SQL串  根据科室与病区关系业务线类型及角色
	public static final String GetRelWards_ByDept_4DWRBl_SQLFormat=" select CC.id_dep from BD_DEPL_DEP CC where CC.id_depl in (select AA.id_depl from bd_depl AA inner join bd_depl_dep BB on AA.ID_DEPL=BB.ID_DEPL " 
					+" where AA.ID_ORG='%s' and AA.Id_Deptltp='"+ISysDictCodeConst.ID_DEPTLTP_DEPWARDREL+"' and BB.Id_Dep='%s') and CC.sd_deplrole='%s' ";
   
	/**
	 *  科室与病区关系业务线类型时,
	 *  获得病区或科室角色对应的编码值
	 * @param issrcward
	 * @return
	 */
	public static String getSdDeptRole4DeptWardRel(FBoolean issrcward){
	   if(CiOrdUtils.isTrue(issrcward))return ISysDictCodeConst.SD_DEPLROLE_DEPRELWARD_WARD;
	   return ISysDictCodeConst.SD_DEPLROLE_DEPRELWARD_DEP;
	}
	
	/**
	 *  科室与病区关系业务线类型时,
	 *  获得病区或科室角色对应的Sql串片段
	 * @param id_org
	 * @param id_dep_src
	 * @param issrcward
	 * @return
	 */
	public static String getSqlPart4DeptWardRel(String id_org,String id_dep_src,FBoolean issrcward){
		String sql=String.format(BizLineHelper.GetRelWards_ByDept_4DWRBl_SQLFormat, 
				id_org,id_dep_src,BizLineHelper.getSdDeptRole4DeptWardRel(issrcward));
		return sql;
	}
	
	/**
	 * 是否在相同就诊科室内部进行病区的转移判断
	 * 大科室小病区管理时，转病区业务在同一科室内进行的业务判断
	 * @param id_org
	 * @param id_dep_or
	 * @param id_ward_from
	 * @param id_ward_to
	 * @return
	 * @throws BizException 
	 */
	public static FBoolean isTransWardWithinUniDept(String id_org,String id_dep_or,String id_ward_from,String id_ward_to) throws BizException{
		IsTransWardWithinUniDeptBP bp=new IsTransWardWithinUniDeptBP();
		return bp.exec(id_org, id_dep_or, id_ward_from,id_ward_to);
	}

	
	
}
