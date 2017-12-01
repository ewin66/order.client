package iih.ci.ord.s.bp.splitlis.rule.bp;

import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.s.bp.splitlis.SplitLisConst;
import iih.ci.ord.splitlis.d.LisOrderSplitDTO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CiOrNotSamptpLisSplitRuleBP {

	public void exec( Hashtable<String, List<LisOrderSplitDTO>> htors8lis,Hashtable<String, List<LisOrderSplitDTO>> rnt){
		
		String rule=SplitLisConst.getSamptpmap().get(SplitLisConst.CI_OP_LIS_SPLIT_DEPMP_RULE0_CODE);
		List<LisOrderSplitDTO> listrnt=new ArrayList<LisOrderSplitDTO>();

		
		if (htors8lis == null && htors8lis.isEmpty())
			return ;
		Iterator entrys = htors8lis.entrySet().iterator();

		while (entrys.hasNext()) {
			Map.Entry entry = (Map.Entry) entrys.next();
			String key = (String) entry.getKey();
			List<LisOrderSplitDTO> orderList = (List) entry.getValue();
			listrnt.addAll(orderList);
		}
		rnt.put(SplitLisConst.CI_OP_LIS_SPLIT_SAMPTP_NOTRULE_CODE, listrnt);
	}
}
