package iih.ci.ord.s.bp.reportstatus;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeTypeConst;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDOCudService;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.ci.ord.cirptlab.d.CiRptLabDO;
import iih.ci.ord.cirptlab.i.ICirptlabMDOCudService;
import iih.ci.ord.cirptlab.i.ICirptlabMDORService;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptobs.i.ICirptobsCudService;
import iih.ci.ord.cirptobs.i.ICirptobsRService;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyCudService;
import iih.ci.ord.cirptpathgy.i.ICirptpathgyRService;
import iih.ci.ord.dto.reportstatus.d.EnumRptTp;
import iih.ci.ord.dto.reportstatus.d.ReportStatusDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.udi.d.UdidocDO;
import xap.sys.xbd.udi.i.IUdidocRService;

/**
 * 更新报告状态
 * 
 * @author xuxing_2016-11-18
 *
 */
public class UpdateReportStatusBp {

	/**
	 * 主入口
	 */
	public void exec(ReportStatusDTO[] params) throws BizException {

		// 1、基础验证，获取医嘱ID集合
		List<String> listOrs = new ArrayList<String>();
		if (!validation(params, listOrs)) {
			return;
		}

		// 2、获取医嘱对象
		HashMap<String, CiOrderDO> orderMap = getOrders(listOrs);

		// 3、获取医嘱结果字典
		initOrderStatusDic();

		// 4、设置检查报告单状态
		CiRptObsDO[] obsDOS = setRtpObsStatus(params, orderMap);

		// 5、设置检验报告单状态
		CiRptLabDO[] labDOS = setRtpLabStatus(params, orderMap);

		// 6、设置病理报告单状态
		CiRptPathgyDO[] pathgyDOS = setRptPathgyStatus(params, orderMap);
		
		// 6、更新操作
		update(obsDOS, labDOS,pathgyDOS, orderMap);
	}


	/**
	 * 基础验证
	 * 
	 * @param params
	 * @param listOrs
	 * @return
	 * @throws BizException
	 */
	private boolean validation(ReportStatusDTO[] params, List<String> listOrs) throws BizException {

		if (params == null || params.length < 1) {
			return false;
		}

		for (ReportStatusDTO param : params) {

			if (StringUtil.isEmptyWithTrim(param.getId_or())) {
				throw new BizException("更改报告状态：医嘱ID空异常！");
			}

			if (StringUtil.isEmptyWithTrim(param.getRpt_status())) {
				throw new BizException("更改报告状态：报告状态空异常！");
			}

			if (param.getRpt_tp() == null) {
				throw new BizException("更改报告状态：报告类型空异常！");
			}

			if (listOrs.contains(param.getId_or())) {
				throw new BizException("更改报告状态：医嘱项目重复异常！");
			} else {
				listOrs.add(param.getId_or());
			}
		}

		return true;
	}

	/**
	 * 获取医嘱对象
	 * 
	 * @param listOrs
	 * @return
	 * @throws BizException
	 */
	private HashMap<String, CiOrderDO> getOrders(List<String> listOrs) throws BizException {

		HashMap<String, CiOrderDO> reMap = new HashMap<String, CiOrderDO>();

		ICiorderMDORService findService = ServiceFinder.find(ICiorderMDORService.class);

		CiOrderDO[] orders = findService.findByIds(listOrs.toArray(new String[listOrs.size()]), FBoolean.FALSE);

		if (orders != null && orders.length > 0) {

			for (CiOrderDO order : orders) {

				reMap.put(order.getId_or(), order);
			}
		}
		return reMap;
	}

	/**
	 * 获取医嘱结果字典
	 * 
	 * @return
	 * @throws BizException
	 */
	private List<UdidocDO> listOrderResult;
	private List<UdidocDO> listObsDoc;
	private List<UdidocDO> listLabDoc;
	private List<UdidocDO> listPathgyDoc;
	
