package iih.ci.ord.s.bp.bedmargin;

import java.util.ArrayList;
import java.util.List;

import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.s.bp.qry.getOrPharmArrivalInTransitSql;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class CiOrPharmArrivalInTransitUpdateBP {

	/**
	 * 临床医嘱药品在途量到货更新操作
	 * 
	 * @author xu_xing2016-07-07
	 * @param id_orsrvs
	 * @throws BizException
	 */
	public String exec(String[] id_orsrvs) throws BizException {

		// 1、获取即将参与计算的医嘱项目物品集合
		OrdSrvMmDO[] reSrvMmDOS = validation(id_orsrvs);

		// 2、校验
		if (reSrvMmDOS == null) {
			return "";
		}

		// 3、验证在途量，返回异常信息
		List<OrdSrvMmDO> listPreSave = new ArrayList<OrdSrvMmDO>();
		String erroeMessage = validationQuan(reSrvMmDOS, listPreSave);

		// 4、更新余量
		updateBedQuan(listPreSave);

		return erroeMessage;
	}

	/**
	 * 获取即将参与计算的医嘱项目物品集合
	 * 
	 * @param id_orsrvs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvMmDO[] validation(String[] id_orsrvs) throws BizException {

		if (id_orsrvs != null && id_orsrvs.length > 0) {

			getOrPharmArrivalInTransitSql Sql = new getOrPharmArrivalInTransitSql(id_orsrvs);

			OrdSrvMmDO[] reSrvMmDOS = (OrdSrvMmDO[]) AppFwUtil.getDORstWithDao(Sql, OrdSrvMmDO.class);

			return reSrvMmDOS;
		}

		return null;
	}

	/**
	 * 验证在途量
	 * 
	 * @param reSrvMmDOS
	 * @return
	 * @throws BizException
	 */
	private String validationQuan(OrdSrvMmDO[] reSrvMmDOS, List<OrdSrvMmDO> listSave) throws BizException {

		String reMessage = "";

		for (OrdSrvMmDO ordSrvMmDO : reSrvMmDOS) {

			if (ordSrvMmDO.getQuan_bed_transit() != null && ordSrvMmDO.getQuan_bed_transit().toDouble() > 0) {

				listSave.add(ordSrvMmDO);

			} else {

				reMessage += (reMessage.length() == 0 ? "" : "") + "?";
			}
		}

		return "物品【" + reMessage + "】在途量空异常！";
	}

	/**
	 * 更新床旁余量
	 * 
	 * @param listSave
	 * @throws BizException
	 */
	private void updateBedQuan(List<OrdSrvMmDO> listSave) throws BizException {

		if (listSave.size() > 0) {

			IOrdsrvmmCudService saveService = ServiceFinder.find(IOrdsrvmmCudService.class);

			for (OrdSrvMmDO ordSrvMmDO : listSave) {

				if (ordSrvMmDO.getQuan_bed_medu() == null || ordSrvMmDO.getQuan_bed_transit() == null) {

					continue;
				}

				Double medu = ordSrvMmDO.getQuan_bed_medu().toDouble();
				Double transit = ordSrvMmDO.getQuan_bed_transit().toDouble();
				ordSrvMmDO.setQuan_bed_medu(new FDouble(medu + transit));
				ordSrvMmDO.setQuan_bed_transit(new FDouble(0));
				ordSrvMmDO.setStatus(DOStatus.UPDATED);
			}

			saveService.save(listSave.toArray(new OrdSrvMmDO[listSave.size()]));
		}
	}
}
