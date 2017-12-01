package iih.ci.ord.s.bp.splitlis.rule.bp;

import iih.ci.ord.s.bp.splitlis.SplitLisConst;
import iih.ci.ord.splitlis.d.LisOrderSplitDTO;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class CiOrSamptpLisSplitRule1BP {

	public void exec( Hashtable<String, List<LisOrderSplitDTO>> htors8lis,Hashtable<String, List<LisOrderSplitDTO>> rnt){
		
		String rule=SplitLisConst.getSamptpmap().get(SplitLisConst.CI_OP_LIS_SPLIT_SAMPTP_RULE0_CODE);
		List<LisOrderSplitDTO> listrnt=new ArrayList<LisOrderSplitDTO>();
		String[] options=rule.split(",");
		
		for (String s : options) {
			if(htors8lis.containsKey(s)){				
				listrnt.addAll(htors8lis.get(s));
				htors8lis.remove(s);
			}
		}
		rnt.put(SplitLisConst.CI_OP_LIS_SPLIT_SAMPTP_RULE0_CODE, listrnt);
        
	}
}
