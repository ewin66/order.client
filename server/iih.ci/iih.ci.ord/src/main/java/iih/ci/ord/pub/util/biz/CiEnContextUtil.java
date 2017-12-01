package iih.ci.ord.pub.util.biz;

import iih.ci.diag.cidiag.d.CiDiagItemDO;
import iih.ci.ord.ciorder.d.HpBeyondEnum;
import iih.ci.ord.ciorder.d.InHpBbrEnum;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.bdfw.bbd.i.IPsndocRService;
import xap.sys.orgfw.dept.d.DeptDO;
import xap.sys.orgfw.dept.i.IDeptRService;
import xap.sys.orgfw.group.d.GroupDO;
import xap.sys.orgfw.group.i.IGroupRService;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRService;
import xap.sys.permfw.user.d.UserDO;
import xap.sys.permfw.user.i.IUserRService;

/**
 * 医嘱助手获取当前环境属性
 * 
 * @author HUMS
 *
 */
public class CiEnContextUtil {

	// 获取系统换行符
	private final static String lineSeparator = System.getProperty("line.separator", "\n");

	/**
	 * 当前就诊banner相关属性
	 * 
	 * @param ent4BannerDTO
	 * @return
	 * @throws BizException
	 */
	public static CiEnContextDTO getCiEnContext(Ent4BannerDTO ent4BannerDTO) throws BizException {
		Context context = Context.get();

		CiEnContextDTO conetxtDTO = new CiEnContextDTO();
		// banner对象
		conetxtDTO.setEnt4BannerDTO(ent4BannerDTO);

		if (context != null) {
			conetxtDTO.setId_grp(context.getGroupId()); // 所属集团
			conetxtDTO.setId_org(context.getOrgId()); // 所属组织
			conetxtDTO.setId_dep_or(context.getDeptId()); // 开立科室
			conetxtDTO.setId_emp_or(context.getUserId());// =
															// context.PsnInfo.Id_psndoc;
															// // 开立医生
		}

		// conetxtDTO.Emsappmode = (int)emsAppModeEnum; // 医疗单应用场景

		conetxtDTO.setId_entp(ent4BannerDTO.getId_entp()); // 就诊类型id
		conetxtDTO.setCode_entp(ent4BannerDTO.getCode_entp()); // 就诊类型编码
		conetxtDTO.setId_pat(ent4BannerDTO.getId_pat()); // 患者
		conetxtDTO.setId_en(ent4BannerDTO.getId_ent()); // 就诊
		conetxtDTO.setId_hp(ent4BannerDTO.getId_hp()); // 主医保数据
		conetxtDTO.setId_dep_en(ent4BannerDTO.getId_dep_phy()); // 当前就诊科室

		conetxtDTO.setId_dep_ns(ent4BannerDTO.getId_dep_nur()); // 当前就诊病区

		conetxtDTO.setId_wg_or(ent4BannerDTO.getId_wg_phy()); // TODO 开立医疗组
		conetxtDTO.setFg_bb(ent4BannerDTO.getFg_newborn()); // 婴儿标识
		conetxtDTO.setNo_bb(ent4BannerDTO.getNum_newborn()); // 婴儿序号
		// ent4BannerDTO.Cp_status临床路径标识，1 在径 0 不在径
		conetxtDTO.setFg_cp("1".equals(ent4BannerDTO.getCp_status()) ? FBoolean.TRUE : FBoolean.FALSE); // 患者入径标识
		conetxtDTO.setFg_hpfundpay(ent4BannerDTO.getFg_hpfundpay());// 本次就诊是否为医保就诊

		// 获取部门对象接口
		IDeptRService deptRService = CiOrdAppUtils.getDeptQryService();
		DeptDO dept = deptRService.findById(conetxtDTO.getId_dep_en());
		conetxtDTO.setDept(dept);

		// 获取组织对象接口
		IOrgRService orgRService = (IOrgRService) ServiceFinder.find(IOrgRService.class);
		OrgDO org = orgRService.findById(dept.getId_org());
		conetxtDTO.setOrg(org);

		// 获取集团对象接口
		IGroupRService groupRService = (IGroupRService) ServiceFinder.find(IGroupRService.class);
		GroupDO group = groupRService.findById(org.getId_grp());
		conetxtDTO.setGroup(group);

		IPsndocRService psndocRService = (IPsndocRService) ServiceFinder.find(IPsndocRService.class);
		//CiAppUtils.
		//PsndocAggDO psnInfo = psndocRService.findById("");

		IPsndocMDORService psndocMDORService = CiOrdAppUtils.getPsnDocQryService();
		//PsnDocDO d = psndocMDORService.findById("");
		//conetxtDTO.setPsnInfo(PsnInfo);

		// 用户
		IUserRService userRService = CiOrdAppUtils.getUserQryService();
		UserDO user = userRService.findById("");
		conetxtDTO.setUser(user);

		if (ent4BannerDTO.getFg_hpfundpay() == FBoolean.TRUE) {
			// 如果本次是医保就诊
			if (ent4BannerDTO.getFg_inhpbbr() == FBoolean.TRUE) {
				conetxtDTO.setEu_inhpbbr(InHpBbrEnum.BLACKLIST); // 黑名单
			} else {
				conetxtDTO.setEu_inhpbbr(InHpBbrEnum.WHITELIST); // 白名单
			}
			// 如果本次就诊未医保就诊先将属性先设置为保内诊断，具体保内还是保外诊断，需要根据诊断的保外诊断属性判断
			conetxtDTO.setEu_hpbeyond(HpBeyondEnum.HPDIAG);
		} else {
			// 本次就诊为非医保就诊时，黑名单状态为9 ，如果医保就诊时 1 为黑名单，0 白名单
			conetxtDTO.setEu_inhpbbr(InHpBbrEnum.NONMEDICARE);
			// 本次就诊为非医保就诊时，保外诊断状态为9 ，如果医保就诊时 1 为保外诊断，0保内诊断
			conetxtDTO.setEu_hpbeyond(HpBeyondEnum.NONMEDICARE);
		}
		// 基本医保判断结果数据信息
		String bhpjudgerst = (conetxtDTO.getFg_hpfundpay() == FBoolean.TRUE ? "1" : "0") + conetxtDTO.getEu_inhpbbr()
				+ conetxtDTO.getEu_hpbeyond();
		conetxtDTO.setBhpjudgerst(bhpjudgerst);

		return conetxtDTO;
	}

