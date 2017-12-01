/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getMedSrvDOBysetId
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年11月11日 下午2:53:47
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetMedSrvAllItemDOBP extends GetMedSrvItemDOBP{
    
	private String _id_srv_set = "";
	public GetMedSrvAllItemDOBP(String id_srv_set){
		_id_srv_set =  id_srv_set;
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
   
	protected String getSql(){
		return "    "
				+ "  select def.*,bdsrv.name Srv_name from bd_srvset_def def ,bd_srv bdsrv where "
                +"   def.id_srv_itm = bdsrv.id_srv  and   def.fg_active='Y' and   def.id_srv = '"+_id_srv_set+"'";
	}
}
