package iih.ci.ord.s.bp.splitpres;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.diag.i.ICidiagQryService;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.dto.OrderPresSplitDTO.d.OrderPresSplitDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.splitpres.CiOrPresSplitList;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.splitlis.pku.PKUSplitConst;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.dataaccess.DBUtil;

/**
 * 临床医嘱处方分方列表数据生成临床医嘱处方并保存及相关处理操作BP
 */
public class CiOrPresSplitList2CiOrPresHandleBP {

	/**
	 * 临床医嘱处方分方列表数据生成临床医嘱处方并保存及相关处理
	 * 
	 * @param orderPreslist
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiPresDO[] exec(List<CiOrPresSplitList> orderPreslist, CiOrSessionDO session) throws BizException {		
		CiEnContextDTO context = (CiEnContextDTO) Context.get().getAttribute("CiEnContextDTO");
		Ent4BannerDTO banner = context.getEnt4BannerDTO();

		if (orderPreslist == null || orderPreslist.size() == 0) {
			return null;
		}
		
		//诊断信息
		String[] diags = new String[2];
		if (orderPreslist.get(0) != null && orderPreslist.get(0).getOrderList() != null
				&& orderPreslist.get(0).getOrderList().get(0).getId_en() != null) {
			diags = CiOrdUtils.getDiag(orderPreslist.get(0).getOrderList().get(0).getId_en());/////////////////////////////////
		}

		//数据库设计文件在此保存 处方 和
		int i = 0;
		List<CiPresDO> listpres = new ArrayList<CiPresDO>();
		List<String> oldPres = new ArrayList<String>();
		Map<String, String> mapOrsrvPres = new HashMap<String, String>();
		String[] idpreses = new DBUtil().getOIDs(orderPreslist.size());
		CiPresDO pres4NO = new CiPresDO();
		pres4NO.setId_en(context.getId_en());
		String[] presNOs=CiOrdUtils.generateNormNOs(orderPreslist.size(), pres4NO, 1, 21);
		for (CiOrPresSplitList presSplit : orderPreslist) {
			if (presSplit.getOrderList() != null && presSplit.getOrderList().size() > 0) {
				CiPresDO pres = new CiPresDO();
				pres.setId_pres(idpreses[i]);
				pres.setName(presSplit.getName());
				pres.setCode(presNOs[i]);
				if (PKUSplitConst.SD_UDIDOC_PRESCRIPTION_MJZMZJYY.equals(presSplit.getSd_pres())) {
					pres.setCode_pois(CiOrdUtils.generatePoisPresNo());///////////////////////////
				}
				pres.setId_prestp(presSplit.getId_prestp());
				pres.setSd_prestp(presSplit.getSd_pres());
				pres.setId_prestpword(ReplaceNUll(presSplit.getId_prestpword()));
				pres.setSd_prestpword(ReplaceNUll(presSplit.getSd_prestpword()));
				OrderPresSplitDTO dto = presSplit.getOrderList().get(0);
				if (pres.getSd_prestpword() != null
						&& pres.getSd_prestpword().indexOf(PKUSplitConst.SD_PRESCRIPTION_FLAG_VIP) > 0) {
					pres.setFg_vip(FBoolean.TRUE);
				} else {
					pres.setFg_vip(FBoolean.FALSE);
				}
				if (banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) 
						|| banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET)) 
						&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")) {
					pres.setFg_hecominsur(FBoolean.TRUE);
					pres.setHecominsurinfo(banner.getName_pat() + ":" + CiOrdAppUtils.getServerDateTime());
				} else {
					pres.setFg_hecominsur(FBoolean.FALSE);
					//pres.setHecominsurinfo(Hecominsurinfo);	
				}

				pres.setId_entp(dto.getId_entp());
				pres.setCode_entp(dto.getCode_entp());
				pres.setId_grp(dto.getId_grp());
				pres.setId_org(dto.getId_org());
				pres.setId_en(dto.getId_en());
				pres.setId_pati(dto.getId_pat());
				pres.setId_srvtp(dto.getId_srvtp());
				pres.setSd_srvtp(dto.getSd_srvtp());
				pres.setId_dep_or(dto.getId_dep_or());
				pres.setId_dep_mp(dto.getId_dep_wh());//国际医院 将 物资流向科室存到 id_dep_mp中
				pres.setId_emp_or(dto.getId_emp_or());
				pres.setId_emp(dto.getId_emp_or());
				pres.setFg_base(dto.getFg_base());
				pres.setStr_name_di(diags[0]);
				pres.setStr_id_di(diags[1]);
				ICidiagQryService service = ServiceFinder.find(ICidiagQryService.class);
				CiDiagItemDO cidido = service.getCiDiagItemDO(dto.getId_en(), dto.getCode_entp());
				if (cidido != null) {
					pres.setId_di(cidido.getId_di());
				}
				if (session != null){
					pres.setId_session(session.getId_ciorsession());
				}
				// todo 医嘱表没有
				//pres.setId_bb(dto.getId);
				pres.setFg_bb(dto.getFg_bb());
				pres.setId_boil(dto.getId_boil());
				pres.setId_boildes(dto.getId_boildes());
				pres.setId_route(dto.getId_route());
				pres.setId_routedes(dto.getId_routedes());
				pres.setNo_bb(dto.getNo_bb());
				pres.setDt_entry(dto.getDt_entry());
				FBoolean flag = isHPHerbsl(presSplit);
				if (flag == null) {
					pres.setFg_hp_pres(dto.getFg_hp_pres().equals("1") ? FBoolean.TRUE : FBoolean.FALSE);//   医保 1，  非医保 0
				} else {
					pres.setFg_hp_pres(flag);
				}
				pres.setStatus(DOStatus.NEW);
				//更新医嘱服务表
				List<String> lstId_orsrv = new ArrayList<String>();
				for (OrderPresSplitDTO presSplitDTO : presSplit.getOrderList()) {
					if (StringUtils.isNullOrEmpty(presSplitDTO.getId_orsrv()))
						continue;
					lstId_orsrv.add(presSplitDTO.getId_orsrv());
					if (!mapOrsrvPres.containsKey(presSplitDTO.getId_orsrv())) {
						mapOrsrvPres.put(presSplitDTO.getId_orsrv(), idpreses[i]);
					}
				}
				listpres.add(pres);
			}
			i++;
		}
		
		OrdPresSplitSaveBP saveBP = new OrdPresSplitSaveBP();
		//保存处方ci_pres
		saveBP.savePresDO(listpres.toArray(new CiPresDO[listpres.size()]));
		//更新ci_orsrv表里id_pres
		saveBP.updateCiORSrv(mapOrsrvPres, oldPres);
		//重新分方删除原有ci_pres(id_pres)
		saveBP.DeletePresDO(oldPres);
		
		return listpres.toArray(new CiPresDO[listpres.size()]);
	}

	private String ReplaceNUll(String str) {
		if (str != null && str.length() > 0) {
			str = str.replace("null,", "");
			if (str != null && str.lastIndexOf(",") > 0) {
				str = str.substring(0, str.length());
			}
			if (str != null && str.startsWith(",")) {
				str = str.substring(1, str.length());
			}
			return str;
		}
		return "";
	}

	private FBoolean isHPHerbsl(CiOrPresSplitList ciOrPresSplitList) {

		if (ciOrPresSplitList.getSd_pres() != null && !ciOrPresSplitList.getSd_pres().equals(PresConstant.SD_HERBAL))
			return null;
		List<OrderPresSplitDTO> orderList = ciOrPresSplitList.getOrderList();
		FBoolean flag = FBoolean.FALSE;
		for (OrderPresSplitDTO orderPresSplitDTO : orderList) {
			if (orderPresSplitDTO.getFg_hp_pres().equals("1")) {
				flag = FBoolean.TRUE;
				break;
			}
		}

		return flag;
	}

}
