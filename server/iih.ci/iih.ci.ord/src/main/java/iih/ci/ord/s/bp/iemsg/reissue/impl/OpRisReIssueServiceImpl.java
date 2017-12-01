package iih.ci.ord.s.bp.iemsg.reissue.impl;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpRisOrDTO;
import iih.ci.ord.iemsg.d.IEOpRisOrEnDTO;
import iih.ci.ord.s.bp.iemsg.GetIEOpMsgInfo4RisBP;
import iih.ci.ord.s.bp.iemsg.reissue.IBizReIssueService;
import iih.ci.ord.s.bp.iemsg.reissue.bp.GetCiOrderBP;
import iih.ci.ord.s.bp.iemsg.reissue.dto.ReissueMsgDTO;
import xap.ip.reissue.BS023Param;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.BizException;

/**
 * 门诊检查补发数据
 * 
 * @author HUMS
 *
 */
public class OpRisReIssueServiceImpl implements IBizReIssueService {

	@Override
	public CiOrderDO[] getCiOrders(BS023Param param) throws BizException {
		// TODO Auto-generated method stub
		GetCiOrderBP bp = new GetCiOrderBP();
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
				sb.append("," + obj.getId_or() );
			}

		}
		GetIEOpMsgInfo4RisBP bp = new GetIEOpMsgInfo4RisBP();
		BaseDTO[] msgdos = bp.exec(sb.toString());
        List<ReissueMsgDTO> reissdtolist=new ArrayList<>();
		for (BaseDTO baseDTO : msgdos) {
			IEOpRisOrEnDTO ierisdto =(IEOpRisOrEnDTO) baseDTO;
			IEOpRisOrDTO ierisordto=(IEOpRisOrDTO) (ierisdto.getIerisors()).get(0);
			ReissueMsgDTO rdto=new ReissueMsgDTO();
			rdto.setDataDTO(baseDTO);
			rdto.setIemsgca_code(ierisordto.getIemsgca_code());
			rdto.setId_dep(ierisordto.getSqd_deptcode());
			rdto.setDomainId("01");
			rdto.setServiceId("BS002");
			reissdtolist.add(rdto);
		}
		return reissdtolist.toArray(new ReissueMsgDTO[0]);
	}

}
