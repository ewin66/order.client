package iih.ci.ord.s.bp.iemsg;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import iih.bl.cg.service.IBlcgqueryService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.iemsg.d.IEOpPharmOrEnDTO;
import iih.ci.ord.iemsg.d.IEOpPharmOrFeeDTO;
import iih.ci.ord.iemsg.d.IEOpPharmPresDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugConfirmQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpDrugPres8idorQry;
import iih.ci.ord.s.bp.iemsg.qry.CiOpOr8IdenQry;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;
import xap.sys.appfw.xapformula.utils.AgeCalcUtil;

/**
 * BS302：处方信息服务</br>
 * 生成集成平台药品医嘱服务数据信息操作BP （门诊）
 */
public class GetIEOpMsgInfo4Pharm8idorBP {

	/**
	 * 生成集成平台药品医嘱服务数据信息 （门诊）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] exec(String id_wc_ors, String id_herb_ors, String iden) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_wc_ors) && CiOrdUtils.isEmpty(id_herb_ors))
			return null;
		//获取就诊-->通过就诊获取该就诊号下所有医嘱-->筛选条件ci_or_srv.sd_srvtp  like ‘01%’ci_order.fg_sign = TRUE 并且 未作废 ci_order.fg_canc = FALSE
		
		// 获得sql串及其对应的结果集map
		String sql = getSQlStr(iden);
		List<Map<String, Object>> maps=CiOrdUtils.getRsMapList(sql);
		ArrayList<CiOrderDO> wc_ciorders = new ArrayList<CiOrderDO>();
		ArrayList<CiOrderDO> herb_ciorders = new ArrayList<CiOrderDO>();
		for (Map<String, Object> map: maps) {
			CiOrderDO cior = new CiOrderDO();
			cior.setId_or(CiOrdUtils.nullHandle(map.get("id_or")));
			cior.setSd_srvtp(CiOrdUtils.nullHandle(map.get("sd_srvtp")));
			cior.setSd_su_bl(CiOrdUtils.nullHandle(map.get("sd_su_bl")));
			if (cior.getSd_srvtp() != null && cior.getSd_srvtp().startsWith("0101")) {
				wc_ciorders.add(cior);
			}else if(cior.getSd_srvtp() != null && cior.getSd_srvtp().startsWith("0102")){
				herb_ciorders.add(cior);
			}
		}
		String wc_ors = "";
		String herb_ors = "";
		if (!CiOrdUtils.isEmpty(wc_ciorders)) {
			wc_ors  = getDrugIdOrs(wc_ciorders.toArray(new CiOrderDO[0]));
		}
		if (!CiOrdUtils.isEmpty(herb_ciorders)) {
			herb_ors  = getDrugIdOrs(herb_ciorders.toArray(new CiOrderDO[0]));
		}
		//获得医嘱签署信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_wc_ors, id_herb_ors);

		//获得处方信息
		String id_preses = pharmPresInfoHandle(wc_ors, herb_ors, rtn, iden);//"1001Z7100000000GWQMU"

		//西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(id_preses, rtn);

		//草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(id_preses, rtn);

		return new IEOpPharmOrEnDTO[] { rtn };
	}
	/**
	 * 获得 SQL串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getSQlStr(String iden) {
		CiOpOr8IdenQry qry = new CiOpOr8IdenQry(iden);
		return qry.getQrySQLStr();
	}
	/**
	 * 拼装医嘱id
	 * @param ciorders
	 * @return
	 */
	private String getDrugIdOrs(CiOrderDO[] ciorders) {
		// TODO Auto-generated method stub
		String result ="";
		for (CiOrderDO ciOrderDO : ciorders) {
			result += ciOrderDO.getId_or()+",";
		}
		return result;
	}
	/**
	 * 生成集成平台药品医嘱服务数据信息 （门诊医嘱重分方）
	 * 
	 * @param id_ors 医嘱id串
	 * @return
	 * @throws BizException
	 */
	public IEOpPharmOrEnDTO[] execAgain(String id_wc_ors, String id_herb_ors, String iden) throws BizException {
		//有效性校验
		if (CiOrdUtils.isEmpty(id_wc_ors) && CiOrdUtils.isEmpty(id_herb_ors))
			return null;

		//获得医嘱签署信息
		IEOpPharmOrEnDTO rtn = getIEMsg4OrSignInfo(id_wc_ors, id_herb_ors);

		//获得处方信息
		String id_preses = pharmPresInfoHandle(id_wc_ors, id_herb_ors, rtn, iden);//"1001Z7100000000GWQMU"

		//西成药处方数据信息计算与处理
		ieOpPresItms4DrugWcHandle(id_preses, rtn);

		//草药处方数据信息计算与处理
		ieOpPresItms4HerbHandle(id_preses, rtn);

		return new IEOpPharmOrEnDTO[] { rtn };
	}

