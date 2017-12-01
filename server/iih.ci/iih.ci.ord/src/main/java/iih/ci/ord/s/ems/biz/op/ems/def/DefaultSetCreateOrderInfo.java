package iih.ci.ord.s.ems.biz.op.ems.def;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import iih.bd.pp.primd.i.IBdPrimdCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.bd.srv.medsrv.d.MedSrvSetItemDO;
import iih.bd.srv.medsrv.i.IMedSrvSetItemDORService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSrvSourceFromEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvset.d.OrdSrvSetDO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.ICalcPriModeProxy;
import iih.ci.ord.s.ems.biz.meta.BdSrvInfoList;
import iih.ci.ord.s.ems.biz.meta.BdSrvInfoMap;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.BdSrvMmInfoList;
import iih.ci.ord.s.ems.biz.meta.OrderPackageInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvExtPackage;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.ci.ord.s.ems.biz.meta.OrderSrvSetList;
import iih.ci.ord.s.ems.biz.op.calcpri.CompCalcPriModeProxy;
import iih.ci.ord.s.ems.biz.op.calcpri.NumACalcPriModeProxy;
import iih.ci.ord.s.ems.biz.op.calcpri.NumCalcPriModeProxy;
import iih.ci.ord.s.ems.biz.op.calcpri.SelfSrvCalcPriModeProxy;
import iih.ci.ord.s.ems.biz.utils.BdSrvInfoUtils;
import iih.ci.ord.s.ems.define.StringList;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.sf.core.util.ServiceFinder;

/**
 * 默认服务套创建逻辑
 * 
 * @author wangqingzhu
 *
 */
public class DefaultSetCreateOrderInfo extends DefaultSingleSrvCreateOrderInfo {

	@Override
	protected DefaultBaseCreateOrderInfo createOrderSrvAExtInfo(OrderPackageInfo orderPakageInfo,
			BdSrvMmInfoList bdSrvMmInfoList) throws BizException {
		
		if (CiOrdUtils.isTrue(orderPakageInfo.getOrderInfo().getFg_set())){
			// 非药品 创建时候服务项目应该只有一个，因此 去 0 位置元素
			OrderSrvExtPackage osasp = CalcSrvFeesOrdSrvInfo(this.getEnContextInfo(), orderPakageInfo.getOrderInfo(),
					bdSrvMmInfoList.get(0));
			if (CiOrdUtils.isEmpty(osasp)) {
				throw new BizException("计算服务项目等扩展信息失败 ");
			}
			if (null != osasp.getOrdSrvSetInfoList()) {
				orderPakageInfo.setOrderSrvSetList(osasp.getOrdSrvSetInfoList());
			}
			if (null != osasp.getOrderSrvMmList()) {
				orderPakageInfo.setOrderSrvMmList(osasp.getOrderSrvMmList());
			}
		} else {
			super.createOrderSrvAExtInfo(orderPakageInfo, bdSrvMmInfoList);
		}

		return this;
	}

	/**
	 * 
	 * @param szMedSrvInfo
	 *            套内项目的基础数据
	 * @return
	 * @throws BizException
	 */
	protected OrdSrvSetDO[] handleOrderSrvSetInfo(CiOrderDO orderInfo, MedSrvDO[] szMedSrvInfo) throws BizException {
		List<OrdSrvSetDO> listOrdSrvSetDO = new ArrayList<OrdSrvSetDO>();
		for (MedSrvDO bdSrvInfo : szMedSrvInfo) {
			MedSrvSetItemDO[] szMedSrvSetItemDO = BdSrvInfoUtils.QueryMedSrvSetItemBy(bdSrvInfo.getId_srv());
			if (!CiOrdUtils.isEmpty(szMedSrvSetItemDO)) {
				szMedSrvSetItemDO = BdSrvInfoUtils.ClinicalMedSrvSetItemArrayOf(szMedSrvSetItemDO);
				if (!CiOrdUtils.isEmpty(szMedSrvSetItemDO)) {
					for (MedSrvSetItemDO bdSrvSetItem : szMedSrvSetItemDO) {
						listOrdSrvSetDO.add(assembleOrderSrvSetInfo(orderInfo, bdSrvSetItem));
					}
				}
			}
		}
		return listOrdSrvSetDO.toArray(new OrdSrvSetDO[listOrdSrvSetDO.size()]);
	}

