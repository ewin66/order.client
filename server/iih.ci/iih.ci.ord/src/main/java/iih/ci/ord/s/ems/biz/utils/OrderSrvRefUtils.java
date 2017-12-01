package iih.ci.ord.s.ems.biz.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.d.OrdSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.ems.d.UsageRelFeeSrvDO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.bp.ems.CiOrDtLastBlCal4OpenBP;
import iih.ci.ord.s.bp.quantum.CalQuantumBP;
import iih.ci.ord.s.bp.srvpri.CiOrSrvPriCalUtils;
import iih.en.pv.dto.d.Ent4BannerDTO;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;

/**
 * 用法关联和煎法关联工具类
 * @author wangqingzhu
 *
 */
public class OrderSrvRefUtils {
	/**
	 * 用法关联费用信息，用法为医嘱层次，因此传入医嘱CiOrderDO
	 * @param ctx 就诊上下文
	 * @param orderInfo 医嘱CiOrderDO
	 * @return
	 * @throws BizException
	 */
	public static OrdSrvDO[] RouteRelFeeSrvs(CiEnContextDTO ctx, CiOrderDO orderInfo) throws BizException{
		Ent4BannerDTO banner = ctx.getEnt4BannerDTO();
		UsageRelFeeSrvDO[] feeSrvDOs = CiOrdUtils.getPriUsgRelFeeSrvInfo(orderInfo.getId_route(), orderInfo.getId_org(),
				banner.getId_dep_nur());
		if(CiOrdUtils.isEmpty(feeSrvDOs)) 
			return null;
		List<String> relSrvIds = new ArrayList<String>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			relSrvIds.add(feeSrvDO.getId_srv());
		}
		MedSrvDO[] relMedSrvs = CiOrdAppUtils.getMedsrvMDORService().findByBIds(relSrvIds.toArray(new String[0]),
				FBoolean.FALSE);
		// 将服务信息放到hash表中，方便后续查询使用
		Map<String, MedSrvDO> medSrvMap = new HashMap<String, MedSrvDO>();
		for (MedSrvDO srv : relMedSrvs) {
			medSrvMap.put(srv.getId_srv(), srv);
		}
		// 组装用法关联的费用信息
		List<OrdSrvDO> ordSrvs = new ArrayList<OrdSrvDO>();
		for (UsageRelFeeSrvDO feeSrvDO : feeSrvDOs) {
			MedSrvDO medSrvDO = medSrvMap.get(feeSrvDO.getId_srv());
			OrdSrvDO srvdo = new OrdSrvDO();
			srvdo.setId_pat(banner.getId_pat());
			srvdo.setId_entp(banner.getId_entp());
			srvdo.setCode_entp(banner.getCode_entp());
			srvdo.setId_en(banner.getId_ent());
			srvdo.setId_srvtp(medSrvDO.getId_srvtp());
			srvdo.setSd_srvtp(medSrvDO.getSd_srvtp());
			srvdo.setId_srv(feeSrvDO.getId_srv());
			srvdo.setName(medSrvDO.getName());
			srvdo.setFg_dose_anoma(FBoolean.FALSE);
			// //2016-11-14 修正原有的剂量及剂量单位逻辑 下面6行原有的代码注释掉了
			// //要注意的是服务单价是以BD_SRV中的医学单位定义的****计算单价时要考虑两者的单位转换
			// 服务关联时，是定值时实际上是有两层含义（总量定值法、单次定值法）：我们目前情况下是指总量定值法
			if (CiOrdUtils.isTrue(feeSrvDO.getIsTotalQuanMd())) {// 2016-11-14
																	// 新增
																	// 服务关联总量模式的赋值逻辑
				srvdo.setQuan_medu(null);
				srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(feeSrvDO));
			} else {
				srvdo.setQuan_medu(CiOrdUtils.getQuan_Med4UsgRelFeeSrv(feeSrvDO)); // 2016-06-22修改
																					// //bdsrvdo.getQuan_med()
				srvdo.setId_medu(CiOrdUtils.getUnit4UsgRelFeeSrv(feeSrvDO));
			}
			srvdo.setId_route(medSrvDO.getId_route());
			srvdo.setId_routedes(medSrvDO.getId_routedes());
			srvdo.setId_boil(medSrvDO.getId_boil());
			srvdo.setId_boildes(medSrvDO.getId_boildes());

