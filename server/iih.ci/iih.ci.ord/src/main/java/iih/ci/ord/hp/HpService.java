/**
 * 
 */
package iih.ci.ord.hp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bl.hp.bdhpindicationdto.d.BdHpIndicationDTO;
import iih.bl.hp.cihpcheckdto.d.CiHpCheckDTO;
import iih.bl.hp.cihpcheckresultdto.d.CiHpCheckResultDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.pi.reg.pat.d.PatDO;
import iih.pi.reg.pat.i.IPatiMDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: HpService
 * @Description 医保的相关信息
 * @author Comsys-li_zheng
 * @date 2016年11月16日 上午11:49:12
 * @Package iih.ci.ord.hp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class HpService {
	
   /**
    * 医保适应证的接口 ，调用医保信息
    * @param bdHpIndicationDTOArr
    * @return
    * @throws BizException
    */
	public static BdHpIndicationDTO[] getHpIndication(
			BdHpIndicationDTO[] bdHpIndicationDTOArr) throws BizException {
	        //添加自己的逻辑 todo 
		    
		  return CiOrdAppUtils.getIHpQueService().getHpIndication(bdHpIndicationDTOArr);
	  }
	
	  
	
	/**
	 * 用于医生开单的各服务的合计值和配合度等需要在最后保存签署环节才能校验的校验接口，
	 * 如单方、领量、持有量等
	 * @param ciHpCheckDTO 开单需要进行校验的相关信息
	 * @return  CiHpCheckResultDTO 开单结果。
	 *    首先，获得CiHpCheckResultDTO.CheckFlag，
	 *         如果为TRUE,则校验通过，可以保存；
	 *         如果为FALSE，则校验失败，
	 *    失败，通过CiHpCheckResultDTO.FailIdorsrvMap获得失败的原因<失败的id_srv,失败原因描述>
	 * @throws BizException
	 */
	 public static CiHpCheckResultDTO checkCiHpSave(CiHpCheckDTO checkCiHpSave)throws BizException{
		 
		 return CiOrdAppUtils.getIHpQueService().checkCiHpSave(checkCiHpSave);
	 }
	
	/**
	 * 医嘱开立时医保适应证信息的提示
	 * @param id_srv
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	public static  BdHpIndicationDTO[]  getMedSrvHpService(String id_srv,String Id_mm,CiEnContextDTO ciEnContextDTO)throws BizException{
		BdHpIndicationDTO[] bdHpIndicationDTOArr = new BdHpIndicationDTO[1];
		BdHpIndicationDTO hpIndicationDto = new BdHpIndicationDTO();
		if(ciEnContextDTO != null){
			 IPatiMDORService pipatService = (IPatiMDORService)ServiceFinder.find(IPatiMDORService.class);
			 PatDO pipatdo = pipatService.findById(ciEnContextDTO.getId_pat());
			 hpIndicationDto.setId_srv(id_srv);
				//hpIndicationDto.setCi_orsrvdo(srvdo);
				hpIndicationDto.setCi_di_itms(CiOrdUtils.getDiagItemList(ciEnContextDTO.getId_en()));
				if(pipatdo != null){
					hpIndicationDto.setPipatdo(pipatdo);
					hpIndicationDto.setSd_sex(pipatdo.getSd_sex());
					hpIndicationDto.setDt_birth(pipatdo.getDt_birth());
				}
				hpIndicationDto.setId_mm(Id_mm);
				hpIndicationDto.setFg_bb(ciEnContextDTO.getFg_bb());
				hpIndicationDto.setFg_mm(FBoolean.TRUE); //测试使药品用 todo
				hpIndicationDto.setCode_entp(ciEnContextDTO.getCode_entp());
				hpIndicationDto.setId_dep_or(ciEnContextDTO.getId_dep_or());
				//hpIndicationDto.setUse_day(ciEnContextDTO.getDays_or());
				hpIndicationDto.setId_hp(ciEnContextDTO.getId_hp());
		}
		bdHpIndicationDTOArr[0] = hpIndicationDto;
		return CiOrdAppUtils.getIHpQueService().getHpIndication(bdHpIndicationDTOArr);  	 
	  }
	
	public static  BdHpIndicationDTO[]  getMedSrvHpService(String[] id_srvs,String[] Id_mms,CiEnContextDTO ciEnContextDTO)throws BizException{
		if(CiOrdUtils.isEmpty(id_srvs)) return null;
		BdHpIndicationDTO[] bdHpIndicationDTOArr = new BdHpIndicationDTO[id_srvs.length];
		if(ciEnContextDTO != null){
			 IPatiMDORService pipatService = (IPatiMDORService)ServiceFinder.find(IPatiMDORService.class);
			 PatDO pipatdo = pipatService.findById(ciEnContextDTO.getId_pat());
			 FArrayList2 diags = CiOrdUtils.getDiagItemList(ciEnContextDTO.getId_en());
			 for(int i=0;i<id_srvs.length;i++){
				BdHpIndicationDTO hpIndicationDto = new BdHpIndicationDTO();
				hpIndicationDto.setId_srv(id_srvs[i]);
				hpIndicationDto.setCi_di_itms(diags);
				if (pipatdo != null) {
					hpIndicationDto.setPipatdo(pipatdo);
					hpIndicationDto.setSd_sex(pipatdo.getSd_sex());
					hpIndicationDto.setDt_birth(pipatdo.getDt_birth());
				}
				hpIndicationDto.setId_mm(Id_mms[i]);
				hpIndicationDto.setFg_bb(ciEnContextDTO.getFg_bb());
				if(CiOrdUtils.isEmpty(Id_mms[i])){
					hpIndicationDto.setFg_mm(FBoolean.FALSE);
				}else{
					hpIndicationDto.setFg_mm(FBoolean.TRUE);
				}
				hpIndicationDto.setCode_entp(ciEnContextDTO.getCode_entp());
				hpIndicationDto.setId_dep_or(ciEnContextDTO.getId_dep_or());
				hpIndicationDto.setId_hp(ciEnContextDTO.getId_hp());
				bdHpIndicationDTOArr[i] = hpIndicationDto;
			 }
			 return CiOrdAppUtils.getIHpQueService().getHpIndication(bdHpIndicationDTOArr);
		}
		return null;
	  }
	
	/**
	 * 查询医保信息参数
	 * @author wangqingzhu
	 *
	 */
	public static class MedSrvHpParam{
		private String id_srv;
		private String id_mm;
		
		public MedSrvHpParam(String id_srv, String id_mm){
			this.id_srv = id_srv;
			this.id_mm = id_mm;
		}

		public String getId_srv() {
			return id_srv;
		}

		public void setId_srv(String id_srv) {
			this.id_srv = id_srv;
		}

		public String getId_mm() {
			return id_mm;
		}

		public void setId_mm(String id_mm) {
			this.id_mm = id_mm;
		}
		
		public static String MedSrvHpParam_Key(String id_srv,String id_mm){
			if (CiOrdUtils.isEmpty(id_mm)){
				return String.format("%s", id_srv);
			}
			else{
				return String.format("%s-%s", id_srv, id_mm);
			}
		}
		
	}
	
	/**
	 * 批量获取医保信息接口
	 * @param szMedSrvHpParam
	 * @param ciEnContextDTO
	 * @return
	 * @throws BizException
	 */
	public static  Map<String,BdHpIndicationDTO>  getMedSrvHpService(MedSrvHpParam[] szMedSrvHpParam,CiEnContextDTO ciEnContextDTO)throws BizException{
		if(CiOrdUtils.isEmpty(szMedSrvHpParam)||ciEnContextDTO == null) return null;
	
		List<BdHpIndicationDTO> listBdHpIndicationDTO = new ArrayList<BdHpIndicationDTO>();
		 IPatiMDORService pipatService = (IPatiMDORService)ServiceFinder.find(IPatiMDORService.class);
		 PatDO pipatdo = pipatService.findById(ciEnContextDTO.getId_pat());
		 FArrayList2 diags = CiOrdUtils.getDiagItemList(ciEnContextDTO.getId_en());
		 for(MedSrvHpParam param : szMedSrvHpParam){
			BdHpIndicationDTO hpIndicationDto = new BdHpIndicationDTO();
			hpIndicationDto.setId_srv(param.getId_srv());
			hpIndicationDto.setCi_di_itms(diags);
			if (pipatdo != null) {
				hpIndicationDto.setPipatdo(pipatdo);
				hpIndicationDto.setSd_sex(pipatdo.getSd_sex());
				hpIndicationDto.setDt_birth(pipatdo.getDt_birth());
			}
			
			hpIndicationDto.setFg_bb(ciEnContextDTO.getFg_bb());
			
			if(CiOrdUtils.isEmpty(param.getId_mm())){
				hpIndicationDto.setFg_mm(FBoolean.FALSE);
			}else{
				hpIndicationDto.setId_mm(param.getId_mm());
				hpIndicationDto.setFg_mm(FBoolean.TRUE);
			}
			hpIndicationDto.setCode_entp(ciEnContextDTO.getCode_entp());
			hpIndicationDto.setId_dep_or(ciEnContextDTO.getId_dep_or());
			hpIndicationDto.setId_hp(ciEnContextDTO.getId_hp());
			listBdHpIndicationDTO.add(hpIndicationDto);
		 }
		 BdHpIndicationDTO[] szBdHpIndicationDTO = CiOrdAppUtils.getIHpQueService().getHpIndication(listBdHpIndicationDTO.toArray(new BdHpIndicationDTO[listBdHpIndicationDTO.size()]));
		 if (szBdHpIndicationDTO==null||szBdHpIndicationDTO.length == 0){
			 return null;
		 }
		 Map<String,BdHpIndicationDTO> tmpBdHpIndicationDTOCache = new HashMap<String,BdHpIndicationDTO>();
		 for (BdHpIndicationDTO bdHpIndicationInfo : szBdHpIndicationDTO){
			 String key = MedSrvHpParam.MedSrvHpParam_Key(bdHpIndicationInfo.getId_srv(),bdHpIndicationInfo.getId_mm());
			 
			 tmpBdHpIndicationDTOCache.put(key, bdHpIndicationInfo);
		 }
		 return tmpBdHpIndicationDTOCache;
		
	  }
}

