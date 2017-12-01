package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiapppathgysheetAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 删除病理打印信息
 * @author YANG
 *
 */
public class CiprnDeleteAppPathgyDataBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiapppathgysheetAggDO[] pathgysheets = CiprnUtils.GetCiapppathgysheetAggDOsByIdor(idors);
		if (pathgysheets == null || pathgysheets.length <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiapppathgysheetAggDOs(pathgysheets);
		return FBoolean.TRUE;
	}
}
