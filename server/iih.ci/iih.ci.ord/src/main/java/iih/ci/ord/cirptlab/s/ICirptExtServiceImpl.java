package iih.ci.ord.cirptlab.s;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptlab.i.ICirptExtService;
import iih.ci.ord.cirptlab.s.bp.SaveCiRptObsDOBp;
import iih.ci.ord.cirptlab.s.bp.SaveCiRptPathgyDOBp;
import iih.ci.ord.cirptlab.s.bp.SaveCirptlabAggDOBp;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年11月18日 下午8:06:26
 * 类说明：检查、检验报告结果录入
 */
public class ICirptExtServiceImpl implements ICirptExtService {

	/**
	 * 检查报告结果录入
	 */
	@Override
	public CiRptObsDO[] saveCiRptObsDO(CiRptObsDO[] ciRptObsDOs) throws BizException {
		
		return new SaveCiRptObsDOBp().exec(ciRptObsDOs);
	}

	/**
	 * 检验报告结果录入
	 */
	@Override
	public CirptlabAggDO saveCirptlabAggDO(CirptlabAggDO cirptlabAggDOs) throws BizException {
		
		return new SaveCirptlabAggDOBp().exec(cirptlabAggDOs);
	}

	/**
	 * 病理报告结果录入
	 */
	@Override
	public CiRptPathgyDO[] saveCiRptPathgyDO(CiRptPathgyDO[] pathgyDOs) throws BizException {
		
		return new SaveCiRptPathgyDOBp().exec(pathgyDOs);
	}

}
