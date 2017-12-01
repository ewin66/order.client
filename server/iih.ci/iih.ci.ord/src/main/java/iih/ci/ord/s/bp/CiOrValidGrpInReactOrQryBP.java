package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICiOrValidateConst;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;

/*
 * 获得临床在执行的组内排斥有效长期医嘱数据信息操作BP
 * （组内排斥医嘱时，需要停止的组内排斥有效医嘱的查询）
 */
public class CiOrValidGrpInReactOrQryBP {
	/**
	 * 获得临床在执行的组内排斥有效长期医嘱数据信息（组内排斥停止医嘱用）
	 * @param id_en  就诊id
	 * @param id_srvreacts  排斥组串
	 * @param dt_cur   排斥发生时间
	 * @return
	 * @throws BizException
	 */
	public CiOrderDO[] exec(String id_en,String id_srvreacts,FDateTime dt_cur) throws BizException{
		//有效性校验
		if (CiOrdUtils.isEmpty(id_en) || CiOrdUtils.isEmpty(id_srvreacts)
				|| CiOrdUtils.isEmpty(id_srvreacts))
			return null;
		
		//获得有效医嘱id数组
		String sql=getSQLStr(id_en,id_srvreacts,dt_cur);
		String[] id_ors=CiOrdUtils.getSingleFldValues(sql);
		if(CiOrdUtils.isEmpty(id_ors))return null;
		
		//获得有效医嘱
		return CiOrdAppUtils.getCiorderMDORService().findByBIds(id_ors, FBoolean.FALSE);
	} 
	
	/**
	 * 获得有效医嘱关联的sql串
	 */
	private String getSQLStr(String id_en,String id_srvreacts,FDateTime dt_cur){
		String sqlformatstr=ICiOrValidateConst.GET_ORIDS_4VALIDGRPIN_SQLSTR;
		String curdtstr=OrSrvSplitUtil.getFDateTimeStdStr(dt_cur);
		String reactids=CiOrdUtils.getSqlInStrsWithOutIn2(id_srvreacts);
		return String.format(sqlformatstr,id_en,curdtstr,curdtstr,reactids);
		
	}
}
