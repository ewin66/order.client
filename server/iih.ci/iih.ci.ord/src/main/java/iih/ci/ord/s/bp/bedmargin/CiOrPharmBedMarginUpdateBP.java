package iih.ci.ord.s.bp.bedmargin;

import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmCudService;
import iih.ci.ord.ordsrvmm.i.IOrdsrvmmRService;
import iih.ci.ord.s.bp.qry.getOrSrvBedQuanSql;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.orm.utils.AppFwUtil;

public class CiOrPharmBedMarginUpdateBP {

	/**
	 * 扣除床旁余量 2016-07-06
	 * 
	 * @author xuxing
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	public String exec(String[] id_ors) throws BizException {

		// 1、获取医嘱主实体DO
		OrdSrvDO[] orSrvDOS = validation(id_ors);

		// 2、验证
		if (orSrvDOS == null || orSrvDOS.length < 1) {
			return "";
		}

		// 3、获取医嘱项目与医嘱项目物品的关系
		QuanRel[] quanRel = getRelation(orSrvDOS);

		// 4、累加使用量，余量校验
		validationQuan(quanRel, id_ors);

		// 5、扣除床旁余量
		quanReduce(quanRel);

		return "";
	}

	/**
	 * 获取医嘱项目主实体DO
	 * 
	 * @param id_ors
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] validation(String[] id_ors) throws BizException {

		if (id_ors != null && id_ors.length > 0) {

			getOrSrvBedQuanSql Sql = new getOrSrvBedQuanSql(id_ors);

			OrdSrvDO[] orSrvDOS = (OrdSrvDO[]) AppFwUtil.getDORstWithDao(Sql, OrdSrvDO.class);

			if (orSrvDOS != null && orSrvDOS.length > 0) {

				return orSrvDOS;
			}

			return null;

		} else {

			return null;
		}
	}

	/**
	 * 获取医嘱项目与医嘱项目物品的关系
	 * 
	 * @param orSrvDOS
	 * @return
	 * @throws BizException
	 */
	private QuanRel[] getRelation(OrdSrvDO[] orSrvDOS) throws BizException {

		List<QuanRel> reList = new ArrayList<QuanRel>();
		IOrdsrvmmRService srvMmService = ServiceFinder.find(IOrdsrvmmRService.class);

		String Id_orsrvs = "";
		for (OrdSrvDO orsrv : orSrvDOS) {

			QuanRel quanRel = new QuanRel();
			quanRel.setId_or(orsrv.getId_or());
			quanRel.setId_orsrv(orsrv.getId_orsrv());
			quanRel.setOrdSrvDO(orsrv);
			reList.add(quanRel);
			Id_orsrvs += (Id_orsrvs.length() == 0 ? "" : ",") + "'" + orsrv.getId_orsrv() + "'";

		}

		// 获取医嘱项目有对应的全部物品信息 （ci_or_srv_mm）
		OrdSrvMmDO[] srvMmDOS = srvMmService.find("a0.id_orsrv in(" + Id_orsrvs + ")", "", FBoolean.FALSE);

		if (reList.size() > 0) {

			for (QuanRel quanRel : reList) {

				setSrvMmRel(quanRel, srvMmDOS);
			}
		}

		return reList.toArray(new QuanRel[reList.size()]);
	}

	/**
	 * 设置服务物品
	 * 
	 * @param quanRel
	 * @param srvMmDOS
	 * @throws BizException
	 */
	private void setSrvMmRel(QuanRel quanRel, OrdSrvMmDO[] srvMmDOS) throws BizException {

		if (srvMmDOS != null && srvMmDOS.length > 0) {

			for (OrdSrvMmDO ordSrvMmDO : srvMmDOS) {

				if (ordSrvMmDO.getId_orsrv().equals(quanRel.getId_orsrv())) {

					quanRel.setOrdSrvMmDO(ordSrvMmDO);

					if (ordSrvMmDO.getQuan_bed_medu() != null) {

						quanRel.BedQuan_sum = ordSrvMmDO.getQuan_bed_medu().toDouble();
					}
					break;
				}
			}
		}

		if (quanRel.getOrdSrvMmDO() == null) {
			throw new BizException("扣减床旁余量：服务项目【" + quanRel.getOrdSevDO().getName() + "】,未找到对应的物品信息！");
		}

	}