	/**
	 * 根据就诊信息获取CiEnContextDTO对象
	 * 
	 * @param ent4BannerDTO banner对象
	 * @param emsAppMode EmsAppModeEnum对应的值
	 * @return
	 * @throws BizException
	 */
	public static CiEnContextDTO getCiEnContext(Ent4BannerDTO ent4BannerDTO, Integer emsAppMode) throws BizException {

		CiEnContextDTO conetxtDTO = getCiEnContext(ent4BannerDTO);
		conetxtDTO.setEmsappmode(emsAppMode); // 医疗单应用场景
		return conetxtDTO;
	}

	/**
	 * 设置保外诊断相关属性
	 * 
	 * @param conetxtDTO
	 * @param ciDiagItems
	 */
	public static void SetHpCiDiagItem(CiEnContextDTO conetxtDTO, CiDiagItemDO[] ciDiagItems) {

		// 如果非医保就诊，或者不存在保外诊断不设置CiEnContextDTO中保外诊断相关属性
		if (conetxtDTO.getFg_hpfundpay() != FBoolean.TRUE || ciDiagItems == null || ciDiagItems.length == 0) {
			return;
		}

		// 保外诊断集合
		StringBuffer buffer = new StringBuffer();

		for (CiDiagItemDO ciDiagItem : ciDiagItems) {
			// 存在保外诊断时，将conetxtDTO保外诊断属性设置为1，并拼接保外诊断id
			if (HpBeyondEnum.HPEXTERNALDIAG.equals(ciDiagItem.getEu_hpbeyond())) {
				conetxtDTO.setEu_hpbeyond(HpBeyondEnum.HPEXTERNALDIAG);
				buffer.append("," + ciDiagItem.getId_didef());
			}
		}

		// 基本医保判断结果数据信息
		String bhpjudgerst = (conetxtDTO.getFg_hpfundpay() == FBoolean.TRUE ? "1" : "0") + conetxtDTO.getEu_inhpbbr()
				+ conetxtDTO.getEu_hpbeyond();
		conetxtDTO.setBhpjudgerst(bhpjudgerst);
		// 设置保外诊断id_didef拼接串
		if (buffer.length() > 0) {
			conetxtDTO.setDes_bhpjudgerst(buffer.substring(1));
		}
	}

