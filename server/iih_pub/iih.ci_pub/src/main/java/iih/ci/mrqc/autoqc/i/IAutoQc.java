package iih.ci.mrqc.autoqc.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.itm.d.ItmDO;

/**
* 组件操作接口方法服务
*/
public interface IAutoQc {

    /**
	*  getAutoQcDefects
	*/
    public abstract  void getAutoQcDefects( String id_ent ,String id_qc_type) throws BizException;
    /**
	*  自动质控配置获取扣分项
	*/
    public abstract  void getAutoQcDivideDos( String id_ent,String id_qc_type) throws BizException;

	
}
