package iih.ci.ord.s.bp.skintest;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获得有效皮试医嘱数据信息查询
 */
public class GetPiValidSkinTestOrQry implements ITransQry {
	private String _id_pi;
	private String _id_skinsrv;
	private FDateTime[] _dt_section; 
	
	/**
	 * 构造函数
	 * @param id_pi
	 * @param id_skinsrv
	 * @param dt_section
	 */
	public GetPiValidSkinTestOrQry(String id_pi,String id_skinsrv,FDateTime[] dt_section){
		_id_pi=id_pi;
		_id_skinsrv=id_skinsrv;
		_dt_section=dt_section; 
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(_id_pi);
		sqlParam.addParam(_dt_section[0]);
		sqlParam.addParam(_dt_section[1]);
		sqlParam.addParam(_id_skinsrv);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return " select A.id_or,A.Id_srv,C.Sd_Rst_Skintest,C.dt_create as dt_act from ci_order A "
              +" left outer join ci_skin_test C ON A.id_or=C.Id_Or "
              +" where A.Id_Pat=? and A.Sd_Srvtp = '"+IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST+"'  And A.Fg_Canc='N' "
              +" and A.dt_effe>=? and A.Dt_Effe<=? "
              +" and A.Id_Srv=? and A.Sd_Su_Mp not in ('21','22') and A.fg_canc='N' order by A.Dt_Effe desc";
              //+" and A.Id_Srv=? and A.Sd_Su_Mp in ('0','1') order by A.Dt_Effe desc";
	}

}
