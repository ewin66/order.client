package iih.ci.ord.s.ems.log;

import com.founder.xap.runtime.msys.Module;
import com.founder.xap.runtime.msys.ModuleSystem;
import com.founder.xap.runtime.msys.impl.ModuleSystemImpl;

import iih.ci.ord.ems.d.CiEnContextDTO;
import iih.ci.ord.pub.CiOrdAppUtils;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.log.logging.internal.Logger;

/**
 * 临床业务类操作日志输出
 * @author wangqingzhu
 *
 */
public class OrdBizLogger {
	
	private static Module module= null;
	
	static {
		module= ModuleSystemImpl.getExtensionPoints().getExtensionPoint(ModuleSystem.class).getModule("iih.ci");
	}
	
	private OrdBizLogger(){}
	
	/**
	 * 信息输出到日志
	 * @param ctx
	 * @param msg
	 */
	public static void info(CiEnContextDTO ctx,String msg) {
		
		GetLogger(ctx).error(msg);
	}
	
	/**
	 * 调试信息输入到日志
	 * @param ctx
	 * @param msg
	 */
	public static void debug(CiEnContextDTO ctx,String msg) {
		
		GetLogger(ctx).debug(msg);
	}
	
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 * @param t
	 */
	public static void error(CiEnContextDTO ctx,String msg, Throwable t) {
		
		GetLogger(ctx).error(msg);
	}
	
	/**
	 * 错误信息输出到日志
	 * @param ctx
	 * @param msg
	 */
	public static void error(CiEnContextDTO ctx,String msg) {
		GetLogger(ctx).error(msg);
		
	}
	/**
	 * 获取日志文件流
	 * @param ctx
	 * @return
	 */
	public static Logger  GetLogger(CiEnContextDTO ctx){
		String logfile = CiOrdUtils.isEmpty(ctx) ? "iih.ci.ord"
				: String.format("%s_%s_%s_%s_%s_%s",
						CiOrdAppUtils.getServerDateTime().getDate().toString(),
						CiOrdUtils.isIpWf(ctx.getCode_entp()) ? "住院" : "门急诊",
						CiOrdUtils.isEmpty(ctx.getOrg()) || CiOrdUtils.isEmpty(ctx.getOrg().getName()) 
						? "未知组织" : ctx.getOrg().getName(),
						CiOrdUtils.isEmpty(ctx.getDept()) || CiOrdUtils.isEmpty(ctx.getDept().getName()) 
						? "未知科室" : ctx.getDept().getName(),
						CiOrdUtils.isEmpty(ctx.getPsnInfo()) || CiOrdUtils.isEmpty(ctx.getPsnInfo().getName()) 
						? "未知医生" : ctx.getPsnInfo().getName(),
						CiOrdUtils.isEmpty(ctx.getEnt4BannerDTO()) || CiOrdUtils.isEmpty(ctx.getEnt4BannerDTO().getName_pat()) 
						? "未知患者" : ctx.getEnt4BannerDTO().getName_pat());
		return module.getContext().getLogger(logfile);
	}
}
