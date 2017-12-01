package iih.ci.ord.s.bp.defaultv;

import iih.ci.ord.ems.d.CiEmsDTO;
import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.CiOrdUtils;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

/**
 * 临床医嘱在院执行默认值设置操作BP
 */
public class CiOrFgMpInDefaultVSetBP {
	/**
	 * 临床医嘱在院执行默认值设置操作
	 * @param emsdto
	 * @throws BizException
	 */
	public void exec(CiEmsDTO emsdto)  throws BizException{
		//医疗单对象为空判断，为空时直接返回
		if(CiOrdUtils.isEmpty(emsdto))return;
		
		//在院执行对象为空判断，不为空时无需设置值直接返回
		if(!CiOrdUtils.isEmpty(emsdto.getFg_mp_in()))return;
		
		IFgMpInDefaultVGet plugin=getCiOrFgMpInDefaultVGetPlugin();
		FBoolean defaultv=plugin.exec(emsdto);
		
		//设置医疗单在院执行标识默认值
		if(!CiOrdUtils.isEmpty(defaultv)){emsdto.setFg_mp_in(defaultv);}
		

	}
	
	/**
	 * 
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	private IFgMpInDefaultVGet getCiOrFgMpInDefaultVGetPlugin(){
		//获得临床医嘱在院执行标识默认值设置插件
		String pluginStr=CiOrdUtils.getOrgParamStr(ICiOrdNSysParamConst.SYS_PARAM_CiOrFgMpInDefaultVPlugin);
		
		//空判断
		if(CiOrdUtils.isEmpty(pluginStr))return new CiOrFgMpInDefaultVGetBP();
		
		try{
			Class<?> c = Class.forName(pluginStr);
			return (IFgMpInDefaultVGet) c.newInstance();
		}catch(Exception e){
			return new CiOrFgMpInDefaultVGetBP();
		}

	}
	

}
