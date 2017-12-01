package iih.ci.ord.s.bp.common;

import java.util.Hashtable;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.ems.d.ExDeptMacroEnum;
import iih.ci.ord.ems.d.ExDeptParamGrpTpEnum;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.exception.ExDeptTacticInfoNull4SrvItemOfSetException;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 获得临床医嘱服务项目对应的执行科室与物资流向科室操作BP
 * （可包含医嘱流向、物资流向）
 * （传入的是医嘱项目集合，按传入的顺序返回“执行”科室)
 * 特别注意：传入的枚举EnumFlow值应该一致
 * 返回的科室：执行科室与物资流向科室按优先级混排的列表List
 */
public class GetExeDepts4CiOrSrvsBatchBP {
	/**
	 * 获得临床医嘱服务项目对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * 返回科室列表
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptParamDTO[] exec(OrWfExDeptParamDTO[] params)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(params))return null;
		
		//获得服务执行科室   传入顺序与返回顺序一致
		OrWfExDeptParamDTO[] exdeptinfo=CiOrdAppUtils.getBdFcQryQryService().getOrExDeptBatchBP(params);
		
		//reserve1是组类型及类型角色：00  组类型为套角色为套服务 、01组类型为套角色为套内服务....，
		//reserve2是组类型时组序号 、
		//reserve3是组类型时组内角色的科室计算方式及相关固定科室值及主执行科室串（单服务与批量的串组成规则相同只是批量时不知则为空的处理）
		//reserve4是“医嘱或医疗单序号”
		//reserve5是医嘱服务标识：Y医嘱主服务,Y药品自备
		//自备药：自定义服务自备、非自定义服务自备
		String setgrpno=null;
		Hashtable<String,FArrayList> htSet=new Hashtable<String,FArrayList>();
		Hashtable<String,FArrayList> htOr=new Hashtable<String,FArrayList>();
		
		//遍历
		for(int i=0;i<exdeptinfo.length;i++){
			if(isSetGrp(exdeptinfo[i])){//为套组套标识处理逻辑   记录套项目的执行科室与物资流向科室列表信息
				setgrpno=exdeptinfo[i].getReserv2();
				htSet.put(setgrpno, exdeptinfo[i].getRes());
			}else if(isSetGrpSrvIn(exdeptinfo[i])){//为套组套内项目标识处理逻辑  依据策略进行处理  
				srvItmOfSetExDeptsHandle(exdeptinfo[i].getReserv3(),exdeptinfo[i],htSet.get(exdeptinfo[i].getReserv2()));
				continue;   //套内项目优先走了
			}
			
			if(isOrMainSrv(exdeptinfo[i])){//为主服务判断逻辑
				setgrpno=exdeptinfo[i].getReserv4();
				htOr.put(setgrpno, exdeptinfo[i].getRes());
			}else{
				orSrvDeptsHandle(exdeptinfo[i],htSet.get(exdeptinfo[i].getReserv4()));
			}
		}
		
		//自备药物流科室置空处理
		selfProvidePharmLDeptHandle(exdeptinfo);
		
		//结果返回
		return exdeptinfo;
	}
	
	/**
	 * 医嘱跟随时的
	 * @param param
	 * @param orExDepts
	 */
	private void orSrvDeptsHandle(OrWfExDeptParamDTO param,FArrayList orExDepts){
		if(CiOrdUtils.isEmpty(param))return;
		if(!ExDeptMacroEnum.FOLLOWOR.equals(param.getEu_macrodepmp()))return;
		param.setRes(getsrvItmOfSetExDeptWithSrvSet(param.getRes(),orExDepts));
		
	}
	
