package iih.ci.ord.s.ortmpl.bp;

import iih.bd.base.cache.CacheContext;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.srv.cherbboilmd.d.CHerbBoilMdDO;
import iih.bd.srv.freqdef.d.FreqDefDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medusage.d.MedUsageDO;
import iih.bd.srv.ortpl.d.OrTmplDO;
import iih.bd.srv.ortpl.d.OrTplItmTypeEnum;
import iih.bd.srv.ortpl.d.OrTplNItmDO;
import iih.ci.ord.dto.newordertemplatedto.d.NewOrderTemplateDTO;
import iih.ci.ord.dto.ordsrvchangeddto.d.OrdSrvChangedInfoDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.assi.bp.GetSrvPriceBP;
import iih.ci.ord.s.bp.ordsrvchangedval.OrdChangedSrvValidateBP;
import iih.ci.ord.s.ortmpl.bp.qry.GetCHerbBoilMdDOsQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetFreqDefDOsQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetMeasDocDOsQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetMedSrvSetItemDOQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetMedUsageDOsQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetOrTmplDOQry;
import iih.ci.ord.s.ortmpl.bp.qry.GetOrTplNItmDOQry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;
import xap.sys.xbd.measdoc.d.MeasDocDO;

/**
 * 医嘱模板明细查询
 * @author Young
 *
 */
public class GetOrTplNItmDTOsBP extends CacheContext {
	
	private CiEnContextDTO ctx;
	
	private Map<String, List<OrTplNItmDO>> mapOrTplNItmDOs;//医嘱模板明细

	private Map<String, OrTmplDO> mapOrTmplDOsRef;//明细项目引用的基础医嘱模板
	private Map<String, List<OrTplNItmDO>> mapOrTplNItmDOsRef;//引用的基础医嘱模板的明细
	
	private Map<String, String> checkSrvValRst;
	
	private Map<String, FDouble> srvMapPrice;// 非物品价格
	private Map<String, FDouble> mmMapPrice;// 物品价格

	private Map<String, String> srvMapMedical;// 非物品医保目录
	private Map<String, String> mmMapMedical;// 物品医保目录

	/**
	 * 构造函数
	 * @param ctx
	 * @throws BizException
	 */
	public GetOrTplNItmDTOsBP(CiEnContextDTO ctx) {
		this.ctx = ctx;
		
		this.mapOrTplNItmDOs = new HashMap<String, List<OrTplNItmDO>>();
		this.mapOrTmplDOsRef = new HashMap<String, OrTmplDO>();
		this.mapOrTplNItmDOsRef = new HashMap<String, List<OrTplNItmDO>>();
	}

	/**
	 * 医嘱模板明细查询
	 * @param idortmpls 医嘱模板ID
	 * @return
	 * @throws BizException
	 */
	public FMap getOrderTemplateDTO(String[] idortmpls) throws BizException {
		return getOrderTemplateDTO(idortmpls, ctx.getEnt4BannerDTO().getId_pripat(), 
				ctx.getId_hp_default(), ctx.getEnt4BannerDTO().getCode_entp());
	}
	
