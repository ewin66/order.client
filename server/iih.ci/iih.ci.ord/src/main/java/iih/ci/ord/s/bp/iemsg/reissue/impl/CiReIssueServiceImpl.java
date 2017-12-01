package iih.ci.ord.s.bp.iemsg.reissue.impl;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.reissue.BizReIssueServiceFactory;
import iih.ci.ord.s.bp.iemsg.reissue.IBizReIssueService;
import iih.ci.ord.s.bp.iemsg.reissue.ICiReIssueService;
import iih.ci.ord.s.bp.iemsg.reissue.dto.ReissueMsgDTO;
import xap.ip.reissue.BS023Param;
import xap.ip.reissue.BaseReissueService;
import xap.ip.reissue.ReissueMessage;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;

public class CiReIssueServiceImpl extends BaseReissueService implements ICiReIssueService {

	/**
	 * BS023Param 参数说明 </br>
	 * 
	 * @param ServiceId ：服务id，如检查BS002,检验BS006 </br>
	 *            *
	 * @param DomainId : 域ID 门诊 01，住院 02 </br>
	 * @param orderNo ：医嘱号 目前保持和申请单号使用同一个值 </br>
	 * @param ApplyId : 申请单号 BarCode ：标本条码号 咱们iih中没有，不考虑 </br>
	 * @param EncounterCardNo ： 就诊卡号 </br>
	 *            门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis </br>
	 *            住院-- 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip </br>
	 * @param HospitalCode ： 医院编码 </br>
	 * @param HospitalName ： 医院名称
	 */
	@Override
	public List<ReissueMessage> getMsgsBy(BS023Param param) {
		
		List<ReissueMessage> msgList = new ArrayList<ReissueMessage>();

		IBizReIssueService service = BizReIssueServiceFactory.get(param.getServiceId(), param.getDomainId());

		try {

			CiOrderDO[] orders = service.getCiOrders(param);
			if(CiOrdUtils.isEmpty(orders)){
				return msgList;
			}

			ReissueMsgDTO[] reissueMsgs = service.getIEEventDTO(orders);
			for (ReissueMsgDTO msgDTO : reissueMsgs) {

				ReissueMessage msg = obj2Msg(msgDTO.getServiceId(), msgDTO.getIemsgca_code(), msgDTO.getDomainId(),
						msgDTO.getId_dep(), msgDTO.getDataDTO());
				msgList.add(msg);
			}

		} catch (BizException e) {
			
			CiOrdUtils.getlogger().error("集成平台补发医嘱数据错误，传入参数[" + JSONObject.toJSONString(param) + "]", e);
			throw new BizRuntimeException(e.getMessage(), e);
		}

		return msgList;
	}

}
