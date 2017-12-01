package iih.ci.ord.ciordems.i;

 
import iih.ci.ord.ciordems.d.EmsHeadDO;
import iih.ci.ord.ciordems.d.EmsType;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;

public interface ICiordermsRService {
	/**
	*  根据id值查找临床医嘱数据
	*/	
	public abstract EmsHeadDO findById(String id,Integer type) throws BizException;
	
	/**
	*  根据id值集合查找临床医嘱数据集合
	*/	
	
	 /**
		*  根据condition条件查找临床医嘱数据集合
		*/	
		public abstract EmsHeadDO[] find(String whereStr,String orderStr,Integer type) throws BizException;
		
		/**
		*  根据查询方案查找临床医嘱数据集合
		*/	

}
