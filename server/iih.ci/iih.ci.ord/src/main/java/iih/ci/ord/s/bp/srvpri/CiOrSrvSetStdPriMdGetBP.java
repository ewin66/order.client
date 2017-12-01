package iih.ci.ord.s.bp.srvpri;

import java.lang.reflect.Array;
import java.util.ArrayList;

import iih.bd.pp.dto.d.PriStdSrvDTO;
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
public class CiOrSrvSetStdPriMdGetBP {
	/**
	 * 临床医嘱选择服务，服务套套内项目合计价格计算
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public PriStdSrvDTO[] exec(BdSrvPriCalParamDTO param)  throws BizException{
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
		}
		
		//组合定价价格
		if(!CiOrdUtils.isEmpty(calsrvgrps[1])){
			String[] comgrp=(String[])calsrvgrps[1];
			for(int i=0;i<comgrp.length;i++){
				stdpris=(PriStdSrvDTO[])CiOrdUtils.mergeObjAry(stdpris, comPriStdHandle(ipricalsrv.CalSrvCompPrice(comgrp[i]),comgrp[i]));
			}
			
		}
		
		
		return stdpris;
	}
	
	/**
	 * 组合定价时   返回的标准服务 价   中标记所属的组合服务
	 * @param stdpris
	 * @param id_srv_com
	 * @return
	 */
	private PriStdSrvDTO[] comPriStdHandle(PriStdSrvDTO[] stdpris,String id_srv_com){
		if(CiOrdUtils.isEmpty(stdpris))return null;
		for(int i=0;i<stdpris.length;i++){
			stdpris[i].setName_srv(id_srv_com); //借用  name字段  表示  该费用项所属 服务
		}
		return stdpris;
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
