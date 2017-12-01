/**
 * 
 */
package iih.ci.ord.s.bp;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.i.ICiorapptransdeptRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.ciorder.i.IOrdSrvDOCudService;
import iih.ci.ord.ciorder.i.IOrdSrvDORService;
import iih.ci.ord.dto.orsrvsplitorder.d.WriteBackOrDTO;

import java.util.ArrayList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * @ClassName: UpdateOrderSdMpBP
 * @Description: 执行回写医嘱状态
 * 
 * @version 2016-06-27 王春辉 需求 更新医嘱服务项目，增加执行科室为本科室的限制条件
 * @version 2016-07-22 转科/转病区医嘱，执行科室单独处理
 * @version 2016-08-25 执行状态增加“执行中”
 * @version 2016-08-30 王琪：执行状态为完成（执行完成，执行取消，执行拒绝）时，更改医嘱状态为完成（60）
 * @version 2016-09-02 回写医嘱不可取消标识Fg_uncancelable
 * @version 2016-09-07 首次执行，预停、核停逻辑
 * @version 2016-09-12 出院带药医嘱，执行即完成
 * @version 2016-09-13 用医嘱的原始执行状态判断是都首次执行
 * @version 2016-09-14 首次执行只有长期医嘱才有
 * @version 2016-09-19 回写不可取消标识错误修正
 * @version 2016-09-20 废除医嘱状态40
 * @version 2016-10-10 非在院执行,执行即完成
 * @version 2016-11-07 Fg_noncancelable字段改为Fg_cancelable
 * @version 2016-11-07 回写医嘱可退费标识、设置服务项目可退费标识
 * @version 2016-12-20 不可取消时，才回写最近执行时间
 * @author xuxing
 * @date 2016年6月21日 下午3:02:48
 * @version 2017-02-24 不可退费标识回写迭代
 * @version 2017-03-03 医嘱为完成状态时，回写无效
 */
public class UpdateOrderSdMpBP {

	public String exe(WriteBackOrDTO[] paramDTOS) throws BizException {

		// 1、参数校验，返回医嘱ID集合
		String[] idOrs = validation(paramDTOS);

		// 2、 获取医嘱集合
		CiOrderDO[] ciOrderDOS = getOrderDOS(idOrs);

		// 3、 获取医嘱项目集合
		OrdSrvDO[] orSrvDOS = getOrSrvDOS(idOrs);

		// 4、设置医嘱执行状态
		setOrderStatus(ciOrderDOS, paramDTOS);

		// 5、设置医嘱项目执行状态和最后执行日期
		setOrSrvStatus(ciOrderDOS, orSrvDOS, paramDTOS);

		// 6、保存
		save(ciOrderDOS, orSrvDOS);

		return "";
	}

	/**
	 * 参数校验，返回医嘱ID集合
	 * 
	 * @param paramDTOS
	 * @return
	 * @throws BizException
	 */
	private String[] validation(WriteBackOrDTO[] paramDTOS) throws BizException {

		List<String> listOrs = new ArrayList<String>();

		if (paramDTOS != null && paramDTOS.length > 0) {

			int rowNum = 0;

			for (WriteBackOrDTO writeBackOrDTO : paramDTOS) {

				String errorStr = "";
				rowNum++;

				if (StringUtil.isEmpty(writeBackOrDTO.getId_or())) {
					errorStr = "医嘱标识为空";
				}
				if (StringUtil.isEmpty(writeBackOrDTO.getMp_tp() + "")) {
					errorStr = "执行类型为空";
				}
				if (StringUtil.isEmpty(writeBackOrDTO.getDt_last_mp() + "")) {
					errorStr = "最后执行日期为空";
				}
				if (!writeBackOrDTO.getMp_tp().equals(0) && !writeBackOrDTO.getMp_tp().equals(1) && !writeBackOrDTO.getMp_tp().equals(2) && !writeBackOrDTO.getMp_tp().equals(3) && !writeBackOrDTO.getMp_tp().equals(4)) {
					errorStr = "执行类型不在范围【0:未执行 1：执行开始 2：拒绝执行 3：执行取消  4：执行完成】";
				}

				if (!StringUtil.isEmpty(errorStr)) {
					throw new BizException("回写医嘱执行状态，" + errorStr + " 【第" + rowNum + "行】!");
				}
				listOrs.add(writeBackOrDTO.getId_or());
			}
		}

		return listOrs.toArray(new String[listOrs.size()]);
	}

