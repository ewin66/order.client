package iih.ci.ord.s.bp.assi.impl;

import java.util.ArrayList;
import java.util.List;

import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.s.bp.assi.service.AbstractAssiCopy;
import iih.ci.ord.tmpl.d.CiOrTmplDTO;
import iih.ci.ord.tmpl.d.CiOrTmplSrvDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.coreitf.d.FBoolean;

/**
 * 拷贝套内项目
 * 
 * @author HUMS
 *
 */
public class CopySrvsetitmsServiceImpl extends AbstractAssiCopy<CiOrTmplDTO, CiEmsDTO> {

	@Override
	public void copyPropertys(CiOrTmplDTO ciOrTmpl, CiEmsDTO ciEms) throws BizException {

		ciEms.setSrvsetitms(this.getSrvsetItms(ciOrTmpl));
	}

	private FMap getSrvsetItms(CiOrTmplDTO ciOrTmpl) throws BizException {

		FMap fmap = null;
		if (ciOrTmpl.getFg_set() != FBoolean.TRUE) {
			return fmap;
		}

		// 获取模板对应的套内项目
		List<MedSrvDO> medSrvList = this.getSetMedSrvDOs(ciOrTmpl);

		return this.getSrvSetitmMap(ciOrTmpl.getId_srv(), medSrvList);
	}

	/**
	 * 获取套的套内项目服务集合
	 * 
	 * @param ciOrTmpl 模板
	 * @return 如果模板中的项目为空，返回套内项目，如果模板选择了部分套内项目，按选择的结果返回
	 * @throws BizException
	 */
	private List<MedSrvDO> getSetMedSrvDOs(CiOrTmplDTO ciOrTmpl) throws BizException {

		List<MedSrvDO> medSrvList = new ArrayList<MedSrvDO>();
		
		FArrayList ortmplsrvs = ciOrTmpl.getOrtmplsrvs();
		if (ortmplsrvs != null && ortmplsrvs.size() > 0) {
			for (Object obj : ortmplsrvs) {
				CiOrTmplSrvDTO tmplSrv = (CiOrTmplSrvDTO)obj;
				medSrvList.add(medSrvMap.get(tmplSrv.getId_srv()));
			}
		}
		
		/*List<MedSrvSetItemDO> medSrvSetItemList = srvSetItemsMap.get(ciOrTmpl.getId_srv());
		if (medSrvSetItemList != null && medSrvSetItemList.size() > 0) {
			for (MedSrvSetItemDO medSrvSetItem : medSrvSetItemList) {
				medSrvList.add(medSrvMap.get(medSrvSetItem.getId_srv_itm()));
			}
		}*/

		return medSrvList;
	}

	/**
	 * 获取套内项目的Map结构
	 * 
	 * @param idSrv 服务套的服务id
	 * @param medSrvList 套内项目集合
	 * @return 套内项目的Map结构,key 服务套的id_srv
	 */
	private FMap getSrvSetitmMap(String idSrv, List<MedSrvDO> medSrvList) {

		FMap fmap = new FMap();

		FArrayList list = new FArrayList();
		for (MedSrvDO medSrv : medSrvList) {

			OrdSrvSetDO ordSrvSetDO = new OrdSrvSetDO();
			ordSrvSetDO.setStatus(DOStatus.NEW);
			ordSrvSetDO.setId_srvset(medSrv.getId_srv());
			ordSrvSetDO.setId_freqdef(medSrv.getId_freq());
			ordSrvSetDO.setId_medu(medSrv.getId_unit_med());
			
			list.add(ordSrvSetDO);
		}

		fmap.put(idSrv, list);
		return fmap;
	}

}
