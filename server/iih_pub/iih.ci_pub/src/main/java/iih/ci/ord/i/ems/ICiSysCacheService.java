package iih.ci.ord.i.ems;

import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ICiSysCacheService {
	/**
	 * 二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean prepareL2Cache(CiEnContextDTO ctx) throws BizException;
	
	/**
	 * 三级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean prepareL3Cache(CiEnContextDTO ctx) throws BizException;
	
	/**
	 * 清除一级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean clearL1Cache(CiEnContextDTO ctx) throws BizException;
	/**
	 * 清除二级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean clearL2Cache(CiEnContextDTO ctx) throws BizException;
	/**
	 * 清除三级缓存
	 * @param ctx
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean clearL3Cache(CiEnContextDTO ctx) throws BizException;
	
	/**
	 * 清除指定缓存下的，给定关键字缓存
	 * @param cacheType
	 * @param keyword
	 * @return
	 * @throws BizException
	 */
	public abstract FBoolean clearCache(String cacheType, String keyword) throws BizException;
}
