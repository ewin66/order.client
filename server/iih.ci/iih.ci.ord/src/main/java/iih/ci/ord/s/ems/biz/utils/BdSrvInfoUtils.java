package iih.ci.ord.s.ems.biz.utils;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.bd.srv.medsrv.i.IMedsrvMDORService;
import iih.ci.ord.s.ems.biz.meta.BdSrvSetItemListMap;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 基础数据工具类
 * @author wangqingzhu
 *
 */
public class BdSrvInfoUtils {

public static MedSrvDO QueryBdSrvInfo(String id_srv) throws BizException{
		
		return ServiceFinder.find(IMedsrvMDORService.class).findById(id_srv);
	}

	public static MedSrvDO[] QueryBdSrvInfo(String[] szId_srv) throws BizException{
		
		return ServiceFinder.find(IMedsrvMDORService.class).findByIds(szId_srv,FBoolean.FALSE);
	}
	
	public static MedSrvDO[] QueryBdSrvInfo(StringList listId_srv) throws BizException{
		
		return ServiceFinder.find(IMedsrvMDORService.class).findByIds(listId_srv.asArray(),FBoolean.FALSE);
	}

	/**
	 * 获取服务套中启用的套内项目集合
	 * 
	 * @param mId_srv
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] QueryMedSrvSetItemBy(String mId_srv) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class)
				.find(String.format(" id_srv = '%s' and fg_active = 'Y' ", mId_srv), "", FBoolean.FALSE);
	}
	/**
	 * 查询套内项目（参数-临床|非临床）
	 * @param mId_srv
	 * @param isClinical
	 * @return
	 * @throws BizException
	 */
	public static MedSrvSetItemDO[] QueryMedSrvSetItemBy(String mId_srv,boolean isClinical) throws BizException {
		return ServiceFinder.find(IMedSrvSetItemDORService.class)
				.find(String.format(" id_srv = '%s' and fg_active = 'Y' and FG_CLINICAL = '%s'", mId_srv,isClinical?"Y":"N"), "", FBoolean.FALSE);
	}
	/**
	 * 
	 * @param szId_srv
	 * @return
	 * @throws BizException
	 */
	public static BdSrvSetItemListMap QueryMedSrvSetItemBy(String[] szId_srv) throws BizException {
		StringBuilder sb = new StringBuilder();
		for (String id_srv : szId_srv){
			sb.append("'").append(id_srv).append("'").append(",");
		}
		String whereStr = sb.deleteCharAt(sb.length()-1).toString();
		
		return new BdSrvSetItemListMap(ServiceFinder.find(IMedSrvSetItemDORService.class)
				.find(String.format(" id_srv in (%s) and fg_active = 'Y' ", whereStr), "", FBoolean.FALSE));
	}
	
	/**
	 * 从套内项目中分拣临床项目
	 * 
	 * @param szMedSrvSetItemDO
	 *            套内项目集合
	 * @return 返回临床套内项目集合
	 */
	public static MedSrvSetItemDO[] ClinicalMedSrvSetItemArrayOf(MedSrvSetItemDO[] szMedSrvSetItemDO) {
		List<MedSrvSetItemDO> listMedSrvSetItemDO = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO item : szMedSrvSetItemDO) {
			if (FBoolean.TRUE.equals(item.getFg_active()) && FBoolean.TRUE.equals(item.getFg_clinical())) {
				listMedSrvSetItemDO.add(item);
			}
		}
		return listMedSrvSetItemDO.toArray(new MedSrvSetItemDO[listMedSrvSetItemDO.size()]);
	}

	/**
	 * 从套内项目集合中分拣非临床项目
	 * 
	 * @param szMedSrvSetItemDO
	 * @return 返回非临床套内项目集合
	 */
	public static MedSrvSetItemDO[] NotClinicalMedSrvSetItemArrayOf(MedSrvSetItemDO[] szMedSrvSetItemDO) {
		List<MedSrvSetItemDO> listMedSrvSetItemDO = new ArrayList<MedSrvSetItemDO>();
		for (MedSrvSetItemDO item : szMedSrvSetItemDO) {
			if (FBoolean.TRUE.equals(item.getFg_active()) && !FBoolean.TRUE.equals(item.getFg_clinical())) {
				listMedSrvSetItemDO.add(item);
			}
		}
		return listMedSrvSetItemDO.toArray(new MedSrvSetItemDO[listMedSrvSetItemDO.size()]);
	}
}
