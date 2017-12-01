package iih.ci.diag.i;

import iih.ci.diag.cidiag.d.CiDiagDO;
import iih.ci.diag.cidiag.d.CidiagAggDO;
import iih.ci.diag.dto.d.DIDTO;
import iih.ci.ord.ems.d.CiEnContextDTO;
import xap.mw.core.data.BizException;

public  interface ICidiagMaintainService {
	

    /**
     * 医嘱诊断 保存
     * id 诊断过程id
     * sd 诊断过程编码
     * @param diDTO
     * @return
     * @throws BizException
     */
   // public abstract DIDTO[] SaveCiDiDto(DIDTO[] diDTO,String id,String sd,String tp )throws BizException;
    
    public abstract DIDTO[] SaveCiDiDto(DIDTO[] diDTO,String des,CiEnContextDTO cienContextDTO)throws BizException;
    
    
    /**
     * 诊断的保存  （包含事件）
     * @param CidiAggDO
     * @return
     * @throws BizException
     */
    public abstract CidiagAggDO SaveCiDi(CidiagAggDO CidiAggDO)throws BizException;
    /**
     * 删除诊断
     * @param ciDiagDo
     * @return
     * @throws BizException
     */
    public  CidiagAggDO DeleteCiDiag(CiDiagDO ciDiagDo)throws BizException;
}
