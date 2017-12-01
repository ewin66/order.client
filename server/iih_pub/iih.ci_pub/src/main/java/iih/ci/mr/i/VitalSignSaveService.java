package iih.ci.mr.i;

import iih.ci.mr.cimrvt.d.VitalSignSave;
import xap.mw.core.data.BizException;

public interface VitalSignSaveService {
	/**
	 * 体征数据保存
	 * @param CiEmrDO 医疗记录
	 * @return AggDO[] 医疗记录智能表格段落
	 */
	public abstract VitalSignSave[] VatilSignSave(VitalSignSave[] ListSaveDTOS)
			throws BizException;
}