	private void initOrderStatusDic() throws BizException {

		IUdidocRService findService = ServiceFinder.find(IUdidocRService.class);

		listOrderResult = new ArrayList<UdidocDO>();
		listObsDoc = new ArrayList<UdidocDO>();
		listLabDoc = new ArrayList<UdidocDO>();
		listPathgyDoc = new ArrayList<UdidocDO>();
		
		List<String> list = new ArrayList<String>();
		list.add(ICiDictCodeTypeConst.SD_ORRSTTP);
		list.add(ICiDictCodeTypeConst.SD_SU_OBSRPT);
		list.add(ICiDictCodeTypeConst.SD_SU_LABRPT);
		list.add(ICiDictCodeTypeConst.SD_SU_PATHGYRPT);

		UdidocDO[] rtn = findService.findByAttrValStrings(UdidocDO.ID_UDIDOCLIST, list.toArray(new String[list.size()]));

		for (UdidocDO doc : rtn) {

			switch (doc.getId_udidoclist()) {

			case ICiDictCodeTypeConst.SD_ORRSTTP:
				listOrderResult.add(doc);
				break;
			case ICiDictCodeTypeConst.SD_SU_OBSRPT:
				listObsDoc.add(doc);
				break;
			case ICiDictCodeTypeConst.SD_SU_LABRPT:
				listLabDoc.add(doc);
				break;
			case ICiDictCodeTypeConst.SD_SU_PATHGYRPT:
				listPathgyDoc.add(doc);
				break;
			}
		}
	}

	/**
	 * 根据指定类型获取医嘱ID集合
	 * 
	 * @param params
	 * @param rptTp
	 * @return
	 */
	private String[] getOrByRptTp(ReportStatusDTO[] params, Integer rptTp) {

		List<String> reList = new ArrayList<>();

		for (ReportStatusDTO param : params) {

			if (rptTp.equals(param.getRpt_tp())) {

				reList.add(param.getId_or());
			}
		}
		return reList.toArray(new String[reList.size()]);
	}

	/**
	 * 设置检查报告状态
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private CiRptObsDO[] setRtpObsStatus(ReportStatusDTO[] params, HashMap<String, CiOrderDO> orderMap) throws BizException {

		List<CiRptObsDO> reList = new ArrayList<CiRptObsDO>();

		String[] idOrs = getOrByRptTp(params, EnumRptTp.RPTOBS);

		if (idOrs != null && idOrs.length > 0) {

			ICirptobsRService findServcice = ServiceFinder.find(ICirptobsRService.class);

			CiRptObsDO[] rtns = findServcice.findByAttrValStrings(CiRptObsDO.ID_OR, idOrs);

			if (rtns != null && rtns.length > 0) {

				for (CiRptObsDO obs : rtns) {

					// 取出医嘱DO
					CiOrderDO order = orderMap.get(obs.getId_or());

					// 取出相应参数
					ReportStatusDTO param = getParamByOr(params, obs.getId_or());

					// 检验对应的医嘱状态
					UdidocDO orderStatus = setOrderStatus(order, param);

					// 报告单状态
					UdidocDO reportStatus = getReportStatus(param.getRpt_status(), ICiDictCodeTypeConst.SD_SU_OBSRPT);

					if (reportStatus != null) {

						obs.setId_su(reportStatus.getId_udidoc());
						obs.setSd_su(reportStatus.getCode());
						obs.setStatus(DOStatus.UPDATED);

					} else {
						throw new BizException("更新报告状态：未找到报告状态【" + param.getRpt_status() + "】！");
					}

					if (orderStatus != null) {

						order.setId_orrsttp(orderStatus.getId_udidoc());
						order.setSd_orrsttp(orderStatus.getCode());
						order.setStatus(DOStatus.UPDATED);

					} else {
						throw new BizException("更新报告状态：未找到医嘱【" + obs.getId_or() + "】在报告状态【" + param.getRpt_status() + "】下对应的医嘱结果！");
					}
					
					reList.add(obs);
				}
			}
		}

		return reList.toArray(new CiRptObsDO[reList.size()]);
	}

	/**
	 * 设置检验报告状态
	 * 
	 * @param params
	 * @return
	 * @throws BizException
	 */
	private CiRptLabDO[] setRtpLabStatus(ReportStatusDTO[] params, HashMap<String, CiOrderDO> orderMap) throws BizException {

		List<CiRptLabDO> reList = new ArrayList<CiRptLabDO>();

		String[] idOrs = getOrByRptTp(params, EnumRptTp.RPTLAB);

		if (idOrs != null && idOrs.length > 0) {

			ICirptlabMDORService findServcice = ServiceFinder.find(ICirptlabMDORService.class);

			CiRptLabDO[] rtns = findServcice.findByAttrValStrings(CiRptLabDO.ID_OR, idOrs);

			if (rtns != null && rtns.length > 0) {

				for (CiRptLabDO lab : rtns) {

					// 取出医嘱DO
					CiOrderDO order = orderMap.get(lab.getId_or());

					// 取出相应参数
					ReportStatusDTO param = getParamByOr(params, lab.getId_or());

					// 检验对应的医嘱状态
					UdidocDO orderStatus = setOrderStatus(order, param);

					// 报告单状态
					UdidocDO reportStatus = getReportStatus(param.getRpt_status(), ICiDictCodeTypeConst.SD_SU_LABRPT);

					if (reportStatus != null) {

						lab.setId_su_lab(reportStatus.getId_udidoc());
						lab.setSd_su_lab(reportStatus.getCode());
						lab.setStatus(DOStatus.UPDATED);

					} else {
						throw new BizException("更新报告状态：未找到报告状态【" + param.getRpt_status() + "】！");
					}

					if (orderStatus != null) {

						order.setId_orrsttp(orderStatus.getId_udidoc());
						order.setSd_orrsttp(orderStatus.getCode());
						order.setStatus(DOStatus.UPDATED);
						

					} else {
						throw new BizException("更新报告状态：未找到医嘱【" + lab.getId_or() + "】在报告状态【" + param.getRpt_status() + "】下对应的医嘱结果！");
					}
					
					reList.add(lab);
				}
			}
		}

		return reList.toArray(new CiRptLabDO[reList.size()]);
	}

