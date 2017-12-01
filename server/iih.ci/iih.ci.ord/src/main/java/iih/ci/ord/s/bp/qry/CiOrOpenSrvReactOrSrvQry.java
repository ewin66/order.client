package iih.ci.ord.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.pub.CiOrdUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOrOpenSrvReactOrSrvQry implements ITransQry {
	private String _id_pi;
	private String _id_pv;
	private String _id_or;
	private String _id_srvreacts;
	
	public CiOrOpenSrvReactOrSrvQry(String id_pi,String id_pv,String id_or,String id_srvreacts){
		_id_pi=id_pi;
		_id_pv=id_pv;
		_id_or=id_or;
		_id_srvreacts=id_srvreacts;
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam  sqlParam = new SqlParam();
		sqlParam.addParam(_id_pi);
		sqlParam.addParam(_id_pv);
		if(!CiOrdUtils.isEmpty(_id_or)){sqlParam.addParam(_id_or);}
		if(!CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR, this._id_srvreacts)){sqlParam.addParam(_id_srvreacts);}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		return " select distinct A.id_or,A.Dt_Effe,A.Dt_End,B.Sd_Su_Mp,B.Id_Srv,B.Name as name_srv,A.Content_Or "
              +" from ci_order A "
              +" inner join ci_or_srv B on A.id_or=B.Id_Or "
              +" where A.Id_Pat=? and A.id_en=? "+getCond_IdOr()
              +"and A.ds=0  and a.sd_su_or !='60' and (A.Fg_Canc='N' and A.Fg_stop='N'  and B.Sd_Su_Mp='"+ICiDictCodeConst.SD_SU_MP_NONE+"') "   // or B.Sd_Su_Mp='1'  已执行的存在时  肯定可开新医嘱（原互斥执行医嘱护士逻辑执行完之后执行新医嘱！！）
              +" and B.Id_Srv in (select id_srv from  bd_srv_react_itm where "+getCond_IdSrvReact()+") ";
	}
	
	/**
	 * 获得医嘱条件串
	 * @return
	 */
	private String getCond_IdOr(){
		if(CiOrdUtils.isEmpty(_id_or))return "";
		return " and A.Id_Or!=? ";
	}
	
	/**
	 * 获得互斥条件串
	 * @return
	 */
	private String getCond_IdSrvReact(){
		if(CiOrdUtils.isInStr(CiOrdUtils.COMMA_STR, this._id_srvreacts)){
			String id_srvreacts=CiOrdUtils.SQUOTE_MARK_STR+_id_srvreacts.replaceAll(CiOrdUtils.COMMA_STR, CiOrdUtils.SQUOTE_MARK_STR+CiOrdUtils.COMMA_STR+CiOrdUtils.SQUOTE_MARK_STR)+CiOrdUtils.SQUOTE_MARK_STR;
			return "  id_srvreact in "+CiOrdUtils.LBRACE_STR+id_srvreacts+CiOrdUtils.RBRACE_STR;
		}else{
			return " id_srvreact=? ";
		}
	}

}
