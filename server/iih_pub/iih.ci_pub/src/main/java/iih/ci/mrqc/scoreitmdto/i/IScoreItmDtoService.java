package iih.ci.mrqc.scoreitmdto.i;

import iih.ci.mrqc.scoreitmdto.d.ScoreItmDto;
import xap.mw.core.data.BizException;


public interface IScoreItmDtoService {
	/**
	*  获取质控评分扣分项目DTO
	*/
    public abstract  ScoreItmDto[] getScoreItmDtos( String id_ent,String id_qc_type) throws BizException;
}
