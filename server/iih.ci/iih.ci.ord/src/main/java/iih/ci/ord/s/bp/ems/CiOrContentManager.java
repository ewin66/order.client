package iih.ci.ord.s.bp.ems;

import iih.ci.ord.content.d.CiOrContentDO;
import iih.ci.ord.content.d.CiOrContentObjFactory;
import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱内容生成管理器
 */
public class CiOrContentManager {
	/**
	 * 获得医嘱内容串
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	public static String getCiOrContentStr(CiEmsDTO ems) throws BizException{
		CiOrContentDO dos=getCiOrContentObj(ems);
		if(dos==null)return null;
		return  dos.toString();
	}
	
	/**
	 * 获得医嘱内容对象
	 * @param ems
	 * @return
	 * @throws BizException 
	 */
	public static CiOrContentDO getCiOrContentObj(CiEmsDTO ems) throws BizException{
		CiOrContentObjFactory instance=CiOrContentFactoryManager.getCiOrContentObjFactory(ems);
		return  instance.create(ems);
	}
}
