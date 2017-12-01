package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 获得医疗单Ems服务项目对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 */
public class GetExeDepts8EmsSrvBatchBP {
	/**
	 * 获得医疗单Ems服务项目对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * @param ems
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptParamDTO[] exec(CiEmsDTO ems,FDateTime dt_effe)  throws BizException{
		//有效性校验
		if(!validateCheck(ems,dt_effe))return null;
		
		//根据EMS获得医嘱流向执行科室入口参数
		OrWfExDeptParamDTO[] paramdtos=getOrWfExDeptParams8Ems(ems,dt_effe);
		
		//获得服务项目对应的执行科室
		OrWfExDeptParamDTO[] exedepdtos=getExeDepts4CiOrSrvsBatch(paramdtos);
		
		//返回值
		return exedepdtos; 
	}
	
	/**
	 * 有效性校验
	 * @param ems
	 * @param index
	 * @param dt_effe
	 * @return
	 * @throws BizException 
	 */
	private boolean validateCheck(CiEmsDTO ems,FDateTime dt_effe){
		//有效性校验
		if(CiOrdUtils.isEmpty(ems) || CiOrdUtils.isEmpty(ems.getEmssrvs()))return false;
		
		//返回值
		return true;
	}
	
	/**
	 * 根据EMS获得医嘱流向执行科室入口参数
	 * @param ems
	 * @param index
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] getOrWfExDeptParams8Ems(CiEmsDTO ems,FDateTime dt_effe) throws BizException{
		GetOrWfExDeptParams8EmsBP bp=new GetOrWfExDeptParams8EmsBP();
		return bp.exec(ems, dt_effe);
	}

	/**
	 * 获得服务项目对应的执行科室
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] getExeDepts4CiOrSrvsBatch(OrWfExDeptParamDTO[] params) throws BizException{
		GetExeDepts4CiOrSrvsBatchBP bp=new GetExeDepts4CiOrSrvsBatchBP();
		return bp.exec(params);
	}
}
