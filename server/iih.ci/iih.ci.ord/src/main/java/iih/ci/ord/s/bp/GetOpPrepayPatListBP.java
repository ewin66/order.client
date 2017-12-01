package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.dto.prepaypat.d.PrepayCondDTO;
import iih.ci.ord.dto.prepaypat.d.PrepayPatDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取得门诊未缴费预付费患者列表
 * @author ly
 *
 */
public class GetOpPrepayPatListBP {

	//窗口可接受处方类型
	private String prestp;

	public GetOpPrepayPatListBP() {
		 
	}
	/**
	 * 取得门诊未缴费预付费患者列表(药品医嘱)
	 * @param cond 查询条件
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	public PrepayPatDTO[] exec(PrepayCondDTO cond) throws BizException {
	
		if(cond == null)
			return null;
		
		this.validate(cond);
		
		String sql = this.getBaseSql();
		SqlParam param  = new SqlParam();
		
		sql += this.getWhereSql(cond, param);
		
		List<PrepayPatDTO> result = (List<PrepayPatDTO>)new DAFacade().
				execQuery(sql, param, new BeanListHandler(PrepayPatDTO.class));
		
		if(ListUtil.isEmpty(result))
			return null;
		
		return this.filter(result);
	}
	
	/**
	 * 简单校验
	 * @param cond
	 * @throws BizException
	 */
	private void validate(PrepayCondDTO cond) throws BizException {
		
		//时间校验
		if(cond.getDt_effe_begin() != null && cond.getDt_effe_end() != null &&
				cond.getDt_effe_begin().compareTo(cond.getDt_effe_end()) > 0){
			throw new BizException("开始时间必须小于结束时间");
		}
	}
	
	/**
	 * 获取基础sql
	 * @return
	 */
	private String getBaseSql(){
		
		String baseSql = "select distinct "
				+ "ord.id_pat, "
				+ "ord.id_en, "
				+ "pat.code code_pat, "
				+ "pat.name name_pat, "
				+ "ord.dt_effe dt_effe "
				+ "from ci_order ord "
				+ "inner join ci_or_srv srv "
				+ "on ord.id_or = srv.id_or "
				+ "inner join pi_pat pat "
				+ "on ord.id_pat = pat.id_pat "
				+ "inner join pi_pat_acc acc "
				+ "on pat.id_pat = acc.id_pat "
				+ "join ci_pres pres "
				+ "on srv.id_pres = pres.id_pres "
				+ "where ord.ds = 0 "
				+ "and ord.code_entp = '00' "
				+ "and ord.fg_sign = 'Y' "
				+ "and ord.fg_canc = 'N' "
				+ "and ord.sd_su_mp = '0' "
				+ "and ord.sd_su_bl = '0' "
				+ "and (NVL(acc.prepay,0)+NVL(acc.cred,0)-NVL(acc.acc_lock,0)) > 0 "; //暂定预交金需要大于0
		
		return baseSql;
	}

	/**
	 * 获取where sql
	 * @return
	 */
	private String getWhereSql(PrepayCondDTO cond,SqlParam param){
		
		String whereSql = "";
		
		if(FBoolean.TRUE.equals(cond.getFg_herb())){
			whereSql += "and substr(ord.sd_srvtp, 1, 4) = '"+IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG+"' ";
		}else{
			whereSql += "and (substr(ord.sd_srvtp, 1, 4) = '" + IBdSrvDictCodeConst.SD_SRVTP_WESTDRUG
					+"' or substr(ord.sd_srvtp, 1, 4) = '"+ IBdSrvDictCodeConst.SD_SRVTP_CYDRUG + "') ";
		}
		
		if(cond.getDt_effe_begin()!= null){
			whereSql += "and ord.dt_effe >= ? ";
			param.addParam(cond.getDt_effe_begin().toString());
		}
		
		if(cond.getDt_effe_end()!= null){
			whereSql += "and ord.dt_effe <= ? ";
			param.addParam(cond.getDt_effe_end().toString());
		}
		
		if(!StringUtil.isEmptyWithTrim(cond.getSd_prestp())){
			whereSql += "and pres.sd_prestp in("+cond.getSd_prestp()+") ";
		}
		
		return whereSql;
	}
	
	/**
	 * 过滤掉重复患者(就诊id会丢失)
	 * @param list
	 */
	private PrepayPatDTO[] filter(List<PrepayPatDTO> list){
		
		Map<String,PrepayPatDTO> map = new HashMap<String,PrepayPatDTO>();
		for (PrepayPatDTO item : list) {
			if(!map.containsKey(item.getId_pat())){
				map.put(item.getId_pat(), item);
			}
		}
		
		return map.values().toArray(new PrepayPatDTO[map.size()]);
	}
}
