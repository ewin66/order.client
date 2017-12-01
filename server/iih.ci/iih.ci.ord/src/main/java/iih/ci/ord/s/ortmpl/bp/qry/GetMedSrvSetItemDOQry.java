package iih.ci.ord.s.ortmpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医疗服务
 * @author Young
 *
 */
public class GetMedSrvSetItemDOQry implements ITransQry {

	private String _id_srv_set = "";
	public GetMedSrvSetItemDOQry(String id_srv_set){
		_id_srv_set = id_srv_set;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return "select DEF.*,SRV.name srv_name from bd_srvset_def DEF,bd_srv SRV where "
        +" DEF.id_srv_itm=SRV.id_srv and DEF.fg_clinical='Y' and DEF.id_srv in ("+_id_srv_set+")";
	}

}