	/**
	 * 医嘱模板明细查询
	 * @param idortmpls
	 * @param idpripat
	 * @param idhp
	 * @param sdentp
	 * @return
	 * @throws BizException
	 */
	public FMap getOrderTemplateDTO(String[] idortmpls, String idpripat, String idhp, String sdentp)
			throws BizException {

		String stridortmpls = CiOrdUtils.IdsConveretCharacterString(idortmpls);
		OrTmplDO[] orTmplDOs = this.getOrTmplDOs(stridortmpls, this.getstrFgentp(sdentp));
		
		OrTplNItmDO[] orTplNItmDOs = this.getOrTplNItmDOs(stridortmpls);
		mapOrTplNItmDOs.clear();
		if (orTplNItmDOs != null && orTplNItmDOs.length > 0) {
			for (int i = 0; i < orTplNItmDOs.length; i++) {
				if (mapOrTplNItmDOs.containsKey(orTplNItmDOs[i].getId_ortmpl())) {
					mapOrTplNItmDOs.get(orTplNItmDOs[i].getId_ortmpl()).add(orTplNItmDOs[i]);
				} else {
					List<OrTplNItmDO> lst = new ArrayList<OrTplNItmDO>();
					lst.add(orTplNItmDOs[i]);
					mapOrTplNItmDOs.put(orTplNItmDOs[i].getId_ortmpl(), lst);
				}
			}
		}
		
		Map<String, FArrayList> mapOrTplNItmDTOs = new HashMap<String, FArrayList>();
		if (orTmplDOs != null && orTmplDOs.length > 0) {
			String strIdtmpl = "";
			String strIdset = "";
			for(OrTmplDO orTmplDO : orTmplDOs){
				List<OrTplNItmDO> orTplItem = mapOrTplNItmDOs.get(orTmplDO.getId_ortmpl());
				if (orTplItem == null)
					continue;
				for (OrTplNItmDO itmDO : orTplItem) {
					if (OrTplItmTypeEnum.ORTMPL.equals(itmDO.getEu_ortplitmtp())) {
						strIdtmpl += ",'" + itmDO.getId_srv() + "'";
					} else if (OrTplItmTypeEnum.SRVSET.equals(itmDO.getEu_ortplitmtp())) {
						strIdset += ",'" + itmDO.getId_srv() + "'";
					}
				}
			}
			
			OrTmplDO[] orTmplDOsRef = null;
			if (strIdtmpl.length() > 0) {
				orTmplDOsRef = this.getOrTmplDOs(strIdtmpl.substring(1), null);
			}
			
			mapOrTmplDOsRef.clear();
			if (orTmplDOsRef != null && orTmplDOsRef.length > 0) {
				for (int i = 0; i < orTmplDOsRef.length; i++) {
					mapOrTmplDOsRef.put(orTmplDOsRef[i].getId_ortmpl(), orTmplDOsRef[i]);
				}
			}
			
			OrTplNItmDO[] orTplNItmDOsRef = null;
			if (strIdtmpl.length() > 0) {
				orTplNItmDOsRef = this.getOrTplNItmDOs(strIdtmpl.substring(1));
			}
			mapOrTplNItmDOsRef.clear();
			if (orTplNItmDOsRef != null && orTplNItmDOsRef.length > 0) {
				for (int i = 0; i < orTplNItmDOsRef.length; i++) {
					if (mapOrTplNItmDOsRef.containsKey(orTplNItmDOsRef[i].getId_ortmpl())) {
						mapOrTplNItmDOsRef.get(orTplNItmDOsRef[i].getId_ortmpl()).add(orTplNItmDOsRef[i]);
					} else {
						List<OrTplNItmDO> lst = new ArrayList<OrTplNItmDO>();
						lst.add(orTplNItmDOsRef[i]);
						mapOrTplNItmDOsRef.put(orTplNItmDOsRef[i].getId_ortmpl(), lst);
					}
				}
			}
			
			
			Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs = new HashMap<String, List<MedSrvSetItemDO>>();
			if(strIdset.length() > 0){
				MedSrvSetItemDO[] itmDOs = getMedSrvSetItemDOs(strIdset.substring(1));
				if (itmDOs != null && itmDOs.length > 0) {
					for (MedSrvSetItemDO itmDO : itmDOs) {
						if (mapMedSrvSetItemDOs.containsKey(itmDO.getId_srv())) {
							mapMedSrvSetItemDOs.get(itmDO.getId_srv()).add(itmDO);
						} else {
							List<MedSrvSetItemDO> lst = new ArrayList<MedSrvSetItemDO>();
							lst.add(itmDO);
							mapMedSrvSetItemDOs.put(itmDO.getId_srv(), lst);
						}
					}
				}
			}
			
			for (OrTmplDO orTmplDO : orTmplDOs) {
				FArrayList lstOrTplNItmDTOs = new FArrayList();
				this.getOrTplNItmDTOs(orTmplDO, lstOrTplNItmDTOs, mapMedSrvSetItemDOs);
				if (lstOrTplNItmDTOs != null && lstOrTplNItmDTOs.size() != 0) {
					mapOrTplNItmDTOs.put(orTmplDO.getId_ortmpl(), lstOrTplNItmDTOs);
				}
			}
		}
		
		// 服务集合
		this.getItemInfo(mapOrTplNItmDTOs, idpripat, idhp, sdentp);
		
		// 设置价格 医保和服务的启停
		this.setItemInfo(mapOrTplNItmDTOs);
		
		FMap mapRst = new FMap();
		for (String key : mapOrTplNItmDTOs.keySet()) {
			mapRst.put(key, mapOrTplNItmDTOs.get(key));
		}
		return mapRst;
	}
	
	/**
	 * 查询医嘱模板
	 * @param strId
	 * @param strSdentp
	 * @return
	 * @throws BizException
	 */
	private OrTmplDO[] getOrTmplDOs(String strId,String strSdentp) throws BizException{
		GetOrTmplDOQry qryTmpl = new GetOrTmplDOQry(strId, strSdentp);
		return (OrTmplDO[]) AppFwUtil.getDORstWithDao(qryTmpl, OrTmplDO.class);
	}
	
	/**
	 * 查询明细
	 * @param strWhere
	 * @return
	 * @throws BizException
	 */
	private OrTplNItmDO[] getOrTplNItmDOs(String strWhere) throws BizException{
		GetOrTplNItmDOQry qryItem=new GetOrTplNItmDOQry(strWhere);
		return (OrTplNItmDO[]) AppFwUtil.getDORstWithDao(qryItem, OrTplNItmDO.class);
	}
	
	/**
	 * 查询套项目
	 * @param strWhere
	 * @return
	 * @throws BizException
	 */
	private MedSrvSetItemDO[] getMedSrvSetItemDOs(String strWhere) throws BizException{
		GetMedSrvSetItemDOQry qry = new GetMedSrvSetItemDOQry(strWhere);
		return (MedSrvSetItemDO[]) AppFwUtil.getDORstWithDao(qry, MedSrvSetItemDO.class);
	}
	
