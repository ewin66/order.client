package iih.ci.ord.s.ems.biz.op.order.bp;

import com.mysql.jdbc.StringUtils;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.IBdSrvDictCodeTypeConst;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrSourceFromEnum;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.d.ems.order.OrderOperateDTO;
import iih.ci.ord.d.ems.order.OrderRstDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.i.ICiOrdQryService;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.ems.biz.itf.bp.IOrderLoadBP;
import iih.ci.ord.s.ems.biz.utils.StringCodingUtils;
import iih.ci.ord.s.ems.define.OrdPicStatusIndex;
import iih.ci.ord.skintest.d.CiSkinTestRstDO;
import iih.ci.ord.skintest.i.ISkintestRService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FMap;
import xap.mw.core.data.FMap2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 医嘱加载
 * 
 * @author Young
 *
 */
public class OrderLoadBP implements IOrderLoadBP {

	@Override
	public OrderRstDTO load(OrderOperateDTO arg) throws BizException {
		// TODO Auto-generated method stub
		CiEnContextDTO ctx = arg.getEnContext();
		// 1. 获取医嘱排序模式
		ICiOrdQryService iCiOrdQryService = ServiceFinder.find(ICiOrdQryService.class);
		String orderbyMode = iCiOrdQryService.getOrderSequenceMode();

		// 2. 查询医嘱
		String whereStr = String
				.format(" a0.id_en='%s' and a0.code_entp='%s' and a0.fg_canc='N' and a0.fg_pres_outp='N' and a0.eu_orsrcmdtp!='%s' and (a0.eu_feereversetp is null or a0.eu_feereversetp<>1)",
						ctx.getId_en(), ctx.getCode_entp(), OrSourceFromEnum.IIHMEDTECHORDERS);
		ICiorderMDORService iCiorderMDORService = ServiceFinder.find(ICiorderMDORService.class);
		CiOrderDO[] szOrder = iCiorderMDORService.find(whereStr, " a0.createdtime " + orderbyMode, FBoolean.FALSE);

		FArrayList orderList = new FArrayList();
		for (CiOrderDO ord : szOrder) {
			ord.setStr_long(FBoolean.TRUE.equals(ord.getFg_long()) ? "长期" : "临时");
			// 如果没有停止医生 则医嘱列表停止时间 不显示 王琦需求
			if (CiOrdUtils.isEmpty(ord.getEmp_stop_name())) {
				ord.setDt_end(null);
			}
			if (!FBoolean.TRUE.equals(ord.getFg_long())) {
				ord.setEmp_stop_name(null);
			}
			if (!CiOrdUtils.isEmpty(ord.getId_emp_sign()) && !ord.getId_emp_sign().equals(ord.getId_emp_or())) {
				ord.setEmp_sign_name(ord.getEmp_sign_name() + "/" + ord.getEmp_phy_name());
			} else {
				ord.setEmp_sign_name(ord.getEmp_phy_name());
			}
			handleOrderDisplayStatus(ord, true);
			orderList.append(ord);
		}

		OrderRstDTO rst = new OrderRstDTO();
		rst.setDocument(orderList);
//		rst.setDocumentString(StringCodingUtils.Utf8_Base64_Encode(orderList.serializeJson()));

		FMap2 extensionInfo = new FMap2();
		extensionInfo.put("SrvTpNameMap", GetSdSrvtpDic());
		rst.setExtension(extensionInfo);

		return rst;
	}