	/**
	 * 获取医嘱集合
	 * 
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO[] getOrderDOS(String[] idOrs) throws BizException {

		ICiorderMDORService orFindService = ServiceFinder.find(ICiorderMDORService.class);

		if (idOrs != null && idOrs.length > 0) {

			CiOrderDO[] orderDOS = orFindService.findByIds(idOrs, FBoolean.FALSE);

			return orderDOS;
		}
		return null;
	}

	/**
	 * 获取医嘱项目集合
	 * 
	 * @param idOrs
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] getOrSrvDOS(String[] idOrs) throws BizException {

		IOrdSrvDORService orSrvFindService = ServiceFinder.find(IOrdSrvDORService.class);

		if (idOrs != null && idOrs.length > 0) {

			String whereInStr = "";

			for (String id_or : idOrs) {
				whereInStr += (whereInStr.length() == 0 ? "" : ",") + "'" + id_or + "'";
			}

			OrdSrvDO[] orSrvDOS = orSrvFindService.find("a1.id_or in(" + whereInStr + ")", "", FBoolean.FALSE);

			return orSrvDOS;
		}
		return null;
	}

	/**
	 * 设置医嘱执行状态
	 * 
	 * @param orderDOS
	 * @param paramDTOS
	 * @throws BizException
	 */
	private void setOrderStatus(CiOrderDO[] orderDOS, WriteBackOrDTO[] paramDTOS) throws BizException {

		if (orderDOS != null && orderDOS.length > 0) {

			for (WriteBackOrDTO writeBackOrDTO : paramDTOS) {

				CiOrderDO order = findOrder(writeBackOrDTO.getId_or(), orderDOS);

				// 2017-03-27退费标识在所有逻辑之前设值
				// 2016-11-07 回写医嘱可退费标识
				if (order.getFg_feertnable() != null && !order.getFg_feertnable().equals(writeBackOrDTO.getFg_feertnable())) {

					order.setFg_feertnable(writeBackOrDTO.getFg_feertnable());
					order.setStatus(DOStatus.UPDATED);
				}

				// 2017-03-27作废标识在所有逻辑之前设值
				// 2016-09-02 回写医嘱不可取消标识
				// 2016-09-19 回写不可取消标识错误修正
				// 2016-11-07 Fg_noncancelable字段改为Fg_cancelable
				if (writeBackOrDTO.getFg_cancelable() != null) {

					FBoolean fg_uncancelable = new FBoolean(FBoolean.FALSE.equals(writeBackOrDTO.getFg_cancelable()));
					order.setFg_uncancelable(fg_uncancelable);
				}

				// 已经是完成状态的医嘱，本次更新跳过
				if (ICiDictCodeConst.SD_SU_FINISH.equals(order.getSd_su_or()) || ICiDictCodeConst.SD_SU_CANCEL.equals(order.getSd_su_or()) || ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(order.getSd_su_or())) {

					continue;
				}

				// 原有执行状态
				// 2016-08-25 执行状态增加“执行中”
				String Old_id_su_mp = order.getId_su_mp() + "";
				String New_id_su_mp = "";

				// 2016-08-30 王琪 执行状态为完成时，更改医嘱状态为完成（60）
				String Old_id_su_or = order.getId_su_or() + "";
				String New_id_su_or = "";

				switch (writeBackOrDTO.getMp_tp()) {
				case 0:// 0 未执行
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_NONE_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
					break;
				case 1:// 执行开始
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_PERFORMED_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED);
					break;
				case 2:// 拒绝执行
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_CANCEL_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL);

					New_id_su_or = ICiDictCodeConst.SD_SU_ID_FINISH;
					order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
					order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
					break;
				case 3:// 执行取消
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_EXECANC_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXECANC_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXECANC);

					New_id_su_or = ICiDictCodeConst.SD_SU_ID_FINISH;
					order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
					order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
					break;
				case 4:// 执行完毕
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_EXEOK_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);

