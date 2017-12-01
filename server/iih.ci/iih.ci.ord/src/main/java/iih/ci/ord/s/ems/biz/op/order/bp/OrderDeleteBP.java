package iih.ci.ord.s.ems.biz.op.order.bp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mysql.jdbc.StringUtils;

import iih.ci.ciet.cievent.d.CiEventDO;
import iih.ci.ciet.cievent.d.desc.CiEventDODesc;
import iih.ci.ord.cior.d.CiorappbtAggDO;
import iih.ci.ord.cior.d.CiorappconsultAggDO;
import iih.ci.ord.cior.d.CiorapppathgyAggDO;
import iih.ci.ord.cior.d.CiorappsurgeryAggDO;
import iih.ci.ord.cior.d.OrdApLabDO;
import iih.ci.ord.cior.d.OrdApOutDO;
import iih.ci.ord.cior.d.OrdApTransDO;
import iih.ci.ord.cior.d.OrdAppBtUseDO;
import iih.ci.ord.cior.d.desc.OrdApBtDODesc;
import iih.ci.ord.cior.d.desc.OrdApConsDODesc;
import iih.ci.ord.cior.d.desc.OrdApLabDODesc;
import iih.ci.ord.cior.d.desc.OrdApOpDODesc;
import iih.ci.ord.cior.d.desc.OrdApOutDODesc;
import iih.ci.ord.cior.d.desc.OrdApPathgyDODesc;
import iih.ci.ord.cior.d.desc.OrdApTransDODesc;
import iih.ci.ord.cior.d.desc.OrdAppBtUseDODesc;
import iih.ci.ord.ciordems.d.EmsType;
import iih.ci.ord.ciorder.d.CiorderAggDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.ordsrvdose.d.OrdSrvDoseDO;
import iih.ci.ord.ordsrvdose.d.desc.OrdSrvDoseDODesc;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.ordsrvmm.d.desc.OrdSrvMmDODesc;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.ordsrvset.d.desc.OrdSrvSetDODesc;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.GetDefaultEmsTp8SrvtpBP;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderDeleteBP;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.d.desc.CiSkinTestRstDODesc;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;

/**
 * 医嘱删除
 * 
 * @author Young
 *
 */
public class OrderDeleteBP implements IOrderDeleteBP {

