package iih.ci.ord.s.external.bp;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class ExistOpenOrdersBp {

	public FBoolean exec(String id_en) throws DAException {
		if (StringUtil.isEmpty(id_en))
			return FBoolean.FALSE;
		String sqlQry = "select count(*) as def1 from ci_order where id_en='"+id_en+"' and fg_canc='N' and fg_sign='N' and sd_su_or='0'";

		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<UtilsDTO> dots = (List<UtilsDTO>) dAFacade.execQuery(sqlQry,
				sqlParam, new BeanListHandler(UtilsDTO.class));

		return dots.get(0).getDef1() > 0 ? FBoolean.TRUE : FBoolean.FALSE;
	}
}
