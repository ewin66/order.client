package iih.ci.ord.s.bp.ordprn.qry;

import org.apache.commons.lang.StringUtils;

import iih.bd.srv.ems.d.EmsDO;
import iih.bd.utils.BdEnvContextUtil;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询待打印医嘱数据
 * 
 * @author hums
 *
 */
public class GetOrdData4PrintQry implements ITransQry{

	private OrdPrintParamDTO paramDTO;

	public GetOrdData4PrintQry(OrdPrintParamDTO paramDTO) {
		this.paramDTO = paramDTO;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
		sqlparam.addParam(paramDTO.getFg_long());
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		
		String sql = this.getQuerySql(paramDTO);
		return sql;
	}

	/**
	 * 查询sql语句字段
	 * 
	 * @author hums
	 *
	 */
	private String[] getFieldsDrug() {

		return new String[] {
				// 0: 医嘱表内容，ci_order ，打印内容字段 content_or_prn 通过case when 拼接
				"a.id_grp, a.id_org, a.id_pat, a.id_en, a.id_entp, a.code_entp, a.id_dep_or as id_dep_phy, a.id_or, a.id_srvtp, a.sd_srvtp, a.fg_long, a.dt_effe, a.id_emp_sign, a.id_dep_sign, a.fg_chk, a.id_emp_chk, a.id_dep_chk, a.dt_end, a.id_emp_stop, a.id_dep_stop, a.id_emp_chk_stop, a.id_dep_chk_stop, a.dt_last_mp as dt_mp, a.fg_chk_stop, a.fg_chk_canc",
				// 1: 医嘱服务项目：服务名、剂量
				"b.name as name_srv, b.quan_medu, b.sortno",
				// 2: 医嘱服务项目物品：物品名称
				"c.name_mm",
				// 3: 医疗物品_基本信息：物品规格
				"d.spec",
				// 4: 住院属性 ：住院病案号
				"e.code_amr_ip",
				// 5: 计量单位：单位名称
				"f.name as medu_name",
				// 6: 用法：用法名称
				"g.name as route_name",
				// 7: 频次： 频次名称
				"h.name as freq_name",
				// 8: 患者
				"i.code as code_pat_en, i.name as name_pat_en",
				//就诊科室
				"p.code as code_dep_phy, p.name as name_dep_phy",
				// 9: 就诊（护理病区）
				"j.id_dep_nur",
				// 10: 护理病区
				"k.code as code_dep_nur, k.name as name_dep_nur",
				//11:签署医生
				"l.code as code_emp_sign, l.name as name_emp_sign",
				//12:核对护士
				"m.code as code_emp_chk, m.name as name_emp_chk",
				//13:停止医生
				"n.code as code_emp_stop, n.name as name_emp_stop",
				//14:停止核对护士
				"o.code as code_emp_chk_stop, o.name as name_emp_chk_stop",
		};
	}
	