	/**
	 * 处理医嘱显示状态
	 * 
	 * @param ci
	 * @param isOpOrder
	 * @throws BizException
	 */
	public void handleOrderDisplayStatus(CiOrderDO ci, boolean isOpOrder) throws BizException {
		switch (ci.getSd_su_or()) {
		case ICiDictCodeConst.SD_SU_OPEN:
			ci.setSu_or_name("开立");
			ci.setOrd_colligate(OrdPicStatusIndex.OPEN.toString());
			break;
		case ICiDictCodeConst.SD_SU_SIGN:
			ci.setSu_or_name("签署");
			ci.setOrd_colligate(OrdPicStatusIndex.SIGN.toString());

			if (IBdFcDictCodeConst.SD_CODE_ENTP_OP.equals(ci.getCode_entp())) {
				if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(ci.getSd_su_mp())) {
					if (ci.getFg_stop() != null) {
						if (ci.getFg_stop().equals(FBoolean.TRUE)) {
							ci.setSu_or_name("执行中+预停");
							ci.setOrd_colligate(OrdPicStatusIndex.EXEC_PRESTOP.toString());
						} else {
							ci.setSu_or_name("执行中");
							ci.setOrd_colligate(OrdPicStatusIndex.EXEC.toString());
						}
					} else {
						ci.setSu_or_name("未知");
						ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
					}
				}
			}
			break;
		case ICiDictCodeConst.SD_SU_CHECKTHROUGH:
			if (ICiDictCodeConst.SD_SU_MP_NONE.equals(ci.getSd_su_mp())) {
				if ((ci.getFg_stop().equals(FBoolean.FALSE)) || ci.getFg_pres_outp().equals(FBoolean.TRUE)) {
					// 出院带药不需要预停操作
					ci.setSu_or_name("确认");
					ci.setOrd_colligate(OrdPicStatusIndex.CONFIRM.toString());
				} else if (ci.getFg_stop().equals(FBoolean.TRUE)) {
					ci.setSu_or_name("确认+预停");
					ci.setOrd_colligate(OrdPicStatusIndex.CONFRIM_PRESTOP.toString());
				} else {
					ci.setSu_or_name("未知");
					ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
				}

			} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(ci.getSd_su_mp())) {
				if (ci.getFg_stop() != null) {
					if (ci.getFg_stop().equals(FBoolean.TRUE)) {
						ci.setSu_or_name("执行中+预停");
						ci.setOrd_colligate(OrdPicStatusIndex.EXEC_PRESTOP.toString());
					} else {
						ci.setSu_or_name("执行中");
						ci.setOrd_colligate(OrdPicStatusIndex.EXEC.toString());
					}
				} else {
					ci.setSu_or_name("未知");
					ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
				}
			} else {
				ci.setSu_or_name("未知");
				ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
			}
			break;
		case ICiDictCodeConst.SD_SU_CHECKSTOP:
			if (ci.getFg_stop().equals(FBoolean.TRUE)) {
				if (ICiDictCodeConst.SD_SU_MP_NONE.equals(ci.getSd_su_mp())) {
					ci.setSu_or_name("确认+停止");
					ci.setOrd_colligate(OrdPicStatusIndex.CONFIRM_STOP.toString());
				} else if (ICiDictCodeConst.SD_SU_MP_PERFORMED.equals(ci.getSd_su_mp())) {
					ci.setSu_or_name("执行中+停止");
					ci.setOrd_colligate(OrdPicStatusIndex.EXEC_STOP.toString());
				} else {
					ci.setSu_or_name("未知");
					ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
				}
			} else {
				ci.setSu_or_name("未知");
				ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
			}
			break;
		case ICiDictCodeConst.SD_SU_FINISH:
			if (ICiDictCodeConst.SD_SU_MP_EXEOK.equals(ci.getSd_su_mp())) {
				ci.setSu_or_name("完成");
				ci.setOrd_colligate(OrdPicStatusIndex.OVER.toString());
			} else if (ICiDictCodeConst.SD_SU_MP_EXECANC.equals(ci.getSd_su_mp())) {
				ci.setSu_or_name("取消");
				ci.setOrd_colligate(OrdPicStatusIndex.CANCEL.toString());
			} else if (ICiDictCodeConst.SD_SU_MP_CANCEL.equals(ci.getSd_su_mp())) {
				ci.setSu_or_name("不执行");
				ci.setOrd_colligate(OrdPicStatusIndex.NOTEXEC.toString());
			} else {
				ci.setSu_or_name("未知");
				ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
			}
			break;
		case ICiDictCodeConst.SD_SU_CANCEL:
			ci.setSu_or_name("作废");
			ci.setOrd_colligate(OrdPicStatusIndex.OBSOLETE.toString());
			break;
		case ICiDictCodeConst.SD_SU_CHECKCANCEL:
			ci.setSu_or_name("已作废");
			ci.setOrd_colligate(OrdPicStatusIndex.CANCELLED.toString());
			break;
		default:
			ci.setSu_or_name("未知");
			ci.setOrd_colligate(OrdPicStatusIndex.UNKNOW.toString());
			break;
		}

		if (IBdSrvDictCodeConst.SD_SRVTP_TREAT_SKINMINGANTEST.equals(ci.getSd_srvtp())) {
			ISkintestRService skinService = ServiceFinder.find(ISkintestRService.class);
			CiSkinTestRstDO[] szRstDO = skinService.find(String.format(" id_or='%s' ", ci.getId_or()), "",
					FBoolean.FALSE);
			if (szRstDO != null && szRstDO.length > 0) {
				String rstSkin = szRstDO[0].getSd_rst_skintest();
				if (StringUtils.isNullOrEmpty(rstSkin)) {
					ci.setResult("结果未出");
				} else {
					ci.setResult(szRstDO[0].getSkinres_name());
				}
			} else {
				ci.setResult("结果未出");
			}
		}
	}

	/**
	 * 获取服务类型字典信息
	 * 
	 * @return
	 * @throws BizException
	 */
	private FMap GetSdSrvtpDic() throws BizException {
		FMap sdSrvtpDic = new FMap();
		String condition = String.format(
				" id_udidoclist = '%s' and (length(code)=2 or code = '%s' or code = '%s' or code = '%s')",
				IBdSrvDictCodeTypeConst.ID_SRVTP, IBdSrvTpDictCodeConst.SD_SRVTP_WESTDRUG,
				IBdSrvTpDictCodeConst.SD_SRVTP_HERBDRUG, IBdSrvTpDictCodeConst.SD_SRVTP_BLOODPROD_PREPARE);
		UdidocDO[] udidocs = ServiceFinder.find(IUdidocRService.class).find(condition, null, FBoolean.FALSE);
		for (UdidocDO udidoc : udidocs) {
			sdSrvtpDic.put(udidoc.getCode(), udidoc.getCtrl2());
		}
		return sdSrvtpDic;
	}
}
