package iih.ci.ord.diag;

import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import xap.mw.core.data.BizException;
/**
 * 给电子病历接口，临床就诊诊断信息查询
 * @author wangqingzhu
 *
 */
public interface ICiEnDiagInfoService {

	public abstract DiaInfoDTO[] getCiEnDiagInfos( String id_ent) throws BizException;
}
