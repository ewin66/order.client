package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 自备药物流科室处理逻辑操作BP
 */
public class LogisticDeptHandle8SelfProvideBP {
	/**
	 * 自备药物流科室处理逻辑操作
	 * @param exdepts
	 * @throws BizException
	 */
	public  void exec(OrWfExDeptParamDTO[] exdepts)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(exdepts))return ;
		
		//遍历
		for(int i=0;i<exdepts.length;i++){
			if(isOrSelfProvideSrv(exdepts[i])){//自备药《物资流向科室应该为空
				logisticDeptNullHandle(exdepts[i]);
			}
		}
		
	}
	
	/**
	 * 设置物流科室为空处理
	 * @param exdept
	 */
	private void logisticDeptNullHandle(OrWfExDeptParamDTO exdept){
		//有效性校验
		if(CiOrdUtils.isEmpty(exdept))return ;
		
		//获得执行科室与物流科室
		Object[] oSrvItemExDepts=CiOrdUtils.getExDeptsAndLogisticDepts(exdept.getRes());
		
		//设置执行与物流科室信息
		exdept.setRes((FArrayList)oSrvItemExDepts[0]);
	}
	
	/**
	 * 获得医嘱服务是否自备标识串
	 * @param input
	 * @return
	 */
	private String getOrSrvSelfProvideFlagStr(String input){
		if(CiOrdUtils.isEmpty(input))return null;
		String[] flagstrs=input.split(",");
		if(flagstrs.length<=1)return null;
		return flagstrs[1];
	}
	
	/**
	 * 是否为自备医嘱服务
	 * @param param
	 * @return
	 */
	private boolean isOrSelfProvideSrv(OrWfExDeptParamDTO param){
		if(CiOrdUtils.OR_MAINSRV_FLAG.equals(getOrSrvSelfProvideFlagStr(param.getReserv5()))){
			return true;
		}
		return false;
	}

	
}
