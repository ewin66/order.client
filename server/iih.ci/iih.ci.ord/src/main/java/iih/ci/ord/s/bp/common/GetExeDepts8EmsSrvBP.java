package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 获得医疗单Ems服务项目对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 */
public class GetExeDepts8EmsSrvBP {
	/**
	 * 获得医疗单Ems服务项目对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * @param ems
	 * @param index
	 * @param dt_effe
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(CiEmsDTO ems,int index,FDateTime dt_effe)  throws BizException{
		//有效性校验
		if(!validateCheck(ems,index,dt_effe))return null;
		
		//根据EMS获得医嘱流向执行科室入口参数
		OrWfExDeptParamDTO paramdto=getOrWfExDeptParam8Ems(ems,index,dt_effe);
		
		//获得服务项目对应的执行科室
		OrWfExDeptDTO[] exedepdtos=getExeDepts4CiOrSrv(paramdto);
		
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
	private boolean validateCheck(CiEmsDTO ems,int index,FDateTime dt_effe){
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
	private OrWfExDeptParamDTO getOrWfExDeptParam8Ems(CiEmsDTO ems,int index,FDateTime dt_effe) throws BizException{
		GetOrWfExDeptParam8EmsBP bp=new GetOrWfExDeptParam8EmsBP();
		return bp.exec(ems, index, dt_effe);
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
