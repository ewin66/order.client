package iih.ci.diag.dto.i;

import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import xap.mw.core.data.BizException;

public interface IcidiagDtoService {
	
	/**
	 * getCiDiagDTO
	 * @param aggdos
	 * @throws BizException
	 */
	@Deprecated
    public abstract void getCiDiagDTO(DIDTO[] aggdos) throws BizException;
    
    /**
     * QueryCiDiagDTO
     * @param id
     * @return
     * @throws BizException
     */
	@Deprecated
    public abstract DIDTO[] QueryCiDiagDTO(String id,String type) throws BizException;
}
