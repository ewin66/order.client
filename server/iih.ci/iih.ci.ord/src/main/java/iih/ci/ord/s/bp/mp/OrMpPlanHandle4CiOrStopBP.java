package iih.ci.ord.s.bp.mp;


import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.mp.nr.splitplan.i.IResponseOrderHandelService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;


/**
 * 临床医嘱停止时，医嘱执行计划相关数据信息处理操作BP
 * (医嘱停止时：拆分数据的反向处理逻辑)
 * @author li_cheng
 *
 */
public class OrMpPlanHandle4CiOrStopBP {
	/**
	 * 临床医嘱停止时，医嘱执行计划相关数据信息处理
	 * (医嘱停止时：拆分数据的反向处理逻辑)
	 * @param needstopors
	 * @param dt_end
	 * @throws BizException
	 */
	public void exec(CiOrderDO[] needstopors,FDateTime dt_end_max) throws BizException{
		IResponseOrderHandelService responseOrderHandelService=ServiceFinder.find(IResponseOrderHandelService.class);
		String[] idors=new String[needstopors.length];
		int i=0;		
		for (CiOrderDO ciOrderDO : needstopors) {
			idors[i]=ciOrderDO.getId_or();
			i++;
		}
		responseOrderHandelService.responseOrStop(idors);
	}
}
