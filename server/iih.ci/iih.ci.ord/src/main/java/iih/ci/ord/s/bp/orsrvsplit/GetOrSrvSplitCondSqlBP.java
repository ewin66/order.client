package iih.ci.ord.s.bp.orsrvsplit;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.dto.blexorder.d.OrLongTempEnum;
import iih.ci.ord.dto.blexorder.d.OrSrvSplitParamDTO;
import iih.ci.ord.dto.blexorder.d.PresOutPTpEnum;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/***
 * 获得医嘱或服务拆分条件Sql串操作BP
 */
public class GetOrSrvSplitCondSqlBP {
	/***
	 * 获得医嘱或服务拆分条件Sql串信息
	 * 
	 * @param param
	 * @return
	 * @throws BizException
	 */
	public String exec(OrSrvSplitParamDTO param) throws BizException {
		StringBuffer rtn = new StringBuffer();

		// 基础条件处理 住院已核对未作废非备用非自备
		Integer orgensplittp = param.getEu_orgensplittp();
		baseWhereHandle(rtn, orgensplittp);

		// 患者就诊字符串处理id_ens
		String id_ens = param.getId_ens();
		appendSqlStr(rtn, getEnCondStr(id_ens));

		// 医嘱字符串处理
		String id_ors = param.getId_ors();
		appendSqlStr(rtn, getOrCondStr(id_ors));

		// 服务类型字符串处理
		String sd_srvtps = param.getSd_srvtps();
		appendSqlStr(rtn, getSrvTpCondStr(sd_srvtps, orgensplittp));

		// 用法字符串处理id_routes
		String id_routes = param.getId_routes();
		appendSqlStr(rtn, getIdRouteCondStr(id_routes, orgensplittp));

		// 长期与临时医嘱条件处理eu_orlongtemp,
		Integer longtemp = param.getEu_orlongtemp();
		appendSqlStr(rtn, getLongtempCondStr(longtemp));

		// 病区处理逻辑id_dep_nur 需FSql处理
		String deptnur = param.getId_dep_nur();
		String[] depnurstrs = getDepNurHandleStr(deptnur);
		appendSqlStr(rtn, depnurstrs[1]);

		// 执行科室字符串处理id_dep_mp
		String id_dep_mp = param.getId_dep_mp();
		appendSqlStr(rtn, getIdDeptMpCondStr(id_dep_mp));

		// 服务项目字符串处理id_srvs,dt_split_start,dt_split_end,eu_orgensplittp
		String id_srvs = param.getId_srvs();
		appendSqlStr(rtn, getSrvCondStr(id_srvs));

		// 出院带药标识条件处理fg_pres_outp,
		Integer fg_pres_outp = param.getFg_pres_outp();
		appendSqlStr(rtn, getFgPresOutpCondStr(fg_pres_outp));

		// 服务项目字符串处理dt_split_start,dt_split_end,eu_orgensplittp
		FDateTime dt_split_start = param.getDt_split_start();
		FDateTime dt_split_end = param.getDt_split_end();
		appendSqlStr(rtn, getDtRelCondStr(dt_split_start, dt_split_end, param.getEu_orgensplittp()));
        //增加 ds=0的判断条件  li_cheng	
		String str="  and  "+IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".ds=0 ";
		appendSqlStr(rtn, str);
        
		//li_cheng 增加管控
		appendSqlStr(rtn, this.getorggrpCondStr(orgensplittp));
		
		return rtn.toString() ;
	}

	/***
	 * 字符串缓存中添加字符串
	 * 
	 * @param sb
	 * @param v
	 */
	private void appendSqlStr(StringBuffer sb, String v) {
		if (OrSrvSplitUtil.isEmpty(v))
			return;
		sb.append(v);
	}

	/***
	 * 设置医嘱或服务拆分基础条件
	 * 
	 * @param sb
	 * @param orgensplittp
	 */
	private void baseWhereHandle(StringBuffer sb, Integer orgensplittp) {
		sb.append(" WHERE ci_order.Code_Entp=" + IBdFcDictCodeConst.SD_CODE_ENTP_IP); // 住院
		sb.append(" and ci_order.Fg_Chk='Y' and ci_order.Fg_Canc='N' and ci_order.Fg_Pmor='N' "); // 已核对未作废非备用
		appendSqlStr(sb, getFgSelfCondStr(orgensplittp));
	}

