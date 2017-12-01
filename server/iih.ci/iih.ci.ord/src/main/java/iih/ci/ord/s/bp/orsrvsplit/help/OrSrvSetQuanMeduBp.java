package iih.ci.ord.s.bp.orsrvsplit.help;

import iih.bd.bc.udi.pub.ISysDictCodeConst;
import iih.ci.ord.dto.blexorder.d.SrvSplitOrderDTO;
import iih.ci.ord.s.bp.exception.CiOrSetQuanMeduException;
import xap.mw.core.data.BizException;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDouble;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.xbd.measdoc.d.MeasDocDO;
import xap.sys.xbd.measdoc.i.IMeasdocRService;

public class OrSrvSetQuanMeduBp {

	/**
	 * aways医嘱，根据 计量单位 转换 数值_医学单位
	 * 
	 * @return
	 * @throws BizException
	 */
	public void exec(SrvSplitOrderDTO srvsplitorder) throws BizException {

		// 1、数据合法性校验
		validationData(srvsplitorder);

		// 2、剂量单位量纲校验,返回校验成功和基本单位
		MeasDocDO[] meduDOS = validationMedu(srvsplitorder);

		// 3、计算
		figureMedu(meduDOS, srvsplitorder);
	}

	/**
	 * 数据合法性校验
	 * 
	 * @param srvsplitorder
	 * @throws CiOrSetQuanMeduException
	 */
	private void validationData(SrvSplitOrderDTO srvsplitorder) throws CiOrSetQuanMeduException {

		if (StringUtil.isEmpty(srvsplitorder.getId_medu())) {

			throw new CiOrSetQuanMeduException(srvsplitorder.getName_srv(), "医学单位空");
		}

		if (srvsplitorder.getQuan_medu().compareTo(FDouble.ZERO_DBL) < 0) {

			throw new CiOrSetQuanMeduException(srvsplitorder.getName_srv(), "医学数值小于0");
		}
	}

	/**
	 * 计量单位校验，是否属于时间量纲
	 * 
	 * @param srvsplitorder
	 * @throws BizException
	 */
	private MeasDocDO[] validationMedu(SrvSplitOrderDTO srvsplitorder) throws BizException {

		IMeasdocRService findService = ServiceFinder.find(IMeasdocRService.class);

		MeasDocDO[] measdocdos = findService.find(" a0.id_oppdimen='" + ISysDictCodeConst.ID_OPPDIMEN_T + "'", "", FBoolean.FALSE);

		if (measdocdos != null && measdocdos.length > 0) {

			return measdocdos;
		}

		throw new CiOrSetQuanMeduException(srvsplitorder.getName_srv(), "时间单位数据");
	}

	/**
	 * 单位换算
	 * 
	 * @return
	 */
	private void figureMedu(MeasDocDO[] meduDOS, SrvSplitOrderDTO srvsplitorder) throws BizException {

		// 基本单位
		MeasDocDO baseMeasdocDO = new MeasDocDO();
		// 当前服务的计量单位
		MeasDocDO orQuanMeduDO = new MeasDocDO();

		for (MeasDocDO measDocDO : meduDOS) {

			// 当前服务的计量单位
			if (measDocDO.getId_measdoc().equals(srvsplitorder.getId_medu())) {
				orQuanMeduDO = measDocDO;
			}

			// 基本单位
			if (measDocDO.getIsbasic().equals(FBoolean.TRUE)) {
				baseMeasdocDO = measDocDO;
			}
		}

		// 服务计量单位不属于“时间量纲”单位
		if (StringUtil.isEmpty(orQuanMeduDO.getId_measdoc())) {

			throw new CiOrSetQuanMeduException(srvsplitorder.getName_srv(), "医学单位");
		}

		// 换算系数校验
		if (orQuanMeduDO.getScalefactor().compareTo(FDouble.ZERO_DBL) < 0) {

			throw new CiOrSetQuanMeduException(srvsplitorder.getName_srv(), "换算系数");
		}

		// 基本单位为秒 前提条件：时间量纲里面秒为最细粒度单位，并且医嘱计算的Quan_medu单位为秒
		if (baseMeasdocDO.getId_measdoc().equals(ISysDictCodeConst.ID_MEASDOC_TIME_S)) {

			Double resQuan = srvsplitorder.getQuan_medu().getDouble() / orQuanMeduDO.getScalefactor().getDouble();

			// ??暂未处理四舍五入规则

			srvsplitorder.setQuan_medu(new FDouble(resQuan));

		} else {

			Double resQuan = srvsplitorder.getQuan_medu().getDouble() * baseMeasdocDO.getScalefactor().getDouble() / orQuanMeduDO.getScalefactor().getDouble();

			// ??暂未处理四舍五入规则

			srvsplitorder.setQuan_medu(new FDouble(resQuan));
		}
	}
}
