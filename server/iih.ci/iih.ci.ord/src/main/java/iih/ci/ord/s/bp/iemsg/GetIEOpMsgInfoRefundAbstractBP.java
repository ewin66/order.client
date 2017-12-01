package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import iih.bl.cg.dto.d.OpRefund4IpEsDTO;
import iih.ci.ord.pub.CiOrdUtils;

public abstract class GetIEOpMsgInfoRefundAbstractBP {
	/**
	 * 获得服务主键
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdOrSrvs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idOrsrvs = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idOrsrvs += es.getId_orsrv() + CiOrdUtils.COMMA_STR;
		}
		if (idOrsrvs.length() > 0) {
			idOrsrvs = idOrsrvs.substring(0, idOrsrvs.length() - 1);
		}
		return idOrsrvs;
	}

	/**
	 * 获得医嘱id_or，以，隔开
	 * 
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdOrs(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idors = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idors += es.getId_or() + CiOrdUtils.COMMA_STR;
		}
		if (idors.length() > 0) {
			idors = idors.substring(0, idors.length() - 1);
		}
		return idors;
	}
	/**
	 * 获得处方主键
	 * @param refund4IpEsDTOs
	 * @return
	 */
	public String getIdPreses(OpRefund4IpEsDTO[] refund4IpEsDTOs) {
		String idpreses = "";
		for (OpRefund4IpEsDTO es : refund4IpEsDTOs) {
			idpreses += es.getId_pres() + CiOrdUtils.COMMA_STR;
		}
		if (idpreses.length() > 0) {
			idpreses = idpreses.substring(0, idpreses.length() - 1);
		}
		return idpreses;
	}
	
	/**
	 * 获得以服务主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	  public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdorsrv(OpRefund4IpEsDTO[] refundDTOs)
	  {
	    HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap();
	    for (OpRefund4IpEsDTO es : refundDTOs) {
	      if (es.getCode_applytp().equals("01")) {
	        refundMap.put(es.getId_pres(), es);
	      } else {
	        refundMap.put(es.getId_orsrv(), es);
	      }
	    }
	    return refundMap;
	  }
	/**
	 * 获得以处方ID主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, List<OpRefund4IpEsDTO>> getOpRefundDTOListKeyIdpres(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, List<OpRefund4IpEsDTO>> refundMap = new HashMap<String,List<OpRefund4IpEsDTO>>();
		
		for (OpRefund4IpEsDTO es : refundDTOs) {
			//去重 存入处方ID by yzh 2017-08-16 15:53:33
			if(refundMap.containsKey(es.getId_pres())){
				refundMap.get(es.getId_pres()).add(es);
			}else{
				List<OpRefund4IpEsDTO> list = new ArrayList<>();
				list.add(es);
				refundMap.put(es.getId_pres(), list);
			}
		}
		return refundMap;
	}
	/**
	 * 获得以处方主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdpres(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap<String,OpRefund4IpEsDTO>();
		for (OpRefund4IpEsDTO es : refundDTOs) {
			if(!refundMap.containsKey(es.getId_pres())){
				refundMap.put(es.getId_pres(), es);
			}
		}
		return refundMap;
	}
	/**
	 * 获得以医嘱主键作为key的退费DTO的Map
	 * @param refundDTOs
	 * @return
	 */
	public HashMap<String, OpRefund4IpEsDTO> getOpRefundDTOMapKeyIdor(OpRefund4IpEsDTO[] refundDTOs) {
		HashMap<String, OpRefund4IpEsDTO> refundMap = new HashMap<String,OpRefund4IpEsDTO>();
		for (OpRefund4IpEsDTO es : refundDTOs) {
			if(!refundMap.containsKey(es.getId_or())){
				refundMap.put(es.getId_or(), es);
			}
		}
		return refundMap;
	}
}
