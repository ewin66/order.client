package iih.ci.ord.s.bp.iemsg.reissue;

import java.util.HashMap;
import java.util.Map;

import iih.ci.ord.s.bp.iemsg.reissue.impl.IpLisReIssueServiceImpl;
import iih.ci.ord.s.bp.iemsg.reissue.impl.IpRisReIssueServiceImpl;
import iih.ci.ord.s.bp.iemsg.reissue.impl.OpLisReIssueServiceImpl;
import iih.ci.ord.s.bp.iemsg.reissue.impl.OpRisReIssueServiceImpl;

public class BizReIssueServiceFactory {

	// 检查
	private final static String BS002 = "BS002";
	// 检验
	private final static String BS006 = "BS006";

	// 集成平台中住院标识
	public final static String IP = "02";
	// 集成平台中门诊标识
	public final static String OP = "01";

	private static Map<String, IBizReIssueService> bizReIssueServiceMap = new HashMap<String, IBizReIssueService>();
	
	static {
		bizReIssueServiceMap.put(IP + BS002, new IpRisReIssueServiceImpl()); //住院检查
		bizReIssueServiceMap.put(IP + BS006, new IpLisReIssueServiceImpl()); //住院检验

		bizReIssueServiceMap.put(OP + BS002, new OpRisReIssueServiceImpl()); //门诊检查
		bizReIssueServiceMap.put(OP + BS006, new OpLisReIssueServiceImpl()); // 门诊检验
	};

	/**
	 * BS023Param 参数说明 ServiceId ：服务id，如检查BS002,检验BS006 DomainId : 域ID 门诊 01，住院 02 orderNo ：医嘱号 目前保持和申请单号使用同一个值 ApplyId
	 * : 申请单号 BarCode ：标本条码号 咱们iih中没有，不考虑 EncounterCardNo ： 就诊卡号 门诊--条码号，患者基本信息PI_PAT .CHIS条码号barcode_chis 住院--
	 * 住院号，患者基本信息PI_PAT .住院病案编号code_amr_ip HospitalCode ： 医院编码 HospitalName ： 医院名称
	 */

	/**
	 * 获取补发数据实现
	 * 
	 * @param serviceId 服务id，如检查BS002,检验BS006
	 * @param domainId 域ID 门诊 01，住院 02
	 * @return
	 */

	public static IBizReIssueService get(String serviceId, String domainId) {

		return bizReIssueServiceMap.get(domainId + serviceId);
	}

}
