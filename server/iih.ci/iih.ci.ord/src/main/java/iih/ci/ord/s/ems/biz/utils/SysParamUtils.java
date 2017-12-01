package iih.ci.ord.s.ems.biz.utils;

import iih.ci.ord.s.ems.biz.meta.OrderSysParamUtils;

public class SysParamUtils {
	
	private static OrderSysParamUtils sysParam;
	private SysParamUtils(){}
	public static OrderSysParamUtils getSysParam(){
		if(sysParam==null){
			sysParam=new OrderSysParamUtils();
		}
		return sysParam;
	}

}
