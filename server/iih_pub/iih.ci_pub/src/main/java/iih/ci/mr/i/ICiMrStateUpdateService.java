package iih.ci.mr.i;

import xap.sys.jdbc.facade.DAException;


public interface ICiMrStateUpdateService {
	
	/**
	 * 根据id_ent更新病历的提交（ci_mr表）、归档(ci_amr表)状态
	 * @param id_ent
	 */
	public abstract void updateSubmitAndPigeonholeStateByIdEnt(String id_ent) throws DAException;
	
	
}