	/***
	 * 获得医疗用法字符串相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getFgSelfCondStr(Integer orgensplittp) {
		if (OrSrvSplitUtil.isOrSplitType(orgensplittp))
			return "";
		String fldname = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS + ".fg_self";
		return OrSrvSplitUtil.getValueCondStr(fldname, "N", true);
	}

	/***
	 * 获得医疗用法字符串相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdDeptMpCondStr(String id_dept) {
		String fldname = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS + ".id_dep_mp";
		return OrSrvSplitUtil.getValueCondStr(fldname, id_dept, true);
	}

	/***
	 * 获得医疗用法字符串相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getIdRouteCondStr(String id_routes, Integer orgensplittp) {
		String fldname = OrSrvSplitUtil.getOrSrvTblAlias(orgensplittp) + ".id_route";
		return OrSrvSplitUtil.getValuesCondStr(fldname, id_routes, true);
	}

	/***
	 * 获得医嘱类型字符串相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getSrvTpCondStr(String sd_srvtps, Integer orgensplittp) {
		String fldname = OrSrvSplitUtil.getOrSrvTblAlias(orgensplittp) + ".sd_srvtp";
		return OrSrvSplitUtil.getValuesCondStr(fldname, sd_srvtps, true);
	}

	/***
	 * 获得长期临时相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getLongtempCondStr(Integer longtemp) {
		String fldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".Fg_Long";
		if (OrLongTempEnum.LONGOR.equals(longtemp)) {
			return " and " + fldname + "='Y'";
		} else if (OrLongTempEnum.TEMPOR.equals(longtemp)) {
			return " and " + fldname + "='N'";
		} else if (OrLongTempEnum.ALL.equals(longtemp)) {
			return "";
		}
		return "";
	}

	/***
	 * 获得出院带药标识相关条件串
	 * 
	 * @param fg_pres_outp
	 * @return
	 */
	private String getFgPresOutpCondStr(Integer fg_pres_outp) {
		String fldname = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS + ".fg_pres_outp";
		if (PresOutPTpEnum.PRESOUTP.equals(fg_pres_outp)) {
			return " and " + fldname + "='Y'";
		} else if (PresOutPTpEnum.UNPRESOUTP.equals(fg_pres_outp)) {
			return " and " + fldname + "='N'";
		} else if (PresOutPTpEnum.ALL.equals(fg_pres_outp)) {
			return "";
		}
		return "";
	}

	/***
	 * 获得医疗服务字串相关条件串
	 * 
	 * @param id_srvs
	 * @return
	 */
	private String getSrvCondStr(String id_srvs) {
		String fldname = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS + ".id_srv";
		return OrSrvSplitUtil.getValuesCondStr(fldname, id_srvs, true);
	}

	/***
	 * 获得医嘱串相关条件串
	 * 
	 * @param id_ors
	 * @return
	 */
	private String getOrCondStr(String id_ors) {
		String fldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".id_or";
		return OrSrvSplitUtil.getValuesCondStr(fldname, id_ors, true);
	}

	/***
	 * 获得就诊串相关条件串
	 * 
	 * @param id_ens
	 * @return
	 */
	private String getEnCondStr(String id_ens) {
		String fldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".id_en";
		return OrSrvSplitUtil.getValuesCondStr(fldname, id_ens, true);
	}

	/***
	 * 获得病区条件相关sql
	 * 
	 * @param deptnur
	 * @return
	 */
	private String[] getDepNurHandleStr(String deptnur) {
		String[] rtns = new String[] { "", "" }; // 0是FSQL 1是CondSQL

		if (OrSrvSplitUtil.isEmpty(deptnur))
			return rtns;
		rtns[0] = IOrAndSrvSplitConst.OREN_BASE_FSQL;
		rtns[1] = " and " + IOrAndSrvSplitConst.EN_TABLE_ALIAS + ".id_dep_nur= '" + deptnur + "'";
		return rtns;
	}

	/***
	 * 获得开始结束日期相关条件串
	 * 
	 * @param dt_split_start
	 * @param dt_split_end
	 * @param orgensplittp
	 * @return
	 */
	private String getDtRelCondStr(FDateTime dt_split_start, FDateTime dt_split_end, Integer orgensplittp) {
		if (OrSrvSplitUtil.isOrSplitType(orgensplittp)) {
			if (dt_split_start == null) {
				return getDtOrRelSplitCondStr(dt_split_start, dt_split_end);
			} else {
				return getDtRelQryCondStr(dt_split_start, dt_split_end);
			}

		} else {
			if (dt_split_start == null) {
				return getDtRelSplitCondStr(dt_split_start, dt_split_end);
			} else {
				return getDtRelQryCondStr(dt_split_start, dt_split_end);
			}
		}
	}

