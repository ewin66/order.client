package iih.ci.ord.s.bp.ordprn;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;

import iih.ci.ord.dto.ordprintdto.d.OrdPrintParamDTO;
import xap.mw.core.data.BizException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已打医嘱页码集合
 * @author hums
 *
 */
public class GetOrdPrintPageNumsBP {

	public int[] exec(OrdPrintParamDTO paramDTO) throws BizException {

		return getPageNums(paramDTO);
	}

	/**
	 * 获取页面集合
	 * @param paramDTO
	 * @return
	 * @throws BizException
	 */
	private int[] getPageNums(OrdPrintParamDTO paramDTO) throws BizException {

		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(paramDTO.getId_en());
		sqlparam.addParam(paramDTO.getFg_long());

		String sqlStr = "select distinct page_num from ci_or_prn where id_en=? and fg_long = ? order by page_num";
		List<Integer> pageNums = (List<Integer>) new DAFacade().execQuery(sqlStr, sqlparam, new ColumnListHandler());
		int[] pageNumArr = ArrayUtils.toPrimitive(pageNums.toArray(new Integer[pageNums.size()]));

		return pageNumArr;
	}
}