	/**
	 * 校验就诊上下文环境属性是否完整
	 * 
	 * @param ciEnContext 就诊上下文环境
	 * @return 校验是失败信息，返回值为空校验通过
	 */
	public static String validateCiEnContext(CiEnContextDTO ciEnContext) {

		StringBuffer errorMsgBuffer = new StringBuffer();
		if (ciEnContext == null) {
			errorMsgBuffer.append("上下文就诊环境CiEnContext不能为空！");
			return errorMsgBuffer.toString();
		}

		if (StringUtils.isEmpty(ciEnContext.getId_en())) {
			errorMsgBuffer.append("就诊信息不能为空").append(lineSeparator);
		}

		if (ciEnContext.getEmsappmode() == null) {
			errorMsgBuffer.append("医疗单使用场景不能为空").append(lineSeparator);
		}
		if (StringUtils.isEmpty(ciEnContext.getEu_orsrcmdtp())) {
			errorMsgBuffer.append("医嘱数据来源不能为空").append(lineSeparator);
		}

		return errorMsgBuffer.toString();
	}

	/**
	 * 判断当前患者是否为医保就诊患者
	 * @param ent4BannerDTO 当前患者就诊banner对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean IsHpPat(Ent4BannerDTO ent4BannerDTO) {

		// 有医保计划，并且医保类型为社保，并且是医保基金支付标识（持卡）才确认是社保
		if (ent4BannerDTO != null && StringUtils.isNotEmpty(ent4BannerDTO.getId_hp())
				&& StringUtils.isNotEmpty(ent4BannerDTO.getSd_hptp()) && ent4BannerDTO.getSd_hptp().startsWith("1")
				&& ent4BannerDTO.getFg_hpfundpay() == FBoolean.TRUE) {
			return true;
		}

		return false;
	}
	
	/**
	 * 判断当前患者是否为医保就诊患者
	 * @param CiEnContextDTO 当前患者就诊环境对象
	 * @return true 医保就诊， false 非医保就诊
	 */
	public static boolean IsHpPat(CiEnContextDTO ctx) {
		
		Ent4BannerDTO ent4Banner = ctx.getEnt4BannerDTO();
		return IsHpPat(ent4Banner);
	}

	/**
	 * 高端商保用户
	 * @param ent4BannerDTO
	 * @return true 高端商保 false 非高端商保
	 */
	public static boolean isHeComInsurPat(Ent4BannerDTO ent4BannerDTO) {

		// 有医保计划，并且医保类型为高端商保，可以保记账标志
		if (ent4BannerDTO != null && StringUtils.isNotEmpty(ent4BannerDTO.getId_hp())
				&& StringUtils.isNotEmpty(ent4BannerDTO.getSd_hptp()) && ent4BannerDTO.getSd_hptp().startsWith("2")) {
			return true;
		}

		return false;
	}
	
	/**
	 * 商业保险用户
	 * @param Id_hp 医保计划
	 * @param Sd_hptp 医保类型
	 * @return true 商业保险 false 非商业保险
	 */
	public static boolean isHeComInsurPat(String Id_hp,String Sd_hptp) {

		// 有医保计划，并且医保类型为高端商保，可以保记账标志
		if (StringUtils.isNotEmpty(Id_hp)
				&& StringUtils.isNotEmpty(Sd_hptp) && Sd_hptp.startsWith("2")) {
			return true;
		}

		return false;
	}

	/**
	 * 商保用户（可医保记账）
	 * @param ent4BannerDTO
	 * @return true 高端商保持卡， false 非持卡
	 */
	public static boolean IsHeComInsurAllowedAccountPat(Ent4BannerDTO ent4BannerDTO) {
		// 商保用户 并且 可医保记账
		if (isHeComInsurPat(ent4BannerDTO) && ent4BannerDTO.getFg_hpcg() == FBoolean.TRUE) {
			return true;
		}

		return false;
	}
	
	/**
	 * 商保用户（不允许医保记账，需要个人支付）
	 * @param ent4BannerDTO
	 * @return true 高端商保非持卡
	 */
	public static boolean IsHeComInsurRefuseAccountPat(Ent4BannerDTO ent4BannerDTO) {
		// 商保用户 并且 不允许医保记账
		if (isHeComInsurPat(ent4BannerDTO) && ent4BannerDTO.getFg_hpcg() != FBoolean.TRUE) {
			return true;
		}

		return false;
	}
}
