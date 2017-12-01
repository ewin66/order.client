package iih.ci.ord.s.bp.skintest;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 需皮试用药的药品存在有效的已执行用药记录查询
 */
public class ExistValidIsNeedSkinExOrQry implements ITransQry {
	private String _id_pi;
	private String _id_srv;
	private String _id_mm;
	private FDateTime[] _dt_section; 
	
	/**
	 * 构造函数
	 * @param id_pi
	 * @param id_skinsrv
	 * @param dt_section
	 */
	public ExistValidIsNeedSkinExOrQry(String id_pi,String id_srv,String id_mm,FDateTime[] dt_section){
		_id_pi=id_pi;
		_id_srv=id_srv;
		_id_mm=id_mm;
		_dt_section=dt_section; 
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(_id_pi);
		sqlParam.addParam(_id_srv);
		sqlParam.addParam(_id_mm);
		sqlParam.addParam(_dt_section[0]);
		sqlParam.addParam(_dt_section[1]);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "A");
		return " select B.Id_Srv as id_biz,count(*) as cnt from ci_order A "
              +" inner join ci_or_srv B ON A.Id_Or=B.Id_Or "
              +" left outer join ci_or_srv_mm C ON B.Id_Orsrv=C.Id_Orsrv "
              +" where A.Id_Pat=? and B.Fg_Skintest='Y' and B.Id_Srv=? and C.ID_MM=? "
              //+" where A.Id_Pat=? and A.Fg_Skintest='Y' and B.Fg_Skintest='Y' and B.Id_Srv=? and C.ID_MM=? "
              +" and B.Dt_Last_Mp>=? and B.Dt_Last_Mp<=? and ( A.Sd_Su_Mp = '1' or A.Sd_Su_Mp='20') "
              + " and "+  orgsql   
              +" group by B.id_srv ";
	}

}
