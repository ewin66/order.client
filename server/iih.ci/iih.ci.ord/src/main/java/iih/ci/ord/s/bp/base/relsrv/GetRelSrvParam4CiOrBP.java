package iih.ci.ord.s.bp.base.relsrv;

import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 创建关联服务匹配时的入口参数数据操作BP
 */
public class GetRelSrvParam4CiOrBP {
	/**
	 * 获得关联服务匹配时的入口参数数据
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public BdRelSrvParamDTO exec(CiEmsDTO ems)  throws BizException{
		//有效性校验 
		if(!validateCheck(ems))return null;
		
		//参数设置
		BdRelSrvParamDTO param=new BdRelSrvParamDTO();
		
		//参数
		param.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
		param.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
		param.setCode_entp(ems.getCode_entp());
		String[] factorids=getMatchFactorIdStr(ems);
		param.setId_bizs1(factorids[0]);
		param.setId_bizs2(factorids[1]);
		param.setId_dep_ns(ems.getId_dept_ns());
		param.setId_dep_en(ems.getId_dept_en());
		param.setId_dep_or(ems.getId_dep_phy());
		//param.setDef1();
		//param.setDef2();
		//param.setDef3();
		//param.setDef4();
		//param.setDef5();
		param.setQuan_medu(new FDouble(factorids[2]));
		param.setId_unit_med(factorids[3]);
		
		return param;
	}
	
	/**
	 * 有效性校验
	 * @param ems
	 * @return
	 */
	private boolean validateCheck(CiEmsDTO ems){
		if(CiOrdUtils.isEmpty(ems) || CiOrdUtils.isEmpty(ems.getEmssrvs()))return false;
		
		return true;
	}
	
	/**
	 * 获得匹配因素id值
	 * @param ems
	 * @return
	 */
	private String[] getMatchFactorIdStr(CiEmsDTO ems){
		FArrayList emssrvs=ems.getEmssrvs();//CiEmsSrvDTO
		CiEmsSrvDTO emssrvdo=(CiEmsSrvDTO)emssrvs.get(0);
		
		String[] rtn=new String[4];
		rtn[0]=emssrvdo.getId_srv();
		
		if(CiOrdUtils.isTrue(emssrvdo.getFg_set())){
			rtn[1]=getSetItemIdSrvStr(emssrvs,emssrvdo.getId_srv());
		}
		if(!CiOrdUtils.isEmpty(emssrvdo.getQuan_med())){
			rtn[2]=emssrvdo.getQuan_med().toString();
		}
		
		rtn[3]=emssrvdo.getId_unit_med();
		return rtn;
	}
	
	/**
	 * 获得匹配因素2的值
	 * 套+服务
	 * @param emssrvs
	 * @param id_srv_set
	 * @return
	 */
	private String getSetItemIdSrvStr(FArrayList emssrvs,String id_srv_set){
		String rtn="";
		CiEmsSrvDTO emssrvdo=null;
		for(int i=1;i<emssrvs.size();i++){
			emssrvdo=(CiEmsSrvDTO)emssrvs.get(i);
			if(id_srv_set.equals(emssrvdo.getId_srv_set()))
			{rtn+=CiOrdUtils.COMMA_STR+emssrvdo.getId_srv();}
		}
		
		if(CiOrdUtils.isEmpty(rtn))return null;
		return rtn.substring(1);
	}
	
}