	/**
	 * 西成药处方数据信息计算与处理
	 * 
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4HerbHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		//获得草药处方明细信息
		GetIEOpMsgInfo4DrugHerbBP bp = new GetIEOpMsgInfo4DrugHerbBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		//空判断
		if (CiOrdUtils.isEmpty(list))
			return;

		//药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (CiOrdUtils.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		//遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (CiOrdUtils.isEmpty(list.get(id_pres)))
				continue;
			presdto.setId_iepharmors(list.get(id_pres));
		}
	}

	/**
	 * 西成药处方数据信息计算与处理
	 * 
	 * @param id_preses
	 * @param rtn
	 * @throws BizException
	 */
	private void ieOpPresItms4DrugWcHandle(String id_preses, IEOpPharmOrEnDTO rtn) throws BizException {

		if (id_preses == null)
			return;
		//获得西成药处方明细信息
		GetIEOpMsgInfo4DrugWcBP bp = new GetIEOpMsgInfo4DrugWcBP();
		Hashtable<String, FArrayList2> list = bp.exec(id_preses);

		//空判断
		if (CiOrdUtils.isEmpty(list))
			return;

		//药品处方
		FArrayList2 list2 = rtn.getId_iepharmpreses();
		if (CiOrdUtils.isEmpty(list2))
			return;
		IEOpPharmPresDTO presdto = null;
		String id_pres = "";

		//遍历
		for (int i = 0; i < list2.size(); i++) {
			presdto = (IEOpPharmPresDTO) list2.get(i);
			id_pres = presdto.getId_iepharmpres();
			if (CiOrdUtils.isEmpty(list.get(id_pres)))
				continue;
			presdto.setId_iepharmwcors(list.get(id_pres));
		}
	}

	/**
	 * 获得医嘱签署信息 患者、就诊、签署
	 * 
	 * @param id_or
	 * @return
	 * @throws BizException
	 */
	private IEOpPharmOrEnDTO getIEMsg4OrSignInfo(String id_wc_ors, String id_herb_ors) throws BizException {
		String id_or = getOr(id_wc_ors, id_herb_ors);

		// 医嘱数据信息查询
		CiOpDrugConfirmQry qry = new CiOpDrugConfirmQry(id_or);
		IEOpPharmOrEnDTO[] rtns = (IEOpPharmOrEnDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmOrEnDTO.class);

		//返回
		if (CiOrdUtils.isEmpty(rtns))
			return null;

		//设置域id
		rtns[0].setDomain_id("01");
		//计算年龄
		rtns[0].setAge(AgeCalcUtil.getAge(rtns[0].getBirthday()));

		return rtns[0];
	}

