package iih.ci.ord.s.bp;

import java.util.HashMap;


public class CacheManager {

	private static HashMap cacheMap = new HashMap(); 

	
	CacheManager() { 
		super(); 
	} 
	
	/**
	 * 获取缓存值
	 * @param key
	 * @return
	 */
	public static Object getCacheMapValue(Object key){
		if(key==null)return null;
		return cacheMap.get(key);
	}
	
	/**
	 * 新增缓存
	 * @param key
	 * @param value
	 */
	public static void setCacheMap(Object key,Object value){
		if(key==null || value==null)return;
		cacheMap.put(key, value);
	}
	
	/**
	 * 清空缓存
	 */
	public static void clearAll(){
		cacheMap.clear();
	}
	
	/**
	 * 删除缓存值
	 * @param key
	 */
	public static void removeCatch(Object key){
		if(key==null)return;
		cacheMap.remove(key);
	}
	
	
	public static Boolean containsKey(Object key){
		if(key==null)return false;
		return cacheMap.containsKey(key);
	}
	
	public static Boolean isNull(){
		if(cacheMap==null || cacheMap.size()==0){
			return true;
		}
		return false;
	}
}