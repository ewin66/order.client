package iih.ci.ord.s.external.bp;

import com.mysql.jdbc.StringUtils;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import iih.bd.srv.diagdef.d.DiagDefDO;
import iih.bd.srv.diagdef.i.IDiagdefMDORService;

/**
 * 查询诊断
 * @author Young
 *
 */
public class GetDiagDefDOsBP {

	public DiagDefDO[] exec(FDateTime dtStart, FDateTime dtEnd, String nameDi, String codeDi, String idcdsystp,
			String iddica, String idorg, String idgrp) throws BizException {
		IDiagdefMDORService service = ServiceFinder.find(IDiagdefMDORService.class);
		String sqlWhere=" fg_active = 'Y' ";
		
		if (dtStart != null) {
			sqlWhere += " and createdtime >='" + dtStart.toString() + "'";
		}
		if (dtEnd != null) {
			sqlWhere += " and createdtime <='" + dtEnd.toString() + "'";
		}
		if (!StringUtils.isNullOrEmpty(nameDi)) {
			sqlWhere += " and name like '%" + nameDi + "%'";
		}
		if (!StringUtils.isNullOrEmpty(codeDi)) {
			sqlWhere += " and code like '%" + codeDi + "%'";
		}
		if (!StringUtils.isNullOrEmpty(idcdsystp)) {
			sqlWhere += " and id_cdsystp ='" + idcdsystp + "'";
		}
		if (!StringUtils.isNullOrEmpty(iddica)) {
			sqlWhere += " and id_didef in( select CA.id_didef from bd_dica_itm_rel CA where CA.id_dica='" + iddica + "')";
		}
		if (!StringUtils.isNullOrEmpty(idorg)) {
			sqlWhere += " and id_org ='" + idorg + "'";
		}
		if (!StringUtils.isNullOrEmpty(idgrp)) {
			sqlWhere += " and id_grp ='" + idgrp + "'";
		}
		
		return service.find(sqlWhere, "", FBoolean.FALSE);
	}
}
