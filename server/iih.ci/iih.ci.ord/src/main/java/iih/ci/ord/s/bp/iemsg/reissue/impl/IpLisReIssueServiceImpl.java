package iih.ci.ord.s.bp.iemsg.reissue.impl;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpLisOrDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpLisOrItmDTO;
import iih.ci.ord.s.bp.iemsg.GetIEMsgInfo4LisBP;
import iih.ci.ord.s.bp.iemsg.reissue.IBizReIssueService;
import iih.ci.ord.s.bp.iemsg.reissue.bp.GetCiOrderBP;
import iih.ci.ord.s.bp.iemsg.reissue.dto.ReissueMsgDTO;
import xap.ip.reissue.BS023Param;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

/**
 * 住院检验补发数据
 * 
 * @author HUMS
 *
 */
public class IpLisReIssueServiceImpl implements IBizReIssueService {

	@Override
	public CiOrderDO[] getCiOrders(BS023Param param) throws BizException {
		// TODO Auto-generated method stub
		GetCiOrderBP bp=new GetCiOrderBP();
		return bp.exe(param);
	}

	@Override
	public ReissueMsgDTO[] getIEEventDTO(CiOrderDO[] ciorders) throws BizException {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for (CiOrderDO obj : ciorders) {
			if (sb.length() == 0) {
				sb.append( obj.getId_or() );
			} else {
				sb.append(", " + obj.getId_or() );
			}

		}
		GetIEMsgInfo4LisBP bp=new GetIEMsgInfo4LisBP();
		IEOpLisOrEnDTO[] msgdos=bp.exec(sb.toString());
        List<ReissueMsgDTO> reissdtolist=new ArrayList<>();
		for (BaseDTO baseDTO : msgdos) {
			IEOpLisOrEnDTO ielisdto = (IEOpLisOrEnDTO) baseDTO;
			IEOpLisOrDTO ielisordto = (IEOpLisOrDTO) (ielisdto.getId_ielisors()).get(0);
			IEOpLisOrItmDTO ielisitemdto = (IEOpLisOrItmDTO) (ielisordto.getId_ielisoritms()).get(0);
			ReissueMsgDTO rdto=new ReissueMsgDTO();
			rdto.setDataDTO(baseDTO);
			rdto.setIemsgca_code(ielisordto.getIemsgca_code());
			rdto.setId_dep(ielisitemdto.getExec_code());
			rdto.setDomainId("02");
			rdto.setServiceId("BS006");
			reissdtolist.add(rdto);
		}
		return reissdtolist.toArray(new ReissueMsgDTO[0]);
	}




}
