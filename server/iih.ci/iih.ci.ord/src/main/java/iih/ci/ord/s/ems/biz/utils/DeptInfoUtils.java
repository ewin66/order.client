package iih.ci.ord.s.ems.biz.utils;

import iih.bd.base.cache.CacheContext;
import iih.bd.base.cache.CacheKeyUtils;
import iih.bd.fc.orwf.d.OrWfExDeptParamDTO;
import iih.bd.fc.wf.d.EnumFlow;
import iih.bd.srv.medsrv.d.MedSrvDO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.emsdi.d.OrWfDeptInfoDTO;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.s.CiOrdQryServiceImpl;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FTime;

public class DeptInfoUtils extends CacheContext {
	private static DeptInfoUtils ins;
	static{
		ins = new DeptInfoUtils();
	}
	/**
	 * 获取医嘱流向科室数据
	 * 
	 * @param code_entp
	 *            就诊类型
	 * @param sd_srvtp
	 *            服务类型sd
	 * @param id_srvCa
	 *            服务分类
	 * @param id_srv
	 *            服务
	 * @param id_route
	 *            用法
	 * @param id_mm
	 *            服务选取的关联物品
	 * @param id_dept_crt
	 *            开单科室
	 * @param id_dept_nur
	 *            就诊护理病区
	 * @param id_dep_ent
	 *            就诊科室
	 * @param id_dep_follow
	 *            主服务执行科室--用于跟随情况
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(String code_entp, String sd_srvtp, String id_srvCa, String id_srv,
			String id_route, String id_mm, String id_dept_crt, String id_dept_nur, String id_dep_ent,
			String id_dep_follow) throws BizException {

		OrWfExDeptParamDTO dto = new OrWfExDeptParamDTO();
		dto.setEu_wftp(EnumFlow.NULL); // 0执行与物资 1执行科室 2物资流向
		dto.setCode_entp(code_entp); // 就诊类型
		dto.setId_dept_ns(id_dept_nur); // 就诊护理病区
		dto.setId_dept_or(id_dept_crt);// 开单科室
		dto.setId_dept_en(id_dep_ent); // 就诊科室
		// dto.Recurstr = ""; //长临需要的 不知道 就为空
		dto.setId_srv(id_srv); // 服务
		dto.setSd_srvtp(sd_srvtp); // 服务类型sd
		dto.setId_srvca(id_srvCa);// 服务分类
		dto.setId_dept_ex(id_dep_follow); // 主服务执行科室--用于跟随情况
		// dto.Innercode_srvca = "";//服务分类内码
		dto.setId_mm(id_mm); // 服务选取的关联物品
		dto.setId_usage(id_route); // 用法
		// dto.Weekno = "2";//生效日期时间相关的 周#与时间
		dto.setTimestr(new FTime());
		// dto.Reserv1 = ""; //暂时无用途 //预留项
		// dto.Reserv2 = ""; //暂时无用途
		// dto.Reserv3 = ""; //套内项目时：
		// BD套内项目的科室计算方式sd值,BD套内项目的固定执行科室ID值,所属套的执行科室ID值
		return new CiOrdQryServiceImpl().getExeDepts4CiOrSrvN(dto);
	}

	/**
	 * 获取执行科室
	 * 
	 * @param ctx
	 * @param medSrv
	 * @param id_mm
	 * @param id_dep_main
	 * @return
	 * @throws BizException
	 */
	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, MedSrvDO medSrv, String id_mm, String id_dep_main)
			throws BizException {
		OrWfDeptInfoDTO obj = null;
		String Key_Dept_Cache = String.format("%s-%s-%s-%s-%s-%s-%s", 
				medSrv.getId_srv(),
				CiOrdUtils.isEmpty(id_mm) ? "NULL_MM" : id_mm,
				medSrv.getId_route() == null ? "NULL_ROUTE" : medSrv.getId_route(), 
				ctx.getId_dep_or(),
				ctx.getId_dep_ns(), 
				ctx.getId_dep_en(),
				CiOrdUtils.isEmpty(id_dep_main) ? "NULL_DEP_MAINSRV" : id_dep_main);
		//
		if (ins.isHitCahce(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()), Key_Dept_Cache)) {
			obj = ins.getCache(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()),
					Key_Dept_Cache);
		} else {
			obj = GetOrWfDeptInfo(ctx.getCode_entp(), medSrv.getSd_srvtp(), medSrv.getId_srvca(), medSrv.getId_srv(),
					medSrv.getId_route(), id_mm, ctx.getId_dep_or(), ctx.getId_dep_ns(), ctx.getId_dep_en(),
					id_dep_main);
			ins.putCache(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()), Key_Dept_Cache, obj);
		}
		return obj;
	}

	public static OrWfDeptInfoDTO GetOrWfDeptInfo(CiEnContextDTO ctx, String id_srv, String sd_srvtp, String id_srvca,
			String id_route, String id_mm, String id_dep_main) throws BizException {
		OrWfDeptInfoDTO obj = null;
		String Key_Dept_Cache = String.format("%s-%s-%s-%s-%s-%s-%s", 
				id_srv,
				CiOrdUtils.isEmpty(id_mm) ? "NULL_MM" : id_mm, 
				CiOrdUtils.isEmpty(id_route) ? "NULL_ROUTE" : id_route,
				ctx.getId_dep_or(), 
				ctx.getId_dep_ns(), 
				ctx.getId_dep_en(),
				CiOrdUtils.isEmpty(id_dep_main) ? "NULL_DEP_MAINSRV" : id_dep_main);
		//
		if (ins.isHitCahce(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()), Key_Dept_Cache)) {
			obj = ins.getCache(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()),
					Key_Dept_Cache);
		} else {
			obj = GetOrWfDeptInfo(ctx.getCode_entp(), sd_srvtp, id_srvca, id_srv, id_route, id_mm, ctx.getId_dep_or(),
					ctx.getId_dep_ns(), ctx.getId_dep_en(), id_dep_main);
			ins.putCache(CacheKeyUtils.L1SessionKeyWith(ctx.getCode_entp()), Key_Dept_Cache, obj);
		}
		return obj;
	}

}
