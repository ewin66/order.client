package iih.ci.ord.s.bp.ems;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import iih.ci.ord.s.bp.orsrvsplit.OrSrvSplitUtil;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 临床医嘱过期时间处理逻辑操作BP
 */
public class CiOrInvalidDtHandleBP {
	/**
	 *  临床医嘱过期时间处理逻辑操
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public  FDateTime exec(CiEmsDTO ems)  throws BizException{
		if(ems==null)return null;
		String sd_entp=ems.getCode_entp();
		Integer hours=null;
	
		if(CiOrdUtils.isIpWf(sd_entp)){//住院临备医嘱
			if(OrSrvSplitUtil.isTrue(ems.getFg_pmor()) && !OrSrvSplitUtil.isTrue(ems.getFg_long())){
				//return ems.getDt_invalid();   2016-09-18 注释掉该代码    增加上述两行代码
				if(CiOrdUtils.isEmpty(ems.getDt_invalid())){
				hours=ParamsetQryUtil.getParaInt(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_TemporaryPrnOrValidTime);
				return DateUtils.getDateTimeAfter(ems.getDt_begin(),hours);
				}else{
					return ems.getDt_invalid(); 
				}
			}else{
				return ems.getDt_end();
			}
		}else if(CiOrdUtils.isOpUrgentWf(sd_entp)){
			try{
				// 2016-09-18  打开该代码注释 
				hours=ParamsetQryUtil.getParaInt(CiOrdAppUtils.getEnvContext().getOrgId(), ICiOrdNSysParamConst.SYS_PARAM_OpOrValidTime);
				//Integer hours = 12;//临时使用   2016-09-18   注释掉该逻辑  使用上面的参数获得  
				if(hours<=0)hours=24;
				return DateUtils.getDateTimeAfter(ems.getDt_begin(),hours);
			}catch(Exception ex){
				//若参数不存在，不给该字段赋值
			}
		}
		
		return null;
	}
	
}
