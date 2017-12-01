package iih.ci.mrqc.qascoredto.i;

import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qascoredto.d.QaScoreDTO;
import xap.mw.core.data.BizException;

public interface IQaScoreDtoQryService {
	/**
	*  获取质控评分扣分项目DTO
	*/
    public abstract  QaScoreDTO[] getQaScoreDtos( String id_ent,String id_qc_type) throws BizException;
	/**
	*  根据缺陷获取质控评分扣分项目DTO
	*/
    public abstract  QaFltDTO[] getQaFltForScoreDtos( String id_ent,String id_qc_type) throws BizException;
}