	/**
	 * 套内项目时相关执行科室处理逻辑
	 * @param sExDeptTacticInfoStr
	 * @param param
	 * @param grpMainExDepts
	 * @throws BizException 
	 */
	private void srvItmOfSetExDeptsHandle(String sExDeptTacticInfoStr,OrWfExDeptParamDTO param,FArrayList grpMainExDepts) throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(sExDeptTacticInfoStr)) throw new ExDeptTacticInfoNull4SrvItemOfSetException();
		
		//获得套内项目的执行科室相关信息
		String[] reservinfos=sExDeptTacticInfoStr.split(CiOrdUtils.COMMA_STR);  //①科室计算方式 ②固定科室  ③医嘱执行科室
		
		if(IBdSrvDictCodeConst.SD_ORTMPLTP_WITHSRVSET.equals(reservinfos[0])){//跟随套
			srvItmOfSetHandleWithSrvSet(param,grpMainExDepts);
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_ORWFMD.equals(reservinfos[0])){//流向模式
			return ;
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_PVDEPT.equals(reservinfos[0])){//就诊科室
			srvItmOfSetHandle4FixDeptMode(param,param.getId_dept_en());
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_PVWARD.equals(reservinfos[0])){//就诊病区
			srvItmOfSetHandle4FixDeptMode(param,param.getId_dept_ns());; 
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_ORDEPT.equals(reservinfos[0])){//开单科室
			srvItmOfSetHandle4FixDeptMode(param,param.getId_dept_or());
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CONSTDEPT.equals(reservinfos[0])){//固定科室
			srvItmOfSetHandle4FixDeptMode(param,reservinfos[2]);
		}
		
	}
	
	/**
	 * 套内项目执行科室策略：就诊、病区、开单、固定科室时处理逻辑
	 * @param param
	 * @throws BizException
	 */
	private void srvItmOfSetHandle4FixDeptMode(OrWfExDeptParamDTO param,String id_dep) throws BizException{
		ExeDeptReplaceHandleBP bp=new ExeDeptReplaceHandleBP();
		bp.exec(param, id_dep, false);   //不需空判断，直接替换
	}
	
	/**
	 * 套内项目执行科室策略：套跟随时处理逻辑
	 * @param param
	 * @param grpMainExDepts
	 */
	private void srvItmOfSetHandleWithSrvSet(OrWfExDeptParamDTO param,FArrayList grpMainExDepts){
		param.setRes(getsrvItmOfSetExDeptWithSrvSet(param.getRes(),grpMainExDepts));
		param.setEu_macrodepmp(ExDeptMacroEnum.FOLLOWSET);
	}
	
	/**
	 * 获得套跟随项目执行科室列表信息
	 * 套跟随
	 * @param srvItemExDepts
	 * @param grpMainExDepts
	 * @return
	 */
	private FArrayList getsrvItmOfSetExDeptWithSrvSet(FArrayList srvItemExDepts,FArrayList grpMainExDepts){
		Object[] oGrpMainExDepts=CiOrdUtils.getExDeptsAndLogisticDepts(grpMainExDepts);
		Object[] oSrvItemExDepts=CiOrdUtils.getExDeptsAndLogisticDepts(srvItemExDepts);
		return CiOrdUtils.mergeFArrayList((FArrayList)oGrpMainExDepts[0],(FArrayList)oSrvItemExDepts[1]);
	}
	
	
	/**
	 * 自备药《物资流向科室应该为空、执行科室为通常逻辑》
	 * @param exdepts
	 * @throws BizException 
	 */
	private void selfProvidePharmLDeptHandle(OrWfExDeptParamDTO[] exdepts) throws BizException{
		LogisticDeptHandle8SelfProvideBP bp=new LogisticDeptHandle8SelfProvideBP();
		bp.exec(exdepts);
	}
	
	/**
	 * 是否为医嘱主服务标识
	 * @param param
	 * @return
	 */
	private boolean isOrMainSrv(OrWfExDeptParamDTO param){
		if(CiOrdUtils.OR_MAINSRV_FLAG.equals(getOrMainSrvFlagStr(param.getReserv5()))){
			return true;
		}
		return false;
	}
	
	/**
	 * 获得医嘱注服务标识串
	 * @param input
	 * @return
	 */
	private String getOrMainSrvFlagStr(String input){
		if(CiOrdUtils.isEmpty(input))return null;
		String[] flagstrs=input.split(",");
		return flagstrs[0];
	}
	
	/**
	 * 是否为套组套标识
	 * @param param
	 * @return
	 */
	private boolean isSetGrp(OrWfExDeptParamDTO param){
		if(ExDeptParamGrpTpEnum.SETGRPANDSETSRV.equals(param.getReserv1())){
			return true;
		}
		return false;
	}
	
	/**
	 * 是否为套组套内项目标识
	 * @param param
	 * @return
	 */
	private boolean isSetGrpSrvIn(OrWfExDeptParamDTO param){
		if(ExDeptParamGrpTpEnum.SETGRPANDSRVOFSETSRV.equals(param.getReserv1())){
			return true;
		}
		return false;
	}
	
}
