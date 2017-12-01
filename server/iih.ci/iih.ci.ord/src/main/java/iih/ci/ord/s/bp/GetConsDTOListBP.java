package iih.ci.ord.s.bp;

import java.util.List;

import iih.ci.ord.ciordems.d.EmsConsItemDO;
import iih.ci.ord.dto.consdto.d.OrdConsDTO;
import iih.ci.ord.dto.patdetaildto.d.PatDetailDTO;
import iih.ci.ord.s.bp.qry.GetConsDTOQry;
import iih.en.pv.dto.d.IpDetailDTO;
import iih.en.pv.i.IEnOutQryService;

import org.apache.commons.lang.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

public class GetConsDTOListBP {

//	public EmsConsItemDO[] getConsList(String id_dep,String su_cons) throws BizException{
////		if(StringUtils.isBlank(id_dep) || StringUtils.isBlank(su_cons))return null;
////		GetConsDTOQry qry=new GetConsDTOQry(id_dep,su_cons);
////		DAFacade cade = new DAFacade();
////		List<EmsConsItemDO> cons = (List<EmsConsItemDO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(EmsConsItemDO.class));
////		return cons.toArray(new EmsConsItemDO[0]);
//		return null;
//	}
	
	public OrdConsDTO[] getConsList(String id_dep ,String str)throws BizException{
		if(StringUtils.isBlank(str)) return null;
		GetConsDTOQry qry=new GetConsDTOQry(id_dep,str);
		DAFacade cade = new DAFacade();
		List<OrdConsDTO> cons = (List<OrdConsDTO>) cade.execQuery(qry.getQrySQLStr(),new BeanListHandler(OrdConsDTO.class));
		return cons.toArray(new OrdConsDTO[0]);
	}
	
	public PatDetailDTO getConsPatDetail(String id_en)throws BizException{
		if(StringUtils.isBlank(id_en)) return null;
		IEnOutQryService qryService = ServiceFinder.find(IEnOutQryService.class);
		if(qryService==null)return null;
		IpDetailDTO patDto=qryService.getIpDetailInfo(id_en);
		PatDetailDTO consPatDto=new PatDetailDTO();
		consPatDto.setId_ent(id_en);
		consPatDto.setId_pat(patDto.getId_pat());		
		consPatDto.setName_pat(patDto.getName_pat()); 	
		consPatDto.setSex_pat(patDto.getName_sex_pat());		
		consPatDto.setTel(patDto.getTel());			 
		consPatDto.setName_nation(patDto.getName_nation());	
		consPatDto.setName_patcret	(patDto.getName_patcret()); 
		consPatDto.setName_hp(patDto.getName_hp());
		if(patDto.getName_admdiv()==null){
			consPatDto.setAddr_pat(patDto.getAddr_pat());
		}else{
			consPatDto.setAddr_pat(patDto.getName_admdiv()+patDto.getAddr_pat());	
		}
		if(consPatDto.getAddr_pat().isEmpty() || consPatDto.getAddr_pat().equals("null"))consPatDto.setAddr_pat("");
		consPatDto.setName_didef_dis(patDto.getName_didef_dis());
		consPatDto.setName_dep_phy(patDto.getName_dep_phy());	 
		consPatDto.setName_dep_nur(patDto.getName_dep_nur());	 
		consPatDto.setName_bed(patDto.getName_bed());		 
		consPatDto.setName_emp_phy(patDto.getName_emp_phy());	 
		consPatDto.setPat_age(AgeCalcUtil.getAge(patDto.getDt_birth()));		
		consPatDto.setName_idcardtp(patDto.getName_idtp());
		consPatDto.setName_idcard(patDto.getId_code());   
		consPatDto.setCode_entp(patDto.getCode_entp());

		
		return consPatDto;
	}
	
}
