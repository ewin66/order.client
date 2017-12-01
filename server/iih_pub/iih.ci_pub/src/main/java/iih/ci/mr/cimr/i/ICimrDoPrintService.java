package iih.ci.mr.cimr.i;

import iih.ci.mr.cimr.d.CiMrDO;
import xap.mw.core.data.BizException;

public interface ICimrDoPrintService {
	/**
	* 模板替换根据就诊号和自定义类型获取病历模板服务
	*/
	public abstract CiMrDO[] getCimrDo(String id_ent ,String Id_mrcactm) throws BizException;


}
