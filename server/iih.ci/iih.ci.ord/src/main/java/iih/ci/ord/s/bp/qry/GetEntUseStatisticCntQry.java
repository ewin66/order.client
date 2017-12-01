package iih.ci.ord.s.bp.qry;

import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 实体使用个数数量统计查询串
 */
public class GetEntUseStatisticCntQry implements ITransQry {
	private String _ids;
	private String _tbl;
	private String _keyfld;
	private String _condfld;
	
	/**
	 * 构造函数
	 * @param ids
	 */
	public GetEntUseStatisticCntQry(String ids,String tbl,String keyfld,String condfld){
		_ids=ids;
		_tbl=tbl;
		_keyfld=keyfld;
		_condfld=condfld;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam rtnParam=new SqlParam();
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		
		return "select "+_keyfld+" as id_biz,count(*) as cnt from "+_tbl+" "
			  +" where "+_condfld+" "+getCondStr()+" group by "+_keyfld;
	}
	
	/**
	 * 获得条件串片段
	 * @return
	 */
	private String getCondStr(){
		return CiOrdUtils.getCondStrWithEqualOrIn(_ids);
	}

}
