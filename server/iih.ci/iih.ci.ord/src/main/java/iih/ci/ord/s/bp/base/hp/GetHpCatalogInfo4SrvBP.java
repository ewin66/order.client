package iih.ci.ord.s.bp.base.hp;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import xap.mw.core.data.BizException;

/**
 * 在对应医疗保险计划下，获得服务所属目录数据信息操作BP
 * 单服务情形
 */
public class GetHpCatalogInfo4SrvBP {
	/**
	 * 在对应医疗保险计划下，获得服务所属目录数据信息
	 * @param id_hp
	 * @param id_srv
	 * @return
	 * @throws BizException
	 */
	public HPSrvorcaDO exec(String id_hp, String id_srv)  throws BizException{
		return CiOrdAppUtils.findHp(id_hp, id_srv);
	}
}
