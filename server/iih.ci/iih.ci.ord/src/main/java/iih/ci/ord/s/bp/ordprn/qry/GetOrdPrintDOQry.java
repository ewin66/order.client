package iih.ci.ord.s.bp.ordprn.qry;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintDataDTO;
import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据待打印的作废医嘱获取已打印的医嘱
 * 
 * @author hums
 *
 */
public class GetOrdPrintDOQry implements ITransQry {

	private OrdPrintParamDTO paramDTO;
	private OrdPrintDataDTO[] printDataDTOs;

	public GetOrdPrintDOQry(OrdPrintParamDTO paramDTO, OrdPrintDataDTO[] printDataDTOs) {
		this.paramDTO = paramDTO;
		this.printDataDTOs = printDataDTOs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
		sqlparam.addParam(paramDTO.getFg_long());
		for(int i=0;i<printDataDTOs.length;i++){
			sqlparam.addParam(printDataDTOs[i].getId_or());
		}
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {

		String sqlSel="select t.*,"
				+ "i.code as code_pat_en,i.name as name_pat_en,"//患者
				+ "p.code as code_dep_phy,p.name as name_dep_phy,"
				+ "j.id_dep_nur,"
				+ "k.code as code_dep_nur,k.name as name_dep_nur,"
				+ "l.code as code_emp_sign,l.name as name_emp_sign,"
				+ "m.code as code_emp_chk,m.name as name_emp_chk,"
				+ "n.code as code_emp_stop,n.name as name_emp_stop,"
				+ "o.code as code_emp_chk_stop,o.name as name_emp_chk_stop ";

		String sqlFrm=" from ci_or_prn t, pi_pat i, en_ent j, bd_dep p, bd_dep k, bd_psndoc l, bd_psndoc m, bd_psndoc n, bd_psndoc o";
		
		
		String sqlWhr = " where id_en = ? and fg_long = ? and t.id_pat = i.id_pat and t.id_dep_phy = p.id_dep(+) and t.id_en = j.id_ent and j.id_dep_nur = k.id_dep(+)"
				+ " and t.id_emp_sign = l.id_psndoc(+) and t.id_emp_chk = m.id_psndoc(+) and t.id_emp_stop = n.id_psndoc(+) and t.id_emp_chk_stop = o.id_psndoc(+)"
				+ " and exists (select * from ci_or_prn prn where prn.fg_reformed = 'N' and prn.page_num = t.page_num and id_or in (";

		StringBuffer buffer = new StringBuffer();

		for(int i=0;i<printDataDTOs.length;i++){
			buffer.append(",?");
		}
		
		return sqlSel + sqlFrm + sqlWhr + buffer.substring(1) + ")) order by page_num,row_num";
	}

}
