package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import iih.bl.cg.service.d.BlCgIpAmtAndUncgRationDTO;
import iih.ci.ord.pub.CiOrdAppUtils;

/**
 * 总览取得费用数据
 * @author li_zheng
 *
 */
public class getBlcgAmtVsDrugRationBP {

	public String[] getBlcgAmtVsDrugRation(String id_pat,String id_ent,String code_srvca)throws BizException{
		String[] amt =new String[3];
		BlCgIpAmtAndUncgRationDTO ration= CiOrdAppUtils.getIBlcgqueryService().GetBlcgIpAmtVsDrugRation(id_pat, id_ent, code_srvca);
		amt[0] =  ration.getAvailable()+"";
		amt[1] = ration.getAmt_uncg()+"";
		amt[2] = ration.getRation()+"";
		return amt;
	}
}
