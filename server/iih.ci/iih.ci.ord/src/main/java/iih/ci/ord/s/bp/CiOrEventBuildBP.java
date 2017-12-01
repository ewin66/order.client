package iih.ci.ord.s.bp;

import java.util.HashMap;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.desc.CiOrderDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.AuditInfoUtil;

/**
 * 临床医嘱相关事件信息创建操作BP
 */
public class CiOrEventBuildBP {
	private FDateTime curtime = null;//当前日期时间

	/**
	 * 临床医嘱相关事件信息创建
	 * 
	 * @param ors
	 * @return
	 * @throws BizException
	 */
	public CiEventDO[] exec(CiOrderDO[] ors) throws BizException {
		if (ors == null || ors.length == 0)
			return null;
		String strIdors = "";
		for (CiOrderDO or : ors) {
			strIdors += ",'" + or.getId_or() + "'";
		}
		CiEventDO[] eventdos = CiOrdAppUtils.getCieventQryService().find(
				CiOrderDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors.substring(1) + ")", "", FBoolean.FALSE);
		Map<String, CiEventDO> mapCiEventDO = new HashMap<String, CiEventDO>();
		if (eventdos != null && eventdos.length > 0) {
			for (CiEventDO eventdo : eventdos) {
				mapCiEventDO.put(eventdo.getId_or(), eventdo);
			}
		}

		CiEventDO[] rtns = new CiEventDO[ors.length];
		for (int i = 0; i < ors.length; i++) {
			if (mapCiEventDO.containsKey(ors[i].getId_or())) {
				rtns[i] = mapCiEventDO.get(ors[i].getId_or());
				rtns[i].setId_user(CiOrdAppUtils.getEnvContext().getUserId());
				rtns[i].setStatus(DOStatus.UPDATED);
				continue;
			}
			rtns[i] = getCiEventDO(ors[i]);
		}
		return rtns;
	}

	/**
	 * 获得医嘱事件
	 * 
	 * @param or
	 * @return
	 * @throws BizException
	 */
	private CiEventDO getCiEventDO(CiOrderDO or) throws BizException {
		CiEventDO eventdo = new CiEventDO();
		//eventdo.setId_et();
		eventdo.setId_grp(or.getId_grp());
		eventdo.setId_org(or.getId_org());
		eventdo.setId_or(or.getId_or());
		//eventdo.setId_di();
		//eventdo.setId_mr();
		eventdo.setDt_et(curtime);
		eventdo.setId_ettp(ICiDictCodeConst.ID_EVENTTP_CI_OR);
		eventdo.setSd_ettp(ICiDictCodeConst.SD_EVENTTP_CI_OR);
		//eventdo.setCode();
		//eventdo.setName();
		//eventdo.setDes();
		//eventdo.setDes_status();
		eventdo.setId_pat(or.getId_pat());
		eventdo.setId_entp(or.getId_entp());
		eventdo.setCode_entp(or.getCode_entp());
		eventdo.setId_ent(or.getId_en());
		//eventdo.setId_dep_et();
		//eventdo.setId_emp_et();
		//eventdo.setId_mrtp();
		//eventdo.setIscompleted();
		eventdo.setId_user(CiOrdAppUtils.getEnvContext().getUserId());
		//eventdo.setDt_begin();
		//eventdo.setDt_end();
		//eventdo.setDt_complete();
		//eventdo.setIsrate();
		//eventdo.setRate();
		//eventdo.setIs_associated();
		AuditInfoUtil.addData(eventdo);//设置设计信息
		eventdo.setStatus(DOStatus.NEW);

		return eventdo;
	}
}
