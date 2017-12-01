package iih.ci.ord.s.bp;

import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCiOderBlSrvBP {

	public GetCiOderBlSrvBP() {
		if (CacheManager.isNull()) {
			try {
				setBlCatchMap();
			} catch (BizException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 根据费用服务id查询服务
	 * @param id_srvs
	 * @return
	 * @throws BizException
	 */
	public FMap getCiordBlSrvByIdsrvs(String[] id_srvs) throws BizException {
		FMap map = new FMap();
		if (id_srvs != null && id_srvs.length > 0) {
			for (String id_srv : id_srvs) {
				if (CacheManager.containsKey(id_srv)) {
					map.put(id_srv, CacheManager.getCacheMapValue(id_srv));
				}
			}
		}
		return map;
	}
	
	/**
	 * 根据医嘱id查询费用服务
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public FMap getCiordBlSrvByIdors(String[] id_ors) throws BizException {
		FMap map = new FMap();
		if (id_ors != null && id_ors.length > 0) {
			String idors = "";
			for (String id_or : id_ors) {
				idors += "'" + id_or + "',";
			}
			OrdSrvDO[] ordsrvs = getCiorderBlSrvId(idors.substring(0, idors.length() - 1));
			if (ordsrvs.length != 0) {
				for (OrdSrvDO srvdo : ordsrvs) {
					if (CacheManager.containsKey(srvdo.getId_srv())) {
						map.put(srvdo.getId_srv(), CacheManager.getCacheMapValue(srvdo.getId_srv()));
					}
				}
			}
		}
		return map;
	}
	/**
	 * 费用服务缓存
	 * @throws BizException
	 */
	private void setBlCatchMap() throws BizException {

		MedSrvDO[] medsrvs = getAllBlSrv();
		if (medsrvs.length != 0) {
			for (MedSrvDO medsrv : medsrvs) {
				CacheManager.setCacheMap(medsrv.getId_srv(), medsrv);
			}
		}
	}	
	
	/**
	 * 获取所有费用服务
	 * @return
	 * @throws BizException
	 */
	private MedSrvDO[] getAllBlSrv()throws BizException{
		IMedsrvMDORService medsrvServiec=ServiceFinder.find(IMedsrvMDORService.class);
		return medsrvServiec.find(" a0.fg_active='Y' and a0.fg_bl='Y' and a0.des is not null", null, FBoolean.FALSE);
	}

	/**
	 * 查询医嘱关联费用服务
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getCiorderBlSrvId(String id_ors) throws BizException {

		String strSql = "select id_srv from ci_or_srv where id_or in (" + id_ors + ") ";

		SqlParam sqlParam = new SqlParam();
		DAFacade dAFacade = new DAFacade();
		@SuppressWarnings("unchecked")
		List<OrdSrvDO> dots = (List<OrdSrvDO>) dAFacade.execQuery(strSql, sqlParam, new BeanListHandler(OrdSrvDO.class));

		return dots.toArray(new OrdSrvDO[] {});
	}
}
