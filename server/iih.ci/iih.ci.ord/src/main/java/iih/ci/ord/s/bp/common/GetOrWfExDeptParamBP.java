package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.DateUtils;
import xap.mw.core.data.BizException;

/**
 * 获得医嘱流向执行科室入口参数操作BP
 */
public class GetOrWfExDeptParamBP {
	/**
	 * 获得医嘱流向执行科室入口参数
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptParamDTO exec(ExeDeptCalParamDTO paramdto)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(paramdto))return null;
			
		OrWfExDeptParamDTO param=new OrWfExDeptParamDTO();
		param.setCode_entp(paramdto.getCode_entp());
		param.setSd_srvtp(paramdto.getSd_srvtp());
		param.setId_srvca(paramdto.getId_srvca());
		param.setInnercode_srvca(paramdto.getInnercode_srvca());
		param.setId_usage(paramdto.getId_route());
		param.setRecurstr(CiOrdUtils.getFg_longStr(paramdto.getFg_long()));
		param.setWeekno(DateUtils.getWeekNoStr4Dt(paramdto.getDt_effe()));
		param.setTimestr(DateUtils.getFTime8Dt(paramdto.getDt_effe()));
		param.setId_srv(paramdto.getId_srv());
		param.setId_mm(paramdto.getId_mm());
		param.setId_dept_en(paramdto.getId_dep_en());
		param.setId_dept_ns(paramdto.getId_dep_ns());
		param.setId_dept_or(paramdto.getId_dep_or());
		param.setId_dept_ex(paramdto.getId_dep_exe());//2016-10-27新增该赋值
		param.setReserv1(paramdto.getDef1());  //套id,套分类,套类型,套用法,分类内码
		param.setReserv2(paramdto.getDef2());
		param.setReserv3(paramdto.getDef3());  //套内项目 科室计算方式sd、固定执行科室、套执行科室	
		param.setEu_wftp(paramdto.getEu_wftp());

		return param;
	}
}
