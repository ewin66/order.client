package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.cior.d.OrdApObsDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 保存检查打印数据
 * @author YANG
 *
 */
public class CiprnSaveAppRisDataBP {

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
					&& cior.getSd_srvtp().substring(0, 2).equals(IBdSrvDictCodeConst.SD_SRVTP_RIS) 
					&& !cior.getSd_srvtp().substring(0, 4).equals(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
				lstCiOrderDOs.add(cior);
				strIdors += "'" + cior.getId_or() + "',";
			}
		}
		if (lstCiOrderDOs == null || lstCiOrderDOs.size() <= 0)
			return null;
		OrdApObsDO[] ordApObsDOs = CiprnUtils.GetOrdApObsDOs(strIdors.substring(0, strIdors.length() - 1));
		Map<String, OrdApObsDO> map = new HashMap<String, OrdApObsDO>();
		for (OrdApObsDO ordApObsDO : ordApObsDOs) {
			map.put(ordApObsDO.getId_or(), ordApObsDO);
		}
		CiAppRisSheetDO[] ciAppRisSheetDOs = getCiAppRisSheetDOs(lstCiOrderDOs.toArray(new CiOrderDO[lstCiOrderDOs.size()]), map, session);
		CiprnUtils.SaveCiAppRisSheetDOs(ciAppRisSheetDOs);
		return FBoolean.TRUE;
	}

	/**
	 * 创建检查打印申请单对象集合
	 * @param ciors 医嘱集合
	 * @param map 检查申请单对象集合
	 * @param session
	 * @return
	 * @throws BizException
	 */
	private CiAppRisSheetDO[] getCiAppRisSheetDOs(CiOrderDO[] ciors, Map<String, OrdApObsDO> map, CiOrSessionDO session)
			throws BizException {
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		Ent4BannerDTO banner = null;
		if(context != null){
			 banner = context.getEnt4BannerDTO();	
		}
		
		CiAppRisSheetDO ciAppRisSheetDO = new CiAppRisSheetDO();
		ciAppRisSheetDO.setId_en(ciors[0].getId_en());
		String[] risNOs = CiOrdUtils.generateNormNOs(ciors.length, ciAppRisSheetDO, 1, 21);
		List<CiAppRisSheetDO> lstCiAppRisSheetDOs = new ArrayList<CiAppRisSheetDO>();
		int i = 0;
		for (CiOrderDO cior : ciors) {
			OrdApObsDO ordApObsDO = map.get(cior.getId_or());
			CiAppRisSheetDO risDO = new CiAppRisSheetDO();
			risDO.setId_pat(cior.getId_pat());
			risDO.setId_entp(cior.getId_entp());
			risDO.setCode_entp(cior.getCode_entp());
			risDO.setId_en(cior.getId_en());
			risDO.setFg_hp(cior.getFg_orhp());
			risDO.setFg_bb(cior.getFg_bb());
			risDO.setNo_bb(cior.getNo_bb());
			risDO.setFg_opspecial(CiprnUtils.GetFg_opspecial(cior.getId_en()));
			risDO.setId_or(cior.getId_or());
			risDO.setId_orobs(ordApObsDO.getId_orobs());
			risDO.setId_srv(cior.getId_srv());
			risDO.setFg_set(cior.getFg_set());
			risDO.setNo_applyform((ordApObsDO.getNo_applyform()));
			risDO.setCode_app(risNOs[i]);
			risDO.setName_app(CiprnUtils.GetName_app(cior.getId_srv()));
			risDO.setId_di(ordApObsDO.getId_di());
			risDO.setId_diitm(ordApObsDO.getId_diitm());
			risDO.setStr_id_diitm((ordApObsDO.getStr_id_diitm()));
			risDO.setStr_code_di((ordApObsDO.getStr_code_di()));
			risDO.setStr_name_di((ordApObsDO.getStr_name_di()));
			risDO.setName_diag((ordApObsDO.getName_diag()));
			risDO.setId_org(cior.getId_org());
			risDO.setId_grp(cior.getId_grp());
			risDO.setDt_plan((ordApObsDO.getDt_plan()));
			risDO.setFg_urgent((ordApObsDO.getFg_urgent()));
			risDO.setId_org_app(cior.getId_org_or());
			risDO.setId_dep_app(cior.getId_dep_sign());
			risDO.setId_emp_app(cior.getId_emp_sign());
			risDO.setDt_app(cior.getDt_sign());
			risDO.setId_dep_mp(cior.getId_dep_mp());
			risDO.setBiopsy((ordApObsDO.getBiopsy()));
			risDO.setDes_sympsign((ordApObsDO.getDes_sympsign()));
			risDO.setClinicalzztz((ordApObsDO.getClinicalzztz()));
			risDO.setAuximtexam((ordApObsDO.getAuximtexam()));
			risDO.setPastillness((ordApObsDO.getPastillness()));
			risDO.setId_pps((ordApObsDO.getId_pps()));
			risDO.setSd_pps((ordApObsDO.getSd_pps()));
			risDO.setDes_pps((ordApObsDO.getDes_pps()));
//			risDO.setId_body((ordApObsDO.getId_body()));
//			risDO.setSd_body((ordApObsDO.getSd_body()));
//			risDO.setId_pos((ordApObsDO.getId_pos()));
//			risDO.setSd_pos((ordApObsDO.getSd_pos()));
//			risDO.setFg_mp_bed((ordApObsDO.getFg_mp_bed()));
			risDO.setAnnouncements((ordApObsDO.getAnnouncements()));
			if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
					banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
					&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
				risDO.setFg_hecominsur(FBoolean.TRUE);
				risDO.setHecominsurinfo(banner.getName_pat()+":"+CiOrdAppUtils.getServerDateTime());
			}else{
				risDO.setFg_hecominsur(FBoolean.FALSE);
			}
			
			risDO.setFg_prepay(cior.getFg_prepay());
			risDO.setFg_vip(cior.getFg_vip());
			risDO.setFg_hpbirth(FBoolean.FALSE);
			risDO.setResearchinfo("");
			risDO.setFg_blsettled(FBoolean.FALSE);
			risDO.setAmt_app(CiprnUtils.GetAmt_app(cior.getId_or()));
			risDO.setFg_prn(FBoolean.FALSE);
			risDO.setCnt_prn(0);
			if (session != null)
				risDO.setId_session(session.getId_ciorsession());
			risDO.setDef1((ordApObsDO.getDef1()));
			risDO.setDef2((ordApObsDO.getDef2()));
			risDO.setDef3((ordApObsDO.getDef3()));
			risDO.setDef4((ordApObsDO.getDef4()));
			risDO.setDef5((ordApObsDO.getDef5()));
			risDO.setDef6((ordApObsDO.getDef6()));
			risDO.setDef7((ordApObsDO.getDef7()));
			risDO.setDef8((ordApObsDO.getDef8()));
			risDO.setDef9((ordApObsDO.getDef9()));
			risDO.setDef10((ordApObsDO.getDef10()));
			risDO.setDef11((ordApObsDO.getDef11()));
			risDO.setDef12((ordApObsDO.getDef12()));
			risDO.setDef13((ordApObsDO.getDef13()));
			risDO.setDef14((ordApObsDO.getDef14()));
			risDO.setDef15((ordApObsDO.getDef15()));
			risDO.setDef16((ordApObsDO.getDef16()));
			risDO.setDef17((ordApObsDO.getDef17()));
			risDO.setDef18((ordApObsDO.getDef18()));
			risDO.setDef19((ordApObsDO.getDef19()));
			risDO.setDef20((ordApObsDO.getDef20()));
			risDO.setDef21((ordApObsDO.getDef21()));
			risDO.setDef22((ordApObsDO.getDef22()));
			risDO.setDef23((ordApObsDO.getDef23()));
			risDO.setDef24((ordApObsDO.getDef24()));
			risDO.setDef25((ordApObsDO.getDef25()));
			risDO.setDef26((ordApObsDO.getDef26()));
			risDO.setDef27((ordApObsDO.getDef27()));
			risDO.setDef28((ordApObsDO.getDef28()));
			risDO.setDef29((ordApObsDO.getDef29()));
			risDO.setDef30((ordApObsDO.getDef30()));
			risDO.setDef31((ordApObsDO.getDef31()));
			risDO.setDef32((ordApObsDO.getDef32()));
			risDO.setDef33((ordApObsDO.getDef33()));
			risDO.setDef34((ordApObsDO.getDef34()));
			risDO.setDef35((ordApObsDO.getDef35()));
			risDO.setDef36((ordApObsDO.getDef36()));
			risDO.setDef37((ordApObsDO.getDef37()));
			risDO.setDef38((ordApObsDO.getDef38()));
			risDO.setDef39((ordApObsDO.getDef39()));
			risDO.setDef40((ordApObsDO.getDef40()));
			risDO.setDef41((ordApObsDO.getDef41()));
			risDO.setDef42((ordApObsDO.getDef42()));
			risDO.setDef43((ordApObsDO.getDef43()));
			risDO.setDef44((ordApObsDO.getDef44()));
			risDO.setDef45((ordApObsDO.getDef45()));
			risDO.setDef46((ordApObsDO.getDef46()));
			risDO.setDef47((ordApObsDO.getDef47()));
			risDO.setDef48((ordApObsDO.getDef48()));
			risDO.setDef49((ordApObsDO.getDef49()));
			risDO.setDef50((ordApObsDO.getDef50()));
			risDO.setStatus(DOStatus.NEW);

			lstCiAppRisSheetDOs.add(risDO);
			i++;
		}
		return lstCiAppRisSheetDOs.toArray(new CiAppRisSheetDO[lstCiAppRisSheetDOs.size()]);
	}
}
