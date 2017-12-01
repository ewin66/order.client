package iih.ci.ord.s.bp.ordbttest;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrdBtTestItmDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtMDOCudService;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.cior.i.ICiordrptbttestCudService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.mp.nr.dto.internal.d.ExecuteTpEnum;
import iih.mp.nr.dto.internal.d.OrPlanDTO;
import iih.mp.nr.i.IMporInternalService;
import iih.mp.pub.IMpFunCodeConst;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 交叉备血结果保存逻辑，包含保存和提交（更新备血量等信息）
 * 
 * @author Administrator
 *
 */
public class OrdBtTestSaveBp {

	/**
	 * 交叉备血结果保存逻辑
	 * 
	 * @author xu_xing2016-07-11
	 * @param aggDO
	 * @throws BizException
	 */
	public CiordrptbttestAggDO exec(CiordrptbttestAggDO aggDO, boolean fg_commit) throws BizException {

		// 1、验证
		if (!validation(aggDO)) {
			return null;
		}

		// 2、条码重复校验
		saveValidation(aggDO);

		// 3、取医嘱
		CiOrderDO order = getOrder(aggDO);

		// 4、保存备血结果
		CiordrptbttestAggDO savedAggDO = saveAggDO(aggDO, fg_commit);

		// 5、更新备血申请可用学余量
		updateApbt(savedAggDO, fg_commit);

		// 6、更改闭环状态
		setOrpltpsta(order, fg_commit);
		
		return savedAggDO;
	}

	/**
	 * 验证
	 * 
	 * @param aggDO
	 * @return
	 */
	private boolean validation(CiordrptbttestAggDO aggDO) {

		boolean reBool = false;

		if (aggDO != null) {

			reBool = true;
		}

		return reBool;
	}

	/**
	 * 保存前校验
	 * 
	 * @param aggDO
	 * @throws BizException
	 */
	private void saveValidation(CiordrptbttestAggDO aggDO) throws BizException {
		
		SaveValidationBp bp = new SaveValidationBp();

		bp.exec(aggDO);
	}

	/**
	 * 取医嘱
	 * 
	 * @param aggDO
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO getOrder(CiordrptbttestAggDO aggDO) throws BizException {

		ICiorderMDORService iCiorderMDORService = ServiceFinder.find(ICiorderMDORService.class);

		return iCiorderMDORService.findById(aggDO.getParentDO().getId_or());
	}

	/**
	 * 备血结果保存
	 * 
	 * @param aggDO
	 * @return
	 * @throws BizException
	 */
	private CiordrptbttestAggDO saveAggDO(CiordrptbttestAggDO aggDO, boolean fg_commit) throws BizException {

		if (aggDO != null && aggDO.getParentDO() != null) {

			ICiordrptbttestCudService saveService = ServiceFinder.find(ICiordrptbttestCudService.class);

			if (!StringUtil.isEmptyWithTrim(aggDO.getParentDO().getId_rptbttest())) {

				aggDO.getParentDO().setStatus(DOStatus.UPDATED);

			} else {

				aggDO.getParentDO().setId_su_bttest(ICiDictCodeConst.ID_BTTEST_KL);
				aggDO.getParentDO().setSd_su_bttest(ICiDictCodeConst.SD_BTTEST_KL);
				aggDO.getParentDO().setStatus(DOStatus.NEW);
			}

			// 确认操作更新备血量
			if (fg_commit == true) {

				if (aggDO.getCiOrdBtTestItmDO() != null && aggDO.getCiOrdBtTestItmDO().length > 0) {

					Integer sum = 0;

					for (CiOrdBtTestItmDO itmDO : aggDO.getCiOrdBtTestItmDO()) {

						if (DOStatus.DELETED != itmDO.getStatus()) {

							sum += itmDO.getNum_bb();
						}
					}

					aggDO.getParentDO().setId_su_bttest(ICiDictCodeConst.ID_BTTEST_TJ);
					aggDO.getParentDO().setSd_su_bttest(ICiDictCodeConst.SD_BTTEST_TJ);
					aggDO.getParentDO().setNum_bt(sum);

				} else {

					throw new BizException("交叉备血结果保存，未找到备血检验结果！");
				}
			}

			CiordrptbttestAggDO[] saved = saveService.save(new CiordrptbttestAggDO[] { aggDO });

			if (saved != null && saved.length > 0) {

				return saved[0];
			}
		}

		return null;
	}

	/**
	 * 更新备血申请可用血余量
	 * 
	 * @param aggDO
	 * @throws BizException
	 */
	private void updateApbt(CiordrptbttestAggDO aggDO, boolean fg_submit) throws BizException {

		// 非提交操作，不更新闭环
		if (!fg_submit) {
			return;
		}

		ICiorappbtMDORService findService = ServiceFinder.find(ICiorappbtMDORService.class);

		OrdApBtDO[] apBtDOS = findService.findByAttrValString(OrdApBtDO.ID_APBT, aggDO.getParentDO().getId_apbt());

		if (apBtDOS != null && apBtDOS.length == 1) {

			apBtDOS[0].setNum_margin_bu(new FDouble(aggDO.getParentDO().getNum_bt()));
			apBtDOS[0].setStatus(DOStatus.UPDATED);

			ICiorappbtMDOCudService saveService = ServiceFinder.find(ICiorappbtMDOCudService.class);
			saveService.save(apBtDOS);

		} else {

			throw new BizException("交叉备血结果保存，获取输血申请异常！");
		}
	}

	/**
	 * 更改备血闭环
	 * 
	 * @param order
	 * @throws BizException
	 */
	private void setOrpltpsta(CiOrderDO order, boolean fg_commit) throws BizException {

		// 非提交操作，不更新闭环
		if (!fg_commit) {
			return;
		}

		IMporInternalService statusService = ServiceFinder.find(IMporInternalService.class);

		OrPlanDTO DTO = new OrPlanDTO();
		DTO.setId_or(order.getId_or());
		DTO.setDt_mp_plan(order.getDt_effe());
		DTO.setEu_tp(ExecuteTpEnum.EXECUTE);

		statusService.updateOrpltpByOr(new OrPlanDTO[] { DTO }, IMpFunCodeConst.FUN_CODE_MTCROSSBTRSTENTER, "");
	}
}
