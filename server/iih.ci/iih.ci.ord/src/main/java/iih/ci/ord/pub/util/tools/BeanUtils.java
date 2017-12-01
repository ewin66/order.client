package iih.ci.ord.pub.util.tools;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import xap.mw.core.data.BizException;

/**
 * bean对象处理
 * 
 * @author HUMS
 *
 */
public class BeanUtils {

	/**
	 * 执行对象的方法
	 * 
	 * @param <T>
	 * @param <T>
	 * @param <T>
	 * @param obj
	 * @param methodName
	 * @param args
	 * @return
	 * @return
	 * @throws BizException
	 */
	public static Object invokeMethod(Object obj, String methodName, Object... args) throws BizException {

		Object result = null;
		Class<? extends Object> clazz = obj.getClass();// 得到对象
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(methodName);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new BizException(clazz.getName() + "获取方法[" + methodName + "]失败");
		}

		if (method != null) {
			try {
				result = method.invoke(obj, args);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new BizException(clazz.getName() + "执行方法[" + methodName + "]获取返回值失败！");
			}
		}

		return result;
	}
}
