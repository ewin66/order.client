package iih.ci.ord.s.bp.common;

import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.emsdi.d.ExeDeptCalParamDTO;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDateTime;

/**
 * 根据EMS获得医嘱流向执行科室入口参数操作BP
 */
public class GetOrWfExDeptParams8EmsBP {
	/**
	 * 根据EMS获得医嘱流向执行科室入口参数
	 * @param paramdto
	 * @return
	 * @throws BizException
	 */
	public  OrWfExDeptParamDTO[] exec(CiEmsDTO ems,FDateTime dt_effe)  throws BizException{
		//有效性校验
		if(CiOrdUtils.isEmpty(ems) || CiOrdUtils.isEmpty(ems.getEmssrvs()))return null;
			
		//获得执行科室计算参数数据
		ExeDeptCalParamDTO[] calparamdto=getExeDeptCalParamDTOs(ems,dt_effe);

		//获得医嘱流向执行科室入口参数
		return getOrWfExDeptParam(calparamdto);
	}
	
	/**
	 * 获得执行科室计算参数数据
	 * @param ems
	 * @param dt_effe
	 * @return
	 */
	private ExeDeptCalParamDTO[] getExeDeptCalParamDTOs(CiEmsDTO ems,FDateTime dt_effe){
		FArrayList list=ems.getEmssrvs();
		ExeDeptCalParamDTO[] rtns=new ExeDeptCalParamDTO[list.size()];
		for(int i=0;i<list.size();i++){
			rtns[i]=getExeDeptCalParamDTO(ems,i,dt_effe);
		}
		
		return rtns;
	}
	
	/**
	 * 获得执行科室计算参数数据
	 * @param ems
	 * @param index
	 * @param dt_effe
	 * @return
	 */
	private ExeDeptCalParamDTO getExeDeptCalParamDTO(CiEmsDTO ems,int index,FDateTime dt_effe){
		CiEmsSrvDTO srvdto=(CiEmsSrvDTO)ems.getEmssrvs().get(index);
		ExeDeptCalParamDTO paramdto=new ExeDeptCalParamDTO();
		paramdto.setCode_entp(ems.getCode_entp());
		paramdto.setId_dep_en(ems.getId_dept_en());
		paramdto.setId_dep_or(ems.getId_dep_phy());
		paramdto.setId_dep_ns(ems.getId_dept_ns());
		paramdto.setId_dep_exe(ems.getId_dep_mp()); //2016-10-27  新增业务逻辑
		paramdto.setFg_long(ems.getFg_long());
		paramdto.setId_srv(srvdto.getId_srv());
		paramdto.setId_mm(srvdto.getId_mm());
		paramdto.setSd_srvtp(srvdto.getSd_srvtp());
		paramdto.setId_srvca(srvdto.getId_srvca());
		paramdto.setInnercode_srvca(srvdto.getInnercode_srvca());
		paramdto.setId_route(srvdto.getId_route());
		paramdto.setDt_effe(dt_effe);
		//paramdto.setDef1();
		//paramdto.setDef2();
		//paramdto.setDef3();
		//paramdto.setDef4();
		//paramdto.setDef5();
		if(!CiOrdUtils.isTrue(srvdto.getFg_mm())){
			paramdto.setEu_wftp(EnumFlow.EXECUTEFLOW);  //只求执行科室
		}else{
			paramdto.setEu_wftp(EnumFlow.NULL);   //求物资流向科室
		}
		return paramdto;
	}
	
	/**
	 *  获得医嘱流向执行科室入口参数
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private OrWfExDeptParamDTO[] getOrWfExDeptParam(ExeDeptCalParamDTO[] params) throws BizException{
		GetOrWfExDeptParamBatchBP bp=new GetOrWfExDeptParamBatchBP();
		return bp.exec(params);
	}
		 
}
