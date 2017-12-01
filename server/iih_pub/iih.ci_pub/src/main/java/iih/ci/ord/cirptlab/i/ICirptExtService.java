package iih.ci.ord.cirptlab.i;

import xap.mw.core.data.BizException;
import iih.ci.ord.cirptlab.d.CirptlabAggDO;
import iih.ci.ord.cirptobs.d.CiRptObsDO;
import iih.ci.ord.cirptpathgy.d.CiRptPathgyDO;

/**
 * @author 作者 :huang_junhao
 * @version 创建时间：2016年11月18日 下午7:54:57
 * 类说明：检查、检验结果录入
 */
public interface ICirptExtService {

	/**
	 * 检查报告结果录入
	 * @param ciRptObsDOs
	 * @return
	 * @throws BizException
	 */
	public abstract CiRptObsDO[] saveCiRptObsDO(CiRptObsDO[] ciRptObsDOs) throws BizException;
	
	/**
	 * 检验报告结果录入
	 * @param cirptlabAggDOs
	 * @return
	 * @throws BizException
	 */
	public abstract CirptlabAggDO saveCirptlabAggDO(CirptlabAggDO cirptlabAggDOs) throws BizException;
	
	/**
	 * 病理报告结果录入
	 * @param pathgyDOs
	 * @return
	 * @throws BizException
	 */
	public abstract CiRptPathgyDO[] saveCiRptPathgyDO(CiRptPathgyDO[] pathgyDOs) throws BizException;
}