	/**
	 * 组装模板明细
	 * @param aggdo
	 * @param lstOrTplNItmDTOs
	 * @param mapAggDOs
	 * @param mapMedSrvSetItemDOs
	 * @throws BizException
	 */
	private void getOrTplNItmDTOs(OrTmplDO orTmplDO, FArrayList lstOrTplNItmDTOs, Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs) throws BizException {

		switch (orTmplDO.getSd_ortmpltp()) {
		case IBdSrvDictCodeConst.SD_ORTMPLTP_FHMBA:// 复合模板
		case IBdSrvDictCodeConst.SD_ORTMPLTP_RIS:// 检查模板
		case IBdSrvDictCodeConst.SD_ORTMPLTP_LIS:// 检验模板
		case IBdSrvDictCodeConst.SD_ORTMPLTP_TREAT:// 诊疗模板
			this.getOrTplNItmDTOsFH(orTmplDO, lstOrTplNItmDTOs, mapMedSrvSetItemDOs);// 综合模板
			break;
		case IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY:
			this.getOrTplNItmDTOsXCY(orTmplDO, lstOrTplNItmDTOs, false);// 成组西成药模板
			break;
		case IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ:
			this.getOrTplNItmDTOsCYFJ(orTmplDO, lstOrTplNItmDTOs, false);// 草药方剂模板
			break;
		}
	}
	
