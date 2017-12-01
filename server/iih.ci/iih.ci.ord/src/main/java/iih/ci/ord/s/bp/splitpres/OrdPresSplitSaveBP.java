package iih.ci.ord.s.bp.splitpres;

import java.util.List;
import java.util.Map;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderSrvDORService;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pres.i.IPresCudService;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;

/**
 * 处方的保存
 * 
 * @author li_zheng
 *
 */
public class OrdPresSplitSaveBP {

	public CiPresDO[] savePresDO(CiPresDO[] ciPresDOs) throws BizException {
		IPresCudService stIpService = ServiceFinder.find(IPresCudService.class);
		CiPresDO[] presDOs = stIpService.save(ciPresDOs);
		return presDOs;
	}

	public String DeletePresDO(List<String> listpres) throws BizException {
		String id_pres = "";
		if (listpres != null && listpres.size() > 0) {
			id_pres = getIdPres(listpres);
			if (id_pres != null && id_pres != "") {
				String strwhere = CiPresDO.ID_PRES + "  in (" + id_pres + ")";
				new DAFacade().deleteByWhere(CiPresDO.class, strwhere);
			}
		}

		return id_pres;
	}

	private String getIdPres(List<String> listpres) throws BizException {
		String strId_pres = "";
		if (listpres != null && listpres.size() > 0) {
			for (String id_pres : listpres) {
				if (new DAFacade().isExist(OrdSrvDO.class, "id_pres ='" + id_pres + "'", null)) {
					strId_pres += ",'" + id_pres + "'";
				}
			}
		}
		if (strId_pres.length() > 0) {
			return strId_pres.substring(1);
		}
		return strId_pres;
	}

	/**
	 * 更新服务表 （分方）
	 * 
	 * @param id_orsrv
	 * @param id_pres
	 * @throws BizException
	 */
	public void updateCiORSrv(Map<String, String> mapOrsrvPres, List<String> oldPres) throws BizException {
		ICiorderSrvDORService qryservice = ServiceFinder.find(ICiorderSrvDORService.class);
		OrdSrvDO[] orSrvDOs = qryservice.findByIds(mapOrsrvPres.keySet().toArray(new String[0]), FBoolean.FALSE);
		for (OrdSrvDO orSrvDO : orSrvDOs) {
			//用于重新分方，重新分方之前的id_pres
			if (orSrvDO.getId_pres() != null && orSrvDO.getId_pres() != "~" && !oldPres.contains(orSrvDO.getId_pres())) {
				oldPres.add(orSrvDO.getId_pres());
			}
			orSrvDO.setId_pres(mapOrsrvPres.get(orSrvDO.getId_orsrv()));
		}
		new DAFacade().updateDOArray(orSrvDOs, new String[] { OrdSrvDO.ID_PRES });
	}
}
