/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: GetPresNameQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年12月16日 上午11:51:28
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetPresNameQry implements ITransQry {
    
	public String id_orsrv ="";
	public GetPresNameQry(String[] id_orsrvs){
		id_orsrv = CiOrdUtils.IdsConveretCharacterString(id_orsrvs);
	}
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		return param;
	}

	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQrySQLStr()
	 */
	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
   
	 private String getSql(){
		 String sql = "";
		 if(id_orsrv != null && id_orsrv !=""){
		 sql =   " select orsrv.id_orsrv, bd_udidoc.name as name  from ci_or_srv  orsrv, ci_pres cipres   ,bd_udidoc "+ 
				 " where orsrv.id_pres !='~' "+
				 " and orsrv.id_pres = cipres.id_pres "+
				 " and  bd_udidoc.id_udidoc = cipres.id_prestp "+
				 " and  orsrv.id_orsrv in ("+this.id_orsrv+") "+ 
				 " union all "+
				 " select orsrv.id_orsrv,  ciorder.name_or as name　from ci_or_srv orsrv,ci_order ciorder  "+
				 "  where id_orsrv in ("+this.id_orsrv+")  and orsrv.id_pres ='~' "+
				 " and ciorder.id_or= orsrv.id_or  ";
		 }
		 return sql;
	 }
}
