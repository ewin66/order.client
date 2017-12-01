package iih.ci.ord.s.ems.biz.op.order.bp.copy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.apbt.OrderApbtCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.apbu.OrderApbuCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.cons.OrderConsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.drugs.OrderDrugsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.herbs.OrderHerbsCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.lis.OrderLisCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.opr.OrderOpCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.pathgy.OrderPathgyCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.ris.OrderRisCopyBP;
import iih.ci.ord.s.ems.biz.op.order.bp.copy.treat.OrderTreatCopyBP;

/**
 * 复制操作工厂类
 * 
 * @author Young
 *
 */
public class OrderCopyFactory {

	/**
	 * 获取个服务类型医嘱的复制操作类
	 * 
	 * @param sdtp
	 * @return
	 */
	public OrderBaseCopyBP getOrderCopyBP(String sdtp) {
		OrderBaseCopyBP bp = null;
		switch (sdtp) {
		case IBdSrvDictCodeConst.SD_SRVTP_DRUG:
			bp = new OrderDrugsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG:
			bp = new OrderHerbsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_RIS:
			bp = new OrderRisCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI:
			bp = new OrderPathgyCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_LIS:
			bp = new OrderLisCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_OP:
			bp = new OrderOpCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_TREAT:
			bp = new OrderTreatCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS:
			bp = new OrderConsCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD:
			bp = new OrderApbuCopyBP();
			break;
		case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE:
			bp = new OrderApbtCopyBP();
			break;
		}

		return bp;
	}

	/**
	 * 获取类型分组的医嘱ID
	 * 
	 * @param ciors
	 * @return
	 */
	public Map<String, List<String>> getMapIdors(CiOrderDO[] ciors) {
		Map<String, List<String>> mapIdors = new HashMap<String, List<String>>();
		for (CiOrderDO cior : ciors) {
			String sd_srvtp = cior.getSd_srvtp();
			switch (sd_srvtp.substring(0, 2)) {
			case IBdSrvDictCodeConst.SD_SRVTP_DRUG:
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG)) {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_HERBDRUG, cior.getId_or());
				} else {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_DRUG, cior.getId_or());
				}
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_RIS:
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI)) {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_RIS_BINGLI, cior.getId_or());
				} else {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_RIS, cior.getId_or());
				}
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_LIS:
				setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_LIS, cior.getId_or());
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_OP:
				setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_OP, cior.getId_or());
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_TREAT:
				setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_TREAT, cior.getId_or());
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS:
				setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_DIAGTREAT_OP_CONCROSS, cior.getId_or());
				break;
			case IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD:
				if (sd_srvtp.startsWith(IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE)) {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE, cior.getId_or());
				} else {
					setMapIdors(mapIdors, IBdSrvDictCodeConst.SD_SRVTP_BLOODPROD, cior.getId_or());
				}
				break;
			}
		}

		return mapIdors;
	}

	/**
	 * 分组
	 * 
	 * @param mapIdors
	 * @param sdsrvtp
	 * @param idor
	 */
	private void setMapIdors(Map<String, List<String>> mapIdors, String sdsrvtp, String idor) {
		if (mapIdors.containsKey(sdsrvtp)) {
			mapIdors.get(sdsrvtp).add(idor);
		} else {
			List<String> lst = new ArrayList<String>();
			lst.add(idor);
			mapIdors.put(sdsrvtp, lst);
		}
	}
}
