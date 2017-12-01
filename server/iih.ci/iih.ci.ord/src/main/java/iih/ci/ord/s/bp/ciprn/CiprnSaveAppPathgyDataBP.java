package iih.ci.ord.s.bp.ciprn;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppPathgySheetDO;
import iih.ci.ord.app.d.CiAppPathgySheetSampDO;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.d.CiapppathgysheetAggDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.OrdApPathgySampDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

import com.mysql.jdbc.StringUtils;

/**
 * 病理打印数据保存
 * @author YANG
 *
 */
public class CiprnSaveAppPathgyDataBP {

	/**
	 * 保存检查打印数据
	 * @param ciors 医嘱集合
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public FBoolean exec(CiOrderDO[] ciors, CiOrSessionDO session) throws BizException {
		if (ciors == null || ciors.length <= 0 || !CiOrdUtils.isOpUrgentWf(ciors[0].getCode_entp()))
			return null;
		List<CiOrderDO> lstCiOrderDOs = new ArrayList<CiOrderDO>();
		String strIdors = "";
		for (CiOrderDO cior : ciors) {
			if (!StringUtils.isNullOrEmpty(cior.getSd_srvtp()) 
					&& cior.getSd_srvtp().startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				lstCiOrderDOs.add(cior);
				strIdors += "'" + cior.getId_or() + "',";
			}
		}
		if (lstCiOrderDOs == null || lstCiOrderDOs.size() <= 0)
			return null;
		CiorapppathgyAggDO[] apppathgyAggDOs = CiprnUtils.GetCiorapppathgyAggDOs(strIdors.substring(0, strIdors.length() - 1));
		Map<String, CiorapppathgyAggDO> map = new HashMap<String, CiorapppathgyAggDO>();
		for (CiorapppathgyAggDO aggDO : apppathgyAggDOs) {
			map.put(aggDO.getParentDO().getId_or(), aggDO);
		}
		CiapppathgysheetAggDO[] aggDOs = getCiapppathgysheetAggDOs(lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]), map, session);
		CiprnUtils.SaveCiorapppathgyAggDOs(aggDOs);
		return FBoolean.TRUE;
	}
	
	/**
	 * 
	 * @param ciors
	 * @param map
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiapppathgysheetAggDO[] getCiapppathgysheetAggDOs(CiOrderDO[] ciors, Map<String, CiorapppathgyAggDO> map, CiOrSessionDO session) throws BizException{
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		Ent4BannerDTO banner = null;
		if(context != null){
			 banner = context.getEnt4BannerDTO();	
		}
		
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setId_en(ciors[0].getId_en());
		String[] pathgyNOs = CiOrdUtils.generateNormNOs(ciors.length, ciAppRisSheetDO, 1, 21);
		int i = 0;
		List<CiapppathgysheetAggDO> lstAggDOs = new ArrayList<CiapppathgysheetAggDO>();
		for (CiOrderDO cior : ciors) {
			CiAppPathgySheetDO pathgySheetDO = new CiAppPathgySheetDO();
			pathgySheetDO.setId_pat(cior.getId_pat());
			pathgySheetDO.setId_entp(cior.getId_entp());
			pathgySheetDO.setCode_entp(cior.getCode_entp());
			pathgySheetDO.setId_en(cior.getId_en());
			pathgySheetDO.setFg_hp(cior.getFg_orhp());
			pathgySheetDO.setFg_bb(cior.getFg_bb());
			pathgySheetDO.setNo_bb(cior.getNo_bb());
			pathgySheetDO.setId_di(map.get(cior.getId_or()).getParentDO().getId_di());
			pathgySheetDO.setId_diitm(map.get(cior.getId_or()).getParentDO().getId_diitm());
			pathgySheetDO.setStr_id_diitm(map.get(cior.getId_or()).getParentDO().getStr_id_diitm());
			pathgySheetDO.setStr_code_di(map.get(cior.getId_or()).getParentDO().getStr_code_di());
			pathgySheetDO.setStr_name_di(map.get(cior.getId_or()).getParentDO().getStr_name_di());
			pathgySheetDO.setName_diag(map.get(cior.getId_or()).getParentDO().getName_diag());
			pathgySheetDO.setId_or(cior.getId_or());
			pathgySheetDO.setId_appathgy(map.get(cior.getId_or()).getParentDO().getId_appathgy());
			pathgySheetDO.setId_srv(cior.getId_srv());
			pathgySheetDO.setFg_set(cior.getFg_set());
			pathgySheetDO.setNo_applyform(map.get(cior.getId_or()).getParentDO().getNo_applyform());
			pathgySheetDO.setCode_app(pathgyNOs[i]);
			pathgySheetDO.setName_app(CiprnUtils.GetName_app(cior.getId_srv()));
			pathgySheetDO.setId_samptp(map.get(cior.getId_or()).getParentDO().getId_samptp());
			pathgySheetDO.setSd_samptp(map.get(cior.getId_or()).getParentDO().getSd_samptp());
			pathgySheetDO.setQuan(map.get(cior.getId_or()).getParentDO().getQuan());
			pathgySheetDO.setId_colltp(map.get(cior.getId_or()).getParentDO().getId_colltp());
			pathgySheetDO.setSd_colltp(map.get(cior.getId_or()).getParentDO().getSd_colltp());
			pathgySheetDO.setDes_labsamp(map.get(cior.getId_or()).getParentDO().getDes_labsamp());
			pathgySheetDO.setFg_urgent(map.get(cior.getId_or()).getParentDO().getFg_urgent());
			pathgySheetDO.setAnnouncements(map.get(cior.getId_or()).getParentDO().getAnnouncements());
			pathgySheetDO.setDes_sympsign(map.get(cior.getId_or()).getParentDO().getDes_sympsign());
			pathgySheetDO.setFg_outer(map.get(cior.getId_or()).getParentDO().getFg_outer());
			pathgySheetDO.setNo_pathgy_old(map.get(cior.getId_or()).getParentDO().getNo_pathgy_old());
			pathgySheetDO.setDt_pathgy_old(map.get(cior.getId_or()).getParentDO().getDt_pathgy_old());
			pathgySheetDO.setDi_pathgy_old(map.get(cior.getId_or()).getParentDO().getDi_pathgy_old());
			pathgySheetDO.setOrg_pathgy_old(map.get(cior.getId_or()).getParentDO().getOrg_pathgy_old());
			pathgySheetDO.setCollectdes(map.get(cior.getId_or()).getParentDO().getCollectdes());
			pathgySheetDO.setId_emp(map.get(cior.getId_or()).getParentDO().getId_emp());
			pathgySheetDO.setId_dep(map.get(cior.getId_or()).getParentDO().getId_dep());
			pathgySheetDO.setDt_coll(map.get(cior.getId_or()).getParentDO().getDt_coll());
			pathgySheetDO.setId_su_pathgy(map.get(cior.getId_or()).getParentDO().getId_su_pathgy());
			pathgySheetDO.setSd_su_pathgy(map.get(cior.getId_or()).getParentDO().getSd_su_pathgy());
			pathgySheetDO.setNo_pathgy(map.get(cior.getId_or()).getParentDO().getNo_pathgy());
			pathgySheetDO.setDt_rptpathgy(map.get(cior.getId_or()).getParentDO().getDt_rptpathgy());
			pathgySheetDO.setId_org(cior.getId_org());
			pathgySheetDO.setId_grp(cior.getId_grp());
			pathgySheetDO.setId_org_app(cior.getId_org_or());
			pathgySheetDO.setId_dep_app(cior.getId_dep_sign());
			pathgySheetDO.setId_emp_app(cior.getId_emp_sign());
			pathgySheetDO.setDt_app(cior.getDt_sign());
			pathgySheetDO.setId_dep_mp(cior.getId_dep_mp());
			pathgySheetDO.setFg_opspecial(CiprnUtils.GetFg_opspecial(cior.getId_en()));
			if (banner != null
					&& (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) || banner.getCode_entp()
							.equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) && banner.getSd_hptp() != null
					&& banner.getSd_hptp().startsWith("2")) {
				pathgySheetDO.setFg_hecominsur(FBoolean.TRUE);
				pathgySheetDO.setHecominsurinfo(banner.getName_pat() + ":" + CiOrdAppUtils.getServerDateTime());
			} else {
				pathgySheetDO.setFg_hecominsur(FBoolean.FALSE);
			}
			pathgySheetDO.setFg_prepay(cior.getFg_prepay());
			pathgySheetDO.setFg_vip(cior.getFg_vip());
			pathgySheetDO.setFg_hpbirth(FBoolean.FALSE);
			pathgySheetDO.setResearchinfo("");
			pathgySheetDO.setFg_blsettled(FBoolean.FALSE);
			pathgySheetDO.setAmt_app(CiprnUtils.GetAmt_app(cior.getId_or()));
			pathgySheetDO.setFg_prn(FBoolean.FALSE);
			pathgySheetDO.setCnt_prn(0);
			if (session != null)
				pathgySheetDO.setId_session(session.getId_ciorsession());
			pathgySheetDO.setDef1((map.get(cior.getId_or()).getParentDO().getDef1()));
			pathgySheetDO.setDef2((map.get(cior.getId_or()).getParentDO().getDef2()));
			pathgySheetDO.setDef3((map.get(cior.getId_or()).getParentDO().getDef3()));
			pathgySheetDO.setDef4((map.get(cior.getId_or()).getParentDO().getDef4()));
			pathgySheetDO.setDef5((map.get(cior.getId_or()).getParentDO().getDef5()));
			pathgySheetDO.setDef6((map.get(cior.getId_or()).getParentDO().getDef6()));
			pathgySheetDO.setDef7((map.get(cior.getId_or()).getParentDO().getDef7()));
			pathgySheetDO.setDef8((map.get(cior.getId_or()).getParentDO().getDef8()));
			pathgySheetDO.setDef9((map.get(cior.getId_or()).getParentDO().getDef9()));
			pathgySheetDO.setDef10((map.get(cior.getId_or()).getParentDO().getDef10()));
			pathgySheetDO.setDef11((map.get(cior.getId_or()).getParentDO().getDef11()));
			pathgySheetDO.setDef12((map.get(cior.getId_or()).getParentDO().getDef12()));
			pathgySheetDO.setDef13((map.get(cior.getId_or()).getParentDO().getDef13()));
			pathgySheetDO.setDef14((map.get(cior.getId_or()).getParentDO().getDef14()));
			pathgySheetDO.setDef15((map.get(cior.getId_or()).getParentDO().getDef15()));
			pathgySheetDO.setDef16((map.get(cior.getId_or()).getParentDO().getDef16()));
			pathgySheetDO.setDef17((map.get(cior.getId_or()).getParentDO().getDef17()));
			pathgySheetDO.setDef18((map.get(cior.getId_or()).getParentDO().getDef18()));
			pathgySheetDO.setDef19((map.get(cior.getId_or()).getParentDO().getDef19()));
			pathgySheetDO.setDef20((map.get(cior.getId_or()).getParentDO().getDef20()));
			pathgySheetDO.setDef21((map.get(cior.getId_or()).getParentDO().getDef21()));
			pathgySheetDO.setDef22((map.get(cior.getId_or()).getParentDO().getDef22()));
			pathgySheetDO.setDef23((map.get(cior.getId_or()).getParentDO().getDef23()));
			pathgySheetDO.setDef24((map.get(cior.getId_or()).getParentDO().getDef24()));
			pathgySheetDO.setDef25((map.get(cior.getId_or()).getParentDO().getDef25()));
			pathgySheetDO.setDef26((map.get(cior.getId_or()).getParentDO().getDef26()));
			pathgySheetDO.setDef27((map.get(cior.getId_or()).getParentDO().getDef27()));
			pathgySheetDO.setDef28((map.get(cior.getId_or()).getParentDO().getDef28()));
			pathgySheetDO.setDef29((map.get(cior.getId_or()).getParentDO().getDef29()));
			pathgySheetDO.setDef30((map.get(cior.getId_or()).getParentDO().getDef30()));
			pathgySheetDO.setDef31((map.get(cior.getId_or()).getParentDO().getDef31()));
			pathgySheetDO.setDef32((map.get(cior.getId_or()).getParentDO().getDef32()));
			pathgySheetDO.setDef33((map.get(cior.getId_or()).getParentDO().getDef33()));
			pathgySheetDO.setDef34((map.get(cior.getId_or()).getParentDO().getDef34()));
			pathgySheetDO.setDef35((map.get(cior.getId_or()).getParentDO().getDef35()));
			pathgySheetDO.setDef36((map.get(cior.getId_or()).getParentDO().getDef36()));
			pathgySheetDO.setDef37((map.get(cior.getId_or()).getParentDO().getDef37()));
			pathgySheetDO.setDef38((map.get(cior.getId_or()).getParentDO().getDef38()));
			pathgySheetDO.setDef39((map.get(cior.getId_or()).getParentDO().getDef39()));
			pathgySheetDO.setDef40((map.get(cior.getId_or()).getParentDO().getDef40()));
			pathgySheetDO.setDef41((map.get(cior.getId_or()).getParentDO().getDef41()));
			pathgySheetDO.setDef42((map.get(cior.getId_or()).getParentDO().getDef42()));
			pathgySheetDO.setDef43((map.get(cior.getId_or()).getParentDO().getDef43()));
			pathgySheetDO.setDef44((map.get(cior.getId_or()).getParentDO().getDef44()));
			pathgySheetDO.setDef45((map.get(cior.getId_or()).getParentDO().getDef45()));
			pathgySheetDO.setDef46((map.get(cior.getId_or()).getParentDO().getDef46()));
			pathgySheetDO.setDef47((map.get(cior.getId_or()).getParentDO().getDef47()));
			pathgySheetDO.setDef48((map.get(cior.getId_or()).getParentDO().getDef48()));
			pathgySheetDO.setDef49((map.get(cior.getId_or()).getParentDO().getDef49()));
			pathgySheetDO.setDef50((map.get(cior.getId_or()).getParentDO().getDef50()));
			pathgySheetDO.setStatus(DOStatus.NEW);

			OrdApPathgySampDO[] sampDOs = map.get(cior.getId_or()).getOrdApPathgySampDO();
			List<CiAppPathgySheetSampDO> lstSheetSampDOs = new ArrayList<CiAppPathgySheetSampDO>();
			for (OrdApPathgySampDO sampDO : sampDOs) {
				CiAppPathgySheetSampDO sheetSampDO = new CiAppPathgySheetSampDO();
				sheetSampDO.setName_labsamp(sampDO.getName_labsamp());
				sheetSampDO.setBody_coll(sampDO.getBody_coll());
				sheetSampDO.setQuan_coll(sampDO.getQuan_coll());
				sheetSampDO.setFixative(sampDO.getFixative());
				sheetSampDO.setId_su_labsamp(sampDO.getId_su_labsamp());
				sheetSampDO.setSd_su_labsamp(sampDO.getSd_su_labsamp());
				sheetSampDO.setId_dep_sign(sampDO.getId_dep_sign());
				sheetSampDO.setId_emp_sign(sampDO.getId_emp_sign());
				sheetSampDO.setDt_sign(sampDO.getDt_sign());
				sheetSampDO.setSortno(sampDO.getSortno());
				sheetSampDO.setStatus(DOStatus.NEW);
				lstSheetSampDOs.add(sheetSampDO);
			}

			CiapppathgysheetAggDO aggDO = new CiapppathgysheetAggDO();
			aggDO.setParentDO(pathgySheetDO);
			aggDO.setCiAppPathgySheetSampDO(lstSheetSampDOs.toArray(new CiAppPathgySheetSampDO[lstSheetSampDOs.size()]));

			lstAggDOs.add(aggDO);
			i++;
		}
		return lstAggDOs.toArray(new CiapppathgysheetAggDO[lstAggDOs.size()]);
	}
}