	/***
	 * 获得开始结束日期查询相关条件串
	 * 
	 * @param dt_split_start
	 * @param dt_split_end
	 * @param orgensplittp
	 * @return
	 */
	private String getDtRelQryCondStr(FDateTime dt_split_start, FDateTime dt_split_end) {
		String sfldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".dt_effe";
		String efldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".dt_end";
		String s = OrSrvSplitUtil.getFDateTimeStdStr(dt_split_start);
		String e = OrSrvSplitUtil.getFDateTimeStdStr(dt_split_end);
		return " and (" + sfldname + "<='" + e + "' and " + efldname + ">='" + s + "') ";
	}

	/***
	 * 获得开始结束日期查询相关条件串
	 * 
	 * @param dt_split_start
	 * @param dt_split_end
	 * @param orgensplittp
	 * @return
	 */
	private String getDtRelSplitCondStr(FDateTime dt_split_start, FDateTime dt_split_end) {
		String sfldname = IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS + ".dt_last_bl";
		String efldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".dt_end";
		String e = OrSrvSplitUtil.getFDateTimeStdStr(dt_split_end);
		// 2016-06-13 xuxing 有效开始时间取最近生成时间，有效结束时间取 min(Dt_end,拆分结束时间)
		return " and (" + sfldname + "<='" + e + "' and " + sfldname + "<=" + efldname + " and(case when " + efldname + "<='" + e + "' then " + efldname + " else '" + e + "' end)<=" + efldname + ")";
		// return " and (" + sfldname + "<='" + e + "' and " + efldname + ">='"
		// + e + "') ";
	}

	/***
	 * 获得开始结束日期查询相关条件串 2016-06-07新增 的代码逻辑主要是解决医嘱拆分中or增加dt_last_bl字段后的拆分逻辑
	 * 医嘱创建时应该 给 or的该dt_last_b字段赋初值：dt_effe??
	 * 
	 * @param dt_split_start
	 * @param dt_split_end
	 * @param orgensplittp
	 * @return
	 */
	private String getDtOrRelSplitCondStr(FDateTime dt_split_start, FDateTime dt_split_end) {
		String sfldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".dt_last_bl";
		String efldname = IOrAndSrvSplitConst.OR_TABLE_ALIAS + ".dt_end";
		String e = OrSrvSplitUtil.getFDateTimeStdStr(dt_split_end);
		// 2016-06-13 xuxing 有效开始时间取最近生成时间，有效结束时间取 min(Dt_end,拆分结束时间)
		// 例子 
		// ci_order.dt_last_bl <= '2016-06-17 00:00:00' 最近生成时间在请求时间之前
		// and ci_order.dt_last_bl <= ci_order.dt_end 最近生成时间在医护结束时间之前
		// and 前两者符合后，请求的时间和医嘱结束时间 取较小的，小于或等于在结束时间
		// ( case
		// when ci_order.dt_end <= '2016-06-17 00:00:00' then
		// ci_order.dt_end
		// else
		// '2016-06-17 00:00:00'
		// end
		// ) <= ci_order.dt_end
		return " and (" + sfldname + "<='" + e + "' and " + sfldname + "<=" + efldname + " and(case when " + efldname + "<='" + e + "' then " + efldname + " else '" + e + "' end)<=" + efldname + ")";
		// return " and ("+sfldname+"<='"+e+"' and "+efldname+">='"+e+"') ";
	}
	/**
	 * @author li_cheng
	 * @param orgensplittp
	 * @return
	 */
	private String getorggrpCondStr(Integer orgensplittp){
		String orgsql=null;
		if (OrSrvSplitUtil.isOrSplitType(orgensplittp)) {
			 orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), IOrAndSrvSplitConst.OR_TABLE_ALIAS);

		} else {
			
			orgsql=BdEnvContextUtil.processEnvContext(new OrdSrvDO(), IOrAndSrvSplitConst.ORSRV_TABLE_ALIAS);
			
		}
		if(orgsql!=null) return " and "+orgsql;
		return null;
	}

}
