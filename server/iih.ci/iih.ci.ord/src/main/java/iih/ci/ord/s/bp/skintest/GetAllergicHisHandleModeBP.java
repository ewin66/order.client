package iih.ci.ord.s.bp.skintest;

import iih.ci.ord.i.ICiOrdNSysParamConst;
import iih.ci.ord.pub.d.AllergicHandleModeEnum;
import xap.mw.core.data.BizException;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

/**
 * 获得过敏史的处理模式操作BP
 */
public class GetAllergicHisHandleModeBP {
	/**
	 * 获得过敏史的处理模式
	 * 返回值为：AllergicHandleModeEnum
	 * @param id_org
	 * @return 
	 * @throws BizException
	 */
	public Integer exec(String id_org)  throws BizException{ 
		//获得参数值
		Integer rtn=ParamsetQryUtil.getParaInt(id_org, ICiOrdNSysParamConst.SYS_PARAM_PharmAllergyHandleMode);
		
		//结果处理并返回
		if(rtn==null)return AllergicHandleModeEnum.FORBIDDEN;
		if(!(rtn==0 || rtn==1 || rtn==2))return AllergicHandleModeEnum.FORBIDDEN;
		
		//返回结果
		return rtn;
	}
}
