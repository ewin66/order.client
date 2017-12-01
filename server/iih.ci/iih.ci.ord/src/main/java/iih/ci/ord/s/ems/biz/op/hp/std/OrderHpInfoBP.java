package iih.ci.ord.s.ems.biz.op.hp.std;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ordsrvmm.d.OrdSrvMmDO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderHpInfoBP;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmInfo;
import iih.ci.ord.s.ems.biz.meta.OrderSrvMmList;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.log.logging.Logger;

/**
 * 医嘱医保信息处理逻辑
 * @author wangqingzhu
 *
 */
public class OrderHpInfoBP implements IOrderHpInfoBP {
	private static String HBHpStr = "2";
	private static String BJHpStr = "1";
	@Override
	public boolean handleOrderHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean handleSrvHpInfo(CiEnContextDTO ctx, OrderSrvMmList orderSrvMmList) {
		if (CiOrdUtils.isEmpty(orderSrvMmList))
			return false;
		Ent4BannerDTO ent4BannerDTO = ctx.getEnt4BannerDTO();
		String sd_hptp = ent4BannerDTO.getSd_hptp();
		String id_hp = ctx.getId_hp();// 前端banner传入的医保计划
		try {
			String id_hp_default = CiOrdUtils.getIdHpDefault(ent4BannerDTO.getId_ent());
			// 前端banner传入的默认医保计划
			Map<String, OrdSrvDO> srvMap = new HashMap<String, OrdSrvDO>();
			List<String> exHPIdSrv = new ArrayList<String>();// 存入没有设置医保值的id_srv
			List<String> exHPIdIdMm = new ArrayList<String>();// 存入没有设置医保值的id_srv关联的id_mm
			String id_hp_temp = id_hp;
			if (StringUtils.isEmpty(id_hp))
				id_hp_temp = id_hp_default;
			for (OrderSrvMmInfo orderSrvMmInfo : orderSrvMmList) {
				OrdSrvDO ordSrvDo = orderSrvMmInfo.getOrderSrvInfo();
				if (!CiOrdUtils.isEmpty(ordSrvDo)) {
					ordSrvDo.setId_hp(id_hp_temp);
					// 过滤出来未赋值的
					if (CiOrdUtils.isEmpty(ordSrvDo.getId_hpsrvtp()) || CiOrdUtils.isEmpty(ordSrvDo.getSd_hpsrvtp())) {
						OrdSrvMmDO ordSrvMmDo = orderSrvMmInfo.getOrderSrvMmInfo();
						if (!CiOrdUtils.isEmpty(ordSrvMmDo)) {
							exHPIdIdMm.add(ordSrvMmDo.getId_mm());
							srvMap.put(ordSrvDo.getId_srv() + ordSrvMmDo.getId_mm(), ordSrvDo);
						} else {
							exHPIdSrv.add(ordSrvDo.getId_srv());
							srvMap.put(ordSrvDo.getId_srv(), ordSrvDo);
						}
					}
				}
			}

			// 如果存在没有id_hpsrvtp和sd_hpsrvtp的服务，给该服务赋值
			if (exHPIdSrv.size() > 0 || exHPIdIdMm.size() > 0) {
				StringBuffer sql = new StringBuffer();
				if (StringUtils.isEmpty(sd_hptp) || sd_hptp.startsWith(HBHpStr) || StringUtils.isEmpty(id_hp)) {
					sql.append(CiOrdUtils.getSql(exHPIdSrv, exHPIdIdMm, id_hp_default).toString());
				}
				if (!StringUtils.isEmpty(sd_hptp) && sd_hptp.startsWith(BJHpStr)) {
					sql.append(CiOrdUtils.getSql(exHPIdSrv, exHPIdIdMm, id_hp).toString());
				}

				HPSrvorcaDO[] hpSrvorcas = CiOrdAppUtils.getIHpExtService().find(sql.toString(), "", FBoolean.FALSE);
				for (HPSrvorcaDO srvca : hpSrvorcas) {
					String id_mm = srvca.getId_mm() == null ? "" : srvca.getId_mm();
					String id_srv = srvca.getId_srv();
					String key = id_srv + id_mm;
					if (srvMap.containsKey(key)) {
						OrdSrvDO srv = srvMap.get(key);
						srv.setId_hpsrvtp(srvca.getId_hpsrvtp());
						srv.setSd_hpsrvtp(srvca.getSd_hpsrvtp());
					}
				}

			}

			// fg_bl为true，且医保目录中不存在，设置为丙类
			for (OrderSrvMmInfo orderSrvMmInfo : orderSrvMmList) {
				OrdSrvDO ordSrvDo = orderSrvMmInfo.getOrderSrvInfo();
				if (StringUtils.isEmpty(ordSrvDo.getId_hpsrvtp()) && FBoolean.TRUE.equals(ordSrvDo.getFg_bl())) {
					ordSrvDo.setId_hpsrvtp(IBdPpCodeTypeConst.ID_HP_BJ_THREE);
					ordSrvDo.setSd_hpsrvtp(IBdPpCodeTypeConst.SD_HP_BJ_THREE);
				}
			}
		} catch (BizException e) {
			Logger.error(e.getMessage());
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean afterHandleHpInfo(CiEnContextDTO ctx, CiOrderDO orderInfo, OrdSrvDO[] szSrvInfo) {
		if(CiOrdUtils.isEmpty(szSrvInfo) || CiOrdUtils.isEmpty(orderInfo)) return false;
		Ent4BannerDTO ent4BannerDTO = ctx.getEnt4BannerDTO();
 		String sd_hptp = ent4BannerDTO.getSd_hptp();
 		
 		if(!StringUtils.isEmpty(sd_hptp) && sd_hptp.startsWith(BJHpStr)){
 			orderInfo.setFg_orhp(FBoolean.FALSE);
 			for (OrdSrvDO ordSrvDO : szSrvInfo) {
				if(!CiOrdUtils.isEmpty(ordSrvDO.getId_hpsrvtp()) && !CiOrdUtils.isEmpty(ordSrvDO.getSd_hpsrvtp())) orderInfo.setFg_orhp(FBoolean.TRUE);;
			}
 		}
 		return true;
	}

}