	/**
	 * 查询sql语句字段
	 * 
	 * @author hums
	 *
	 */
	private String[] getFieldsNotDrug() {

		return new String[] {
				// 0: 医嘱表内容，ci_order ，打印内容字段 content_or_prn 通过case when 拼接
				"a.id_grp, a.id_org, a.id_pat, a.id_en, a.id_entp, a.code_entp, a.id_dep_or as id_dep_phy, a.id_or, a.id_srvtp, a.sd_srvtp, a.fg_long, a.dt_effe, a.id_emp_sign, a.id_dep_sign, a.fg_chk, a.id_emp_chk, a.id_dep_chk, a.dt_end, a.id_emp_stop, a.id_dep_stop, a.id_emp_chk_stop, a.id_dep_chk_stop, a.dt_last_mp as dt_mp, a.fg_chk_stop, a.fg_chk_canc",
				// 1: 医嘱服务项目：服务名、剂量
				"a.name_or as name_srv, a.quan_medu as quan_medu, 0 as sortno",
				// 2: 医嘱服务项目物品：物品名称
				"'' as name_mm",
				// 3: 医疗物品_基本信息：物品规格
				"'' as spec",
				// 4: 住院属性 ：住院病案号
				"e.code_amr_ip",
				// 5: 计量单位：单位名称
				"'' as medu_name",
				// 6: 用法：用法名称
				"g.name as route_name",
				// 7: 频次： 频次名称
				"h.name as freq_name",
				// 8: 患者
				"i.code as code_pat_en, i.name as name_pat_en",
				//就诊科室
				"p.code as code_dep_phy, p.name as name_dep_phy",
				// 9: 就诊（护理病区）
				"j.id_dep_nur",
				// 10: 护理病区
				"k.code as code_dep_nur, k.name as name_dep_nur",
				//11:签署医生
				"l.code as code_emp_sign, l.name as name_emp_sign",
				//12:核对护士
				"m.code as code_emp_chk, m.name as name_emp_chk",
				//13:停止医生
				"n.code as code_emp_stop, n.name as name_emp_stop",
				//14:停止核对护士
				"o.code as code_emp_chk_stop, o.name as name_emp_chk_stop",
		};
	}

	/**
	 * 获取基础的select 部分字段
	 * 
	 * @return
	 */
	private String getBaseSelectSql(String[] strArr) {

		return StringUtils.join(strArr, ",");
	}

	/**
	 * 获取from部分语句
	 * 
	 * @return
	 */
	private String getBaseFromSql(Boolean isDrug) {

		return isDrug?" from ci_order a, ci_or_srv b, ci_or_srv_mm c, bd_mm d, en_ent_ip e, bd_measdoc f, bd_route g, bd_freq h, pi_pat i, en_ent j, bd_dep p, bd_dep k, bd_psndoc l, bd_psndoc m, bd_psndoc n, bd_psndoc o"
				:" from ci_order a, en_ent_ip e, bd_route g, bd_freq h, pi_pat i, en_ent j, bd_dep p, bd_dep k, bd_psndoc l, bd_psndoc m, bd_psndoc n, bd_psndoc o";
	}

	/**
	 * 获取where部分语句
	 * 
	 * @return
	 */
	private String getBaseWhereSql(Boolean isDrug) {
		String orgsql=BdEnvContextUtil.processEnvContext(new CiOrderDO(), "a");
		String whereSql1 = " where a.sd_srvtp like '01%' and a.fg_chk = 'Y' and b.fg_or = 'Y' "
				+ " and a.id_or = b.id_or and b.id_orsrv = c.id_orsrv(+) and c.id_mm = d.id_mm(+) "
				+ " and a.id_en = e.id_ent and b.id_medu = f.id_measdoc(+) and a.id_route = g.id_route(+) and a.id_freq = h.id_freq(+) "
				+ " and a.id_pat = i.id_pat and a.id_dep_or = p.id_dep(+) and a.id_en = j.id_ent and j.id_dep_nur = k.id_dep(+) "
				+ " and a.id_emp_sign = l.id_psndoc(+) and a.id_emp_chk = m.id_psndoc(+) and a.id_emp_stop = n.id_psndoc(+) and a.id_emp_chk_stop = o.id_psndoc(+)"
				+ " and "+orgsql;

		String whereSql2=" where a.sd_srvtp not like '01%' and a.fg_chk = 'Y' "
				+ " and a.id_en = e.id_ent and a.id_route = g.id_route(+) and a.id_freq = h.id_freq(+) "
				+ " and a.id_pat = i.id_pat and a.id_dep_or = p.id_dep(+) and a.id_en = j.id_ent and j.id_dep_nur = k.id_dep(+) "
				+ " and a.id_emp_sign = l.id_psndoc(+) and a.id_emp_chk = m.id_psndoc(+) and a.id_emp_stop = n.id_psndoc(+) and a.id_emp_chk_stop = o.id_psndoc(+)"
				+ " and "+orgsql;;

		return isDrug?whereSql1:whereSql2;
	}

