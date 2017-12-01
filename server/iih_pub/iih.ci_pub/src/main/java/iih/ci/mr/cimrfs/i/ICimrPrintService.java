package iih.ci.mr.cimrfs.i;

import iih.ci.mr.cimr.d.CiMrDO;
import iih.ci.mr.cimrfs.d.CiMrFsDO;
import xap.mw.core.data.BizException;

public interface ICimrPrintService {
	/**
	* 模板替换根据就诊号和自定义类型获取病历模板流服务
	*/
	public abstract CiMrFsDO[] getCimrStream(CiMrDO[] dos) throws BizException;

}
