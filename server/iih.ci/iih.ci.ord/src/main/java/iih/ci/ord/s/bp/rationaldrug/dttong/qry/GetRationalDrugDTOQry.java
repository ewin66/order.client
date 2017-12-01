package iih.ci.ord.s.bp.rationaldrug.dttong.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.pub.DateUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取合理用药检查的药品数据<br>
 * 包括本次签署医嘱对应的药品，本次就诊已签署的药品医嘱 ，与本次就诊同一天在其他科室就诊已签署的药品医嘱
 * 
 * @author hums
 *
 */
public class GetRationalDrugDTOQry implements ITransQry {

	// 当前正在执行签署的医嘱id集合
	private String[] ordIds;
	// banner就诊信息
	private Ent4BannerDTO bannerDTO;

	public GetRationalDrugDTOQry(Ent4BannerDTO bannerDTO, String[] ordIds) {

		this.ordIds = ordIds;
		this.bannerDTO = bannerDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		// sql1 对应参数
		param.addParam(bannerDTO.getCode_entp());
		param.addParam(bannerDTO.getId_pat());
		param.addParam(bannerDTO.getId_ent());
		param.addParam(DateUtils.getCurTime().substring(0, 10)+"%"); // 对应生效日期
		
		// sql2对应参数
		param.addParam(bannerDTO.getCode_entp());
		param.addParam(bannerDTO.getId_pat());
		param.addParam(bannerDTO.getId_ent());
		for (int i = 0; i < ordIds.length; i++) {
			param.addParam(ordIds[i]);
		}

		return param;
	}

	@Override
	public String getQrySQLStr() {

		return this.getSql();
	}

	private String getSql() {
        
		//管控
		String orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "ord");
		// 查询已签署的药品 1.本次就诊已签署，2. 有效期等于当前的其他就诊对应的医嘱
		String sql1 = "select "
				+ "	ord.id_or ,ord.days_or ,ord.fg_sign ,"
				+ " srv.id_srv ,srv.name as name_srv ,srv.quan_medu ,"
				+ " mm.id_orsrvmm ,mm.code_mm ,mm.name_mm ,"
				+ " route.id_route ,route.code as route_code,route.name as route_name,"
				+ " freq.id_freq ,freq.code as freq_code ,freq.name as freq_name,"
				+ " medu.id_measdoc as id_medu ,medu.code as medu_code ,medu.name as medu_name"				
				+ " from ci_order ord "
				+ "		join ci_or_srv srv on ord.id_or = srv.id_or"
				+ "		join ci_or_srv_mm mm on mm.id_orsrv = srv.id_orsrv "
				+ "		left join bd_route route on srv.id_route = route.id_route"
				+ "		left join bd_freq freq on srv.id_freq = freq.id_freq"
				+ "		left join bd_measdoc medu on srv.id_medu = medu.id_measdoc"
				+ "	where (ord.eu_feereversetp is null or ord.eu_feereversetp != 1) and ord.fg_canc = 'N' and ord.code_entp = ? and ord.id_pat = ? and ord.fg_sign = 'Y' and ord.id_en = ? and ord.dt_effe like ?"
				+ " and "+orgsql;
		
		// 查询本次签署的药品
		String sql2 = " select "
				+ "	ord.id_or ,ord.days_or ,ord.fg_sign ,"
				+ " srv.id_srv ,srv.name as name_srv ,srv.quan_medu ,"
				+ " mm.id_orsrvmm ,mm.code_mm ,mm.name_mm,"
				+ " route.id_route ,route.code as route_code,route.name as route_name,"
				+ " freq.id_freq ,freq.code as freq_code ,freq.name as freq_name,"
				+ " medu.id_measdoc as id_medu ,medu.code as medu_code ,medu.name as medu_name"				
				+ " from ci_order ord "
				+ "		join ci_or_srv srv on ord.id_or = srv.id_or"
				+ "		join ci_or_srv_mm mm on mm.id_orsrv = srv.id_orsrv "
				+ "		left join bd_route route on srv.id_route = route.id_route"
				+ "		left join bd_freq freq on srv.id_freq = freq.id_freq"
				+ "		left join bd_measdoc medu on srv.id_medu = medu.id_measdoc"
				+ "	where (ord.eu_feereversetp is null or ord.eu_feereversetp != 1) and ord.fg_canc = 'N' and ord.code_entp = ? and ord.id_pat = ? and ord.id_en = ? and ord.fg_sign = 'N' "
				+ " and "+orgsql
				+ "		and ord.id_or in (";
		
		StringBuffer idOrBuffer = new StringBuffer();
		for (int i = 0; i < ordIds.length; i++) {
			idOrBuffer.append(",?");
		}

		
		sql2 += idOrBuffer.substring(1) + ")";
		return sql1 + " union " + sql2;
	}

}
