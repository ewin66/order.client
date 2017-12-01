package iih.ci.ord.s.bp.common;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 获得临床医嘱服务项目对应的执行科室操作BP
 * （可包含医嘱流向、物资流向）
 */
public class GetExeDepts4CiOrSrvBP {
	/**
	 * 获得临床医嘱服务项目对应的执行科室
	 * （可包含医嘱流向、物资流向）
	 * 返回科室列表
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(OrWfExDeptParamDTO param)  throws BizException{
		//有效性校验
		if(param==null)return null;
		
		//参数设置
		String relsrvsetinfo=param.getReserv1();  //套id,套分类,套类型,套用法,分类内码
		FBoolean isDeptFixed=FBoolean.FALSE;
		String[] deptinfos=reserveInfoHandle(param.getReserv3(), param,isDeptFixed);//套内项目 科室计算方式sd、固定执行科室、套执行科室
		OrWfExDeptDTO exdeptdto=null;
		if(!CiOrdUtils.isEmpty(deptinfos) && deptinfos[0].equals("1")){
			if(!CiOrdUtils.isEmpty(deptinfos[1])){
				exdeptdto=getOrWfExDept(deptinfos[1],EnumFlow.EXECUTEFLOW);
				if(!CiOrdUtils.isEmpty(exdeptdto)){
					return new OrWfExDeptDTO[]{exdeptdto};
				}
			}
			return getExDept(param,EnumFlow.EXECUTEFLOW);
		}
		
		//获得服务执行科室
		OrWfExDeptDTO[] exdeptinfo=CiOrdAppUtils.getBdFcQryQryService().getOrExDeptMainBP(param);
		if(exdeptinfo==null || exdeptinfo.length==0){
			if(!CiOrdUtils.isEmpty(relsrvsetinfo)){
				//获得套对应的执行科室
				OrWfExDeptParamDTO param1=getSetParam(param,relsrvsetinfo);
				if(param1!=null){
					exdeptinfo=CiOrdAppUtils.getBdFcQryQryService().getOrExDeptMainBP(param1);
					if(exdeptinfo!=null && exdeptinfo.length!=0)return merge(exdeptinfo,exdeptdto);
				}
			}
		}else{
			return  merge(exdeptinfo,exdeptdto);
		}
		
		//返回病区或就诊科室
		return getExDept(param,EnumFlow.NULL);
	}
	
	/**
	 * 获得套流向参数
	 * @param param
	 * @param relsrvsetinfo
	 * @return
	 */
	private OrWfExDeptParamDTO getSetParam(OrWfExDeptParamDTO param,String relsrvsetinfo){
		String[] setinfos=getSetInfo(relsrvsetinfo);
		if(setinfos==null || setinfos.length==0)return null;
		OrWfExDeptParamDTO rtn=new OrWfExDeptParamDTO();
		param.setCode_entp(param.getCode_entp());
		param.setRecurstr(param.getRecurstr());
		param.setWeekno(param.getWeekno());
		param.setTimestr(param.getTimestr());
		param.setId_srv(setinfos[0]);
		param.setId_srvca(setinfos[1]);
		param.setSd_srvtp(setinfos[2]);
		param.setId_usage(setinfos[3]);
		//param.setInnercode_srvca(setinfos[4]);  缺失 待补
		param.setId_mm("");
		param.setId_dept_en(param.getId_dept_en());
		param.setId_dept_ns(param.getId_dept_ns());
		param.setId_dept_or(param.getId_dept_or());
		//param.setId_dept_ex();
		//param.setReserv1();  
		//param.setReserv2();
		//param.setReserv3();
		param.setEu_wftp(param.getEu_wftp());
		return param;
	}
	
	/**
	 * 获得套信息
	 * 套id,套分类,套类型,套用法
	 * @param relsrvsetinfo
	 * @return
	 */
	private String[] getSetInfo(String relsrvsetinfo){
		String[] rtns=relsrvsetinfo.split(CiOrdUtils.COMMA_STR);
		if(rtns==null || rtns.length!=4)return null;
		return rtns;
	}
	
