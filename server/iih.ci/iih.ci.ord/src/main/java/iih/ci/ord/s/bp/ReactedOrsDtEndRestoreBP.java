package iih.ci.ord.s.bp;

import iih.ci.ord.cior.d.CiOrReactLogDO;
import iih.ci.ord.cior.d.desc.CiOrReactLogDODesc;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.appfw.orm.utils.AuditInfoUtil;
/*
 * 被排斥医嘱截止时间数据信息还原操作BP
 */
public class ReactedOrsDtEndRestoreBP {
	/**
	 * 被排斥医嘱截止时间数据信息还原
	 * @param id_en
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(CiOrReactLogDO[] reactorlogs) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(reactorlogs))return null;
		
		//获得被排斥的医嘱数据信息
		String whereStr = CiOrderDODesc.TABLE_ALIAS_NAME + ".id_or in ("
				+ getSqlStr(reactorlogs) + ")";
		CiOrderDO[] ordos = CiOrdAppUtils.getCiorderMDORService().find(
				whereStr, "", FBoolean.FALSE);
		
		//遍历  更新医嘱数据信息
		for(int i=0;i<ordos.length;i++){
			ordos[i].setDt_end(reactorlogs[i].getDt_end_orreact());
			AuditInfoUtil.updateData(ordos[i]);
			ordos[i].setStatus(DOStatus.UPDATED);
		}
		
		//更新
		return CiOrdAppUtils.getOrService().update(ordos);
	
	}
	
	/**
	 * 获得条件sql串
	 * @param id_ors
	 * @return
	 */
	private String getSqlStr(CiOrReactLogDO[] reactorlogs){
		String rtn=CiOrdUtils.aryToString(reactorlogs,CiOrReactLogDO.ID_OR_REACT);
		rtn = rtn.replaceAll(CiOrdUtils.COMMA_STR, CiOrdUtils.SQUOTE_MARK_STR
				+ CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR);
		return CiOrdUtils.SQUOTE_MARK_STR+rtn+CiOrdUtils.SQUOTE_MARK_STR;
	}
	
}
