package iih.ci.ord.s.bp.ciprn;

import iih.ci.ord.app.d.CiAppRisSheetDO;
import iih.ci.ord.app.i.ICiapprissheetCudService;
import iih.ci.ord.app.i.ICiapprissheetRService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 删除检查打印数据
 * @author YANG
 *
 */
public class CiprnDeleteAppRisDataBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiAppRisSheetDO[] rissheets = CiprnUtils.GetCiAppRisSheetDOsByIdor(idors);
		if (rissheets == null || rissheets.length <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiAppRisSheetDOs(rissheets);
		return FBoolean.TRUE;
	}
}
