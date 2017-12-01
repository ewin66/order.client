package iih.ci.ord.s.bp.oporsplit.qry;

import iih.ci.ord.dto.oporsplit.d.OpOrSplitParamDTO;
import iih.ci.ord.s.bp.oporsplit.help.OpSplitUtils;
import iih.ci.ord.s.bp.oporsplit.help.StrProcesUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrSplitSql implements ITransQry {

	private OpOrSplitParamDTO DTO;//门诊医嘱拆分入口参数

	String[] id_ors;//医嘱主键串
	String[] id_ens;//就诊主键串
	String[] sd_srvtps;//服务类型编码串
	String[] id_routes;//医嘱用法主键串
	
	public GetOrSplitSql(OpOrSplitParamDTO orSplitParDTO){
		
		this.DTO=orSplitParDTO;
		this.id_ors=StrProcesUtils.StrSplit(DTO.getId_ors());
		this.id_ens=StrProcesUtils.StrSplit(DTO.getId_ens());
		this.sd_srvtps=StrProcesUtils.StrSplit(DTO.getSd_srvtps());
		this.id_routes=StrProcesUtils.StrSplit(DTO.getId_routes());		
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam Param = new SqlParam();
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}
	
	public String getSqlStr() {
		StringBuffer SqlStr = new StringBuffer();
		
		SqlStr.append("select  ");
		SqlStr.append(OpSplitUtils.OPORSPLIT_EN_SQL+",");
		SqlStr.append(OpSplitUtils.OPORSPLIT_OR_SQL+",");
		SqlStr.append(OpSplitUtils.OPORSPLIT_BASE_SQL);
		SqlStr.append(" from ci_order ");
		SqlStr.append(" inner join en_ent on ci_order.id_en=en_ent.id_ent ");
		SqlStr.append(" left join bd_freq on ci_order.id_freq=bd_freq.id_freq ");
		SqlStr.append(" where ci_order.fg_mp_in ='Y'  ");  //在院执行标志
		SqlStr.append(" and ent.code_entp='00' "); //就诊类型
		SqlStr.append(" and ci_order.fg_sign='Y' "); //医嘱签署标志
		SqlStr.append(" and ci_order.fg_pmor='N' "); //备用医嘱标志
		
		
		if(id_ors!=null&&id_ors.length>0) {		
			SqlStr.append(" and ci_order.id_or in ("+StrProcesUtils.StrMerge(id_ors)+") ");  // 医嘱id
		}		
		if(id_ens!=null&&id_ens.length>0){
			SqlStr.append(" and ci_order.id_ent in ("+StrProcesUtils.StrMerge(id_ens)+") ");  //就诊id
		}
		if(sd_srvtps!=null&&sd_srvtps.length>0){
			SqlStr.append(" and ci_order.sd_srvtp in ("+StrProcesUtils.StrMerge(sd_srvtps)+") ");  // 服务类型
		}
		if(id_routes!=null&&id_routes.length>0){
			SqlStr.append(" and ci_order.id_route In () ");  // 医嘱用法
		}
		
		return SqlStr.toString();
	}
}
