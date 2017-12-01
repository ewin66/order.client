package iih.ci.ord.s.bp.ordbttest;

import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.i.ICiOrdBtTestItmDORService;
import iih.ci.ord.s.bp.qry.GetBttestCodeSql;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

/**
 * 交叉备血结果保存条码重复校验
 * 
 * @author xuxing_2017-03-06
 *
 */

public class SaveValidationBp {

	/**
	 * 主入口
	 * 
	 * @param aggDO
	 * @throws BizException
	 */
	public void exec(CiordrptbttestAggDO aggDO) throws BizException {

		// 1、自身血袋条码校验，获取与自身条码相同的全部血袋
		CiOrdBtTestItmDO[] TestItmDOS = getRepeatTestItm(aggDO);

		// 2、存在相同的条码，组装异常信息
		String msg = figureRepeat(TestItmDOS, aggDO.getParentDO().getId_rptbttest());
		if (!StringUtil.isEmptyWithTrim(msg)) {
			throw new BizException("血袋编码【" + msg + "】重复！");
		}
	}

	/**
	 * 获取与当前全部条码重复的血袋信息
	 * 
	 * @param aggDO
	 * @return
	 * @throws BizException
	 */
	private CiOrdBtTestItmDO[] getRepeatTestItm(CiordrptbttestAggDO aggDO) throws BizException {

		List<String> listCode = new ArrayList<String>();

		if (aggDO.getCiOrdBtTestItmDO() != null && aggDO.getCiOrdBtTestItmDO().length > 0) {

			String message = "";

			for (CiOrdBtTestItmDO itm : aggDO.getCiOrdBtTestItmDO()) {

				if (itm.getStatus() != DOStatus.DELETED) {

					if (!listCode.contains(itm.getBarcode_bb())) {

						listCode.add(itm.getBarcode_bb());

					} else {

						message += (message.length() == 0 ? "" : ",") + itm.getBarcode_bb();
					}
				}
			}

			if (!StringUtil.isEmptyWithTrim(message)) {

				throw new BizException("血袋编码【" + message + "】重复！");
			}
		}

		GetBttestCodeSql Sql = new GetBttestCodeSql(aggDO.getParentDO().getId_rptbttest(), listCode.toArray(new String[listCode.size()]));

		CiOrdBtTestItmDO[] rtns = (CiOrdBtTestItmDO[]) AppFwUtil.getDORstWithDao(Sql, CiOrdBtTestItmDO.class);

		return rtns;
	}

	/**
	 * 获取重复编码集合
	 * 
	 * @param TestItmDOS
	 */
	private String figureRepeat(CiOrdBtTestItmDO[] TestItmDOS, String Id_rptbttest) {

		String message = "";

		if (TestItmDOS != null && TestItmDOS.length > 0) {

			for (CiOrdBtTestItmDO itm : TestItmDOS) {

				message += (message.length() == 0 ? "" : ",") + itm.getBarcode_bb();
			}
		}

		return message;
	}

}
