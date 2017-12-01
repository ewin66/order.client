package iih.ci.ord.s.bp.srvpri;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Map;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.pub.CiOrSrvPriHelper;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FDouble;

/**
 * 临床医嘱选择服务，服务套套内项目合计价格计算操作BP
 */
public class CiOrSrvSetSumPriMdCalBP {
	/**
	 * 临床医嘱选择服务，服务套套内项目合计价格计算
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public FDouble exec(BdSrvPriCalParamDTO param)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		
		//获得价格计算服务对象数组信息
		Object[] calsrvgrps=getPriCalSrvObjs(param.getSrvsetitms());
		IPriCalService ipricalsrv=CiOrdAppUtils.getPriCalService();
		
		//参数设置
		FDouble rtn=null;
		PriStdSrvDTO[] stdpris=null;
		
		//本服务定价价格
		if(!CiOrdUtils.isEmpty(calsrvgrps[0])){
			stdpris=ipricalsrv.CalManySrvsStdPrices((PriStdSrvDTO[])calsrvgrps[0]);
			rtn=CiOrSrvPriHelper.getPriceSum(stdpris);
		}
		
		//组合定价价格
		if(!CiOrdUtils.isEmpty(calsrvgrps[1])){
			stdpris=ipricalsrv.CalMultiSrvCompPrice((String[])calsrvgrps[1]);
			FDouble rtn1=CiOrSrvPriHelper.getPriceSum(stdpris);
			
			if(!CiOrdUtils.isEmpty(rtn1) && !CiOrdUtils.isEmpty(rtn)){
				rtn=rtn1.add(rtn);
			}else{
				rtn=rtn1;
			}
		}
		
		
		return rtn==null?new FDouble(0):rtn;
	}
	
	/**
	 * 折扣价
	 * @param param
	 * @param id_pripat
	 * @return
	 * @throws BizException
	 */
	public FDouble[] exec(BdSrvPriCalParamDTO param,String id_pripat)  throws BizException{
		//有效性判断处理
		if(!validateCheck(param))return null;
		
		//获得价格计算服务对象数组信息
		Object[] calsrvgrps=getPriCalSrvObjs(param.getSrvsetitms());
		IPriCalService ipricalsrv=CiOrdAppUtils.getPriCalService();
		
		//参数设置
		FDouble[] szRtn=new FDouble[]{new FDouble(0),new FDouble(0) };
		PriStdSrvDTO[] stdpris=null;
		
		//本服务定价价格
		if(!CiOrdUtils.isEmpty(calsrvgrps[0])){
			// stdpris=ipricalsrv.CalManySrvsStdPrices((PriStdSrvDTO[])calsrvgrps[0]);
			//rtn=CiOrSrvPriHelper.getPriceSum(stdpris);
			SrvPricalRateAndPriceDTO[] szSrvPricalRateAndPriceDTO = ipricalsrv.CalManySrvsPriceMapByIdPripat((PriStdSrvDTO[])calsrvgrps[0],id_pripat);
			
			FDouble[] szPrice = CiOrSrvPriHelper.getPriceSum(szSrvPricalRateAndPriceDTO);
			szRtn[0] = szRtn[0].add(szPrice[0]);
			szRtn[1] = szRtn[1].add(szPrice[1]);
		}
		
		//组合定价价格
		if(!CiOrdUtils.isEmpty(calsrvgrps[1])){
			String[] szCalSrvGrps = (String[])calsrvgrps[1];
			
			Map<String,Map<String,SrvPricalRateAndPriceDTO>> rstMap = ipricalsrv.CalMultiSrvCompPriceByIdpripat_map((String[])calsrvgrps[1],id_pripat);
			for (String id_srv_comp : szCalSrvGrps){
				if (rstMap.containsKey(id_srv_comp)){
					Map<String,SrvPricalRateAndPriceDTO> srvPricalRateAndPriceMap = rstMap.get(id_srv_comp);
					if (null != srvPricalRateAndPriceMap){
						
						SrvPricalRateAndPriceDTO[] szSrvPricalRateAndPriceDTO = srvPricalRateAndPriceMap.values().toArray(new SrvPricalRateAndPriceDTO [srvPricalRateAndPriceMap.values().size()]);
						FDouble[] szPrice = CiOrSrvPriHelper.getPriceSum(szSrvPricalRateAndPriceDTO);
						szRtn[0] = szRtn[0].add(szPrice[0]);
						szRtn[1] = szRtn[1].add(szPrice[1]);
					}
				}
			}
		}
		
		
		return szRtn;
	}
	
	/**
	 * 有效性校验
	 * @param id_srv
	 * @param id_primd
	 * @return
	 */
	private boolean validateCheck(BdSrvPriCalParamDTO param){
		if(CiOrdUtils.isEmpty(param))return false;
		if(CiOrdUtils.isEmpty(param.getSrvsetitms()))return false;
		return true;
	}
	
	/**
	 * 获得价格计算服务对象数组信息
	 * @param list
	 * @return
	 */
	private Object[] getPriCalSrvObjs(FArrayList list){
		Object[] rtn=new Object[2];
		BdSrvPriCalParamDTO param=null;
		String id_primd=null;
		ArrayList<PriStdSrvDTO> pristdsrvdtos=new ArrayList<PriStdSrvDTO>();
		ArrayList<String> compoundsrvs=new ArrayList<String>();
		//遍历
		for(int i=0;i<list.size();i++){
			param=(BdSrvPriCalParamDTO)list.get(i);
			id_primd=param.getId_primd();
			if(CiOrdUtils.isEmpty(id_primd))
			{
				try {
					id_primd=CiOrdAppUtils.getMedsrvMDORService().findById(param.getId_srv()).getId_primd();
				} catch (BizException e) {
					e.printStackTrace();
				}
			}
			//判断
			if(CiOrSrvPriHelper.isSrvSelfPrimd(id_primd)){
				pristdsrvdtos.add(getPriStdSrvDTO(param));
			}else if(CiOrSrvPriHelper.isSrvCompPrimd(id_primd)){
				compoundsrvs.add(param.getId_srv());
			}else{
				
			}
		}
		if(!CiOrdUtils.isEmpty(pristdsrvdtos)){
			rtn[0]=(PriStdSrvDTO[]) pristdsrvdtos.toArray((PriStdSrvDTO[]) Array.newInstance(PriStdSrvDTO.class, 0));
		}
		if(!CiOrdUtils.isEmpty(compoundsrvs)){
			rtn[1]=(String[]) compoundsrvs.toArray((String[]) Array.newInstance(String.class, 0));
		}
		
		return rtn;
	}
	
	/**
	 * 获得本服务定价数据DTO信息
	 * @param id_srv
	 * @return
	 */
	private PriStdSrvDTO getPriStdSrvDTO(BdSrvPriCalParamDTO param){
		PriStdSrvDTO rtn=new PriStdSrvDTO();
		rtn.setId_srv(param.getId_srv());
		rtn.setName_srv(param.getName_srv());
		return rtn;
	}
}
