/**
 * 
 */
package iih.ci.ord.s.bp.qry;

import iih.ci.ord.dto.cporderstatusdto.d.CpOrderStatusDto;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @ClassName: getCpOrderStatusDtoQry
 * @Description: TODO
 * @author Comsys-li_zheng
 * @date 2016年3月10日 上午11:12:18
 * @Package iih.ci.ord.s.bp.qry
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class GetCpOrderStatusDtoQry implements ITransQry {

	
	 private String _id_en;
	 private String _code_srv;
	 private FDateTime _bdgin;
	 private FDateTime  _end;
	 private FBoolean _fg_pres_outp;
	 
	 public GetCpOrderStatusDtoQry(CpOrderStatusDto cpOrderStatus){
		 
		 this._id_en = cpOrderStatus.getId_en();
		 this._code_srv = cpOrderStatus.getCode_srv();
		 this._bdgin = cpOrderStatus.getDt_begin();
		 this._end = cpOrderStatus.getDt_end();
		 this._fg_pres_outp = cpOrderStatus.getFg_pres_outp();
	 }
	
	/* (non-Javadoc)
	 * @see xap.sys.appfw.orm.utils.ITransQry#getQryParameter(java.lang.StringBuffer)
	 */
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
		sqlparam.addParam(this._fg_pres_outp);
		sqlparam.addParam(this._code_srv);
		return sqlparam;
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
		 
		 StringBuffer bp = new StringBuffer();
		 bp.append(" select  ciorder.* from ci_order  ciorder ,  ");
		 bp.append("   ci_or_srv  srv  ");
		 bp.append(" where ciorder.id_or = srv.id_or  ");
		 bp.append(" and  ciorder.id_en = ? ");
		 bp.append(" and  ciorder.fg_pres_outp = ? ");
		 bp.append(" and  srv.code_srv = ? ");
		 if(this._bdgin != null  ){
			 bp.append("  and   ciorder.dt_effe >= '"+this._bdgin+"' ");
		 }
		 if(this._end != null  ){
			 bp.append("  and   ciorder.dt_effe <= '"+this._end+"' ");
		 }
		 bp.append("  order by ciorder.sd_su_or , ciorder.sd_su_mp  ");
         return bp.toString();
	 }
}