	/**
	 * 
	 * @param szMedSrvSetItemDO
	 * @return
	 * @throws BizException
	 */
	private OrdSrvSetDO[] assembleOrderSrvSetInfo(CiOrderDO orderInfo, MedSrvSetItemDO[] szMedSrvSetItemDO)
			throws BizException {
		List<OrdSrvSetDO> listOrdSrvSetDO = new ArrayList<OrdSrvSetDO>();
		if (!CiOrdUtils.isEmpty(szMedSrvSetItemDO)) {
			szMedSrvSetItemDO = BdSrvInfoUtils.ClinicalMedSrvSetItemArrayOf(szMedSrvSetItemDO);
			if (!CiOrdUtils.isEmpty(szMedSrvSetItemDO)) {
				for (MedSrvSetItemDO bdSrvSetItem : szMedSrvSetItemDO) {
					listOrdSrvSetDO.add(assembleOrderSrvSetInfo(orderInfo, bdSrvSetItem));
				}
			}
		}

		return listOrdSrvSetDO.toArray(new OrdSrvSetDO[listOrdSrvSetDO.size()]);
	}

	/**
	 * 医嘱服务套信息
	 * 
	 * @param setItemdo
	 *            套内项目对象
	 * @return
	 */
	protected OrdSrvSetDO assembleOrderSrvSetInfo(CiOrderDO orderInfo, MedSrvSetItemDO setItemdo) {
		OrdSrvSetDO srvset = new OrdSrvSetDO();
		srvset.setStatus(DOStatus.NEW);
		srvset.setId_orsrvset(this.generatePks()); // 医嘱服务服务套主键标识
		// srvset.setId_orsrv(); //医嘱服务项目
		srvset.setId_or(orderInfo.getId_or()); // 医嘱
		srvset.setId_srvsetdef(setItemdo.getId_srv()); // 服务套
		srvset.setId_srvset(setItemdo.getId_srv_itm()); // 套内服务项目
		srvset.setSortno(setItemdo.getSortno()); // 序号
		srvset.setDes_srv(setItemdo.getDes()); // 套内服务项目描述
		srvset.setId_srvsetrole(setItemdo.getId_srvsetrole()); // 成员角色
		srvset.setSd_srvsetrole(setItemdo.getSd_srvsetrole()); // 成员角色编码
		srvset.setId_medu(setItemdo.getId_medu()); // 医疗单位
		srvset.setQuan_medu(setItemdo.getQuan_medu()); // 数值_医疗单位
		srvset.setId_freqdef(setItemdo.getId_freq()); // 频次
		// srvset.setSd_body(); //部位编码
		// srvset.setBody_name(); //部位名称
		// srvset.setSd_pos(); //体位编码
		srvset.setFg_clinical(setItemdo.getFg_clinical()); // 是否临床
		srvset.setFg_clinical_bl(setItemdo.getFg_clinical_bl()); // 是否临床价格计算
		// srvset.setId_body(); //部位
		// srvset.setId_pos(); //体位
		srvset.setId_route(setItemdo.getId_route()); // 用法
		srvset.setId_routedes(setItemdo.getId_routedes()); // 用法要求
		return srvset;
	}

