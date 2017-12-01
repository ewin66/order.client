package iih.ci.ord.i;

import iih.ci.ord.srvref.d.CiSrvRefParamDTO;
import iih.ci.ord.srvref.d.CiSrvRefResultDTO;
import xap.mw.core.data.BizException;

/**
 * 医嘱服务接口
 * @author hums
 *
 */
public interface ICiSrvRefResultService {

    /**
     * 查询医嘱服务
     * @param dto 医嘱服务参照入口参数数据
     * @return 医嘱服务集合
     * @throws BizException 
     */
    public CiSrvRefResultDTO[] getSrvRefResult(CiSrvRefParamDTO dto) throws BizException;
}
