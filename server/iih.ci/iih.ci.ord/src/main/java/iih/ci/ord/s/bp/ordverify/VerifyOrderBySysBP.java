package iih.ci.ord.s.bp.ordverify;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.dto.orderverify.d.OrderVerifyDTO;
import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocServiceExt;

/**
 * 系统审核医嘱
 * @author ly
 *
 */
public class VerifyOrderBySysBP {

	/**
	 * 系统审核医嘱 TODO
	 * @param orderIds
	 * @return
	 * @throws BizException
	 */
	public OrderVerifyDTO[] exec(String[] orderIds) throws BizException {
		//1.组织数据

		//2.调用合理用药接口...
		
		//3.组织返回数据
		IUdidocServiceExt udidocServiceExt = ServiceFinder.find(IUdidocServiceExt.class);
		UdidocDO[] udiDoc = udidocServiceExt.findByUdidoclistCode("CI.OR.0660");
		
		List<OrderVerifyDTO> result = new ArrayList<OrderVerifyDTO>();
		//TEST CODE TODO
		int i = 0;
		for (String ordId : orderIds) {
			OrderVerifyDTO orderDTO = new OrderVerifyDTO();
			orderDTO.setId_or(ordId);
			orderDTO.setDes_verify_sys("机器人说没问题了");
			orderDTO.setSd_excep_level_sys("0");
			
			if(i%3 == 0){
				orderDTO.setSd_excep_level_sys("1");
			}
			
			for (UdidocDO doc : udiDoc) {
				if(doc.getCode().equals(orderDTO.getSd_excep_level_sys())){
					orderDTO.setId_excep_level_sys(doc.getId_udidoc());
					orderDTO.setName_excep_level_sys(doc.getName());
					break;
				}
			}
			
			i++;
		}
		
		return result.toArray(new OrderVerifyDTO[result.size()]);
	}
}
