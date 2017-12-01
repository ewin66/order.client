package iih.ci.ord.s.bp;

import iih.ci.ord.dto.d.ImplVtDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import xap.mw.core.data.BizException;
import xap.mw.log.logging.Logger;
import xap.sys.devcfg.alert.PreAlertException;
import xap.sys.jdbc.kernel.PersistMgr;
import xap.sys.jdbc.kernel.PersistSession;
import xap.sys.jdbc.kernel.exception.DbException;
import xap.sys.permfw.dataper.d.systemEnum;

/**
 * 生命体征预置数据导入操作
 * 
 * @author zwq
 *
 */
public class ImplVtBP {
	public boolean exec(ImplVtDTO vt) throws BizException {
		// 执行批量插入操作
		return insertImplVt(replaceSql(vt));
	}

	/**
	 * 将集团、组织、服务分类替换到sql语句中
	 * 
	 * @param vt
	 * @throws BizException
	 */
	private String replaceSql(ImplVtDTO vt) throws BizException {
		String execSql = StringCodingUtils.Utf8_Base64_Decode(vt.getExec_sql_base64());
		System.out.println(execSql);
		String id_grp = vt.getId_grp();
		String id_org = vt.getId_org();
		String id_srvca = vt.getId_srvca();
		return execSql.replaceAll("@GroupID", id_grp).replaceAll("@OrgID", id_org).replaceAll("@SrvcaID", id_srvca);
	}

	/**
	 * 执行批量插入
	 * 
	 * @param sql
	 * @throws PreAlertException
	 */
	private boolean insertImplVt(String sql) throws PreAlertException {
		if (CiOrdUtils.isEmpty(sql))
			return false;
		PersistMgr persist = null;
		PersistSession session = null;
		try {
			persist = (PersistMgr) PersistMgr.getInstance();
			session = persist.getPersistSession();
			String[] sqlArray = sql.split(";");
			for (int i = 0; i < sqlArray.length; i++) {
				System.out.println(sqlArray[i]);
				if (!CiOrdUtils.isEmpty(sqlArray[i])) {
					session.addBatch(sqlArray[i]);
				}
			}
			session.execBatch();

		} catch (DbException e) {
			Logger.error(e.getMessage(), e);
			throw new PreAlertException(e.getMessage());
		} finally {
			if (session != null)
				session.closeAll();

			if (persist != null)
				persist.release();
		}
		return true;
	}
}
