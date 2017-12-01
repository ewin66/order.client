package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;

/**
 * 根据执行科室计算参数数据信息获得对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 */
public class GetExeDepts8DepcalparamBP {
	/**
	 * 根据执行科室计算参数数据信息获得对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * @param calparamdto
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(ExeDeptCalParamDTO calparamdto)  throws BizException{
		//有效性校验
		if(!validateCheck(calparamdto))return null;
		
		//根据EMS获得医嘱流向执行科室入口参数
		OrWfExDeptParamDTO paramdto=getOrWfExDeptParam8Ems(calparamdto);
		
		//获得服务项目对应的执行科室
		OrWfExDeptDTO[] exedepdtos=getExeDepts4CiOrSrv(paramdto);
		
		//返回值
		return exedepdtos; 
	}
	
	/**
	 * 有效性校验
	 * @param calparamdto
	 * @return
	 * @throws BizException 
	 */
	private boolean validateCheck(ExeDeptCalParamDTO calparamdto){
		//有效性校验
		if(CiOrdUtils.isEmpty(calparamdto))return false;
		
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
	private OrWfExDeptParamDTO getOrWfExDeptParam8Ems(ExeDeptCalParamDTO calparamdto) throws BizException{
		GetOrWfExDeptParamBP bp=new GetOrWfExDeptParamBP();
		return bp.exec(calparamdto);
	}

	/**
	 * 获得服务项目对应的执行科室
	 * @param param
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO[] getExeDepts4CiOrSrv(OrWfExDeptParamDTO param) throws BizException{
		GetExeDepts4CiOrSrvBP bp=new GetExeDepts4CiOrSrvBP();
		return bp.exec(param);
	}
}
