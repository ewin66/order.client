package iih.ci.ord.s.bp.ems;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.pp.primd.i.IPriCalService;
import iih.ci.ord.s.ems.biz.meta.OrderPriCalParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;

public class CiOrSrvPriCalGetBP {

	public Map<String,Map<String,SrvPricalRateAndPriceDTO>> exec(OrderPriCalParam[] pricalParams,String id_pripat) throws BizException{

		List<PriStdSrvDTO> srvSelfParamlist=new ArrayList<PriStdSrvDTO>();//本服务定价
		List<String> srvCompIdlist=new ArrayList<String>();//组合定价
		List<OrderPriCalParam> srvsetMemberSumIdlist=new ArrayList<OrderPriCalParam>();//套成员合计加
		List<OrderPriCalParam> srvsetMemCntAddIdlist=new ArrayList<OrderPriCalParam>();//套个数加收
		List<String> srvsetMemberCntIdlist=new ArrayList<String>();//套个数定价


		for( OrderPriCalParam param:pricalParams){
			switch(param.getId_primd()){
			case IBdPrimdCodeConst.ID_PRI_SRV://本服务定价
				PriStdSrvDTO paramdo=new PriStdSrvDTO();
				paramdo.setId_srv(param.getId_srv());
				paramdo.setName_srv(param.getName_srv());
				srvSelfParamlist.add(paramdo);
				break;
			case IBdPrimdCodeConst.ID_PRI_SRV_COMP://组合定价
				srvCompIdlist.add(param.getId_srv());
				break;
			case IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT://套成员合计
				srvsetMemberSumIdlist.add(param);
				break;
			case IBdPrimdCodeConst.ID_PRI_SRVSET_MU://套个数加收
				srvsetMemCntAddIdlist.add(param);
				break;
			case IBdPrimdCodeConst.ID_PRI_SRVSET_FIX://套个数定价
				srvsetMemberCntIdlist.add(param.getId_srv());
				break;
			}
		}
		IPriCalService service=ServiceFinder.find(IPriCalService.class);

		Map<String,Map<String,SrvPricalRateAndPriceDTO>> pricalmap = new HashMap<String,Map<String,SrvPricalRateAndPriceDTO>>();
		if(srvSelfParamlist.size()>0){//本服务定价

			SrvPricalRateAndPriceDTO[] pricaldtos=service.CalManySrvsPriceMapByIdPripat_withoutThrow( srvSelfParamlist.toArray(new PriStdSrvDTO[srvSelfParamlist.size()]),id_pripat);
			for(SrvPricalRateAndPriceDTO dto: pricaldtos){
				Map<String,SrvPricalRateAndPriceDTO> map=new HashMap<String,SrvPricalRateAndPriceDTO>();
				map.put(dto.getId_srv(),dto);
				pricalmap.put(dto.getId_srv(), map);
			}
		}
		if(srvCompIdlist.size()>0){//组合定价
			pricalmap.putAll(service.CalMultiSrvCompPriceByIdpripat_map(srvCompIdlist.toArray(new String[srvCompIdlist.size()]),id_pripat));
		}
		if(srvsetMemberSumIdlist.size()>0){//套成员合计加

			for(OrderPriCalParam param:srvsetMemberSumIdlist){
				pricalmap.putAll(service.CalSrvSetMUPricesByIdPripat_map(param.getId_srv(),param.getNum(),id_pripat));

			}
		}
		if(srvsetMemCntAddIdlist.size()>0){//套个数加收
			for(OrderPriCalParam param:srvsetMemberSumIdlist){
			pricalmap.putAll(service.CalSrvSetFIXPricesByIdPripat_map(param.getId_srv(),param.getNum(),id_pripat));
			}
		}
		if(srvsetMemberCntIdlist.size()>0){//套个数定价
			for(String id_srv:srvsetMemberCntIdlist){
				pricalmap.put(id_srv,service.CalSrvCompPriceByIdPripat_map(id_srv,id_pripat));
			}

		}


		return pricalmap;
	}


	
}
