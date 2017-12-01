package iih.ci.ord.s.bp.srvpri;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.pp.dto.d.PriStdSrvDTO;
import iih.bd.pp.dto.d.SrvPricalRateAndPriceDTO;
import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvPriceDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEmsSrvDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.log.OrdBizLogger;
import iih.ci.ord.srvpri.d.BdSrvPriCalParamDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.BizRuntimeException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;

public class CiOrSrvPriCalUtils {
	/**
	 * 折扣价，为srv中赋折扣价相关参数（折扣价，标准价，折扣系数，患者的价格分类）
	 * @param code_entp
	 * @param srvdto
	 * @param srvdo
	 * @throws BizException
	 */
	public static void mappingPriceRateFromEmsToSrv(String code_entp,CiEmsSrvDTO srvdto,OrdSrvDO srvdo) throws BizException{
		if (CiOrdUtils.isIpWf(code_entp)){//住院
			FDouble price = FDouble.ZERO_DBL;
			if (CiOrdUtils.isSrvMMPri8Id(srvdto.getId_primd())) {// 对应物品价格
				price =  CiOrdUtils.getOrSrvMMPrice(srvdto.getId_mm(), srvdto.getId_unit_sale());
			} else {
				price = CiOrdUtils.getOrSrvPrice(code_entp, srvdto.getId_srv(),
						srvdto.getPrice(), srvdto.getId_primd());
			}
			srvdo.setPri(price);
			srvdo.setPri_std(price);
		}else{
			CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO",CiEnContextDTO.class);
			long tBeginTime = System.currentTimeMillis();
			if(CiOrdUtils.isEmpty(srvdto.getPrice())||CiOrdUtils.isEmpty(srvdto.getPri_std())||CiOrdUtils.isEmpty(srvdto.getPri_ratio())){
				FDouble[] priRats = getOrSrvPrice(code_entp, srvdto);
				if(priRats!=null){
					srvdo.setPri(priRats[0]);
					srvdo.setPri_std(priRats[1]);
				}
			}else{
				CiOrdUtils.assignPriratToSrvDO(srvdto,srvdo);
			}
			OrdBizLogger.info(cienContext, String.format("计算服务[%s]价格，耗时:%s(ms)", srvdto.getName_srv(),System.currentTimeMillis()-tBeginTime));
			
			srvdo.setId_pripat(cienContext.getEnt4BannerDTO().getId_pripat());
			if(!CiOrdUtils.isEmpty(srvdo.getPri())&&!CiOrdUtils.isEmpty(srvdo.getPri_std()))
				if(!CiOrdUtils.isEmpty(srvdo.getPri_std())&&srvdo.getPri_std().toDouble()!=0){
					srvdo.setPri_ratio(srvdo.getPri().div(srvdo.getPri_std()));//折扣系数
				}
		}
		
	}
	/**
	 * 折扣价，为srv中赋折扣价相关参数（折扣价，标准价，折扣系数，患者的价格分类）
	 * @param code_entp
	 * @param srvdto
	 * @param srvdo
	 * @throws BizException
	 */
	public static void mappingPriceRateFromEmsToSrv(String code_entp,String id_srv,String id_primd,OrdSrvDO srvdo) throws BizException{
		if (CiOrdUtils.isIpWf(code_entp)){//住院
			if(IBdPrimdCodeConst.ID_PRI_SRV.equals(id_primd)){//本服务定价
				FDouble price = CiOrdAppUtils.getPriCalService().CalSingleSrvStdPrice(id_srv);
				srvdo.setPri(price);
				srvdo.setPri_std(price);
			}
		}else{
			CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
			BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
			CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO",CiEnContextDTO.class);
			String id_pripat = cienContext.getEnt4BannerDTO().getId_pripat();
			param.setId_srv(id_srv);
			param.setId_primd(id_primd);
			MedSrvPriceDO srvprice = bp.exec(param,id_pripat);
			if(!CiOrdUtils.isEmpty(srvprice)){
				srvdo.setPri(srvprice.getPrice_ratio());
				srvdo.setPri_std(srvprice.getPrice_std());
			}
			srvdo.setId_pripat(cienContext.getEnt4BannerDTO().getId_pripat());
			if(!CiOrdUtils.isEmpty(srvdo.getPri_std())&&srvdo.getPri_std()!=FDouble.ZERO_DBL){
				srvdo.setPri_ratio(srvdo.getPri().div(srvdo.getPri_std()));//折扣系数
			}
		}
	}
		
