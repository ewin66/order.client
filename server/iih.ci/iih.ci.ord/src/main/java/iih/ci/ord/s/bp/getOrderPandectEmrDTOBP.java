package iih.ci.ord.s.bp;

import iih.ci.mr.cimrfs.d.CiMrFsDO;
import iih.ci.mr.mrdocrefvalue.d.MrDocRefValueDO;
import iih.ci.mr.mrserviceext.i.IMrServiceExt;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.ord.dto.orderpandectemrdto.d.OrderPandectEmrDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;

/**
 * 门诊住院病历信息
 * @author li_zheng
 *
 */
public class getOrderPandectEmrDTOBP {

	public OrderPandectEmrDTO[] exec(String enttp,String id_ent)throws BizException{
		IMrServiceExt MrservrExt = CiOrdAppUtils.getIMrServiceExt();
		//S.01  主诉
		//S.03  现病史
		//S.04 既往史
		String[] arrRefCode = new String[]{IMrPubConst.DG_ZS,IMrPubConst.DG_XBS,IMrPubConst.DG_JWS};
		MrDocRefValueDO[] mrdo = MrservrExt.GetSpecRefs(id_ent, arrRefCode);
		if(mrdo == null) return  null;
		OrderPandectEmrDTO[] pandectEmrDTO = new OrderPandectEmrDTO[1];
		 int i = 0;
		 OrderPandectEmrDTO drmdot = new OrderPandectEmrDTO();
		for(MrDocRefValueDO mrRefValue:mrdo){
			if( IMrPubConst.DG_ZS.equals(mrRefValue.getCode_element())){
				drmdot.setMainsuit_name("主诉");
				drmdot.setMainsuit_value(mrRefValue.getContent());
			}
			if( IMrPubConst.DG_XBS.equals(mrRefValue.getCode_element())){
				drmdot.setNewillnes_name("现病史");
				drmdot.setNewillnes_value(mrRefValue.getContent());
			}
			if(IMrPubConst.DG_JWS.equals(mrRefValue.getCode_element())){
				drmdot.setHistoryillnes_name("既往史");
				drmdot.setHistoryillnes_value(mrRefValue.getContent());
			} 
	    } 
		pandectEmrDTO[0] = drmdot;
		return  pandectEmrDTO;
	}
}
