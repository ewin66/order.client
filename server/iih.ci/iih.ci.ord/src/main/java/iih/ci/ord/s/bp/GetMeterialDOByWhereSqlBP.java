package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.mm.meterial.d.MeterialDO;
import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.cior.d.desc.CiOrReactLogDODesc;
import iih.ci.ord.ciordems.d.EmsOrDrug;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.qry.CiorderDrugQry;
import iih.ci.ord.s.bp.qry.GetMeterialDOByWhereSqlQry;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
/**
 * 根据传入的sql语句查询出物品
 * @author Administrator
 *
 */
public class GetMeterialDOByWhereSqlBP {
	public MeterialDO[] exec(String whereSql) throws BizException{
		GetMeterialDOByWhereSqlQry qry=new GetMeterialDOByWhereSqlQry(whereSql);
		DAFacade cade = new DAFacade();
		List<MeterialDO> mm = (List<MeterialDO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(MeterialDO.class));
		if(CiOrdUtils.isEmpty(mm)||mm.size()==0)return null;
		MeterialDO[] arr = mm.toArray(new MeterialDO[mm.size()]);
		return arr;
	}
	
	/**
	 * 获得条件sql串
	 * @param id_ors
	 * @return
	 */
	private String getSqlStr(String[] id_ors){
		String rtn=CiOrdUtils.aryToString(id_ors);
		rtn = rtn.replaceAll(CiOrdUtils.COMMA_STR, CiOrdUtils.SQUOTE_MARK_STR
				+ CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR);
		return CiOrdUtils.SQUOTE_MARK_STR+rtn+CiOrdUtils.SQUOTE_MARK_STR;
	}
	
}