	/**
	 * 获取查询的sql语句
	 * 
	 * @return
	 */
	private String getQuerySql(OrdPrintParamDTO paramDTO) {

		StringBuffer buffer = new StringBuffer();
		// buffer.append("select t.*,(").append(this.getConfigSql()).append(")
		// as content_or_prn from (");
		buffer.append("select t.* from (");
		buffer.append(" select ");
		buffer.append(this.getBaseSelectSql(this.getFieldsDrug()));
		buffer.append(this.getBaseFromSql(Boolean.TRUE));
		buffer.append(this.getBaseWhereSql(Boolean.TRUE));
		buffer.append(" union all select ");
		buffer.append(this.getBaseSelectSql(this.getFieldsNotDrug()));
		buffer.append(this.getBaseFromSql(Boolean.FALSE));
		buffer.append(this.getBaseWhereSql(Boolean.FALSE));
		buffer.append(") t where ");
		buffer.append(this.getDynamicWhereSql(paramDTO));
		buffer.append(" order by ").append(this.getOrderBySql());

		return buffer.toString();
	}

	/**
	 * 获取动态条件语句
	 * 
	 * @return
	 */
	private String getDynamicWhereSql(OrdPrintParamDTO paramDTO) {

		StringBuffer buffer = new StringBuffer();
		buffer.append(" t.id_en= ?");
		buffer.append(" and t.fg_long = ?");

		buffer.append(" and ").append(this.getSqlByPrintMode(paramDTO));

		return buffer.toString();
	}

	/**
	 * 根据打印模式获取拼接续打Sql
	 * 
	 * @return
	 */
	private String getSqlByPrintMode(OrdPrintParamDTO paramDTO) {

		String sql = null;
		switch (paramDTO.getPrint_mode()) {
		case "1": // 一般续打,续打为相同就诊，排除已经打印过的医嘱,如果是重整，需要注意重整前没有打印停止时间的也需要查询出来
			sql = " not exists ( select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or)";
			//sql = " not exists ( select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or and (prn.fg_reformed = 'N' or prn.fg_stop_prn='Y' or prn.fg_canc_prn='Y'))";
			break;
		case "2": // 重整打印,需要排除
					// 已经打印完停止时间的(排除执行过停止打印的记录)，并且不包含作废医嘱（是否包含作废医嘱可以通过配置实现）
			sql = " not exists ( select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or "
					+ " and (prn.fg_stop_prn='Y' or prn.fg_canc_prn='Y'))";
			break;
		case "3": // 撤销医嘱打印（作废打印），打印已作废的医嘱，排除已经执行过作废打印的医嘱(打印表中作废打印标记为false，医嘱中作废标记为true)
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or "
					+ " and prn.fg_canc_prn = 'N' and t.fg_chk_canc = 'Y' and prn.fg_reformed = 'N')";
			break;
		case "4": // 停止打印，打印已经停止的医嘱（需要排除已经打印过的停止医嘱）
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en=t.id_en and prn.id_or = t.id_or "
					+ " and prn.fg_stop_prn = 'N' and t.fg_chk_stop = 'Y' and prn.fg_reformed = 'N')";
			break;
		case "5":// 查询指定页码需要补打作废线or停止时间的数据
			sql = " exists (select id_orprn from ci_or_prn prn where prn.id_en = t.id_en and prn.id_or = t.id_or "
					+ " and ((prn.fg_stop_prn = 'N' and t.fg_chk_stop = 'Y') or (prn.fg_canc_prn = 'N' and t.fg_chk_canc = 'Y')) "
					+ " and prn.fg_reformed = 'N' "
					+ " and prn.page_num = '"
					+ paramDTO.getPage_num().toString()
					+ "')";
			break;
		}

		return sql;
	}

	/**
	 * 获取排序sql
	 * 
	 * @return
	 */
	private String getOrderBySql() {

		return " dt_effe,sortno";
	}
}
