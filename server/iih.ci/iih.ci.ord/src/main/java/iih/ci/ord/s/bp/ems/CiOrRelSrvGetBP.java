package iih.ci.ord.s.bp.ems;

import iih.bd.srv.oth.d.BdRelSrvParamDTO;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.s.bp.base.relsrv.GetRelBdSrv8InfluFactorsBP;
import iih.ci.ord.s.bp.base.relsrv.GetRelSrvParam4CiOrBP;
import xap.mw.core.data.BizException;

/*
 * 获得医疗单关联服务数据信息操作BP
 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息 
 */
public class CiOrRelSrvGetBP {
	/**
	 * 获得医疗单关联服务数据信息
	 * 通过关联服务策略因素项匹配获得对应关联服务列表数据信息
	 * @param ems
	 * @return
	 * @throws BizException
	 */
	public UsageRelFeeSrvDO[] exec(CiEmsDTO ems)  throws BizException{
		//有效性校验 
		if(ems==null)return null;
		
		//创建关联服务匹配时的入口参数数据
		BdRelSrvParamDTO param=createBdRelSrvParamDTO(ems);

		//获得医嘱关联的服务数据信息并返回
		return getCiOrRelSrvs(param);
	}
	
	/**
	 * 创建关联服务匹配时的入口参数数据
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	private BdRelSrvParamDTO createBdRelSrvParamDTO(CiEmsDTO ems) throws BizException{
		GetRelSrvParam4CiOrBP bp=new GetRelSrvParam4CiOrBP();
		return bp.exec(ems);
	}
	
	/**
	 * 根据匹配因素获得关联的服务集合数据信息
	 * @param param
	 * @return
	 * @throws BizException 
	 */
	private UsageRelFeeSrvDO[] getCiOrRelSrvs(BdRelSrvParamDTO param) throws BizException{
		try{
			GetRelBdSrv8InfluFactorsBP bp=new GetRelBdSrv8InfluFactorsBP();
			return bp.exec(param);
		}catch(Exception e){
			throw new BizException(e.getMessage());
		}
	}
	
}
