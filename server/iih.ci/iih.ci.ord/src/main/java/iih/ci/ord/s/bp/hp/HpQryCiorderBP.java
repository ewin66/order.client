package iih.ci.ord.s.bp.hp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.hp.d.HpQryCiorderDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医嘱、物品、服务集合 医保使用
 * 
 * @author HUMS
 *
 */
public class HpQryCiorderBP {

	@SuppressWarnings({ "unchecked" })
	public FArrayList2 exec(String id_pat, FDateTime start, FDateTime end) throws BizException {

		if (StringUtils.isBlank(id_pat)) {
			throw new BizException("医保调用就诊接口传入参数id_pat不能为空");
		}

		if (end.before(start)) {
			throw new BizException("医保调用就诊接口传入参数开始、结束日期不能为空，并且开始日期不能大于结束日期");
		}

		// 返回结果集合
		FArrayList2 resultCiorderList = null;

		// 医嘱id集合
		List<String> idOrList = new ArrayList<String>();
		// 医嘱服务项目id集合
		List<String> idOrSrvList = new ArrayList<String>();
		// 医嘱服务项目Map集合List<OrdSrvDO>
		Map<String, FArrayList2> ordSrvMap = new HashMap<String, FArrayList2>();

		// 查询有效的医嘱
		List<CiOrderDO> ciorderList = this.getCiorderList(id_pat, start, end);
		// 如果医嘱为空直接返回
		if(ciorderList == null || ciorderList.size() ==0 ){
			return null;
		}
		
		for(CiOrderDO ciOrder : ciorderList){
			idOrList.add(ciOrder.getId_or());
		}

		// 遍历医嘱服务项目，并构造map结构方便后续使用
		List<OrdSrvDO> ciorSrvList = this.getOrdsrvList(idOrList);
		if(ciorSrvList == null || ciorSrvList.size() == 0){ // 如果服务项目为空，就不存在对应的物品，直接返回空
			return null;
		}
		
		// 遍历全部的服务项目，构造医嘱id和服务项目集合的map结构
		for (OrdSrvDO ordSrv : ciorSrvList) {

			FArrayList2 tempOrSrvList = null;
			if(ordSrv.getFg_mm() == FBoolean.TRUE){
				// 物品服务项目集合
				idOrSrvList.add(ordSrv.getId_orsrv());	
			}
			
			// 构造医嘱id与服务项目的map集合
			if (ordSrvMap.containsKey(ordSrv.getId_or())) {
				tempOrSrvList = ordSrvMap.get(ordSrv.getId_or());
			} else {
				tempOrSrvList = new FArrayList2();
				ordSrvMap.put(ordSrv.getId_or(), tempOrSrvList);
			}

			tempOrSrvList.add(ordSrv);
		}
		
		// 缓存服务项目和物品对应关系
		Map<String, FArrayList2> ordSrvMmMap = new HashMap<String, FArrayList2>();
		
		// 获取物品集合		 
		if(idOrSrvList.size() >0){
			List<OrdSrvMmDO> ordSrvMmList = getOrdsrvmms(idOrSrvList);	
			for (OrdSrvMmDO ordSrvMm : ordSrvMmList) {

				FArrayList2 tempOrdSrvMmList = null;
				if (ordSrvMmMap.containsKey(ordSrvMm.getId_orsrv())) {
					tempOrdSrvMmList = ordSrvMmMap.get(ordSrvMm.getId_orsrv());
				} else {
					tempOrdSrvMmList = new FArrayList2();
					ordSrvMmMap.put(ordSrvMm.getId_orsrv(), tempOrdSrvMmList);
				}

				tempOrdSrvMmList.add(ordSrvMm);
			}
		}

		// 循环遍历
		for (int i = 0; i < ciorderList.size(); i++) {

			FArrayList2 orSrvMmList = null;
			CiOrderDO ciorder = ciorderList.get(i);

			// 获取医嘱对应的服务集合
			FArrayList2 ordsrvList = ordSrvMap.get(ciorder.getId_or());
			if(ordsrvList == null || ordsrvList.size() ==0){
				continue;
			}
			
			if(resultCiorderList == null){
				resultCiorderList = new FArrayList2();
			}
			
			for (int j = 0; j < ordsrvList.size(); j++) {

				OrdSrvDO ordSrv = (OrdSrvDO) ordsrvList.get(j);
				if (ordSrvMmMap.get(ordSrv.getId_orsrv()) != null && ordSrvMmMap.get(ordSrv.getId_orsrv()).size() > 0) {
					if (orSrvMmList == null) {
						orSrvMmList = new FArrayList2();
					}
					orSrvMmList.addAll(ordSrvMmMap.get(ordSrv.getId_orsrv()));
				}
			}

			// 返回封装医嘱、项目、物品的集合
			HpQryCiorderDTO dto = new HpQryCiorderDTO();
			dto.setCiorderdo(ciorder); // 添加医嘱
			dto.setOrdsrvs(ordsrvList); // 添加服务项目
			dto.setOrdsrvmms(orSrvMmList);// 添加物品
			
			resultCiorderList.add(dto);// 返回结果集合
		}

		return resultCiorderList;
	}