	/**
	 * 使用量累加 同一医嘱，多个执行点同时执行，累加使用量
	 * 
	 * @param quanRel
	 * @param id_ors
	 * @throws BizException
	 */
	private void validationQuan(QuanRel[] quanRel, String[] id_ors) throws BizException {

		if (quanRel != null && quanRel.length > 0) {

			// 使用量累加
			for (String id_or : id_ors) {

				copyQuan(id_or, quanRel);
			}

			// 余量校验
			for (QuanRel quan : quanRel) {

				if (quan.BedQuan_sum < quan.Quan_sum) {

					throw new BizException("扣减床旁余量，医嘱项目【" + quan.getOrdSevDO().getName() + "】床旁余量不足！");
				}
			}
		}
	}

	/**
	 * 根据医嘱ID，累加使用量
	 * 
	 * @param id_or
	 * @param quanRel
	 * @return
	 */
	private void copyQuan(String id_or, QuanRel[] quanRel) throws BizException {

		if (!StringUtil.isEmpty(id_or)) {

			for (QuanRel quan : quanRel) {

				if (quan.getId_or().equals(id_or)) {

					// 累加使用量
					if (quan.getOrdSevDO().getQuan_medu() != null) {

						quan.Quan_sum += quan.getOrdSevDO().getQuan_medu().toDouble();

					} else {

						throw new BizException("扣减床旁余量，医嘱项目【" + quan.getOrdSevDO().getName() + "】数值_医学单位空异常！");
					}
				}
			}
		}
	}

	/**
	 * 扣除床旁余量
	 * 
	 * @param quanRel
	 * @throws BizException
	 */
	private void quanReduce(QuanRel[] quanRel) throws BizException {

		List<OrdSrvMmDO> listSave = new ArrayList<OrdSrvMmDO>();
		IOrdsrvmmCudService saveService = ServiceFinder.find(IOrdsrvmmCudService.class);

		for (QuanRel quan : quanRel) {

			if (quan.getOrdSrvMmDO() != null) {

				Double bedQuan = quan.getOrdSrvMmDO().getQuan_bed_medu().toDouble();
				Double remain = bedQuan - quan.Quan_sum;
				quan.getOrdSrvMmDO().setQuan_bed_medu(new FDouble(remain));
				quan.getOrdSrvMmDO().setStatus(DOStatus.UPDATED);
				listSave.add(quan.getOrdSrvMmDO());
			}
		}

		if (listSave.size() > 0) {

			saveService.save(listSave.toArray(new OrdSrvMmDO[listSave.size()]));
		}
	}

	/**
	 * 医嘱项目与物品对应关系
	 * 
	 * @author Administrator
	 *
	 */
	private class QuanRel {

		public QuanRel() {
		}

		/**
		 * 医嘱
		 */
		private String Id_or;

		public String getId_or() {
			return Id_or;
		}

		private void setId_or(String id_or) {
			Id_or = id_or;
		}

		/**
		 * 医嘱项目
		 */
		private String Id_orsrv;

		public String getId_orsrv() {
			return Id_orsrv;
		}

		private void setId_orsrv(String id_orsrv) {
			Id_orsrv = id_orsrv;
		}

		/**
		 * 使用量
		 */
		public Double Quan_sum = 0.0;

		/**
		 * 床旁余量
		 */
		public Double BedQuan_sum = 0.0;

		/**
		 * 服务
		 */
		private OrdSrvDO SrvDO;

		public OrdSrvDO getOrdSevDO() {
			return SrvDO;
		}

		private void setOrdSrvDO(OrdSrvDO srvDO) {
			SrvDO = srvDO;
		}

		/**
		 * 服务物品
		 */
		private OrdSrvMmDO SrvMmDO;

		public OrdSrvMmDO getOrdSrvMmDO() {
			return SrvMmDO;
		}

		private void setOrdSrvMmDO(OrdSrvMmDO srvMmDO) {
			SrvMmDO = srvMmDO;
		}

	}

}
