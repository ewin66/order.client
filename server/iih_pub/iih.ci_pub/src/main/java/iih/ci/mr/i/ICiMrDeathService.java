package iih.ci.mr.i;

import iih.ci.mr.d.CiMrDeathDTO;
import xap.mw.core.data.BizException;

public interface ICiMrDeathService {
		/**
		 * 获取集成平台需要的病人死亡信息
		 * 
		 * @param id_apt
		 * @return
		 * @throws BizException
		 */
		public abstract CiMrDeathDTO getCiMrDeathDTO(String id_pat) throws BizException;
		
	
}
