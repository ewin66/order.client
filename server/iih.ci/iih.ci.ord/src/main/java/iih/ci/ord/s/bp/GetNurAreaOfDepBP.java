package iih.ci.ord.s.bp;

import iih.ci.ord.dto.ordpres.d.OrdPresDTO;
import iih.ci.ord.dto.ordpres.d.PresDrugDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.GetNurAreaOfDepQry;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获得科室下的病区id串
 * 
 */
public class GetNurAreaOfDepBP {
	/**
	 * 获得科室下的病区id串
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	public String exec(String id_dep) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_dep))return null;
		
		GetNurAreaOfDepQry qry = new GetNurAreaOfDepQry(id_dep);
		
		DeptDO[] ordpreses = (DeptDO[])AppFwUtil.getDORstWithDao(qry, DeptDO.class);
		if(CiOrdUtils.isEmpty(ordpreses))return null;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<ordpreses.length;i++){//遍历
			sb.append(CiOrdUtils.SQUOTE_MARK_STR+ordpreses[i].getId_dep()+CiOrdUtils.SQUOTE_MARK_STR);
			if(ordpreses.length-1!=i){
				sb.append(CiOrdUtils.COMMA_STR);
			}
		}
		
		return sb.toString();	
	}
}
