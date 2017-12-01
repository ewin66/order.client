package iih.ci.ord.s.bp.splitlis;

import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitpres.CiOr2CiOrPresSplitListBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitOrFilterHandleBP;
import iih.ci.ord.s.bp.splitpres.CiOrPresSplitRuleArrangeExeBP;
import iih.ci.ord.splitlis.d.CiOrdLisSplitList;

import java.util.List;

import xap.mw.core.data.BizException;

public class CiOrLisSplitHandleBP {
	
	public List<CiOrdLisSplitList> exec(CiOrderDO[] ciors,CiOrSessionDO session)throws BizException{
		
		ciors=orLisSplitOrFilterHandle(ciors);
		if(CiOrdUtils.isEmpty(ciors))return null;
		
		List<CiOrdLisSplitList> orpressplitlists=convertCiOr2CiOrLisSplitList(ciors);		
		//合单规则编排
		orpressplitlists=ciOrLisSplitRuleArrangePluginExec(orpressplitlists);
		
		return null;
	}
	
	
	/**
	 * 临床医嘱分方时，分方医嘱过滤与处理
	 * @param ciorder
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] orLisSplitOrFilterHandle(CiOrderDO[] ciorder) throws BizException{
		CiOrLisSplitOrFilterHandleBP bp=new CiOrLisSplitOrFilterHandleBP();
		return bp.exec(ciorder);
	}
	
	private List<CiOrdLisSplitList> convertCiOr2CiOrLisSplitList(CiOrderDO[] ciors)throws BizException {
		CiOr2CiOrLisSplitListBP bp=new CiOr2CiOrLisSplitListBP();
		return bp.exec(ciors);
	}
	
	private List<CiOrdLisSplitList> ciOrLisSplitRuleArrangePluginExec(List<CiOrdLisSplitList> orpressplitlists) throws BizException{
		CiOrLisSplitRuleArrangeExeBP bp=new CiOrLisSplitRuleArrangeExeBP();
		return bp.exec(orpressplitlists);
	}
	

}
