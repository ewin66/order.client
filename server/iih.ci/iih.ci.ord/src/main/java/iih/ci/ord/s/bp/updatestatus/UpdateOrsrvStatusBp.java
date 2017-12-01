package iih.ci.ord.s.bp.updatestatus;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderCudService;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrSrvDTO;
import iih.mp.nr.mporplan.d.ExecuteStatusEnum;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 更新医嘱项目执行状态
 * 
 * @author xuxing_2016-11-09
 *
 */
public class UpdateOrsrvStatusBp {

	/**
	 * 主入口
	 * 
	 * @param params
	 * @throws BizException
	 */
	public CiorderAggDO[] exec(WriteBackOrSrvDTO[] params) throws BizException {

		// 1、基本校验
		List<String> listOrder = new ArrayList<String>();
		if (!validation(params, listOrder)) {
			return null;
		}

		// 2、获取医嘱项目对应关系
		CiorderAggDO[] orderAggDOs = getOrsrvs(listOrder);

		// 3、设置医嘱和医嘱项目状态
		setStatus(params, orderAggDOs);

		// 4、更新操作
		CiorderAggDO[] aggs = update(orderAggDOs);

		return aggs;
	}

	/**
	 * 基本校验
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private boolean validation(WriteBackOrSrvDTO[] params, List<String> listOrder) throws BizException {

		if (params == null) {
			return false;
		}

		List<Integer> listStatus = new ArrayList<Integer>();
		listStatus.add(ExecuteStatusEnum.EXECUTED);// 执行
		listStatus.add(ExecuteStatusEnum.NOEXECUTE);// 不执行
		listStatus.add(ExecuteStatusEnum.UNEXECUTE);// 未执行
		listStatus.add(ExecuteStatusEnum.CANCEL);// 取消执行
		listStatus.add(ExecuteStatusEnum.ENDEXECUTED);// 执行完成

		for (WriteBackOrSrvDTO param : params) {

			if (!listOrder.contains(param.getId_or())) {
				listOrder.add(param.getId_or());
			}

			if (StringUtil.isEmptyWithTrim(param.getId_orsrv())) {
				throw new BizException("医嘱项目状态更新：医嘱项目ID空异常！");
			}
			if (StringUtil.isEmptyWithTrim(param.getId_or())) {
				throw new BizException("医嘱项目状态更新：医嘱ID空异常！");
			}
			if (param.getDt_last_mp() == null) {
				throw new BizException("医嘱项目状态更新：医嘱项目计划执行时间空异常！");
			}
			if (!listStatus.contains(param.getMp_tp())) {
				throw new BizException("医嘱项目状态更新：执行类别未能识别！");
			}
		}
		return true;
	}

	/**
	 * 获取医嘱项目对应关系
	 * 
	 * @param listOrder
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO[] getOrsrvs(List<String> listOrder) throws BizException {

		ICiorderRService findService = ServiceFinder.find(ICiorderRService.class);

		CiorderAggDO[] aggDOs = findService.findByAttrValStrings(CiOrderDO.ID_OR, listOrder.toArray(new String[listOrder.size()]));

		if (aggDOs == null || aggDOs.length < 1) {
			throw new BizException("医嘱项目状态更新：未找到医嘱信息！");
		}

		return aggDOs;
	}

	/**
	 * 设置医嘱和医嘱项目状态
	 * 
	 * @param params
	 * @param orderAggDOs
	 */
	private void setStatus(WriteBackOrSrvDTO[] params, CiorderAggDO[] orderAggDOs) {

		for (CiorderAggDO aggDO : orderAggDOs) {

			OrdSrvDO[] orSrvs = aggDO.getOrdSrvDO();
			FDateTime maxLastMp = orSrvs[0].getDt_last_mp();

			for (OrdSrvDO ordSrvDO : orSrvs) {

				WriteBackOrSrvDTO param = getParamByOrSrv(params, ordSrvDO.getId_orsrv());

				if (param != null) {

					// 最近执行时间
					ordSrvDO.setDt_last_mp(param.getDt_last_mp());
					if (maxLastMp == null || param.getDt_last_mp().compareTo(maxLastMp) > 0) {
						maxLastMp = param.getDt_last_mp();
					}
					ordSrvDO.setStatus(DOStatus.UPDATED);

					// 未执行0
					if (ExecuteStatusEnum.UNEXECUTE.equals(param.getMp_tp())) {

						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
					}
					// 执行中1
					if (ExecuteStatusEnum.EXECUTED.equals(param.getMp_tp())) {

						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED);
					}
					// 不执行2
					if (ExecuteStatusEnum.NOEXECUTE.equals(param.getMp_tp())) {

						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL);
					}
					// 取消执行3
					if (ExecuteStatusEnum.CANCEL.equals(param.getMp_tp())) {

						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL);
					}
					// 执行完成4
					if (ExecuteStatusEnum.ENDEXECUTED.equals(param.getMp_tp())) {

						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
					}
				}
			}
			aggDO.getParentDO().setId_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
			aggDO.getParentDO().setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED);

			setOrderCompleted(aggDO);
			aggDO.getParentDO().setDt_last_mp(maxLastMp);
			aggDO.getParentDO().setStatus(DOStatus.UPDATED);
		}
	}

	/**
	 * 根据Id_orsrv获取回写参数
	 * 
	 * @param params
	 * @param id_orsrv
	 * @return
	 */
	private WriteBackOrSrvDTO getParamByOrSrv(WriteBackOrSrvDTO[] params, String id_orsrv) {

		for (WriteBackOrSrvDTO param : params) {

			if (id_orsrv.equals(param.getId_orsrv())) {

				return param;
			}
		}
		return null;
	}

	/**
	 * 医嘱项目是否全部执行完成
	 * 
	 * @param ordSrvDO
	 * @return
	 */
	private void setOrderCompleted(CiorderAggDO aggDO) {

		List<String> listStatus = new ArrayList<String>();
		listStatus.add(ICiDictCodeConst.SD_SU_MP_EXEOK);// 执行完成
		listStatus.add(ICiDictCodeConst.SD_SU_MP_EXECANC);// 不执行
		listStatus.add(ICiDictCodeConst.SD_SU_MP_CANCEL);// 取消执行

		OrdSrvDO[] orSrvs = aggDO.getOrdSrvDO();

		for (OrdSrvDO ordSrvDO : orSrvs) {
			if (!listStatus.contains(ordSrvDO.getSd_su_mp())) {
				return;
			}
		}

		CiOrderDO order = aggDO.getParentDO();

		order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
		order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
		order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
		order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);

		// 医嘱不可取消，不可退费
		order.setFg_uncancelable(FBoolean.TRUE);
		order.setFg_feertnable(FBoolean.FALSE);

		// 完成状态的医嘱，所有项目均不可退费
		for (OrdSrvDO ordSrvDO : orSrvs) {

			ordSrvDO.setFg_feertnable(FBoolean.FALSE);
			ordSrvDO.setStatus(DOStatus.UPDATED);
		}

	}

	/**
	 * 更新操作
	 * 
	 * @param orderAggDOs
	 * @throws BizException
	 */
	private CiorderAggDO[] update(CiorderAggDO[] orderAggDOs) throws BizException {

		ICiorderCudService saveService = ServiceFinder.find(ICiorderCudService.class);

		return saveService.save(orderAggDOs);
	}
}
