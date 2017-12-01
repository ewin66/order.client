package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 获得临床医嘱服务项目对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 * 返回科室集合实体
 */
public class GetExeDepts4CiOrSrvNBP {
	/**
	 * 获得临床医嘱服务项目对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * @return
	 * @throws BizException
	 */
	public  OrWfDeptInfoDTO exec(OrWfExDeptParamDTO param)  throws BizException{
		//获得临床医嘱服务项目对应的执行科室列表
		OrWfExDeptDTO[] orwfexdeptdtos=GetExeDepts4CiOrSrvBP(param);
		
		//返回病区或就诊科室
		return CiOrdUtils.getOrWfDeptInfo(orwfexdeptdtos);
	}
	
	/**
	 * 获得临床医嘱服务项目对应的执行科室列表
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptDTO[] GetExeDepts4CiOrSrvBP(OrWfExDeptParamDTO param) throws BizException{
		GetExeDepts4CiOrSrvBP bp=new GetExeDepts4CiOrSrvBP();
		return bp.exec(param);
	}
	

}
