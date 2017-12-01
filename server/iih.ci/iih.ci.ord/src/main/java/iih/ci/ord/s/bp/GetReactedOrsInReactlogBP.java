package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.cior.d.desc.CiOrReactLogDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
/*
 * 获得排斥日志中获得被排斥医嘱数据信息操作BP
 */
public class GetReactedOrsInReactlogBP {
	/**
	 * 获得排斥日志中获得被排斥医嘱数据信息
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public CiOrReactLogDO[] exec(String[] id_ors) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得最近一次会话数据信息
		String whereStr=CiOrReactLogDODesc.TABLE_ALIAS_NAME+".id_or in ("+getSqlStr(id_ors)+")";
		CiOrReactLogDO[] reactorlogs = CiOrdAppUtils.getOrreactlogQryService()
				.find(whereStr, "", FBoolean.FALSE);
		
		//返回
		return reactorlogs;
		
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
