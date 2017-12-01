package iih.ci.ord.s.external.bp;

import iih.ci.ord.i.external.Mode4CheckExistValidOrdersEnum;

import java.util.List;

import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 取消接诊判断是否存在有效医嘱
 * @author Young
 *
 */
public class ExistValidOrdersBp {

	public FBoolean exec(String id_en, String mode) throws DAException {
		if (StringUtil.isEmpty(id_en) || StringUtil.isEmpty(mode))
			return FBoolean.FALSE;
		String sqlQry = "select count(*) as def1 from ci_order where id_en='"+id_en+"' and fg_canc='N'";

		switch (mode) {
		case Mode4CheckExistValidOrdersEnum.ORDERSTATUS0:
			sqlQry += " and sd_su_bl!='2'";
			break;
		case Mode4CheckExistValidOrdersEnum.ORDERSTATUS1:
			sqlQry += " and sd_su_bl!='2' and fg_sign='Y'";
			break;
		case Mode4CheckExistValidOrdersEnum.ORDERSTATUS2:
			sqlQry += " and sd_su_bl='1'";
			break;
		}

		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<UtilsDTO> dots = (List<UtilsDTO>) dAFacade.execQuery(sqlQry,
				sqlParam, new BeanListHandler(UtilsDTO.class));

		return dots.get(0).getDef1() > 0 ? FBoolean.TRUE : FBoolean.FALSE;
	}
}
