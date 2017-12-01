package iih.ci.ord.s.bp.ciprn;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.app.d.CiAppLisSheetOrDO;
import iih.ci.ord.app.d.CiapplissheetAggDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 
 * @author YANG
 *
 */
public class CiprnDeleteAppLisDataBP {

	public FBoolean exec(String[] idors) throws BizException {
		if (idors == null || idors.length <= 0)
			return FBoolean.TRUE;
		CiAppLisSheetOrDO[] lisSheetOrDOs= CiprnUtils.GetCiAppLisSheetOrDOByIdor(idors);
		if (lisSheetOrDOs == null || lisSheetOrDOs.length <= 0)
			return FBoolean.TRUE;
		List<String> lstIdapplissheet = new ArrayList<String>();
		for (CiAppLisSheetOrDO lisSheetOrDO : lisSheetOrDOs) {
			if (!lstIdapplissheet.contains(lisSheetOrDO.getId_ciapplissheet()))
				lstIdapplissheet.add(lisSheetOrDO.getId_ciapplissheet());
		}
		//删除打印明细
		CiprnUtils.DeleteCiAppLisSheetOrDO(lisSheetOrDOs);
		//如果单据内明细已空，则删除单据
		CiapplissheetAggDO[] aggDOs = CiprnUtils.GetCiapplissheetAggDOs(lstIdapplissheet
				.toArray(new String[lstIdapplissheet.size()]));
		List<CiapplissheetAggDO> lstAggDOs = new ArrayList<CiapplissheetAggDO>();
		if (aggDOs != null && aggDOs.length > 0) {
			for (CiapplissheetAggDO aggDO : aggDOs) {
				if (aggDO.getCiAppLisSheetOrDO().length <= 0)
					lstAggDOs.add(aggDO);
			}
		}
		if (lstAggDOs == null || lstAggDOs.size() <= 0)
			return FBoolean.TRUE;
		CiprnUtils.DeleteCiapplissheetAggDO(lstAggDOs.toArray(new CiapplissheetAggDO[lstAggDOs.size()]));
		return FBoolean.TRUE;
	}
}
