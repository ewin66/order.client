package iih.ci.ord.i.external;

import iih.bd.srv.diagdef.d.DiagDefDO;
import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FDateTime;

/**
 * 临床对费用提供的对外接口
 * 
 * @author HUMS
 *
 */
public interface ICiOrdBlService {

	/**
	 * 查询诊断集合
	 * @param dtStart 开始时间
	 * @param dtEnd 结束时间
	 * @param nameDi 诊断名称
	 * @param codeDi 诊断编码
	 * @param idcdsystp 诊断体系ID
	 * @param iddica 诊断分类ID
	 * @param idorg 集团ID
	 * @param idgrp 组织ID
	 * @return
	 * @throws BizException
	 */
	public abstract DiagDefDO[] GetDiagDefDOs(FDateTime dtStart, FDateTime dtEnd, String nameDi, String codeDi,
			String idcdsystp, String iddica, String idorg, String idgrp) throws BizException;
}