	@Override
	public OrderRstDTO delete(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		OrderRstDTO rstDTO = new OrderRstDTO();
		FArrayList paramList = arg.getDocument();
		if (paramList == null || paramList.size() <= 0) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		List<String> lstIdors = new ArrayList<String>();
		String strIdors = "";
		for (Object obj : paramList) {
			if (CiOrdUtils.isEmpty(obj))
				continue;
			lstIdors.add(obj.toString());
			strIdors += ",'" + obj.toString() + "'";
		}
		if (StringUtils.isNullOrEmpty(strIdors)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}
		strIdors = strIdors.substring(1);

		//获得医嘱集合
		CiorderAggDO[] aggdos = CiOrdAppUtils.getOrAggQryService().findByIds(
				lstIdors.toArray(new String[lstIdors.size()]), FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(aggdos)) {
			rstDTO.setIsSuccess(FBoolean.FALSE);
			return rstDTO;
		}

		String strIdorsrvs = "";
		HashMap<Integer, String> mapEmsType = new HashMap<Integer, String>();
		for (CiorderAggDO aggdo : aggdos) {
			OrdSrvDO[] orsrvDOs = aggdo.getOrdSrvDO();
			if (CiOrdUtils.isEmpty(orsrvDOs))
				continue;
			for (OrdSrvDO orsrvDO : orsrvDOs) {
				strIdorsrvs += ",'" + orsrvDO.getId_orsrv() + "'";
			}

			Integer tp = getEmsType(aggdo.getParentDO().getSd_srvtp());
			if (mapEmsType.containsKey(tp)) {
				mapEmsType.put(tp, mapEmsType.get(tp) + ",'" + aggdo.getParentDO().getId_or() + "'");
			} else {
				mapEmsType.put(tp, "'" + aggdo.getParentDO().getId_or() + "'");
			}
		}

		//医嘱项目关联物品数据删除
		if (!StringUtils.isNullOrEmpty(strIdorsrvs)) {
			deleteCiOrSrvMm(strIdorsrvs.substring(1));
		}
		//医嘱项目关联变动剂量数据删除
		deleteCiOrSrvDose(strIdors);
		//医嘱或医嘱项目关联套内项目数据删除
		deleteCiOrSrvSet(strIdors);
		//医嘱对应的皮试相关结果的删除
		deleteCiOrSkinTestRst(strIdors);

		//医嘱对应的检验申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.LIS))
			deleteCiOrdApLabDO(mapEmsType.get(EmsType.LIS));
		//医嘱对应的检查申请相关信息的删除
		if (mapEmsType.containsKey(EmsType.RIS))
			deleteCiOrdApObsDO(mapEmsType.get(EmsType.RIS));
		if (mapEmsType.containsKey(EmsType.CONS))
			deleteCiOrdApConsDO(mapEmsType.get(EmsType.CONS));
		if (mapEmsType.containsKey(EmsType.BT))
			deleteCiOrdApbtDO(mapEmsType.get(EmsType.BT));
		if (mapEmsType.containsKey(EmsType.BTUSE))
			deleteCiOrdApbuDO(mapEmsType.get(EmsType.BTUSE));
		if (mapEmsType.containsKey(EmsType.OPER))
			deleteCiOrdApOpDO(mapEmsType.get(EmsType.OPER));
		if (mapEmsType.containsKey(EmsType.PATHGY))
			deleteCiOrdApPathgyDO(mapEmsType.get(EmsType.PATHGY));
		if (mapEmsType.containsKey(EmsType.TRANSDEPT))
			deleteCiOrdAptransdeptDO(mapEmsType.get(EmsType.TRANSDEPT));
		if (mapEmsType.containsKey(EmsType.OUTHOSP))
			deleteCiOrdApoutDO(mapEmsType.get(EmsType.OUTHOSP));

		deleteCiOrder(aggdos);
		deleteCiOrEvent(strIdors);

		rstDTO.setIsSuccess(FBoolean.TRUE);
		return rstDTO;
	}

