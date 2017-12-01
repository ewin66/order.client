package iih.ci.ord.s.bp;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.sys.xbd.paramset.i.ParamsetQryUtil;

public class getUnitParam {
	/**
	 * 
	 * @param param 'jbdw'基本单位    ‘lsdw’零售单位   code  'CIOR0005'
	 * @return
	 * @throws BizException
	 */
	
	public static String getUnitParam(String param,String code)throws BizException{
		String str = ParamsetQryUtil.getParaString(Context.get().getDeptId(), code);
		String[] paras=null;
		String par=null;
		if(param==null){
			return str;
		}else
		if(str!=null){
			paras=str.split(",");
			if(param.equals("jbdw"))
				par=paras[0];
			else if(param.equals("lsdw"))
				par=paras[1];
		}
		return par;
	}

}