	/**
	 * 设置病理报告状态
	 * @param params
	 * @param orderMap
	 * @return
	 * @throws BizException
	 */
	private CiRptPathgyDO[] setRptPathgyStatus(ReportStatusDTO[] params, HashMap<String, CiOrderDO> orderMap) throws BizException {

		List<CiRptPathgyDO> reList = new ArrayList<CiRptPathgyDO>();

		String[] idOrs = getOrByRptTp(params, EnumRptTp.RPTPATHGY);

		if (idOrs != null && idOrs.length > 0) {

			ICirptpathgyRService findServcice = ServiceFinder.find(ICirptpathgyRService.class);

			CiRptPathgyDO[] rtns = findServcice.findByAttrValStrings(CiRptPathgyDO.ID_OR, idOrs);

			if (rtns != null && rtns.length > 0) {

				for (CiRptPathgyDO pathgy : rtns) {

					// 取出医嘱DO
					CiOrderDO order = orderMap.get(pathgy.getId_or());

					// 取出相应参数
					ReportStatusDTO param = getParamByOr(params, pathgy.getId_or());

					// 检验对应的医嘱状态
					UdidocDO orderStatus = setOrderStatus(order, param);

					// 报告单状态
					UdidocDO reportStatus = getReportStatus(param.getRpt_status(), ICiDictCodeTypeConst.SD_SU_PATHGYRPT);

					if (reportStatus != null) {

						pathgy.setId_su_rpt(reportStatus.getId_udidoc());
						pathgy.setSd_su_rpt(reportStatus.getCode());
						pathgy.setStatus(DOStatus.UPDATED);

					} else {
						throw new BizException("更新报告状态：未找到报告状态【" + param.getRpt_status() + "】！");
					}

					if (orderStatus != null) {

						order.setId_orrsttp(orderStatus.getId_udidoc());
						order.setSd_orrsttp(orderStatus.getCode());
						order.setStatus(DOStatus.UPDATED);
						

					} else {
						throw new BizException("更新报告状态：未找到医嘱【" + pathgy.getId_or() + "】在报告状态【" + param.getRpt_status() + "】下对应的医嘱结果！");
					}
					
					reList.add(pathgy);
				}
			}
		}

		return reList.toArray(new CiRptPathgyDO[reList.size()]);
	}
	
