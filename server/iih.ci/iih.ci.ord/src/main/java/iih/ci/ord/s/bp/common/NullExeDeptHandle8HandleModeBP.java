package iih.ci.ord.s.bp.common;

import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ord.ems.d.ExDeptMacroEnum;
import iih.ci.ord.ems.d.ExDeptParamGrpTpEnum;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.ExDeptTacticInfoNull4SrvItemOfSetException;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;

/**
 * 空执行科室结果按流向处理模式及默认值处理操作BP
 * 第一层概念：0流向配置模式、 1流向配置+模式
 * 第二层概念：流向配置+模式时，执行流向默认科室设置值
 */
public class NullExeDeptHandle8HandleModeBP {
	/**
	 * 空执行科室结果按流向处理模式及默认值处理操作
	 * 第一层概念：0流向配置模式、 1流向配置+模式
	 * 第二层概念：流向配置+模式时，执行流向默认科室设置值  
	 * @param exdepts
	 * @param id_org
	 * @param code_entp
	 * @throws BizException
	 */
	public  void exec(OrWfExDeptParamDTO[] exdepts,String id_org,String code_entp)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(exdepts))return ;
		
		//模式判断   医嘱执行流向科室处理模式为：0 流向配置模式时直接返回
		String[] modeinfo=CiOrParamUtils.getCiOrExFlowDeptHandleModeInfo(id_org,code_entp);
		if(CiOrParamUtils.isCiOrExFlowDeptHandleModeDeptFlowCfg(modeinfo[0]))return;  //不需处理并返回
			
		//遍历
		for(int i=0;i<exdepts.length;i++){
			//空执行科室补足处理逻辑
			nullExeDeptHandle(exdepts[i],modeinfo[1]);
		}
		
	}
	
	/**
	 * 空执行科室补足处理逻辑
	 * @param exdeptinfo
	 * @param depttype
	 * @throws BizException
	 */
	private void nullExeDeptHandle(OrWfExDeptParamDTO exdeptinfo,String depttype) throws BizException{
		String id_dep=getDeptID(exdeptinfo,depttype);
		ExeDeptReplaceHandleBP bp=new ExeDeptReplaceHandleBP();
		bp.exec(exdeptinfo, id_dep, true);   //空则替换补足
	}
	
	/**
	 * 根据科室类型获得科室ID
	 * @param exdeptinfo
	 * @param depttype
	 * @return
	 */
	private String getDeptID(OrWfExDeptParamDTO exdeptinfo,String depttype){
		if(ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet_PvDept.equals(depttype)){
			return exdeptinfo.getId_dept_en();
		}else if(ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet_OrDept.equals(depttype)){
			return exdeptinfo.getId_dept_or();
		}else if(ICiOrdNSysParamConst.PARAMV_CiOrExFlowDefaultDeptSet_NsDept.equals(depttype)){
			return exdeptinfo.getId_dept_ns();
		}
		return null;
	}

	
}