	/**
	 * 折扣价，成员个数定价，返回价格服务
	 * @param Id_srv_set
	 * @param num
	 * @return
	 * @throws BizException 
	 */
	public static PriStdSrvDTO[] CalSrvSetFIXPrices(String Id_srv_set,int num) throws BizException{
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getEnt4BannerDTO().getCode_entp();
		if (CiOrdUtils.isIpWf(code_entp)){//住院
			return CiOrdAppUtils.getPriCalService().CalSrvSetFIXPrices(Id_srv_set, num);
		}else{
			String id_pripat = cienContext.getEnt4BannerDTO().getId_pripat();
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvSetFIXPricesByIdPripat_map(Id_srv_set, num, id_pripat);
			Map<String,SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap =	 priMap.get(Id_srv_set);
			return getPriStdSrvDTOs(srvPricalRateAndPriceDTOMap,Id_srv_set,id_pripat);
		}
	}
	/**
	 * 折扣价，个数加收，返回价格服务
	 * @param Id_srv_set
	 * @param num
	 * @return
	 * @throws BizException
	 */
	public static PriStdSrvDTO[] CalSrvSetMUPrices(String Id_srv_set,int num) throws BizException{
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getEnt4BannerDTO().getCode_entp();
		if (CiOrdUtils.isIpWf(code_entp)) {// 住院
			return CiOrdAppUtils.getPriCalService().CalSrvSetMUPrices(Id_srv_set, num);
		} else {
			String id_pripat = cienContext.getEnt4BannerDTO().getId_pripat();
			Map<String, Map<String, SrvPricalRateAndPriceDTO>> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvSetMUPricesByIdPripat_map(Id_srv_set, num, id_pripat);
			Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap = priMap.get(Id_srv_set);
			return getPriStdSrvDTOs(srvPricalRateAndPriceDTOMap, Id_srv_set, id_pripat);
		}
	}
	/**
	 * 折扣价，组合定价的服务
	 * @param Id_srv
	 * @return
	 * @throws BizException
	 */
	public static PriStdSrvDTO[] CalSrvCompPrice(String Id_srv) throws BizException{
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO", CiEnContextDTO.class);
		String code_entp = cienContext.getEnt4BannerDTO().getCode_entp();
		if (CiOrdUtils.isIpWf(code_entp)) {// 住院
			return CiOrdAppUtils.getPriCalService().CalSrvCompPrice(Id_srv);
		} else {
			String id_pripat = cienContext.getEnt4BannerDTO().getId_pripat();
			Map<String, SrvPricalRateAndPriceDTO> priMap = CiOrdAppUtils.getPriCalService()
					.CalSrvCompPriceByIdPripat_map(Id_srv, id_pripat);
			return getPriStdSrvDTOs(priMap, Id_srv, id_pripat);
		}
	}
	private static PriStdSrvDTO[] getPriStdSrvDTOs(Map<String, SrvPricalRateAndPriceDTO> srvPricalRateAndPriceDTOMap ,String Id_srv_set,String id_pripat){
		List<PriStdSrvDTO> listPriStdSrvDTO = new ArrayList<PriStdSrvDTO>();
		for (SrvPricalRateAndPriceDTO srvPricalRat : srvPricalRateAndPriceDTOMap.values()) {
			
			if(StringUtils.isNotBlank(srvPricalRat.getError_msg())){
				throw new BizRuntimeException(srvPricalRat.getError_msg());
			}
			PriStdSrvDTO priStdSrv = new PriStdSrvDTO();
			priStdSrv.setId_srv(srvPricalRat.getId_srv());
			priStdSrv.setId_pripat(id_pripat);
			priStdSrv.setPrice(srvPricalRat.getPrice_ratio());//折扣价
			priStdSrv.setQuan(srvPricalRat.getQuan());
			priStdSrv.setAttrVal("Pri_std", srvPricalRat.getPrice());//标准价
			priStdSrv.setAttrVal("Pri_ratio", srvPricalRat.getRate());//价格系数
			listPriStdSrvDTO.add(priStdSrv);
		}
		PriStdSrvDTO[] prisrvs = listPriStdSrvDTO.toArray(new PriStdSrvDTO[listPriStdSrvDTO.size()]);
		return prisrvs;
	}
	/**
	 * @param code_entp
	 * @param emssrv
	 * @return 0:折扣价，1：标准价
	 *
	 * 
	 * @throws BizException
	 */
	private static FDouble[] getOrSrvPrice(String code_entp,CiEmsSrvDTO emssrv) throws BizException{
		if (!CiOrdUtils.isOpWf(code_entp)&&!CiOrdUtils.isUrgentWf(code_entp))
			return null; // 不是门急诊则返回
		
		if (CiOrdUtils.isSrvMMPri8Id(emssrv.getId_primd())&&CiOrdUtils.isEmpty(emssrv.getPrice())) {// 对应物品价格
			FDouble price = CiOrdUtils.getOrSrvMMPrice(emssrv.getId_mm(), emssrv.getId_unit_sale());
			return new FDouble[]{price,price};
		} 
		if (emssrv.getFg_mm() == FBoolean.TRUE && !CiOrdUtils.isEmpty(emssrv.getPrice()))
			return new FDouble[]{emssrv.getPrice(),emssrv.getPrice()}; 
//		if (!CiOrdUtils.isSrvSelfPrimd8Id(emssrv.getId_primd()))
//			return null; // 不是本服务定价则返回
		CiOrBdSrvPriceCalBP bp = new CiOrBdSrvPriceCalBP();
		CiEnContextDTO cienContext = Context.get().getAttribute("CiEnContextDTO",CiEnContextDTO.class);
		MedSrvPriceDO srvprice = bp.exec(getBdSrvPriCalParamDTOFrom(emssrv),cienContext.getEnt4BannerDTO().getId_pripat());
		if(!CiOrdUtils.isEmpty(srvprice)){
			return new FDouble[]{srvprice.getPrice_ratio(),srvprice.getPrice_std()};
		}else{
;			return new FDouble[]{FDouble.ZERO_DBL,FDouble.ZERO_DBL};
		}
	}
	private static BdSrvPriCalParamDTO getBdSrvPriCalParamDTOFrom(CiEmsSrvDTO emssrv){
		BdSrvPriCalParamDTO param = new BdSrvPriCalParamDTO();
		param.setId_srv(emssrv.getId_srv());
		param.setId_primd(emssrv.getId_primd());
		return param;
	}
}
