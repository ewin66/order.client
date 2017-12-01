package iih.ci.ord.s.bp.ordbttest;

import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.cior.d.CiOrdBtTestDO;
import iih.ci.ord.cior.d.CiordrptbttestAggDO;
import iih.ci.ord.cior.d.OrdApBtDO;
import iih.ci.ord.cior.i.ICiorappbtMDORService;
import iih.ci.ord.cior.i.ICiordrptbttestRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ciorder.i.ICiorderRService;
import iih.ci.ord.s.bp.rpt.CiReportCommBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 根据申请单号回去备血信息
 * 
 * @author xuxing_2017-03-07
 *
 */
public class GetBtTestInfoBp {

	/**
	 * 主入口
	 *
	 * @param no_applyForm
	 * @return
	 * @throws BizException
	 */
	public CiordrptbttestAggDO exec(String no_applyForm) throws BizException {

		// 1、空校验
		if (StringUtil.isEmptyWithTrim(no_applyForm)) {
			return null;
		}

		// 2、获取输血申请单
		OrdApBtDO apBtDO = getApBtDO(no_applyForm);

		// 3、保存过的直接返回
		CiordrptbttestAggDO rtn = getBtTestAggDO(apBtDO);
		if (rtn.getParentDO() != null && !StringUtil.isEmptyWithTrim(rtn.getParentDO().getId_rptbttest())) {
			return rtn;
		}

		// 4、获取医嘱信息
		CiorderAggDO orderAgg = getOrder(apBtDO);

		// 5、实例化主DO
		CiOrdBtTestDO btTestDO = getParentDO(orderAgg, apBtDO);

		// 6、设置主DO
		rtn.setParentDO(btTestDO);

		return rtn;
	}

	/**
	 * 获取输血申请
	 * 
	 * @param no_applyForm
	 * @return
	 * @throws BizException
	 */
	private OrdApBtDO getApBtDO(String no_applyForm) throws BizException {

		ICiorappbtMDORService findService = ServiceFinder.find(ICiorappbtMDORService.class);

		OrdApBtDO[] rtns = findService.findByAttrValString(OrdApBtDO.NO_APPLYFORM, no_applyForm);

		if (rtns != null && rtns.length == 1) {

			return rtns[0];

		} else {

			throw new BizException("申请单【" + no_applyForm + "】对应的输血申请空或不唯一异常！");
		}
	}

	/**
	 * 获取备血结果Agg
	 * 
	 * @param apBtDO
	 * @return
	 * @throws BizException
	 */
	private CiordrptbttestAggDO getBtTestAggDO(OrdApBtDO apBtDO) throws BizException {

		ICiordrptbttestRService btTestFindService = ServiceFinder.find(ICiordrptbttestRService.class);
		CiordrptbttestAggDO[] aggDOs = btTestFindService.findByAttrValString(OrdApBtDO.ID_APBT, apBtDO.getId_apbt());

		if (aggDOs != null) {

			if (aggDOs.length == 1) {

				return aggDOs[0];

			} else if (aggDOs.length > 1) {

				throw new BizException("申请单【" + apBtDO.getNo_applyform() + "】对应的备血检验结果不唯一异常！");
			}
		}

		return new CiordrptbttestAggDO();
	}

	/**
	 * 获取医嘱Agg
	 * 
	 * @param apBtDO
	 * @return
	 * @throws BizException
	 */
	private CiorderAggDO getOrder(OrdApBtDO apBtDO) throws BizException {

		if (!StringUtil.isEmptyWithTrim(apBtDO.getId_or())) {

			ICiorderRService findService = ServiceFinder.find(ICiorderRService.class);

			CiorderAggDO orderAgg = findService.findById(apBtDO.getId_or());

			if (orderAgg != null) {

				return orderAgg;

			} else {

				throw new BizException("备血结果录入：未找到医嘱信息！");
			}
		}

		return null;
	}

	/**
	 * 实例化主DO
	 * 
	 * @param orderAgg
	 * @return
	 * @throws BizException 
	 */
	private CiOrdBtTestDO getParentDO(CiorderAggDO orderAgg, OrdApBtDO apBtDO) throws BizException {

		CiOrdBtTestDO parentDO = new CiOrdBtTestDO();
		parentDO.setStatus(DOStatus.NEW);
		parentDO.setId_su_bttest(ICiDictCodeConst.ID_BTTEST_KL);
		parentDO.setSd_su_bttest(ICiDictCodeConst.SD_BTTEST_KL);
		parentDO.setNo_applyform(apBtDO.getNo_applyform());
		parentDO.setApplyformno(apBtDO.getNo_applyform());
		parentDO.setId_apbt(apBtDO.getId_apbt());
		parentDO.setDt_recheck(new FDateTime());

		CiOrderDO order = orderAgg.getParentDO();

		Map<String,Object> entInfo = CiReportCommBP.findEntInfoByOrId(order.getId_or());
		parentDO.setEnt_code((String)entInfo.get("ent_code"));
		
		if (order != null) {

			parentDO.setId_or(order.getId_or());// 医嘱
			parentDO.setId_ent(order.getId_en());// 就诊
			parentDO.setName_pat(order.getPat_name());// 患者姓名
			parentDO.setId_pat(order.getId_pat());// 患者ID
		}

		if (orderAgg.getOrdSrvDO() != null && orderAgg.getOrdSrvDO().length > 0) {

			Double sum = 0.0;

			for (OrdSrvDO srvDO : orderAgg.getOrdSrvDO()) {

				if (IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE.equals(srvDO.getSd_srvtp())) {

					sum += srvDO.getQuan_medu().toDouble();

					if (StringUtil.isEmptyWithTrim(parentDO.getId_medu())) {

						parentDO.setId_srv_bt(srvDO.getId_srv());// 血液服务项目
						parentDO.setId_medu(srvDO.getId_medu());// 医疗单位
						parentDO.setMedu_name(srvDO.getMedu_name());// 单位名称
						parentDO.setName_bt(srvDO.getName());// 服务名称
					}
				}
			}
			parentDO.setQuan_medu(new FDouble(sum));// 备血量
		}

		return parentDO;
	}

	
	
}
