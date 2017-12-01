package iih.ci.ord.s.bp.orsms.lis;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.ord.app.d.CiAppLisSheetDO;
import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import iih.ci.ord.app.i.ICiapplissheetCudService;
import iih.ci.ord.cior.d.CiOrSessionDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.orsms.d.CiLisOrInfo4Sms;
import iih.ci.ord.orsms.d.CiLisOrSmsIoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.orsms.lis.cfg.EmsMergeUtils;
import iih.ci.ord.s.bp.orsms.lis.qry.CiLisOpOrSmsQry;
import iih.ci.ord.s.bp.orsms.lis.rule.CiLisOrSmsUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.custcfg.billcode.i.IBillcodeManage;

/**
 * 临床医嘱合单列表数据生成临床医嘱合单并保存及相关处理操作BP
 */
public class CiOrSmsList2CiOrLisSheetHandleBP {

	/**
	 * 临床医嘱合单列表数据生成临床医嘱合单并保存及相关处理
	 * 
	 * @param ordersmslist
	 * @param session
	 * @return
	 * @throws BizException
	 */
	public CiapplissheetAggDO[] exec(CiOrderDO[] ciors, List<CiLisOrSmsIoDTO> ordersmslist, CiOrSessionDO session) throws BizException {

		if (ordersmslist == null || ordersmslist.size() == 0) {
			return null;
		}
		CiEnContextDTO context = (CiEnContextDTO)Context.get().getAttribute("CiEnContextDTO");
		Ent4BannerDTO banner = null;
		if(context != null){
			 banner = context.getEnt4BannerDTO();	
		}
		long startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP  检验合单查询Fg_hp_pres  .." + System.currentTimeMillis() + "毫秒");
		String sql = getSQlStr(ciors[0].getId_en());
		Map<String, Object> map = CiOrdUtils.getRsMap(sql);
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询Fg_hp_pres  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		ICiapplissheetCudService lissheetservice = ServiceFinder.find(ICiapplissheetCudService.class);
		List<CiapplissheetAggDO> list = new ArrayList<CiapplissheetAggDO>();
		startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP  检验合单查询price  .." + System.currentTimeMillis() + "毫秒");
		Map<String,FDouble> orprices=getOrPrices(ciors);
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询price  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		
		startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP  检验合单查询code  .." + System.currentTimeMillis() + "毫秒");
		CiAppLisSheetDO ciAppLisSheetDO = new CiAppLisSheetDO();
		ciAppLisSheetDO.setId_en(context.getId_en());
		String[] code_cg = CiOrdUtils.generateNormNOs(ordersmslist.size(), ciAppLisSheetDO, 1, 21);
//		String[] code_cg = CiOrdUtils.generateLisPrintNo(context.getId_en(),ordersmslist.size());
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询code  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		int num=0;
		for (CiLisOrSmsIoDTO smsinfo : ordersmslist) {
	
			if (smsinfo.getCilisorinfos() != null && smsinfo.getCilisorinfos().size() > 0) {
				CiapplissheetAggDO agg = new CiapplissheetAggDO();
				CiAppLisSheetDO liapsheet = new CiAppLisSheetDO();
				agg.setParentDO(liapsheet);
				// 唯一编码 规则 TODO
				// IBillcodeManage codeS1 = ServiceFinder.find(IBillcodeManage.class);
				// String code_cg = codeS1.getPreBillCode_RequiresNew(OrdApLabDODesc.CLASS_FULLNAME);
				
				CiLisOrInfo4Sms dto = (CiLisOrInfo4Sms) smsinfo.getCilisorinfos().get(0);
				if( banner != null && (banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_OP) ||
						banner.getCode_entp().equals(IBdFcDictCodeConst.SD_CODE_ENTP_ET))
						&& banner.getSd_hptp() != null && banner.getSd_hptp().startsWith("2")){
					liapsheet.setFg_hecominsur(FBoolean.TRUE);
					liapsheet.setHecominsurinfo(banner.getName_pat()+" :"+CiOrdAppUtils.getServerDateTime());
				}else{
					liapsheet.setFg_hecominsur(FBoolean.FALSE);
					 //pres.setHecominsurinfo(Hecominsurinfo);	
				}
				liapsheet.setCode_app(code_cg[num]);
				liapsheet.setId_ciapplissheet(null);
				liapsheet.setId_di(dto.getOrlisapdo().getId_di());
				liapsheet.setId_diitm(dto.getOrlisapdo().getId_diitm());
				liapsheet.setStr_id_diitm(dto.getOrlisapdo().getStr_id_diitm());
				liapsheet.setStr_code_di(dto.getOrlisapdo().getStr_code_di());
				liapsheet.setStr_name_di(dto.getOrlisapdo().getStr_name_di());
				liapsheet.setName_diag(dto.getOrlisapdo().getName_diag());
				liapsheet.setId_group(dto.getOrdo().getId_grp());
				liapsheet.setId_org(dto.getOrdo().getId_org());
				liapsheet.setDt_plan(dto.getOrlisapdo().getDt_plan());

				liapsheet.setFg_urgent(dto.getOrdo().getFg_urgent());
				liapsheet.setId_org_app(dto.getOrdo().getId_org_or());
				liapsheet.setId_dep_app(dto.getOrdo().getId_dep_or());
				liapsheet.setFg_prn(dto.getOrlisapdo().getFg_prn());
				liapsheet.setCnt_prn(dto.getOrlisapdo().getCnt_prn());

				liapsheet.setFg_hp_pres(FBoolean.FALSE);// C.fg_maj,C.fg_fundpay,
				String fg_maj = CiOrdUtils.nullHandle(map.get("fg_maj"));
				String fg_fundpay = CiOrdUtils.nullHandle(map.get("fg_fundpay"));
				
				if (fg_maj != null && fg_maj.equals("Y") && fg_fundpay != null && fg_fundpay.equals("Y"))
					liapsheet.setFg_hp_pres(FBoolean.TRUE);

				liapsheet.setId_emp_app(dto.getOrdo().getId_emp_or());
				liapsheet.setDt_app(dto.getOrlisapdo().getCreatedtime());
				liapsheet.setId_pat(dto.getOrdo().getId_pat());
				liapsheet.setId_entp(dto.getOrdo().getId_entp());
				liapsheet.setCode_entp(dto.getOrdo().getCode_entp());
				liapsheet.setId_en(dto.getOrdo().getId_en());
				liapsheet.setFg_bb(dto.getOrdo().getFg_bb());
				liapsheet.setNo_bb(dto.getOrdo().getNo_bb());
				liapsheet.setFg_opspecial(FBoolean.FALSE);
				String ur = CiOrdUtils.nullHandle(map.get("sd_svrtp"));
				if (ur != null && ur.equals(CiLisOrSmsUtils.CILISOR_SMS_SPECIAL))
					liapsheet.setFg_opspecial(FBoolean.TRUE);
				liapsheet.setAnnouncements(smsinfo.getAnnouncements());
				liapsheet.setSampcolplace(null);            //需要业务上进一步确认如何赋值
				liapsheet.setId_sampcoltime(dto.getOrlisapdo().getId_sampcoltime());
				liapsheet.setLen_sampcoltime(dto.getOrlisapdo().getLen_sampcoltime());
				liapsheet.setId_sampcollecttimetp(dto.getOrlisapdo().getId_sampcollecttimetp());
				liapsheet.setSd_sampcollecttimetp(dto.getOrlisapdo().getSd_sampcollecttimetp());
				liapsheet.setId_unit_sampcoltime(dto.getOrlisapdo().getId_unit_sampcoltime());
				liapsheet.setStatus(DOStatus.NEW);
				liapsheet.setId_samptp(dto.getOrlisapdo().getId_samptp());//复合规则下该值是无效的
				liapsheet.setSd_samptp(dto.getOrlisapdo().getSd_samptp());
				liapsheet.setId_dep_mp(dto.getOrdo().getId_dep_mp());
				
				if (session != null)
					liapsheet.setId_session(session.getId_ciorsession());
				FArrayList2 fa = smsinfo.getCilisorinfos();
				CiAppLisSheetOrDO[] aplist = new CiAppLisSheetOrDO[fa.size()];
				FDouble sheetprice=FDouble.ZERO_DBL;
				int i = 0;
				FBoolean vipflag=FBoolean.FALSE;
				for (Object o : fa) {
					CiLisOrInfo4Sms t = (CiLisOrInfo4Sms) o;
					CiAppLisSheetOrDO ap = new CiAppLisSheetOrDO();
					ap.setId_or(t.getOrdo().getId_or());
					ap.setId_orlab(t.getOrlisapdo().getId_orlab());
					ap.setAmt_app(orprices.get(t.getOrdo().getId_or()));
					sheetprice=sheetprice.add(orprices.get(t.getOrdo().getId_or()));
					ap.setStatus(DOStatus.NEW);
					aplist[i] = ap;
					if(t.getOrdo().getFg_vip().booleanValue()==true){
						vipflag=t.getOrdo().getFg_vip();
					}
					i++;
				}
				//赋vip标志
				liapsheet.setFg_vip(vipflag);
				liapsheet.setAmt_app_total(sheetprice);
				agg.setCiAppLisSheetOrDO(aplist);
				list.add(agg);

			}
			num++;
		}
		startTIme = System.currentTimeMillis();
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP  检验合单查询save  .." + System.currentTimeMillis() + "毫秒");
		CiapplissheetAggDO[] aggs = list.toArray(new CiapplissheetAggDO[list.size()]);
		lissheetservice.save(aggs);
		CiOrdUtils.getlogger().info("CiLisOrSmsHandlerBP 检验合单查询save  .." + (System.currentTimeMillis() - startTIme) + "毫秒");
		return list.toArray(new CiapplissheetAggDO[list.size()]);
	}

	/**
	 * 获得 SQL串
	 * 
	 * @param id_en
	 * @return
	 */
	private String getSQlStr(String id_en) {
		CiLisOpOrSmsQry qry = new CiLisOpOrSmsQry(id_en);
		return qry.getQrySQLStr();
	}
	
	/**
	 * 获取医嘱总价
	 * @throws BizException 
	 */
	
	private Map<String,FDouble> getOrPrices(CiOrderDO[] ciors) throws BizException{
		
		return EmsMergeUtils.GetOrdPriceMap(ciors);
	}

}
