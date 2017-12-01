package iih.ci.ord.s.bp.iemsg.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.ICiIEMsgRelSqlConst;
import xap.mw.core.data.BizException;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取住院的检查、病理医嘱信息
 *
 */
public class CiRisOrQry implements ITransQry {

	private String _id_ors;
	
	public CiRisOrQry(String id_ors){
		this._id_ors = id_ors;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		try {
			return getSql();
		} catch (BizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 * @throws BizException 
	 */
	 private String getSql() throws BizException {
		 
		 String[] idors=_id_ors.split(CiOrdUtils.COMMA_STR);
		 String str_idor_ris="";// 检查id_or字符串集合
		 String str_idor_path="";// 病理id_or 字符串集合
		 for(String idor:idors){
			 String sdtp=CiOrdUtils.GetSrvtpByID(idor);
			 if(sdtp.equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI))
				 str_idor_path+=idor+",";
			 else
				 str_idor_ris+=idor+",";
		 }
		 
		 String formatsql="";
		 if(str_idor_path.length()>0){
			 formatsql+=String.format(ICiIEMsgRelSqlConst.CI_IE_APPPATH_ALL_SQL, "A.id_or"+CiOrdUtils.getSqlInOrEqualStrs(str_idor_path.substring(0, str_idor_path.length()-1)));
		 }
		 if(str_idor_ris.length()>0){
			 if(formatsql.length()>0)
				 formatsql+=" Union All ";
			 formatsql+=String.format(ICiIEMsgRelSqlConst.CI_IE_APPRIS_ALL_SQL, "A.id_or"+CiOrdUtils.getSqlInOrEqualStrs(str_idor_ris.substring(0, str_idor_ris.length()-1)));
		 }
		 
		 return formatsql;
	 }

}