	/**
	 * 医嘱项目关联物品数据删除
	 * 
	 * @param strIdorsrvs
	 * @throws BizException
	 */
	private void deleteCiOrSrvMm(String strIdorsrvs) throws BizException {

		StringBuilder conditionSB = new StringBuilder();
		conditionSB.append(OrdSrvMmDODesc.TABLE_ALIAS_NAME).append(".id_orsrv in (").append(strIdorsrvs).append(")");
		OrdSrvMmDO[] dos = CiOrdAppUtils.getOrSrvMmQryService().find(conditionSB.toString(), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrsrvmmService().logicDelete(dos);
	}

	/**
	 * 医嘱项目关联变动剂量数据删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvDose(String strIdors) throws BizException {
		StringBuilder conditionSB = new StringBuilder();
		conditionSB.append(OrdSrvDoseDODesc.TABLE_ALIAS_NAME).append(".id_or in (").append(strIdors).append(")");

		OrdSrvDoseDO[] dos = CiOrdAppUtils.getOrsrvdoseQryService().find(conditionSB.toString(), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrsrvdoseService().delete(dos);
	}

	/**
	 * 医嘱或医嘱项目关联套内项目数据删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSrvSet(String strIdors) throws BizException {
		StringBuilder conditionSB = new StringBuilder();
		conditionSB.append(OrdSrvSetDODesc.TABLE_ALIAS_NAME).append(".id_or in (").append(strIdors).append(")");

		OrdSrvSetDO[] dos = CiOrdAppUtils.getOrsrvsetQryService().find(conditionSB.toString(), "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrsrvsetService().delete(dos);
	}

	/**
	 * 医嘱对应的皮试相关结果的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrSkinTestRst(String strIdors) throws BizException {
		String condstr = CiSkinTestRstDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiSkinTestRstDO[] dos = CiOrdAppUtils.getCiskintestrstQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getCiskintestrstService().delete(dos);
	}

	/**
	 * 临床医嘱删除
	 * 
	 * @param aggdo
	 * @throws BizException
	 */
	private void deleteCiOrder(CiorderAggDO[] aggdos) throws BizException {
		CiOrdAppUtils.getOrAggService().delete(aggdos);
	}

	/**
	 * 删除医嘱对应的临床事件
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrEvent(String strIdors) throws BizException {
		String condstr = CiEventDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiEventDO[] dos = CiOrdAppUtils.getCieventQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getCieventService().logicDelete(dos);
	}

	/**
	 * 医嘱对应的检验申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApLabDO(String strIdors) throws BizException {
		String condstr = OrdApLabDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		OrdApLabDO[] dos = CiOrdAppUtils.getOrapplisQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapplisService().delete(dos);
	}

	/**
	 * 医嘱对应的检查申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApObsDO(String strIdors) throws BizException {
		String condstr = OrdApLabDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		OrdApLabDO[] dos = CiOrdAppUtils.getOrapplisQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapplisService().delete(dos);
	}

	/**
	 * 医嘱对应的会诊申请相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApConsDO(String strIdors) throws BizException {
		String condstr = OrdApConsDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappconsultAggDO[] dos = CiOrdAppUtils.getOrappconsultQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappconsultService().delete(dos);
	}

	/**
	 * 备血对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbtDO(String strIdors) throws BizException {
		String condstr = OrdApBtDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappbtAggDO[] dos = CiOrdAppUtils.getOrappbtQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappbtService().delete(dos);
	}

	/**
	 * 用血对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApbuDO(String strIdors) throws BizException {
		String condstr = OrdAppBtUseDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		OrdAppBtUseDO[] dos = CiOrdAppUtils.getOrappbuQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappbuService().delete(dos);
	}

	/**
	 * 手术对应申请单相关的信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApOpDO(String strIdors) throws BizException {
		String condstr = OrdApOpDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorappsurgeryAggDO[] dos = CiOrdAppUtils.getOrappsurgeryQrytService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappsurgerytService().delete(dos);
	}

	/**
	 * 病理对应的申请单相关的信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApPathgyDO(String strIdors) throws BizException {
		String condstr = OrdApPathgyDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		CiorapppathgyAggDO[] dos = CiOrdAppUtils.getOrapppathgyQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapppathgyService().delete(dos);
	}

	/**
	 * 转科对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdAptransdeptDO(String strIdors) throws BizException {
		String condstr = OrdApTransDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		OrdApTransDO[] dos = CiOrdAppUtils.getOrapptransdepQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrapptransdepService().delete(dos);
	}

	/**
	 * 出院对应的申请单相关信息的删除
	 * 
	 * @param strIdors
	 * @throws BizException
	 */
	private void deleteCiOrdApoutDO(String strIdors) throws BizException {
		String condstr = OrdApOutDODesc.TABLE_ALIAS_NAME + ".id_or in (" + strIdors + ")";
		OrdApOutDO[] dos = CiOrdAppUtils.getOrappoutQryService().find(condstr, "", FBoolean.FALSE);
		if (CiOrdUtils.isEmpty(dos))
			return;
		CiOrdAppUtils.getOrappoutService().delete(dos);
	}

	/**
	 * 获得默认医疗单类型
	 * 
	 * @param sd_srvtp
	 * @return
	 * @throws BizException
	 */
	private Integer getEmsType(String sd_srvtp) throws BizException {
		GetDefaultEmsTp8SrvtpBP bp = new GetDefaultEmsTp8SrvtpBP();
		return bp.exec(sd_srvtp);
	}
}
