package iih.ci.mr.nu.newbornveinnur.i;

import xap.mw.core.data.BizException;
import iih.ci.mr.nu.newbornveinnur.d.NewBornVeinNurDO;
import xap.sys.appfw.orm.handle.dataobject.errlog.DOWithErrLog;
/**
* 新生儿科脐静脉护理记录单（一）数据维护服务
*/
public interface INewbornveinnurMDOCudService {
	/**
	*  新生儿科脐静脉护理记录单（一）数据真删除
	*/
    public abstract void delete(NewBornVeinNurDO[] aggdos) throws BizException;
    
    /**
	*  新生儿科脐静脉护理记录单（一）数据插入保存
	*/
	public abstract NewBornVeinNurDO[] insert(NewBornVeinNurDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科脐静脉护理记录单（一）数据保存
	*/
	public abstract NewBornVeinNurDO[] save(NewBornVeinNurDO[] aggdos) throws BizException;
	
    /**
	*  新生儿科脐静脉护理记录单（一）数据更新
	*/
	public abstract NewBornVeinNurDO[] update(NewBornVeinNurDO[] aggdos) throws BizException;
	
	/**
	*  新生儿科脐静脉护理记录单（一）数据逻辑删除
	*/
	public abstract void logicDelete(NewBornVeinNurDO[] aggdos) throws BizException;
	
	/**
	 * 批量启用：全部都启用；或者出现异常，启用全部失败
	 */
	public NewBornVeinNurDO[] enableWithoutFilter(NewBornVeinNurDO[] aggdos) throws BizException ;

	/**
	 * 批量启用：可部分启用成功；
	 * 启用成功的记录可通过返回值的getDos方法得到，启用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog enableDO(NewBornVeinNurDO[] aggdos) throws BizException ;

	/**
	 * 批量停用：要不全部都停用；或者出现异常，停用全部失败
	 */
	public NewBornVeinNurDO[] disableVOWithoutFilter(NewBornVeinNurDO[] aggdos) throws BizException;


	/**
	 * 批量停用：可部分停用成功；
	 * 停用成功的记录可通过返回值的getDos方法得到，停用不成功的记录附加日志可通过返回值的getErrLogList方法得到
	 */
	public DOWithErrLog disableDO(NewBornVeinNurDO[] aggdos) throws BizException ;
	
}