	/**
	 * 综合模板组装明细
	 * @param aggdo
	 * @param lstOrTplNItmDTOs
	 * @throws BizException
	 */
	private void getOrTplNItmDTOsFH(OrTmplDO orTmplDO, FArrayList lstOrTplNItmDTOs, Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs) throws BizException {
		if(orTmplDO != null){
			List<OrTplNItmDO> orTplItem = mapOrTplNItmDOs.get(orTmplDO.getId_ortmpl());
			if (orTplItem == null)
				return;
			for (OrTplNItmDO item : orTplItem) {
				if (OrTplItmTypeEnum.ORTMPL.equals(item.getEu_ortplitmtp())) {
					//明细项目是引用的基础模板
					OrTmplDO tempOrTmplDO = mapOrTmplDOsRef.get(item.getId_srv());
					if (IBdSrvDictCodeConst.SD_ORTMPLTP_CZXCY.equals(tempOrTmplDO.getSd_ortmpltp())) {
						// 成组西成药模板
						getOrTplNItmDTOsXCY(tempOrTmplDO, lstOrTplNItmDTOs, true);
					} else if (IBdSrvDictCodeConst.SD_ORTMPLTP_CYFJ.equals(tempOrTmplDO.getSd_ortmpltp())) {
						// 草药方剂模板
						getOrTplNItmDTOsCYFJ(tempOrTmplDO, lstOrTplNItmDTOs, true);
					}
				} else if (OrTplItmTypeEnum.SRV.equals(item.getEu_ortplitmtp())) {
					//明细项目是医疗服务
					NewOrderTemplateDTO template = new NewOrderTemplateDTO();
					template.setId(item.getId_ortmplitm());
					template.setName(orTmplDO.getName());
					template.setId_srv(item.getId_srv());
					template.setId_mm(item.getId_mm());
					template.setSd_srvtp(item.getSd_srvtp());
					template.setId_freq(item.getId_freq());
					template.setName_freq(item.getOrtplnitm_freq_name());
					template.setId_route(item.getId_route());
					template.setName_route(item.getOrtplnitm_route_name());
					template.setName_routedes(item.getOrtplnitm_boildes_name());
					template.setDays_or(item.getDays_or());
					template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					template.setTemplatetype(FBoolean.FALSE);
					
					if (item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG)
							|| item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_CYDRUG)) {
						template.setUi_flag("3");
					}else{
						if (item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
							template.setId_boil(item.getId_boil());
							template.setName_boil(item.getOrtplnitm_boil_name());
							template.setTemplatetype(FBoolean.TRUE);
							template.setUi_flag("4");
						} else if (item.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_TREAT)) {
							template.setUi_flag("6");
						} else {
							template.setUi_flag("4");
						}
					} 
					
					item.setIdentical_ortmpl(item.getId_ortmplitm());
					FArrayList itemlist = new FArrayList();
					itemlist.append(item);
					template.setItemlist(itemlist);
					lstOrTplNItmDTOs.append(template);
				} else if (OrTplItmTypeEnum.SRVSET.equals(item.getEu_ortplitmtp())) {
					//明细项目是服务套
					NewOrderTemplateDTO template = new NewOrderTemplateDTO();
					template.setId(item.getId_ortmplitm());
					template.setName(item.getOrtplnitm_srv_name());
					template.setId_srv(item.getId_srv());
					template.setName_route(item.getOrtplnitm_route_name());
					template.setName_routedes(item.getOrtplnitm_boildes_name());
					template.setName_freq(item.getOrtplnitm_freq_name());
					template.setDays_or(item.getDays_or());
					template.setOrtplnitm_mp_name(item.getOrtplnitm_mp_name());
					template.setTemplatetype(FBoolean.FALSE);
					template.setIsmuldose(item.getIsmuldose());
					template.setIsmulexec(item.getIsmulexec());
					template.setQuan_med(item.getQuan_med());
					template.setOrtplnitm_unit_name(item.getOrtplnitm_unit_name());
					template.setUi_flag("1");
					template.setItemlist(getOrTplNItmDO4Set(item, mapMedSrvSetItemDOs));
					lstOrTplNItmDTOs.append(template);
				}
			}
		}
	}
	
	/**
	 * 成组西成药模板组装明细
	 * @param aggdo
	 * @param lstOrTplNItmDTOs
	 * @throws BizException
	 */
	private void getOrTplNItmDTOsXCY(OrTmplDO orTmplDO, FArrayList lstOrTplNItmDTOs, Boolean isRef) throws BizException {
		List<OrTplNItmDO> orTplItem = isRef ? this.mapOrTplNItmDOsRef.get(orTmplDO.getId_ortmpl())
				: this.mapOrTplNItmDOs.get(orTmplDO.getId_ortmpl());
		if(orTmplDO != null && orTplItem != null && orTplItem.size() > 0){
			NewOrderTemplateDTO template = new NewOrderTemplateDTO();
			template.setId(orTmplDO.getId_ortmpl());
			template.setName(orTmplDO.getName());
			template.setName_route(orTmplDO.getOrtmpl_route_name());
			template.setName_routedes(orTmplDO.getOrtmpl_routedes_name());
			template.setDays_or(orTmplDO.getDays_or());
			template.setTemplatetype(FBoolean.FALSE);// 其它模板时N ，草药模板时 Y
			template.setUi_flag("2");
			
			FArrayList itemlist = new FArrayList();
			int num = orTplItem.size();
			int seq = 0;
			for (OrTplNItmDO item : orTplItem) {
				item.setDays_or(orTmplDO.getDays_or());
				item.setOrtplnitm_route_code(orTmplDO.getOrtmpl_route_code());
				item.setOrtplnitm_route_name(orTmplDO.getOrtmpl_route_name());
				item.setOrtplnitm_routedes_code(orTmplDO.getOrtmpl_routedes_code());
				item.setOrtplnitm_routedes_name(orTmplDO.getOrtmpl_routedes_name());
				item.setOrtplnitm_freq_code(orTmplDO.getOrtmpl_freq_code());
				item.setOrtplnitm_freq_name(orTmplDO.getOrtmpl_freq_name());
				item.setIdentical_ortmpl(orTmplDO.getId_ortmpl());

				if (num == 2) {
					if (seq == 0) {
						item.setOrtplnitm_mm_name("┏ " + item.getOrtplnitm_mm_name());
						item.setOrtplnitm_srv_name("┏ " + item.getOrtplnitm_srv_name());
					} else {
						item.setOrtplnitm_mm_name("┗ " + item.getOrtplnitm_mm_name());
						item.setOrtplnitm_srv_name("┗ " + item.getOrtplnitm_srv_name());
					}

				} else if (num > 2) {
					if (seq == 0) {
						item.setOrtplnitm_mm_name("┏ " + item.getOrtplnitm_mm_name());
						item.setOrtplnitm_srv_name("┏ " + item.getOrtplnitm_srv_name());
					} else if (seq == num - 1) {
						item.setOrtplnitm_mm_name("┗ " + item.getOrtplnitm_mm_name());
						item.setOrtplnitm_srv_name("┗ " + item.getOrtplnitm_srv_name());
					} else {
						item.setOrtplnitm_mm_name("┠ " + item.getOrtplnitm_mm_name());
						item.setOrtplnitm_srv_name("┠ " + item.getOrtplnitm_srv_name());
					}
				}
				itemlist.append(item);
				seq++;
			}
			template.setId_srv(orTplItem.get(0).getId_srv());
			template.setId_mm(orTplItem.get(0).getId_mm());
			template.setSd_srvtp(orTplItem.get(0).getSd_srvtp());
			template.setOrtplnitm_mp_name(orTplItem.get(0).getOrtplnitm_mp_name());
			template.setName_freq(orTplItem.get(0).getOrtplnitm_freq_name());
			
			template.setItemlist(itemlist);
			lstOrTplNItmDTOs.append(template);
		}
	}

	/**
	 * 草药方剂模板组装明细
	 * @param aggdo
	 * @param lstOrTplNItmDTOs
	 * @throws BizException
	 */
	private void getOrTplNItmDTOsCYFJ(OrTmplDO orTmplDO, FArrayList lstOrTplNItmDTOs, Boolean isRef) throws BizException {
		List<OrTplNItmDO> orTplItem = isRef ? this.mapOrTplNItmDOsRef.get(orTmplDO.getId_ortmpl())
				: this.mapOrTplNItmDOs.get(orTmplDO.getId_ortmpl());
		if(orTmplDO != null && orTplItem != null && orTplItem.size() > 0){
			NewOrderTemplateDTO template = new NewOrderTemplateDTO();
			template.setId(orTmplDO.getId_ortmpl());
			template.setName(orTmplDO.getName());
			template.setId_boil(orTmplDO.getId_boil());
			template.setName_boil(orTmplDO.getOrtmpl_boil_name());
			template.setId_route(orTmplDO.getId_route());
			template.setName_route(orTmplDO.getOrtmpl_route_name());
			template.setName_routedes(orTmplDO.getOrtmpl_routedes_name());
			template.setId_freq(orTmplDO.getId_freq());
			template.setName_freq(orTmplDO.getOrtmpl_freq_name());
			template.setOrders(orTmplDO.getOrders());
			template.setUi_flag("5");
			template.setTemplatetype(FBoolean.TRUE);// 其它模板时N ，草药模板时 Y
			
			template.setFreqdefdo(this.getFreqDefDO());
			template.setMeasdocdo(this.getMeasDocDO());
			template.setRoutedo(this.getRouteDO());
			template.setBoildo(this.getBoilDO());
			
			FArrayList itemlist = new FArrayList();
			for (OrTplNItmDO item : orTplItem) {
				item.setOrders(orTmplDO.getOrders());
				item.setIdentical_ortmpl(orTmplDO.getId_ortmpl());
				item.setId_boil(orTmplDO.getId_boil());
				item.setOrtplnitm_boil_name(orTmplDO.getOrtmpl_boil_name());
				
				itemlist.append(item);
			}
			template.setId_srv(orTplItem.get(0).getId_srv());
			template.setId_mm(orTplItem.get(0).getId_mm());
			template.setSd_srvtp(orTplItem.get(0).getSd_srvtp());
			template.setDays_or(orTplItem.get(0).getDays_or());
			template.setOrtplnitm_mp_name(orTplItem.get(0).getOrtplnitm_mp_name());
			template.setItemlist(itemlist);
			lstOrTplNItmDTOs.append(template);
		}
	}
	
	/**
	 * 
	 * @param ortmpl
	 * @param mapMedSrvSetItemDOs
	 * @return
	 * @throws BizException
	 */
	private FArrayList getOrTplNItmDO4Set(OrTplNItmDO ortmpl, Map<String, List<MedSrvSetItemDO>> mapMedSrvSetItemDOs) throws BizException {
		List<MedSrvSetItemDO> itmDOs = mapMedSrvSetItemDOs.get(ortmpl.getId_srv());
		FArrayList list = new FArrayList();
		if (itmDOs != null) {
			setOrTplNItmDO(list, itmDOs.toArray(new MedSrvSetItemDO[] {}), ortmpl);
		}
		return list;
	}
	
	/**
	 * 模板是套时 套内明细内容
	 * @param list
	 * @param itmDOs
	 * @param ortmpl
	 */
	private void setOrTplNItmDO(FArrayList list, MedSrvSetItemDO[] itmDOs, OrTplNItmDO ortmpl) {
		if (itmDOs != null && itmDOs.length > 0) {
			for (MedSrvSetItemDO medSrvset : itmDOs) {
				OrTplNItmDO item = new OrTplNItmDO();
				item.setId_ortmpl(ortmpl.getId_ortmpl());
				item.setId_srvtp(ortmpl.getId_srvtp());
				item.setSd_srvtp(ortmpl.getSd_srvtp());
				item.setOrtplnitm_mm_name(ortmpl.getOrtplnitm_srv_name());//借用这个字段存套的名称，需求还在待优化
				
				item.setId_ortmplitm(medSrvset.getId_srv_itm() + medSrvset.getId_srv());
				item.setId_srv(medSrvset.getId_srv_itm());
				item.setOrtplnitm_srv_name(medSrvset.getSrv_name());
				item.setId_srv_set(medSrvset.getId_srv());
				item.setIdentical_ortmpl(medSrvset.getId_srv());
				
				item.setId_route(medSrvset.getId_route());
				item.setOrtplnitm_route_name(medSrvset.getRoute_name());
				item.setId_routedes(medSrvset.getId_routedes());
				item.setOrtplnitm_routedes_name(medSrvset.getRoutedes_name());
				item.setId_boil(medSrvset.getId_boil());
				item.setId_boildes(medSrvset.getId_boildes());
				item.setOrtplnitm_boildes_name(medSrvset.getBoil_name());
				item.setId_freq(medSrvset.getId_freq());
				item.setOrtplnitm_freq_name(medSrvset.getFreq_name());
				item.setQuan_med(medSrvset.getQuan_medu());
				item.setId_unit_med(medSrvset.getId_medu());
				item.setOrtplnitm_unit_name(medSrvset.getMedu_name());
				
				item.setFg_edit(medSrvset.getFg_edit());
				item.setFg_clinical(medSrvset.getFg_clinical());//套内临床标识
				list.append(item);
			}
		}
	}
	
	/**
	 * 
	 * @param mapOrTplNItmDTOs
	 * @param idpripat
	 * @param id_hp
	 * @param code_entp
	 * @throws BizException
	 */
	private void getItemInfo(Map<String, FArrayList> mapOrTplNItmDTOs, String idpripat, String id_hp, String code_entp) throws BizException {
		if (mapOrTplNItmDTOs != null && mapOrTplNItmDTOs.size() > 0) {
			
			long  startTime1 = System.currentTimeMillis();
			
			List<String> idmms = new ArrayList<String>(); // 物品id集合
			List<String> idsrvs = new ArrayList<String>();// 项目id集合
			List<OrdSrvChangedInfoDTO> infoList = new ArrayList<OrdSrvChangedInfoDTO>();
			for (String key : mapOrTplNItmDTOs.keySet()) {
				FArrayList templateList = mapOrTplNItmDTOs.get(key);
				if (templateList != null && templateList.size() > 0) {
					for (int i = 0; i < templateList.size(); i++) {
						NewOrderTemplateDTO dto = (NewOrderTemplateDTO) templateList.get(i);
						FArrayList list = dto.getItemlist();
						getItemInfo(list, idmms, idsrvs, infoList);
					}
				}
			}
			
			long  startTime2 = System.currentTimeMillis();
			iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-查询校验信息 耗时：" +(startTime2-startTime1));

			// 价格
			getPrice(idpripat, idsrvs, idmms);
			
			long  startTime3 = System.currentTimeMillis();
			iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-查询价格信息 耗时：" +(startTime3-startTime2));
			
			// 医保目录信息
			getMedicareCataLogSrv(id_hp, idsrvs);
			getMedicareCataLogMm(id_hp, idmms);
			
			long  startTime4 = System.currentTimeMillis();
			iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-查询医保目录信息 耗时：" +(startTime4-startTime3));
			
			// 服务是否停用校验
			if (infoList != null && infoList.size() > 0) {
				OrdChangedSrvValidateBP bp = new OrdChangedSrvValidateBP();
				checkSrvValRst = bp.exec(code_entp, infoList);
			}
			
			long  startTime5 = System.currentTimeMillis();
			iih.ci.ord.pub.CiOrdUtils.LogerOutInfo("医嘱模板-校验服务启停 耗时：" +(startTime5-startTime4));
		}
	}
	
	/**
	 * 
	 * @param list
	 * @param idmms
	 * @param idsrvs
	 * @param infoList
	 */
	private void getItemInfo(FArrayList list, List<String> idmms, List<String> idsrvs, List<OrdSrvChangedInfoDTO> infoList) {
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				OrdSrvChangedInfoDTO dto = new OrdSrvChangedInfoDTO();
				OrTplNItmDO itemDo = (OrTplNItmDO) list.get(i);
				if (itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					idmms.add(itemDo.getId_mm());
					dto.setId_srv(itemDo.getId_srv());
					dto.setId_mm(itemDo.getId_mm());
				} else {
					idsrvs.add(itemDo.getId_srv());
					if (!CiOrdUtils.isEmpty(itemDo.getId_srv_set()) && !idsrvs.contains(itemDo.getId_srv_set())) {
						idsrvs.add(itemDo.getId_srv_set());
						dto.setId_srv(itemDo.getId_srv_set());
					} else {
						dto.setId_srv(itemDo.getId_srv());
					}
				}
				infoList.add(dto);
			}
		}
	}
	
	/**
	 * 获取价格信息
	 * @param idpripat
	 * @param idsrvs
	 * @param idmms
	 */
	private void getPrice(String idpripat, List<String> idsrvs, List<String> idmms) {
		GetSrvPriceBP priceBP = new GetSrvPriceBP();
		srvMapPrice = priceBP.getSrvPrice(idpripat, idsrvs);
		mmMapPrice = priceBP.getMMPrice(idmms);
	}
	
	/**
	 * 医保目录 非药品
	 * @param id_hp
	 * @param id_srvs
	 * @throws DAException
	 */
	@SuppressWarnings("unchecked")
	private void getMedicareCataLogSrv(String id_hp, List<String> id_srvs) throws DAException {
		if(StringUtils.isNotEmpty(id_hp)) {
			String sql = "select bd_hp_srvorca.id_srv,bd_udidoc.name from bd_hp_srvorca,bd_udidoc "
					+ " where bd_hp_srvorca.id_hpsrvtp=bd_udidoc.id_udidoc and bd_hp_srvorca.id_hp='" + id_hp
					+ "' and bd_hp_srvorca.id_srv in (" + CiOrdUtils.ListConveretCharacterString(id_srvs) + ")";
			srvMapMedical = new HashMap<String, String>();
			List<Map<String, Object>> priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql, new MapListHandler());
			if (priMapList != null && priMapList.size() > 0) {
				for (Map<String, Object> priObjMap : priMapList) {
					String key = (String) priObjMap.get("id_srv");
					String value = (String) priObjMap.get("name");
					srvMapMedical.put(key, value);
				}
			}
		}
	}

	/**
	 * 医保目录药品
	 * 
	 * @param id_hp
	 * @param id_mms
	 * @return
	 * @throws DAException 
	 */
	@SuppressWarnings("unchecked")
	private void getMedicareCataLogMm(String id_hp, List<String> id_mms) throws DAException {
		if(StringUtils.isNotEmpty(id_hp)) {
			String sql = "select bd_hp_srvorca.id_mm,bd_udidoc.name from bd_hp_srvorca,bd_udidoc "
					+ " where bd_hp_srvorca.id_hpsrvtp = bd_udidoc.id_udidoc and bd_hp_srvorca.id_hp='" + id_hp
					+ "' and bd_hp_srvorca.id_mm in (" + CiOrdUtils.ListConveretCharacterString(id_mms) + ")";
			mmMapMedical = new HashMap<String, String>();
			List<Map<String, Object>> priMapList = null;
			priMapList = (List<Map<String, Object>>) new DAFacade().execQuery(sql, new MapListHandler());
			if (priMapList != null && priMapList.size() > 0) {
				for (Map<String, Object> priObjMap : priMapList) {
					String key = (String) priObjMap.get("id_mm");
					String value = (String) priObjMap.get("name");
					mmMapMedical.put(key, value);
				}
			}
		}
	}

	
	/**
	 * 价格医保信息
	 * @param mapOrTplNItmDTOs
	 */
	private void setItemInfo(Map<String, FArrayList> mapOrTplNItmDTOs) {
		if (mapOrTplNItmDTOs != null && mapOrTplNItmDTOs.size() > 0) {
			for (String key:mapOrTplNItmDTOs.keySet()) {
				FArrayList templateList = mapOrTplNItmDTOs.get(key);
				if (templateList != null && templateList.size() > 0) {
					for (int i = 0; i < templateList.size(); i++) {
						NewOrderTemplateDTO dto = (NewOrderTemplateDTO)templateList.get(i);
						setInfo(dto);
					}
				}
			}
		}
	}
	
	/**
	 * 
	 * @param dto
	 */
	private void setInfo(NewOrderTemplateDTO dto) {
		if (this.srvMapPrice != null && this.srvMapPrice.containsKey(dto.getId_srv())) {
			dto.setPrice(formatePriceLength(this.srvMapPrice.get(dto.getId_srv())));
		}
		if (this.mmMapMedical != null && this.mmMapMedical.containsKey(dto.getId_srv())) {
			dto.setName_hp(this.mmMapMedical.get(dto.getId_srv()));
		}
		if (this.srvMapMedical != null && this.srvMapMedical.containsKey(dto.getId_srv())) {
			dto.setName_hp(this.srvMapMedical.get(dto.getId_srv()));
		}

		if (this.checkSrvValRst != null) {

			String key = dto.getId_srv();
			if (this.checkSrvValRst.containsKey(key)) {
				dto.setDescription(this.checkSrvValRst.get(key));
				dto.setFg_active(FBoolean.FALSE);
			} else {
				// 拼接id_srv,id_mm 作为key值
				key += StringUtils.isBlank(dto.getId_mm()) ? "" : "," + dto.getId_mm();
				if (this.checkSrvValRst.containsKey(key)) {
					dto.setDescription(this.checkSrvValRst.get(key));
					dto.setFg_active(FBoolean.FALSE);
				}
			}
		}
		
		FArrayList list = dto.getItemlist();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				OrTplNItmDO itemDo = (OrTplNItmDO) list.get(i);
				if (itemDo.getSd_srvtp() != null && itemDo.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)) {
					if (this.mmMapPrice != null && this.mmMapPrice.containsKey(itemDo.getId_srv() + "," + itemDo.getId_mm())) {
						itemDo.setPrice(formatePriceLength(this.mmMapPrice.get(itemDo.getId_srv() + "," + itemDo.getId_mm())));
					}
					if (this.mmMapMedical != null && this.mmMapMedical.containsKey(itemDo.getId_mm())) {
						itemDo.setName_hp(this.mmMapMedical.get(itemDo.getId_mm()));
					}

					if (this.checkSrvValRst != null) {
						String key = itemDo.getId_srv();
						if (this.checkSrvValRst.containsKey(key)) {
							itemDo.setDescription(this.checkSrvValRst.get(key));
							itemDo.setFg_active(FBoolean.FALSE);
						} else {
							// 拼接id_srv,id_mm作为key值
							key += StringUtils.isBlank(itemDo.getId_mm()) ? "" : "," + itemDo.getId_mm();
							if (this.checkSrvValRst.containsKey(key)) {
								itemDo.setDescription(this.checkSrvValRst.get(key));
								itemDo.setFg_active(FBoolean.FALSE);
							}
						}
					}
				} else {
					if (this.srvMapPrice != null && this.srvMapPrice.containsKey(itemDo.getId_srv())) {
						itemDo.setPrice(formatePriceLength(this.srvMapPrice.get(itemDo.getId_srv())));
					}
					if (this.srvMapMedical != null && this.srvMapMedical.containsKey(itemDo.getId_srv())) {
						itemDo.setName_hp(this.srvMapMedical.get(itemDo.getId_srv()));
					}
					if (this.checkSrvValRst != null && this.checkSrvValRst.containsKey(itemDo.getId_srv())) {
						itemDo.setDescription(this.checkSrvValRst.get(itemDo.getId_srv()));
						itemDo.setFg_active(FBoolean.FALSE);
						if (dto.getUi_flag() != null && dto.getUi_flag() == "1") {
							dto.setFg_active(FBoolean.FALSE);
							dto.setDescription(this.checkSrvValRst.get(itemDo.getId_srv()));
						}
					}
				}
			}
		}
	}

	/**
	 * 就诊类型条件字符串
	 * @param code_entp
	 * @return
	 */
	private String getstrFgentp(String code_entp) {
		String str = "";
		switch (code_entp) {
		case IEnDictCodeConst.SD_ENTP_OUTPATIENT:
			str += "fg_entp_op ='Y'";
			break;
		case IEnDictCodeConst.SD_ENTP_EMERGENCY:
			str += "fg_entp_er ='Y'";
			break;
		case IEnDictCodeConst.SD_ENTP_INPATIENT:
			str += "fg_entp_ip ='Y'";
			break;
		case IEnDictCodeConst.SD_ENTP_PHYSICALEXAM:
			str += "fg_entp_pe ='Y'";
			break;
		case IEnDictCodeConst.SD_ENTP_HOME:
			str += "fg_entp_fm ='Y'";
			break;
		}
		return str;
	}
	
	/**
	 * 价格精度处理
	 * 
	 * @param price
	 * @return
	 */
	private FDouble formatePriceLength(FDouble price) {
		if (CiOrdUtils.isEmpty(price))
			return new FDouble(0.00);
		return price.setScale(-2, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 频次集合
	 * 
	 * @throws BizException
	 */
	public FMap getFreqDefDO() throws BizException {
		FMap rstFreqInfoMap = getCache(L3SessionKeyWith(ctx), FreqDefList_Cache_Key);
		if (null == rstFreqInfoMap) {
			ITransQry qry = new GetFreqDefDOsQry(" fg_use_op='Y' ");
			FreqDefDO[] dos = (FreqDefDO[]) AppFwUtil.getDORstWithDao(qry, FreqDefDO.class);

			if (dos != null) {
				rstFreqInfoMap = new FMap();
				FArrayList freqdo = new FArrayList();
				for (FreqDefDO freq : dos) {
					FreqDefDO newFreq = new FreqDefDO();
					newFreq.setId_freq(freq.getId_freq());
					newFreq.setSd_frequnitct(freq.getSd_frequnitct());
					newFreq.setFre_name(freq.getFre_name());
					newFreq.setName(freq.getName());
					newFreq.setFreqct(freq.getFreqct());
					newFreq.setFrequnitct(freq.getFrequnitct());
					freqdo.append(newFreq);
				}
				rstFreqInfoMap.put("FreqDefDO", freqdo);
				putCache(L3SessionKeyWith(ctx), FreqDefList_Cache_Key, rstFreqInfoMap);
			}
		}
		return rstFreqInfoMap;
	}

	/**
	 * 单位集合
	 * 
	 * @throws BizException
	 */
	public FMap getMeasDocDO() throws BizException {
		FMap rstMeasDocMap = getCache(L3SessionKeyWith(ctx), MeasDocList_Cache_Key);
		if (null == rstMeasDocMap) {
			ITransQry qry = new GetMeasDocDOsQry();
			MeasDocDO[] dos = (MeasDocDO[]) AppFwUtil.getDORstWithDao(qry, MeasDocDO.class);

			if (dos != null && dos.length > 0) {
				rstMeasDocMap = new FMap();
				FArrayList measlist = new FArrayList();
				for (MeasDocDO item : dos) {
					MeasDocDO newMeasDoc = new MeasDocDO();
					newMeasDoc.setId_measdoc(item.getId_measdoc());
					newMeasDoc.setMeasdoc_name(item.getMeasdoc_name());
					measlist.append(newMeasDoc);
				}
				rstMeasDocMap.put("MeasDocDO", measlist);
				putCache(L3SessionKeyWith(ctx), MeasDocList_Cache_Key, rstMeasDocMap);
			}
		}
		return rstMeasDocMap;
	}

	/**
	 * 煎法集合
	 * 
	 * @throws BizException
	 */
	public FMap getBoilDO() throws BizException {
		FMap rstBoilInfoMap = getCache(L3SessionKeyWith(ctx), BoilDefList_Cache_Key);
		if (null == rstBoilInfoMap) {
			ITransQry qry = new GetCHerbBoilMdDOsQry();
			CHerbBoilMdDO[] dos = (CHerbBoilMdDO[]) AppFwUtil.getDORstWithDao(qry, CHerbBoilMdDO.class);

			if (dos != null && dos.length > 0) {
				rstBoilInfoMap = new FMap();
				FArrayList measlist = new FArrayList();
				for (CHerbBoilMdDO item : dos) {
					CHerbBoilMdDO mddo = new CHerbBoilMdDO();
					mddo.setId_boil(item.getId_boil());
					mddo.setName(item.getName());
					measlist.append(mddo);
				}
				rstBoilInfoMap.put("CHerbBoilMdDO", measlist);
				putCache(L3SessionKeyWith(ctx), BoilDefList_Cache_Key, rstBoilInfoMap);
			}
		}
		return rstBoilInfoMap;
	}

	/**
	 * 用法集合
	 * 
	 * @throws BizException
	 */
	public FMap getRouteDO() throws BizException {
		FMap rstRouteInfoMap = getCache(L3SessionKeyWith(ctx), RouteDefList_Cache_Key);
		if (null == rstRouteInfoMap) {
			ITransQry qry = new GetMedUsageDOsQry(IBdSrvDictCodeConst.ID_DOSAGE_HERB);
			MedUsageDO[] dos = (MedUsageDO[]) AppFwUtil.getDORstWithDao(qry, MedUsageDO.class);

			if (dos != null && dos.length > 0) {
				rstRouteInfoMap = new FMap();
				FArrayList measlist = new FArrayList();
				for (MedUsageDO medUsage : dos) {
					MedUsageDO usage = new MedUsageDO();
					usage.setId_route(medUsage.getId_route());
					usage.setName(medUsage.getName());
					measlist.append(usage);
				}
				rstRouteInfoMap.put("MedUsageDO", measlist);
				putCache(L3SessionKeyWith(ctx), RouteDefList_Cache_Key, rstRouteInfoMap);
			}
		}
		return rstRouteInfoMap;
	}

}
