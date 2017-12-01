package iih.ci.ord.s.bp.validate;

import iih.bd.srv.mutex.d.SrvReactDTO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.ICiOrValidateConst;
import xap.mw.core.data.BizException;

/*
 * 临床医嘱签署时，获得服务互斥信息数据操作BP
 */
public class CiOrSignOrSrvReactInfoGetBP {
	/**
	 * 临床医嘱签署时，获得服务互斥信息数据
	 * @param aggors
	 * @throws BizException
	 */
	public SrvReactDTO[] exec(CiorderAggDO[] aggors) throws BizException{
		//有效性校验
		if(aggors==null || aggors.length==0)return null;
		
		//获得医嘱集合中医嘱服务项目的互斥服务集合
		String srvcondstr=getSrv4OrCondStr(aggors);
		if(CiOrdUtils.isEmpty(srvcondstr))return null;
		
		//返回
		return CiOrdAppUtils.getBdSrvQryQryService().getSrvReactInfos(srvcondstr);
	}
	
	/**
	 * 获得医嘱id串
	 * @param aggors
	 * @return
	 * @throws BizException 
	 */
	private String getOrIds(CiorderAggDO[] aggors) throws BizException{
		String rtnstr = "";
		CiOrderDO ordo = null;

		for (int i = 0; i < aggors.length; i++) {
			ordo = aggors[i].getParentDO();
			if (isTransWardWithinUniDept(ordo))
				continue; //2016-07-25 新增该业务逻辑  判断转科医嘱为同一就诊科室下的转病区
			rtnstr += CiOrdUtils.COMMA_STR + CiOrdUtils.SQUOTE_MARK_STR + ordo.getId_or() + CiOrdUtils.SQUOTE_MARK_STR;
		}
		if (CiOrdUtils.isEmpty(rtnstr))
			return null;
		return rtnstr.substring(1);
	}
	
	/**
	 * 获得医嘱列表中所含医疗服务条件串
	 * @param aggors
	 * @return
	 * @throws BizException 
	 */
	private String getSrv4OrCondStr(CiorderAggDO[] aggors) throws BizException{
		String oridinstr=getOrIds(aggors);
		String rtn=String.format(ICiOrValidateConst.GET_ORSRV_IDS_SQLSTR,oridinstr);
		return rtn;
	}
	
	/**
	 * 是否是同一就诊科室下转病区医嘱判断
	 * @param ordo
	 * @return
	 * @throws BizException
	 */
	private boolean isTransWardWithinUniDept(CiOrderDO ordo) throws BizException{
		IsTransWardWithinUniDeptBP bp=new IsTransWardWithinUniDeptBP();
		return bp.exec(ordo).booleanValue();
	}

	
}