			srvdo.setId_org_srv(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_dep_srv(CiOrdAppUtils.getEnvContext().getDeptId());
			srvdo.setId_emp_srv(CiOrdAppUtils.getEnvContext().getUserId());
			srvdo.setDt_create(CiOrdAppUtils.getServerDateTime());
			srvdo.setId_org_mp(CiOrdUtils.getOrgOfDept(srvdo.getId_dep_mp()));
			srvdo.setId_su_mp(ICiDictCodeConst.SD_SU_MP_NONE_ID);
			srvdo.setSd_su_mp(ICiDictCodeConst.SD_SU_MP_NONE);
			srvdo.setId_su_bl(ICiDictCodeConst.SD_SU_BL_NONE_ID);
			srvdo.setSd_su_bl(ICiDictCodeConst.SD_SU_BL_NONE);
			CiOrDtLastBlCal4OpenBP bp = new CiOrDtLastBlCal4OpenBP();
			srvdo.setDt_last_bl(bp.exec(orderInfo.getId_freq(), orderInfo.getDt_effe(), orderInfo.getQuan_firday_mp(),
					orderInfo.getFg_long()));
			srvdo.setFg_or(FBoolean.FALSE);
			srvdo.setEu_blmd(medSrvDO.getEu_blmd()); // 本服务定价
			srvdo.setFg_mm(FBoolean.FALSE);
			srvdo.setFg_set(FBoolean.FALSE);
			srvdo.setFg_propc(FBoolean.FALSE);
			srvdo.setFg_self(FBoolean.FALSE);
			srvdo.setFg_pres_outp(FBoolean.FALSE);
			srvdo.setNote_srv("");
			srvdo.setId_srvca(medSrvDO.getId_srvca());
			srvdo.setFg_bl(CiOrdUtils.nullHandle(medSrvDO.getFg_bl()));
			srvdo.setCode_srv(medSrvDO.getCode());
			srvdo.setEu_sourcemd(CiOrdUtils.getRelType_Med4UsgRelFeeSrv(feeSrvDO));
			srvdo.setId_primd(medSrvDO.getId_primd());
			srvdo.setFg_selfsrv(medSrvDO.getFg_ctm());
			srvdo.setId_srv_src(orderInfo.getId_srv());
			srvdo.setId_org(CiOrdAppUtils.getEnvContext().getOrgId());
			srvdo.setId_grp(CiOrdAppUtils.getEnvContext().getGroupId());
			srvdo.setId_freq(orderInfo.getId_freq());
			srvdo.setSd_frequnitct(orderInfo.getSd_frequnitct());
			srvdo.setFreqct(orderInfo.getFreqct());
			srvdo.setFreq_name(orderInfo.getFreq_name());
			CalQuantumBP quantumUtils = new CalQuantumBP();
			srvdo.setQuan_total_medu(quantumUtils.getQuantum(srvdo.getQuan_medu(), orderInfo.getTimes_cur()));
			// 折扣价和折扣系数
			CiOrSrvPriCalUtils.mappingPriceRateFromEmsToSrv(orderInfo.getCode_entp(), srvdo.getId_srv(),
					srvdo.getId_primd(), srvdo);
			//执行科室赋值
			OrWfDeptInfoDTO wf = DeptInfoUtils.GetOrWfDeptInfo(ctx, srvdo.getId_srv(), srvdo.getSd_srvtp(), srvdo.getId_srvca(), srvdo.getId_route(), srvdo.getId_dep_mp(), orderInfo.getId_dep_mp());
			if (wf != null){
				srvdo.setId_dep_mp(wf.getFirstid_mp_dept());
				srvdo.setId_dep_wh(wf.getId_dept_wh());
			}
			srvdo.setFg_feertnable(FBoolean.TRUE);
			srvdo.setStatus(DOStatus.NEW);
			ordSrvs.add(srvdo);
		}
		return ordSrvs.toArray(new OrdSrvDO[0]);
	}
}