	/**
	 * 查询有效就诊中的有效医嘱（排除退诊关联的、作废的医嘱）
	 * 
	 * @param id_pat
	 * @return
	 * @throws DAException
	 */
	private List<CiOrderDO> getCiorderList(String id_pat, FDateTime start, FDateTime end) throws DAException {

		// 查询医嘱，指定时间周期的有效医保就诊（en_ent_hp.fg_fundpay=Y），
		StringBuffer sql = new StringBuffer();
		sql.append("select * from ci_order ci where fg_sign='Y' and fg_canc='N' and sd_su_bl<>'"+ICiDictCodeConst.SD_SU_BL_REFOUND+"' and exists ");
		sql.append("( select 1 from en_ent ent,en_ent_hp hp ");
		sql.append("where ent.id_pat = ? and ent.id_ent=hp.id_ent and fg_fundpay='Y' and ent.fg_canc='N' ");
		sql.append("and ci.dt_effe >=? and ci.dt_effe <=? and ent.id_ent = ci.id_en)");

		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_pat);
		sqlParam.addParam(start);
		sqlParam.addParam(end);
		CiOrderDO ciorder = new CiOrderDO();

		DAFacade dAFacade = new DAFacade();
		return (List<CiOrderDO>) dAFacade.execQuery(sql.toString(), sqlParam, new BeanListHandler(CiOrderDO.class));
	}

	/**
	 * 查询医嘱关联的服务项目
	 * 医保标识并且已经结账的服务项目
	 * 
	 * @param idOrList
	 * @return
	 * @throws DAException
	 */
	private List<OrdSrvDO> getOrdsrvList(List<String> idOrList) throws DAException {

		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer paramBuffer = new StringBuffer();
		SqlParam sqlParam = new SqlParam();

		sqlBuffer.append("select * from ci_or_srv srv where   srv.id_or in ( ");
		for (int i = 0; i < idOrList.size(); i++) {
			paramBuffer.append(",?");
			sqlParam.addParam(idOrList.get(i));
		}
		sqlBuffer.append(paramBuffer.substring(1)).append(")");
		sqlBuffer.append(" and srv.fg_selfpay = 'N' ");
		sqlBuffer.append(" and srv.fg_self ='N'  ");
		DAFacade dAFacade = new DAFacade();
		return (List<OrdSrvDO>) dAFacade.execQuery(sqlBuffer.toString(), sqlParam, new BeanListHandler(OrdSrvDO.class));
	}

	/**
	 * 查询服务项目关联的物品
	 * 
	 * @param idOrsrvList
	 * @return
	 * @throws DAException
	 */
	private List<OrdSrvMmDO> getOrdsrvmms(List<String> idOrsrvList) throws DAException {

		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer paramBuffer = new StringBuffer();
		SqlParam sqlParam = new SqlParam();

		sqlBuffer.append("select t.*,p.id_srv from ci_or_srv_mm t,ci_or_srv p where t.id_orsrv = p.id_orsrv and  t.id_orsrv in ( ");
		for (int i = 0; i < idOrsrvList.size(); i++) {
			paramBuffer.append(",?");
			sqlParam.addParam(idOrsrvList.get(i));
		}

		String sql = sqlBuffer.append(paramBuffer.substring(1)).append(")").toString();

		DAFacade dAFacade = new DAFacade();
		return (List<OrdSrvMmDO>) dAFacade.execQuery(sql.toString(), sqlParam, new BeanListHandler(OrdSrvMmDO.class));
	}

}
