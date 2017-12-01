/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.BlFeeCiOrderSrvDto.d.BlFeeCiOrderSrvDto;
import iih.ci.ord.pub.CiOrdAppUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * @ClassName: getCiOrderAggDOBP
 * @Description:  费用使用，取得医嘱信息和医嘱项目信息
 * @author Comsys-li_zheng
 * @date 2016年5月10日 下午4:23:16
 * @Package iih.ci.ord.s.bp
 * Copyright: Copyright (c) 2011 
 * Company: 北大医疗信息技术有限责任公司
 */
public class getCiOrderAggDOBP {

	public CiorderAggDO[] exe(String wherestr,List TableColumnList)throws BizException{
		DAFacade dafacade=new DAFacade();
		String sql = getSql(wherestr,TableColumnList);
		List<BlFeeCiOrderSrvDto> OrderSrvDto =(List<BlFeeCiOrderSrvDto>)dafacade.execQuery(sql, new BeanListHandler(BlFeeCiOrderSrvDto.class));
	    if(OrderSrvDto== null || OrderSrvDto.size()==0) return null;
		return BlFeeCiOrderSrvDtoTOOrderAgg(OrderSrvDto);
	}
	
	private String getSql(String wherestr,List TableColumnList){
		String sql = "";
		sql =  getListToSql(TableColumnList);
		if(wherestr != null && wherestr !="") {
			return sql += " where   "+ wherestr + "  order by ci_order.id_or ";	
		}else{
			return sql + "  order by ci_order.id_or "  ;
		}
	}
	
	private String getListToSql(List TableColumnList){
		String sql = "select ";
		for(int i =0;i<TableColumnList.size();i++){
			sql+=TableColumnList.get(i)+" , ";
		}
		sql = sql.substring(0, sql.lastIndexOf(","));
		sql+= "  from ci_order ci_order left outer join ci_or_srv  ci_or_srv ";
		sql+= "   on ci_order.id_or = ci_or_srv.id_or  ";
		return sql;
	}
	
	//dto 转换成 医嘱的aggDO
	private CiorderAggDO[] BlFeeCiOrderSrvDtoTOOrderAgg(List<BlFeeCiOrderSrvDto> OrderSrvDto){
		Map<String,CiOrderDO> mapOrder = new HashMap();
		Map<String,List<OrdSrvDO>> mapSrvList = new HashMap();
		List<CiorderAggDO> listAgg = new ArrayList<CiorderAggDO>();
		String temp_id_or = "";
		CiorderAggDO agg = null;
		for(BlFeeCiOrderSrvDto dto:OrderSrvDto){
			if(!mapOrder.containsKey(dto.getId_or())){
				mapOrder.put(dto.getId_or(), CreateCiOrderDO(dto));
			} 
			if(dto.getId_or().equals(temp_id_or)){
				 OrdSrvDO ordsrv = createOrdSrvDO(dto); 
				 mapSrvList.get(dto.getId_or()).add(ordsrv);
			}else{
				 OrdSrvDO ordsrv = createOrdSrvDO(dto);
				 List<OrdSrvDO> listsrv = new ArrayList<OrdSrvDO>();
				 listsrv.add(ordsrv);
				 mapSrvList.put(dto.getId_or(),listsrv);
			}
			temp_id_or = dto.getId_or();
		}
         if(mapOrder != null && mapOrder.size() > 0){
        	 for(CiOrderDO orderDO:mapOrder.values()){
        		 agg = new CiorderAggDO();
				 agg.setParent(orderDO);
				 agg.setOrdSrvDO(mapSrvList.get(orderDO.getId_or()).toArray(new OrdSrvDO[]{}));
				 listAgg.add(agg); 
        	 }
         }
      return  listAgg.toArray(new CiorderAggDO[]{});
	}
	