					New_id_su_or = ICiDictCodeConst.SD_SU_ID_FINISH;
					order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
					order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);
					break;
				}

				// 2016-09-07 首次执行，停止逻辑
				// 2016-09-13 用医嘱的原始执行状态判断是都首次执行
				// 2016-09-20废除医嘱状态40
				// specialOrderHandle(order, Old_id_su_mp);

				// 2016-09-12 出院带药&非在院执行(2016-10-10) 医嘱，执行即完成
				if ((FBoolean.FALSE.equals(order.getFg_mp_in()) || FBoolean.TRUE.equals(order.getFg_pres_outp())) && writeBackOrDTO.getMp_tp().equals(1)) {
					New_id_su_mp = ICiDictCodeConst.SD_SU_MP_EXEOK_ID;
					order.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
					order.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);

					New_id_su_or = ICiDictCodeConst.SD_SU_ID_FINISH;
					order.setId_su_or(ICiDictCodeConst.SD_SU_ID_FINISH);
					order.setSd_su_or(ICiDictCodeConst.SD_SU_FINISH);

					// 将执行状态改为4，便于服务项目状态也同样改为已完成
					writeBackOrDTO.setMp_tp(4);

					order.setFg_uncancelable(FBoolean.TRUE);
					order.setFg_feertnable(FBoolean.FALSE);
				}

				// 2016-07-14 医嘱CI_ORDER增加最近执行时间
				// 2016-12-20 只有到不可取消标识的时候才回写最近执行时间
				if (FBoolean.TRUE.equals(order.getFg_uncancelable())) {

					if (order.getDt_last_mp() == null) {
						order.setDt_last_mp(writeBackOrDTO.getDt_last_mp());
						order.setStatus(DOStatus.UPDATED);

					} else if (order.getDt_last_mp().compareTo(writeBackOrDTO.getDt_last_mp()) < 0) {

						order.setDt_last_mp(writeBackOrDTO.getDt_last_mp());
						order.setStatus(DOStatus.UPDATED);
					}
				}

				// 状态是否有变更
				if (!Old_id_su_mp.equals(New_id_su_mp) || !Old_id_su_or.equals(New_id_su_or)) {
					order.setStatus(DOStatus.UPDATED);
				}
			}

			// throw new BizException("");
		}
	}

	/**
	 * 设置医嘱项目执行状态和最后执行日期
	 * 
	 * @param orderDOS
	 * @param orSrvDOS
	 * @param paramDTOS
	 * @throws BizException
	 */
	private void setOrSrvStatus(CiOrderDO[] orderDOS, OrdSrvDO[] orSrvDOS, WriteBackOrDTO[] paramDTOS) throws BizException {

		if (orSrvDOS != null && orSrvDOS.length > 0) {

			for (WriteBackOrDTO writeBackOrDTO : paramDTOS) {

				// 取当前医嘱信息（用长临标识）
				CiOrderDO order = findOrder(writeBackOrDTO.getId_or(), orderDOS);

				// 取医嘱下的全部服务项目
				OrdSrvDO[] setOrSrvDO = findOrSrv(writeBackOrDTO.getId_or(), orSrvDOS);

				for (OrdSrvDO ordSrvDO : setOrSrvDO) {

					// 2017-03-27 可退费标识移至服务状态回写第一步
					// 设置服务项目可退费标识
					if (ordSrvDO.getFg_feertnable() != null && !ordSrvDO.getFg_feertnable().equals(writeBackOrDTO.getFg_feertnable())) {

						ordSrvDO.setFg_feertnable(writeBackOrDTO.getFg_feertnable());
						ordSrvDO.setStatus(DOStatus.UPDATED);
					}

					// 2017-03-27已完成校验，移至服务项目循环中
					// 已经是完成状态的医嘱，本次更新跳过
					// if
					// (ICiDictCodeConst.SD_SU_FINISH.equals(order.getSd_su_or())
					// ||
					// ICiDictCodeConst.SD_SU_CANCEL.equals(order.getSd_su_or())
					// ||
					// ICiDictCodeConst.SD_SU_CHECKCANCEL.equals(order.getSd_su_or()))
					// {
					//
					// continue;
					// }

					// 2016-07-22 转科/转病区医嘱，执行科室单独处理
					if (!transDeptOrderValidation(ordSrvDO)) {

						// 2016-06-27 王春辉 需求 更新医嘱服务项目，增加执行科室为本科室的限制条件
						if (ordSrvDO.getId_dep_mp() != null) {

							if (!ordSrvDO.getId_dep_mp().equals(Context.get().getDeptId())) {

								continue;
							}

						} else {

							throw new BizException("回写医嘱执行状态，医嘱【" + order.getName_or() + "】服务项目【" + ordSrvDO.getName() + "】执行科室为空异常!");
						}

					}

					// 原有执行状态
					String Old_id_su_mp = ordSrvDO.getId_su_mp() + "";
					String New_id_su_mp = "";

					if (ordSrvDO.getDt_last_mp() == null) {

						ordSrvDO.setDt_last_mp(writeBackOrDTO.getDt_last_mp());

					} else if (writeBackOrDTO.getDt_last_mp().compareTo(ordSrvDO.getDt_last_mp()) > 0) {

						// 最后执行时间，由于是计划执行时间，就存在执行先后的问题，回写时，计划执行时间在现有的最近执行时间之后时，才回写
						ordSrvDO.setDt_last_mp(writeBackOrDTO.getDt_last_mp());
						Old_id_su_mp += "|";
					}

					switch (writeBackOrDTO.getMp_tp()) {
					case 0:// 0 未执行
						New_id_su_mp = ICiDictCodeConst.SD_SU_MP_NONE_ID;
						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
						break;
					case 1:// 执行开始
						New_id_su_mp = ICiDictCodeConst.SD_SU_MP_PERFORMED_ID;
						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_PERFORMED);
						break;
					case 2:// 拒绝执行
						New_id_su_mp = ICiDictCodeConst.SD_SU_MP_CANCEL_ID;
						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_CANCEL);
						break;
					case 3:// 执行取消
						New_id_su_mp = ICiDictCodeConst.SD_SU_MP_EXECANC_ID;
						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXECANC_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXECANC);
						break;
					case 4:// 执行完毕
						New_id_su_mp = ICiDictCodeConst.SD_SU_MP_EXEOK_ID;
						ordSrvDO.setId_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK_ID);
						ordSrvDO.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_EXEOK);
						break;
					}

					// 2016-12-20 只有到不可取消标识的时候才回写最近执行时间
					if (FBoolean.TRUE.equals(order.getFg_uncancelable())) {

						if (ordSrvDO.getDt_last_mp() == null) {
							ordSrvDO.setDt_last_mp(writeBackOrDTO.getDt_last_mp());
							ordSrvDO.setStatus(DOStatus.UPDATED);

						} else if (order.getDt_last_mp().compareTo(writeBackOrDTO.getDt_last_mp()) < 0) {

							ordSrvDO.setDt_last_mp(writeBackOrDTO.getDt_last_mp());
							ordSrvDO.setStatus(DOStatus.UPDATED);
						}
					}

					if (!Old_id_su_mp.equals(New_id_su_mp)) {

						ordSrvDO.setStatus(DOStatus.UPDATED);
					}
				}
			}
		}
	}

	/**
	 * 校验转科、转病区医嘱
	 * 
	 * @param order
	 * @throws BizException
	 */
	private boolean transDeptOrderValidation(OrdSrvDO ordSrvDO) throws BizException {

		if (IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSDEPT.equals(ordSrvDO.getSd_srvtp()) || IBdSrvDictCodeConst.SD_SRVTP_PATIMAN_TRANSWARD.equals(ordSrvDO.getSd_srvtp())) {

			ICiorapptransdeptRService findService = ServiceFinder.find(ICiorapptransdeptRService.class);

			OrdApTransDO[] transDOS = findService.find(" id_or='" + ordSrvDO.getId_or() + "'", "", FBoolean.FALSE);

			if (transDOS != null && transDOS.length == 1) {

				if (transDOS[0].getId_dep_nur_to().equals(Context.get().getDeptId())) {

					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 取单个医嘱
	 * 
	 * @param id_or
	 * @param orderDOS
	 * @return
	 * @throws BizException
	 */
	private CiOrderDO findOrder(String id_or, CiOrderDO[] orderDOS) throws BizException {

		for (CiOrderDO ciOrderDO : orderDOS) {

			if (ciOrderDO.getId_or().equals(id_or)) {

				return ciOrderDO;
			}
		}

		throw new BizException("回写医嘱执行状态，未找到医嘱信息【" + id_or + "】!");

	}

	/**
	 * 取多个医嘱项目
	 * 
	 * @param id_or
	 * @param orderDOS
	 * @return
	 * @throws BizException
	 */
	private OrdSrvDO[] findOrSrv(String id_or, OrdSrvDO[] orSrvDOS) throws BizException {

		List<OrdSrvDO> reListDOS = new ArrayList<OrdSrvDO>();

		for (OrdSrvDO ciOrSrvDO : orSrvDOS) {

			if (ciOrSrvDO.getId_or().equals(id_or)) {

				reListDOS.add(ciOrSrvDO);
			}
		}

		if (reListDOS.size() < 1) {

			throw new BizException("回写医嘱执行状态，未找到医嘱项目信息【医嘱：" + id_or + "】!");
		}

		return reListDOS.toArray(new OrdSrvDO[reListDOS.size()]);
	}

	/**
	 * 医嘱和项目和项目保存
	 * 
	 * @throws BizException
	 */
	private void save(CiOrderDO[] orderDOS, OrdSrvDO[] orSrvDOS) throws BizException {

		ICiorderMDOCudService orSaveService = ServiceFinder.find(ICiorderMDOCudService.class);

		IOrdSrvDOCudService orSrvSaveService = ServiceFinder.find(IOrdSrvDOCudService.class);

		orSaveService.save(orderDOS);

		orSrvSaveService.save(orSrvDOS);

	}

}
