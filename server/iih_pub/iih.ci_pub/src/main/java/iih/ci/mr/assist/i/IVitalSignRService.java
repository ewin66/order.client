package iih.ci.mr.assist.i;

import iih.ci.mr.cimrpatsigns.d.VitalSignsDTO;
import iih.ci.mr.cimrvt.d.CimrvtAggDO;
import xap.mw.core.data.BizException;

public interface IVitalSignRService {
	public VitalSignsDTO[] GetVitalSignsDTOList(String id_ent,String BeginDate,String EndDate) throws BizException;
}
