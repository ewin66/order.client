package iih.ci.ord.s.bp.ems;

import iih.bd.fc.orwf.d.OrWfExDeptDTO;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.sys.orgfw.dept.d.DeptDO;

/**
 * 获得临床医嘱服务项目对应的执行科室操作BP
 * 
 */
public class CiOrSrvExecuteDeptGetBP {
	/**
	 * 获得临床医嘱服务项目对应的执行科室
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptDTO[] exec(OrWfExDeptParamDTO param)  throws BizException{
		//有效性校验
		if(param==null)return null;
		String relsrvsetinfo=param.getReserv1();  //套id,套分类,套类型,套用法
		
		//获得服务执行科室
		OrWfExDeptDTO[] exdeptinfo=CiOrdAppUtils.getBdFcQryQryService().getOrExDept4OpenMode(param);
		if(exdeptinfo==null || exdeptinfo.length==0){
			if(!CiOrdUtils.isEmpty(relsrvsetinfo)){
				//获得套对应的执行科室
				OrWfExDeptParamDTO param1=getSetParam(param,relsrvsetinfo);
				if(param1!=null){
					exdeptinfo=CiOrdAppUtils.getBdFcQryQryService().getOrExDept4OpenMode(param1);
					if(exdeptinfo!=null && exdeptinfo.length!=0)return exdeptinfo;
				}
			}
		}else{
			return exdeptinfo;
		}
		
		//返回病区或就诊科室
		return getExDept(param);
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
		param.setSd_srvtp(param.getSd_srvtp());
		param.setId_srvca(param.getId_srvca());
		param.setId_usage(param.getId_usage());
		param.setRecurstr(param.getRecurstr());
		//param.setWeekno();
		//param.setTimestr();
		param.setId_srv(setinfos[0]);
		param.setId_srvca(setinfos[1]);
		param.setSd_srvtp(setinfos[2]);
		param.setId_usage(setinfos[3]);
		param.setId_mm("");
		param.setId_dept_en(param.getId_dept_en());
		param.setId_dept_ns(param.getId_dept_ns());
		param.setId_dept_or(param.getId_dept_or());
		//param.setId_dept_ex();
		//param.setReserv1();  
		//param.setReserv2();
		//param.setReserv3();
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
	private OrWfExDeptDTO[] getExDept(OrWfExDeptParamDTO param) throws BizException{
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
		OrWfExDeptDTO depdto=getOrWfExDept(id_dep);
		
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
	private OrWfExDeptDTO getOrWfExDept(String id_dep) throws BizException{
		return CiOrdAppUtils.getBdFcQryQryService().getExDeptInfo8DepId(id_dep);
	}
	
}
