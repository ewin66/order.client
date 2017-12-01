package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 根据执行科室计算参数数据信息获得对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 */
public class GetExeDepts8DepCalParamBatchBP {
	/**
	 * 根据执行科室计算参数数据信息获得对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * @param calparamdtos
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptParamDTO[] exec(ExeDeptCalParamDTO[] calparamdtos)  throws BizException{
		//有效性校验
		if(!validateCheck(calparamdtos))return null;
		
		//获得医嘱流向执行科室入口参数数组集合
		OrWfExDeptParamDTO[] paramdtos=getOrWfExDeptParams(calparamdtos);
		
		//获得服务项目对应的执行科室
		OrWfExDeptParamDTO[] exedepdtos=getExeDepts(paramdtos);
		
		//返回值
		return exedepdtos; 
	}
	
	/**
	 * 有效性校验
	 * @param calparamdtos
	 * @return
	 * @throws BizException 
	 */
	private boolean validateCheck(ExeDeptCalParamDTO[] calparamdtos){
		//有效性校验
		if(CiOrdUtils.isEmpty(calparamdtos))return false;
		
		//返回值
		return true;
	}
	
	/**
	 * 获得医嘱流向执行科室入口参数数组集合
	 * @param ems
	 * @param index
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] getOrWfExDeptParams(ExeDeptCalParamDTO[] calparamdtos) throws BizException{
		GetOrWfExDeptParamBatchBP bp=new GetOrWfExDeptParamBatchBP();
		return bp.exec(calparamdtos);
	}

	/**
	 * 获得服务项目对应的执行科室数组集合
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptParamDTO[] getExeDepts(OrWfExDeptParamDTO[] params) throws BizException{
		GetExeDepts4CiOrSrvsBatchBP bp=new GetExeDepts4CiOrSrvsBatchBP();
		return bp.exec(params);
	}
}
