package iih.ci.mr.i;


import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import xap.mw.core.data.BizException;

public interface ICiVitalSignsService {
	
	/*
	 * 
	 * @param Id_ent
	 * @return BeginDate
	 * @throws EndDate
	 */
	public abstract VitalSignsDTO[] GetVitalSignsDTOList(String Id_ent,String BeginDate,String EndDate)
			throws BizException;
}
