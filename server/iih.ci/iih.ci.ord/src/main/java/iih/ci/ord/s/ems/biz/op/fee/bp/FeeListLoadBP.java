package iih.ci.ord.s.ems.biz.op.fee.bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import iih.bd.base.cache.CacheContext;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciordems.d.CiOrdFeeSrvDTO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.d.ems.fee.FeeListLoadDTO;
import iih.ci.ord.d.ems.fee.FeeListRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.bp.IFeeListLoadBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.MapListHandler;

/**
 * 加载费用清单数据
 * @author wangqingzhu
 *
 */
public class FeeListLoadBP extends CacheContext implements IFeeListLoadBP {

	@Override
	public FeeListRstDTO load(FeeListLoadDTO ems) throws BizException {
		FeeListRstDTO feeListRstDTO = new FeeListRstDTO();
		// 解析参数 FeeListLoadDTO ，获取加载逻辑内容使用数据结构（去F化）
		CiEnContextDTO ciEnContextDTO = ems.getEnContext();
		String id_en = ciEnContextDTO.getId_en();
		String code_entp = ciEnContextDTO.getCode_entp();
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		//医嘱排序
		String OrderSequenceModel = iCiOrdQryService.getOrderSequenceMode();  
		String ordSql = getOrdFeeLIstSql(id_en, code_entp,OrderSequenceModel);
		// 查询医嘱费用数据
		List<Map<String, Object>> ordResult = (List<Map<String, Object>>) new DAFacade()
				.execQuery(ordSql, new MapListHandler());
		if(CiOrdUtils.isEmpty(ordResult)) return feeListRstDTO;
		List<CiOrdFeeSrvDTO> ordFeeList = handleOrdFeeList(ordResult);
		if(CiOrdUtils.isEmpty(ordFeeList)) return feeListRstDTO;
		// 将费用数据组织为 UI 数据
		FArrayList resultList = new FArrayList();
		resultList.addAll(ordFeeList);
		feeListRstDTO.setDocument(resultList);
		// 返回结果处理或 错误信息处理
		
		
		return feeListRstDTO;
	}
	/**
	 * 获得该就诊id下的所有医嘱
	 * @author yzh
	 * @param id_en
	 * @param code_entp
	 * @return
	 */
	private String getOrdFeeLIstSql(String id_en, String code_entp,String OrderSequenceModel) {
		
		StringBuffer sql = new StringBuffer();
		sql.append("  select a0.id_or,a0.dt_effe,a0.code_or,a0.content_or,srv.name as name_srv,");
		//sql.append("  hp.name as name_hp,orsrv.quan_total_medu as med_unit,");
		sql.append("  udi.name as name_hp,orsrv.quan_total_medu as med_unit,");
		sql.append("  orsrv.pri as price,round(orsrv.pri*orsrv.quan_total_medu,4) as amt_total,");
		sql.append("  orsrv.fg_indic,orsrv.fg_selfpay,dep.name as name_dep,srv.des as des_srv,measdoc.name as name_unit_med,measdoc_mm.name as mm_name_unit_med,orsrvmm.code_mm,");
		sql.append("  orsrv.sd_srvtp,a0.orders,orsrvmm.quan_cur as quan_drug,round(orsrv.pri*orsrvmm.quan_cur,4) as amt_total_drug,");
		sql.append("  orsrv.fg_bl as orsrv_fg_bl,orsrv.fg_mm as orsrv_fg_mm,(case when orsrv.fg_bl = 'Y' then srv.code  when orsrv.fg_mm='Y' then bdmm.code else '' end) as fee_code_or");
		sql.append("  from ci_order a0");
		sql.append("  left outer join ci_or_srv orsrv on a0.id_or = orsrv.id_or");
		sql.append("  left outer join bd_srv srv on orsrv.id_srv = srv.id_srv");
		sql.append("  left outer join ci_or_srv_mm orsrvmm on orsrv.id_orsrv=orsrvmm.id_orsrv");
		sql.append("  left outer join bd_mm bdmm on orsrvmm.id_mm=bdmm.id_mm");
		//sql.append("  left outer join bd_hp hp on orsrv.id_hp = hp.id_hp");
		sql.append("  left outer join bd_udidoc udi on orsrv.id_hpsrvtp = udi.id_udidoc");
		sql.append("  left outer join bd_dep dep on a0.id_dep_mp=dep.id_dep");
		sql.append("  left outer join bd_measdoc measdoc on orsrv.id_medu=measdoc.id_measdoc");
		sql.append("  left outer join bd_measdoc measdoc_mm on orsrvmm.id_pgku_cur=measdoc_mm.id_measdoc");
		sql.append("  where a0.id_en ='"+id_en+"'");
		sql.append("  and orsrv.fg_bl='Y'");
		sql.append("  and a0.code_entp = '"+code_entp+"'");
		sql.append("  and a0.fg_canc = 'N'");
		sql.append("  and a0.EU_ORSRCMDTP not in ('"+ OrSourceFromEnum.IIHMEDTECHORDERS + "')");
		sql.append("  and (a0.eu_feereversetp is null or a0.eu_feereversetp <> 1) ");
		sql.append("  order by a0.createdtime "+OrderSequenceModel);
		return sql.toString();
	}
	/**
	 * 数据库查出的数据转为CiOrdFeeSrvDto
	 * @author yzh
	 * @param ordFeeList
	 * @return
	 */
	private List<CiOrdFeeSrvDTO> handleOrdFeeList(List<Map<String, Object>> ordFeeList){
		List<CiOrdFeeSrvDTO> ciOrdFeeList = new ArrayList<CiOrdFeeSrvDTO>();
		for (Map<String, Object> ordFee : ordFeeList) {
			CiOrdFeeSrvDTO ciOrdFeeSrvDTO = new CiOrdFeeSrvDTO();
			if(CiOrdUtils.isEmpty(ordFee)) continue;
			ciOrdFeeSrvDTO.setId_or(CiOrdUtils.nullHandle(ordFee.get("id_or")));
			ciOrdFeeSrvDTO.setCode_or(CiOrdUtils.nullHandle(ordFee.get("code_or")));
			ciOrdFeeSrvDTO.setDt_effe(CiOrdUtils.isEmpty(ordFee.get("dt_effe"))?null:new FDateTime((String)ordFee.get("dt_effe")));
			ciOrdFeeSrvDTO.setContent_or(CiOrdUtils.nullHandle(ordFee.get("content_or")));
			ciOrdFeeSrvDTO.setName_srv(CiOrdUtils.nullHandle(ordFee.get("name_srv")));
			ciOrdFeeSrvDTO.setName_hp(CiOrdUtils.nullHandle(ordFee.get("name_hp")));
			ciOrdFeeSrvDTO.setQuan_total_medu(CiOrdUtils.isEmpty(ordFee.get("med_unit"))?FDouble.ONE_DBL:new FDouble(ordFee.get("med_unit").toString()));
			ciOrdFeeSrvDTO.setPrice(CiOrdUtils.isEmpty(ordFee.get("price"))?FDouble.ONE_DBL:new FDouble(ordFee.get("price").toString()));
			ciOrdFeeSrvDTO.setAmt_total(CiOrdUtils.isEmpty(ordFee.get("amt_total"))?FDouble.ONE_DBL:new FDouble(ordFee.get("amt_total").toString()));
			ciOrdFeeSrvDTO.setName_unit_med(CiOrdUtils.nullHandle(ordFee.get("name_unit_med")));
			//如果是药品做特殊处理 药品的编码显示物品编码 药品的数量取ci_or_srv_mm表数量
			if(!CiOrdUtils.isEmpty(ordFee.get("sd_srvtp")) && ordFee.get("sd_srvtp").toString().startsWith(IBdSrvDictCodeConst.SD_SRVTP_DRUG)){
				ciOrdFeeSrvDTO.setAmt_total(CiOrdUtils.isEmpty(ordFee.get("amt_total_drug"))?FDouble.ONE_DBL:new FDouble(ordFee.get("amt_total_drug").toString()));
				ciOrdFeeSrvDTO.setQuan_total_medu(CiOrdUtils.isEmpty(ordFee.get("quan_drug"))?FDouble.ONE_DBL:new FDouble(ordFee.get("quan_drug").toString()));
				ciOrdFeeSrvDTO.setName_unit_med(CiOrdUtils.nullHandle(ordFee.get("mm_name_unit_med")));
				//ciOrdFeeSrvDTO.setCode_or(CiOrdUtils.nullHandle(ordFee.get("code_mm")));
			}
			ciOrdFeeSrvDTO.setFee_code_or(CiOrdUtils.nullHandle(ordFee.get("fee_code_or")));
			ciOrdFeeSrvDTO.setFg_indic(CiOrdUtils.isEmpty(ordFee.get("fg_indic"))?FBoolean.FALSE:new FBoolean(ordFee.get("fg_indic").toString()));
			ciOrdFeeSrvDTO.setFg_selfpay(CiOrdUtils.isEmpty(ordFee.get("fg_selfpay"))?FBoolean.FALSE:new FBoolean(ordFee.get("fg_selfpay").toString()));
			ciOrdFeeSrvDTO.setName_dep(CiOrdUtils.nullHandle(ordFee.get("name_dep")));
			ciOrdFeeSrvDTO.setDes_srv(CiOrdUtils.nullHandle(ordFee.get("des_srv")));
			ciOrdFeeList.add(ciOrdFeeSrvDTO);
		}
		return ciOrdFeeList;
	}
}
