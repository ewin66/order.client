package iih.ci.ord.content.d;

import iih.ci.ord.ems.d.CiEmsDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱内容生成工厂
 */
public interface CiOrContentObjFactory {
	public CiOrContentDO create(CiEmsDTO ems) throws BizException;
}
