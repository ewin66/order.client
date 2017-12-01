package iih.ci.ord.s.bp.orsrvsplit;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/***
 * 医嘱或服务拆分截止时间有效性校验操作BP
 *
 */
public class DtSplitEndValidateBP {
	/***
	 * 医嘱或服务拆分入口参数校验
	 * @param dt_split_end
	 * @throws BizException
	 */
	public void exec(FDateTime dt_split_end)  throws BizException{
		//获得当前时间
		FDateTime srvTime=OrSrvSplitUtil.getServerDateTime();
		
		//获得截止时间有效天数参数值d ParamsetQryUtil
		String orgid=Context.get().getOrgId();
		//2015/12/15 ly修改
		Integer days = null;
		try {
			days = ParamsetQryUtil.getParaInt(orgid, ICiOrdNSysParamConst.SYS_PARAM_ORSRVSPLITDTENDMAXALLOWDAYS);
		} catch (Exception e) {
			Logger.info(e.getMessage());
		}
		
		if(days==null || days<=0)days = 10;
		//截止时间大于（当前时间+d）则抛出错误
		int d1=dt_split_end.getDaysAfter(srvTime);
		if(d1>days){
			throw new BizException("医嘱或服务拆分时，截止时间不能大于截止的时间参数设置值！");
		}
	}
}
