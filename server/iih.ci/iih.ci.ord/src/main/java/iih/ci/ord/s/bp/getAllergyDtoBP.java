/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.dto.allergy.d.AllergyDto;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.pi.overview.overview.d.PiPatAlDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * @ClassName: getPiPatAlDOBP
 * @Description:  患者过敏史
 * @author Comsys-li_zheng
 * @date 2016年2月25日 下午5:02:38
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getAllergyDtoBP {

	  /**
	   * 过敏史
	   * @param id_pat
	   * @return
	   * @throws BizException
	   */
	  public AllergyDto[] exe(String id_pat) throws BizException{
		  if(id_pat == null) return null;
		  PiPatAlDO[] papatals = CiOrdAppUtils.getIPiPatAlDORService().find("a5.Id_pat = '"+id_pat+"'", PiPatAlDO.SD_ALDEG +" desc ", FBoolean.FALSE);
		  if(papatals == null || papatals.length==0) return null;
		  AllergyDto[] allergy = new AllergyDto[papatals.length];
		  for(int i = 0 ;i<papatals.length;i++){
			  AllergyDto dto =  new AllergyDto();
			  dto.setId_pat(papatals[i].getId_pat());
			  dto.setName_alcla(papatals[i].getName_alcla());
			  dto.setName_altp(papatals[i].getName_altp());
			  dto.setId_patal(papatals[i].getId_patal());
			  allergy[i]=dto;
		  }
		  return allergy;
	  }
	
}
