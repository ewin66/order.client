package iih.ci.ord.pub.function;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import iih.ci.ord.pub.CiOrdUtils;
import iih.ci.ord.pub.IAssoSrvQuanMeduCal;
import iih.ci.ord.s.bp.exception.ExternFunNullException;
import iih.ci.ord.s.bp.exception.ParamVCntAndParamCntNotEqualException;
import iih.ci.ord.s.bp.exception.ParamVStrNullException;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDouble;

/*
 * 根据外挂函数计算用量数据操作BP
 */
public class CalQuan8ExternFunBP {
	
	/**
	 * 根据外挂函数计算用量数据
	 * @param fullclassname_fun
	 * @param paramvStr
	 * @param cnt_param
	 * @param appScene
	 * @param replaceVs
	 * @return 
	 * @throws BizException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public FDouble exec(String fullclassname_fun,String paramvStr,Integer cnt_param,String appScene,String[] replaceVs)  throws BizException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		//外挂函数空校验
		if(CiOrdUtils.isEmpty(fullclassname_fun))throw new ExternFunNullException(appScene);
			
		//参数设置
		Class<?> c = null;
		IAssoSrvQuanMeduCal iasqmc=null;
		
		//创建外挂函数类
		c = Class.forName(fullclassname_fun.trim());
		if(CiOrdUtils.isEmpty(cnt_param) || cnt_param<=0){
			iasqmc = (IAssoSrvQuanMeduCal) c.newInstance();
		}else{
			Constructor<?> cs = c.getConstructor(getFuncParamClassArray(cnt_param));
			Object[] args= paramValidateCheck(paramvStr,cnt_param,appScene,replaceVs); 
			iasqmc = (IAssoSrvQuanMeduCal) cs.newInstance(args);		
		}
		
		//计算值并返回
		return iasqmc.calculate();
	}

	/**
	 * 参数值有效性校验
	 * @param paramvstr
	 * @param cnt_param
	 * @param appScene
	 * @return
	 * @throws BizException
	 */
	private String[] paramValidateCheck(String paramvstr,Integer cnt_param,String appScene,String[] replaceVs) throws BizException{
		if(CiOrdUtils.isEmpty(paramvstr))throw new ParamVStrNullException(appScene);
		String[] args= paramvstr.split(CiOrdUtils.COMMA_STR);
		if(cnt_param!=args.length)throw new ParamVCntAndParamCntNotEqualException(appScene);
		
		//宏替换处理并返回
		return replaceHandle(args,replaceVs);
	}
	
	/**
	 * 获得参数类型class数组
	 * @param paramcnt
	 * @return
	 */
	private Class<?>[] getFuncParamClassArray(Integer paramcnt){
		Class<?>[] rtn=new Class[paramcnt]; 
		for(int i=0;i<paramcnt;i++){
			rtn[i]=String.class;
		}
		return rtn;
	}

	/**
	 * 宏替换处理
	 * @param args
	 * @param replaceVs
	 */
	private String[] replaceHandle(String[] args,String[] replaceVs){
		//有效性校验
		if(CiOrdUtils.isEmpty(args) || CiOrdUtils.isEmpty(replaceVs))return args;
		
		//参数
		int iN=0;
		int iL=replaceVs.length;
		
		//遍历
		for(int i=0;i<args.length;i++){
			if(existMacro(args[i])){
				if(iN<iL){
				args[i]=replaceVs[iN];
				++iN;
				}else{
					break;
				}
			}
		}
		
		return args;
	}
	
	/**
	 * 宏替换存在性校验
	 * @param s
	 * @return
	 */
	private boolean existMacro(String s){
		if(CiOrdUtils.isEmpty(s))return false;
		if(CiOrdUtils.MACRO_STR.equals(s.trim()))return true;
		return false;
	}
	
}
