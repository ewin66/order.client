package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 执行科室替换处理操作BP
 */
public class ExeDeptReplaceHandleBP {
	/**
	 * 执行科室替换处理操作
	 * @param param
	 * @param id_dept
	 * @param isNullReplace
	 * @throws BizException
	 */
	public  void exec(OrWfExDeptParamDTO param,String id_dept,boolean isNullReplace)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(param) || CiOrdUtils.isEmpty(id_dept))return ;
		
		Object[] oSrvItemExDepts=CiOrdUtils.getExDeptsAndLogisticDepts(param.getRes());
		if(isNullReplace){
			if(!CiOrdUtils.isEmpty(oSrvItemExDepts[0]))return;  //执行科室非空，不需处理
			//为空则补足
		}
		OrWfExDeptDTO exdeptdto=CiOrdUtils.getOrWfExDept(id_dept,EnumFlow.EXECUTEFLOW);
		param.setRes(CiOrdUtils.merge2FArrayList(exdeptdto,(FArrayList)oSrvItemExDepts[1]));
		
	}
	
}