	/**
	 * 
	 * @param orderSrvDto
	 * @return
	 */
	private CiOrderDO CreateCiOrderDO(BlFeeCiOrderSrvDto orderSrvDto){
		CiOrderDO order = new CiOrderDO();
		order.setApplyno(orderSrvDto.getApplyno());
		order.setId_emp_stop(orderSrvDto.getId_emp_stop());
		order.setId_dep_stop(orderSrvDto.getId_dep_stop());
		order.setDt_stop(orderSrvDto.getDt_stop());
		order.setFg_chk_stop(orderSrvDto.getFg_chk_stop());
		order.setId_emp_chk_stop(orderSrvDto.getId_emp_chk_stop());
		order.setId_dep_chk_stop(orderSrvDto.getId_dep_chk_stop());
		order.setDt_chk_stop(orderSrvDto.getDt_chk_stop());
		order.setFg_canc(orderSrvDto.getFg_canc());
		order.setId_emp_canc(orderSrvDto.getId_emp_canc());
		order.setId_dep_canc(orderSrvDto.getId_dep_canc());
		order.setDt_canc(orderSrvDto.getDt_canc());
		order.setFg_chk_canc(orderSrvDto.getFg_chk_canc());
		order.setId_emp_chk_canc(orderSrvDto.getId_emp_chk_canc());
		order.setId_dep_chk_canc(orderSrvDto.getId_dep_chk_canc());
		order.setDt_chk_canc(orderSrvDto.getDt_chk_canc());
		order.setFg_pmor(orderSrvDto.getFg_pmor());
		order.setDes_pmor(orderSrvDto.getDes_pmor());
		order.setFg_active_pm(orderSrvDto.getFg_active_pm());
		order.setId_reltp(orderSrvDto.getId_reltp());
		order.setSd_reltp(orderSrvDto.getSd_reltp());
		order.setId_or_rel(orderSrvDto.getId_or_rel());
		order.setFg_bb(orderSrvDto.getFg_bb());
		order.setNo_bb(orderSrvDto.getNo_bb());
		order.setFg_ctlcp(orderSrvDto.getFg_ctlcp());
		order.setFg_mr(orderSrvDto.getFg_mr());
		order.setFg_skintest(orderSrvDto.getFg_skintest());
		order.setFg_mp_in(orderSrvDto.getFg_mp_in());
		order.setTimes_mp_in(orderSrvDto.getTimes_mp_in());
		order.setFg_mp_bed(orderSrvDto.getFg_mp_bed());
		order.setNote_or(orderSrvDto.getNote_or());
		order.setCreatedby(orderSrvDto.getCreatedby());
		order.setCreatedtime(orderSrvDto.getCreatedtime());
		order.setModifiedby(orderSrvDto.getModifiedby());
		order.setModifiedtime(orderSrvDto.getModifiedtime());
		order.setEu_verify_pharm(orderSrvDto.getEu_verify_pharm());
		order.setDes_verify_pharm(orderSrvDto.getDes_verify_pharm());
		//order.setId_excep_level_pharm(orderSrvDto.getId_excep_level_pharm());
		order.setSd_excep_level_pharm(orderSrvDto.getSd_excep_level_pharm());
		order.setDes_verify_sys(orderSrvDto.getDes_verify_sys());
		//order.setId_excep_level_sys(orderSrvDto.getId_excep_level_sys());
		order.setSd_excep_level_sys(orderSrvDto.getSd_excep_level_sys());
		order.setId_emp_verify_pharm(orderSrvDto.getId_emp_verify_pharm());
		order.setDt_verify_pharm(orderSrvDto.getDt_verify_pharm());
		order.setDes_bk_pharm(orderSrvDto.getDes_bk_pharm());
		order.setDt_bk_pharm(orderSrvDto.getDt_bk_pharm());
		order.setId_emp_bk_pharm(orderSrvDto.getId_emp_bk_pharm());
		//order.setDs(orderSrvDto.getDs());
		//order.setSv(orderSrvDto.getSv());
		order.setId_ecep_level_sys(orderSrvDto.getId_ecep_level_sys());
		order.setId_ecep_level_pharm(orderSrvDto.getId_ecep_level_pharm());
		order.setDt_end(orderSrvDto.getDt_end());
		order.setName_or(orderSrvDto.getName_or());
		order.setId_srvca(orderSrvDto.getId_srvca());
		order.setFg_pkg(orderSrvDto.getFg_pkg());
		order.setQuan_firday_mp(orderSrvDto.getQuan_firday_mp());
		order.setFg_or_form(orderSrvDto.getFg_or_form());
		order.setId_skintest_skip_reason(orderSrvDto.getId_skintest_skip_reason());
		order.setSd_skintest_skip_reason(orderSrvDto.getSd_skintest_skip_reason());
		order.setId_srv(orderSrvDto.getId_srv());
		order.setFg_set(orderSrvDto.getFg_set());
		//order.setId_srv_set(orderSrvDto.getId_srv_set());
		//order.setTimes_firday_mp(orderSrvDto.getTimes_firday_mp());
		order.setFg_pres_outp(orderSrvDto.getFg_pres_outp());
		order.setFuncclassstr(orderSrvDto.getFuncclassstr());
		order.setId_srvof(orderSrvDto.getId_srvof());
		order.setId_or(orderSrvDto.getId_or());
		order.setId_grp(orderSrvDto.getId_grp());
		order.setId_org(orderSrvDto.getId_org());
		order.setId_pat(orderSrvDto.getId_pat());
		order.setId_en(orderSrvDto.getId_en());
		order.setId_entp(orderSrvDto.getId_entp());
		order.setCode_entp(orderSrvDto.getCode_entp());
		order.setId_srvtp(orderSrvDto.getId_srvtp());
		order.setSd_srvtp(orderSrvDto.getSd_srvtp());
		order.setId_srv_pkg(orderSrvDto.getId_srv_pkg());
		order.setFg_long(orderSrvDto.getFg_long());
		order.setCode_or(orderSrvDto.getCode_or());
		order.setContent_or(orderSrvDto.getContent_or());
		order.setDes_or(orderSrvDto.getDes_or());
		order.setId_freq(orderSrvDto.getId_freq());
		order.setOrders(orderSrvDto.getOrders());
		order.setFg_boil(orderSrvDto.getFg_boil());
		order.setOrders_boil(orderSrvDto.getOrders_boil());
		order.setId_route(orderSrvDto.getId_route());
		order.setId_routedes(orderSrvDto.getId_routedes());
		order.setId_boil(orderSrvDto.getId_boil());
		order.setId_boildes(orderSrvDto.getId_boildes());
		order.setDays_or(orderSrvDto.getDays_or());
		order.setId_su_or(orderSrvDto.getId_su_or());
		order.setSd_su_or(orderSrvDto.getSd_su_or());
		order.setId_su_mp(orderSrvDto.getId_su_mp());
		order.setSd_su_mp(orderSrvDto.getSd_su_mp());
		order.setId_su_bl(orderSrvDto.getId_su_bl());
		order.setSd_su_bl(orderSrvDto.getSd_su_bl());
		order.setId_org_or(orderSrvDto.getId_org_or());
		order.setId_dep_or(orderSrvDto.getId_dep_or());
		order.setId_wg_or(orderSrvDto.getId_wg_or());
		order.setId_emp_or(orderSrvDto.getId_emp_or());
		order.setDt_entry(orderSrvDto.getDt_entry());
		order.setFg_sign(orderSrvDto.getFg_sign());
		order.setId_emp_sign(orderSrvDto.getId_emp_sign());
		order.setId_dep_sign(orderSrvDto.getId_dep_sign());
		order.setDt_sign(orderSrvDto.getDt_sign());
		order.setDt_effe(orderSrvDto.getDt_effe());
		order.setDt_invalid(orderSrvDto.getDt_invalid());
		order.setFg_chk(orderSrvDto.getFg_chk());
		order.setId_emp_chk(orderSrvDto.getId_emp_chk());
		order.setId_dep_chk(orderSrvDto.getId_dep_chk());
		order.setDt_chk(orderSrvDto.getDt_chk());
		order.setFg_stop(orderSrvDto.getFg_stop());
		order.setDt_last_bl(orderSrvDto.getDt_last_bl());
		return order;
	}
	/**
	 * 
	 * @param orderSrvDto
	 * @return
	 */
	private OrdSrvDO createOrdSrvDO(BlFeeCiOrderSrvDto orderSrvDto){
		OrdSrvDO   ordsrv = new OrdSrvDO();
		ordsrv.setId_orsrv(orderSrvDto.getId_orsrv());
		ordsrv.setId_or(orderSrvDto.getId_or());
		ordsrv.setId_pres(orderSrvDto.getId_pres());
		ordsrv.setId_pat(orderSrvDto.getId_pat());
		ordsrv.setId_entp(orderSrvDto.getId_entp());
		ordsrv.setCode_entp(orderSrvDto.getCode_entp());
		ordsrv.setId_en(orderSrvDto.getId_en());
		ordsrv.setSortno(orderSrvDto.getSortno());
		ordsrv.setId_srvtp(orderSrvDto.getId_srvtp());
		ordsrv.setSd_srvtp(orderSrvDto.getSd_srvtp());
		ordsrv.setId_srv(orderSrvDto.getId_srv());
		ordsrv.setName(orderSrvDto.getName());
		ordsrv.setFg_dose_anoma(orderSrvDto.getFg_dose_anoma());
		ordsrv.setQuan_medu(orderSrvDto.getQuan_medu());
		ordsrv.setId_medu(orderSrvDto.getId_medu());
		//增加一列
		ordsrv.setQuan_total_medu(orderSrvDto.getQuan_total_medu());
		
		ordsrv.setId_route(orderSrvDto.getId_route());
		ordsrv.setId_routedes(orderSrvDto.getId_routedes());
		ordsrv.setId_boil(orderSrvDto.getId_boil());
		ordsrv.setId_boildes(orderSrvDto.getId_boildes());
		ordsrv.setId_freq(orderSrvDto.getId_freq());
		ordsrv.setId_org_srv(orderSrvDto.getId_org_srv());
		ordsrv.setId_dep_srv(orderSrvDto.getId_dep_srv());
		ordsrv.setId_wg_or(orderSrvDto.getId_wg_or());
		ordsrv.setId_emp_srv(orderSrvDto.getId_emp_srv());
		ordsrv.setId_org_mp(orderSrvDto.getId_org_mp());
		ordsrv.setId_dep_mp(orderSrvDto.getId_dep_mp());
		ordsrv.setId_su_mp(orderSrvDto.getId_su_mp());
		ordsrv.setSd_su_mp(orderSrvDto.getSd_su_mp());
		ordsrv.setId_su_bl(orderSrvDto.getId_su_bl());
		ordsrv.setSd_su_bl(orderSrvDto.getSd_su_bl());
		ordsrv.setDt_last_mp(orderSrvDto.getDt_last_mp());
		ordsrv.setDt_last_bl(orderSrvDto.getDt_last_bl());
		ordsrv.setFg_or(orderSrvDto.getFg_or());
		ordsrv.setEu_blmd(orderSrvDto.getEu_blmd());
		ordsrv.setFg_mm(orderSrvDto.getFg_mm());
		ordsrv.setPri(orderSrvDto.getPri());
		ordsrv.setFg_set(orderSrvDto.getFg_set());
		ordsrv.setFg_indic(orderSrvDto.getFg_indic());
		ordsrv.setFg_propc(orderSrvDto.getFg_propc());
		ordsrv.setFg_self(orderSrvDto.getFg_self());
		ordsrv.setFg_pres_outp(orderSrvDto.getFg_pres_outp());
		ordsrv.setNote_srv(orderSrvDto.getNote_srv());
		//ordsrv.setDs(orderSrvDto.getDs());
		//ordsrv.setSv(orderSrvDto.getSv());
		//ordsrv.setDt_entry(orderSrvDto.getDt_entry());
		ordsrv.setDt_create(orderSrvDto.getDt_create());
		ordsrv.setId_srvca(orderSrvDto.getId_srvca());
		ordsrv.setFg_bl(orderSrvDto.getFg_bl());
		ordsrv.setCode_srv(orderSrvDto.getCode_srv());
		ordsrv.setId_dep_nur_srv(orderSrvDto.getId_dep_nur_srv());
		ordsrv.setEu_sourcemd(orderSrvDto.getEu_sourcemd());
		ordsrv.setId_hp(orderSrvDto.getId_hp());
		ordsrv.setId_hpsrvtp(orderSrvDto.getId_hpsrvtp());
		ordsrv.setSd_hpsrvtp(orderSrvDto.getSd_hpsrvtp());
		ordsrv.setFg_skintest(orderSrvDto.getFg_skintest());
		ordsrv.setId_skintest_skip_reason(orderSrvDto.getId_skintest_skip_reason());
		ordsrv.setSd_skintest_skip_reason(orderSrvDto.getSd_skintest_skip_reason());
		ordsrv.setId_reltp(orderSrvDto.getId_reltp());
		ordsrv.setSd_reltp(orderSrvDto.getSd_reltp());
		ordsrv.setId_or_rel(orderSrvDto.getId_or_rel());
		return ordsrv;
	}
}