	/**
	 * 获得病区或就诊科室
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptDTO[] getExDept(OrWfExDeptParamDTO param,Integer eu_wftp) throws BizException{
		//有效性校验
		if(param==null)return null;
		
		//参数设置
		String id_dep;
		
		//获得科室id
		if(CiOrdUtils.isIpWf(param.getCode_entp())){
			id_dep=param.getId_dept_ns();
		}else{
			id_dep=param.getId_dept_en();
		}
		
		//特别注意这句话为临时的  最后需要注释掉
		//理论角度讲如果Banner上下文中正确的话这句话也不会执行的  也没有问题
		if(CiOrdUtils.isEmpty(id_dep)){id_dep=param.getId_dept_or();}   
		
		//获得医嘱流向科室信息
		OrWfExDeptDTO depdto=getOrWfExDept(id_dep,eu_wftp);
		
		//返回处理
		if(depdto==null)return null;
		return new OrWfExDeptDTO[]{depdto};
	}
	
	/**
	 * 获得医嘱流向执行科室
	 * @param id_dep
	 * @return
	 * @throws BizException
	 */
	private OrWfExDeptDTO getOrWfExDept(String id_dep,Integer eu_wftp) throws BizException{
		OrWfExDeptDTO deptdto=CiOrdAppUtils.getBdFcQryQryService().getExDeptInfo8DepId(id_dep);
		deptdto.setEu_wftp(eu_wftp);
		return deptdto;
	}
	
	/**
	 * 套内项目时相关执行科室处理逻辑
	 * @param reserve3
	 * @param param
	 * @return
	 */
	private String[] reserveInfoHandle(String reserve3,OrWfExDeptParamDTO param,FBoolean isDeptFixed){
		//有效性校验
		if(CiOrdUtils.isEmpty(reserve3)) return null;
		
		//获得套内项目的执行科室相关信息
		String[] reservinfos=reserve3.split(CiOrdUtils.COMMA_STR);  //科室计算方式 固定科室  医嘱执行科室
		param.setReserv3(null);
		String[] rtn=new String[]{"0",""};
		String id_dept;
		
		if(IBdSrvDictCodeConst.SD_ORTMPLTP_WITHSRVSET.equals(reservinfos[0])){  //跟随套
			paramHandle(param,isDeptFixed);
			return new String[]{"1",reservinfos[2]};
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_ORWFMD.equals(reservinfos[0])){//流向模式
			return null;
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_PVDEPT.equals(reservinfos[0])){//就诊科室
			paramHandle(param,isDeptFixed);
			return new String[]{"1",param.getId_dept_en()};
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_PVWARD.equals(reservinfos[0])){//就诊病区
			paramHandle(param,isDeptFixed);
			return new String[]{"1",param.getId_dept_ns()}; 
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_ORDEPT.equals(reservinfos[0])){//开单科室
			paramHandle(param,isDeptFixed);
			return new String[]{"1",param.getId_dept_or()};
		}else if(IBdSrvDictCodeConst.SD_ORTMPLTP_CONSTDEPT.equals(reservinfos[0])){//固定科室
			paramHandle(param,isDeptFixed);
			return new String[]{"1",reservinfos[1]};
		}
		
		return null;
	}
	
	/**
	 * 流向执行科室参数数据处理
	 * @param param
	 */
	private void paramHandle(OrWfExDeptParamDTO param,FBoolean isDeptFixed){
		isDeptFixed=FBoolean.TRUE;
		if(EnumFlow.NULL==param.getEu_wftp()){param.setEu_wftp(EnumFlow.SUPPLIESFLOW);}
		else if(EnumFlow.EXECUTEFLOW==param.getEu_wftp()){param=null;}
		else if(EnumFlow.SUPPLIESFLOW==param.getEu_wftp()){}else{}
	}
	
	/**
	 * 合并
	 */
	private OrWfExDeptDTO[] merge(OrWfExDeptDTO[] rtn,OrWfExDeptDTO addone){
		if(CiOrdUtils.isEmpty(addone)) return rtn;
		if(CiOrdUtils.isEmpty(rtn)) return new OrWfExDeptDTO[]{addone};
		int iL=rtn.length;
		OrWfExDeptDTO[] rtn1=new OrWfExDeptDTO[iL+1];
		rtn1[0]=addone;
		for(int i=1;i<=iL;i++){
			rtn1[i]=rtn[i-1];
		}
		return rtn1;
		
	}
	
}