	/**
	 * 获得药品处方数据信息 西成药 草药
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @param rtn
	 * @return
	 * @throws BizException
	 */
	private String pharmPresInfoHandle(String id_wc_ors, String id_herb_ors, IEOpPharmOrEnDTO rtn, String id_en)
			throws BizException {
		
		String id_ors= getIDOrs(id_wc_ors, id_herb_ors);
		if (CiOrdUtils.isEmpty(id_ors)) return null;
		String[] idors = id_ors.split(CiOrdUtils.COMMA_STR);
		String idor = "";
		for (String string : idors) {
			idor+=",'"+string+"'";
		}
		// 医嘱数据信息查询
		CiOpDrugPres8idorQry qry = new CiOpDrugPres8idorQry(idor.substring(1, idor.length()));
		IEOpPharmPresDTO[] predtos = (IEOpPharmPresDTO[]) AppFwUtil.getDORstWithDao(qry, IEOpPharmPresDTO.class);
		//空判断
		if (CiOrdUtils.isEmpty(predtos))
			return null;

		//设置已收费处方数据
		List<IEOpPharmPresDTO> preslist = handlePres(predtos, rtn);

		//空判断
		if (preslist == null || preslist.isEmpty())
			return null;

		//参数设置
		FArrayList2 list = new FArrayList2();
		String rtnstr = "";

		//遍历
		for (IEOpPharmPresDTO o : preslist) {
			list.add(o);
			rtnstr += CiOrdUtils.COMMA_STR + o.getId_iepharmpres();
		}

		//设置未收费处方集合数据信息
		rtn.setId_iepharmpreses(list);

		if (rtnstr.equals(""))
			return null;
		//返回
		return rtnstr.substring(1);
	}

	/**
	 * 获得一个医嘱ID
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getOr(String id_wc_ors, String id_herb_ors) {
		String id_ors = null;
		if (!CiOrdUtils.isEmpty(id_wc_ors)) {
			id_ors = id_wc_ors;
		} else {
			id_ors = id_herb_ors;
		}

		return id_ors.split(CiOrdUtils.COMMA_STR)[0];
	}

	/**
	 * 合并医嘱ID字串
	 * 
	 * @param id_wc_ors
	 * @param id_herb_ors
	 * @return
	 */
	private String getIDOrs(String id_wc_ors, String id_herb_ors) {
		if (CiOrdUtils.isEmpty(id_wc_ors)) {
			return id_herb_ors;
		} else {
			if (CiOrdUtils.isEmpty(id_herb_ors))
				return id_wc_ors;
			return id_wc_ors + CiOrdUtils.COMMA_STR + id_herb_ors;
		}
	}

	private List<IEOpPharmPresDTO> handlePres(IEOpPharmPresDTO[] predtos, IEOpPharmOrEnDTO rtn) throws BizException {

		List<IEOpPharmPresDTO> preslist = new ArrayList<>();
		FArrayList2 feelist = new FArrayList2();

		Map<String, FBoolean> feernt = getFeedtos(predtos);

		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			if (feernt.get(ieOpPharmPresDTO.getId_iepharmpres()).booleanValue()) {
				IEOpPharmOrFeeDTO feedto = new IEOpPharmOrFeeDTO();
				feedto.setOrderno(ieOpPharmPresDTO.getOrderno());
				feedto.setOrdertypecode(ieOpPharmPresDTO.getOrdertypecode());
				feelist.add(feedto);
			} else {

				preslist.add(ieOpPharmPresDTO);
			}
		}
		//设置已收费处方
		rtn.setIepharmfees(feelist);
		return preslist;

	}

	private Map<String, FBoolean> getFeedtos(IEOpPharmPresDTO[] predtos) throws BizException {

		IBlcgqueryService service = ServiceFinder.find(IBlcgqueryService.class);
		String[] idpreses = new String[predtos.length];
		int i = 0;
		for (IEOpPharmPresDTO ieOpPharmPresDTO : predtos) {
			idpreses[i] = ieOpPharmPresDTO.getId_iepharmpres();
			i++;
		}

		return service.querySettlementByIdPres_Oep(idpreses);

	}

}
