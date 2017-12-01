package iih.ci.ord.s.bp;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.pres.d.CiPresDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;

public class MOdOrdsrv4PresBP {

	/**
	 * 门急诊清医嘱项目中处方标识
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	public void exec(String[] idors) throws BizException {

		// 擦除ordsrv的id_pres，并返回处方id
		List<String> preslist = modOrdSrv(idors);
		if (preslist == null || preslist.isEmpty())
			return;

		// 如果处方表中没有医嘱信息则删除该处方
		List<String> preslist2 = getIdPres8Srv(preslist);// 获取有效处方

		if (preslist2.size() == preslist.size())
			return;

		List<String> dellist = new ArrayList<>();
		// 获取无效的处方id
		for (String id : preslist) {
			if (!preslist2.contains(id))
				dellist.add(id);
		}
		// 删除无效处方
//		String[] idpres = dellist.toArray(new String[dellist.size()]);
//		CiPresDO[] cipres = CiOrdAppUtils.getCiPresQryService().findByIds(idpres, FBoolean.FALSE);
//		CiOrdAppUtils.getCiPresService().delete(cipres);
		
		if (dellist.size() > 0) {
			String strIdpres = CiOrdUtils.IdsConveretCharacterString(dellist.toArray(new String[0]));
			String strwhere = CiPresDO.ID_PRES + "  in (" + strIdpres + ")";
			new DAFacade().deleteByWhere(CiPresDO.class, strwhere);
		}
	}

	/**
	 * 擦除ordsrv的id_pres
	 * 
	 * @param ids
	 * @return
	 * @throws BizException
	 */
	private List<String> modOrdSrv(String[] idors) throws BizException {

		// 擦除ordsrv的id_pres
		String strIdors = CiOrdUtils.IdsConveretCharacterString(idors);
		String whereStr = " (id_pres != '~' or id_pres != null ) and id_or in (" + strIdors + ")";
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(whereStr, OrdSrvDO.ID_OR, FBoolean.FALSE);
		if (ordSrvDOs == null || ordSrvDOs.length == 0)
			return null;

		List<String> preslist = new ArrayList<>();
		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			if (!preslist.contains(ordSrvDO.getId_pres())) {
				preslist.add(ordSrvDO.getId_pres());
			}

			ordSrvDO.setId_pres("~");
			ordSrvDO.setStatus(DOStatus.UPDATED);
		}

//		CiOrdAppUtils.getOrSrvService().save(ordSrvDOs);
		new DAFacade().updateDOArray(ordSrvDOs, new String[] { OrdSrvDO.ID_PRES });
		return preslist;
	}

	/**
	 * 获取有效的处方id
	 * 
	 * @param preslist
	 * @return
	 * @throws BizException
	 */
	private List<String> getIdPres8Srv(List<String> preslist) throws BizException {

		String strIdpres = CiOrdUtils.IdsConveretCharacterString(preslist.toArray(new String[0]));
		String whereStr = " id_pres in (" + strIdpres + ")";
		OrdSrvDO[] ordSrvDOs = CiOrdAppUtils.getOrSrvQryService().find(whereStr, OrdSrvDO.ID_OR, FBoolean.FALSE);
		// 获取有效的处方id
		if (ordSrvDOs == null)
			ordSrvDOs = new OrdSrvDO[0];

		List<String> preslist2 = new ArrayList<>();
		for (OrdSrvDO ordSrvDO : ordSrvDOs) {
			if (!preslist2.contains(ordSrvDO.getId_pres())) {
				preslist2.add(ordSrvDO.getId_pres());
			}
		}

		return preslist2;
	}
}
