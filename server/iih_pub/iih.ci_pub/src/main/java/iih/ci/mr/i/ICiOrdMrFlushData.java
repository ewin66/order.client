package iih.ci.mr.i;

import xap.mw.core.data.BizException;
import xap.mw.core.data.FMap2;

public interface ICiOrdMrFlushData {
	
		/**
		 * 处置手动刷新到病历 
		 * 
		 * @param id_ent
		 * @param code_entp
		 * @param orders
		 * @return
		 * @throws BizException
		 */
		public abstract FMap2 getOrderMrDtoFlushList(String id_ent, String code_entp) throws BizException;
		
		/**
		 * 诊断刷新到病历 
		 * @param id_ent
		 * @return
		 * @throws BizException
		 */
		public abstract String getDiagList(String id_ent) throws BizException;
}