	/**
	 * 计算费用关联服务项目
	 * 
	 * @param szMedSrvInfo
	 *            服务套信息
	 * @return
	 * @throws BizException
	 */
	public OrderSrvExtPackage CalcSrvFeesOrdSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo)
			throws BizException {
		
		// 根据服务套id 查询套内项目
		MedSrvSetItemDO[] szMedSrvSetItemDO = BdSrvInfoUtils
				.QueryMedSrvSetItemBy(bdSrvMmInfo.getBdSrvInfo().getId_srv(), true);
		// 单选模式默认选择第一个
		if (CiOrdUtils.isTrue(bdSrvMmInfo.getBdSrvInfo().getFg_setradio())) {
			szMedSrvSetItemDO = new MedSrvSetItemDO[] { szMedSrvSetItemDO[0] };
		}
		OrderSrvExtPackage orderSrvExtPackage = CalcSrvFeesOrdSrvInfo(ctx, orderInfo, bdSrvMmInfo, szMedSrvSetItemDO);
		
		// 计算套内非临床
		szMedSrvSetItemDO = BdSrvInfoUtils.QueryMedSrvSetItemBy(bdSrvMmInfo.getBdSrvInfo().getId_srv(), false);
		OrderSrvExtPackage orderSrvExtPackage1 = CalcSrvFeesOrdSrvInfo(ctx, orderInfo, bdSrvMmInfo, szMedSrvSetItemDO);
		if (!CiOrdUtils.isEmpty(orderSrvExtPackage)&&!CiOrdUtils.isEmpty(orderSrvExtPackage1)) {
			orderSrvExtPackage.merge(orderSrvExtPackage1);
		}
		return orderSrvExtPackage;
	}

	/**
	 * 根据主服务和给定的套内项目服务ID集合创建医嘱服务扩展对象包
	 * 
	 * @param ctx
	 *            就诊上下文
	 * @param orderInfo
	 *            医嘱对象
	 * @param bdSrvMmInfo
	 *            定义态基础数据服务和物品对象聚集对象
	 * @param szId_srv
	 *            套内项目服务id数组
	 * @return
	 * @throws BizException
	 */
	public OrderSrvExtPackage CalcSrvFeesOrdSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo,
			String[] szId_srv) throws BizException {
		MedSrvSetItemDO[] szMedSrvSetItemDO = ServiceFinder.find(IMedSrvSetItemDORService.class)
				.findByAttrValStrings(MedSrvSetItemDO.ID_SRV_ITM, szId_srv);
		return CalcSrvFeesOrdSrvInfo(ctx,orderInfo,bdSrvMmInfo,szMedSrvSetItemDO);
	}
	
	/**
	 * 根据主服务和给定的套内项目对象集合创建医嘱服务扩展对象包
	 * 
	 * @param ctx
	 * @param orderInfo
	 * @param bdSrvMmInfo
	 * @param szMedSrvSetItemDO
	 * @return
	 * @throws BizException
	 */
	public OrderSrvExtPackage CalcSrvFeesOrdSrvInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, BdSrvMmInfo bdSrvMmInfo,
			MedSrvSetItemDO[] szMedSrvSetItemDO) throws BizException {
		OrderSrvExtPackage ordSrvExtPackage = new OrderSrvExtPackage();
		if (CiOrdUtils.isEmpty(szMedSrvSetItemDO))
			return ordSrvExtPackage;
		

		// 0. 按照不同计价模式分拣服务
		switch (bdSrvMmInfo.getBdSrvInfo().getId_primd()) {
		case IBdPrimdCodeConst.ID_PRI_SRV:// 本服务定价
			// 1. 计算本服务定价
			// ordSrvExtPackage = CalcSelfPriOfOrdSrvPackage(ctx, orderInfo,
			// bdSrvMmInfo);
			ordSrvExtPackage = CalcPriOfOrdSrvPackage(ctx, orderInfo, bdSrvMmInfo, szMedSrvSetItemDO,
					new SelfSrvCalcPriModeProxy(bdSrvMmInfo.getBdSrvInfo().getId_srv(),
							bdSrvMmInfo.getBdSrvInfo().getName(), szMedSrvSetItemDO.length));
			break;
		case IBdPrimdCodeConst.ID_PRI_SRV_COMP:// 组合定价
			// ordSrvExtPackage = CalcCompPriOfOrdSrvPackage(ctx, orderInfo,
			// bdSrvMmInfo);
			ordSrvExtPackage = CalcPriStdSrvOfOrdSrvList(ctx, orderInfo, bdSrvMmInfo.getBdSrvInfo(),
					new CompCalcPriModeProxy(bdSrvMmInfo.getBdSrvInfo().getId_srv(),
							bdSrvMmInfo.getBdSrvInfo().getName(), szMedSrvSetItemDO.length));

			break;
		case IBdPrimdCodeConst.ID_PRI_SRVSET_AMOUNT:// 套成员合计价
			ordSrvExtPackage = CalcSumPriOfOrdSrvPackage(ctx, orderInfo, bdSrvMmInfo,szMedSrvSetItemDO);
			
			break;
		case IBdPrimdCodeConst.ID_PRI_SRVSET_MU:// 套个数加收
			// ordSrvExtPackage = CalcNumAPriOfOrdSrvPackage(ctx, orderInfo,
			// bdSrvMmInfo);
			ordSrvExtPackage = CalcPriOfOrdSrvPackage(ctx, orderInfo, bdSrvMmInfo, szMedSrvSetItemDO,
					new NumACalcPriModeProxy(bdSrvMmInfo.getBdSrvInfo().getId_srv(),
							bdSrvMmInfo.getBdSrvInfo().getName(), szMedSrvSetItemDO.length));
			break;
		case IBdPrimdCodeConst.ID_PRI_SRVSET_FIX:// 套个数定价
			// ordSrvExtPackage = CalcNumPriOfOrdSrvPackage(ctx, orderInfo,
			// bdSrvMmInfo);
			ordSrvExtPackage = CalcPriOfOrdSrvPackage(ctx, orderInfo, bdSrvMmInfo, szMedSrvSetItemDO,
					new NumCalcPriModeProxy(bdSrvMmInfo.getBdSrvInfo().getId_srv(),
							bdSrvMmInfo.getBdSrvInfo().getName(), szMedSrvSetItemDO.length));
			break;
		}

		return ordSrvExtPackage;
	}

	/**
	 * 成员合计服务套处理逻辑
	 * 
	 * @param ctx
	 *            就诊上下文信息
	 * @param orderInfo
	 *            医嘱信息
	 * @param bdSrvMmInfo
	 *            套信息
	 * @return
	 * @throws BizException
	 */
	protected OrderSrvExtPackage CalcSumPriOfOrdSrvPackage(CiEnContextDTO ctx, CiOrderDO orderInfo,
			BdSrvMmInfo bdSrvMmInfo,MedSrvSetItemDO[] szMedSrvSetItemDO) throws BizException {

		// 查询出所有的套内项目，并分组到映射表中

		StringList idSrvList = new StringList();
		for (MedSrvSetItemDO mssid : szMedSrvSetItemDO) {
			idSrvList.add(mssid.getId_srv_itm());
		}

		// 计算出所有的套内项目的基础数据集合
		BdSrvInfoMap bdSrvInfoWithSetItemCache = new BdSrvInfoList(BdSrvInfoUtils.QueryBdSrvInfo(idSrvList.asArray()))
				.asMap();

		OrderSrvMmList osmil = new OrderSrvMmList();
		OrderSrvSetList ossil = new OrderSrvSetList();
		// 遍历套内项目
		for (int index = 0; index < szMedSrvSetItemDO.length; ++index) {
			MedSrvSetItemDO mssid = szMedSrvSetItemDO[index];
			if (bdSrvInfoWithSetItemCache.containsKey(mssid.getId_srv_itm())) {
				MedSrvDO srvInfo = bdSrvInfoWithSetItemCache.get(mssid.getId_srv_itm());
					
				if (IBdPrimdCodeConst.ID_PRI_SRV_COMP.equals(srvInfo.getId_primd())) {
					// TODO: 成员合计项目中的【组合计价】处理
					OrderSrvExtPackage ordSrvExtPackage = CalcPriStdSrvOfOrdSrvList(this.getEnContextInfo(), orderInfo,
							srvInfo, new CompCalcPriModeProxy(bdSrvMmInfo.getBdSrvInfo().getId_srv(),
									bdSrvMmInfo.getBdSrvInfo().getName(), 0));
					// 非套服务 - 组合定价服务信息（费用项目）计算
					if (!CiOrdUtils.isEmpty(osmil) && !CiOrdUtils.isEmpty(ordSrvExtPackage.getOrderSrvMmList())) {
						osmil.addAll(ordSrvExtPackage.getOrderSrvMmList());
				}
				} else {
					// // 本服务定价
					// if
					// (IBdPrimdCodeConst.ID_PRI_SRV.equals(srvInfo.getId_primd()))
					// {
					//
					// }
					// // 对应物品价格
					// else if
					// (IBdPrimdCodeConst.ID_PRI_RES.equals(srvInfo.getId_primd()))
					// {
					//
					// }
					//
					// // 不付费
					// else if
					// (IBdPrimdCodeConst.ID_PRI_FREE.equals(srvInfo.getId_primd()))
					// {
					//
					// }
					// else if
					// (IBdPrimdCodeConst.ID_PRI_PLUGIN.equals(srvInfo.getId_primd()))
					// {
					//
					// }

					// 组织服务信息和物品信息
					OrderSrvMmInfo orderSrvMmInfo = createOrderSrvMmInfo(ctx, orderInfo, srvInfo,
							OrSrvSourceFromEnum.PHYSIAN, index);
					osmil.add(orderSrvMmInfo);
				}
				// 临床项目生成套项目信息
				if (CiOrdUtils.isTrue(mssid.getFg_clinical()) && CiOrdUtils.isTrue(mssid.getFg_active())) {
					ossil.add(assembleOrderSrvSetInfo(orderInfo, mssid));
				}

			}
		}

		return new OrderSrvExtPackage(bdSrvMmInfo.getBdSrvInfo().getId_srv(),osmil,ossil);
	}

	/**
	 * 组合计价模式服务项目计算
	 * 
	 * @param ctx
	 * @param orderInfo
	 *            医嘱对象
	 * @param bdSrvMmInfo
	 *            基础数据和物品数据聚集对象
	 * @return
	 * @throws BizException
	 */
	protected OrderSrvExtPackage CalcPriOfOrdSrvPackage(CiEnContextDTO ctx, CiOrderDO orderInfo,
			BdSrvMmInfo bdSrvMmInfo, MedSrvSetItemDO[] szMedSrvSetItemDO, ICalcPriModeProxy iCalcPriModeProxy)
			throws BizException {
		
		//
		OrderSrvExtPackage ordSrvExtPackage = CalcPriStdSrvOfOrdSrvList(ctx, orderInfo, bdSrvMmInfo.getBdSrvInfo(),
				iCalcPriModeProxy);

		// 生成临床套内项目信息
		OrdSrvSetDO[] szOrdSrvSetDO = assembleOrderSrvSetInfo(orderInfo, szMedSrvSetItemDO);
		if (!CiOrdUtils.isEmpty(szOrdSrvSetDO)) {
			ordSrvExtPackage.setOrdSrvSetInfoList(new OrderSrvSetList(Arrays.asList(szOrdSrvSetDO)));
		}
		return ordSrvExtPackage;
		
	}

}
