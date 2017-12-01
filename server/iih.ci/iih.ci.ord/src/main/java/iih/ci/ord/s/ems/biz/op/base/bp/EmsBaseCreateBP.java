package iih.ci.ord.s.ems.biz.op.base.bp;

import iih.bd.base.cache.CacheContext;
import iih.ci.ord.d.ems.ems.EmsCrtDTO;
import iih.ci.ord.d.ems.ems.EmsRstDTO;
import iih.ci.ord.s.ems.biz.itf.bp.IEmsCreateBP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.FArrayList;

/**
 * 医疗单创建业务逻辑处理 -- 基类
 * @author wangqingzhu
 *
 */
public class EmsBaseCreateBP extends CacheContext implements IEmsCreateBP {

	@Override
	public EmsRstDTO[] create(EmsCrtDTO[] ems) throws BizException {
		// TODO Auto-generated method stub
		return null;
	}

	protected FArrayList handleReturnDocument(Object objInfo) throws BizException{
		FArrayList objList = new FArrayList();
		objList.add(objInfo);
		
		return objList;
	}
}