	/**
	 * 根据医嘱ID取参数
	 * 
	 * @param params
	 * @param id_or
	 * @return
	 */
	private ReportStatusDTO getParamByOr(ReportStatusDTO[] params, String id_or) {

		for (ReportStatusDTO param : params) {

			if (id_or.equals(param.getId_or())) {

				return param;
			}
		}

		return null;
	}

	/**
	 * 检查检验对应不同的状态
	 * 
	 * @param order
	 * @param param
	 * @param orderResDic
	 * @return
	 */
	private UdidocDO setOrderStatus(CiOrderDO order, ReportStatusDTO param) {

		String attr = "";

		// 检查检验对应取不同的扩展你字段
		if (order.getSd_srvtp().indexOf(IBdSrvDictCodeConst.SD_SRVTP_RIS) ==0) {
			attr = UdidocDO.CTRL1;
		}
		if (order.getSd_srvtp().indexOf(IBdSrvDictCodeConst.SD_SRVTP_LIS) ==0) {
			attr = UdidocDO.CTRL2;
		}

		for (UdidocDO doc : listOrderResult) {

			for (String status : (doc.getAttrVal(attr) + "").split(",")) {

				if (status.equals(param.getRpt_status())) {
					return doc;
				}
			}
		}

		return null;
	}

	/**
	 * 获取报告对应状态
	 * 
	 * @param rptStatus
	 * @param docList
	 * @return
	 */
	private UdidocDO getReportStatus(String rptStatus, String docList) {

		if (ICiDictCodeTypeConst.SD_SU_OBSRPT.equals(docList)) {

			for (UdidocDO udidocDO : listObsDoc) {

				if (rptStatus.equals(udidocDO.getCode())) {

					return udidocDO;
				}
			}
		}

		if (ICiDictCodeTypeConst.SD_SU_LABRPT.equals(docList)) {

			for (UdidocDO udidocDO : listLabDoc) {

				if (rptStatus.equals(udidocDO.getCode())) {

					return udidocDO;
				}
			}
		}

		if (ICiDictCodeTypeConst.SD_SU_PATHGYRPT.equals(docList)) {

			for (UdidocDO udidocDO : listPathgyDoc) {

				if (rptStatus.equals(udidocDO.getCode())) {

					return udidocDO;
				}
			}
		}
		
		return null;
	}

	/**
	 * 更新操作
	 * @param pathgyDOS 
	 * 
	 * @throws BizException
	 */
	@SuppressWarnings("rawtypes")
	private void update(CiRptObsDO[] obsDOS, CiRptLabDO[] labDOS, CiRptPathgyDO[] pathgyDOS, HashMap<String, CiOrderDO> orderMap) throws BizException {

		if (obsDOS != null && obsDOS.length > 0) {

			ICirptobsCudService obsSaveService = ServiceFinder.find(ICirptobsCudService.class);
			obsSaveService.save(obsDOS);
		}

		if (labDOS != null && labDOS.length > 0) {

			ICirptlabMDOCudService labSaveService = ServiceFinder.find(ICirptlabMDOCudService.class);
			labSaveService.save(labDOS);
		}

		if (pathgyDOS != null && pathgyDOS.length > 0) {

			ICirptpathgyCudService labSaveService = ServiceFinder.find(ICirptpathgyCudService.class);
			labSaveService.save(pathgyDOS);
		}

		
		if (orderMap.size() > 0) {

			ICiorderMDOCudService orderSaveService = ServiceFinder.find(ICiorderMDOCudService.class);
			List<CiOrderDO> listOrder = new ArrayList<CiOrderDO>();

			Iterator iter = orderMap.entrySet().iterator();

			while (iter.hasNext()) {

				Map.Entry entry = (Map.Entry) iter.next();

				listOrder.add((CiOrderDO) entry.getValue());
			}
			orderSaveService.save(listOrder.toArray(new CiOrderDO[listOrder.size()]));
		}
	}
}
