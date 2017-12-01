package iih.ci.mrqc.i;

import xap.mw.core.data.BizException;
import xap.mw.coreitf.d.FBoolean;
import iih.ci.mrqc.qaflt.d.QaFltDTO;
import iih.ci.mrqc.qared.d.QaRecordDO;
import iih.ci.mrqc.revisionnotice.d.RevisionNoticeDO;

public interface IMrqcMaintainService {
	/**
	 * 保存整改通知
	 * @param revnotice
	 * @throws BizException
	 */
	public FBoolean SaveRevNotice(RevisionNoticeDO revnotice,QaFltDTO[] qaflt,QaRecordDO qarecord,String id_amr) throws BizException;

	/**
	 * 更新缺陷状态
	 * @param revnotice
	 * @throws BizException
	 */
	public FBoolean updateStatus(QaFltDTO[] qaflt) throws BizException;
}
